package com.kftc.테스트_퓨쳐패턴.Impl;

import com.kftc.테스트_퓨쳐패턴.interfaceC.IData;

public class RealData implements IData{
	private final String content;
	
	public RealData(final int count, final char c){
		System.out.println(" making ReadlData(" + count + "," + c + ")Begin");
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i]  = c;
		}
		
		System.out.println(" making ReadData(" + count + "," + c + ")End");
		this.content = new String(buffer);
	}
	@Override
	public String getContent() {
		return this.content;
	}
}