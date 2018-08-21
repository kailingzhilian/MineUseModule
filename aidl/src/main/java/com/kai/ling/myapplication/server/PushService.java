package com.kai.ling.myapplication.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.kai.ling.myapplication.server.MyServer;

public class PushService extends Service {

    private MyServer myServer=new MyServer();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myServer;
    }
}

