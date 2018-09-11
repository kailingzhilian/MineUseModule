package com.kai.ling.anr;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.kai.ling.BaseActivity;
import com.kai.ling.R;

/**
 * Created by kai.wang
 * on 2018/9/6 0006.
 */

public class ANRTestActivity extends BaseActivity implements View.OnClickListener {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, ANRTestActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_anr_test;
    }

    @Override
    protected void initView() {
        findViewById(R.id.InputDispatching).setOnClickListener(this);
        findViewById(R.id.service).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.InputDispatching:
                try {
                    Log.e("InputDispatching-start", "time = " + System.currentTimeMillis());
                    Thread.sleep(1000 * 20);
                    Log.e("InputDispatching-end", "time = " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.service:
                Intent intent = new Intent(this, ANRService.class);
                getApplicationContext().startService(intent);
                break;
        }
    }
}
