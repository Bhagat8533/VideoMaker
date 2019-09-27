package com.introvd.template.common;

import com.introvd.template.p414ui.view.TextSeekBar;
import com.introvd.template.p414ui.view.TextSeekBar.C8983a;

public class SpeedUIManager {

    /* renamed from: Kj */
    private int f3446Kj = 0;
    private String[] bWQ = {"1/4x", "1x", "2x", "3x", "4x"};
    /* access modifiers changed from: private */
    public Float[] bWS = {Float.valueOf(4.0f), Float.valueOf(3.0f), Float.valueOf(2.0f), Float.valueOf(1.5f), Float.valueOf(1.25f), Float.valueOf(1.0f), Float.valueOf(0.9f), Float.valueOf(0.8f), Float.valueOf(0.7f), Float.valueOf(0.6f), Float.valueOf(0.5f), Float.valueOf(0.467f), Float.valueOf(0.433f), Float.valueOf(0.4f), Float.valueOf(0.367f), Float.valueOf(0.333f), Float.valueOf(0.316f), Float.valueOf(0.3f), Float.valueOf(0.283f), Float.valueOf(0.267f), Float.valueOf(0.25f)};
    private boolean cbh = false;
    /* access modifiers changed from: private */
    public TextSeekBar ccK;
    /* access modifiers changed from: private */
    public C5231a ccL;
    private C8983a ccM = new C8983a() {
        /* renamed from: a */
        public void mo26415a(TextSeekBar textSeekBar) {
            LogUtils.m14222e("SpeedUIManager", "onStartTrackingTouch=");
            if (SpeedUIManager.this.ccL != null) {
                SpeedUIManager.this.ccL.onSpeedChangeStart();
            }
        }

        /* renamed from: b */
        public void mo26416b(TextSeekBar textSeekBar) {
            int position = textSeekBar.getPosition();
            if (SpeedUIManager.this.ccL != null) {
                float floatValue = SpeedUIManager.this.bWS[position].floatValue();
                StringBuilder sb = new StringBuilder();
                sb.append("onStopTrackingTouch=");
                sb.append(position);
                sb.append(";speedValue=");
                sb.append(floatValue);
                LogUtils.m14222e("SpeedUIManager", sb.toString());
                SpeedUIManager.this.ccL.onSpeedChanged(floatValue);
                SpeedUIManager.this.ccL.onSpeedChangeStop();
            }
        }

        /* renamed from: iD */
        public void mo26417iD(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onProgressChanged=");
            sb.append(i);
            LogUtils.m14222e("SpeedUIManager", sb.toString());
            int position = SpeedUIManager.this.ccK.getPosition();
            if (SpeedUIManager.this.ccL != null) {
                SpeedUIManager.this.ccL.onSpeedTrackingChange(SpeedUIManager.this.bWS[position].floatValue());
            }
        }
    };

    public static class SimpleSpeedChangeListener implements C5231a {
        public void onSpeedChangeStart() {
        }

        public void onSpeedChangeStop() {
        }

        public void onSpeedChanged(float f) {
        }

        public void onSpeedTrackingChange(float f) {
        }
    }

    /* renamed from: com.introvd.template.common.SpeedUIManager$a */
    private interface C5231a {
        void onSpeedChangeStart();

        void onSpeedChangeStop();

        void onSpeedChanged(float f);

        void onSpeedTrackingChange(float f);
    }

    public SpeedUIManager(TextSeekBar textSeekBar, boolean z) {
        this.ccK = textSeekBar;
        this.cbh = z;
    }

    /* renamed from: X */
    private int m14252X(float f) {
        int i = 0;
        for (Float floatValue : this.bWS) {
            if (((double) Math.abs(floatValue.floatValue() - f)) < 0.01d) {
                return i;
            }
            i++;
        }
        return 5;
    }

    public void initViewState(float f) {
        this.f3446Kj = m14252X(f);
        this.ccK.setmTxtArr(this.bWQ);
        if (this.cbh) {
            this.ccK.setScreenOrientation(1);
            this.ccK.setmDefaultColor(-1);
        } else {
            this.ccK.setScreenOrientation(2);
            this.ccK.setmDefaultColor(-9408400);
        }
        this.ccK.setDashLinesCount(0);
        this.ccK.setSubsectionNum(5);
        this.ccK.setPostion(this.f3446Kj);
        this.ccK.setOnTextSeekbarChangeListener(this.ccM);
    }

    public void setmOnSpeedChangeListener(C5231a aVar) {
        this.ccL = aVar;
    }

    public void update(float f) {
        this.f3446Kj = m14252X(f);
        this.ccK.setPostion(this.f3446Kj);
        this.ccK.postInvalidate();
    }
}
