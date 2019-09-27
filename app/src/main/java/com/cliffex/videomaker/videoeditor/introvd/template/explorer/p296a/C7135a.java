package com.introvd.template.explorer.p296a;

import org.json.JSONObject;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.explorer.a.a */
public class C7135a {
    private static C7135a dxN;
    /* access modifiers changed from: private */
    public int dxO = 1;

    private C7135a() {
    }

    public static C7135a avU() {
        if (dxN == null) {
            dxN = new C7135a();
        }
        return dxN;
    }

    public boolean avV() {
        return this.dxO == 1;
    }

    /* renamed from: dH */
    public void mo31594dH(final String str) {
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                try {
                    C7135a.this.dxO = new JSONObject(str).optInt("BGM_Add_From_Video", 1);
                } catch (Exception unused) {
                }
            }
        });
    }
}
