package com.kftc.테스트_퓨쳐패턴.Impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.kftc.테스트_퓨쳐패턴.interfaceC.IData;

public class StreamData implements IData{
	private final String content;
	
	public StreamData(final int count, final byte[] c) throws IOException{
		System.out.println(" making Stream ReadlData(" + count + "," + c + ")Begin");
		
		
		Path path = Paths.get("C:/workspace_sts/netty/src/test/java/com/kftc/테스트_퓨쳐패턴/documents",Thread.currentThread().getName());
		FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
		ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
		for (int i = 0; i < count; i++) {
			byteBuffer.clear();
			byteBuffer.put(c);
			byteBuffer.flip();
			fileChannel.write(byteBuffer);	
		}
		
		fileChannel.close();
		
		System.out.println(" making  Stream ReadData(" + count + "," + c + ")End");
		this.content = new String(c);
	}
	@Override
	public String getContent() {
		return this.content;
	}
}