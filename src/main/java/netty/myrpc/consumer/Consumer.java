package netty.myrpc.consumer;

import netty.myrpc.api.JdbcInterface;
import netty.myrpc.api.MyInterface;
import netty.myrpc.consumer.proxy.MyRpcProxy;
import netty.myrpc.model.User;
import netty.rpc.consumer.proxy.RpcProxy;

import java.util.List;

/**
 * @author admin
 * @date 2020-06-01 15:02
 */
public class Consumer {

    public static void main(String[] args) {

        MyInterface myInterface = MyRpcProxy.getProxy(MyInterface.class);
        System.out.println(myInterface.hello("mnn"));

        JdbcInterface jdbcInterface = MyRpcProxy.getProxy(JdbcInterface.class);


        List<User> users = jdbcInterface.select();

        users.forEach(user -> {
             System.out.println(user);
         });
        System.out.println("*****************************");
        User user = new User();

        user.setId(1000);
        user.setName("代号0000"+1000);
         jdbcInterface.add(user);


         jdbcInterface.delete(2);


         user.setId(3);
         user.setName("卧底");
         jdbcInterface.update(user);

        System.out.println(jdbcInterface.selectById(3));

        System.out.println("*****************************");

        jdbcInterface.select().forEach(newUser -> {
            System.out.println(newUser);
        });

    }

}
