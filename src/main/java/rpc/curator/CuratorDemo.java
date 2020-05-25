package rpc.curator;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2019/11/12
 */
public class CuratorDemo {


    private static  final String path = "47.98.209.24:2181";
    public static void main(String[] args) {
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.newClient(path,new ExponentialBackoffRetry(1000, 3));

        curatorFramework.start();

    }

}
