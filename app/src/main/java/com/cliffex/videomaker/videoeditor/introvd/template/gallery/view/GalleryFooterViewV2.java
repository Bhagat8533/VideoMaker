package com.introvd.template.gallery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.xygallery.R;

public class GalleryFooterViewV2 extends RelativeLayout {
    private TextView dJH;
    private RelativeLayout dJI;
    /* access modifiers changed from: private */
    public C7491a dJJ;
    private Context mContext;

    /* renamed from: com.introvd.template.gallery.view.GalleryFooterViewV2$a */
    public interface C7491a {
        void azj();
    }

    public GalleryFooterViewV2(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public GalleryFooterViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(R.layout.gallery_include_foot_view, this, true);
        this.dJI = (RelativeLayout) findViewById(R.id.gallery_footer_layout);
        this.dJH = (TextView) findViewById(R.id.gallery_footer_scan_text);
        this.dJI.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (GalleryFooterViewV2.this.dJJ != null) {
                    GalleryFooterViewV2.this.dJJ.azj();
                }
            }
        });
        LayoutParams layoutParams = this.dJI.getLayoutParams();
        layoutParams.width = (Constants.getScreenSize().width - (C4583d.m11670O(this.mContext, 15) * 3)) / 2;
        layoutParams.height = (Constants.getScreenSize().width - (C4583d.m11670O(this.mContext, 15) * 3)) / 2;
        this.dJI.setLayoutParams(layoutParams);
    }

    public void setButtonText(int i) {
        if (this.dJH != null) {
            this.dJH.setText(i);
        }
    }

    public void setOnFooterClickListener(C7491a aVar) {
        this.dJJ = aVar;
    }
}
