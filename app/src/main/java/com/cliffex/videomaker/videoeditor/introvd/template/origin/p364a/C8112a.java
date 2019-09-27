package com.introvd.template.origin.p364a;

import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.vivavideo.mobile.component.sharedpref.C9324b;
import com.vivavideo.mobile.component.sharedpref.C9327e;
import java.util.concurrent.TimeUnit;

/* renamed from: com.introvd.template.origin.a.a */
class C8112a {
    private static final long dWu = TimeUnit.MINUTES.toMillis(1);
    private String dWv = null;
    private C9324b dWw;

    C8112a() {
    }

    /* renamed from: EC */
    private C9324b m23494EC() {
        if (this.dWw == null) {
            this.dWw = C9327e.m27034cR(VivaBaseApplication.m8749FZ(), "app_config");
        }
        return this.dWw;
    }

    /* renamed from: d */
    static String m23495d(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append("__");
        sb.append(str);
        sb.append("__");
        sb.append(str2);
        sb.append("__");
        sb.append(str3);
        sb.append("__");
        sb.append(str4);
        sb.append("__");
        sb.append(str5);
        sb.append("__");
        return sb.toString();
    }

    /* renamed from: so */
    private String m23496so() {
        return m23494EC().getString(InAppPurchaseMetaData.KEY_SIGNATURE, "");
    }

    /* access modifiers changed from: 0000 */
    public String aES() {
        if (!TextUtils.isEmpty(this.dWv)) {
            return this.dWv;
        }
        synchronized (C8113b.class) {
            this.dWv = m23494EC().getString("app_config", null);
        }
        return this.dWv;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: aQ */
    public void mo33148aQ(long j) {
        m23494EC().setLong("last_check_time", j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: mc */
    public void mo33149mc(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (C8113b.class) {
                this.dWv = str;
                m23494EC().setString("app_config", str);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: md */
    public boolean mo33150md(String str) {
        String so = m23496so();
        boolean z = true;
        boolean z2 = !str.equals(so);
        StringBuilder sb = new StringBuilder();
        sb.append("AppConfig:CurrentSignature = ");
        sb.append(str);
        sb.append(",OldSignature = ");
        sb.append(so);
        sb.append(",needCheck=");
        sb.append(z2);
        LogUtilsV2.m14227d(sb.toString());
        if (z2) {
            if (TextUtils.isEmpty(aES())) {
                C8115d.m23506a(true, "AppConfig init", 0);
            } else {
                C8115d.m23506a(true, "Signature diff", 0);
            }
            return true;
        }
        long j = m23494EC().getLong("last_check_time", 0);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        if (System.currentTimeMillis() - j <= dWu) {
            z = false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AppConfig:Last Request AppConfig in ");
        sb2.append(seconds);
        sb2.append("s,checkCycle=");
        sb2.append(TimeUnit.MILLISECONDS.toSeconds(dWu));
        sb2.append("s,needCheck=");
        sb2.append(z);
        LogUtilsV2.m14227d(sb2.toString());
        C8115d.m23506a(z, z ? "expired" : "hitCache", seconds);
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: me */
    public void mo33151me(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("saveSignature = ");
        sb.append(str);
        LogUtilsV2.m14227d(sb.toString());
        m23494EC().setString(InAppPurchaseMetaData.KEY_SIGNATURE, str);
    }
}
