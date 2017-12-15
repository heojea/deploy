package co.kr.jettyRest.process;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by v.jyheo on 2017-12-15.
 * 설명 : exchange 사용방법을 최대한 기술 하도록 한다.
 *       http rest 기반의 값들을 어떻게 가져오는지 확일 할수 있도록 한다.
 */
public class HelloProcess implements Processor {
    public void process(Exchange exchange) throws Exception {
        System.out.println("exchange.toString():::"+exchange.toString());
        System.out.println("exchange.getIn().toString():::"+exchange.getIn().toString());
        System.out.println("exchange.getIn().getHeaders().toString():::"+exchange.getIn().getHeader("Accept"));
        System.out.println("exchange.getIn().getHeaders().toString():::"+exchange.getIn().getHeader("Accept-Language"));
        System.out.println("exchange.getIn().getHeaders().toString():::"+exchange.getIn().getHeader("Cache-Control"));

        exchange.getOut().setBody("{aaa,aabvcd}");

    }
}
