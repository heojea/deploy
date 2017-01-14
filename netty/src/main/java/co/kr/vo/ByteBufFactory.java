package co.kr.vo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.concurrent.atomic.AtomicInteger;

public class ByteBufFactory {
	
	AtomicInteger atomInt = new AtomicInteger();
	
	@SuppressWarnings("finally")
	public ByteBuf getByteBuf(){
		byte[] testData = ("TEST VALUE =====>" + atomInt.getAndIncrement()).getBytes();
		ByteBuf byteBuf = Unpooled.buffer(testData.length);
		byteBuf.writeBytes(testData);
		return byteBuf;	
	}
}
