package netty.mvc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import netty.mvc.handler.HttpHandler;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/21
 */
public class ChatService {

    private int port;


    public ChatService(int port) {
        this.port = port;
    }


    private void start() {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup,workerGroup)
                .channel( NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024 )
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new HttpServerCodec());
                        pipeline.addLast(new HttpHandler());
                    }
                });

        ChannelFuture f =  bootstrap.bind(port).sync();
        f.channel().closeFuture().sync();
        }catch (Exception e){

        }finally{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ChatService(8080).start();
    }




}
