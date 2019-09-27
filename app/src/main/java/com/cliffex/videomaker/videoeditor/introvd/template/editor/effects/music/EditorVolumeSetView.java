package com.introvd.template.editor.effects.music;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4583d;

public class EditorVolumeSetView extends RelativeLayout {
    private OnSeekBarChangeListener cMI = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            EditorVolumeSetView.this.m17680nc(i);
            EditorVolumeSetView.this.m17681ni(i);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            EditorVolumeSetView.this.cMT.setVisibility(0);
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            EditorVolumeSetView.this.m17680nc(seekBar.getProgress());
            EditorVolumeSetView.this.cMT.setVisibility(4);
            if (EditorVolumeSetView.this.cMV != null) {
                EditorVolumeSetView.this.cMV.mo28584mu(seekBar.getProgress());
            }
        }
    };
    private SeekBar cMS;
    /* access modifiers changed from: private */
    public TextView cMT;
    private TextView cMU;
    /* access modifiers changed from: private */
    public C6176a cMV;
    private int cMW;
    private int cMX;
    private int cMY;
    private Context mContext;

    /* renamed from: com.introvd.template.editor.effects.music.EditorVolumeSetView$a */
    public interface C6176a {
        /* renamed from: mu */
        void mo28584mu(int i);
    }

    public EditorVolumeSetView(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public EditorVolumeSetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public EditorVolumeSetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.editor_volume_setting_layout, this, true);
        this.cMS = (SeekBar) findViewById(R.id.seekbar_editor_effect_audio_volume);
        this.cMS.setOnSeekBarChangeListener(this.cMI);
        this.cMT = (TextView) findViewById(R.id.tv_editor_effect_audio_volume_tip);
        this.cMU = (TextView) findViewById(R.id.tv_editor_effect_audio_volume);
    }

    /* access modifiers changed from: private */
    /* renamed from: nc */
    public void m17680nc(int i) {
        TextView textView = this.cMT;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("%");
        textView.setText(sb.toString());
        TextView textView2 = this.cMU;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append("%");
        textView2.setText(sb2.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: ni */
    public void m17681ni(int i) {
        LayoutParams layoutParams = (LayoutParams) this.cMT.getLayoutParams();
        layoutParams.setMargins(m17682nj(i) - (this.cMT.getWidth() / 2), 0, 0, 0);
        this.cMT.setLayoutParams(layoutParams);
    }

    /* renamed from: nj */
    private int m17682nj(int i) {
        if (this.cMW == 0) {
            this.cMW = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        if (this.cMX == 0) {
            this.cMX = this.cMW - C4583d.m11670O(getContext(), 110);
        }
        if (this.cMY == 0) {
            this.cMY = C4583d.m11670O(getContext(), 47);
        }
        return this.cMY + ((this.cMX * i) / 100);
    }

    public int getProgress() {
        return this.cMS.getProgress();
    }

    /* renamed from: nh */
    public void mo28980nh(int i) {
        this.cMS.setProgress(i);
        m17680nc(i);
        m17681ni(i);
    }

    public void setVolumeSetListener(C6176a aVar) {
        this.cMV = aVar;
    }
}
