package com.introvd.template.editor.advance;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p021v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.advance.a */
public class C5581a {
    private static HashMap<String, Integer> cud = new HashMap<>();
    private ProgressBar bqi;
    private RelativeLayout cua;
    private Button cub;
    private TextView cuc;

    public C5581a(RelativeLayout relativeLayout, OnClickListener onClickListener) {
        this.cua = relativeLayout;
        this.cua.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.bqi = (ProgressBar) relativeLayout.findViewById(R.id.progressbar_loading);
        this.cub = (Button) relativeLayout.findViewById(R.id.btn_roll_download_state);
        this.cub.setOnClickListener(onClickListener);
        this.cuc = (TextView) relativeLayout.findViewById(R.id.txtview_rolldownload_progress);
    }

    /* renamed from: a */
    private static Drawable m15219a(Drawable drawable, ColorStateList colorStateList) {
        Drawable wrap = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrap, colorStateList);
        return wrap;
    }

    private void acl() {
        this.cub.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.cub.setText(R.string.xiaoying_str_template_state_download);
        this.cub.setTextColor(-16777216);
        this.cub.setBackgroundDrawable(m15219a(this.cub.getBackground(), ColorStateList.valueOf(-1)));
    }

    private boolean isNeedToPurchase(String str) {
        if (!C8739i.isNeedToPurchase(str)) {
            return false;
        }
        return C8745n.isAnimSubtitleRollcode(str) ? !C8072q.aBx().mo33072ku(C7825a.ANIM_TITLE.getId()) : C8049f.aBf().mo33101iL(str);
    }

    /* renamed from: a */
    public void mo27472a(Context context, boolean z, TemplateInfo templateInfo, String str) {
        if (C8745n.m25561qv(str) || z || "20160224184948".equals(str) || "20160224184733".equals(str) || "Giphy".equals(str) || "sticker_test/".equals(str) || "title_test/".equals(str)) {
            this.cua.setVisibility(4);
            return;
        }
        this.cua.setVisibility(0);
        this.cub.setVisibility(0);
        boolean z2 = true;
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
                if (VERSION.SDK_INT >= 17) {
                    this.cub.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.vivavideo_roll_template_lock_icon, 0, 0, 0);
                } else {
                    this.cub.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vivavideo_roll_template_lock_icon, 0, 0, 0);
                }
                this.cub.setText(R.string.xiaoying_str_iap_ad_unlock_button);
                this.cub.setTextColor(-1);
                this.cub.setBackgroundDrawable(m15219a(this.cub.getBackground(), ColorStateList.valueOf(Color.parseColor("#3ebcf1"))));
            } else if (C8739i.m25527qr(str)) {
                if (VERSION.SDK_INT >= 17) {
                    this.cub.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.vivavideo_roll_template_lock_icon, 0, 0, 0);
                } else {
                    this.cub.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vivavideo_roll_template_lock_icon, 0, 0, 0);
                }
                this.cub.setText(R.string.xiaoying_str_iap_unlock_template_list);
                this.cub.setTextColor(-1);
                this.cub.setBackgroundDrawable(m15219a(context.getResources().getDrawable(R.drawable.v5_xiaoying_category_search_bg), ColorStateList.valueOf(Color.parseColor("#3ebcf1"))));
            } else {
                acl();
            }
            if (isNeedToPurchase(str)) {
                this.cub.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                if (AppStateModel.getInstance().isInChina() || C7589a.getAdView(context, 37) == null) {
                    z2 = false;
                }
                if (z2) {
                    this.cub.setText(R.string.xiaoying_str_reward_video_ad_to_watch);
                } else {
                    this.cub.setText(R.string.xiaoying_str_iap_buy);
                }
                this.cub.setTextColor(-1);
                this.cub.setGravity(17);
                if (C8049f.aBf().mo33077EO() || z2) {
                    this.cub.setBackgroundDrawable(m15219a(this.cub.getBackground(), ColorStateList.valueOf(Color.parseColor("#ff3961"))));
                } else {
                    this.cub.setBackgroundDrawable(m15219a(this.cub.getBackground(), ColorStateList.valueOf(Color.parseColor("#6d6d6d"))));
                }
            }
        }
    }

    public void ack() {
        this.cua.setVisibility(4);
    }

    /* renamed from: c */
    public void mo27474c(String str, int i, boolean z) {
        cud.put(str, Integer.valueOf(i));
        if (z) {
            this.bqi.setVisibility(0);
            this.cuc.setVisibility(0);
            this.cub.setVisibility(4);
            this.bqi.setProgress(i);
            TextView textView = this.cuc;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("%");
            textView.setText(sb.toString());
        }
    }
}
