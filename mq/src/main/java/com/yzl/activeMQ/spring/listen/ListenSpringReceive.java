package mq.activeMQ.spring.listen;


import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.apache.xbean.spring.context.SpringApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import java.io.IOException;

/**
 * @author admin
 * @date 2020-06-03 13:53
 */
public class ListenSpringReceive {

    public static void main(String[] args) {
        SpringApplicationContext springApplicationContext = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/service-jms.xml");


        JmsTemplate jmsTemplate = (JmsTemplate) springApplicationContext.getBean("jmsTemplate");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
