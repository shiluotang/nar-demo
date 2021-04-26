package org.sqg;

import org.sqg.spi.HelloEngineProvider;

import org.junit.Assert;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() throws Exception {
        try (HelloEngine engine = HelloEngineProvider.provider().newEngine()) {
            Assert.assertEquals("NATIVE", HelloEngineProvider.provider().getVendorName());
            Assert.assertEquals("Hi, Bruce!", engine.greetings("Bruce"));
            engine.println();

            LOGGER.info("{}", HelloEngineProvider.provider().getVendorName());
        }
    }
}
