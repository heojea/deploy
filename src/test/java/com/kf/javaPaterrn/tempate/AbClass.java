package com.kf.javaPaterrn.tempate;

import com.kf.javaPaterrn.tempate.InterfaceClass;

/**
 * Created by v.jyheo on 2018-01-23.
 */
public abstract class AbClass  implements InterfaceClass {
    private String step;
    private int logicCount;

    public synchronized void plusCount(){
        logicCount++;
    }

    public int getLogicCount(){
        return logicCount;
    }

    @Override
    public void init(){
        System.out.println(AbClass.class.getName() + " init action~~~~");
    }

    @Override
    public void head() throws Exception{
        throw new Exception(this.getClass().getName()+ " head !!! not logic");
    }

    @Override
    public void body() throws Exception{
        throw new Exception(this.getClass().getName()+ " body !!! not logic");
    }

    @Override
    public void tail() throws Exception{
        throw new Exception(this.getClass().getName()+ " tail !!! not logic");
    }

    @Override
    public void worker(){
        System.out.println(this.getClass().getName() + " default worker action!!!");
        try{
            this.init();
            this.head();
            this.body();
            this.tail();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
