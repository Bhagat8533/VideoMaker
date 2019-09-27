package com.introvd.template.camera.p233ui.p235b;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.b.a */
public class C5058a extends Dialog implements OnClickListener {
    private OnClickListener bDG;
    private ImageButton bUT;
    private ImageButton bUU;
    private ImageButton bUV;
    private ImageButton bUW;
    private Button bUX;

    public C5058a(Context context, OnClickListener onClickListener) {
        super(context, R.style.xiaoying_adjust_camera_dialog);
        this.bDG = onClickListener;
    }

    public void onBackPressed() {
        this.bDG.onClick(null);
    }

    public void onClick(View view) {
        this.bDG.onClick(view);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cam_dialog_adjust);
        this.bUT = (ImageButton) findViewById(R.id.cam_adjust_dialog_btn_rotate_left);
        this.bUU = (ImageButton) findViewById(R.id.cam_adjust_dialog_btn_rotate_right);
        this.bUV = (ImageButton) findViewById(R.id.cam_adjust_dialog_btn_flip_horizontal);
        this.bUW = (ImageButton) findViewById(R.id.cam_adjust_dialog_btn_flip_vertical);
        this.bUX = (Button) findViewById(R.id.cam_adjust_dialog_btn_ok);
        this.bUT.setOnClickListener(this);
        this.bUU.setOnClickListener(this);
        this.bUV.setOnClickListener(this);
        this.bUW.setOnClickListener(this);
        this.bUX.setOnClickListener(this);
        this.bUT.setTag(Integer.valueOf(1));
        this.bUU.setTag(Integer.valueOf(2));
        this.bUV.setTag(Integer.valueOf(3));
        this.bUW.setTag(Integer.valueOf(4));
        this.bUX.setTag(Integer.valueOf(5));
    }
}
