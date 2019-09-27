package com.introvd.template.camera.p233ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.TimerImageView */
public class TimerImageView extends ImageView {
    /* access modifiers changed from: private */

    /* renamed from: Kj */
    public int f3423Kj = 0;
    /* access modifiers changed from: private */
    public C5043a bSk;
    /* access modifiers changed from: private */
    public int[] bSl = {10, 11, 12, 13};
    /* access modifiers changed from: private */
    public int[] bSm = {R.drawable.v5_xiaoying_cam_timer_0s, R.drawable.v5_xiaoying_cam_timer_3s, R.drawable.v5_xiaoying_cam_timer_5s, R.drawable.v5_xiaoying_cam_timer_10s};

    /* renamed from: com.introvd.template.camera.ui.TimerImageView$a */
    public interface C5043a {
        /* renamed from: js */
        void mo25907js(int i);
    }

    public TimerImageView(Context context) {
        super(context);
        initState();
    }

    public TimerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initState();
    }

    public TimerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initState();
    }

    private void initState() {
        setImageResource(this.bSm[this.f3423Kj]);
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TimerImageView.this.f3423Kj = (TimerImageView.this.f3423Kj + 1) % TimerImageView.this.bSl.length;
                int i = TimerImageView.this.bSl[TimerImageView.this.f3423Kj];
                TimerImageView.this.setImageResource(TimerImageView.this.bSm[TimerImageView.this.f3423Kj]);
                if (TimerImageView.this.bSk != null) {
                    TimerImageView.this.bSk.mo25907js(i);
                }
            }
        });
    }

    public void setmOnTimerModeChangeListener(C5043a aVar) {
        this.bSk = aVar;
    }
}
