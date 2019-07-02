package org.apache.sling.graalvm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.sling.testing.mock.osgi.junit5.OsgiContext;

import io.quarkus.runtime.annotations.RegisterForReflection;

@Path("/sling")
@Produces(MediaType.APPLICATION_JSON)
public class SlingResource {

    @RegisterForReflection
    public static class ResponseData {
        private final String msg;

        ResponseData(String msg) {
            this.msg = msg;
        }
        public String getMessage() { return msg; }
    }

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
    public Response sling() {
        return Response.ok(new ResponseData(getMessage())).build();
    }
}