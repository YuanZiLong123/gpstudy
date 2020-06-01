package mq.activeMQ.broker.notransactional;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author admin
 * @date 2020-06-01 14:13
 */
public class QueueReceive {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();


            // Session.AUTO_ACKNOWLEDGE  自动签收
            // Session.CLIENT_ACKNOWLEDGE 客户端进行签收
            // Session.DUPS_OK_ACKNOWLEDGE 延迟签收
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE );
            Destination destination = session.createQueue("nu-transactional");
            MessageConsumer consumer = session.createConsumer(destination);
            TextMessage textMessage = (TextMessage) consumer.receive();

            System.out.println(textMessage.getText());

            //textMessage.acknowledge();
            session.close();

        }catch (Exception e){

        }finally{
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
