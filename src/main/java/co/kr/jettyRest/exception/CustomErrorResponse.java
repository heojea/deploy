package co.kr.jettyRest.exception;

import org.apache.camel.Exchange;

/**
 * Created by v.jyheo on 2017-12-19.
 */
public  class CustomErrorResponse {
    /**
     * 사용자정의 에러 response 정의
     * @param exchange : setting 될 exchange
     * @param msg      : error message
     * @param contentType : text/plain
     * @param errorCode   : 501 , 502
     */
    public static void setErrorResponse(Exchange exchange ,String msg ,String contentType ,int errorCode ){
        //사용자 정의 return error 기술
        exchange.getOut().setBody(msg);  //"ERROR 501 : RESON CUSTOM Exception!!
        exchange.getOut().setHeader(Exchange.CONTENT_TYPE, contentType); //"text/plain"
        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, errorCode);
    }
}
