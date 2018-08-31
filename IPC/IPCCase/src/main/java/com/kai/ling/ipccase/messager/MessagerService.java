package com.kai.ling.ipccase.messager;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by kai.wang
 * on 2018/8/30 0030.
 */

public class MessagerService extends Service {

    private Messenger messenger = new Messenger(new MessaengerHandler());

    private static class MessaengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constants.CLENT_MESSAGE:
                    Log.i("GELAOLITOU", "收到消息：" + msg.getData().get(Constants.KEY));
                    Messenger msgr_client = msg.replyTo;
                    Message mes_reply = Message.obtain(null, Constants.SERVER_MESSAGE);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.REPLY_KEY, "你的信息我已经收到，现在就回复你");
                    mes_reply.setData(bundle);

                    try {
                        msgr_client.send(mes_reply);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }


}
