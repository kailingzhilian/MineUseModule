package com.kai.ling.anr;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by kai.wang
 * on 2018/9/6 0006.
 */

public class ANRService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("ANRService-start", "start");

        try {
            Log.e("ANRService-start", "time = " + System.currentTimeMillis());
            for (int i = 1; i < 31; i++) {
                Thread.sleep(1000);
                Log.e("ANRService-run", "time = " + i);
            }

            Log.e("ANRService-end", "time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
