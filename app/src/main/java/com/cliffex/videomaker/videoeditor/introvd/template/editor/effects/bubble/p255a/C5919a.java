package com.introvd.template.editor.effects.bubble.p255a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.p021v4.graphics.drawable.DrawableCompat;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.bubble.a.a */
public class C5919a {
    private static HashMap<String, Integer> cud = new HashMap<>();
    private ProgressBar bqi;
    private RelativeLayout cua;
    private Button cub;
    private TextView cuc;

    public C5919a(RelativeLayout relativeLayout, OnClickListener onClickListener) {
        this.cua = relativeLayout;
        this.cub = (Button) relativeLayout.findViewById(R.id.btn_roll_bubble_download_state);
        this.cub.setOnClickListener(onClickListener);
        this.bqi = (ProgressBar) relativeLayout.findViewById(R.id.progressbar_bubble_loading);
        this.cuc = (TextView) relativeLayout.findViewById(R.id.tv_roll_bubble_download_progress);
    }

    /* renamed from: a */
    private static Drawable m16597a(Drawable drawable, ColorStateList colorStateList) {
        Drawable wrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrap, colorStateList);
        return wrap;
    }

    private void acl() {
        this.cub.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.cub.setText(R.string.xiaoying_str_template_state_download);
        this.cub.setTextColor(-16777216);
        this.cub.setBackgroundDrawable(m16597a(this.cub.getBackground(), ColorStateList.valueOf(-1)));
    }

    private boolean isNeedToPurchase(String str) {
        if (!C8739i.isNeedToPurchase(str)) {
            return false;
        }
        return C8745n.isAnimSubtitleRollcode(str) ? !C8072q.aBx().mo33072ku(C7825a.ANIM_TITLE.getId()) : C6386d.m18377iL(str);
    }

    /* renamed from: a */
    public void mo28526a(Context context, boolean z, TemplateInfo templateInfo, String str) {
        if (C8745n.m25561qv(str) || z || "20160224184948".equals(str) || "20160224184733".equals(str) || "Giphy".equals(str) || "sticker_test/".equals(str) || "title_test/".equals(str)) {
            this.cua.setVisibility(4);
            return;
        }
        this.cua.setVisibility(0);
        this.cub.setVisibility(0);
        if (templateInfo != null && templateInfo.nState == 8) {
            this.cub.setVisibility(4);
            this.bqi.setVisibility(0);
            this.cuc.setVisibility(0);
            if (cud != null && cud.containsKey(str)) {
                Integer num = (Integer) cud.get(str);
                if (num != null && num.intValue() >= 0) {
                    TextView textView = this.cuc;
                    StringBuilder sb = new StringBuilder();
                    sb.append(num);
                    sb.append("%");
                    textView.setText(sb.toString());
                    this.bqi.setProgress(num.intValue());
                }
            }
        } else {
            this.bqi.setVisibility(8);
            this.cuc.setVisibility(8);
            this.cub.setVisibility(0);
            if (C8739i.m25526qq(str)) {
                this.cub.setText(R.string.xiaoying_str_iap_ad_unlock_button);
                this.cub.setTextColor(-1);
                this.cub.setBackgroundDrawable(m16597a(this.cub.getBackground(), ColorStateList.valueOf(context.getResources().getColor(R.color.color_ff5e13))));
            } else if (C8739i.m25527qr(str)) {
                this.cub.setText(R.string.xiaoying_str_iap_unlock_template_list);
                this.cub.setTextColor(-1);
                this.cub.setBackgroundDrawable(m16597a(context.getResources().getDrawable(R.drawable.v5_xiaoying_category_search_bg), ColorStateList.valueOf(context.getResources().getColor(R.color.color_ff5e13))));
            } else {
                acl();
            }
            if (isNeedToPurchase(str)) {
                this.cub.setText(R.string.xiaoying_str_try_immediately);
                this.cub.setTextColor(-1);
                this.cub.setGravity(17);
                if (C8049f.aBf().mo33077EO()) {
                    this.cub.setBackgroundDrawable(m16597a(this.cub.getBackground(), ColorStateList.valueOf(context.getResources().getColor(R.color.color_ff5e13))));
                } else {
                    this.cub.setBackgroundDrawable(m16597a(this.cub.getBackground(), ColorStateList.valueOf(context.getResources().getColor(R.color.color_6d6d6d))));
                }
            }
        }
    }

    public void ack() {
        this.cua.setVisibility(4);
    }

    /* renamed from: c */
    public void mo28528c(String str, int i, boolean z) {
        cud.put(str, Integer.valueOf(i));
        if (z) {
            this.bqi.setVisibility(0);
            this.cuc.setVisibility(0);
            this.cub.setVisibility(4);
            if (i >= 0) {
                TextView textView = this.cuc;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("%");
                textView.setText(sb.toString());
                this.bqi.setProgress(i);
            }
        }
    }
}
