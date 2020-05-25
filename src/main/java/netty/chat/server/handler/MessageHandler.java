package netty.chat.server.handler;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.chat.server.processor.MessageProcessor;
import netty.chat.server.protocol.Message;

/**
 * @author admin
 * @date 2020-05-25 10:43
 */
public class MessageHandler extends SimpleChannelInboundHandler<Message> {


    private MessageProcessor processor = new MessageProcessor();

    //发送消息
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message message) throws Exception {
        System.out.println(message.toString());
        processor.sendMessage(channelHandlerContext,message );
    }


    //退出
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        processor.loginOut(ctx);
    }


    //在线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
