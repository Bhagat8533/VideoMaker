package com.introvd.template.sdk.p384d;

import com.introvd.template.sdk.database.C8405a;
import com.introvd.template.sdk.model.editor.DataItemClip;

/* renamed from: com.introvd.template.sdk.d.a */
public class C8402a {
    /* renamed from: aX */
    public static String m24225aX(long j) {
        return C8405a.aHD().aHF().mo33985aX(j);
    }

    /* renamed from: aY */
    public static void m24226aY(long j) {
        C8405a.aHD().aHF().mo33986aY(j);
    }

    /* renamed from: b */
    public static void m24227b(DataItemClip dataItemClip) {
        if (dataItemClip != null) {
            long a = C8405a.aHD().aHF().mo33984a(dataItemClip);
            if (a >= 0) {
                try {
                    C8403b.m24230b(2147483647L, a, true);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: nA */
    public static long m24228nA(String str) {
        return C8405a.aHD().aHF().mo33987nA(str);
    }
}
