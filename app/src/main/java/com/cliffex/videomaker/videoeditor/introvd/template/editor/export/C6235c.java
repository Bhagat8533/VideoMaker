package com.introvd.template.editor.export;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.editor.R;
import com.p131c.p132a.C2561a;

/* renamed from: com.introvd.template.editor.export.c */
public class C6235c extends Dialog implements OnClickListener {
    private TextView cOA;
    private boolean cOB;
    private C6236a cOC;
    private View cOt;
    private RelativeLayout cOu;
    private RelativeLayout cOv;
    private RelativeLayout cOw;
    private RelativeLayout cOx;
    private TextView cOy;
    private TextView cOz;

    /* renamed from: com.introvd.template.editor.export.c$a */
    public interface C6236a {
        /* renamed from: R */
        void mo29087R(int i, boolean z);
    }

    public C6235c(Context context, boolean z, boolean[] zArr, boolean z2, boolean z3, boolean z4) {
        super(context, R.style.xiaoying_style_com_dialog);
        setCancelable(true);
        if (zArr == null || zArr.length != 7) {
            throw new IllegalArgumentException("the config of show must be 7");
        }
        this.cOB = z2;
        this.cOt = LayoutInflater.from(context).inflate(R.layout.editor_export_hd_dialog_layout, null);
        this.cOy = (TextView) this.cOt.findViewById(R.id.normal_layout);
        this.cOu = (RelativeLayout) this.cOt.findViewById(R.id.hd_layout);
        this.cOv = (RelativeLayout) this.cOt.findViewById(R.id.hd_1080_layout);
        this.cOz = (TextView) this.cOt.findViewById(R.id.extra_layout);
        this.cOA = (TextView) this.cOt.findViewById(R.id.gif_layout);
        this.cOw = (RelativeLayout) this.cOt.findViewById(R.id.hd_2k_layout);
        this.cOx = (RelativeLayout) this.cOt.findViewById(R.id.hd_4k_layout);
        ImageView imageView = (ImageView) this.cOt.findViewById(R.id.purchase_hd_1080_lock);
        ImageView imageView2 = (ImageView) this.cOt.findViewById(R.id.purchase_hd_2k_lock);
        ImageView imageView3 = (ImageView) this.cOt.findViewById(R.id.purchase_hd_4k_lock);
        ((ImageView) this.cOt.findViewById(R.id.purchase_hd_lock)).setImageResource(z3 ? R.drawable.xiaoying_publish_video_export_lock_icon : R.drawable.iap_vip_icon_user_vip_flag_enable);
        imageView.setImageResource(z4 ? R.drawable.xiaoying_publish_video_export_lock_icon : R.drawable.iap_vip_icon_user_vip_flag_enable);
        imageView2.setImageResource(z3 ? R.drawable.xiaoying_publish_video_export_lock_icon : R.drawable.iap_vip_icon_user_vip_flag_enable);
        imageView3.setImageResource(z3 ? R.drawable.xiaoying_publish_video_export_lock_icon : R.drawable.iap_vip_icon_user_vip_flag_enable);
        TextView textView = (TextView) this.cOt.findViewById(R.id.purchase_hd_desc);
        TextView textView2 = (TextView) this.cOt.findViewById(R.id.purchase_hd_1080_desc);
        TextView textView3 = (TextView) this.cOt.findViewById(R.id.purchase_hd_4k_desc);
        TextView textView4 = (TextView) this.cOt.findViewById(R.id.purchase_hd_2k_desc);
        if (!z) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            textView4.setVisibility(8);
        }
        m17886b(zArr);
        this.cOy.setOnClickListener(this);
    }

    /* renamed from: b */
    private void m17886b(boolean[] zArr) {
        for (int i = 1; i < zArr.length; i++) {
            if (i == 1) {
                if (!zArr[i]) {
                    this.cOu.setOnClickListener(this);
                } else {
                    this.cOu.setOnClickListener(this);
                }
            } else if (i == 2) {
                if (!zArr[i]) {
                    this.cOv.setOnClickListener(this);
                } else {
                    this.cOv.setOnClickListener(this);
                }
            } else if (i == 3) {
                if (!zArr[i]) {
                    this.cOz.setOnClickListener(this);
                } else {
                    this.cOz.setOnClickListener(this);
                }
            } else if (i == 4) {
                if (!zArr[i]) {
                    this.cOA.setOnClickListener(this);
                } else {
                    this.cOA.setOnClickListener(this);
                }
            } else if (i == 5) {
                if (!zArr[i]) {
                    this.cOw.setOnClickListener(this);
                } else {
                    this.cOw.setOnClickListener(this);
                }
            } else if (i == 6) {
                if (!zArr[i]) {
                    this.cOx.setOnClickListener(this);
                } else {
                    this.cOx.setOnClickListener(this);
                }
            }
        }
        if (!C3742b.m9111II().mo23148JP()) {
            this.cOw.setVisibility(8);
            this.cOx.setVisibility(8);
        }
        if (C2561a.aON()) {
            this.cOw.setVisibility(8);
            this.cOx.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void mo29136a(C6236a aVar) {
        this.cOC = aVar;
    }

    public void onClick(View view) {
        dismiss();
        if (view.equals(this.cOu)) {
            if (this.cOC != null) {
                this.cOC.mo29087R(1, this.cOB);
            }
        } else if (view.equals(this.cOv)) {
            if (this.cOC != null) {
                this.cOC.mo29087R(2, this.cOB);
            }
        } else if (view.equals(this.cOy)) {
            if (this.cOC != null) {
                this.cOC.mo29087R(0, this.cOB);
            }
        } else if (view.equals(this.cOz)) {
            if (this.cOC != null) {
                this.cOC.mo29087R(3, this.cOB);
            }
        } else if (view.equals(this.cOA)) {
            if (this.cOC != null) {
                this.cOC.mo29087R(4, this.cOB);
            }
        } else if (view.equals(this.cOw)) {
            if (this.cOC != null) {
                this.cOC.mo29087R(5, this.cOB);
            }
        } else if (view.equals(this.cOx) && this.cOC != null) {
            this.cOC.mo29087R(6, this.cOB);
        }
    }

    public void show() {
        if (this.cOt != null) {
            setContentView(this.cOt);
        }
        super.show();
    }
}
