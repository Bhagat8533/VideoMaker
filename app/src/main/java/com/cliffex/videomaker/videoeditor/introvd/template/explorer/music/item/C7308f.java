package com.introvd.template.explorer.music.item;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.explorer.music.p305c.C7272a;
import com.introvd.template.explorer.p308ui.RangeLogicSeekBar;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import com.introvd.template.vivaexplorermodule.R;
import com.introvd.template.xyui.audiowave.RangeSeekBarV4;
import com.introvd.template.xyui.audiowave.RangeSeekBarV4.C9159b;

/* renamed from: com.introvd.template.explorer.music.item.f */
public class C7308f {
    public int dBW;
    public int dBX;
    /* access modifiers changed from: private */
    public C7302d dBY;
    private ViewStub dBZ;
    /* access modifiers changed from: private */
    public View dCa;
    private RangeLogicSeekBar dCb;
    private ImageView dCc;
    private C9159b<Integer> dbg = new C9159b<Integer>() {
        boolean dCe;
        volatile boolean dCf = false;

        /* renamed from: a */
        public void mo29912b(RangeSeekBarV4<?> rangeSeekBarV4, Integer num, Integer num2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin Trim Control onRangeSeekBarValuesChanged minValue = ");
            sb.append(num);
            sb.append(" , maxValue = ");
            sb.append(num2);
            LogUtilsV2.m14227d(sb.toString());
            if (C7308f.this.dBY != null) {
                if (num.intValue() != C7308f.this.dBW || C7308f.this.dBX != num2.intValue()) {
                    C7308f.this.dBW = num.intValue();
                    C7308f.this.dBX = num2.intValue();
                    C7272a.m21451a(C7308f.this.dBY.awP(), (DBTemplateAudioInfo) C7308f.this.dBY.getItemData(), this.dCe ? 4 : 5, C7308f.this.dBW, C7308f.this.dBX);
                    C7308f.this.dBY.dBA = 3;
                    C7308f.this.dBY.mo31919qQ(3);
                }
            }
        }

        /* renamed from: a */
        public void mo29910a(RangeSeekBarV4<?> rangeSeekBarV4, boolean z) {
            this.dCe = z;
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin Trim Control onRangeSeekBarTrackStart isLeft = ");
            sb.append(z);
            LogUtilsV2.m14227d(sb.toString());
        }

        /* renamed from: b */
        public void mo29909a(RangeSeekBarV4<?> rangeSeekBarV4, Integer num, Integer num2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin Trim Control onRangeSeekBarValuesChange minValue = ");
            sb.append(num);
            sb.append(" , maxValue = ");
            sb.append(num2);
            LogUtilsV2.m14227d(sb.toString());
            if (num2.intValue() - num.intValue() <= 1000 && !this.dCf) {
                this.dCf = true;
                if (C7308f.this.dCa != null) {
                    ToastUtils.show(C7308f.this.dCa.getContext(), R.string.xiaoying_str_ve_msg_music_len_invalid, 0);
                }
            }
            if (num2.intValue() - num.intValue() > 1000) {
                this.dCf = false;
            }
        }
    };
    public int duration;

    public C7308f(C7302d dVar) {
        if (dVar != null) {
            this.dBY = dVar;
            this.duration = ((DBTemplateAudioInfo) dVar.getItemData()).duration;
            this.dBW = 0;
            this.dBX = this.duration;
        }
    }

    private void init() {
        if (this.dBZ != null) {
            if (this.dBZ.getTag() == this) {
                LogUtilsV2.m14227d("Jamin same one no need init");
                return;
            }
            LogUtilsV2.m14227d("Jamin need init");
            this.dBZ.setTag(this);
            if (this.dCa == null) {
                try {
                    this.dCa = this.dBZ.inflate();
                } catch (IllegalStateException unused) {
                }
            }
            if (this.dCa != null) {
                this.dCb = (RangeLogicSeekBar) this.dCa.findViewById(R.id.music_item_play_seek_bar);
                this.dCc = (ImageView) this.dCa.findViewById(R.id.music_item_play_state);
                this.dCb.setOnRangeSeekBarChangeListener(this.dbg);
                this.dCb.mo36124a(Integer.valueOf(0), Integer.valueOf(this.duration), 1000.0d);
                this.dCb.setSelectedMinValue(Integer.valueOf(this.dBW));
                this.dCb.setSelectedMaxValue(Integer.valueOf(this.dBX));
                this.dCc.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (C7308f.this.dBY != null) {
                            C7308f.this.dBY.axv();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void mo31929a(ViewStub viewStub, View view) {
        this.dBZ = viewStub;
        this.dCa = view;
    }

    /* renamed from: qS */
    public void mo31930qS(int i) {
        if (this.dCb != null) {
            this.duration = i;
            this.dBX = i;
            this.dBW = 0;
            this.dCb.mo36124a(Integer.valueOf(0), Integer.valueOf(i), 1000.0d);
            this.dCb.setSelectedMinValue(Integer.valueOf(this.dBW));
            this.dCb.setSelectedMaxValue(Integer.valueOf(this.dBX));
        }
    }

    /* renamed from: qT */
    public void mo31931qT(int i) {
        if (this.dBY != null) {
            if (i != 1) {
                switch (i) {
                    case 3:
                        init();
                        if (this.dCa != null && this.dCc != null) {
                            if (!this.dBY.isDownloaded()) {
                                this.dCa.setVisibility(8);
                                break;
                            } else {
                                this.dCa.setVisibility(0);
                                this.dCc.setImageResource(R.drawable.xiaoying_music_item_pause);
                                break;
                            }
                        } else {
                            return;
                        }
                    case 4:
                        init();
                        if (this.dCa != null && this.dCc != null) {
                            if (!this.dBY.isDownloaded()) {
                                this.dCa.setVisibility(8);
                                break;
                            } else {
                                this.dCa.setVisibility(0);
                                this.dCc.setImageResource(R.drawable.xiaoying_music_item_play);
                                break;
                            }
                        } else {
                            return;
                        }
                }
            } else if (this.dCa != null) {
                this.dCa.setVisibility(8);
            }
        }
    }

    public void updateProgress(int i) {
        if (this.dCb != null) {
            this.dCb.setProgressValue(Integer.valueOf(i));
        }
    }
}
