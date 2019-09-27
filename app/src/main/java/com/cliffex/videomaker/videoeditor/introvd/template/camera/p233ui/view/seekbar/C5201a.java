package com.introvd.template.camera.p233ui.view.seekbar;

import com.introvd.template.camera.p233ui.view.seekbar.DraggableSeekBar.C5200a;
import com.introvd.template.common.LogUtils;

/* renamed from: com.introvd.template.camera.ui.view.seekbar.a */
public class C5201a {

    /* renamed from: Kj */
    private int f3445Kj = 0;
    /* access modifiers changed from: private */
    public Float[] bWS;
    private boolean cbh = false;
    /* access modifiers changed from: private */
    public C5203a cbi;
    private DraggableSeekBar cbj;
    private C5200a cbk = new C5200a() {
        /* renamed from: a */
        public void mo26346a(DraggableSeekBar draggableSeekBar) {
            LogUtils.m14222e("SeekBarManager", "onStartTrackingTouch");
            if (C5201a.this.cbi != null) {
                C5201a.this.cbi.mo26134Yc();
            }
        }

        /* renamed from: b */
        public void mo26347b(DraggableSeekBar draggableSeekBar) {
            int position = draggableSeekBar.getPosition();
            if (C5201a.this.cbi != null) {
                float floatValue = C5201a.this.bWS[position].floatValue();
                StringBuilder sb = new StringBuilder();
                sb.append("onStopTrackingTouch=");
                sb.append(position);
                sb.append(";speedValue=");
                sb.append(floatValue);
                LogUtils.m14222e("SeekBarManager", sb.toString());
                C5201a.this.cbi.mo26133R(floatValue);
            }
        }

        /* renamed from: iD */
        public void mo26348iD(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onProgressChanged=");
            sb.append(i);
            LogUtils.m14222e("SeekBarManager", sb.toString());
            if (C5201a.this.cbi != null) {
                float floatValue = C5201a.this.bWS[i].floatValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onStopTrackingTouch=");
                sb2.append(i);
                sb2.append(";speedValue=");
                sb2.append(floatValue);
                LogUtils.m14222e("SeekBarManager", sb2.toString());
                C5201a.this.cbi.mo26133R(floatValue);
            }
        }
    };

    /* renamed from: com.introvd.template.camera.ui.view.seekbar.a$a */
    public interface C5203a {
        /* renamed from: R */
        void mo26133R(float f);

        /* renamed from: Yc */
        void mo26134Yc();
    }

    public C5201a(DraggableSeekBar draggableSeekBar, boolean z) {
        this.cbj = draggableSeekBar;
        this.cbh = z;
    }

    /* renamed from: X */
    private int m14199X(float f) {
        int i = 0;
        for (Float floatValue : this.bWS) {
            if (m14202r(floatValue.floatValue(), f)) {
                return i;
            }
            i++;
        }
        return 5;
    }

    /* renamed from: r */
    private boolean m14202r(float f, float f2) {
        return ((double) Math.abs(f - f2)) < 1.0E-5d;
    }

    /* renamed from: a */
    public void mo26349a(C5203a aVar) {
        this.cbi = aVar;
    }

    /* renamed from: a */
    public void mo26350a(String[] strArr, String[] strArr2, Float[] fArr, float f, int i, boolean z, boolean z2) {
        this.bWS = fArr;
        this.f3445Kj = m14199X(f);
        this.cbj.setmTxtArr(strArr);
        this.cbj.setBubbleTxtArr(strArr2);
        this.cbj.setValueArr(fArr);
        this.cbj.mo26323dC(z);
        this.cbj.setScaleValueVisibility(z2);
        if (this.cbh) {
            this.cbj.setScreenOrientation(1);
            this.cbj.setmDefaultColor(-1);
        } else {
            this.cbj.setScreenOrientation(2);
            this.cbj.setmDefaultColor(i);
        }
        this.cbj.setDashLinesCount(0);
        this.cbj.setSubsectionNum(5);
        this.cbj.setPostion(this.f3445Kj);
        this.cbj.setOnTextSeekbarChangeListener(this.cbk);
    }

    public void update(float f) {
        this.f3445Kj = m14199X(f);
        this.cbj.setPostion(this.f3445Kj);
        this.cbj.postInvalidate();
    }
}
