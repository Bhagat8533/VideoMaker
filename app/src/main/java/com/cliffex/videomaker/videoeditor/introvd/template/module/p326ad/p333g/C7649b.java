package com.introvd.template.module.p326ad.p333g;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.module.ad.R;
import com.introvd.template.module.p326ad.C7588a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p334h.C7662c;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.C1841p;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p058f.p059a.C1523b;

/* renamed from: com.introvd.template.module.ad.g.b */
public class C7649b extends C7644a implements C1839n<Integer> {
    private C1838m<Integer> dNn;
    private int dNo;

    /* renamed from: com.introvd.template.module.ad.g.b$a */
    private static class C7652a implements C1495b, C1842q<Integer> {
        private final AtomicReference<C1495b> dNs = new AtomicReference<>();
        private C1842q<? super Integer> dNt;
        private C7649b dNu;

        C7652a(C1842q<? super Integer> qVar, C7649b bVar) {
            this.dNt = qVar;
            this.dNu = bVar;
        }

        /* renamed from: a */
        public final void mo9877a(C1495b bVar) {
            this.dNt.mo9877a(this);
        }

        public boolean aAy() {
            return this.dNs.get() == C1523b.DISPOSED;
        }

        public void dispose() {
            this.dNu.cancel();
            C1523b.m4750a(this.dNs);
        }

        /* renamed from: n */
        public void mo9886K(Integer num) {
            this.dNt.mo9886K(num);
        }

        public void onComplete() {
            this.dNt.onComplete();
        }

        public void onError(Throwable th) {
            this.dNt.onError(th);
        }
    }

    private C7649b(Context context, int i, String str, boolean z, int i2) {
        super(context, i, str, z);
        this.dNo = i2;
    }

    /* renamed from: Ig */
    private static String m22457Ig() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance().getTime());
    }

    /* renamed from: a */
    public static C1834l<Integer> m22458a(Context context, int i, String str, boolean z) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return C1834l.m5263w(new IllegalStateException("activity state wrong"));
        }
        if (!C7680l.aAf().isAdAvailable(context, i)) {
            return C1834l.m5263w(new IllegalStateException("has not reward ad"));
        }
        int aAx = aAx();
        Integer V = C7588a.m22357V(AdParamMgr.getExtraInfoByKey(i, "show"));
        if (aAx >= Integer.valueOf(V == null ? 0 : V.intValue()).intValue()) {
            return C1834l.m5263w(new IllegalStateException("the ad today has show out"));
        }
        C7649b bVar = new C7649b(context, i, str, z, aAx);
        return C1834l.m5254a((C1839n<T>) bVar).mo10136a((C1841p<? super T, ? extends R>) new C1841p<Integer, Integer>(bVar) {
            final /* synthetic */ C7649b dNp;

            {
                this.dNp = r1;
            }

            /* renamed from: a */
            public C1840o<Integer> mo10178a(final C1834l<Integer> lVar) {
                return new C1834l<Integer>() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo9964a(C1842q<? super Integer> qVar) {
                        C7652a aVar = new C7652a(qVar, C76501.this.dNp);
                        C76501.this.dNp.show();
                        qVar.mo9886K(Integer.valueOf(0));
                        lVar.mo10149b((C1842q<? super T>) aVar);
                    }
                };
            }
        });
    }

    private static int aAx() {
        try {
            return new JSONObject(C7662c.aAA().getString("show_times", "{}")).optInt(m22457Ig(), 0);
        } catch (Exception e) {
            C7662c.aAA().setString("show_times", null);
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: go */
    private static void m22459go(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"");
        sb.append(m22457Ig());
        sb.append("\":");
        sb.append(i);
        sb.append("}");
        C7662c.aAA().setString("show_times", sb.toString());
    }

    /* renamed from: a */
    public void mo10177a(C1838m<Integer> mVar) throws Exception {
        this.dNn = mVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: iz */
    public void mo32537iz(boolean z) {
        super.mo32537iz(z);
        if (this.dNn != null) {
            this.dNn.mo9791K(Integer.valueOf(z ? 1 : -1));
        }
    }

    public void show() {
        super.show();
        TextView textView = (TextView) findViewById(R.id.tv_title);
        Integer V = C7588a.m22357V(AdParamMgr.getExtraInfoByKey(this.bgQ, "availabletime"));
        Context context = getContext();
        int i = R.string.xiaoying_str_encourage_template_duration;
        Object[] objArr = new Object[1];
        objArr[0] = String.valueOf((V == null || V.intValue() == 0) ? 7 : V.intValue());
        textView.setText(context.getString(i, objArr));
        m22459go(this.dNo + 1);
    }
}
