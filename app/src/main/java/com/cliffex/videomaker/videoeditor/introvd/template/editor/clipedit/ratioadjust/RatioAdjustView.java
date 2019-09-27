package com.introvd.template.editor.clipedit.ratioadjust;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;

public class RatioAdjustView extends RelativeLayout {
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(RatioAdjustView.this.cBm) && RatioAdjustView.this.cAS != null) {
                RatioAdjustView.this.cAS.mo27968b(RatioAdjustView.this, RatioAdjustView.this.cvt);
            }
        }
    };
    /* access modifiers changed from: private */
    public C5730a cAS;
    private ImageView cBk;
    private TextView cBl;
    /* access modifiers changed from: private */
    public RelativeLayout cBm;
    /* access modifiers changed from: private */
    public float cvt;
    private Context mContext;

    /* renamed from: com.introvd.template.editor.clipedit.ratioadjust.RatioAdjustView$a */
    public interface C5730a {
        /* renamed from: b */
        void mo27968b(RatioAdjustView ratioAdjustView, float f);
    }

    public RatioAdjustView(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public RatioAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public RatioAdjustView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.editor_clip_ratio_view_layout, this, true);
        this.cBk = (ImageView) findViewById(R.id.ratio_icon);
        this.cBl = (TextView) findViewById(R.id.ratio_title);
        this.cBm = (RelativeLayout) findViewById(R.id.ratio_main_layout);
        this.cBm.setOnClickListener(this.acD);
    }

    /* renamed from: a */
    public void mo27963a(int i, String str, float f) {
        if (this.cBk != null) {
            this.cBk.setImageResource(i);
        }
        if (this.cBl != null) {
            this.cBl.setText(str);
        }
        this.cvt = f;
    }

    public void clearFocus() {
        if (this.cBk != null) {
            this.cBk.setAlpha(0.5f);
        }
        if (this.cBl != null) {
            this.cBl.setAlpha(0.5f);
        }
    }

    public void setFocus() {
        if (this.cBk != null) {
            this.cBk.setAlpha(1.0f);
        }
        if (this.cBl != null) {
            this.cBl.setAlpha(1.0f);
        }
    }

    public void setOnClipRatioViewClickListener(C5730a aVar) {
        this.cAS = aVar;
    }
}
