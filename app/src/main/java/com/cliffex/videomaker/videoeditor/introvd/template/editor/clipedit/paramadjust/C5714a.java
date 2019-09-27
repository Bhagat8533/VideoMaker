package com.introvd.template.editor.clipedit.paramadjust;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.paramadjust.view.ParamAdjustView;
import com.introvd.template.editor.clipedit.paramadjust.view.ParamAdjustView.C5720a;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.view.ControllableScrollView;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.utils.p394b.C8537n;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.clip.QClip;

/* renamed from: com.introvd.template.editor.clipedit.paramadjust.a */
public class C5714a {
    private View czA;
    private TextView czB;
    private TextView czC;
    /* access modifiers changed from: private */
    public ControllableScrollView czD;
    private DecimalFormat czE = new DecimalFormat("##0.00");
    private WeakReference<QEngine> czF;
    private QEffectPropertyData[] czG;
    /* access modifiers changed from: private */
    public QEffectPropertyData[] czH;
    /* access modifiers changed from: private */
    public C5716a czI;
    private C5720a czJ = new C5720a() {
        /* renamed from: a */
        public void mo27936a(ParamAdjustView paramAdjustView, int i, boolean z) {
            if (C5714a.this.czH != null && C5714a.this.czH.length == 10) {
                C5714a.this.czD.setEnableScroll(!z);
                C5714a.this.m15826a(paramAdjustView, i);
                if (C5714a.this.czI != null) {
                    C5714a.this.czI.mo27928b(C5714a.this.czH);
                }
            }
        }
    };
    private ParamAdjustView czq;
    private ParamAdjustView czr;
    private ParamAdjustView czs;
    private ParamAdjustView czt;
    private ParamAdjustView czu;
    private ParamAdjustView czv;
    private ParamAdjustView czw;
    private ParamAdjustView czx;
    private ParamAdjustView czy;
    private ParamAdjustView czz;

    /* renamed from: com.introvd.template.editor.clipedit.paramadjust.a$a */
    public interface C5716a {
        /* renamed from: b */
        void mo27928b(QEffectPropertyData[] qEffectPropertyDataArr);
    }

    public C5714a(QEngine qEngine, View view, View view2) {
        if (view instanceof ControllableScrollView) {
            this.czD = (ControllableScrollView) view;
            this.czA = view2;
            this.czB = (TextView) view2.findViewById(R.id.clip_param_value);
            this.czC = (TextView) view2.findViewById(R.id.clip_param_title);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.height = (int) (((double) ((C5840b.cEx - C4583d.m11671P(32.0f)) - C4583d.m11671P(44.0f))) / 2.5d);
            this.czq = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_brightness);
            this.czr = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_contrast);
            this.czs = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_sharpen);
            this.czt = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_saturation);
            this.czu = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_temperature);
            this.czv = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_vignette);
            this.czw = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_tone);
            this.czx = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_fade);
            this.czy = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_shadow);
            this.czz = (ParamAdjustView) view.findViewById(R.id.clipparam_adjust_hightlight);
            m15827a(this.czq, R.drawable.editor_selector_adjust_brightness, (ViewGroup.LayoutParams) layoutParams);
            m15827a(this.czr, R.drawable.editor_selector_adjust_contrast, (ViewGroup.LayoutParams) layoutParams);
            m15827a(this.czs, R.drawable.editor_selector_adjust_sharpen, (ViewGroup.LayoutParams) layoutParams);
            m15827a(this.czt, R.drawable.editor_selector_adjust_saturation, (ViewGroup.LayoutParams) layoutParams);
            m15827a(this.czu, R.drawable.editor_selector_adjust_temperature, (ViewGroup.LayoutParams) layoutParams);
            m15827a(this.czv, R.drawable.editor_selector_adjust_vignetee, (ViewGroup.LayoutParams) layoutParams);
            m15827a(this.czw, R.drawable.editor_selector_adjust_tone, (ViewGroup.LayoutParams) layoutParams);
            m15827a(this.czy, R.drawable.editor_selector_adjust_shadow, (ViewGroup.LayoutParams) layoutParams);
            m15827a(this.czz, R.drawable.editor_selector_adjust_highlight, (ViewGroup.LayoutParams) layoutParams);
            m15827a(this.czx, R.drawable.editor_selector_adjust_fade, (ViewGroup.LayoutParams) layoutParams);
            this.czF = new WeakReference<>(qEngine);
        }
    }

    /* renamed from: a */
    private void m15824a(View view, float f, float f2, long j, long j2) {
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillBefore(false);
        alphaAnimation.setStartOffset(j);
        view.startAnimation(alphaAnimation);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15826a(ParamAdjustView paramAdjustView, int i) {
        if (!this.czA.isShown()) {
            this.czA.setVisibility(0);
        }
        this.czC.setText(paramAdjustView.getContentDescription());
        this.czB.setText(m15832cn(paramAdjustView.getViewReferenceF(), i));
        m15824a(this.czA, 1.0f, 0.0f, 200, 500);
        if (paramAdjustView.equals(this.czq)) {
            this.czH[0].mValue = i;
        } else if (paramAdjustView.equals(this.czr)) {
            this.czH[1].mValue = i;
        } else if (paramAdjustView.equals(this.czt)) {
            this.czH[2].mValue = i;
        } else if (paramAdjustView.equals(this.czs)) {
            this.czH[3].mValue = i;
        } else if (paramAdjustView.equals(this.czu)) {
            this.czH[4].mValue = i;
        } else if (paramAdjustView.equals(this.czv)) {
            this.czH[5].mValue = i;
        } else if (paramAdjustView.equals(this.czw)) {
            this.czH[6].mValue = i;
        } else if (paramAdjustView.equals(this.czy)) {
            this.czH[7].mValue = i;
        } else if (paramAdjustView.equals(this.czz)) {
            this.czH[8].mValue = i;
        } else if (paramAdjustView.equals(this.czx)) {
            this.czH[9].mValue = i;
        }
    }

    /* renamed from: a */
    private void m15827a(ParamAdjustView paramAdjustView, int i, ViewGroup.LayoutParams layoutParams) {
        paramAdjustView.mo27947li(i);
        paramAdjustView.setLayoutParams(layoutParams);
        paramAdjustView.setClipParamAdjustListener(this.czJ);
    }

    /* renamed from: a */
    private void m15828a(QEffectPropertyData[] qEffectPropertyDataArr) {
        this.czq.mo27948lj(qEffectPropertyDataArr[0].mValue);
        this.czr.mo27948lj(qEffectPropertyDataArr[1].mValue);
        this.czt.mo27948lj(qEffectPropertyDataArr[2].mValue);
        this.czs.mo27948lj(qEffectPropertyDataArr[3].mValue);
        this.czu.mo27948lj(qEffectPropertyDataArr[4].mValue);
        this.czv.mo27948lj(qEffectPropertyDataArr[5].mValue);
        if (qEffectPropertyDataArr.length > 6) {
            this.czw.mo27948lj(qEffectPropertyDataArr[6].mValue);
            this.czy.mo27948lj(qEffectPropertyDataArr[7].mValue);
            this.czz.mo27948lj(qEffectPropertyDataArr[8].mValue);
            this.czx.mo27948lj(qEffectPropertyDataArr[9].mValue);
        }
    }

    /* renamed from: cn */
    private String m15832cn(int i, int i2) {
        if (i == 50) {
            i2 -= 50;
        }
        float f = (((float) i2) * 0.5f) / 50.0f;
        if (f > 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("+ ");
            sb.append(this.czE.format((double) f));
            return sb.toString();
        } else if (f >= 0.0f) {
            return "0.00";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("- ");
            sb2.append(this.czE.format((double) (-f)));
            return sb2.toString();
        }
    }

    /* renamed from: a */
    public void mo27930a(C5716a aVar) {
        this.czI = aVar;
    }

    /* renamed from: a */
    public void mo27931a(QClip qClip) {
        this.czH = C8537n.m24817b((QEngine) this.czF.get(), qClip, 105, C6386d.dkB.longValue());
        if (this.czH != null && this.czH.length == 10) {
            this.czG = new QEffectPropertyData[this.czH.length];
            for (int i = 0; i < this.czH.length; i++) {
                QEffectPropertyData qEffectPropertyData = new QEffectPropertyData();
                qEffectPropertyData.mID = this.czH[i].mID;
                qEffectPropertyData.mValue = this.czH[i].mValue;
                this.czG[i] = qEffectPropertyData;
            }
            m15828a(this.czH);
        }
    }

    public boolean aeY() {
        if (this.czG != null && this.czH != null && this.czG.length > 0 && this.czH.length > 0 && this.czG.length == this.czH.length) {
            for (int i = 0; i < this.czH.length; i++) {
                if (this.czG[i].mValue != this.czH[i].mValue) {
                    return true;
                }
            }
        }
        return false;
    }

    public QEffectPropertyData[] aeZ() {
        return this.czH;
    }

    public String afa() {
        StringBuilder sb = new StringBuilder();
        if (this.czH != null && this.czH.length == 6) {
            if (this.czH[0].mValue != 50) {
                sb.append("亮度+");
            }
            if (this.czH[1].mValue != 50) {
                sb.append("对比度+");
            }
            if (this.czH[2].mValue != 50) {
                sb.append("饱和度+");
            }
            if (this.czH[3].mValue != 50) {
                sb.append("锐度+");
            }
            if (this.czH[4].mValue != 50) {
                sb.append("色温+");
            }
            if (this.czH[5].mValue != 50) {
                sb.append("暗角+");
            }
            if (this.czH[6].mValue != 50) {
                sb.append("色调+");
            }
            if (this.czH[7].mValue != 50) {
                sb.append("阴影+");
            }
            if (this.czH[8].mValue != 50) {
                sb.append("高光+");
            }
            if (this.czH[9].mValue != 0) {
                sb.append("褪色+");
            }
        }
        if (sb.length() <= 0) {
            sb.append("无");
        }
        return sb.toString();
    }

    /* renamed from: s */
    public void mo27935s(int[] iArr) {
        if (this.czH != null) {
            this.czH[0].mValue = iArr[0];
            this.czH[1].mValue = iArr[1];
            this.czH[2].mValue = iArr[2];
            this.czH[3].mValue = iArr[3];
            this.czH[4].mValue = iArr[4];
            this.czH[5].mValue = iArr[5];
            if (this.czH.length > 6) {
                this.czH[6].mValue = iArr[6];
                this.czH[7].mValue = iArr[7];
                this.czH[8].mValue = iArr[8];
                this.czH[9].mValue = iArr[9];
            }
            m15828a(this.czH);
            this.czD.postInvalidate();
            if (this.czI != null) {
                this.czI.mo27928b(this.czH);
            }
        }
    }
}
