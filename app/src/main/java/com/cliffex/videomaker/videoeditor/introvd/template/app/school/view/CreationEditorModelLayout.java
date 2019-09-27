package com.introvd.template.app.school.view;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.C0171f;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.community.freeze.C3763b;
import com.introvd.template.app.creation.C3821d;
import com.introvd.template.app.homepage.creation.C3949b;
import com.introvd.template.app.homepage.creation.MainToolItemView;
import com.introvd.template.app.manager.C4047b;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.school.C4205m;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.banner.LoopViewPager.PagerFormatData;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p310g.C7368g;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.AppRouter.YoungerModeParams;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.banner.BannerInfo;
import com.introvd.template.router.banner.IBannerService;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.user.UserServiceProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

public class CreationEditorModelLayout extends LinearLayout implements C0068f {
    /* access modifiers changed from: private */
    public C3821d bot;
    /* access modifiers changed from: private */
    public C7368g bzX;

    public CreationEditorModelLayout(Context context) {
        super(context);
        m10653Iu();
    }

    public CreationEditorModelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10653Iu();
    }

    public CreationEditorModelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10653Iu();
    }

    /* renamed from: Iu */
    private void m10653Iu() {
        this.bzX = (C7368g) C0171f.m365a(LayoutInflater.from(getContext()), R.layout.app_include_creation_editor, (ViewGroup) this, true);
        this.bzX.cpe.getLayoutParams().height = (int) (((float) (Constants.getScreenSize().width - C4583d.m11673ii(30))) / 3.5729167f);
        this.bzX.cpj.setPlaceHolderImg(R.drawable.app_bg_creation_banner_default);
        this.bzX.cpj.setCornerRadius((float) C4583d.m11673ii(8));
        this.bzX.cpj.mBannerCode = 101;
        this.bzX.cpj.addOnPageChangeListener(new OnPageChangeListener() {
            private boolean bzY = false;

            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    this.bzY = true;
                } else if (i == 0) {
                    if (this.bzY) {
                        UserBehaviorLog.onKVEvent(CreationEditorModelLayout.this.getContext(), "Home_Banner_Slide", new HashMap());
                    }
                    this.bzY = false;
                }
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
            }
        });
        this.bot = new C3821d();
    }

    /* renamed from: OE */
    private void m10654OE() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                CreationEditorModelLayout.this.bot.mo23318cg(VivaBaseApplication.m8749FZ());
                return Boolean.valueOf(true);
            }
        }).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                CreationEditorModelLayout.this.mo24248Kp();
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                CreationEditorModelLayout.this.mo24248Kp();
            }
        });
        m10655OF();
    }

    /* renamed from: OF */
    private void m10655OF() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(YoungerModeParams.RECEIVE_ACTION_YOUNGER_MODE_OPEN);
        intentFilter.addAction(YoungerModeParams.RECEIVE_ACTION_YOUNGER_MODE_CLOSE);
        LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                StringBuilder sb = new StringBuilder();
                sb.append("onReceive : ");
                sb.append(intent.getAction());
                LogUtilsV2.m14230i(sb.toString());
                CreationEditorModelLayout.this.m10666bM(YoungerModeParams.RECEIVE_ACTION_YOUNGER_MODE_OPEN.equals(intent.getAction()));
            }
        }, intentFilter);
    }

    /* renamed from: OG */
    private void m10656OG() {
        C1487a.aUa().mo10058o(new Runnable() {
            public void run() {
                ArrayList arrayList = new ArrayList();
                PagerFormatData pagerFormatData = new PagerFormatData();
                pagerFormatData.f3453id = "younger id";
                pagerFormatData.imgUrl = "http://hybrid.xiaoying.tv/vcm/20190520/17474040/2019052017474040.jpg";
                pagerFormatData.todoCode = Integer.valueOf(TodoConstants.TODO_TYPE_OPEN_URL);
                pagerFormatData.name = "";
                pagerFormatData.todoContent = "{\"url\": \"https://hybrid.xiaoying.tv/web/vivaVideo/faq/index.html?__webview_options__=st=NO*sbi=NO&time=20190213\", \"existParam\": \"\", \"getAppMode\": \"\", \"getTheatreConfig\": \"\", \"useHybrid\": \"1\"}";
                pagerFormatData.description = "";
                arrayList.add(pagerFormatData);
                CreationEditorModelLayout.this.bzX.cpj.init(arrayList, false, false);
                CreationEditorModelLayout.this.bzX.cph.setVisibility(8);
            }
        });
    }

    /* renamed from: OH */
    private void m10657OH() {
        C1834l.m5257ah(this.bot.mo23310Kt()).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<ModeItemInfo>>() {
            /* renamed from: R */
            public void mo9886K(List<ModeItemInfo> list) {
                CreationEditorModelLayout.this.m10665b((ModeItemInfo) list.get(0), (ModeItemInfo) list.get(1));
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: OI */
    private void m10658OI() {
        C1834l.m5257ah(this.bot.mo23312Kv()).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<ModeItemInfo>>() {
            /* renamed from: R */
            public void mo9886K(List<ModeItemInfo> list) {
                CreationEditorModelLayout.this.bzX.cpi.setSubToolItemViewListener(new C3949b() {
                    /* renamed from: LF */
                    public void mo23507LF() {
                    }

                    /* renamed from: b */
                    public boolean mo23508b(ModeItemInfo modeItemInfo) {
                        return CreationEditorModelLayout.this.m10669d(modeItemInfo);
                    }
                });
                CreationEditorModelLayout.this.bzX.cpi.mo24261W(list);
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10665b(final ModeItemInfo modeItemInfo, final ModeItemInfo modeItemInfo2) {
        MainToolItemView.m9721a(modeItemInfo, this.bzX.cpf.cpn);
        MainToolItemView.m9720a(modeItemInfo, this.bzX.cpf.cpp);
        MainToolItemView.m9721a(modeItemInfo2, this.bzX.cpg.cpn);
        MainToolItemView.m9720a(modeItemInfo2, this.bzX.cpg.cpp);
        this.bzX.cpf.cpm.setBackgroundResource(R.drawable.app_bg_creation_main_tool_left);
        this.bzX.cpf.cpo.setBackgroundResource(R.drawable.app_shadow_creation_main_tool_left);
        this.bzX.cpg.cpm.setBackgroundResource(R.drawable.app_bg_creation_main_tool_right);
        this.bzX.cpg.cpo.setBackgroundResource(R.drawable.app_shadow_creation_main_tool_right);
        Context context = getContext();
        String str = modeItemInfo.itemName;
        StringBuilder sb = new StringBuilder();
        sb.append(modeItemInfo.rawId);
        sb.append("");
        UserBehaviorABTestUtils.onEventShowHomeMain(context, 0, str, sb.toString());
        Context context2 = getContext();
        String str2 = modeItemInfo2.itemName;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(modeItemInfo2.rawId);
        sb2.append("");
        UserBehaviorABTestUtils.onEventShowHomeMain(context2, 1, str2, sb2.toString());
        this.bzX.cpf.getRoot().setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CreationEditorModelLayout.this.m10668c(modeItemInfo);
                C4205m.m10502r(modeItemInfo.itemName, modeItemInfo.itemNameBackupRes);
            }
        });
        this.bzX.cpg.getRoot().setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CreationEditorModelLayout.this.m10668c(modeItemInfo2);
                C4205m.m10502r(modeItemInfo2.itemName, modeItemInfo2.itemNameBackupRes);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bM */
    public void m10666bM(boolean z) {
        if (z) {
            m10656OG();
            return;
        }
        C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_BANNER_PAGE, (C8354a) new C8354a() {
            /* renamed from: a */
            public void mo23009a(Context context, String str, int i, Bundle bundle) {
                C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_BANNER_PAGE);
                if (i == 131072) {
                    C1487a.aUa().mo10058o(new Runnable() {
                        public void run() {
                            List b = CreationEditorModelLayout.this.getBannerInfoList();
                            if (b != null) {
                                CreationEditorModelLayout.this.bzX.cpj.init(b, true, true);
                                if (b.size() > 1) {
                                    CreationEditorModelLayout.this.bzX.cpj.initIndicator(R.drawable.app_shape_school_banner_dot_focus, R.drawable.app_shape_school_banner_dot, CreationEditorModelLayout.this.bzX.cph);
                                    CreationEditorModelLayout.this.bzX.cph.setVisibility(0);
                                }
                            }
                        }
                    });
                }
            }
        });
        C8346e.m24077d(getContext(), 0, AppStateModel.getInstance().getCountryCode(), "105,104,11,10401,107,10402,18001,18002,18003,18004,18005,18006,6001,111,122,101");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10668c(ModeItemInfo modeItemInfo) {
        if (!C4580b.m11632Sf() && modeItemInfo != null) {
            UserBehaviorUtilsV5.onEventHomeEditV5(getContext(), BizAppTodoActionManager.getInstance().getTodoCodeName(modeItemInfo.todoCode), modeItemInfo.itemName);
            if (!m10669d(modeItemInfo)) {
                if (modeItemInfo.todoCode == 408) {
                    UtilsPrefs with = UtilsPrefs.with(getContext(), AppRouter.VIVA_APP_PREF_FILENAME, true);
                    if (!with.readBoolean("key_show_main_tool_mv_tip", false)) {
                        with.writeBoolean("key_show_main_tool_mv_tip", true);
                        UserBehaviorABTestUtils.homeFunctionTipClick(getContext(), "Mv_tip");
                    }
                } else if (modeItemInfo.todoCode == 401) {
                    UtilsPrefs with2 = UtilsPrefs.with(getContext(), AppRouter.VIVA_APP_PREF_FILENAME, true);
                    if (!with2.readBoolean("key_show_main_tool_editor_tip", false)) {
                        with2.writeBoolean("key_show_main_tool_editor_tip", true);
                        UserBehaviorABTestUtils.homeFunctionTipClick(getContext(), "edit_tip");
                    }
                }
                C4047b.m10067a((Activity) getContext(), modeItemInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m10669d(ModeItemInfo modeItemInfo) {
        int freezeCode = C3763b.getFreezeCode();
        boolean z = true;
        if (freezeCode == 203) {
            C3763b.m9231Is().mo23238f(getContext(), UserServiceProxy.getUserId(), freezeCode);
            return true;
        }
        if (!C4047b.m10065Nb() || !C3742b.m9111II().mo23176Jw()) {
            z = false;
        }
        if (z) {
            C4047b.m10069b(getContext(), modeItemInfo);
        } else {
            C4047b.m10076hd(modeItemInfo.todoCode);
        }
        return z;
    }

    /* access modifiers changed from: private */
    public List<PagerFormatData> getBannerInfoList() {
        IBannerService iBannerService = (IBannerService) C1919a.m5529sc().mo10356i(IBannerService.class);
        if (iBannerService == null) {
            return null;
        }
        List<BannerInfo> bannerInfo = iBannerService.getBannerInfo(VivaBaseApplication.m8749FZ(), 101);
        if (bannerInfo == null || bannerInfo.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BannerInfo bannerInfo2 : bannerInfo) {
            PagerFormatData pagerFormatData = new PagerFormatData();
            StringBuilder sb = new StringBuilder();
            sb.append(bannerInfo2.f3572id);
            sb.append("");
            pagerFormatData.f3453id = sb.toString();
            pagerFormatData.imgUrl = bannerInfo2.strContentUrl;
            pagerFormatData.todoCode = Integer.valueOf(bannerInfo2.todoType);
            pagerFormatData.name = bannerInfo2.strContentTitle;
            pagerFormatData.todoContent = bannerInfo2.strTodoContent;
            pagerFormatData.description = bannerInfo2.strDesc;
            arrayList.add(pagerFormatData);
        }
        return arrayList;
    }

    /* renamed from: Kp */
    public void mo24248Kp() {
        m10657OH();
        m10658OI();
        IAppService iAppService = (IAppService) C1919a.m5529sc().mo10356i(IAppService.class);
        m10666bM(iAppService != null ? iAppService.isYoungerMode() : false);
    }

    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onPause() {
        this.bzX.cpj.onPause();
    }

    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onResume() {
        this.bzX.cpj.onResume();
    }

    @C0078n(mo161n = C0062a.ON_START)
    public void onStart() {
        m10654OE();
    }
}
