package com.introvd.template.editor.p252e;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Process;
import android.text.TextUtils;
import com.introvd.template.C4681i;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.p173a.C3570a;
import com.introvd.template.p374q.C8358i;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.utils.C8553i;
import xiaoying.utils.QStreamAssets;

/* renamed from: com.introvd.template.editor.e.d */
public class C5881d extends Thread {
    private static boolean cUR;
    private Context cUN;

    public C5881d(Context context) {
        this.cUN = context;
    }

    /* renamed from: a */
    private static synchronized void m16423a(AssetManager assetManager) {
        synchronized (C5881d.class) {
            if (!cUR) {
                QStreamAssets.mAssetManager = assetManager;
                try {
                    QStreamAssets.native_Init(QStreamAssets.ASSETS_THEME, QStreamAssets.mAssetManager);
                    cUR = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                return;
            }
        }
        return;
    }

    /* renamed from: ff */
    private static void m16424ff(Context context) {
        C8553i.setContext(context.getApplicationContext());
        C8553i.m25005ut(1);
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Process.setThreadPriority(-1);
            C8553i.setContext(this.cUN.getApplicationContext());
            C8410e.m24270gK(this.cUN);
            StringBuilder sb = new StringBuilder();
            sb.append("loadLibraries, cost:");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            LogUtilsV2.m14227d(sb.toString());
            m16423a(C4681i.m12184Gp().mo25015Gq());
            m16424ff(this.cUN);
            Process.setThreadPriority(10);
            if (!TextUtils.isEmpty(UserServiceProxy.getUserId())) {
                C8358i.m24109gV(this.cUN);
            }
        } catch (Throwable th) {
            C3570a.m8781x(4, true);
            throw th;
        }
        C3570a.m8781x(4, true);
    }
}
