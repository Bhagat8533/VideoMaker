package com.introvd.template.template.info.filter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.p024v7.widget.C1174u;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.introvd.template.EventActivity;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8064m;
import com.introvd.template.module.iap.business.C7870d;
import com.introvd.template.module.iap.business.C7870d.C7873a;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.C4605o;
import com.introvd.template.p414ui.view.ProgressWheel;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.template.C8622a;
import com.introvd.template.template.R;
import com.introvd.template.template.data.C8670b;
import com.introvd.template.template.data.api.model.TemplateResponseRoll;
import com.introvd.template.template.download.C8705e;
import com.introvd.template.template.download.C8705e.C8707b;
import com.introvd.template.template.p401b.C8626a;
import com.introvd.template.template.p401b.C8627b;
import com.introvd.template.template.p404d.C8645a;
import com.introvd.template.template.p407e.C8728c;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8762d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import p469f.C9740h;

@C1942a(mo10417rZ = "/Template/Filter")
public class FilterActivity extends EventActivity implements OnClickListener, VideoAdsListener, VideoRewardListener, C8707b {
    private C7870d bNG;
    /* access modifiers changed from: private */
    public TemplateInfo bNP;
    /* access modifiers changed from: private */
    public boolean byU = false;
    private OnRefreshListener dgr = null;
    /* access modifiers changed from: private */
    public String ekf;
    private boolean emI = false;
    /* access modifiers changed from: private */
    public boolean emL = true;
    /* access modifiers changed from: private */
    public int emQ = 20;
    /* access modifiers changed from: private */
    public int emW = 0;
    private int enc = 3;
    /* access modifiers changed from: private */
    public boolean ene = false;
    private List<TemplateInfo> eqA;
    private TextView eqB;
    private ImageView eqC;
    private ImageButton eqD;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout eqE;
    /* access modifiers changed from: private */
    public RecyclerView eqF;
    private RelativeLayout eqG;
    private Button eqH;
    private RelativeLayout eqI;
    /* access modifiers changed from: private */
    public LinearLayout eqJ;
    /* access modifiers changed from: private */
    public C8870a eqK;
    /* access modifiers changed from: private */
    public C8876a eqL;
    /* access modifiers changed from: private */
    public LinearLayoutManager eqM;
    /* access modifiers changed from: private */
    public C8627b eqN = new C8627b();
    private String eqO;
    /* access modifiers changed from: private */
    public boolean eqy = false;
    /* access modifiers changed from: private */
    public List<TemplateInfo> eqz;

    /* renamed from: com.introvd.template.template.info.filter.FilterActivity$a */
    private static class C8870a extends WeakHandler<FilterActivity> {
        private long enz = 0;

        public C8870a(FilterActivity filterActivity) {
            super(filterActivity);
        }

        /* access modifiers changed from: protected */
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public void handleMessage(Message message) {
            if (getOwner() != null) {
                final FilterActivity filterActivity = (FilterActivity) getOwner();
                C8876a a = filterActivity.eqL;
                boolean z = true;
                switch (message.what) {
                    case 4099:
                        removeMessages(4099);
                        if (filterActivity.eqJ != null) {
                            filterActivity.eqJ.setVisibility(8);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.enz >= 1000) {
                            this.enz = currentTimeMillis;
                            C8735f.aMf().mo35147cz(filterActivity, filterActivity.ekf);
                            int ql = C8735f.aMf().mo35152ql(filterActivity.ekf);
                            if (ql > 0) {
                                if (filterActivity.emW * filterActivity.emQ <= ql) {
                                    z = false;
                                }
                                filterActivity.byU = z;
                            }
                            if (a != null) {
                                filterActivity.aLE();
                                filterActivity.eqE.setRefreshing(false);
                                a.mo35409a(filterActivity.eqz, filterActivity.ene, filterActivity.eqy);
                                filterActivity.ene = false;
                            }
                            if (filterActivity.eqE != null) {
                                filterActivity.eqE.setRefreshing(false);
                                break;
                            }
                        } else {
                            sendEmptyMessageDelayed(4099, 1000);
                            return;
                        }
                        break;
                    case 4100:
                        filterActivity.m26036dP(message.arg1, message.arg2);
                        break;
                    case 8194:
                        String str = (String) message.obj;
                        int i = message.arg1;
                        if (i < 10) {
                            i = 10;
                        }
                        if (!(a == null || str == null)) {
                            a.mo35411h(str, i, C8876a.erb);
                            if (i >= 0 && i < 100) {
                                filterActivity.m26055v(str, i);
                                break;
                            } else {
                                a.mo35412pJ(str);
                                break;
                            }
                        }
                    case 8195:
                        String str2 = (String) message.obj;
                        C8735f.aMf().mo35153qn(str2);
                        if (a != null) {
                            a.mo35411h(str2, 100, C8876a.erc);
                            a.mo35412pJ(str2);
                            break;
                        }
                        break;
                    case 12289:
                        C8670b.m25247d(filterActivity.ekf, filterActivity.emQ, message.arg1, 0).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateResponseRoll>>() {
                            /* renamed from: a */
                            public void mo9883a(C1495b bVar) {
                            }

                            public void onError(Throwable th) {
                                th.printStackTrace();
                                C8870a.this.sendEmptyMessage(12292);
                                try {
                                    if (th instanceof C9740h) {
                                        if (((C9740h) th).baz().baJ() != null) {
                                            UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), filterActivity.ekf, ((JsonObject) new Gson().fromJson(((C9740h) th).baz().baJ().charStream(), JsonObject.class)).get(IronSourceConstants.EVENTS_ERROR_CODE).getAsInt(), -1, ParametersKeys.FAILED, "tz");
                                        } else {
                                            return;
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                C8870a.this.sendMessage(C8870a.this.obtainMessage(16385, Integer.valueOf(65536)));
                            }

                            public void onSuccess(List<TemplateResponseRoll> list) {
                                C8739i.m25524ho(VivaBaseApplication.m8749FZ());
                                C8870a.this.sendEmptyMessage(12291);
                                if (list.size() == 0) {
                                    UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), filterActivity.ekf, -1, -1, "success", "tz");
                                }
                                C8870a.this.sendMessage(C8870a.this.obtainMessage(16385, Integer.valueOf(131072)));
                            }
                        });
                        break;
                    case 12291:
                        if (1 == filterActivity.emW) {
                            String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                            AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append("key_last_template_info_refresh_time_");
                            sb.append(filterActivity.ekf);
                            instance.setAppSettingStr(sb.toString(), format);
                            filterActivity.aLH();
                        }
                        sendEmptyMessage(4099);
                        break;
                    case 16385:
                        if (filterActivity.eqJ != null) {
                            filterActivity.eqJ.setVisibility(8);
                            break;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: A */
    private void m26023A(TemplateInfo templateInfo) {
        Long valueOf = Long.valueOf(0);
        if (templateInfo != null) {
            valueOf = C8745n.m25563qx(templateInfo.ttid);
        }
        if (this.emI) {
            if (valueOf.longValue() > 0) {
                String bB = C8762d.aMt().mo35225bB(valueOf.longValue());
                Intent intent = new Intent();
                intent.putExtra("template_path", bB);
                setResult(-1, intent);
            }
            finish();
            return;
        }
        C8728c.m25457a(this, C8399c.ecY, valueOf, "");
    }

    /* renamed from: Oj */
    private void m26024Oj() {
        this.eqB = (TextView) findViewById(R.id.title);
        this.eqC = (ImageView) findViewById(R.id.img_back);
        this.eqD = (ImageButton) findViewById(R.id.right_mgr);
        this.eqE = (SwipeRefreshLayout) findViewById(R.id.template_refresh);
        this.eqF = (RecyclerView) findViewById(R.id.content_recyclerview);
        this.eqF.mo7737a((C1022l) new C1022l() {
            /* renamed from: d */
            public void mo8096d(RecyclerView recyclerView, int i) {
                if (FilterActivity.this.emL) {
                    for (C8626a aVar : FilterActivity.this.eqN.mo34930a(FilterActivity.this.getApplicationContext(), C8735f.aMf().mo35151qk(FilterActivity.this.ekf), FilterActivity.this.eqF, FilterActivity.this.eqM)) {
                        UserBehaviorUtils.recordTemplateExposureRate(FilterActivity.this.getApplicationContext(), "Materials_Filter_Show", aVar.title, aVar.pos, aVar.ttid);
                    }
                    FilterActivity.this.emL = false;
                }
                if (i == 0) {
                    for (C8626a aVar2 : FilterActivity.this.eqN.mo34930a(FilterActivity.this.getApplicationContext(), C8735f.aMf().mo35151qk(FilterActivity.this.ekf), FilterActivity.this.eqF, FilterActivity.this.eqM)) {
                        UserBehaviorUtils.recordTemplateExposureRate(FilterActivity.this.getApplicationContext(), "Materials_Filter_Show", aVar2.title, aVar2.pos, aVar2.ttid);
                    }
                }
            }
        });
        this.eqG = (RelativeLayout) findViewById(R.id.pager_layout_error);
        this.eqH = (Button) findViewById(R.id.try_btn);
        this.eqI = (RelativeLayout) findViewById(R.id.pager_layout_empty);
        this.eqJ = (LinearLayout) findViewById(R.id.loading_layout);
        this.eqB.setText(getString(R.string.xiaoying_str_ve_effect_title));
        this.eqC.setOnClickListener(this);
        this.eqD.setOnClickListener(this);
    }

    private void aFP() {
        this.eqM = new LinearLayoutManager(this);
        this.eqF.setLayoutManager(this.eqM);
        this.eqM.setOrientation(1);
        this.eqF.setItemAnimator(new C1174u());
        this.eqL = new C8876a(this, this.eqK);
        this.eqF.setAdapter(this.eqL);
        aLE();
        this.eqL.mo35409a(this.eqz, false, false);
    }

    private void aKL() {
    }

    private void aKM() {
        if (this.eqL == null || !this.eqL.aLv()) {
            finish();
            overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
            return;
        }
        this.eqy = false;
        this.eqD.setVisibility(0);
        this.eqI.setVisibility(8);
        this.eqL.mo35409a(this.eqz, this.ene, false);
        this.eqB.setText(R.string.xiaoying_str_ve_effect_title);
        aKV();
    }

    private boolean aKV() {
        if (!C4600l.m11739k(this, true)) {
            if (C8735f.aMf().mo35152ql(this.ekf) == 0) {
                this.eqG.setVisibility(0);
                this.eqJ.setVisibility(4);
            } else {
                this.eqK.sendEmptyMessage(4099);
            }
            return false;
        }
        if (!C8645a.m25200pt(this.ekf)) {
            int ql = C8735f.aMf().mo35152ql(this.ekf);
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("key_last_template_theme_type", 3);
            if (ql == 0 || aKY() || (C8399c.ecX.equals(this.ekf) && appSettingInt != this.enc)) {
                this.eqG.setVisibility(4);
                if (this.eqJ != null) {
                    this.eqJ.setVisibility(0);
                }
                this.emW = 1;
                this.eqK.sendMessage(this.eqK.obtainMessage(12289, this.emW, 0));
            } else {
                this.emW = ((ql - 1) / 20) + 1;
                this.eqK.sendEmptyMessage(4099);
            }
        } else {
            this.eqG.setVisibility(4);
        }
        return true;
    }

    private boolean aKY() {
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("key_last_template_info_refresh_time_");
        sb.append(this.ekf);
        return C4580b.m11663f(instance.getAppSettingStr(sb.toString(), ""), 28800);
    }

    /* access modifiers changed from: private */
    public void aLE() {
        List<TemplateInfo> qk = C8735f.aMf().mo35151qk(this.ekf);
        if (qk != null && qk.size() > 0) {
            if (this.eqz == null) {
                this.eqz = new ArrayList();
            } else {
                this.eqz.clear();
            }
            for (TemplateInfo templateInfo : qk) {
                if (templateInfo instanceof RollInfo) {
                    RollInfo rollInfo = (RollInfo) templateInfo;
                    if (rollInfo.rollModel != null) {
                        if (rollInfo.rollModel.isShowInMC > 0) {
                        }
                    }
                }
                if (TextUtils.isEmpty(this.eqO) || this.eqO.equals(templateInfo.strSubType)) {
                    this.eqz.add(templateInfo);
                }
            }
        }
    }

    private void aLF() {
        this.eqE.setColorSchemeResources(R.color.color_ff8e00);
        this.dgr = new OnRefreshListener() {
            public void onRefresh() {
                if (!C4600l.m11739k(FilterActivity.this, true)) {
                    return;
                }
                if (FilterActivity.this.eqy) {
                    FilterActivity.this.eqE.setRefreshing(false);
                } else {
                    FilterActivity.this.eqK.sendMessage(FilterActivity.this.eqK.obtainMessage(12289, FilterActivity.this.emW, 0));
                }
            }
        };
        this.eqE.setOnRefreshListener(this.dgr);
    }

    private ArrayList<TemplateInfo> aLG() {
        ArrayList<TemplateInfo> arrayList = new ArrayList<>();
        if (this.eqz != null) {
            for (TemplateInfo templateInfo : this.eqz) {
                if (C8745n.m25561qv(templateInfo.ttid)) {
                    arrayList.add(templateInfo);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void aLH() {
        if (this.eqE != null) {
            AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("key_last_template_info_refresh_time_");
            sb.append(this.ekf);
            instance.getAppSettingStr(sb.toString(), "");
        }
    }

    /* renamed from: cY */
    private void m26034cY(List list) {
        if (list == null || list.size() <= 0) {
            this.eqI.setVisibility(0);
        } else {
            this.eqI.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dP */
    public void m26036dP(int i, int i2) {
        final TemplateInfo uK = m26052uK(i);
        if (i2 != 4112) {
            switch (i2) {
                case 4101:
                    if (uK != null && !this.eqy) {
                        C8622a.ctW = (RollInfo) uK;
                        TemplateRouter.getRouterBuilder(getApplication(), TemplateRouter.URL_FILTER_DETAIL).mo10396b((Activity) this, 1000);
                        break;
                    } else {
                        return;
                    }
                    break;
                case 4102:
                    if (uK != null) {
                        if (!C8739i.m25527qr(uK.ttid)) {
                            m26050s(uK);
                            break;
                        } else {
                            this.bNP = uK;
                            C4586g.m11710d(this, TemplateRouter.RATE_UNLOCK_REQUEST_CODE, uK.strTitle);
                            break;
                        }
                    }
                    break;
                case 4103:
                    m26054uW(i);
                    break;
                case 4104:
                    Log.i("FilterActivity", "onItemButtonClick: MSG_ITEM_BTN_DOWNLOAD  进度条按钮被点击 progress 按钮被点击");
                    break;
                case 4105:
                    m26053uV(i);
                    break;
            }
        } else if (C4600l.m11739k(this, true)) {
            this.bNP = uK;
            if (uK != null) {
                this.bNG.mo32790iE(C7589a.isAdAvailable(this, 19));
                this.bNG.templateId = uK.ttid;
                this.bNG.dPp = C8399c.ecY;
                this.bNG.mo32789a((C7873a) new C7873a() {
                    /* renamed from: cl */
                    public void mo24962cl(boolean z) {
                        if (z) {
                            C7589a.m22358a(FilterActivity.this, 19, FilterActivity.this);
                            return;
                        }
                        FilterActivity.this.m26050s(FilterActivity.this.bNP);
                        C8739i.m25523cC(FilterActivity.this, uK.ttid);
                        ToastUtils.show((Context) FilterActivity.this, FilterActivity.this.getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get), 1);
                    }
                });
                this.bNG.show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m26050s(TemplateInfo templateInfo) {
        if (C4600l.m11739k(this, true) && templateInfo != null && (templateInfo instanceof RollInfo)) {
            m26051t(templateInfo);
            UserEventDurationRelaUtils.startDurationEvent(templateInfo.ttid, templateInfo.nSize, C4605o.getHost(((RollInfo) templateInfo).rollModel.rollDownUrl));
        }
    }

    /* renamed from: t */
    private void m26051t(TemplateInfo templateInfo) {
        if (this.eqz != null && templateInfo != null) {
            RollInfo rollInfo = (RollInfo) templateInfo;
            C8705e.m25369gZ(this).mo35084y(rollInfo.ttid, rollInfo.strVer, rollInfo.rollModel.rollDownUrl);
            C8735f.aMf().mo35136D(rollInfo);
            if (this.eqK != null) {
                this.eqK.sendMessage(this.eqK.obtainMessage(8194, 0, 0, rollInfo.ttid));
            }
        }
    }

    /* renamed from: uK */
    private TemplateInfo m26052uK(int i) {
        if (this.eqz == null || i < 0 || i >= this.eqz.size()) {
            return null;
        }
        return (TemplateInfo) this.eqz.get(i);
    }

    /* renamed from: uV */
    private boolean m26053uV(int i) {
        if (this.eqA != null && i >= 0 && i < this.eqA.size()) {
            TemplateInfo templateInfo = (TemplateInfo) this.eqA.remove(i);
            if (templateInfo instanceof RollInfo) {
                C8745n.m25558cM(getApplicationContext(), templateInfo.ttid);
            }
        }
        m26034cY(this.eqA);
        this.eqL.mo35409a(this.eqA, false, this.eqy);
        return true;
    }

    /* renamed from: uW */
    private void m26054uW(int i) {
        if (this.eqz != null) {
            m26023A((TemplateInfo) this.eqz.get(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m26055v(String str, int i) {
        if (this.eqM != null) {
            int findFirstVisibleItemPosition = this.eqM.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.eqM.findLastVisibleItemPosition();
            int pP = this.eqL.mo35413pP(str);
            if (pP >= findFirstVisibleItemPosition && pP <= findLastVisibleItemPosition) {
                View childAt = this.eqF.getChildAt(pP - findFirstVisibleItemPosition);
                if (childAt != null) {
                    TextView textView = (TextView) childAt.findViewById(R.id.template_filter_apply);
                    TextView textView2 = (TextView) childAt.findViewById(R.id.template_filter_download);
                    ProgressWheel progressWheel = (ProgressWheel) childAt.findViewById(R.id.template_pack_download_progress);
                    if (progressWheel != null) {
                        progressWheel.setProgress(i);
                        progressWheel.setVisibility(0);
                        textView.setVisibility(4);
                        textView2.setVisibility(4);
                    }
                }
            }
        }
    }

    public void arB() {
    }

    public void arC() {
    }

    /* renamed from: iA */
    public void mo30336iA(String str) {
        if (this.eqK != null) {
            this.eqK.sendMessage(this.eqK.obtainMessage(8194, 100, 0, str));
        }
        if (this.eqK != null) {
            this.eqK.sendMessage(this.eqK.obtainMessage(8195, 0, 0, str));
            this.eqK.sendEmptyMessage(4099);
        }
        TemplateInfo qp = C8735f.aMf().mo35155qp(str);
        UserEventDurationRelaUtils.finishDuraEventSuc(getApplicationContext(), str, "Template_Download_All_Filter", "list", qp == null ? null : qp.strTitle);
    }

    /* renamed from: iB */
    public void mo30337iB(String str) {
        if (this.eqL != null) {
            this.eqL.mo35411h(str, 0, C8876a.erd);
            this.eqL.mo35412pJ(str);
        }
        TemplateInfo qp = C8735f.aMf().mo35155qp(str);
        UserEventDurationRelaUtils.finishDuraEventFail(getApplicationContext(), str, "Template_Download_All_Filter", "list", qp == null ? null : qp.strTitle);
    }

    /* renamed from: iC */
    public void mo30338iC(String str) {
        if (this.eqL != null) {
            this.eqL.mo35411h(str, 0, C8876a.ere);
            this.eqL.mo35412pJ(str);
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
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            if (i2 == -1 && C8622a.ctW != null) {
                m26023A(C8622a.ctW);
            }
        } else if (i == 4369) {
            m26050s(this.bNP);
            C8739i.m25523cC(this, this.bNP.ttid);
            ToastUtils.show((Context) this, getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get), 1);
        } else if (i == 9527) {
            C8064m.aBv().mo33115aI(this);
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
        int id = view.getId();
        if (id == R.id.img_back) {
            aKM();
        } else if (id == R.id.right_mgr) {
            this.eqy = true;
            String string = getString(R.string.xiaoying_str_ve_effect_title);
            String string2 = getResources().getString(R.string.xiaoying_str_template_manage_suffix, new Object[]{string});
            this.eqD.setVisibility(4);
            this.eqB.setText(string2);
            this.eqA = aLG();
            m26034cY(this.eqA);
            this.eqL.mo35409a(this.eqA, false, this.eqy);
            C8522g.aJA().aJF();
        } else {
            int i = R.id.try_btn;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        this.ekf = C8399c.ecY;
        this.emI = extras.getBoolean(TemplateRouter.EXTRA_KEY_NEED_ACTIVITY_RESULT, false);
        this.enc = extras.getInt(TemplateRouter.KEY_TEMPLATE_THEME_TYPE, 3);
        this.eqO = extras.getString(TemplateRouter.KEY_INTENT_TEMPLATE_SUB_TYPE);
        this.eqK = new C8870a(this);
        C7589a.m22363h(19, this);
        C7589a.m22360aj(this, 19);
        C7593c.m22383b("filter", C7594d.dMB, new String[0]);
        this.bNG = new C7870d(this);
        C8705e.m25369gZ(this).mo35079a((C8707b) this);
        setContentView(R.layout.v5_xiaoying_template_filter_activity);
        C8735f.aMf().mo35149m(this, this.ekf, true);
        C8735f.aMf().mo35147cz(this, this.ekf);
        aLE();
        aKL();
        m26024Oj();
        aLF();
        aFP();
        aKV();
        C8064m.init();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C8035c.release();
        C8705e.m25369gZ(this).mo35080b((C8707b) this);
        C8064m.aBv().mo33116aJ(this);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        aKM();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        C8064m.aBv().mo33116aJ(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.eqL != null) {
            this.eqL.notifyDataSetChanged();
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
        StringBuilder sb = new StringBuilder();
        sb.append("onDownLoadProgressChanged: 下载进度更新");
        sb.append(i);
        Log.i("FilterActivity", sb.toString());
        if (this.eqK != null) {
            this.eqK.sendMessage(this.eqK.obtainMessage(8194, i, 0, str));
        }
    }
}
