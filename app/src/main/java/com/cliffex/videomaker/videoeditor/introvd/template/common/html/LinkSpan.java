package com.introvd.template.common.html;

import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import xiaoying.quvideo.com.vivabase.C10122R;

public class LinkSpan extends URLSpan {
    private ClickableSpan ceY;

    public LinkSpan(String str) {
        super(str);
    }

    public void onClick(View view) {
        if (this.ceY != null) {
            view.setTag(C10122R.C10124id.tag_link_url, getURL());
            this.ceY.onClick(view);
            return;
        }
        super.onClick(view);
    }

    public void setClickableSpan(ClickableSpan clickableSpan) {
        this.ceY = clickableSpan;
    }
}
