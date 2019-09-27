package com.introvd.template.p374q;

import android.content.Context;
import com.introvd.template.p374q.C8350g.C8354a;

/* renamed from: com.introvd.template.q.a */
public class C8342a {
    private C8350g ejb = null;

    /* renamed from: a */
    public void mo33595a(String str, C8354a aVar) {
        if (aVar != null && str != null) {
            this.ejb.mo33606a(str, aVar);
        }
    }

    /* renamed from: d */
    public void mo33596d(Context context, Class<?> cls) {
        if (this.ejb == null) {
            this.ejb = new C8350g(context, cls);
        }
    }

    /* renamed from: oT */
    public void mo33597oT(String str) {
        if (str != null) {
            this.ejb.mo33607oT(str);
        }
    }

    public void uninit() {
        if (this.ejb != null) {
            this.ejb.release();
        }
    }
}
