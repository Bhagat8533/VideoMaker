package com.introvd.template.xyui.audiowave;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.introvd.template.ui.widget.R;
import com.introvd.template.xyui.p421b.C9162a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.Number;
import java.math.BigDecimal;

public class RangeSeekBarV4<T extends Number> extends ImageView {
    public static final int DEFAULT_COLOR = Color.argb(255, 255, 103, 43);
    private boolean aMq;
    private final RectF bcc = new RectF();
    private final Paint dDE = new Paint(1);
    private final Bitmap dDG = BitmapFactory.decodeResource(getResources(), R.drawable.xyui_music_trim_seek_bar_normal);
    private final Bitmap dDH = BitmapFactory.decodeResource(getResources(), R.drawable.xyui_music_trim_seek_bar_normal);
    private final Bitmap dDI = BitmapFactory.decodeResource(getResources(), R.drawable.xyui_music_trim_seek_bar_pressed);
    private final Bitmap dDJ = BitmapFactory.decodeResource(getResources(), R.drawable.xyui_music_trim_seek_bar_pressed);
    private final Bitmap dDK = BitmapFactory.decodeResource(getResources(), R.drawable.xyui_music_trim_seek_cursor);
    private final int dDL = getResources().getColor(R.color.color_ff5e13);
    private final float dDM = ((float) C9162a.m26663P(18.0f));
    private final float dDN = (this.dDM * 0.5f);
    private final float dDO = (((float) C9162a.m26663P(34.0f)) * 0.5f);
    private final float dDP = (this.dDO * 0.1f);
    private final float dDQ = this.dDM;
    private double dDT;
    private double dDU;
    private double dDV;
    private double[] dDW;
    private double dDX = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    private double dDY = 1.0d;
    private float dDZ = 0.0f;
    private float dEa = 0.0f;
    private Rect dEd = new Rect();
    private RectF dEe = new RectF();
    private boolean dEf = true;
    private float dEh;
    private int dEi;
    private final Paint dnF = new Paint(1);
    private final int eCH = IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED;
    private final int eCI = -13553359;
    private final int eCJ = -19610;
    private T eCK;
    private T eCL;
    private C9158a eCM;
    private T eCN;
    private C9160c eCO = null;
    private C9159b<T> eCP;
    private boolean eCQ = false;
    private int mActivePointerId = 255;
    private final Paint paint = new Paint(1);

    /* renamed from: com.introvd.template.xyui.audiowave.RangeSeekBarV4$a */
    private enum C9158a {
        LONG,
        DOUBLE,
        INTEGER,
        FLOAT,
        SHORT,
        BYTE,
        BIG_DECIMAL;

        /* renamed from: c */
        public static <E extends Number> C9158a m26656c(E e) throws IllegalArgumentException {
            if (e instanceof Long) {
                return LONG;
            }
            if (e instanceof Double) {
                return DOUBLE;
            }
            if (e instanceof Integer) {
                return INTEGER;
            }
            if (e instanceof Float) {
                return FLOAT;
            }
            if (e instanceof Short) {
                return SHORT;
            }
            if (e instanceof Byte) {
                return BYTE;
            }
            if (e instanceof BigDecimal) {
                return BIG_DECIMAL;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Number class '");
            sb.append(e.getClass().getName());
            sb.append("' is not supported");
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: l */
        public Number mo36145l(double d) {
            switch (this) {
                case LONG:
                    return Long.valueOf((long) d);
                case DOUBLE:
                    return Double.valueOf(d);
                case INTEGER:
                    return Integer.valueOf((int) d);
                case FLOAT:
                    return Float.valueOf((float) d);
                case SHORT:
                    return Short.valueOf((short) ((int) d));
                case BYTE:
                    return Byte.valueOf((byte) ((int) d));
                case BIG_DECIMAL:
                    return new BigDecimal(d);
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("can't convert ");
                    sb.append(this);
                    sb.append(" to a Number object");
                    throw new InstantiationError(sb.toString());
            }
        }
    }

    /* renamed from: com.introvd.template.xyui.audiowave.RangeSeekBarV4$b */
    public interface C9159b<T> {
        /* renamed from: a */
        void mo29909a(RangeSeekBarV4<?> rangeSeekBarV4, T t, T t2);

        /* renamed from: a */
        void mo29910a(RangeSeekBarV4<?> rangeSeekBarV4, boolean z);

        /* renamed from: b */
        void mo29912b(RangeSeekBarV4<?> rangeSeekBarV4, T t, T t2);
    }

    /* renamed from: com.introvd.template.xyui.audiowave.RangeSeekBarV4$c */
    private enum C9160c {
        MIN,
        MAX
    }

    public RangeSeekBarV4(Context context) {
        super(context);
    }

    public RangeSeekBarV4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RangeSeekBarV4(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public RangeSeekBarV4(T t, T t2, Context context) throws IllegalArgumentException {
        super(context);
        mo36123a(t, t2);
    }

    /* renamed from: R */
    private final void m26644R(MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
        if (C9160c.MIN.equals(this.eCO)) {
            setNormalizedMinValue(m26647aK(x));
        } else if (C9160c.MAX.equals(this.eCO)) {
            setNormalizedMaxValue(m26647aK(x));
        }
    }

    /* renamed from: a */
    private void m26645a(float f, boolean z, Canvas canvas) {
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
    private boolean m26646a(float f, double d) {
        return Math.abs(f - m26651g(d)) <= this.dDN * 4.0f;
    }

    /* renamed from: aK */
    private double m26647aK(float f) {
        float width = (float) getWidth();
        return width <= this.dDQ * 2.0f ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : Math.min(1.0d, Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (double) ((f - this.dDQ) / (width - (this.dDQ * 2.0f)))));
    }

    /* renamed from: aV */
    private C9160c m26648aV(float f) {
        boolean a = m26646a(f, this.dDX);
        boolean a2 = m26646a(f, this.dDY);
        if (a && a2) {
            return f / ((float) getWidth()) > 0.5f ? C9160c.MIN : C9160c.MAX;
        }
        if (a) {
            return C9160c.MIN;
        }
        if (a2) {
            return C9160c.MAX;
        }
        return null;
    }

    private void axU() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* renamed from: b */
    private double m26649b(T t) {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE == this.dDU - this.dDT ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : (t.doubleValue() - this.dDT) / (this.dDU - this.dDT);
    }

    /* renamed from: b */
    private void m26650b(float f, boolean z, Canvas canvas) {
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

    /* renamed from: g */
    private float m26651g(double d) {
        return (float) (((double) this.dDQ) + (d * ((double) (((float) getWidth()) - (this.dDQ * 2.0f)))));
    }

    /* renamed from: k */
    private T m26652k(double d) {
        return this.eCM.mo36145l(this.dDT + (d * (this.dDU - this.dDT)));
    }

    private final void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i = action == 0 ? 1 : 0;
            this.dEh = motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
        }
    }

    /* renamed from: a */
    public final void mo36123a(T t, T t2) {
        this.eCK = t;
        this.eCL = t2;
        this.dDT = t.doubleValue();
        this.dDU = t2.doubleValue();
        this.dDV = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE / (this.dDU - this.dDT);
        this.eCM = C9158a.m26656c(t);
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

    /* renamed from: a */
    public void mo36124a(T t, T t2, double d) {
        this.dDX = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.dDY = 1.0d;
        this.eCK = t;
        this.eCL = t2;
        this.dDT = this.eCK.doubleValue();
        this.dDU = this.eCL.doubleValue();
        this.dDV = d / (this.dDU - this.dDT);
        this.eCN = Integer.valueOf(0);
        invalidate();
    }

    /* renamed from: a */
    public void mo36125a(T t, T t2, double d, double[] dArr, T t3, T t4, boolean z) {
        this.dDX = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.dDY = 1.0d;
        this.eCK = t;
        this.eCL = t2;
        this.dDT = this.eCK.doubleValue();
        this.dDU = this.eCL.doubleValue();
        this.dDV = d / (this.dDU - this.dDT);
        this.eCN = Integer.valueOf(0);
        this.dDW = dArr;
        this.dDX = m26649b(t3);
        this.dDY = m26649b(t4);
        this.eCQ = z;
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

    public T getAbsoluteMaxValue() {
        return this.eCL;
    }

    public T getAbsoluteMinValue() {
        return this.eCK;
    }

    public T getProgressValue() {
        return this.eCN;
    }

    public T getSelectedMaxValue() {
        return m26652k(this.dDY);
    }

    public T getSelectedMinValue() {
        return m26652k(this.dDX);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0292, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0197  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onDraw(android.graphics.Canvas r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            monitor-enter(r18)
            super.onDraw(r19)     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            float r3 = r1.dDQ     // Catch:{ all -> 0x0293 }
            r2.left = r3     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            int r3 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            float r3 = (float) r3     // Catch:{ all -> 0x0293 }
            float r4 = r1.dDP     // Catch:{ all -> 0x0293 }
            float r3 = r3 - r4
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 * r4
            r2.top = r3     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            int r3 = r18.getWidth()     // Catch:{ all -> 0x0293 }
            float r3 = (float) r3     // Catch:{ all -> 0x0293 }
            float r5 = r1.dDQ     // Catch:{ all -> 0x0293 }
            float r3 = r3 - r5
            r2.right = r3     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            int r3 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            float r3 = (float) r3     // Catch:{ all -> 0x0293 }
            float r5 = r1.dDP     // Catch:{ all -> 0x0293 }
            float r3 = r3 + r5
            float r3 = r3 * r4
            r2.bottom = r3     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            float r2 = r2.left     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            float r2 = r2.right     // Catch:{ all -> 0x0293 }
            android.graphics.Paint r2 = r1.paint     // Catch:{ all -> 0x0293 }
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL     // Catch:{ all -> 0x0293 }
            r2.setStyle(r3)     // Catch:{ all -> 0x0293 }
            android.graphics.Paint r2 = r1.paint     // Catch:{ all -> 0x0293 }
            r8 = -13553359(0xffffffffff313131, float:-2.3552877E38)
            r2.setColor(r8)     // Catch:{ all -> 0x0293 }
            android.graphics.Paint r2 = r1.paint     // Catch:{ all -> 0x0293 }
            r9 = 1
            r2.setAntiAlias(r9)     // Catch:{ all -> 0x0293 }
            boolean r2 = r1.eCQ     // Catch:{ all -> 0x0293 }
            r10 = 0
            r3 = 1073741824(0x40000000, float:2.0)
            if (r2 != 0) goto L_0x00d2
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            float r5 = r1.dDP     // Catch:{ all -> 0x0293 }
            float r5 = r5 / r3
            float r6 = r1.dDP     // Catch:{ all -> 0x0293 }
            float r6 = r6 / r3
            android.graphics.Paint r7 = r1.paint     // Catch:{ all -> 0x0293 }
            r0.drawRoundRect(r2, r5, r6, r7)     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            double r5 = r1.dDX     // Catch:{ all -> 0x0293 }
            float r5 = r1.m26651g(r5)     // Catch:{ all -> 0x0293 }
            r2.left = r5     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            double r5 = r1.dDY     // Catch:{ all -> 0x0293 }
            float r5 = r1.m26651g(r5)     // Catch:{ all -> 0x0293 }
            r2.right = r5     // Catch:{ all -> 0x0293 }
            android.graphics.Paint r2 = r1.paint     // Catch:{ all -> 0x0293 }
            int r5 = r1.dDL     // Catch:{ all -> 0x0293 }
            r2.setColor(r5)     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            float r5 = r1.dDP     // Catch:{ all -> 0x0293 }
            float r5 = r5 / r3
            float r6 = r1.dDP     // Catch:{ all -> 0x0293 }
            float r6 = r6 / r3
            android.graphics.Paint r7 = r1.paint     // Catch:{ all -> 0x0293 }
            r0.drawRoundRect(r2, r5, r6, r7)     // Catch:{ all -> 0x0293 }
            T r2 = r1.eCN     // Catch:{ all -> 0x0293 }
            if (r2 == 0) goto L_0x00d2
            T r2 = r1.eCN     // Catch:{ all -> 0x0293 }
            double r5 = r2.doubleValue()     // Catch:{ all -> 0x0293 }
            int r2 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d2
            java.lang.Number r2 = r18.getSelectedMinValue()     // Catch:{ all -> 0x0293 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0293 }
            T r5 = r1.eCN     // Catch:{ all -> 0x0293 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0293 }
            if (r2 >= r5) goto L_0x00d2
            T r2 = r1.eCN     // Catch:{ all -> 0x0293 }
            double r5 = r1.m26649b(r2)     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            float r5 = r1.m26651g(r5)     // Catch:{ all -> 0x0293 }
            r2.right = r5     // Catch:{ all -> 0x0293 }
            android.graphics.Paint r2 = r1.paint     // Catch:{ all -> 0x0293 }
            r5 = -19610(0xffffffffffffb366, float:NaN)
            r2.setColor(r5)     // Catch:{ all -> 0x0293 }
            android.graphics.RectF r2 = r1.bcc     // Catch:{ all -> 0x0293 }
            float r5 = r1.dDP     // Catch:{ all -> 0x0293 }
            float r5 = r5 / r3
            float r6 = r1.dDP     // Catch:{ all -> 0x0293 }
            float r6 = r6 / r3
            android.graphics.Paint r7 = r1.paint     // Catch:{ all -> 0x0293 }
            r0.drawRoundRect(r2, r5, r6, r7)     // Catch:{ all -> 0x0293 }
        L_0x00d2:
            T r2 = r1.eCN     // Catch:{ all -> 0x0293 }
            if (r2 == 0) goto L_0x0112
            T r2 = r1.eCN     // Catch:{ all -> 0x0293 }
            double r5 = r2.doubleValue()     // Catch:{ all -> 0x0293 }
            int r2 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x0112
            boolean r2 = r18.isPressed()     // Catch:{ all -> 0x0293 }
            if (r2 == 0) goto L_0x0112
            T r2 = r1.eCN     // Catch:{ all -> 0x0293 }
            double r5 = r1.m26649b(r2)     // Catch:{ all -> 0x0293 }
            float r2 = r1.m26651g(r5)     // Catch:{ all -> 0x0293 }
            android.graphics.Bitmap r5 = r1.dDK     // Catch:{ all -> 0x0293 }
            android.graphics.Bitmap r6 = r1.dDK     // Catch:{ all -> 0x0293 }
            int r6 = r6.getWidth()     // Catch:{ all -> 0x0293 }
            float r6 = (float) r6     // Catch:{ all -> 0x0293 }
            float r6 = r6 * r4
            float r2 = r2 - r6
            int r6 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            float r6 = (float) r6     // Catch:{ all -> 0x0293 }
            float r6 = r6 * r4
            android.graphics.Bitmap r7 = r1.dDK     // Catch:{ all -> 0x0293 }
            int r7 = r7.getHeight()     // Catch:{ all -> 0x0293 }
            float r7 = (float) r7     // Catch:{ all -> 0x0293 }
            float r7 = r7 * r4
            float r6 = r6 - r7
            android.graphics.Paint r4 = r1.paint     // Catch:{ all -> 0x0293 }
            r0.drawBitmap(r5, r2, r6, r4)     // Catch:{ all -> 0x0293 }
        L_0x0112:
            boolean r2 = r1.eCQ     // Catch:{ all -> 0x0293 }
            if (r2 == 0) goto L_0x01f6
            double[] r2 = r1.dDW     // Catch:{ all -> 0x0293 }
            if (r2 == 0) goto L_0x01f6
            double[] r2 = r1.dDW     // Catch:{ all -> 0x0293 }
            int r2 = r2.length     // Catch:{ all -> 0x0293 }
            if (r2 <= 0) goto L_0x01f6
            int r2 = r18.getWidth()     // Catch:{ all -> 0x0293 }
            float r2 = (float) r2     // Catch:{ all -> 0x0293 }
            float r4 = r1.dDQ     // Catch:{ all -> 0x0293 }
            float r4 = r4 * r3
            float r2 = r2 - r4
            int r12 = (int) r2     // Catch:{ all -> 0x0293 }
            float r2 = r1.dDQ     // Catch:{ all -> 0x0293 }
            int r2 = (int) r2     // Catch:{ all -> 0x0293 }
            r13 = r2
        L_0x012e:
            float r3 = (float) r13     // Catch:{ all -> 0x0293 }
            int r2 = r18.getWidth()     // Catch:{ all -> 0x0293 }
            float r2 = (float) r2     // Catch:{ all -> 0x0293 }
            float r4 = r1.dDQ     // Catch:{ all -> 0x0293 }
            float r2 = r2 - r4
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x01f6
            int r2 = r13 % 4
            if (r2 != 0) goto L_0x01ec
            double[] r2 = r1.dDW     // Catch:{ all -> 0x0293 }
            int r2 = r2.length     // Catch:{ all -> 0x0293 }
            float r2 = (float) r2     // Catch:{ all -> 0x0293 }
            float r4 = (float) r12     // Catch:{ all -> 0x0293 }
            float r2 = r2 / r4
            float r4 = r1.dDQ     // Catch:{ all -> 0x0293 }
            float r4 = r3 - r4
            float r2 = r2 * r4
            int r2 = (int) r2     // Catch:{ all -> 0x0293 }
            double r4 = r1.dDX     // Catch:{ all -> 0x0293 }
            float r4 = r1.m26651g(r4)     // Catch:{ all -> 0x0293 }
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x0169
            double r4 = r1.dDY     // Catch:{ all -> 0x0293 }
            float r4 = r1.m26651g(r4)     // Catch:{ all -> 0x0293 }
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0161
            goto L_0x0169
        L_0x0161:
            android.graphics.Paint r4 = r1.paint     // Catch:{ all -> 0x0293 }
            int r5 = r1.dDL     // Catch:{ all -> 0x0293 }
            r4.setColor(r5)     // Catch:{ all -> 0x0293 }
            goto L_0x016e
        L_0x0169:
            android.graphics.Paint r4 = r1.paint     // Catch:{ all -> 0x0293 }
            r4.setColor(r8)     // Catch:{ all -> 0x0293 }
        L_0x016e:
            double[] r4 = r1.dDW     // Catch:{ all -> 0x0293 }
            int r4 = r4.length     // Catch:{ all -> 0x0293 }
            int r4 = r4 - r9
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r14 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            if (r2 <= r4) goto L_0x0197
            int r2 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            double r8 = (double) r2     // Catch:{ all -> 0x0293 }
            double r8 = r8 * r14
            double r8 = r8 - r5
            float r4 = (float) r8     // Catch:{ all -> 0x0293 }
            int r2 = r13 + 2
            float r7 = (float) r2     // Catch:{ all -> 0x0293 }
            int r2 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            double r8 = (double) r2     // Catch:{ all -> 0x0293 }
            double r8 = r8 * r14
            double r8 = r8 + r5
            float r6 = (float) r8     // Catch:{ all -> 0x0293 }
            android.graphics.Paint r8 = r1.paint     // Catch:{ all -> 0x0293 }
            r2 = r19
            r5 = r7
            r7 = r8
            r2.drawRect(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0293 }
            goto L_0x01ec
        L_0x0197:
            double[] r4 = r1.dDW     // Catch:{ all -> 0x0293 }
            r7 = r4[r2]     // Catch:{ all -> 0x0293 }
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x01ce
            r16 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r7 = r7 / r16
            int r2 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            double r10 = (double) r2     // Catch:{ all -> 0x0293 }
            double r10 = r10 * r7
            int r2 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x01af
            goto L_0x01ce
        L_0x01af:
            r2 = 0
            double r4 = r14 - r7
            int r2 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            double r9 = (double) r2     // Catch:{ all -> 0x0293 }
            double r4 = r4 * r9
            float r4 = (float) r4     // Catch:{ all -> 0x0293 }
            int r2 = r13 + 2
            float r5 = (float) r2     // Catch:{ all -> 0x0293 }
            double r7 = r7 + r14
            int r2 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            double r9 = (double) r2     // Catch:{ all -> 0x0293 }
            double r7 = r7 * r9
            float r6 = (float) r7     // Catch:{ all -> 0x0293 }
            android.graphics.Paint r7 = r1.paint     // Catch:{ all -> 0x0293 }
            r2 = r19
            r2.drawRect(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0293 }
            goto L_0x01ec
        L_0x01ce:
            int r2 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            double r7 = (double) r2     // Catch:{ all -> 0x0293 }
            double r7 = r7 * r14
            double r7 = r7 - r5
            float r4 = (float) r7     // Catch:{ all -> 0x0293 }
            int r2 = r13 + 2
            float r7 = (float) r2     // Catch:{ all -> 0x0293 }
            int r2 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            double r8 = (double) r2     // Catch:{ all -> 0x0293 }
            double r8 = r8 * r14
            double r8 = r8 + r5
            float r6 = (float) r8     // Catch:{ all -> 0x0293 }
            android.graphics.Paint r8 = r1.paint     // Catch:{ all -> 0x0293 }
            r2 = r19
            r5 = r7
            r7 = r8
            r2.drawRect(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0293 }
        L_0x01ec:
            int r13 = r13 + 1
            r8 = -13553359(0xffffffffff313131, float:-2.3552877E38)
            r9 = 1
            r10 = 0
            goto L_0x012e
        L_0x01f6:
            double r2 = r1.dDX     // Catch:{ all -> 0x0293 }
            float r2 = r1.m26651g(r2)     // Catch:{ all -> 0x0293 }
            com.introvd.template.xyui.audiowave.RangeSeekBarV4$c r3 = com.introvd.template.xyui.audiowave.RangeSeekBarV4.C9160c.MIN     // Catch:{ all -> 0x0293 }
            com.introvd.template.xyui.audiowave.RangeSeekBarV4$c r4 = r1.eCO     // Catch:{ all -> 0x0293 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0293 }
            r1.m26645a(r2, r3, r0)     // Catch:{ all -> 0x0293 }
            double r2 = r1.dDY     // Catch:{ all -> 0x0293 }
            float r2 = r1.m26651g(r2)     // Catch:{ all -> 0x0293 }
            com.introvd.template.xyui.audiowave.RangeSeekBarV4$c r3 = com.introvd.template.xyui.audiowave.RangeSeekBarV4.C9160c.MAX     // Catch:{ all -> 0x0293 }
            com.introvd.template.xyui.audiowave.RangeSeekBarV4$c r4 = r1.eCO     // Catch:{ all -> 0x0293 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0293 }
            r1.m26650b(r2, r3, r0)     // Catch:{ all -> 0x0293 }
            boolean r2 = r1.eCQ     // Catch:{ all -> 0x0293 }
            if (r2 == 0) goto L_0x021e
            monitor-exit(r18)
            return
        L_0x021e:
            java.lang.Number r2 = r18.getSelectedMinValue()     // Catch:{ all -> 0x0293 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0293 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = com.introvd.template.xyui.C9163c.m26664kg(r2)     // Catch:{ all -> 0x0293 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0293 }
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1048576000(0x3e800000, float:0.25)
            if (r3 != 0) goto L_0x0257
            android.graphics.Paint r3 = r1.dnF     // Catch:{ all -> 0x0293 }
            r3.measureText(r2)     // Catch:{ all -> 0x0293 }
            int r3 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            float r3 = (float) r3     // Catch:{ all -> 0x0293 }
            float r3 = r3 * r5
            float r6 = r1.dDZ     // Catch:{ all -> 0x0293 }
            float r6 = r6 + r4
            com.introvd.template.xyui.audiowave.RangeSeekBarV4$c r7 = com.introvd.template.xyui.audiowave.RangeSeekBarV4.C9160c.MIN     // Catch:{ all -> 0x0293 }
            com.introvd.template.xyui.audiowave.RangeSeekBarV4$c r8 = r1.eCO     // Catch:{ all -> 0x0293 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0293 }
            if (r7 == 0) goto L_0x0252
            android.graphics.Paint r7 = r1.dDE     // Catch:{ all -> 0x0293 }
            goto L_0x0254
        L_0x0252:
            android.graphics.Paint r7 = r1.dnF     // Catch:{ all -> 0x0293 }
        L_0x0254:
            r0.drawText(r2, r6, r3, r7)     // Catch:{ all -> 0x0293 }
        L_0x0257:
            java.lang.Number r2 = r18.getSelectedMaxValue()     // Catch:{ all -> 0x0293 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0293 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0293 }
            java.lang.String r2 = com.introvd.template.xyui.C9163c.m26664kg(r2)     // Catch:{ all -> 0x0293 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0293 }
            if (r3 != 0) goto L_0x0291
            android.graphics.Paint r3 = r1.dnF     // Catch:{ all -> 0x0293 }
            r3.measureText(r2)     // Catch:{ all -> 0x0293 }
            r18.getWidth()     // Catch:{ all -> 0x0293 }
            float r3 = r1.dDQ     // Catch:{ all -> 0x0293 }
            int r3 = r18.getHeight()     // Catch:{ all -> 0x0293 }
            float r3 = (float) r3     // Catch:{ all -> 0x0293 }
            float r3 = r3 * r5
            float r5 = r1.dEa     // Catch:{ all -> 0x0293 }
            float r5 = r5 + r4
            com.introvd.template.xyui.audiowave.RangeSeekBarV4$c r4 = com.introvd.template.xyui.audiowave.RangeSeekBarV4.C9160c.MAX     // Catch:{ all -> 0x0293 }
            com.introvd.template.xyui.audiowave.RangeSeekBarV4$c r6 = r1.eCO     // Catch:{ all -> 0x0293 }
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0293 }
            if (r4 == 0) goto L_0x028c
            android.graphics.Paint r4 = r1.dDE     // Catch:{ all -> 0x0293 }
            goto L_0x028e
        L_0x028c:
            android.graphics.Paint r4 = r1.dnF     // Catch:{ all -> 0x0293 }
        L_0x028e:
            r0.drawText(r2, r5, r3, r4)     // Catch:{ all -> 0x0293 }
        L_0x0291:
            monitor-exit(r18)
            return
        L_0x0293:
            r0 = move-exception
            monitor-exit(r18)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.xyui.audiowave.RangeSeekBarV4.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3 = 200;
        if (MeasureSpec.getMode(i) != 0) {
            i3 = MeasureSpec.getSize(i);
        }
        int O = C9162a.m26662O(getContext(), IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED);
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
                this.eCO = m26648aV(this.dEh);
                if (this.eCO != null) {
                    if (this.eCP != null) {
                        C9159b<T> bVar = this.eCP;
                        if (this.eCO == C9160c.MIN) {
                            z = true;
                        }
                        bVar.mo29910a(this, z);
                    }
                    setPressed(true);
                    invalidate();
                    axV();
                    m26644R(motionEvent);
                    axU();
                    break;
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            case 1:
                if (this.aMq) {
                    m26644R(motionEvent);
                    axW();
                    setPressed(false);
                } else {
                    axV();
                    m26644R(motionEvent);
                    axW();
                }
                this.eCO = null;
                invalidate();
                if (this.eCP != null) {
                    this.eCP.mo29912b(this, getSelectedMinValue(), getSelectedMaxValue());
                    break;
                }
                break;
            case 2:
                if (this.eCO != null) {
                    if (this.aMq) {
                        m26644R(motionEvent);
                    } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.dEh) > ((float) this.dEi)) {
                        setPressed(true);
                        invalidate();
                        axV();
                        m26644R(motionEvent);
                        axU();
                    }
                    if (this.dEf && this.eCP != null) {
                        this.eCP.mo29909a(this, getSelectedMinValue(), getSelectedMaxValue());
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

    public void setOnRangeSeekBarChangeListener(C9159b<T> bVar) {
        this.eCP = bVar;
    }

    public void setProgressValue(T t) {
        this.eCN = t;
        invalidate();
    }

    public void setSelectedMaxValue(T t) {
        if (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE == this.dDU - this.dDT) {
            setNormalizedMaxValue(1.0d);
        } else {
            setNormalizedMaxValue(m26649b(t));
        }
    }

    public void setSelectedMinValue(T t) {
        if (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE == this.dDU - this.dDT) {
            setNormalizedMinValue(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } else {
            setNormalizedMinValue(m26649b(t));
        }
    }
}
