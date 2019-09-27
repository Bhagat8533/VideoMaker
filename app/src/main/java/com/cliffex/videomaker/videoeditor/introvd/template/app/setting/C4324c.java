package com.introvd.template.app.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.XZip;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.router.user.UserServiceProxy;
import com.quvideo.rescue.C4905b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.setting.c */
public class C4324c {
    /* renamed from: K */
    private static String m10846K(Context context, int i) {
        String dV = C5206b.m14212dV(context);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("OS", "android");
        jsonObject.addProperty("os_version", VERSION.CODENAME);
        jsonObject.addProperty("appkey", dV);
        jsonObject.addProperty("country", AppStateModel.getInstance().getCountryCode());
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        jsonObject.addProperty("filetype", sb.toString());
        return jsonObject.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public static void m10847U(Context context, String str) {
        HashMap hashMap = new HashMap();
        String userId = UserServiceProxy.getUserId();
        String dz = C4580b.m11653dz(context);
        String countryCode = AppStateModel.getInstance().getCountryCode();
        hashMap.put("url", str);
        hashMap.put("auid", userId);
        hashMap.put("duid", dz);
        hashMap.put("country", countryCode);
        UserBehaviorLog.onKVEvent(context, "dev_user_crashlog_upload_info", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m10849c(Context context, int i, String str) {
        if (i == 9) {
            C3727b.m9077A(m10851d(context, i, str));
            C4905b.m12538Fd();
        }
    }

    /* renamed from: cH */
    public static void m10850cH(final Context context) {
        C1834l.m5254a((C1839n<T>) new C1839n<String>() {
            /* renamed from: a */
            public void mo10177a(C1838m<String> mVar) throws Exception {
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
                StringBuilder sb = new StringBuilder();
                sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                sb.append(File.separator);
                sb.append(format);
                sb.append("_");
                sb.append("logger");
                sb.append(".zip");
                String sb2 = sb.toString();
                if (FileUtils.isFileExisted(sb2)) {
                    FileUtils.deleteFile(sb2);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                sb3.append(File.separator);
                sb3.append("logger");
                String sb4 = sb3.toString();
                ArrayList arrayList = new ArrayList();
                File file = new File(sb4);
                if (!file.exists() || !file.isDirectory()) {
                    mVar.mo9791K("");
                    return;
                }
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    mVar.mo9791K("");
                    return;
                }
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        arrayList.add(file2.getAbsolutePath());
                    }
                }
                XZip.zipFiles(sb2, (String[]) arrayList.toArray(new String[arrayList.size()]));
                mVar.mo9791K(sb2);
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10168g((C1517e<? super T>) new C1517e<String>() {
            /* renamed from: dn */
            public void accept(final String str) throws Exception {
                if (!TextUtils.isEmpty(str)) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("file_upload_suc");
                    intentFilter.addAction("file_upload_fail");
                    LocalBroadcastManager.getInstance(context.getApplicationContext()).registerReceiver(new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            if (intent.getAction() == "file_upload_suc") {
                                String stringExtra = intent.getStringExtra("param_url");
                                C4324c.m10849c(context, intent.getIntExtra("param_type", 0), stringExtra);
                                C4324c.m10847U(context, stringExtra);
                                StringBuilder sb = new StringBuilder();
                                sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                                sb.append(File.separator);
                                sb.append("logger");
                                FileUtils.deleteDirectory(sb.toString());
                                if (FileUtils.isFileExisted(str)) {
                                    FileUtils.deleteFile(str);
                                }
                            }
                            LocalBroadcastManager.getInstance(context.getApplicationContext()).unregisterReceiver(this);
                        }
                    }, intentFilter);
                    String str2 = context.getApplicationInfo().packageName;
                    StringBuilder sb = new StringBuilder();
                    sb.append(Environment.getExternalStorageDirectory().getPath());
                    sb.append("/Android/data/");
                    sb.append(str2);
                    sb.append("/cache/");
                    C8346e.m24074c(context.getApplicationContext(), str, 9, sb.toString());
                }
            }
        });
    }

    /* renamed from: d */
    private static Map<String, String> m10851d(Context context, int i, String str) {
        String userId = UserServiceProxy.getUserId();
        String dz = C4580b.m11653dz(context);
        HashMap hashMap = new HashMap();
        hashMap.put(C5878a.TAG, str);
        String str2 = C7234b.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        hashMap.put(str2, sb.toString());
        hashMap.put("c", m10846K(context, i));
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("auid", userId);
        }
        if (!TextUtils.isEmpty(dz)) {
            hashMap.put("duid", dz);
        }
        return hashMap;
    }
}
