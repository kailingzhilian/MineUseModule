package com.kai.ling.optimizations.server;

import android.os.RemoteException;
import android.util.Log;

import com.kai.ling.optimizations.IMyAidlInterface;
import com.kai.ling.optimizations.MessageData;

public class MyServer extends IMyAidlInterface.Stub {

    private static final String TAG = "GEBILAOLITOU";


    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public void connect() throws RemoteException {
        Log.i(TAG, "connect");
    }

    @Override
    public void sendMessage(MessageData message) throws RemoteException {
        Log.i(TAG, "MyServer ** sendInMessage **" + message.toString());
    }

}
