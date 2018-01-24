package com.kf.javaPaterrn.impl;


import com.kf.javaPaterrn.abstractC.AbClass;

/**
 * Created by v.jyheo on 2018-01-24.
 */
public class ImplClass extends AbClass{
    @Override
    public void worker(){
        System.out.println(this.getClass().getName() +" IMplClass worker action!!!");
    }
}
