package org.sqg;

import org.sqg.spi.HelloEngineProvider;

public class JHelloEngineProvider extends HelloEngineProvider {

    @Override
    public String getVendorName() {
        return "JAVA";
    }

    @Override
    public HelloEngine newEngine() {
        return new JHelloEngine();
    }
}
