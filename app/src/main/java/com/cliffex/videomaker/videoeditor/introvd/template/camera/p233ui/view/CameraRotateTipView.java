package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.vivacamera.R;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p133a.C2564c.C2569a;

/* renamed from: com.introvd.template.camera.ui.view.CameraRotateTipView */
public class CameraRotateTipView extends LinearLayout {
    private Context mContext;

    public CameraRotateTipView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CameraRotateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public CameraRotateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_record_rotate_tip, this, true).findViewById(R.id.record_rotate_tip_layout_ok).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                AppPreferencesSetting.getInstance().setAppSettingBoolean("key_pref_rotate_tip_show", true);
                CameraRotateTipView.this.dismiss();
            }
        });
    }

    public void dismiss() {
        if (isShown()) {
            C2564c.m7325b(this, new C2569a() {
                public void onFinish() {
                    CameraRotateTipView.this.setVisibility(8);
                }
            });
        }
    }

    public void show() {
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("key_pref_rotate_tip_show", false);
        if (!isShown() && !appSettingBoolean) {
            setVisibility(0);
            C2564c.m7328dB(this);
        }
    }
}
