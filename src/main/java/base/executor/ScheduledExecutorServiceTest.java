package base.executor;


import java.util.concurrent.*;

/**
 * @author admin
 * @date 2020-05-26 15:25
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
      //  BlockingQueue workQueue = new LinkedBlockingQueue();
        //ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(1, 2, 100, TimeUnit.SECONDS, workQueue);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        MyThread myThread = new MyThread();
        scheduledExecutorService.scheduleAtFixedRate(myThread, 0,10 ,TimeUnit.SECONDS );
    }





}
