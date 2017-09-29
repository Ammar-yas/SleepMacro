package com.example.ammaryasser.sleepmacro;

import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button disableWifi = (Button) findViewById(R.id.btn_wifi);
        Button dndmode = (Button) findViewById(R.id.btn_disturb);
        Button bluetooth = (Button) findViewById(R.id.btn_blutooth);
        Button alarm = (Button) findViewById(R.id.btn_alarm);


        // Disable wifi code block
        final WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        disableWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this, "Wifi Disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //dnd mode code block
        final AudioManager am = (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);
        dndmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            }
        });

        //bluetooth code block
        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.disable();
                }
            }
        });

        // set alarm
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_HOUR,20);
                i.putExtra(AlarmClock.EXTRA_MINUTES, 37);
                startActivity(i);
            }
        });

    }


}
