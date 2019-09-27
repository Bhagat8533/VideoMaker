package com.introvd.template.sdk.slide.p392a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.utils.C8556l;
import com.introvd.template.sdk.utils.C8569v;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.slide.a.c */
public class C8466c {
    /* renamed from: a */
    public static void m24512a(String str, Bitmap bitmap, int i) {
        if (str != null && bitmap != null) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    String upperCase = str.toUpperCase(Locale.US);
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    if (upperCase.endsWith(".PNG")) {
                        compressFormat = CompressFormat.PNG;
                    }
                    bitmap.compress(compressFormat, i, fileOutputStream);
                    try {
                        fileOutputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static boolean aIY() {
        Context context = C8410e.aGX().getContext();
        boolean z = true;
        if (context == null) {
            return true;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > 720 || displayMetrics.heightPixels > 1280) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043 A[Catch:{ Throwable -> 0x0071, all -> 0x006a, Throwable -> 0x00ce }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044 A[Catch:{ Throwable -> 0x0071, all -> 0x006a, Throwable -> 0x00ce }] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m24513c(java.lang.String r17, int r18, int r19, int r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r17)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            int r3 = com.introvd.template.common.bitmapfun.util.Utils.getFileOrientation(r17)     // Catch:{ Throwable -> 0x00ce }
            int r3 = r3 + r20
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options     // Catch:{ Throwable -> 0x00ce }
            r5.<init>()     // Catch:{ Throwable -> 0x00ce }
            r6 = 1
            r5.inJustDecodeBounds = r6     // Catch:{ Throwable -> 0x00ce }
            android.graphics.BitmapFactory.decodeFile(r0, r5)     // Catch:{ Throwable -> 0x00ce }
            r7 = 0
            int r8 = com.introvd.template.common.bitmapfun.util.ImageResizer.calculateInSampleSize(r5, r1, r2, r7)     // Catch:{ Throwable -> 0x00ce }
            r5.inJustDecodeBounds = r7     // Catch:{ Throwable -> 0x00ce }
            r5.inSampleSize = r8     // Catch:{ Throwable -> 0x00ce }
            int r8 = m24517nT(r17)     // Catch:{ Throwable -> 0x00ce }
            r9 = 2
            if (r8 != r6) goto L_0x0035
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r5)     // Catch:{ Throwable -> 0x00ce }
        L_0x0033:
            r5 = r0
            goto L_0x0041
        L_0x0035:
            int r5 = m24517nT(r17)     // Catch:{ Throwable -> 0x00ce }
            if (r5 != r9) goto L_0x0040
            android.graphics.Bitmap r0 = android.media.ThumbnailUtils.createVideoThumbnail(r0, r6)     // Catch:{ Throwable -> 0x00ce }
            goto L_0x0033
        L_0x0040:
            r5 = r4
        L_0x0041:
            if (r5 != 0) goto L_0x0044
            return r4
        L_0x0044:
            android.graphics.Matrix r15 = new android.graphics.Matrix     // Catch:{ Throwable -> 0x00ce }
            r15.<init>()     // Catch:{ Throwable -> 0x00ce }
            float r0 = (float) r3     // Catch:{ Throwable -> 0x00ce }
            r15.postRotate(r0)     // Catch:{ Throwable -> 0x00ce }
            r11 = 0
            r12 = 0
            int r0 = r5.getWidth()     // Catch:{ Throwable -> 0x0071, all -> 0x006a }
            int r0 = r0 >> r9
            int r13 = r0 << 2
            int r0 = r5.getHeight()     // Catch:{ Throwable -> 0x0071, all -> 0x006a }
            int r0 = r0 >> r9
            int r14 = r0 << 2
            r16 = 1
            r10 = r5
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Throwable -> 0x0071, all -> 0x006a }
            if (r5 == r0) goto L_0x0078
            r5.recycle()     // Catch:{ Throwable -> 0x00ce }
            goto L_0x0078
        L_0x006a:
            r0 = move-exception
            if (r5 == 0) goto L_0x0070
            r5.recycle()     // Catch:{ Throwable -> 0x00ce }
        L_0x0070:
            throw r0     // Catch:{ Throwable -> 0x00ce }
        L_0x0071:
            if (r5 == 0) goto L_0x0077
            r5.recycle()     // Catch:{ Throwable -> 0x00ce }
        L_0x0077:
            r0 = r4
        L_0x0078:
            if (r0 == 0) goto L_0x00d2
            int r3 = r0.getWidth()     // Catch:{ Throwable -> 0x00ce }
            int r5 = r0.getHeight()     // Catch:{ Throwable -> 0x00ce }
            int r6 = r3 * r2
            int r8 = r1 * r5
            r10 = 1056964608(0x3f000000, float:0.5)
            if (r6 <= r8) goto L_0x009f
            float r6 = (float) r2     // Catch:{ Throwable -> 0x00ce }
            float r8 = (float) r5     // Catch:{ Throwable -> 0x00ce }
            float r6 = r6 / r8
            float r8 = (float) r3     // Catch:{ Throwable -> 0x00ce }
            float r11 = (float) r1     // Catch:{ Throwable -> 0x00ce }
            float r11 = r11 / r6
            float r8 = r8 - r11
            float r8 = r8 * r10
            int r6 = (int) r8     // Catch:{ Throwable -> 0x00ce }
            int r6 = r6 >> r9
            int r6 = r6 << r9
            int r8 = r6 * 2
            int r3 = r3 - r8
            int r3 = r3 >> r9
            int r3 = r3 << r9
            r8 = r5
            r5 = r3
            r3 = 0
            goto L_0x00b4
        L_0x009f:
            float r6 = (float) r1     // Catch:{ Throwable -> 0x00ce }
            float r8 = (float) r3     // Catch:{ Throwable -> 0x00ce }
            float r6 = r6 / r8
            float r8 = (float) r5     // Catch:{ Throwable -> 0x00ce }
            float r11 = (float) r2     // Catch:{ Throwable -> 0x00ce }
            float r11 = r11 / r6
            float r8 = r8 - r11
            float r8 = r8 * r10
            int r6 = (int) r8     // Catch:{ Throwable -> 0x00ce }
            int r6 = r6 >> r9
            int r6 = r6 << r9
            int r8 = r6 * 2
            int r5 = r5 - r8
            int r5 = r5 >> r9
            int r5 = r5 << r9
            r8 = r5
            r5 = r3
            r3 = r6
            r6 = 0
        L_0x00b4:
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r0, r6, r3, r5, r8)     // Catch:{ Throwable -> 0x00ce }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r3, r1, r2, r7)     // Catch:{ Throwable -> 0x00ce }
            if (r1 == r3) goto L_0x00c2
            r3.recycle()     // Catch:{ Throwable -> 0x00ce }
            r3 = r4
        L_0x00c2:
            if (r3 == r0) goto L_0x00cd
            boolean r2 = r0.isRecycled()     // Catch:{ Throwable -> 0x00ce }
            if (r2 != 0) goto L_0x00cd
            r0.recycle()     // Catch:{ Throwable -> 0x00ce }
        L_0x00cd:
            return r1
        L_0x00ce:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.slide.p392a.C8466c.m24513c(java.lang.String, int, int, int):android.graphics.Bitmap");
    }

    /* renamed from: e */
    public static void m24514e(String str, Bitmap bitmap) {
        m24512a(str, bitmap, 85);
    }

    /* renamed from: f */
    public static QClip m24515f(QStoryboard qStoryboard, int i) {
        if (qStoryboard == null) {
            return null;
        }
        if (m24521w(qStoryboard)) {
            i--;
        }
        if (i < 0 || i >= qStoryboard.getClipCount()) {
            return null;
        }
        return qStoryboard.getClip(i);
    }

    /* renamed from: nS */
    public static int m24516nS(String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e) {
            e.printStackTrace();
            exifInterface = null;
        }
        if (exifInterface != null) {
            int attributeInt = exifInterface.getAttributeInt(android.supportin.media.ExifInterface.TAG_ORIENTATION, -1);
            if (attributeInt != -1) {
                if (attributeInt == 3) {
                    return QDisplayContext.DISPLAY_ROTATION_180;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 8) {
                    return QDisplayContext.DISPLAY_ROTATION_270;
                }
            }
        }
        return 0;
    }

    /* renamed from: nT */
    public static int m24517nT(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int GetFileMediaType = C8556l.GetFileMediaType(str);
        if (C8556l.IsImageFileType(GetFileMediaType)) {
            return 1;
        }
        return C8556l.IsVideoFileType(GetFileMediaType) ? 2 : 0;
    }

    /* renamed from: nU */
    public static Date m24518nU(String str) {
        try {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: u */
    public static VeMSize m24519u(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return null;
        }
        VeMSize v = m24520v(qStoryboard);
        if (v != null) {
            v = C8572y.m25094g(v);
            int i = v.width;
            int i2 = v.height;
            boolean z = false;
            boolean z2 = i > i2;
            VeMSize js = C8572y.m25096js(C8410e.aGX().isCommunitySupport());
            if (i * i2 > js.width * js.height || (!z2 ? i2 > js.width || i > js.height : i > js.width || i2 > js.height)) {
                z = true;
            }
            if (z) {
                if (!z2) {
                    v = new VeMSize(i2, i);
                }
                v = C8569v.m25057a(v, js);
                if (!z2) {
                    v = new VeMSize(v.height, v.width);
                }
            }
            if (C8540q.m24893B(qStoryboard)) {
                VeMSize veMSize = z2 ? new VeMSize(js.width, js.height) : new VeMSize(js.height, js.width);
                int i3 = v.width;
                int i4 = v.height;
                int i5 = veMSize.width;
                int i6 = veMSize.height;
                int i7 = (i4 * i5) / i6;
                if (i7 < i3) {
                    i4 = (i6 * i3) / i5;
                } else {
                    i3 = i7;
                }
                v = new VeMSize(i3, i4);
            }
        }
        return v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.introvd.template.sdk.utils.VeMSize m24520v(xiaoying.engine.storyboard.QStoryboard r5) {
        /*
            boolean r0 = m24521w(r5)
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r0 = 1
            xiaoying.engine.clip.QClip r5 = m24515f(r5, r0)
            goto L_0x0011
        L_0x000d:
            xiaoying.engine.clip.QClip r5 = m24515f(r5, r1)
        L_0x0011:
            r0 = 0
            if (r5 == 0) goto L_0x006d
            boolean r2 = r5 instanceof xiaoying.engine.clip.QSceneClip
            if (r2 != 0) goto L_0x0041
            boolean r2 = r5 instanceof xiaoying.engine.cover.QCover
            if (r2 != 0) goto L_0x0041
            r2 = 12315(0x301b, float:1.7257E-41)
            java.lang.Object r2 = r5.getProperty(r2)     // Catch:{ Exception -> 0x003d }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x003d }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x003d }
            r1 = 360(0x168, float:5.04E-43)
            if (r2 >= 0) goto L_0x0036
            int r3 = r2 % 360
            int r3 = r3 + r1
            r1 = r3
            goto L_0x0041
        L_0x0031:
            r1 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
            goto L_0x003e
        L_0x0036:
            if (r2 <= r1) goto L_0x003b
            int r1 = r2 % 360
            goto L_0x0041
        L_0x003b:
            r1 = r2
            goto L_0x0041
        L_0x003d:
            r2 = move-exception
        L_0x003e:
            r2.printStackTrace()
        L_0x0041:
            r2 = 12291(0x3003, float:1.7223E-41)
            java.lang.Object r5 = r5.getProperty(r2)
            xiaoying.engine.base.QVideoInfo r5 = (xiaoying.engine.base.QVideoInfo) r5
            if (r5 == 0) goto L_0x005b
            r0 = 3
            int r0 = r5.get(r0)
            r2 = 4
            int r5 = r5.get(r2)
            com.introvd.template.sdk.utils.VeMSize r2 = new com.introvd.template.sdk.utils.VeMSize
            r2.<init>(r0, r5)
            r0 = r2
        L_0x005b:
            if (r0 == 0) goto L_0x006d
            r5 = 90
            if (r1 == r5) goto L_0x0065
            r5 = 270(0x10e, float:3.78E-43)
            if (r1 != r5) goto L_0x006d
        L_0x0065:
            int r5 = r0.height
            int r1 = r0.width
            r0.height = r1
            r0.width = r5
        L_0x006d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.slide.p392a.C8466c.m24520v(xiaoying.engine.storyboard.QStoryboard):com.introvd.template.sdk.utils.VeMSize");
    }

    /* renamed from: w */
    public static boolean m24521w(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        if (qStoryboard.getProperty(16392) != null) {
            z = true;
        }
        return z;
    }
}
