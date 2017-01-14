package com.kftc.카멜네티테스트케이스;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.TestCase;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.kr.handler.client.ClientInBoundHandHandler;

public class TestClass extends TestCase 
{ 
    
    public final static Logger LOG = LoggerFactory.getLogger(TestClass.class);
    public final static CamelContext serverContext = new DefaultCamelContext(); 

    public final CamelContext clientContext = new DefaultCamelContext(); 
    public final AtomicInteger responseCounter = new AtomicInteger(0); 
    public final AtomicBoolean passedTen = new AtomicBoolean(false); 

    public  Boolean disconnectClient = true; 

    /*
    @Before 
    public void createClient() throws Exception 
    { 
        clientContext.addRoutes(new RouteBuilder() 
        { 
            @Override 
            public void configure() throws Exception 
            { 
                // Generate an Echo message and ensure a Response is sent 
                from("timer://echoTimer?delay=1s&fixedRate=true&period=1s") 
                        .setExchangePattern(ExchangePattern.InOut) 
                        .transform() 
                        .constant(2) 
                        .to(ExchangePattern.InOut, "netty:tcp://localhost:9000?allowDefaultCodec=true&tcpNoDelay=true&reuseAddress=true&keepAlive=false&sync=true&disconnect=" + disconnectClient.toString()) 
                        .process(new Processor() 
                        { 
                            @Override 
                            public void process(Exchange exchange) throws Exception 
                            { 
                                Object body = exchange.getIn().getBody(); 
                                logger.info("Response number {} : Value = {}", 
                                        responseCounter.incrementAndGet(), body); 

                                if (responseCounter.get() > 10) { 
                                    passedTen.set(true); 
                                } 
                            } 

                        }).stop(); 
            } 
        }); 
    } 
*/
    @Test 
    public void test() throws Exception 
    {
    	
    	//서버 시작
    	 serverContext.addRoutes(new RouteBuilder() 
         { 
             @Override 
             public void configure() throws Exception 
             { 
                 from("netty4:tcp://localhost:9000?sync=true&disconnectOnNoReply=false&allowDefaultCodec=true&tcpNoDelay=true&reuseAddress=true&keepAlive=false") 
                         .setExchangePattern(ExchangePattern.InOut) 
                         .process(new Processor() { 

                             @Override 
                             public void process(Exchange exchange) throws Exception 
                             { 
                                 Object body = exchange.getIn().getBody(); 
                                 LOG.debug("Request received : Value = {}", body); 
                             } 
                             
                         }) 
                         .transform(constant(3)).stop(); 
             } 
         }); 

         serverContext.start(); 
    	
    	
    
        clientContext.getShutdownStrategy().setTimeout(1); 

        clientContext.addRoutes(new RouteBuilder() 
        { 
            @Override 
            public void configure() throws Exception 
            { 
                // Generate an Echo message and ensure a Response is sent 
                from("timer://echoTimer?delay=1s&fixedRate=true&period=1s") 
                        .setExchangePattern(ExchangePattern.InOut) 
                        .transform() 
                        .constant(2) 
                        .to(ExchangePattern.InOut, "netty4:tcp://localhost:9000?allowDefaultCodec=true&tcpNoDelay=true&reuseAddress=true&keepAlive=false&sync=true&disconnect=" + disconnectClient.toString()) 
                        .process(new Processor() 
                        { 
                            @Override 
                            public void process(Exchange exchange) throws Exception 
                            { 
                                Object body = exchange.getIn().getBody(); 
                                LOG.debug("Response number {} : Value = {}", 
                                        responseCounter.incrementAndGet(), body); 

                                if (responseCounter.get() > 10) { 
                                    passedTen.set(true); 
                                } 
                            } 

                        }).stop(); 
            } 
        }); 
        
        clientContext.start(); 

        LOG.debug("Disconnect = {}", this.disconnectClient); 

        //Thread.sleep(TimeUnit.SECONDS.toMillis(15)); 

        //clientContext.stop(); 

        assertTrue("More than 10 responses have been received", passedTen.get());
    } 
} 