package com.kai.ling.myapplication.server;

import android.os.RemoteException;
import android.util.Log;

import com.kai.ling.myapplication.IMyAidlInterface;
import com.kai.ling.myapplication.MessageData;

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
    public MessageData sendMessage(MessageData message) throws RemoteException {
        Log.i(TAG, "MyServer ** sendInMessage **" + message.toString());
        message.content = "更改了";
        return message;
    }

}
