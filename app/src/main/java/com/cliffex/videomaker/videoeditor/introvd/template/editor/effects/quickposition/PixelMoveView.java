package com.introvd.template.editor.effects.quickposition;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;

public class PixelMoveView extends RelativeLayout {
    /* access modifiers changed from: private */
    public C6191a cNu;
    /* access modifiers changed from: private */
    public Runnable cNv;

    /* renamed from: com.introvd.template.editor.effects.quickposition.PixelMoveView$a */
    public interface C6191a {
        /* renamed from: A */
        void mo29009A(View view, int i);
    }

    public PixelMoveView(Context context) {
        this(context, null);
    }

    public PixelMoveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PixelMoveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNv = new Runnable() {
            public void run() {
                if (PixelMoveView.this.cNu != null) {
                    PixelMoveView.this.cNu.mo29009A(PixelMoveView.this, 1);
                }
                PixelMoveView.this.postDelayed(PixelMoveView.this.cNv, 50);
            }
        };
        m17727Oj();
    }

    /* renamed from: Oj */
    private void m17727Oj() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_effect_subtitle_pixel_move, this, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                setPressed(true);
                if (this.cNu != null) {
                    this.cNu.mo29009A(this, 0);
                }
                postDelayed(this.cNv, (long) ViewConfiguration.getLongPressTimeout());
                break;
            case 1:
            case 3:
            case 4:
                setPressed(false);
                removeCallbacks(this.cNv);
                break;
        }
        return true;
    }

    public void setLongClickListener(C6191a aVar) {
        this.cNu = aVar;
    }
}
