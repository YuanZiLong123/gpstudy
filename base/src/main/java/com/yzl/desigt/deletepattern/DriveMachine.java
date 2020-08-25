package com.yzl.desigt.deletepattern;

import com.yzl.desigt.deletepattern.IWork;

public class DriveMachine implements IWork {
    @Override
    public void doWork() {
        System.out.println("我是驾驶的机器人，负责驾驶");
    }
}
