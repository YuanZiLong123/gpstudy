package com.yzl.netty.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import com.yzl.netty.chat.client.handler.ChatClientHandler;
import com.yzl.netty.chat.server.handler.MessageHandler;
import com.yzl.netty.chat.server.protocol.MyDecoder;
import com.yzl.netty.chat.server.protocol.MyEncoder;

/**
 * @author admin
 * @date 2020-05-28 17:16
 */
public class ChatClient3 {

    private String nickName;

    private String ip;

    private int port;

    public ChatClient3(String nickName,String ip, int port) {
        this.nickName = nickName;
        this.ip = ip;
        this.port = port;
    }

    public void connect(){
        EventLoopGroup worker = new EpollEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE,true )
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                               ChannelPipeline channelPipeline = socketChannel.pipeline();
                               channelPipeline.addLast(new MyDecoder());
                               channelPipeline.addLast(new MyEncoder());
                               channelPipeline.addLast(new ChatClientHandler(nickName));
                        }
                    });

           ChannelFuture future = bootstrap.connect(ip,port ).sync();
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            worker.shutdownGracefully();
        }
    }


    public static void main(String[] args) {
            new ChatClient3("","127.0.0.1" ,8080 ).connect();
    }

}
