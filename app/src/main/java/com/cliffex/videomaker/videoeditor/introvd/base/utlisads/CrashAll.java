package com.introvd.base.utlisads;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import funtion.one.AdConfig;
import funtion.one.AdsListener;
import funtion.one.App;
import funtion.one.RequestListener;
import funtion.two.VideoASReceiver;
import java.io.PrintStream;

public class CrashAll {
    public static String fb_Id = "1:118074487535:android:d59df0ee9b03ae99";
    public static String fb_Key = "AIzaSyDeFidDimdT4ScSRfQolFOH-KgTMnU3h1g";
    public static String fl_Id = "NHF4JTD2MWPQ7GSK24P2";
    public static ProgressDialog progressDialog;
    public static RelativeLayout relativeLayout;
    public static int team8 = 181;

    public static void intentFromSplashToMain(Activity activity) {
    }

    public static boolean isNetworkConnected(Activity activity) {
        return ((ConnectivityManager) activity.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static void loadAndshow(Activity activity, String param) {
        if (isNetworkConnected(activity)) {
            try {
                relativeLayout = new RelativeLayout(activity);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                relativeLayout.setBackgroundColor(Color.parseColor("#000000"));
                relativeLayout.setVisibility(0);
                relativeLayout.setLayoutParams(layoutParams);
                activity.addContentView(relativeLayout, layoutParams);
                progressDialog = ProgressDialog.show(activity, "", "");
                progressDialog.setCancelable(true);
                progressDialog.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                if (CrashAll.relativeLayout != null) {
                                    CrashAll.relativeLayout.setVisibility(8);
                                    Log.d("CrashAll", "lasprogressDialog. onCancel");
                                }
                            }
                        }, 3000);
                    }
                });
                progressDialog.setOnDismissListener(new OnDismissListener() {
                    public void onDismiss(DialogInterface dialog) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                if (CrashAll.relativeLayout != null) {
                                    CrashAll.relativeLayout.setVisibility(8);
                                    Log.d("CrashAll", "lasprogressDialog. onDimiss");
                                }
                            }
                        }, 3000);
                    }
                });
                AdConfig.loadAndShowAds(param, activity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void init(final Activity activity) {
        try {
            progressDialog = ProgressDialog.show(activity, "", "");
            progressDialog.setCancelable(true);
            VideoASReceiver.start(activity);
            setAdListener(activity);
            App.init(team8, activity, fl_Id, fb_Id, fb_Key, new RequestListener() {
                public void onFinish(int status, String message) {
                    if (CrashAll.isNetworkConnected(activity)) {
                        PrintStream printStream = System.out;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("CrashAll: ");
                        stringBuilder.append(message);
                        printStream.println(stringBuilder.toString());
                        CrashAll.loadAd(activity, "start_app");
                        return;
                    }
                    CrashAll.intentFromSplashToMain(activity);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAdListener(final Activity activity) {
        AdConfig.setAdListener(new AdsListener() {
            public void onDismissed(String s) {
                Log.e("CrashAll", "start_app onDismissed");
                if (s.equalsIgnoreCase("start_app")) {
                    CrashAll.intentFromSplashToMain(activity);
                    return;
                }
                System.out.println("CrashAll: listeneronDismissed");
                try {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            CrashAll.relativeLayout.setVisibility(8);
                            if (CrashAll.progressDialog.isShowing()) {
                                CrashAll.progressDialog.dismiss();
                            }
                        }
                    }, 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onError(String s, String s1) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError : ");
                sb.append(s);
                sb.append("    ");
                sb.append(s1);
                Log.e("CrashAll", sb.toString());
                if (s.equalsIgnoreCase("start_app")) {
                    Log.e("CrashAll", "start_app error");
                    CrashAll.intentFromSplashToMain(activity);
                    return;
                }
                System.out.println("CrashAll: listeneronError");
                try {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            CrashAll.relativeLayout.setVisibility(8);
                            if (CrashAll.progressDialog.isShowing()) {
                                CrashAll.progressDialog.dismiss();
                            }
                        }
                    }, 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onLoaded(String s) {
                StringBuilder sb = new StringBuilder();
                sb.append("onLoaded : ");
                sb.append(s);
                Log.e("CrashAll", sb.toString());
                if (s.equalsIgnoreCase("start_app")) {
                    CrashAll.dimesssDialog();
                    CrashAll.showAd(activity, "start_app");
                    return;
                }
                System.out.println("CrashAll: listeneronLoaded");
                try {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            CrashAll.relativeLayout.setVisibility(8);
                            if (CrashAll.progressDialog.isShowing()) {
                                CrashAll.progressDialog.dismiss();
                            }
                        }
                    }, 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void dimesssDialog() {
        try {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadAd(Activity activity, String param) {
        try {
            AdConfig.loadAds(param, activity);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CrashAll: Exception : ");
            stringBuilder.append(e.getMessage());
            printStream.println(stringBuilder.toString());
        }
    }

    public static void showAd(Activity activity, String param) {
        try {
            AdConfig.showAds(param, activity);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CrashAll: Exception : ");
            stringBuilder.append(e.getMessage());
            printStream.println(stringBuilder.toString());
        }
    }
}
