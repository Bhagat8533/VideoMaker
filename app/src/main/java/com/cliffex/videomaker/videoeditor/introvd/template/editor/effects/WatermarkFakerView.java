package com.introvd.template.editor.effects;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.customwatermark.CustomWaterMarkView;
import com.introvd.template.editor.effects.customwatermark.CustomWaterMarkView.C6087a;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;

public class WatermarkFakerView extends RelativeLayout {
    private CustomWaterMarkView cGQ;
    private RelativeLayout cGz;

    public WatermarkFakerView(Context context) {
        super(context);
    }

    public WatermarkFakerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WatermarkFakerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void aiQ() {
        this.cGQ = new CustomWaterMarkView(getContext());
        this.cGQ.setLayoutParams(new LayoutParams(-1, -1));
        this.cGz.addView(this.cGQ);
    }

    /* renamed from: d */
    public void mo28447d(MSize mSize) {
        if (mSize != null) {
            LayoutInflater.from(getContext()).inflate(R.layout.editor_view_simple_fakerview, this, true);
            this.cGz = (RelativeLayout) findViewById(R.id.editor_fake_layout);
            LayoutParams layoutParams = new LayoutParams(mSize.width, mSize.height);
            layoutParams.addRule(13, 1);
            this.cGz.setLayoutParams(layoutParams);
            this.cGz.invalidate();
            aiQ();
        }
    }

    /* renamed from: e */
    public void mo28448e(MSize mSize) {
        if (this.cGz != null) {
            LayoutParams layoutParams = new LayoutParams(mSize.width, mSize.height);
            layoutParams.addRule(13, 1);
            this.cGz.setLayoutParams(layoutParams);
            this.cGz.invalidate();
        }
    }

    /* renamed from: e */
    public void mo28449e(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState != null && this.cGQ != null && !TextUtils.isEmpty(scaleRotateViewState.mStylePath)) {
            this.cGQ.mo28825l(scaleRotateViewState);
            this.cGQ.setVisibility(0);
        }
    }

    public void setCustomWaterMarkViewListener(C6087a aVar) {
        if (this.cGQ != null) {
            this.cGQ.setCustomWaterMarkViewListener(aVar);
        }
    }
}
