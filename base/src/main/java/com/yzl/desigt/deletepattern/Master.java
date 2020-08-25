package com.yzl.desigt.deletepattern;

import com.yzl.desigt.deletepattern.CleanMachine;
import com.yzl.desigt.deletepattern.CookMachine;
import com.yzl.desigt.deletepattern.DriveMachine;
import com.yzl.desigt.deletepattern.IWork;

import java.util.HashMap;

public class Master {

    private static HashMap<String, IWork> delegateMachines = new HashMap<String, IWork>();

    static  {
        delegateMachines.put("cook",new CookMachine());
        delegateMachines.put("clean",new CleanMachine());
        delegateMachines.put("drive",new DriveMachine());
    }

    public void doWork(String cmd){
        delegateMachines.get(cmd).doWork();
    }

}
