package com.introvd.template.app.welcomepage.snsview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.support.p021v4.app.FragmentActivity;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.introvd.template.C4681i;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.common.C4417b.C4418a;
import com.introvd.template.common.SnsConfigMgr.SnsItemInfo;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.user.IUserService;
import com.introvd.template.router.user.LoginUserBehaviorUtils;
import com.introvd.template.sns.login.coupling.LoginCouplingConstant;
import com.introvd.template.util.SpanUtils;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class SnsLoginListView extends BaseSnsLoginView {
    /* access modifiers changed from: private */
    public Context applicationContext;
    private List<SnsItemInfo> bID;
    /* access modifiers changed from: private */
    public IUserService bIO;
    private TextView bJh;
    private RecyclerView bJi;
    private ExpandHeightGridView bJj;
    private C4529b bJk;
    /* access modifiers changed from: private */
    public boolean bJl = false;
    /* access modifiers changed from: private */
    public FragmentActivity mActivity;

    /* renamed from: com.introvd.template.app.welcomepage.snsview.SnsLoginListView$a */
    public interface C4514a {
        /* renamed from: a */
        void mo24732a(SnsItemInfo snsItemInfo);
    }

    /* renamed from: com.introvd.template.app.welcomepage.snsview.SnsLoginListView$b */
    class C4515b {
        SnsItemInfo bJs;
        int type;

        public C4515b(int i, SnsItemInfo snsItemInfo) {
            this.type = i;
            this.bJs = snsItemInfo;
        }
    }

    public SnsLoginListView(Context context) {
        super(context);
    }

    public SnsLoginListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsLoginListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public SnsLoginListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: RB */
    public void m11412RB() {
        int size = this.bID.size();
        if (size < bIU) {
            this.bJj.setNumColumns(size);
        } else {
            this.bJj.setNumColumns(bIU);
        }
        ArrayList arrayList = new ArrayList();
        if (size > 6) {
            size = 6;
        }
        for (int i = 0; i < size; i++) {
            if (i < bIU - 1) {
                arrayList.add(new C4515b(0, (SnsItemInfo) this.bID.get(i)));
            } else if (this.bJl) {
                if (i == bIU) {
                    arrayList.add(new C4515b(2, (SnsItemInfo) this.bID.get(i)));
                }
                arrayList.add(new C4515b(0, (SnsItemInfo) this.bID.get(i)));
            } else if (i == bIU - 1) {
                if (size == bIU) {
                    arrayList.add(new C4515b(0, (SnsItemInfo) this.bID.get(i)));
                } else {
                    arrayList.add(new C4515b(1, null));
                }
            }
        }
        this.bJk.mo24750au(arrayList);
        this.bJk.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11414a(int i, long j, long j2, String str) {
        int i2 = i;
        if (!(this.bIO == null || this.mActivity == null)) {
            this.bIO.startSnsLogin(this.mActivity, j, j2, i, false, str, null);
        }
        UserBehaviorUtils.recordUserLoginPosition(this.applicationContext, LoginUserBehaviorUtils.LOGIN_POSITION_WELCOME);
        String behaviorSnsName = UserBehaviorUtils.getBehaviorSnsName(i);
        Context context = this.applicationContext;
        boolean z = this.bIV;
        String str2 = LoginUserBehaviorUtils.LOGIN_POSITION_WELCOME;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        UserBehaviorUtils.recordUserLoginEvent(context, z, behaviorSnsName, str2, sb.toString());
        UserBehaviorUtilsV5.onEventHomeSlide(this.applicationContext, Event.LOGIN, behaviorSnsName);
        if (AppStateModel.ZONE_MIDDLE_EAST.equals(AppStateModel.getInstance().getZoneCode())) {
            HashMap hashMap = new HashMap();
            hashMap.put("socialEnable", AppStateModel.getInstance().isCommunitySupport() ? "enable" : "disable");
            hashMap.put("country", this.countryCode);
            hashMap.put("zone", AppStateModel.getInstance().getZoneCode());
            hashMap.put("localeinfo", Locale.getDefault().toString());
            UserBehaviorLog.onKVEvent(this.applicationContext, "Dev_Event_Login_Error", hashMap);
        }
        if (i2 == 31) {
            LoginCouplingConstant.mLoginPosition = 100;
        }
    }

    /* renamed from: a */
    private void m11415a(long j, long j2, String str, C4514a aVar) {
        this.bJi.setLayoutManager(new LinearLayoutManager(this.applicationContext, 0, false));
        this.bJi.mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                if (recyclerView.mo7746aN(view) > 0) {
                    rect.left = C4583d.m11670O(SnsLoginListView.this.applicationContext, 28);
                } else {
                    rect.left = C4583d.m11670O(SnsLoginListView.this.applicationContext, 15);
                }
                rect.right = C4583d.m11670O(SnsLoginListView.this.applicationContext, 15);
            }
        });
        C4527a aVar2 = new C4527a();
        aVar2.setDataList(this.bID);
        final C4527a aVar3 = aVar2;
        final C4514a aVar4 = aVar;
        final long j3 = j;
        final long j4 = j2;
        final String str2 = str;
        C45082 r0 = new C4418a() {
            public void onItemClicked(int i) {
                SnsItemInfo snsItemInfo = (SnsItemInfo) aVar3.getListItem(i);
                if (snsItemInfo != null) {
                    if (!C4600l.m11739k(SnsLoginListView.this.applicationContext, true)) {
                        ToastUtils.show(SnsLoginListView.this.applicationContext, R.string.xiaoying_str_com_msg_network_inactive, 1);
                        return;
                    }
                    if (aVar4 != null) {
                        aVar4.mo24732a(snsItemInfo);
                    }
                    String behaviorSnsName = UserBehaviorUtils.getBehaviorSnsName(snsItemInfo.mSnsCode);
                    Context a = SnsLoginListView.this.applicationContext;
                    boolean z = SnsLoginListView.this.bIV;
                    String str = LoginUserBehaviorUtils.LOGIN_POSITION_WELCOME;
                    StringBuilder sb = new StringBuilder();
                    sb.append(snsItemInfo.mSnsCode);
                    sb.append("");
                    UserBehaviorUtils.recordUserLoginEvent(a, z, behaviorSnsName, str, sb.toString());
                    if (!(SnsLoginListView.this.bIO == null || SnsLoginListView.this.mActivity == null)) {
                        SnsLoginListView.this.bIO.startSnsLogin(SnsLoginListView.this.mActivity, j3, j4, snsItemInfo.mSnsCode, false, str2, "");
                    }
                }
            }
        };
        aVar2.setItemListener(r0);
        this.bJi.setAdapter(aVar2);
    }

    /* renamed from: b */
    private void m11419b(long j, long j2, String str, C4514a aVar) {
        Context context = this.applicationContext;
        final C4514a aVar2 = aVar;
        final long j3 = j;
        final long j4 = j2;
        final String str2 = str;
        C45093 r0 = new C4514a() {
            /* renamed from: a */
            public void mo24732a(SnsItemInfo snsItemInfo) {
                if ((snsItemInfo.mSnsCode == 1 || snsItemInfo.mSnsCode == 7) && !SnsLoginListView.this.mo24727N(SnsLoginListView.this.applicationContext, snsItemInfo.mSnsCode)) {
                    ToastUtils.show(SnsLoginListView.this.applicationContext, R.string.xiaoying_str_com_no_sns_client, 0);
                } else if (!C4600l.m11739k(SnsLoginListView.this.applicationContext, true)) {
                    ToastUtils.show(SnsLoginListView.this.applicationContext, R.string.xiaoying_str_com_msg_network_inactive, 0);
                } else {
                    if (aVar2 != null) {
                        aVar2.mo24732a(snsItemInfo);
                    }
                    SnsLoginListView.this.m11414a(snsItemInfo.mSnsCode, j3, j4, str2);
                }
            }
        };
        this.bJk = new C4529b(context, r0, new C4531a() {
            /* renamed from: bY */
            public void mo24733bY(View view) {
                SnsLoginListView.this.bJl = true;
                SnsLoginListView.this.m11412RB();
            }
        });
        this.bJj.setAdapter(this.bJk);
        m11412RB();
    }

    /* renamed from: bX */
    private void m11420bX(boolean z) {
        String string = this.applicationContext.getString(R.string.xiaoying_str_community_pre_terms_and_privacy);
        SpanUtils spanUtils = new SpanUtils();
        if (this.bIW || z) {
            String string2 = this.applicationContext.getString(R.string.xiaoying_str_setting_about_privacy_text4);
            String string3 = this.applicationContext.getString(R.string.xiaoying_str_setting_about_privacy_text1);
            spanUtils.mo35760B(string).mo35767vH(this.bIY).mo35766vG(33);
            spanUtils.mo35760B(string2).mo35767vH(this.bIZ).mo35761a(new ClickableSpan() {
                public void onClick(View view) {
                    String str = "https://hybrid.xiaoying.tv/web/vivavideo/User_Agreement.html";
                    if (SnsLoginListView.this.mActivity != null) {
                        AppRouter.startWebPage(SnsLoginListView.this.mActivity, str, null);
                    }
                }
            }).mo35766vG(33);
            spanUtils.mo35760B(RequestParameters.AMPERSAND).mo35767vH(this.bIY).mo35766vG(33);
            spanUtils.mo35760B(string3).mo35767vH(this.bIZ).mo35761a(new ClickableSpan() {
                public void onClick(View view) {
                    String str = "https://hybrid.xiaoying.tv/web/vivavideo/terms_privacy.html";
                    if (SnsLoginListView.this.mActivity != null) {
                        AppRouter.startWebPage(SnsLoginListView.this.mActivity, str, null);
                    }
                }
            }).mo35766vG(33);
        } else {
            String string4 = this.applicationContext.getString(R.string.xiaoying_str_community_setting_about_privacy_terms);
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" ");
            sb.append(string4);
            spanUtils.mo35760B(sb.toString()).mo35767vH(this.bJa).mo35761a(new ClickableSpan() {
                public void onClick(View view) {
                    if (SnsLoginListView.this.mActivity != null) {
                        IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
                        if (iAppService != null) {
                            iAppService.showPrivacyTerms(SnsLoginListView.this.mActivity, 0);
                        }
                    }
                }
            }).mo35766vG(18);
        }
        this.bJh.setText(spanUtils.aNl());
        this.bJh.setMovementMethod(new LinkMovementMethod());
    }

    /* renamed from: a */
    public void mo24730a(FragmentActivity fragmentActivity, boolean z, long j, long j2, List<SnsItemInfo> list, String str, C4514a aVar, boolean z2) {
        boolean z3 = z;
        this.mActivity = fragmentActivity;
        this.applicationContext = fragmentActivity.getApplicationContext();
        this.bID = list;
        if (z2) {
            bIU = 5;
        }
        m11420bX(z);
        if (z3) {
            this.bJi.setVisibility(8);
            this.bJj.setVisibility(0);
        } else {
            this.bJi.setVisibility(0);
            this.bJj.setVisibility(8);
        }
        if (z3) {
            m11419b(j, j2, str, aVar);
        } else {
            m11415a(j, j2, str, aVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: dp */
    public void mo24728dp(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_user_sns_login_list_view, this, true);
        this.bJh = (TextView) findViewById(R.id.tv_privacy);
        this.bJi = (RecyclerView) findViewById(R.id.rv_sns_login_list);
        this.bJj = (ExpandHeightGridView) findViewById(R.id.gv_sns_login_list);
        this.bIO = (IUserService) C4681i.m12184Gp().getService(IUserService.class);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActivity != null) {
            this.mActivity = null;
        }
    }
}
