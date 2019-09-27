package com.introvd.template.xyui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.util.AttributeSet;
import android.view.View;
import com.introvd.template.ui.widget.R;
import com.introvd.template.xyui.p421b.C9162a;

public class StoryGridView extends RecyclerView {
    private boolean dHs;
    private boolean eCA = false;
    private C9161b eCB;
    private C9135b eCC;
    private C9134a eCD;
    private int eCE = 0;
    private int eCz;
    private int horizontalSpacing;
    private int orientation;
    private int pagerSize = 1;
    private int spanCounts;
    private int verticalSpacing;

    /* renamed from: com.introvd.template.xyui.StoryGridView$a */
    public interface C9134a {
        /* renamed from: vQ */
        void mo36069vQ(int i);
    }

    /* renamed from: com.introvd.template.xyui.StoryGridView$b */
    private class C9135b extends C1018h {
        private boolean dHs;
        private int horizontalSpacing;
        private int spanCount;
        private int verticalSpacing;

        public C9135b(int i, int i2, int i3, boolean z) {
            this.horizontalSpacing = i;
            this.verticalSpacing = i2;
            this.spanCount = i3;
            this.dHs = z;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
            super.getItemOffsets(rect, view, recyclerView, rVar);
            int aM = recyclerView.mo7745aM(view);
            int i = aM % this.spanCount;
            if (this.dHs) {
                if (C9162a.cfW) {
                    rect.left = ((i + 1) * this.horizontalSpacing) / this.spanCount;
                    rect.right = this.horizontalSpacing - ((i * this.horizontalSpacing) / this.spanCount);
                } else {
                    rect.left = this.horizontalSpacing - ((this.horizontalSpacing * i) / this.spanCount);
                    rect.right = ((i + 1) * this.horizontalSpacing) / this.spanCount;
                }
                if (aM < this.spanCount) {
                    rect.top = this.verticalSpacing;
                }
                rect.bottom = this.verticalSpacing;
                return;
            }
            if (C9162a.cfW) {
                rect.left = this.horizontalSpacing - (((i + 1) * this.horizontalSpacing) / this.spanCount);
                rect.right = (i * this.horizontalSpacing) / this.spanCount;
            } else {
                rect.left = (this.horizontalSpacing * i) / this.spanCount;
                rect.right = this.horizontalSpacing - (((i + 1) * this.horizontalSpacing) / this.spanCount);
            }
            if (aM >= this.spanCount) {
                rect.top = this.verticalSpacing;
            }
        }
    }

    public StoryGridView(Context context) {
        super(context);
    }

    /* JADX INFO: finally extract failed */
    public StoryGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.StoryGridView, 0, 0);
            try {
                this.pagerSize = obtainStyledAttributes.getInt(R.styleable.StoryGridView_pagerSize, 1);
                this.eCz = obtainStyledAttributes.getInt(R.styleable.StoryGridView_mode, 0);
                this.spanCounts = obtainStyledAttributes.getInt(R.styleable.StoryGridView_spanCounts, 1);
                this.orientation = obtainStyledAttributes.getInt(R.styleable.StoryGridView_orientation, 1);
                this.horizontalSpacing = C9162a.m26662O(context, obtainStyledAttributes.getInt(R.styleable.StoryGridView_horizontalSpacing, 0));
                this.verticalSpacing = C9162a.m26662O(context, obtainStyledAttributes.getInt(R.styleable.StoryGridView_verticalSpacing, 0));
                this.dHs = obtainStyledAttributes.getBoolean(R.styleable.StoryGridView_includeEdge, true);
                obtainStyledAttributes.recycle();
                this.eCB = new C9161b(context, this.spanCounts, this.orientation, false);
                C9135b bVar = new C9135b(this.horizontalSpacing, this.verticalSpacing, this.spanCounts, this.dHs);
                this.eCC = bVar;
                setLayoutManager(this.eCB);
                mo7733a((C1018h) this.eCC);
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
    }

    private int getScrollToPosition() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        if (firstVisiblePosition - this.eCE > 0) {
            int i = (((lastVisiblePosition / this.pagerSize) + 1) * this.pagerSize) - 1;
            this.eCE = (i - this.pagerSize) + 1;
            return i;
        }
        int i2 = this.pagerSize * (firstVisiblePosition / this.pagerSize);
        this.eCE = i2;
        return i2;
    }

    /* renamed from: am */
    public boolean mo7757am(int i, int i2) {
        boolean am = super.mo7757am(i, i2);
        if (this.eCz == 1) {
            return false;
        }
        return am;
    }

    public int getFirstVisiblePosition() {
        if (this.eCB != null) {
            return this.eCB.findFirstVisibleItemPosition();
        }
        return 0;
    }

    public GridLayoutManager getGridLayoutManager() {
        return this.eCB;
    }

    public int getLastVisiblePosition() {
        if (this.eCB != null) {
            return this.eCB.findLastVisibleItemPosition();
        }
        return 0;
    }

    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (this.eCz == 1) {
            switch (i) {
                case 0:
                    int scrollToPosition = getScrollToPosition();
                    if (this.eCD != null && !this.eCA) {
                        this.eCD.mo36069vQ(scrollToPosition / this.pagerSize);
                    }
                    if (this.eCA) {
                        this.eCB.smoothScrollToPosition(this, null, scrollToPosition);
                        this.eCA = false;
                        return;
                    }
                    return;
                case 1:
                    this.eCA = true;
                    return;
                default:
                    return;
            }
        }
    }

    public void setAdapter(C1008a aVar) {
        super.setAdapter(aVar);
    }

    public void setIsFullView(boolean z) {
        this.eCB.setIsFullView(z);
    }

    public void setOnPageChangeListener(C9134a aVar) {
        this.eCD = aVar;
    }

    public void setPagerSize(int i) {
        this.pagerSize = i;
    }
}
