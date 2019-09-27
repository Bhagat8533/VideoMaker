package com.introvd.template.editor.effects;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.support.p021v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.editor.widget.timeline.C7116a;
import com.introvd.template.editor.widget.timeline.C7124b;
import com.introvd.template.editor.widget.timeline.C7133g;
import com.introvd.template.editor.widget.timeline.VeGallery2;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4580b;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import xiaoying.engine.storyboard.QStoryboard;

public class ColorfulSeekLayout extends LinearLayout {
    private QStoryboard cFJ;
    private TextView cGe;
    /* access modifiers changed from: private */
    public TextView cGf;
    private ImageView cGg;
    private ImageView cGh;
    private ImageView cGi;
    private C7116a cGj;
    /* access modifiers changed from: private */
    public boolean cGk;
    private C6499a cGl;
    /* access modifiers changed from: private */
    public C5910b cGm;
    private boolean cGn;
    private boolean cGo;
    private boolean cGp;
    /* access modifiers changed from: private */
    public C7124b cGq;
    C5687a cGr;
    BroadcastReceiver cGs;
    private MSize css;

    public ColorfulSeekLayout(Context context) {
        this(context, null);
    }

    public ColorfulSeekLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorfulSeekLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGk = false;
        this.cGn = true;
        this.cGo = true;
        this.cGp = true;
        this.cGs = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                LogUtilsV2.m14227d("receive ");
                ColorfulSeekLayout.this.aip();
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorfulSeekLayout);
            this.cGo = obtainStyledAttributes.getBoolean(R.styleable.ColorfulSeekLayout_timeLineAddable, true);
            this.cGp = obtainStyledAttributes.getBoolean(R.styleable.ColorfulSeekLayout_playable, true);
            obtainStyledAttributes.recycle();
        }
        m16425Oj();
    }

    /* renamed from: Oj */
    private void m16425Oj() {
        C10021c.aZH().mo38494ax(this);
        m16426Pw();
        LayoutInflater.from(getContext()).inflate(R.layout.editor_colorful_seek_bar, this, true);
        this.cGf = (TextView) findViewById(R.id.video_editor_seek_current_time);
        this.cGe = (TextView) findViewById(R.id.video_editor_seek_duration);
        this.cGg = (ImageView) findViewById(R.id.video_editor_seek_play);
        this.cGi = (ImageView) findViewById(R.id.video_editor_effect_add_clip);
        this.cGh = (ImageView) findViewById(R.id.bg_add_clip_btn);
        int i = 8;
        this.cGi.setVisibility(this.cGo ? 0 : 8);
        this.cGh.setVisibility(this.cGo ? 0 : 8);
        ImageView imageView = this.cGg;
        if (this.cGp) {
            i = 0;
        }
        imageView.setVisibility(i);
        this.cGg.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ColorfulSeekLayout.this.cGm != null) {
                    if (ColorfulSeekLayout.this.cGk) {
                        ColorfulSeekLayout.this.cGm.pauseVideo();
                    } else {
                        ColorfulSeekLayout.this.cGm.aav();
                    }
                } else if (ColorfulSeekLayout.this.cGk) {
                    ColorfulSeekLayout.this.pauseVideo();
                } else {
                    ColorfulSeekLayout.this.aav();
                }
            }
        });
        this.cGi.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
    }

    /* renamed from: Pw */
    private void m16426Pw() {
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.cGs, new IntentFilter(C8048e.aBe().mo23625Mq()));
    }

    private void abZ() {
        if (this.cFJ != null && this.css != null) {
            this.cGj = new C7116a((VeGallery2) findViewById(R.id.video_editor_seek_gallery), this.cFJ.getDuration(), null, null);
            this.cGj.setmState(2);
            this.cGj.mo31553hP(true);
            this.cGj.setmOnTimeLineSeekListener(new C7124b() {
                /* renamed from: a */
                public boolean mo28344a(int i, Range range) {
                    return ColorfulSeekLayout.this.cGq != null && ColorfulSeekLayout.this.cGq.mo28344a(i, range);
                }

                public void acD() {
                    if (ColorfulSeekLayout.this.cGq != null) {
                        ColorfulSeekLayout.this.cGq.acD();
                    }
                }

                public void acd() {
                    if (ColorfulSeekLayout.this.cGq != null) {
                        ColorfulSeekLayout.this.cGq.acd();
                    }
                }

                /* renamed from: dY */
                public void mo28347dY(boolean z) {
                    if (ColorfulSeekLayout.this.cGq != null) {
                        ColorfulSeekLayout.this.cGq.mo28347dY(z);
                    }
                }

                /* renamed from: dZ */
                public void mo28348dZ(boolean z) {
                    if (ColorfulSeekLayout.this.cGq != null) {
                        ColorfulSeekLayout.this.cGq.mo28348dZ(z);
                    }
                }

                /* renamed from: iD */
                public void mo28349iD(int i) {
                    if (ColorfulSeekLayout.this.cGq != null) {
                        ColorfulSeekLayout.this.cGq.mo28349iD(i);
                    }
                    if (ColorfulSeekLayout.this.cGf != null) {
                        ColorfulSeekLayout.this.cGf.setText(C4580b.m11637V((long) i));
                    }
                }

                /* renamed from: kM */
                public void mo28350kM(int i) {
                    if (ColorfulSeekLayout.this.cGq != null) {
                        ColorfulSeekLayout.this.cGq.mo28350kM(i);
                    }
                }

                /* renamed from: kN */
                public int mo28351kN(int i) {
                    if (ColorfulSeekLayout.this.cGq != null) {
                        return ColorfulSeekLayout.this.cGq.mo28351kN(i);
                    }
                    return 0;
                }

                /* renamed from: kz */
                public void mo28352kz(int i) {
                    if (ColorfulSeekLayout.this.cGq != null) {
                        ColorfulSeekLayout.this.cGq.mo28352kz(i);
                    }
                }
            });
        }
    }

    private void aio() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.cGs);
    }

    private boolean ais() {
        return this.cGj != null;
    }

    /* renamed from: J */
    public void mo28315J(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerReady progress = ");
        sb.append(i);
        LogUtilsV2.m14227d(sb.toString());
        if (ais() && !z) {
            this.cGj.mo31544c(i, true, false);
        }
        if (this.cGf != null) {
            this.cGf.setText(C4580b.m11637V((long) i));
        }
    }

    /* renamed from: K */
    public void mo28316K(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerPlaying progress = ");
        sb.append(i);
        sb.append(",isUserSeeking = ");
        sb.append(z);
        LogUtilsV2.m14227d(sb.toString());
        if (!this.cGk) {
            mo28330fd(true);
        }
        if (this.cGj != null && !z) {
            this.cGj.mo31566qs(0);
            this.cGj.mo31544c(i, true, false);
            if (this.cGf != null) {
                this.cGf.setText(C4580b.m11637V((long) i));
            }
        }
    }

    /* renamed from: L */
    public void mo28317L(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerPause progress = ");
        sb.append(i);
        sb.append(",isUserSeeking = ");
        sb.append(z);
        LogUtilsV2.m14227d(sb.toString());
        if (this.cGj != null && !z) {
            this.cGj.mo31544c(i, true, false);
            if (this.cGf != null) {
                this.cGf.setText(C4580b.m11637V((long) i));
            }
        }
        mo28330fd(false);
    }

    /* renamed from: M */
    public void mo28318M(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerStop progress = ");
        sb.append(i);
        sb.append(",isUserSeeking = ");
        sb.append(z);
        LogUtilsV2.m14227d(sb.toString());
        if (this.cGj != null && !z) {
            this.cGj.mo31544c(i, true, true);
            if (this.cGf != null) {
                this.cGf.setText(C4580b.m11637V((long) i));
            }
        }
        mo28330fd(false);
    }

    /* renamed from: a */
    public void mo28319a(QStoryboard qStoryboard, MSize mSize) {
        this.cFJ = qStoryboard;
        this.css = mSize;
        abZ();
        this.cGf.setText(C4580b.m11637V(0));
        aip();
    }

    public void aav() {
        if (this.cGl != null) {
            this.cGl.aoh();
        }
    }

    public void aeu() {
        if (this.cGr != null) {
            this.cGr.mo27875fS(true);
        }
    }

    public int aev() {
        return this.cGj.acp();
    }

    public void aew() {
        if (this.cGr != null) {
            this.cGr.mo27875fS(false);
        }
    }

    public void aip() {
        this.cGe.setTextColor(getResources().getColor(R.color.color_8E8E93));
        if (this.cFJ != null) {
            this.cGe.setText(C4580b.m11637V((long) this.cFJ.getDuration()));
            if (this.cFJ.getDuration() >= 300000 && !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId())) {
                this.cGe.setTextColor(getResources().getColor(R.color.color_FF2E0E));
            }
        }
    }

    public void aiq() {
        if (this.cGj != null && this.cFJ != null) {
            this.cGj.mo31560q(this.cFJ);
        }
    }

    public void air() {
        if (this.cGj != null) {
            this.cGj.invalidate();
        }
    }

    public boolean ait() {
        return this.cGn;
    }

    /* renamed from: b */
    public void mo28328b(C5687a aVar) {
        this.cGr = aVar;
        LogUtilsV2.m14227d("init");
    }

    public void destroy() {
        if (this.cGj != null) {
            this.cGj.destroy();
        }
        C10021c.aZH().mo38496az(this);
        aio();
    }

    /* renamed from: fd */
    public void mo28330fd(boolean z) {
        this.cGk = z;
        if (z) {
            this.cGg.setImageResource(R.drawable.v5_xiaoying_ve_preview_pause_btn);
        } else {
            this.cGg.setImageResource(R.drawable.v5_xiaoying_ve_preview_play_btn);
        }
    }

    public int getCurrentTime() {
        if (this.cGj == null) {
            return 0;
        }
        return this.cGj.acp();
    }

    public int getDuration() {
        if (this.cGj == null) {
            return 0;
        }
        return this.cGj.avu();
    }

    /* renamed from: hV */
    public int mo28333hV(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.cGj == null) {
            return i;
        }
        if (!this.cGj.avA()) {
            i = this.cGj.mo31555kF(i);
        }
        return i;
    }

    /* renamed from: lb */
    public void mo28334lb(int i) {
        this.cGj.mo31544c(i, true, false);
        if (this.cGf != null) {
            this.cGf.setText(C4580b.m11637V((long) i));
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7133g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onEventMainThread TimelineThumbnailEvent iCurDecodeIdentifier = ");
        sb.append(gVar.dwf);
        LogUtilsV2.m14227d(sb.toString());
        if (this.cGj != null) {
            this.cGj.mo31556kG(gVar.dwf);
        }
    }

    public void pauseVideo() {
        if (this.cGl != null) {
            this.cGl.aoi();
        }
    }

    public void setOnAddClipBtnClickListener(C2582a<View> aVar) {
        if (this.cGi != null) {
            C2579b.m7399a(aVar, this.cGi);
        }
    }

    public void setOnOperationCallback(C6499a aVar) {
        this.cGl = aVar;
    }

    public void setOnVideoEditorSeekListener(C5910b bVar) {
        this.cGm = bVar;
    }

    public void setQStoryboard(QStoryboard qStoryboard) {
        this.cFJ = qStoryboard;
    }

    public void setmOnTimeLineSeekListener(C7124b bVar) {
        this.cGq = bVar;
    }
}
