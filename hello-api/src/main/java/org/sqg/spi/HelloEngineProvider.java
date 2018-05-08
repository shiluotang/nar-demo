package org.sqg.spi;

import java.util.Properties;
import java.util.ServiceLoader;

import org.sqg.HelloEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HelloEngineProvider {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(HelloEngineProvider.class);

    private static final String PROPERTY_NAME = "hello.engine";

    private static volatile HelloEngineProvider provider;

    public abstract String getVendorName();

    private static HelloEngineProvider fromSettings() {
        Properties[] props = new Properties[] { System.getProperties() };

        HelloEngineProvider loadedProvider = null;
        for (Properties prop : props)
            if ((loadedProvider = fromProperties(prop)) != null)
                return loadedProvider;
        return loadedProvider;
    }

    private static HelloEngineProvider fromProperties(final Properties props) {
        final String providerClassName = props.getProperty(PROPERTY_NAME);
        if (providerClassName != null) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(providerClassName, false,
                        Thread.currentThread().getContextClassLoader());
                if (!HelloEngineProvider.class.isAssignableFrom(clazz)) {
                    LOGGER.info("{} is not a HelloEngineProvider", providerClassName);
                    return null;
                }
                return provider = HelloEngineProvider.class.cast(clazz.newInstance());
            } catch (ClassNotFoundException e) {
                LOGGER.warn("Provider {} not found!", providerClassName);
            } catch (Throwable t) {
                LOGGER.warn(t.getMessage(), t);
            }
        }
        return null;
    }

    private static HelloEngineProvider fromServiceLoader() {
        ServiceLoader<HelloEngineProvider> loader = ServiceLoader
            .load(HelloEngineProvider.class);
        for (HelloEngineProvider provider : loader)
            LOGGER.info("Found HelloEngineProvider {}", provider);
        for (HelloEngineProvider provider : loader)
            return provider;
        LOGGER.info("No HelloEngineProvider found by ServiceLoader.");
        return null;
    }

    public static HelloEngineProvider provider() {
        if (provider != null)
            return provider;
        if (provider == null) {
            synchronized (HelloEngineProvider.class) {
                if (provider == null) {
                    if ((provider = fromSettings()) != null)
                        return provider;
                    if ((provider = fromServiceLoader()) != null)
                        return provider;
                }
            }
        }
        return provider;
    }

    public HelloEngine newEngine() {
        return null;
    }
}
