package org.sqg;

import org.sqg.spi.HelloEngineProvider;

public class NativeHelloEngineProvider extends HelloEngineProvider {

    @Override
    public String getVendorName() {
        return "NATIVE";
    }

    @Override
    public HelloEngine newEngine() {
        return new NativeHelloEngine();
    }
}
