package co.kr.nettyProject.vo;

import java.util.concurrent.atomic.AtomicInteger;

public class StringFactory {
	
	AtomicInteger atomInt = new AtomicInteger();
	
	@SuppressWarnings("finally")
	public String getString(){
		return "TEST STRING===>" + atomInt.getAndIncrement();
	}
}
