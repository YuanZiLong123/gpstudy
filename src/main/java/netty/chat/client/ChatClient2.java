package netty.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import netty.chat.client.handler.ChatClientHandler;
import netty.chat.server.protocol.MyDecoder;
import netty.chat.server.protocol.MyEncoder;

import java.io.IOException;

/**
 * 客户端
 * @author Tom
 *
 */
public class ChatClient2 {

    private ChatClientHandler clientHandler;
    private String host;
    private int port;

    public ChatClient2(String nickName){
    		this.clientHandler = new ChatClientHandler(nickName);
    }
    
    public void connect(String host,int port){
    		this.host = host;
    		this.port = port;

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new MyDecoder());
                    ch.pipeline().addLast(new MyEncoder());
                    ch.pipeline().addLast(clientHandler);
                }
            });
            ChannelFuture f = b.connect(this.host, this.port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
    
    
    public static void main(String[] args) throws IOException{
		new ChatClient2("Sam").connect("127.0.0.1",8080);
    }
    
}
