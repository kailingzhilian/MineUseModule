package com.kai.ling.ipccase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kai.wang
 * on 2018/8/23 0023.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initData();
        initView();
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected void initData() {
    }

}
