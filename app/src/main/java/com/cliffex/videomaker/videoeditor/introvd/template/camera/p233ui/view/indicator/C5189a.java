package com.introvd.template.camera.p233ui.view.indicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.view.animation.LinearInterpolator;
import com.introvd.template.VivaBaseApplication;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.camera.ui.view.indicator.a */
public class C5189a extends C5195b {
    /* access modifiers changed from: private */
    public int alpha = 255;
    /* access modifiers changed from: private */
    public int bYT = 0;
    /* access modifiers changed from: private */
    public int bYU = 255;
    private int bYV = 0;
    private int bYW = 0;
    private int bYX = 0;
    private int bYY = 0;
    private int bYZ = 0;
    private int bZa = Color.parseColor("#FF6CFD");
    private int bZb = Color.parseColor("#2C69FF");
    private volatile boolean bZc = false;
    private int mColor = 0;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void initState() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.bZc     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0069
            r0 = 0
            r3.bYT = r0     // Catch:{ all -> 0x006b }
            r0 = 255(0xff, float:3.57E-43)
            r3.bYU = r0     // Catch:{ all -> 0x006b }
            r3.alpha = r0     // Catch:{ all -> 0x006b }
            int r0 = r3.getWidth()     // Catch:{ all -> 0x006b }
            int r0 = r0 / 2
            r3.bYV = r0     // Catch:{ all -> 0x006b }
            int r0 = r3.getHeight()     // Catch:{ all -> 0x006b }
            int r0 = r0 / 2
            r3.bYW = r0     // Catch:{ all -> 0x006b }
            int r0 = r3.bYV     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0024
            monitor-exit(r3)
            return
        L_0x0024:
            r0 = 15
            int r0 = r3.m14159jF(r0)     // Catch:{ all -> 0x006b }
            r1 = 1082130432(0x40800000, float:4.0)
            int r1 = com.introvd.template.p203b.C4583d.m11671P(r1)     // Catch:{ all -> 0x006b }
            boolean r2 = r3.apa     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x004e
            r2 = 1073741824(0x40000000, float:2.0)
            int r2 = com.introvd.template.p203b.C4583d.m11671P(r2)     // Catch:{ all -> 0x006b }
            r3.bYZ = r2     // Catch:{ all -> 0x006b }
            int r2 = r3.bYV     // Catch:{ all -> 0x006b }
            int r2 = r2 - r0
            int r2 = r2 + r1
            r3.bYX = r2     // Catch:{ all -> 0x006b }
            int r2 = r3.bYV     // Catch:{ all -> 0x006b }
            int r2 = r2 - r0
            int r2 = r2 + r1
            r3.bYY = r2     // Catch:{ all -> 0x006b }
            r0 = 16726784(0xff3b00, float:2.3439217E-38)
            r3.mColor = r0     // Catch:{ all -> 0x006b }
            goto L_0x0066
        L_0x004e:
            r2 = 1069547520(0x3fc00000, float:1.5)
            int r2 = com.introvd.template.p203b.C4583d.m11671P(r2)     // Catch:{ all -> 0x006b }
            r3.bYZ = r2     // Catch:{ all -> 0x006b }
            int r2 = r3.bYV     // Catch:{ all -> 0x006b }
            int r2 = r2 - r0
            int r2 = r2 - r1
            r3.bYX = r2     // Catch:{ all -> 0x006b }
            int r1 = r3.bYV     // Catch:{ all -> 0x006b }
            int r1 = r1 - r0
            r3.bYY = r1     // Catch:{ all -> 0x006b }
            r0 = 16605490(0xfd6132, float:2.3269248E-38)
            r3.mColor = r0     // Catch:{ all -> 0x006b }
        L_0x0066:
            r0 = 1
            r3.bZc = r0     // Catch:{ all -> 0x006b }
        L_0x0069:
            monitor-exit(r3)
            return
        L_0x006b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p233ui.view.indicator.C5189a.initState():void");
    }

    /* renamed from: jF */
    private int m14159jF(int i) {
        return mo26307YA() != null ? ((int) mo26307YA().getContext().getResources().getDisplayMetrics().density) * i : (int) (VivaBaseApplication.m8749FZ().getApplicationContext().getResources().getDisplayMetrics().density * ((float) i));
    }

    /* renamed from: Yf */
    public void mo26296Yf() {
        super.mo26296Yf();
        this.bZc = false;
        initState();
    }

    /* renamed from: Yg */
    public void mo26297Yg() {
        super.mo26297Yg();
        this.bZc = false;
        initState();
    }

    /* renamed from: Yz */
    public List<Animator> mo26298Yz() {
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{m14159jF(-3), m14159jF(12)});
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(1000);
        ofInt.setRepeatCount(-1);
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    C5189a.this.bYT = ((Integer) animatedValue).intValue();
                }
                C5189a.this.postInvalidate();
            }
        });
        if (this.apa) {
            ofInt.start();
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{255, 0});
        ofInt2.setInterpolator(new LinearInterpolator());
        ofInt2.setDuration(1000);
        ofInt2.setRepeatCount(-1);
        ofInt2.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    C5189a.this.alpha = ((Integer) animatedValue).intValue();
                }
                C5189a.this.postInvalidate();
            }
        });
        if (this.apa) {
            ofInt2.start();
        }
        ValueAnimator ofInt3 = ValueAnimator.ofInt(new int[]{255, 0});
        ofInt3.setInterpolator(new LinearInterpolator());
        ofInt3.setDuration(250);
        ofInt3.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    C5189a.this.bYU = ((Integer) animatedValue).intValue();
                }
                C5189a.this.postInvalidate();
            }
        });
        boolean z = this.apa;
        ValueAnimator ofInt4 = ValueAnimator.ofInt(new int[]{0, 255});
        ofInt4.setInterpolator(new LinearInterpolator());
        ofInt4.setDuration(750);
        ofInt4.setStartDelay(250);
        ofInt4.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    C5189a.this.bYU = ((Integer) animatedValue).intValue();
                }
                C5189a.this.postInvalidate();
            }
        });
        final AnimatorSet animatorSet = new AnimatorSet();
        if (this.apa) {
            animatorSet.playTogether(new Animator[]{ofInt3, ofInt4});
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    animatorSet.start();
                }
            });
            animatorSet.setDuration(1000);
            animatorSet.start();
        }
        arrayList.add(ofInt);
        arrayList.add(ofInt2);
        arrayList.add(animatorSet);
        return arrayList;
    }

    public void draw(Canvas canvas, Paint paint) {
        initState();
        paint.setColor(this.mColor);
        canvas.save();
        paint.setAlpha(this.bYU);
        paint.setStyle(Style.FILL);
        int i = this.bYV + this.bYX;
        int i2 = this.bYV + this.bYX;
        int i3 = this.bYV - this.bYX;
        int i4 = this.bYV - this.bYX;
        LinearGradient linearGradient = new LinearGradient((float) i, (float) i2, (float) i3, (float) i4, this.bZa, this.bZb, TileMode.CLAMP);
        paint.setShader(linearGradient);
        canvas.drawCircle((float) this.bYV, (float) this.bYV, (float) this.bYX, paint);
        canvas.restore();
        paint.setAlpha(this.alpha);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth((float) this.bYZ);
        canvas.save();
        canvas.drawCircle((float) this.bYV, (float) this.bYV, (float) (this.bYY + this.bYT), paint);
        canvas.restore();
    }

    public void setGradientColor(int i, int i2) {
        this.bZa = i;
        this.bZb = i2;
    }
}
