package com.introvd.template.xyui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomRelativeLayout extends RelativeLayout {
    private boolean eCb = false;
    private boolean eCc = false;
    private C9133a eCd;
    private int mHeight;

    /* renamed from: com.introvd.template.xyui.CustomRelativeLayout$a */
    public interface C9133a {
        /* renamed from: vN */
        void mo36046vN(int i);
    }

    public CustomRelativeLayout(Context context) {
        super(context);
    }

    public CustomRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.eCb) {
            this.eCb = true;
            this.mHeight = i4;
            if (this.eCd != null) {
                this.eCd.mo36046vN(1);
            }
        } else {
            this.mHeight = this.mHeight < i4 ? i4 : this.mHeight;
        }
        if (this.eCb && this.mHeight > i4) {
            this.eCc = true;
            if (this.eCd != null) {
                this.eCd.mo36046vN(3);
            }
        }
        if (this.eCb && this.eCc && this.mHeight == i4) {
            this.eCc = false;
            if (this.eCd != null) {
                this.eCd.mo36046vN(2);
            }
        }
    }

    public void setOnKeyboardStateChangedListener(C9133a aVar) {
        this.eCd = aVar;
    }
}
