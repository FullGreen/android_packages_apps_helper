package com.fullgreen.flarerom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void quest(View v) {
        Intent intent_01 = new Intent(getApplicationContext(), questActivity.class);
        startActivity(intent_01);
    }

    public void bug(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fullgreen.dothome.co.kr/bugreport"));
        startActivity(intent);
    }

    public void burn(View v) {
        try {
            PackageManager pm = getPackageManager();
            String strAppPackage = "de.andip71.boeffla_config_v2";
            PackageInfo pi = pm.getPackageInfo(strAppPackage,  PackageManager.GET_ACTIVITIES);
            Intent intent = getPackageManager().getLaunchIntentForPackage("de.andip71.boeffla_config_v2");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(getApplicationContext(),R.string.notfound_config, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.boeffla.de/index.php/downloads/boeffla-config-app"));
            startActivity(intent);
        }
    }

    public void app(View v) {
        Intent intent_01 = new Intent(getApplicationContext(), InformationActivity.class);
        startActivity(intent_01);
    }

}
