package mq.activeMQ.broker;

import org.apache.activemq.broker.BrokerService;

/**
 * @author admin
 * @date 2020-06-01 9:24
 */
public class BrokerTest {

    public static void main(String[] args) {
        BrokerService brokerService = new BrokerService();
        try {
            brokerService.setUseJmx(true);
            brokerService.addConnector("tcp://localhost:61616");
            brokerService.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
