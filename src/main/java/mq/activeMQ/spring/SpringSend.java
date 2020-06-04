package mq.activeMQ.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.apache.xbean.spring.context.SpringApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author admin
 * @date 2020-06-03 13:14
 */
public class SpringSend {

    public static void main(String[] args) {
        SpringApplicationContext applicationContext  = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/service-jms.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate");

        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText("hello");
                return textMessage;
            }
        });

    }

}


