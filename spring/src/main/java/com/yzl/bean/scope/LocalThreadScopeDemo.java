package com.yzl.bean.scope;

import com.yzl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2020-08-06 11:37
 */
public class LocalThreadScopeDemo {


    @Bean
    @Scope(LocalThreadScope.SCOPE_NAME)
    public SimpleDateFormat simpleDateFormat(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat;
    }


    @Autowired
    public SimpleDateFormat simpleDateFormat;


    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(LocalThreadScopeDemo.class);

        annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactory->{
            beanFactory.registerScope(LocalThreadScope.SCOPE_NAME,new LocalThreadScope());
        });

        annotationConfigApplicationContext.refresh();

        createSimpleDateFormatByThread(annotationConfigApplicationContext);

        annotationConfigApplicationContext.close();



    }

    private static void createSimpleDateFormatByThread(AnnotationConfigApplicationContext annotationConfigApplicationContext) throws InterruptedException {
        List<SimpleDateFormat> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(() -> {

                System.out.println(Thread.currentThread().getName());
                // user 是共享 Bean 对象
               SimpleDateFormat simpleDateFormat = annotationConfigApplicationContext.getBean("simpleDateFormat", SimpleDateFormat.class);
                //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                User user = new User();

                list.add(simpleDateFormat);

                System.out.printf("[Thread id :%d] simpleDateFormat = %s  user = %s%n", Thread.currentThread().getId(), simpleDateFormat,user.toString());
            });


            // 启动线程
            thread.start();
            // 强制线程执行完成
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(1000);

        for (int j = 1;j<10;j++){
            System.out.printf("下标为%s与下标为%s的比较为%s%n",j-1,j,list.get(j-1)==list.get(j));
        }

    }




}
