package com.introvd.template.picker.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.picker.R;
import com.introvd.template.picker.adapter.C8173a;

public class PickerFolderFooterView extends RelativeLayout {
    private LinearLayout bpS;
    private int dXV;
    private TextView dZm;

    public PickerFolderFooterView(Context context, int i) {
        this(context, (AttributeSet) null);
        this.dXV = i;
    }

    public PickerFolderFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PickerFolderFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dXV = 1;
        init();
    }

    private void init() {
        this.bpS = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.picker_folder_footer_layout, this, true).findViewById(R.id.picker_folder_footer_layout);
        this.dZm = (TextView) findViewById(R.id.footer_scan_text);
        LayoutParams layoutParams = this.bpS.getLayoutParams();
        layoutParams.width = (Constants.getScreenSize().width - (C8173a.dXS * 4)) / C8173a.dXT;
        layoutParams.height = (Constants.getScreenSize().width - (C8173a.dXS * 4)) / C8173a.dXT;
        this.bpS.setLayoutParams(layoutParams);
        if (this.dXV == 1) {
            this.dZm.setText(R.string.xiaoying_str_ve_gallery_not_find_video_tip);
        } else {
            this.dZm.setText(R.string.xiaoying_str_ve_gallery_not_find_photo_tip);
        }
    }
}
