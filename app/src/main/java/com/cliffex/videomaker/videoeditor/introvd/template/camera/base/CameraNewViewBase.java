package com.introvd.template.camera.base;

import android.content.Context;
import android.view.animation.Animation;
import com.introvd.template.sdk.model.template.TemplateInfo;

public abstract class CameraNewViewBase extends AbstractCameraView {
    protected Animation bOP;
    protected Animation bOQ;
    protected Animation bOR;
    protected Animation bOS;
    protected Animation mHideAnim;
    protected Animation mShowAnim;

    public CameraNewViewBase(Context context) {
        super(context);
    }

    /* renamed from: Us */
    public abstract void mo25829Us();

    /* renamed from: Ut */
    public abstract void mo25830Ut();

    /* renamed from: Uu */
    public abstract void mo25831Uu();

    /* renamed from: Uv */
    public abstract void mo25832Uv();

    /* renamed from: Uw */
    public abstract void mo25833Uw();

    /* renamed from: a */
    public abstract void mo25834a(TemplateInfo templateInfo, int i);

    /* renamed from: a */
    public abstract void mo25835a(boolean z, String str, String str2, boolean z2);

    /* renamed from: af */
    public abstract void mo25836af(long j);

    /* renamed from: bT */
    public abstract void mo25837bT(int i, int i2);

    /* renamed from: cn */
    public abstract void mo25838cn(boolean z);

    /* renamed from: co */
    public abstract void mo25839co(boolean z);

    /* renamed from: eQ */
    public abstract void mo25840eQ(String str);

    /* renamed from: eR */
    public abstract void mo25841eR(String str);

    /* renamed from: iH */
    public abstract void mo25842iH(int i);

    public abstract void setCameraMode(int i, int i2, boolean z, boolean z2);

    public abstract void setCameraViewRatio(int i);

    public abstract void setMusicViewEnable(boolean z);
}
