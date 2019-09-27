package com.introvd.template.app.push;

import android.content.Context;
import com.introvd.template.VivaBaseApplication;
import com.quvideo.mobile.component.push.C4800f;
import com.quvideo.mobile.component.push.C4807j;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.push.d */
class C4112d implements C4800f {
    C4110c bvU;

    public C4112d(C4110c cVar) {
        this.bvU = cVar;
    }

    /* renamed from: N */
    private boolean m10214N(Object obj) {
        try {
            String string = new JSONObject((Map) obj).getString("message");
            if (new JSONObject(string).getString("objectName").equals("RC:TxtMsg")) {
                this.bvU.mo23790a((Context) VivaBaseApplication.m8749FZ(), 3, "", string, "", C4807j.m12381fM(6));
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo23793b(int i, Object obj) {
        if (i == 6) {
            return m10214N(obj);
        }
        return false;
    }
}
