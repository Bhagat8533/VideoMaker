package com.introvd.template.p414ui.dialog;

import android.content.Context;
import android.support.p021v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import com.afollestad.materialdialogs.C1890f.C1895a;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.m */
public class C8978m {
    /* renamed from: af */
    public static C1895a m26348af(Context context, String str, String str2) {
        StyleSpan styleSpan = new StyleSpan(1);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(16, true);
        C1895a ds = new C1895a(context).mo10302du(ContextCompat.getColor(context, C10122R.color.black)).mo10300ds(ContextCompat.getColor(context, C10122R.color.color_ff5e13));
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(styleSpan, 0, spannableString.length(), 17);
            spannableString.setSpan(absoluteSizeSpan, 0, spannableString.length(), 17);
            ds.mo10317t(spannableString);
        }
        if (!TextUtils.isEmpty(str2)) {
            SpannableString spannableString2 = new SpannableString(str2);
            spannableString2.setSpan(styleSpan, 0, spannableString2.length(), 17);
            spannableString2.setSpan(absoluteSizeSpan, 0, spannableString2.length(), 17);
            ds.mo10316s(spannableString2);
        }
        return ds;
    }

    /* renamed from: hs */
    public static C1895a m26349hs(Context context) {
        return new C1895a(context).mo10302du(ContextCompat.getColor(context, C10122R.color.color_585858)).mo10300ds(ContextCompat.getColor(context, C10122R.color.color_585858)).mo10288aA(false);
    }

    /* renamed from: ht */
    public static C1895a m26350ht(Context context) {
        return new C1895a(context).mo10303dv(C10122R.string.xiaoying_str_com_cancel).mo10299dr(C10122R.string.xiaoying_str_com_ok).mo10302du(ContextCompat.getColor(context, C10122R.color.color_585858)).mo10300ds(ContextCompat.getColor(context, C10122R.color.color_585858)).mo10288aA(false);
    }
}
