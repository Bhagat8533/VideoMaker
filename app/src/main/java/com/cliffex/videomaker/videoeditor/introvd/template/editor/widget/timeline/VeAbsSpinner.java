package com.introvd.template.editor.widget.timeline;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

public abstract class VeAbsSpinner extends VeAdapterView<SpinnerAdapter> {

    /* renamed from: SZ */
    SpinnerAdapter f3534SZ;

    /* renamed from: UP */
    int f3535UP;

    /* renamed from: UQ */
    int f3536UQ;

    /* renamed from: UR */
    int f3537UR;

    /* renamed from: US */
    int f3538US;
    int dnI;
    int dnJ;
    protected boolean dnK;
    Rect dnL;
    View dnM;
    private Rect dnO;
    C7084a dwg;
    private DataSetObserver mDataSetObserver;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            /* renamed from: K */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: qt */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        long dnR;
        int position;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dnR = parcel.readLong();
            this.position = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VeAbsSpinner.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" selectedId=");
            sb.append(this.dnR);
            sb.append(" position=");
            sb.append(this.position);
            sb.append("}");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.dnR);
            parcel.writeInt(this.position);
        }
    }

    /* renamed from: com.introvd.template.editor.widget.timeline.VeAbsSpinner$a */
    class C7084a {
        private SparseArray<View> dnP = new SparseArray<>();

        C7084a() {
        }

        /* access modifiers changed from: 0000 */
        public void clear() {
            SparseArray<View> sparseArray = this.dnP;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View view = (View) sparseArray.valueAt(i);
                if (view != null) {
                    VeAbsSpinner.this.removeDetachedView(view, true);
                }
            }
            sparseArray.clear();
        }

        /* renamed from: f */
        public void mo31209f(int i, View view) {
            this.dnP.put(i, view);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: pO */
        public View mo31210pO(int i) {
            View view = (View) this.dnP.get(i);
            if (view != null) {
                this.dnP.delete(i);
            }
            return view;
        }
    }

    public VeAbsSpinner(Context context) {
        super(context);
        this.f3535UP = 0;
        this.f3536UQ = 0;
        this.f3537UR = 0;
        this.f3538US = 0;
        this.dnL = new Rect();
        this.dnM = null;
        this.dwg = new C7084a();
        atW();
    }

    public VeAbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VeAbsSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3535UP = 0;
        this.f3536UQ = 0;
        this.f3537UR = 0;
        this.f3538US = 0;
        this.dnL = new Rect();
        this.dnM = null;
        this.dwg = new C7084a();
        atW();
    }

    private void atW() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ad */
    public void mo31182ad(int i, boolean z) {
        if (i != this.doi) {
            this.dnK = true;
            int i2 = i - this.dof;
            setNextSelectedPositionInt(i);
            mo31183ae(i2, z);
            this.dnK = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ae */
    public abstract void mo31183ae(int i, boolean z);

    /* access modifiers changed from: 0000 */
    public void atX() {
        this.bXu = false;
        this.dnX = false;
        removeAllViewsInLayout();
        this.doi = -1;
        this.doj = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* access modifiers changed from: 0000 */
    public void atY() {
        int childCount = getChildCount();
        C7084a aVar = this.dwg;
        for (int i = 0; i < childCount; i++) {
            aVar.mo31209f(this.dnS + i, getChildAt(i));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cK */
    public int mo31186cK(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cL */
    public int mo31187cL(View view) {
        return view.getMeasuredWidth();
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public SpinnerAdapter getAdapter() {
        return this.f3534SZ;
    }

    public int getCount() {
        return this.aaE;
    }

    public View getSelectedView() {
        if (this.aaE <= 0 || this.dof < 0) {
            return null;
        }
        return getChildAt(this.dof - this.dnS);
    }

    /* access modifiers changed from: 0000 */
    public void handleDataChanged() {
        super.handleDataChanged();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r7)
            android.graphics.Rect r1 = r6.dnL
            int r2 = r6.getPaddingLeft()
            int r3 = r6.f3535UP
            if (r2 <= r3) goto L_0x0013
            int r2 = r6.getPaddingLeft()
            goto L_0x0015
        L_0x0013:
            int r2 = r6.f3535UP
        L_0x0015:
            r1.left = r2
            android.graphics.Rect r1 = r6.dnL
            int r2 = r6.getPaddingTop()
            int r3 = r6.f3536UQ
            if (r2 <= r3) goto L_0x0026
            int r2 = r6.getPaddingTop()
            goto L_0x0028
        L_0x0026:
            int r2 = r6.f3536UQ
        L_0x0028:
            r1.top = r2
            android.graphics.Rect r1 = r6.dnL
            int r2 = r6.getPaddingRight()
            int r3 = r6.f3537UR
            if (r2 <= r3) goto L_0x0039
            int r2 = r6.getPaddingRight()
            goto L_0x003b
        L_0x0039:
            int r2 = r6.f3537UR
        L_0x003b:
            r1.right = r2
            android.graphics.Rect r1 = r6.dnL
            int r2 = r6.getPaddingBottom()
            int r3 = r6.f3538US
            if (r2 <= r3) goto L_0x004c
            int r2 = r6.getPaddingBottom()
            goto L_0x004e
        L_0x004c:
            int r2 = r6.f3538US
        L_0x004e:
            r1.bottom = r2
            boolean r1 = r6.bXu
            if (r1 == 0) goto L_0x0057
            r6.handleDataChanged()
        L_0x0057:
            int r1 = r6.getSelectedItemPosition()
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 1
            r4 = 0
            if (r0 == r2) goto L_0x00b1
            if (r1 < 0) goto L_0x00b1
            android.widget.SpinnerAdapter r2 = r6.f3534SZ
            if (r2 == 0) goto L_0x00b1
            com.introvd.template.editor.widget.timeline.VeAbsSpinner$a r2 = r6.dwg
            android.view.View r2 = r2.mo31210pO(r1)
            if (r2 != 0) goto L_0x0076
            android.widget.SpinnerAdapter r2 = r6.f3534SZ
            r5 = 0
            android.view.View r2 = r2.getView(r1, r5, r6)
        L_0x0076:
            if (r2 == 0) goto L_0x007d
            com.introvd.template.editor.widget.timeline.VeAbsSpinner$a r5 = r6.dwg
            r5.mo31209f(r1, r2)
        L_0x007d:
            if (r2 == 0) goto L_0x00b1
            android.view.ViewGroup$LayoutParams r1 = r2.getLayoutParams()
            if (r1 != 0) goto L_0x0090
            r6.dnK = r3
            android.view.ViewGroup$LayoutParams r1 = r6.generateDefaultLayoutParams()
            r2.setLayoutParams(r1)
            r6.dnK = r4
        L_0x0090:
            r6.measureChild(r2, r7, r8)
            int r1 = r6.mo31186cK(r2)
            android.graphics.Rect r3 = r6.dnL
            int r3 = r3.top
            int r1 = r1 + r3
            android.graphics.Rect r3 = r6.dnL
            int r3 = r3.bottom
            int r1 = r1 + r3
            int r2 = r6.mo31187cL(r2)
            android.graphics.Rect r3 = r6.dnL
            int r3 = r3.left
            int r2 = r2 + r3
            android.graphics.Rect r3 = r6.dnL
            int r3 = r3.right
            int r2 = r2 + r3
            r3 = 0
            goto L_0x00b3
        L_0x00b1:
            r1 = 0
            r2 = 0
        L_0x00b3:
            if (r3 == 0) goto L_0x00c9
            android.graphics.Rect r1 = r6.dnL
            int r1 = r1.top
            android.graphics.Rect r3 = r6.dnL
            int r3 = r3.bottom
            int r1 = r1 + r3
            if (r0 != 0) goto L_0x00c9
            android.graphics.Rect r0 = r6.dnL
            int r0 = r0.left
            android.graphics.Rect r2 = r6.dnL
            int r2 = r2.right
            int r2 = r2 + r0
        L_0x00c9:
            int r0 = r6.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r1, r0)
            int r1 = r6.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = resolveSize(r0, r8)
            int r1 = resolveSize(r1, r7)
            r6.setMeasuredDimension(r1, r0)
            r6.dnI = r8
            r6.dnJ = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.widget.timeline.VeAbsSpinner.onMeasure(int, int):void");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.dnR >= 0) {
            this.bXu = true;
            this.dnX = true;
            this.dnV = savedState.dnR;
            this.dnU = savedState.position;
            this.dnY = 0;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.dnR = getSelectedItemId();
        if (savedState.dnR >= 0) {
            savedState.position = getSelectedItemPosition();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.dnO;
        if (rect == null) {
            this.dnO = new Rect();
            rect = this.dnO;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.dnS + childCount;
                }
            }
        }
        return -1;
    }

    public void requestLayout() {
        if (!this.dnK) {
            super.requestLayout();
        }
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f3534SZ != null) {
            this.f3534SZ.unregisterDataSetObserver(this.mDataSetObserver);
            atX();
        }
        this.f3534SZ = spinnerAdapter;
        int i = -1;
        this.doi = -1;
        this.doj = Long.MIN_VALUE;
        if (this.f3534SZ != null) {
            this.doh = this.aaE;
            this.aaE = this.f3534SZ.getCount();
            atZ();
            this.mDataSetObserver = new C7087b();
            this.f3534SZ.registerDataSetObserver(this.mDataSetObserver);
            if (this.aaE > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.aaE == 0) {
                auc();
            }
        } else {
            atZ();
            atX();
            auc();
        }
        requestLayout();
    }

    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    public void setSelection(int i, boolean z) {
        boolean z2 = true;
        if (!z || this.dnS > i || i > (this.dnS + getChildCount()) - 1) {
            z2 = false;
        }
        mo31182ad(i, z2);
    }
}
