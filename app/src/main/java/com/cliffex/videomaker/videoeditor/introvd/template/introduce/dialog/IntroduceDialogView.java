package com.introvd.template.introduce.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

public class IntroduceDialogView extends RelativeLayout {
    TextView bkw;
    DynamicLoadingImageView dLu;
    TextView titleView;

    public IntroduceDialogView(Context context) {
        this(context, null);
    }

    public IntroduceDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IntroduceDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.xyui_introduce_item_layout, this, true);
        this.dLu = (DynamicLoadingImageView) findViewById(R.id.imgLogo);
        this.titleView = (TextView) findViewById(R.id.textTitle);
        this.bkw = (TextView) findViewById(R.id.textContent);
    }

    /* renamed from: a */
    public void mo32309a(C7529b bVar) {
        if (bVar != null) {
            this.dLu.setImage(bVar.azK());
            String title = bVar.getTitle();
            if (!TextUtils.isEmpty(title)) {
                this.titleView.setText(title);
            }
            String desc = bVar.getDesc();
            if (!TextUtils.isEmpty(desc)) {
                this.bkw.setText(desc);
            }
        }
    }

    public TextView getTitleView() {
        return this.titleView;
    }
}
