package com.kftc.handler;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

public class StringEncoder extends MessageToMessageEncoder<ByteBuf> {

	@Override
	protected void encode(ChannelHandlerContext ctx, ByteBuf msg,
			List<Object> out) throws Exception {
		
		System.out.println(msg.toString(Charset.defaultCharset()));
		msg.writeBytes("stringEncoding".getBytes());
		ChannelFuture channelFuture = ctx.writeAndFlush(msg);
		
		System.out.println("timeunit before");
		channelFuture.await(5, TimeUnit.SECONDS);
		System.out.println("timeunit after");
	}
}
	