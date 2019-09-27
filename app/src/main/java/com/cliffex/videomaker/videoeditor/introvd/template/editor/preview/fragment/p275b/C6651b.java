package com.introvd.template.editor.preview.fragment.p275b;

import android.app.Activity;
import android.view.View;
import com.introvd.template.xyui.C9136a;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.editor.preview.fragment.b.b */
public class C6651b {
    private WeakReference<Activity> bbj;
    private C9136a cMo;

    public C6651b(Activity activity) {
        this.bbj = new WeakReference<>(activity);
    }

    /* renamed from: b */
    public void mo30034b(View view, int i, String str, boolean z, int i2, int i3) {
        Activity activity = (Activity) this.bbj.get();
        if (activity != null) {
            if (this.cMo == null) {
                this.cMo = new C9136a(activity);
            }
            this.cMo.mo36087f(view, i, z);
            this.cMo.mo36086dt(str);
            this.cMo.mo36085dT(i2, i3);
        }
    }

    public void hide() {
        if (this.cMo != null) {
            this.cMo.aNX();
        }
    }
}
