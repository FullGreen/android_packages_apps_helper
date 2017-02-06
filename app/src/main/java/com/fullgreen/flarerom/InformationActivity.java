package com.fullgreen.flarerom;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import android.content.Context;

import android.telephony.TelephonyManager;

import static com.fullgreen.flarerom.R.id.product_platform;

public class InformationActivity extends AppCompatActivity {
    private static String LOG_TAG = MainActivity.class.getName();

    public static Map<String, String> getWiftMac() {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Scanner s = new Scanner(new File("/sys/class/net/wlan0/address"));
            while (s.hasNextLine()) {
                String[] vals = s.nextLine().split(": ");
                if (vals.length > 1) map.put(vals[0].trim(), vals[1].trim());
            }
        } catch (Exception e) {Log.e("getCpuInfoMap",Log.getStackTraceString(e));}
        return map;
    }

    public static Map<String, String> getWifiModule() {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Scanner s = new Scanner(new File("/data/.cid.info"));
            while (s.hasNextLine()) {
                String[] vals = s.nextLine().split(": ");
                if (vals.length > 1) map.put(vals[0].trim(), vals[1].trim());
            }
        } catch (Exception e) {Log.e("getWifiModule",Log.getStackTraceString(e));}
        return map;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        String model = getProp("ro.product.model");
        String device = getProp("ro.fullgreen.device");
        String kernel = getProp("ro.fullgreen.kernel");
        String wifi = getProp("ro.fullgreen.wifi");
        String rom = getProp("ro.fullgreen.rom");
        String manufacturer = Build.MANUFACTURER;
        String codename = Build.VERSION.CODENAME;
        String abi = Build.CPU_ABI;
        String abi2 = Build.CPU_ABI2;
        String bootloader = Build.BOOTLOADER;
        String display = Build.DISPLAY;
        String name = getProp("ro.product.name");
        String hardware = getProp("ro.hardware");
        String bbootloader = getProp("ro.bootloader");
        String babi2 = getProp("ro.product.cpu.abi2");
        String buildid = getProp("ro.build.id");
        String sdk = getProp("ro.build.version.sdk");
        String release = getProp("ro.build.version.release");
        String security_patch = getProp("ro.build.version.security_patch");
        String date = getProp("ro.build.date");
        String type = getProp("ro.build.type");
        String user = getProp("ro.build.user");
        String host = getProp("ro.build.host");
        String flavor = getProp("ro.build.flavor");
        String board = getProp("ro.product.board");
        String platform = getProp("ro.board.platform");
        WifiManager mng = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo info = mng.getConnectionInfo();
        String wifimac = info.getMacAddress();

        String loadPath = "/storage/emulated/0/.cid.info";
            try {
                FileInputStream fis = new FileInputStream(loadPath);
                BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fis));
                String ccontent="", temp="";
                while( (temp = bufferReader.readLine()) != null ) {
                    ccontent += temp;
                }
                Log.i(LOG_TAG,""+ccontent);
            } catch (Exception e) {
                Log.i(LOG_TAG,"error");
            }

        Log.d("mac", getWiftMac().toString());
        Log.d("module", getWifiModule().toString());

        TextView product_model = (TextView) findViewById(R.id.product_model);
        product_model.setText("model :" + manufacturer + " " + model);

        TextView product_bootloader = (TextView) findViewById(R.id.product_bootloader);
        product_bootloader.setText("bootloader :" + bootloader);

        TextView product_display = (TextView) findViewById(R.id.product_display);
        product_display.setText("display :" + display);

        TextView product_hardware = (TextView) findViewById(R.id.product_hardware);
        product_hardware.setText("hardware :" + hardware);

        TextView product_buildid = (TextView) findViewById(R.id.product_buildid);
        product_buildid.setText("Build id :" + buildid);

        TextView product_sdk = (TextView) findViewById(R.id.product_sdk);
        product_sdk.setText("Build sdk :" + sdk);

        TextView product_release = (TextView) findViewById(R.id.product_release);
        product_release.setText("Android version :" + release);

        TextView product_security_patch = (TextView) findViewById(R.id.product_security_patch);
        product_security_patch.setText("security patch :" + security_patch);

        TextView product_date = (TextView) findViewById(R.id.product_date);
        product_date.setText("Build date :" + date);

        TextView product_user = (TextView) findViewById(R.id.product_user);
        product_user.setText("Build user :" + user + "(" + host + ")" );

        TextView product_platform = (TextView) findViewById(R.id.product_platform);
        product_platform.setText("Board platform :" + platform);

        TextView product_wifimac = (TextView) findViewById(R.id.product_wifimac);
        product_wifimac.setText("Wifi mac address :" + getWiftMac());

        TextView product_wifimoudle = (TextView) findViewById(R.id.product_wifimoudle);
        product_wifimoudle.setText("Wifi module :" + getWifiModule());

    }

    public static String getProp(String prop) {
        try {
            Process process = Runtime.getRuntime().exec("getprop " + prop);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }
            return log.toString();
        } catch (IOException e) {
            // Runtime error
        }
        return null;
    }

}
