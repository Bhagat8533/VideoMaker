package com.introvd.template.camera.p233ui.view.indicator;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.camera.p208a.C4670i;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.camera.p233ui.C5054b.C5055a;
import com.introvd.template.camera.p233ui.C5054b.C5056b;
import com.introvd.template.camera.p233ui.C5054b.C5057c;
import com.introvd.template.camera.p233ui.C5111d;
import com.introvd.template.p414ui.view.RotateImageView;
import com.introvd.template.p414ui.view.RotateTextView;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.vivacamera.R;
import lib.C12177i;
import p504io.fabric.sdk.android.services.common.IdManager;

/* renamed from: com.introvd.template.camera.ui.view.indicator.TopIndicatorLan */
public class TopIndicatorLan extends RelativeLayout implements OnClickListener {
    private static final String TAG = "TopIndicatorLan";
    /* access modifiers changed from: private */
    public RelativeLayout bZD;
    private RelativeLayout bZY;
    /* access modifiers changed from: private */
    public C4670i cae;
    private long cag = 0;
    private long cah = 0;
    private long cai = 0;
    private RotateImageView cam;
    private RotateTextView can;
    private RotateTextView cao;
    private RotateTextView cap;
    private RelativeLayout caq;
    private RotateTextView car;
    private RotateTextView cas;
    private Context mContext;

    public TopIndicatorLan(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public TopIndicatorLan(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public TopIndicatorLan(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    /* renamed from: YJ */
    private void m14138YJ() {
        int clipCount = C5008i.m12937VU().getClipCount();
        int state = C5008i.m12937VU().getState();
        if (clipCount <= 0 && state != 2) {
            C5111d dVar = new C5111d(this.mContext);
            dVar.mo25997c(1, R.string.xiaoying_str_cam_duration_landscape_no_limit, true, true);
            dVar.mo25997c(0, R.string.xiaoying_str_cam_duration_portrait_no_limit, false, true);
            dVar.mo25931a((C5056b) new C5056b() {
                /* renamed from: a */
                public void mo25941a(C5055a aVar) {
                    C5008i.m12937VU().setDurationLimit(TopIndicatorLan.this.m14142jJ(aVar.getItemId()));
                    if (TopIndicatorLan.this.cae != null) {
                        TopIndicatorLan.this.bZD.setVisibility(0);
                        TopIndicatorLan.this.cae.mo25003iN(aVar.getItemId());
                    }
                }
            });
            dVar.mo25932a((C5057c) new C5057c() {
                public void onDismiss() {
                    TopIndicatorLan.this.bZD.setVisibility(0);
                }
            });
            dVar.show(this);
        }
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_top_indicator_lan, this, true);
        this.bZY = (RelativeLayout) findViewById(R.id.duration_layout);
        this.bZD = (RelativeLayout) findViewById(R.id.mode_layout);
        this.cam = (RotateImageView) findViewById(R.id.img_arrow);
        this.can = (RotateTextView) findViewById(R.id.cam_recording_total_time);
        this.cao = (RotateTextView) findViewById(R.id.txt_current_time);
        this.cap = (RotateTextView) findViewById(R.id.txt_total_time);
        this.caq = (RelativeLayout) findViewById(R.id.cam_pip_duration_layout);
        this.car = (RotateTextView) findViewById(R.id.txt_record_mode);
        this.cam.setOnClickListener(this);
        this.bZD.setOnClickListener(this);
        this.cas = (RotateTextView) findViewById(R.id.cam_clip_count_hor);
    }

    /* access modifiers changed from: private */
    /* renamed from: jJ */
    public int m14142jJ(int i) {
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

    private void setTimeValue(long j, long j2, TextView textView) {
        String str = "";
        if (j2 < C12177i.f6154j) {
            int i = (j2 > 10000 ? 1 : (j2 == 10000 ? 0 : -1));
            if (i < 0) {
                str = C5034e.m13263jN((int) j2);
                if (j >= 10000 || j == 0) {
                    textView.setHeight((int) textView.getPaint().measureText(IdManager.DEFAULT_VERSION_NAME));
                }
            } else {
                int i2 = (j2 > DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS ? 1 : (j2 == DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS ? 0 : -1));
                if (i2 < 0 && i >= 0) {
                    str = C5034e.m13263jN((int) j2);
                    if (j >= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || j < 10000) {
                        textView.setHeight((int) textView.getPaint().measureText("00.0"));
                    }
                } else if (i2 >= 0) {
                    str = C5034e.m13263jN((int) j2);
                    if (j < DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS || j > C12177i.f6154j) {
                        textView.setHeight((int) textView.getPaint().measureText("0:00.0"));
                    }
                }
            }
        } else {
            str = C5034e.m13263jN((int) j2);
            if (j < C12177i.f6154j) {
                textView.setHeight((int) textView.getPaint().measureText("00:00.0"));
            }
        }
        textView.setText(str);
    }

    /* renamed from: YK */
    public void mo26270YK() {
        this.cas.setVisibility(8);
    }

    /* renamed from: YL */
    public void mo26271YL() {
        this.cas.setVisibility(0);
    }

    /* renamed from: bU */
    public void mo26272bU(int i, int i2) {
        long j = (long) i;
        setTimeValue(this.cah, j, this.cao);
        this.cah = j;
        long j2 = (long) i2;
        setTimeValue(this.cai, j2, this.cap);
        this.cai = j2;
    }

    /* renamed from: dA */
    public void mo26273dA(boolean z) {
        if (z) {
            this.cas.setBackgroundResource(R.drawable.v5_xiaoying_cam_clipcount_text_focus_bg_shape);
            this.cas.setTextColor(-1);
            return;
        }
        this.cas.setBackgroundResource(R.drawable.v5_xiaoying_cam_clipcount_text_bg_shape);
        this.cas.setTextColor(this.mContext.getResources().getColor(R.color.color_ff774e));
    }

    public void onClick(View view) {
        if (view.equals(this.cam) || view.equals(this.bZD)) {
            m14138YJ();
            this.bZD.setVisibility(4);
            if (this.cae != null) {
                this.cae.mo25002UU();
            }
        } else if (view.equals(this.can)) {
            m14138YJ();
            this.bZD.setVisibility(4);
        }
    }

    public void onPause() {
    }

    public void setClipCount(String str) {
        this.cas.setText(str);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public void setTimeExceed(boolean z) {
        if (z) {
            this.can.setTextColor(-65536);
        } else {
            this.can.setTextColor(this.mContext.getResources().getColor(R.color.white));
        }
    }

    public void setTimeValue(long j) {
        setTimeValue(this.cag, j, this.can);
        this.cag = j;
    }

    public void setTopIndicatorClickListener(C4670i iVar) {
        this.cae = iVar;
    }

    public void update() {
        int VW = C5008i.m12937VU().mo25610VW();
        int clipCount = C5008i.m12937VU().getClipCount();
        int state = C5008i.m12937VU().getState();
        int Wi = C5008i.m12937VU().mo25622Wi();
        this.caq.setVisibility(8);
        if (!CameraCodeMgr.isCameraParamPIP(VW) || -1 == Wi) {
            this.can.setVisibility(0);
            this.caq.setVisibility(8);
        } else {
            this.caq.setVisibility(0);
            this.can.setVisibility(8);
        }
        if (clipCount <= 0) {
            mo26270YK();
            this.bZY.setVisibility(4);
            if (state != 2) {
                this.bZY.setVisibility(4);
                this.bZD.setVisibility(0);
                this.cam.setVisibility(0);
                this.bZD.setClickable(true);
                this.car.setVisibility(0);
                String string = getResources().getString(R.string.xiaoying_str_cam_duration_landscape_no_limit);
                TextPaint paint = this.car.getPaint();
                int i = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
                int measureText = (int) paint.measureText(string);
                this.car.setWidth(i);
                this.car.setHeight(measureText);
                this.car.setText(string);
                this.can.setVisibility(8);
                return;
            }
            this.bZY.setVisibility(0);
            this.bZD.setVisibility(4);
            this.cam.setVisibility(8);
            this.bZD.setClickable(false);
            this.car.setVisibility(8);
            this.can.setVisibility(0);
            return;
        }
        this.bZY.setVisibility(0);
        this.bZD.setVisibility(4);
        mo26271YL();
        if (!CameraCodeMgr.isCameraParamPIP(VW) || -1 == Wi) {
            this.can.setVisibility(0);
            this.caq.setVisibility(8);
        } else {
            this.caq.setVisibility(0);
            this.can.setVisibility(8);
        }
        this.car.setVisibility(8);
        this.cam.setVisibility(8);
        this.bZY.setClickable(false);
    }
}
