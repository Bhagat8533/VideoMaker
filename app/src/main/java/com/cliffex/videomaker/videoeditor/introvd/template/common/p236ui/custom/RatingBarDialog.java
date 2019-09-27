package com.introvd.template.common.p236ui.custom;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.R;

/* renamed from: com.introvd.template.common.ui.custom.RatingBarDialog */
public class RatingBarDialog extends Dialog implements OnClickListener {
    private TextView bCG;
    private TextView cgS;
    private ImageView cgT;
    private TextView cgU;
    private RatingBarView cgV;
    private OnAlertDialogClickListener cgW;

    /* renamed from: com.introvd.template.common.ui.custom.RatingBarDialog$OnAlertDialogClickListener */
    public interface OnAlertDialogClickListener {
        void buttonClick(int i, float f);
    }

    public RatingBarDialog(Context context, OnAlertDialogClickListener onAlertDialogClickListener) {
        super(context, R.style.xiaoying_style_com_dialog);
        this.cgW = onAlertDialogClickListener;
        View inflate = LayoutInflater.from(context).inflate(R.layout.app_dialog_ratingbar, null);
        setContentView(inflate);
        this.bCG = (TextView) inflate.findViewById(R.id.rating_dialog_title);
        this.cgS = (TextView) inflate.findViewById(R.id.rating_dialog_content);
        this.cgT = (ImageView) inflate.findViewById(R.id.btn_cancel);
        this.cgU = (TextView) inflate.findViewById(R.id.rating_dialog_positive);
        this.cgV = (RatingBarView) inflate.findViewById(R.id.ratingbarview);
        this.cgT.setOnClickListener(this);
        this.cgU.setOnClickListener(this);
        this.cgV.setOnStarChangedListener(new C5329a(this));
        this.cgU.setEnabled(this.cgV.getRating() > 0.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ void m14484Z(float f) {
        this.cgU.setEnabled(f > 0.0f);
    }

    public void onClick(View view) {
        if (view == this.cgT) {
            if (!(this.cgW == null || this.cgV == null)) {
                this.cgW.buttonClick(0, this.cgV.getRating());
            }
        } else if (!(view != this.cgU || this.cgW == null || this.cgV == null)) {
            this.cgW.buttonClick(1, this.cgV.getRating());
        }
        dismiss();
    }

    public void setDialogContent(String str) {
        if (this.cgS != null) {
            this.cgS.setText(str);
        }
    }

    public void setDialogTitle(String str) {
        if (this.bCG != null) {
            this.bCG.setText(str);
        }
    }
}
