package org.apache.sling.graalvm.osgi;

import org.apache.sling.graalvm.sling.MockResourceProvider;
import org.apache.sling.testing.mock.osgi.junit5.OsgiContext;

public class SlingContext {
    private static OsgiContext context;
    
    public static OsgiContext get() {
        if(context != null) {
            return context;
        }

        synchronized(SlingContext.class) {
            context = initialize();
        }

        return context;
    }

    private static OsgiContext initialize() {
        final OsgiContext result = new OsgiContext();
        result.registerInjectActivateService(new MockResourceProvider());
        return result;
    }
}