package com.introvd.template.template.download;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.template.R;
import com.introvd.template.template.download.C8705e.C8707b;
import com.p131c.p132a.p135c.C2575a;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.template.download.d */
public class C8703d {
    /* access modifiers changed from: private */
    public C8708f elN;
    private C8707b elO = new C8707b() {
        public void arB() {
        }

        public void arC() {
        }

        /* renamed from: iA */
        public void mo30336iA(String str) {
            Long valueOf = Long.valueOf(TextUtils.isEmpty(str) ? 0 : C2575a.m7391rq(str));
            if (C8703d.this.elN != null) {
                C8703d.this.elN.mo24952c(valueOf.longValue(), -1);
                C8703d.this.elN.mo24953c(valueOf);
            }
        }

        /* renamed from: iB */
        public void mo30337iB(String str) {
            Long valueOf = Long.valueOf(TextUtils.isEmpty(str) ? 0 : C2575a.m7391rq(str));
            if (C8703d.this.elN != null) {
                C8703d.this.elN.mo24952c(valueOf.longValue(), -2);
                C8703d.this.elN.mo27390p(valueOf);
            }
        }

        /* renamed from: iC */
        public void mo30338iC(String str) {
        }

        /* renamed from: ix */
        public void mo30340ix(String str) {
        }

        /* renamed from: iy */
        public void mo30341iy(String str) {
            if (C8703d.this.elN != null) {
                C8703d.this.elN.mo24951b(Long.valueOf(TextUtils.isEmpty(str) ? 0 : C2575a.m7391rq(str)));
            }
        }

        /* renamed from: iz */
        public void mo30342iz(String str) {
            if (C8703d.this.elN != null) {
                C8703d.this.elN.mo27389o(Long.valueOf(TextUtils.isEmpty(str) ? 0 : C2575a.m7391rq(str)));
            }
        }

        /* renamed from: w */
        public void mo30344w(String str, int i) {
            if (C8703d.this.elN != null) {
                C8703d.this.elN.mo24952c(TextUtils.isEmpty(str) ? 0 : C2575a.m7391rq(str), i);
            }
        }
    };
    private WeakReference<Context> mContextRef;

    public C8703d(Context context, C8708f fVar) {
        this.mContextRef = new WeakReference<>(context);
        this.elN = fVar;
        C8705e.m25369gZ((Context) this.mContextRef.get()).mo35079a(this.elO);
    }

    /* renamed from: VD */
    public void mo35076VD() {
        C8705e.m25369gZ((Context) this.mContextRef.get()).mo35080b(this.elO);
    }

    /* renamed from: a */
    public void mo35077a(EffectInfoModel effectInfoModel, String str) {
        if (!BaseSocialNotify.isNetworkAvaliable((Context) this.mContextRef.get())) {
            ToastUtils.show((Context) this.mContextRef.get(), R.string.xiaoying_str_com_msg_network_inactive, 0);
        } else {
            C8705e.m25369gZ((Context) this.mContextRef.get()).mo35078a(effectInfoModel, str);
        }
    }
}
