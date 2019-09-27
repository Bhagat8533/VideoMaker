package com.introvd.template.app.creation;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.app.api.model.FeatureRequestResult;
import com.introvd.template.app.api.model.FeatureRequestResult.FeatureItem;
import com.introvd.template.app.homepage.AppModelConfigInfo;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.homepage.C3935b.C3941a;
import com.introvd.template.app.homepage.C3950d;
import com.introvd.template.app.homepage.FloatImageView;
import com.introvd.template.app.homepage.FloatImageView.C3921a;
import com.introvd.template.app.manager.C4047b;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FeedbackRefreshEvent;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.custom.VideoViewForCreationModel;
import com.introvd.template.component.feedback.C5349b;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p337i.C7675d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4599k;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.banner.BannerInfo;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.setting.VivaSettingRouter.SettingPrams;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.xyui.BadgeHelper;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.controller.BannerJSAdapter;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import okhttp3.C9804ad;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9740h;

public class CreationFragment extends FragmentBase {
    private RelativeLayout bof;
    /* access modifiers changed from: private */
    public DynamicLoadingImageView bog;
    /* access modifiers changed from: private */
    public DynamicLoadingImageView boh;
    private DynamicLoadingImageView boi;
    private DynamicLoadingImageView boj;
    /* access modifiers changed from: private */
    public DynamicLoadingImageView bok;
    /* access modifiers changed from: private */
    public View bol;
    /* access modifiers changed from: private */
    public boolean bom = false;
    /* access modifiers changed from: private */
    public boolean bon = false;
    private boolean boo;
    private boolean bop = true;
    /* access modifiers changed from: private */
    public boolean boq = false;
    /* access modifiers changed from: private */
    public long bor = 0;
    C4047b bos = null;
 C3821d bot = null;
    /* access modifiers changed from: private */
    public BadgeHelper bou;
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: com.introvd.template.app.creation.CreationFragment$a */
    private static class C3809a extends Handler {
        private WeakReference<CreationFragment> boy = null;

        public C3809a(CreationFragment creationFragment) {
            this.boy = new WeakReference<>(creationFragment);
        }

        public void handleMessage(Message message) {
            final CreationFragment creationFragment = (CreationFragment) this.boy.get();
            if (creationFragment != null && creationFragment.getActivity() != null) {
                final boolean z = true;
                switch (message.what) {
                    case 1001:
                        creationFragment.bom = true;
                        creationFragment.bos.mo23720b(creationFragment.bot.mo23317cf(creationFragment.getActivity()), message.obj != null && ((Boolean) message.obj).booleanValue());
                        if (creationFragment.bon) {
                            removeMessages(1005);
                            sendMessage(obtainMessage(1005, 1, 0));
                            break;
                        }
                        break;
                    case 1002:
                        creationFragment.bon = true;
                        if (creationFragment.bom) {
                            removeMessages(1005);
                            sendMessage(obtainMessage(1005, 1, 0));
                            break;
                        }
                        break;
                    case 1003:
                        removeMessages(1003);
                        C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_BANNER_PAGE, (C8354a) new C8354a() {
                            /* renamed from: a */
                            public void mo23009a(Context context, String str, int i, Bundle bundle) {
                                C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_BANNER_PAGE);
                                long currentTimeMillis = System.currentTimeMillis() - creationFragment.bor;
                                String str2 = "Home_refresh_banner_function";
                                if (i == 131072) {
                                    creationFragment.m9312a(context, str2, currentTimeMillis, creationFragment.boq, true, "");
                                    C3809a.this.sendEmptyMessage(1002);
                                    return;
                                }
                                int i2 = bundle.getInt("errCode");
                                CreationFragment creationFragment = creationFragment;
                                boolean d = creationFragment.boq;
                                StringBuilder sb = new StringBuilder();
                                sb.append("");
                                sb.append(i2);
                                creationFragment.m9312a(context, str2, currentTimeMillis, d, false, sb.toString());
                                creationFragment.bon = true;
                                if (creationFragment.bom) {
                                    C3809a.this.removeMessages(1005);
                                    C3809a.this.sendMessage(C3809a.this.obtainMessage(1005, 0, 0));
                                }
                            }
                        });
                        C8346e.m24077d(creationFragment.getActivity(), 0, AppStateModel.getInstance().getCountryCode(), "105,104,11,10401,107,10402,18001,18002,18003,18004,18005,18006,6001,111,122,101");
                        if (message.obj == null || !((Boolean) message.obj).booleanValue()) {
                            z = false;
                        }
                        if (!z) {
                            C3935b.m9679Lb().mo23482a((Context) creationFragment.getActivity(), (C3941a) new C3941a() {
                                /* renamed from: bu */
                                public void mo23296bu(boolean z) {
                                    if (z) {
                                        creationFragment.m9309Km();
                                        creationFragment.bos.mo23717Z(AppStateModel.getInstance().isInChina() ? creationFragment.bot.mo23311Ku() : creationFragment.bot.mo23310Kt());
                                        creationFragment.bos.mo23718aa(AppStateModel.getInstance().isInChina() ? creationFragment.bot.mo23313Kw() : creationFragment.bot.mo23312Kv());
                                        C3809a.this.sendEmptyMessage(1006);
                                        C3809a.this.sendEmptyMessage(1007);
                                    }
                                }
                            });
                            break;
                        } else {
                            return;
                        }
                    case 1004:
                        removeMessages(1004);
                        if (message.obj == null || !((Boolean) message.obj).booleanValue()) {
                            z = false;
                        }
                        C3727b.m9084c(C4580b.m11635Si(), AppStateModel.getInstance().getCountryCode(), "105,70", C4580b.m11653dz(VivaBaseApplication.m8749FZ()), UserServiceProxy.getUserId()).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<FeatureRequestResult, FeatureRequestResult>() {
                            /* renamed from: b */
                            public FeatureRequestResult apply(FeatureRequestResult featureRequestResult) {
                                Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_DYNAMIC_FEATURE);
                                ContentResolver contentResolver = VivaBaseApplication.m8749FZ().getContentResolver();
                                contentResolver.delete(tableUri, null, null);
                                for (int i = 0; i < featureRequestResult.list.size(); i++) {
                                    FeatureItem featureItem = (FeatureItem) featureRequestResult.list.get(i);
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(SocialConstDef.DYNAMIC_FEATURE_RAW_ID, Integer.valueOf(featureItem.f3373id));
                                    contentValues.put("type", Integer.valueOf(featureItem.type));
                                    contentValues.put("orderno", Integer.valueOf(featureItem.orderno));
                                    contentValues.put(SocialConstDef.DYNAMIC_FEATURE_OBJ, new Gson().toJson((JsonElement) featureItem.obj));
                                    contentValues.put("title", featureItem.title);
                                    contentValues.put("modelcode", featureItem.parentmodelcode);
                                    contentValues.put(SocialConstDef.DYNAMIC_FEATURE_VIEWTYPE, Integer.valueOf(featureItem.viewtype));
                                    contentResolver.insert(tableUri, contentValues);
                                }
                                return featureRequestResult;
                            }
                        }).mo10188a((C1850u<? super T>) new C1850u<FeatureRequestResult>() {
                            /* renamed from: a */
                            public void mo9883a(C1495b bVar) {
                            }

                            /* renamed from: a */
                            public void onSuccess(FeatureRequestResult featureRequestResult) {
                                long currentTimeMillis = System.currentTimeMillis() - creationFragment.bor;
                                creationFragment.m9312a(VivaBaseApplication.m8749FZ(), "Home_refresh_recommend", currentTimeMillis, creationFragment.boq, true, "");
                                creationFragment.bot.mo23318cg(VivaBaseApplication.m8749FZ());
                                Message obtainMessage = C3809a.this.obtainMessage(1001, Boolean.valueOf(false));
                                obtainMessage.obj = Boolean.valueOf(z);
                                C3809a.this.sendMessage(obtainMessage);
                            }

                            public void onError(Throwable th) {
                                th.printStackTrace();
                                long currentTimeMillis = System.currentTimeMillis() - creationFragment.bor;
                                String str = "Home_refresh_recommend";
                                try {
                                    if (th instanceof C9740h) {
                                        C9804ad baJ = ((C9740h) th).baz().baJ();
                                        if (baJ != null) {
                                            int asInt = ((JsonObject) new Gson().fromJson(baJ.charStream(), JsonObject.class)).get(IronSourceConstants.EVENTS_ERROR_CODE).getAsInt();
                                            CreationFragment creationFragment = creationFragment;
                                            VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
                                            boolean d = creationFragment.boq;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("");
                                            sb.append(asInt);
                                            creationFragment.m9312a(FZ, str, currentTimeMillis, d, false, sb.toString());
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                creationFragment.bom = true;
                                if (creationFragment.bon) {
                                    C3809a.this.removeMessages(1005);
                                    C3809a.this.sendMessage(C3809a.this.obtainMessage(1005, 0, 0));
                                }
                            }
                        });
                        break;
                    case 1005:
                        creationFragment.boq = false;
                        creationFragment.bos.mo23713MZ().setRefreshing(false);
                        creationFragment.bom = false;
                        creationFragment.bon = false;
                        break;
                    case 1006:
                        C3814a.m9345a(creationFragment.bok);
                        break;
                    case 1007:
                        C3814a.m9346a(creationFragment.boh, creationFragment.bol);
                        break;
                }
            }
        }
    }

    /* renamed from: Kl */
    private void m9308Kl() {
        this.boj = (DynamicLoadingImageView) this.bof.findViewById(R.id.imgview_logo_icon);
        TextView textView = (TextView) this.bof.findViewById(R.id.txtview_logo_text);
        if (C4580b.m11633Sg()) {
            this.boj.setVisibility(8);
            textView.setVisibility(0);
        } else {
            this.boj.setVisibility(0);
            textView.setVisibility(8);
        }
        this.boi = (DynamicLoadingImageView) this.bof.findViewById(R.id.img_head);
        this.boh = (DynamicLoadingImageView) this.bof.findViewById(R.id.btn_shuffle);
        this.bol = this.bof.findViewById(R.id.btn_shuffle_dot);
        C3814a.m9346a(this.boh, this.bol);
        this.bog = (DynamicLoadingImageView) this.bof.findViewById(R.id.creation_setting);
        this.bog.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                VivaRouter.getRouterBuilder(SettingPrams.URL).mo10386a(CommonParams.INTENT_MAGIC_CODE, CreationFragment.this.mActivity.getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0)).mo10391a(SettingPrams.BUNDLE_DATA_KEY_GO_FEEDBACK, false).mo10382H(CreationFragment.this.mActivity);
                UserBehaviorUtils.recordHomeClick("setting");
                AppModelConfigInfo Li = C3935b.m9679Lb().mo23479Li();
                if (Li != null) {
                    Context context = CreationFragment.this.getContext();
                    String str = Li.title;
                    StringBuilder sb = new StringBuilder();
                    sb.append(Li.f3378id);
                    sb.append("");
                    UserBehaviorABTestUtils.onEventShowSetting(context, str, sb.toString(), false);
                }
            }
        });
        if (AppStateModel.getInstance().isCommunitySupport()) {
            this.bog.setVisibility(8);
        } else {
            this.bog.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.boh.getLayoutParams();
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginEnd(C4583d.m11671P(57.0f));
            } else {
                layoutParams.rightMargin = C4583d.m11671P(57.0f);
            }
            AppModelConfigInfo Li = C3935b.m9679Lb().mo23479Li();
            if (Li != null) {
                Context context = getContext();
                String str = Li.title;
                StringBuilder sb = new StringBuilder();
                sb.append(Li.f3378id);
                sb.append("");
                UserBehaviorABTestUtils.onEventShowSetting(context, str, sb.toString(), true);
            }
        }
        this.bok = (DynamicLoadingImageView) this.bof.findViewById(R.id.btn_vip);
        C3814a.m9345a(this.bok);
    }

    /* access modifiers changed from: private */
    /* renamed from: Km */
    public void m9309Km() {
        AppModelConfigInfo Le = C3935b.m9679Lb().mo23475Le();
        if (C3742b.m9111II().mo23142JJ()) {
            this.boi.setPlaceholderImage(R.drawable.vivavideo_create_bg_testb);
        } else {
            this.boi.setPlaceholderImage(R.drawable.vivavideo_create_bg);
        }
        if (Le != null && !TextUtils.isEmpty(Le.content)) {
            this.boi.setImageURI(Le.content);
            Context context = getContext();
            String str = Le.title;
            StringBuilder sb = new StringBuilder();
            sb.append(Le.f3378id);
            sb.append("");
            UserBehaviorABTestUtils.onEventTopIcon(context, str, sb.toString(), true);
        }
        if (this.boj.getVisibility() == 0) {
            AppModelConfigInfo Lf = C3935b.m9679Lb().mo23476Lf();
            if (Lf != null && !TextUtils.isEmpty(Lf.content)) {
                this.boj.setImageURI(Lf.content);
            }
        }
        if (this.bog.getVisibility() == 0) {
            AppModelConfigInfo Li = C3935b.m9679Lb().mo23479Li();
            if (Li != null && !TextUtils.isEmpty(Li.content)) {
                this.bog.setImageURI(Li.content);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9312a(Context context, String str, long j, boolean z, boolean z2, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", z2 ? "success" : BannerJSAdapter.FAIL);
        hashMap.put("duration_new", m9329y(j));
        hashMap.put("type", z ? "mannual" : "auto");
        String dL = C4599k.m11733dL(context);
        hashMap.put("networkType", dL);
        if (!z2) {
            StringBuilder sb = new StringBuilder();
            sb.append(dL);
            sb.append("#");
            sb.append(str2);
            hashMap.put("errorcode", sb.toString());
        }
        UserBehaviorLog.onKVEvent(getContext(), str, hashMap);
    }

    /* renamed from: y */
    private String m9329y(long j) {
        String str = "大于10s";
        if (j < 0) {
            j = 0;
        }
        int i = ((int) j) / 1000;
        if (i >= 10) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        sb.append("-");
        sb.append(i + 1);
        return sb.toString();
    }

    /* renamed from: Kn */
    public void mo23284Kn() {
        if (!AppStateModel.getInstance().isCommunitySupport()) {
            this.bog.post(new Runnable() {
                public void run() {
                    if (CreationFragment.this.getActivity() != null && !CreationFragment.this.getActivity().isFinishing()) {
                        if (CreationFragment.this.bou == null) {
                            CreationFragment.this.bou = new BadgeHelper(CreationFragment.this.getActivity()).mo36037vM(0).mo36036v(0, C4583d.m11671P(2.0f), C4583d.m11671P(2.0f), 0).mo36027G(true, true);
                            CreationFragment.this.bou.mo36029do(CreationFragment.this.bog);
                        }
                        CreationFragment.this.bou.setBadgeEnable(C5349b.m14582ek(CreationFragment.this.getContext()));
                    }
                }
            });
        }
    }

    /* renamed from: Ko */
    public void mo23285Ko() {
        if (this.bos != null) {
            this.bos.mo23721bC(false);
        }
    }

    /* renamed from: Kp */
    public void mo23286Kp() {
        mo23285Ko();
        if (this.bos != null) {
            this.bos.mo23713MZ().setRefreshing(true);
            this.bor = System.currentTimeMillis();
            this.boq = true;
            this.mHandler.sendEmptyMessage(1003);
            Message obtainMessage = this.mHandler.obtainMessage(1004);
            obtainMessage.obj = Boolean.valueOf(true);
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    /* renamed from: Kq */
    public void mo23287Kq() {
        final BannerInfo Ln = C3950d.m9740Lm().mo23509Ln();
        if (Ln != null && !TextUtils.isEmpty(Ln.strContentUrl) && !AppPreferencesSetting.getInstance().getAppSettingStr("key_closed_float_image_url", "").equals(Ln.strContentUrl)) {
            final FloatImageView floatImageView = (FloatImageView) this.bof.findViewById(R.id.float_imageview);
            LayoutParams layoutParams = (LayoutParams) floatImageView.getLayoutParams();
            if (AppStateModel.getInstance().isCommunitySupport()) {
                layoutParams.bottomMargin = C4583d.m11670O(getActivity(), 55);
            } else {
                layoutParams.bottomMargin = C4583d.m11670O(getActivity(), 5);
            }
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
                    UserBehaviorUtilsV5.onEventHomeFloatClick(CreationFragment.this.getActivity(), Ln.strContentTitle, false);
                }

                /* renamed from: Ks */
                public void mo23294Ks() {
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = Ln.todoType;
                    tODOParamModel.mJsonParam = Ln.strTodoContent;
                    BizAppTodoActionManager.getInstance().executeTodo(CreationFragment.this.mActivity, tODOParamModel);
                    UserBehaviorUtilsV5.onEventHomeFloatClick(CreationFragment.this.getActivity(), Ln.strContentTitle, true);
                    FragmentActivity activity = CreationFragment.this.getActivity();
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C10021c.aZH().mo38494ax(this);
        this.mHandler = new C3809a(this);
        this.mActivity = getActivity();
        this.bof = (RelativeLayout) layoutInflater.inflate(R.layout.creation_fragment_layout, viewGroup, false);
        View findViewById = this.bof.findViewById(R.id.view_bottom_shadow);
        if (VERSION.SDK_INT >= 21) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        this.bos = new C4047b(getActivity(), this.bof);
        this.bot = new C3821d();
        this.bot.mo23318cg(VivaBaseApplication.m8749FZ());
        this.bos.mo23717Z(AppStateModel.getInstance().isInChina() ? this.bot.mo23311Ku() : this.bot.mo23310Kt());
        this.bos.mo23718aa(AppStateModel.getInstance().isInChina() ? this.bot.mo23313Kw() : this.bot.mo23312Kv());
        this.bos.mo23719ab(this.bot.mo23317cf(getActivity()));
        this.bos.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                if (C4599k.m11735dN(CreationFragment.this.mActivity.getApplicationContext())) {
                    CreationFragment.this.bor = System.currentTimeMillis();
                    CreationFragment.this.boq = true;
                    CreationFragment.this.mHandler.sendEmptyMessage(1003);
                    Message obtainMessage = CreationFragment.this.mHandler.obtainMessage(1004);
                    obtainMessage.obj = Boolean.valueOf(true);
                    CreationFragment.this.mHandler.sendMessage(obtainMessage);
                } else {
                    CreationFragment.this.bos.mo23713MZ().setRefreshing(false);
                    ToastUtils.show(CreationFragment.this.mActivity.getApplicationContext(), R.string.xiaoying_str_studio_msg_report_video_fail, 0);
                }
                C7589a.m22360aj(CreationFragment.this.getActivity(), 32);
                if (!C7675d.m22507kq(C7675d.m22508rW(42))) {
                    C7589a.m22360aj(CreationFragment.this.getActivity(), 42);
                }
                if (!C7680l.aAe().isAdAvailable(CreationFragment.this.getContext(), 19)) {
                    C7680l.aAe().mo32526aj(CreationFragment.this.mActivity, 19);
                }
            }
        });
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1003, Boolean.valueOf(true)));
        this.mHandler.sendEmptyMessage(1004);
        this.bor = System.currentTimeMillis();
        this.boq = false;
        m9308Kl();
        return this.bof;
    }

    public void onDestroy() {
        if (this.bos != null) {
            this.bos.onDestroy();
        }
        C10021c.aZH().mo38496az(this);
        super.onDestroy();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(FeedbackRefreshEvent feedbackRefreshEvent) {
        mo23284Kn();
    }

    public void onHiddenChanged(boolean z) {
        if (z) {
            VideoViewForCreationModel.getInstance(this.mActivity).resetPlayer();
        } else if (AppPreferencesSetting.getInstance().getAppSettingBoolean("key_pref_refresh_creation_ui", false)) {
            this.mHandler.sendEmptyMessage(1003);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("key_pref_refresh_creation_ui", false);
        }
        mo23284Kn();
    }

    public boolean onKeyUp() {
        if (this.bos == null || !this.bos.onKeyUp()) {
            return super.onKeyUp();
        }
        return true;
    }

    public void onPause() {
        if (this.bos != null) {
            this.bos.onPause();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (!this.bop) {
            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
            if (iEditorService != null) {
                iEditorService.removeCommonBehaviorParam();
            }
        } else {
            this.bop = false;
        }
        UserBehaviorLog.pageFragmentAppear(getActivity(), "Creation");
        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("key_pref_refresh_creation_ui", false)) {
            this.mHandler.sendEmptyMessage(1003);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("key_pref_refresh_creation_ui", false);
        }
        mo23284Kn();
        m9309Km();
        if (this.bos != null) {
            this.bos.onResume();
        }
        mo23287Kq();
        this.bof.post(new Runnable() {
            public void run() {
                if (CreationFragment.this.bos != null && CreationFragment.this.bot != null) {
                    CreationFragment.this.bos.mo23715X(CreationFragment.this.bot.mo23311Ku());
                    CreationFragment.this.bos.mo23716Y(CreationFragment.this.bot.mo23311Ku());
                }
            }
        });
    }
}
