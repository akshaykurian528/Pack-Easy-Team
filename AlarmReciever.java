package com.example.pack_easy;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.example.pack_easy.Constants.MyConstants;

import java.util.Date;

public class AlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent checkListIntent = new Intent(context, CheckList.class);
        checkListIntent.putExtra(MyConstants.HEADER_SMALL, MyConstants.MY_SELECTIONS);
        checkListIntent.putExtra(MyConstants.SHOW_SMALL, MyConstants.FALSE_STRING);


        checkListIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);


        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, checkListIntent, 0);


        String notificationContent = "Click Here To View Your List";

        Intent serviceIntent = new Intent(context, AlarmSoundService.class);
        context.startService(serviceIntent);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "foxandroid")
                .setSmallIcon(R.drawable.r_ic)
                .setContentTitle("Have You Packed Yet ?")
                .setContentText(notificationContent)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(123, builder.build());
    }
}
