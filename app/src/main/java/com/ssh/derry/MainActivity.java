package com.ssh.derry;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Anthony" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        // 点击事件
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e(TAG,"OnClick:");
//            }
//        });

        // 长按事件
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.e(TAG,"onLongClick:");
                return false;// 若为true，表示事件被onTouch消费，onClick将不会执行。
            }
        });

        // 触摸事件
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) { // 由Android系统代码执行。
                Log.e(TAG,"onTouch:" + event.getAction());
                return false; // 若为true，表示事件被onTouch消费，onLongClick、onClick将不会执行。
            }
        });
    }

    public void AnthonyClick(View view) {
        Log.e(TAG,"OnClick:");
    }
}