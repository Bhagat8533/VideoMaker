package com.introvd.template.p363o;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.common.ToastUtils;
import com.vivavideo.component.permission.C9295b;
import com.vivavideo.component.permission.C9296c;
import com.vivavideo.component.permission.request.C9302c;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.o.a */
public class C8086a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m23465a(int i, final Activity activity) {
        if (activity != null) {
            C8093c.m23475a(i, activity, new OnClickListener() {
                public void onClick(View view) {
                    C9295b.m26988hA(activity);
                }
            }, new OnClickListener() {
                public void onClick(View view) {
                }
            });
        }
    }

    /* renamed from: a */
    public static void m23466a(final Activity activity, final C8099d dVar) {
        if (activity != null) {
            if (!C9295b.m26985b(activity, C8092b.dXv) || !C9295b.m26985b(activity, C8092b.dXx) || dVar == null) {
                final C9302c bb = C9295b.m26986bb(activity);
                final int i = 2;
                if (C9295b.m26985b(activity, C8092b.dXv)) {
                    i = 4;
                    bb.mo36519m(C8092b.dXx);
                } else if (C9295b.m26985b(activity, C8092b.dXx)) {
                    i = 3;
                    bb.mo36519m(C8092b.dXv);
                } else {
                    bb.mo36516a(C8092b.dXv, C8092b.dXx);
                }
                C8093c.m23476a(i, activity, true, new OnClickListener() {
                    public void onClick(View view) {
                        C8086a.m23467a(activity, bb, i, dVar);
                    }
                }, new OnClickListener() {
                    public void onClick(View view) {
                    }
                });
                return;
            }
            dVar.mo24403PP();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m23467a(final Activity activity, C9302c cVar, final int i, final C8099d dVar) {
        if (activity != null && cVar != null) {
            cVar.mo36515a((C9296c) new C9296c() {
                /* renamed from: QI */
                public void mo24442QI() {
                    C8086a.m23465a(i, activity);
                }

                /* renamed from: ao */
                public void mo24443ao(List<String> list) {
                    if (dVar != null) {
                        dVar.mo24403PP();
                    }
                    C8086a.m23469b(i, (Context) activity);
                }

                /* renamed from: ap */
                public void mo24444ap(List<String> list) {
                    ToastUtils.show((Context) activity, C10122R.string.xiaoying_str_cam_cannot_connect_camera_tip, 0);
                    C8086a.m23469b(i, (Context) activity);
                }
            }).aPq();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m23469b(int i, Context context) {
        if (context != null) {
            if (!C9295b.m26985b(context, C8092b.dXv) || !(i == 3 || i == 2)) {
                C8106f.m23492ak(3, false);
            } else {
                C8106f.m23492ak(3, true);
            }
            if (!C9295b.m26985b(context, C8092b.dXx) || !(i == 4 || i == 2)) {
                C8106f.m23492ak(4, false);
            } else {
                C8106f.m23492ak(4, true);
            }
        }
    }
}
