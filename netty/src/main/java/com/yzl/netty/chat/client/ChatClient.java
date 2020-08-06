package com.yzl.netty.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import com.yzl.netty.chat.client.handler.ClientHandler;
import com.yzl.netty.chat.server.protocol.MyDecoder;
import com.yzl.netty.chat.server.protocol.MyEncoder;

import java.util.Scanner;

/**
 * @author admin
 * @date 2020-05-25 11:16
 */
public class ChatClient  {

    private  String nickName;

    private String ip;

    private int port;

    private ClientHandler clientHandler;

    public ChatClient(String nickName, String ip, int port) {
        this.nickName = nickName;
        this.ip = ip;
        this.port = port;
        this.clientHandler = new ClientHandler(nickName);
    }

    public void start(){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();

            b.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE,true )
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                           ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new MyDecoder());
                            pipeline.addLast(new MyEncoder());
                            pipeline.addLast(clientHandler);
                        }
                    });
            ChannelFuture f = b.connect(this.ip, this.port).sync();
            f.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入昵称：");
        String input = scanner.nextLine();
            new ChatClient(input,"127.0.0.1" , 8080).start();
    }
}
