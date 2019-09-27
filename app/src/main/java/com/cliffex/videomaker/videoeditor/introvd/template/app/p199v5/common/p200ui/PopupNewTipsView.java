package com.introvd.template.app.p199v5.common.p200ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.exoplayer2.C3119C;
import com.introvd.template.R;
import com.introvd.template.crash.C5523b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.dialog.C8980o;

/* renamed from: com.introvd.template.app.v5.common.ui.PopupNewTipsView */
public class PopupNewTipsView extends LinearLayout {
    private int bFv = 0;
    private int bFw;

    public PopupNewTipsView(Context context) {
        super(context);
        init();
    }

    public PopupNewTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PopupNewTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(0);
    }

    /* renamed from: QV */
    public void mo24505QV() {
        removeAllViews();
        TextView textView = new TextView(getContext());
        String string = getContext().getString(R.string.xiaoying_str_here_is_all_create_tools);
        Drawable drawable = getResources().getDrawable(R.drawable.xyui_icon_pupup_close_n);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int dpFloatToPixel = C4583d.dpFloatToPixel(getContext(), 5.0f);
        textView.setCompoundDrawablePadding(dpFloatToPixel);
        if (VERSION.SDK_INT >= 17) {
            textView.setCompoundDrawablesRelative(null, null, drawable, null);
        } else {
            textView.setCompoundDrawables(null, null, drawable, null);
        }
        textView.setText(string);
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(C8980o.m26352qX(C3119C.SANS_SERIF_NAME));
        textView.setTextColor(-1);
        textView.setGravity(17);
        addView(textView, new LayoutParams(-2, -2));
        this.bFw = (int) textView.getPaint().measureText(string);
        this.bFw += (C4583d.m11670O(getContext(), 12) * 2) + drawable.getIntrinsicWidth() + dpFloatToPixel;
        setGravity(17);
        setBackgroundResource(R.drawable.xyui_bg_help_pop_center_up);
    }

    public int getTipWidth() {
        return this.bFw;
    }

    /* renamed from: s */
    public void mo24507s(String str, int i) {
        removeAllViews();
        TextView textView = new TextView(getContext());
        Drawable drawable = getResources().getDrawable(R.drawable.xyui_icon_pupup_close_n);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int dpFloatToPixel = C4583d.dpFloatToPixel(getContext(), 5.0f);
        textView.setCompoundDrawablePadding(dpFloatToPixel);
        if (VERSION.SDK_INT >= 17) {
            textView.setCompoundDrawablesRelative(null, null, drawable, null);
        } else {
            textView.setCompoundDrawables(null, null, drawable, null);
        }
        textView.setText(str);
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(C8980o.m26352qX(C3119C.SANS_SERIF_NAME));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setSingleLine();
        this.bFw = (int) textView.getPaint().measureText(str);
        this.bFw += (C4583d.m11670O(getContext(), 12) * 2) + drawable.getIntrinsicWidth() + dpFloatToPixel;
        setGravity(17);
        addView(textView, new LayoutParams(-2, -2));
        try {
            setBackgroundResource(i);
        } catch (Exception e) {
            C5523b.logException(e);
        }
    }
}
