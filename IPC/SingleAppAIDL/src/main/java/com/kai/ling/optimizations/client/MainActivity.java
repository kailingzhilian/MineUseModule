package com.kai.ling.optimizations.client;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kai.ling.optimizations.R;

public class MainActivity extends AppCompatActivity {

    private boolean isConnected;
    private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        PushManager.getInstance().init(this);

        content = findViewById(R.id.content);

        findViewById(R.id.connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PushManager.getInstance().connect();
                isConnected = true;
            }
        });

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isConnected) {
                    Toast.makeText(MainActivity.this, "请连接", Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(content.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "请输入", Toast.LENGTH_LONG).show();
                }
                PushManager.getInstance().sendMessage(content.getText().toString().trim());
            }
        });
    }
}
