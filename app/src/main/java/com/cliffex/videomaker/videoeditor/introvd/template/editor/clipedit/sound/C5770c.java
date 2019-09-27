package com.introvd.template.editor.clipedit.sound;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.editor.R;
import java.util.List;

/* renamed from: com.introvd.template.editor.clipedit.sound.c */
class C5770c extends C1008a<C5775c> {
    private static final int cBS = R.layout.editor_clip_view_item_magic_sound;
    private List<C5768a> cBT;
    /* access modifiers changed from: private */
    public C5772a cBU;
    /* access modifiers changed from: private */
    public C5768a cBV;
    /* access modifiers changed from: private */
    public C5773b cBW = new C5773b();
    private Context context;

    /* renamed from: com.introvd.template.editor.clipedit.sound.c$a */
    interface C5772a {
        /* renamed from: b */
        void mo28037b(C5768a aVar);
    }

    /* renamed from: com.introvd.template.editor.clipedit.sound.c$b */
    private static class C5773b {
        /* access modifiers changed from: private */
        public ValueAnimator animator;
        /* access modifiers changed from: private */
        public View cBZ;
        private int cCa;
        private AnimatorUpdateListener cCb;

        private C5773b() {
            this.cCa = 0;
            this.cCb = new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (C5773b.this.cBZ == null) {
                        if (C5773b.this.animator != null && C5773b.this.animator.isRunning()) {
                            C5773b.this.animator.cancel();
                        }
                        return;
                    }
                    C5773b.this.cBZ.setRotation((valueAnimator.getAnimatedFraction() * 360.0f) - 90.0f);
                }
            };
        }

        /* access modifiers changed from: private */
        public void afD() {
            this.cCa++;
        }

        /* access modifiers changed from: private */
        /* renamed from: cz */
        public void m16049cz(View view) {
            if (view != null && this.cCa > 0) {
                this.cCa--;
                this.cBZ = view;
                if (this.animator == null) {
                    this.animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    this.animator.addUpdateListener(this.cCb);
                } else if (this.animator.isRunning()) {
                    this.animator.cancel();
                }
                this.animator.start();
            }
        }
    }

    /* renamed from: com.introvd.template.editor.clipedit.sound.c$c */
    static class C5775c extends C1034u {
        /* access modifiers changed from: private */
        public TextView bAk;
        /* access modifiers changed from: private */
        public ImageView bJg;
        /* access modifiers changed from: private */
        public View cCd;
        /* access modifiers changed from: private */
        public View cCe;

        public C5775c(View view) {
            super(view);
            this.cCd = view.findViewById(R.id.v_focus);
            this.bAk = (TextView) view.findViewById(R.id.tv_title);
            this.bJg = (ImageView) view.findViewById(R.id.iv_icon);
            this.cCe = view.findViewById(R.id.iv_vip);
        }
    }

    C5770c(Context context2, C5768a aVar, List<C5768a> list, C5772a aVar2) {
        this.context = context2;
        this.cBT = list;
        this.cBU = aVar2;
        this.cBV = aVar;
    }

    /* renamed from: lp */
    private C5768a m16040lp(int i) {
        if (this.cBT == null || this.cBT.isEmpty() || i < 0 || i >= this.cBT.size()) {
            return null;
        }
        return (C5768a) this.cBT.get(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28041a(C5768a aVar) {
        if (aVar != null) {
            this.cBV = aVar;
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(C5775c cVar, int i) {
        final C5768a lp = m16040lp(i);
        if (lp != null) {
            cVar.bJg.setImageResource(lp.iconRes);
            cVar.bJg.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!lp.cBP) {
                        C5770c.this.cBW.afD();
                    }
                    if (C5770c.this.cBU != null) {
                        C5770c.this.cBV = lp;
                        C5770c.this.cBU.mo28037b(lp);
                        C5770c.this.notifyDataSetChanged();
                    }
                }
            });
            cVar.bAk.setText(lp.titleRes);
            int i2 = 0;
            boolean z = this.cBV == lp && !lp.cBP;
            if (z) {
                this.cBW.m16049cz(cVar.cCd);
            }
            cVar.cCd.setVisibility(z ? 0 : 4);
            View d = cVar.cCe;
            if (!lp.cBP) {
                i2 = 8;
            }
            d.setVisibility(i2);
        }
    }

    public int getItemCount() {
        if (this.cBT != null) {
            return this.cBT.size();
        }
        return 0;
    }

    /* renamed from: z */
    public C5775c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C5775c(LayoutInflater.from(this.context).inflate(cBS, viewGroup, false));
    }
}
