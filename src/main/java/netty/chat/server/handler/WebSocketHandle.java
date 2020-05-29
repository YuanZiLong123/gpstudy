package netty.chat.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import netty.chat.server.processor.MessageProcessor;
import netty.chat.server.protocol.Message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author admin
 * @date 2020-05-29 15:33
 */
public class WebSocketHandle extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //解析IM写一下请求内容的正则
    private Pattern pattern = Pattern.compile("^\\[(.*)\\](\\s\\-\\s(.*))?");

    private MessageProcessor processor = new MessageProcessor();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,TextWebSocketFrame msg) throws Exception {
        processor.sendMessage(ctx,decode(msg.text()));
    }

    /**
     * 字符串解析成自定义即时通信协议
     * @param msg
     * @return
     */
    public Message decode(String msg){
        if(null == msg || "".equals(msg.trim())){ return null; }
        try{
            Matcher m = pattern.matcher(msg);
            String header = "";
            String content = "";
            if(m.matches()){
                header = m.group(1);
                content = m.group(3);
            }

            String [] heards = header.split("\\]\\[");
            long time = 0;
            try{ time = Long.parseLong(heards[1]); } catch(Exception e){}
            String nickName = heards[2];
            //昵称最多十个字
            nickName = nickName.length() < 10 ? nickName : nickName.substring(0, 9);

            if(msg.startsWith("[login]")){
                return new Message(heards[0],time,nickName);
            }else if(msg.startsWith("[chat]")){
                return new Message(heards[0],time,nickName,content);
            }else if(msg.startsWith("[loginOut]")){
                return new Message(heards[0],time,nickName);
            }else if(msg.startsWith("[privateChat]")){
                return new Message(heards[0],heards[3],time,nickName,content);
            }
            else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception { // (2)
        Channel client = ctx.channel();
        System.out.println("WebSocket Client:" + getAddress(client) + "加入");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception { // (3)
        processor.loginOut(ctx);
        System.out.println("WebSocket Client:" + getAddress(ctx.channel()) + "离开");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
        Channel client = ctx.channel();
        String addr = getAddress(client);
        System.out.println("WebSocket Client:" + addr + "上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
        Channel client = ctx.channel();
        String addr = getAddress(client);
        System.out.println("WebSocket Client:" + addr + "掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println("WebSocket Client:" + getAddress(ctx.channel()) + "异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    private String getAddress(Channel client){
        return client.remoteAddress().toString().replaceFirst("/","");
    }
}
