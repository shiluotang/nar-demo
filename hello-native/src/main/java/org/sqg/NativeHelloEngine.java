package org.sqg;

import org.sqg.jni.NativeMethods;

public class NativeHelloEngine implements HelloEngine {

    @Override
    public String greetings(String name) {
        return NativeMethods.sayHi(name);
    }

    @Override
    public void println() {
        NativeMethods.printLine();
    }

    @Override
    public void close() {
    }
}
