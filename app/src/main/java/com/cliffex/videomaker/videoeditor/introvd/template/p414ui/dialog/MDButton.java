package com.introvd.template.p414ui.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;
import xiaoying.quvideo.com.vivabase.C10122R;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.introvd.template.ui.dialog.MDButton */
public class MDButton extends TextView {

    /* renamed from: PH */
    private Drawable f3617PH;
    private boolean exE = false;
    private C8972k exF;
    private int exG;
    private Drawable exH;

    public MDButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MDButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.exG = context.getResources().getDimensionPixelSize(C10122R.dimen.md_dialog_frame_margin);
        this.exF = C8972k.END;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo35578f(boolean z, boolean z2) {
        if (this.exE != z || z2) {
            setGravity(z ? this.exF.mo35620qk() | 16 : 17);
            if (VERSION.SDK_INT >= 17) {
                setTextAlignment(z ? this.exF.getTextAlignment() : 4);
            }
            C8966i.m26329a(this, z ? this.f3617PH : this.exH);
            if (z) {
                setPadding(this.exG, getPaddingTop(), this.exG, getPaddingBottom());
            }
            this.exE = z;
        }
    }

    public void setAllCapsCompat(boolean z) {
        setAllCaps(z);
    }

    public void setDefaultSelector(Drawable drawable) {
        this.exH = drawable;
        if (!this.exE) {
            mo35578f(false, true);
        }
    }

    public void setStackedGravity(C8972k kVar) {
        this.exF = kVar;
    }

    public void setStackedSelector(Drawable drawable) {
        this.f3617PH = drawable;
        if (this.exE) {
            mo35578f(true, true);
        }
    }
}
