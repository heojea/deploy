package com.kftc.Util;

import java.io.IOException;
import java.io.OutputStream;

import io.netty.buffer.ByteBuf;

public class ByteBufUtil {
	public static void write(OutputStream os , ByteBuf byteBuf) throws IOException{
		byte[] tempByte = new byte[byteBuf.readableBytes()];
		byteBuf.getBytes(0, tempByte);
		os.write(tempByte);
	}
}
