package com.kftc.Util;

import io.netty.buffer.ByteBuf;

public class CustomUtil {
	public static void print(ByteBuf byteBuf){
		System.out.println("byteBuf.readableBytes()==" + byteBuf.readableBytes());
		System.out.println("byteBuf.readerIndex()==" + byteBuf.readerIndex());
		System.out.println("byteBuf.isReadable()==" + byteBuf.isReadable());
		System.out.println("byteBuf.writerIndex()==" + byteBuf.writerIndex());
		System.out.println("byteBuf.capacity()==" + byteBuf.capacity());
		System.out.println("byteBuf.readByte()==" + byteBuf.readByte());
	}
}
