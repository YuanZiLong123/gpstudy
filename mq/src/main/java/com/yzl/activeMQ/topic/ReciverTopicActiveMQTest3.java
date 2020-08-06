package mq.activeMQ.topic;

import mq.activeMQ.Constant;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author admin
 * @date 2020-05-29 13:17
 */
public class ReciverTopicActiveMQTest3 {


    public static void main(String[] args) {
        ReciverTopicActiveMQTest reciverTopicActiveMQTest = new ReciverTopicActiveMQTest();
        reciverTopicActiveMQTest.reciverTopic();
    }



    public void reciverTopic(){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(Constant.ACTIVE_IP);

        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE );
            Topic topic = session.createTopic("topic");
            consumer = session.createConsumer(topic);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if (message instanceof  TextMessage){
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            System.out.println(textMessage.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            System.in.read();
        }catch (Exception e){

        }finally{
            try {
                consumer.close();
                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }


    }

}
