package com.introvd.template.editor.preview.theme.duration;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.editor.R;
import com.introvd.template.sdk.utils.C8572y;

public class SeekBarDuration extends RelativeLayout {
    private OnSeekBarChangeListener cMI = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            SeekBarDuration.this.mo30055oN(i);
            if (SeekBarDuration.this.ddk != null) {
                SeekBarDuration.this.ddk.agf();
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (SeekBarDuration.this.ddk != null) {
                SeekBarDuration.this.ddk.agg();
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (SeekBarDuration.this.ddk != null) {
                SeekBarDuration.this.ddk.agh();
            }
        }
    };
    private TextView ddh;
    private TextView ddi;
    private SeekBar ddj;
    /* access modifiers changed from: private */
    public C6666a ddk;

    /* renamed from: com.introvd.template.editor.preview.theme.duration.SeekBarDuration$a */
    public interface C6666a {
        void agf();

        void agg();

        void agh();
    }

    public SeekBarDuration(Context context) {
        super(context);
        m19375dp(context);
    }

    public SeekBarDuration(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19375dp(context);
    }

    /* renamed from: dp */
    private void m19375dp(Context context) {
        LayoutInflater.from(context).inflate(R.layout.editor_clip_seekbar_duration_layout, this, true);
        this.ddh = (TextView) findViewById(R.id.tvThemeDurationTime);
        this.ddi = (TextView) findViewById(R.id.maxTv);
        this.ddj = (SeekBar) findViewById(R.id.seekbar_theme_duration);
        this.ddj.setOnSeekBarChangeListener(this.cMI);
        if (C3742b.m9111II().mo23143JK()) {
            this.ddj.setMax(300);
            this.ddi.setText("30s");
        }
    }

    public int getProgress() {
        return this.ddj.getProgress();
    }

    /* renamed from: oL */
    public int mo30053oL(int i) {
        float f = ((float) i) / 1000.0f;
        if (C8572y.m25061O(0.1f, f) || this.ddj == null) {
            return 0;
        }
        for (int i2 = 1; i2 <= this.ddj.getMax(); i2++) {
            if (C8572y.m25061O(((float) i2) * 0.1f, f)) {
                return i2;
            }
        }
        return 30;
    }

    /* renamed from: oM */
    public float mo30054oM(int i) {
        if (i <= 1) {
            return 0.1f;
        }
        return ((float) i) / 10.0f;
    }

    /* renamed from: oN */
    public void mo30055oN(int i) {
        if (i <= 1) {
            this.ddh.setText("0.1");
            return;
        }
        float f = ((float) i) / 10.0f;
        TextView textView = this.ddh;
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        sb.append("");
        textView.setText(sb.toString());
    }

    public void setOnSeekBarChangeListener(C6666a aVar) {
        this.ddk = aVar;
    }

    public void setProgress(int i) {
        this.ddj.setProgress(i);
    }

    public void setTvDuration(int i) {
        mo30055oN(i);
    }
}
