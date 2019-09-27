package com.introvd.template.template.widget.p412a.p413a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.C2136c;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.widget.p412a.C8917a;
import com.introvd.template.template.widget.p412a.C8938d;
import com.introvd.template.xyui.RoundCornerImageView;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.template.widget.a.a.c */
public class C8921c extends C2136c {
    /* access modifiers changed from: private */
    public Context context;
    private DynamicLoadingImageView evA;
    private TextView evB;
    private ImageView evC;
    /* access modifiers changed from: private */
    public C8917a evj;
    /* access modifiers changed from: private */
    public C8927g evq;
    /* access modifiers changed from: private */
    public C8938d evr;
    private ImageView evs;
    private RoundCornerImageView evt;
    private TextView evu;
    private RelativeLayout evv;
    private RelativeLayout evw;
    private ImageView evx;
    private ImageView evy;
    private LinearLayout evz;

    /* renamed from: com.introvd.template.template.widget.a.a.c$2 */
    static /* synthetic */ class C89232 {
        static final /* synthetic */ int[] evE = new int[C8938d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.introvd.template.template.widget.a.d[] r0 = com.introvd.template.template.widget.p412a.C8938d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                evE = r0
                int[] r0 = evE     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.introvd.template.template.widget.a.d r1 = com.introvd.template.template.widget.p412a.C8938d.STORE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = evE     // Catch:{ NoSuchFieldError -> 0x001f }
                com.introvd.template.template.widget.a.d r1 = com.introvd.template.template.widget.p412a.C8938d.SINGLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = evE     // Catch:{ NoSuchFieldError -> 0x002a }
                com.introvd.template.template.widget.a.d r1 = com.introvd.template.template.widget.p412a.C8938d.GROUP     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.widget.p412a.p413a.C8921c.C89232.<clinit>():void");
        }
    }

    public C8921c(View view) {
        super(view);
        this.context = view.getContext();
        this.evt = (RoundCornerImageView) view.findViewById(R.id.item_fitler_parent_cover);
        this.evs = (ImageView) view.findViewById(R.id.icon_fitler_parent_new);
        this.evu = (TextView) view.findViewById(R.id.item_fitler_parent_name);
        this.evv = (RelativeLayout) view.findViewById(R.id.bg_filter_group_revoke);
        this.evw = (RelativeLayout) view.findViewById(R.id.layout_filter_lock);
        this.evx = (ImageView) view.findViewById(R.id.icon_filter_lock);
        this.evy = (ImageView) view.findViewById(R.id.iv_filter_download);
        this.evz = (LinearLayout) view.findViewById(R.id.layout_download_progress);
        this.evA = (DynamicLoadingImageView) view.findViewById(R.id.bg_download_progress);
        ImageLoader.loadImage(R.drawable.xiaoying_cam_filter_download_loading, this.evA);
        this.evB = (TextView) view.findViewById(R.id.text_download_progress);
        this.evC = (ImageView) view.findViewById(R.id.bg_filter_single_selected);
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                switch (C89232.evE[C8921c.this.evr.ordinal()]) {
                    case 1:
                        if (C8921c.this.evj != null) {
                            C8921c.this.evj.mo35492Xs();
                            break;
                        }
                        break;
                    case 2:
                        C8921c.this.evq.setSelected(true);
                        if (C8921c.this.evj != null) {
                            C8921c.this.evj.mo35494a(new C8926f(C8921c.this.mo11807tn(), C8921c.this.evq));
                            break;
                        }
                        break;
                    case 3:
                        C8926f fVar = new C8926f(C8921c.this.mo11807tn(), C8921c.this.evq);
                        if (C8921c.this.evq.aMX() != 2 && C8921c.this.evq.aMX() != 3) {
                            if (C8921c.this.evq.aMX() == 0 && C8921c.this.evj != null) {
                                C8921c.this.evj.mo35495b(fVar);
                                break;
                            }
                        } else if (C8921c.this.evq.aMY() != 2) {
                            if (C8921c.this.evq.aMY() == 0 && C4600l.m11739k(C8921c.this.context, true) && C8921c.this.evj != null) {
                                C8921c.this.aMG();
                                C8921c.this.evj.mo35497c(fVar);
                                break;
                            }
                        } else if (C8921c.this.getAdapterPosition() >= 0) {
                            if (!C8921c.this.isExpanded()) {
                                if (C8921c.this.evj != null) {
                                    C8921c.this.evj.mo35498e(fVar);
                                }
                                C8921c.this.mo11810tt();
                                break;
                            } else {
                                C8921c.this.mo11811tu();
                                break;
                            }
                        }
                        break;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void aMG() {
        this.evq.mo35548vB(1);
        this.evq.mo35550vz(0);
    }

    private void aMH() {
        this.evq.mo35548vB(2);
        this.evw.setVisibility(8);
        this.evy.setVisibility(8);
        this.evA.setVisibility(8);
        this.evz.setVisibility(8);
    }

    /* renamed from: qS */
    private void m26195qS(String str) {
        if (C8739i.m25526qq(str) || C8739i.m25527qr(str)) {
            this.evx.setImageResource(R.drawable.editor_lock_icon_20_n);
        }
        if (C8049f.aBf().isNeedToPurchase(str)) {
            this.evx.setImageResource(R.drawable.editor_vip_icon_20_n);
        }
    }

    /* renamed from: a */
    public void mo35508a(C8927g gVar, C8917a aVar, boolean z) {
        this.evq = gVar;
        this.evj = aVar;
        this.evr = gVar.aMU();
        if (this.evr == C8938d.STORE) {
            this.evt.setImageResource(R.drawable.xiaoying_cam_icon_filter_store);
        } else if (!TextUtils.isEmpty(gVar.aMT())) {
            ImageLoader.loadImage(this.context, gVar.aMT(), (ImageView) this.evt);
        } else {
            this.evt.setImageResource(gVar.aMQ());
        }
        if ((TextUtils.isEmpty(this.evu.getText()) || !this.evu.getText().toString().equals(gVar.aMS())) && !TextUtils.isEmpty(gVar.aMS())) {
            this.evu.setText(gVar.aMS());
        }
        if (gVar.aMV()) {
            this.evs.setVisibility(0);
        } else {
            this.evs.setVisibility(8);
        }
        this.evz.setVisibility(8);
        if (gVar.aMX() == 3 || gVar.aMX() == 0) {
            m26195qS(gVar.aMR());
            this.evw.setVisibility(0);
        } else {
            this.evw.setVisibility(8);
        }
        if (gVar.aMY() == 2) {
            this.evy.setVisibility(8);
        } else if (gVar.aMW() == 0) {
            this.evy.setVisibility(0);
        } else if (gVar.aMW() > 0 && gVar.aMW() < 100) {
            this.evy.setVisibility(8);
            this.evz.setVisibility(0);
            TextView textView = this.evB;
            StringBuilder sb = new StringBuilder();
            sb.append(gVar.aMW());
            sb.append("%");
            textView.setText(sb.toString());
        } else if (gVar.aMW() == -1) {
            aMH();
        }
        if (!this.evq.isSelected() || !z) {
            this.evC.setVisibility(8);
        } else {
            this.evC.setVisibility(0);
        }
        if (!this.evq.isExpanded() || this.evq.aMU() != C8938d.GROUP) {
            this.evv.setVisibility(8);
        } else {
            this.evv.setVisibility(0);
        }
    }

    /* renamed from: aK */
    public void mo11803aK(boolean z) {
        super.mo11803aK(z);
        if (z) {
            this.evv.setVisibility(8);
        } else if (this.evq != null && this.evq.aMU() == C8938d.GROUP) {
            this.evv.setVisibility(0);
        }
    }

    @SuppressLint({"NewApi"})
    public void setExpanded(boolean z) {
        super.setExpanded(z);
        if (!z) {
            this.evv.setVisibility(8);
        } else if (this.evq != null && this.evq.aMU() == C8938d.GROUP) {
            this.evv.setVisibility(0);
        }
    }

    /* renamed from: ts */
    public boolean mo11809ts() {
        return false;
    }
}
