package com.introvd.template.template.info;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.introvd.template.EventActivity;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.app.api.model.AppVersionInfo;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.LoadingMoreFooterView;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.datacenter.TaskService;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8064m;
import com.introvd.template.module.iap.business.C7870d;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.C4605o;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.template.C8622a;
import com.introvd.template.template.R;
import com.introvd.template.template.data.C8670b;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.data.api.model.TemplateResponseRoll;
import com.introvd.template.template.download.C8705e;
import com.introvd.template.template.download.C8705e.C8707b;
import com.introvd.template.template.info.p410a.C8827c;
import com.introvd.template.template.info.p410a.C8831d;
import com.introvd.template.template.p402c.C8629b;
import com.introvd.template.template.p404d.C8645a;
import com.introvd.template.template.p404d.C8651b;
import com.introvd.template.template.p404d.C8653d;
import com.introvd.template.template.p404d.C8655f;
import com.introvd.template.template.p407e.C8728c;
import com.introvd.template.template.p407e.C8729d;
import com.introvd.template.template.p407e.C8729d.C8732a;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8733e.C8734a;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p408f.C8747b;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.p131c.p132a.p135c.C2575a;
import com.videoeditor.intromaker.ThemeConfig;
import funtion.one.App;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import p469f.C9740h;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;
import xiaoying.utils.QComUtils;

@C1942a(mo10417rZ = "/Template/Info")
public class TemplateInfoActivity extends EventActivity implements OnClickListener, OnScrollListener, OnItemClickListener, VideoAdsListener, VideoRewardListener, C8707b {
    /* access modifiers changed from: private */

    /* renamed from: FO */
    public ListView f3601FO;
    private C7870d bNG;
    private C8759b bOt;
    private ImageView bvn;
    /* access modifiers changed from: private */
    public boolean byU = false;
    /* access modifiers changed from: private */
    public TODOParamModel csJ = null;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout dCq;
    private List<String> dcI = new ArrayList();
    /* access modifiers changed from: private */
    public LinearLayout dqs;
    /* access modifiers changed from: private */
    public String ekf;
    private List<Integer> ekj = new ArrayList();
    private List<C8792b> ekk = new ArrayList();
    private List<Integer> ekl = new ArrayList();
    private OnRefreshListener eks = new OnRefreshListener() {
        public void onRefresh() {
            if (!C4600l.m11739k(TemplateInfoActivity.this, true)) {
                ToastUtils.show((Context) TemplateInfoActivity.this, R.string.xiaoying_str_com_msg_network_inactive, 1);
                if (TemplateInfoActivity.this.dCq != null) {
                    TemplateInfoActivity.this.dCq.setRefreshing(false);
                    return;
                }
                return;
            }
            TemplateInfoActivity.this.ene = true;
            TemplateInfoActivity.this.emW = 1;
            TemplateInfoActivity.this.emZ.sendEmptyMessage(12289);
        }
    };
    private Button emC;
    private TextView emD;
    /* access modifiers changed from: private */
    public RelativeLayout emF;
    private ImageButton emG;
    private boolean emI = false;
    private boolean emL = true;
    /* access modifiers changed from: private */
    public int emQ = 20;
    /* access modifiers changed from: private */
    public C8827c emR;
    /* access modifiers changed from: private */
    public EditText emS;
    private ImageView emT;
    /* access modifiers changed from: private */
    public int emU;
    private long emV = 0;
    /* access modifiers changed from: private */
    public int emW = 0;
    /* access modifiers changed from: private */
    public boolean emX = false;
    private boolean emY = false;
    /* access modifiers changed from: private */
    public C8789a emZ = null;
    /* access modifiers changed from: private */
    public LoadingMoreFooterView ena = null;
    private View enb;
    /* access modifiers changed from: private */
    public int enc = 3;
    /* access modifiers changed from: private */
    public boolean ene = false;
    /* access modifiers changed from: private */
    public C8729d enf;
    private boolean eng = false;
    private View enh;
    private int eni = -1;
    private String enj = "unknown";
    /* access modifiers changed from: private */
    public C8831d enk;
    /* access modifiers changed from: private */
    public List<C8653d> enl = new ArrayList();
    /* access modifiers changed from: private */
    public List<C8653d> enm = new ArrayList();
    /* access modifiers changed from: private */
    public OnRefreshListener enn = null;
    /* access modifiers changed from: private */
    public OnRefreshListener eno = null;
    private C8651b enp = null;
    private C8651b enq = null;
    private OnEditorActionListener enr = null;
    private TextWatcher ens = null;
    /* access modifiers changed from: private */
    public C8645a ent;
    /* access modifiers changed from: private */
    public String enu = "";
    /* access modifiers changed from: private */
    public boolean isLoading = false;
    /* access modifiers changed from: private */
    public View mEmptyView;
    private String mTitle;

    /* renamed from: com.introvd.template.template.info.TemplateInfoActivity$a */
    private static class C8789a extends Handler {
        private final WeakReference<TemplateInfoActivity> bwg;
        private long enz = 0;

        public C8789a(TemplateInfoActivity templateInfoActivity) {
            this.bwg = new WeakReference<>(templateInfoActivity);
        }

        public void handleMessage(Message message) {
            Message message2 = message;
            final TemplateInfoActivity templateInfoActivity = (TemplateInfoActivity) this.bwg.get();
            if (templateInfoActivity != null) {
                C8827c a = templateInfoActivity.emR;
                final int i = 3;
                int i2 = 0;
                switch (message2.what) {
                    case 1201:
                        if (templateInfoActivity.csJ != null && templateInfoActivity.csJ.mTODOCode == 612) {
                            templateInfoActivity.enf.aLZ();
                            templateInfoActivity.aKS();
                            break;
                        }
                    case 1202:
                        if (C8735f.aMf().mo35143aq(templateInfoActivity, templateInfoActivity.ekf)) {
                            AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append("key_last_template_info_refresh_time_");
                            sb.append(templateInfoActivity.ekf);
                            instance.setAppSettingStr(sb.toString(), "");
                        }
                        C8735f.aMf().mo35149m(templateInfoActivity, templateInfoActivity.ekf, true);
                        break;
                    case 4097:
                        TemplateInfo c = templateInfoActivity.m25735uK(message2.arg1);
                        if (c != null) {
                            if (!C8735f.m25479qm(templateInfoActivity.ekf)) {
                                String str = c.strPreviewurl;
                                if (!TextUtils.isEmpty(str)) {
                                    templateInfoActivity.emU = message2.arg1;
                                    templateInfoActivity.m25682T(str, message2.arg1);
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                templateInfoActivity.emU = message2.arg1;
                                templateInfoActivity.m25741v(c);
                                break;
                            }
                        } else {
                            return;
                        }
                    case 4098:
                        templateInfoActivity.emU = message2.arg1;
                        templateInfoActivity.m25736uL(message2.arg1);
                        break;
                    case 4099:
                        removeMessages(4099);
                        if (templateInfoActivity.dqs != null) {
                            templateInfoActivity.dqs.setVisibility(8);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.enz >= 1000) {
                            this.enz = currentTimeMillis;
                            C8735f.aMf().mo35147cz(templateInfoActivity, templateInfoActivity.ekf);
                            int ql = C8735f.aMf().mo35152ql(templateInfoActivity.ekf);
                            if (ql == 0) {
                                if (templateInfoActivity.ena != null) {
                                    templateInfoActivity.ena.setStatus(0);
                                }
                            } else if (templateInfoActivity.emW * templateInfoActivity.emQ > ql) {
                                templateInfoActivity.byU = true;
                                if (templateInfoActivity.ena != null) {
                                    templateInfoActivity.ena.setStatus(6);
                                }
                            } else {
                                templateInfoActivity.byU = false;
                                if (templateInfoActivity.ena != null) {
                                    templateInfoActivity.ena.setStatus(2);
                                }
                            }
                            if (a != null) {
                                List<TemplateInfo> qk = C8735f.aMf().mo35151qk(templateInfoActivity.ekf);
                                if ((message2.obj instanceof Boolean) && ((Boolean) message2.obj).booleanValue() && qk != null && qk.size() > 0) {
                                    for (TemplateInfo templateInfo : qk) {
                                        if (templateInfo.nState == 8) {
                                            templateInfo.nState = 1;
                                        }
                                    }
                                }
                                a.mo35328d(qk, templateInfoActivity.ene);
                                templateInfoActivity.ene = false;
                            }
                            if (templateInfoActivity.dCq != null) {
                                templateInfoActivity.dCq.setRefreshing(false);
                                break;
                            }
                        } else {
                            sendEmptyMessageDelayed(4099, 1000);
                            return;
                        }
                        break;
                    case 8194:
                        String str2 = (String) message2.obj;
                        int i3 = message2.arg1;
                        if (!(a == null || str2 == null)) {
                            a.mo35324U(str2, i3);
                            a.mo35325V(str2, 8);
                            break;
                        }
                    case 8195:
                        String str3 = (String) message2.obj;
                        if (a != null) {
                            a.mo35324U(str3, 100);
                            a.mo35325V(str3, 3);
                            break;
                        }
                        break;
                    case 12289:
                        if (!C8735f.m25479qm(templateInfoActivity.ekf)) {
                            if (C8399c.ecX.equals(templateInfoActivity.ekf)) {
                                i = templateInfoActivity.enc;
                            }
                            C87912 r3 = new C1850u<List<TemplateResponseInfo>>() {
                                /* renamed from: a */
                                public void mo9883a(C1495b bVar) {
                                }

                                public void onError(Throwable th) {
                                    C8789a.this.sendEmptyMessage(12292);
                                    try {
                                        if (th instanceof C9740h) {
                                            if (((C9740h) th).baz().baJ() != null) {
                                                UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), templateInfoActivity.ekf, ((JsonObject) new Gson().fromJson(((C9740h) th).baz().baJ().charStream(), JsonObject.class)).get(IronSourceConstants.EVENTS_ERROR_CODE).getAsInt(), i, ParametersKeys.FAILED, "tb");
                                            } else {
                                                return;
                                            }
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    C8789a.this.sendMessage(C8789a.this.obtainMessage(16385, Integer.valueOf(65536)));
                                }

                                public void onSuccess(List<TemplateResponseInfo> list) {
                                    C8789a.this.sendEmptyMessage(12291);
                                    if (list.size() == 0) {
                                        UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), templateInfoActivity.ekf, -1, i, "success", "tb");
                                    }
                                    C8789a.this.sendMessage(C8789a.this.obtainMessage(16385, Integer.valueOf(131072)));
                                }
                            };
                            if (!C8399c.ecX.equals(templateInfoActivity.ekf)) {
                                C8670b.m25245a(templateInfoActivity.ekf, templateInfoActivity.emQ, message2.arg1, 3, 0, "").mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) r3);
                                break;
                            } else {
                                AppPreferencesSetting.getInstance().setAppSettingInt("key_last_template_theme_type", templateInfoActivity.enc);
                                C8670b.m25245a(templateInfoActivity.ekf, templateInfoActivity.emQ, message2.arg1, templateInfoActivity.enc, 0, String.valueOf(C8451b.THEME.code)).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) r3);
                                break;
                            }
                        } else {
                            C8670b.m25247d(templateInfoActivity.ekf, templateInfoActivity.emQ, message2.arg1, 0).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateResponseRoll>>() {
                                /* renamed from: a */
                                public void mo9883a(C1495b bVar) {
                                }

                                public void onError(Throwable th) {
                                    th.printStackTrace();
                                    C8789a.this.sendEmptyMessage(12292);
                                    try {
                                        if (th instanceof C9740h) {
                                            if (((C9740h) th).baz().baJ() != null) {
                                                UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), templateInfoActivity.ekf, ((JsonObject) new Gson().fromJson(((C9740h) th).baz().baJ().charStream(), JsonObject.class)).get(IronSourceConstants.EVENTS_ERROR_CODE).getAsInt(), -1, ParametersKeys.FAILED, "tz");
                                            } else {
                                                return;
                                            }
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    C8789a.this.sendMessage(C8789a.this.obtainMessage(16385, Integer.valueOf(65536)));
                                }

                                public void onSuccess(List<TemplateResponseRoll> list) {
                                    C8739i.m25524ho(VivaBaseApplication.m8749FZ());
                                    C8789a.this.sendEmptyMessage(12291);
                                    if (list.size() == 0) {
                                        UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), templateInfoActivity.ekf, -1, -1, "success", "tz");
                                    }
                                    C8789a.this.sendMessage(C8789a.this.obtainMessage(16385, Integer.valueOf(131072)));
                                }
                            });
                            break;
                        }
                    case 12291:
                        C8739i.m25524ho(templateInfoActivity);
                        if (1 == templateInfoActivity.emW) {
                            String format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
                            AppPreferencesSetting instance2 = AppPreferencesSetting.getInstance();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("key_last_template_info_refresh_time_");
                            sb2.append(templateInfoActivity.ekf);
                            instance2.setAppSettingStr(sb2.toString(), format);
                        }
                        sendEmptyMessage(4099);
                        break;
                    case 12292:
                        if (templateInfoActivity.ena != null) {
                            templateInfoActivity.ena.setStatus(0);
                            break;
                        }
                        break;
                    case 16385:
                        if (templateInfoActivity.dqs != null) {
                            templateInfoActivity.dqs.setVisibility(8);
                            break;
                        }
                        break;
                    case 24577:
                        if (message2.obj instanceof TemplateInfo) {
                            templateInfoActivity.m25729s((TemplateInfo) message2.obj);
                            break;
                        }
                        break;
                    case 28673:
                        sendEmptyMessage(36881);
                        if (templateInfoActivity.dCq != null) {
                            templateInfoActivity.dCq.setEnabled(true);
                        }
                        if (!(templateInfoActivity.enk == null || templateInfoActivity.dqs == null)) {
                            if (templateInfoActivity.enk.getCount() >= 1 || templateInfoActivity.dqs.getVisibility() != 8) {
                                templateInfoActivity.dqs.setVisibility(8);
                            } else {
                                templateInfoActivity.dqs.setVisibility(0);
                            }
                        }
                        String format2 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
                        AppPreferencesSetting instance3 = AppPreferencesSetting.getInstance();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("key_last_template_info_refresh_time_");
                        sb3.append(templateInfoActivity.ekf);
                        instance3.setAppSettingStr(sb3.toString(), format2);
                        break;
                    case 28675:
                        if (!(templateInfoActivity.enk == null || templateInfoActivity.mEmptyView == null || !C8645a.m25200pt(templateInfoActivity.ekf))) {
                            if (templateInfoActivity.enk.getCount() >= 1) {
                                templateInfoActivity.mEmptyView.setVisibility(8);
                                break;
                            } else {
                                templateInfoActivity.mEmptyView.setVisibility(0);
                                break;
                            }
                        }
                    case 28679:
                        if (templateInfoActivity.ena != null) {
                            templateInfoActivity.ena.setStatus(6);
                        }
                        if (templateInfoActivity.dCq != null) {
                            templateInfoActivity.dCq.setRefreshing(false);
                        }
                        if (templateInfoActivity.enk != null) {
                            templateInfoActivity.enk.notifyDataSetChanged();
                            break;
                        }
                        break;
                    case 36871:
                        ArrayList arrayList = (ArrayList) message2.obj;
                        if (arrayList != null && arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                int i4 = i2 + 1;
                                sendMessageDelayed(obtainMessage(24577, (TemplateInfo) it.next()), (long) (i2 * 1000));
                                i2 = i4;
                            }
                            break;
                        }
                    case 36880:
                        templateInfoActivity.m25724px((String) message2.obj);
                        break;
                    case 36881:
                        if (templateInfoActivity.enk != null) {
                            templateInfoActivity.enk.notifyDataSetChanged();
                            break;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.template.info.TemplateInfoActivity$b */
    class C8792b {
        int pos;
        String title;
        String ttid;

        public C8792b(int i, String str, String str2) {
            this.pos = i;
            this.title = str;
            this.ttid = str2;
        }
    }

    /* renamed from: Nu */
    private void m25680Nu() {
        this.bvn.setOnClickListener(this);
        this.emG.setOnClickListener(this);
        this.emC.setOnClickListener(this);
    }

    /* renamed from: Oj */
    private void m25681Oj() {
        this.f3601FO = (ListView) findViewById(R.id.template_info_listview);
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.emG = (ImageButton) findViewById(R.id.text_right);
        this.emC = (Button) findViewById(R.id.try_btn);
        this.emD = (TextView) findViewById(R.id.title);
        this.emD.setText(this.mTitle);
        this.emF = (RelativeLayout) findViewById(R.id.net_error_layout);
        this.dqs = (LinearLayout) findViewById(R.id.loading_layout);
        this.mEmptyView = findViewById(R.id.layout_empty_music_list);
        this.enh = findViewById(R.id.gif_title_bar);
        if (this.emI) {
            this.emG.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m25682T(String str, int i) {
        TemplateInfo uK = m25735uK(i);
        if (uK == null || C8399c.ecZ.equals(this.ekf)) {
            LogUtils.m14222e("TemplateInfoActivity", "TemplateInfo is null !");
            return;
        }
        C1941a f = TemplateRouter.getRouterBuilder(getApplication(), TemplateRouter.URL_TEMPLATE_PREVIEW).mo10406h(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TYPE, uK.nPreviewtype).mo10391a(TemplateRouter.EXTRA_KEY_NEED_ACTIVITY_RESULT, this.emI).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TITLE, uK.strTitle).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_INTRO, uK.strIntro).mo10399f(TemplateRouter.BUNDLE_TEMPLATE_DOWNLOAD_KEY, uK.strUrl).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_URL, str).mo10406h(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_STATE, uK.nState).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TTID, uK.ttid).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_VER, uK.strVer);
        if (this.emI) {
            f.mo10396b((Activity) this, 9098);
        } else if (C8739i.isNeedToPurchase(uK.ttid)) {
            f.mo10396b((Activity) this, (int) IapRTConstants.REQUEST_CODE_FOR_VIP);
        } else {
            this.emY = true;
            f.mo10382H(this);
        }
    }

    /* renamed from: a */
    private void m25685a(Context context, TemplateInfo templateInfo, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SocialServiceDef.EXTRAS_REQUEST_TYPE, templateInfo.ttid);
            jSONObject.put("version", templateInfo.strVer);
            jSONObject.put("lang", templateInfo.strLang);
            jSONObject.put("social_method", str);
            jSONObject.put(SocialServiceDef.TODO_ACTION, SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
            String jSONObject2 = jSONObject.toString();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SocialConstDef.TASK_MAIN_TYPE, Integer.valueOf(3));
            contentValues.put(SocialConstDef.TASK_SUB_TYPE, Integer.valueOf(0));
            contentValues.put(SocialConstDef.TASK_SUB_STATE, Integer.valueOf(0));
            contentValues.put("state", Integer.valueOf(0));
            contentValues.put(SocialConstDef.TASK_USER_DATA, jSONObject2);
            context.getContentResolver().insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TASK), contentValues);
            TaskService.doPendingTask(this, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m25686a(final EditText editText, final ImageView imageView) {
        this.enr = new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                ((InputMethodManager) TemplateInfoActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 2);
                if (i == 3) {
                    if (TemplateInfoActivity.this.dCq != null) {
                        TemplateInfoActivity.this.dCq.setRefreshing(false);
                        TemplateInfoActivity.this.dCq.setEnabled(false);
                    }
                    if (C4600l.m11739k(TemplateInfoActivity.this, false)) {
                        TemplateInfoActivity.this.emF.setVisibility(4);
                        TemplateInfoActivity.this.f3601FO.setVisibility(0);
                        TemplateInfoActivity.this.ent.aKB();
                        TemplateInfoActivity.this.enu = editText.getText().toString();
                        if (!TextUtils.isEmpty(TemplateInfoActivity.this.enu)) {
                            if (TemplateInfoActivity.this.enk != null) {
                                TemplateInfoActivity.this.enk.setDataList(TemplateInfoActivity.this.enm);
                            }
                            if (TemplateInfoActivity.this.enm != null) {
                                TemplateInfoActivity.this.enm.clear();
                            }
                            if (TemplateInfoActivity.this.emZ != null) {
                                TemplateInfoActivity.this.emZ.sendEmptyMessage(28673);
                            }
                            TemplateInfoActivity.this.ent.mo34947a(TemplateInfoActivity.this.enu, (C8651b) new C8651b() {
                                /* renamed from: a */
                                public void mo27626a(C8653d dVar) {
                                }

                                /* renamed from: aG */
                                public void mo27627aG(List<C8653d> list) {
                                    TemplateInfoActivity.this.emX = true;
                                    if (list != null) {
                                        if (TemplateInfoActivity.this.enm != null) {
                                            TemplateInfoActivity.this.enm.clear();
                                            TemplateInfoActivity.this.enm.addAll(list);
                                        }
                                        if (TemplateInfoActivity.this.emZ != null) {
                                            TemplateInfoActivity.this.emZ.sendEmptyMessage(28673);
                                            TemplateInfoActivity.this.emZ.sendEmptyMessage(28675);
                                        }
                                    }
                                }

                                /* renamed from: cm */
                                public void mo27628cm(int i, int i2) {
                                }
                            });
                        }
                        if (TemplateInfoActivity.this.dCq != null) {
                            TemplateInfoActivity.this.dCq.setOnRefreshListener(TemplateInfoActivity.this.eno);
                        }
                    } else {
                        TemplateInfoActivity.this.emF.setVisibility(0);
                        TemplateInfoActivity.this.f3601FO.setVisibility(8);
                    }
                }
                return false;
            }
        };
        this.ens = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TextUtils.isEmpty(charSequence)) {
                    imageView.setVisibility(0);
                    return;
                }
                imageView.setVisibility(8);
                TemplateInfoActivity.this.mEmptyView.setVisibility(8);
                if (TemplateInfoActivity.this.dqs != null) {
                    TemplateInfoActivity.this.dqs.setVisibility(8);
                }
                if (TemplateInfoActivity.this.enk != null) {
                    TemplateInfoActivity.this.enk.setDataList(TemplateInfoActivity.this.enl);
                    if (!(TemplateInfoActivity.this.dCq == null || TemplateInfoActivity.this.enn == null)) {
                        TemplateInfoActivity.this.emX = false;
                        TemplateInfoActivity.this.dCq.setOnRefreshListener(TemplateInfoActivity.this.enn);
                    }
                }
                if (TemplateInfoActivity.this.emZ != null) {
                    TemplateInfoActivity.this.emZ.sendEmptyMessage(36881);
                }
            }
        };
    }

    private void aKO() {
        boolean z;
        List aMe = C8733e.aMa().aMe();
        int i = (C8399c.ede.equals(this.ekf) || C8399c.edb.equals(this.ekf)) ? 1 : 2;
        this.ekj.clear();
        this.ekk.clear();
        int firstVisiblePosition = this.f3601FO.getFirstVisiblePosition();
        int lastVisiblePosition = this.f3601FO.getLastVisiblePosition();
        for (int i2 = 0; i2 <= lastVisiblePosition - firstVisiblePosition; i2++) {
            int i3 = i2 + firstVisiblePosition;
            if (m25708g(this.f3601FO.getChildAt(i2), this.f3601FO)) {
                this.ekj.add(Integer.valueOf(i3));
                z = true;
            } else {
                z = false;
            }
            if (!this.ekl.contains(Integer.valueOf(i3)) && z) {
                for (int i4 = 0; i4 < i; i4++) {
                    int i5 = (i * i3) + i4;
                    if (aMe.size() > i5 && i5 >= 0) {
                        TemplateInfo templateInfo = (TemplateInfo) aMe.get(i5);
                        if (templateInfo != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Material_");
                            sb.append(this.ekf);
                            sb.append(templateInfo.strTitle);
                            String sb2 = sb.toString();
                            if (System.currentTimeMillis() - C2575a.parseLong(AppPreferencesSetting.getInstance().getAppSettingStr(sb2, "0")) >= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS) {
                                AppPreferencesSetting.getInstance().setAppSettingStr(sb2, String.valueOf(System.currentTimeMillis()));
                                this.ekk.add(new C8792b(i3, templateInfo.strTitle, templateInfo.ttid));
                            }
                        }
                    }
                }
            }
        }
        this.ekl.clear();
        this.ekl.addAll(this.ekj);
        for (C8792b bVar : this.ekk) {
            String aLa = aLa();
            if (!TextUtils.isEmpty(aLa)) {
                UserBehaviorUtils.recordTemplateExposureRate(this, aLa, bVar.title, bVar.pos, bVar.ttid);
            }
        }
    }

    private void aKP() {
        try {
            int parseInt = C2575a.parseInt(this.ekf);
            if (parseInt == 1) {
                this.enj = "theme";
            } else if (parseInt != 9) {
                switch (parseInt) {
                    case 4:
                        this.enj = "filter";
                        return;
                    case 5:
                        this.enj = "sticker";
                        return;
                    default:
                        return;
                }
            } else {
                this.enj = "title";
            }
        } catch (Exception unused) {
            this.enj = "error";
        }
    }

    private void aKQ() {
        if (this.eng && this.ekf.equals(C8399c.ede)) {
            this.enh.setVisibility(0);
            this.enf = new C8729d(this, this.enh, new C8732a() {
                public void aLb() {
                    TemplateInfoActivity.this.aKS();
                }

                public void aLc() {
                    TemplateInfoActivity.this.aKR();
                }
            });
            this.emD.setVisibility(4);
        }
        if (C8645a.m25200pt(this.ekf)) {
            aKW();
            m25713jF(true);
        }
    }

    /* access modifiers changed from: private */
    public void aKR() {
        this.ekf = C8399c.ede;
        this.mTitle = getString(R.string.xiaoying_str_ve_sticker);
        findViewById(R.id.search_editor_layout).setVisibility(8);
        findViewById(R.id.layout_empty_music_list).setVisibility(8);
        if (this.dqs != null) {
            this.dqs.setVisibility(8);
        }
        if (this.dCq != null) {
            this.dCq.setRefreshing(false);
        }
        aKT();
    }

    /* access modifiers changed from: private */
    public void aKS() {
        this.ekf = "Giphy";
        this.mTitle = "Giphy";
        this.emG.setVisibility(0);
        this.emG.setOnClickListener(this);
        findViewById(R.id.search_editor_layout).setVisibility(0);
        if (this.f3601FO != null) {
            this.f3601FO.setVisibility(4);
            this.f3601FO.setEnabled(false);
        }
        aKW();
        m25713jF(true);
        aKV();
        if (this.dCq != null) {
            this.dCq.setRefreshing(false);
        }
    }

    private void aKT() {
        if (C8645a.m25200pt(this.ekf)) {
            m25734uJ(1001);
        } else {
            m25723pw(this.ekf);
        }
    }

    private void aKU() {
    }

    private boolean aKV() {
        int count = getCount();
        if (!C4600l.m11739k(this, true)) {
            if (count == 0) {
                this.emF.setVisibility(0);
                this.dqs.setVisibility(4);
            }
            return false;
        }
        if (!C8645a.m25200pt(this.ekf)) {
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("key_last_template_theme_type", 3);
            if (count == 0 || aKY() || (C8399c.ecX.equals(this.ekf) && appSettingInt != this.enc)) {
                this.emF.setVisibility(4);
                if (this.dqs != null) {
                    this.dqs.setVisibility(0);
                }
                this.emW = 1;
                this.emZ.sendMessage(this.emZ.obtainMessage(12289, this.emW, 0));
            } else {
                this.emW = ((count - 1) / 20) + 1;
                this.emZ.sendMessage(this.emZ.obtainMessage(4099, Boolean.valueOf(true)));
            }
        } else {
            this.emF.setVisibility(4);
            m25734uJ(TextUtils.isEmpty(this.enu) ? 1001 : 1002);
        }
        return true;
    }

    private void aKW() {
        this.enn = new OnRefreshListener() {
            public void onRefresh() {
                if (TemplateInfoActivity.this.dCq != null) {
                    TemplateInfoActivity.this.dCq.setRefreshing(false);
                }
            }
        };
        this.eno = new OnRefreshListener() {
            public void onRefresh() {
                if (TemplateInfoActivity.this.dCq != null) {
                    TemplateInfoActivity.this.dCq.setRefreshing(false);
                }
            }
        };
        this.enp = new C8651b() {
            /* renamed from: a */
            public void mo27626a(C8653d dVar) {
            }

            /* renamed from: aG */
            public void mo27627aG(List<C8653d> list) {
                if (list != null && TemplateInfoActivity.this.enl != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    sb.append("");
                    LogUtils.m14223i("gif time1", sb.toString());
                    TemplateInfoActivity.this.enl.clear();
                    TemplateInfoActivity.this.enl.addAll(list);
                    if (TemplateInfoActivity.this.emZ != null) {
                        TemplateInfoActivity.this.emZ.sendEmptyMessage(28673);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(System.currentTimeMillis());
                    sb2.append("");
                    LogUtils.m14223i("gif time2", sb2.toString());
                }
            }

            /* renamed from: cm */
            public void mo27628cm(int i, int i2) {
            }
        };
        this.enq = new C8651b() {
            /* renamed from: a */
            public void mo27626a(C8653d dVar) {
            }

            /* renamed from: aG */
            public void mo27627aG(List<C8653d> list) {
                TemplateInfoActivity.this.emX = true;
                if (list != null) {
                    if (TemplateInfoActivity.this.enm != null) {
                        TemplateInfoActivity.this.enm.clear();
                        TemplateInfoActivity.this.enm.addAll(list);
                    }
                    if (TemplateInfoActivity.this.emZ != null) {
                        TemplateInfoActivity.this.emZ.sendEmptyMessage(28673);
                        TemplateInfoActivity.this.emZ.sendEmptyMessage(28675);
                    }
                }
            }

            /* renamed from: cm */
            public void mo27628cm(int i, int i2) {
            }
        };
    }

    /* access modifiers changed from: private */
    public void aKX() {
        IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
        if (iAppService != null) {
            iAppService.setUpgradeReceiveMain(this);
        }
        if (this.emV + DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS <= System.currentTimeMillis()) {
            boolean dA = C4580b.m11646dA(VivaBaseApplication.m8749FZ());
            String Si = C4580b.m11635Si();
            String countryCode = AppStateModel.getInstance().getCountryCode();
            C3727b.m9082a(dA ? 1 : 0, DeviceInfo.getSDK(), DeviceInfo.getModule(), Si, countryCode).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<AppVersionInfo>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(AppVersionInfo appVersionInfo) {
                    Intent intent = new Intent(SocialServiceDef.ACTION_APK_VERSION_UPGRADE);
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_URL, appVersionInfo.apkUrl);
                    LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).sendBroadcast(intent);
                    ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_com_msg_download, 0);
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                    ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_com_new_version_checking_failed, 0);
                }
            });
            this.emV = System.currentTimeMillis();
        }
    }

    private boolean aKY() {
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("key_last_template_info_refresh_time_");
        sb.append(this.ekf);
        return C4580b.m11663f(instance.getAppSettingStr(sb.toString(), ""), 28800);
    }

    private void aKZ() {
        m25737uM(this.eni);
        TemplateInfo uK = m25735uK(this.eni);
        if (uK != null) {
            C8739i.m25523cC(this, uK.ttid);
            ToastUtils.show((Context) this, getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get), 1);
        }
        if (this.emR != null) {
            this.emR.notifyDataSetChanged();
        }
    }

    private String aLa() {
        return C8399c.ecX.equals(this.ekf) ? "Materials_Theme_Show" : C8399c.ecZ.equals(this.ekf) ? "Materials_Transition_Show" : C8399c.edd.equals(this.ekf) ? "Materials_FX_Show" : C8399c.ede.equals(this.ekf) ? "Materials_Sticker_Show" : C8399c.edb.equals(this.ekf) ? "Materials_Title_Show" : "";
    }

    /* renamed from: bs */
    private boolean m25696bs(long j) {
        return QTemplateIDUtils.getTemplateType(j) == 1 || !QTemplateIDUtils.isThemeSubTemplate(j);
    }

    /* renamed from: g */
    private boolean m25708g(View view, View view2) {
        boolean z = false;
        if (view == null || view2 == null) {
            return false;
        }
        int top = view.getTop();
        int bottom = view.getBottom();
        if (top >= 0 && bottom <= view2.getHeight()) {
            z = true;
        }
        return z;
    }

    /* renamed from: gc */
    public static boolean m25709gc(String str) {
        return C8399c.ede.equals(str);
    }

    private int getCount() {
        if (!C8735f.m25479qm(this.ekf)) {
            return C8735f.aMf().mo35152ql(this.ekf);
        }
        int i = 0;
        List<TemplateInfo> qk = C8735f.aMf().mo35151qk(this.ekf);
        if (qk != null) {
            for (TemplateInfo templateInfo : qk) {
                try {
                    if ((templateInfo instanceof RollInfo) && ((RollInfo) templateInfo).rollModel.isShowInMC == 1) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
        return i;
    }

    /* renamed from: jF */
    private void m25713jF(boolean z) {
        this.emS = (EditText) findViewById(R.id.edittext_search);
        this.emT = (ImageView) findViewById(R.id.btn_clear_edit);
        m25686a(this.emS, this.emT);
        if (this.emS != null && this.emT != null) {
            this.emS.setOnEditorActionListener(this.enr);
            this.emS.addTextChangedListener(this.ens);
            this.emT.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    TemplateInfoActivity.this.emS.setText("");
                    TemplateInfoActivity.this.enu = "";
                    ((InputMethodManager) TemplateInfoActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
                }
            });
        }
    }

    /* renamed from: pA */
    private String m25720pA(String str) {
        String str2 = str.equals(C8399c.ecX) ? getString(R.string.xiaoying_str_ve_theme_title_common) : str.equals(C8399c.ecY) ? getString(R.string.xiaoying_str_ve_effect_title) : str.equals(C8399c.ecZ) ? getString(R.string.xiaoying_str_ve_transition_title) : str.equals(C8399c.eda) ? getString(R.string.xiaoying_str_ve_poster_title) : str.equals(C8399c.edb) ? getString(R.string.xiaoying_str_ve_subtitle_title) : str.equals(C8399c.edc) ? getString(R.string.xiaoying_str_ve_bgm_title) : str.equals(C8399c.edd) ? getString(R.string.xiaoying_str_ve_animate_frame_title) : str.equals(C8399c.ede) ? getString(R.string.xiaoying_str_ve_sticker) : C8645a.m25200pt(str) ? "Giphy" : "";
        C7591a.m22374kd("top");
        C7591a.m22375ke(str2);
        return str2;
    }

    /* renamed from: pB */
    private void m25721pB(String str) {
        TemplateInfo pz = m25725pz(str);
        String str2 = null;
        if (C8399c.edb.equals(this.ekf) || C8399c.ede.equals(this.ekf)) {
            String str3 = m25709gc(this.ekf) ? "Template_Download_All_Sticker" : "Template_Download_All_Title";
            Context applicationContext = getApplicationContext();
            String str4 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventSuc(applicationContext, str, str3, str4, str2);
        } else if (C8399c.ecX.equals(this.ekf)) {
            String str5 = "Template_Download_Theme";
            Context applicationContext2 = getApplicationContext();
            String str6 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventSuc(applicationContext2, str, str5, str6, str2);
        } else if (C8399c.edd.equals(this.ekf)) {
            String str7 = "Template_Download_FX";
            Context applicationContext3 = getApplicationContext();
            String str8 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventSuc(applicationContext3, str, str7, str8, str2);
        } else if (C8399c.ecZ.equals(this.ekf)) {
            String str9 = "Template_Download_Transion";
            Context applicationContext4 = getApplicationContext();
            String str10 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventSuc(applicationContext4, str, str9, str10, str2);
        }
    }

    /* renamed from: pC */
    private void m25722pC(String str) {
        TemplateInfo pz = m25725pz(str);
        String str2 = null;
        if (C8399c.edb.equals(this.ekf) || C8399c.ede.equals(this.ekf)) {
            String str3 = m25709gc(this.ekf) ? "Template_Download_All_Sticker" : "Template_Download_All_Title";
            Context applicationContext = getApplicationContext();
            String str4 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventFail(applicationContext, str, str3, str4, str2);
        } else if (C8399c.ecX.equals(this.ekf)) {
            String str5 = "Template_Download_Theme";
            Context applicationContext2 = getApplicationContext();
            String str6 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventFail(applicationContext2, str, str5, str6, str2);
        } else if (C8399c.edd.equals(this.ekf)) {
            String str7 = "Template_Download_FX";
            Context applicationContext3 = getApplicationContext();
            String str8 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventFail(applicationContext3, str, str7, str8, str2);
        } else if (C8399c.ecZ.equals(this.ekf)) {
            String str9 = "Template_Download_Transion";
            Context applicationContext4 = getApplicationContext();
            String str10 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventFail(applicationContext4, str, str9, str10, str2);
        }
    }

    /* renamed from: pw */
    private void m25723pw(String str) {
        C8735f.aMf().mo35157vf(0);
        if (this.emR == null) {
            this.emR = new C8827c(this, C8734a.SCENE, str);
            this.emR.setHandler(this.emZ);
        }
        this.f3601FO.setVisibility(0);
        this.f3601FO.setEnabled(true);
        if (this.dCq == null) {
            this.dCq = (SwipeRefreshLayout) findViewById(R.id.template_refresh);
            this.dCq.setColorSchemeResources(R.color.color_ff8e00);
        }
        this.dCq.setOnRefreshListener(this.eks);
        if (this.ena != null) {
            this.f3601FO.removeFooterView(this.ena);
        }
        this.ena = new LoadingMoreFooterView(this);
        this.ena.setStatus(0);
        this.f3601FO.addFooterView(this.ena);
        if (this.enb != null) {
            this.f3601FO.removeHeaderView(this.enb);
        }
        this.enb = C8747b.m25572a(this, 34, C2575a.parseInt(this.ekf));
        if (this.enb != null) {
            this.f3601FO.addHeaderView(this.enb);
        }
        this.f3601FO.setOnItemClickListener(this);
        this.f3601FO.setOnScrollListener(this);
        this.f3601FO.setAdapter(this.emR);
        LayoutParams layoutParams = (LayoutParams) this.dCq.getLayoutParams();
        findViewById(R.id.search_editor_layout).setVisibility(8);
        layoutParams.addRule(3, R.id.layout_title);
        this.dCq.setLayoutParams(layoutParams);
        this.emR.mo35326b(this.f3601FO);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        return;
     */
    /* renamed from: px */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m25724px(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            boolean r0 = r3.emI     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x001f
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x002c }
            r0.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r1 = "template_path"
            r0.putExtra(r1, r4)     // Catch:{ all -> 0x002c }
            r4 = -1
            r3.setResult(r4, r0)     // Catch:{ all -> 0x002c }
            r3.finish()     // Catch:{ all -> 0x002c }
            goto L_0x002a
        L_0x001f:
            java.lang.String r0 = com.introvd.template.sdk.p383c.C8399c.ede     // Catch:{ all -> 0x002c }
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x002c }
            com.introvd.template.template.p407e.C8728c.m25457a(r3, r0, r1, r4)     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r3)
            return
        L_0x002c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.info.TemplateInfoActivity.m25724px(java.lang.String):void");
    }

    /* renamed from: pz */
    private TemplateInfo m25725pz(String str) {
        return C8735f.aMf().mo35144be(this.ekf, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m25729s(TemplateInfo templateInfo) {
        if (templateInfo != null) {
            if (C8762d.aMt().mo35228bE(C2575a.m7391rq(templateInfo.ttid))) {
                C8705e.m25369gZ(this).mo35081b(templateInfo.ttid, templateInfo.strVer, templateInfo.strUrl, templateInfo.nSize);
                C8735f.aMf().mo35136D(templateInfo);
            } else if (!C8735f.aMf().mo35154qo(templateInfo.ttid)) {
                mo30336iA(templateInfo.ttid);
            }
        }
    }

    /* renamed from: t */
    private void m25731t(TemplateInfo templateInfo) {
        if (templateInfo != null) {
            String str = ((RollInfo) templateInfo).rollModel.rollDownUrl;
            if (m25709gc(this.ekf)) {
                HashMap hashMap = new HashMap();
                hashMap.put("stickerid", templateInfo.ttid);
                UserBehaviorLog.onKVEvent(getApplicationContext(), "Dev_Event_App_Error_analysis", hashMap);
            }
            UserEventDurationRelaUtils.startDurationEvent(templateInfo.ttid, templateInfo.nSize, C4605o.getHost(str));
            if (C8745n.m25561qv(templateInfo.ttid)) {
                mo30336iA(templateInfo.ttid);
            } else if (!C8735f.aMf().mo35154qo(templateInfo.ttid)) {
                C8705e.m25369gZ(this).mo35084y(templateInfo.ttid, templateInfo.strVer, str);
                C8735f.aMf().mo35136D(templateInfo);
            }
        }
    }

    /* renamed from: u */
    private void m25733u(TemplateInfo templateInfo) {
        if (this.emI) {
            if (templateInfo != null) {
                long rq = C2575a.m7391rq(templateInfo.ttid);
                if (C8735f.m25479qm(this.ekf)) {
                    rq = C8745n.m25563qx(templateInfo.ttid).longValue();
                }
                String bB = C8762d.aMt().mo35225bB(rq);
                Intent intent = new Intent();
                intent.putExtra("template_path", bB);
                setResult(-1, intent);
            }
            finish();
        } else if (templateInfo != null) {
            long rq2 = C2575a.m7391rq(templateInfo.ttid);
            if (C8735f.m25479qm(this.ekf)) {
                rq2 = C8745n.m25563qx(templateInfo.ttid).longValue();
            }
            C8728c.m25457a(this, templateInfo.tcid, Long.valueOf(rq2), "");
        }
    }

    /* renamed from: uJ */
    private void m25734uJ(int i) {
        List<C8653d> list;
        if (this.dCq == null) {
            this.dCq = (SwipeRefreshLayout) findViewById(R.id.template_refresh);
            this.dCq.setColorSchemeResources(R.color.color_ff8e00);
        }
        LayoutParams layoutParams = (LayoutParams) this.dCq.getLayoutParams();
        findViewById(R.id.search_editor_layout).setVisibility(0);
        layoutParams.addRule(3, R.id.search_editor_layout);
        this.dCq.setLayoutParams(layoutParams);
        this.dCq.setEnabled(false);
        if (this.ent == null) {
            this.ent = C8655f.aKE();
        }
        switch (i) {
            case 1001:
                if (this.emS != null) {
                    this.emS.setText("");
                }
                if (this.dqs != null && (this.enl == null || this.enl.size() < 1)) {
                    this.dqs.setVisibility(0);
                }
                list = this.enl;
                this.ent.aKC();
                this.ent.mo34946a(this.enp);
                this.dCq.setOnRefreshListener(this.enn);
                break;
            case 1002:
                list = this.enm;
                this.ent.aKB();
                this.ent.mo34947a(this.enu, this.enq);
                this.dCq.setOnRefreshListener(this.eno);
                break;
            default:
                list = null;
                break;
        }
        if (this.enk == null) {
            this.enk = new C8831d(this, list, 0);
        } else if (list != null) {
            this.enk.setDataList(list);
        }
        this.f3601FO.setVisibility(0);
        this.f3601FO.setEnabled(true);
        if (this.ena != null) {
            this.f3601FO.removeFooterView(this.ena);
        }
        if (this.enb != null) {
            this.f3601FO.removeHeaderView(this.enb);
        }
        this.ena = new LoadingMoreFooterView(this);
        this.ena.setStatus(0);
        this.f3601FO.addFooterView(this.ena);
        this.f3601FO.setOnItemClickListener(this);
        this.f3601FO.setOnScrollListener(this);
        this.f3601FO.setAdapter(this.enk);
        this.enk.setHandler(this.emZ);
    }

    /* access modifiers changed from: private */
    /* renamed from: uK */
    public TemplateInfo m25735uK(int i) {
        List aMe = C8733e.aMa().aMe();
        if (i < 0 || i > aMe.size() - 1) {
            return null;
        }
        return (TemplateInfo) C8733e.aMa().aMe().get(i);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0111, code lost:
        return;
     */
    /* renamed from: uL */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m25736uL(final int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.introvd.template.sdk.model.template.TemplateInfo r0 = r3.m25735uK(r4)     // Catch:{ all -> 0x0112 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            int r1 = r0.nState     // Catch:{ all -> 0x0112 }
            r2 = 1
            switch(r1) {
                case 1: goto L_0x008a;
                case 2: goto L_0x005c;
                case 3: goto L_0x0057;
                case 4: goto L_0x0023;
                case 5: goto L_0x0110;
                case 6: goto L_0x001e;
                case 7: goto L_0x000f;
                case 8: goto L_0x0011;
                default: goto L_0x000f;
            }     // Catch:{ all -> 0x0112 }
        L_0x000f:
            goto L_0x0110
        L_0x0011:
            com.introvd.template.template.download.e r4 = com.introvd.template.template.download.C8705e.m25369gZ(r3)     // Catch:{ all -> 0x0112 }
            java.lang.String r1 = r0.ttid     // Catch:{ all -> 0x0112 }
            r4.mo35083pi(r1)     // Catch:{ all -> 0x0112 }
            r0.nState = r2     // Catch:{ all -> 0x0112 }
            goto L_0x0110
        L_0x001e:
            r3.m25739uO(r4)     // Catch:{ all -> 0x0112 }
            goto L_0x0110
        L_0x0023:
            boolean r4 = r3.isFinishing()     // Catch:{ all -> 0x0112 }
            if (r4 != 0) goto L_0x0110
            com.afollestad.materialdialogs.f$a r4 = com.introvd.template.p414ui.dialog.C8978m.m26349hs(r3)     // Catch:{ all -> 0x0112 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_com_info_title     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10293dl(r0)     // Catch:{ all -> 0x0112 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_template_msg_update_app_for_support_template     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10296do(r0)     // Catch:{ all -> 0x0112 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_com_cancel     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10303dv(r0)     // Catch:{ all -> 0x0112 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_template_state_update_app     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10299dr(r0)     // Catch:{ all -> 0x0112 }
            com.introvd.template.template.info.TemplateInfoActivity$3 r0 = new com.introvd.template.template.info.TemplateInfoActivity$3     // Catch:{ all -> 0x0112 }
            r0.<init>()     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f$a r4 = r4.mo10281a(r0)     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f r4 = r4.mo10313qu()     // Catch:{ all -> 0x0112 }
            r4.show()     // Catch:{ all -> 0x0112 }
            goto L_0x0110
        L_0x0057:
            r3.m25739uO(r4)     // Catch:{ all -> 0x0112 }
            goto L_0x0110
        L_0x005c:
            boolean r0 = r3.isFinishing()     // Catch:{ all -> 0x0112 }
            if (r0 != 0) goto L_0x0110
            com.afollestad.materialdialogs.f$a r0 = com.introvd.template.p414ui.dialog.C8978m.m26349hs(r3)     // Catch:{ all -> 0x0112 }
            int r1 = com.introvd.template.template.R.string.xiaoying_str_com_delete_ask     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f$a r0 = r0.mo10296do(r1)     // Catch:{ all -> 0x0112 }
            int r1 = com.introvd.template.template.R.string.xiaoying_str_com_no     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f$a r0 = r0.mo10303dv(r1)     // Catch:{ all -> 0x0112 }
            int r1 = com.introvd.template.template.R.string.xiaoying_str_com_yes     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f$a r0 = r0.mo10299dr(r1)     // Catch:{ all -> 0x0112 }
            com.introvd.template.template.info.TemplateInfoActivity$2 r1 = new com.introvd.template.template.info.TemplateInfoActivity$2     // Catch:{ all -> 0x0112 }
            r1.<init>(r4)     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f$a r4 = r0.mo10281a(r1)     // Catch:{ all -> 0x0112 }
            com.afollestad.materialdialogs.f r4 = r4.mo10313qu()     // Catch:{ all -> 0x0112 }
            r4.show()     // Catch:{ all -> 0x0112 }
            goto L_0x0110
        L_0x008a:
            boolean r1 = com.introvd.template.p203b.C4600l.m11739k(r3, r2)     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x0092
            monitor-exit(r3)
            return
        L_0x0092:
            java.lang.String r1 = r0.ttid     // Catch:{ all -> 0x0112 }
            boolean r1 = com.introvd.template.template.p407e.C8739i.m25526qq(r1)     // Catch:{ all -> 0x0112 }
            r2 = 3
            if (r1 == 0) goto L_0x00f0
            int r1 = r0.nState     // Catch:{ all -> 0x0112 }
            if (r1 == r2) goto L_0x00f0
            java.lang.String r1 = com.introvd.template.sdk.p383c.C8399c.ecX     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r3.ekf     // Catch:{ all -> 0x0112 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x00b9
            com.introvd.template.template.info.TemplateInfoActivity$a r0 = r3.emZ     // Catch:{ all -> 0x0112 }
            r1 = 4097(0x1001, float:5.741E-42)
            android.os.Message r0 = r0.obtainMessage(r1)     // Catch:{ all -> 0x0112 }
            r0.arg1 = r4     // Catch:{ all -> 0x0112 }
            com.introvd.template.template.info.TemplateInfoActivity$a r4 = r3.emZ     // Catch:{ all -> 0x0112 }
            r4.sendMessage(r0)     // Catch:{ all -> 0x0112 }
            goto L_0x0110
        L_0x00b9:
            java.lang.String r1 = com.introvd.template.sdk.p383c.C8399c.edb     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r3.ekf     // Catch:{ all -> 0x0112 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x00cd
            java.lang.String r1 = com.introvd.template.sdk.p383c.C8399c.ede     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r3.ekf     // Catch:{ all -> 0x0112 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x0110
        L_0x00cd:
            r3.eni = r4     // Catch:{ all -> 0x0112 }
            com.introvd.template.module.iap.business.d r1 = r3.bNG     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r0.ttid     // Catch:{ all -> 0x0112 }
            r1.templateId = r2     // Catch:{ all -> 0x0112 }
            com.introvd.template.module.iap.business.d r1 = r3.bNG     // Catch:{ all -> 0x0112 }
            r2 = 19
            boolean r2 = com.introvd.template.module.p326ad.p327a.C7589a.isAdAvailable(r3, r2)     // Catch:{ all -> 0x0112 }
            r1.mo32790iE(r2)     // Catch:{ all -> 0x0112 }
            com.introvd.template.module.iap.business.d r1 = r3.bNG     // Catch:{ all -> 0x0112 }
            com.introvd.template.template.info.TemplateInfoActivity$15 r2 = new com.introvd.template.template.info.TemplateInfoActivity$15     // Catch:{ all -> 0x0112 }
            r2.<init>(r0, r4)     // Catch:{ all -> 0x0112 }
            r1.mo32789a(r2)     // Catch:{ all -> 0x0112 }
            com.introvd.template.module.iap.business.d r4 = r3.bNG     // Catch:{ all -> 0x0112 }
            r4.show()     // Catch:{ all -> 0x0112 }
            goto L_0x0110
        L_0x00f0:
            java.lang.String r1 = r0.ttid     // Catch:{ all -> 0x0112 }
            boolean r1 = com.introvd.template.template.p407e.C8739i.m25527qr(r1)     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x0106
            int r1 = r0.nState     // Catch:{ all -> 0x0112 }
            if (r1 == r2) goto L_0x0106
            r3.eni = r4     // Catch:{ all -> 0x0112 }
            r4 = 4369(0x1111, float:6.122E-42)
            java.lang.String r0 = r0.strTitle     // Catch:{ all -> 0x0112 }
            com.introvd.template.p203b.C4586g.m11710d(r3, r4, r0)     // Catch:{ all -> 0x0112 }
            goto L_0x0110
        L_0x0106:
            boolean r4 = r3.m25737uM(r4)     // Catch:{ all -> 0x0112 }
            if (r4 == 0) goto L_0x0110
            r4 = 8
            r0.nState = r4     // Catch:{ all -> 0x0112 }
        L_0x0110:
            monitor-exit(r3)
            return
        L_0x0112:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.info.TemplateInfoActivity.m25736uL(int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: uM */
    public boolean m25737uM(int i) {
        LogUtils.m14223i("TemplateInfoActivity", "doDownload <---");
        if (!C4600l.m11739k(this, true)) {
            return false;
        }
        TemplateInfo uK = m25735uK(i);
        if (uK == null) {
            return false;
        }
        this.dcI.add(uK.ttid);
        if (this.emR != null) {
            this.emR.mo35327cT(this.dcI);
        }
        if (uK instanceof RollInfo) {
            m25731t(uK);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("type", uK.tcid);
            hashMap.put("name", uK.strTitle);
            UserBehaviorLog.onKVEvent(this, "Template_Download_New", hashMap);
            m25729s(uK);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: uN */
    public void m25738uN(int i) {
        TemplateInfo uK = m25735uK(i);
        if (uK != null) {
            String str = uK.ttid;
            if (!TextUtils.isEmpty(str)) {
                String bB = C8762d.aMt().mo35225bB(C2575a.m7391rq(str));
                if (!TextUtils.isEmpty(bB)) {
                    long templateID = C8762d.aMt().getTemplateID(bB);
                    if (templateID != -1 && m25696bs(templateID)) {
                        m25685a((Context) this, uK, SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_UNDOWN);
                        ArrayList qG = C8762d.aMt().mo35242qG(bB);
                        boolean isInChina = AppStateModel.getInstance().isInChina();
                        if (qG != null && !qG.isEmpty()) {
                            Iterator it = qG.iterator();
                            while (it.hasNext()) {
                                Long l = (Long) it.next();
                                this.bOt.mo35200a((Context) this, l.longValue(), false, isInChina);
                            }
                        }
                        this.emZ.sendEmptyMessage(4099);
                    }
                }
            }
        }
    }

    /* renamed from: uO */
    private void m25739uO(int i) {
        m25733u((TemplateInfo) C8733e.aMa().aMe().get(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m25741v(TemplateInfo templateInfo) {
        if (templateInfo != null) {
            C8622a.ekc = templateInfo;
            TemplateRouter.getRouterBuilder(getApplication(), TemplateRouter.URL_TEMPLATE_ROLL_DETAIL).mo10399f(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID, this.ekf).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TTID, templateInfo.ttid).mo10396b((Activity) this, 4368);
        }
    }

    public void arB() {
    }

    public void arC() {
    }

    /* renamed from: iA */
    public void mo30336iA(String str) {
        if (this.dcI.contains(str)) {
            if (this.emZ != null) {
                this.emZ.sendMessage(this.emZ.obtainMessage(8194, 100, 0, str));
            }
            if (this.emZ != null) {
                this.emZ.sendMessage(this.emZ.obtainMessage(8195, 0, 0, str));
                this.emZ.sendEmptyMessage(4099);
            }
            m25721pB(str);
        }
    }

    /* renamed from: iB */
    public void mo30337iB(String str) {
        if (this.dcI.contains(str)) {
            if (this.emZ != null) {
                this.emZ.sendMessage(this.emZ.obtainMessage(8194, 0, 0, str));
                this.emZ.sendEmptyMessage(4099);
            }
            if (this.emR != null) {
                this.emR.mo35324U(str, 0);
                this.emR.mo35325V(str, 1);
            }
            m25722pC(str);
            if (this.eni >= 0) {
                this.eni = -1;
            }
        }
    }

    /* renamed from: iC */
    public void mo30338iC(String str) {
        if (this.dcI.contains(str) && this.emR != null) {
            this.emR.mo35324U(str, 0);
            this.emR.mo35325V(str, 1);
            if (this.emZ != null) {
                this.emZ.sendEmptyMessage(4099);
            }
        }
    }

    /* renamed from: ix */
    public void mo30340ix(String str) {
    }

    /* renamed from: iy */
    public void mo30341iy(String str) {
    }

    /* renamed from: iz */
    public void mo30342iz(String str) {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        LogUtils.m14223i("TemplateInfoActivity", "onActivityResult");
        super.onActivityResult(i, i2, intent);
        if (i == 9098) {
            if (i2 == 1) {
                this.emZ.sendMessageDelayed(this.emZ.obtainMessage(4098, this.emU, 0, null), 500);
            }
        } else if (i == 4368) {
            if (i2 == -1) {
                m25733u(C8622a.ekc);
            }
        } else if (i == 9527) {
            if (i2 == -1 && this.emR != null && C8399c.ecX.equals(this.ekf)) {
                this.emR.notifyDataSetChanged();
            }
            C8064m.aBv().mo33115aI(this);
        } else if (i == 4369) {
            aKZ();
        }
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("load:");
        sb.append(z);
        sb.append("/");
        sb.append(str);
        LogUtils.m14222e("Unlock_theme", sb.toString());
    }

    public void onClick(View view) {
        if (view.equals(this.bvn)) {
            finish();
            overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
        } else if (view.equals(this.emC)) {
            aKV();
        } else if (view.equals(this.emG)) {
            Intent intent = new Intent(this, TemplateMgrActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID, this.ekf);
            bundle.putString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_TITLE, this.mTitle);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x006f */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            java.lang.String r0 = "las_themes_info_activity"
            com.introvd.base.utlisads.CrashAll.loadAndshow(r5, r0)
            com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs.actionTemplateInfoActivity(r5)
            java.lang.String r6 = "onCreate"
            com.introvd.template.common.LogUtilsV2.m14230i(r6)
            org.greenrobot.eventbus.c r6 = org.greenrobot.eventbus.C10021c.aZH()
            r6.mo38494ax(r5)
            com.introvd.template.module.iap.C8064m.init()
            com.introvd.template.template.info.TemplateInfoActivity$a r6 = new com.introvd.template.template.info.TemplateInfoActivity$a
            r6.<init>(r5)
            r5.emZ = r6
            android.content.Intent r6 = r5.getIntent()
            android.os.Bundle r6 = r6.getExtras()
            android.content.Intent r0 = r5.getIntent()
            java.lang.String r1 = "intent_extra_boolean_from_material"
            r2 = 0
            boolean r0 = r0.getBooleanExtra(r1, r2)
            r5.eng = r0
            java.lang.String r0 = "extra_key_template_category_id"
            java.lang.String r0 = r6.getString(r0)
            r5.ekf = r0
            java.lang.String r0 = "key_templateInfoActivity_need_activity_result"
            boolean r0 = r6.getBoolean(r0, r2)
            r5.emI = r0
            java.lang.String r0 = "key_templateInfoActivity_template_theme_type"
            r1 = 3
            int r0 = r6.getInt(r0, r1)
            r5.enc = r0
            java.lang.String r0 = "TODOCODE_PARAM_MODEL"
            android.os.Parcelable r6 = r6.getParcelable(r0)
            com.introvd.template.router.todoCode.TODOParamModel r6 = (com.introvd.template.router.todoCode.TODOParamModel) r6
            r5.csJ = r6
            com.introvd.template.template.g.b r6 = new com.introvd.template.template.g.b
            r0 = 4
            r6.<init>(r0)
            r5.bOt = r6
            java.lang.String r6 = r5.ekf
            java.lang.String r6 = r5.m25720pA(r6)
            r5.mTitle = r6
            int r6 = com.introvd.template.template.R.layout.xiaoying_template_info_list     // Catch:{ InflateException -> 0x006f }
            r5.setContentView(r6)     // Catch:{ InflateException -> 0x006f }
            goto L_0x007c
        L_0x006f:
            int r6 = com.introvd.template.template.R.layout.xiaoying_template_info_list     // Catch:{ InflateException -> 0x0075 }
            r5.setContentView(r6)     // Catch:{ InflateException -> 0x0075 }
            goto L_0x007c
        L_0x0075:
            r6 = move-exception
            com.introvd.template.crash.C5523b.logException(r6)
            r5.finish()
        L_0x007c:
            r6 = 20
            r5.emQ = r6
            java.lang.String r6 = r5.ekf
            boolean r6 = com.introvd.template.template.p404d.C8645a.m25200pt(r6)
            if (r6 != 0) goto L_0x009a
            com.introvd.template.template.info.TemplateInfoActivity$a r6 = r5.emZ
            r0 = 1202(0x4b2, float:1.684E-42)
            r3 = 800(0x320, double:3.953E-321)
            r6.sendEmptyMessageDelayed(r0, r3)
            com.introvd.template.template.e.f r6 = com.introvd.template.template.p407e.C8735f.aMf()
            java.lang.String r0 = r5.ekf
            r6.mo35147cz(r5, r0)
        L_0x009a:
            r5.m25681Oj()
            r5.m25680Nu()
            r5.aKQ()
            com.introvd.template.template.e.f r6 = com.introvd.template.template.p407e.C8735f.aMf()
            java.lang.String r0 = r5.ekf
            r1 = 1
            r6.mo35148l(r5, r0, r1)
            r5.aKT()
            r5.aKV()
            com.introvd.template.template.download.e r6 = com.introvd.template.template.download.C8705e.m25369gZ(r5)
            r6.mo35079a(r5)
            r5.mo22812FU()
            r5.aKU()
            r5.aKP()
            com.introvd.template.module.ad.f r6 = com.introvd.template.module.p326ad.C7680l.aAe()
            r0 = 19
            r6.mo32531h(r0, r5)
            com.introvd.template.module.ad.f r6 = com.introvd.template.module.p326ad.C7680l.aAe()
            r6.mo32526aj(r5, r0)
            java.lang.String r6 = r5.enj
            java.lang.String r0 = com.introvd.template.module.p326ad.p328b.C7594d.dMB
            java.lang.String[] r1 = new java.lang.String[r2]
            com.introvd.template.module.p326ad.p328b.C7593c.m22383b(r6, r0, r1)
            com.introvd.template.module.iap.business.d r6 = new com.introvd.template.module.iap.business.d
            r6.<init>(r5)
            r5.bNG = r6
            com.introvd.template.template.info.TemplateInfoActivity$a r6 = r5.emZ
            r0 = 1201(0x4b1, float:1.683E-42)
            r1 = 300(0x12c, double:1.48E-321)
            r6.sendEmptyMessageDelayed(r0, r1)
            com.videoeditor.intromaker.ThemeConfig.fillLayoutTheme(r5)
            com.introvd.base.utlisads.BannerAdmob.setupDataBannerAdmob(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.info.TemplateInfoActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C8064m.aBv().mo33116aJ(this);
        C10021c.aZH().mo38496az(this);
        C8705e.m25369gZ(this).mo35080b((C8707b) this);
        if (this.emZ != null) {
            this.emZ.removeCallbacksAndMessages(null);
            this.emZ = null;
        }
        if (this.emR != null) {
            this.emR = null;
        }
        if (this.bOt != null) {
            this.bOt.unInit();
            this.bOt = null;
        }
        QComUtils.resetInstanceMembers(this);
        C7680l.aAe().releasePosition(19, false);
        C8035c.release();
        super.onDestroy();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C8629b bVar) {
        this.dcI.add(bVar.ttid);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        App.onPause();
        LogUtils.m14223i("TemplateInfoActivity", "onPause");
        super.onPause();
        UserBehaviorLog.onPause(this);
        C8064m.aBv().mo33116aJ(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        App.onResume();
        LogUtils.m14223i("TemplateInfoActivity", "onResume");
        int count = getCount();
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("key_last_template_theme_type", 3);
        if (count > 0 && (!C8399c.ecX.equals(this.ekf) || appSettingInt == this.enc)) {
            if (this.emZ != null && !this.emY) {
                this.emZ.sendEmptyMessage(4099);
            }
            this.emY = false;
        }
        super.onResume();
        UserBehaviorLog.onResume(this);
        if (!(this.enk == null || this.emZ == null)) {
            this.emZ.sendEmptyMessage(36881);
        }
        if (!C8747b.aMk() && this.enb != null && this.f3601FO != null) {
            this.f3601FO.removeHeaderView(this.enb);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.emL) {
            aKO();
            this.emL = false;
        }
        if (!(this.emR == null && this.enk == null) && i == 0 && C4600l.m11739k(this, true)) {
            if (absListView.getLastVisiblePosition() >= absListView.getCount() - 15) {
                if (C8645a.m25200pt(this.ekf)) {
                    if (this.ena != null) {
                        this.ena.setStatus(2);
                    }
                    if (this.emX) {
                        if (this.enl != null && this.enl.size() >= 1) {
                            if (this.ent != null && !this.isLoading) {
                                this.isLoading = true;
                                if (this.dCq != null) {
                                    this.dCq.setRefreshing(false);
                                }
                                this.ent.mo34947a(this.enu, (C8651b) new C8651b() {
                                    /* renamed from: a */
                                    public void mo27626a(C8653d dVar) {
                                    }

                                    /* renamed from: aG */
                                    public void mo27627aG(List<C8653d> list) {
                                        TemplateInfoActivity.this.isLoading = false;
                                        if (list != null) {
                                            if (TemplateInfoActivity.this.enm != null) {
                                                TemplateInfoActivity.this.enm.addAll(list);
                                            }
                                            if (TemplateInfoActivity.this.emZ != null) {
                                                TemplateInfoActivity.this.emZ.sendEmptyMessage(28679);
                                            }
                                        }
                                    }

                                    /* renamed from: cm */
                                    public void mo27628cm(int i, int i2) {
                                    }
                                });
                            }
                        } else {
                            return;
                        }
                    } else if (this.enl != null && this.enl.size() >= 1) {
                        if (this.ent != null && !this.isLoading) {
                            this.isLoading = true;
                            if (this.dCq != null) {
                                this.dCq.setRefreshing(false);
                            }
                            this.ent.mo34946a((C8651b) new C8651b() {
                                /* renamed from: a */
                                public void mo27626a(C8653d dVar) {
                                }

                                /* renamed from: aG */
                                public void mo27627aG(List<C8653d> list) {
                                    TemplateInfoActivity.this.isLoading = false;
                                    if (list != null) {
                                        if (TemplateInfoActivity.this.enl != null) {
                                            TemplateInfoActivity.this.enl.addAll(list);
                                        }
                                        if (TemplateInfoActivity.this.emZ != null) {
                                            TemplateInfoActivity.this.emZ.sendEmptyMessage(28679);
                                        }
                                    }
                                }

                                /* renamed from: cm */
                                public void mo27628cm(int i, int i2) {
                                }
                            });
                        }
                    } else {
                        return;
                    }
                } else if (!this.byU && this.emW * this.emQ <= C8735f.aMf().mo35152ql(this.ekf)) {
                    this.byU = false;
                    this.emW++;
                    this.emZ.sendMessage(this.emZ.obtainMessage(12289, this.emW, 0));
                }
            }
            aKO();
        }
    }

    public void onShowVideoAd(AdPositionInfoParam adPositionInfoParam, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("available:");
        sb.append(z);
        LogUtils.m14222e("Unlock_theme", sb.toString());
    }

    /* renamed from: w */
    public void mo30344w(String str, int i) {
        if (this.dcI.contains(str) && this.emZ != null) {
            this.emZ.sendMessage(this.emZ.obtainMessage(8194, i, 0, str));
        }
    }

    public void onBackPressed() {
        ThemeConfig.finishAllActivity(this);
        super.onBackPressed();
    }
}
