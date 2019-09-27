package com.introvd.template.app.manager;

import android.app.Activity;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0069g;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.R;
import com.introvd.template.app.C3671a;
import com.introvd.template.app.community.freeze.C3763b;
import com.introvd.template.app.homepage.AppModelConfigInfo;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.homepage.creation.C3948a;
import com.introvd.template.app.homepage.creation.C3949b;
import com.introvd.template.app.homepage.creation.MainToolItemView;
import com.introvd.template.app.homepage.creation.SubToolItemView;
import com.introvd.template.app.homepage.p186a.C3929a;
import com.introvd.template.app.homepage.p186a.C3929a.C3931a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p199v5.common.p200ui.videolist.C4426a;
import com.introvd.template.app.p199v5.common.p200ui.videolist.CreationListView;
import com.introvd.template.app.p199v5.common.p200ui.videolist.CreationListView.C4423a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.custom.VideoViewForCreationModel;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.common.utils.UtilsDevice;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.home.C7971c;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.VivaRouter.VideoEditorParams;
import com.introvd.template.router.camera.CameraRouter;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.todoCode.TodoH5UrlFromParamHandler;
import com.introvd.template.router.user.UserServiceProxy;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.manager.b */
public class C4047b implements OnTouchListener {
    /* access modifiers changed from: private */

    /* renamed from: OC */
    public View f3386OC;
    /* access modifiers changed from: private */
    public Context bbr;
    /* access modifiers changed from: private */
    public DynamicLoadingImageView boi;
    private View btV;
    private int btW;
    private int btX;
    private SwipeRefreshLayout btY;
    /* access modifiers changed from: private */
    public ImageView btZ = null;
    /* access modifiers changed from: private */
    public RelativeLayout bua;
    /* access modifiers changed from: private */
    public ImageView bub;
    /* access modifiers changed from: private */
    public CreationListView buc;
    private C4426a bud;
    private List<ModeItemInfo> bue = new ArrayList();
    /* access modifiers changed from: private */
    public FrameLayout bug;
    /* access modifiers changed from: private */
    public MainToolItemView buh;
    private SubToolItemView bui;
    private View buj;
    private int buk = -1;
    private C3929a bul;
    private LayoutInflater mInflater;

    public C4047b(final Context context, View view) {
        this.bbr = context;
        AppPreferencesSetting.getInstance().setAppSettingStr("key_ad_show_time_stamp", "0");
        this.mInflater = LayoutInflater.from(this.bbr);
        if (view == null) {
            this.btV = this.mInflater.inflate(R.layout.creation_fragment_layout, null);
        } else {
            this.btV = view;
        }
        this.btW = Constants.getScreenSize().width;
        this.btX = Constants.getScreenSize().height;
        this.boi = (DynamicLoadingImageView) this.btV.findViewById(R.id.img_head);
        this.bua = (RelativeLayout) this.btV.findViewById(R.id.creation_home_title_layout);
        this.bub = (ImageView) this.btV.findViewById(R.id.img_title_divider);
        if (VERSION.SDK_INT < 19) {
            Rect rect = new Rect();
            if (this.bbr instanceof Activity) {
                ((Activity) this.bbr).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            }
            this.btX -= rect.top;
        }
        this.bud = new C4426a(this.bbr, this.bue, 23);
        this.buc = (CreationListView) this.btV.findViewById(R.id.creation_bottom_list);
        this.buc.setScrollEventId("Home_Video_Scroll");
        this.btZ = (ImageView) this.btV.findViewById(R.id.creation_back_top);
        this.btZ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C4047b.this.mo23721bC(true);
                UserBehaviorLog.onKVEvent(context, "Home_Top_Click", new HashMap());
            }
        });
        this.buc.setOnOffsetTopListener(new C4423a() {
            /* renamed from: O */
            private void m10088O(float f) {
                int i = (int) (255.0f - (f * 255.0f));
                if (i >= 255) {
                    C4047b.this.bub.setVisibility(0);
                } else {
                    C4047b.this.bub.setVisibility(8);
                }
                C4047b.this.bua.setBackgroundColor(Color.argb(i, 255, 255, 255));
            }

            /* renamed from: Nd */
            public void mo23731Nd() {
                if (C4047b.this.f3386OC != null && C4047b.this.bug != null) {
                    m10088O((((float) Math.max(0, (C4047b.this.f3386OC.getBottom() - C4047b.this.bug.getHeight()) - C4047b.this.buc.getPaddingTop())) * 1.0f) / ((float) (C4047b.this.f3386OC.getHeight() - C4047b.this.bug.getHeight())));
                    C4047b.this.boi.setTranslationY((float) (C4047b.this.f3386OC.getTop() - C4047b.this.buc.getPaddingTop()));
                }
            }

            /* renamed from: bD */
            public void mo23732bD(boolean z) {
                C4047b.this.btZ.setVisibility(z ? 0 : 8);
            }
        });
        this.buc.setThresholdPage(2);
        this.f3386OC = this.mInflater.inflate(R.layout.creation_fragment_head_layout, null);
        this.buj = this.f3386OC.findViewById(R.id.home_extra_click_root);
        this.buc.addHeaderView(this.f3386OC);
        this.buc.setAdapter((ListAdapter) this.bud);
        init();
        new C3671a().mo23022bx(this.f3386OC);
        m10062MX();
    }

    /* renamed from: MX */
    private void m10062MX() {
        if (C3742b.m9111II().mo23142JJ()) {
            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
            int i = 0;
            if (iEditorService != null) {
                i = iEditorService.getDraftLayoutHeight(this.bbr);
            }
            int P = (((((this.btX - C4583d.m11671P(42.0f)) - (C3948a.m9737co(this.bbr) * 2)) - i) - C4583d.m11671P(15.0f)) - C4583d.m11671P(20.0f)) - C4583d.m11671P(60.0f);
            if (NotchUtil.isNotchDevice()) {
                P += UtilsDevice.getStatusBarHeight(this.bbr);
            }
            if (P > 0) {
                LayoutParams layoutParams = (LayoutParams) this.buh.getLayoutParams();
                layoutParams.topMargin = P;
                this.buh.setLayoutParams(layoutParams);
                this.buh.requestLayout();
                int P2 = (this.btX - i) - C4583d.m11671P(60.0f);
                LayoutParams layoutParams2 = (LayoutParams) this.boi.getLayoutParams();
                layoutParams2.height = P2;
                this.boi.setLayoutParams(layoutParams2);
                this.boi.requestLayout();
                return;
            }
            return;
        }
        LayoutParams layoutParams3 = (LayoutParams) this.boi.getLayoutParams();
        layoutParams3.height = this.btW;
        this.boi.setLayoutParams(layoutParams3);
        this.boi.requestLayout();
    }

    /* renamed from: MY */
    private void m10063MY() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null && C3742b.m9111II().mo23149JQ() != 1) {
            View studioItemView = iEditorService.getStudioItemView(this.f3386OC.getContext());
            if (studioItemView != null) {
                this.bug.addView(studioItemView, new FrameLayout.LayoutParams(-1, -1));
                if ((studioItemView instanceof C0068f) && (this.f3386OC.getContext() instanceof C0069g)) {
                    ((C0069g) this.f3386OC.getContext()).getLifecycle().mo152a((C0068f) studioItemView);
                }
            }
        }
    }

    /* renamed from: Na */
    private void m10064Na() {
    }

    /* renamed from: Nb */
    public static boolean m10065Nb() {
        if (!C8072q.aBx().isVip()) {
            if (!C8072q.aBx().mo33070i(C7825a.GOLD_MONTHLY.getId(), C7825a.GOLD_YEARLY.getId())) {
                return AppPreferencesSetting.getInstance().getAppSettingBoolean("home_help_show_flag", true);
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m10067a(Activity activity, ModeItemInfo modeItemInfo) {
        if (activity != null && !activity.isFinishing() && modeItemInfo != null) {
            if (activity.getIntent() != null) {
                activity.getIntent().removeExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
            }
            TODOParamModel tODOParamModel = new TODOParamModel();
            tODOParamModel.mTODOCode = modeItemInfo.todoCode;
            tODOParamModel.mJsonParam = modeItemInfo.todoParameter;
            TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_TYPE_CREATION_FUN, modeItemInfo.itemName);
            Bundle bundle = new Bundle();
            bundle.putString(EditorRouter.COMMON_PARAM_POSITION, EditorRouter.COMMON_BEHAVIOR_POSITION_CREATION);
            BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel, bundle);
        }
    }

    /* renamed from: b */
    public static void m10069b(final Context context, final ModeItemInfo modeItemInfo) {
        if (context instanceof Activity) {
            C1820a.aVi().mo10058o(new Runnable() {
                public void run() {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("home_help_show_flag", false);
                }
            });
            if (!((Activity) context).isFinishing()) {
                C7971c cVar = new C7971c(context);
                cVar.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        if (modeItemInfo != null) {
                            UtilsPrefs with = UtilsPrefs.with(context, AppRouter.VIVA_APP_PREF_FILENAME, true);
                            if (modeItemInfo.todoCode == 408) {
                                if (!with.readBoolean("key_show_main_tool_mv_tip", false)) {
                                    with.writeBoolean("key_show_main_tool_mv_tip", true);
                                }
                            } else if (modeItemInfo.todoCode == 401 && !with.readBoolean("key_show_main_tool_editor_tip", false)) {
                                with.writeBoolean("key_show_main_tool_editor_tip", true);
                            }
                        }
                        C4047b.m10067a((Activity) context, modeItemInfo);
                    }
                });
                cVar.show();
            }
        }
    }

    /* renamed from: hd */
    public static void m10076hd(int i) {
        final String he = m10077he(i);
        if (!TextUtils.isEmpty(he)) {
            C1820a.aVi().mo10058o(new Runnable() {
                public void run() {
                    AppPreferencesSetting.getInstance().setAppSettingStr(VideoEditorParams.SOURCE_TO_SIMPLE_EDIT, he);
                }
            });
        }
    }

    /* renamed from: he */
    private static String m10077he(int i) {
        if (i == 201) {
            return "capture";
        }
        if (i == 401) {
            return "video";
        }
        if (i == 408) {
            return "photo";
        }
        if (i == 605) {
            return "material";
        }
        if (i != 701) {
            return null;
        }
        return EditorRouter.ENTRANCE_STUDIO;
    }

    private void init() {
        this.btY = (SwipeRefreshLayout) this.btV.findViewById(R.id.creation_home_swipe_layout);
        this.btY.setColorSchemeResources(R.color.color_ff8e00);
        this.btY.setProgressViewEndTarget(false, C4583d.m11670O(this.bbr, 100));
        LayoutParams layoutParams = (LayoutParams) this.btZ.getLayoutParams();
        int P = AppStateModel.getInstance().isCommunitySupport() ? C4583d.m11671P(48.0f) : 0;
        this.btY.setPadding(0, 0, 0, P);
        if (layoutParams != null) {
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(0);
                layoutParams.topMargin = 0;
                layoutParams.setMarginEnd(C4583d.m11671P(5.0f));
                layoutParams.bottomMargin = C4583d.m11671P(5.0f) + P;
            } else {
                layoutParams.setMargins(0, 0, C4583d.m11671P(5.0f), C4583d.m11671P(5.0f) + P);
            }
            this.btZ.setLayoutParams(layoutParams);
        }
        this.buh = (MainToolItemView) this.f3386OC.findViewById(R.id.home_main_tool_item_view);
        this.bui = (SubToolItemView) this.f3386OC.findViewById(R.id.home_sub_tool_item_view);
        this.bug = (FrameLayout) this.f3386OC.findViewById(R.id.studio_item_view);
        m10063MY();
    }

    /* renamed from: MZ */
    public SwipeRefreshLayout mo23713MZ() {
        return this.btY;
    }

    /* renamed from: Nc */
    public void mo23714Nc() {
        if (this.bul != null) {
            this.bul.mo23459LH();
        }
    }

    /* renamed from: X */
    public void mo23715X(final List<ModeItemInfo> list) {
        UtilsPrefs with = UtilsPrefs.with(this.bbr, AppRouter.VIVA_APP_PREF_FILENAME, true);
        if (!with.readBoolean("key_show_main_tool_mv_tip", false)) {
            if (with.readBoolean("key_show_main_tool_editor_tip", false) || AppPreferencesSetting.getInstance().getAppSettingBoolean(CameraRouter.KEY_PREFER_HAS_ENTER_CAMERA, false)) {
                if (this.bul == null) {
                    this.bul = new C3929a();
                }
                if (this.bbr != null && !this.bul.mo23458LG() && this.buh != null && this.bui != null) {
                    this.bul.mo23461a(list, this.bbr, this.buh, 408, this.bbr.getResources().getString(R.string.xiaoying_str_homeview_photo_mv_help_tip), this.bbr.getResources().getDrawable(R.drawable.xyui_image_help_music));
                    this.buh.mo23495c(list, 408);
                    this.bul.mo23460a((C3931a) new C3931a() {
                        /* renamed from: t */
                        public void mo23463t(View view, int i) {
                            if (C4047b.this.buh != null) {
                                MainToolItemView h = C4047b.this.buh;
                                boolean z = false;
                                if (((ModeItemInfo) list.get(0)).todoCode == i) {
                                    z = true;
                                }
                                h.mo23494by(z);
                            }
                        }
                    });
                    UserBehaviorABTestUtils.homeFunctionTipShow(this.bbr, "Mv_tip");
                }
            }
        }
    }

    /* renamed from: Y */
    public void mo23716Y(final List<ModeItemInfo> list) {
        UtilsPrefs with = UtilsPrefs.with(this.bbr, AppRouter.VIVA_APP_PREF_FILENAME, true);
        if (!with.readBoolean("key_show_main_tool_mv_tip", false) || with.readBoolean("key_show_main_tool_editor_tip", false)) {
            return;
        }
        if (with.readBoolean("key_show_main_tool_mv_tip", false) || !AppPreferencesSetting.getInstance().getAppSettingBoolean(CameraRouter.KEY_PREFER_HAS_ENTER_CAMERA, false)) {
            if (this.bul == null) {
                this.bul = new C3929a();
            }
            if (this.bbr != null && !this.bul.mo23458LG() && this.buh != null && this.bui != null) {
                this.bul.mo23461a(list, this.bbr, this.buh, 401, this.bbr.getResources().getString(R.string.xiaoying_str_homeview_editor_help_tip), this.bbr.getResources().getDrawable(R.drawable.xyui_image_help_editor));
                this.buh.mo23495c(list, 401);
                this.bul.mo23460a((C3931a) new C3931a() {
                    /* renamed from: t */
                    public void mo23463t(View view, int i) {
                        if (C4047b.this.buh != null) {
                            MainToolItemView h = C4047b.this.buh;
                            boolean z = false;
                            if (((ModeItemInfo) list.get(0)).todoCode == i) {
                                z = true;
                            }
                            h.mo23494by(z);
                        }
                    }
                });
                UserBehaviorABTestUtils.homeFunctionTipShow(this.bbr, "edit_tip");
            }
        }
    }

    /* renamed from: Z */
    public void mo23717Z(List<ModeItemInfo> list) {
        final AppModelConfigInfo Le = C3935b.m9679Lb().mo23475Le();
        if (!(Le == null || this.buj == null || Le.eventType == 0)) {
            final TODOParamModel tODOParamModel = new TODOParamModel();
            tODOParamModel.mTODOCode = Le.eventType;
            tODOParamModel.mJsonParam = Le.eventContent;
            this.buj.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C4047b.this.bbr instanceof Activity) {
                        BizAppTodoActionManager.getInstance().executeTodo((Activity) C4047b.this.bbr, tODOParamModel);
                        Context i = C4047b.this.bbr;
                        String str = Le.title;
                        StringBuilder sb = new StringBuilder();
                        sb.append(Le.f3378id);
                        sb.append("");
                        UserBehaviorABTestUtils.onEventTopIcon(i, str, sb.toString(), false);
                    }
                    C7835b.m22861lq("首页工具背景");
                }
            });
        }
        this.buh.setMainToolItemViewListener(new C3949b() {
            /* renamed from: LF */
            public void mo23507LF() {
                C4047b.this.mo23714Nc();
            }

            /* renamed from: b */
            public boolean mo23508b(ModeItemInfo modeItemInfo) {
                int freezeCode = C3763b.getFreezeCode();
                boolean z = true;
                if (freezeCode == 203) {
                    C3763b.m9231Is().mo23238f(C4047b.this.bbr, UserServiceProxy.getUserId(), freezeCode);
                    return true;
                }
                if (!C4047b.m10065Nb() || !C3742b.m9111II().mo23176Jw()) {
                    z = false;
                }
                if (z) {
                    C4047b.m10069b(C4047b.this.bbr, modeItemInfo);
                } else {
                    C4047b.m10076hd(modeItemInfo.todoCode);
                }
                return z;
            }
        });
        this.buh.mo23493a((ModeItemInfo) list.get(0), (ModeItemInfo) list.get(1));
    }

    /* renamed from: aa */
    public void mo23718aa(List<ModeItemInfo> list) {
        this.bui.setSubToolItemViewListener(new C3949b() {
            /* renamed from: LF */
            public void mo23507LF() {
            }

            /* renamed from: b */
            public boolean mo23508b(ModeItemInfo modeItemInfo) {
                int freezeCode = C3763b.getFreezeCode();
                boolean z = true;
                if (freezeCode == 203) {
                    C3763b.m9231Is().mo23238f(C4047b.this.bbr, UserServiceProxy.getUserId(), freezeCode);
                    return true;
                }
                if (!C4047b.m10065Nb() || !C3742b.m9111II().mo23176Jw()) {
                    z = false;
                }
                if (z) {
                    C4047b.m10069b(C4047b.this.bbr, modeItemInfo);
                } else {
                    C4047b.m10076hd(modeItemInfo.todoCode);
                }
                return z;
            }
        });
        this.bui.mo23498W(list);
    }

    /* renamed from: ab */
    public void mo23719ab(List<ModeItemInfo> list) {
        mo23720b(list, true);
    }

    /* renamed from: b */
    public void mo23720b(List<ModeItemInfo> list, boolean z) {
        this.buk = -1;
        if (list != null) {
            this.buk = list.size();
            this.bue.clear();
            this.bue.addAll(list);
            this.bud.mo24524hM(13);
            this.bud.mo24519bU(z);
        }
    }

    /* renamed from: bC */
    public void mo23721bC(boolean z) {
        if (this.buc != null && this.buc.getChildCount() > 0) {
            this.buc.setSelection(0);
        }
    }

    public void onDestroy() {
        if (this.bud != null) {
            this.bud.release();
        }
    }

    public boolean onKeyUp() {
        return false;
    }

    public void onPause() {
        VideoViewForCreationModel.getInstance(this.bbr).resetPlayer();
    }

    public void onResume() {
        m10064Na();
        this.bud.mo24519bU(false);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                view.setAlpha(0.4f);
                break;
            case 1:
            case 3:
                view.setAlpha(1.0f);
                break;
        }
        return false;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        if (this.btY != null) {
            this.btY.setOnRefreshListener(onRefreshListener);
        }
    }
}
