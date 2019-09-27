package com.introvd.template.xyui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.introvd.template.ui.widget.R;
import com.introvd.template.xyui.p421b.C9162a;

public class RoundCornerImageView extends ImageView {
    private Path eCv = new Path();
    private RectF rect = new RectF();

    /* renamed from: xw */
    private float f3676xw = -1.0f;

    public RoundCornerImageView(Context context) {
        super(context);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3676xw = m26598h(context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerImageView));
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3676xw = m26598h(context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerImageView));
    }

    /* renamed from: h */
    private float m26598h(TypedArray typedArray) {
        return typedArray.getDimension(R.styleable.RoundCornerImageView_cornerRadius, this.f3676xw);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            super.onDraw(canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (this.f3676xw < 0.0f) {
            this.f3676xw = (float) C9162a.m26663P(8.0f);
        }
        float f = this.f3676xw;
        if (this.rect == null) {
            this.rect = new RectF();
        }
        this.rect.left = 0.0f;
        this.rect.top = 0.0f;
        this.rect.right = (float) width;
        this.rect.bottom = (float) height;
        this.eCv.addRoundRect(this.rect, f, f, Direction.CW);
        canvas.clipPath(this.eCv);
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
