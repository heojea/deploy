package com.kftc.네트로만들파일검증;

import java.awt.BufferCapabilities.FlipContents;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class FileValid {
	@Test
	public void fileCheck() throws IOException{
		Path path = Paths.get("C:/workspace_sts/netty/src/test/java/documents/A_네티테스트_Server");
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		FileChannel fileChannel = FileChannel.open(path, EnumSet.of(StandardOpenOption.READ));
		for (int i = 0; i < 1000000/10; i++) {
			fileChannel.read(byteBuffer);
			byteBuffer.flip();  
			if(!new String(byteBuffer.array()).equals(StringUtils.rightPad("A"+i, 10))){
				System.out.println("(" + new String(byteBuffer.array()) + "=" + StringUtils.right("A"+i, 10) + ")");
				System.out.println("not equal ~~");
				break;
			}	
		}
		

	}
}
