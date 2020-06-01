package netty.myrpc.impl;

import netty.myrpc.api.JdbcInterface;
import netty.myrpc.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author admin
 * @date 2020-06-01 16:10
 */
public class JdbcInterfaceImpl implements JdbcInterface {

    private static ConcurrentHashMap<Integer,User> userDb = new ConcurrentHashMap<>();

   static  {
        for (int i =1; i<=10;i++){
            User user = new User();
            user.setId(i);
            user.setName("代号0000"+i);
            userDb.put(i,user );
        }

    }


    @Override
    public boolean add(User user) {
        return Objects.nonNull(userDb.put(user.getId(),user ));
    }

    @Override
    public boolean delete(Integer id) {
        return Objects.nonNull(userDb.remove(id));
    }

    @Override
    public boolean update(User user) {
        return Objects.nonNull(userDb.put(user.getId(),user ));
    }

    @Override
    public List<User> select() {
       List<User> users = new ArrayList<>();
       userDb.values().forEach(user -> {
           users.add(user );
       });
       return users;
    }

    @Override
    public User selectById(Integer id) {
        return userDb.get(id);
    }
}
