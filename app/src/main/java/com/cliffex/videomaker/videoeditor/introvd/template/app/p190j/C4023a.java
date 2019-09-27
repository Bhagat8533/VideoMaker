package com.introvd.template.app.p190j;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.AppStateModel;
import org.json.JSONObject;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.j.a */
public class C4023a {
    private static C4023a btD;
    /* access modifiers changed from: private */
    public int btE = 1;
    /* access modifiers changed from: private */
    public int btF = 0;
    /* access modifiers changed from: private */
    public String btG;
    /* access modifiers changed from: private */
    public String btH;
    /* access modifiers changed from: private */
    public int btI = -1;
    /* access modifiers changed from: private */
    public int btJ = 0;
    /* access modifiers changed from: private */
    public String btK;
    /* access modifiers changed from: private */
    public String btL;

    private C4023a() {
    }

    /* renamed from: MK */
    public static C4023a m9973MK() {
        if (btD == null) {
            btD = new C4023a();
        }
        return btD;
    }

    /* renamed from: ML */
    public boolean mo23673ML() {
        return this.btE == 1;
    }

    /* renamed from: MM */
    public boolean mo23674MM() {
        return this.btF == 1;
    }

    /* renamed from: MN */
    public String mo23675MN() {
        return this.btG;
    }

    /* renamed from: MO */
    public String mo23676MO() {
        return this.btH;
    }

    /* renamed from: MP */
    public boolean mo23677MP() {
        if (this.btI == -1) {
            return AppStateModel.getInstance().isInChina();
        }
        return this.btI > 0;
    }

    /* renamed from: MQ */
    public int mo23678MQ() {
        return this.btI;
    }

    /* renamed from: MR */
    public String mo23679MR() {
        return this.btK;
    }

    /* renamed from: MS */
    public String mo23680MS() {
        return this.btL;
    }

    /* renamed from: dH */
    public void mo23681dH(final String str) {
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    C4023a.this.btE = jSONObject.optInt("New_Feature_Slide", 1);
                    C4023a.this.btF = jSONObject.optInt("rating_dialog_style", 0);
                    C4023a.this.btG = jSONObject.optString("rateDialogDesc");
                    C4023a.this.btH = jSONObject.optString("rateDialogSubDesc");
                    C4023a.this.btK = jSONObject.optString("feedbackTemplateQQNumber");
                    C4023a.this.btL = jSONObject.optString("feedbackCourseQQNumber");
                    if (!VivaBaseApplication.m8749FZ().mo22829Gb()) {
                        C4023a.this.btI = jSONObject.optInt("CreatorPageStyle", -1);
                        StringBuilder sb = new StringBuilder();
                        sb.append("set school creation config : ");
                        sb.append(C4023a.this.btI);
                        LogUtilsV2.m14230i(sb.toString());
                    }
                    C4023a.this.btJ = jSONObject.optInt("loginPopUIStyle", 0);
                } catch (Exception unused) {
                }
            }
        });
    }

    public boolean getLoginPopUIStyle() {
        return true;
    }
}
