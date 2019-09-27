package com.introvd.template.editor.preview.clipsort;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.preview.adapter.C6548e;
import com.introvd.template.editor.preview.model.ClipItemInfo;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.xyui.RoundCornerImageView;

public class ClipSortItemView extends RelativeLayout {
    RoundCornerImageView daH;
    TextView daI;
    TextView daJ;
    ImageView daK;

    public ClipSortItemView(Context context) {
        this(context, null);
    }

    public ClipSortItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipSortItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19017Oj();
    }

    /* renamed from: Oj */
    private void m19017Oj() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.editor_clip_sort_item_layout, this, true);
        this.daH = (RoundCornerImageView) inflate.findViewById(R.id.item_cover);
        this.daI = (TextView) inflate.findViewById(R.id.item_duration);
        this.daK = (ImageView) findViewById(R.id.iv_item_mask);
        this.daJ = (TextView) inflate.findViewById(R.id.item_order);
    }

    /* renamed from: a */
    public void mo29872a(int i, ClipItemInfo clipItemInfo, C6548e eVar) {
        if (clipItemInfo.bmpThumbnail != null && !clipItemInfo.bmpThumbnail.isRecycled()) {
            this.daH.setImageBitmap(clipItemInfo.bmpThumbnail);
        } else if (eVar != null) {
            eVar.mo29861d(this.daH, i);
        }
        this.daK.setVisibility(clipItemInfo.isImage ? 0 : 8);
        this.daI.setText(C4580b.m11637V((long) ((int) clipItemInfo.lDuration)));
    }

    /* renamed from: o */
    public void mo29873o(boolean z, int i) {
        this.daJ.setText(String.valueOf(i));
        this.daJ.setVisibility(z ? 0 : 8);
    }
}
