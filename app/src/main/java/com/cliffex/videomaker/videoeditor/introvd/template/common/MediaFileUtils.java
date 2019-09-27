package com.introvd.template.common;

import android.annotation.SuppressLint;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.introvd.template.router.todoCode.TodoConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import p503cz.msebera.android.httpclient.HttpStatus;

public class MediaFileUtils {
    private static HashMap<String, C5222a> ccw = new HashMap<>();
    public static final String s_strFileExtFilter;

    /* renamed from: com.introvd.template.common.MediaFileUtils$a */
    static class C5222a {
        /* access modifiers changed from: private */
        public int ccx;
        /* access modifiers changed from: private */
        public String ccy;

        C5222a(int i, String str) {
            this.ccx = i;
            this.ccy = str;
        }

        /* renamed from: YX */
        public String mo26406YX() {
            return this.ccy;
        }
    }

    static {
        m14244d("MP3", 1, MimeTypes.AUDIO_MPEG);
        m14244d("M4A", 2, MimeTypes.AUDIO_MP4);
        m14244d("M4A", 2, MimeTypes.AUDIO_AMR_NB);
        m14244d("WAV", 3, "audio/x-wav");
        m14244d("AMR", 4, "audio/amr");
        m14244d("AWB", 5, MimeTypes.AUDIO_AMR_WB);
        m14244d("WMA", 6, "audio/x-ms-wma");
        m14244d("OGG", 7, "application/ogg");
        m14244d("OGA", 7, "application/ogg");
        m14244d("AAC", 8, "audio/aac");
        m14244d("MID", 101, "audio/midi");
        m14244d("MIDI", 101, "audio/midi");
        m14244d("XMF", 101, "audio/midi");
        m14244d("RTTTL", 101, "audio/midi");
        m14244d("SMF", 102, "audio/sp-midi");
        m14244d("IMY", 103, "audio/imelody");
        m14244d("RTX", 101, "audio/midi");
        m14244d("OTA", 101, "audio/midi");
        m14244d("MP4", 201, MimeTypes.VIDEO_MP4);
        m14244d("M4V", 202, MimeTypes.VIDEO_MP4);
        m14244d("3GP", 203, MimeTypes.VIDEO_H263);
        m14244d("3GPP", 203, MimeTypes.VIDEO_H263);
        m14244d("3G2", HttpStatus.SC_NO_CONTENT, "video/3gpp2");
        m14244d("3GPP2", HttpStatus.SC_NO_CONTENT, "video/3gpp2");
        m14244d("WMV", HttpStatus.SC_RESET_CONTENT, "video/x-ms-wmv");
        m14244d("SKM", HttpStatus.SC_PARTIAL_CONTENT, "video/skm");
        m14244d("K3G", 207, "video/k3g");
        m14244d("AVI", TodoConstants.TODO_TYPE_CAMERA_MODE_ACTION, "video/avi");
        m14244d("ASF", TodoConstants.TODO_TYPE_CAMERA_MODE_FUNNY, "video/asf");
        m14244d("MOV", TodoConstants.TODO_TYPE_CAMERA_MODE_PIP, MimeTypes.VIDEO_MP4);
        m14244d("FLV", TodoConstants.TODO_TYPE_CAMERA_MODE_FB, MimeTypes.VIDEO_MP4);
        m14244d("JPG", HttpStatus.SC_MOVED_PERMANENTLY, "image/jpeg");
        m14244d("JPEG", HttpStatus.SC_MOVED_PERMANENTLY, "image/jpeg");
        m14244d("GIF", 302, "image/gif");
        m14244d("PNG", HttpStatus.SC_SEE_OTHER, "image/png");
        m14244d("BMP", HttpStatus.SC_NOT_MODIFIED, "image/x-ms-bmp");
        m14244d("WBMP", 305, "image/vnd.wap.wbmp");
        m14244d("M3U", 401, "audio/x-mpegurl");
        m14244d("PLS", HttpStatus.SC_PAYMENT_REQUIRED, "audio/x-scpls");
        m14244d("WPL", HttpStatus.SC_FORBIDDEN, "application/vnd.ms-wpl");
        StringBuilder sb = new StringBuilder();
        for (String append : ccw.keySet()) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(append);
        }
        s_strFileExtFilter = sb.toString();
    }

    public static int GetFileMediaType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return 0;
        }
        C5222a aVar = (C5222a) ccw.get(str.substring(lastIndexOf + 1).toUpperCase(Locale.US));
        if (aVar == null) {
            return 0;
        }
        return aVar.ccx;
    }

    public static String GetFileMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return "";
        }
        C5222a aVar = (C5222a) ccw.get(str.substring(lastIndexOf + 1).toUpperCase(Locale.US));
        return aVar == null ? "" : aVar.mo26406YX();
    }

    public static String GetMediaFileExt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        for (Entry entry : ccw.entrySet()) {
            if (str.equalsIgnoreCase(((C5222a) entry.getValue()).ccy)) {
                return (String) entry.getKey();
            }
        }
        return "unknown";
    }

    public static boolean IsAudioFileType(int i) {
        if (i < 1 || i > 99) {
            return i >= 101 && i <= 199;
        }
        return true;
    }

    public static boolean IsImageFileType(int i) {
        return i >= 301 && i <= 399;
    }

    public static boolean IsSupportedVideoFileType(int i) {
        return i >= 201 && i <= 204;
    }

    public static boolean IsVideoFileType(int i) {
        return i >= 201 && i <= 299;
    }

    /* renamed from: d */
    static void m14244d(String str, int i, String str2) {
        ccw.put(str, new C5222a(i, str2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getAudioMediaDuration(java.lang.String r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r3 = 10
            if (r0 >= r3) goto L_0x0009
            return r1
        L_0x0009:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0010
            return r1
        L_0x0010:
            r0 = 0
            android.media.MediaMetadataRetriever r3 = new android.media.MediaMetadataRetriever     // Catch:{ Throwable -> 0x0033, all -> 0x002b }
            r3.<init>()     // Catch:{ Throwable -> 0x0033, all -> 0x002b }
            r3.setDataSource(r6)     // Catch:{ Throwable -> 0x0029, all -> 0x0027 }
            r6 = 9
            java.lang.String r6 = r3.extractMetadata(r6)     // Catch:{ Throwable -> 0x0029, all -> 0x0027 }
            long r4 = java.lang.Long.parseLong(r6)     // Catch:{ Throwable -> 0x0029, all -> 0x0027 }
            r3.release()
            return r4
        L_0x0027:
            r6 = move-exception
            goto L_0x002d
        L_0x0029:
            goto L_0x0034
        L_0x002b:
            r6 = move-exception
            r3 = r0
        L_0x002d:
            if (r3 == 0) goto L_0x0032
            r3.release()
        L_0x0032:
            throw r6
        L_0x0033:
            r3 = r0
        L_0x0034:
            if (r3 == 0) goto L_0x0039
            r3.release()
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.MediaFileUtils.getAudioMediaDuration(java.lang.String):long");
    }

    @SuppressLint({"NewApi"})
    public static int getVideoDuration(String str) {
        if (VERSION.SDK_INT >= 10) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (extractMetadata != null && extractMetadata.length() > 0) {
                    return Integer.parseInt(extractMetadata);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Throwable error:");
                sb.append(th.getMessage());
                LogUtilsV2.m14228e(sb.toString());
                return 0;
            } finally {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception unused2) {
                }
            }
        }
        return 0;
    }
}
