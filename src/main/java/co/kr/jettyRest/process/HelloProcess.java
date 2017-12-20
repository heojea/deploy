package co.kr.jettyRest.process;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by v.jyheo on 2017-12-15.
 * ?Ñ§Î™? : exchange ?Ç¨?ö©Î∞©Î≤ï?ùÑ ÏµúÎ??ïú Í∏∞Ïà† ?ïò?èÑÎ°? ?ïú?ã§.
 *       http rest Í∏∞Î∞ò?ùò Í∞íÎì§?ùÑ ?ñ¥?ñªÍ≤? Í∞??†∏?ò§?äîÏß? ?ôï?ùº ?ï†?àò ?ûà?èÑÎ°? ?ïú?ã§.
 */
public class HelloProcess implements Processor , DataFormat{

	private ObjectMapper jacksonMapper;
	  
    public void process(Exchange exchange) throws Exception {
    	jacksonMapper = new ObjectMapper();
        System.out.println("exchange.toString():::"+exchange.toString());
        System.out.println("exchange.getIn().toString():::"+exchange.getIn().toString());
        System.out.println("exchange.getIn().getHeaders().toString():::"+exchange.getIn().getHeader("Accept"));
        System.out.println("exchange.getIn().getHeaders().toString():::"+exchange.getIn().getHeader("Accept-Language"));
        System.out.println("exchange.getIn().getHeaders().toString():::"+exchange.getIn().getHeader("Cache-Control"));
        System.out.println("exchange.getProperty(viewClass):::"+exchange.getProperty("viewClass"));
        System.out.println("exchange.getOut().getBody(OutputStream.class):::" + exchange.getIn().getBody(OutputStream.class));
        System.out.println("exchange.getIn().getHeader(Exchange.HTTP_SERVLET_RESPONSE):::" + exchange.getIn().getHeader(Exchange.HTTP_SERVLET_RESPONSE));
        
        HttpServletResponse response = (HttpServletResponse) exchange.getIn().getHeader(Exchange.HTTP_SERVLET_RESPONSE);
        
        //exchange.getOut().setBody("{\"id\":2,\"content\":\"Hello, User!\"}");
        //String responseString = "{\"id\":2,\"content\":\"Hello, User!\"}";
        
        Map<String,String> payload = new HashMap<>();
        payload.put("id", "1111");
        payload.put("content", "ddfadsf");

        exchange.getOut().setBody(payload);

        //String json = new ObjectMapper().writeValueAsString(payload);
        //this.marshal(exchange, payload , response.getOutputStream());
        
    }

	@Override
	public void marshal(Exchange exchange, Object obj, OutputStream stream) throws Exception {
        Class view = (Class) exchange.getProperty("viewClass");
        if (view != null){
            ObjectWriter w = jacksonMapper.writerWithView(view);
            w.writeValue(stream, obj);
        }else{
            stream.write(jacksonMapper.writeValueAsBytes(obj));
        }

    }

	@Override
	public Object unmarshal(Exchange arg0, InputStream arg1) throws Exception {
		return null;
	}
}
