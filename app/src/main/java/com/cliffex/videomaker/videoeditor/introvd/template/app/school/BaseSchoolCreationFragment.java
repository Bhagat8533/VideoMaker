package com.introvd.template.app.school;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.homepage.C3950d;
import com.introvd.template.app.homepage.FloatImageView;
import com.introvd.template.app.homepage.FloatImageView.C3921a;
import com.introvd.template.app.school.view.CreationEditorModelLayout;
import com.introvd.template.app.school.view.SchoolCreationTitleLayout;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.router.AppRouter.YoungerModeParams;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.banner.BannerInfo;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.xyui.CustomSwipeRefreshLayout;

public abstract class BaseSchoolCreationFragment extends FragmentBase {
    private boolean boo;
    /* access modifiers changed from: private */
    public CreationEditorModelLayout bwA;
    protected CustomSwipeRefreshLayout bwv;
    protected SchoolCreationTitleLayout bww;
    protected AppBarLayout bwx;
    private View bwy;
    private CollapsingToolbarLayout bwz;

    /* renamed from: Nq */
    private void m10268Nq() {
        View findViewById = this.bwy.findViewById(R.id.viewStubHeaderExtra);
        View cD = mo23816cD(getActivity());
        if (cD == null) {
            findViewById.setVisibility(8);
        } else {
            m10273f(findViewById, cD);
        }
        View findViewById2 = this.bwy.findViewById(R.id.viewStubHeaderCeiling);
        View cE = mo23817cE(getActivity());
        if (cE == null) {
            findViewById2.setVisibility(8);
        } else {
            m10273f(findViewById2, cE);
        }
        View findViewById3 = this.bwy.findViewById(R.id.viewStubBottomView);
        View cF = mo23818cF(getActivity());
        if (cF == null) {
            findViewById3.setVisibility(8);
        } else {
            m10273f(findViewById3, cF);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Nr */
    public /* synthetic */ void m10269Nr() {
        this.bww.mo24265Kp();
        this.bwA.mo24248Kp();
        mo23814Kp();
    }

    /* renamed from: bE */
    private void m10272bE(boolean z) {
        final FloatImageView floatImageView = (FloatImageView) this.bwy.findViewById(R.id.float_imageview);
        if (z) {
            floatImageView.setVisibility(8);
            return;
        }
        final BannerInfo Ln = C3950d.m9740Lm().mo23509Ln();
        if (Ln != null && !TextUtils.isEmpty(Ln.strContentUrl) && !AppPreferencesSetting.getInstance().getAppSettingStr("key_closed_float_image_url", "").equals(Ln.strContentUrl)) {
            floatImageView.setImageUrl(Ln.strContentUrl);
            floatImageView.setVisibility(0);
            if (!this.boo) {
                this.boo = true;
                UserBehaviorUtilsV5.onEventHomeFloatShow(getActivity(), Ln.strContentTitle);
                FragmentActivity activity = getActivity();
                int i = Ln.orderNum;
                String str = Ln.strContentTitle;
                StringBuilder sb = new StringBuilder();
                sb.append(Ln.f3572id);
                sb.append("");
                UserBehaviorABTestUtils.onEventFloatBanner(activity, i, str, sb.toString(), true);
            }
            floatImageView.setOnViewClickListener(new C3921a() {
                /* renamed from: Kr */
                public void mo23293Kr() {
                    floatImageView.setVisibility(8);
                    AppPreferencesSetting.getInstance().setAppSettingStr("key_closed_float_image_url", Ln.strContentUrl);
                    UserBehaviorUtilsV5.onEventHomeFloatClick(BaseSchoolCreationFragment.this.getActivity(), Ln.strContentTitle, false);
                }

                /* renamed from: Ks */
                public void mo23294Ks() {
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = Ln.todoType;
                    tODOParamModel.mJsonParam = Ln.strTodoContent;
                    BizAppTodoActionManager.getInstance().executeTodo(BaseSchoolCreationFragment.this.getActivity(), tODOParamModel);
                    UserBehaviorUtilsV5.onEventHomeFloatClick(BaseSchoolCreationFragment.this.getActivity(), Ln.strContentTitle, true);
                    FragmentActivity activity = BaseSchoolCreationFragment.this.getActivity();
                    int i = Ln.orderNum;
                    String str = Ln.strContentTitle;
                    StringBuilder sb = new StringBuilder();
                    sb.append(Ln.f3572id);
                    sb.append("");
                    UserBehaviorABTestUtils.onEventFloatBanner(activity, i, str, sb.toString(), false);
                }
            });
        }
    }

    /* renamed from: f */
    private void m10273f(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        LayoutParams layoutParams = view.getLayoutParams();
        int indexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        viewGroup.addView(view2, indexOfChild, layoutParams);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Kp */
    public abstract void mo23814Kp();

    /* access modifiers changed from: protected */
    /* renamed from: bF */
    public void mo23815bF(boolean z) {
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) this.bwz.getLayoutParams();
        if (z) {
            layoutParams.mo1594Y(0);
        } else {
            layoutParams.mo1594Y(1);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cD */
    public abstract View mo23816cD(Context context);

    /* access modifiers changed from: 0000 */
    /* renamed from: cE */
    public abstract View mo23817cE(Context context);

    /* access modifiers changed from: 0000 */
    /* renamed from: cF */
    public abstract View mo23818cF(Context context);

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bwy = layoutInflater.inflate(R.layout.app_frag_school_creation, viewGroup, false);
        this.bww = (SchoolCreationTitleLayout) this.bwy.findViewById(R.id.layoutTitle);
        this.bwz = (CollapsingToolbarLayout) this.bwy.findViewById(R.id.collapsing_toolbar_layout);
        this.bwx = (AppBarLayout) this.bwy.findViewById(R.id.appbar_layout);
        this.bwA = (CreationEditorModelLayout) this.bwy.findViewById(R.id.layoutEditorModel);
        getLifecycle().mo152a(this.bwA);
        this.bwv = (CustomSwipeRefreshLayout) this.bwy.findViewById(R.id.swipe_refresh_layout);
        this.bwv.setOnRefreshListener(new C4143a(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(YoungerModeParams.RECEIVE_ACTION_YOUNGER_MODE_OPEN);
        intentFilter.addAction(YoungerModeParams.RECEIVE_ACTION_YOUNGER_MODE_CLOSE);
        LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                StringBuilder sb = new StringBuilder();
                sb.append("onReceive : ");
                sb.append(intent.getAction());
                LogUtilsV2.m14230i(sb.toString());
                YoungerModeParams.RECEIVE_ACTION_YOUNGER_MODE_OPEN.equals(intent.getAction());
                BaseSchoolCreationFragment.this.bww.mo24265Kp();
                BaseSchoolCreationFragment.this.bwA.mo24248Kp();
            }
        }, intentFilter);
        m10268Nq();
        return this.bwy;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        IAppService iAppService = (IAppService) C1919a.m5529sc().mo10356i(IAppService.class);
        m10272bE(iAppService != null ? iAppService.isYoungerMode() : false);
    }
}
