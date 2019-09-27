package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.camera.p208a.C4662a;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.p414ui.view.RotateImageView;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.BackDeleteButton */
public class BackDeleteButton extends RelativeLayout {
    /* access modifiers changed from: private */
    public boolean bQF = false;
    private RotateImageView bWv;
    private TextView bWw;
    /* access modifiers changed from: private */
    public C4662a bWx;
    private boolean bWy = true;
    private int brU = 0;
    private Context mContext;

    /* renamed from: po */
    private OnClickListener f3437po = new OnClickListener() {
        public void onClick(View view) {
            if (BackDeleteButton.this.bWx != null) {
                BackDeleteButton.this.bWx.mo24976cr(BackDeleteButton.this.bQF);
            }
            BackDeleteButton.this.bQF = !BackDeleteButton.this.bQF;
            BackDeleteButton.this.setDeleteEnable(BackDeleteButton.this.bQF);
        }
    };

    public BackDeleteButton(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public BackDeleteButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RotateView);
        this.bWy = obtainStyledAttributes.getBoolean(R.styleable.RotateView_isPortrait, true);
        obtainStyledAttributes.recycle();
        initUI();
    }

    public BackDeleteButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RotateView);
        this.bWy = obtainStyledAttributes.getBoolean(R.styleable.RotateView_isPortrait, true);
        obtainStyledAttributes.recycle();
        initUI();
    }

    private void initUI() {
        this.brU = getContext().getResources().getColor(R.color.color_dd2c00);
        if (this.bWy) {
            LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_delete_switch, this, true);
            this.bWv = (RotateImageView) findViewById(R.id.item_img);
            this.bWv.setDegree(0);
            this.bWv.setOnClickListener(this.f3437po);
        } else {
            LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_delete_switch_lan, this, true);
            this.bWw = (TextView) findViewById(R.id.item_img);
            this.bWw.setOnClickListener(this.f3437po);
        }
        setDeleteEnable(false);
    }

    /* renamed from: XT */
    public void mo26105XT() {
        if (this.bWy) {
            this.bWv.setImageResource(R.drawable.v4_xiaoying_cam_btn_back_delete_selector);
        } else {
            this.bWw.setTextColor(-1);
        }
    }

    public void setDeleteEnable(boolean z) {
        if (isEnabled()) {
            this.bQF = z;
            if (this.bWy) {
                if (z) {
                    this.bWv.setImageResource(R.drawable.v4_xiaoying_cam_btn_back_delete_enable_selector);
                } else {
                    this.bWv.setImageResource(R.drawable.v4_xiaoying_cam_btn_back_delete_selector);
                }
                C5008i.m12937VU().setDeleteEnable(z);
            } else {
                if (z) {
                    this.bWw.setTextColor(this.brU);
                } else {
                    this.bWw.setTextColor(-1);
                }
                C5008i.m12937VU().setDeleteEnable(z);
            }
        }
    }

    public void setDeleteSwitchClickListener(C4662a aVar) {
        this.bWx = aVar;
    }

    public void setEnabled(boolean z) {
        if (this.bWy) {
            if (!z) {
                this.bWv.setImageResource(R.drawable.v4_xiaoying_cam_btn_back_delete_selector);
            }
            this.bWv.setEnabled(z);
        } else {
            if (!z) {
                this.bWw.setTextColor(-1);
            } else {
                this.bWw.setTextColor(this.brU);
            }
            this.bWw.setEnabled(z);
        }
        super.setEnabled(z);
    }
}
