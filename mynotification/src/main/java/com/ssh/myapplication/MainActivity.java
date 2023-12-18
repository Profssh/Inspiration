package com.ssh.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // channelid 为渠道id，需通过NotificationChannel来设置。在这之前需先进行版本判断。

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // importance是重要程度的设置，用NotificationManager类来获取。
            NotificationChannel channel = new NotificationChannel("anthony","Test notification",NotificationManager.IMPORTANCE_HIGH);

            manager.createNotificationChannel(channel);
        }

        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        notification = new NotificationCompat.Builder(this,"anthony")
                .setContentTitle("Official notification")
                .setContentText("Our world is so great,do you want to have a travel?")
                .setSmallIcon(R.drawable.baseline_person_24) // 图片不能带颜色。
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.image)) // 大图标
                .setColor(Color.parseColor("#ff0000"))
                .setContentIntent(pendingIntent) // 点击通知后的跳转意图
                .setAutoCancel(true) // 点击通知后，自动清除。
//                .setWhen() // 设置时间。
                .build();
    }

    public void sendNotification(View view) {
        manager.notify(1,notification);
    }

    public void cancelNotification(View view) {
        manager.cancel(1); // 取消通知。
    }

}