package com.yzl.netty.mvc.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaders.Names.*;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/21
 */
public class HttpHandler extends SimpleChannelInboundHandler<HttpRequest> {

    private static HashMap<String,String> servletMap = new HashMap<>();

    static {
        servletMap.put("/getName", "netty.chat.servlet.MyController#getName");
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpRequest request) throws Exception {

        String uri = request.uri();

        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(uri);

        Map<String, List<String>> parameters = queryStringDecoder.parameters();
        Integer id = Integer.valueOf(parameters.get("id").get(0));

        String name = queryStringDecoder.uri().split("\\?")[0];
        String classAndMethod = servletMap.get(name);

        String className = classAndMethod.split("#")[0];
        String methodName = classAndMethod.split("#")[1];
        Class<?> cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName, Integer.class);
        String result = (String) method.invoke(obj, id);

        FullHttpResponse response = new DefaultFullHttpResponse(
                HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(("name:"+result).getBytes("UTF-8")));
        response.headers().set(CONTENT_TYPE, "text/json");
        response.headers().set(CONTENT_LENGTH,response.content().readableBytes());
        response.headers().set(EXPIRES, 0);
        if (HttpHeaders.isKeepAlive(request)) {
            response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }
        channelHandlerContext.write(response);
        channelHandlerContext.flush();
    }
}
