package com.introvd.template.explorer.p308ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p024v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.vivaexplorermodule.R;

/* renamed from: com.introvd.template.explorer.ui.WaveSeekBar */
public class WaveSeekBar extends AppCompatImageView {
    private boolean aMq;
    private final RectF bcc;
    private final Paint dDE;
    private Rect dDF;
    private final Bitmap dDG;
    private final Bitmap dDH;
    private final Bitmap dDI;
    private final Bitmap dDJ;
    private final Bitmap dDK;
    private final int dDL;
    private final float dDM;
    private final float dDN;
    private final float dDO;
    private final float dDP;
    private final float dDQ;
    private Integer dDR;
    private Integer dDS;
    private double dDT;
    private double dDU;
    private double dDV;
    private double[] dDW;
    private double dDX;
    private double dDY;
    private float dDZ;
    private float dEa;
    private Integer dEb;
    private C7341b dEc;
    private Rect dEd;
    private RectF dEe;
    private boolean dEf;
    private C7342c dEg;
    private float dEh;
    private int dEi;
    private final Paint dnF;
    private int mActivePointerId;
    private final Paint paint;

    /* renamed from: com.introvd.template.explorer.ui.WaveSeekBar$a */
    public enum C7340a {
        START,
        MOVE,
        END
    }

    /* renamed from: com.introvd.template.explorer.ui.WaveSeekBar$b */
    private enum C7341b {
        MIN,
        MAX
    }

    /* renamed from: com.introvd.template.explorer.ui.WaveSeekBar$c */
    public interface C7342c {
        /* renamed from: a */
        void mo31735a(WaveSeekBar waveSeekBar, C7340a aVar, boolean z);
    }

    public WaveSeekBar(Context context) {
        this(context, null);
    }

    public WaveSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint(1);
        this.dnF = new Paint(1);
        this.dDE = new Paint(1);
        this.dDF = new Rect();
        this.dDG = BitmapFactory.decodeResource(getResources(), R.drawable.wave_seek_drag_bar_normal);
        this.dDH = BitmapFactory.decodeResource(getResources(), R.drawable.wave_seek_drag_bar_normal);
        this.dDI = BitmapFactory.decodeResource(getResources(), R.drawable.wave_seek_drag_bar_pressed);
        this.dDJ = BitmapFactory.decodeResource(getResources(), R.drawable.wave_seek_drag_bar_pressed);
        this.dDK = BitmapFactory.decodeResource(getResources(), R.drawable.xyui_music_trim_seek_cursor);
        this.dDL = getResources().getColor(R.color.color_ff5e13);
        this.dDM = (float) C4583d.m11671P(13.0f);
        this.dDN = this.dDM * 0.5f;
        this.dDO = ((float) C4583d.m11671P(41.0f)) * 0.5f;
        this.dDP = this.dDO * 0.1f;
        this.dDQ = this.dDM * 2.0f;
        this.dDR = Integer.valueOf(0);
        this.dDS = Integer.valueOf(100);
        this.dDX = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.dDY = 1.0d;
        this.dDZ = 0.0f;
        this.dEa = 0.0f;
        this.dEc = null;
        this.dEd = new Rect();
        this.dEe = new RectF();
        this.dEf = true;
        this.bcc = new RectF();
        this.mActivePointerId = 255;
        mo31968b(Integer.valueOf(0), Integer.valueOf(100));
    }

    /* renamed from: R */
    private void m21656R(MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
        if (C7341b.MIN.equals(this.dEc)) {
            setNormalizedMinValue(m21660aK(x));
        } else if (C7341b.MAX.equals(this.dEc)) {
            setNormalizedMaxValue(m21660aK(x));
        }
    }

    /* renamed from: a */
    private void m21657a(float f, boolean z, Canvas canvas) {
        Bitmap bitmap = z ? this.dDI : this.dDG;
        float f2 = f - this.dDN;
        float height = (((float) getHeight()) * 0.5f) - this.dDO;
        int i = 0;
        this.dEd.left = 0;
        this.dEd.top = 0;
        this.dEd.right = this.dDG == null ? 0 : this.dDG.getWidth();
        Rect rect = this.dEd;
        if (this.dDG != null) {
            i = this.dDG.getHeight();
        }
        rect.bottom = i;
        this.dEe.left = f2;
        this.dEe.top = height;
        this.dEe.right = f2 + this.dDM;
        this.dEe.bottom = height + (this.dDO * 2.0f);
        this.dDZ = this.dEe.right - this.dDN;
        canvas.drawBitmap(bitmap, this.dEd, this.dEe, this.paint);
    }

    /* renamed from: a */
    private boolean m21658a(float f, double d) {
        return Math.abs(f - m21663g(d)) <= this.dDN * 4.0f;
    }

    /* renamed from: aJ */
    private C7341b m21659aJ(float f) {
        boolean a = m21658a(f, this.dDX);
        boolean a2 = m21658a(f, this.dDY);
        if (a && a2) {
            return f / ((float) getWidth()) > 0.5f ? C7341b.MIN : C7341b.MAX;
        }
        if (a) {
            return C7341b.MIN;
        }
        if (a2) {
            return C7341b.MAX;
        }
        return null;
    }

    /* renamed from: aK */
    private double m21660aK(float f) {
        float width = (float) getWidth();
        return width <= this.dDQ * 2.0f ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : Math.min(1.0d, Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (double) ((f - this.dDQ) / (width - (this.dDQ * 2.0f)))));
    }

    private void axU() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* renamed from: b */
    private void m21661b(float f, boolean z, Canvas canvas) {
        Bitmap bitmap = z ? this.dDJ : this.dDH;
        float f2 = f - this.dDN;
        float height = (((float) getHeight()) * 0.5f) - this.dDO;
        this.dEd.left = 0;
        this.dEd.top = 0;
        this.dEd.right = this.dDH.getWidth();
        this.dEd.bottom = this.dDH.getHeight();
        this.dEe.left = f2;
        this.dEe.top = height;
        this.dEe.right = f2 + this.dDM;
        this.dEe.bottom = height + (this.dDO * 2.0f);
        this.dEa = this.dEe.left + this.dDN;
        canvas.drawBitmap(bitmap, this.dEd, this.dEe, this.paint);
    }

    /* renamed from: f */
    private int m21662f(double d) {
        return (int) (this.dDT + (d * (this.dDU - this.dDT)));
    }

    /* renamed from: g */
    private float m21663g(double d) {
        return (float) (((double) this.dDQ) + (d * ((double) (((float) getWidth()) - (this.dDQ * 2.0f)))));
    }

    /* renamed from: m */
    private double m21664m(Integer num) {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE == this.dDU - this.dDT ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : (num.doubleValue() - this.dDT) / (this.dDU - this.dDT);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i = action == 0 ? 1 : 0;
            this.dEh = motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
        }
    }

    /* renamed from: a */
    public void mo31965a(int i, int i2, double[] dArr, int i3, int i4) {
        this.dDX = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.dDY = 1.0d;
        this.dDR = Integer.valueOf(i);
        this.dDS = Integer.valueOf(i2);
        this.dDT = this.dDR.doubleValue();
        this.dDU = this.dDS.doubleValue();
        this.dEb = Integer.valueOf(0);
        this.dDV = 0.1d;
        this.dDW = dArr;
        this.dDX = m21664m(Integer.valueOf(i3));
        this.dDY = m21664m(Integer.valueOf(i4));
        invalidate();
    }

    /* access modifiers changed from: 0000 */
    public void axV() {
        this.aMq = true;
    }

    /* access modifiers changed from: 0000 */
    public void axW() {
        this.aMq = false;
    }

    /* renamed from: b */
    public final void mo31968b(Integer num, Integer num2) {
        this.dDR = num;
        this.dDS = num2;
        this.dDT = num.doubleValue();
        this.dDU = num2.doubleValue();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.dnF.reset();
        this.dnF.setColor(-10066330);
        this.dnF.setAntiAlias(true);
        float dimension = getResources().getDimension(R.dimen.font_size_12sp);
        this.dnF.setTextSize(dimension);
        this.dnF.setTextAlign(Align.CENTER);
        this.dDE.reset();
        this.dDE.setColor(this.dDL);
        this.dDE.setAntiAlias(true);
        this.dDE.setTextSize(dimension);
        this.dDE.setTextAlign(Align.CENTER);
        this.dEi = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public int getAbsoluteMaxValue() {
        return this.dDS.intValue();
    }

    public int getAbsoluteMinValue() {
        return this.dDR.intValue();
    }

    public int getProgressValue() {
        return this.dEb.intValue();
    }

    public int getSelectedMaxValue() {
        return m21662f(this.dDY);
    }

    public int getSelectedMinValue() {
        return m21662f(this.dDX);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onDraw(android.graphics.Canvas r26) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            monitor-enter(r25)
            super.onDraw(r26)     // Catch:{ all -> 0x0216 }
            float r2 = r1.dDM     // Catch:{ all -> 0x0216 }
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 * r3
            int r4 = r25.getWidth()     // Catch:{ all -> 0x0216 }
            float r4 = (float) r4     // Catch:{ all -> 0x0216 }
            float r2 = r2 / r4
            double r4 = (double) r2     // Catch:{ all -> 0x0216 }
            r1.dDV = r4     // Catch:{ all -> 0x0216 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0216 }
            float r4 = r1.dDQ     // Catch:{ all -> 0x0216 }
            r2.left = r4     // Catch:{ all -> 0x0216 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0216 }
            int r4 = r25.getHeight()     // Catch:{ all -> 0x0216 }
            float r4 = (float) r4     // Catch:{ all -> 0x0216 }
            float r5 = r1.dDP     // Catch:{ all -> 0x0216 }
            float r4 = r4 - r5
            r8 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 * r8
            r2.top = r4     // Catch:{ all -> 0x0216 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0216 }
            int r4 = r25.getWidth()     // Catch:{ all -> 0x0216 }
            float r4 = (float) r4     // Catch:{ all -> 0x0216 }
            float r5 = r1.dDQ     // Catch:{ all -> 0x0216 }
            float r4 = r4 - r5
            r2.right = r4     // Catch:{ all -> 0x0216 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0216 }
            int r4 = r25.getHeight()     // Catch:{ all -> 0x0216 }
            float r4 = (float) r4     // Catch:{ all -> 0x0216 }
            float r5 = r1.dDP     // Catch:{ all -> 0x0216 }
            float r4 = r4 + r5
            float r4 = r4 * r8
            r2.bottom = r4     // Catch:{ all -> 0x0216 }
            android.graphics.Paint r2 = r1.paint     // Catch:{ all -> 0x0216 }
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL     // Catch:{ all -> 0x0216 }
            r2.setStyle(r4)     // Catch:{ all -> 0x0216 }
            r9 = -13553359(0xffffffffff313131, float:-2.3552877E38)
            android.graphics.Paint r2 = r1.paint     // Catch:{ all -> 0x0216 }
            r2.setColor(r9)     // Catch:{ all -> 0x0216 }
            android.graphics.Paint r2 = r1.paint     // Catch:{ all -> 0x0216 }
            r10 = 1
            r2.setAntiAlias(r10)     // Catch:{ all -> 0x0216 }
            java.lang.Integer r2 = r1.dEb     // Catch:{ all -> 0x0216 }
            r11 = 0
            if (r2 == 0) goto L_0x009e
            java.lang.Integer r2 = r1.dEb     // Catch:{ all -> 0x0216 }
            double r4 = r2.doubleValue()     // Catch:{ all -> 0x0216 }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x009e
            boolean r2 = r25.isPressed()     // Catch:{ all -> 0x0216 }
            if (r2 == 0) goto L_0x009e
            java.lang.Integer r2 = r1.dEb     // Catch:{ all -> 0x0216 }
            double r4 = r1.m21664m(r2)     // Catch:{ all -> 0x0216 }
            float r2 = r1.m21663g(r4)     // Catch:{ all -> 0x0216 }
            android.graphics.Bitmap r4 = r1.dDK     // Catch:{ all -> 0x0216 }
            android.graphics.Bitmap r5 = r1.dDK     // Catch:{ all -> 0x0216 }
            int r5 = r5.getWidth()     // Catch:{ all -> 0x0216 }
            float r5 = (float) r5     // Catch:{ all -> 0x0216 }
            float r5 = r5 * r8
            float r2 = r2 - r5
            int r5 = r25.getHeight()     // Catch:{ all -> 0x0216 }
            float r5 = (float) r5     // Catch:{ all -> 0x0216 }
            float r5 = r5 * r8
            android.graphics.Bitmap r6 = r1.dDK     // Catch:{ all -> 0x0216 }
            int r6 = r6.getHeight()     // Catch:{ all -> 0x0216 }
            float r6 = (float) r6     // Catch:{ all -> 0x0216 }
            float r6 = r6 * r8
            float r5 = r5 - r6
            android.graphics.Paint r6 = r1.paint     // Catch:{ all -> 0x0216 }
            r0.drawBitmap(r4, r2, r5, r6)     // Catch:{ all -> 0x0216 }
        L_0x009e:
            double[] r2 = r1.dDW     // Catch:{ all -> 0x0216 }
            r13 = 0
            if (r2 == 0) goto L_0x0179
            double[] r2 = r1.dDW     // Catch:{ all -> 0x0216 }
            int r2 = r2.length     // Catch:{ all -> 0x0216 }
            if (r2 <= 0) goto L_0x0179
            r2 = 1056293519(0x3ef5c28f, float:0.48)
            int r4 = r25.getHeight()     // Catch:{ all -> 0x0216 }
            float r4 = (float) r4     // Catch:{ all -> 0x0216 }
            float r14 = r4 * r2
            int r2 = r25.getHeight()     // Catch:{ all -> 0x0216 }
            float r2 = (float) r2     // Catch:{ all -> 0x0216 }
            float r2 = r2 - r14
            float r15 = r2 / r3
            float r2 = r1.dDQ     // Catch:{ all -> 0x0216 }
            int r2 = (int) r2     // Catch:{ all -> 0x0216 }
            r7 = r2
            r2 = 0
        L_0x00bf:
            float r3 = (float) r7     // Catch:{ all -> 0x0216 }
            int r4 = r25.getWidth()     // Catch:{ all -> 0x0216 }
            float r4 = (float) r4     // Catch:{ all -> 0x0216 }
            float r5 = r1.dDQ     // Catch:{ all -> 0x0216 }
            float r4 = r4 - r5
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0179
            int r4 = r7 % 6
            if (r4 != 0) goto L_0x016e
            double r4 = r1.dDX     // Catch:{ all -> 0x0216 }
            float r4 = r1.m21663g(r4)     // Catch:{ all -> 0x0216 }
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x00ed
            double r4 = r1.dDY     // Catch:{ all -> 0x0216 }
            float r4 = r1.m21663g(r4)     // Catch:{ all -> 0x0216 }
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x00e5
            goto L_0x00ed
        L_0x00e5:
            android.graphics.Paint r4 = r1.paint     // Catch:{ all -> 0x0216 }
            int r5 = r1.dDL     // Catch:{ all -> 0x0216 }
            r4.setColor(r5)     // Catch:{ all -> 0x0216 }
            goto L_0x00f2
        L_0x00ed:
            android.graphics.Paint r4 = r1.paint     // Catch:{ all -> 0x0216 }
            r4.setColor(r9)     // Catch:{ all -> 0x0216 }
        L_0x00f2:
            double[] r4 = r1.dDW     // Catch:{ all -> 0x0216 }
            int r4 = r4.length     // Catch:{ all -> 0x0216 }
            int r4 = r4 - r10
            r5 = 1092616192(0x41200000, float:10.0)
            r16 = 4617315517961601024(0x4014000000000000, double:5.0)
            r18 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            if (r2 <= r4) goto L_0x011d
            int r20 = r2 + 1
            int r2 = r25.getHeight()     // Catch:{ all -> 0x0216 }
            double r9 = (double) r2     // Catch:{ all -> 0x0216 }
            double r9 = r9 * r18
            double r9 = r9 - r16
            float r4 = (float) r9     // Catch:{ all -> 0x0216 }
            int r2 = r7 + 2
            float r6 = (float) r2     // Catch:{ all -> 0x0216 }
            float r9 = r4 + r5
            android.graphics.Paint r10 = r1.paint     // Catch:{ all -> 0x0216 }
            r2 = r26
            r5 = r6
            r6 = r9
            r9 = r7
            r7 = r10
            r2.drawRect(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0216 }
            r2 = r20
            goto L_0x016f
        L_0x011d:
            r9 = r7
            double[] r4 = r1.dDW     // Catch:{ all -> 0x0216 }
            r6 = r4[r2]     // Catch:{ all -> 0x0216 }
            float r4 = (float) r6     // Catch:{ all -> 0x0216 }
            float r4 = r4 * r14
            int r10 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r10 == 0) goto L_0x0152
            r21 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = r6 / r21
            double r11 = (double) r14     // Catch:{ all -> 0x0216 }
            double r21 = r6 * r11
            r23 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r10 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r10 >= 0) goto L_0x0137
            goto L_0x0152
        L_0x0137:
            int r10 = r2 + 1
            double r18 = r18 - r6
            double r5 = r18 * r11
            float r2 = (float) r5     // Catch:{ all -> 0x0216 }
            float r5 = r15 + r2
            int r7 = r9 + 2
            float r6 = (float) r7     // Catch:{ all -> 0x0216 }
            float r7 = r5 + r4
            android.graphics.Paint r11 = r1.paint     // Catch:{ all -> 0x0216 }
            r2 = r26
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r11
            r2.drawRect(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0216 }
        L_0x0150:
            r2 = r10
            goto L_0x016f
        L_0x0152:
            int r10 = r2 + 1
            int r2 = r25.getHeight()     // Catch:{ all -> 0x0216 }
            double r6 = (double) r2     // Catch:{ all -> 0x0216 }
            double r6 = r6 * r18
            double r6 = r6 - r16
            float r4 = (float) r6     // Catch:{ all -> 0x0216 }
            int r7 = r9 + 2
            float r6 = (float) r7     // Catch:{ all -> 0x0216 }
            float r7 = r4 + r5
            android.graphics.Paint r11 = r1.paint     // Catch:{ all -> 0x0216 }
            r2 = r26
            r5 = r6
            r6 = r7
            r7 = r11
            r2.drawRect(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0216 }
            goto L_0x0150
        L_0x016e:
            r9 = r7
        L_0x016f:
            int r7 = r9 + 1
            r9 = -13553359(0xffffffffff313131, float:-2.3552877E38)
            r10 = 1
            r11 = 0
            goto L_0x00bf
        L_0x0179:
            double r2 = r1.dDX     // Catch:{ all -> 0x0216 }
            float r2 = r1.m21663g(r2)     // Catch:{ all -> 0x0216 }
            com.introvd.template.explorer.ui.WaveSeekBar$b r3 = com.introvd.template.explorer.p308ui.WaveSeekBar.C7341b.MIN     // Catch:{ all -> 0x0216 }
            com.introvd.template.explorer.ui.WaveSeekBar$b r4 = r1.dEc     // Catch:{ all -> 0x0216 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0216 }
            r1.m21657a(r2, r3, r0)     // Catch:{ all -> 0x0216 }
            double r2 = r1.dDY     // Catch:{ all -> 0x0216 }
            float r2 = r1.m21663g(r2)     // Catch:{ all -> 0x0216 }
            com.introvd.template.explorer.ui.WaveSeekBar$b r3 = com.introvd.template.explorer.p308ui.WaveSeekBar.C7341b.MAX     // Catch:{ all -> 0x0216 }
            com.introvd.template.explorer.ui.WaveSeekBar$b r4 = r1.dEc     // Catch:{ all -> 0x0216 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0216 }
            r1.m21661b(r2, r3, r0)     // Catch:{ all -> 0x0216 }
            int r2 = r25.getHeight()     // Catch:{ all -> 0x0216 }
            float r2 = (float) r2     // Catch:{ all -> 0x0216 }
            float r2 = r2 * r8
            float r3 = r1.dDO     // Catch:{ all -> 0x0216 }
            float r2 = r2 - r3
            int r3 = r25.getSelectedMinValue()     // Catch:{ all -> 0x0216 }
            java.lang.String r3 = com.introvd.template.xyui.C9163c.m26664kg(r3)     // Catch:{ all -> 0x0216 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0216 }
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r4 != 0) goto L_0x01de
            android.graphics.Paint r4 = r1.dnF     // Catch:{ all -> 0x0216 }
            int r6 = r3.length()     // Catch:{ all -> 0x0216 }
            android.graphics.Rect r7 = r1.dDF     // Catch:{ all -> 0x0216 }
            r4.getTextBounds(r3, r13, r6, r7)     // Catch:{ all -> 0x0216 }
            android.graphics.Rect r4 = r1.dDF     // Catch:{ all -> 0x0216 }
            int r4 = r4.height()     // Catch:{ all -> 0x0216 }
            float r6 = r1.dDZ     // Catch:{ all -> 0x0216 }
            float r6 = r6 + r5
            float r4 = (float) r4     // Catch:{ all -> 0x0216 }
            float r4 = r2 - r4
            com.introvd.template.explorer.ui.WaveSeekBar$b r7 = com.introvd.template.explorer.p308ui.WaveSeekBar.C7341b.MIN     // Catch:{ all -> 0x0216 }
            com.introvd.template.explorer.ui.WaveSeekBar$b r8 = r1.dEc     // Catch:{ all -> 0x0216 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0216 }
            if (r7 == 0) goto L_0x01d9
            android.graphics.Paint r7 = r1.dDE     // Catch:{ all -> 0x0216 }
            goto L_0x01db
        L_0x01d9:
            android.graphics.Paint r7 = r1.dnF     // Catch:{ all -> 0x0216 }
        L_0x01db:
            r0.drawText(r3, r6, r4, r7)     // Catch:{ all -> 0x0216 }
        L_0x01de:
            int r4 = r25.getSelectedMaxValue()     // Catch:{ all -> 0x0216 }
            java.lang.String r4 = com.introvd.template.xyui.C9163c.m26664kg(r4)     // Catch:{ all -> 0x0216 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0216 }
            if (r6 != 0) goto L_0x0214
            android.graphics.Paint r6 = r1.dnF     // Catch:{ all -> 0x0216 }
            int r7 = r3.length()     // Catch:{ all -> 0x0216 }
            android.graphics.Rect r8 = r1.dDF     // Catch:{ all -> 0x0216 }
            r6.getTextBounds(r3, r13, r7, r8)     // Catch:{ all -> 0x0216 }
            android.graphics.Rect r3 = r1.dDF     // Catch:{ all -> 0x0216 }
            int r3 = r3.height()     // Catch:{ all -> 0x0216 }
            float r6 = r1.dEa     // Catch:{ all -> 0x0216 }
            float r6 = r6 + r5
            float r3 = (float) r3     // Catch:{ all -> 0x0216 }
            float r2 = r2 - r3
            com.introvd.template.explorer.ui.WaveSeekBar$b r3 = com.introvd.template.explorer.p308ui.WaveSeekBar.C7341b.MAX     // Catch:{ all -> 0x0216 }
            com.introvd.template.explorer.ui.WaveSeekBar$b r5 = r1.dEc     // Catch:{ all -> 0x0216 }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0216 }
            if (r3 == 0) goto L_0x020f
            android.graphics.Paint r3 = r1.dDE     // Catch:{ all -> 0x0216 }
            goto L_0x0211
        L_0x020f:
            android.graphics.Paint r3 = r1.dnF     // Catch:{ all -> 0x0216 }
        L_0x0211:
            r0.drawText(r4, r6, r2, r3)     // Catch:{ all -> 0x0216 }
        L_0x0214:
            monitor-exit(r25)
            return
        L_0x0216:
            r0 = move-exception
            monitor-exit(r25)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p308ui.WaveSeekBar.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int O = C4583d.m11670O(getContext(), 78);
        int i3 = O * 2;
        if (MeasureSpec.getMode(i) != 0) {
            i3 = MeasureSpec.getSize(i);
        }
        if (MeasureSpec.getMode(i2) != 0) {
            O = Math.min(O, MeasureSpec.getSize(i2));
        }
        setMeasuredDimension(i3, O);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
        this.dDX = bundle.getDouble("MIN");
        this.dDY = bundle.getDouble("MAX");
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putDouble("MIN", this.dDX);
        bundle.putDouble("MAX", this.dDY);
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
                this.dEh = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                this.dEc = m21659aJ(this.dEh);
                if (this.dEc != null) {
                    if (this.dEg != null) {
                        C7342c cVar = this.dEg;
                        C7340a aVar = C7340a.START;
                        if (this.dEc == C7341b.MIN) {
                            z = true;
                        }
                        cVar.mo31735a(this, aVar, z);
                    }
                    setPressed(true);
                    invalidate();
                    axV();
                    m21656R(motionEvent);
                    axU();
                    break;
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            case 1:
                if (this.aMq) {
                    m21656R(motionEvent);
                    axW();
                    setPressed(false);
                } else {
                    axV();
                    m21656R(motionEvent);
                    axW();
                }
                if (this.dEg != null) {
                    C7342c cVar2 = this.dEg;
                    C7340a aVar2 = C7340a.END;
                    if (this.dEc == C7341b.MIN) {
                        z = true;
                    }
                    cVar2.mo31735a(this, aVar2, z);
                }
                this.dEc = null;
                invalidate();
                break;
            case 2:
                if (this.dEc != null) {
                    if (this.aMq) {
                        m21656R(motionEvent);
                    } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.dEh) > ((float) this.dEi)) {
                        setPressed(true);
                        invalidate();
                        axV();
                        m21656R(motionEvent);
                        axU();
                    }
                    if (this.dEf && this.dEg != null) {
                        C7342c cVar3 = this.dEg;
                        C7340a aVar3 = C7340a.MOVE;
                        if (this.dEc == C7341b.MIN) {
                            z = true;
                        }
                        cVar3.mo31735a(this, aVar3, z);
                        break;
                    }
                }
                break;
            case 3:
                if (this.aMq) {
                    axW();
                    setPressed(false);
                }
                invalidate();
                break;
            case 5:
                int pointerCount = motionEvent.getPointerCount() - 1;
                this.dEh = motionEvent.getX(pointerCount);
                this.mActivePointerId = motionEvent.getPointerId(pointerCount);
                invalidate();
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                invalidate();
                break;
        }
        return true;
    }

    public void setNormalizedMaxValue(double d) {
        this.dDY = Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, Math.min(1.0d, Math.max(d, this.dDX + this.dDV)));
        invalidate();
    }

    public void setNormalizedMinValue(double d) {
        this.dDX = Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, Math.min(1.0d, Math.min(d, this.dDY - this.dDV)));
        invalidate();
    }

    public void setNotifyWhileDragging(boolean z) {
        this.dEf = z;
    }

    public void setProgressValue(int i) {
        this.dEb = Integer.valueOf(i);
        invalidate();
    }

    public void setSelectedMaxValue(int i) {
        if (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE == this.dDU - this.dDT) {
            setNormalizedMaxValue(1.0d);
        } else {
            setNormalizedMaxValue(m21664m(Integer.valueOf(i)));
        }
    }

    public void setSelectedMinValue(int i) {
        if (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE == this.dDU - this.dDT) {
            setNormalizedMinValue(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } else {
            setNormalizedMinValue(m21664m(Integer.valueOf(i)));
        }
    }

    public void setWaveChangeCallback(C7342c cVar) {
        this.dEg = cVar;
    }
}
