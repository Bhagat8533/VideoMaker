package com.introvd.template.app.homepage.hometab;

import android.app.Activity;
import android.content.Context;
import android.databinding.C0171f;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.R;
import com.introvd.template.app.homepage.C3950d;
import com.introvd.template.app.homepage.HomeView;
import com.introvd.template.app.homepage.p186a.C3932b.C3934a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p189i.C4003a;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.ViewClickEffectMgr;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.p310g.C7354aa;
import com.introvd.template.p310g.C7386y;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

public class HomeTabLayout extends HomeTabLayoutBase {
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            int i;
            int i2;
            if (view.equals(HomeTabLayout.this.bsk.cqK)) {
                i = 0;
                i2 = 18002;
            } else if (view.equals(HomeTabLayout.this.bsk.cqJ)) {
                if (HomeTabLayout.this.bsm != null && HomeTabLayout.this.bsm.mo23465LJ()) {
                    HomeTabLayout.this.bsm.mo23464LI();
                    UserBehaviorABTestUtils.homeCreateTipDisappear(HomeTabLayout.this.getContext(), "click_tab");
                    if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_help_V2_show_flag", true)) {
                        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_help_V2_show_flag", false);
                    }
                }
                if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_icon_use_webp", true)) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_icon_use_webp", false);
                }
                i = 1;
                i2 = 18003;
            } else if (view.equals(HomeTabLayout.this.bsk.cqN)) {
                i = 3;
                i2 = 18005;
            } else {
                i = view.equals(HomeTabLayout.this.bsk.cqM) ? 4 : -1;
                i2 = -1;
            }
            boolean z = C7386y.m21767a(HomeTabLayout.this.bsn.getLastFocusTabIdField()) == i;
            if (!z) {
                if (!((HomeTabLayout.this.bru == null || i == -1) ? false : HomeTabLayout.this.bru.mo23453gM(i))) {
                    HomeTabLayout.this.mo23536r(i, true);
                } else {
                    return;
                }
            }
            if (!(HomeTabLayout.this.bru == null || i == -1)) {
                HomeTabLayout.this.bru.mo23454q(i, z);
            }
            HomeTabLayout.this.bsn.getLastFocusTabIdField().set(Integer.valueOf(i));
            if (HomeTabLayout.this.bsi) {
                int gG = C3950d.m9740Lm().mo23513gG(i2);
                String gF = C3950d.m9740Lm().mo23512gF(i2);
                Context context = HomeTabLayout.this.getContext();
                StringBuilder sb = new StringBuilder();
                sb.append(gG);
                sb.append("");
                UserBehaviorABTestUtils.onEventNavigationbarIcon(context, gF, sb.toString(), false);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean bsi;
    private boolean bsj;
    /* access modifiers changed from: private */
    public C7354aa bsk;

    public HomeTabLayout(Context context) {
        super(context);
        m9781LL();
    }

    public HomeTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9781LL();
    }

    public HomeTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9781LL();
    }

    /* renamed from: LL */
    private void m9781LL() {
        this.bsk = (C7354aa) C0171f.m365a(LayoutInflater.from(getContext()), R.layout.home_tab_layout, (ViewGroup) this, true);
        if (!AppStateModel.getInstance().isVivaSchoolTabSupport() || C4023a.m9973MK().mo23677MP()) {
            this.bsk.cqM.setVisibility(8);
        } else {
            this.bsk.cqM.setVisibility(0);
        }
        if (!TextUtils.isEmpty(C3742b.m9111II().mo23135JC()) && !C3742b.m9111II().mo23135JC().equals("0")) {
            this.bsk.cqP.setText(C3742b.m9111II().mo23135JC());
        }
        if (C3742b.m9111II().mo23177Jx() == 1) {
            this.bsk.cqP.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.bsk.cqE.getLayoutParams();
            layoutParams.width = C7689a.m22597aR(45.0f);
            layoutParams.height = C7689a.m22597aR(45.0f);
            this.bsk.cqE.setLayoutParams(layoutParams);
        }
        ViewClickEffectMgr.addEffectForViews(HomeTabLayoutV2.class.getSimpleName(), this.bsk.cqJ);
        ViewClickEffectMgr.addEffectForViews(HomeTabLayoutV2.class.getSimpleName(), this.bsk.cqK);
        ViewClickEffectMgr.addEffectForViews(HomeTabLayoutV2.class.getSimpleName(), this.bsk.cqN);
        ViewClickEffectMgr.addEffectForViews(HomeTabLayoutV2.class.getSimpleName(), this.bsk.cqM);
        this.bsk.cqK.setOnClickListener(this.acD);
        this.bsk.cqJ.setOnClickListener(this.acD);
        this.bsk.cqN.setOnClickListener(this.acD);
        this.bsk.cqM.setOnClickListener(this.acD);
        this.bsm.mo23468a((C3934a) new C3934a() {
            /* renamed from: LK */
            public void mo23472LK() {
                UserBehaviorABTestUtils.homeTabCreateTipClick(HomeTabLayout.this.getContext());
                UserBehaviorABTestUtils.homeCreateTipDisappear(HomeTabLayout.this.getContext(), "click_tip");
                if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_icon_use_webp", true)) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_icon_use_webp", false);
                }
                if (HomeTabLayout.this.bru != null) {
                    boolean z = C7386y.m21767a(HomeTabLayout.this.bsn.getLastFocusTabIdField()) == 1;
                    if (!z) {
                        HomeTabLayout.this.mo23536r(1, true);
                    }
                    HomeTabLayout.this.bru.mo23454q(1, z);
                    if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_help_V2_show_flag", true)) {
                        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_help_V2_show_flag", false);
                    }
                    HomeTabLayout.this.bsn.getLastFocusTabIdField().set(Integer.valueOf(1));
                }
            }
        });
    }

    /* renamed from: gQ */
    private DynamicLoadingImageView m9784gQ(int i) {
        if (18002 == i) {
            return this.bsk.cqF;
        }
        if (18003 == i) {
            return this.bsk.cqE;
        }
        if (18005 == i) {
            return this.bsk.cqI;
        }
        return null;
    }

    /* renamed from: gR */
    private int m9785gR(int i) {
        if (C3742b.m9111II().mo23177Jx() == 0) {
            if (18002 == i) {
                return AppStateModel.getInstance().isInChina() ? R.drawable.btn_home_tab_find_cn_selector : AppStateModel.getInstance().isMiddleEast() ? R.drawable.app_selector_home_tab_find_grey_mideast : R.drawable.btn_home_tab_find_selector;
            }
            if (18003 == i) {
                return R.drawable.btn_home_tab_creation_selector;
            }
            if (18005 == i) {
                return R.drawable.btn_home_tab_studio_selector;
            }
            return -1;
        } else if (18002 == i) {
            return AppStateModel.getInstance().isInChina() ? R.drawable.btn_home_tab_find_cn_selector_new : R.drawable.btn_home_tab_find_selector_new;
        } else {
            if (18003 == i) {
                return R.drawable.btn_home_tab_creation_selector_new;
            }
            if (18005 == i) {
                return R.drawable.btn_home_tab_studio_selector_new;
            }
            return -1;
        }
    }

    /* renamed from: s */
    private void m9786s(int i, boolean z) {
        if (i == 0) {
            setFindTabSelection(z);
        } else if (i == 1) {
            setCreationTabSelection(z);
        } else if (i == 3) {
            setStudioTabSelection(z);
        } else if (i == 4) {
            setSchoolTabSelection(z);
        }
    }

    private void setCreationTabSelection(boolean z) {
        this.bsk.cqP.setSelected(z);
        this.bsk.cqE.setSelected(z);
        m9787t(18003, z);
    }

    private void setFindTabSelection(boolean z) {
        this.bsk.cqQ.setSelected(z);
        this.bsk.cqF.setSelected(z);
        m9787t(18002, z);
    }

    private void setSchoolTabSelection(boolean z) {
        this.bsk.cqS.setSelected(z);
        this.bsk.cqH.setSelected(z);
    }

    private void setStudioTabSelection(boolean z) {
        this.bsk.cqT.setSelected(z);
        this.bsk.cqI.setSelected(z);
        m9787t(18005, z);
    }

    /* renamed from: t */
    private void m9787t(int i, boolean z) {
        DynamicLoadingImageView gQ = m9784gQ(i);
        if (gQ != null) {
            int gR = m9785gR(i);
            if (this.bsi) {
                ImageLoader.loadImage(C3950d.m9740Lm().mo23515p(i, z), gQ);
                int gG = C3950d.m9740Lm().mo23513gG(i);
                String gF = C3950d.m9740Lm().mo23512gF(i);
                Context context = getContext();
                StringBuilder sb = new StringBuilder();
                sb.append(gG);
                sb.append("");
                UserBehaviorABTestUtils.onEventNavigationbarIcon(context, gF, sb.toString(), true);
            } else if (gR != -1) {
                int Ju = C3742b.m9111II().mo23174Ju();
                int Jx = C3742b.m9111II().mo23177Jx();
                boolean z2 = Ju == 2 || Ju == 3;
                boolean z3 = Jx == 1;
                if (z2 && z3) {
                    if (AppPreferencesSetting.getInstance().getAppSettingInt(C5527a.cnQ, 1) == 1) {
                        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_icon_use_webp", false);
                    }
                    if (18003 == i && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_icon_use_webp", true)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("res://");
                        sb2.append(gQ.getContext().getPackageName());
                        sb2.append("/");
                        sb2.append(R.drawable.home_tab_create_animation);
                        ImageLoader.loadImage(sb2.toString(), R.drawable.home_tab_create_new, R.drawable.home_tab_create_new, getResources().getDrawable(R.drawable.home_tab_create_new), gQ);
                        return;
                    }
                }
                gQ.setImageResource(gR);
            }
        }
    }

    /* renamed from: LM */
    public void mo23530LM() {
        String gH = C3950d.m9740Lm().mo23514gH(18006);
        this.bsi = C3950d.m9740Lm().mo23510Lo();
        if (!TextUtils.isEmpty(gH) && this.bsi) {
            this.bsn.getBgUrlField().set(gH);
        }
        if (this.bsi) {
            String p = C3950d.m9740Lm().mo23515p(18002, false);
            if (!this.bsj && !TextUtils.isEmpty(p)) {
                this.bsj = true;
                UserBehaviorUtilsV5.onEventHomeSkinChange(getContext(), p);
            }
        }
        m9787t(18002, this.bsk.cqF.isSelected());
        m9787t(18003, this.bsk.cqE.isSelected());
        m9787t(18005, this.bsk.cqI.isSelected());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: LN */
    public void mo23531LN() {
        super.mo23539h(this.bsk.cqJ, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23532a(HomeTabLayoutModel homeTabLayoutModel) {
        this.bsn = homeTabLayoutModel;
        this.bsk.mo31991b(homeTabLayoutModel);
    }

    /* renamed from: gO */
    public RelativeLayout mo23533gO(int i) {
        if (i == 0) {
            return this.bsk.cqK;
        }
        if (i == 1) {
            return this.bsk.cqJ;
        }
        if (i == 3) {
            return this.bsk.cqN;
        }
        if (i == 4) {
            return this.bsk.cqM;
        }
        return null;
    }

    /* renamed from: gP */
    public ImageView mo23534gP(int i) {
        if (i == 0) {
            return this.bsk.cqF;
        }
        if (i == 1) {
            return this.bsk.cqE;
        }
        if (i == 3) {
            return this.bsk.cqI;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* renamed from: r */
    public boolean mo23536r(int i, boolean z) {
        if (C7386y.m21767a(this.bsn.getLastFocusTabIdField()) == i) {
            return false;
        }
        m9786s(C7386y.m21767a(this.bsn.getLastFocusTabIdField()), false);
        m9786s(i, true);
        this.bsn.getLastFocusTabIdField().set(Integer.valueOf(i));
        if (i == 3) {
            C4003a.dismiss();
        } else if (!HomeView.brm) {
            C4003a.m9890a((Activity) getContext(), this.bsk.cqN);
        }
        return true;
    }
}
