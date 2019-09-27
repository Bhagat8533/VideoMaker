package com.introvd.template.editor.clipedit.speed;

import com.introvd.template.common.SpeedUIManager;
import com.introvd.template.common.SpeedUIManager.SimpleSpeedChangeListener;
import com.introvd.template.p414ui.view.TextSeekBar;

/* renamed from: com.introvd.template.editor.clipedit.speed.a */
public class C5782a {
    private SpeedUIManager cCq;
    /* access modifiers changed from: private */
    public float cCr = 1.0f;
    private float cCs;
    /* access modifiers changed from: private */
    public float cCt;
    /* access modifiers changed from: private */
    public C5784a cCu;

    /* renamed from: com.introvd.template.editor.clipedit.speed.a$a */
    public interface C5784a {
        void afL();

        void afM();

        /* renamed from: at */
        boolean mo28051at(float f);

        void onSpeedTrackingChange(float f);
    }

    public C5782a(TextSeekBar textSeekBar) {
        if (textSeekBar != null) {
            this.cCq = new SpeedUIManager(textSeekBar, false);
            this.cCq.initViewState(1.0f);
            this.cCq.setmOnSpeedChangeListener(new SimpleSpeedChangeListener() {
                public void onSpeedChangeStart() {
                    C5782a.this.cCt = C5782a.this.cCr;
                    if (C5782a.this.cCu != null) {
                        C5782a.this.cCu.afL();
                    }
                }

                public void onSpeedChangeStop() {
                    if (C5782a.this.cCu != null) {
                        C5782a.this.cCu.afM();
                    }
                }

                public void onSpeedChanged(float f) {
                    C5782a.this.cCr = f;
                    C5782a.this.m16077B(C5782a.this.cCt, f);
                }

                public void onSpeedTrackingChange(float f) {
                    if (C5782a.this.cCu != null) {
                        C5782a.this.cCu.onSpeedTrackingChange(f);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m16077B(float f, float f2) {
        if (f != f2 && this.cCu != null) {
            if (this.cCu.mo28051at(f2)) {
                mo28053T(f2);
            } else {
                mo28053T(f);
            }
        }
    }

    /* renamed from: T */
    public void mo28053T(float f) {
        this.cCr = f;
        this.cCq.update(f);
    }

    /* renamed from: a */
    public void mo28054a(C5784a aVar) {
        this.cCu = aVar;
    }

    public float afI() {
        return this.cCt;
    }

    public float afJ() {
        return this.cCr;
    }

    public boolean afK() {
        return this.cCs != this.cCr;
    }

    /* renamed from: as */
    public void mo28058as(float f) {
        this.cCs = f;
    }

    public void changeSpeed(float f) {
        this.cCr = f;
        if (this.cCq != null) {
            this.cCq.update(f);
        }
        m16077B(this.cCs, f);
    }
}
