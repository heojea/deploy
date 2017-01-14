package co.kr.vo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufFactory {
	
	@SuppressWarnings("finally")
	public ByteBuf getByteBuf(){
		byte[] testData = "TEST VALUE =====>".getBytes();
		ByteBuf byteBuf = Unpooled.buffer(testData.length);
		byteBuf.writeBytes(testData);
		return byteBuf;	
	}
}
