package com.introvd.template.editor.slideshow.funny;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.Constants;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.p278a.C6738a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.slide.FunnySlideRouter;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.data.api.C8659b;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.download.C8705e;
import com.introvd.template.template.download.C8705e.C8707b;
import com.introvd.template.template.p407e.C8742k;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.xyui.video.C9183a;
import com.introvd.template.xyui.video.VideoView;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.p131c.p132a.p135c.C2575a;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;
import p469f.C9768m;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;

@C1942a(mo10417rZ = "/Funny/TemplateDetail")
public class FunnyTemplateDetailActivity extends EventActivity implements OnClickListener, C8707b {
    private ImageView bvn;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    private TextView dgE;
    private TextView dgF;
    /* access modifiers changed from: private */
    public ImageView dgG;
    private RelativeLayout dgH;
    /* access modifiers changed from: private */
    public VideoView dgI;
    /* access modifiers changed from: private */
    public RelativeLayout dgJ;
    /* access modifiers changed from: private */
    public TextView dgK;
    /* access modifiers changed from: private */
    public RelativeLayout dgL;
    private TextView dgM;
    private ProgressBar dgN;
    /* access modifiers changed from: private */
    public String dgO;
    /* access modifiers changed from: private */
    public String dgP;
    private TemplateInfo dgQ;
    private int dgR = -1;
    private C9183a dgS = new C9183a() {
        public boolean aqu() {
            return false;
        }

        public void aqv() {
        }

        public void aqw() {
        }

        public void aqx() {
        }

        /* renamed from: oU */
        public void mo30103oU(int i) {
        }

        public void onBuffering(boolean z) {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (mediaPlayer.getCurrentPosition() == 0) {
                FunnyTemplateDetailActivity.this.dgG.setVisibility(0);
            }
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return false;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            FunnyTemplateDetailActivity.this.m19788he(false);
            FunnyTemplateDetailActivity.this.dgJ.setVisibility(0);
            if (mediaPlayer != null) {
                int videoWidth = mediaPlayer.getVideoWidth();
                int videoHeight = mediaPlayer.getVideoHeight();
                int O = C4583d.m11670O(FunnyTemplateDetailActivity.this, 10);
                int O2 = C4583d.m11670O(FunnyTemplateDetailActivity.this, 119);
                int O3 = C4583d.m11670O(FunnyTemplateDetailActivity.this, 48);
                int O4 = C4583d.m11670O(FunnyTemplateDetailActivity.this, 184);
                if (videoWidth > videoHeight) {
                    int i = Constants.getScreenSize().width;
                    LayoutParams layoutParams = new LayoutParams(i, (int) ((((float) i) / ((float) videoWidth)) * ((float) videoHeight)));
                    layoutParams.addRule(15);
                    FunnyTemplateDetailActivity.this.dgJ.setLayoutParams(layoutParams);
                } else {
                    int i2 = ((Constants.getScreenSize().height - O3) - O) - O4;
                    LayoutParams layoutParams2 = new LayoutParams((int) ((((float) i2) / ((float) videoHeight)) * ((float) videoWidth)), i2);
                    layoutParams2.setMargins(0, O, 0, O2);
                    layoutParams2.addRule(14);
                    layoutParams2.addRule(3, FunnyTemplateDetailActivity.this.dgL.getId());
                    layoutParams2.addRule(2, FunnyTemplateDetailActivity.this.dgK.getId());
                    FunnyTemplateDetailActivity.this.dgJ.setLayoutParams(layoutParams2);
                }
                FunnyTemplateDetailActivity.this.dgI.setBackgroundColor(0);
                FunnyTemplateDetailActivity.this.dgI.start();
                FunnyTemplateDetailActivity.this.dgG.setVisibility(8);
            }
        }
    };

    @SuppressLint({"CheckResult"})
    /* renamed from: Kl */
    private void m19776Kl() {
        m19791ph(mo30339iw(this.dgP));
        this.compositeDisposable.mo9785e(C1834l.m5254a((C1839n<T>) new C1839n<TemplateInfo>() {
            /* renamed from: a */
            public void mo10177a(C1838m<TemplateInfo> mVar) throws Exception {
                TemplateInfo ad = C8742k.aMi().mo35175ad(FunnyTemplateDetailActivity.this.getApplicationContext(), FunnyTemplateDetailActivity.this.dgO, FunnyTemplateDetailActivity.this.dgP);
                if (ad != null) {
                    mVar.mo9791K(ad);
                    return;
                }
                FunnyTemplateDetailActivity.this.arx();
                mVar.onComplete();
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<TemplateInfo>() {
            /* renamed from: q */
            public void accept(TemplateInfo templateInfo) throws Exception {
                FunnyTemplateDetailActivity.this.m19790p(templateInfo);
            }
        }));
    }

    /* renamed from: Oj */
    private void m19777Oj() {
        this.dgE = (TextView) findViewById(R.id.title);
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.dgF = (TextView) findViewById(R.id.share);
        this.dgG = (ImageView) findViewById(R.id.video_play);
        this.dgH = (RelativeLayout) findViewById(R.id.xiaoying_com_progress_video_loading);
        this.dgI = (VideoView) findViewById(R.id.videoView);
        this.dgJ = (RelativeLayout) findViewById(R.id.player_container);
        this.dgK = (TextView) findViewById(R.id.funny_template_create_tv);
        this.dgN = (ProgressBar) findViewById(R.id.funny_template_download_progress);
        this.dgL = (RelativeLayout) findViewById(R.id.layout_title);
        this.dgM = (TextView) findViewById(R.id.funny_template_des);
        this.dgI.setVideoViewListener(this.dgS);
        this.dgI.setBackgroundColor(-16777216);
        m19788he(true);
        this.dgJ.setOnClickListener(this);
        this.dgK.setOnClickListener(this);
        this.dgJ.setVisibility(4);
        this.bvn.setOnClickListener(this);
        this.dgF.setOnClickListener(this);
        this.dgG.setOnClickListener(this);
    }

    private void arA() {
        if (this.dgQ != null) {
            C8705e.m25369gZ(this).mo35081b(this.dgP, this.dgQ.strVer, this.dgQ.strUrl, this.dgQ.nSize);
        }
    }

    /* access modifiers changed from: private */
    public void arx() {
        C8659b.m25234x(String.valueOf(QTemplateIDUtils.getTemplateType(C2575a.m7391rq(this.dgP))), this.dgP, String.valueOf(QEngine.VERSION_NUMBER)).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<C9768m<TemplateResponseInfo>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
                FunnyTemplateDetailActivity.this.compositeDisposable.mo9785e(bVar);
            }

            /* renamed from: b */
            public void onSuccess(C9768m<TemplateResponseInfo> mVar) {
                if (mVar != null) {
                    TemplateResponseInfo templateResponseInfo = (TemplateResponseInfo) mVar.baI();
                    if (templateResponseInfo != null) {
                        TemplateInfo templateInfo = new TemplateInfo();
                        templateInfo.ttid = FunnyTemplateDetailActivity.this.dgP;
                        templateInfo.nSize = C2575a.parseInt(templateResponseInfo.fileSize, 0);
                        templateInfo.strPreviewurl = templateResponseInfo.previewUrl;
                        templateInfo.strUrl = templateResponseInfo.downloadUrl;
                        templateInfo.strTitle = templateResponseInfo.name;
                        templateInfo.strIntro = templateResponseInfo.description;
                        templateInfo.strVer = templateResponseInfo.engineVersion;
                        templateInfo.strIcon = templateResponseInfo.thumbUrl;
                        FunnyTemplateDetailActivity.this.m19790p(templateInfo);
                    }
                }
            }

            public void onError(Throwable th) {
                FunnyTemplateDetailActivity.this.finish();
            }
        });
    }

    private void ary() {
        if (this.dgI != null && this.dgI.aOi()) {
            this.dgG.setVisibility(8);
            this.dgI.setBackgroundColor(0);
            this.dgI.start();
        }
    }

    private void arz() {
        int iw = this.dgR == 0 ? 8 : mo30339iw(this.dgP);
        if (iw != 1) {
            if (iw == 3) {
                C6738a.m19567y(this, "downloaded", this.dgP);
                FunnySlideRouter.launchFunnyEdit(this, C2575a.m7391rq(this.dgP));
                finish();
            } else if (iw == 8) {
                C8705e.m25369gZ(this).mo35083pi(this.dgP);
                C6738a.m19568z(this, "cancel", this.dgP);
            }
        } else if (!BaseSocialNotify.isNetworkAvaliable(getApplicationContext())) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_com_msg_network_inactive, 1);
        } else {
            arA();
            C6738a.m19567y(this, "not_downloaded", this.dgP);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: he */
    public void m19788he(boolean z) {
        if (z) {
            this.dgH.setVisibility(0);
        } else {
            this.dgH.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m19790p(TemplateInfo templateInfo) {
        this.dgQ = templateInfo;
        if (!TextUtils.isEmpty(templateInfo.strIntro)) {
            this.dgM.setText(templateInfo.strIntro);
        }
        if (!TextUtils.isEmpty(templateInfo.strPreviewurl) && this.dgI != null) {
            this.dgI.setVideoURI(Uri.parse(templateInfo.strPreviewurl));
        }
        if (!TextUtils.isEmpty(templateInfo.strTitle)) {
            this.dgE.setText(templateInfo.strTitle);
        }
    }

    /* renamed from: ph */
    private void m19791ph(int i) {
        if (i == 1 || i == 3) {
            this.dgK.setText(getResources().getString(R.string.xiaoying_str_funny_template_create));
            this.dgK.setBackground(getResources().getDrawable(R.drawable.editor_shape_funny_template_detail_create));
            this.dgN.setVisibility(8);
        }
    }

    public void arB() {
    }

    public void arC() {
    }

    /* renamed from: iA */
    public void mo30336iA(String str) {
        if (this.dgP.equals(str) && this.dgR != 1) {
            m19791ph(mo30339iw(this.dgP));
            this.dgR = 1;
            C6738a.m19568z(this, "succeed", String.valueOf(str));
            FunnySlideRouter.launchFunnyEdit(this, C2575a.m7391rq(this.dgP));
            finish();
        }
    }

    /* renamed from: iB */
    public void mo30337iB(String str) {
        C6738a.m19568z(this, ParametersKeys.FAILED, String.valueOf(str));
        this.dgN.setVisibility(8);
        this.dgK.setText(getResources().getString(R.string.xiaoying_str_funny_template_create));
        this.dgK.setBackground(getResources().getDrawable(R.drawable.editor_shape_funny_template_detail_create));
    }

    /* renamed from: iC */
    public void mo30338iC(String str) {
        this.dgN.setVisibility(8);
        this.dgK.setText(getResources().getString(R.string.xiaoying_str_funny_template_create));
        this.dgK.setBackground(getResources().getDrawable(R.drawable.editor_shape_funny_template_detail_create));
        this.dgR = 2;
    }

    /* renamed from: iw */
    public int mo30339iw(String str) {
        TemplateItemData bD = C8762d.aMt().mo35227bD(C2575a.m7391rq(str));
        return (bD == null || bD.shouldOnlineDownload() || bD.nDelFlag == 1) ? 1 : 3;
    }

    /* renamed from: ix */
    public void mo30340ix(String str) {
    }

    /* renamed from: iy */
    public void mo30341iy(String str) {
        this.dgR = 0;
    }

    /* renamed from: iz */
    public void mo30342iz(String str) {
    }

    public void onClick(View view) {
        if (view.equals(this.bvn)) {
            finish();
        } else if (!view.equals(this.dgF)) {
            if (view.equals(this.dgG)) {
                if (this.dgI != null) {
                    this.dgI.start();
                    this.dgG.setVisibility(8);
                }
            } else if (view.equals(this.dgJ)) {
                if (this.dgI != null) {
                    this.dgG.setVisibility(0);
                    this.dgI.pause();
                }
            } else if (view.equals(this.dgK) && !C4580b.m11632Sf()) {
                arz();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.editor_act_funny_template_detail);
        this.dgO = getIntent().getStringExtra(FunnySlideRouter.INTENT_KEY_FUNNY_TEMPLATE_GROUP);
        this.dgP = getIntent().getStringExtra(FunnySlideRouter.INTENT_KEY_FUNNY_TEMPLATE_ID);
        this.compositeDisposable = new C1494a();
        m19777Oj();
        m19776Kl();
        C8705e.m25369gZ(this).mo35079a((C8707b) this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.dgI != null) {
            this.dgI.stop();
            this.dgI = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            if (this.dgI != null) {
                this.dgI.stop();
                this.dgI = null;
            }
            if (this.compositeDisposable != null) {
                this.compositeDisposable.clear();
            }
            C8705e.m25369gZ(this).mo35080b((C8707b) this);
        } else if (this.dgI != null) {
            this.dgI.pause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ary();
    }

    /* renamed from: w */
    public void mo30344w(String str, int i) {
        if (this.dgP.equals(str) && this.dgR != -1) {
            this.dgR = 0;
            this.dgK.setBackgroundColor(0);
            this.dgN.setVisibility(0);
            this.dgN.setProgress(i);
            TextView textView = this.dgK;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.xiaoying_str_com_msg_download));
            sb.append(" ");
            sb.append(i);
            sb.append("%");
            textView.setText(sb.toString());
        }
    }
}
