package com.yzl.netty.chat.server.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*@Description: 自定义解密
*@Param: 
*@return: 
*@Author: yzl
*@date: 2020/5/25
*/
public class MyDecoder extends ByteToMessageDecoder {


    //解析IM写一下请求内容的正则
    private Pattern pattern = Pattern.compile("^*-*-*-*?");

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int length =  byteBuf.readableBytes();
            byte[] bytes = new byte[length];
            String content = new String(bytes,byteBuf.readerIndex(),length);

            //空消息不解析
            if(!(null == content || "".equals(content.trim()))){
                if(!isIMP(content)){
                    ctx.channel().pipeline().remove(this);
                    return;
                }
            }

            byteBuf.getBytes(byteBuf.readerIndex(), bytes, 0, length);
            list.add(new MessagePack().read(bytes,Message.class));
            byteBuf.clear();
        }catch (Exception e){
            ctx.channel().pipeline().remove(this);
        }

    }

    public static boolean isIMP(String content){
        return content.matches("^\\[(system|login|loginOut|chat)\\]");
    }

    public boolean checkIsMessage(String content){

        Matcher m = pattern.matcher(content);

        return m.matches();
    }
}
