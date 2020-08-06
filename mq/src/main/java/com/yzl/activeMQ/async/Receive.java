package mq.activeMQ.async;

import mq.activeMQ.Constant;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author admin
 * @date 2020-06-03 9:58
 */
public class Receive {
    public static void main(String[] args) {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(Constant.ACTIVE_IP);
        Connection connection = null;
        try {
            connection = activeMQConnectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("queue?consumer.prefetchSize=0");
            MessageConsumer consumer = session.createConsumer(destination);
            for (int i=0;i<1000;i++){
                TextMessage textMessage = (TextMessage) consumer.receive();
                textMessage.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
                System.out.println(textMessage.getText());
                textMessage.acknowledge();
            }


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
