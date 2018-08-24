package com.kai.ling.ipccase.systemservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.PowerManager;

import com.kai.ling.ipccase.R;

/**
 * Created by kai.wang
 * on 2018/8/23 0023.
 */

class SystemServiceUtils {

    private final static int GRAY_SERVICE_ID = -1002;
    // 电源管理-锁屏仍运行
    private PowerManager.WakeLock wakeLock = null;


    private static SystemServiceUtils sInstance = new SystemServiceUtils();

    public static SystemServiceUtils getInstance() {
        return sInstance;
    }

    private SystemServiceUtils() {
    }

    public void showNotification(Context context) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        //这里启动一个后台notification，前台运行
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String id = "ipc";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel mChannel = new NotificationChannel(id, "ipc", importance);
            mNotificationManager.createNotificationChannel(mChannel);
            Notification notification = new Notification.Builder(context, id)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("IPC")
                    .setContentText("IPC通知")
                    .setAutoCancel(false)
                    .build();
            mNotificationManager.notify(GRAY_SERVICE_ID, notification);
//            startForeground(GRAY_SERVICE_ID, notification);
        } else {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle("IPC")
                    //设置内容
                    .setContentText("IPC通知")
                    //设置小图标
                    .setSmallIcon(R.mipmap.ic_launcher)
                    //设置通知时间
                    .setWhen(System.currentTimeMillis())
                    //首次进入时显示效果
                    .setTicker("IPC通知--------------")
                    //设置通知方式，声音，震动，呼吸灯等效果，这里通知方式为声音
                    .setDefaults(Notification.DEFAULT_SOUND);
            mNotificationManager.notify(GRAY_SERVICE_ID, builder.build());
        }
    }

}
