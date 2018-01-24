package co.kr.nettyProject.vo;

import java.util.concurrent.atomic.AtomicInteger;

public class ByteArrFactory {
	
	AtomicInteger atomInt = new AtomicInteger();
	
	@SuppressWarnings("finally")
	public byte[] getByteArr(){
		return ("TEST byte ARR===>" + atomInt.getAndIncrement()).getBytes();
	}
}
