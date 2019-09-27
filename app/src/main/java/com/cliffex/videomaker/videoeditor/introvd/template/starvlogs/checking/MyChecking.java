package com.introvd.template.starvlogs.checking;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.starvlogs.ToolsUtils;

public class MyChecking extends Activity {

    private class GetNetWork extends AsyncTask<Void, Void, Void> {
        private GetNetWork() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0091 A[SYNTHETIC, Splitter:B:34:0x0091] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Void... r16) {
            /*
                r15 = this;
                java.lang.String r8 = "http://ip-api.com/json"
                r11 = 0
                r0 = 0
                java.lang.String r12 = "TAGGGGGGGG"
                java.lang.String r13 = "Response from url1: vvv"
                android.util.Log.e(r12, r13)
                java.net.URL r10 = new java.net.URL     // Catch:{ Exception -> 0x00a6 }
                r10.<init>(r8)     // Catch:{ Exception -> 0x00a6 }
                java.net.URLConnection r11 = r10.openConnection()     // Catch:{ Exception -> 0x00a6 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00a6 }
                java.io.InputStreamReader r12 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00a6 }
                java.io.InputStream r13 = r11.getInputStream()     // Catch:{ Exception -> 0x00a6 }
                r12.<init>(r13)     // Catch:{ Exception -> 0x00a6 }
                r1.<init>(r12)     // Catch:{ Exception -> 0x00a6 }
                java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                r9.<init>()     // Catch:{ Exception -> 0x0031, all -> 0x008d }
            L_0x0027:
                java.lang.String r7 = r1.readLine()     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                if (r7 == 0) goto L_0x0041
                r9.append(r7)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                goto L_0x0027
            L_0x0031:
                r4 = move-exception
                r0 = r1
            L_0x0033:
                java.lang.String r12 = "TAGGGGGGGG"
                java.lang.String r13 = "yourDataTask"
                android.util.Log.e(r12, r13, r4)     // Catch:{ all -> 0x00a4 }
                r12 = 0
                if (r0 == 0) goto L_0x0040
                r0.close()     // Catch:{ IOException -> 0x009a }
            L_0x0040:
                return r12
            L_0x0041:
                java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                if (r6 == 0) goto L_0x007f
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                java.lang.String r12 = "countryCode"
                java.lang.String r2 = r5.getString(r12)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                java.lang.String r12 = "TAGGGGGGGG"
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                r13.<init>()     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                java.lang.String r14 = "Response from url2: "
                java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                java.lang.StringBuilder r13 = r13.append(r2)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                android.util.Log.e(r12, r13)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                java.lang.String r12 = "tw"
                boolean r12 = r2.equals(r12)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                if (r12 != 0) goto L_0x007a
                java.lang.String r12 = "cn"
                boolean r12 = r2.equals(r12)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                if (r12 == 0) goto L_0x0087
            L_0x007a:
                com.introvd.template.starvlogs.checking.MyChecking r12 = com.introvd.template.starvlogs.checking.MyChecking.this     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                com.introvd.template.starvlogs.checking.MyChecking.access$100(r12)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
            L_0x007f:
                if (r1 == 0) goto L_0x0084
                r1.close()     // Catch:{ IOException -> 0x0095 }
            L_0x0084:
                r12 = 0
                r0 = r1
                goto L_0x0040
            L_0x0087:
                com.introvd.template.starvlogs.checking.MyChecking r12 = com.introvd.template.starvlogs.checking.MyChecking.this     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                com.introvd.template.starvlogs.checking.MyChecking.access$200(r12)     // Catch:{ Exception -> 0x0031, all -> 0x008d }
                goto L_0x007f
            L_0x008d:
                r12 = move-exception
                r0 = r1
            L_0x008f:
                if (r0 == 0) goto L_0x0094
                r0.close()     // Catch:{ IOException -> 0x009f }
            L_0x0094:
                throw r12
            L_0x0095:
                r3 = move-exception
                r3.printStackTrace()
                goto L_0x0084
            L_0x009a:
                r3 = move-exception
                r3.printStackTrace()
                goto L_0x0040
            L_0x009f:
                r3 = move-exception
                r3.printStackTrace()
                goto L_0x0094
            L_0x00a4:
                r12 = move-exception
                goto L_0x008f
            L_0x00a6:
                r4 = move-exception
                goto L_0x0033
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.starvlogs.checking.MyChecking.GetNetWork.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ToolsUtils.getIdLayout(this, "activity_my_checking"));
        if (!CountryCheck.isCNTW(this)) {
            intentSplash();
        } else {
            intentNewActivity();
        }
    }

    private void intentNewActivity() {
        startActivity(new Intent(this, ErrorActivity.class));
    }

    private void intentSplash() {
        startActivity(new Intent(this, SplashActivity.class));
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService("connectivity");
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
