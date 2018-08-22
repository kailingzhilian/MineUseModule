package com.kai.ling.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by kai.wang
 * on 2018/8/22 0022.
 */

public class SumService extends Service {

    private MyServer myServer = new MyServer();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myServer;
    }
}
