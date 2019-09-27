package com.introvd.template.gallery.view.p315a;

import android.graphics.Rect;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.introvd.template.gallery.view.a.a */
public enum C7508a {
    LEFT,
    TOP,
    RIGHT,
    BOTTOM;
    
    private float dmx;

    public static float getHeight() {
        return BOTTOM.atF() - TOP.atF();
    }

    public static float getWidth() {
        return RIGHT.atF() - LEFT.atF();
    }

    public float atF() {
        return this.dmx;
    }

    /* renamed from: aw */
    public void mo32294aw(float f) {
        this.dmx = f;
    }

    /* renamed from: o */
    public boolean mo32295o(Rect rect) {
        switch (this) {
            case LEFT:
                if (((double) (this.dmx - ((float) rect.left))) >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return false;
                }
                break;
            case TOP:
                if (((double) (this.dmx - ((float) rect.top))) >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return false;
                }
                break;
            case RIGHT:
                if (((double) (((float) rect.right) - this.dmx)) >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return false;
                }
                break;
            case BOTTOM:
                if (((double) (((float) rect.bottom) - this.dmx)) >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }
}
