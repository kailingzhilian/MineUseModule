// IMyAidlInterface.aidl
package com.kai.ling.myapplication;
// Declare any non-default types here with import statements
import com.kai.ling.myapplication.MessageData;

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void connect();

    void sendMessage(inout MessageData message);
}
