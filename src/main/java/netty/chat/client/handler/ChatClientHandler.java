package netty.chat.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import netty.chat.server.protocol.Message;
import org.apache.log4j.Logger;


/**
 * 聊天客户端逻辑实现
 * @author Tom
 *
 */
public class ChatClientHandler extends ChannelInboundHandlerAdapter{
	
	private static Logger LOG = Logger.getLogger(ChatClientHandler.class);
	private ChannelHandlerContext ctx;
	private String nickName;
	public ChatClientHandler(String nickName){
		this.nickName = nickName;
	}
	
	/**启动客户端控制台*/
    private void session() throws IOException {
    		new Thread(){
    			@Override
    			public void run(){
    				LOG.info(nickName + ",你好，请在控制台输入消息内容");
    				Message message = null;
    		        Scanner scanner = new Scanner(System.in);
    		        do{
    			        	if(scanner.hasNext()){
    			        		String input = scanner.nextLine();
    			        		if("exit".equals(input)){
    			        			message = new Message("loginOut",System.currentTimeMillis(),nickName);
    			        		}else{
    			        			message = new Message("chat",System.currentTimeMillis(),nickName,input);
    			        		}
    			        	}
    		        }
    		        while (sendMsg(message));
    		        scanner.close();
    			}
    		}.start();
    }
	
    /**
     * tcp链路建立成功后调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    		this.ctx = ctx;
        Message message = new Message("login",System.currentTimeMillis(),this.nickName);
        sendMsg(message);
        LOG.info("成功连接服务器,已执行登录动作");
        session();
    }
    /**
     * 发送消息
     * @param msg
     * @return
     * @throws IOException 
     */
    private boolean sendMsg(Message msg){
        ctx.channel().writeAndFlush(msg);
        LOG.info("已发送至聊天面板,请继续输入");
        return  true;
    }
    /**
     * 收到消息后调用
     * @throws IOException 
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException {
    	Message m = (Message)msg;
    	String type = m.getType();
    	String info  = new String();

		DateTimeFormatter dateTimeFormat =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime  =LocalDateTime.ofEpochSecond(((Message) msg).getSysTime()/1000,0, ZoneOffset.ofHours(8));
		String date = dateTimeFormat.format(localDateTime);

    	switch (type){
			case "system":
				info = date+"\n系统消息：\n"+m.getContent()+"当前人数："+m.getOnlineNumber();
				break;
			case "chat":
				if (nickName.equals(m.getNickName())){
					info = date+"\n你说：\n"+m.getContent();
				}else {
					info = date+"\n"+m.getNickName()+"说：\n"+m.getContent();
				}
				break;
		}
    	LOG.info(info);
    }
    /**
     * 发生异常时调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    	cause.printStackTrace();
    	LOG.info("与服务器断开连接:"+cause.getMessage());
        ctx.close();
    }
}
