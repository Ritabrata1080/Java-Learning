// Created by Ritabrata

#include <jni.h>
#include <stdio.h>
#include "JNICalls.h"

// Method 1: Print a message
JNIEXPORT void JNICALL Java_JNICalls_printMessage(JNIEnv *env, jobject obj) {
    printf("Hello from JNI printMessage()\n");
}

// Method 2: Add two numbers and return the result
JNIEXPORT jint JNICALL Java_JNICalls_addNumbers(JNIEnv *env, jobject obj, jint a, jint b) {
    return a + b;
}

// Method 3: Return a greeting message
JNIEXPORT jstring JNICALL Java_JNICalls_getGreeting(JNIEnv *env, jobject obj) {
    return (*env)->NewStringUTF(env, "Hello from JNI getGreeting()");
}
