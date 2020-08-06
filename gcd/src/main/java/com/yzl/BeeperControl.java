package com.yzl;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author admin
 * @date 2020-07-06 13:29
 */
public class BeeperControl {






    public void beepForAnHour() {
       /* final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                System.out.println("beep");
            }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);*/

        ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(2);

        scheduler.scheduleAtFixedRate(()->{
            System.out.println(1);

        }, 0 ,10, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {
        BeeperControl beeperControl = new BeeperControl();

        beeperControl.beepForAnHour();
    }
}
