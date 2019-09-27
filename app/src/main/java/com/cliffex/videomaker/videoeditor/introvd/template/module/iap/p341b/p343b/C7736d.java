package com.introvd.template.module.iap.p341b.p343b;

import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.vivaiap.coffer.C9038f;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.b.b.d */
public class C7736d {
    public final int code;
    public List<String> dQv;
    public String message;
    public final boolean success;

    public C7736d(C9038f fVar) {
        if (fVar == null) {
            this.success = false;
            this.code = -1;
            return;
        }
        this.code = fVar.getCode();
        this.success = fVar.isSuccess();
        this.message = fVar.getMessage();
        this.dQv = C7738c.aEv().aNx().aNG();
    }
}
