package com.introvd.base.utlisads;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.base.fulrryconfig.ActionAds;
import com.introvd.base.fulrryconfig.RemotesMoreApp;
import funtion.one.App;
import videoeditor.videomaker.slowmotions.starsleap.R;

public class MainActivity extends Activity {
    public static MainActivity mainActivity;

    public static MainActivity returnMainActivity() {
        return mainActivity;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.dimen.abc_action_bar_content_inset_material);
        mainActivity = this;
        RemotesMoreApp.getdataMoreApp(this);
        ActionAds.ActionMoreApps(this);
        BannerAdmob.setupDataBannerAdmob(this);
        NativeAdmob.refreshAd(this);
        ((TextView) findViewById(2131034160)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    public void onBackPressed() {
        clickOnbackPressed(this);
    }

    public void clickOnbackPressed(Activity mActivity) {
        Builder builder = new Builder(mActivity);
        builder.setTitle("Please confirm");
        builder.setMessage("Are you want to exit the app?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        App.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        App.onPause();
    }
}
