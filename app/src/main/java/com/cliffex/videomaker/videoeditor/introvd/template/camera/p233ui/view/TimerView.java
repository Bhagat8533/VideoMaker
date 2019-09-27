package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.p414ui.view.RotateTextView;
import com.introvd.template.vivacamera.R;
import java.lang.ref.WeakReference;
import xiaoying.engine.base.QDisplayContext;

/* renamed from: com.introvd.template.camera.ui.view.TimerView */
public class TimerView extends RelativeLayout implements OnClickListener {
    private static final String TAG = "TimerView";
    private static final int[] bYw = {3, 5, 10};
    private boolean bPL = true;
    /* access modifiers changed from: private */
    public C5178b bTI;
    /* access modifiers changed from: private */
    public C5177a bYA = new C5177a(this);
    /* access modifiers changed from: private */
    public int bYB = 0;
    private Animation bYq;
    private Animation bYr;
    private Animation bYs;
    private Animation bYt;
    /* access modifiers changed from: private */
    public boolean bYu = false;
    private int bYv = 0;
    private RotateTextView bYx;
    private RotateTextView bYy;
    private RotateTextView bYz;
    private Context mContext;

    /* renamed from: com.introvd.template.camera.ui.view.TimerView$a */
    private static class C5177a extends Handler {
        final WeakReference<TimerView> bry;

        public C5177a(TimerView timerView) {
            super(Looper.getMainLooper());
            this.bry = new WeakReference<>(timerView);
        }

        public void handleMessage(Message message) {
            TimerView timerView = (TimerView) this.bry.get();
            if (timerView != null) {
                switch (message.what) {
                    case 4097:
                        int i = message.arg1;
                        if (i % 10 == 0) {
                            int i2 = i / 10;
                            timerView.setTimer(i2);
                            if (timerView.bTI != null) {
                                timerView.bTI.mo25959jx(i2);
                                break;
                            }
                        }
                        break;
                    case 4098:
                        timerView.mo26208Yq();
                        break;
                    case 4099:
                        timerView.mo26208Yq();
                        break;
                    case 4100:
                        if (timerView.bYA != null) {
                            if (timerView.bYB >= 0 && timerView.bYu) {
                                timerView.bYA.sendMessage(timerView.bYA.obtainMessage(4097, timerView.bYB, 0));
                                timerView.bYB = timerView.bYB - 1;
                                timerView.bYA.sendEmptyMessageDelayed(4100, 100);
                                break;
                            } else {
                                timerView.bYA.removeMessages(4100);
                                break;
                            }
                        } else {
                            return;
                        }
                }
            }
        }
    }

    /* renamed from: com.introvd.template.camera.ui.view.TimerView$b */
    public interface C5178b {
        /* renamed from: jw */
        void mo25958jw(int i);

        /* renamed from: jx */
        void mo25959jx(int i);
    }

    public TimerView(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public TimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public TimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    /* renamed from: WV */
    private void m14069WV() {
        this.bYr = AnimationUtils.loadAnimation(this.mContext, R.anim.xiaoying_timer_out);
        this.bYr.setFillAfter(true);
        this.bYq = AnimationUtils.loadAnimation(this.mContext, R.anim.xiaoying_timer_in);
        this.bYq.setFillAfter(true);
        this.bYs = AnimationUtils.loadAnimation(this.mContext, 17432576);
        this.bYt = AnimationUtils.loadAnimation(this.mContext, 17432577);
    }

    private int getIndex(int i) {
        for (int i2 = 0; i2 < bYw.length; i2++) {
            if (bYw[i2] == i) {
                return i2;
            }
        }
        return 0;
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_timer, this, true);
        this.bYx = (RotateTextView) findViewById(R.id.timer_text1);
        this.bYy = (RotateTextView) findViewById(R.id.timer_text2);
        this.bYz = (RotateTextView) findViewById(R.id.timer_tip);
        m14069WV();
        reset();
        C5008i.m12937VU().mo25656jk(0);
        AppPreferencesSetting.getInstance().setAppSettingStr("pref_timer_onoff_key", "off");
    }

    /* renamed from: Yp */
    public void mo26207Yp() {
        if (this.bYA.hasMessages(4099)) {
            this.bYA.removeMessages(4099);
        }
        if (this.bYA.hasMessages(4100)) {
            this.bYA.removeMessages(4100);
        }
        this.bYx.clearAnimation();
        this.bYy.clearAnimation();
        this.bYz.setText("");
        this.bYx.setText(String.valueOf(this.bYv));
        this.bYy.setText(String.valueOf(this.bYv));
        this.bYB = (this.bYv * 100) / 10;
        if (!isShown()) {
            setVisibility(0);
            startAnimation(this.bYs);
        }
        this.bYu = false;
        C5008i.m12937VU().mo25633cI(this.bYu);
    }

    /* renamed from: Yq */
    public void mo26208Yq() {
        this.bYx.setText("");
        this.bYy.setText("");
        this.bYz.setText("");
        setVisibility(4);
        this.bYu = false;
        C5008i.m12937VU().mo25633cI(this.bYu);
    }

    /* renamed from: Yr */
    public boolean mo26209Yr() {
        return this.bYu;
    }

    /* renamed from: Ys */
    public void mo26210Ys() {
        if (!this.bYu) {
            this.bYu = true;
            C5008i.m12937VU().mo25633cI(this.bYu);
            this.bYA.sendEmptyMessage(4100);
        }
    }

    /* renamed from: a */
    public void mo26211a(C5178b bVar) {
        this.bYv = AppPreferencesSetting.getInstance().getAppSettingInt("pref_timer_onoff_value_key", 3);
        this.bTI = bVar;
    }

    /* renamed from: am */
    public void mo26212am(long j) {
        this.bYA.sendEmptyMessageDelayed(4099, j);
    }

    /* renamed from: fg */
    public void mo26213fg(String str) {
        this.bYx.clearAnimation();
        this.bYy.clearAnimation();
        this.bYx.setText("");
        this.bYy.setText("");
        this.bYz.setText(str);
        if (!isShown()) {
            setVisibility(0);
            startAnimation(this.bYs);
        }
    }

    public int getTimerValue() {
        return AppPreferencesSetting.getInstance().getAppSettingInt("pref_timer_onoff_value_key", 3);
    }

    public void onClick(View view) {
        try {
            if (this.bTI != null) {
                int index = getIndex(this.bYv) + 1;
                if (index >= bYw.length) {
                    index = 0;
                }
                this.bYv = bYw[index];
                AppPreferencesSetting.getInstance().setAppSettingInt("pref_timer_onoff_value_key", this.bYv);
                this.bTI.mo25958jw(this.bYv);
                mo26207Yp();
            }
        } catch (Exception unused) {
        }
    }

    public void reset() {
        this.bYv = 3;
        AppPreferencesSetting.getInstance().setAppSettingInt("pref_timer_onoff_value_key", this.bYv);
    }

    public void setPortrait(boolean z) {
        this.bPL = z;
        if (this.bPL) {
            this.bYx.setDegree(0);
            this.bYy.setDegree(0);
            return;
        }
        this.bYx.setDegree(QDisplayContext.DISPLAY_ROTATION_270);
        this.bYy.setDegree(QDisplayContext.DISPLAY_ROTATION_270);
    }

    public void setTimer(int i) {
        this.bYu = true;
        setVisibility(0);
        int i2 = i + 1;
        if (i == this.bYv) {
            i2 = i;
        }
        this.bYx.setText(String.valueOf(i2));
        this.bYy.setText(String.valueOf(i));
        if (i != this.bYv) {
            this.bYx.startAnimation(this.bYr);
            this.bYy.startAnimation(this.bYq);
        }
    }
}
