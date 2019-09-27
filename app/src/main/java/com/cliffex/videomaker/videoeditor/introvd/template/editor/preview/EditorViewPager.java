package com.introvd.template.editor.preview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p021v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.introvd.template.editor.R;

public class EditorViewPager extends ViewPager {
    private boolean cZG;

    public EditorViewPager(Context context) {
        this(context, null);
    }

    public EditorViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZG = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.EditorViewPager);
            this.cZG = obtainStyledAttributes.getBoolean(R.styleable.EditorViewPager_scrollable, true);
            obtainStyledAttributes.recycle();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.cZG;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.cZG;
    }
}
