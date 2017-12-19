package com.kf.nettyDiscardTest;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;

public class EchoClintTest {
	// start setting
	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();

		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
			// .handler(new LoggingHandler(LogLevel.INFO))
					.handler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch)
								throws Exception {
							ChannelPipeline p = ch.pipeline();
							p.addLast(new LoggingHandler(LogLevel.INFO));
							p.addLast(new EchoClientHandler());
						}
					});
			;
			// Start the server.
			ChannelFuture f = b.connect("localhost", 8888).sync();

			f.channel().closeFuture().sync();
		} finally {
			// Shut down all event loops to terminate all threads.
			group.shutdownGracefully();

		}
	}
}

class EchoClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		/*ByteBuf byteBuf = Unpooled.buffer();
		
		Path path = Paths.get("C:/workspace_sts/netty/src/test/java/documents/A_네티테스트");
		RandomAccessFile raf = new RandomAccessFile(path.toFile() , "r" );
		raf.seek(0);
		FileInputStream fis = new FileInputStream(raf.getFD());
		
		byte[] bytes = new byte[100];
		
		for (int i = 0; i < 10; i++) {
			raf.seek(i*100);
			IOUtils.readFully(fis, bytes);
			byteBuf.writeBytes(bytes);
			ctx.write(byteBuf);
			byteBuf.retain();
			ctx.flush();
		}*/
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		((ByteBuf) msg).toString(Charset.defaultCharset());
		// ctx.close();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
