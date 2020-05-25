package zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2019/11/12
 */
public class ZkclientDemo  {

    private static  final String path = "47.98.209.24:2181";


    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(path,4000);
        String path = "/yzl";

        zkClient.create(path, "123", CreateMode.PERSISTENT );
        zkClient.writeData(path,"456" );
        zkClient.getChildren(path);


        zkClient.delete("/yzl");

    }

}
