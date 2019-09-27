package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.camera.p208a.C4665d;
import com.introvd.template.vivacamera.R;
import com.mediarecorder.engine.QPIPFrameParam;
import java.lang.ref.WeakReference;
import xiaoying.utils.QPoint;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.camera.ui.view.PipSwapWidget */
public class PipSwapWidget extends RelativeLayout {
    /* access modifiers changed from: private */
    public QPIPFrameParam bRF;
    private int bRG = 1;
    private ImageView bXE;
    private C4665d bXF;
    /* access modifiers changed from: private */
    public int bXG;
    private Context mContext;
    private Handler mHandler;

    /* renamed from: com.introvd.template.camera.ui.view.PipSwapWidget$a */
    private static class C5172a extends Handler {
        final WeakReference<PipSwapWidget> bry;

        public C5172a(PipSwapWidget pipSwapWidget) {
            super(Looper.getMainLooper());
            this.bry = new WeakReference<>(pipSwapWidget);
        }

        public void handleMessage(Message message) {
            PipSwapWidget pipSwapWidget = (PipSwapWidget) this.bry.get();
            if (pipSwapWidget != null) {
                if (message.what == 4097) {
                    pipSwapWidget.mo26184c(pipSwapWidget.bXG, pipSwapWidget.bRF);
                }
                super.handleMessage(message);
            }
        }
    }

    public PipSwapWidget(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public PipSwapWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public PipSwapWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_pip_swap, this, true);
        this.bXE = (ImageView) findViewById(R.id.xiaoying_cam_img_pip_add);
    }

    /* renamed from: c */
    public void mo26184c(int i, QPIPFrameParam qPIPFrameParam) {
        this.bXG = i;
        if (i == 0 || 1 == i) {
            this.bRF = qPIPFrameParam;
            LayoutParams layoutParams = (LayoutParams) this.bXE.getLayoutParams();
            int width = getWidth();
            int height = getHeight();
            if (height > width) {
                height = width;
            }
            int width2 = this.bXE.getWidth();
            int height2 = this.bXE.getHeight();
            if ((width == 0 || height == 0 || width2 == 0 || height2 == 0) && this.bRG < 3) {
                if (this.mHandler == null) {
                    this.mHandler = new C5172a(this);
                }
                this.mHandler.sendEmptyMessageDelayed(4097, 500);
                this.bRG++;
                return;
            }
            this.bRG = 1;
            this.bXE.setVisibility(0);
            QPoint elementTipsLocation = qPIPFrameParam.getElementTipsLocation(i);
            QRect elementDisplayRegion = qPIPFrameParam.getElementDisplayRegion(i);
            try {
                if (VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(((width * (elementDisplayRegion.left + (((elementDisplayRegion.right - elementDisplayRegion.left) * elementTipsLocation.f3733x) / 10000))) / 10000) - (width2 / 2));
                } else {
                    layoutParams.leftMargin = ((width * (elementDisplayRegion.left + (((elementDisplayRegion.right - elementDisplayRegion.left) * elementTipsLocation.f3733x) / 10000))) / 10000) - (width2 / 2);
                }
                layoutParams.topMargin = ((height * (elementDisplayRegion.top + (((elementDisplayRegion.bottom - elementDisplayRegion.top) * elementTipsLocation.f3734y) / 10000))) / 10000) - (height2 / 2);
                this.bXE.setLayoutParams(layoutParams);
            } catch (Exception unused) {
            }
            return;
        }
        this.bXE.setVisibility(4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0075, code lost:
        if (-1 == r8) goto L_0x0072;
     */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo26185p(android.view.MotionEvent r8) {
        /*
            r7 = this;
            android.widget.ImageView r0 = r7.bXE
            int r0 = r0.getVisibility()
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            r0 = 2
            int[] r0 = new int[r0]
            r7.getLocationOnScreen(r0)
            int r2 = r7.getWidth()
            int r3 = r7.getHeight()
            if (r3 <= r2) goto L_0x001b
            r3 = r2
        L_0x001b:
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            r5 = r0[r1]
            r4.left = r5
            r5 = 1
            r0 = r0[r5]
            r4.top = r0
            int r0 = r4.left
            int r0 = r0 + r2
            r4.right = r0
            int r0 = r4.top
            int r0 = r0 + r3
            r4.bottom = r0
            float r0 = r8.getX()
            int r0 = (int) r0
            float r6 = r8.getY()
            int r6 = (int) r6
            boolean r0 = r4.contains(r0, r6)
            if (r0 == 0) goto L_0x0078
            float r0 = r8.getX()
            int r0 = (int) r0
            int r6 = r4.left
            int r0 = r0 - r6
            int r0 = r0 * 10000
            int r0 = r0 / r2
            float r8 = r8.getY()
            int r8 = (int) r8
            int r2 = r4.top
            int r8 = r8 - r2
            int r8 = r8 * 10000
            int r8 = r8 / r3
            com.mediarecorder.engine.QPIPFrameParam r2 = r7.bRF
            if (r2 == 0) goto L_0x0078
            com.mediarecorder.engine.QPIPFrameParam r2 = r7.bRF
            int r8 = r2.getElementIndexByPoint(r0, r8)
            int r0 = r7.bXG
            if (r8 != r0) goto L_0x0074
            com.introvd.template.camera.a.d r8 = r7.bXF
            if (r8 == 0) goto L_0x0078
            com.introvd.template.camera.a.d r8 = r7.bXF
            int r0 = r7.bXG
            r8.mo24979iK(r0)
        L_0x0072:
            r1 = 1
            goto L_0x0078
        L_0x0074:
            r0 = -1
            if (r0 != r8) goto L_0x0078
            goto L_0x0072
        L_0x0078:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p233ui.view.PipSwapWidget.mo26185p(android.view.MotionEvent):boolean");
    }

    public void setPipOnAddClipClickListener(C4665d dVar) {
        this.bXF = dVar;
    }
}
