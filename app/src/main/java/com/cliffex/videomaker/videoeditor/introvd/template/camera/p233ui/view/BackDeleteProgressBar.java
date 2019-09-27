package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.p203b.C4583d;
import java.util.ArrayList;
import java.util.Iterator;
import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.camera.ui.view.BackDeleteProgressBar */
public class BackDeleteProgressBar extends View {

    /* renamed from: Kj */
    private int f3438Kj = 0;
    private ArrayList<C5159a> bWA = null;
    private int bWB = 0;
    private float bWC = 1.0f;
    private int bWD = QUtils.VIDEO_RES_720P_HEIGHT;
    private int bWE = 2;
    private int bWF = 5;
    private int bWG = 1000;
    private boolean bWH = true;
    /* access modifiers changed from: private */
    public Runnable bWI = new Runnable() {
        public void run() {
            int durationLimit = C5008i.m12937VU().getDurationLimit();
            C5008i.m12937VU().getState();
            if (durationLimit != 0 && BackDeleteProgressBar.this.getBlink()) {
                BackDeleteProgressBar.this.postDelayed(BackDeleteProgressBar.this.bWI, 500);
                BackDeleteProgressBar.this.invalidate();
            }
        }
    };
    private boolean bWe = false;
    private Context mContext = null;
    private int mHeight = 0;
    private Paint mPaint = new Paint();
    private int mProgress = 0;

    /* renamed from: com.introvd.template.camera.ui.view.BackDeleteProgressBar$a */
    private static class C5159a {
        public int bWK;
        public boolean bWL = false;
        public int bWM;
        public int bWN;
        public int end;
        public int start;

        public C5159a(int i, int i2, int i3) {
            this.bWK = i3;
            this.start = i;
            this.end = i2;
        }
    }

    public BackDeleteProgressBar(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public BackDeleteProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public BackDeleteProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    /* access modifiers changed from: private */
    public boolean getBlink() {
        return this.bWe;
    }

    private C5159a getLastItem() {
        int size = this.bWA.size() - 2;
        if (size < 0) {
            return null;
        }
        return (C5159a) this.bWA.get(size);
    }

    private void init() {
        this.bWA = new ArrayList<>();
        this.bWA.add(new C5159a(0, 0, 0));
        this.bWD = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        this.bWC = ((float) this.bWD) / ((float) this.bWG);
        if (!isInEditMode()) {
            this.bWE = C4583d.m11670O(this.mContext, 1);
            this.bWF = C4583d.m11670O(this.mContext, 4);
        }
    }

    private void setBlink(boolean z) {
        this.bWe = z;
    }

    /* renamed from: XV */
    public void mo26110XV() {
        this.bWB += this.bWE;
        C5159a aVar = new C5159a(this.bWB, this.bWB, this.mProgress);
        aVar.bWM = this.bWB - this.bWE;
        aVar.bWN = this.bWB;
        this.bWA.add(aVar);
        this.f3438Kj++;
    }

    /* renamed from: XW */
    public void mo26111XW() {
        C5159a lastItem = getLastItem();
        if (lastItem != null) {
            lastItem.end = lastItem.start;
            lastItem.bWL = false;
            this.mProgress = lastItem.bWK;
            this.bWB = lastItem.bWM;
            if (this.f3438Kj >= 1) {
                this.bWA.remove(this.f3438Kj);
                this.f3438Kj--;
            }
            invalidate();
        }
    }

    /* renamed from: XX */
    public void mo26112XX() {
        C5159a lastItem = getLastItem();
        if (lastItem != null) {
            if (lastItem.start == 0 && lastItem.start == lastItem.end) {
                ArrayList<C5159a> arrayList = this.bWA;
                int i = this.f3438Kj;
                this.f3438Kj = i - 1;
                arrayList.remove(i);
                lastItem = (C5159a) this.bWA.get(this.f3438Kj);
            }
            lastItem.bWL = true;
            invalidate();
        }
    }

    /* renamed from: XY */
    public void mo26113XY() {
        C5159a lastItem = getLastItem();
        if (lastItem != null) {
            lastItem.bWL = false;
            this.bWB = lastItem.end;
            mo26110XV();
            invalidate();
        }
    }

    /* renamed from: XZ */
    public void mo26114XZ() {
        if (!getBlink()) {
            setBlink(true);
            removeCallbacks(this.bWI);
            post(this.bWI);
        }
    }

    /* renamed from: Ya */
    public void mo26115Ya() {
        setBlink(false);
    }

    /* renamed from: b */
    public void mo26116b(ArrayList<Integer> arrayList) {
        reset();
        this.bWA.clear();
        this.bWA = new ArrayList<>();
        this.bWA.add(new C5159a(0, 0, 0));
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((Integer) arrayList.get(i2)).intValue();
            setProgress(i);
            mo26110XV();
        }
        invalidate();
    }

    public int getMaxProgress() {
        return this.bWG;
    }

    public int getProgress() {
        return this.mProgress;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(-13880775);
        canvas.drawRect(0.0f, 0.0f, (float) this.bWD, (float) this.mHeight, this.mPaint);
        Iterator it = this.bWA.iterator();
        while (it.hasNext()) {
            C5159a aVar = (C5159a) it.next();
            if (aVar.end > aVar.start) {
                this.mPaint.setColor(-12498348);
                canvas.drawRect((float) aVar.bWM, 0.0f, (float) aVar.bWN, (float) this.mHeight, this.mPaint);
            }
            if (aVar.bWL) {
                this.mPaint.setColor(-65536);
                canvas.drawRect((float) aVar.start, 0.0f, (float) aVar.end, (float) this.mHeight, this.mPaint);
            } else {
                this.mPaint.setColor(-38095);
                canvas.drawRect((float) aVar.start, 0.0f, (float) aVar.end, (float) this.mHeight, this.mPaint);
            }
        }
        if (this.bWe) {
            int i = (int) (((float) this.mProgress) * this.bWC);
            if (this.bWH) {
                this.mPaint.setColor(0);
                canvas.drawRect((float) i, 0.0f, (float) (i + this.bWF), (float) this.mHeight, this.mPaint);
            } else {
                this.mPaint.setColor(-1);
                canvas.drawRect((float) i, 0.0f, (float) (i + this.bWF), (float) this.mHeight, this.mPaint);
            }
            this.bWH = !this.bWH;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        this.mHeight = size2;
        setMeasuredDimension(size, size2);
    }

    public void reset() {
        this.mProgress = 0;
        this.bWB = 0;
        this.bWA.clear();
        this.f3438Kj = 0;
        this.bWA.add(new C5159a(0, 0, 0));
        invalidate();
    }

    public void setProgress(int i) {
        this.mProgress = i;
        ((C5159a) this.bWA.get(this.f3438Kj)).end = (int) (((float) this.mProgress) * this.bWC);
        this.bWB = ((C5159a) this.bWA.get(this.f3438Kj)).end;
        invalidate();
    }
}
