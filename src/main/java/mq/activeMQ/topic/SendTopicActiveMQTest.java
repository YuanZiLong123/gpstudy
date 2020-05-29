package mq.activeMQ.topic;


import mq.activeMQ.Constant;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author admin
 * @date 2020-05-29 11:52
 */
public class SendTopicActiveMQTest {

    public static void main(String[] args) {
        SendTopicActiveMQTest sendTopicActiveMQTest = new SendTopicActiveMQTest();
        sendTopicActiveMQTest.sendTopicMQ();
    }



    public void sendTopicMQ()  {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(Constant.ACTIVE_IP);
        Connection connection = null;
        Session session = null;
        MessageProducer messageProducer = null;
        try {
            connection = connectionFactory.createConnection();
             session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("topic");
             messageProducer = session.createProducer(topic);
            TextMessage textMessage = session.createTextMessage("你好！垃圾");
            messageProducer.send(textMessage);
        }catch (Exception e){

        }finally{
            try {
                messageProducer.close();
                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }


    }

}
