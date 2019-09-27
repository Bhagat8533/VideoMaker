package com.introvd.template.app.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.multidex.C0513a;
import com.introvd.template.R;
import com.introvd.template.app.C4387t;
import com.introvd.template.common.LogUtils;

public class LoadResActivity extends Activity {
    private static ProgressDialog bjf;
    /* access modifiers changed from: private */
    public C3700a bje;

    /* renamed from: com.introvd.template.app.activity.LoadResActivity$a */
    class C3700a extends BroadcastReceiver {
        C3700a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.introvd.template.finish.Loading".equals(intent.getAction())) {
                LoadResActivity.this.unregisterReceiver(LoadResActivity.this.bje);
                LogUtils.m14221d("loadDex", "get install finish");
                LoadResActivity.this.finish();
                LogUtils.m14221d("loadDex", "finish activity");
                System.exit(0);
            }
        }
    }

    /* renamed from: com.introvd.template.app.activity.LoadResActivity$b */
    class C3701b extends AsyncTask {
        C3701b() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object[] objArr) {
            try {
                C0513a.m1814i(LoadResActivity.this.getApplication());
                LogUtils.m14221d("loadDex", "install finish");
                C4387t.m11049bJ(LoadResActivity.this.getApplication());
            } catch (Exception e) {
                LogUtils.m14222e("loadDex", e.getLocalizedMessage());
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Object obj) {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            LogUtils.m14221d("loadDex", "install start");
            super.onPreExecute();
        }
    }

    /* renamed from: B */
    public static void m9000B(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            bjf = new ProgressDialog(activity);
            bjf.setMessage(activity.getResources().getString(R.string.xiaoying_str_com_loading));
            bjf.setProgressStyle(0);
            bjf.setIndeterminate(false);
            bjf.setCancelable(false);
            bjf.setCanceledOnTouchOutside(false);
            bjf.show();
        }
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.load_res_layout);
        this.bje = new C3700a();
        registerReceiver(this.bje, new IntentFilter("com.introvd.template.finish.Loading"));
        new C3701b().execute(new Object[0]);
        m9000B(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (isFinishing() && bjf != null) {
            bjf.dismiss();
            bjf = null;
        }
    }
}
