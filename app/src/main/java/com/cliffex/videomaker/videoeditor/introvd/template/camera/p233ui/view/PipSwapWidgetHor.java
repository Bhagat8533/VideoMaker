package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.camera.p208a.C4665d;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.sdk.utils.C8562q;
import com.introvd.template.vivacamera.R;
import com.mediarecorder.engine.QPIPFrameParam;
import xiaoying.utils.QPoint;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.camera.ui.view.PipSwapWidgetHor */
public class PipSwapWidgetHor extends RelativeLayout {
    /* access modifiers changed from: private */
    public QPIPFrameParam bRF;
    private int bRG = 1;
    private ImageView bXE;
    private C4665d bXF;
    /* access modifiers changed from: private */
    public int bXG;
    private Context mContext;
    private Handler mHandler;

    /* renamed from: com.introvd.template.camera.ui.view.PipSwapWidgetHor$a */
    private static class C5173a extends WeakHandler<PipSwapWidgetHor> {
        public C5173a(PipSwapWidgetHor pipSwapWidgetHor) {
            super(pipSwapWidgetHor);
        }

        public void handleMessage(Message message) {
            PipSwapWidgetHor pipSwapWidgetHor = (PipSwapWidgetHor) getOwner();
            if (pipSwapWidgetHor != null) {
                if (message.what == 4097) {
                    pipSwapWidgetHor.mo26188c(pipSwapWidgetHor.bXG, pipSwapWidgetHor.bRF);
                }
                super.handleMessage(message);
            }
        }
    }

    /* renamed from: com.introvd.template.camera.ui.view.PipSwapWidgetHor$b */
    public static class C5174b {

        /* renamed from: com.introvd.template.camera.ui.view.PipSwapWidgetHor$b$a */
        public static class C5175a {

            /* renamed from: x */
            public float f3440x;

            /* renamed from: y */
            public float f3441y;

            public C5175a() {
                this.f3440x = 0.0f;
                this.f3441y = 0.0f;
                this.f3440x = 0.0f;
                this.f3441y = 0.0f;
            }

            public C5175a(float f, float f2) {
                this.f3440x = 0.0f;
                this.f3441y = 0.0f;
                this.f3440x = f;
                this.f3441y = f2;
            }
        }

        /* renamed from: a */
        public static C5175a m14056a(float f, C5175a aVar, C5175a aVar2) {
            float[] fArr = new float[9];
            Matrix matrix = new Matrix();
            float[] fArr2 = {aVar.f3440x, aVar.f3441y, 1.0f};
            C5175a aVar3 = new C5175a();
            aVar3.f3440x = aVar2.f3440x / 2.0f;
            aVar3.f3441y = aVar2.f3441y / 2.0f;
            matrix.postTranslate(-aVar3.f3440x, -aVar3.f3441y);
            matrix.postRotate(-f);
            matrix.postTranslate(aVar3.f3440x, aVar3.f3441y);
            matrix.getValues(fArr);
            float[] b = m14057b(fArr, fArr2);
            return b == null ? new C5175a() : new C5175a(b[0], b[1]);
        }

        /* renamed from: b */
        private static float[] m14057b(float[] fArr, float[] fArr2) {
            if (3 != fArr2.length || 9 != fArr.length) {
                return null;
            }
            float[] fArr3 = new float[3];
            for (int i = 0; i < 3; i++) {
                int i2 = i * 3;
                fArr3[i] = (fArr[i2 + 0] * fArr2[0]) + (fArr[i2 + 1] * fArr2[1]) + (fArr[i2 + 2] * fArr2[2]);
            }
            return fArr3;
        }
    }

    public PipSwapWidgetHor(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public PipSwapWidgetHor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public PipSwapWidgetHor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    /* renamed from: a */
    private boolean m14052a(QPIPFrameParam qPIPFrameParam, int i, int i2, int i3) {
        C5175a a = C5174b.m14056a(90.0f, new C5175a((float) i2, (float) i3), new C5175a(10000.0f, 10000.0f));
        return i == qPIPFrameParam.getElementIndexByPoint((int) a.f3440x, (int) a.f3441y);
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_pip_swap_hor, this, true);
        this.bXE = (ImageView) findViewById(R.id.xiaoying_cam_img_pip_add);
    }

    /* renamed from: c */
    public void mo26188c(int i, QPIPFrameParam qPIPFrameParam) {
        this.bXG = i;
        if (i == 0 || 1 == i) {
            this.bRF = qPIPFrameParam;
            int width = getWidth();
            int height = getHeight();
            int width2 = this.bXE.getWidth();
            int height2 = this.bXE.getHeight();
            if ((width == 0 || height == 0 || width2 == 0 || height2 == 0) && this.bRG < 3) {
                if (this.mHandler == null) {
                    this.mHandler = new C5173a(this);
                }
                this.mHandler.sendEmptyMessageDelayed(4097, 500);
                this.bRG++;
                return;
            }
            this.bRG = 1;
            this.bXE.setVisibility(0);
            QPoint elementTipsLocation = qPIPFrameParam.getElementTipsLocation(i);
            QRect elementDisplayRegion = qPIPFrameParam.getElementDisplayRegion(i);
            if (elementDisplayRegion != null) {
                QRect a = C8562q.m25043a(elementDisplayRegion, 90, 10000, 10000);
                LayoutParams layoutParams = (LayoutParams) this.bXE.getLayoutParams();
                int i2 = a.left;
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(((width * (i2 + (((a.right - i2) * elementTipsLocation.f3733x) / 10000))) / 10000) - (width2 / 2));
                } else {
                    layoutParams.leftMargin = ((width * (i2 + (((a.right - i2) * elementTipsLocation.f3733x) / 10000))) / 10000) - (width2 / 2);
                }
                int i3 = a.top;
                layoutParams.topMargin = ((height * (i3 + (((a.bottom - i3) * elementTipsLocation.f3734y) / 10000))) / 10000) - (height2 / 2);
                this.bXE.setLayoutParams(layoutParams);
            }
            return;
        }
        this.bXE.setVisibility(4);
    }

    /* renamed from: p */
    public boolean mo26189p(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bXE.getVisibility() != 0) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int width = getWidth();
        int height = getHeight();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + width;
        rect.bottom = rect.top + height;
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            int x = ((((int) motionEvent.getX()) - rect.left) * 10000) / width;
            int y = ((((int) motionEvent.getY()) - rect.top) * 10000) / height;
            if (this.bRF != null) {
                if (m14052a(this.bRF, this.bXG, x, y) && this.bXF != null) {
                    this.bXF.mo24979iK(this.bXG);
                }
                z = true;
            }
        }
        return z;
    }

    public void setPipOnAddClipClickListener(C4665d dVar) {
        this.bXF = dVar;
    }
}
