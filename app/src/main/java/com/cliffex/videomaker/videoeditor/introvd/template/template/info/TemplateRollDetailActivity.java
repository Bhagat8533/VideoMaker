package com.introvd.template.template.info;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8035c.C8038a;
import com.introvd.template.module.iap.C8069n;
import com.introvd.template.module.iap.business.C7870d;
import com.introvd.template.module.iap.business.C7870d.C7873a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.p414ui.view.ProgressWheel;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.template.RollIconInfo;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.RollScriptInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.model.template.TemplateRollModel;
import com.introvd.template.template.C8622a;
import com.introvd.template.template.R;
import com.introvd.template.template.download.C8705e;
import com.introvd.template.template.download.C8705e.C8707b;
import com.introvd.template.template.info.p410a.C8852i;
import com.introvd.template.template.p402c.C8629b;
import com.introvd.template.template.p407e.C8728c;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.xyui.StoryGridView;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import org.greenrobot.eventbus.C10021c;

@C1942a(mo10417rZ = "/Template/RollDetail")
public class TemplateRollDetailActivity extends EventActivity implements OnClickListener, VideoAdsListener, VideoRewardListener, C8707b {
    private C7870d bNG;
    private int btW;
    /* access modifiers changed from: private */
    public String cHd;
    private boolean deu = true;
    /* access modifiers changed from: private */
    public String ekf;
    /* access modifiers changed from: private */
    public TextView eoA;
    private StoryGridView eoB;
    private RelativeLayout eoC;
    private TextView eoD;
    private View eoE;
    private C8852i eoF;
    /* access modifiers changed from: private */
    public ProgressWheel eoG;
    /* access modifiers changed from: private */
    public TemplateRollModel eoH;
    /* access modifiers changed from: private */
    public String eoI;
    private String eoJ = "back";
    private boolean eoK = false;
    private boolean eoL = false;
    private boolean eoM = true;
    private TextView eou;
    private ImageView eov;
    private DynamicLoadingImageView eow;
    private TextView eox;
    private TextView eoy;
    /* access modifiers changed from: private */
    public ImageButton eoz;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: com.introvd.template.template.info.TemplateRollDetailActivity$a */
    private static class C8815a extends WeakHandler<TemplateRollDetailActivity> {
        public C8815a(TemplateRollDetailActivity templateRollDetailActivity) {
            super(templateRollDetailActivity);
        }

        public void handleMessage(Message message) {
            TemplateRollDetailActivity templateRollDetailActivity = (TemplateRollDetailActivity) getOwner();
            if (templateRollDetailActivity != null) {
                switch (message.what) {
                    case 4097:
                        removeMessages(4097);
                        sendMessage(obtainMessage(4098, 0, 0));
                        templateRollDetailActivity.aLt();
                        templateRollDetailActivity.aLs();
                        break;
                    case 4098:
                        templateRollDetailActivity.updateProgress(message.arg1);
                        break;
                    case 4099:
                        sendMessage(obtainMessage(4098, 100, 0));
                        templateRollDetailActivity.eoA.setVisibility(0);
                        templateRollDetailActivity.eoG.setVisibility(8);
                        templateRollDetailActivity.eoz.setVisibility(8);
                        break;
                    case 4100:
                        templateRollDetailActivity.aLs();
                        break;
                    case 4101:
                        C8622a.ekc = C8735f.m25474X(templateRollDetailActivity, templateRollDetailActivity.ekf, templateRollDetailActivity.cHd);
                        if (C8622a.ekc != null) {
                            templateRollDetailActivity.eoH = ((RollInfo) C8622a.ekc).rollModel;
                            templateRollDetailActivity.aLr();
                        }
                        C4586g.m11695Sl();
                        break;
                    case 4102:
                        ToastUtils.show(templateRollDetailActivity.getApplicationContext(), R.string.xiaoying_str_com_load_failed, 0);
                        C4586g.m11695Sl();
                        break;
                }
            }
        }
    }

    /* renamed from: Nu */
    private void m25864Nu() {
        this.eov.setOnClickListener(this);
        this.eoz.setOnClickListener(this);
        this.eoA.setOnClickListener(this);
    }

    private void aLq() {
        this.mHandler = new C8815a(this);
        this.eou = (TextView) findViewById(R.id.template_pack_name);
        this.eov = (ImageView) findViewById(R.id.img_back);
        this.eow = (DynamicLoadingImageView) findViewById(R.id.template_pack_bg);
        this.eox = (TextView) findViewById(R.id.template_pack_txt_title);
        this.eoy = (TextView) findViewById(R.id.template_pack_txt_content);
        this.eoz = (ImageButton) findViewById(R.id.template_pack_download_btn);
        this.eoA = (TextView) findViewById(R.id.template_pack_apply_btn);
        this.eoB = (StoryGridView) findViewById(R.id.template_pack_detail_view);
        this.eoG = (ProgressWheel) findViewById(R.id.template_pack_download_progress);
        this.eoC = (RelativeLayout) findViewById(R.id.template_iap_button_layout);
        this.eoE = findViewById(R.id.template_iap_icon);
        this.eoD = (TextView) findViewById(R.id.template_iap_present_price);
        this.eoC.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void aLr() {
        if (this.eoH != null) {
            RollScriptInfo rollScriptInfo = this.eoH.mRollScriptInfo;
            this.eou.setText(rollScriptInfo.rollTitle);
            this.eox.setText(rollScriptInfo.rollTitle);
            this.eoy.setText(rollScriptInfo.rollDetailIntro);
            this.eou.setVisibility(0);
            this.eox.setVisibility(0);
            this.eoy.setVisibility(0);
            this.eoz.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.eow.getLayoutParams();
            layoutParams.height = (this.btW * 2) / 5;
            this.eow.setLayoutParams(layoutParams);
            RollIconInfo rollIconInfo = this.eoH.mRollIconInfo;
            ImageLoader.loadImage(rollIconInfo.mBigIconUrl, this.eow);
            this.eoF = new C8852i(this, rollIconInfo.mXytList);
            this.eoB.setIsFullView(true);
            this.eoB.setAdapter(this.eoF);
            aLs();
        }
    }

    /* access modifiers changed from: private */
    public void aLs() {
        if (C8622a.ekc != null) {
            if (C8745n.m25561qv(C8622a.ekc.ttid)) {
                this.eoC.setVisibility(8);
                this.eoz.setVisibility(8);
                this.eoA.setVisibility(0);
                this.eoG.setVisibility(8);
            } else if (C8735f.aMf().mo35155qp(C8622a.ekc.ttid) != null) {
                this.eoC.setVisibility(8);
                this.eoz.setVisibility(8);
                this.eoA.setVisibility(8);
                this.eoG.setVisibility(0);
                updateProgress(10);
            } else {
                this.eoz.setVisibility(0);
                this.eoG.setVisibility(0);
                this.eoA.setVisibility(8);
                if (C8739i.m25527qr(this.eoI)) {
                    this.eoz.setImageResource(R.drawable.vivavideo_rate_lock1);
                    this.eoG.setVisibility(8);
                    return;
                } else if (C8739i.m25526qq(this.eoI)) {
                    this.eoC.setVisibility(0);
                    C8069n.m23424a(this.eoD, this.eoz);
                }
            }
            this.eoC.setVisibility(8);
            C8038a aVar = new C8038a();
            aVar.mo33056rY(37).mo33054cY(this.eoC).mo33053a(this.eoz).mo33055cZ(this.eoE).mo33062se(R.drawable.v5_xiaoying_template_encourage_btn).mo33058sa(getResources().getColor(R.color.color_f0f0f0)).mo33057rZ(R.drawable.v5_xiaoying_iap_template_purchase_diable_bg);
            C8035c.m23245a(this, this.eoI, this.eoD, aVar);
        }
    }

    /* access modifiers changed from: private */
    public void aLt() {
        if (!(C8622a.ekc == null || !C4600l.m11739k(this, true) || C8622a.ekc == null)) {
            String str = ((RollInfo) C8622a.ekc).rollModel.rollDownUrl;
            String host = Uri.parse(str).getHost();
            C8705e.m25369gZ(this).mo35084y(C8622a.ekc.ttid, C8622a.ekc.strVer, str);
            C8735f.aMf().mo35136D(C8622a.ekc);
            C10021c.aZH().mo38492aA(new C8629b(C8622a.ekc.ttid));
            UserEventDurationRelaUtils.startDurationEvent(C8622a.ekc.ttid, C8622a.ekc.nSize, host);
        }
    }

    private void adJ() {
        if (C8622a.ekc != null) {
            try {
                this.eoH = ((RollInfo) C8622a.ekc).rollModel;
            } catch (ClassCastException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("cast RollInfo error;rolldetailerror mTemplateInfo:");
                sb.append(C8622a.ekc);
                C5523b.logException(new C5526d(sb.toString()));
            }
        }
        this.btW = Constants.getScreenSize().width;
    }

    private void initUI() {
        aLq();
        adJ();
        aLr();
        m25864Nu();
    }

    /* renamed from: pE */
    private String m25877pE(String str) {
        String str2 = "unknown";
        try {
            int parseInt = C2575a.parseInt(str);
            return parseInt != 5 ? parseInt != 9 ? str2 : "title" : "sticker";
        } catch (Exception unused) {
            return "error";
        }
    }

    /* renamed from: pF */
    private String m25878pF(String str) {
        String str2 = "unknown";
        try {
            int parseInt = C2575a.parseInt(str);
            return parseInt != 5 ? parseInt != 9 ? str2 : "title_detail" : "sticker_detail";
        } catch (Exception unused) {
            return "error";
        }
    }

    /* access modifiers changed from: private */
    public void updateProgress(int i) {
        this.eoG.setProgress(i);
        this.eoG.setText("");
    }

    public void arB() {
    }

    public void arC() {
    }

    public void finish() {
        if (this.deu) {
            String pE = m25877pE(this.ekf);
            UserBehaviorUtils.recordIAPTemplatePreview(this, this.eoJ, this.eoI, pE);
            if ("buy".equals(this.eoJ)) {
                UserBehaviorUtils.recordIAPTemplateClick(this, m25878pF(this.ekf), this.eoI, pE);
            }
        }
        super.finish();
    }

    /* renamed from: iA */
    public void mo30336iA(String str) {
        if (this.mHandler != null && this.eoI.equals(str)) {
            C8745n.updateRollTemplateMapInfo(this);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4098, 100, 0, str));
        }
        if (this.mHandler != null && this.eoI.equals(str)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4099, 0, 0, str));
            this.mHandler.sendEmptyMessage(4099);
        }
        String str2 = TemplateInfoActivity.m25709gc(this.ekf) ? "Template_Download_All_Sticker" : "Template_Download_All_Title";
        TemplateInfo qp = C8735f.aMf().mo35155qp(str);
        UserEventDurationRelaUtils.finishDuraEventSuc(getApplicationContext(), str, str2, "detail", qp == null ? null : qp.strTitle);
    }

    /* renamed from: iB */
    public void mo30337iB(String str) {
        if (this.mHandler != null && this.eoI.equals(str)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4100, 0, 0, str));
        }
        String str2 = TemplateInfoActivity.m25709gc(this.ekf) ? "Template_Download_All_Sticker" : "Template_Download_All_Title";
        TemplateInfo qp = C8735f.aMf().mo35155qp(str);
        UserEventDurationRelaUtils.finishDuraEventFail(getApplicationContext(), str, str2, "detail", qp == null ? null : qp.strTitle);
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
            C8739i.m25523cC(this, this.eoI);
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
        if (view.equals(this.eov)) {
            finish();
        } else if (view.equals(this.eoz)) {
            if (this.eoH != null) {
                if (!C4600l.m11739k(this, true)) {
                    ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
                } else if (C8739i.m25527qr(this.eoI)) {
                    C4586g.m11710d(this, TemplateRouter.RATE_UNLOCK_REQUEST_CODE, this.eoH.mRollScriptInfo.rollTitle);
                } else {
                    this.mHandler.sendEmptyMessage(4097);
                }
            }
        } else if (view.equals(this.eoA)) {
            if (this.eoK) {
                Long valueOf = Long.valueOf(0);
                if (C8622a.ekc != null) {
                    C8745n.updateRollTemplateMapInfo(this);
                    valueOf = C8745n.m25563qx(C8622a.ekc.ttid);
                }
                C8728c.m25457a(this, this.ekf, valueOf, "");
                finish();
            } else {
                setResult(-1);
                finish();
            }
        } else if (view.equals(this.eoC) && C4600l.m11739k(this, true)) {
            this.bNG.templateId = this.eoI;
            this.bNG.mo32790iE(C7589a.isAdAvailable(this, 19));
            this.bNG.mo32789a((C7873a) new C7873a() {
                /* renamed from: cl */
                public void mo24962cl(boolean z) {
                    if (z) {
                        C7589a.m22358a(TemplateRollDetailActivity.this, 19, TemplateRollDetailActivity.this);
                        return;
                    }
                    TemplateRollDetailActivity.this.aLt();
                    C8739i.m25523cC(TemplateRollDetailActivity.this, TemplateRollDetailActivity.this.eoI);
                    ToastUtils.show((Context) TemplateRollDetailActivity.this, TemplateRollDetailActivity.this.getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get), 1);
                    TemplateRollDetailActivity.this.aLs();
                }
            });
            this.bNG.show();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        this.ekf = extras.getString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID);
        this.eoI = extras.getString(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TTID);
        this.eoK = getIntent().getBooleanExtra(TemplateRouter.BUNDLE_SELF_APPLY_KEY, false);
        this.cHd = extras.getString(TemplateRouter.KEY_TEMPLATE_ROLL_CODE);
        if (TextUtils.isEmpty(this.eoI)) {
            if (!TextUtils.isEmpty(this.cHd)) {
                this.eoI = this.cHd;
            } else if (C8622a.ekc != null) {
                this.eoI = C8622a.ekc.ttid;
            }
        }
        setContentView(R.layout.v4_xiaoying_template_roll_detail_layout);
        C8705e.m25369gZ(this).mo35079a((C8707b) this);
        C7680l.aAe().mo32531h(19, this);
        C7680l.aAe().mo32526aj(this, 19);
        C7593c.m22383b(m25877pE(this.ekf), C7594d.dMB, new String[0]);
        this.bNG = new C7870d(this);
        initUI();
        if (!TextUtils.isEmpty(this.cHd)) {
            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ROLL_DETAIL, (C8354a) new C8354a() {
                /* renamed from: a */
                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                    C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ROLL_DETAIL);
                    if (TemplateRollDetailActivity.this.mHandler == null) {
                        TemplateRollDetailActivity.this.finish();
                    } else if (i == 131072) {
                        C8739i.m25524ho(context);
                        TemplateRollDetailActivity.this.mHandler.sendEmptyMessage(4101);
                    } else {
                        TemplateRollDetailActivity.this.mHandler.sendEmptyMessage(4102);
                        Context context2 = context;
                        UserBehaviorUtilsV5.onEventTemplateListServerResult(context2, TemplateRollDetailActivity.this.ekf, bundle.getInt("errCode"), -1, ParametersKeys.FAILED, "tza");
                    }
                }
            });
            C8346e.aKd().mo33599S(getApplicationContext(), this.ekf, this.cHd);
            C4586g.m11704a((Context) this, R.string.xiaoying_str_com_loading, (OnCancelListener) null, true);
        }
        if (!TextUtils.isEmpty(this.ekf)) {
            this.deu = C8035c.isNeedToPurchase(this.eoI);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C8705e.m25369gZ(this).mo35080b((C8707b) this);
        C8035c.release();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.eoL = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.eoL) {
            aLs();
            this.eoL = false;
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
        if (this.mHandler != null && this.eoI.equals(str)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4098, i, 0, str));
        }
    }
}
