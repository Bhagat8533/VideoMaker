package com.introvd.template.editor.studio;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.C4681i;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p244a.C5553a;
import com.introvd.template.editor.service.ProjectScanService;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.p326ad.C7590b;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.app.IFreezeService;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.editor.studio.StudioActionEvent;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.sdk.p390f.C8445a;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.utils.C8558m;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

public class StudioItemView extends RelativeLayout implements C0068f {
    private static final String TAG = "StudioItemView";
    private View bFx = null;
    /* access modifiers changed from: private */
    public BroadcastReceiver bfy;
    private LinearLayout boS;
    private LinearLayout djT;
    private ImageView djU;
    /* access modifiers changed from: private */
    public RelativeLayout djV;
    private RelativeLayout djW;

    public StudioItemView(Context context) {
        super(context);
        m20085Iu();
    }

    public StudioItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20085Iu();
    }

    public StudioItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20085Iu();
    }

    /* renamed from: Iu */
    private void m20085Iu() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_studio_item_view_layout, this, true);
        this.djT = (LinearLayout) findViewById(R.id.layout_studio_empty_hint);
        this.djU = (ImageView) findViewById(R.id.studio_empty_img);
        this.djV = (RelativeLayout) findViewById(R.id.layout_studio_view);
        this.djW = (RelativeLayout) findViewById(R.id.rl_vip_tip_layout);
        TextView textView = (TextView) findViewById(R.id.btn_more);
        this.boS = (LinearLayout) findViewById(R.id.layout_draft_item);
        asC();
        LayoutParams layoutParams = (LayoutParams) this.djT.getLayoutParams();
        layoutParams.height = getDraftLayoutHeight(getContext()) - C4583d.m11671P(30.0f);
        this.djT.setLayoutParams(layoutParams);
        this.djU.setImageResource(AppStateModel.getInstance().isMiddleEast() ? R.drawable.editor_east_draft_empty_video : R.drawable.vivavideo_common_empty);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                IFreezeService iFreezeService = (IFreezeService) BizServiceManager.getService(IFreezeService.class);
                if (iFreezeService == null || iFreezeService.getFreezeCode() != 203) {
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = TodoConstants.TODO_TYPE_STUDIO;
                    BizAppTodoActionManager.getInstance().executeTodo((Activity) StudioItemView.this.getContext(), tODOParamModel);
                    UserBehaviorUtilsV5.onEventHomeStudioClick(StudioItemView.this.getContext(), "more");
                    return;
                }
                iFreezeService.showFreezeDialog(StudioItemView.this.getContext(), UserServiceProxy.getUserId(), 203);
            }
        });
        if (!AppStateModel.getInstance().isInChina()) {
            C7589a.m22363h(32, new ViewAdsListener() {
                public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                    if (z) {
                        StudioItemView.this.refresh();
                    }
                }
            });
            C7589a.m22360aj(getContext(), 32);
            C7589a.m22360aj(getContext(), 42);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: KH */
    public void m20086KH() {
        if (this.bfy == null) {
            final Context applicationContext = getContext().getApplicationContext();
            ProjectScanService.m19506fl(applicationContext);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH);
            this.bfy = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH.equals(intent.getAction())) {
                        C4681i.m12184Gp().mo25016Gr().recordScanResultEvt(context, intent.getIntExtra(StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH_INTENT_RESULT, 0));
                        StudioItemView.this.postDelayed(new Runnable() {
                            public void run() {
                                C8446b.aIZ().mo34316am(StudioItemView.this.getContext(), 0);
                                List list = C8446b.aIZ().getList();
                                if (list != null && !list.isEmpty()) {
                                    StudioItemView.this.setEmptyHintViewVisible(false);
                                    StudioItemView.this.m20091bJ(list);
                                }
                            }
                        }, 1000);
                    }
                    if (StudioItemView.this.bfy != null) {
                        LocalBroadcastManager.getInstance(applicationContext).unregisterReceiver(StudioItemView.this.bfy);
                    }
                }
            };
            LocalBroadcastManager.getInstance(applicationContext).registerReceiver(this.bfy, intentFilter);
        }
    }

    /* access modifiers changed from: private */
    public void asC() {
        if (this.djW != null) {
            final String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_iap_risk_tip_id", "");
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_iap_risk_tip_state", 1);
            long parseLong = C2575a.parseLong(AppPreferencesSetting.getInstance().getAppSettingStr("pref_iap_risk_tip_time", "0"));
            if ((TextUtils.isEmpty(appSettingStr) || !C8072q.aBx().mo33072ku(appSettingStr)) && parseLong >= System.currentTimeMillis()) {
                if (appSettingInt != 0 || TextUtils.isEmpty(appSettingStr) || C8072q.aBx().mo33072ku(appSettingStr)) {
                    this.djW.setVisibility(8);
                } else {
                    this.djW.setVisibility(0);
                    this.djW.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            C7835b.aCN();
                            AppRouter.launchMarketSubscribe(StudioItemView.this.getContext(), appSettingStr);
                        }
                    });
                    C7835b.aCM();
                }
                return;
            }
            this.djW.setVisibility(8);
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_iap_risk_tip_id", "");
            AppPreferencesSetting.getInstance().setAppSettingInt("pref_iap_risk_tip_state", 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bJ */
    public void m20091bJ(List<C8445a> list) {
        this.boS.removeAllViews();
        int size = list.size();
        int i = 0;
        while (i < 3) {
            this.boS.addView(m20093c(i < size ? (C8445a) list.get(i) : null, i));
            i++;
        }
        m20096py(size);
    }

    /* renamed from: c */
    private View m20093c(final C8445a aVar, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        MSize fy = m20095fy(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fy.width, fy.height);
        int P = C4583d.m11671P(9.5f);
        int P2 = C4583d.m11671P(15.0f);
        int P3 = C4583d.m11671P(4.0f);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.topMargin = P;
            layoutParams.bottomMargin = P2;
            if (i == 0) {
                layoutParams.setMarginStart(P2);
                layoutParams.setMarginEnd(0);
            } else if (i == 2) {
                layoutParams.setMarginStart(P3);
                layoutParams.setMarginEnd(P2);
            } else {
                layoutParams.setMarginStart(P3);
                layoutParams.setMarginEnd(0);
            }
        } else if (i == 0) {
            layoutParams.setMargins(P2, P, 0, P2);
        } else if (i == 2) {
            layoutParams.setMargins(P3, P, P2, P2);
        } else {
            layoutParams.setMargins(P3, P, 0, P2);
        }
        relativeLayout.setLayoutParams(layoutParams);
        if (aVar == null) {
            return relativeLayout;
        }
        DynamicLoadingImageView dynamicLoadingImageView = new DynamicLoadingImageView(getContext());
        LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        String str = aVar.strPrjThumbnail;
        StringBuilder sb = new StringBuilder();
        sb.append("file://");
        sb.append(str);
        ImageLoader.loadImage(sb.toString(), dynamicLoadingImageView);
        relativeLayout.addView(dynamicLoadingImageView, layoutParams2);
        relativeLayout.addView(getShadowView());
        TextView textView = new TextView(getContext());
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        textView.setText(C4580b.m11637V(aVar.egs));
        if (VERSION.SDK_INT >= 17) {
            layoutParams3.addRule(21);
            layoutParams3.setMarginEnd(C4583d.dpFloatToPixel(getContext(), 6.5f));
        } else {
            layoutParams3.addRule(11);
            layoutParams3.rightMargin = C4583d.dpFloatToPixel(getContext(), 6.5f);
        }
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = C4583d.m11670O(getContext(), 4);
        textView.setTextColor(-1);
        textView.setTextSize(2, 10.0f);
        relativeLayout.addView(textView, layoutParams3);
        final boolean un = C8451b.m24477un(aVar.prjThemeType);
        if (un) {
            TextView textView2 = new TextView(getContext());
            String og = C8558m.m25024og(aVar.strExtra);
            if (!TextUtils.isEmpty(og)) {
                textView2.setText(og);
            }
            LayoutParams layoutParams4 = new LayoutParams(-2, -2);
            if (VERSION.SDK_INT >= 17) {
                layoutParams4.addRule(20);
                layoutParams4.setMarginStart(C4583d.dpFloatToPixel(getContext(), 6.5f));
            } else {
                layoutParams4.addRule(9);
                layoutParams4.leftMargin = C4583d.dpFloatToPixel(getContext(), 6.5f);
            }
            layoutParams4.addRule(12);
            layoutParams4.bottomMargin = C4583d.m11670O(getContext(), 4);
            textView2.setTextColor(-1);
            textView2.setTextSize(2, 10.0f);
            textView2.setEllipsize(TruncateAt.END);
            textView2.setSingleLine();
            relativeLayout.addView(textView2, layoutParams4);
        }
        relativeLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Context context = StudioItemView.this.djV.getContext();
                IFreezeService iFreezeService = (IFreezeService) BizServiceManager.getService(IFreezeService.class);
                if (iFreezeService != null) {
                    int freezeCode = iFreezeService.getFreezeCode();
                    if (freezeCode == 203) {
                        iFreezeService.showFreezeDialog(StudioItemView.this.getContext(), UserServiceProxy.getUserId(), freezeCode);
                        return;
                    }
                }
                if (context != null) {
                    IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
                    if (iEditorService != null) {
                        String[] ok = C8558m.m25028ok(aVar.strExtra);
                        C5553a.m15009b(ok[0], ok[1], false);
                        iEditorService.enterPreview((Activity) context, aVar.strPrjURL, un, EditorRouter.ENTRANCE_HOME_PAGE);
                    }
                }
                UserBehaviorUtilsV5.onEventHomeStudioClick(context, "project");
            }
        });
        return relativeLayout;
    }

    /* renamed from: fy */
    private static MSize m20095fy(Context context) {
        int dpFloatToPixel = C4583d.dpFloatToPixel(context, 3.5f);
        int O = ((Constants.getScreenSize().width - (C4583d.m11670O(context, 15) * 2)) - (dpFloatToPixel * 2)) / 3;
        return new MSize(O, (int) (((float) O) / 1.3392857f));
    }

    public static int getDraftLayoutHeight(Context context) {
        return m20095fy(context).height + C4583d.m11671P(48.0f) + C4583d.m11671P(30.0f) + C4583d.m11671P(15.0f);
    }

    private View getShadowView() {
        View view = new View(getContext());
        LayoutParams layoutParams = new LayoutParams(-1, C4583d.m11671P(26.0f));
        layoutParams.addRule(12);
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.drawable.home_studio_bottom_shadow);
        return view;
    }

    /* renamed from: py */
    private void m20096py(int i) {
        int i2 = 1;
        if (!(C7589a.aAc() || C7590b.m22368rQ(32)) && (C7589a.isAdAvailable(getContext(), 32) || this.bFx != null)) {
            if (i >= 2) {
                i2 = 2;
            } else if (i <= 0) {
                i2 = -1;
            }
            if (i2 >= 0) {
                View adView = C7589a.getAdView(getContext(), 32);
                if (!(adView == null || this.bFx == adView)) {
                    adView.setLayoutParams(new LinearLayout.LayoutParams(m20095fy(getContext()).width + C4583d.m11671P(19.0f), -1));
                    this.bFx = adView;
                }
                this.boS.removeViewAt(i2);
                try {
                    if (this.bFx != null) {
                        this.boS.addView(this.bFx, i2);
                        UserBehaviorUtils.recordHomeStudioAdEvent("Ad_HomeStudio_Show", C7591a.m22370W(this.bFx.getTag()));
                    }
                } catch (Exception e) {
                    LogUtils.m14222e(TAG, e.getMessage());
                    if (e instanceof IllegalStateException) {
                        C5523b.logException(e);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setEmptyHintViewVisible(boolean z) {
        int i = 8;
        this.djT.setVisibility(z ? 0 : 8);
        RelativeLayout relativeLayout = this.djV;
        if (!z) {
            i = 0;
        }
        relativeLayout.setVisibility(i);
    }

    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onCreate() {
        C10021c.aZH().mo38494ax(this);
    }

    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onDestroy() {
        C10021c.aZH().mo38496az(this);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(StudioActionEvent studioActionEvent) {
        refresh();
    }

    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onResume() {
        LogUtilsV2.m14227d("onResume");
        refresh();
    }

    public void refresh() {
        C8446b.aIZ().mo34317an(getContext(), 0).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<C8445a>>() {
            /* renamed from: R */
            public void mo9886K(List<C8445a> list) {
                if (list == null || list.isEmpty()) {
                    StudioItemView.this.setEmptyHintViewVisible(true);
                    StudioItemView.this.m20086KH();
                } else {
                    StudioItemView.this.setEmptyHintViewVisible(false);
                    StudioItemView.this.m20091bJ(list);
                }
                StudioItemView.this.asC();
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
}
