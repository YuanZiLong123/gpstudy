package netty.chat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import netty.chat.server.handler.MessageHandler;
import netty.chat.server.handler.WebSocketHandle;
import netty.chat.server.protocol.MyDecoder;
import netty.chat.server.protocol.MyEncoder;

/**
 * @author admin
 * @date 2020-05-28 17:08
 */
public class ChatService2 {


    private int port;

    public ChatService2(int port) {
        this.port = port;
    }


    public void start(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024 )
                    .childOption(ChannelOption.SO_KEEPALIVE,true )
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline channelPipeline = socketChannel.pipeline();

                            channelPipeline.addLast(new WebSocketHandle());

                            channelPipeline.addLast(new MyDecoder());
                            channelPipeline.addLast(new MyEncoder());
                            channelPipeline.addLast(new MessageHandler());
                        }
                    });
            ChannelFuture future = bootstrap.bind(port).sync();
            future.channel().closeFuture();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }

    public static void main(String[] args) {
            new ChatService2(8080).start();
    }
}
