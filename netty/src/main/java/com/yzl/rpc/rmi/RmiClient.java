package com.yzl.rpc.rmi;

import com.yzl.rpc.SerizableDome.User;

import java.rmi.Naming;

public class RmiClient {


    public static void main(String[] args) {

        try {
            IUserService userService = (IUserService) Naming.lookup("rmi://59.69.29.130:8888/getUser");

            User user = userService.getUser();
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
