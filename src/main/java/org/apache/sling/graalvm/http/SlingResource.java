package org.apache.sling.graalvm.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.sling.graalvm.osgi.SlingContext;
import org.apache.sling.graalvm.sling.MockResource;
import org.apache.sling.spi.resource.provider.ResourceProvider;
import org.apache.sling.api.resource.Resource;

@Path("/sling")
@Produces(MediaType.APPLICATION_JSON)
public class SlingResource {

    @GET
    public Response sling() {
        final ResourceProvider<MockResource> rp = SlingContext.get().getService(ResourceProvider.class);
        final Resource r = rp.getResource(null, "/sling", null, null);
        return Response.ok(r).build();
    }
}