package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.introvd.template.camera.ui.view.HorizontalListView */
public class HorizontalListView extends AdapterView<ListAdapter> {
    protected int aNk;
    private Runnable akM = new Runnable() {
        public void run() {
            HorizontalListView.this.requestLayout();
        }
    };
    public boolean bXj = true;
    /* access modifiers changed from: private */
    public int bXk = -1;
    private int bXl = 0;
    protected int bXm;
    private int bXn = Integer.MAX_VALUE;
    private int bXo = 0;
    private GestureDetector bXp;
    private Queue<View> bXq = new LinkedList();
    /* access modifiers changed from: private */
    public OnItemSelectedListener bXr;
    /* access modifiers changed from: private */
    public OnItemClickListener bXs;
    /* access modifiers changed from: private */
    public OnItemLongClickListener bXt;
    /* access modifiers changed from: private */
    public boolean bXu = false;
    private DataSetObserver bXv = new DataSetObserver() {
        public void onChanged() {
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.bXu = true;
            }
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        public void onInvalidated() {
            HorizontalListView.this.reset();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    };
    private OnGestureListener bXw = new SimpleOnGestureListener() {
        /* renamed from: a */
        private boolean m14041a(MotionEvent motionEvent, View view) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int width = view.getWidth() + i;
            int i2 = iArr[1];
            rect.set(i, i2, width, view.getHeight() + i2);
            return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }

        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.onDown(motionEvent);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return HorizontalListView.this.onFling(motionEvent, motionEvent2, f, f2);
        }

        public void onLongPress(MotionEvent motionEvent) {
            int childCount = HorizontalListView.this.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = HorizontalListView.this.getChildAt(i);
                if (!m14041a(motionEvent, childAt)) {
                    i++;
                } else if (HorizontalListView.this.bXt != null) {
                    HorizontalListView.this.bXt.onItemLongClick(HorizontalListView.this, childAt, HorizontalListView.this.bXk + 1 + i, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.bXk + 1 + i));
                    return;
                } else {
                    return;
                }
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.bXm += (int) f;
            }
            HorizontalListView.this.requestLayout();
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int i = 0;
            while (true) {
                if (i >= HorizontalListView.this.getChildCount()) {
                    break;
                }
                View childAt = HorizontalListView.this.getChildAt(i);
                if (m14041a(motionEvent, childAt)) {
                    if (HorizontalListView.this.bXs != null) {
                        HorizontalListView.this.bXs.onItemClick(HorizontalListView.this, childAt, HorizontalListView.this.bXk + 1 + i, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.bXk + 1 + i));
                    }
                    if (HorizontalListView.this.bXr != null) {
                        HorizontalListView.this.bXr.onItemSelected(HorizontalListView.this, childAt, HorizontalListView.this.bXk + 1 + i, HorizontalListView.this.mAdapter.getItemId(HorizontalListView.this.bXk + 1 + i));
                    }
                } else {
                    i++;
                }
            }
            return true;
        }
    };
    protected ListAdapter mAdapter;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14028Oj();
    }

    /* renamed from: Oj */
    private synchronized void m14028Oj() {
        this.bXk = -1;
        this.bXl = 0;
        this.bXo = 0;
        this.aNk = 0;
        this.bXm = 0;
        this.bXn = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.bXp = new GestureDetector(getContext(), this.bXw);
    }

    /* renamed from: cd */
    private void m14033cd(int i, int i2) {
        while (i + i2 < getWidth() && this.bXl < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.bXl, (View) this.bXq.poll(), this);
            m14040x(view, -1);
            i += view.getMeasuredWidth();
            if (this.bXl == this.mAdapter.getCount() - 1) {
                this.bXn = (this.aNk + i) - getWidth();
            }
            if (this.bXn < 0) {
                this.bXn = 0;
            }
            this.bXl++;
        }
    }

    /* renamed from: ce */
    private void m14034ce(int i, int i2) {
        while (i + i2 > 0 && this.bXk >= 0) {
            View view = this.mAdapter.getView(this.bXk, (View) this.bXq.poll(), this);
            m14040x(view, 0);
            i -= view.getMeasuredWidth();
            this.bXk--;
            this.bXo -= view.getMeasuredWidth();
        }
    }

    /* renamed from: jC */
    private void m14037jC(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        int i2 = 0;
        m14033cd(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        if (childAt2 != null) {
            i2 = childAt2.getLeft();
        }
        m14034ce(i2, i);
    }

    /* renamed from: jD */
    private void m14038jD(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.bXo += childAt.getMeasuredWidth();
            this.bXq.offer(childAt);
            removeViewInLayout(childAt);
            this.bXk++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.bXq.offer(childAt2);
            removeViewInLayout(childAt2);
            this.bXl--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* renamed from: jE */
    private void m14039jE(int i) {
        if (getChildCount() > 0) {
            this.bXo += i;
            int i2 = this.bXo;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += measuredWidth + childAt.getPaddingRight();
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void reset() {
        m14028Oj();
        removeAllViewsInLayout();
        requestLayout();
    }

    /* renamed from: x */
    private void m14040x(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.bXp.onTouchEvent(motionEvent) | super.dispatchTouchEvent(motionEvent);
    }

    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    public View getSelectedView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean onDown(MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.bXm, 0, (int) (-f), 0, 0, this.bXn, 0, 0);
        }
        requestLayout();
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        /*
            r0 = this;
            monitor-enter(r0)
            super.onLayout(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0067 }
            android.widget.ListAdapter r1 = r0.mAdapter     // Catch:{ all -> 0x0067 }
            if (r1 != 0) goto L_0x000a
            monitor-exit(r0)
            return
        L_0x000a:
            boolean r1 = r0.bXu     // Catch:{ all -> 0x0067 }
            r2 = 0
            if (r1 == 0) goto L_0x001b
            int r1 = r0.aNk     // Catch:{ all -> 0x0067 }
            r0.m14028Oj()     // Catch:{ all -> 0x0067 }
            r0.removeAllViewsInLayout()     // Catch:{ all -> 0x0067 }
            r0.bXm = r1     // Catch:{ all -> 0x0067 }
            r0.bXu = r2     // Catch:{ all -> 0x0067 }
        L_0x001b:
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x0067 }
            boolean r1 = r1.computeScrollOffset()     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x002b
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x0067 }
            int r1 = r1.getCurrX()     // Catch:{ all -> 0x0067 }
            r0.bXm = r1     // Catch:{ all -> 0x0067 }
        L_0x002b:
            int r1 = r0.bXm     // Catch:{ all -> 0x0067 }
            r3 = 1
            if (r1 > 0) goto L_0x0037
            r0.bXm = r2     // Catch:{ all -> 0x0067 }
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x0067 }
            r1.forceFinished(r3)     // Catch:{ all -> 0x0067 }
        L_0x0037:
            int r1 = r0.bXm     // Catch:{ all -> 0x0067 }
            int r2 = r0.bXn     // Catch:{ all -> 0x0067 }
            if (r1 < r2) goto L_0x0046
            int r1 = r0.bXn     // Catch:{ all -> 0x0067 }
            r0.bXm = r1     // Catch:{ all -> 0x0067 }
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x0067 }
            r1.forceFinished(r3)     // Catch:{ all -> 0x0067 }
        L_0x0046:
            int r1 = r0.aNk     // Catch:{ all -> 0x0067 }
            int r2 = r0.bXm     // Catch:{ all -> 0x0067 }
            int r1 = r1 - r2
            r0.m14038jD(r1)     // Catch:{ all -> 0x0067 }
            r0.m14037jC(r1)     // Catch:{ all -> 0x0067 }
            r0.m14039jE(r1)     // Catch:{ all -> 0x0067 }
            int r1 = r0.bXm     // Catch:{ all -> 0x0067 }
            r0.aNk = r1     // Catch:{ all -> 0x0067 }
            android.widget.Scroller r1 = r0.mScroller     // Catch:{ all -> 0x0067 }
            boolean r1 = r1.isFinished()     // Catch:{ all -> 0x0067 }
            if (r1 != 0) goto L_0x0065
            java.lang.Runnable r1 = r0.akM     // Catch:{ all -> 0x0067 }
            r0.post(r1)     // Catch:{ all -> 0x0067 }
        L_0x0065:
            monitor-exit(r0)
            return
        L_0x0067:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p233ui.view.HorizontalListView.onLayout(boolean, int, int, int, int):void");
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.bXv);
        }
        this.mAdapter = listAdapter;
        this.mAdapter.registerDataSetObserver(this.bXv);
        reset();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.bXs = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.bXt = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.bXr = onItemSelectedListener;
    }

    public void setSelection(int i) {
    }
}
