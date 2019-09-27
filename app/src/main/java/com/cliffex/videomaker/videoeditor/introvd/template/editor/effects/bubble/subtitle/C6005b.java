package com.introvd.template.editor.effects.bubble.subtitle;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.xyui.C9136a;

/* renamed from: com.introvd.template.editor.effects.bubble.subtitle.b */
public class C6005b {
    private ViewGroup boF;
    private RelativeLayout cHA;
    private RelativeLayout cHB;
    private LinearLayout cHC;
    private C6007a cHD = null;
    private C9136a cHE;
    /* access modifiers changed from: private */
    public RelativeLayout cHw;
    /* access modifiers changed from: private */
    public RelativeLayout cHx;
    /* access modifiers changed from: private */
    public RelativeLayout cHy;
    /* access modifiers changed from: private */
    public RelativeLayout cHz;
    private int cwZ = 0;
    private RelativeLayout cxr;

    /* renamed from: po */
    private OnClickListener f3495po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(C6005b.this.cHx)) {
                C6005b.this.m16966kU(1);
            } else if (view.equals(C6005b.this.cHy)) {
                C6005b.this.mo28690fk(false);
                C6005b.this.m16966kU(2);
            } else if (view.equals(C6005b.this.cHz)) {
                C6005b.this.m16966kU(3);
            } else if (view.equals(C6005b.this.cHw)) {
                C6005b.this.m16966kU(0);
            }
        }
    };

    /* renamed from: com.introvd.template.editor.effects.bubble.subtitle.b$a */
    public interface C6007a {
        /* renamed from: fl */
        void mo28694fl(boolean z);

        /* renamed from: kV */
        void mo28695kV(int i);
    }

    public C6005b(View view, boolean z) {
        this.boF = (RelativeLayout) view;
        m16964cx(view);
        if (!z) {
            this.cHw.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m16957a(View view, int i, String str, boolean z, int i2, int i3) {
        if (this.cHE != null) {
            this.cHE.mo36087f(view, i, z);
            this.cHE.mo36086dt(str);
            this.cHE.mo36085dT(i2, i3);
        }
    }

    /* renamed from: a */
    private void m16958a(View view, ImageView imageView, boolean z) {
        if (view.equals(this.cHx)) {
            if (z) {
                imageView.setImageResource(R.drawable.editor_icon_effect_subtitle_text_focus);
            } else {
                imageView.setImageResource(R.drawable.editor_icon_effect_subtitle_text_n);
            }
        } else if (view.equals(this.cHy)) {
            if (z) {
                imageView.setImageResource(R.drawable.editor_btn_effect_subtitle_font_focus);
            } else {
                imageView.setImageResource(R.drawable.editor_btn_effect_subtitle_font_normal);
            }
        } else if (view.equals(this.cHz)) {
            if (z) {
                imageView.setImageResource(R.drawable.editor_btn_effect_subtitle_align_focus);
            } else {
                imageView.setImageResource(R.drawable.editor_btn_effect_subtitle_align_normal);
            }
        } else if (!view.equals(this.cHw)) {
        } else {
            if (z) {
                imageView.setImageResource(R.drawable.editor_icon_effect_subtitle_anim_focus);
            } else {
                imageView.setImageResource(R.drawable.editor_icon_effect_subtitle_anim_normal);
            }
        }
    }

    /* renamed from: a */
    private void m16960a(boolean z, RelativeLayout relativeLayout) {
        if (relativeLayout != null) {
            View childAt = relativeLayout.getChildAt(0);
            ImageView imageView = null;
            ImageView imageView2 = childAt instanceof ImageView ? (ImageView) childAt : null;
            View childAt2 = relativeLayout.getChildAt(1);
            if (childAt2 instanceof ImageView) {
                imageView = (ImageView) childAt2;
                imageView.setVisibility(0);
            }
            if (z) {
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
            } else if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            if (imageView != null) {
                m16958a(relativeLayout, imageView, z);
            }
            if (this.cHD != null && relativeLayout == this.cHz) {
                this.cHD.mo28694fl(z);
            }
        }
    }

    /* renamed from: cA */
    private void m16963cA(View view) {
        UtilsPrefs with = UtilsPrefs.with(view.getContext(), EditorRouter.VIVA_EDITOR_PREF_FILENAME, true);
        if (!with.readBoolean("key_has_showed_stroke_and_shadow_tip", false)) {
            with.writeBoolean("key_has_showed_stroke_and_shadow_tip", true);
            if (view.getContext() instanceof Activity) {
                this.cHE = new C9136a((Activity) view.getContext());
            }
            m16957a(this.cHy, 4, view.getContext().getString(R.string.xiaoying_str_ve_stroke_and_shadow_help_tip), C4580b.m11666qi(), 0, 0);
        }
    }

    /* renamed from: cx */
    private void m16964cx(View view) {
        this.cHw = (RelativeLayout) view.findViewById(R.id.rl_tab_animtitle);
        this.cHx = (RelativeLayout) view.findViewById(R.id.rl_tab_subtitle);
        this.cHy = (RelativeLayout) view.findViewById(R.id.rl_tab_font);
        this.cHz = (RelativeLayout) view.findViewById(R.id.rl_tab_align);
        this.cHA = (RelativeLayout) view.findViewById(R.id.rl_anim_text_layout);
        this.cHB = (RelativeLayout) view.findViewById(R.id.rl_subtitle_layout);
        this.cxr = (RelativeLayout) view.findViewById(R.id.rl_font_text_layout);
        this.cHC = (LinearLayout) view.findViewById(R.id.layout_adjust_control);
        this.cHw.setOnClickListener(this.f3495po);
        this.cHx.setOnClickListener(this.f3495po);
        this.cHy.setOnClickListener(this.f3495po);
        this.cHz.setOnClickListener(this.f3495po);
        mo28692s(true, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: kU */
    public void m16966kU(int i) {
        if (i != this.cwZ) {
            switch (i) {
                case 0:
                    mo28692s(true, true);
                    break;
                case 1:
                    mo28692s(false, true);
                    break;
                case 2:
                    m16960a(false, this.cHx);
                    m16960a(false, this.cHw);
                    m16960a(true, this.cHy);
                    m16960a(false, this.cHz);
                    if (this.cHA != null) {
                        this.cHA.setVisibility(8);
                    }
                    if (this.cHB != null) {
                        this.cHB.setVisibility(8);
                    }
                    if (this.cxr != null) {
                        this.cxr.setVisibility(0);
                    }
                    if (this.cHC != null) {
                        this.cHC.setVisibility(8);
                        break;
                    }
                    break;
                case 3:
                    m16960a(false, this.cHw);
                    m16960a(false, this.cHx);
                    m16960a(false, this.cHy);
                    m16960a(true, this.cHz);
                    if (this.cHA != null) {
                        this.cHA.setVisibility(8);
                    }
                    if (this.cHB != null) {
                        this.cHB.setVisibility(8);
                    }
                    if (this.cxr != null) {
                        this.cxr.setVisibility(8);
                    }
                    if (this.cHC != null) {
                        this.cHC.setVisibility(0);
                        break;
                    }
                    break;
            }
            this.cwZ = i;
            if (this.cHD != null) {
                this.cHD.mo28695kV(i);
            }
        }
    }

    /* renamed from: a */
    public void mo28687a(C6007a aVar) {
        this.cHD = aVar;
    }

    public void ade() {
        this.cHx = null;
        this.cHy = null;
        this.cHz = null;
        this.cHB = null;
        this.cxr = null;
        this.cHC = null;
        if (this.boF != null) {
            this.boF.removeAllViews();
            this.boF = null;
        }
    }

    public int ajC() {
        return this.cwZ;
    }

    /* renamed from: fk */
    public void mo28690fk(boolean z) {
        if (z) {
            m16963cA(this.boF);
        } else if (this.cHE != null && this.cHE.isShowing()) {
            this.cHE.aNX();
        }
    }

    /* renamed from: kP */
    public void mo28691kP(int i) {
        m16966kU(i);
        this.cwZ = i;
    }

    /* renamed from: s */
    public void mo28692s(boolean z, boolean z2) {
        if (!z2) {
            this.cwZ = z ^ true ? 1 : 0;
        }
        m16960a(z, this.cHw);
        m16960a(!z, this.cHx);
        int i = 0;
        m16960a(false, this.cHy);
        m16960a(false, this.cHz);
        if (this.cHA != null) {
            this.cHA.setVisibility(z ? 0 : 8);
        }
        if (this.cHB != null) {
            RelativeLayout relativeLayout = this.cHB;
            if (z) {
                i = 8;
            }
            relativeLayout.setVisibility(i);
        }
        if (this.cxr != null) {
            this.cxr.setVisibility(8);
        }
        if (this.cHC != null) {
            this.cHC.setVisibility(8);
        }
    }
}
