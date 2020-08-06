package com.yzl.netty.chat.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import com.yzl.netty.chat.server.handler.MessageHandler;
import com.yzl.netty.chat.server.protocol.MyDecoder;
import com.yzl.netty.chat.server.protocol.MyEncoder;

import java.net.ServerSocket;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/25
 */
public class ChatServer {

    private int port = 80;


    public ChatServer(int port) {
        this.port = port;
    }


    public void start()  {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss,worker )
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024 )
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();

                          pipeline.addLast(new MyDecoder());
                            pipeline.addLast(new MyEncoder());
                            pipeline.addLast(new MessageHandler());
                        }
                    });

            //绑定端口 启动
            ChannelFuture future = serverBootstrap.bind(port).sync();

            //等待客户端连接
            future.channel().closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }


    }

    public static void main(String[] args) {
        new ChatServer(8080).start();
    }

}
