package com.introvd.template.app.homepage.hometab;

import android.content.Context;
import android.databinding.C0175i;
import android.databinding.C0175i.C0176a;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.homepage.hometab.HomeTabLayoutBase.C3969a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p310g.C7386y;
import com.introvd.template.router.community.util.CommunityPageTabConstants;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import p037b.p050b.p051a.p053b.C1487a;

/* renamed from: com.introvd.template.app.homepage.hometab.a */
public class C3972a {
    private HomeTabLayoutBase bsq;
    private HomeTabLayoutModel bsr = new HomeTabLayoutModel();

    /* renamed from: LP */
    private boolean m9819LP() {
        return AppStateModel.getInstance().isMessageTabSupport();
    }

    /* renamed from: LQ */
    private static boolean m9820LQ() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("key_saved_home_tab_time", null);
        boolean z = true;
        if (TextUtils.isEmpty(appSettingStr)) {
            return true;
        }
        if (System.currentTimeMillis() <= Long.valueOf(appSettingStr).longValue() + 28800000) {
            z = false;
        }
        return z;
    }

    /* renamed from: LR */
    private static void m9821LR() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("");
        AppPreferencesSetting.getInstance().setAppSettingStr("key_saved_home_tab_time", sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: LW */
    public void m9822LW() {
        if (mo23577LV() == 1) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_help_V2_show_flag", false);
            return;
        }
        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_help_V2_show_flag", true)) {
            this.bsq.mo23531LN();
        }
    }

    /* renamed from: bz */
    private void m9824bz(boolean z) {
        this.bsq.setVisibility(z ? 0 : 8);
    }

    /* renamed from: gS */
    private String m9825gS(int i) {
        if (i == 1) {
            return "Home";
        }
        if (i == 2) {
            return SocialConstDef.TBL_NAME_MESSAGE;
        }
        if (i == 3) {
            return "Studio";
        }
        if (i == 4) {
            return "School";
        }
        if (i == 0) {
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt(CommunityPageTabConstants.KEY_SAVED_TAB_ID, AppStateModel.getInstance().isHotVideoEnable() ? 2 : 3);
            if (appSettingInt == 1) {
                return SocialConstDef.TBL_NAME_FOLLOW;
            }
            if (appSettingInt == 2) {
                return "Hot";
            }
            if (appSettingInt == 3) {
                return "Explore";
            }
        }
        return "other";
    }

    /* renamed from: LM */
    public void mo23573LM() {
        this.bsq.mo23530LM();
    }

    /* renamed from: LS */
    public ImageView mo23574LS() {
        return this.bsq.mo23534gP(0);
    }

    /* renamed from: LT */
    public ImageView mo23575LT() {
        return this.bsq.mo23534gP(3);
    }

    /* renamed from: LU */
    public ImageView mo23576LU() {
        return this.bsq.mo23534gP(1);
    }

    /* renamed from: LV */
    public int mo23577LV() {
        return C7386y.m21767a(this.bsr.getLastFocusTabIdField());
    }

    /* renamed from: a */
    public void mo23578a(RelativeLayout relativeLayout) {
        Context context = relativeLayout.getContext();
        if (m9819LP()) {
            this.bsq = new HomeTabLayoutV2(context);
        } else {
            this.bsq = new HomeTabLayout(context);
        }
        this.bsq.mo23532a(this.bsr);
        this.bsr.getLastFocusTabIdField().addOnPropertyChangedCallback(new C0176a() {
            /* renamed from: a */
            public void mo423a(C0175i iVar, int i) {
            }
        });
        LayoutParams layoutParams = new LayoutParams(-1, C4583d.m11670O(context, 60));
        layoutParams.addRule(12);
        relativeLayout.addView(this.bsq, layoutParams);
        HashMap hashMap = new HashMap();
        if (!AppStateModel.getInstance().isCommunitySupport()) {
            m9824bz(false);
            hashMap.put("value", "Tools");
        } else {
            m9824bz(true);
            C1487a.aUa().mo9777a(new Runnable() {
                public void run() {
                    C3972a.this.m9822LW();
                }
            }, 1, TimeUnit.SECONDS);
            hashMap.put("value", "Community");
        }
        UserBehaviorLog.onKVEvent(context, "App_Type", hashMap);
    }

    /* renamed from: d */
    public void mo23579d(boolean z, int i) {
        if (i > 0) {
            this.bsr.getVideoTabModel().getNewCountField().set(Integer.valueOf(i));
        } else if (z) {
            this.bsr.getVideoTabModel().isNewField().set(Boolean.valueOf(true));
        } else {
            this.bsr.getVideoTabModel().getNewCountField().set(Integer.valueOf(0));
            this.bsr.getVideoTabModel().isNewField().set(Boolean.valueOf(false));
        }
    }

    /* renamed from: e */
    public void mo23580e(boolean z, int i) {
        if (i > 0) {
            this.bsr.getMsgTabModel().getNewCountField().set(Integer.valueOf(i));
        } else if (z) {
            this.bsr.getMsgTabModel().isNewField().set(Boolean.valueOf(true));
        } else {
            this.bsr.getMsgTabModel().getNewCountField().set(Integer.valueOf(0));
            this.bsr.getMsgTabModel().isNewField().set(Boolean.valueOf(false));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
        if (com.introvd.template.common.model.AppStateModel.getInstance().isMiddleEast() != false) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008c  */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo23581g(android.content.Context r8, boolean r9) {
        /*
            r7 = this;
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r1 = com.introvd.template.p242d.C5527a.cnQ
            r2 = 1
            int r0 = r0.getAppSettingInt(r1, r2)
            com.introvd.template.app.b.b r1 = com.introvd.template.app.p177b.C3742b.m9111II()
            boolean r1 = r1.isCommunityCloseSoon()
            r3 = 0
            if (r1 == 0) goto L_0x0022
            com.introvd.template.common.model.AppStateModel r1 = com.introvd.template.common.model.AppStateModel.getInstance()
            boolean r1 = r1.isCommunityCloseSoon()
            if (r1 == 0) goto L_0x0022
            r1 = 1
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            boolean r4 = m9820LQ()
            r5 = 2
            if (r4 == 0) goto L_0x00a6
            com.introvd.template.common.model.AppStateModel r0 = com.introvd.template.common.model.AppStateModel.getInstance()
            boolean r0 = r0.isCommunitySupport()
            if (r0 == 0) goto L_0x009b
            if (r1 == 0) goto L_0x0038
            goto L_0x009b
        L_0x0038:
            com.introvd.template.app.b.b r0 = com.introvd.template.app.p177b.C3742b.m9111II()
            int r0 = r0.mo23117IK()
            r1 = 4
            r4 = 3
            if (r0 != r1) goto L_0x0046
        L_0x0044:
            r1 = 1
            goto L_0x008a
        L_0x0046:
            if (r0 != r4) goto L_0x0055
            if (r9 == 0) goto L_0x0053
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r5 = com.introvd.template.router.community.util.CommunityPageTabConstants.KEY_SAVED_TAB_ID
            r1.setAppSettingInt(r5, r4)
        L_0x0053:
            r1 = 0
            goto L_0x008a
        L_0x0055:
            r6 = 5
            if (r0 != r6) goto L_0x005a
            r1 = 2
            goto L_0x008a
        L_0x005a:
            r6 = 6
            if (r0 != r6) goto L_0x005f
            r1 = 3
            goto L_0x008a
        L_0x005f:
            if (r0 != r2) goto L_0x006d
            if (r9 == 0) goto L_0x0053
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r4 = com.introvd.template.router.community.util.CommunityPageTabConstants.KEY_SAVED_TAB_ID
            r1.setAppSettingInt(r4, r2)
            goto L_0x0053
        L_0x006d:
            if (r0 != r5) goto L_0x007b
            if (r9 == 0) goto L_0x0053
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r4 = com.introvd.template.router.community.util.CommunityPageTabConstants.KEY_SAVED_TAB_ID
            r1.setAppSettingInt(r4, r5)
            goto L_0x0053
        L_0x007b:
            r4 = 7
            if (r0 != r4) goto L_0x007f
            goto L_0x008a
        L_0x007f:
            com.introvd.template.common.model.AppStateModel r1 = com.introvd.template.common.model.AppStateModel.getInstance()
            boolean r1 = r1.isMiddleEast()
            if (r1 == 0) goto L_0x0044
            goto L_0x0053
        L_0x008a:
            if (r9 == 0) goto L_0x0099
            java.lang.String r4 = "default_page"
            if (r0 == 0) goto L_0x0092
            java.lang.String r4 = "VCM_set_page"
        L_0x0092:
            java.lang.String r0 = r7.m9825gS(r1)
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordFirstPage(r8, r0, r4)
        L_0x0099:
            r0 = r1
            goto L_0x00e1
        L_0x009b:
            if (r9 == 0) goto L_0x00a4
            java.lang.String r0 = "Home"
            java.lang.String r1 = "default_page"
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordFirstPage(r8, r0, r1)
        L_0x00a4:
            r0 = 1
            goto L_0x00e1
        L_0x00a6:
            com.introvd.template.app.b.b r1 = com.introvd.template.app.p177b.C3742b.m9111II()
            boolean r1 = r1.mo23136JD()
            if (r1 == 0) goto L_0x00d6
            com.introvd.template.common.model.AppStateModel r1 = com.introvd.template.common.model.AppStateModel.getInstance()
            boolean r1 = r1.isMiddleEast()
            if (r1 != 0) goto L_0x00bc
            r0 = 1
            goto L_0x00ca
        L_0x00bc:
            if (r0 == r2) goto L_0x00ca
            if (r9 == 0) goto L_0x00c9
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r1 = com.introvd.template.router.community.util.CommunityPageTabConstants.KEY_SAVED_TAB_ID
            r0.setAppSettingInt(r1, r5)
        L_0x00c9:
            r0 = 0
        L_0x00ca:
            if (r9 == 0) goto L_0x00e1
            java.lang.String r1 = r7.m9825gS(r0)
            java.lang.String r4 = "last_time_page"
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordFirstPage(r8, r1, r4)
            goto L_0x00e1
        L_0x00d6:
            if (r9 == 0) goto L_0x00e1
            java.lang.String r1 = r7.m9825gS(r0)
            java.lang.String r4 = "last_time_page"
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordFirstPage(r8, r1, r4)
        L_0x00e1:
            if (r9 == 0) goto L_0x00f4
            r7.mo23584gV(r0)
            m9821LR()
            if (r0 != r2) goto L_0x00f4
            com.introvd.template.common.AppPreferencesSetting r8 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r9 = "pref_home_creation_icon_use_webp"
            r8.setAppSettingBoolean(r9, r3)
        L_0x00f4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.homepage.hometab.C3972a.mo23581g(android.content.Context, boolean):int");
    }

    /* renamed from: gT */
    public RelativeLayout mo23582gT(int i) {
        return this.bsq.mo23533gO(i);
    }

    /* renamed from: gU */
    public void mo23583gU(int i) {
        this.bsr.getVideoTabModel().getNameField().set(VivaBaseApplication.m8749FZ().getString(i));
    }

    /* renamed from: gV */
    public boolean mo23584gV(int i) {
        return this.bsq.mo23536r(i, true);
    }

    public void setTabOnClickListener(C3969a aVar) {
        this.bsq.setTabOnClickListener(aVar);
    }

    public void uninit() {
        this.bsq.mo23538LO();
    }
}
