package com.introvd.template.editor.preview.theme;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4580b;

public class ThemeAudioTrackMixView extends RelativeLayout {
    public int bYB = 0;
    private OnSeekBarChangeListener cMI = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            ThemeAudioTrackMixView.this.m19349oK(i);
            ThemeAudioTrackMixView.this.bYB = 100 - i;
            if (ThemeAudioTrackMixView.this.dbh != null) {
                ThemeAudioTrackMixView.this.dbh.mo29916oB(ThemeAudioTrackMixView.this.bYB);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ThemeAudioTrackMixView.this.m19348gP(true);
            int progress = seekBar.getProgress();
            ThemeAudioTrackMixView.this.bYB = 100 - progress;
            ThemeAudioTrackMixView.this.m19349oK(progress);
            if (ThemeAudioTrackMixView.this.dbh != null) {
                ThemeAudioTrackMixView.this.dbh.apt();
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ThemeAudioTrackMixView.this.m19348gP(false);
            int progress = seekBar.getProgress();
            ThemeAudioTrackMixView.this.bYB = 100 - progress;
            ThemeAudioTrackMixView.this.m19349oK(progress);
            if (ThemeAudioTrackMixView.this.dbh != null) {
                ThemeAudioTrackMixView.this.dbh.mo29916oB(ThemeAudioTrackMixView.this.bYB);
            }
        }
    };
    /* access modifiers changed from: private */
    public C6655a dbh;
    private SeekBar dcX;
    /* access modifiers changed from: private */
    public ImageView dcY;
    /* access modifiers changed from: private */
    public ImageView dcZ;
    private RelativeLayout dda;
    private RelativeLayout ddb;
    private TextView ddc;
    private TextView ddd;
    /* access modifiers changed from: private */
    public int dde;
    /* access modifiers changed from: private */
    public int ddf;
    private Context mContext;

    /* renamed from: po */
    private OnClickListener f3512po = new OnClickListener() {
        public void onClick(View view) {
            if (!C4580b.m11632Sf()) {
                boolean z = false;
                if (ThemeAudioTrackMixView.this.dcY.equals(view)) {
                    if (ThemeAudioTrackMixView.this.dde != 2) {
                        ThemeAudioTrackMixView.this.dde = ThemeAudioTrackMixView.this.dde == 1 ? 0 : 1;
                        ThemeAudioTrackMixView.this.dcY.setImageResource(ThemeAudioTrackMixView.this.m19345cO(0, ThemeAudioTrackMixView.this.dde));
                        if (ThemeAudioTrackMixView.this.dbh != null) {
                            C6655a c = ThemeAudioTrackMixView.this.dbh;
                            if (ThemeAudioTrackMixView.this.dde == 1) {
                                z = true;
                            }
                            c.mo29914gD(z);
                        }
                    }
                } else if (ThemeAudioTrackMixView.this.dcZ.equals(view) && ThemeAudioTrackMixView.this.ddf != 2) {
                    ThemeAudioTrackMixView.this.ddf = ThemeAudioTrackMixView.this.ddf == 1 ? 0 : 1;
                    ThemeAudioTrackMixView.this.dcZ.setImageResource(ThemeAudioTrackMixView.this.m19345cO(1, ThemeAudioTrackMixView.this.ddf));
                    if (ThemeAudioTrackMixView.this.dbh != null) {
                        C6655a c2 = ThemeAudioTrackMixView.this.dbh;
                        if (ThemeAudioTrackMixView.this.ddf == 1) {
                            z = true;
                        }
                        c2.mo29915gE(z);
                    }
                }
            }
        }
    };

    /* renamed from: com.introvd.template.editor.preview.theme.ThemeAudioTrackMixView$a */
    public interface C6655a {
        void apt();

        /* renamed from: gD */
        void mo29914gD(boolean z);

        /* renamed from: gE */
        void mo29915gE(boolean z);

        /* renamed from: oB */
        void mo29916oB(int i);
    }

    public ThemeAudioTrackMixView(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public ThemeAudioTrackMixView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public ThemeAudioTrackMixView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    private boolean aqq() {
        return (this.ddf == 0 || this.dde == 0) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: cO */
    public int m19345cO(int i, int i2) {
        switch (i2) {
            case 0:
                return i == 0 ? R.drawable.editor_icon_tool_mute_on : R.drawable.editor_icon_music_on_tool;
            case 1:
                return i == 0 ? R.drawable.editor_icon_tool_mute_off : R.drawable.editor_icon_music_off_tool;
            case 2:
                return i == 0 ? R.drawable.editor_icon_tool_mute_off : R.drawable.editor_icon_music_off_tool;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gP */
    public void m19348gP(boolean z) {
        if (z) {
            if (this.ddf == 0) {
                this.dcZ.setVisibility(4);
                this.ddb.setVisibility(0);
            }
            if (this.dde == 0) {
                this.dcY.setVisibility(4);
                this.dda.setVisibility(0);
                return;
            }
            return;
        }
        this.dcY.setVisibility(0);
        this.dda.setVisibility(4);
        this.dcZ.setVisibility(0);
        this.ddb.setVisibility(4);
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.editor_theme_audiomix_layout, this, true);
        this.dcX = (SeekBar) findViewById(R.id.seekbar_audio_track_mix);
        this.dcX.setOnSeekBarChangeListener(this.cMI);
        this.dcY = (ImageView) findViewById(R.id.imgview_icon_video);
        this.dcZ = (ImageView) findViewById(R.id.imgview_icon_bgm);
        this.dcY.setOnClickListener(this.f3512po);
        this.dcZ.setOnClickListener(this.f3512po);
        this.dda = (RelativeLayout) findViewById(R.id.layout_txts_video);
        this.ddb = (RelativeLayout) findViewById(R.id.layout_txts_bgm);
        this.ddc = (TextView) findViewById(R.id.txtview_video_value);
        this.ddd = (TextView) findViewById(R.id.txtview_value);
    }

    /* access modifiers changed from: private */
    /* renamed from: oK */
    public void m19349oK(int i) {
        TextView textView = this.ddc;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("%");
        textView.setText(sb.toString());
        TextView textView2 = this.ddd;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(100 - i);
        sb2.append("%");
        textView2.setText(sb2.toString());
    }

    /* renamed from: C */
    public void mo30040C(int i, int i2, int i3) {
        this.ddf = i2;
        this.dde = i;
        this.dcY.setImageResource(m19345cO(0, this.dde));
        this.dcZ.setImageResource(m19345cO(1, this.ddf));
        this.bYB = i3;
        m19349oK(100 - this.bYB);
        this.dcX.setProgress(100 - this.bYB);
        this.dcX.setEnabled(!aqq());
        if (!aqq()) {
            this.dcX.setThumb(getResources().getDrawable(R.drawable.editor_layer_seekbar_thumb_white_hollow_18));
        } else {
            this.dcX.setThumb(getResources().getDrawable(R.drawable.editor_layer_seekbar_thumb_white_hollow_18));
        }
        this.dcX.invalidate();
    }

    public void setImageViewBgmAudioIconEnable() {
        if (!(this.dcZ == null || this.ddf == 0 || this.ddf == 2)) {
            boolean z = false;
            this.ddf = 0;
            this.dcZ.setImageResource(m19345cO(1, this.ddf));
            if (this.dbh != null) {
                C6655a aVar = this.dbh;
                if (this.ddf == 1) {
                    z = true;
                }
                aVar.mo29915gE(z);
            }
        }
    }

    public void setmOnMixChangeListener(C6655a aVar) {
        this.dbh = aVar;
    }
}
