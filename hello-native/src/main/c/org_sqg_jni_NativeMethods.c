#include "org_sqg_jni_NativeMethods.h"

#include <stdlib.h>
#include <string.h>
#include <stdio.h>

/*
 * Class:     org_sqg_jni_NativeMethods
 * Method:    sayHi
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_sqg_jni_NativeMethods_sayHi(
        JNIEnv *env, jclass clazz, jstring name) {
    char const* const PREFIX = "Hi, ";
    char const* const SUFFIX = "!";
    char const* name_chars = NULL;
    char *result = NULL;
    jstring hi = NULL;
    name_chars = (*env)->GetStringUTFChars(env, name, NULL);
    if (!name_chars)
        return hi;
    result = malloc(strlen(PREFIX) + strlen(name_chars) + strlen(SUFFIX) + 1);
    if (!result) {
        (*env)->ReleaseStringUTFChars(env, name, name_chars);
        return hi;
    }
    memset(result, 0, strlen(PREFIX) + strlen(name_chars) + strlen(SUFFIX) + 1);
    strcat(result, PREFIX);
    strcat(result, name_chars);
    strcat(result, SUFFIX);
    hi = (*env)->NewStringUTF(env, result);
    free(result);
    result = NULL;
    return hi;
}

/*
 * Class:     org_sqg_jni_NativeMethods
 * Method:    printLine
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_sqg_jni_NativeMethods_printLine(
        JNIEnv *env,
        jclass clazz) {
    printf("printLine2\n");
}

