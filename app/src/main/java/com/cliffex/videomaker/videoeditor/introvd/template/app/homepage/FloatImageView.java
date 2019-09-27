package com.introvd.template.app.homepage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.R;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4583d;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

public class FloatImageView extends RelativeLayout {
    private ImageView bkq;
    private DynamicLoadingImageView bqH;
    /* access modifiers changed from: private */
    public C3921a bqI;

    /* renamed from: com.introvd.template.app.homepage.FloatImageView$a */
    public interface C3921a {
        /* renamed from: Kr */
        void mo23293Kr();

        /* renamed from: Ks */
        void mo23294Ks();
    }

    public FloatImageView(Context context) {
        super(context);
        m9627Ll();
    }

    public FloatImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9627Ll();
    }

    public FloatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9627Ll();
    }

    /* renamed from: Ll */
    private void m9627Ll() {
        this.bqH = new DynamicLoadingImageView(getContext());
        int O = C4583d.m11670O(getContext(), 100);
        addView(this.bqH, new LayoutParams(O, O));
        this.bkq = new ImageView(getContext());
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(11);
        addView(this.bkq, layoutParams);
        this.bkq.setImageResource(R.drawable.vavavideo_float_view_close_btn_selector);
        this.bkq.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (FloatImageView.this.bqI != null) {
                    FloatImageView.this.bqI.mo23293Kr();
                }
            }
        });
        this.bqH.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (FloatImageView.this.bqI != null) {
                    FloatImageView.this.bqI.mo23294Ks();
                }
            }
        });
    }

    public void setImageUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            ImageLoader.loadImage(str, this.bqH);
        }
    }

    public void setOnViewClickListener(C3921a aVar) {
        this.bqI = aVar;
    }
}
