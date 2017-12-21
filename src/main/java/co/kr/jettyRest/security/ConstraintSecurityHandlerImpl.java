package co.kr.jettyRest.security;

import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.LoginService;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by v.jyheo on 2017-12-21.
 */
public class ConstraintSecurityHandlerImpl extends ConstraintSecurityHandler {

    protected LoginService findLoginService() throws Exception {
        LoginService service = new HardcodedLoginService();
        return service;
    }
}
