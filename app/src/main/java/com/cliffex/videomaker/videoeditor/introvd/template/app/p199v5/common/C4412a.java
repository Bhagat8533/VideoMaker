package com.introvd.template.app.p199v5.common;

import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.common.C4420c.C4421a;
import com.introvd.template.app.p199v5.common.p200ui.PopupNewTipsView;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4583d;

/* renamed from: com.introvd.template.app.v5.common.a */
public class C4412a {
    /* access modifiers changed from: private */
    public C4420c bFg;
    /* access modifiers changed from: private */
    public C4416a bFh;
    /* access modifiers changed from: private */
    public PopupNewTipsView bFi;
    /* access modifiers changed from: private */
    public PopupNewTipsView bFj;
    /* access modifiers changed from: private */
    public PopupNewTipsView bFk;
    /* access modifiers changed from: private */
    public ImageView bFl;
    /* access modifiers changed from: private */
    public ImageView bFm;
    /* access modifiers changed from: private */
    public boolean bFn = false;
    private C4421a bkc = new C4421a() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 5:
                    if (C4412a.this.bFi.getParent() == null) {
                        C4412a.this.bFi.mo24505QV();
                        LayoutParams layoutParams = new LayoutParams(-2, -2);
                        layoutParams.addRule(12);
                        layoutParams.bottomMargin = C4583d.m11670O(C4412a.this.bof.getContext(), 50);
                        int[] iArr = new int[2];
                        C4412a.this.bFl.getLocationOnScreen(iArr);
                        if (VERSION.SDK_INT >= 17) {
                            layoutParams.setMarginStart((iArr[0] + (C4412a.this.bFl.getMeasuredWidth() / 2)) - (C4412a.this.bFi.getTipWidth() / 2));
                        } else {
                            layoutParams.leftMargin = (iArr[0] + (C4412a.this.bFl.getMeasuredWidth() / 2)) - (C4412a.this.bFi.getTipWidth() / 2);
                        }
                        C4412a.this.bof.addView(C4412a.this.bFi, layoutParams);
                        C4412a.this.bFi.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                if (C4412a.this.bFh != null) {
                                    C4412a.this.bFh.mo24489QU();
                                }
                                C4412a.this.bFg.sendEmptyMessage(6);
                            }
                        });
                        C4412a.this.bFg.removeMessages(6);
                        break;
                    } else {
                        return;
                    }
                case 6:
                    C4412a.this.bFg.removeMessages(6);
                    if (C4412a.this.bFi.getParent() != null) {
                        C4412a.this.bof.removeView(C4412a.this.bFi);
                        break;
                    }
                    break;
                case 8:
                    C4412a.this.bFg.removeMessages(8);
                    if (C4412a.this.bFj.getParent() != null) {
                        C4412a.this.bof.removeView(C4412a.this.bFj);
                        break;
                    }
                    break;
                case 9:
                    if (C4412a.this.bFk.getParent() == null) {
                        C4412a.this.bFk.mo24507s(C4412a.this.bFk.getContext().getString(R.string.viva_comm_studio_move_tips), R.drawable.xyui_bg_help_pop_right_up);
                        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                        layoutParams2.addRule(12);
                        layoutParams2.bottomMargin = C4583d.m11670O(C4412a.this.bof.getContext(), 50);
                        int[] iArr2 = new int[2];
                        C4412a.this.bFm.getLocationOnScreen(iArr2);
                        if (VERSION.SDK_INT >= 17) {
                            layoutParams2.setMarginStart((iArr2[0] - C4412a.this.bFk.getTipWidth()) + (C4412a.this.bFm.getMeasuredWidth() / 2) + C7689a.m22599ii(18));
                        } else {
                            layoutParams2.leftMargin = (iArr2[0] - C4412a.this.bFk.getTipWidth()) + (C4412a.this.bFm.getMeasuredWidth() / 2) + C7689a.m22599ii(18);
                        }
                        C4412a.this.bof.addView(C4412a.this.bFk, layoutParams2);
                        C4412a.this.bFn = true;
                        C4412a.this.bFk.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                C4412a.this.bFg.sendEmptyMessage(16);
                            }
                        });
                        C4412a.this.bFg.removeMessages(16);
                        break;
                    } else {
                        return;
                    }
                case 16:
                    C4412a.this.bFg.removeMessages(16);
                    if (C4412a.this.bFk.getParent() != null) {
                        C4412a.this.bof.removeView(C4412a.this.bFk);
                    }
                    C4412a.this.bFn = false;
                    break;
            }
        }
    };
    /* access modifiers changed from: private */
    public RelativeLayout bof;

    /* renamed from: com.introvd.template.app.v5.common.a$a */
    public interface C4416a {
        /* renamed from: QU */
        void mo24489QU();
    }

    public C4412a(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2) {
        this.bof = relativeLayout;
        this.bFl = imageView2;
        this.bFm = imageView;
        this.bFg = new C4420c();
        this.bFg.mo24501a(this.bkc);
        this.bFi = new PopupNewTipsView(relativeLayout.getContext());
        this.bFj = new PopupNewTipsView(relativeLayout.getContext());
        this.bFk = new PopupNewTipsView(relativeLayout.getContext());
    }

    /* renamed from: QO */
    public void mo24481QO() {
        this.bFg.sendEmptyMessageDelayed(5, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    /* renamed from: QP */
    public void mo24482QP() {
        this.bFg.sendEmptyMessage(6);
    }

    /* renamed from: QQ */
    public void mo24483QQ() {
        this.bFg.sendEmptyMessage(8);
    }

    /* renamed from: QR */
    public void mo24484QR() {
        this.bFg.sendEmptyMessageDelayed(9, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    /* renamed from: QS */
    public void mo24485QS() {
        this.bFg.sendEmptyMessage(16);
    }

    /* renamed from: QT */
    public boolean mo24486QT() {
        return this.bFn;
    }
}
