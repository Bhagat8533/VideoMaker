package com.introvd.template.common.recyclerviewutil.gallerylayoutmanager;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.p024v7.widget.C1092ac;
import android.support.p024v7.widget.C1093ad;
import android.support.p024v7.widget.C1097ag;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1020j;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.support.p024v7.widget.RecyclerView.C1025n;
import android.support.p024v7.widget.RecyclerView.C1028q.C1029a;
import android.support.p024v7.widget.RecyclerView.C1028q.C1030b;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public class GalleryLayoutManager extends LayoutManager implements C1030b {

    /* renamed from: Vu */
    RecyclerView f3448Vu;

    /* renamed from: Xp */
    private C1097ag f3449Xp;

    /* renamed from: Xq */
    private C1097ag f3450Xq;
    private int cfi = 0;
    private int cfj = 0;
    private int cfk = -1;
    int cfl = -1;
    View cfm;
    private C5298c cfn;
    /* access modifiers changed from: private */
    public C1093ad cfo = new C1093ad();
    private C5297b cfp = new C5297b();
    /* access modifiers changed from: private */
    public boolean cfq = false;
    private ItemTransformer cfr;
    /* access modifiers changed from: private */
    public OnItemSelectedListener cfs;
    private int mOrientation = 0;

    public interface ItemTransformer {
        void transformItem(GalleryLayoutManager galleryLayoutManager, View view, float f);
    }

    public static class LayoutParams extends android.support.p024v7.widget.RecyclerView.LayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public interface OnItemSelectedListener {
        void onItemSelected(RecyclerView recyclerView, View view, int i);
    }

    /* renamed from: com.introvd.template.common.recyclerviewutil.gallerylayoutmanager.GalleryLayoutManager$a */
    private class C5296a extends C1092ac {
        public C5296a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo8147a(View view, C1031r rVar, C1029a aVar) {
            int cr = mo26646cr(view);
            int cs = mo26647cs(view);
            int ca = mo8667ca((int) Math.sqrt((double) ((cr * cr) + (cs * cs))));
            if (ca > 0) {
                aVar.mo8163a(-cr, -cs, ca, this.mDecelerateInterpolator);
            }
        }

        public PointF computeScrollVectorForPosition(int i) {
            return null;
        }

        /* renamed from: cr */
        public int mo26646cr(View view) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
                return 0;
            }
            android.support.p024v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.p024v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
            int decoratedLeft = layoutManager.getDecoratedLeft(view) - layoutParams.leftMargin;
            int decoratedRight = layoutManager.getDecoratedRight(view) + layoutParams.rightMargin;
            return ((int) (((float) ((layoutManager.getWidth() - layoutManager.getPaddingRight()) - layoutManager.getPaddingLeft())) / 2.0f)) - (decoratedLeft + ((int) (((float) (decoratedRight - decoratedLeft)) / 2.0f)));
        }

        /* renamed from: cs */
        public int mo26647cs(View view) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null || !layoutManager.canScrollVertically()) {
                return 0;
            }
            android.support.p024v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.p024v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
            int decoratedTop = layoutManager.getDecoratedTop(view) - layoutParams.topMargin;
            int decoratedBottom = layoutManager.getDecoratedBottom(view) + layoutParams.bottomMargin;
            return ((int) (((float) ((layoutManager.getHeight() - layoutManager.getPaddingBottom()) - layoutManager.getPaddingTop())) / 2.0f)) - (decoratedTop + ((int) (((float) (decoratedBottom - decoratedTop)) / 2.0f)));
        }
    }

    /* renamed from: com.introvd.template.common.recyclerviewutil.gallerylayoutmanager.GalleryLayoutManager$b */
    private class C5297b extends C1022l {
        boolean cfu;
        int mState;

        private C5297b() {
        }

        /* renamed from: a */
        public void mo8095a(RecyclerView recyclerView, int i, int i2) {
            super.mo8095a(recyclerView, i, i2);
            View a = GalleryLayoutManager.this.cfo.mo8674a(recyclerView.getLayoutManager());
            if (a != null && recyclerView.getLayoutManager() != null) {
                int position = recyclerView.getLayoutManager().getPosition(a);
                if (position != GalleryLayoutManager.this.cfl) {
                    if (GalleryLayoutManager.this.cfm != null) {
                        GalleryLayoutManager.this.cfm.setSelected(false);
                    }
                    GalleryLayoutManager.this.cfm = a;
                    GalleryLayoutManager.this.cfm.setSelected(true);
                    GalleryLayoutManager.this.cfl = position;
                    if (GalleryLayoutManager.this.cfq || this.mState == 0) {
                        if (GalleryLayoutManager.this.cfs != null) {
                            GalleryLayoutManager.this.cfs.onItemSelected(recyclerView, a, GalleryLayoutManager.this.cfl);
                        }
                        return;
                    }
                    this.cfu = true;
                }
            }
        }

        /* renamed from: d */
        public void mo8096d(RecyclerView recyclerView, int i) {
            super.mo8096d(recyclerView, i);
            this.mState = i;
            if (recyclerView.getLayoutManager() != null && this.mState == 0) {
                View a = GalleryLayoutManager.this.cfo.mo8674a(recyclerView.getLayoutManager());
                if (a != null) {
                    int position = recyclerView.getLayoutManager().getPosition(a);
                    if (position != GalleryLayoutManager.this.cfl) {
                        if (GalleryLayoutManager.this.cfm != null) {
                            GalleryLayoutManager.this.cfm.setSelected(false);
                        }
                        GalleryLayoutManager.this.cfm = a;
                        GalleryLayoutManager.this.cfm.setSelected(true);
                        GalleryLayoutManager.this.cfl = position;
                        if (GalleryLayoutManager.this.cfs != null) {
                            GalleryLayoutManager.this.cfs.onItemSelected(recyclerView, a, GalleryLayoutManager.this.cfl);
                        }
                    } else if (!GalleryLayoutManager.this.cfq && GalleryLayoutManager.this.cfs != null && this.cfu) {
                        this.cfu = false;
                        GalleryLayoutManager.this.cfs.onItemSelected(recyclerView, a, GalleryLayoutManager.this.cfl);
                    }
                } else {
                    Log.e("GalleryLayoutManager", "onScrollStateChanged: snap null");
                }
            }
        }
    }

    /* renamed from: com.introvd.template.common.recyclerviewutil.gallerylayoutmanager.GalleryLayoutManager$c */
    class C5298c {
        SparseArray<Rect> cfv = new SparseArray<>();
        int cfw = 0;

        public C5298c() {
        }
    }

    public GalleryLayoutManager(int i) {
        this.mOrientation = i;
    }

    /* renamed from: Zk */
    private int m14394Zk() {
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    /* renamed from: Zl */
    private int m14395Zl() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    /* renamed from: a */
    private void m14397a(C1025n nVar, int i, int i2, int i3) {
        Rect rect = new Rect();
        int Zl = m14395Zl();
        while (i >= 0 && i2 > i3) {
            View cl = nVar.mo8121cl(i);
            addView(cl, 0);
            measureChildWithMargins(cl, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(cl);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(cl);
            int paddingTop = (int) (((float) getPaddingTop()) + (((float) (Zl - decoratedMeasuredHeight)) / 2.0f));
            rect.set(i2 - decoratedMeasuredWidth, paddingTop, i2, decoratedMeasuredHeight + paddingTop);
            layoutDecorated(cl, rect.left, rect.top, rect.right, rect.bottom);
            i2 = rect.left;
            this.cfi = i;
            if (getState().cfv.get(i) == null) {
                getState().cfv.put(i, rect);
            } else {
                ((Rect) getState().cfv.get(i)).set(rect);
            }
            i--;
        }
    }

    /* renamed from: b */
    private void m14398b(C1025n nVar, int i, int i2, int i3) {
        Rect rect = new Rect();
        int Zl = m14395Zl();
        while (i < getItemCount() && i2 < i3) {
            View cl = nVar.mo8121cl(i);
            addView(cl);
            measureChildWithMargins(cl, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(cl);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(cl);
            int paddingTop = (int) (((float) getPaddingTop()) + (((float) (Zl - decoratedMeasuredHeight)) / 2.0f));
            rect.set(i2, paddingTop, decoratedMeasuredWidth + i2, decoratedMeasuredHeight + paddingTop);
            layoutDecorated(cl, rect.left, rect.top, rect.right, rect.bottom);
            i2 = rect.right;
            this.cfj = i;
            if (getState().cfv.get(i) == null) {
                getState().cfv.put(i, rect);
            } else {
                ((Rect) getState().cfv.get(i)).set(rect);
            }
            i++;
        }
    }

    /* renamed from: c */
    private void m14401c(C1025n nVar, int i, int i2, int i3) {
        Rect rect = new Rect();
        int Zk = m14394Zk();
        while (i >= 0 && i2 > i3) {
            View cl = nVar.mo8121cl(i);
            addView(cl, 0);
            measureChildWithMargins(cl, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(cl);
            int paddingLeft = (int) (((float) getPaddingLeft()) + (((float) (Zk - decoratedMeasuredWidth)) / 2.0f));
            rect.set(paddingLeft, i2 - getDecoratedMeasuredHeight(cl), decoratedMeasuredWidth + paddingLeft, i2);
            layoutDecorated(cl, rect.left, rect.top, rect.right, rect.bottom);
            i2 = rect.top;
            this.cfi = i;
            if (getState().cfv.get(i) == null) {
                getState().cfv.put(i, rect);
            } else {
                ((Rect) getState().cfv.get(i)).set(rect);
            }
            i--;
        }
    }

    /* renamed from: cG */
    private int m14402cG(int i) {
        int i2 = -1;
        if (getChildCount() == 0) {
            return -1;
        }
        if (i >= this.cfi) {
            i2 = 1;
        }
        return i2;
    }

    /* renamed from: d */
    private void m14403d(C1025n nVar, int i, int i2, int i3) {
        Rect rect = new Rect();
        int Zk = m14394Zk();
        while (i < getItemCount() && i2 < i3) {
            View cl = nVar.mo8121cl(i);
            addView(cl);
            measureChildWithMargins(cl, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(cl);
            int paddingLeft = (int) (((float) getPaddingLeft()) + (((float) (Zk - decoratedMeasuredWidth)) / 2.0f));
            rect.set(paddingLeft, i2, decoratedMeasuredWidth + paddingLeft, getDecoratedMeasuredHeight(cl) + i2);
            layoutDecorated(cl, rect.left, rect.top, rect.right, rect.bottom);
            i2 = rect.bottom;
            this.cfj = i;
            if (getState().cfv.get(i) == null) {
                getState().cfv.put(i, rect);
            } else {
                ((Rect) getState().cfv.get(i)).set(rect);
            }
            i++;
        }
    }

    /* renamed from: d */
    private void m14404d(C1025n nVar, C1031r rVar, int i) {
        if (this.cfk < 0 || this.cfk >= getItemCount()) {
            m14405e(nVar, rVar, i);
            return;
        }
        if (this.mOrientation == 0) {
            m14410i(nVar, rVar);
        } else {
            m14411j(nVar, rVar);
        }
        if (this.cfr != null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                this.cfr.transformItem(this, childAt, m14406f(childAt, (float) i));
            }
        }
        this.cfp.mo8095a(this.f3448Vu, 0, 0);
    }

    /* renamed from: e */
    private void m14405e(C1025n nVar, C1031r rVar, int i) {
        if (getItemCount() != 0) {
            if (this.mOrientation == 0) {
                m14409g(nVar, rVar, i);
            } else {
                m14407f(nVar, rVar, i);
            }
            if (this.cfr != null) {
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    View childAt = getChildAt(i2);
                    this.cfr.transformItem(this, childAt, m14406f(childAt, (float) i));
                }
            }
        }
    }

    /* renamed from: f */
    private float m14406f(View view, float f) {
        return Math.max(-1.0f, Math.min(1.0f, (((float) m14408g(view, f)) * 1.0f) / ((float) (this.mOrientation == 0 ? view.getWidth() : view.getHeight()))));
    }

    /* renamed from: f */
    private void m14407f(C1025n nVar, C1031r rVar, int i) {
        int i2;
        int i3;
        C1025n nVar2 = nVar;
        int kM = getOrientationHelper().mo8693kM();
        int kN = getOrientationHelper().mo8694kN();
        int i4 = 0;
        if (getChildCount() > 0) {
            if (i < 0) {
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = getChildAt(childCount);
                    if (getDecoratedTop(childAt) - i <= kN) {
                        break;
                    }
                    removeAndRecycleView(childAt, nVar2);
                    this.cfj--;
                }
            } else {
                int i5 = 0;
                for (int i6 = 0; i6 < getChildCount(); i6++) {
                    View childAt2 = getChildAt(i6 + i5);
                    if (getDecoratedBottom(childAt2) - i >= kM) {
                        break;
                    }
                    removeAndRecycleView(childAt2, nVar2);
                    this.cfi++;
                    i5--;
                }
            }
        }
        int i7 = this.cfi;
        int Zk = m14394Zk();
        int i8 = -1;
        if (i >= 0) {
            if (getChildCount() != 0) {
                View childAt3 = getChildAt(getChildCount() - 1);
                int position = getPosition(childAt3) + 1;
                i3 = getDecoratedBottom(childAt3);
                i2 = position;
            } else {
                i2 = i7;
                i3 = -1;
            }
            int i9 = i2;
            while (i9 < getItemCount() && i3 < kN + i) {
                Rect rect = (Rect) getState().cfv.get(i9);
                View cl = nVar2.mo8121cl(i9);
                addView(cl);
                if (rect == null) {
                    rect = new Rect();
                    getState().cfv.put(i9, rect);
                }
                Rect rect2 = rect;
                measureChildWithMargins(cl, i4, i4);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(cl);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(cl);
                int paddingLeft = (int) (((float) getPaddingLeft()) + (((float) (Zk - decoratedMeasuredWidth)) / 2.0f));
                if (i3 == -1 && i2 == 0) {
                    int paddingTop = (int) (((float) getPaddingTop()) + (((float) (m14395Zl() - decoratedMeasuredHeight)) / 2.0f));
                    rect2.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
                } else {
                    rect2.set(paddingLeft, i3, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + i3);
                }
                int i10 = rect2.left;
                int i11 = rect2.top;
                int i12 = rect2.right;
                View view = cl;
                int i13 = i10;
                int i14 = i11;
                int i15 = i12;
                Rect rect3 = rect2;
                layoutDecorated(view, i13, i14, i15, rect2.bottom);
                i3 = rect3.bottom;
                this.cfj = i9;
                i9++;
                i4 = 0;
            }
            return;
        }
        if (getChildCount() > 0) {
            View childAt4 = getChildAt(0);
            int position2 = getPosition(childAt4) - 1;
            i8 = getDecoratedTop(childAt4);
            i7 = position2;
        }
        for (int i16 = i7; i16 >= 0 && i8 > kM + i; i16--) {
            Rect rect4 = (Rect) getState().cfv.get(i16);
            View cl2 = nVar2.mo8121cl(i16);
            addView(cl2, 0);
            if (rect4 == null) {
                rect4 = new Rect();
                getState().cfv.put(i16, rect4);
            }
            Rect rect5 = rect4;
            measureChildWithMargins(cl2, 0, 0);
            int decoratedMeasuredWidth2 = getDecoratedMeasuredWidth(cl2);
            int paddingLeft2 = (int) (((float) getPaddingLeft()) + (((float) (Zk - decoratedMeasuredWidth2)) / 2.0f));
            rect5.set(paddingLeft2, i8 - getDecoratedMeasuredHeight(cl2), decoratedMeasuredWidth2 + paddingLeft2, i8);
            layoutDecorated(cl2, rect5.left, rect5.top, rect5.right, rect5.bottom);
            i8 = rect5.top;
            this.cfi = i16;
        }
    }

    /* renamed from: g */
    private int m14408g(View view, float f) {
        C1097ag orientationHelper = getOrientationHelper();
        int kN = ((orientationHelper.mo8694kN() - orientationHelper.mo8693kM()) / 2) + orientationHelper.mo8693kM();
        return this.mOrientation == 0 ? (int) (((((float) (view.getWidth() / 2)) - f) + ((float) view.getLeft())) - ((float) kN)) : (int) (((((float) (view.getHeight() / 2)) - f) + ((float) view.getTop())) - ((float) kN));
    }

    /* renamed from: g */
    private void m14409g(C1025n nVar, C1031r rVar, int i) {
        int i2;
        int i3;
        C1025n nVar2 = nVar;
        int kM = getOrientationHelper().mo8693kM();
        int kN = getOrientationHelper().mo8694kN();
        int i4 = 0;
        if (getChildCount() > 0) {
            if (i >= 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < getChildCount(); i6++) {
                    View childAt = getChildAt(i6 + i5);
                    if (getDecoratedRight(childAt) - i >= kM) {
                        break;
                    }
                    removeAndRecycleView(childAt, nVar2);
                    this.cfi++;
                    i5--;
                }
            } else {
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt2 = getChildAt(childCount);
                    if (getDecoratedLeft(childAt2) - i > kN) {
                        removeAndRecycleView(childAt2, nVar2);
                        this.cfj--;
                    }
                }
            }
        }
        int i7 = this.cfi;
        int Zl = m14395Zl();
        int i8 = -1;
        if (i >= 0) {
            if (getChildCount() != 0) {
                View childAt3 = getChildAt(getChildCount() - 1);
                int position = getPosition(childAt3) + 1;
                i3 = getDecoratedRight(childAt3);
                i2 = position;
            } else {
                i2 = i7;
                i3 = -1;
            }
            int i9 = i2;
            while (i9 < getItemCount() && i3 < kN + i) {
                Rect rect = (Rect) getState().cfv.get(i9);
                View cl = nVar2.mo8121cl(i9);
                addView(cl);
                if (rect == null) {
                    rect = new Rect();
                    getState().cfv.put(i9, rect);
                }
                Rect rect2 = rect;
                measureChildWithMargins(cl, i4, i4);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(cl);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(cl);
                int paddingTop = (int) (((float) getPaddingTop()) + (((float) (Zl - decoratedMeasuredHeight)) / 2.0f));
                if (i3 == -1 && i2 == 0) {
                    int paddingLeft = (int) (((float) getPaddingLeft()) + (((float) (m14394Zk() - decoratedMeasuredWidth)) / 2.0f));
                    rect2.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
                } else {
                    rect2.set(i3, paddingTop, decoratedMeasuredWidth + i3, decoratedMeasuredHeight + paddingTop);
                }
                int i10 = rect2.left;
                int i11 = rect2.top;
                int i12 = rect2.right;
                View view = cl;
                int i13 = i10;
                int i14 = i11;
                int i15 = i12;
                Rect rect3 = rect2;
                layoutDecorated(view, i13, i14, i15, rect2.bottom);
                i3 = rect3.right;
                this.cfj = i9;
                i9++;
                i4 = 0;
            }
            return;
        }
        if (getChildCount() > 0) {
            View childAt4 = getChildAt(0);
            int position2 = getPosition(childAt4) - 1;
            i8 = getDecoratedLeft(childAt4);
            i7 = position2;
        }
        for (int i16 = i7; i16 >= 0 && i8 > kM + i; i16--) {
            Rect rect4 = (Rect) getState().cfv.get(i16);
            View cl2 = nVar2.mo8121cl(i16);
            addView(cl2, 0);
            if (rect4 == null) {
                rect4 = new Rect();
                getState().cfv.put(i16, rect4);
            }
            Rect rect5 = rect4;
            measureChildWithMargins(cl2, 0, 0);
            int decoratedMeasuredWidth2 = getDecoratedMeasuredWidth(cl2);
            int decoratedMeasuredHeight2 = getDecoratedMeasuredHeight(cl2);
            int paddingTop2 = (int) (((float) getPaddingTop()) + (((float) (Zl - decoratedMeasuredHeight2)) / 2.0f));
            rect5.set(i8 - decoratedMeasuredWidth2, paddingTop2, i8, decoratedMeasuredHeight2 + paddingTop2);
            layoutDecorated(cl2, rect5.left, rect5.top, rect5.right, rect5.bottom);
            i8 = rect5.left;
            this.cfi = i16;
        }
    }

    /* renamed from: i */
    private void m14410i(C1025n nVar, C1031r rVar) {
        detachAndScrapAttachedViews(nVar);
        int kM = getOrientationHelper().mo8693kM();
        int kN = getOrientationHelper().mo8694kN();
        int i = this.cfk;
        Rect rect = new Rect();
        int Zl = m14395Zl();
        View cl = nVar.mo8121cl(this.cfk);
        addView(cl, 0);
        measureChildWithMargins(cl, 0, 0);
        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(cl);
        int decoratedMeasuredHeight = getDecoratedMeasuredHeight(cl);
        int paddingTop = (int) (((float) getPaddingTop()) + (((float) (Zl - decoratedMeasuredHeight)) / 2.0f));
        int paddingLeft = (int) (((float) getPaddingLeft()) + (((float) (m14394Zk() - decoratedMeasuredWidth)) / 2.0f));
        rect.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
        layoutDecorated(cl, rect.left, rect.top, rect.right, rect.bottom);
        if (getState().cfv.get(i) == null) {
            getState().cfv.put(i, rect);
        } else {
            ((Rect) getState().cfv.get(i)).set(rect);
        }
        this.cfj = i;
        this.cfi = i;
        int decoratedLeft = getDecoratedLeft(cl);
        int decoratedRight = getDecoratedRight(cl);
        m14397a(nVar, this.cfk - 1, decoratedLeft, kM);
        m14398b(nVar, this.cfk + 1, decoratedRight, kN);
    }

    /* renamed from: j */
    private void m14411j(C1025n nVar, C1031r rVar) {
        detachAndScrapAttachedViews(nVar);
        int kM = getOrientationHelper().mo8693kM();
        int kN = getOrientationHelper().mo8694kN();
        int i = this.cfk;
        Rect rect = new Rect();
        int Zk = m14394Zk();
        View cl = nVar.mo8121cl(this.cfk);
        addView(cl, 0);
        measureChildWithMargins(cl, 0, 0);
        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(cl);
        int decoratedMeasuredHeight = getDecoratedMeasuredHeight(cl);
        int paddingLeft = (int) (((float) getPaddingLeft()) + (((float) (Zk - decoratedMeasuredWidth)) / 2.0f));
        int paddingTop = (int) (((float) getPaddingTop()) + (((float) (m14395Zl() - decoratedMeasuredHeight)) / 2.0f));
        rect.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
        layoutDecorated(cl, rect.left, rect.top, rect.right, rect.bottom);
        if (getState().cfv.get(i) == null) {
            getState().cfv.put(i, rect);
        } else {
            ((Rect) getState().cfv.get(i)).set(rect);
        }
        this.cfj = i;
        this.cfi = i;
        int decoratedTop = getDecoratedTop(cl);
        int decoratedBottom = getDecoratedBottom(cl);
        m14401c(nVar, this.cfk - 1, decoratedTop, kM);
        m14403d(nVar, this.cfk + 1, decoratedBottom, kN);
    }

    private void reset() {
        if (this.cfn != null) {
            this.cfn.cfv.clear();
        }
        this.cfl = -1;
        this.cfi = 0;
        if (this.cfm != null) {
            this.cfm.setSelected(false);
            this.cfm = null;
        }
        this.cfj = 0;
    }

    public void attach(RecyclerView recyclerView, int i) {
        if (recyclerView != null) {
            this.f3448Vu = recyclerView;
            this.cfk = i;
            recyclerView.setLayoutManager(this);
            this.cfo.mo8807a(recyclerView);
            recyclerView.mo7737a((C1022l) this.cfp);
            recyclerView.setOnFlingListener(new C1020j() {
                /* renamed from: aB */
                public boolean mo8091aB(int i, int i2) {
                    return false;
                }
            });
            return;
        }
        throw new IllegalArgumentException("The attach RecycleView must not null!!");
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public boolean checkLayoutParams(android.support.p024v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public PointF computeScrollVectorForPosition(int i) {
        int cG = m14402cG(i);
        PointF pointF = new PointF();
        if (cG == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) cG;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) cG;
        }
        return pointF;
    }

    public android.support.p024v7.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 1 ? new LayoutParams(-1, -2) : new LayoutParams(-2, -1);
    }

    public android.support.p024v7.widget.RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.p024v7.widget.RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public C1097ag getOrientationHelper() {
        if (this.mOrientation == 0) {
            if (this.f3450Xq == null) {
                this.f3450Xq = C1097ag.m3539d(this);
            }
            return this.f3450Xq;
        }
        if (this.f3449Xp == null) {
            this.f3449Xp = C1097ag.m3540e(this);
        }
        return this.f3449Xp;
    }

    public C5298c getState() {
        if (this.cfn == null) {
            this.cfn = new C5298c();
        }
        return this.cfn;
    }

    public void onLayoutChildren(C1025n nVar, C1031r rVar) {
        if (getItemCount() == 0) {
            reset();
            detachAndScrapAttachedViews(nVar);
        } else if (!rVar.mo8170ma()) {
            if (rVar.getItemCount() == 0 || rVar.mo8174me()) {
                if (getChildCount() == 0 || rVar.mo8174me()) {
                    reset();
                }
                detachAndScrapAttachedViews(nVar);
                m14404d(nVar, rVar, 0);
            }
        }
    }

    public int scrollHorizontallyBy(int i, C1025n nVar, C1031r rVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        int i2 = -i;
        int kN = ((getOrientationHelper().mo8694kN() - getOrientationHelper().mo8693kM()) / 2) + getOrientationHelper().mo8693kM();
        if (i > 0) {
            if (getPosition(getChildAt(getChildCount() - 1)) == getItemCount() - 1) {
                View childAt = getChildAt(getChildCount() - 1);
                if (childAt != null) {
                    i2 = -Math.max(0, Math.min(i, (((childAt.getRight() - childAt.getLeft()) / 2) + childAt.getLeft()) - kN));
                }
            }
        } else if (this.cfi == 0) {
            View childAt2 = getChildAt(0);
            if (childAt2 != null) {
                i2 = -Math.min(0, Math.max(i, (((childAt2.getRight() - childAt2.getLeft()) / 2) + childAt2.getLeft()) - kN));
            }
        }
        int i3 = -i2;
        getState().cfw = i3;
        m14405e(nVar, rVar, i3);
        offsetChildrenHorizontal(i2);
        return i3;
    }

    public int scrollVerticallyBy(int i, C1025n nVar, C1031r rVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        int i2 = -i;
        int kN = ((getOrientationHelper().mo8694kN() - getOrientationHelper().mo8693kM()) / 2) + getOrientationHelper().mo8693kM();
        if (i > 0) {
            if (getPosition(getChildAt(getChildCount() - 1)) == getItemCount() - 1) {
                View childAt = getChildAt(getChildCount() - 1);
                i2 = -Math.max(0, Math.min(i, (((getDecoratedBottom(childAt) - getDecoratedTop(childAt)) / 2) + getDecoratedTop(childAt)) - kN));
            }
        } else if (this.cfi == 0) {
            View childAt2 = getChildAt(0);
            i2 = -Math.min(0, Math.max(i, (((getDecoratedBottom(childAt2) - getDecoratedTop(childAt2)) / 2) + getDecoratedTop(childAt2)) - kN));
        }
        int i3 = -i2;
        getState().cfw = i3;
        m14405e(nVar, rVar, i3);
        offsetChildrenVertical(i2);
        return i3;
    }

    public void setCallbackInFling(boolean z) {
        this.cfq = z;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.cfs = onItemSelectedListener;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C1031r rVar, int i) {
        C5296a aVar = new C5296a(recyclerView.getContext());
        aVar.mo8152cq(i);
        startSmoothScroll(aVar);
    }
}
