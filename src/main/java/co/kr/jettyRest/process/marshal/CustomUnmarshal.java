package co.kr.jettyRest.process.marshal;


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
public class CustomUnmarshal implements DataFormat{
	private ObjectMapper jacksonMapper;
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
        System.out.println("Unmarshal>>>>>>>>>>>");
		return null;
	}
}
