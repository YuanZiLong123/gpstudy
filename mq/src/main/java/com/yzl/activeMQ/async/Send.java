package mq.activeMQ.async;

import mq.activeMQ.Constant;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @author admin
 * @date 2020-06-03 9:58
 */
public class Send {

    public static void main(String[] args) {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(Constant.ACTIVE_IP);
        Connection connection = null;
        try {
            //设置异步发送
             //activeMQConnectionFactory.setUseAsyncSend(true);
            //activeMQConnectionFactory.setProducerWindowSize(100);
            //设置同步发送
            activeMQConnectionFactory.setAlwaysSyncSend(true);

             connection = activeMQConnectionFactory.createConnection();
             connection.start();
             Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("queue?consumer.prefetchSize=0");
            MessageProducer producer = session.createProducer(destination);

            for (int i = 0;i<200;i++){
                TextMessage textMessage = session.createTextMessage("你好"+i);
                //设置非持久化消息
                textMessage.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
                producer.send(textMessage);
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
