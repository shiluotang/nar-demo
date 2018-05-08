package org.sqg;

public interface HelloEngine extends AutoCloseable {

    String greetings(String name);

    void println();

    /**
     * {@inheritDoc}
     */
    @Override
    void close();
}
