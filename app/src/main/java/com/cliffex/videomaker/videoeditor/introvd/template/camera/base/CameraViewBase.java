package com.introvd.template.camera.base;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.introvd.template.template.p409g.C8759b;
import com.mediarecorder.engine.QPIPFrameParam;

public abstract class CameraViewBase extends AbstractCameraView {
    protected Animation bOP;
    protected Animation bOQ;
    protected Animation bOR;
    protected Animation bOS;
    protected boolean bOT = false;
    protected Animation mHideAnim;
    protected Animation mShowAnim;

    public CameraViewBase(Context context) {
        super(context);
    }

    /* renamed from: Tr */
    public abstract void mo25846Tr();

    /* renamed from: UA */
    public abstract void mo25847UA();

    /* renamed from: UB */
    public abstract void mo25848UB();

    /* renamed from: UC */
    public abstract void mo25849UC();

    /* renamed from: UD */
    public abstract void mo25850UD();

    /* renamed from: UE */
    public void mo25851UE() {
        this.bOT = true;
        mo25853UG();
    }

    /* renamed from: UF */
    public void mo25852UF() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: UG */
    public abstract void mo25853UG();

    /* renamed from: Ux */
    public abstract void mo25854Ux();

    /* renamed from: Uy */
    public abstract void mo25855Uy();

    /* renamed from: Uz */
    public abstract void mo25856Uz();

    /* renamed from: a */
    public abstract void mo25857a(int i, QPIPFrameParam qPIPFrameParam);

    /* renamed from: b */
    public void mo25858b(final View view, boolean z, boolean z2) {
        if (view != null) {
            if (z) {
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                    if (z2) {
                        view.startAnimation(this.bOR);
                    }
                }
            } else if (view.getVisibility() == 0 && z2) {
                this.bOS.setAnimationListener(new AnimationListener() {
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(8);
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }
                });
                view.startAnimation(this.bOS);
            }
        }
    }

    /* renamed from: bU */
    public abstract void mo25859bU(int i, int i2);

    /* renamed from: cl */
    public void mo25860cl(View view) {
        if (view != null && view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    /* renamed from: cp */
    public abstract void mo25861cp(boolean z);

    /* renamed from: cq */
    public abstract void mo25862cq(boolean z);

    public abstract void setCameraMode(int i, int i2, boolean z);

    public abstract void setPipEffect(int i, boolean z);

    public abstract void setPipEffectMgr(C8759b bVar);
}
