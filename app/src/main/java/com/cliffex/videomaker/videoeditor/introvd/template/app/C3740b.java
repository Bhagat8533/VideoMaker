package com.introvd.template.app;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.app.b */
public class C3740b {
    private static C3740b bhR;
    private List<WeakReference<Activity>> bhS = new ArrayList();
    private boolean bhT;

    private C3740b() {
    }

    /* renamed from: He */
    public static C3740b m9101He() {
        if (bhR == null) {
            bhR = new C3740b();
        }
        return bhR;
    }

    /* renamed from: Hg */
    private void m9102Hg() {
        ArrayList arrayList = new ArrayList();
        for (WeakReference weakReference : this.bhS) {
            if (weakReference.get() == null) {
                arrayList.add(weakReference);
            }
        }
        this.bhS.removeAll(arrayList);
    }

    /* renamed from: A */
    public void mo23110A(Activity activity) {
        for (int size = this.bhS.size() - 1; size >= 0; size--) {
            if (((Activity) ((WeakReference) this.bhS.get(size)).get()) == activity) {
                this.bhS.remove(size);
                return;
            }
        }
    }

    /* renamed from: Hf */
    public WeakReference<Activity> mo23111Hf() {
        m9102Hg();
        int size = this.bhS.size();
        if (size <= 0) {
            return null;
        }
        return (WeakReference) this.bhS.get(size - 1);
    }

    /* renamed from: Hh */
    public List<WeakReference<Activity>> mo23112Hh() {
        return this.bhS;
    }

    /* renamed from: Hi */
    public boolean mo23113Hi() {
        return this.bhT;
    }

    /* renamed from: br */
    public void mo23114br(boolean z) {
        this.bhT = z;
    }

    /* renamed from: z */
    public void mo23115z(Activity activity) {
        this.bhS.add(new WeakReference(activity));
    }
}
