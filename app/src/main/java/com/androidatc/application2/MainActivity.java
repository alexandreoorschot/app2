package com.androidatc.application2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    Button button;
    TextView msg;
    int error = 0;
    public static final int requestCode_intent = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (TextView) findViewById(R.id.app1view);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.setAction("Android.ATC.example.Application1");
                in.addCategory("android.intent.category.DEFAULT");
                try {
                    startActivityForResult(in, requestCode_intent);
                } catch (Exception e) {
                    msg.append("\n" + e.getMessage() + "\n");
                    Toast.makeText(MainActivity.this, "Permission Not Declared error!", Toast.LENGTH_LONG).show();
                    error = 1;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCode_intent && error == 0) {
            msg.append("\n You opened Application 1 Activity \n");
            Toast.makeText(this, "You opened Application 1 Activity", Toast.LENGTH_LONG).show();
            error = 0;
        } else {
            /* exception will handle this */
        }
    }
}