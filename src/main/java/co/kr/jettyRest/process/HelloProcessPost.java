package co.kr.jettyRest.process;


import co.kr.jettyRest.exception.CustomErrorResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by v.jyheo on 2017-12-15.
 * ?Ñ§Î™? : exchange ?Ç¨?ö©Î∞©Î≤ï?ùÑ ÏµúÎ??ïú Í∏∞Ïà† ?ïò?èÑÎ°? ?ïú?ã§.
 *       http rest Í∏∞Î∞ò?ùò Í∞íÎì§?ùÑ ?ñ¥?ñªÍ≤? Í∞??†∏?ò§?äîÏß? ?ôï?ùº ?ï†?àò ?ûà?èÑÎ°? ?ïú?ã§.
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

        //response body binding
        try{
            exchange.getOut().setBody(payload);
        }catch(Exception e){ //custom eror ocurr~
            CustomErrorResponse.setErrorResponse(exchange,"CUSTOM ERROR RESPONSE ~~" ,"text/plain" , 502);
        }
    }
}
