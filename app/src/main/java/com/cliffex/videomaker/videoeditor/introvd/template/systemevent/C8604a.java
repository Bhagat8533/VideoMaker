package com.introvd.template.systemevent;

import android.text.TextUtils;
import com.introvd.template.systemevent.C8605b.C8606a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.introvd.template.systemevent.a */
public class C8604a {
    boolean ejT;
    private C8606a ejU;
    ArrayList<C8605b> mObservers;

    /* renamed from: a */
    public void mo34887a(C8605b bVar) {
        if (bVar != null) {
            this.ejT = false;
            this.mObservers.add(bVar);
            bVar.startWatching();
        }
    }

    /* renamed from: b */
    public void mo34888b(C8605b bVar) {
        if (bVar != null) {
            this.mObservers.remove(bVar);
            bVar.stopWatching();
        }
    }

    /* renamed from: oV */
    public void mo34889oV(String str) {
        if (!TextUtils.isEmpty(str)) {
            mo34887a(new C8605b(str, this.ejU));
        }
    }

    /* renamed from: oW */
    public void mo34890oW(String str) {
        if (!TextUtils.isEmpty(str)) {
            mo34888b(mo34891oX(str));
        }
    }

    /* renamed from: oX */
    public C8605b mo34891oX(String str) {
        Iterator it = this.mObservers.iterator();
        while (it.hasNext()) {
            C8605b bVar = (C8605b) it.next();
            if (TextUtils.equals(str, bVar.getPath())) {
                return bVar;
            }
        }
        return null;
    }
}
