package netty.chat.server.processor;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;
import netty.chat.server.protocol.Message;

/**
 * @author admin
 * @date 2020-05-25 10:48
 */
public class MessageProcessor {

    //记录在线用户
    private static ChannelGroup onlineUsers = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private AttributeKey<String> NICK_NAME = AttributeKey.valueOf("nickName");

    /**
     * 获取用户昵称
     * @param client
     * @return
     */
    public String getNickName(Channel client){
        return client.attr(NICK_NAME).get();
    }


    public void sendMessage(ChannelHandlerContext channelHandlerContext, Message message){
        Channel channel = channelHandlerContext.channel();

        String type = message.getType();

        switch (type){
            case "login":
                    login(channelHandlerContext, message.getNickName());
                break;
            case "loginOut":
                    loginOut(channelHandlerContext);
                break;
            case "chat":
                    chat(channelHandlerContext,message );
                break;
        }
    }

    public void chat(ChannelHandlerContext channelHandlerContext, Message message){

        Channel channel = channelHandlerContext.channel();
        for (Channel client : onlineUsers) {
            Message request = new Message("chat",getNickName(channel), onlineUsers.size(),message.getContent(),System.currentTimeMillis());
            client.writeAndFlush(request);
        }
    }

    public void login(ChannelHandlerContext channelHandlerContext, String nickName){

        Channel channel = channelHandlerContext.channel();
        channel.attr(NICK_NAME).getAndSet(nickName);
        onlineUsers.add(channel);
        for (Channel client : onlineUsers) {
            Message request = new Message("system",getNickName(channel), onlineUsers.size(), getNickName(channel) + "加入聊天室",System.currentTimeMillis());
            client.writeAndFlush(request);
        }

    }

    public void loginOut(ChannelHandlerContext channelHandlerContext){

        Channel client = channelHandlerContext.channel();

        //如果nickName为null，没有遵从聊天协议的连接，表示未非法登录
        if(getNickName(client) == null){ return; }
        for (Channel channel : onlineUsers) {
            Message request = new Message("system",getNickName(client), onlineUsers.size(), getNickName(client) + "离开",System.currentTimeMillis());
            channel.writeAndFlush(request);
        }
        onlineUsers.remove(client);

    }

}
