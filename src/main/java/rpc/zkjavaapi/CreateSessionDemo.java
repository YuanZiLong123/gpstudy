package rpc.zkjavaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2019/11/12
 */
public class CreateSessionDemo implements Watcher {


    private static  final String path = "47.98.209.24:2181";

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static  ZooKeeper zooKeeper = null;

    private static Stat stat = new Stat();

    public static void main(String[] args) {


        try {
             zooKeeper = new ZooKeeper(path,5000 , new CreateSessionDemo());
            countDownLatch.await();
            zooKeeper.create("/yzl", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT );
            TimeUnit.SECONDS.sleep(5);
            zooKeeper.create("/yzl/mn", "111".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT );
            TimeUnit.SECONDS.sleep(5);
            zooKeeper.setData("/yzl", "456".getBytes(), -1);
            TimeUnit.SECONDS.sleep(5);
            zooKeeper.delete("/yzl/mn", -1);
            TimeUnit.SECONDS.sleep(5);
            zooKeeper.delete("/yzl", -1);
            TimeUnit.SECONDS.sleep(5);

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            if (watchedEvent.getState()== Event.KeeperState.SyncConnected){
                System.out.println(watchedEvent.getType());
                if(Event.EventType.None==watchedEvent.getType()&&null==watchedEvent.getPath()){
                    countDownLatch.countDown();
                    System.out.println(watchedEvent.getState()+"-->"+watchedEvent.getType()
                            );
                }else if (watchedEvent.getType()==Event.EventType.NodeCreated){
                    System.out.println(watchedEvent.getPath()+"节点被创建"+"->节点的值："+
                            zooKeeper.getData(watchedEvent.getPath(),true,stat));
                }else if (watchedEvent.getType()==Event.EventType.NodeDataChanged){
                    System.out.println(watchedEvent.getPath()+"节点被改变，值为"
                            +zooKeeper.getData(watchedEvent.getPath(), true,stat ));
                }else if (watchedEvent.getType()==Event.EventType.NodeDeleted){
                    System.out.println(watchedEvent.getPath()+"节点被删除"+"->节点的值："+
                            zooKeeper.getData(watchedEvent.getPath(),true,stat));
                }else if (watchedEvent.getType()==Event.EventType.NodeChildrenChanged){
                    System.out.println(watchedEvent.getPath()+"子节点被改变");
                }
            }
        }catch (Exception e){

        }

    }
}
