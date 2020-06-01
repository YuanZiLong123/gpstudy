package netty.chat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import netty.chat.server.handler.HttpHandler;
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
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline channelPipeline = socketChannel.pipeline();

                            channelPipeline.addLast(new HttpServerCodec());
                            //主要是将同一个http请求或响应的多个消息对象变成一个 fullHttpRequest完整的消息对象
                            channelPipeline.addLast(new HttpObjectAggregator(64 * 1024));
                            //主要用于处理大数据流,比如一个1G大小的文件如果你直接传输肯定会撑暴jvm内存的 ,加上这个handler我们就不用考虑这个问题了
                            channelPipeline.addLast(new ChunkedWriteHandler());
                            channelPipeline.addLast(new HttpHandler());

                            channelPipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                            channelPipeline.addLast(new WebSocketHandle());

                            //channelPipeline.addLast(new MyDecoder());
                            //channelPipeline.addLast(new MyEncoder());
                            //channelPipeline.addLast(new MessageHandler());
                        }
                    });


            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("服务器启动");
            future.channel().closeFuture().sync();


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
