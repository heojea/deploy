package co.kr.nettyProject.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;

import org.apache.camel.component.netty4.NettyConsumer;
import org.apache.camel.component.netty4.ServerInitializerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.kr.nettyProject.handler.server.ServerInBoundHandHandler;

public class ServerInitFactory extends ServerInitializerFactory  {
	private Logger LOG = LoggerFactory.getLogger(ServerInitFactory.class);
	private NettyConsumer nettyConsumer;
	
	public ServerInitFactory(){}
	
	public ServerInitFactory(NettyConsumer nettyConsumer) {

		this.nettyConsumer = nettyConsumer;
	}

	@Override
	public ServerInitializerFactory createPipelineFactory(NettyConsumer nettyConsumer) {
		return new ServerInitFactory(nettyConsumer);
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline p = ch.pipeline();
		p.addLast(new ServerInBoundHandHandler(this.nettyConsumer));
	}
}
