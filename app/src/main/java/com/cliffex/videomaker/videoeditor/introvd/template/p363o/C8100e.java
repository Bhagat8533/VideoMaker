package com.introvd.template.p363o;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.vivavideo.component.permission.C9295b;
import com.vivavideo.component.permission.C9296c;
import java.util.List;

/* renamed from: com.introvd.template.o.e */
public class C8100e {
    /* renamed from: aS */
    public static void m23485aS(final Activity activity) {
        if (activity != null) {
            C8093c.m23476a(5, activity, true, new OnClickListener() {
                public void onClick(View view) {
                    C8100e.m23486aT(activity);
                }
            }, new OnClickListener() {
                public void onClick(View view) {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aT */
    public static void m23486aT(final Activity activity) {
        if (activity != null) {
            C9295b.m26986bb(activity).mo36519m(C8092b.dXx).mo36515a((C9296c) new C9296c() {
                /* renamed from: QI */
                public void mo24442QI() {
                    C8100e.m23487aU(activity);
                }

                /* renamed from: ao */
                public void mo24443ao(List<String> list) {
                    C8100e.m23488gD(activity);
                }

                /* renamed from: ap */
                public void mo24444ap(List<String> list) {
                    C8100e.m23488gD(activity);
                }
            }).aPq();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aU */
    public static void m23487aU(final Activity activity) {
        if (activity != null) {
            C8093c.m23475a(4, activity, new OnClickListener() {
                public void onClick(View view) {
                    C9295b.m26988hA(activity);
                }
            }, new OnClickListener() {
                public void onClick(View view) {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gD */
    public static void m23488gD(Context context) {
        if (context != null) {
            if (C9295b.m26985b(context, C8092b.dXx)) {
                C8106f.m23492ak(5, true);
            } else {
                C8106f.m23492ak(5, false);
            }
        }
    }
}
