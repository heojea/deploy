package co.kr.jettyRest.security;

import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by v.jyheo on 2017-12-21.
 */
public class ConstraintSecurityHandlerImpl extends ConstraintSecurityHandler {
    /**
     * 이상하게 외부에서 설정해 놓은 주입한 LoginService 주석처리 하고 무조건 아래의 사용자 정의 인증을 거치도록 바꿧다.
     * 이유는 알수 없지만 중복하여 인스턴스를 주입시키는것으로 보인다.
     * @return
     * @throws Exception
     */
    @Override
    protected LoginService findLoginService() throws Exception {
        LoginService service = new HardcodedLoginService();
        return service;
    }
}
