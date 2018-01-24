package com.kf.javaPaterrn.abstractC;

import com.kf.javaPaterrn.interfaceC.InterfaceClass;

/**
 * Created by v.jyheo on 2018-01-23.
 */
public abstract class AbClass implements InterfaceClass {
    private String step;
    private int    logicCount;

    public synchronized void plusCount(){
        logicCount++;
    }

    public int getLogicCount(){
        return logicCount;
    }

    @Override
    public void worker(){
        System.out.println(this.getClass().getName() +" default worker action!!!");
    }

}
