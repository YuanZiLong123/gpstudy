package com.yzl.springcloud.tocmat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/20
 */
public class ServlerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof HttpRequest){
            HttpRequest request = (HttpRequest)msg;

            MyHttpRequest myHttpRequest = new MyHttpRequest(ctx,request );
            MyHttpResponse myHttpResponse = new MyHttpResponse(ctx,request );
            FirstServlet firstServlet = new FirstServlet();
            firstServlet.doGet(myHttpRequest,myHttpResponse );
        }

    }
}
