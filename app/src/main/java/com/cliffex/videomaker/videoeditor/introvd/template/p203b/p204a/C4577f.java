package com.introvd.template.p203b.p204a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowInsets;
import android.widget.TextView;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.crash.C5523b;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.p204a.C4564a.C4566a;
import java.lang.ref.WeakReference;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.b.a.f */
public class C4577f {
    private static WeakReference<C4576e> bLG;

    @TargetApi(23)
    /* renamed from: a */
    private static int m11621a(Context context, View view) {
        int i;
        int i2 = 90;
        if (VERSION.SDK_INT < 23) {
            try {
                i = context.getResources().getDimensionPixelOffset(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
            } catch (Exception e) {
                C5523b.logException(e);
                i = 90;
            }
            if (i > 0 && i <= 300) {
                i2 = i;
            }
        } else if (view == null) {
            return 0;
        } else {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets != null) {
                i2 = rootWindowInsets.getStableInsetTop();
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static C4576e m11622a(Context context, View view, int i, int i2, View view2) {
        C4576e eVar = null;
        if (view == null || context == null || view2 == null) {
            return null;
        }
        C4576e a = C4576e.m11610a(context, view, new C4566a().mo24820Y(300).mo24821Z(300).mo24826il(i).mo24827im(i2).mo24825ce(true).mo24824cd(view2).mo24822a(C4571b.BaseEffectForEditor).mo24834it(136).mo24819SB());
        if (bLG != null) {
            eVar = (C4576e) bLG.get();
        }
        if (eVar != null && eVar.isShowing()) {
            m11629e(eVar);
        }
        a.show();
        bLG = new WeakReference<>(a);
        return a;
    }

    /* renamed from: a */
    public static C4576e m11623a(Context context, View view, String str, int i) {
        return m11624a(context, view, str, 0, i);
    }

    /* renamed from: a */
    public static C4576e m11624a(final Context context, View view, final String str, int i, final int i2) {
        final String str2;
        if (context == null) {
            return null;
        }
        String valueOf = String.valueOf(str);
        char c = 65535;
        switch (valueOf.hashCode()) {
            case -1984489302:
                if (valueOf.equals("Mosaic")) {
                    c = 4;
                    break;
                }
                break;
            case -1846648247:
                if (valueOf.equals("animated_text")) {
                    c = 3;
                    break;
                }
                break;
            case -1833928446:
                if (valueOf.equals("effects")) {
                    c = 0;
                    break;
                }
                break;
            case -1657657459:
                if (valueOf.equals("key_frame")) {
                    c = 7;
                    break;
                }
                break;
            case -894257304:
                if (valueOf.equals("customize_watermark")) {
                    c = 6;
                    break;
                }
                break;
            case 948441424:
                if (valueOf.equals("VoiceChanger")) {
                    c = 5;
                    break;
                }
                break;
            case 1537079280:
                if (valueOf.equals("audio_extraction")) {
                    c = 8;
                    break;
                }
                break;
            case 1611555795:
                if (valueOf.equals("custom_bg")) {
                    c = 2;
                    break;
                }
                break;
            case 1977085293:
                if (valueOf.equals("adjustment")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str2 = C7825a.ALL_TEMPLATE.getId();
                break;
            case 1:
                str2 = C7825a.VIDEO_PARAM_ADJUST.getId();
                break;
            case 2:
                str2 = C7825a.CUSTOMIZED_BACKGROUND.getId();
                break;
            case 3:
                str2 = C7825a.ANIM_TITLE.getId();
                break;
            case 4:
                str2 = C7825a.MOSAIC.getId();
                break;
            case 5:
                str2 = C7825a.MAGIC_SOUND.getId();
                break;
            case 6:
                str2 = C7825a.USER_WATER_MARK.getId();
                break;
            case 7:
                str2 = C7825a.KEY_FRAME.getId();
                break;
            case 8:
                str2 = C7825a.AUDIO_EXTRA.getId();
                break;
            default:
                str2 = null;
                break;
        }
        View inflate = LayoutInflater.from(context.getApplicationContext()).inflate(C10122R.C10126layout.iap_toast_vip_tip_in_editor, null);
        inflate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8049f.aBf().mo33097b(context, C8070o.aBw(), str2, str, i2);
            }
        });
        return m11622a(context, view, 0, (NotchUtil.isNotchDevice() ? m11621a(context, view) : 0) + C4583d.m11671P((float) i), inflate);
    }

    /* renamed from: a */
    public static C4576e m11625a(final Context context, View view, String str, final String str2, final int i) {
        if (context == null) {
            return null;
        }
        TextView textView = (TextView) LayoutInflater.from(context.getApplicationContext()).inflate(C10122R.C10126layout.iap_toast_vip_tip_in_editor, null);
        String string = context.getString(C10122R.string.xiaoying_str_vip_editor_tip_duration_limit, new Object[]{str});
        String string2 = context.getString(C10122R.string.xiaoying_str_vip_editor_tip_trim, new Object[]{string});
        SpannableString spannableString = new SpannableString(string2);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(C10122R.color.color_f8e71c)), string2.length() - string.length(), string2.length(), 18);
        textView.setText(spannableString);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8049f.aBf().mo33097b(context.getApplicationContext(), C8070o.aBw(), C7825a.DURATION_LIMIT.getId(), str2, i);
            }
        });
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return m11622a(context, view, 0, iArr[1] + C4583d.m11671P(44.0f), (View) textView);
    }

    /* renamed from: a */
    public static void m11626a(Context context, int i, View view, int i2) {
        m11628a(context, view, (CharSequence) context.getResources().getString(i2), i, 1500);
    }

    /* renamed from: a */
    public static void m11627a(Context context, View view, int i, long j) {
        m11628a(context, view, (CharSequence) context.getResources().getString(i), 0, j);
    }

    /* renamed from: a */
    public static void m11628a(Context context, View view, CharSequence charSequence, int i, long j) {
        if (view != null && context != null && !TextUtils.isEmpty(charSequence)) {
            C4576e.m11611a(context, view, charSequence, 0, i != 0 ? view.getHeight() : 0, new C4566a().mo24823aa(j).mo24830ip(C4583d.m11671P(30.0f)).mo24828in(-1).mo24829io(-855673010).mo24831iq(17).mo24832ir(10).mo24833is(14).mo24819SB()).show();
        }
    }

    /* renamed from: e */
    public static void m11629e(C4576e eVar) {
        if (eVar != null) {
            eVar.remove();
        }
    }

    /* renamed from: i */
    public static boolean m11630i(C4576e eVar) {
        return eVar != null && eVar.isShowing();
    }
}
