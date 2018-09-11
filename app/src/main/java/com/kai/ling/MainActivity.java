package com.kai.ling;

import android.view.View;

import com.kai.ling.anr.ANRTestActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.anr).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.anr:
                ANRTestActivity.show(this);
                break;
        }
    }
}
