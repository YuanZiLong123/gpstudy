package mq.activeMQ.broker.notransactional;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author admin
 * @date 2020-06-01 10:39
 */
public class QueueSend {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE );
            Destination destination  = session.createQueue("nu-transactional");

            MessageProducer messageProducer =  session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage("你好呀");
            messageProducer.send(textMessage);

            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != connection){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
