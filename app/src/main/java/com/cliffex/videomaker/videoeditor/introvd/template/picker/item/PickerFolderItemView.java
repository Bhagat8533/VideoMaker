package com.introvd.template.picker.item;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.imageloader.ImageLoader.SourceType;
import com.introvd.template.picker.R;
import com.introvd.template.picker.adapter.C8173a;
import com.introvd.template.picker.p367c.C8192a;

public class PickerFolderItemView extends RelativeLayout {
    private ImageView bAU;
    private RelativeLayout dZn;
    private ImageView dZo;
    private TextView dZp;
    private TextView dZq;

    public PickerFolderItemView(Context context) {
        this(context, null);
    }

    public PickerFolderItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PickerFolderItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.picker_folder_item_layout, this, true);
        this.dZn = (RelativeLayout) inflate.findViewById(R.id.layout_album_cover);
        this.dZo = (ImageView) inflate.findViewById(R.id.iv_album_cover);
        this.bAU = (ImageView) inflate.findViewById(R.id.iv_new_flag);
        this.dZp = (TextView) inflate.findViewById(R.id.picker_album_title);
        this.dZq = (TextView) inflate.findViewById(R.id.picker_album_item_num);
        LayoutParams layoutParams = this.dZn.getLayoutParams();
        layoutParams.width = (Constants.getScreenSize().width - (C8173a.dXS * 4)) / C8173a.dXT;
        layoutParams.height = (Constants.getScreenSize().width - (C8173a.dXS * 4)) / C8173a.dXT;
        this.dZn.setLayoutParams(layoutParams);
    }

    /* renamed from: c */
    public void mo33379c(C8192a aVar) {
        ImageLoader.loadImage(getContext(), aVar.aFG() ? R.drawable.xiaoying_com_default_video_bg : R.drawable.xiaoying_com_default_pic_bg, aVar.aFD(), this.dZo, SourceType.UNKNOWN);
        if (aVar.aFF() > 0) {
            this.bAU.setVisibility(0);
        } else {
            this.bAU.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.getTitle())) {
            this.dZp.setText(aVar.getTitle());
        }
        this.dZq.setText(String.valueOf(aVar.getChildCount()));
    }

    public void setNewFlag(boolean z) {
        if (z) {
            this.bAU.setVisibility(0);
        } else {
            this.bAU.setVisibility(8);
        }
    }
}
