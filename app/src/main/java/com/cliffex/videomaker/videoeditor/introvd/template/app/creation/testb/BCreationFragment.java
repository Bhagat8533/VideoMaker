package com.introvd.template.app.creation.testb;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.creation.C3818b;
import com.introvd.template.app.homepage.AppModelConfigInfo;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.common.utils.UtilsDevice;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.setting.VivaSettingRouter.SettingPrams;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.C2570b;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BCreationFragment extends FragmentBase implements C3854f {
    /* access modifiers changed from: private */
    public static final int boE = C4583d.m11671P(64.0f);
    ViewGroup boF;
    Space boG;
    LinearLayout boH;
    LinearLayout boI;
    MainToolT1View boJ;
    MainToolT1View boK;
    MainToolT2View boL;
    MainToolT2View boM;
    ImageButton boN;
    ImageButton boO;
    ImageView boP;
    ImageView boQ;
    ImageButton boR;
    LinearLayout boS;
    RelativeLayout boT;
    TextView boU;
    CreationDraftView boV;
    /* access modifiers changed from: private */
    public C3834a boW;
    private float boX;

    /* renamed from: KA */
    private void m9389KA() {
        float P = ((float) (Constants.getScreenSize().width - ((C4583d.m11671P(15.0f) * 2) + (C4583d.m11671P(8.0f) * 2)))) / 2.703f;
        this.boX = 1.223f * P;
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.width = (int) P;
        layoutParams.height = (int) this.boX;
        this.boI.setLayoutParams(layoutParams);
        this.boJ.mo23336p(P, this.boX);
        this.boK.mo23336p(P, this.boX);
        float f = P * 0.703f;
        this.boL.mo23338p(f, 0.776f * f);
        this.boM.mo23338p(f, 0.964f * f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.boJ);
        arrayList.add(this.boK);
        arrayList.add(this.boL);
        arrayList.add(this.boM);
        this.boW.mo23347Q(arrayList);
    }

    /* renamed from: bH */
    private void m9392bH(View view) {
        this.boF = (ViewGroup) view.findViewById(R.id.root_layout);
        this.boG = (Space) view.findViewById(R.id.creation_space);
        this.boH = (LinearLayout) view.findViewById(R.id.creation_card_layout);
        this.boI = (LinearLayout) view.findViewById(R.id.main_tool_t2_layout);
        this.boJ = (MainToolT1View) view.findViewById(R.id.main_tool_t1_pos1_view);
        this.boK = (MainToolT1View) view.findViewById(R.id.main_tool_t1_pos2_view);
        this.boL = (MainToolT2View) view.findViewById(R.id.main_tool_t2_pos1_view);
        this.boM = (MainToolT2View) view.findViewById(R.id.main_tool_t2_pos2_view);
        this.boN = (ImageButton) view.findViewById(R.id.hd_camera_btn);
        this.boV = (CreationDraftView) view.findViewById(R.id.draft_view);
        this.boS = (LinearLayout) view.findViewById(R.id.creation_draft_layout);
        this.boT = (RelativeLayout) view.findViewById(R.id.draft_content_layout);
        this.boU = (TextView) view.findViewById(R.id.draft_count);
        this.boP = (ImageView) view.findViewById(R.id.btn_vip);
        this.boQ = (ImageView) view.findViewById(R.id.btn_shuffle);
        this.boO = (ImageButton) view.findViewById(R.id.tutorial_btn);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                BCreationFragment.this.boW.mo23342F(BCreationFragment.this.getActivity());
            }
        }, this.boN);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                BCreationFragment.this.boW.mo23343G(BCreationFragment.this.getActivity());
            }
        }, this.boT);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.show(view);
                BCreationFragment.this.boW.mo23344H(BCreationFragment.this.getActivity());
            }
        }, this.boO);
        m9393bI(view);
        m9389KA();
        m9394bv(true);
    }

    /* renamed from: bI */
    private void m9393bI(View view) {
        this.boR = (ImageButton) view.findViewById(R.id.btn_setting);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                VivaRouter.getRouterBuilder(SettingPrams.URL).mo10391a(SettingPrams.BUNDLE_DATA_KEY_GO_FEEDBACK, false).mo10382H(BCreationFragment.this.getActivity());
            }
        }, this.boR);
        if (AppStateModel.getInstance().isCommunitySupport()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.boQ.getLayoutParams();
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginEnd(C4583d.m11671P(10.0f));
                layoutParams.addRule(21);
            } else {
                layoutParams.rightMargin = C4583d.m11671P(10.0f);
                layoutParams.addRule(11);
            }
            this.boR.setVisibility(8);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.boQ.getLayoutParams();
        if (VERSION.SDK_INT >= 17) {
            layoutParams2.setMarginEnd(C4583d.m11671P(6.0f));
        } else {
            layoutParams2.rightMargin = C4583d.m11671P(6.0f);
        }
        this.boR.setVisibility(0);
    }

    /* renamed from: bv */
    private void m9394bv(boolean z) {
        if (z) {
            int statusBarHeight = ((Constants.getScreenSize().height - UtilsDevice.getStatusBarHeight(getContext())) - (C4583d.m11671P(92.0f) + ((int) this.boX))) - C4583d.m11671P(98.0f);
            if (statusBarHeight < boE) {
                statusBarHeight = boE;
            }
            ViewGroup.LayoutParams layoutParams = this.boG.getLayoutParams();
            layoutParams.height = statusBarHeight;
            this.boG.setLayoutParams(layoutParams);
            return;
        }
        this.boH.post(new Runnable() {
            public void run() {
                int statusBarHeight = ((Constants.getScreenSize().height - UtilsDevice.getStatusBarHeight(BCreationFragment.this.getContext())) - BCreationFragment.this.boH.getMeasuredHeight()) - C4583d.m11671P(98.0f);
                if (statusBarHeight < BCreationFragment.boE) {
                    statusBarHeight = BCreationFragment.boE;
                }
                final ViewGroup.LayoutParams layoutParams = BCreationFragment.this.boG.getLayoutParams();
                if (layoutParams.height != statusBarHeight) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{layoutParams.height, statusBarHeight});
                    ofInt.setDuration(250);
                    ofInt.addUpdateListener(new AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            BCreationFragment.this.boG.setLayoutParams(layoutParams);
                        }
                    });
                    ofInt.start();
                }
            }
        });
    }

    /* renamed from: P */
    public void mo23321P(List<String> list) {
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("creation_pref_key_shown_draft", false);
        if (list.size() == 0) {
            if (!appSettingBoolean) {
                m9394bv(false);
                this.boS.setVisibility(8);
                return;
            } else if (!this.boS.isShown()) {
                this.boS.setVisibility(0);
            }
        }
        AppPreferencesSetting.getInstance().setAppSettingBoolean("creation_pref_key_shown_draft", true);
        if (!this.boS.isShown()) {
            this.boS.setVisibility(0);
        }
        if (this.boU != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(list.size());
            sb.append(")");
            this.boU.setText(sb.toString());
        }
        if (this.boV != null) {
            this.boV.mo23335S(list);
        }
        m9394bv(false);
    }

    /* renamed from: a */
    public void mo23322a(C3843b bVar) {
        if (this.boM != null && this.boM.getTag() == null) {
            this.boM.setTag("Breath");
            C2564c.m7326d(this.boM, 0.88f, 1.05f);
        }
    }

    /* renamed from: a */
    public void mo23323a(final ModeItemInfo modeItemInfo) {
        if (modeItemInfo != null) {
            if (C2561a.aOR() != 1) {
                this.boQ.setVisibility(8);
                return;
            }
            if (modeItemInfo.todoCode == 910) {
                modeItemInfo.itemImgUrl = null;
                modeItemInfo.itemImgBackupRes = Integer.valueOf(R.drawable.vivavideo_tool_shuffle_new);
            }
            if (!TextUtils.isEmpty(modeItemInfo.itemImgUrl)) {
                ImageLoader.loadImage(getContext(), modeItemInfo.itemImgUrl, this.boQ);
            } else if (((Integer) modeItemInfo.itemImgBackupRes).intValue() > 0) {
                C2570b.m7335f(this).mo12193a(Integer.valueOf(((Integer) modeItemInfo.itemImgBackupRes).intValue())).mo12186g(this.boQ);
            }
            Context context = getContext();
            String str = modeItemInfo.itemName;
            StringBuilder sb = new StringBuilder();
            sb.append(modeItemInfo.rawId);
            sb.append("");
            UserBehaviorABTestUtils.onEventHomeNavigationRight(context, str, sb.toString(), true);
            this.boQ.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (BCreationFragment.this.boW.mo23346KG()) {
                        C3818b.m9355M(VivaBaseApplication.m8749FZ(), "AD_icon");
                    } else {
                        C3818b.m9354L(VivaBaseApplication.m8749FZ(), "AD_icon");
                    }
                    C7899c.aDg().setBoolean("is_from_gif_box", true);
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", String.valueOf(modeItemInfo.todoCode));
                    hashMap.put("title", modeItemInfo.itemName);
                    UserBehaviorLog.onKVEvent(BCreationFragment.this.getContext(), "Ad_Box_Icon_Click", hashMap);
                    Context context = BCreationFragment.this.getContext();
                    String str = modeItemInfo.title;
                    StringBuilder sb = new StringBuilder();
                    sb.append(modeItemInfo.itemId);
                    sb.append("");
                    UserBehaviorABTestUtils.onEventHomeNavigationRight(context, str, sb.toString(), false);
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = modeItemInfo.todoCode;
                    tODOParamModel.mJsonParam = modeItemInfo.todoParameter;
                    BizAppTodoActionManager.getInstance().executeTodo(BCreationFragment.this.getActivity(), tODOParamModel);
                }
            });
        }
    }

    /* renamed from: c */
    public void mo23324c(final AppModelConfigInfo appModelConfigInfo) {
        if (C2561a.aOR() == 4) {
            this.boP.setVisibility(8);
            return;
        }
        if (appModelConfigInfo.eventType == 16004) {
            appModelConfigInfo.content = null;
        }
        if (TextUtils.isEmpty(appModelConfigInfo.content)) {
            C2570b.m7335f(this).mo12193a(Integer.valueOf(R.drawable.vivavideo_navi_vip_new)).mo12186g(this.boP);
        } else {
            ImageLoader.loadImage(getContext(), appModelConfigInfo.content, this.boP);
            Context context = getContext();
            String str = appModelConfigInfo.title;
            StringBuilder sb = new StringBuilder();
            sb.append(appModelConfigInfo.f3378id);
            sb.append("");
            UserBehaviorABTestUtils.onEventVIPPage(context, str, sb.toString(), true);
        }
        this.boP.setVisibility(0);
        this.boP.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (appModelConfigInfo.eventType > 0) {
                    if (BCreationFragment.this.boW.mo23346KG()) {
                        C3818b.m9355M(VivaBaseApplication.m8749FZ(), "Vip_icon");
                    } else {
                        C3818b.m9354L(VivaBaseApplication.m8749FZ(), "Vip_icon");
                    }
                    C7835b.m22861lq("home vip");
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", appModelConfigInfo.title);
                    UserBehaviorLog.onKVEvent(BCreationFragment.this.getContext(), "IAP_Vip_Click", hashMap);
                    UserBehaviorUtils.recordHomeClick("vip icon");
                    Context context = BCreationFragment.this.getContext();
                    String str = appModelConfigInfo.title;
                    StringBuilder sb = new StringBuilder();
                    sb.append(appModelConfigInfo.f3378id);
                    sb.append("");
                    UserBehaviorABTestUtils.onEventVIPPage(context, str, sb.toString(), false);
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = appModelConfigInfo.eventType;
                    tODOParamModel.mJsonParam = appModelConfigInfo.eventContent;
                    BizAppTodoActionManager.getInstance().executeTodo(BCreationFragment.this.getActivity(), tODOParamModel);
                }
            }
        });
    }

    public Activity getHostActivity() {
        return getActivity();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.creation_b_fragment_layout, viewGroup, false);
        this.boW = new C3834a();
        this.boW.attachView((C3854f) this);
        this.boW.init(getContext());
        m9392bH(inflate);
        this.boW.mo23345KC();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        this.boW.release();
    }

    public void onResume() {
        super.onResume();
        this.boH.post(new Runnable() {
            public void run() {
                BCreationFragment.this.boW.mo23350bw(true);
            }
        });
    }
}
