package com.kai.ling.ipccase.messager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.widget.TextView;

import com.kai.ling.ipccase.BaseActivity;
import com.kai.ling.ipccase.R;

import java.lang.ref.WeakReference;

/**
 * Created by kai.wang
 * on 2018/8/30 0030.
 */

public class MessagerClientActivity extends BaseActivity {


    public static void show(Activity activity) {
        Intent intent = new Intent(activity, MessagerClientActivity.class);
        activity.startActivity(intent);
    }

    private Messenger serverMessager;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serverMessager = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    private Messenger mGetReplyMessenger = new Messenger(new MessengerClientHandler(this));

    private static class MessengerClientHandler extends Handler {

        private WeakReference<MessagerClientActivity> messagerClientActivityWeakReference;

        private MessengerClientHandler(MessagerClientActivity messagerClientActivity) {
            messagerClientActivityWeakReference = new WeakReference<MessagerClientActivity>(messagerClientActivity);
        }

        @Override
        public void handleMessage(Message msg) {


            switch (msg.what) {
                case Constants.SERVER_MESSAGE:
                    MessagerClientActivity activity = messagerClientActivityWeakReference.get();
                    if (activity != null) {
                        activity.handleMessage(msg);
                    }
                    break;
            }

        }

    }

    private void handleMessage(Message msg) {
        content.setText("收到 服务端的消息，消息内容是" + msg.getData().getString(Constants.REPLY_KEY));
    }

    private TextView content;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_messager_client;
    }

    @Override
    protected void initView() {

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
        content = findViewById(R.id.content);
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = new Intent(this, MessagerService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        unbindService(connection);
        super.onDestroy();
    }

    private void sendMessage() {
        if (serverMessager == null) {
            return;
        }

        //创建一个what值为Constants.CLENT_MESSAGE的message
        Message message = Message.obtain(null, Constants.CLENT_MESSAGE);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY, "我是来自客户端的信息");
        message.setData(bundle);

        //新增，这是重点
        message.replyTo = mGetReplyMessenger;
        try {
            serverMessager.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
