package com.introvd.template.editor.slideshow.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.model.SlideNodeModel;
import com.introvd.template.editor.slideshow.p278a.C6739b;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.xyui.RoundCornerImageView;
import java.util.Locale;

public class SlideNodeItemView extends RelativeLayout {
    RelativeLayout cRJ;
    RelativeLayout ddY;
    ImageButton dfH;
    ImageButton dfI;
    RoundCornerImageView dfJ;
    RelativeLayout dfK;
    LinearLayout dfL;
    TextView dfM;
    ImageView dfN;
    private SlideNodeModel dfO;

    public SlideNodeItemView(Context context) {
        this(context, null);
    }

    public SlideNodeItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideNodeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_slide_scene_item_view_layout, this, true);
        this.cRJ = (RelativeLayout) findViewById(R.id.content_layout);
        this.ddY = (RelativeLayout) findViewById(R.id.focus_layout);
        this.dfK = (RelativeLayout) findViewById(R.id.edit_layout);
        this.dfH = (ImageButton) findViewById(R.id.btn_text_edit);
        this.dfI = (ImageButton) findViewById(R.id.btn_insert);
        this.dfJ = (RoundCornerImageView) findViewById(R.id.iv_cover);
        this.dfL = (LinearLayout) findViewById(R.id.detail_layout);
        this.dfM = (TextView) findViewById(R.id.tv_duration_limit);
        this.dfN = (ImageView) findViewById(R.id.focus_mask);
    }

    /* renamed from: b */
    public void mo30236b(SlideNodeModel slideNodeModel) {
        this.dfO = slideNodeModel;
        mo30238gZ(slideNodeModel.isFocus());
        if (slideNodeModel.containTextAnimation()) {
            this.dfH.setVisibility(0);
            C6739b.m19577fq(getContext());
        } else {
            this.dfH.setVisibility(4);
        }
        if (slideNodeModel.isHasSetSource()) {
            this.dfL.setVisibility(8);
            if (slideNodeModel.getThumbnail() == null || slideNodeModel.getThumbnail().isRecycled()) {
                this.dfJ.setImageResource(R.drawable.xiaoying_com_default_pic_bg);
            } else {
                this.dfJ.setImageBitmap(slideNodeModel.getThumbnail());
            }
        } else {
            this.dfL.setVisibility(0);
            this.dfJ.setImageResource(R.drawable.editor_slide_scene_cover_default);
        }
        if (slideNodeModel.getDurationLimit() > 0) {
            this.dfM.setVisibility(0);
            this.dfM.setText(String.format(Locale.US, "%.1f%s", new Object[]{Float.valueOf(((float) slideNodeModel.getDurationLimit()) / 1000.0f), "s"}));
            return;
        }
        this.dfM.setVisibility(8);
    }

    /* renamed from: g */
    public void mo30237g(TrimedClipItemDataModel trimedClipItemDataModel) {
        this.dfO.setDataModel(trimedClipItemDataModel);
        if (this.dfO.isHasSetSource()) {
            if (this.dfO.getThumbnail() == null || this.dfO.getThumbnail().isRecycled()) {
                this.dfJ.setImageResource(R.drawable.xiaoying_com_default_pic_bg);
            } else {
                this.dfJ.setImageBitmap(this.dfO.getThumbnail());
            }
        }
        mo30238gZ(this.dfO.isFocus());
    }

    /* renamed from: gZ */
    public void mo30238gZ(boolean z) {
        this.dfO.setFocus(z);
        int i = 8;
        if (z) {
            this.ddY.setVisibility(0);
            if (this.dfO.isHasSetSource()) {
                this.dfL.setVisibility(8);
                this.dfK.setVisibility(0);
                return;
            }
            this.dfL.setVisibility(0);
            this.dfK.setVisibility(8);
            return;
        }
        this.ddY.setVisibility(8);
        LinearLayout linearLayout = this.dfL;
        if (!this.dfO.isHasSetSource()) {
            i = 0;
        }
        linearLayout.setVisibility(i);
    }

    public ViewGroup getContentLayout() {
        return this.cRJ;
    }

    public ImageButton getTextEditBtn() {
        return this.dfH;
    }
}
