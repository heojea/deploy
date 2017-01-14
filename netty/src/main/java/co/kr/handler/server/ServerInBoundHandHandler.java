package co.kr.handler.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerInBoundHandHandler extends ChannelInboundHandlerAdapter {
	private Logger LOG = LoggerFactory.getLogger(ServerInBoundHandHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		LOG.debug("[SERVER] channelActive channelID[{}]",ctx.toString());
		//super.channelActive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		LOG.debug("[SERVER] channelRead channelID[{}]",ctx.channel().toString());
		LOG.debug("[SERVER] channelRead RCV.VALUE[{}]", getByteToString((ByteBuf)msg) );
		ByteBuf byteBuf = (ByteBuf)msg;
		LOG.debug("[SERVER] channelRead byteBuf readable[{}]", byteBuf.resetReaderIndex().readableBytes());
		byteBuf.writeBytes(getByteToString((ByteBuf)msg).getBytes());
		ctx.writeAndFlush(byteBuf);
	}

	public String getByteToString(ByteBuf bBuf){
		byte[] tempByteArr = new byte[bBuf.readableBytes()];
		bBuf.readBytes(tempByteArr);
		return new String(tempByteArr);
		
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		//super.channelReadComplete(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		//super.exceptionCaught(ctx, cause);
	}

}
