package com.introvd.template.explorer.p300e.p301a;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.introvd.template.explorer.p300e.p301a.p302a.C7203d;
import java.io.File;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.explorer.e.a.a */
public class C7192a {

    /* renamed from: com.introvd.template.explorer.e.a.a$a */
    public interface C7195a {
        /* renamed from: b */
        void mo29919b(double[] dArr);
    }

    /* renamed from: a */
    public static void m21254a(final String str, final C7195a aVar) {
        C1834l.m5254a((C1839n<T>) new C1839n<double[]>() {
            /* renamed from: a */
            public void mo10177a(C1838m<double[]> mVar) throws Exception {
                if (TextUtils.isEmpty(str)) {
                    mVar.mo9791K(null);
                    return;
                }
                C7203d a = C7203d.m21277a(new File(str).getAbsolutePath(), null);
                if (a == null) {
                    mVar.mo9791K(null);
                } else {
                    mVar.mo9791K(C7192a.m21255a(a));
                }
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<double[]>() {
            /* renamed from: c */
            public void accept(double[] dArr) {
                if (aVar != null) {
                    aVar.mo29919b(dArr);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static double[] m21255a(C7203d dVar) {
        int i;
        int uj = dVar.mo31682uj();
        int[] aye = dVar.aye();
        double[] dArr = new double[uj];
        if (uj == 1) {
            dArr[0] = (double) aye[0];
        } else if (uj == 2) {
            dArr[0] = (double) aye[0];
            dArr[1] = (double) aye[1];
        } else if (uj > 2) {
            dArr[0] = (((double) aye[0]) / 2.0d) + (((double) aye[1]) / 2.0d);
            int i2 = 1;
            while (true) {
                i = uj - 1;
                if (i2 >= i) {
                    break;
                }
                int i3 = i2 + 1;
                dArr[i2] = (((double) aye[i2 - 1]) / 3.0d) + (((double) aye[i2]) / 3.0d) + (((double) aye[i3]) / 3.0d);
                i2 = i3;
            }
            dArr[i] = (((double) aye[uj - 2]) / 2.0d) + (((double) aye[i]) / 2.0d);
        }
        double d = 1.0d;
        for (int i4 = 0; i4 < uj; i4++) {
            if (dArr[i4] > d) {
                d = dArr[i4];
            }
        }
        double d2 = d > 255.0d ? 255.0d / d : 1.0d;
        int[] iArr = new int[256];
        double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i5 = 0; i5 < uj; i5++) {
            int i6 = (int) (dArr[i5] * d2);
            if (i6 < 0) {
                i6 = 0;
            }
            if (i6 > 255) {
                i6 = 255;
            }
            double d4 = (double) i6;
            if (d4 > d3) {
                d3 = d4;
            }
            iArr[i6] = iArr[i6] + 1;
        }
        double d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i7 = 0;
        while (d5 < 255.0d && i7 < uj / 20) {
            i7 += iArr[(int) d5];
            d5 += 1.0d;
        }
        double d6 = d3;
        int i8 = 0;
        while (d6 > 2.0d && i8 < uj / 100) {
            i8 += iArr[(int) d6];
            d6 -= 1.0d;
        }
        double[] dArr2 = new double[uj];
        double d7 = d6 - d5;
        for (int i9 = 0; i9 < uj; i9++) {
            double d8 = ((dArr[i9] * d2) - d5) / d7;
            if (d8 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d8 = 0.0d;
            }
            if (d8 > 1.0d) {
                d8 = 1.0d;
            }
            dArr2[i9] = d8 * d8;
        }
        return dArr2;
    }
}
