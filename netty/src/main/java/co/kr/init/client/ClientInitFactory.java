package co.kr.init.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;

import org.apache.camel.CamelContext;
import org.apache.camel.component.netty4.ClientInitializerFactory;
import org.apache.camel.component.netty4.NettyProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.kr.handler.client.ClientInBoundHandHandler;

public class ClientInitFactory extends ClientInitializerFactory  {
	private Logger LOG = LoggerFactory.getLogger(ClientInitFactory.class);
	NettyProducer producer;
	CamelContext camelContext;
	
	ClientInitFactory(){
	}
	
	ClientInitFactory(NettyProducer producer){
		LOG.debug("ClientInitFactory  initial[{}]", producer.getEndpoint().getEndpointUri());
		this.producer     = producer;
		this.camelContext = producer.getContext();
		this.camelContext.getShutdownStrategy().setTimeout(3);
	}
	
	@Override
	public ClientInitializerFactory createPipelineFactory(NettyProducer producer) {
		return new ClientInitFactory(producer);
	}

	@Override
	public void initChannel(Channel ch) throws Exception {
		LOG.debug("[CLINET]initChannel chid[{}]",ch.toString());
		ChannelPipeline p = ch.pipeline();
		//p.addLast(new LoggingHandler());
		p.addLast(new ClientInBoundHandHandler());
	}

}
