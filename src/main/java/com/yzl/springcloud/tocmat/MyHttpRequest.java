package com.yzl.springcloud.tocmat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/20
 */
public class MyHttpRequest {

    private ChannelHandlerContext ctx;


    private HttpRequest r;

    public MyHttpRequest(ChannelHandlerContext ctx, HttpRequest r) {
        this.ctx = ctx;
        this.r = r;
    }


    public MyHttpRequest() {
    }

    public  String getUri(){
        return r.uri();
    }
    public  String getMethodName(){
        return r.method().name().toString();
    }


    public Map<String, List<String>> getParameters(){
        QueryStringDecoder decoderQuery = new QueryStringDecoder(r.uri());
        return decoderQuery.parameters();
    }


    public String getParameter(String name) {
        Map<String, List<String>> params = getParameters();
        List<String> param = params.get(name);
        if(null != param){
            return param.get(0);
        }else{
            return null;
        }
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public HttpRequest getR() {
        return r;
    }

    public void setR(HttpRequest r) {
        this.r = r;
    }
}
