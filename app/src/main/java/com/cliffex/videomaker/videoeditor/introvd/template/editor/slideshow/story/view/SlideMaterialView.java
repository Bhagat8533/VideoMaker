package com.introvd.template.editor.slideshow.story.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.story.p285a.C6849b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.template.p408f.C8750d;

public class SlideMaterialView extends RelativeLayout {
    ImageView cRH;
    RelativeLayout cRJ;
    ImageButton ddV;
    RelativeLayout diB;
    TextView diC;
    ImageButton diD;
    private TrimedClipItemDataModel diE;
    /* access modifiers changed from: private */
    public C6849b diF;
    /* access modifiers changed from: private */
    public int index;

    public SlideMaterialView(Context context) {
        this(context, null);
    }

    public SlideMaterialView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideMaterialView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void ams() {
        this.diD.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SlideMaterialView.this.diF != null) {
                    SlideMaterialView.this.diF.mo30472pp(SlideMaterialView.this.index);
                }
            }
        });
        this.ddV.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SlideMaterialView.this.diF != null) {
                    SlideMaterialView.this.diF.mo30473pq(SlideMaterialView.this.index);
                }
            }
        });
        this.cRJ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SlideMaterialView.this.diF != null) {
                    SlideMaterialView.this.diF.mo30474pr(SlideMaterialView.this.index);
                }
            }
        });
    }

    private void asq() {
        this.diD.setVisibility(0);
        this.ddV.setVisibility(8);
        this.diB.setVisibility(8);
        this.cRH.setImageResource(0);
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.slideshow_material_item_layout, this, true);
        this.cRJ = (RelativeLayout) inflate.findViewById(R.id.content_layout);
        this.cRH = (ImageView) inflate.findViewById(R.id.material_cover);
        this.diD = (ImageButton) inflate.findViewById(R.id.btn_add);
        this.diB = (RelativeLayout) inflate.findViewById(R.id.layout_video_info);
        this.diC = (TextView) inflate.findViewById(R.id.video_duration);
        this.ddV = (ImageButton) inflate.findViewById(R.id.btn_delete);
        ams();
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setInterCallback(C6849b bVar) {
        this.diF = bVar;
    }

    public void setMaterialData(TrimedClipItemDataModel trimedClipItemDataModel) {
        this.diE = trimedClipItemDataModel;
        if (trimedClipItemDataModel != null) {
            this.diD.setVisibility(8);
            this.ddV.setVisibility(0);
            if (trimedClipItemDataModel.mThumbnail != null && !trimedClipItemDataModel.mThumbnail.isRecycled()) {
                this.cRH.setImageBitmap(trimedClipItemDataModel.mThumbnail);
            }
            boolean jM = C8750d.m25573jM(trimedClipItemDataModel.mRawFilePath);
            if (trimedClipItemDataModel.isImage.booleanValue() || jM) {
                this.diB.setVisibility(8);
                return;
            }
            int i = trimedClipItemDataModel.mVeRangeInRawVideo.getmTimeLength();
            if (trimedClipItemDataModel.mTrimVeRange != null && trimedClipItemDataModel.mTrimVeRange.getmTimeLength() > 0) {
                i = trimedClipItemDataModel.mTrimVeRange.getmTimeLength();
            }
            this.diB.setVisibility(0);
            this.diC.setText(C4580b.m11637V((long) i));
            return;
        }
        asq();
    }
}
