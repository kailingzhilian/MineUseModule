package com.kai.ling.server;

import android.os.RemoteException;
import android.util.Log;

public class MyServer extends IMyAidlInterface.Stub {
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public int sum(int num1, int num2) throws RemoteException {
        Log.i("MultipleAppAIDL", "num1=" + num1 + "   num2=" + num2);
        return num1 + num2;
    }
}