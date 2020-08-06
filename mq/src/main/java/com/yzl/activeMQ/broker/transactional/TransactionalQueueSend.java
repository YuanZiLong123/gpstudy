package mq.activeMQ.broker.transactional;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author admin
 * @date 2020-06-01 9:36
 */
public class TransactionalQueueSend {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection =null;
        try {
             connection = connectionFactory.createConnection();
            connection.start();
            //开启事物
            Session  session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("queue");

            MessageProducer  producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("你好");
            producer.send(textMessage);

            //事务进行提交
            session.commit();

            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if (null !=connection){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
