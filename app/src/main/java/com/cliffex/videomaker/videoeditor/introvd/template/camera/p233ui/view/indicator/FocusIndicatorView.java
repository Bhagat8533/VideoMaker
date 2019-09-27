package com.introvd.template.camera.p233ui.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.indicator.FocusIndicatorView */
public class FocusIndicatorView extends View {
    private Animation bZm;

    public FocusIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZm = AnimationUtils.loadAnimation(context, R.anim.xiaoying_focus_zoomout);
    }

    /* renamed from: YE */
    private boolean m14105YE() {
        return SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "unlock"));
    }

    private void setDrawable(int i) {
        setBackgroundResource(i);
    }

    /* renamed from: YB */
    public void mo26229YB() {
        setVisibility(0);
        if (!m14105YE()) {
            setDrawable(R.drawable.xiaoying_cam_focusing);
        } else if (CameraCodeMgr.isLandScapeMode(C5008i.m12937VU().getCameraMode())) {
            setDrawable(R.drawable.xiaoying_cam_focusing_ae_locked_lan);
        } else {
            setDrawable(R.drawable.xiaoying_cam_focusing_ae_locked);
        }
        startAnimation(this.bZm);
    }

    /* renamed from: YC */
    public void mo26230YC() {
        if (!m14105YE()) {
            setDrawable(R.drawable.xiaoying_cam_focus_success);
        } else if (CameraCodeMgr.isLandScapeMode(C5008i.m12937VU().getCameraMode())) {
            setDrawable(R.drawable.xiaoying_cam_focus_success_ae_locked_lan);
        } else {
            setDrawable(R.drawable.xiaoying_cam_focus_success_ae_locked);
        }
    }

    /* renamed from: YD */
    public void mo26231YD() {
        if (!m14105YE()) {
            setDrawable(R.drawable.xiaoying_cam_focus_failed);
        } else if (CameraCodeMgr.isLandScapeMode(C5008i.m12937VU().getCameraMode())) {
            setDrawable(R.drawable.xiaoying_cam_focus_failed_ae_locked_lan);
        } else {
            setDrawable(R.drawable.xiaoying_cam_focus_failed_ae_locked);
        }
    }
}
