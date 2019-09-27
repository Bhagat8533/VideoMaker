package com.introvd.template.editor.videotrim.crop.p289a;

import android.graphics.RectF;
import com.introvd.template.editor.videotrim.crop.p291c.C6978a;

/* renamed from: com.introvd.template.editor.videotrim.crop.a.a */
public enum C6969a {
    LEFT,
    TOP,
    RIGHT,
    BOTTOM;
    
    private static int dmu;
    private static int dmv;
    private static float dmw;
    private float dmx;

    static {
        dmu = 100;
        dmv = 100;
        dmw = 5.0f;
    }

    /* renamed from: a */
    private static float m20376a(float f, RectF rectF, float f2, float f3) {
        if (f - rectF.left < f2) {
            return rectF.left;
        }
        float f4 = Float.POSITIVE_INFINITY;
        if (f >= RIGHT.atF() - ((float) dmv)) {
            f4 = RIGHT.atF() - ((float) dmv);
        }
        float min = Math.min(f, f4);
        float atF = (BOTTOM.atF() - TOP.atF()) / dmw;
        return RIGHT.atF() - min < atF ? RIGHT.atF() - atF : min;
    }

    /* renamed from: a */
    private boolean m20377a(float f, float f2, float f3, float f4, RectF rectF) {
        return f < rectF.top || f2 < rectF.left || f3 > rectF.bottom || f4 > rectF.right;
    }

    /* renamed from: b */
    private static float m20378b(float f, RectF rectF, float f2, float f3) {
        if (rectF.right - f < f2) {
            return rectF.right;
        }
        float f4 = Float.NEGATIVE_INFINITY;
        if (f <= LEFT.atF() + ((float) dmv)) {
            f4 = LEFT.atF() + ((float) dmv);
        }
        float max = Math.max(f, f4);
        float atF = (BOTTOM.atF() - TOP.atF()) / dmw;
        return max - LEFT.atF() < atF ? LEFT.atF() + atF : max;
    }

    /* renamed from: c */
    private static float m20379c(float f, RectF rectF, float f2, float f3) {
        if (f - rectF.top < f2) {
            return rectF.top;
        }
        float f4 = Float.POSITIVE_INFINITY;
        if (f >= BOTTOM.atF() - ((float) dmu)) {
            f4 = BOTTOM.atF() - ((float) dmu);
        }
        float min = Math.min(f, f4);
        float atF = (RIGHT.atF() - LEFT.atF()) / dmw;
        return BOTTOM.atF() - min < atF ? BOTTOM.atF() - atF : min;
    }

    /* renamed from: d */
    private static float m20380d(float f, RectF rectF, float f2, float f3) {
        if (rectF.bottom - f < f2) {
            return rectF.bottom;
        }
        float f4 = Float.NEGATIVE_INFINITY;
        if (f <= TOP.atF() + ((float) dmu)) {
            f4 = TOP.atF() + ((float) dmu);
        }
        float max = Math.max(f, f4);
        float atF = (RIGHT.atF() - LEFT.atF()) / dmw;
        return max - TOP.atF() < atF ? TOP.atF() + atF : max;
    }

    public static float getHeight() {
        return BOTTOM.atF() - TOP.atF();
    }

    public static float getWidth() {
        return RIGHT.atF() - LEFT.atF();
    }

    /* renamed from: a */
    public void mo30655a(float f, float f2, RectF rectF, float f3, float f4) {
        switch (this) {
            case LEFT:
                this.dmx = m20376a(f, rectF, f3, f4);
                return;
            case TOP:
                this.dmx = m20379c(f2, rectF, f3, f4);
                return;
            case RIGHT:
                this.dmx = m20378b(f, rectF, f3, f4);
                return;
            case BOTTOM:
                this.dmx = m20380d(f2, rectF, f3, f4);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public boolean mo30656a(C6969a aVar, RectF rectF, float f) {
        float j = aVar.mo30663j(rectF);
        switch (this) {
            case LEFT:
                if (aVar.equals(TOP)) {
                    float f2 = rectF.top;
                    float atF = BOTTOM.atF() - j;
                    float atF2 = RIGHT.atF();
                    return m20377a(f2, C6978a.m20406l(f2, atF2, atF, f), atF, atF2, rectF);
                } else if (aVar.equals(BOTTOM)) {
                    float f3 = rectF.bottom;
                    float atF3 = TOP.atF() - j;
                    float atF4 = RIGHT.atF();
                    return m20377a(atF3, C6978a.m20406l(atF3, atF4, f3, f), f3, atF4, rectF);
                }
                break;
            case TOP:
                if (aVar.equals(LEFT)) {
                    float f4 = rectF.left;
                    float atF5 = RIGHT.atF() - j;
                    float atF6 = BOTTOM.atF();
                    return m20377a(C6978a.m20407m(f4, atF5, atF6, f), f4, atF6, atF5, rectF);
                } else if (aVar.equals(RIGHT)) {
                    float f5 = rectF.right;
                    float atF7 = LEFT.atF() - j;
                    float atF8 = BOTTOM.atF();
                    return m20377a(C6978a.m20407m(atF7, f5, atF8, f), atF7, atF8, f5, rectF);
                }
                break;
            case RIGHT:
                if (aVar.equals(TOP)) {
                    float f6 = rectF.top;
                    float atF9 = BOTTOM.atF() - j;
                    float atF10 = LEFT.atF();
                    return m20377a(f6, atF10, atF9, C6978a.m20408n(atF10, f6, atF9, f), rectF);
                } else if (aVar.equals(BOTTOM)) {
                    float f7 = rectF.bottom;
                    float atF11 = TOP.atF() - j;
                    float atF12 = LEFT.atF();
                    return m20377a(atF11, atF12, f7, C6978a.m20408n(atF12, atF11, f7, f), rectF);
                }
                break;
            case BOTTOM:
                if (aVar.equals(LEFT)) {
                    float f8 = rectF.left;
                    float atF13 = RIGHT.atF() - j;
                    float atF14 = TOP.atF();
                    return m20377a(atF14, f8, C6978a.m20409o(f8, atF14, atF13, f), atF13, rectF);
                } else if (aVar.equals(RIGHT)) {
                    float f9 = rectF.right;
                    float atF15 = LEFT.atF() - j;
                    float atF16 = TOP.atF();
                    return m20377a(atF16, atF15, C6978a.m20409o(atF15, atF16, f9, f), f9, rectF);
                }
                break;
        }
        return true;
    }

    public float atF() {
        return this.dmx;
    }

    /* renamed from: aw */
    public void mo30658aw(float f) {
        this.dmx = f;
    }

    /* renamed from: ax */
    public void mo30659ax(float f) {
        this.dmx += f;
    }

    /* renamed from: ay */
    public void mo30660ay(float f) {
        float atF = LEFT.atF();
        float atF2 = TOP.atF();
        float atF3 = RIGHT.atF();
        float atF4 = BOTTOM.atF();
        switch (this) {
            case LEFT:
                this.dmx = C6978a.m20406l(atF2, atF3, atF4, f);
                return;
            case TOP:
                this.dmx = C6978a.m20407m(atF, atF3, atF4, f);
                return;
            case RIGHT:
                this.dmx = C6978a.m20408n(atF, atF2, atF4, f);
                return;
            case BOTTOM:
                this.dmx = C6978a.m20409o(atF, atF2, atF3, f);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public boolean mo30661b(RectF rectF, float f) {
        switch (this) {
            case LEFT:
                if (this.dmx - rectF.left >= f) {
                    return false;
                }
                break;
            case TOP:
                if (this.dmx - rectF.top >= f) {
                    return false;
                }
                break;
            case RIGHT:
                if (rectF.right - this.dmx >= f) {
                    return false;
                }
                break;
            default:
                if (rectF.bottom - this.dmx >= f) {
                    return false;
                }
                break;
        }
        return true;
    }

    /* renamed from: i */
    public float mo30662i(RectF rectF) {
        float f = this.dmx;
        switch (this) {
            case LEFT:
                this.dmx = rectF.left;
                break;
            case TOP:
                this.dmx = rectF.top;
                break;
            case RIGHT:
                this.dmx = rectF.right;
                break;
            case BOTTOM:
                this.dmx = rectF.bottom;
                break;
        }
        return this.dmx - f;
    }

    /* renamed from: j */
    public float mo30663j(RectF rectF) {
        float f;
        float f2 = this.dmx;
        switch (this) {
            case LEFT:
                f = rectF.left;
                break;
            case TOP:
                f = rectF.top;
                break;
            case RIGHT:
                f = rectF.right;
                break;
            default:
                f = rectF.bottom;
                break;
        }
        return f - f2;
    }

    /* renamed from: pF */
    public void mo30664pF(int i) {
        dmu = i;
    }

    /* renamed from: pG */
    public void mo30665pG(int i) {
        dmv = i;
    }
}
