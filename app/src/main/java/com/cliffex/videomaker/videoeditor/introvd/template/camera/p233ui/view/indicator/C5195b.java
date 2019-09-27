package com.introvd.template.camera.p233ui.view.indicator;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.introvd.template.camera.ui.view.indicator.b */
public abstract class C5195b {
    protected volatile boolean apa = false;
    private WeakReference<View> bZf;
    private List<Animator> bZg;

    /* renamed from: com.introvd.template.camera.ui.view.indicator.b$a */
    public enum C5197a {
        START,
        END,
        CANCEL
    }

    /* renamed from: WV */
    public void mo26306WV() {
        if (this.bZg == null) {
            this.bZg = mo26298Yz();
        }
    }

    /* renamed from: YA */
    public View mo26307YA() {
        if (this.bZf != null) {
            return (View) this.bZf.get();
        }
        return null;
    }

    /* renamed from: Yf */
    public void mo26296Yf() {
        if (!this.apa) {
            this.apa = true;
            mo26308a(C5197a.START);
            postInvalidate();
        }
    }

    /* renamed from: Yg */
    public void mo26297Yg() {
        if (this.apa) {
            this.apa = false;
            mo26308a(C5197a.END);
            postInvalidate();
        }
    }

    /* renamed from: Yz */
    public abstract List<Animator> mo26298Yz();

    /* renamed from: a */
    public void mo26308a(C5197a aVar) {
        if (this.bZg != null) {
            int size = this.bZg.size();
            for (int i = 0; i < size; i++) {
                Animator animator = (Animator) this.bZg.get(i);
                boolean isRunning = animator.isRunning();
                switch (aVar) {
                    case START:
                        if (!isRunning && this.apa) {
                            animator.start();
                            break;
                        }
                    case END:
                        if (!isRunning) {
                            break;
                        } else {
                            animator.end();
                            break;
                        }
                    case CANCEL:
                        if (!isRunning) {
                            break;
                        } else {
                            animator.cancel();
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: cq */
    public void mo26309cq(View view) {
        this.bZf = new WeakReference<>(view);
    }

    public abstract void draw(Canvas canvas, Paint paint);

    public int getHeight() {
        if (mo26307YA() != null) {
            return mo26307YA().getHeight();
        }
        return 0;
    }

    public int getWidth() {
        if (mo26307YA() != null) {
            return mo26307YA().getWidth();
        }
        return 0;
    }

    public void postInvalidate() {
        if (mo26307YA() != null) {
            mo26307YA().postInvalidate();
        }
    }
}
