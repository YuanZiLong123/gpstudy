package com.yzl.netty.myrpc.consumer.proxy;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import com.yzl.netty.myrpc.protocol.Protocol;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author admin
 * @date 2020-06-01 15:04
 */
public class MyRpcProxy {


    public static <T> T getProxy(Class<?> clazz) {
        MethodProxy methodProxy = new MethodProxy(clazz);
        Class<?> [] interfaces = clazz.isInterface() ?
                new Class[]{clazz} :
                clazz.getInterfaces();

        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),interfaces ,methodProxy );

    }


    private static class MethodProxy implements InvocationHandler {

        private Class<?> clazz;

        public MethodProxy(Class<?> clazz) {
            this.clazz = clazz;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = new Object();
            if ( clazz.isInterface()){
                result = rpcResult(method,args);
            }else {
                result =  method.invoke(this,args);
            }

            return result;
        }

        private Object rpcResult( Method method, Object[] args) {
            Protocol portocol = new Protocol();

            portocol.setClassName(this.clazz.getName());
            portocol.setMethod(method.getName());
            portocol.setArgs(method.getParameterTypes());
            portocol.setValues(args);


            Bootstrap bootstrap = new Bootstrap();
            EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
            RpcClientHandler rpcClientHandler = new RpcClientHandler();
            try {

                bootstrap
                        .group(eventLoopGroup)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.SO_KEEPALIVE,true )
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                ChannelPipeline pipeline = socketChannel.pipeline();

                                //自定义协议解码器
                                /** 入参有5个，分别解释如下
                                 maxFrameLength：框架的最大长度。如果帧的长度大于此值，则将抛出TooLongFrameException。
                                 lengthFieldOffset：长度字段的偏移量：即对应的长度字段在整个消息数据中得位置
                                 lengthFieldLength：长度字段的长度。如：长度字段是int型表示，那么这个值就是4（long型就是8）
                                 lengthAdjustment：要添加到长度字段值的补偿值
                                 initialBytesToStrip：从解码帧中去除的第一个字节数
                                 */
                                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                                //自定义协议编码器
                                pipeline.addLast(new LengthFieldPrepender(4));
                                //对象参数类型编码器
                                pipeline.addLast("encoder",new ObjectEncoder());
                                //对象参数类型解码器
                                pipeline.addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                                pipeline.addLast(rpcClientHandler);
                            }
                        });

                ChannelFuture channelFuture = bootstrap.connect("localhost", 8080).sync();
                channelFuture.channel().writeAndFlush(portocol).sync();
                channelFuture.channel().closeFuture().sync();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                eventLoopGroup.shutdownGracefully();
            }

            return rpcClientHandler.getResult();
        }
    }
}