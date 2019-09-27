package com.introvd.template.camera.p233ui.view.indicator;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.camera.p208a.C4670i;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.camera.p233ui.C5044a;
import com.introvd.template.camera.p233ui.C5054b.C5055a;
import com.introvd.template.camera.p233ui.C5054b.C5056b;
import com.introvd.template.camera.p233ui.C5054b.C5057c;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.vivacamera.R;
import com.introvd.template.xyui.C9136a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import lib.C12177i;

/* renamed from: com.introvd.template.camera.ui.view.indicator.TopIndicator */
public class TopIndicator extends RelativeLayout implements OnClickListener {
    private static final String TAG = "TopIndicator";
    private C9136a bML;
    private ImageView bZM;
    private ImageView bZX;
    private RelativeLayout bZY;
    private TextView bZZ;
    private TextView caa;
    private TextView cab;
    private LinearLayout cac;
    private View cad;
    /* access modifiers changed from: private */
    public C4670i cae;
    private TextView caf;
    private long cag = 0;
    private long cah = 0;
    private long cai = 0;
    private ProgressBar caj;
    private TextView cak;
    private Context mContext;

    public TopIndicator(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public TopIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public TopIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    /* renamed from: YJ */
    private void m14123YJ() {
        C5044a aVar = new C5044a(this.mContext);
        int durationLimit = C5008i.m12937VU().getDurationLimit();
        aVar.setWidth(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT);
        aVar.mo25946c(0, R.string.xiaoying_str_cam_duration_portrait_no_limit, m14127cf(0, durationLimit), true);
        aVar.mo25946c(1, R.string.xiaoying_str_cam_duration_landscape_no_limit, m14127cf(1, durationLimit), true);
        aVar.mo25931a((C5056b) new C5056b() {
            /* renamed from: a */
            public void mo25941a(C5055a aVar) {
                if (aVar != null) {
                    C5008i.m12937VU().setDurationLimit(TopIndicator.this.m14128jJ(aVar.getItemId()));
                    TopIndicator.this.m14129jK(C5008i.m12937VU().getDurationLimit());
                    if (TopIndicator.this.cae != null) {
                        TopIndicator.this.cae.mo25003iN(aVar.getItemId());
                    }
                    TopIndicator.this.update();
                }
            }
        });
        aVar.mo25932a((C5057c) new C5057c() {
            public void onDismiss() {
            }
        });
        aVar.show(this.bZY);
    }

    /* renamed from: cf */
    private boolean m14127cf(int i, int i2) {
        boolean z = true;
        if (i == 6) {
            if (i2 != 5900) {
                z = false;
            }
            return z;
        } else if (i == 8) {
            if (i2 != 7900) {
                z = false;
            }
            return z;
        } else if (i == 10) {
            if (i2 != 9900) {
                z = false;
            }
            return z;
        } else if (i != 15) {
            switch (i) {
                case 0:
                    if (i2 != 0) {
                        z = false;
                    }
                    return z;
                case 1:
                    return false;
                default:
                    return false;
            }
        } else {
            if (i2 != 14900) {
                z = false;
            }
            return z;
        }
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_top_indicator_por, this, true);
        this.bZY = (RelativeLayout) findViewById(R.id.duration_layout);
        this.bZX = (ImageView) findViewById(R.id.img_arrow);
        this.bZZ = (TextView) findViewById(R.id.cam_recording_total_time);
        this.caa = (TextView) findViewById(R.id.txt_current_time);
        this.cab = (TextView) findViewById(R.id.txt_total_time);
        this.cac = (LinearLayout) findViewById(R.id.cam_pip_duration_layout);
        this.caf = (TextView) findViewById(R.id.txt_record_mode);
        this.caj = (ProgressBar) findViewById(R.id.cam_music_progressbar);
        this.bZM = (ImageView) findViewById(R.id.img_back);
        this.bZM.setOnClickListener(this);
        this.cad = findViewById(R.id.cam_btn_next);
        this.cad.setOnClickListener(this);
        this.bZX.setOnClickListener(this);
        this.bZY.setOnClickListener(this);
        this.cak = (TextView) findViewById(R.id.cam_clip_count);
        if (C5034e.m13264s(this.mContext, false)) {
            this.bZY.setBackgroundResource(R.drawable.xiaoying_cam_por_time_bg_selector);
            setBackgroundColor(4278868);
            this.bZZ.setTextSize(2, 20.0f);
            this.caa.setTextSize(2, 20.0f);
            return;
        }
        this.bZY.setBackgroundResource(R.drawable.xiaoying_com_trans_bg);
        setBackgroundResource(R.drawable.v4_xiaoying_cam_indicator_bar_bg);
    }

    /* access modifiers changed from: private */
    /* renamed from: jJ */
    public int m14128jJ(int i) {
        if (i == 6) {
            return 5900;
        }
        if (i == 8) {
            return 7900;
        }
        if (i == 10) {
            return 9900;
        }
        if (i == 15) {
            return 14900;
        }
        switch (i) {
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: jK */
    public void m14129jK(int i) {
        if (i == 0) {
            this.caf.setText(R.string.xiaoying_str_cam_duration_portrait_no_limit);
        } else if (i == 5900) {
            this.caf.setText(R.string.xiaoying_str_cam_duration_portrait_6_sec);
        } else if (i == 7900) {
            this.caf.setText(R.string.xiaoying_str_cam_duration_portrait_8_sec);
        } else if (i == 9900) {
            this.caf.setText(R.string.xiaoying_str_cam_duration_portrait_10_sec);
        } else if (i == 14900) {
            this.caf.setText(R.string.xiaoying_str_cam_duration_portrait_15_sec);
        }
    }

    /* renamed from: XO */
    public void mo26251XO() {
        if (this.bML != null) {
            this.bML.aNX();
        }
    }

    /* renamed from: YK */
    public void mo26252YK() {
        this.cak.setVisibility(8);
    }

    /* renamed from: YL */
    public void mo26253YL() {
        this.cak.setVisibility(0);
    }

    /* renamed from: ae */
    public void mo26254ae(Activity activity) {
        if (this.bML == null) {
            this.bML = new C9136a(activity, true);
        }
        this.bML.mo36087f(this.caf, 10, C4580b.m11666qi());
        this.bML.mo36086dt(getResources().getString(R.string.xiaoying_str_cam_help_duration));
        this.bML.show();
    }

    /* renamed from: bU */
    public void mo26255bU(int i, int i2) {
        long j = (long) i;
        setTimeValue(this.cah, j, this.caa);
        this.cah = j;
        long j2 = (long) i2;
        setTimeValue(this.cai, j2, this.cab);
        this.cai = j2;
    }

    /* renamed from: dA */
    public void mo26256dA(boolean z) {
        if (z) {
            this.cak.setBackgroundResource(R.drawable.v5_xiaoying_cam_clipcount_text_focus_bg_shape);
            this.cak.setTextColor(-1);
            return;
        }
        this.cak.setBackgroundResource(R.drawable.v5_xiaoying_cam_clipcount_text_bg_shape);
        this.cak.setTextColor(this.mContext.getResources().getColor(R.color.color_ff774e));
    }

    /* renamed from: dz */
    public void mo26257dz(boolean z) {
        if (z) {
            this.caj.setVisibility(0);
        } else {
            this.caj.setVisibility(4);
        }
    }

    public View getBtnNext() {
        return this.cad;
    }

    public void onClick(View view) {
        if (view.equals(this.bZX) || view.equals(this.bZY)) {
            m14123YJ();
            mo26251XO();
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_duration", true);
            if (this.cae != null) {
                this.cae.mo25002UU();
            }
        } else if (view.equals(this.bZM)) {
            if (this.cae != null) {
                this.cae.mo25001UT();
            }
        } else if (view.equals(this.cad)) {
            C5198c.m14174dx(false);
            if (this.cae != null) {
                this.cae.mo25000UO();
            }
        }
    }

    public void onPause() {
        mo26251XO();
    }

    public void setClipCount(String str) {
        this.cak.setText(str);
    }

    public void setEnabled(boolean z) {
        this.bZM.setEnabled(z);
        this.cad.setEnabled(z);
        super.setEnabled(z);
    }

    public void setMaxProgress(int i) {
        this.caj.setMax(i);
    }

    public void setProgress(int i) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("progress: ");
        sb.append(i);
        LogUtils.m14223i(str, sb.toString());
        this.caj.setProgress(i);
    }

    public void setTimeExceed(boolean z) {
        if (z) {
            this.bZZ.setTextColor(-65536);
        } else {
            this.bZZ.setTextColor(this.mContext.getResources().getColor(R.color.white));
        }
    }

    public void setTimeValue(long j) {
        setTimeValue(this.cag, j, this.bZZ);
        this.cag = j;
    }

    public void setTimeValue(long j, long j2, TextView textView) {
        if (C5008i.m12937VU().getDurationLimit() == 0) {
            String str = "";
            if (C5008i.m12937VU().getDurationLimit() == 0) {
                if (j2 < C12177i.f6154j) {
                    int i = (j2 > 10000 ? 1 : (j2 == 10000 ? 0 : -1));
                    if (i < 0) {
                        str = C5034e.m13263jN((int) j2);
                        if (j >= 10000 || j == 0) {
                            textView.setWidth((int) textView.getPaint().measureText("x0.0"));
                        }
                    } else {
                        int i2 = (j2 > DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS ? 1 : (j2 == DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS ? 0 : -1));
                        if (i2 < 0 && i >= 0) {
                            str = C5034e.m13263jN((int) j2);
                            if (j >= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || j < 10000) {
                                textView.setWidth((int) textView.getPaint().measureText("x00.0"));
                            }
                        } else if (i2 >= 0) {
                            str = C5034e.m13263jN((int) j2);
                            if (j < DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || j > C12177i.f6154j) {
                                textView.setWidth((int) textView.getPaint().measureText("x0:00.0"));
                            }
                        }
                    }
                } else {
                    str = C5034e.m13263jN((int) j2);
                    if (j < C12177i.f6154j) {
                        textView.setWidth((int) textView.getPaint().measureText("x00:00.0"));
                    }
                }
                textView.setText(str);
            } else {
                if (j2 < 10000) {
                    if (j >= 10000 || j == 0) {
                        textView.setWidth((int) textView.getPaint().measureText("x0.0"));
                    }
                } else if (j < 10000) {
                    textView.setWidth((int) textView.getPaint().measureText("x00.0"));
                }
                textView.setText(C5034e.m13263jN((int) j2));
            }
        }
    }

    public void setTopIndicatorClickListener(C4670i iVar) {
        this.cae = iVar;
    }

    public void update() {
        int VW = C5008i.m12937VU().mo25610VW();
        int clipCount = C5008i.m12937VU().getClipCount();
        int state = C5008i.m12937VU().getState();
        int durationLimit = C5008i.m12937VU().getDurationLimit();
        C5008i.m12937VU().mo25611VX();
        int Wi = C5008i.m12937VU().mo25622Wi();
        int i = 0;
        if (durationLimit != 0) {
            this.bZZ.setVisibility(8);
            this.cac.setVisibility(8);
        } else if (!CameraCodeMgr.isCameraParamPIP(VW) || -1 == Wi) {
            this.bZZ.setVisibility(0);
            this.cac.setVisibility(8);
        } else {
            this.cac.setVisibility(0);
            this.bZZ.setVisibility(8);
        }
        boolean z = true;
        if (clipCount <= 0) {
            mo26252YK();
            if (state != 2) {
                this.bZX.setVisibility(0);
                this.bZY.setClickable(true);
                this.caf.setVisibility(0);
                m14129jK(durationLimit);
                this.bZZ.setVisibility(8);
            } else {
                this.bZX.setVisibility(8);
                this.bZY.setClickable(false);
                this.caf.setVisibility(8);
                if (durationLimit != 0) {
                    this.bZZ.setVisibility(8);
                } else {
                    this.bZZ.setVisibility(0);
                }
            }
            this.cad.setVisibility(4);
            this.cac.setVisibility(8);
            z = false;
        } else {
            mo26253YL();
            this.caf.setVisibility(8);
            this.bZX.setVisibility(8);
            this.bZY.setClickable(false);
            boolean Wh = C5008i.m12937VU().mo25621Wh();
            if (!CameraCodeMgr.isCameraParamPIP(VW)) {
                this.cad.setVisibility(0);
            } else if (Wh) {
                this.cad.setVisibility(0);
            } else {
                this.cad.setVisibility(4);
                z = false;
            }
            if (durationLimit != 0) {
                this.bZZ.setVisibility(8);
                this.cac.setVisibility(8);
            } else if (!CameraCodeMgr.isCameraParamPIP(VW) || -1 == Wi) {
                this.bZZ.setVisibility(0);
                this.cac.setVisibility(8);
            } else {
                this.cac.setVisibility(0);
                this.bZZ.setVisibility(8);
            }
        }
        if (state == 2) {
            this.bZM.setVisibility(4);
            this.cad.setVisibility(4);
            return;
        }
        this.bZM.setVisibility(0);
        View view = this.cad;
        if (!z) {
            i = 4;
        }
        view.setVisibility(i);
    }
}
