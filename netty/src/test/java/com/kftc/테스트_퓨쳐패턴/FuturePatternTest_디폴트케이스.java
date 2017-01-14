package com.kftc.테스트_퓨쳐패턴;

import org.junit.Test;

import com.kftc.테스트_퓨쳐패턴.interfaceC.IData;

public class FuturePatternTest_디폴트케이스 {
	@Test
	public void main(){
		System.out.println("main Begin");
		final Host host = new Host();
		
		/*
		final IData data1 = host.request(10,'A'); 
		final IData data2 = host.request(20,'B');
		final IData data3 = host.request(30,'C');
		
		System.out.println("main otherJob BEGIN");
		
		/*try{
			Thread.sleep(2000);
		}catch(final InterruptedException e){e.printStackTrace();}
		System.out.println("main otherJob End");
		
		System.out.println("data1 = " + data1.getContent());
		System.out.println("data2 = " + data2.getContent());
		System.out.println("data3 = " + data3.getContent());
		
		System.out.println("main End");*/
		
	}
}



