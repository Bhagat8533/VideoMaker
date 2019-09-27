package com.introvd.template.template.info.filter;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.banner.LoopViewPager;
import com.introvd.template.common.p236ui.banner.LoopViewPager.OnMyPageChangeListener;
import com.introvd.template.common.p236ui.banner.LoopViewPager.PagerFormatData;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8035c.C8038a;
import com.introvd.template.module.iap.C8069n;
import com.introvd.template.module.iap.business.C7870d;
import com.introvd.template.module.iap.business.C7870d.C7873a;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.C4605o;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.RollXytInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.model.template.TemplateRollModel;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.C8622a;
import com.introvd.template.template.R;
import com.introvd.template.template.download.C8705e;
import com.introvd.template.template.download.C8705e.C8707b;
import com.introvd.template.template.p407e.C8728c;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.ArrayList;
import java.util.List;

@C1942a(mo10417rZ = "/Template/FilterDetail")
public class FilterDetailActivity extends EventActivity implements OnClickListener, VideoAdsListener, VideoRewardListener, C8707b {
    /* access modifiers changed from: private */
    public TextView bCG;
    private C7870d bNG;
    /* access modifiers changed from: private */
    public String cHd;
    /* access modifiers changed from: private */
    public Button cub;
    private Button dem;
    private boolean deu = true;
    /* access modifiers changed from: private */
    public String ekf;
    private String eoJ = "back";
    private boolean eoK = false;
    private TextView eqS;
    private TextView eqT;
    /* access modifiers changed from: private */
    public ProgressBar eqU;
    /* access modifiers changed from: private */
    public Button eqV;
    private LoopViewPager eqW;
    /* access modifiers changed from: private */
    public C8875a eqX;
    private boolean eqY = false;
    private LinearLayout mDotLayout;

    /* renamed from: com.introvd.template.template.info.filter.FilterDetailActivity$a */
    private static class C8875a extends Handler {
        private FilterDetailActivity era;

        public C8875a(FilterDetailActivity filterDetailActivity) {
            this.era = filterDetailActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 4097:
                    LogUtils.m14223i("MainHandler", "handleMessage: MSG_TEMPLATE_DOWNLOAD_START");
                    removeMessages(4097);
                    sendMessage(obtainMessage(4098, 0, 0));
                    this.era.aLt();
                    this.era.aLs();
                    return;
                case 4098:
                    this.era.updateProgress(message.arg1);
                    return;
                case 4099:
                    sendMessage(obtainMessage(4098, 100, 0));
                    this.era.eqV.setVisibility(0);
                    this.era.eqU.setVisibility(8);
                    this.era.cub.setVisibility(8);
                    return;
                case 4100:
                    this.era.aLs();
                    return;
                case 4101:
                    this.era.bCG.setText(this.era.m26081uX(message.arg1 - 1));
                    return;
                case 4102:
                    C8622a.ctW = C8735f.m25474X(this.era, this.era.ekf, this.era.cHd);
                    if (C8622a.ctW != null) {
                        this.era.aLs();
                        this.era.initData();
                        this.era.aLI();
                    }
                    C4586g.m11695Sl();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: Oj */
    private void m26066Oj() {
        ImageView imageView = (ImageView) findViewById(R.id.template_datail_back);
        this.bCG = (TextView) findViewById(R.id.tv_filter_item_title);
        this.eqS = (TextView) findViewById(R.id.tv_filter_item_nums);
        this.eqT = (TextView) findViewById(R.id.tv_filter_item_intro);
        this.eqU = (ProgressBar) findViewById(R.id.progressbar_loading);
        this.cub = (Button) findViewById(R.id.btn_filter_download);
        this.mDotLayout = (LinearLayout) findViewById(R.id.template_pager_dot_layout);
        this.eqW = (LoopViewPager) findViewById(R.id.filter_detail_viewpager);
        this.eqV = (Button) findViewById(R.id.btn_filter_apply);
        this.eqV.setOnClickListener(this);
        this.dem = (Button) findViewById(R.id.template_iap_price);
        this.dem.setOnClickListener(this);
        imageView.setOnClickListener(this);
        this.cub.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void aLI() {
        List d = m26072d(C8622a.ctW);
        if (d != null) {
            this.eqW.init(d, false, true);
            this.eqW.setmOnMyPageChangeListener(new OnMyPageChangeListener() {
                public void onPageSelected(int i) {
                    if (FilterDetailActivity.this.eqX != null) {
                        FilterDetailActivity.this.eqX.sendMessage(FilterDetailActivity.this.eqX.obtainMessage(4101, i, 0));
                    }
                }
            });
            this.eqW.initIndicator(R.drawable.v5_xiaoying_materials_point_choose, R.drawable.v5_xiaoying_materials_point_unchoose, this.mDotLayout);
        }
    }

    private void aLJ() {
        Intent intent = getIntent();
        this.ekf = C8399c.ecY;
        this.cHd = intent.getStringExtra(TemplateRouter.KEY_TEMPLATE_ROLL_CODE);
    }

    /* access modifiers changed from: private */
    public void aLs() {
        this.dem.setVisibility(8);
        if (C8622a.ctW != null) {
            if (C8745n.m25561qv(C8622a.ctW.ttid)) {
                this.cub.setVisibility(8);
                this.eqV.setVisibility(0);
                this.eqU.setVisibility(8);
            } else {
                TemplateInfo qp = C8735f.aMf().mo35155qp(C8622a.ctW.ttid);
                this.cub.setVisibility(0);
                if (qp != null) {
                    this.cub.setBackgroundResource(R.color.transparent);
                    this.cub.setTextColor(getResources().getColor(R.color.white));
                    this.eqV.setVisibility(8);
                    this.eqU.setVisibility(0);
                    updateProgress(10);
                } else {
                    this.cub.setBackgroundResource(R.drawable.v5_xiaoying_template_btn_yellow_selector);
                    this.cub.setText(R.string.xiaoying_str_btn_freedownload);
                    this.cub.setTextColor(getResources().getColor(R.color.white));
                    this.eqV.setVisibility(8);
                    this.eqU.setVisibility(8);
                    if (C8739i.m25526qq(C8622a.ctW.ttid)) {
                        C8069n.m23424a(this.dem, this.cub);
                    } else if (C8739i.m25527qr(C8622a.ctW.ttid)) {
                        this.cub.setText(R.string.xiaoying_str_iap_unlock_template_list);
                        return;
                    }
                }
            }
            boolean isInChina = AppStateModel.getInstance().isInChina();
            C8038a aVar = new C8038a();
            aVar.mo33056rY(37).mo33054cY(this.dem).mo33053a(this.cub).mo33060sc(isInChina ? R.string.xiaoying_str_vip_duration_limit_confirm : R.string.xiaoying_str_vip_subscribe).mo33061sd(R.string.xiaoying_str_reward_video_ad_to_watch).mo33058sa(getResources().getColor(R.color.color_595959)).mo33057rZ(R.drawable.v5_xiaoying_iap_template_purchase_filter_detail_disable_bg);
            C8035c.m23245a(this, C8622a.ctW.ttid, this.dem, aVar);
        }
    }

    /* access modifiers changed from: private */
    public void aLt() {
        if (C4600l.m11739k(this, true) && C8622a.ctW != null) {
            String str = C8622a.ctW.rollModel.rollDownUrl;
            C8705e.m25369gZ(this).mo35084y(C8622a.ctW.ttid, C8622a.ctW.strVer, str);
            C8735f.aMf().mo35136D(C8622a.ctW);
            UserEventDurationRelaUtils.startDurationEvent(C8622a.ctW.ttid, C8622a.ctW.nSize, C4605o.getHost(str));
        }
    }

    /* renamed from: d */
    private List<PagerFormatData> m26072d(RollInfo rollInfo) {
        ArrayList arrayList = new ArrayList();
        if (rollInfo == null || rollInfo.rollModel.mRollIconInfo.mXytList == null) {
            return null;
        }
        for (int i = 0; i < rollInfo.rollModel.mRollIconInfo.mXytList.size(); i++) {
            PagerFormatData pagerFormatData = new PagerFormatData();
            pagerFormatData.imgUrl = ((RollXytInfo) rollInfo.rollModel.mRollIconInfo.mXytList.get(i)).mXytIconUrl;
            StringBuilder sb = new StringBuilder();
            sb.append("changeData: ");
            sb.append(((RollXytInfo) rollInfo.rollModel.mRollIconInfo.mXytList.get(i)).mXytIconUrl);
            LogUtils.m14223i("FilterDetailActivity", sb.toString());
            arrayList.add(pagerFormatData);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void initData() {
        if (C8622a.ctW != null) {
            TemplateRollModel templateRollModel = C8622a.ctW.rollModel;
            if (templateRollModel != null) {
                this.bCG.setText(m26081uX(0));
                this.eqT.setText(templateRollModel.mRollScriptInfo.rollDetailIntro);
                int size = templateRollModel.mRollIconInfo.mXytList != null ? templateRollModel.mRollIconInfo.mXytList.size() : 0;
                this.eqS.setText(getResources().getQuantityString(R.plurals.xiaoying_str_meterial_filter_countdesc_plurals, size, new Object[]{Integer.valueOf(size)}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: uX */
    public String m26081uX(int i) {
        String str = "";
        if (C8622a.ctW == null || C8622a.ctW.rollModel == null) {
            return str;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= C8622a.ctW.rollModel.mRollIconInfo.mXytList.size()) {
                break;
            } else if (i2 == i) {
                str = ((RollXytInfo) C8622a.ctW.rollModel.mRollIconInfo.mXytList.get(i)).mName;
                break;
            } else {
                i2++;
            }
        }
        return TextUtils.isEmpty(str) ? C8622a.ctW.rollModel.mRollScriptInfo.rollTitle : str;
    }

    /* access modifiers changed from: private */
    public void updateProgress(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateProgress:  = ");
        sb.append(i);
        LogUtils.m14223i("FilterDetailActivity", sb.toString());
        this.eqU.setProgress(i);
        Button button = this.cub;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append("%");
        button.setText(sb2.toString());
    }

    public void arB() {
        LogUtils.m14223i("FilterDetailActivity", "onDownLoadProgressChanged: onFileDownloadStart = onFileDownloadStart");
    }

    public void arC() {
    }

    public void finish() {
        if (C8622a.ctW != null && this.deu) {
            UserBehaviorUtils.recordIAPTemplatePreview(this, this.eoJ, C8622a.ctW.ttid, "filter");
            if ("buy".equals(this.eoJ)) {
                UserBehaviorUtils.recordIAPTemplateClick(this, "filter_detail", C8622a.ctW.ttid, "filter");
            }
        }
        super.finish();
    }

    /* renamed from: iA */
    public void mo30336iA(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onDownLoadSuccess: strTtid = ");
        sb.append(str);
        LogUtils.m14223i("FilterDetailActivity", sb.toString());
        if (!(this.eqX == null || C8622a.ctW == null || !str.equals(C8622a.ctW.ttid))) {
            this.eqX.sendMessage(this.eqX.obtainMessage(4098, 100, 0, str));
            this.eqX.sendMessage(this.eqX.obtainMessage(4099, 0, 0, str));
            this.eqX.sendEmptyMessage(4099);
        }
        TemplateInfo qp = C8735f.aMf().mo35155qp(str);
        UserEventDurationRelaUtils.finishDuraEventSuc(getApplicationContext(), str, "Template_Download_All_Filter", "detail", qp == null ? null : qp.strTitle);
    }

    /* renamed from: iB */
    public void mo30337iB(String str) {
        if (!(this.eqX == null || C8622a.ctW == null || !str.equals(C8622a.ctW.ttid))) {
            this.eqX.sendMessage(this.eqX.obtainMessage(4100, 0, 0, str));
        }
        TemplateInfo qp = C8735f.aMf().mo35155qp(str);
        UserEventDurationRelaUtils.finishDuraEventFail(getApplicationContext(), str, "Template_Download_All_Filter", "detail", qp == null ? null : qp.strTitle);
    }

    /* renamed from: iC */
    public void mo30338iC(String str) {
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
        if (i == 4369) {
            aLt();
            if (C8622a.ctW != null) {
                C8739i.m25523cC(this, C8622a.ctW.ttid);
            }
            ToastUtils.show((Context) this, getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get), 1);
            aLs();
        } else if (i == 9527) {
            aLs();
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
        if (view.getId() == R.id.template_datail_back) {
            finish();
        } else if (view.getId() == R.id.btn_filter_download) {
            if (C8622a.ctW == null) {
                finish();
            } else if (!C4600l.m11739k(this, true)) {
                ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
            } else if (C8739i.m25527qr(C8622a.ctW.ttid)) {
                C4586g.m11710d(this, TemplateRouter.RATE_UNLOCK_REQUEST_CODE, C8622a.ctW.strTitle);
            } else {
                this.eqX.sendEmptyMessage(4097);
            }
        } else if (view.equals(this.eqV)) {
            if (this.eoK) {
                Long valueOf = Long.valueOf(0);
                if (C8622a.ctW != null) {
                    C8745n.updateRollTemplateMapInfo(this);
                    valueOf = C8745n.m25563qx(C8622a.ctW.ttid);
                }
                C8728c.m25457a(this, C8399c.ecY, valueOf, "");
                finish();
            } else {
                setResult(-1);
                finish();
            }
        } else if (view.equals(this.dem)) {
            if (C8622a.ctW == null) {
                finish();
            } else if (C4600l.m11739k(this, true)) {
                this.bNG.templateId = C8622a.ctW.ttid;
                this.bNG.mo32790iE(C7589a.isAdAvailable(this, 19));
                this.bNG.mo32789a((C7873a) new C7873a() {
                    /* renamed from: cl */
                    public void mo24962cl(boolean z) {
                        if (z) {
                            C7589a.m22358a(FilterDetailActivity.this, 19, FilterDetailActivity.this);
                            return;
                        }
                        FilterDetailActivity.this.aLt();
                        C8739i.m25523cC(FilterDetailActivity.this, C8622a.ctW.ttid);
                        FilterDetailActivity.this.aLs();
                    }
                });
                this.bNG.show();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.v5_xiaoying_template_filter_detail_activity);
        this.eqX = new C8875a(this);
        this.eoK = getIntent().getBooleanExtra(TemplateRouter.BUNDLE_SELF_APPLY_KEY, false);
        C8705e.m25369gZ(this).mo35079a((C8707b) this);
        aLJ();
        if (C8622a.ctW != null && C8739i.m25526qq(C8622a.ctW.ttid)) {
            C7589a.m22363h(19, this);
            C7589a.m22360aj(this, 19);
            C7593c.m22383b("filter", C7594d.dMB, new String[0]);
            this.bNG = new C7870d(this);
        }
        m26066Oj();
        aLs();
        initData();
        aLI();
        if (!TextUtils.isEmpty(this.cHd) && C8622a.ctW == null) {
            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ROLL_DETAIL, (C8354a) new C8354a() {
                /* renamed from: a */
                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                    C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ROLL_DETAIL);
                    if (FilterDetailActivity.this.eqX != null) {
                        if (i == 131072) {
                            C8739i.m25524ho(context);
                        } else {
                            Context context2 = context;
                            UserBehaviorUtilsV5.onEventTemplateListServerResult(context2, FilterDetailActivity.this.ekf, bundle.getInt("errCode"), -1, ParametersKeys.FAILED, "tza");
                        }
                        FilterDetailActivity.this.eqX.sendEmptyMessage(4102);
                        return;
                    }
                    FilterDetailActivity.this.finish();
                }
            });
            C8346e.aKd().mo33599S(getApplicationContext(), this.ekf, this.cHd);
            C4586g.m11704a((Context) this, R.string.xiaoying_str_com_loading, (OnCancelListener) null, true);
        }
        if (C8622a.ctW != null) {
            this.deu = C8035c.isNeedToPurchase(C8622a.ctW.ttid);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C8705e.m25369gZ(this).mo35080b((C8707b) this);
        C8035c.release();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.eqY = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.eqY) {
            aLs();
            this.eqY = false;
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
        sb.append("onDownLoadProgressChanged:  progress = ");
        sb.append(i);
        LogUtils.m14223i("FilterDetailActivity", sb.toString());
        if (this.eqX != null && C8622a.ctW != null && str.equals(C8622a.ctW.ttid)) {
            this.eqX.sendMessage(this.eqX.obtainMessage(4098, i, 0, str));
        }
    }
}
