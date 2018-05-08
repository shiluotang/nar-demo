package org.sqg;

import org.sqg.spi.HelloEngineProvider;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        try (HelloEngine engine = HelloEngineProvider.provider().newEngine()) {
            Assert.assertEquals("JAVA", HelloEngineProvider.provider().getVendorName());
            Assert.assertEquals("Hi, abc!", engine.greetings("abc"));
        }
    }
}
