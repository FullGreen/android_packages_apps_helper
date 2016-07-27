package com.fullgreen.flarerom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.net.Uri;

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
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fullgreen.rf.gd/bug_report"));
        startActivity(intent);
    }

    public void burn(View v) {
        Intent intent_01 = new Intent(getApplicationContext(), burnActivity.class);
        startActivity(intent_01);
    }

    public void app(View v) {
        Intent intent_01 = new Intent(getApplicationContext(), InformationActivity.class);
        startActivity(intent_01);
    }

}
