package co.kr.jettyRest.process;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spi.DataFormat;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by v.jyheo on 2017-12-15.
 * 설명 : exchange 사용방법을 최대한 기술 하도록 한다.
 *       http rest 기반의 값들을 어떻게 가져오는지 확일 할수 있도록 한다.
 */
public class HelloProcessPost implements Processor , DataFormat{
	private ObjectMapper jacksonMapper;
    public void process(Exchange exchange) throws Exception {
    	jacksonMapper = new ObjectMapper();
        /*
        System.out.println("exchange.toString():::"+exchange.toString());
        System.out.println("exchange.getIn().toString():::"+exchange.getIn().toString());
        System.out.println("exchange.getOut().toString():::"+exchange.getOut().toString());
        System.out.println("exchange.getIn().getHeaders().toString():::"+exchange.getIn().getHeader("Accept"));
        System.out.println("exchange.getIn().getHeaders().toString():::"+exchange.getIn().getHeader("Accept-Language"));
        System.out.println("exchange.getIn().getHeaders().toString():::"+exchange.getIn().getHeader("Cache-Control"));

        System.out.println("exchange.getProperty(viewClass):::"+exchange.getProperty("viewClass"));
        System.out.println("exchange.getOut().getBody(OutputStream.class):::" + exchange.getIn().getBody(OutputStream.class));
        System.out.println("exchange.getIn().getHeader(Exchange.HTTP_SERVLET_RESPONSE):::" + exchange.getIn().getHeader(Exchange.HTTP_SERVLET_RESPONSE));
        */

        Map<String,String> payload = new HashMap<>();


        HttpServletResponse response = (HttpServletResponse) exchange.getIn().getHeader(Exchange.HTTP_SERVLET_RESPONSE);
        
        //exchange.getOut().setBody("{\"id\":2,\"content\":\"Hello, User!\"}");
        //String responseString = "{\"id\":2,\"content\":\"Hello, User!\"}";

        payload.put("id","2");
        payload.put("content","User");


        //String json = new ObjectMapper().writeValueAsString(payload);
        this.marshal(exchange, payload , response.getOutputStream());
        
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
