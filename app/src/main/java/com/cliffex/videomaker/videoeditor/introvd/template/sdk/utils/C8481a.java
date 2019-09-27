package com.introvd.template.sdk.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.webkit.MimeTypeMap;
import com.google.android.exoplayer2.util.MimeTypes;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.sdk.model.editor.VideoInfo;
import java.io.File;
import java.util.Locale;

/* renamed from: com.introvd.template.sdk.utils.a */
public class C8481a {
    /* renamed from: a */
    public static boolean m24575a(Context context, String str, VideoInfo videoInfo) {
        char c;
        if (context == null || str == null || str.lastIndexOf(".") < 0) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        int GetFileMediaType = C8556l.GetFileMediaType(str);
        if (C8556l.IsImageFileType(GetFileMediaType)) {
            c = 1;
        } else if (!C8556l.IsVideoFileType(GetFileMediaType)) {
            return false;
        } else {
            c = 3;
        }
        File file = new File(str);
        if (!file.isFile()) {
            return false;
        }
        String name = file.getName();
        if (name.lastIndexOf(".") < 0) {
            return false;
        }
        String substring = name.substring(0, name.lastIndexOf("."));
        int i = 6;
        if (c == 1) {
            ContentValues contentValues = new ContentValues(6);
            contentValues.put("title", substring);
            contentValues.put("_display_name", file.getName());
            contentValues.put(SocialConstDef.MEDIA_ITEM_DATA, file.getPath());
            contentValues.put(SocialConstDef.MEDIA_ITEM_DATE_MODIFIED, Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("_size", Long.valueOf(file.length()));
            String oa = m24577oa(str);
            if (oa == null) {
                oa = "image/jpeg";
            }
            contentValues.put(SocialConstDef.MEDIA_ITEM_MIME_TYPE, oa);
            contentResolver.insert(Media.EXTERNAL_CONTENT_URI, contentValues);
        } else if (c == 3) {
            if (videoInfo != null) {
                i = 8;
            }
            ContentValues contentValues2 = new ContentValues(i);
            contentValues2.put("title", substring);
            contentValues2.put("_display_name", file.getName());
            contentValues2.put(SocialConstDef.MEDIA_ITEM_DATA, file.getPath());
            contentValues2.put(SocialConstDef.MEDIA_ITEM_DATE_MODIFIED, Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues2.put("_size", Long.valueOf(file.length()));
            String oa2 = m24577oa(str);
            if (oa2 == null) {
                oa2 = MimeTypes.VIDEO_MP4;
            }
            contentValues2.put(SocialConstDef.MEDIA_ITEM_MIME_TYPE, oa2);
            if (videoInfo != null) {
                int i2 = videoInfo.duration;
                int i3 = videoInfo.frameWidth;
                int i4 = videoInfo.frameHeight;
                StringBuilder sb = new StringBuilder();
                sb.append(i3);
                sb.append("x");
                sb.append(i4);
                String sb2 = sb.toString();
                contentValues2.put("duration", Integer.valueOf(i2));
                contentValues2.put("resolution", sb2);
            }
            contentResolver.insert(Video.Media.EXTERNAL_CONTENT_URI, contentValues2);
        }
        return true;
    }

    /* renamed from: av */
    public static boolean m24576av(Context context, String str) {
        if (context == null) {
            return false;
        }
        String[] strArr = {str};
        context.getContentResolver().delete(Video.Media.EXTERNAL_CONTENT_URI, "_data = ?", strArr);
        return true;
    }

    /* renamed from: oa */
    private static String m24577oa(String str) {
        if (str == null) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf(".") + 1);
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        if (singleton == null) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(substring.toLowerCase(Locale.US));
    }
}
