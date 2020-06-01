package netty.myrpc.provide;

import io.netty.channel.*;
import netty.myrpc.protocol.Protocol;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author admin
 * @date 2020-06-01 14:37
 */
public class RpcHandler extends ChannelInboundHandlerAdapter {


    private ConcurrentHashMap<String,Object> interfaceMap = new ConcurrentHashMap<>();

    private List<String> classNames = new ArrayList<>();

    private final String packageName = "netty.myrpc.impl";

    public RpcHandler() {
        scannerClass(packageName);
        doRegister();
    }


    private void scannerClass(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File file = new File(url.getFile());
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                scannerClass(f.getPath());
            }else {
                classNames.add(packageName + "." + f.getName().replace(".class", "").trim());
            }
        }
    }

    private void doRegister() {
        if (classNames.size()==0){
            return;
        }

        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                Class<?> i = clazz.getInterfaces()[0];
                interfaceMap.put(i.getName(), clazz.newInstance());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        Channel channel = ctx.channel();
        Protocol protocol = (Protocol) msg;
        String clazzName = protocol.getClassName();
        Object clazz  = interfaceMap.get(clazzName);
        Method method = clazz.getClass().getMethod(protocol.getMethod(),protocol.getArgs());
        Object result =  method.invoke(clazz, protocol.getValues());
        channel.writeAndFlush(result);
        channel.close();
    }


    public static void main(String[] args) {
        new RpcHandler();
    }

}
