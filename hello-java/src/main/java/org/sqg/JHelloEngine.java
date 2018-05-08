package org.sqg;

class JHelloEngine implements HelloEngine {

    @Override
    public String greetings(String name) {
        return "Hi, " + name + "!";
    }

    @Override
    public void println() {
        System.out.println();
    }

    @Override
    public void close() {
    }
}
