package org.sqg;

import org.junit.Assert;
import org.junit.Test;
import org.sqg.spi.HelloEngineProvider;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() throws Exception {
        try (HelloEngine engine = HelloEngineProvider.provider().newEngine()) {
            Assert.assertEquals("NATIVE", HelloEngineProvider.provider().getVendorName());
            Assert.assertEquals("Hi, abc!", engine.greetings("abc"));
        }
    }
}
