package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.introvd.template.camera.p208a.C4662a;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.BackDeleteTextButton */
public class BackDeleteTextButton extends RelativeLayout {
    /* access modifiers changed from: private */
    public boolean bQF = false;
    private Button bWO;
    /* access modifiers changed from: private */
    public C4662a bWx;
    private int brU = 0;
    private Context mContext;

    public BackDeleteTextButton(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public BackDeleteTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public BackDeleteTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        this.brU = getContext().getResources().getColor(R.color.color_ff2040);
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_back_delete_text_button, this, true);
        this.bWO = (Button) findViewById(R.id.xiaoying_cam_btn_text_delete);
        this.bWO.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!C4580b.m11632Sf() && BackDeleteTextButton.this.bWx != null) {
                    BackDeleteTextButton.this.bWx.mo24976cr(BackDeleteTextButton.this.bQF);
                }
            }
        });
        setDeleteEnable(false);
    }

    /* renamed from: XT */
    public void mo26124XT() {
        this.bWO.setTextColor(-1);
    }

    public void setDeleteEnable(boolean z) {
        if (isEnabled()) {
            this.bQF = z;
            if (z) {
                this.bWO.setTextColor(this.brU);
            } else {
                this.bWO.setTextColor(-1);
            }
            C5008i.m12937VU().setDeleteEnable(z);
        }
    }

    public void setDeleteSwitchClickListener(C4662a aVar) {
        this.bWx = aVar;
    }

    public void setEnabled(boolean z) {
        if (!z) {
            this.bWO.setTextColor(-1);
        } else {
            this.bWO.setTextColor(this.brU);
        }
        this.bWO.setEnabled(z);
        super.setEnabled(z);
    }
}
