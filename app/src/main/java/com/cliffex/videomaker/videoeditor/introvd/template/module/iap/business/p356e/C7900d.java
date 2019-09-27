package com.introvd.template.module.iap.business.p356e;

import android.text.TextUtils;
import com.fiii.aiii.FirebaseApp;
import com.giii.aiii.biii.tasks.OnCompleteListener;
import com.giii.aiii.biii.tasks.Task;
import com.google.firebase.p172e.C3441a;
import com.google.firebase.p172e.C3446f.C3447a;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.p352b.C7835b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.business.e.d */
public class C7900d {
    /* access modifiers changed from: private */
    public final C3441a dTc;
    private final Map<String, Object> dTd;

    /* renamed from: com.introvd.template.module.iap.business.e.d$a */
    public interface C7903a {
        void onComplete();
    }

    public C7900d() {
        this(new HashMap(), false);
    }

    public C7900d(Map<String, Object> map) {
        this(map, true);
    }

    public C7900d(Map<String, Object> map, boolean z) {
        this.dTc = aDh();
        this.dTd = map;
        if (z) {
            init();
        }
    }

    /* renamed from: a */
    public static void m23029a(final C7903a aVar) {
        if (C8048e.aBe().isInChina()) {
            if (aVar != null) {
                aVar.onComplete();
            }
            return;
        }
        final C3441a aDh = aDh();
        if (aDh != null) {
            try {
                aDh.mo22377u(4320).addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(Task<Void> task) {
                        aDh.mo22369BH();
                        if (aVar != null) {
                            aVar.onComplete();
                        }
                    }
                });
            } catch (Exception unused) {
                if (aVar != null) {
                    aVar.onComplete();
                }
            }
        }
    }

    public static C3441a aDh() {
        try {
            if (FirebaseApp.getInstance() == null) {
                FirebaseApp.m8116aK(C8048e.aBe().getContext());
            }
            return C3441a.m8681BG();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void init() {
        if (this.dTc != null) {
            this.dTc.mo22375l(this.dTd);
            this.dTc.setConfigSettings(new C3447a().mo22380be(false).mo22379BJ());
            long j = 4320;
            if (this.dTc.mo22370BI().getConfigSettings().isDeveloperModeEnabled()) {
                j = 0;
            }
            this.dTc.mo22377u(j).addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        C7900d.this.dTc.mo22369BH();
                    }
                }
            });
        }
    }

    /* renamed from: lw */
    public String mo32861lw(String str) {
        Object obj = this.dTd.get(str);
        if (C8048e.aBe().isInChina()) {
            return obj == null ? "" : String.valueOf(obj);
        }
        if (this.dTc == null) {
            return "";
        }
        String string = this.dTc.getString(str);
        String valueOf = obj != null ? String.valueOf(obj) : "";
        if (!(valueOf == null || string == null || valueOf.equals(string))) {
            C7835b.m22863ls(string);
        }
        if (TextUtils.isEmpty(string)) {
            string = valueOf;
        }
        return string;
    }
}
