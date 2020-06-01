package mq.activeMQ.broker.transactional;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author admin
 * @date 2020-06-01 9:48
 */
public class TransactionalTopicReceive {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection=null;
        try {
            connection = connectionFactory.createConnection();
           connection.start();
           Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
           Destination destination = session.createTopic("topic");
           MessageConsumer consumer = session.createConsumer(destination);
           TextMessage textMessage = (TextMessage) consumer.receive();

            System.out.println(textMessage.getText());

            //确认消息被签收
            session.commit();

            consumer.close();
            session.close();
            connection.close();;

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
