package com.yzl.rpc.tocmat;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;



public class TomcatService {

        private int port =80;


    public TomcatService(int port) {
        this.port = port;
    }


    public static void main(String[] args) {
        new TomcatService(8080).listen();
    }

    private void listen() {

        //EpollEventLoopGroup 对应 liunx   NioEventLoopGroup 对应window
        EventLoopGroup bossGroup= new NioEventLoopGroup();
        EventLoopGroup workGroup= new NioEventLoopGroup();
        try {
        ServerBootstrap serverBootstrap = new ServerBootstrap()
                //设置主从线程
                .group( bossGroup, workGroup)
                //设置通道
                .channel(NioServerSocketChannel.class)
                //设置拦截器
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new HttpRequestDecoder())
                                    .addLast(new HttpResponseEncoder())
                                    .addLast(new ServlerHandler() );
                    }
                })
                //给主线程设置，设置最大列表的值
                .option(ChannelOption.SO_BACKLOG,128 )
                //给从线程设置
                .childOption(ChannelOption.SO_KEEPALIVE,true );


        //绑定服务端口
        ChannelFuture f = serverBootstrap.bind(port).sync();


        //开始接收客户

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}


/*
import netty.io.bio.tomcat.GPTomcat;
import org.apache.log4j.Logger;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

public class TomcatService {

    private static Logger LOG = Logger.getLogger(GPTomcat.class);

    public void start(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            //服务端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
                            ch.pipeline().addLast(new HttpResponseEncoder());
                            //服务端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
                            ch.pipeline().addLast(new HttpRequestDecoder());
                            //最后处理自己的逻辑
                            ch.pipeline().addLast(new ServlerHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            //绑定服务端口
            ChannelFuture f = b.bind(port).sync();

            LOG.info("HTTP服务已启动，监听端口:" + port);

            //开始接收客户
            f.channel().closeFuture().sync();

        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String [] args){
        try {
            new TomcatService().start(8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
