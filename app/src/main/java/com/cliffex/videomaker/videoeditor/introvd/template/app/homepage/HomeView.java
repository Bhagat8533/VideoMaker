package com.introvd.template.app.homepage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.app.FragmentManager;
import android.support.p021v4.app.FragmentTransaction;
import android.support.p021v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.aiii.android.arouter.p091c.C1919a;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.introvd.template.C3569a;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.apicore.C3624b;
import com.introvd.template.app.C3869e;
import com.introvd.template.app.ads.C3712c;
import com.introvd.template.app.ads.C3719d;
import com.introvd.template.app.community.freeze.C3763b;
import com.introvd.template.app.community.usergrade.C3786c;
import com.introvd.template.app.community.usergrade.C3797h;
import com.introvd.template.app.creation.CreationFragment;
import com.introvd.template.app.creation.testb.BCreationFragment;
import com.introvd.template.app.homepage.hometab.C3972a;
import com.introvd.template.app.homepage.hometab.HomeTabLayoutBase.C3969a;
import com.introvd.template.app.homepage.pop.C3979a;
import com.introvd.template.app.homepage.pop.C3989d;
import com.introvd.template.app.homepage.pop.C3991e;
import com.introvd.template.app.homepage.pop.C3993f;
import com.introvd.template.app.homepage.pop.C3996g;
import com.introvd.template.app.homepage.pop.p188b.C3986b;
import com.introvd.template.app.p176a.C3676a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.app.p193m.C4040a;
import com.introvd.template.app.p199v5.common.C4412a;
import com.introvd.template.app.push.C4103b;
import com.introvd.template.app.school.SchoolCreationFragment;
import com.introvd.template.app.school.SchoolCreationFragmentTestA;
import com.introvd.template.app.school.SchoolCreationFragmentTestB;
import com.introvd.template.app.school.SchoolFragment;
import com.introvd.template.app.utils.AppStateInitIntentService;
import com.introvd.template.app.utils.C4402e;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FeedbackRefreshEvent;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.behavior.UserBehaviorUtilsV7;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.component.feedback.C5349b;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.business.coupon.C7858e;
import com.introvd.template.module.iap.business.exchange.C7916c;
import com.introvd.template.module.iap.business.exchange.C7916c.C7920a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p330d.C7602b;
import com.introvd.template.p153p.C3209a.C3210a;
import com.introvd.template.p173a.C3570a;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4585f;
import com.introvd.template.p203b.C4599k;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.community.ICommunityService;
import com.introvd.template.router.community.event.MessageTipsEvent;
import com.introvd.template.router.community.event.ScrollTopEvent;
import com.introvd.template.router.community.util.CommunityPageTabConstants;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.iaphuawei.HuaweiIAPServiceProxy;
import com.introvd.template.router.lbs.LbsManagerProxy;
import com.introvd.template.router.lbs.LbsRouter;
import com.introvd.template.router.lbs.LocationInfo;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.wxapi.C9083a;
import com.introvd.template.xyui.BadgeHelper;
import com.p131c.p132a.C2561a;
import com.quvideo.priority.p217a.C4892c;
import com.quvideo.priority.p217a.C4897f;
import com.xiaoying.p448a.C9537b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p076j.C1820a;

public class HomeView extends BaseHomeView {
    public static boolean brm;
    private C4897f bdv;
    /* access modifiers changed from: private */
    public BadgeHelper bou;
    private Fragment bqX;
    private Fragment bqY;
    private Fragment bqZ;
    private Fragment bra;
    private Fragment brb;
    private FragmentManager brc;
    public C3972a brd;
    private HeadsetPlugReceiver bre;
    private Bundle brf;
    private boolean brg = false;
    private int brh = 0;
    private C4412a bri;
    private boolean brj;
    private ICommunityService brk;
    /* access modifiers changed from: private */
    public View brl;
    private C4892c brn = C8049f.aBf().aBn();
    private C4892c bro = C8049f.aBf().mo33080a(null);
    private C4892c brp = new C3993f(null);
    private C4892c brq = new C3991e();
    private C4892c brr = new C3989d();
    private C4892c brs = new C3979a(null);
    private C4892c brt = new C3996g(null);
    private C3969a bru = new C3969a() {
        /* renamed from: gM */
        public boolean mo23453gM(int i) {
            if (HomeView.this.brd.mo23577LV() == 0) {
                boolean z = true;
                if (i == 1) {
                    ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
                    if (iCommunityAPI == null) {
                        return false;
                    }
                    HomeView.this.brl = iCommunityAPI.checkNeedMissionPopupView(HomeView.this);
                    if (HomeView.this.brl == null) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        /* renamed from: q */
        public void mo23454q(int i, boolean z) {
            if (z) {
                HomeView.this.m9658gJ(i);
            } else {
                HomeView.this.m9642a(i, false, true);
            }
        }
    };
    /* access modifiers changed from: private */
    public FragmentActivity mActivity;
    private Handler mHandler;

    public class HeadsetPlugReceiver extends BroadcastReceiver {
        public HeadsetPlugReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!intent.hasExtra("state")) {
                return;
            }
            if (intent.getIntExtra("state", 0) == 0) {
                C10021c.aZH().mo38492aA(new C3210a(false));
            } else if (intent.getIntExtra("state", 0) == 1) {
                C10021c.aZH().mo38492aA(new C3210a(true));
            }
        }
    }

    /* renamed from: com.introvd.template.app.homepage.HomeView$a */
    private static class C3927a extends Handler {
        final WeakReference<HomeView> bry;

        public C3927a(HomeView homeView) {
            super(Looper.getMainLooper());
            this.bry = new WeakReference<>(homeView);
        }

        public void handleMessage(Message message) {
            HomeView homeView = (HomeView) this.bry.get();
            if (homeView != null) {
                switch (message.what) {
                    case 1003:
                        int a = homeView.m9657gI(AppPreferencesSetting.getInstance().getAppSettingInt(C5527a.cnQ, 1));
                        homeView.brd.mo23584gV(a);
                        homeView.m9642a(a, false, false);
                        break;
                    case 1004:
                        homeView.brd.mo23573LM();
                        homeView.brd.mo23583gU(R.string.xiaoying_str_home_xycircle_tab_title);
                        break;
                    case 1006:
                        homeView.m9634Lt();
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    public HomeView(Context context) {
        super(context);
        this.mActivity = (FragmentActivity) context;
        init();
    }

    public HomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivity = (FragmentActivity) context;
        init();
    }

    public HomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivity = (FragmentActivity) context;
        init();
    }

    /* renamed from: Lq */
    private void m9631Lq() {
        String dI = C4585f.m11690dI(getContext().getApplicationContext());
        String dG = C4585f.m11688dG(getContext().getApplicationContext());
        StringBuilder sb = new StringBuilder();
        sb.append(">>>udidv1=");
        sb.append(dI);
        sb.append(",udidv2=");
        sb.append(dG);
        LogUtilsV2.m14228e(sb.toString());
    }

    /* renamed from: Lr */
    private void m9632Lr() {
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                C3935b.m9679Lb().mo23486cj(HomeView.this.getContext());
                HomeView.this.m9650bx(false);
            }
        });
    }

    /* renamed from: Ls */
    private void m9633Ls() {
        C3797h.m9288Ix().mo23278Iy();
        int freezeCode = C3763b.getFreezeCode();
        if (freezeCode != -1) {
            C3763b.m9231Is().mo23237e(getContext(), UserServiceProxy.getUserId(), freezeCode);
        }
        if (UserServiceProxy.isLogin() && AppStateModel.getInstance().isInChina()) {
            C3786c.m9273Iv().mo23269a(getContext(), "", null);
        }
        C4103b.m10188cu(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: Lt */
    public void m9634Lt() {
        m9637Lw();
        C7680l.aAf().mo32493gk(this.mActivity);
        C7680l.aAe().mo32526aj(this.mActivity.getApplicationContext(), 34);
        C7680l.aAe().mo32526aj(this.mActivity.getApplicationContext(), 37);
        C7680l.aAe().mo32526aj(this.mActivity.getApplicationContext(), 36);
        if (C3569a.m8772FK()) {
            C7680l.aAe().mo32526aj(this.mActivity, 22);
        }
        if (AdParamMgr.getAdType(18) == 3) {
            C7680l.aAe().mo32526aj(this.mActivity.getApplicationContext(), 18);
            UserBehaviorLog.onKVEvent(this.mActivity.getApplicationContext(), "Ad_Incentive_Request", new HashMap());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Lu */
    public void m9635Lu() {
        int g = this.brd.mo23581g(getContext(), true);
        C7897a.m23022b(String.valueOf(g), "Iap_default_init_home_tab_id", new String[0]);
        m9642a(g, true, true);
        if (g == 1 || !AppStateModel.getInstance().isCommunitySupport() || AppStateModel.getInstance().isMessageTabSupport()) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_help_show_flag", false);
        }
        if (g == 1) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_icon_use_webp", false);
        }
    }

    /* renamed from: Lv */
    private void m9636Lv() {
        if (this.brd != null) {
            this.brd.mo23574LS().setImageResource(R.drawable.comm_icon_scroll_top);
            this.brd.mo23583gU(R.string.xiaoying_str_planet_recommend_back_top);
        }
    }

    /* renamed from: Lw */
    private void m9637Lw() {
        C3712c.m9010HP().mo23064HQ();
        C3712c.m9010HP().mo23065bP(this.mActivity);
        C3712c.m9010HP().initSdkInLauncherActivity(this.mActivity);
    }

    /* access modifiers changed from: private */
    /* renamed from: Lx */
    public /* synthetic */ int m9638Lx() {
        if (this.brd == null) {
            return 1;
        }
        return this.brd.mo23581g(getContext(), false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9642a(int i, boolean z, boolean z2) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && i != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("setTabSelection : ");
            sb.append(i);
            LogUtilsV2.m14230i(sb.toString());
            FragmentTransaction beginTransaction = this.brc.beginTransaction();
            m9643a(beginTransaction);
            String str = "unknow";
            boolean z3 = true;
            switch (i) {
                case 0:
                    if (this.brk != null) {
                        C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(true));
                        if (this.bqX == null) {
                            this.bqX = this.brk.createFindViewPagerFragment();
                            beginTransaction.add(R.id.content, this.bqX);
                        } else {
                            beginTransaction.show(this.bqX);
                        }
                        if (z2 && !C3961g.m9772Lz().isShowing()) {
                            getPopMgr().mo25353a("close_younger", (Collection<C4892c>) Arrays.asList(new C4892c[]{this.brs, this.brt}));
                        }
                        ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
                        if (iCommunityAPI != null) {
                            iCommunityAPI.checkNewFollowVideo();
                        }
                        str = "video";
                        this.bri.mo24483QQ();
                        this.brd.mo23579d(false, 0);
                        if (z) {
                            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt(CommunityPageTabConstants.KEY_SAVED_TAB_ID, AppStateModel.getInstance().isHotVideoEnable() ? 2 : 3);
                            if (appSettingInt != 1) {
                                if (appSettingInt != 2) {
                                    if (appSettingInt == 3) {
                                        C9083a.m26521cP(getContext(), "MixedPageFragment");
                                        break;
                                    }
                                } else {
                                    C9083a.m26521cP(getContext(), "VideoShowFragment");
                                    break;
                                }
                            } else {
                                C9083a.m26521cP(getContext(), "FollowVideoFragment");
                                break;
                            }
                        }
                    } else {
                        return;
                    }
                    break;
                case 1:
                    C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(false));
                    if (z2 && !C3961g.m9772Lz().isShowing()) {
                        getPopMgr().mo25353a("vipguide_toolfeature_coupon", (Collection<C4892c>) Arrays.asList(new C4892c[]{this.bro, this.brp, this.brn}));
                    }
                    if (this.bqY == null) {
                        if (C2561a.aON()) {
                            this.bqY = (Fragment) VivaRouter.getRouterBuilder(AppRouter.BIZ_APP_PRO_MAIN_FRAG).mo10412rX();
                        } else if (C2561a.aOS()) {
                            this.bqY = new BCreationFragment();
                        } else if (C4023a.m9973MK().mo23677MP()) {
                            int MQ = C4023a.m9973MK().mo23678MQ();
                            if (MQ == 2) {
                                this.bqY = new SchoolCreationFragmentTestA();
                            } else if (MQ == 3) {
                                this.bqY = new SchoolCreationFragmentTestB();
                            } else {
                                this.bqY = new SchoolCreationFragment();
                            }
                        } else if (C3742b.m9111II().mo23145JM()) {
                            this.bqY = new BCreationFragment();
                        } else {
                            this.bqY = new CreationFragment();
                            this.brf.putBoolean("home_help_show_flag", this.brj);
                            this.bqY.setArguments(this.brf);
                        }
                        if (this.bqY != null) {
                            beginTransaction.add(R.id.content, this.bqY);
                        }
                    } else {
                        beginTransaction.show(this.bqY);
                    }
                    ICommunityAPI iCommunityAPI2 = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
                    if (iCommunityAPI2 != null) {
                        iCommunityAPI2.checkNewFollowVideo();
                    }
                    str = "create";
                    this.bri.mo24482QP();
                    brm = false;
                    if (z) {
                        C9083a.m26521cP(getContext(), "CreationFragment");
                        break;
                    }
                    break;
                case 2:
                    if (this.brk != null) {
                        C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(false));
                        if (this.bra == null) {
                            this.bra = this.brk.createMessageFragment();
                            beginTransaction.add(R.id.content, this.bra);
                        } else {
                            beginTransaction.show(this.bra);
                        }
                        ICommunityAPI iCommunityAPI3 = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
                        if (iCommunityAPI3 == null || iCommunityAPI3.getTotalUnreadMessageCount() <= 0) {
                            z3 = false;
                        }
                        UserBehaviorUtilsV5.onEventMessageClick(z3);
                        str = "message";
                        this.brd.mo23580e(false, 0);
                        if (z) {
                            C9083a.m26521cP(getContext(), "MessageFragment");
                            break;
                        }
                    } else {
                        return;
                    }
                    break;
                case 3:
                    if (this.brk != null) {
                        C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(false));
                        if (this.bqZ == null) {
                            this.bqZ = this.brk.createStudioFragment();
                            beginTransaction.add(R.id.content, this.bqZ);
                        } else {
                            beginTransaction.show(this.bqZ);
                        }
                        ICommunityAPI iCommunityAPI4 = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
                        if (iCommunityAPI4 != null) {
                            iCommunityAPI4.checkNewFollowVideo();
                        }
                        str = "personal";
                        UserBehaviorUtilsV7.onEventPageviewHomepage(getContext(), "myself", "MyTab", this.bri.mo24486QT() ? "有" : "无");
                        if (this.bri != null) {
                            this.bri.mo24485QS();
                        }
                        if (z) {
                            C9083a.m26521cP(getContext(), "StudioFragmentNew");
                            break;
                        }
                    } else {
                        return;
                    }
                    break;
                case 4:
                    if (this.brb == null) {
                        this.brb = new SchoolFragment();
                        beginTransaction.add(R.id.content, this.brb);
                    } else {
                        beginTransaction.show(this.brb);
                    }
                    str = "school";
                    break;
            }
            C4040a.m10034X(getContext(), str);
            AppPreferencesSetting.getInstance().setAppSettingInt(C5527a.cnQ, i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            sb2.append("");
            AppPreferencesSetting.getInstance().setAppSettingStr("key_saved_home_tab_time", sb2.toString());
            try {
                beginTransaction.commitAllowingStateLoss();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m9643a(FragmentTransaction fragmentTransaction) {
        if (this.bqX != null) {
            fragmentTransaction.hide(this.bqX);
        }
        if (this.bqY != null) {
            fragmentTransaction.hide(this.bqY);
        }
        if (this.bqZ != null) {
            fragmentTransaction.hide(this.bqZ);
        }
        if (this.bra != null) {
            fragmentTransaction.hide(this.bra);
        }
        if (this.brb != null) {
            fragmentTransaction.hide(this.brb);
        }
    }

    /* renamed from: a */
    private void m9647a(MessageTipsEvent messageTipsEvent) {
        if (C5530d.m14977kn(this.brh)) {
            if (!UserServiceProxy.isLogin()) {
                this.brd.mo23579d(false, 0);
                this.brd.mo23580e(false, 0);
                return;
            }
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt(C5527a.cnQ, -1);
            if (messageTipsEvent.needShowFollowVideoTips && appSettingInt != 0) {
                this.brd.mo23579d(true, 0);
            }
            if (messageTipsEvent.needShowMessageTips) {
                if (AppStateModel.getInstance().isMessageTabSupport()) {
                    if (appSettingInt != 2) {
                        this.brd.mo23580e(true, messageTipsEvent.messageTipsCount);
                    }
                } else if (appSettingInt != 0) {
                    this.brd.mo23579d(true, 0);
                }
            }
            ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
            if (iCommunityAPI != null) {
                iCommunityAPI.onTabMessageTipsApply();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bx */
    public void m9650bx(boolean z) {
        LocationInfo currentLocation = LbsManagerProxy.getCurrentLocation();
        if (currentLocation != null && currentLocation.mLatitude > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && currentLocation.mLongitude > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("getLocation mAddressStrDetail : ");
            sb.append(currentLocation.mAddressStrDetail);
            LogUtilsV2.m14230i(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getLocation mLongitude : ");
            sb2.append(currentLocation.mLongitude);
            LogUtilsV2.m14230i(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getLocation mLatitude : ");
            sb3.append(currentLocation.mLatitude);
            LogUtilsV2.m14230i(sb3.toString());
            if (AppStateModel.getInstance().isInChina()) {
                C3624b GC = C3624b.m8865GC();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(currentLocation.mLatitude);
                sb4.append("");
                GC.mo22953cX(sb4.toString());
                C3624b GC2 = C3624b.m8865GC();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(currentLocation.mLongitude);
                sb5.append("");
                GC2.mo22952cW(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(currentLocation.mLatitude);
                sb6.append("");
                C9537b.setParameter("X-Xiaoying-Security-latitude", sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append(currentLocation.mLongitude);
                sb7.append("");
                C9537b.setParameter("X-Xiaoying-Security-longitude", sb7.toString());
            }
        } else if (!z) {
            m9652cm(getContext());
        }
    }

    /* renamed from: cm */
    private void m9652cm(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LbsRouter.INTENT_ACTION_LBS_UPDATE);
        LocalBroadcastManager.getInstance(context.getApplicationContext()).registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (LbsRouter.INTENT_ACTION_LBS_UPDATE.equals(intent.getAction())) {
                    HomeView.this.m9650bx(true);
                    LocalBroadcastManager.getInstance(context.getApplicationContext()).unregisterReceiver(this);
                }
            }
        }, intentFilter);
    }

    /* renamed from: d */
    private boolean m9654d(int i, KeyEvent keyEvent) {
        if (i != 4 || this.brl == null || this.brl.getParent() == null) {
            return false;
        }
        ((ViewGroup) this.brl.getParent()).removeView(this.brl);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: gI */
    public int m9657gI(int i) {
        if (!AppStateModel.getInstance().isCommunitySupport()) {
            return 1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: gJ */
    public void m9658gJ(int i) {
        switch (i) {
            case 0:
                if (!(this.bqX == null || this.brk == null)) {
                    this.brk.refreshFragmentData(this.bqX);
                }
                this.brd.mo23573LM();
                this.brd.mo23583gU(R.string.xiaoying_str_home_xycircle_tab_title);
                UserBehaviorUtilsV7.eventClickVivaplanetBackTop(this.mActivity);
                return;
            case 1:
                if (this.bqY instanceof CreationFragment) {
                    ((CreationFragment) this.bqY).mo23286Kp();
                    return;
                }
                return;
            case 3:
                if (this.bqZ != null && this.brk != null) {
                    this.brk.refreshFragmentData(this.bqZ);
                    return;
                }
                return;
            case 4:
                if (this.brb instanceof SchoolFragment) {
                    ((SchoolFragment) this.brb).mo23827NJ();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: gK */
    private Fragment m9659gK(int i) {
        if (i == 3) {
            return this.bqZ;
        }
        switch (i) {
            case 0:
                return this.bqX;
            case 1:
                return this.bqY;
            default:
                return null;
        }
    }

    /* renamed from: gL */
    private void m9660gL(int i) {
        if (this.mActivity != null) {
            if (i != -1) {
                C3719d.m9024bs(false);
                UserBehaviorLog.setEnable(false);
            } else {
                C3719d.m9024bs(true);
                UserBehaviorLog.setEnable(true);
                C3958f.m9764cn(this.mActivity.getApplicationContext());
            }
            C3712c.m9010HP().initSdkInOthers(this.mActivity);
        }
    }

    private C4897f getPopMgr() {
        if (this.bdv == null) {
            this.bdv = new C4897f(this.mActivity, new C3986b());
        }
        return this.bdv;
    }

    private void init() {
        long currentTimeMillis = System.currentTimeMillis();
        this.brk = (ICommunityService) C1919a.m5529sc().mo10356i(ICommunityService.class);
        HuaweiIAPServiceProxy.initHuaweiIAPListener(this.mActivity);
        this.mHandler = new C3927a(this);
        C3869e.m9527Hk();
        StringBuilder sb = new StringBuilder();
        sb.append("xsj HomeView init111 cost  : ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtilsV2.m14230i(sb.toString());
        long currentTimeMillis2 = System.currentTimeMillis();
        this.brc = this.mActivity.getSupportFragmentManager();
        LayoutInflater.from(this.mActivity).inflate(R.layout.v3_home_fragment_tabs, this, true);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_appwall);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("xsj HomeView init222 cost  : ");
        sb2.append(System.currentTimeMillis() - currentTimeMillis2);
        LogUtilsV2.m14230i(sb2.toString());
        long currentTimeMillis3 = System.currentTimeMillis();
        this.brd = new C3972a();
        this.brd.mo23578a((RelativeLayout) this);
        this.brd.setTabOnClickListener(this.bru);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("xsj HomeView init333 cost  : ");
        sb3.append(System.currentTimeMillis() - currentTimeMillis3);
        LogUtilsV2.m14230i(sb3.toString());
        long currentTimeMillis4 = System.currentTimeMillis();
        this.brj = C2561a.aON();
        C3961g.m9772Lz().mo23524a(this.mActivity, new C3957e(this));
        C3961g.m9772Lz().show();
        m9631Lq();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("xsj HomeView init444 cost  : ");
        sb4.append(System.currentTimeMillis() - currentTimeMillis4);
        LogUtilsV2.m14230i(sb4.toString());
        long currentTimeMillis5 = System.currentTimeMillis();
        if (!AppStateModel.getInstance().isCommunitySupport()) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("xsj HomeView init555 cost  : ");
        sb5.append(System.currentTimeMillis() - currentTimeMillis5);
        LogUtilsV2.m14230i(sb5.toString());
        long currentTimeMillis6 = System.currentTimeMillis();
        this.bri = new C4412a(this, this.brd.mo23575LT(), this.brd.mo23576LU());
        if (!C2561a.aON()) {
            this.mHandler.sendEmptyMessageDelayed(1006, 3000);
        }
        AppStateInitIntentService.m11065cY(getContext());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("xsj HomeView init666 cost  : ");
        sb6.append(System.currentTimeMillis() - currentTimeMillis6);
        LogUtilsV2.m14230i(sb6.toString());
        long currentTimeMillis7 = System.currentTimeMillis();
        m9632Lr();
        m9633Ls();
        StringBuilder sb7 = new StringBuilder();
        sb7.append("xsj HomeView init777 cost  : ");
        sb7.append(System.currentTimeMillis() - currentTimeMillis7);
        LogUtilsV2.m14230i(sb7.toString());
        long currentTimeMillis8 = System.currentTimeMillis();
        UserBehaviorUtilsV5.recordDeviceLanguage();
        UserBehaviorUtilsV5.recordPermissionNotificationStatus(getContext());
        if (C2561a.aOR() == 1) {
            C4402e.m11114a(getContext(), "action_launch_xiaoying_intenthome_mv", R.drawable.editor_launch_edit_mv_icon, getContext().getString(R.string.xiaoying_str_com_home_edit_photo), "SHORT_CUT_MV");
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("xsj HomeView init888 cost  : ");
        sb8.append(System.currentTimeMillis() - currentTimeMillis8);
        LogUtilsV2.m14230i(sb8.toString());
        long currentTimeMillis9 = System.currentTimeMillis();
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            iEditorService.updateQualityParams(C3742b.m9111II().mo23161Jh(), C3742b.m9111II().mo23162Ji(), C3742b.m9111II().mo23163Jj(), C3742b.m9111II().mo23164Jk());
        }
        if (C8048e.aBe().mo23629Mu() || C8048e.aBe().mo23630Mv() || C8048e.aBe().mo23631Mw()) {
            C8049f.aBf().restoreGoodsAndPurchaseInfo();
        }
        C7858e.m22915a(null);
        String dL = C4599k.m11733dL(getContext());
        HashMap hashMap = new HashMap();
        hashMap.put("Network", dL);
        UserBehaviorLog.onAliEvent("App_Network", hashMap);
        StringBuilder sb9 = new StringBuilder();
        sb9.append("xsj HomeView init999 cost  : ");
        sb9.append(System.currentTimeMillis() - currentTimeMillis9);
        LogUtilsV2.m14230i(sb9.toString());
    }

    /* renamed from: Kn */
    public void mo23445Kn() {
        if (this.brd != null && this.brd.mo23582gT(3) != null && this.mActivity != null) {
            final RelativeLayout gT = this.brd.mo23582gT(3);
            gT.post(new Runnable() {
                public void run() {
                    if (HomeView.this.bou == null) {
                        HomeView.this.bou = new BadgeHelper(HomeView.this.mActivity).mo36037vM(0).mo36036v(0, C4583d.m11671P(15.0f), C4583d.m11671P(25.0f), 0).mo36030jO(true);
                        HomeView.this.bou.mo36029do(gT);
                    }
                    HomeView.this.bou.setBadgeEnable(C5349b.m14582ek(HomeView.this.getContext()));
                }
            });
        }
    }

    public void init(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.brh = i;
        this.brf = new Bundle();
        this.brf.putInt("key_running_mode", i);
        this.brg = true;
        C10021c.aZH().mo38494ax(this);
        C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                HomeView.this.m9635Lu();
            }
        }, 300, TimeUnit.MILLISECONDS);
        this.bre = new HeadsetPlugReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        this.mActivity.registerReceiver(this.bre, intentFilter);
        StringBuilder sb = new StringBuilder();
        sb.append("xsj HomeView init2 cost  : ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtilsV2.m14230i(sb.toString());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9528) {
            m9660gL(i2);
        } else if (this.bqZ != null && !this.bqZ.isHidden()) {
            this.bqZ.onActivityResult(i, i2, intent);
        } else if (this.bqX != null && !this.bqX.isHidden()) {
            this.bqX.onActivityResult(i, i2, intent);
        } else if (this.bqY != null && !this.bqY.isHidden()) {
            this.bqY.onActivityResult(i, i2, intent);
        } else if (this.bra != null && !this.bra.isHidden()) {
            this.bra.onActivityResult(i, i2, intent);
        }
        HuaweiIAPServiceProxy.handleResult(i, i2, intent);
    }

    public void onDestroy() {
        if (this.bre != null) {
            try {
                this.mActivity.unregisterReceiver(this.bre);
            } catch (Exception e) {
                C5523b.logException(new C5526d(e.getMessage()));
            }
        }
        C10021c.aZH().mo38496az(this);
        HuaweiIAPServiceProxy.unInit();
        C3961g.m9772Lz().unInit();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(FeedbackRefreshEvent feedbackRefreshEvent) {
        mo23445Kn();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(MessageTipsEvent messageTipsEvent) {
        m9647a(messageTipsEvent);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(ScrollTopEvent scrollTopEvent) {
        if (scrollTopEvent.isShow) {
            UserBehaviorUtilsV7.eventPageviewVivaPlanetBackTop(this.mActivity);
            m9636Lv();
        } else if (this.brd != null) {
            this.brd.mo23573LM();
            this.brd.mo23583gU(R.string.xiaoying_str_home_xycircle_tab_title);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("assets_copy_done", false);
        if ((!C3570a.m8779RU() && !appSettingBoolean) || m9654d(i, keyEvent)) {
            return true;
        }
        Fragment gK = m9659gK(this.brd.mo23577LV());
        return (gK instanceof FragmentBase) && ((FragmentBase) gK).onKeyUp();
    }

    public void onPause() {
        if ((getContext() instanceof Activity) && ((Activity) getContext()).isFinishing()) {
            this.brd.uninit();
        }
    }

    public void onResume() {
        if (C7916c.aCW().aCY()) {
            C7916c.aCW().mo32876a((C7920a) null);
        }
        mo23445Kn();
        if (this.brg) {
            this.mHandler.sendEmptyMessageDelayed(1003, 500);
            ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
            if (iCommunityAPI != null) {
                iCommunityAPI.checkNewFollowVideo();
            }
            if (!C3961g.m9772Lz().isShowing() && !getPopMgr().mo25354b(this.brr)) {
                getPopMgr().mo25354b(this.brq);
            }
            C3950d.m9740Lm().mo23511cl(getContext());
            if (AppStateModel.getInstance().isCommunitySupport()) {
                this.mHandler.sendEmptyMessage(1004);
            }
            if (AppPreferencesSetting.getInstance().getAppSettingInt(C5527a.cnQ, 1) == 1) {
                C7602b.aAs().mo32486gn(this.mActivity);
            }
            int Ju = C3742b.m9111II().mo23174Ju();
            if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_help_show_flag", true) && Ju == 1) {
                this.bri.mo24481QO();
                brm = true;
                AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_help_show_flag", false);
            }
            int JQ = C3742b.m9111II().mo23149JQ();
            if (AppStateModel.getInstance().isCommunitySupport() && JQ == 1 && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_creation_help_V2_show_flag", false) && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_home_studio_help_show_flag", true)) {
                C3676a.m8967bU(getContext());
                this.bri.mo24484QR();
                AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_studio_help_show_flag", false);
            }
            C8049f.aBf().aBk();
            C7680l.aAe().mo32526aj(this.mActivity, 19);
            C7680l.aAe().mo32526aj(this.mActivity, 49);
        }
    }
}
