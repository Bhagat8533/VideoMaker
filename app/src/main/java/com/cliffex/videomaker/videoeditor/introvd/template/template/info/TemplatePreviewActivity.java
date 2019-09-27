package com.introvd.template.template.info;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.C4677g;
import com.introvd.template.C4681i;
import com.introvd.template.EventActivity;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8035c.C8038a;
import com.introvd.template.module.iap.C8071p;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.module.p326ad.p328b.C7596f;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.p377ad.AdServiceProxy;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.R;
import com.introvd.template.template.download.C8705e;
import com.introvd.template.template.download.C8705e.C8707b;
import com.introvd.template.template.p402c.C8629b;
import com.introvd.template.template.p407e.C8728c;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.xyui.video.C9183a;
import com.introvd.template.xyui.video.VideoView;
import com.p131c.p132a.p135c.C2575a;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1495b;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;
import xiaoying.utils.QComUtils;

@C1942a(mo10417rZ = "/Template/Preview")
public class TemplatePreviewActivity extends EventActivity implements OnTouchListener, VideoAdsListener, VideoRewardListener, C8707b {
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(TemplatePreviewActivity.this.cti)) {
                if (!TemplatePreviewActivity.this.isImage) {
                    TemplatePreviewActivity.this.mHandler.sendMessage(TemplatePreviewActivity.this.mHandler.obtainMessage(101));
                }
            } else if (view.equals(TemplatePreviewActivity.this.bMj)) {
                if (!TemplatePreviewActivity.this.isImage) {
                    TemplatePreviewActivity.this.mHandler.sendMessage(TemplatePreviewActivity.this.mHandler.obtainMessage(102));
                }
            } else if (view.equals(TemplatePreviewActivity.this.eoa)) {
                TemplatePreviewActivity.this.finish();
            } else if (view.equals(TemplatePreviewActivity.this.enZ)) {
                TemplatePreviewActivity.this.aLm();
            }
        }
    };
    private ProgressBar bHt;
    /* access modifiers changed from: private */
    public RelativeLayout bMj;
    private RelativeLayout cBm;
    /* access modifiers changed from: private */
    public C1495b cTc;
    private String csh = "";
    /* access modifiers changed from: private */
    public ImageButton cti;
    private Button dem;
    private RelativeLayout deq;
    private boolean deu = false;
    private String dev = "close";
    /* access modifiers changed from: private */
    public VideoView dgI;
    private String dgP;
    C9183a dgS = new C9183a() {
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
            TemplatePreviewActivity.this.mo35293bV(z);
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            LogUtils.m14223i("TemplatePreviewActivity", "onError");
            if (TemplatePreviewActivity.this.dgI != null) {
                TemplatePreviewActivity.this.dgI.setBackgroundColor(-16777216);
            }
            return false;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            LogUtils.m14223i("TemplatePreviewActivity", "onPrepared");
            if (mediaPlayer != null) {
                int videoWidth = mediaPlayer.getVideoWidth();
                int videoHeight = mediaPlayer.getVideoHeight();
                if (videoWidth == 0 || videoHeight == 0) {
                    mediaPlayer.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
                        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                            TemplatePreviewActivity.this.m25835cY(i, i2);
                        }
                    });
                } else {
                    TemplatePreviewActivity.this.m25835cY(videoWidth, videoHeight);
                }
                TemplatePreviewActivity.this.dgI.setBackgroundColor(0);
            }
        }
    };
    private String dhE;
    private String dhF;
    private String dhG;
    private boolean emI = false;
    private boolean enV = false;
    private boolean enW = false;
    /* access modifiers changed from: private */
    public ImageView enX;
    private ImageView enY;
    /* access modifiers changed from: private */
    public Button enZ;
    /* access modifiers changed from: private */
    public ImageButton eoa;
    private ProgressBar eob;
    private TextView eoc;
    private TextView eod;
    private MediaMetadataRetriever eoe;
    /* access modifiers changed from: private */
    public boolean eog = false;
    private String eoh;
    private boolean eoi = false;
    private boolean eoj = false;
    private boolean eok = false;
    private boolean eol = true;
    private String eom = "download";
    private long eon = 0;
    private long eoo = 0;
    OnCompletionListener eop = new OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            TemplatePreviewActivity.this.eog = true;
            TemplatePreviewActivity.this.mHandler.sendMessage(TemplatePreviewActivity.this.mHandler.obtainMessage(103, 0, 0));
        }
    };
    /* access modifiers changed from: private */
    public boolean isImage = true;
    private Bitmap mBitmap;
    /* access modifiers changed from: private */
    public Handler mHandler = new C8811a(this);

    /* renamed from: com.introvd.template.template.info.TemplatePreviewActivity$a */
    static class C8811a extends Handler {
        /* access modifiers changed from: private */
        public TemplatePreviewActivity eos;

        public C8811a(TemplatePreviewActivity templatePreviewActivity) {
            this.eos = templatePreviewActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 101:
                    if (C4600l.m11739k(this.eos, true)) {
                        LogUtils.m14223i("TemplatePreviewActivity", "MAIN_MSG_PLAYER_START");
                        if (this.eos.dgI != null) {
                            this.eos.eog = false;
                            this.eos.dgI.setBackgroundColor(0);
                            this.eos.dgI.start();
                            this.eos.cti.setVisibility(4);
                            this.eos.mo35293bV(false);
                        }
                        if (this.eos.dgI != null) {
                            MediaPlayer mediaPlayer = this.eos.dgI.getmMediaPlayer();
                            if (mediaPlayer != null) {
                                mediaPlayer.setVolume(0.0f, 1.0f);
                                mediaPlayer.setLooping(true);
                            }
                        }
                        sendEmptyMessage(107);
                        break;
                    } else {
                        return;
                    }
                case 102:
                    LogUtils.m14223i("TemplatePreviewActivity", "MAIN_MSG_PLAYER_PAUSE");
                    if (this.eos.dgI != null) {
                        this.eos.dgI.pause();
                    }
                    if (this.eos.cti != null) {
                        this.eos.cti.setVisibility(0);
                    }
                    if (!(this.eos.dgI == null || this.eos.dgI.getmMediaPlayer() == null)) {
                        this.eos.dgI.getmMediaPlayer().setVolume(0.0f, 1.0f);
                        break;
                    }
                case 103:
                    LogUtils.m14223i("TemplatePreviewActivity", "MAIN_MSG_PLAYER_STOP");
                    this.eos.mo35293bV(false);
                    if (this.eos.cti != null) {
                        this.eos.cti.setVisibility(0);
                        break;
                    }
                    break;
                case 104:
                    C4586g.m11703a((Context) this.eos, -1, (OnCancelListener) new OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                            if (!C8811a.this.eos.isFinishing()) {
                                C4586g.m11696Sm();
                            }
                            C8811a.this.eos.finish();
                        }
                    });
                    break;
                case 105:
                    if (!this.eos.isFinishing()) {
                        C4586g.m11696Sm();
                        break;
                    }
                    break;
                case 106:
                    if (message.obj instanceof JSONObject) {
                        this.eos.m25840f((JSONObject) message.obj);
                    }
                    this.eos.init();
                    break;
                case 107:
                    MediaPlayer mediaPlayer2 = this.eos.dgI.getmMediaPlayer();
                    if (this.eos.enX != null && mediaPlayer2 != null && mediaPlayer2.getCurrentPosition() > 500) {
                        this.eos.enX.setVisibility(8);
                        break;
                    } else {
                        sendEmptyMessageDelayed(107, 100);
                        break;
                    }
            }
        }
    }

    private void aLj() {
        if (!C4600l.m11739k(this, true)) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_com_msg_network_inactive, 1);
            finish();
            return;
        }
        String activeNetworkName = BaseSocialNotify.getActiveNetworkName(this);
        if (TextUtils.isEmpty(activeNetworkName) || !activeNetworkName.equals(BaseSocialNotify.CONNECTIVITY_NAME_MOBILE)) {
            aLl();
        } else if (AppPreferencesSetting.getInstance().getAppSettingBoolean("key_template_preview_need_show_mobile_net_tips", true)) {
            C8978m.m26350ht(this).mo10293dl(R.string.xiaoying_str_com_info_title).mo10315r(getString(R.string.xiaoying_str_community_play_in_mobile_net_tips)).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("key_template_preview_need_show_mobile_net_tips", true);
                    TemplatePreviewActivity.this.finish();
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("key_template_preview_need_show_mobile_net_tips", false);
                    TemplatePreviewActivity.this.aLl();
                }
            }).mo10313qu().show();
        } else {
            ToastUtils.show((Context) this, R.string.xiaoying_str_community_play_in_cellular_network, 0);
            aLl();
        }
    }

    /* access modifiers changed from: private */
    public void aLl() {
        mo35293bV(true);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(104);
        }
        aLo();
    }

    /* access modifiers changed from: private */
    public void aLm() {
        switch (mo35295iw(this.dgP)) {
            case 1:
                if (!this.eoj) {
                    if (!C8739i.m25527qr(this.dgP)) {
                        m25834c(this.dgP, this.dhE, this.dhG, asa());
                        break;
                    } else {
                        C4586g.m11710d(this, TemplateRouter.RATE_UNLOCK_REQUEST_CODE, this.dhF);
                        break;
                    }
                } else if (BaseSocialNotify.isNetworkAvaliable(getApplicationContext())) {
                    if (this.eoi && C8739i.m25526qq(this.dgP)) {
                        this.eoo = System.currentTimeMillis();
                        this.dev = "unlock";
                        C7680l.aAf().mo32521a(this, 19, this);
                        this.eok = true;
                        break;
                    } else {
                        C8739i.m25523cC(this, this.dgP);
                        m25834c(this.dgP, this.dhE, this.dhG, asa());
                        break;
                    }
                } else {
                    ToastUtils.show((Context) this, R.string.xiaoying_str_com_msg_network_inactive, 1);
                    return;
                }
                break;
            case 3:
                if (!this.emI) {
                    if (C8735f.aMf().mo35146cB(this, this.dgP) != null) {
                        long rq = C2575a.m7391rq(this.dgP);
                        C8728c.m25457a(this, String.valueOf(QTemplateIDUtils.getTemplateType(rq)), Long.valueOf(rq), "");
                    }
                    finish();
                    break;
                } else {
                    setResult(1);
                    finish();
                    break;
                }
        }
    }

    private void aLn() {
        this.cBm = (RelativeLayout) findViewById(R.id.main_view);
        this.enX = (ImageView) findViewById(R.id.imageView);
        this.dgI = (VideoView) findViewById(R.id.videoView);
        this.cti = (ImageButton) findViewById(R.id.btn_preview_play);
        this.bMj = (RelativeLayout) findViewById(R.id.layout_preview);
        this.enZ = (Button) findViewById(R.id.btn_download);
        this.eoa = (ImageButton) findViewById(R.id.imgbtn_close);
        this.enY = (ImageView) findViewById(R.id.bg_img);
        this.eob = (ProgressBar) findViewById(R.id.progressbar_loading);
        this.eoc = (TextView) findViewById(R.id.preview_text_title);
        this.eod = (TextView) findViewById(R.id.preview_text_intro);
        this.dem = (Button) findViewById(R.id.template_iap_price);
        this.deq = (RelativeLayout) findViewById(R.id.layout_frame);
        if (!TextUtils.isEmpty(this.dhF)) {
            this.eoc.setVisibility(0);
            this.eoc.setText(this.dhF);
        }
        if (!TextUtils.isEmpty(this.eoh)) {
            this.eod.setVisibility(0);
            this.eod.setText(this.eoh);
        }
        if (this.enY != null) {
            this.enY.setOnTouchListener(this);
        }
        this.bHt = (ProgressBar) findViewById(R.id.xiaoying_com_progress_video_loading);
        this.enZ.setOnClickListener(this.acD);
        this.eoa.setOnClickListener(this.acD);
        this.cti.setOnClickListener(this.acD);
        this.bMj.setOnClickListener(this.acD);
        this.dgI.setOnClickListener(this.acD);
        if (this.deq != null) {
            this.deq.setOnClickListener(this.acD);
        }
        this.dgI.setVisibility(0);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aLo() {
        /*
            r2 = this;
            com.introvd.template.xyui.video.VideoView r0 = r2.dgI
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = r2.csh
            r1 = 1
            android.graphics.Bitmap r0 = android.media.ThumbnailUtils.createVideoThumbnail(r0, r1)
            r2.mBitmap = r0
            android.widget.ImageView r0 = r2.enX
            r1 = 0
            r0.setVisibility(r1)
            android.widget.ImageView r0 = r2.enX
            android.graphics.Bitmap r1 = r2.mBitmap
            r0.setImageBitmap(r1)
            android.widget.ImageView r0 = r2.enX
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setBackgroundColor(r1)
            com.introvd.template.xyui.video.VideoView r0 = r2.dgI
            com.introvd.template.xyui.video.a r1 = r2.dgS
            r0.setVideoViewListener(r1)
            com.introvd.template.xyui.video.VideoView r0 = r2.dgI
            android.media.MediaPlayer$OnCompletionListener r1 = r2.eop
            r0.setOnCompletionListener(r1)
            com.introvd.template.xyui.video.VideoView r0 = r2.dgI
            java.lang.String r1 = r2.csh
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r0.setVideoURI(r1)
            boolean r0 = com.introvd.template.common.ApiHelper.GINGERBREAD_MR1_AND_HIGHER
            if (r0 == 0) goto L_0x005a
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever
            r0.<init>()
            r2.eoe = r0
            android.media.MediaMetadataRetriever r0 = r2.eoe     // Catch:{ Exception -> 0x004d, all -> 0x0053 }
            java.lang.String r1 = r2.csh     // Catch:{ Exception -> 0x004d, all -> 0x0053 }
            r0.setDataSource(r1)     // Catch:{ Exception -> 0x004d, all -> 0x0053 }
        L_0x004d:
            android.media.MediaMetadataRetriever r0 = r2.eoe     // Catch:{ Exception -> 0x005a }
            r0.release()     // Catch:{ Exception -> 0x005a }
            goto L_0x005a
        L_0x0053:
            r0 = move-exception
            android.media.MediaMetadataRetriever r1 = r2.eoe     // Catch:{ Exception -> 0x0059 }
            r1.release()     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            throw r0
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.info.TemplatePreviewActivity.aLo():void");
    }

    private void aLp() {
        boolean z;
        if (C8739i.isNeedToPurchase(this.dgP)) {
            C8071p aBx = C8072q.aBx();
            StringBuilder sb = new StringBuilder();
            sb.append("iap.template.");
            sb.append(this.dgP);
            if (!aBx.mo33072ku(sb.toString().toLowerCase())) {
                z = true;
                if (!C8072q.aBx().isVip() && z) {
                    if (this.cTc != null && !this.cTc.aAy()) {
                        this.cTc.dispose();
                    }
                    LogUtilsV2.m14228e("isReward 11111111111    ");
                    ((C1834l) AdServiceProxy.execute(AdServiceProxy.observableShowUnlockTemplate, this, this.dgP, Boolean.valueOf(false))).mo10149b((C1842q<? super T>) new C1842q<Integer>() {
                        /* renamed from: a */
                        public void mo9877a(C1495b bVar) {
                            TemplatePreviewActivity.this.cTc = bVar;
                        }

                        /* renamed from: n */
                        public void mo9886K(Integer num) {
                            if (num.intValue() == 0) {
                                TemplatePreviewActivity.this.getWindow().getDecorView().setAlpha(0.0f);
                                if (TemplatePreviewActivity.this.dgI != null) {
                                    TemplatePreviewActivity.this.dgI.stop();
                                    TemplatePreviewActivity.this.dgI.setVisibility(8);
                                    return;
                                }
                                return;
                            }
                            TemplatePreviewActivity.this.finish();
                        }

                        public void onComplete() {
                        }

                        public void onError(Throwable th) {
                        }
                    });
                    return;
                }
            }
        }
        z = false;
        if (!C8072q.aBx().isVip()) {
        }
    }

    private int asa() {
        TemplateInfo cB = C8735f.aMf().mo35146cB(this, this.dgP);
        if (cB != null) {
            return cB.nSize;
        }
        return 0;
    }

    /* renamed from: c */
    private void m25834c(String str, String str2, String str3, int i) {
        C10021c.aZH().mo38492aA(new C8629b(str));
        C8705e.m25369gZ(this).mo35081b(str, str2, str3, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: cY */
    public void m25835cY(int i, int i2) {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(105);
        }
        this.cBm.setVisibility(0);
        m25837dL(i, i2);
    }

    /* renamed from: dL */
    private void m25837dL(int i, int i2) {
        this.enX.setVisibility(0);
        if (i < i2) {
            LayoutParams layoutParams = (LayoutParams) this.dgI.getLayoutParams();
            if (this.enV) {
                layoutParams.height = C7689a.m22597aR(350.0f);
                layoutParams.width = (int) (((float) (C7689a.m22597aR(350.0f) * i)) / ((float) i2));
                layoutParams.addRule(13);
            } else {
                layoutParams.height = C7689a.m22597aR(250.0f);
                layoutParams.width = (int) (((float) (C7689a.m22597aR(250.0f) * i)) / ((float) i2));
            }
            this.dgI.setLayoutParams(layoutParams);
        }
        if (this.dgI.getmMediaPlayer() != null) {
            this.dgI.getmMediaPlayer().setVolume(0.0f, 0.0f);
        }
        m25848uS(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m25840f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dhE = jSONObject.optString(C7234b.TAG);
            this.dhF = jSONObject.optString("d");
            this.eoh = jSONObject.optString("e");
            this.csh = jSONObject.optString(C4677g.TAG);
            int optInt = jSONObject.optInt("h");
            if (optInt == 2) {
                this.isImage = true;
            } else if (optInt == 3) {
                this.isImage = false;
            }
            this.dhG = jSONObject.optString("x");
        }
        aLn();
    }

    /* access modifiers changed from: private */
    public void init() {
        m25847ph(getIntent().getIntExtra(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_STATE, 1));
        if (!TextUtils.isEmpty(this.csh)) {
            if (this.isImage) {
                LogUtils.m14223i("TemplatePreviewActivity", "isImage");
                C8705e.m25369gZ(this).mo35082ph(this.csh);
            } else {
                LogUtils.m14223i("TemplatePreviewActivity", "isVideo");
                aLj();
            }
            C8705e.m25369gZ(this).mo35079a((C8707b) this);
        }
    }

    /* renamed from: pD */
    private void m25846pD(String str) {
        this.mBitmap = BitmapFactory.decodeFile(str);
        this.enX.setVisibility(0);
        try {
            if (this.mBitmap != null) {
                this.enX.setImageBitmap(this.mBitmap);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("ex message:");
            sb.append(e.getMessage());
            LogUtils.m14223i("TemplatePreviewActivity", sb.toString());
        }
    }

    /* renamed from: ph */
    private void m25847ph(int i) {
        switch (i) {
            case 1:
                this.eob.setVisibility(4);
                if (this.eoj) {
                    this.enZ.setText(getString(this.eoi ? R.string.xiaoying_str_reward_video_ad_to_watch : R.string.xiaoying_str_template_state_download));
                } else if (C8739i.m25527qr(this.dgP)) {
                    this.enZ.setText(getString(R.string.xiaoying_str_iap_unlock_template_list));
                } else {
                    this.enZ.setText(R.string.xiaoying_str_template_state_download);
                }
                this.enZ.setTextColor(-1);
                this.enZ.setVisibility(0);
                this.dem.setVisibility(8);
                this.enZ.setBackgroundResource(R.drawable.v5_xiaoying_com_template_btn_preview_download_selector);
                this.deu = C8035c.isNeedToPurchase(this.dgP);
                break;
            case 2:
                this.enZ.setText(R.string.xiaoying_str_template_state_delete);
                this.enZ.setTextColor(-1);
                this.enZ.setBackgroundResource(R.drawable.xiaoying_com_template_btn_delete);
                break;
            case 3:
                this.eob.setVisibility(4);
                if (this.eoj) {
                    this.enZ.setText(getString(R.string.xiaoying_str_reward_video_ad_to_use));
                } else {
                    this.enZ.setText(R.string.xiaoying_str_template_state_apply);
                }
                this.enZ.setTextColor(-1);
                this.enZ.setBackgroundResource(R.drawable.v5_xiaoying_com_template_btn_preview_download_selector);
                break;
            case 4:
                this.enZ.setText(R.string.xiaoying_str_template_state_download);
                this.enZ.setTextColor(-1);
                this.enZ.setBackgroundResource(R.drawable.v5_xiaoying_com_template_btn_preview_download_selector);
                break;
            case 5:
                this.enZ.setText(R.string.xiaoying_str_template_state_disable);
                this.enZ.setTextColor(-1);
                this.enZ.setBackgroundResource(R.drawable.xiaoying_com_template_btn_delete);
                this.enZ.setEnabled(false);
                break;
            case 6:
                this.enZ.setText(R.string.xiaoying_str_template_state_downloaded2);
                this.enZ.setTextColor(getResources().getColor(R.color.color_acacac));
                this.enZ.setBackgroundResource(R.drawable.xiaoying_com_template_btn_preview_downloaded);
                this.enZ.setEnabled(false);
                break;
        }
        boolean isInChina = AppStateModel.getInstance().isInChina();
        C8038a aVar = new C8038a();
        aVar.mo33056rY(36).mo33054cY(this.dem).mo33060sc(isInChina ? R.string.xiaoying_str_vip_duration_limit_confirm : R.string.xiaoying_str_vip_subscribe).mo33053a(this.enZ).mo33061sd(R.string.xiaoying_str_reward_video_ad_to_watch).mo33058sa(getResources().getColor(R.color.color_f0f0f0)).mo33057rZ(R.drawable.v5_xiaoying_iap_template_purchase_diable_bg);
        C8035c.m23245a(this, this.dgP, this.dem, aVar);
    }

    /* renamed from: uS */
    private void m25848uS(int i) {
        if (this.dgI.isPlaying() || this.eok || !this.eol) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(102));
            return;
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(101), (long) i);
    }

    public void arB() {
        mo35293bV(true);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(104);
        }
    }

    public void arC() {
        mo35293bV(false);
    }

    /* renamed from: bV */
    public void mo35293bV(boolean z) {
        if (this.bHt != null) {
            if (!z || this.eog) {
                this.bHt.setVisibility(8);
            } else {
                this.bHt.setVisibility(0);
            }
        }
    }

    public void finish() {
        if (this.deu) {
            UserBehaviorUtils.recordIAPThemePreview(this, this.dev, this.dgP, "theme");
            if ("buy".equals(this.dev)) {
                UserBehaviorUtils.recordIAPTemplateClick(this, "theme_dialog", this.dgP, "theme");
            }
        }
        super.finish();
    }

    /* renamed from: iA */
    public void mo30336iA(String str) {
        if (this.dgP.equals(str) && !"done".equals(this.eom)) {
            m25847ph(mo35295iw(this.dgP));
            this.eom = "done";
        }
    }

    /* renamed from: iB */
    public void mo30337iB(String str) {
    }

    /* renamed from: iC */
    public void mo30338iC(String str) {
    }

    /* renamed from: iw */
    public int mo35295iw(String str) {
        TemplateItemData bD = C8762d.aMt().mo35227bD(C2575a.m7391rq(str));
        return (bD == null || bD.shouldOnlineDownload() || bD.nDelFlag == 1) ? 1 : 3;
    }

    /* renamed from: ix */
    public void mo30340ix(String str) {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(105);
        }
        this.csh = str;
        mo35293bV(false);
        this.cBm.setVisibility(0);
        m25846pD(this.csh);
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
            C8739i.m25523cC(this, this.dgP);
            if (C4600l.m11739k(this, true)) {
                m25834c(this.dgP, this.dhE, this.dhG, asa());
                this.eon = System.currentTimeMillis();
            } else {
                return;
            }
        }
        if (i == 9527) {
            this.dev = "buy";
            m25847ph(mo35295iw(this.dgP));
            int i3 = -1;
            if (i2 == -1) {
                setResult(-1);
            } else if (C4681i.m12184Gp().mo25016Gr() != null) {
                if (!C8072q.aBx().mo33072ku(C7825a.ALL_TEMPLATE.getId())) {
                    i3 = 0;
                }
                setResult(i3);
            }
            aLp();
        }
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setVolumeControlStream(3);
        LogUtils.m14223i("TemplatePreviewActivity", "onStart");
        Bundle extras = getIntent().getExtras();
        this.emI = extras.getBoolean(TemplateRouter.EXTRA_KEY_NEED_ACTIVITY_RESULT, false);
        int i = extras.getInt(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TYPE, 2);
        this.enV = extras.getBoolean(TemplateRouter.TEMPLATE_CARD_PREVIEWTYPE_IAP_KEY);
        setContentView(this.enV ? R.layout.xiaoying_template_preview_iap : R.layout.xiaoying_template_preview);
        this.csh = extras.getString(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_URL);
        this.dgP = extras.getString(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TTID);
        this.dhE = extras.getString(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_VER);
        this.dhG = extras.getString(TemplateRouter.BUNDLE_TEMPLATE_DOWNLOAD_KEY);
        this.dhF = extras.getString(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TITLE);
        this.eoh = extras.getString(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_INTRO);
        this.eoj = C8739i.m25526qq(this.dgP);
        C7680l.aAf().mo32531h(19, this);
        C7680l.aAf().mo32526aj(this, 19);
        C7680l.aAf().mo32526aj(this, 49);
        this.eoi = C7680l.aAf().isAdAvailable(this, 19);
        aLn();
        if (i == 2) {
            this.isImage = true;
        } else if (i == 3) {
            this.isImage = false;
        }
        this.cBm.setVisibility(4);
        if (TextUtils.isEmpty(this.dgP) || TextUtils.isEmpty(this.dhE) || this.enV) {
            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ITEM_INFO, (C8354a) new C8354a() {
                /* renamed from: a */
                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                    C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ITEM_INFO);
                    if (TemplatePreviewActivity.this.mHandler != null) {
                        TemplatePreviewActivity.this.mHandler.sendEmptyMessage(105);
                    }
                    if (i == 131072) {
                        C8739i.m25524ho(context);
                        try {
                            JSONObject jSONObject = new JSONObject(bundle.getString(SocialServiceDef.XIAOYING_SERVER_RESPONSE));
                            if (TemplatePreviewActivity.this.mHandler != null) {
                                TemplatePreviewActivity.this.mHandler.sendMessage(TemplatePreviewActivity.this.mHandler.obtainMessage(106, jSONObject));
                            }
                        } catch (Exception unused) {
                            LogUtils.m14222e("TemplatePreviewActivity", "parse json error");
                        }
                    }
                }
            });
            C8346e.m24072U(this, String.valueOf(QTemplateIDUtils.getTemplateType(C2575a.m7391rq(this.dgP))), C8450a.m24469bn(C2575a.m7391rq(this.dgP)));
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(104);
            }
        } else {
            init();
        }
        if (this.eoj) {
            this.eoc.setText(getString(this.eoi ? R.string.xiaoying_str_reward_video_ad_to_unlock_material_title : R.string.xiaoying_str_reward_video_ad_to_luckily_download_title));
            this.eoc.setVisibility(0);
            this.eod.setVisibility(8);
        }
        C10021c.aZH().mo38494ax(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        LogUtils.m14223i("TemplatePreviewActivity", "onDestroy");
        C7593c.m22383b("theme", C7594d.dMB, new String[0]);
        if (this.eoj) {
            C7591a.m22373d(this.dgP, this.dev, this.eoi);
        }
        C8705e.m25369gZ(this).mo35080b((C8707b) this);
        if (this.dgI != null) {
            this.dgI.stop();
            this.dgI = null;
        }
        if (this.eoe != null) {
            this.eoe.release();
            this.eoe = null;
        }
        QComUtils.resetInstanceMembers(this);
        C10021c.aZH().mo38496az(this);
        C8035c.release();
        C7680l.aAe().releasePosition(19, false);
        super.onDestroy();
        if (this.cTc != null && !this.cTc.aAy()) {
            this.cTc.dispose();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEvent(C7596f fVar) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.dgI != null && !this.isImage) {
            this.dgI.pause();
        }
        UserBehaviorLog.onPause(this);
        LogUtils.m14223i("TemplatePreviewActivity", "onPause");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UserBehaviorLog.onResume(this);
        LogUtils.m14223i("TemplatePreviewActivity", "onResume");
        if (this.isImage) {
            this.dgI.setVisibility(8);
            this.cti.setVisibility(8);
        } else {
            this.dgI.setBackgroundColor(-16777216);
            m25848uS(0);
        }
        if (C4681i.m12184Gp().mo25016Gr() != null && C8072q.aBx().mo33072ku(C7825a.ALL_TEMPLATE.getId())) {
            m25847ph(mo35295iw(this.dgP));
        }
        this.eok = false;
    }

    public void onShowVideoAd(AdPositionInfoParam adPositionInfoParam, boolean z) {
        this.eol = false;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        LogUtils.m14223i("TemplatePreviewActivity", "onStop");
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.equals(this.enY)) {
            finish();
        }
        return false;
    }

    /* renamed from: w */
    public void mo30344w(String str, int i) {
        if (this.dgP.equals(str) && !"done".equals(this.eom)) {
            this.eom = "downloading";
            this.enZ.setBackgroundColor(0);
            this.eob.setVisibility(0);
            this.eob.setProgress(i);
            Button button = this.enZ;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("%");
            button.setText(sb.toString());
        }
    }
}
