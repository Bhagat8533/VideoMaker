package com.introvd.template.common.imageloader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.C2176e;
import com.bumptech.glide.C2263l;
import com.bumptech.glide.C2516m;
import com.bumptech.glide.load.p118b.C2375i;
import com.bumptech.glide.load.p123c.p126c.C2465c;
import com.bumptech.glide.p111e.C2203g;
import com.bumptech.glide.p114f.C2212c;
import com.introvd.template.common.LogUtilsV2;
import com.quvideo.mobile.component.imageview.C4769c;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import p503cz.msebera.android.httpclient.HttpHost;

@Deprecated
public class ImageLoader {
    private static final int cfd = Color.parseColor("#66aaaaaa");

    public enum SourceType {
        IMAGE,
        VIDEO,
        HTTP,
        UNKNOWN
    }

    /* renamed from: ee */
    private static boolean m14392ee(Context context) {
        return (context instanceof Activity) && ((Activity) context).isFinishing();
    }

    public static void loadImage(int i, DynamicLoadingImageView dynamicLoadingImageView) {
        dynamicLoadingImageView.setImage(i);
    }

    public static void loadImage(Context context, int i, ImageView imageView) {
        if (!m14392ee(context)) {
            C2176e.m6137am(context).mo12193a(Integer.valueOf(i)).mo12182b(new C2203g().mo11974b(C2375i.aDg).mo12006xi()).mo12186g(imageView);
        }
    }

    public static void loadImage(Context context, int i, String str, ImageView imageView) {
        if (!m14392ee(context)) {
            C2176e.m6137am(context).mo12195aO(str).mo12182b(new C2203g().mo11974b(C2375i.aDg).mo11982em(i)).mo12186g(imageView);
        }
    }

    public static void loadImage(Context context, int i, String str, ImageView imageView, SourceType sourceType) {
        if (!m14392ee(context)) {
            if (str != null && str.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                sourceType = SourceType.HTTP;
            }
            StringBuilder sb = null;
            switch (sourceType) {
                case IMAGE:
                case VIDEO:
                    sb = new StringBuilder("file://");
                    sb.append(str);
                    break;
                case HTTP:
                    break;
                default:
                    if (str != null && !str.toLowerCase().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                        sb = new StringBuilder("file://");
                        sb.append(str);
                        break;
                    }
            }
            C2203g xi = new C2203g().mo11982em(i).mo12006xi();
            C2203g gVar = sourceType == SourceType.VIDEO ? xi.mo11974b(C2375i.aDg) : sourceType != SourceType.UNKNOWN ? xi.mo11974b(C2375i.aDg) : xi.mo11974b(C2375i.aDg);
            C2263l am = C2176e.m6137am(context);
            if (sb != null) {
                str = sb.toString();
            }
            am.mo12195aO(str).mo12182b(gVar).mo12186g(imageView);
        }
    }

    public static void loadImage(Context context, String str, ImageView imageView) {
        if (!m14392ee(context)) {
            C2176e.m6137am(context).mo12195aO(str).mo12182b(new C2203g().mo11974b(C2375i.aDg)).mo12186g(imageView);
        }
    }

    public static void loadImage(Context context, String str, ImageView imageView, int i, int i2) {
        if (!m14392ee(context)) {
            C2176e.m6137am(context).mo12195aO(str).mo12182b(new C2203g().mo11974b(C2375i.aDg).mo11978bg(i, i2)).mo12177a((C2516m<?, ? super TranscodeType>) C2465c.m7094wF()).mo12186g(imageView);
        }
    }

    public static void loadImage(String str, int i, int i2, Drawable drawable, DynamicLoadingImageView dynamicLoadingImageView) {
        if (!m14392ee(dynamicLoadingImageView.getContext()) && !TextUtils.isEmpty(str)) {
            dynamicLoadingImageView.setPlaceholderImage(i);
            dynamicLoadingImageView.setFailureImage(i2);
            if (C4769c.m12317D(dynamicLoadingImageView.getContext(), str)) {
                dynamicLoadingImageView.setImage(C4769c.m12316C(dynamicLoadingImageView.getContext(), str));
            } else {
                dynamicLoadingImageView.setImageURI(str);
            }
        }
    }

    public static void loadImage(String str, DynamicLoadingImageView dynamicLoadingImageView) {
        if (!m14392ee(dynamicLoadingImageView.getContext()) && !TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("1.url=");
            sb.append(str);
            LogUtilsV2.m14227d(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("2.imageView getHeight=");
            sb2.append(dynamicLoadingImageView.getHeight());
            sb2.append(",getWidth=");
            sb2.append(dynamicLoadingImageView.getWidth());
            LogUtilsV2.m14227d(sb2.toString());
            if (C4769c.m12317D(dynamicLoadingImageView.getContext(), str)) {
                dynamicLoadingImageView.setImage(C4769c.m12316C(dynamicLoadingImageView.getContext(), str));
            } else {
                dynamicLoadingImageView.setImageURI(str);
            }
        }
    }

    public static void loadImageWithSignature(Context context, String str, ImageView imageView, String str2) {
        if (!m14392ee(context)) {
            if (str2 == null) {
                str2 = "";
            }
            C2176e.m6137am(context).mo12195aO(str).mo12182b(new C2203g().mo11974b(C2375i.aDg).mo11987j(new C2212c(str2))).mo12186g(imageView);
        }
    }

    public static void pauseRequest(Context context) {
        C2176e.m6137am(context).mo12203tN();
    }

    public static void resumeRequest(Context context) {
        C2176e.m6137am(context).mo12204tO();
    }
}
