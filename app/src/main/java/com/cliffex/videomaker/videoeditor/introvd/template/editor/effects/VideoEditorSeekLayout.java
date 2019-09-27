package com.introvd.template.editor.effects;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
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
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.editor.widget.timeline.C7116a;
import com.introvd.template.editor.widget.timeline.C7124b;
import com.introvd.template.editor.widget.timeline.C7131e;
import com.introvd.template.editor.widget.timeline.C7133g;
import com.introvd.template.editor.widget.timeline.VeGallery2;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.sdk.editor.C8418a;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.p394b.C8530i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import xiaoying.engine.storyboard.QStoryboard;

public class VideoEditorSeekLayout extends LinearLayout {
    private C5686a cGL;
    /* access modifiers changed from: private */
    public C7131e cGM;
    /* access modifiers changed from: private */
    public boolean cGN = false;
    C7124b cGO = new C7124b() {
        /* renamed from: a */
        public boolean mo28344a(int i, Range range) {
            return VideoEditorSeekLayout.this.cGq != null && VideoEditorSeekLayout.this.cGq.mo28344a(i, range);
        }

        public void acD() {
            if (VideoEditorSeekLayout.this.cGq != null) {
                VideoEditorSeekLayout.this.cGq.acD();
            }
            if (VideoEditorSeekLayout.this.cGM != null) {
                VideoEditorSeekLayout.this.cGM.akT();
            }
        }

        public void acd() {
            if (VideoEditorSeekLayout.this.cGq != null) {
                VideoEditorSeekLayout.this.cGq.acd();
            }
        }

        /* renamed from: dY */
        public void mo28347dY(boolean z) {
            if (VideoEditorSeekLayout.this.cGq != null) {
                VideoEditorSeekLayout.this.cGq.mo28347dY(z);
            }
        }

        /* renamed from: dZ */
        public void mo28348dZ(boolean z) {
            if (VideoEditorSeekLayout.this.cGq != null) {
                VideoEditorSeekLayout.this.cGq.mo28348dZ(z);
            }
        }

        /* renamed from: iD */
        public void mo28349iD(int i) {
            if (VideoEditorSeekLayout.this.cGq != null) {
                VideoEditorSeekLayout.this.cGq.mo28349iD(i);
            }
            if (VideoEditorSeekLayout.this.cGf != null) {
                VideoEditorSeekLayout.this.cGf.setText(C4580b.m11637V((long) i));
            }
        }

        /* renamed from: kM */
        public void mo28350kM(int i) {
            if (VideoEditorSeekLayout.this.cGq != null) {
                VideoEditorSeekLayout.this.cGq.mo28350kM(i);
            }
        }

        /* renamed from: kN */
        public int mo28351kN(int i) {
            if (VideoEditorSeekLayout.this.cGq != null) {
                return VideoEditorSeekLayout.this.cGq.mo28351kN(i);
            }
            return 0;
        }

        /* renamed from: kz */
        public void mo28352kz(int i) {
            if (VideoEditorSeekLayout.this.cGq != null) {
                VideoEditorSeekLayout.this.cGq.mo28352kz(i);
            }
        }
    };
    private TextView cGe;
    /* access modifiers changed from: private */
    public TextView cGf;
    private ImageView cGg;
    private C7116a cGj;
    /* access modifiers changed from: private */
    public boolean cGk = false;
    private C6499a cGl;
    /* access modifiers changed from: private */
    public C5910b cGm;
    private boolean cGn = true;
    /* access modifiers changed from: private */
    public C7124b cGq;
    C5687a cGr;
    BroadcastReceiver cGs = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            LogUtilsV2.m14230i("receive ");
            VideoEditorSeekLayout.this.aip();
        }
    };
    private volatile ArrayList<C8441b> csv = null;

    public VideoEditorSeekLayout(Context context) {
        super(context);
        m16467Oj();
    }

    public VideoEditorSeekLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16467Oj();
    }

    public VideoEditorSeekLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16467Oj();
    }

    /* renamed from: Oj */
    private void m16467Oj() {
        C10021c.aZH().mo38494ax(this);
        m16468Pw();
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.editor_main_seek_bar_layout, this, true);
        this.cGf = (TextView) findViewById(R.id.video_editor_seek_current_time);
        this.cGe = (TextView) findViewById(R.id.video_editor_seek_duration);
        this.cGg = (ImageView) findViewById(R.id.video_editor_seek_play);
        this.cGg.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!VideoEditorSeekLayout.this.cGN) {
                    if (VideoEditorSeekLayout.this.cGm != null) {
                        if (VideoEditorSeekLayout.this.cGk) {
                            VideoEditorSeekLayout.this.cGm.pauseVideo();
                        } else {
                            VideoEditorSeekLayout.this.cGm.aav();
                        }
                        return;
                    }
                    if (VideoEditorSeekLayout.this.cGk) {
                        VideoEditorSeekLayout.this.pauseVideo();
                    } else {
                        VideoEditorSeekLayout.this.aav();
                    }
                }
            }
        });
    }

    /* renamed from: Pw */
    private void m16468Pw() {
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.cGs, new IntentFilter(C8048e.aBe().mo23625Mq()));
    }

    private void abZ() {
        if (this.cGL != null) {
            QStoryboard adO = this.cGL.adO();
            MSize streamSize = this.cGL.getStreamSize();
            if (!(adO == null || streamSize == null)) {
                VeGallery2 veGallery2 = (VeGallery2) findViewById(R.id.video_editor_seek_gallery);
                ArrayList t = C8530i.m24764t(this.csv);
                ArrayList arrayList = new ArrayList();
                Iterator it = t.iterator();
                while (it.hasNext()) {
                    VeRange veRange = (VeRange) it.next();
                    if (veRange != null) {
                        arrayList.add(new Range(veRange.getmPosition(), veRange.getmTimeLength()));
                    }
                }
                this.cGj = new C7116a(veGallery2, adO.getDuration(), arrayList, m16475j(this.csv));
                this.cGj.setmState(2);
                this.cGj.mo31553hP(true);
                this.cGj.setmOnTimeLineSeekListener(this.cGO);
                this.cGj.setKeyFrameListener(this.cGM);
            }
        }
    }

    private void aio() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.cGs);
    }

    /* renamed from: j */
    private HashMap<Integer, ArrayList<C8418a>> m16475j(ArrayList<C8441b> arrayList) {
        HashMap<Integer, ArrayList<C8418a>> hashMap = new HashMap<>();
        if (arrayList == null || arrayList.size() == 0) {
            return hashMap;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            hashMap.put(Integer.valueOf(i), ((C8441b) arrayList.get(i)).eei);
        }
        return hashMap;
    }

    /* renamed from: J */
    public void mo28392J(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerReady progress = ");
        sb.append(i);
        LogUtilsV2.m14230i(sb.toString());
        if (this.cGj != null && !z) {
            this.cGj.mo31544c(i, true, false);
            if (this.cGf != null) {
                this.cGf.setText(C4580b.m11637V((long) i));
            }
        }
    }

    /* renamed from: K */
    public void mo28393K(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerPlaying progress = ");
        sb.append(i);
        sb.append(",isUserSeeking = ");
        sb.append(z);
        LogUtilsV2.m14230i(sb.toString());
        if (!this.cGk) {
            mo28416fd(true);
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
    public void mo28394L(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerPause progress = ");
        sb.append(i);
        sb.append(",isUserSeeking = ");
        sb.append(z);
        LogUtilsV2.m14230i(sb.toString());
        if (this.cGj != null && !z) {
            this.cGj.mo31544c(i, true, false);
            if (this.cGf != null) {
                this.cGf.setText(C4580b.m11637V((long) i));
            }
        }
        mo28416fd(false);
    }

    /* renamed from: M */
    public void mo28395M(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerStop progress = ");
        sb.append(i);
        sb.append(",isUserSeeking = ");
        sb.append(z);
        LogUtilsV2.m14230i(sb.toString());
        if (this.cGj != null && !z) {
            this.cGj.mo31544c(i, true, true);
            if (this.cGf != null) {
                this.cGf.setText(C4580b.m11637V((long) i));
            }
        }
        mo28416fd(false);
    }

    /* renamed from: a */
    public C8418a mo28396a(int i, int i2, int i3, float f, float f2, int i4) {
        if (this.cGj == null || i < 0 || this.cGL == null) {
            return null;
        }
        return this.cGj.mo31542b(i, i2, i3, f, f2, i4);
    }

    /* renamed from: a */
    public void mo28397a(C5686a aVar, ArrayList<C8441b> arrayList) {
        this.cGL = aVar;
        this.csv = arrayList;
        abZ();
        aip();
    }

    public void aav() {
        if (this.cGl != null) {
            this.cGl.aoh();
        }
    }

    public boolean acx() {
        return this.cGj == null || this.cGj.acx();
    }

    public boolean aeE() {
        if (this.cGj == null) {
            return false;
        }
        return this.cGj.aeE();
    }

    public void aeu() {
        if (this.cGj != null) {
            boolean z = true;
            if (this.cGj.avz() != 0) {
                Range avw = this.cGj.avw();
                if (avw == null) {
                    this.cGj.mo31566qs(0);
                } else {
                    this.cGj.mo31543b(avw);
                }
                if (this.cGr != null) {
                    C5687a aVar = this.cGr;
                    if (avw != null) {
                        z = false;
                    }
                    aVar.mo27875fS(z);
                }
            } else if (this.cGr != null) {
                this.cGr.mo27875fS(true);
            }
        }
    }

    public int aev() {
        int i;
        boolean z = false;
        if (this.cGj == null) {
            return 0;
        }
        if (this.cGj.avz() == 0) {
            i = this.cGj.acp();
        } else {
            Range avw = this.cGj.avw();
            if (avw == null) {
                return 0;
            }
            if (this.cGj.avz() == 1) {
                z = true;
            }
            i = z ? avw.getmPosition() : avw.getLimitValue();
        }
        return i;
    }

    public void aew() {
        if (!(this.cGj == null || this.cGr == null)) {
            this.cGr.mo27875fS(false);
        }
    }

    public void aiL() {
        if (this.cGj != null) {
            mo28416fd(false);
            this.cGj.mo31552hO(false);
            this.cGj.avy();
            this.cGj.mo31558kK(-1);
            this.cGj.invalidate();
        }
    }

    public void aiM() {
        Range avw = this.cGj.avw();
        if (avw != null) {
            this.cGj.mo31530a(avw);
        }
    }

    public boolean aiN() {
        return this.cGj != null;
    }

    public boolean aiO() {
        return this.cGj != null && this.cGj.acv();
    }

    public boolean aiP() {
        return this.cGj == null || this.cGj.avz() == 1;
    }

    public void aip() {
        this.cGf.setText(C4580b.m11637V(0));
        this.cGe.setTextColor(getResources().getColor(R.color.color_8E8E93));
        if (this.cGL != null && this.cGL.adO() != null) {
            this.cGe.setText(C4580b.m11637V((long) this.cGL.adO().getDuration()));
            this.cGe.setText(C4580b.m11637V((long) this.cGL.adO().getDuration()));
            if (this.cGL.adO().getDuration() >= 300000 && !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId())) {
                this.cGe.setTextColor(getResources().getColor(R.color.color_FF2E0E));
            }
        }
    }

    public boolean ait() {
        return this.cGn;
    }

    /* renamed from: b */
    public void mo28411b(C5687a aVar) {
        this.cGr = aVar;
        LogUtilsV2.m14230i("init");
    }

    /* renamed from: c */
    public void mo28412c(int i, Range range) {
        VeRange aIc = ((C8441b) this.csv.get(i)).aIc();
        if (aIc != null) {
            aIc.setmPosition(range.getmPosition());
            aIc.setmTimeLength(range.getmTimeLength());
        }
    }

    /* renamed from: c */
    public void mo28413c(Range range) {
        LogUtilsV2.m14230i("addRangeOnTimeline");
        if (this.cGj != null && range != null && this.cGL != null) {
            this.cGj.mo31547g(range);
            this.cGj.mo31552hO(false);
        }
    }

    /* renamed from: cx */
    public void mo28414cx(int i, int i2) {
        mo28424j(i, i2, true);
    }

    public void destroy() {
        if (this.cGj != null) {
            this.cGj.destroy();
        }
        C10021c.aZH().mo38496az(this);
        aio();
    }

    /* renamed from: fd */
    public void mo28416fd(boolean z) {
        this.cGk = z;
        if (z) {
            this.cGg.setImageResource(R.drawable.v5_xiaoying_ve_preview_pause_btn);
        } else {
            this.cGg.setImageResource(R.drawable.v5_xiaoying_ve_preview_play_btn);
        }
    }

    public Range getAddingRange() {
        if (this.cGj == null) {
            return null;
        }
        return this.cGj.avx();
    }

    public Range getEditRange() {
        if (this.cGj == null) {
            return null;
        }
        return this.cGj.avw();
    }

    public int getFocusState() {
        if (this.cGj == null) {
            return 0;
        }
        return this.cGj.avz();
    }

    public int getTimeLineLeftPos() {
        if (this.cGj == null) {
            return 0;
        }
        return this.cGj.getTimeLineLeftPos();
    }

    public int getmEditBGMRangeIndex() {
        if (this.cGj == null) {
            return 0;
        }
        return this.cGj.getmEditBGMRangeIndex();
    }

    public ArrayList<C8418a> getmEffectKeyFrameRangeList() {
        if (this.cGj == null) {
            return null;
        }
        return this.cGj.getmEffectKeyFrameRangeList();
    }

    /* renamed from: hV */
    public int mo28423hV(int i) {
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

    /* renamed from: j */
    public void mo28424j(int i, int i2, boolean z) {
        if (this.cGj != null) {
            this.cGj.mo31564qq(i);
            this.cGj.mo31565qr(i2);
            this.cGj.mo31552hO(true);
            this.cGj.mo31551h(new Range(i, 0));
            this.cGj.mo31545dW(z);
        }
    }

    /* renamed from: lb */
    public void mo28425lb(int i) {
        if (this.cGj != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onFineTuningChange progress = ");
            sb.append(i);
            LogUtilsV2.m14230i(sb.toString());
            this.cGj.mo31544c(i, true, false);
            if (this.cGf != null) {
                this.cGf.setText(C4580b.m11637V((long) i));
            }
        }
    }

    /* renamed from: ml */
    public void mo28426ml(int i) {
        LogUtilsV2.m14230i("removeRangeOnTimeline");
        if (this.cGj != null && i >= 0 && this.cGL != null) {
            this.cGj.mo31561qn(i);
            this.cGj.mo31552hO(false);
        }
    }

    /* renamed from: mm */
    public int mo28427mm(int i) {
        if (this.cGj == null || i < 0 || this.cGL == null) {
            return -1;
        }
        return this.cGj.mo31562qo(i);
    }

    /* renamed from: mn */
    public void mo28428mn(int i) {
        if (this.cGj != null && i >= 0) {
            this.cGj.mo31559mn(i);
        }
    }

    /* renamed from: mo */
    public void mo28429mo(int i) {
        if (this.cGj != null) {
            mo28416fd(false);
            this.cGj.mo31552hO(false);
            this.cGj.avy();
            this.cGj.mo31558kK(i);
            this.cGj.invalidate();
        }
    }

    /* renamed from: mp */
    public int mo28430mp(int i) {
        if (this.cGj == null) {
            return -1;
        }
        return this.cGj.mo31557kJ(i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7133g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onEventMainThread TimelineThumbnailEvent iCurDecodeIdentifier = ");
        sb.append(gVar.dwf);
        LogUtilsV2.m14230i(sb.toString());
        this.cGj.mo31556kG(gVar.dwf);
    }

    public void pauseVideo() {
        if (this.cGl != null) {
            this.cGl.aoi();
        }
    }

    public void setCurrentFocusPos(int i) {
        this.cGj.setCurrentFocusPos(i);
    }

    public void setDisablePauseBtn(boolean z) {
        this.cGN = z;
        if (this.cGN) {
            this.cGg.setVisibility(4);
        } else {
            this.cGg.setVisibility(0);
        }
    }

    public void setEditIndexWhenMoving(int i) {
        if (i >= -1 && this.cGj != null) {
            this.cGj.mo31563qp(i);
        }
    }

    public void setFineTuningEnable(boolean z) {
        this.cGn = z;
    }

    public void setKeyFrameListener(C7131e eVar) {
        this.cGM = eVar;
    }

    public void setMaskDrawable(Drawable drawable) {
        if (this.cGj != null) {
            this.cGj.setMaskDrawable(drawable);
        }
    }

    public void setOnOperationCallback(C6499a aVar) {
        this.cGl = aVar;
    }

    public void setOnVideoEditorSeekListener(C5910b bVar) {
        this.cGm = bVar;
    }

    public void setTrimMaskDrawable(Drawable drawable) {
        if (this.cGj != null) {
            this.cGj.setTrimMaskDrawable(drawable);
        }
    }

    public void setmOnTimeLineSeekListener(C7124b bVar) {
        this.cGq = bVar;
    }

    public void setmState(int i) {
        if (this.cGj != null) {
            this.cGj.setmState(i);
        }
    }
}
