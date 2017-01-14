package co.kr.init.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;

import org.apache.camel.component.netty4.NettyConsumer;
import org.apache.camel.component.netty4.ServerInitializerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.kr.handler.server.ServerInBoundHandHandler;

public class ServerInitFactory extends ServerInitializerFactory  {
	private Logger LOG = LoggerFactory.getLogger(ServerInitFactory.class);

	@Override
	public ServerInitializerFactory createPipelineFactory(NettyConsumer consumer) {
		
		return new ServerInitFactory();
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline p = ch.pipeline();
		p.addLast(new ServerInBoundHandHandler());
	}
	
	
}
