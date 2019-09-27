package com.introvd.template.module.iap.business.vip.p360a;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.vip.a.d */
public class C8018d extends Dialog {
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public String bFV;
    private View bwy;
    /* access modifiers changed from: private */
    public C8022e dUA;
    /* access modifiers changed from: private */
    public boolean dUB;
    private String goodsId;

    public C8018d(Activity activity2, int i) {
        this(activity2, i, null);
    }

    public C8018d(Activity activity2, int i, String str) {
        super(activity2, R.style.vivavideo_iap_dialog_com_style);
        this.dUB = true;
        this.activity = activity2;
        this.goodsId = str;
        this.dUA = m23226sJ(i);
        if (this.dUA != null) {
            this.bwy = LayoutInflater.from(activity2).inflate(R.layout.iap_vip_dialog_function_layout, null);
            aEc();
            alN();
            aEd();
            setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (C8018d.this.dUB) {
                        C7835b.m22848aB(C8018d.this.bFV, "cancel");
                    }
                }
            });
        }
    }

    private void aEc() {
        int aDW = this.dUA.aDW();
        DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) this.bwy.findViewById(R.id.vip_home_dialog_head_bg);
        dynamicLoadingImageView.setAspectRatio(this.dUA.aDX());
        dynamicLoadingImageView.setImage(aDW);
    }

    private void aEd() {
        ((LinearLayout) this.bwy.findViewById(R.id.ll_buttons)).setOrientation(this.dUA.aDZ());
        TextView textView = (TextView) this.bwy.findViewById(R.id.vip_home_dialog_left_button);
        if (this.dUA.mo33026f(textView)) {
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8018d.this.dUB = false;
                    C8018d.this.dUA.mo33022aN(C8018d.this.activity);
                    C8018d.this.dismiss();
                }
            });
        }
        TextView textView2 = (TextView) this.bwy.findViewById(R.id.vip_home_dialog_right_button);
        if (this.dUA.mo33027g(textView2)) {
            textView2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8018d.this.dUB = false;
                    C8018d.this.dUA.mo33023aO(C8018d.this.activity);
                    C8018d.this.dismiss();
                }
            });
        }
    }

    private void alN() {
        TextView textView = (TextView) this.bwy.findViewById(R.id.vip_home_dialog_title);
        this.dUA.mo33024d(textView);
        textView.setText(this.dUA.getTitle());
        TextView textView2 = (TextView) this.bwy.findViewById(R.id.vip_home_dialog_description);
        this.dUA.mo33025e(textView2);
        textView2.setText(this.dUA.getDescription());
        List aDY = this.dUA.aDY();
        ListView listView = (ListView) this.bwy.findViewById(R.id.vip_home_dialog_purchase_list);
        if (aDY == null || aDY.isEmpty()) {
            listView.setVisibility(8);
            return;
        }
        C8023f fVar = new C8023f(getContext(), aDY);
        listView.setAdapter(fVar);
        listView.setVisibility(0);
        fVar.notifyDataSetChanged();
    }

    /* renamed from: sJ */
    private C8022e m23226sJ(int i) {
        if (i == 0) {
            this.bFV = "Restore_Failed_Dialog_Click";
            return new C8015b();
        } else if (i != 2) {
            return null;
        } else {
            this.bFV = "Free_Trial_Cancel_Dialog_Click";
            return new C8016c(this.goodsId);
        }
    }

    public void show() {
        if (!C8048e.aBe().isInChina() && this.dUA != null && this.dUA.aEa() && this.activity != null && !this.activity.isFinishing()) {
            setContentView(this.bwy);
            super.show();
            this.dUA.aEb();
        }
    }
}
