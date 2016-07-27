package com.fullgreen.flarerom;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import android.content.Context;

import android.telephony.TelephonyManager;

public class InformationActivity extends AppCompatActivity {

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

        TextView product_model = (TextView) findViewById(R.id.product_model);
        product_model.setText( "Device :" + model);

        TextView product_device = (TextView) findViewById(R.id.product_device);
        product_device.setText("Device Source :" + device);

        TextView product_kernel = (TextView) findViewById(R.id.product_kernel);
        product_kernel.setText("Kernel Source :" + kernel);

        TextView product_wifi = (TextView) findViewById(R.id.product_wifi);
        product_wifi.setText("Wifi patch :" + wifi);

        TextView product_rom = (TextView) findViewById(R.id.product_rom);
        product_rom.setText("ROM :" + rom);

        TextView product_manufacturer = (TextView) findViewById(R.id.product_manufacturer);
        product_manufacturer.setText("Manufacturer :" + manufacturer);

        TextView product_codename = (TextView) findViewById(R.id.product_codename);
        product_codename.setText("Codename :" + codename);

        TextView product_abi = (TextView) findViewById(R.id.product_abi);
        product_abi.setText("abi :" + abi);

        TextView product_abi2 = (TextView) findViewById(R.id.product_abi2);
        product_abi2.setText("abi2 :" + abi2);

        TextView product_bootloader = (TextView) findViewById(R.id.product_bootloader);
        product_bootloader.setText("bootloader :" + bootloader);

        TextView product_display = (TextView) findViewById(R.id.product_display);
        product_display.setText("display :" + display);

        TextView product_name = (TextView) findViewById(R.id.product_name);
        product_name.setText("name :" + name);

        TextView product_hardware = (TextView) findViewById(R.id.product_hardware);
        product_hardware.setText("hardware :" + hardware);

        TextView product_bbootloader = (TextView) findViewById(R.id.product_bbootloader);
        product_bbootloader.setText("bootloader :" + bbootloader);

        TextView product_babi2 = (TextView) findViewById(R.id.product_babi2);
        product_babi2.setText("abi2 :" + babi2);

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

        TextView product_type = (TextView) findViewById(R.id.product_type);
        product_type.setText("Build type :" + type);

        TextView product_user = (TextView) findViewById(R.id.product_user);
        product_user.setText("Build user :" + user);

        TextView product_host = (TextView) findViewById(R.id.product_host);
        product_host.setText("Build host :" + host);

        TextView product_flavor = (TextView) findViewById(R.id.product_flavor);
        product_flavor.setText("Build flavor :" + flavor);

        TextView product_board = (TextView) findViewById(R.id.product_board);
        product_board.setText("Board :" + board);

        TextView product_platform = (TextView) findViewById(R.id.product_platform);
        product_platform.setText("Board platform :" + platform);

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
