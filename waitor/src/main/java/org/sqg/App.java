package org.sqg;

import org.sqg.spi.HelloEngineProvider;

public class App {

    public static void main(String[] args) {
        try (HelloEngine engine = HelloEngineProvider.provider().newEngine()) {
            engine.println();
        }
    }
}
