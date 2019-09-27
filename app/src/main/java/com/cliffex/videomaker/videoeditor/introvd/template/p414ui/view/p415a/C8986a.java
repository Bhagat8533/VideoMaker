package com.introvd.template.p414ui.view.p415a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.p031a.C1072a.C1078a;
import android.view.View;
import com.introvd.template.common.LogUtils;

/* renamed from: com.introvd.template.ui.view.a.a */
public class C8986a extends C1078a {
    private C8987a ezI;
    private Drawable ezJ;
    private int ezK = -1;
    private C8988b ezL;
    private int ezM = -1;
    private int ezN = -1;
    private boolean ezO;

    /* renamed from: com.introvd.template.ui.view.a.a$a */
    public interface C8987a {
        /* renamed from: cp */
        void mo28031cp(int i, int i2);

        /* renamed from: lo */
        void mo28032lo(int i);
    }

    /* renamed from: com.introvd.template.ui.view.a.a$b */
    public interface C8988b {
        /* renamed from: D */
        void mo29870D(View view, int i);

        /* renamed from: cM */
        void mo29871cM(int i, int i2);
    }

    /* renamed from: com.introvd.template.ui.view.a.a$c */
    public static class C8989c implements C8988b {
        /* renamed from: D */
        public void mo29870D(View view, int i) {
        }

        /* renamed from: cM */
        public void mo29871cM(int i, int i2) {
        }
    }

    public C8986a(C8987a aVar) {
        this.ezI = aVar;
    }

    public C8986a(C8987a aVar, boolean z) {
        this.ezI = aVar;
        this.ezO = z;
        StringBuilder sb = new StringBuilder();
        sb.append("Init isLongPressDragEnabled:");
        sb.append(z);
        LogUtils.m14223i("DragItemTouchCallback", sb.toString());
    }

    /* renamed from: a */
    public int mo8612a(RecyclerView recyclerView, C1034u uVar) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            return m3452aQ(15, 0);
        }
        int i = 3;
        if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return m3452aQ(3, 0);
        }
        if (((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation() == 0) {
            i = 12;
        }
        return m3452aQ(i, 0);
    }

    /* renamed from: a */
    public void mo8615a(Canvas canvas, RecyclerView recyclerView, C1034u uVar, float f, float f2, int i, boolean z) {
        if (i == 1) {
            uVar.itemView.setAlpha(1.0f - (Math.abs(f) / ((float) uVar.itemView.getWidth())));
            uVar.itemView.setTranslationX(f);
            return;
        }
        super.mo8615a(canvas, recyclerView, uVar, f, f2, i, z);
    }

    /* renamed from: a */
    public void mo35758a(C8988b bVar) {
        this.ezL = bVar;
    }

    /* renamed from: b */
    public boolean mo8623b(RecyclerView recyclerView, C1034u uVar, C1034u uVar2) {
        int adapterPosition = uVar.getAdapterPosition();
        int adapterPosition2 = uVar2.getAdapterPosition();
        if (this.ezM == -1) {
            this.ezM = adapterPosition;
        }
        this.ezN = adapterPosition2;
        StringBuilder sb = new StringBuilder();
        sb.append("--->onMove :from #");
        sb.append(adapterPosition);
        sb.append(",to#");
        sb.append(adapterPosition2);
        LogUtils.m14223i("DragItemTouchCallback", sb.toString());
        this.ezI.mo28031cp(adapterPosition, adapterPosition2);
        return true;
    }

    /* renamed from: d */
    public void mo8625d(RecyclerView recyclerView, C1034u uVar) {
        super.mo8625d(recyclerView, uVar);
        uVar.itemView.setAlpha(1.0f);
        if (this.ezJ != null) {
            uVar.itemView.setBackgroundDrawable(this.ezJ);
        }
        if (this.ezK != -1) {
            uVar.itemView.setBackgroundColor(this.ezK);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("--->clearView view==");
        sb.append(uVar.itemView.toString());
        LogUtils.m14223i("DragItemTouchCallback", sb.toString());
        if (this.ezL != null) {
            this.ezL.mo29871cM(this.ezM, this.ezN);
        }
        this.ezM = -1;
        this.ezN = -1;
    }

    /* renamed from: g */
    public void mo8626g(C1034u uVar, int i) {
        this.ezI.mo28032lo(uVar.getAdapterPosition());
    }

    /* renamed from: h */
    public void mo8627h(C1034u uVar, int i) {
        if (i != 0) {
            if (this.ezJ == null && this.ezK == -1) {
                Drawable background = uVar.itemView.getBackground();
                if (background == null) {
                    this.ezK = 0;
                } else {
                    this.ezJ = background;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("--->onSelectedChanged actionState==");
            sb.append(i);
            sb.append(",view = ");
            sb.append(uVar.itemView.toString());
            LogUtils.m14223i("DragItemTouchCallback", sb.toString());
            if (i == 2 && this.ezL != null) {
                this.ezL.mo29870D(uVar.itemView, uVar.getAdapterPosition());
            }
        }
        super.mo8627h(uVar, i);
    }

    /* renamed from: jL */
    public void mo35759jL(boolean z) {
        this.ezO = z;
    }

    /* renamed from: nP */
    public boolean mo8628nP() {
        return this.ezO;
    }

    /* renamed from: nQ */
    public boolean mo8629nQ() {
        return true;
    }
}
