package com.introvd.template.editor.fast.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.editor.provider.C6710e;
import com.introvd.template.p203b.C4583d;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.ArrayList;
import java.util.Iterator;

public class FastMoreToolLayout extends RelativeLayout {
    View cRA;
    LinearLayout cRB;
    private AlphaAnimation cRC;
    private AlphaAnimation cRD;
    private C6292a cRE;
    /* access modifiers changed from: private */
    public C6292a cRF;

    public FastMoreToolLayout(Context context) {
        this(context, null);
    }

    public FastMoreToolLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FastMoreToolLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void amk() {
        ArrayList aqB = new C6710e(getContext()).aqB();
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.width = C4583d.m11670O(getContext(), 48);
        layoutParams.height = -2;
        layoutParams.bottomMargin = C4583d.m11670O(getContext(), 10);
        Iterator it = aqB.iterator();
        while (it.hasNext()) {
            EditorToolItem editorToolItem = (EditorToolItem) it.next();
            FastToolItemView fastToolItemView = new FastToolItemView(getContext());
            fastToolItemView.setListener(this.cRE);
            fastToolItemView.setItemData(editorToolItem.mode, true, editorToolItem.coverResID, editorToolItem.titleResID);
            this.cRB.addView(fastToolItemView, layoutParams);
        }
        FastToolItemView fastToolItemView2 = new FastToolItemView(getContext());
        fastToolItemView2.setListener(this.cRE);
        fastToolItemView2.setItemData(-1, true, R.drawable.editor_fast_icon_tool_more_exit, "");
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = C4583d.m11670O(getContext(), 10);
        this.cRB.addView(fastToolItemView2, layoutParams);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_fast_more_tool_view_layout, this, true);
        this.cRA = findViewById(R.id.background);
        this.cRB = (LinearLayout) findViewById(R.id.container);
        this.cRC = new AlphaAnimation(0.0f, 1.0f);
        this.cRD = new AlphaAnimation(1.0f, 0.0f);
        this.cRC.setDuration(300);
        this.cRD.setDuration(500);
        this.cRC.setFillAfter(true);
        this.cRD.setFillAfter(true);
        this.cRE = new C6292a() {
            /* renamed from: nu */
            public void mo29221nu(int i) {
                if (!(FastMoreToolLayout.this.cRF == null || i == -1)) {
                    FastMoreToolLayout.this.cRF.mo29221nu(i);
                }
                FastMoreToolLayout.this.hide();
            }
        };
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                FastMoreToolLayout.this.hide();
            }
        }, this.cRA);
        amk();
    }

    public void hide() {
        int childCount = this.cRB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2 = (childCount - 1) - i;
            if (i2 == 0) {
                this.cRB.getChildAt(i).startAnimation(this.cRD);
            } else {
                long j = (long) ((i2 * 50) + 200);
                int O = (C4583d.m11670O(getContext(), 10) * (i2 - 1)) + C4583d.dpFloatToPixel(getContext(), 20.0f) + (this.cRB.getChildAt(i).getMeasuredHeight() * i2);
                AnimationSet animationSet = new AnimationSet(true);
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) O);
                translateAnimation.setDuration(j);
                translateAnimation.setFillAfter(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(j);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                this.cRB.getChildAt(i).startAnimation(animationSet);
            }
        }
        postDelayed(new Runnable() {
            public void run() {
                FastMoreToolLayout.this.setVisibility(8);
            }
        }, 200);
    }

    public void setToolItemListener(C6292a aVar) {
        this.cRF = aVar;
    }

    public void show() {
        setVisibility(0);
        int childCount = this.cRB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2 = (childCount - 1) - i;
            if (i2 == 0) {
                this.cRB.getChildAt(i).startAnimation(this.cRC);
            } else {
                long j = (long) ((i2 * 50) + 300);
                int O = (C4583d.m11670O(getContext(), 10) * (i2 - 1)) + C4583d.dpFloatToPixel(getContext(), 20.0f) + (this.cRB.getChildAt(i).getMeasuredHeight() * i2);
                AnimationSet animationSet = new AnimationSet(true);
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) O, 0.0f);
                translateAnimation.setDuration(j);
                translateAnimation.setFillAfter(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(j);
                alphaAnimation.setFillAfter(true);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                this.cRB.getChildAt(i).startAnimation(animationSet);
            }
        }
    }
}
