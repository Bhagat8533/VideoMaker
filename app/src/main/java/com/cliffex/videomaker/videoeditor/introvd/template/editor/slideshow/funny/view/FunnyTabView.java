package com.introvd.template.editor.slideshow.funny.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;

public class FunnyTabView extends LinearLayout {
    TextView dhx;
    ImageView dhy;

    public FunnyTabView(Context context) {
        this(context, null);
    }

    public FunnyTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunnyTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_funny_category_item_tab_layout, this, true);
        this.dhx = (TextView) findViewById(R.id.tab_title);
        this.dhy = (ImageView) findViewById(R.id.tab_icon);
        this.dhy.setAlpha(0.3f);
    }

    /* renamed from: aq */
    public void mo30402aq(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.dhx.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            ImageLoader.loadImage(getContext(), str2, this.dhy);
        }
    }

    public void setSelect(boolean z) {
        this.dhx.getPaint().setFakeBoldText(z);
        this.dhy.setAlpha(z ? 1.0f : 0.3f);
    }
}
