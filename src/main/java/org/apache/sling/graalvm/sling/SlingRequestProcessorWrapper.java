package org.apache.sling.graalvm.sling;

import org.apache.sling.engine.SlingRequestProcessor;
import org.apache.sling.engine.impl.SlingRequestProcessorImpl;
import org.osgi.service.component.annotations.Component;

@Component(service=SlingRequestProcessor.class)
public class SlingRequestProcessorWrapper extends SlingRequestProcessorImpl {
    public SlingRequestProcessorWrapper() {
        // TODO setup error handler, servlet resolver etc.
    }
}