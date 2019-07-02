package org.apache.sling.graalvm.sling;

import org.apache.sling.api.resource.AbstractResource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class MockResource extends AbstractResource {

    private final String path;
    private final ResourceResolver resolver;

    public MockResource(ResourceResolver resolver, String path) {
        this.resolver = resolver;
        this.path = path;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getResourceType() {
        return "FOO/bar";
    }

    @Override
    public String getResourceSuperType() {
        return null;
    }

    @Override
    public ResourceMetadata getResourceMetadata() {
        return null;
    }

    @Override
    public ResourceResolver getResourceResolver() {
        return resolver;
    }
}