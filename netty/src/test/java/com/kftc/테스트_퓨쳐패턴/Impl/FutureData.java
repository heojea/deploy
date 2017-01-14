package com.kftc.테스트_퓨쳐패턴.Impl;

import com.kftc.테스트_퓨쳐패턴.interfaceC.IData;

public class FutureData implements IData{
	private IData realData = null;
	private boolean ready = false;
	
	public synchronized void setRealData(final StreamData realData2){
		if(ready){
			System.out.println("read return!~!!!!!!!!!!!!");
			return;
			
		}//end if
		this.realData = realData2;
		this.ready = true;
		notifyAll();
	}
	
	@Override
	public synchronized String getContent() {
		while(!this.ready){
			try{
				System.out.println("wait!~!!!!!!!!!!!!");
				wait();
			}catch(final InterruptedException e){e.printStackTrace();}
		}
		return this.realData.getContent();
	}
	
}