package org.sqg.jni;

public class NativeMethods {

    static {
        NarSystem.loadLibrary();
    }

    public static native String sayHi(final String name);

    public static native void printLine();
}
