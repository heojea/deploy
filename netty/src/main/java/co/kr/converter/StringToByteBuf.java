package co.kr.converter;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringToByteBuf{
	private static Logger LOG = LoggerFactory.getLogger(StringToByteBuf.class);
    
    public ByteBuf toByteBuffer(String s, Exchange exchange) {
    	LOG.debug("String s:[{}], Exchange exchange:[{}]", s, exchange);
        byte[] bytes;
        if (exchange != null) {
            // use type converter as it can handle encoding set on the Exchange
            bytes = exchange.getContext().getTypeConverter().convertTo(byte[].class, exchange, s);
        } else {
            bytes = s.getBytes();
        }
        
        
        return toByteBuffer(bytes);
    }
    
    public ByteBuf toByteBuffer(byte[] bytes) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(bytes.length);
        buf.writeBytes(bytes);
        return buf;
    }
}
