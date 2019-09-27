package com.introvd.template.component.videofetcher.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.p021v4.content.ContextCompat;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.utils.C5486d;

/* renamed from: com.introvd.template.component.videofetcher.view.d */
public class C5506d extends C1018h {
    private int cmN;
    private final Paint mPaint = new Paint();

    public C5506d(Context context) {
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(ContextCompat.getColor(context, R.color.color_eeeeee));
        this.mPaint.setStrokeWidth(1.0f);
        this.cmN = C5486d.m14894O(context, 15);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
        super.getItemOffsets(rect, view, recyclerView, rVar);
        if (((LayoutParams) view.getLayoutParams()).getViewLayoutPosition() == 0) {
            rect.top = C5486d.m14894O(view.getContext(), 10);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, C1031r rVar) {
        super.onDraw(canvas, recyclerView, rVar);
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (recyclerView.mo7745aM(childAt) != 0) {
                int paddingLeft = childAt.getPaddingLeft() + this.cmN;
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) paddingLeft, (float) (childAt.getTop() - 1), (float) (childAt.getWidth() - childAt.getPaddingRight()), (float) childAt.getTop(), this.mPaint);
            }
        }
    }
}
