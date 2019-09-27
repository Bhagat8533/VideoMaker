package com.introvd.template.editor.videotrim.p292ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

/* renamed from: com.introvd.template.editor.videotrim.ui.VeAdapterView */
public abstract class VeAdapterView<T extends Adapter> extends ViewGroup {
    @ExportedProperty
    int aaE;
    boolean bXu;
    boolean dnK = false;
    @ExportedProperty
    int dnS = 0;
    int dnT;
    int dnU;
    long dnV = Long.MIN_VALUE;
    long dnW;
    boolean dnX = false;
    int dnY;
    private int dnZ;
    C6992e doa;
    C6990c dob;
    C6991d doc;
    @ExportedProperty
    int dod = -1;
    long doe = Long.MIN_VALUE;
    @ExportedProperty
    int dof = -1;
    long dog = Long.MIN_VALUE;
    int doh;
    int doi = -1;
    long doj = Long.MIN_VALUE;
    private boolean dok;
    private boolean dol;
    private C6993f dom;
    private View mEmptyView;
    boolean mInLayout = false;

    /* renamed from: com.introvd.template.editor.videotrim.ui.VeAdapterView$a */
    public static class C6988a implements ContextMenuInfo {

        /* renamed from: id */
        public long f3525id;
        public int position;
        public View targetView;

        public C6988a(View view, int i, long j) {
            this.targetView = view;
            this.position = i;
            this.f3525id = j;
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VeAdapterView$b */
    class C6989b extends DataSetObserver {
        private Parcelable don = null;

        C6989b() {
        }

        public void onChanged() {
            VeAdapterView.this.bXu = true;
            VeAdapterView.this.doh = VeAdapterView.this.aaE;
            VeAdapterView.this.aaE = VeAdapterView.this.getAdapter().getCount();
            if (!VeAdapterView.this.getAdapter().hasStableIds() || this.don == null || VeAdapterView.this.doh != 0 || VeAdapterView.this.aaE <= 0) {
                VeAdapterView.this.aue();
            } else {
                VeAdapterView.this.onRestoreInstanceState(this.don);
                this.don = null;
            }
            VeAdapterView.this.atZ();
            VeAdapterView.this.requestLayout();
        }

        public void onInvalidated() {
            VeAdapterView.this.bXu = true;
            if (VeAdapterView.this.getAdapter().hasStableIds()) {
                this.don = VeAdapterView.this.onSaveInstanceState();
            }
            VeAdapterView.this.doh = VeAdapterView.this.aaE;
            VeAdapterView.this.aaE = 0;
            VeAdapterView.this.dof = -1;
            VeAdapterView.this.dog = Long.MIN_VALUE;
            VeAdapterView.this.dod = -1;
            VeAdapterView.this.doe = Long.MIN_VALUE;
            VeAdapterView.this.dnX = false;
            VeAdapterView.this.auc();
            VeAdapterView.this.atZ();
            VeAdapterView.this.requestLayout();
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VeAdapterView$c */
    public interface C6990c {
        /* renamed from: a */
        void mo30783a(VeAdapterView<?> veAdapterView, View view, int i, long j);
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VeAdapterView$d */
    public interface C6991d {
        /* renamed from: b */
        boolean mo30784b(VeAdapterView<?> veAdapterView, View view, int i, long j);
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VeAdapterView$e */
    public interface C6992e {
        /* renamed from: c */
        void mo30785c(VeAdapterView<?> veAdapterView);

        /* renamed from: c */
        void mo30786c(VeAdapterView<?> veAdapterView, View view, int i, long j);
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.VeAdapterView$f */
    private class C6993f extends Handler implements Runnable {
        private C6993f() {
        }

        public void run() {
            if (VeAdapterView.this.bXu) {
                post(this);
            } else {
                VeAdapterView.this.aub();
            }
        }
    }

    public VeAdapterView(Context context) {
        super(context);
    }

    public VeAdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VeAdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: private */
    public void aub() {
        if (this.doa != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.doa.mo30786c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
            } else {
                this.doa.mo30785c(this);
            }
        }
    }

    @SuppressLint({"WrongCall"})
    /* renamed from: ht */
    private void m20449ht(boolean z) {
        if (isInFilterMode()) {
            z = false;
        }
        if (z) {
            if (this.mEmptyView != null) {
                this.mEmptyView.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.bXu) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.mEmptyView != null) {
            this.mEmptyView.setVisibility(8);
        }
        setVisibility(0);
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in VeAdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in VeAdapterView");
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in VeAdapterView");
    }

    public void addView(View view, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in VeAdapterView");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: af */
    public int mo30745af(int i, boolean z) {
        return i;
    }

    /* access modifiers changed from: 0000 */
    public void atZ() {
        Adapter adapter = getAdapter();
        boolean z = false;
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.dol);
        super.setFocusable(z2 && this.dok);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            m20449ht(z);
        }
    }

    /* access modifiers changed from: 0000 */
    public void aua() {
        if (this.doa != null) {
            if (this.mInLayout || this.dnK) {
                if (this.dom == null) {
                    this.dom = new C6993f<>();
                }
                this.dom.post(this.dom);
            } else {
                aub();
            }
        }
        if (this.dof != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    /* access modifiers changed from: 0000 */
    public void auc() {
        if (this.dof != this.doi || this.dog != this.doj) {
            aua();
            this.doi = this.dof;
            this.doj = this.dog;
        }
    }

    /* access modifiers changed from: 0000 */
    public int aud() {
        int i = this.aaE;
        if (i == 0) {
            return -1;
        }
        long j = this.dnV;
        int i2 = this.dnU;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int i3 = i - 1;
        int min = Math.min(i3, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i4 = min;
        int i5 = i4;
        loop0:
        while (true) {
            boolean z = false;
            while (SystemClock.uptimeMillis() <= uptimeMillis) {
                if (adapter.getItemId(min) != j) {
                    boolean z2 = i4 == i3;
                    boolean z3 = i5 == 0;
                    if (z2 && z3) {
                        break loop0;
                    } else if (z3 || (z && !z2)) {
                        i4++;
                        min = i4;
                    } else if (z2 || !z) {
                        i5--;
                        min = i5;
                        z = true;
                    }
                } else {
                    return min;
                }
            }
            break loop0;
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public void aue() {
        if (getChildCount() > 0) {
            this.dnX = true;
            this.dnW = (long) this.dnZ;
            if (this.dof >= 0) {
                View childAt = getChildAt(this.dof - this.dnS);
                this.dnV = this.doe;
                this.dnU = this.dod;
                if (childAt != null) {
                    this.dnT = childAt.getTop();
                }
                this.dnY = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapter = getAdapter();
            if (this.dnS < 0 || this.dnS >= adapter.getCount()) {
                this.dnV = -1;
            } else {
                this.dnV = adapter.getItemId(this.dnS);
            }
            this.dnU = this.dnS;
            if (childAt2 != null) {
                this.dnT = childAt2.getTop();
            }
            this.dnY = 1;
        }
    }

    /* access modifiers changed from: protected */
    public boolean canAnimate() {
        return super.canAnimate() && this.aaE > 0;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 8) {
            accessibilityEvent.setEventType(4);
        }
        View selectedView = getSelectedView();
        boolean dispatchPopulateAccessibilityEvent = selectedView != null ? selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent) : false;
        if (!dispatchPopulateAccessibilityEvent) {
            if (selectedView != null) {
                accessibilityEvent.setEnabled(selectedView.isEnabled());
            }
            accessibilityEvent.setItemCount(getCount());
            accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        }
        return dispatchPopulateAccessibilityEvent;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public abstract T getAdapter();

    @CapturedViewProperty
    public int getCount() {
        return this.aaE;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public int getFirstVisiblePosition() {
        return this.dnS;
    }

    public long getItemIdAtPosition(int i) {
        Adapter adapter = getAdapter();
        if (adapter == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i);
    }

    public int getLastVisiblePosition() {
        return (this.dnS + getChildCount()) - 1;
    }

    public final C6990c getOnItemClickListener() {
        return this.dob;
    }

    public final C6991d getOnItemLongClickListener() {
        return this.doc;
    }

    public final C6992e getOnItemSelectedListener() {
        return this.doa;
    }

    public int getPositionForView(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException unused) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return this.dnS + i;
            }
        }
        return -1;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @CapturedViewProperty
    public long getSelectedItemId() {
        return this.doe;
    }

    @CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.dod;
    }

    public abstract View getSelectedView();

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleDataChanged() {
        /*
            r5 = this;
            int r0 = r5.aaE
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0041
            boolean r3 = r5.dnX
            if (r3 == 0) goto L_0x001d
            r5.dnX = r2
            int r3 = r5.aud()
            if (r3 < 0) goto L_0x001d
            int r4 = r5.mo30745af(r3, r1)
            if (r4 != r3) goto L_0x001d
            r5.setNextSelectedPositionInt(r3)
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            if (r3 != 0) goto L_0x003f
            int r4 = r5.getSelectedItemPosition()
            if (r4 < r0) goto L_0x0028
            int r0 = r0 - r1
            goto L_0x0029
        L_0x0028:
            r0 = r4
        L_0x0029:
            if (r0 >= 0) goto L_0x002c
            r0 = 0
        L_0x002c:
            int r4 = r5.mo30745af(r0, r1)
            if (r4 >= 0) goto L_0x0036
            int r4 = r5.mo30745af(r0, r2)
        L_0x0036:
            if (r4 < 0) goto L_0x003f
            r5.setNextSelectedPositionInt(r4)
            r5.auc()
            goto L_0x0042
        L_0x003f:
            r1 = r3
            goto L_0x0042
        L_0x0041:
            r1 = 0
        L_0x0042:
            if (r1 != 0) goto L_0x0054
            r0 = -1
            r5.dof = r0
            r3 = -9223372036854775808
            r5.dog = r3
            r5.dod = r0
            r5.doe = r3
            r5.dnX = r2
            r5.auc()
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.videotrim.p292ui.VeAdapterView.handleDataChanged():void");
    }

    /* access modifiers changed from: 0000 */
    public boolean isInFilterMode() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.dnZ = getHeight();
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.dob == null) {
            return false;
        }
        playSoundEffect(0);
        this.dob.mo30783a(this, view, i, j);
        return true;
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in VeAdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in VeAdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in VeAdapterView");
    }

    public abstract void setAdapter(T t);

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        Adapter adapter = getAdapter();
        m20449ht(adapter == null || adapter.isEmpty());
    }

    public void setFocusable(boolean z) {
        Adapter adapter = getAdapter();
        boolean z2 = true;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.dok = z;
        if (!z) {
            this.dol = false;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        Adapter adapter = getAdapter();
        boolean z2 = false;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.dol = z;
        if (z) {
            this.dok = true;
        }
        if (z && (!z3 || isInFilterMode())) {
            z2 = true;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* access modifiers changed from: 0000 */
    public void setNextSelectedPositionInt(int i) {
        this.dod = i;
        this.doe = getItemIdAtPosition(i);
        if (this.dnX && this.dnY == 0 && i >= 0) {
            this.dnU = i;
            this.dnV = this.doe;
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an VeAdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(C6990c cVar) {
        this.dob = cVar;
    }

    public void setOnItemLongClickListener(C6991d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.doc = dVar;
    }

    public void setOnItemSelectedListener(C6992e eVar) {
        this.doa = eVar;
    }

    /* access modifiers changed from: 0000 */
    public void setSelectedPositionInt(int i) {
        this.dof = i;
        this.dog = getItemIdAtPosition(i);
    }

    public abstract void setSelection(int i);
}
