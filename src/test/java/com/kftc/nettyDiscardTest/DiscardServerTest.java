package com.kftc.nettyDiscardTest;

import io.netty.bootstrap.ServerBootstrap;
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
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.kftc.Util.ByteBufUtil;
import com.kftc.Util.CustomUtil;
import com.kftc.handler.StringEncoder;

public class DiscardServerTest {
	//start setting
	public static void main(String[] args) throws InterruptedException{
	    EventLoopGroup bossGroup = new NioEventLoopGroup(2);
	    EventLoopGroup workerGroup = new NioEventLoopGroup();
	    try {
	        ServerBootstrap b = new ServerBootstrap();
	        b.group(bossGroup, workerGroup)
	         .channel(NioServerSocketChannel.class)
	         //.option(ChannelOption.SO_BACKLOG, 100)
	         //.handler(new LoggingHandler(LogLevel.INFO))
	         
	         .childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ChannelPipeline p = ch.pipeline();
					
					p.addLast(new LoggingHandler(LogLevel.INFO));
					
					p.addLast(new StringEncoder());
					//p.addLast(new OutBoundTest());
					p.addLast(new DiscardServerHandler());
					
					
				}
	        	  
	         });
	
	        // Start the server.
	        ChannelFuture f = b.bind(8888).sync();
	
	        f.channel().closeFuture().sync();
	    } finally {
	        // Shut down all event loops to terminate all threads.
	    	workerGroup.shutdownGracefully();
	        bossGroup.shutdownGracefully();
	        
	    }
	}
}


class DiscardServerHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Server Channel active!!!!");
		ByteBuf buf = Unpooled.buffer(3);
		buf.writeBytes("serverString>>>> ".getBytes());
		ctx.write(buf);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf byteBuf = (ByteBuf)msg;
		Path path = Paths.get("C:/workspace_sts/netty/src/test/java/documents/A_네티테스트_Server");
		RandomAccessFile raf = new RandomAccessFile(path.toFile(),"rw");
		raf.seek(raf.length());
		FileOutputStream fos = new FileOutputStream(raf.getFD());
		ByteBufUtil.write(fos, byteBuf);
		CustomUtil.print(byteBuf);
		
		//ctx.write(byteBuf);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		//ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}
	
}
