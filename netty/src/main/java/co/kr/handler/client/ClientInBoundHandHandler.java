package co.kr.handler.client;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientInBoundHandHandler extends ChannelInboundHandlerAdapter {
	private Logger LOG = LoggerFactory.getLogger(ClientInBoundHandHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		LOG.debug("[CLIENT] channelActive channelID[{}]",ctx.toString());
		//super.channelActive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		LOG.debug("[CLIENT] channelRead channelID[{}]",ctx.toString());
		// TODO Auto-generated method stub
		//super.channelRead(ctx, msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		//super.channelReadComplete(ctx);
		ChannelFuture cf = ctx.channel().close();
		cf.addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				LOG.debug("CLINET channelReadComplete >> close >> operationComplete future.isSuccess:[{}]]" + future.isSuccess());
			}
		});
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		//super.exceptionCaught(ctx, cause);
	}

}
