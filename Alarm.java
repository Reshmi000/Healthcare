package com.example.healthcare;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver{
    @Override
    public void onReceive (Context Context, Intent intent)
    {
        MediaPlayer mp=MediaPlayer.create(Context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mp.start();
        Toast.makeText(Context, "Wakeup", Toast.LENGTH_LONG).show();
    }

}
