package com.kftc.테스트_퓨쳐패턴;

import java.io.IOException;

import com.kftc.테스트_퓨쳐패턴.Impl.FutureData;
import com.kftc.테스트_퓨쳐패턴.Impl.StreamData;
import com.kftc.테스트_퓨쳐패턴.interfaceC.IData;


class Host{
	public IData request(final int count , final byte[] c){
		System.out.println(" request(" + count+ "," + c + ")BEGIN");
		final FutureData future = new FutureData();
		
		new Thread(){
			public void run(){
				StreamData realData = null;
				try {
					realData = new StreamData(count ,c);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				future.setRealData(realData);
			}//end run Method
		}.start();
		
		System.out.println(" request(" + count + "," + c+ ")End");
		return future;
	}
}