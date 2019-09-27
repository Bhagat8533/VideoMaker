package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.introvd.template.vivacamera.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.camera.ui.view.SegProgressbar */
public class SegProgressbar extends View {
    private final int bXH;
    private final int bXI;
    private final int bXJ;
    private final int bXK;
    private final int bXL;
    private final int bXM;
    private final int bXN;
    private final int bXO;
    private final int bXP;
    private final int bXQ;
    private final int bXR;
    private int bXS;
    private long bXT;
    private float bXU;
    private float bXV;
    private int bXW;
    private int bXX;
    private int bXY;
    private int bXZ;
    private int bYa;
    private int bYb;
    private int bYc;
    private float bYd;
    private boolean bYe;
    private boolean bYf;
    private float bYg;
    private float bYh;
    private float bYi;
    RectF bYj;
    RectF bYk;
    private List<Long> bYl;
    private boolean bYm;
    private boolean bYn;
    private float bYo;
    private C5176a bYp;
    private Paint paint;
    private long progress;

    /* renamed from: qZ */
    private float f3442qZ;

    /* renamed from: ra */
    private float f3443ra;
    private float textSize;

    /* renamed from: com.introvd.template.camera.ui.view.SegProgressbar$a */
    public interface C5176a {
        /* renamed from: Ub */
        void mo24957Ub();
    }

    public SegProgressbar(Context context) {
        this(context, null);
    }

    public SegProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SegProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bXH = 450;
        this.bXI = 12;
        this.bXJ = 1000;
        this.bXK = 0;
        this.bXL = Color.parseColor("#FF7044");
        this.bXM = Color.parseColor("#00000000");
        this.bXN = 50;
        this.bXO = 20;
        this.bXP = 30;
        this.bXQ = 0;
        this.bXR = Color.parseColor("#FF2040");
        this.bXS = 0;
        this.progress = 0;
        this.bXT = 1000;
        this.bXU = 450.0f;
        this.bXV = 12.0f;
        this.bXW = this.bXL;
        this.bXX = this.bXM;
        this.bXY = -16777216;
        this.bXZ = -16776961;
        this.bYa = -65536;
        this.bYb = this.bXW;
        this.bYc = -7829368;
        this.bYd = 20.0f;
        this.textSize = 30.0f;
        this.bYg = 70.0f;
        this.bYh = 50.0f;
        this.bYi = -90.0f;
        this.bYm = true;
        this.bYn = false;
        this.bYo = 1.0f;
        m14058b(context, attributeSet, i);
    }

    /* renamed from: b */
    private void m14058b(Context context, AttributeSet attributeSet, int i) {
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        windowManager.getDefaultDisplay().getHeight();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegProgressbar, i, 0);
        this.bXU = obtainStyledAttributes.getDimension(R.styleable.SegProgressbar_p_width, (float) width);
        this.bXV = obtainStyledAttributes.getDimension(R.styleable.SegProgressbar_p_height, 12.0f);
        this.bXS = obtainStyledAttributes.getInteger(R.styleable.SegProgressbar_p_shapeType, 0);
        this.bYe = obtainStyledAttributes.getBoolean(R.styleable.SegProgressbar_p_showText, false);
        this.bYf = obtainStyledAttributes.getBoolean(R.styleable.SegProgressbar_p_showProgressSegment, false);
        if (this.bXS == 1) {
            this.bYh = obtainStyledAttributes.getDimension(R.styleable.SegProgressbar_p_circle_radius, 50.0f);
            this.bYg = obtainStyledAttributes.getDimension(R.styleable.SegProgressbar_p_circle_X_Y, this.bYh + 20.0f);
        }
        if (this.bXS == 2) {
            this.bYd = obtainStyledAttributes.getDimension(R.styleable.SegProgressbar_p_square_radius, 20.0f);
        }
        if (this.bYe) {
            this.textSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.SegProgressbar_p_textSize, 30);
        }
        this.bXT = (long) obtainStyledAttributes.getInteger(R.styleable.SegProgressbar_p_maxValue, 1000);
        this.progress = (long) obtainStyledAttributes.getInteger(R.styleable.SegProgressbar_p_progressValue, 0);
        this.bXW = obtainStyledAttributes.getColor(R.styleable.SegProgressbar_p_progressColor, this.bXL);
        this.bXX = obtainStyledAttributes.getColor(R.styleable.SegProgressbar_p_progressBackColor, this.bXM);
        this.bXY = obtainStyledAttributes.getColor(R.styleable.SegProgressbar_p_textLowColor, -16777216);
        this.bXZ = obtainStyledAttributes.getColor(R.styleable.SegProgressbar_p_textMiddleColor, -16776961);
        this.bYa = obtainStyledAttributes.getColor(R.styleable.SegProgressbar_p_textHighColor, -65536);
        this.bYb = obtainStyledAttributes.getColor(R.styleable.SegProgressbar_p_progressSegmentColor, this.bXL);
        this.bYc = obtainStyledAttributes.getColor(R.styleable.SegProgressbar_p_progressDoubleSegColor, -7829368);
        obtainStyledAttributes.recycle();
        this.paint = new Paint();
        this.bYj = new RectF();
        this.bYk = new RectF();
        this.bYl = new ArrayList();
        this.paint.setAntiAlias(true);
        this.paint.setFlags(1);
        this.paint.setColor(Color.parseColor("#EFEFEF"));
        this.paint.setStrokeWidth(10.0f);
        this.paint.setStyle(Style.FILL);
    }

    /* renamed from: Yj */
    public void mo26192Yj() {
        this.bYn = true;
        invalidate();
    }

    /* renamed from: Yk */
    public void mo26193Yk() {
        this.bYn = false;
        invalidate();
    }

    /* renamed from: Yl */
    public boolean mo26194Yl() {
        return this.progress / (this.bXT - 10) >= 1 || this.progress / (this.bXT + 10) >= 1;
    }

    /* renamed from: Ym */
    public void mo26195Ym() {
        if (this.bXT != 0) {
            if (this.bYl.size() > 0) {
                long longValue = ((Long) this.bYl.get(this.bYl.size() - 1)).longValue();
                if (this.progress > longValue) {
                    this.progress = longValue;
                } else {
                    this.bYl.remove(this.bYl.size() - 1);
                    if (this.bYl.size() == 0) {
                        this.progress = 0;
                    } else {
                        this.progress = ((Long) this.bYl.get(this.bYl.size() - 1)).longValue();
                    }
                }
            } else {
                this.progress = 0;
            }
            invalidate();
        }
    }

    /* renamed from: Yn */
    public void mo26196Yn() {
        if (this.bXT != 0) {
            this.bXW = this.bXL;
            this.bYm = true;
        }
    }

    /* renamed from: Yo */
    public void mo26197Yo() {
    }

    /* renamed from: b */
    public void mo26198b(ArrayList<Integer> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.progress = (long) (((float) this.progress) + (((float) ((Integer) arrayList.get(i)).intValue()) / this.bYo));
                this.bYl.add(Long.valueOf(this.progress));
                invalidate();
            }
        }
    }

    /* renamed from: du */
    public void mo26199du(boolean z) {
        if (this.bXT != 0) {
        }
    }

    /* renamed from: dv */
    public void mo26200dv(boolean z) {
        if (this.bXT != 0) {
            setProgress(this.progress, z);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        this.paint.setColor(this.bXX);
        this.paint.setStrokeWidth(10.0f);
        this.paint.setTextSize(this.textSize);
        this.f3442qZ = 0.0f;
        this.f3443ra = 0.0f;
        int i = 0;
        switch (this.bXS) {
            case 0:
                canvas.drawRect(this.f3442qZ, this.f3443ra, this.bXU, this.bXV, this.paint);
                this.paint.setColor(this.bXW);
                canvas.drawRect(this.f3442qZ, this.f3443ra, this.bXU * (((float) this.progress) / ((float) this.bXT)), this.bXV, this.paint);
                if (this.bYn) {
                    this.paint.setStrokeWidth(10.0f);
                    this.paint.setColor(this.bXR);
                    if (this.bYl.size() > 0) {
                        if (this.progress > ((Long) this.bYl.get(this.bYl.size() - 1)).longValue()) {
                            canvas.drawRect(this.bXU * (((float) ((Long) this.bYl.get(this.bYl.size() - 1)).longValue()) / ((float) this.bXT)), this.f3443ra, this.bXU * (((float) this.progress) / ((float) this.bXT)), this.bXV, this.paint);
                        } else {
                            canvas.drawRect(this.bYl.size() > 1 ? (((float) ((Long) this.bYl.get(this.bYl.size() - 2)).longValue()) / ((float) this.bXT)) * this.bXU : 0.0f, this.f3443ra, this.bXU * (((float) this.progress) / ((float) this.bXT)), this.bXV, this.paint);
                        }
                    } else {
                        canvas.drawRect(this.f3442qZ, this.f3443ra, this.bXU * (((float) this.progress) / ((float) this.bXT)), this.bXV, this.paint);
                    }
                }
                this.paint.setStrokeWidth(4.0f);
                this.paint.setColor(this.bYc);
                if (this.bYl.size() > 0) {
                    while (i < this.bYl.size()) {
                        canvas.drawLine(this.bXU * (((float) ((Long) this.bYl.get(i)).longValue()) / ((float) this.bXT)), this.f3443ra, this.bXU * (((float) ((Long) this.bYl.get(i)).longValue()) / ((float) this.bXT)), (this.bXV - this.f3443ra) + this.f3443ra, this.paint);
                        i++;
                    }
                }
                if (this.bYf) {
                    this.paint.setColor(this.bYb);
                    this.paint.setStrokeWidth(4.0f);
                    canvas.drawLine(this.bXU * (((float) this.progress) / ((float) this.bXT)), this.f3443ra, this.bXU * (((float) this.progress) / ((float) this.bXT)), (this.bXV - this.f3443ra) + this.f3443ra, this.paint);
                }
                if (this.bYe) {
                    if (this.progress < this.bXT / 3) {
                        this.paint.setColor(this.bXY);
                    } else if (this.progress >= (this.bXT / 3) * 2 || this.progress <= this.bXT / 3) {
                        this.paint.setColor(this.bYa);
                    } else {
                        this.paint.setColor(this.bXZ);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append((int) ((((float) this.progress) / ((float) this.bXT)) * 1000.0f));
                    sb.append("%");
                    canvas2.drawText(sb.toString(), ((((float) this.progress) / ((float) this.bXT)) * this.bXU) - (this.progress == 0 ? 0.0f : this.textSize), this.bXV + this.textSize, this.paint);
                    return;
                }
                return;
            case 1:
                this.paint.setStyle(Style.STROKE);
                this.paint.setColor(this.bXW);
                this.bYj.set(this.bYg, this.bYg, this.bYg + (this.bYh * 2.0f), this.bYg + (this.bYh * 2.0f));
                if (this.bYl.size() > 0) {
                    this.bYi = -90.0f;
                    boolean z = true;
                    float f = 0.0f;
                    for (Long longValue : this.bYl) {
                        float longValue2 = (float) longValue.longValue();
                        float f2 = longValue2 - f;
                        canvas.drawArc(this.bYj, this.bYi, (f2 / ((float) this.bXT)) * 360.0f, false, this.paint);
                        this.bYi = ((f2 / ((float) this.bXT)) * 360.0f) + this.bYi;
                        if (z) {
                            this.paint.setColor(this.bYb);
                        } else {
                            this.paint.setColor(this.bXW);
                        }
                        z = !z;
                        f = longValue2;
                    }
                    canvas.drawArc(this.bYj, this.bYi, ((((float) this.progress) - f) / ((float) this.bXT)) * 360.0f, false, this.paint);
                } else {
                    canvas.drawArc(this.bYj, this.bYi, (((float) this.progress) / ((float) this.bXT)) * 360.0f, false, this.paint);
                }
                if (this.bYe) {
                    this.paint.reset();
                    this.paint.setStrokeWidth(1.0f);
                    this.paint.setTextSize(this.textSize);
                    if (this.progress < this.bXT / 3) {
                        this.paint.setColor(this.bXY);
                    } else if (this.progress >= (this.bXT / 3) * 2 || this.progress <= this.bXT / 3) {
                        this.paint.setColor(this.bYa);
                    } else {
                        this.paint.setColor(this.bXZ);
                    }
                    if (this.progress == this.bXT) {
                        canvas2.drawText("Done", this.bYg + (this.textSize / 2.0f), this.bYg + (this.textSize * 2.0f), this.paint);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((int) ((((float) this.progress) / ((float) this.bXT)) * 1000.0f));
                    sb2.append("%");
                    canvas2.drawText(sb2.toString(), this.bYg + (this.textSize / 2.0f), this.bYg + (this.textSize * 2.0f), this.paint);
                    return;
                }
                return;
            case 2:
                this.bYk.set(this.f3442qZ, this.f3443ra, this.bXU, this.bXV);
                canvas2.drawRoundRect(this.bYk, this.bYd, this.bYd, this.paint);
                this.paint.setColor(this.bXW);
                this.bYk.set(this.f3442qZ, this.f3443ra, (((float) this.progress) / ((float) this.bXT)) * this.bXU, this.bXV);
                canvas2.drawRoundRect(this.bYk, this.bYd, this.bYd, this.paint);
                this.paint.setColor(this.bYc);
                this.paint.setStrokeWidth(1.0f);
                if (this.bYl.size() > 0) {
                    while (i < this.bYl.size()) {
                        canvas.drawLine(this.bXU * (((float) ((Long) this.bYl.get(i)).longValue()) / ((float) this.bXT)), this.f3443ra, this.bXU * (((float) ((Long) this.bYl.get(i)).longValue()) / ((float) this.bXT)), (this.bXV - this.f3443ra) + this.f3443ra, this.paint);
                        i++;
                    }
                }
                this.paint.setColor(this.bYb);
                this.paint.setStrokeWidth(4.0f);
                canvas.drawLine(this.bXU * (((float) this.progress) / ((float) this.bXT)), this.f3443ra, this.bXU * (((float) this.progress) / ((float) this.bXT)), (this.bXV - this.f3443ra) + this.f3443ra, this.paint);
                if (this.bYe) {
                    if (this.progress < this.bXT / 3) {
                        this.paint.setColor(this.bXY);
                    } else if (this.progress >= (this.bXT / 3) * 2 || this.progress <= this.bXT / 3) {
                        this.paint.setColor(this.bYa);
                    } else {
                        this.paint.setColor(this.bXZ);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append((int) ((((float) this.progress) / ((float) this.bXT)) * 1000.0f));
                    sb3.append("%");
                    canvas2.drawText(sb3.toString(), ((((float) this.progress) / ((float) this.bXT)) * this.bXU) - (this.progress == 0 ? 0.0f : this.textSize), this.bXV + this.textSize, this.paint);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setNewProcess(boolean z) {
        this.bYm = z;
    }

    public void setProcessLimit(long j) {
        this.bYo = (float) (j / this.bXT);
    }

    public void setProgress(long j) {
        setProgress((long) (((float) j) / this.bYo), false);
    }

    public void setProgress(long j, boolean z) {
        if (this.bXT != 0 && j >= this.progress) {
            if (j <= this.bXT + 10) {
                this.progress = j;
                if (this.bYm && z) {
                    this.bYl.add(Long.valueOf(j));
                }
                invalidate();
            } else {
                if (this.bYp != null) {
                    this.bYp.mo24957Ub();
                }
                mo26199du(false);
            }
        }
    }

    public void setSegListener(C5176a aVar) {
        this.bYp = aVar;
    }
}
