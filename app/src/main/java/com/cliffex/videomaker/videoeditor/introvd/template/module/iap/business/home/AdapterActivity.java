package com.introvd.template.module.iap.business.home;

import android.content.Context;
import android.content.res.Resources;
import android.support.p021v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import com.introvd.template.module.iap.C8048e;
import java.lang.reflect.Field;

public abstract class AdapterActivity extends FragmentActivity {
    C7947a dTh = new C7947a(C8048e.aBe().getApplication());

    /* renamed from: com.introvd.template.module.iap.business.home.AdapterActivity$a */
    public static class C7947a {
        private Context context;
        private boolean dTi = false;
        private Field dTj;

        public C7947a(Context context2) {
            this.context = context2.getApplicationContext();
        }

        /* renamed from: aO */
        private void m23096aO(float f) {
            this.context.getResources().getDisplayMetrics().xdpi = f;
        }

        /* renamed from: j */
        private DisplayMetrics m23097j(Resources resources) {
            DisplayMetrics k = m23098k(resources);
            return k == null ? resources.getDisplayMetrics() : k;
        }

        /* renamed from: k */
        private DisplayMetrics m23098k(Resources resources) {
            DisplayMetrics displayMetrics;
            if (!this.dTi) {
                String simpleName = resources.getClass().getSimpleName();
                if ("MiuiResources".equals(simpleName) || "XResources".equals(simpleName)) {
                    try {
                        this.dTj = Resources.class.getDeclaredField("mTmpMetrics");
                        this.dTj.setAccessible(true);
                        displayMetrics = (DisplayMetrics) this.dTj.get(resources);
                    } catch (Exception unused) {
                        Log.e(getClass().getSimpleName(), "no field of mTmpMetrics in resources.");
                    }
                    this.dTi = true;
                    return displayMetrics;
                }
                displayMetrics = null;
                this.dTi = true;
                return displayMetrics;
            } else if (this.dTj == null) {
                return null;
            } else {
                try {
                    return (DisplayMetrics) this.dTj.get(resources);
                } catch (Exception unused2) {
                    return null;
                }
            }
        }

        /* renamed from: b */
        public Resources mo32912b(Resources resources, int i) {
            DisplayMetrics j = m23097j(resources);
            float f = (((float) j.heightPixels) * 72.0f) / ((float) i);
            j.xdpi = f;
            m23096aO(f);
            return resources;
        }
    }

    public abstract int aDi();

    public Resources getResources() {
        int aDi = aDi();
        return aDi > 0 ? this.dTh.mo32912b(super.getResources(), aDi) : super.getResources();
    }
}
