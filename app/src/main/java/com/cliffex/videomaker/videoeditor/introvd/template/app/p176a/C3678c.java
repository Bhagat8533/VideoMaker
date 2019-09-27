package com.introvd.template.app.p176a;

import android.content.Context;
import android.os.Process;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.module.iap.C8071p;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.p131c.p132a.C2561a;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.a.c */
public class C3678c {
    static {
        C8071p aBx = C8072q.aBx();
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("_super");
        C1848s.m5326ai(Boolean.valueOf(aBx.mo33072ku(sb.toString()) && !C2561a.aON())).mo10200k(3, TimeUnit.SECONDS).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    Process.killProcess(Process.myPid());
                }
            }

            public void onError(Throwable th) {
                Process.killProcess(Process.myPid());
            }
        });
    }

    /* renamed from: Im */
    private static String m8971Im() {
        C7825a[] values;
        if (C8072q.aBx().mo33072ku("HelloWorld")) {
            return "Super";
        }
        for (C7825a aVar : C7825a.values()) {
            if (C8072q.aBx().mo33072ku(aVar.getId())) {
                return aVar.getId();
            }
        }
        return C2561a.aON() ? "Pro" : "Normal";
    }

    /* renamed from: a */
    private static String m8972a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return toHexString(instance.digest(), ":");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m8973a(byte[] bArr, byte b) throws Exception {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ b);
        }
        return bArr;
    }

    /* renamed from: bW */
    public static void m8974bW(Context context) {
        if (context != null) {
            try {
                String str = new String(m8973a("LH3<H3M=3:K39J3:?3KM3O:3OM39H3<<3K13M<3=<3H:3O<3<H3983:>3<;".getBytes(), 9));
                String a = m8972a(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray(), "SHA1");
                boolean equals = str.equals(a);
                HashMap hashMap = new HashMap();
                hashMap.put(InAppPurchaseMetaData.KEY_SIGNATURE, a);
                hashMap.put("equal", String.valueOf(equals));
                hashMap.put("channel", C5206b.m14214dX(context));
                UserBehaviorLog.onAliEvent("Dev_Event_Signature_State", hashMap);
                if (!equals) {
                    String Im = m8971Im();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("goodType", Im);
                    hashMap2.put(InAppPurchaseMetaData.KEY_SIGNATURE, a);
                    if ("Super".equals(Im)) {
                        hashMap2.put("super_signature", a);
                    }
                    UserBehaviorLog.onAliEvent("Dev_Event_Signature_Good_Type", hashMap2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static String toHexString(byte[] bArr, String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (i < bArr.length - 1) {
            sb.append(cArr[(bArr[i] & 240) >>> 4]);
            sb.append(cArr[bArr[i] & 15]);
            if (str != null) {
                sb.append(str);
            }
            i++;
        }
        sb.append(cArr[(bArr[i] & 240) >>> 4]);
        sb.append(cArr[bArr[i] & 15]);
        return sb.toString();
    }
}
