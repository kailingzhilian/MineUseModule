package com.kai.ling.myapplication.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.kai.ling.myapplication.IMyAidlInterface;
import com.kai.ling.myapplication.MessageData;
import com.kai.ling.myapplication.server.PushService;

public class PushManager {

    private static final String TAG = "GEBILAOLITOU";

    private PushManager() {
    }

    private IMyAidlInterface iMyAidlInterface;

    private static PushManager instance = new PushManager();

    //单例
    public static PushManager getInstance() {
        return instance;
    }


    //绑定服务
    public void init(Context context) {
        //定义intent
        Intent intent = new Intent(context, PushService.class);
        //绑定服务
        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //成功连接
            Log.d(TAG, "pushManager ***************成功连接***************");
            //通过asInterface获取
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //断开连接调用
            Log.d(TAG, "pushManager ***************连接已经断开***************");
        }
    };

    //远程调用connect()方法
    public void connect() {
        try {
            Log.d(TAG, "pushManager ***************start Remote***************");
            iMyAidlInterface.connect();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    //远程调用sendMessage()方法
    public void sendMessage(String content) {
        MessageData messageData = new MessageData();
        messageData.content = content;
        try {
            MessageData messageData1 = iMyAidlInterface.sendMessage(messageData);
            Log.d(TAG, "pushManager ***************" + messageData1.content + "***************");
        } catch (RemoteException e) {
            e.printStackTrace();
            Log.d(TAG, "pushManager ***************RemoteException***************");
        }
    }
}