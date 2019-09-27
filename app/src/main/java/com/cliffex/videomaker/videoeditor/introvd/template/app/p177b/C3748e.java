package com.introvd.template.app.p177b;

import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.model.AppStateModel;

/* renamed from: com.introvd.template.app.b.e */
public class C3748e {
    private static C3748e bnU;
    private boolean bnT = true;

    private C3748e() {
    }

    /* renamed from: JX */
    public static C3748e m9193JX() {
        if (bnU == null) {
            synchronized (C3748e.class) {
                if (bnU == null) {
                    bnU = new C3748e();
                }
            }
        }
        return bnU;
    }

    /* renamed from: JY */
    public void mo23192JY() {
        if (mo23193JZ()) {
            this.bnT = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_key_auto_play_next", true);
        } else {
            this.bnT = false;
        }
    }

    /* renamed from: JZ */
    public boolean mo23193JZ() {
        return C3742b.m9111II().mo23137JE() && (AppStateModel.getInstance().isInChina() || AppStateModel.getInstance().isInIndia() || AppStateModel.getInstance().isMiddleEast());
    }

    /* renamed from: Ka */
    public boolean mo23194Ka() {
        this.bnT = !this.bnT;
        return this.bnT;
    }

    /* renamed from: Kb */
    public boolean mo23195Kb() {
        return this.bnT;
    }

    /* renamed from: Kc */
    public void mo23196Kc() {
        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_key_auto_play_next", this.bnT);
    }
}
