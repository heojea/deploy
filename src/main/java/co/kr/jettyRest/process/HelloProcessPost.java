package co.kr.jettyRest.process;


import co.kr.jettyRest.process.exception.CustomErrorResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by v.jyheo on 2017-12-15.
 * 설명 : exchange 사용방법을 최대한 기술 하도록 한다.
 *       http rest 기반의 값들을 어떻게 가져오는지 확일 할수 있도록 한다.
 */
public class HelloProcessPost implements Processor{
    public void process(Exchange exchange) throws Exception {
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

        HttpServletResponse response = (HttpServletResponse) exchange.getIn().getHeader(Exchange.HTTP_SERVLET_RESPONSE);
        Map<String,String> payload = new HashMap<>();
        payload.put("id", "2");
        payload.put("content", "User");

        //response body 내용을 기술
        exchange.getOut().setBody(payload);

        CustomErrorResponse.setErrorResponse(exchange,"CUSTOM ERROR RESPONSE ~~" ,"text/plain" , 502);
    }
}
