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
import com.introvd.template.R;
import com.introvd.template.app.homepage.C3950d;
import com.introvd.template.app.homepage.p186a.C3932b.C3934a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.ViewClickEffectMgr;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.p310g.C7356ac;
import com.introvd.template.p310g.C7386y;
import com.introvd.template.router.LoginRouter;
import com.introvd.template.router.user.UserServiceProxy;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

public class HomeTabLayoutV2 extends HomeTabLayoutBase {
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            int i;
            int i2;
            if (view.equals(HomeTabLayoutV2.this.bst.cqK)) {
                i = 0;
                i2 = 18002;
            } else if (view.equals(HomeTabLayoutV2.this.bst.cqJ)) {
                if (HomeTabLayoutV2.this.bsm != null && HomeTabLayoutV2.this.bsm.mo23465LJ()) {
                    HomeTabLayoutV2.this.bsm.mo23464LI();
                    UserBehaviorABTestUtils.homeCreateTipDisappear(HomeTabLayoutV2.this.getContext(), "click_tab");
                    if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_help_V2_show_flag", true)) {
                        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_help_V2_show_flag", false);
                    }
                }
                if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_icon_use_webp", true)) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_icon_use_webp", false);
                }
                i = 1;
                i2 = 18003;
            } else if (view.equals(HomeTabLayoutV2.this.bst.cqN)) {
                i = 3;
                i2 = 18005;
            } else if (view.equals(HomeTabLayoutV2.this.bst.cqL)) {
                i = 2;
                i2 = 18004;
            } else {
                i = -1;
                i2 = -1;
            }
            if (i != 2 || UserServiceProxy.isLogin()) {
                boolean z = C7386y.m21767a(HomeTabLayoutV2.this.bsn.getLastFocusTabIdField()) == i;
                if (!z) {
                    if (!((HomeTabLayoutV2.this.bru == null || i == -1) ? false : HomeTabLayoutV2.this.bru.mo23453gM(i))) {
                        HomeTabLayoutV2.this.mo23536r(i, true);
                    } else {
                        return;
                    }
                }
                if (!(HomeTabLayoutV2.this.bru == null || i == -1)) {
                    HomeTabLayoutV2.this.bru.mo23454q(i, z);
                }
                HomeTabLayoutV2.this.bsn.getLastFocusTabIdField().set(Integer.valueOf(i));
                if (HomeTabLayoutV2.this.bsi) {
                    int gG = C3950d.m9740Lm().mo23513gG(i2);
                    String gF = C3950d.m9740Lm().mo23512gF(i2);
                    Context context = HomeTabLayoutV2.this.getContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(gG);
                    sb.append("");
                    UserBehaviorABTestUtils.onEventNavigationbarIcon(context, gF, sb.toString(), false);
                }
                return;
            }
            LoginRouter.startSettingBindAccountActivity((Activity) HomeTabLayoutV2.this.getContext());
        }
    };
    /* access modifiers changed from: private */
    public boolean bsi;
    private boolean bsj;
    /* access modifiers changed from: private */
    public C7356ac bst;

    public HomeTabLayoutV2(Context context) {
        super(context);
        m9805LL();
    }

    public HomeTabLayoutV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9805LL();
    }

    public HomeTabLayoutV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9805LL();
    }

    /* renamed from: LL */
    private void m9805LL() {
        this.bst = (C7356ac) C0171f.m365a(LayoutInflater.from(getContext()), R.layout.home_tab_layout_v2, (ViewGroup) this, true);
        ViewClickEffectMgr.addEffectForViews(HomeTabLayoutV2.class.getSimpleName(), this.bst.cqJ);
        ViewClickEffectMgr.addEffectForViews(HomeTabLayoutV2.class.getSimpleName(), this.bst.cqK);
        ViewClickEffectMgr.addEffectForViews(HomeTabLayoutV2.class.getSimpleName(), this.bst.cqN);
        ViewClickEffectMgr.addEffectForViews(HomeTabLayoutV2.class.getSimpleName(), this.bst.cqL);
        this.bst.cqK.setOnClickListener(this.acD);
        this.bst.cqJ.setOnClickListener(this.acD);
        this.bst.cqN.setOnClickListener(this.acD);
        this.bst.cqL.setOnClickListener(this.acD);
        if (!TextUtils.isEmpty(C3742b.m9111II().mo23135JC()) && !C3742b.m9111II().mo23135JC().equals("0")) {
            this.bst.cqP.setText(C3742b.m9111II().mo23135JC());
        }
        this.bsm.mo23468a((C3934a) new C3934a() {
            /* renamed from: LK */
            public void mo23472LK() {
                UserBehaviorABTestUtils.homeTabCreateTipClick(HomeTabLayoutV2.this.getContext());
                UserBehaviorABTestUtils.homeCreateTipDisappear(HomeTabLayoutV2.this.getContext(), "click_tip");
                if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_icon_use_webp", true)) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_icon_use_webp", false);
                }
                if (HomeTabLayoutV2.this.bru != null) {
                    boolean z = C7386y.m21767a(HomeTabLayoutV2.this.bsn.getLastFocusTabIdField()) == 1;
                    if (!z) {
                        HomeTabLayoutV2.this.mo23536r(1, true);
                    }
                    HomeTabLayoutV2.this.bru.mo23454q(1, z);
                    if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_help_V2_show_flag", true)) {
                        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_help_V2_show_flag", false);
                    }
                    HomeTabLayoutV2.this.bsn.getLastFocusTabIdField().set(Integer.valueOf(1));
                }
            }
        });
    }

    /* renamed from: gQ */
    private DynamicLoadingImageView m9808gQ(int i) {
        if (18002 == i) {
            return this.bst.cqF;
        }
        if (18003 == i) {
            return this.bst.cqE;
        }
        if (18005 == i) {
            return this.bst.cqI;
        }
        if (18004 == i) {
            return this.bst.cqG;
        }
        return null;
    }

    /* renamed from: gR */
    private int m9809gR(int i) {
        if (C3742b.m9111II().mo23177Jx() == 0) {
            if (18002 == i) {
                return AppStateModel.getInstance().isMiddleEast() ? R.drawable.app_selector_home_tab_find_grey_mideast : R.drawable.btn_home_tab_find_selector;
            }
            if (18003 == i) {
                return R.drawable.btn_home_tab_creation_selector_v2;
            }
            if (18005 == i) {
                return R.drawable.btn_home_tab_studio_selector;
            }
            if (18004 == i) {
                return R.drawable.btn_home_tab_message_selector;
            }
            return -1;
        } else if (18002 == i) {
            return AppStateModel.getInstance().isMiddleEast() ? R.drawable.app_selector_home_tab_find_dark_mideast : R.drawable.btn_home_tab_find_selector_new;
        } else {
            if (18003 == i) {
                return R.drawable.btn_home_tab_creation_selector_new;
            }
            if (18005 == i) {
                return R.drawable.btn_home_tab_studio_selector_new;
            }
            if (18004 == i) {
                return R.drawable.btn_home_tab_message_selector_new;
            }
            return -1;
        }
    }

    /* renamed from: s */
    private void m9810s(int i, boolean z) {
        if (i == 0) {
            setFindTabSelection(z);
        } else if (i == 1) {
            setCreationTabSelection(z);
        } else if (i == 3) {
            setStudioTabSelection(z);
        } else if (i == 2) {
            setMessageTabSelection(z);
        }
    }

    private void setCreationTabSelection(boolean z) {
        this.bst.cqE.setSelected(z);
        this.bst.cqP.setSelected(z);
        m9811t(18003, z);
    }

    private void setFindTabSelection(boolean z) {
        this.bst.cqQ.setSelected(z);
        this.bst.cqF.setSelected(z);
        m9811t(18002, z);
    }

    private void setMessageTabSelection(boolean z) {
        this.bst.cqR.setSelected(z);
        this.bst.cqG.setSelected(z);
        m9811t(18004, z);
    }

    private void setStudioTabSelection(boolean z) {
        this.bst.cqT.setSelected(z);
        this.bst.cqI.setSelected(z);
        m9811t(18005, z);
    }

    /* renamed from: t */
    private void m9811t(int i, boolean z) {
        DynamicLoadingImageView gQ = m9808gQ(i);
        if (gQ != null) {
            int gR = m9809gR(i);
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
                if (AppPreferencesSetting.getInstance().getAppSettingInt(C5527a.cnQ, 1) == 1) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_icon_use_webp", false);
                }
                if ((Ju == 2 || Ju == 3) && 18003 == i && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_icon_use_webp", true)) {
                    ImageLoader.loadImage(R.drawable.home_tab_create_animation, gQ);
                    return;
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
        m9811t(18002, this.bst.cqF.isSelected());
        m9811t(18003, this.bst.cqE.isSelected());
        m9811t(18004, this.bst.cqG.isSelected());
        m9811t(18005, this.bst.cqI.isSelected());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: LN */
    public void mo23531LN() {
        super.mo23539h(this.bst.cqJ, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23532a(HomeTabLayoutModel homeTabLayoutModel) {
        this.bsn = homeTabLayoutModel;
        this.bst.mo31992b(homeTabLayoutModel);
    }

    /* renamed from: gO */
    public RelativeLayout mo23533gO(int i) {
        if (i == 0) {
            return this.bst.cqK;
        }
        if (i == 1) {
            return this.bst.cqJ;
        }
        if (i == 3) {
            return this.bst.cqN;
        }
        return null;
    }

    /* renamed from: gP */
    public ImageView mo23534gP(int i) {
        if (i == 0) {
            return this.bst.cqF;
        }
        if (i == 1) {
            return this.bst.cqE;
        }
        if (i == 3) {
            return this.bst.cqI;
        }
        return null;
    }

    /* renamed from: r */
    public boolean mo23536r(int i, boolean z) {
        if (C7386y.m21767a(this.bsn.getLastFocusTabIdField()) == i) {
            return false;
        }
        m9810s(C7386y.m21767a(this.bsn.getLastFocusTabIdField()), false);
        m9810s(i, true);
        this.bsn.getLastFocusTabIdField().set(Integer.valueOf(i));
        return true;
    }
}
