package com.introvd.template.editor.effects.customwatermark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;

public class CustomWaterMarkQuickPositionView extends RelativeLayout {
    /* access modifiers changed from: private */
    public C6095g cKg;
    /* access modifiers changed from: private */
    public View cKh;
    /* access modifiers changed from: private */
    public View cKi;
    /* access modifiers changed from: private */
    public View cKj;
    /* access modifiers changed from: private */
    public View cKk;
    /* access modifiers changed from: private */
    public View cKl;
    /* access modifiers changed from: private */
    public View cKm;
    /* access modifiers changed from: private */
    public View cKn;
    /* access modifiers changed from: private */
    public View cKo;
    /* access modifiers changed from: private */
    public View cKp;

    /* renamed from: po */
    private OnClickListener f3498po;

    public CustomWaterMarkQuickPositionView(Context context) {
        this(context, null);
    }

    public CustomWaterMarkQuickPositionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomWaterMarkQuickPositionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3498po = new OnClickListener() {
            public void onClick(View view) {
                String str = "";
                int i = 0;
                if (view.equals(CustomWaterMarkQuickPositionView.this.cKh)) {
                    i = 3;
                    str = "左上";
                } else if (view.equals(CustomWaterMarkQuickPositionView.this.cKi)) {
                    i = 7;
                    str = "上";
                } else if (view.equals(CustomWaterMarkQuickPositionView.this.cKj)) {
                    i = 4;
                    str = "右上";
                } else if (view.equals(CustomWaterMarkQuickPositionView.this.cKk)) {
                    i = 1;
                    str = "左";
                } else if (view.equals(CustomWaterMarkQuickPositionView.this.cKl)) {
                    str = "中";
                } else if (view.equals(CustomWaterMarkQuickPositionView.this.cKm)) {
                    i = 2;
                    str = "右";
                } else if (view.equals(CustomWaterMarkQuickPositionView.this.cKn)) {
                    i = 5;
                    str = "左下";
                } else if (view.equals(CustomWaterMarkQuickPositionView.this.cKo)) {
                    i = 8;
                    str = "下";
                } else if (view.equals(CustomWaterMarkQuickPositionView.this.cKp)) {
                    i = 6;
                    str = "右下";
                }
                if (CustomWaterMarkQuickPositionView.this.cKg != null) {
                    CustomWaterMarkQuickPositionView.this.cKg.mo28815m(i, str);
                }
            }
        };
        m17335Oj();
    }

    /* renamed from: Oj */
    private void m17335Oj() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.editor_effect_watermark_quick_position, this, true);
        this.cKh = inflate.findViewById(R.id.position_0);
        this.cKh.setOnClickListener(this.f3498po);
        this.cKi = inflate.findViewById(R.id.position_1);
        this.cKi.setOnClickListener(this.f3498po);
        this.cKj = inflate.findViewById(R.id.position_2);
        this.cKj.setOnClickListener(this.f3498po);
        this.cKk = inflate.findViewById(R.id.position_3);
        this.cKk.setOnClickListener(this.f3498po);
        this.cKl = inflate.findViewById(R.id.position_4);
        this.cKl.setOnClickListener(this.f3498po);
        this.cKm = inflate.findViewById(R.id.position_5);
        this.cKm.setOnClickListener(this.f3498po);
        this.cKn = inflate.findViewById(R.id.position_6);
        this.cKn.setOnClickListener(this.f3498po);
        this.cKo = inflate.findViewById(R.id.position_7);
        this.cKo.setOnClickListener(this.f3498po);
        this.cKp = inflate.findViewById(R.id.position_8);
        this.cKp.setOnClickListener(this.f3498po);
    }

    public void setWaterMarkQuickPositionListener(C6095g gVar) {
        this.cKg = gVar;
    }
}
