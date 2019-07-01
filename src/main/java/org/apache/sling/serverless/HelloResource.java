package org.apache.sling.serverless;

import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.sling.testing.mock.osgi.junit5.OsgiContext;

@Path("/hello")
public class HelloResource {

    private String getMessage() {
        // Yes this is funky, the goal is to verify that
        // the Sling OSGi mocks context works in a
        // native executable
        final OsgiContext ctx = new OsgiContext();
        ctx.registerInjectActivateService(new MsgProviderImpl("Hello"));
        final MsgProvider svc = ctx.getService(MsgProvider.class);
        return svc.getMsg();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        final String msg = getMessage();
        return msg;
    }
}