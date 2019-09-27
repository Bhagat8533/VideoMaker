package com.introvd.template.editor.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class ControllableScrollView extends ScrollView {
    private GestureDetector aML;
    /* access modifiers changed from: private */
    public boolean cFz;

    /* renamed from: com.introvd.template.editor.common.view.ControllableScrollView$a */
    class C5867a extends SimpleOnGestureListener {
        C5867a() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return ControllableScrollView.this.cFz;
        }
    }

    public ControllableScrollView(Context context) {
        this(context, null, 0);
    }

    public ControllableScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ControllableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cFz = true;
        init();
    }

    private void init() {
        this.aML = new GestureDetector(new C5867a());
        setFadingEdgeLength(0);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent) && this.aML.onTouchEvent(motionEvent);
    }

    public void setEnableScroll(boolean z) {
        this.cFz = z;
    }
}
