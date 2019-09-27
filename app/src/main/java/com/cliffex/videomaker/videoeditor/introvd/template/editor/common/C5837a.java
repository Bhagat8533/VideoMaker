package com.introvd.template.editor.common;

import org.json.JSONObject;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.common.a */
public class C5837a {
    private static volatile C5837a cEt;
    /* access modifiers changed from: private */
    public EditorConfigBean cEu = new EditorConfigBean();

    private C5837a() {
    }

    public static C5837a agH() {
        if (cEt == null) {
            synchronized (C5837a.class) {
                if (cEt == null) {
                    cEt = new C5837a();
                }
            }
        }
        return cEt;
    }

    public boolean abi() {
        return this.cEu.undo_redo == 1;
    }

    public boolean agI() {
        return this.cEu.Preview_Resolution_refine == 1;
    }

    public boolean agJ() {
        return this.cEu.VE_Add_Clip_Enterance == 1;
    }

    public boolean agK() {
        return this.cEu.Effects_Material_Add_Logic == 0;
    }

    public boolean agL() {
        return this.cEu.Preview_Exit_Save_or_not == 1;
    }

    public boolean agM() {
        return this.cEu.Slide_Show_Edit_Mode == 1;
    }

    public boolean agN() {
        return this.cEu.keyframe == 1;
    }

    /* renamed from: dH */
    public void mo28216dH(final String str) {
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                EditorConfigBean editorConfigBean;
                C5837a aVar;
                try {
                    C5837a.this.cEu = new EditorConfigBean();
                    JSONObject jSONObject = new JSONObject(str);
                    C5837a.this.cEu.Preview_Resolution_refine = jSONObject.optInt("Preview_Resolution_refine", 0);
                    C5837a.this.cEu.VE_Add_Clip_Enterance = jSONObject.optInt("VE_Add_Clip_Enterance", 0);
                    C5837a.this.cEu.Effects_Material_Add_Logic = jSONObject.optInt("Effects_Material_Add_Logic", 0);
                    C5837a.this.cEu.undo_redo = jSONObject.optInt("undo_redo", 1);
                    C5837a.this.cEu.Preview_Exit_Save_or_not = jSONObject.optInt("Preview_Exit_Save_or_not", 0);
                    C5837a.this.cEu.Slide_Show_Edit_Mode = jSONObject.optInt("Slide_Show_Edit_Mode", 0);
                    C5837a.this.cEu.keyframe = jSONObject.optInt("keyframe", 0);
                    if (C5837a.this.cEu == null) {
                        aVar = C5837a.this;
                        editorConfigBean = new EditorConfigBean();
                        aVar.cEu = editorConfigBean;
                    }
                } catch (Exception unused) {
                    if (C5837a.this.cEu == null) {
                        aVar = C5837a.this;
                        editorConfigBean = new EditorConfigBean();
                    }
                } catch (Throwable th) {
                    if (C5837a.this.cEu == null) {
                        C5837a.this.cEu = new EditorConfigBean();
                    }
                    throw th;
                }
            }
        });
    }
}
