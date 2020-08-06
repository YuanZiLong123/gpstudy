package com.yzl.bean.scope;

import com.yzl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @date 2020-08-06 11:37
 */
public class SimpleDateFormatterScopeDemo {


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

        annotationConfigApplicationContext.register(SimpleDateFormatterScopeDemo.class);

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
            SimpleDateFormat simpleDateFormat = annotationConfigApplicationContext.getBean(SimpleDateFormat.class);
            //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Thread thread = new SimpleDateFormatThread("2018-11-03 10:02:47",simpleDateFormat);

            list.add(simpleDateFormat);
            // 启动线程
            thread.start();
            // 强制线程执行完成
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1;j<10;j++){
            System.out.printf("下标为%s与下标为%s的比较为%s%n",j-1,j,list.get(j-1)==list.get(j));
        }

    }


    public static class SimpleDateFormatThread extends Thread {

        private String dateStr;

        private SimpleDateFormat simpleDateFormat;

        public SimpleDateFormatThread(String dateStr, SimpleDateFormat simpleDateFormat){
            this.dateStr = dateStr;
            this.simpleDateFormat = simpleDateFormat;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName()+":"+simpleDateFormat.parse(dateStr));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
