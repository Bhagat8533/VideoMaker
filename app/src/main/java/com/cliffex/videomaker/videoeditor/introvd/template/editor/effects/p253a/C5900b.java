package com.introvd.template.editor.effects.p253a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseEditorActivity;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.effects.PlayerFakeView;
import com.introvd.template.editor.effects.PlayerFakeView.C5891c;
import com.introvd.template.editor.effects.VideoEditorSeekLayout;
import com.introvd.template.editor.effects.bubble.sticker.C5963b;
import com.introvd.template.editor.effects.bubble.subtitle.C6028f;
import com.introvd.template.editor.effects.collage.C6072a;
import com.introvd.template.editor.effects.mosaic.C6167b;
import com.introvd.template.editor.widget.timeline.C7131e;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.editor.C8418a;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.utils.C8562q;
import com.introvd.template.xyui.C9136a;
import xiaoying.engine.clip.QKeyFrameTransformData.Value;

/* renamed from: com.introvd.template.editor.effects.a.b */
public final class C5900b {
    public static int cMr = 20;
    /* access modifiers changed from: private */
    public String cFC = "https://hybrid.xiaoying.tv/web/vivaVideo/preview_toturial/index.html#key_frame";
    private C5891c cGG = new C5891c() {
        /* renamed from: mj */
        public void mo28389mj(int i) {
            if ((i != 2 || C5900b.this.m16566mV(C5900b.this.cMk.getGroupId())) && C5900b.this.cyJ != null && C5900b.this.cyJ.getmEffectKeyFrameRangeList() != null && C5900b.this.cyJ.getmEffectKeyFrameRangeList().size() != 0 && C5900b.this.m16550a(C5900b.this.cMq)) {
                if (C5900b.this.cMi) {
                    C5900b.this.mo28488a(C5900b.this.m16559fz(false), C5900b.this.cMk, C5900b.this.akQ());
                } else {
                    C5900b.this.mo28488a(C5900b.this.cMk.adZ(), C5900b.this.cMk, C5900b.this.akQ());
                    C5899a.m16544v(VivaBaseApplication.m8749FZ(), C5900b.this.m16556d(C5900b.this.cMk), "auto");
                }
            }
        }
    };
    private PlayerFakeView cGY;
    /* access modifiers changed from: private */
    public boolean cMi;
    /* access modifiers changed from: private */
    public boolean cMj;
    /* access modifiers changed from: private */
    public C5896a cMk;
    /* access modifiers changed from: private */
    public ImageView cMl;
    /* access modifiers changed from: private */
    public ImageView cMm;
    /* access modifiers changed from: private */
    public C5909e cMn;
    private C9136a cMo;
    /* access modifiers changed from: private */
    public C5907d cMp;
    /* access modifiers changed from: private */
    public C8418a cMq;
    /* access modifiers changed from: private */
    public VideoEditorSeekLayout cyJ;
    /* access modifiers changed from: private */
    public Activity mActivity;

    public C5900b(Activity activity, VideoEditorSeekLayout videoEditorSeekLayout, PlayerFakeView playerFakeView, C5896a aVar, C5909e eVar) {
        this.mActivity = activity;
        this.cyJ = videoEditorSeekLayout;
        this.cGY = playerFakeView;
        this.cGY.setOnKeyFrameListener(this.cGG);
        this.cMk = aVar;
        this.cMn = eVar;
        this.cyJ.setKeyFrameListener(new C7131e() {
            public void akT() {
                if (C5900b.this.cMp != null) {
                    C5900b.this.cMp.mo28508LI();
                }
            }

            /* renamed from: fA */
            public void mo28500fA(boolean z) {
                if (C5900b.this.cMl != null && C5900b.this.cMl.getVisibility() != 8) {
                    if (!z && C5900b.this.cMj) {
                        C5900b.this.cMj = false;
                        C5900b.this.akS();
                    }
                    if (z) {
                        C5900b.this.mo28492am(C5900b.this.mActivity);
                        C5899a.m16543bm(VivaBaseApplication.m8749FZ(), C5900b.this.m16556d(C5900b.this.cMk));
                    }
                    C5900b.this.cMi = z;
                    C5900b.this.cMl.setBackground(z ? VivaBaseApplication.m8749FZ().getResources().getDrawable(R.drawable.editor_btn_effect_delete_keyframe) : VivaBaseApplication.m8749FZ().getResources().getDrawable(R.drawable.editor_btn_effect_add_keyframe));
                }
            }

            /* renamed from: fB */
            public void mo28501fB(boolean z) {
                if (C5900b.this.cMl != null && C5900b.this.cMm != null) {
                    int i = 8;
                    C5900b.this.cMl.setVisibility(z ? 0 : 8);
                    ImageView e = C5900b.this.cMm;
                    if (z) {
                        i = 0;
                    }
                    e.setVisibility(i);
                    if (z) {
                        C5900b.this.cMl.post(new Runnable() {
                            public void run() {
                                C5900b.this.mo28491al(C5900b.this.mActivity);
                            }
                        });
                    } else {
                        C5900b.this.akS();
                    }
                }
            }

            /* renamed from: mW */
            public void mo28502mW(int i) {
                if (C5900b.this.cyJ != null) {
                    C5900b.this.cMk.mo27874kY(i);
                    C5900b.this.cyJ.mo28425lb(i);
                    C5900b.this.mo28494cA(i, C5900b.this.akQ());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16550a(C8418a aVar) {
        if (this.cyJ == null) {
            return false;
        }
        if (aVar == null) {
            return true;
        }
        ScaleRotateViewState scaleViewState = this.cGY.getScaleRotateView().getScaleViewState();
        return (scaleViewState == null || scaleViewState.getRectArea() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public int akQ() {
        if (this.cMn == null) {
            return -1;
        }
        return this.cMn.ajt();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m16556d(C5896a aVar) {
        return aVar instanceof C6028f ? "字幕" : aVar instanceof C5963b ? "贴纸" : aVar instanceof C6072a ? "画中画" : aVar instanceof C6167b ? "马赛克" : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: fz */
    public int m16559fz(boolean z) {
        if (this.cyJ == null || this.cGY == null || this.cGY.getScaleRotateView() == null) {
            return -1;
        }
        ScaleRotateViewState scaleViewState = this.cGY.getScaleRotateView().getScaleViewState();
        if (scaleViewState == null || scaleViewState.getRectArea() == null) {
            return -1;
        }
        int mm = this.cyJ.mo28427mm(this.cMk.adZ());
        this.cMi = false;
        this.cMl.setBackground(VivaBaseApplication.m8749FZ().getResources().getDrawable(R.drawable.editor_btn_effect_add_keyframe));
        if (z) {
            this.cMk.mo28474b(this.cyJ.getmEffectKeyFrameRangeList(), akQ());
        }
        if ((this.cMk instanceof C6167b) && this.cMn != null) {
            this.cMn.aju();
        }
        return mm;
    }

    /* access modifiers changed from: private */
    /* renamed from: mV */
    public boolean m16566mV(int i) {
        return i == 40;
    }

    /* renamed from: a */
    public void mo28488a(int i, C5896a aVar, int i2) {
        if (this.cyJ != null && this.cGY != null && this.cGY.getScaleRotateView() != null) {
            ScaleRotateViewState scaleViewState = this.cGY.getScaleRotateView().getScaleViewState();
            if (scaleViewState != null && scaleViewState.getRectArea() != null) {
                if (i < 0) {
                    i = aVar.adZ();
                }
                int i3 = i;
                Rect a = C8562q.m25042a(scaleViewState.getRectArea(), aVar.getSurfaceSize().width, aVar.getSurfaceSize().height);
                float[] a2 = aVar.mo28464a(a, i2);
                VideoEditorSeekLayout videoEditorSeekLayout = this.cyJ;
                int centerX = a.centerX();
                this.cMq = videoEditorSeekLayout.mo28396a(i3, centerX, a.centerY(), a2[0], a2[1], (int) scaleViewState.mDegree);
                this.cMi = true;
                this.cMl.setBackground(VivaBaseApplication.m8749FZ().getResources().getDrawable(R.drawable.editor_btn_effect_delete_keyframe));
                aVar.mo28474b(this.cyJ.getmEffectKeyFrameRangeList(), i2);
            }
        }
    }

    public void akR() {
        if (this.cMo != null && this.cMo.isShowing()) {
            if (this.cMj) {
                this.cMj = false;
            }
            this.cMo.aNX();
        }
    }

    public void akS() {
        if (this.cMo != null && this.cMo.isShowing()) {
            if (this.cMj) {
                this.cMj = false;
            }
            this.cMo.aNX();
        }
        if (this.cMp != null) {
            this.cMp.mo28508LI();
        }
    }

    /* renamed from: al */
    public void mo28491al(Activity activity) {
        if (activity != null && C5842b.ahn()) {
            if (this.cMo == null) {
                this.cMo = new C9136a(activity);
            }
            this.cMo.mo36087f(this.cMl, 5, C4580b.m11666qi());
            this.cMo.mo36086dt(activity.getString(R.string.xiaoying_str_editor_add_effect_key_frame));
            this.cMo.show();
            C5842b.ahm();
        }
    }

    /* renamed from: am */
    public void mo28492am(Activity activity) {
        if (activity != null && C5842b.ahp()) {
            if (this.cMo == null) {
                this.cMo = new C9136a(activity);
            }
            this.cMj = true;
            this.cMo.mo36087f(this.cMl, 5, C4580b.m11666qi());
            this.cMo.mo36086dt(activity.getString(R.string.xiaoying_str_editor_click_delete_effect_key_frame));
            this.cMo.show();
            C5842b.aho();
        }
    }

    /* renamed from: an */
    public void mo28493an(Activity activity) {
        if (activity != null && C5842b.ahr()) {
            if (this.cMp == null) {
                this.cMp = new C5907d();
            }
            this.cMp.mo28509h(this.cyJ, this.cyJ.getTimeLineLeftPos(), -C4583d.m11673ii(10));
            C5842b.ahq();
        }
    }

    /* renamed from: cA */
    public void mo28494cA(int i, int i2) {
        if (this.cyJ != null && this.cMk != null) {
            Range editRange = this.cyJ.getEditRange();
            if (editRange != null) {
                Value a = this.cMk.mo28457a(i, editRange, i2);
                Rect a2 = this.cMk.mo28453a(a, i2);
                float a3 = this.cMk.mo28451a(a);
                if (!(this.cGY == null || a2 == null)) {
                    this.cGY.setViewPosition(a2, a3);
                }
            }
        }
    }

    public void destroy() {
        this.cMq = null;
        this.cMn = null;
        this.cMl = null;
        this.mActivity = null;
        this.cMo = null;
    }

    /* renamed from: eS */
    public ImageView mo28496eS(Context context) {
        if (context == null) {
            return null;
        }
        ImageView imageView = new ImageView(context);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.addRule(21);
        } else {
            layoutParams.addRule(11);
        }
        layoutParams.addRule(15);
        layoutParams.setMargins(0, 0, C7689a.m22597aR(15.0f), 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackground(context.getResources().getDrawable(R.drawable.editor_btn_effect_add_keyframe));
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C5900b.this.akR();
                boolean z = true;
                if (C5900b.this.cMi) {
                    C5900b.this.m16559fz(true);
                    C5899a.m16542bl(VivaBaseApplication.m8749FZ(), C5900b.this.m16556d(C5900b.this.cMk));
                    C5900b.this.mo28494cA(C5900b.this.cMk.adZ(), C5900b.this.akQ());
                } else {
                    C5900b.this.mo28488a(C5900b.this.cMk.adZ(), C5900b.this.cMk, C5900b.this.akQ());
                    C5899a.m16544v(VivaBaseApplication.m8749FZ(), C5900b.this.m16556d(C5900b.this.cMk), "click_icon");
                    C5900b.this.mo28493an(C5900b.this.mActivity);
                }
                if (C5900b.this.cMn != null && C5900b.this.cyJ != null && C5900b.this.cyJ.getmEffectKeyFrameRangeList() != null) {
                    C5909e j = C5900b.this.cMn;
                    if (C5900b.this.cyJ.getmEffectKeyFrameRangeList().size() == 0) {
                        z = false;
                    }
                    j.mo28513fh(z);
                }
            }
        });
        this.cMl = imageView;
        this.cMl.setVisibility(8);
        return imageView;
    }

    /* renamed from: eT */
    public ImageView mo28497eT(Context context) {
        if (context == null) {
            return null;
        }
        ImageView imageView = new ImageView(context);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.addRule(20);
        } else {
            layoutParams.addRule(9);
        }
        layoutParams.addRule(15);
        layoutParams.setMargins(C7689a.m22597aR(15.0f), 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackground(context.getResources().getDrawable(R.drawable.editor_btn_edit_lesson));
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5900b.this.mActivity instanceof BaseEditorActivity) {
                    ((BaseEditorActivity) C5900b.this.mActivity).cyx.mo27787gw(C5900b.this.cFC);
                }
            }
        });
        this.cMm = imageView;
        this.cMm.setVisibility(8);
        return imageView;
    }

    /* renamed from: mn */
    public void mo28498mn(int i) {
        if (this.cyJ != null && i >= 0) {
            this.cMk.mo28484mh(i);
            this.cyJ.mo28428mn(i);
        }
    }
}
