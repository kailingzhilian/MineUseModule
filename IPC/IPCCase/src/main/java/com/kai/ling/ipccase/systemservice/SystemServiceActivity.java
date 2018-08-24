package com.kai.ling.ipccase.systemservice;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.kai.ling.ipccase.BaseActivity;
import com.kai.ling.ipccase.R;

/**
 * Created by kai.wang
 * on 2018/8/23 0023.
 */

public class SystemServiceActivity extends BaseActivity implements View.OnClickListener {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, SystemServiceActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_system_service;
    }

    @Override
    protected void initView() {
        findViewById(R.id.notification).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notification:
                SystemServiceUtils.getInstance().showNotification(this);
                break;
        }
    }
}
