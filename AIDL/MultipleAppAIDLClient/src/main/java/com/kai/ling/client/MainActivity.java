package com.kai.ling.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kai.ling.server.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    private IMyAidlInterface iMyAidlInterface;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("MultipleAppAIDL", "service connected");
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("MultipleAppAIDL", "service disconnected");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText num1 = findViewById(R.id.num1);
        final EditText num2 = findViewById(R.id.num2);

        findViewById(R.id.connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.kai.ling.aidl");
                intent.setPackage("com.kai.ling.server");
                bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.sum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(num1.getText().toString().trim());
                int y = Integer.parseInt(num2.getText().toString().trim());

                try {
                    int sum = iMyAidlInterface.sum(x, y);
                    Toast.makeText(MainActivity.this, "" + sum, Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
