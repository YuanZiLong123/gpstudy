package com.yzl.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author admin
 * @date 2020-08-20 9:08
 */
public class MessageFormatDemo {

    public static void main(String[] args) {
        String messageFormatPattern = "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.";
        MessageFormat messageFormat = new MessageFormat(messageFormatPattern);

        Object[] objs = {1,new Date(),"hello word"};

        String result = messageFormat.format(objs);

        System.out.println(result);


        messageFormat.applyPattern("{0} at {1} ");

        objs = new Object[]{1,new Date()};

         result = messageFormat.format(objs);

        System.out.println(result);


        messageFormat.setFormat(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objs = new Object[]{1,new Date()};

         result = messageFormat.format(objs);

        System.out.println(result);

    }
}
