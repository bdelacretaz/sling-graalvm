package org.apache.sling.graalvm.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.sling.graalvm.osgi.SlingContext;
import org.apache.sling.graalvm.sling.MockResource;
import org.apache.sling.spi.resource.provider.ResourceProvider;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.engine.SlingRequestProcessor;

@Path("/sling/{resourcePath: [^/][a-zA-Z/_0-9\\.]*}")
@Produces(MediaType.APPLICATION_JSON)
public class SlingResource {

    @GET
    public Response sling(@PathParam("resourcePath") String resourcePath) {
        final SlingRequestProcessor p = SlingContext.get().getService(SlingRequestProcessor.class);
        assert(p != null);
        final ResourceProvider<MockResource> rp = SlingContext.get().getService(ResourceProvider.class);
        final Resource r = rp.getResource(null, resourcePath, null, null);
        return Response.ok(r).build();
    }
}