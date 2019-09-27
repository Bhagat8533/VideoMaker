package com.introvd.template.app.test;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FileUtils;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestService extends Service {
    private String bEP = "";

    /* renamed from: eh */
    private Resources m11051eh(String str) {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
            try {
                assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            assetManager = null;
            e.printStackTrace();
            Resources resources = getResources();
            resources.getDisplayMetrics();
            resources.getConfiguration();
            Resources resources2 = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            resources2.newTheme().setTo(getTheme());
            return resources2;
        }
        Resources resources3 = getResources();
        resources3.getDisplayMetrics();
        resources3.getConfiguration();
        Resources resources22 = new Resources(assetManager, resources3.getDisplayMetrics(), resources3.getConfiguration());
        resources22.newTheme().setTo(getTheme());
        return resources22;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|(4:5|6|7|(4:9|(1:11)|55|12)(1:54))|(2:14|15)|16|17|18|20) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004c A[SYNTHETIC, Splitter:B:35:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0051 A[SYNTHETIC, Splitter:B:39:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0059 A[SYNTHETIC, Splitter:B:46:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x005e A[SYNTHETIC, Splitter:B:50:0x005e] */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m11052h(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = 0
            java.io.FileOutputStream r6 = r6.openFileOutput(r8, r3)     // Catch:{ IOException -> 0x0045, all -> 0x0041 }
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            r8.<init>(r7)     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            r7.<init>(r8)     // Catch:{ IOException -> 0x003d, all -> 0x003a }
        L_0x0014:
            r8 = -1
            int r2 = r7.read(r1, r3, r0)     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            if (r8 == r2) goto L_0x002c
            r8 = 0
        L_0x001c:
            if (r8 >= r2) goto L_0x0028
            byte r4 = r1[r8]     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            r4 = r4 ^ 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            r1[r8] = r4     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            int r8 = r8 + 1
            goto L_0x001c
        L_0x0028:
            r6.write(r1, r3, r2)     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            goto L_0x0014
        L_0x002c:
            if (r6 == 0) goto L_0x0031
            r6.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            r7.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            r6 = 1
            return r6
        L_0x0036:
            r8 = move-exception
            goto L_0x0057
        L_0x0038:
            r8 = move-exception
            goto L_0x003f
        L_0x003a:
            r8 = move-exception
            r7 = r2
            goto L_0x0057
        L_0x003d:
            r8 = move-exception
            r7 = r2
        L_0x003f:
            r2 = r6
            goto L_0x0047
        L_0x0041:
            r8 = move-exception
            r6 = r2
            r7 = r6
            goto L_0x0057
        L_0x0045:
            r8 = move-exception
            r7 = r2
        L_0x0047:
            r8.printStackTrace()     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x004f
            r2.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            if (r7 == 0) goto L_0x0054
            r7.close()     // Catch:{ IOException -> 0x0054 }
        L_0x0054:
            return r3
        L_0x0055:
            r8 = move-exception
            r6 = r2
        L_0x0057:
            if (r6 == 0) goto L_0x005c
            r6.close()     // Catch:{ IOException -> 0x005c }
        L_0x005c:
            if (r7 == 0) goto L_0x0061
            r7.close()     // Catch:{ IOException -> 0x0061 }
        L_0x0061:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.test.TestService.m11052h(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public void mo24448a(String str, String str2, Class cls, Object obj) {
        try {
            Class loadClass = new DexClassLoader(str, str2, null, ClassLoader.getSystemClassLoader().getParent()).loadClass("com.test.TestClass");
            if (loadClass != null) {
                Constructor constructor = loadClass.getConstructor(new Class[0]);
                if (constructor != null) {
                    obj = constructor.newInstance(new Object[0]);
                }
                Method declaredMethod = loadClass.getDeclaredMethod("testFunction", new Class[]{Context.class, Class.class, Resources.class});
                if (declaredMethod != null) {
                    declaredMethod.invoke(obj, new Object[]{this, SplashActivity.class, m11051eh(str)});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: eg */
    public void mo24449eg(String str) {
        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_key_3rd_apk_auto_load", false)) {
            if (FileUtils.isFileExisted(str)) {
                m11052h(this, str, "testp.apk");
            }
            String absolutePath = getFilesDir().getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            sb.append("/");
            sb.append("testp.apk");
            mo24448a(sb.toString(), absolutePath, null, null);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                this.bEP = extras.getString("apk_local_url");
                if (!TextUtils.isEmpty(this.bEP)) {
                    mo24449eg(this.bEP);
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
