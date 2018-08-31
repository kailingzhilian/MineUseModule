package com.kai.ling.ipccase;

import android.view.View;

import com.kai.ling.ipccase.messager.MessagerClientActivity;
import com.kai.ling.ipccase.systemservice.SystemServiceActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.system_service).setOnClickListener(this);
        findViewById(R.id.messager).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.system_service:
                SystemServiceActivity.show(this);
                break;
            case R.id.messager:
                MessagerClientActivity.show(this);
                break;
        }
    }
}
