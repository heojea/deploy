package co.kr.jettyRest.process;


//import co.kr.jettyRest.exception.CustomErrorResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by v.jyheo on 2017-12-15.
 * ?���? : exchange ?��?��방법?�� 최�??�� 기술 ?��?���? ?��?��.
 *       http rest 기반?�� 값들?�� ?��?���? �??��?��?���? ?��?�� ?��?�� ?��?���? ?��?��.
 */
public class HelloProcessPut implements Processor{
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
        List<Map> list = new ArrayList();
        Map<String,String> payload = new HashMap<>();
        payload.put("id", "2");
        payload.put("content", "Put");
        list.add(payload);

        payload = new HashMap<>();
        payload.put("id", "4");
        payload.put("content", "User11");

        list.add(payload);


        //response body binding
        try{
            exchange.getOut().setBody(list);
        }catch(Exception e){ //custom eror ocurr~
            //CustomErrorResponse.setErrorResponse(exchange,"CUSTOM ERROR RESPONSE ~~" ,"text/plain" , 502);
        }
    }
}
