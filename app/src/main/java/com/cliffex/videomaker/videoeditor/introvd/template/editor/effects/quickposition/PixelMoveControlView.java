package com.introvd.template.editor.effects.quickposition;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.bubble.subtitle.C6031g;
import com.introvd.template.editor.effects.quickposition.PixelMoveView.C6191a;

public class PixelMoveControlView extends RelativeLayout {
    /* access modifiers changed from: private */
    public PixelMoveView cNn;
    /* access modifiers changed from: private */
    public PixelMoveView cNo;
    /* access modifiers changed from: private */
    public PixelMoveView cNp;
    /* access modifiers changed from: private */
    public PixelMoveView cNq;
    /* access modifiers changed from: private */
    public C6189a cNr;
    private C6191a cNs;

    /* renamed from: com.introvd.template.editor.effects.quickposition.PixelMoveControlView$a */
    public interface C6189a {
        /* renamed from: mH */
        void mo28772mH(int i);
    }

    public PixelMoveControlView(Context context) {
        this(context, null);
    }

    public PixelMoveControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PixelMoveControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNs = new C6191a() {
            /* renamed from: A */
            public void mo29009A(View view, int i) {
                String str;
                int i2;
                String str2 = "";
                if (view.equals(PixelMoveControlView.this.cNn)) {
                    i2 = 0;
                    str = "上";
                } else if (view.equals(PixelMoveControlView.this.cNo)) {
                    i2 = 1;
                    str = "左";
                } else if (view.equals(PixelMoveControlView.this.cNp)) {
                    i2 = 2;
                    str = "右";
                } else if (view.equals(PixelMoveControlView.this.cNq)) {
                    i2 = 3;
                    str = "下";
                } else {
                    str = str2;
                    i2 = -1;
                }
                C6031g.m17120u(view.getContext(), str, i == 0 ? "click" : "hold");
                if (PixelMoveControlView.this.cNr != null) {
                    PixelMoveControlView.this.cNr.mo28772mH(i2);
                }
            }
        };
        m17719Oj();
    }

    /* renamed from: Oj */
    private void m17719Oj() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.editor_effect_subtitle_pixel_move_control, this, true);
        this.cNn = (PixelMoveView) inflate.findViewById(R.id.top_move);
        this.cNo = (PixelMoveView) inflate.findViewById(R.id.left_move);
        this.cNp = (PixelMoveView) inflate.findViewById(R.id.right_move);
        this.cNq = (PixelMoveView) inflate.findViewById(R.id.bottom_move);
        this.cNn.setLongClickListener(this.cNs);
        this.cNo.setLongClickListener(this.cNs);
        this.cNp.setLongClickListener(this.cNs);
        this.cNq.setLongClickListener(this.cNs);
    }

    public void setOnLongMoveListener(C6189a aVar) {
        this.cNr = aVar;
    }
}
