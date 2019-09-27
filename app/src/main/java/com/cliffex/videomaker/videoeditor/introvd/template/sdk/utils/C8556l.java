package com.introvd.template.sdk.utils;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.introvd.template.router.todoCode.TodoConstants;
import java.util.HashMap;
import java.util.Locale;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.sdk.utils.l */
public class C8556l {
    private static HashMap<String, C8557a> ccw = new HashMap<>();
    public static final String s_strFileExtFilter;

    /* renamed from: com.introvd.template.sdk.utils.l$a */
    static class C8557a {
        /* access modifiers changed from: private */
        public int ccx;
        private String ccy;

        C8557a(int i, String str) {
            this.ccx = i;
            this.ccy = str;
        }
    }

    static {
        m25014d("MP3", 1, MimeTypes.AUDIO_MPEG);
        m25014d("M4A", 2, MimeTypes.AUDIO_MP4);
        m25014d("M4A", 2, MimeTypes.AUDIO_AMR_NB);
        m25014d("WAV", 3, "audio/x-wav");
        m25014d("AMR", 4, "audio/amr");
        m25014d("AWB", 5, MimeTypes.AUDIO_AMR_WB);
        m25014d("WMA", 6, "audio/x-ms-wma");
        m25014d("OGG", 7, "application/ogg");
        m25014d("OGA", 7, "application/ogg");
        m25014d("AAC", 8, "audio/aac");
        m25014d("MID", 101, "audio/midi");
        m25014d("MIDI", 101, "audio/midi");
        m25014d("XMF", 101, "audio/midi");
        m25014d("RTTTL", 101, "audio/midi");
        m25014d("SMF", 102, "audio/sp-midi");
        m25014d("IMY", 103, "audio/imelody");
        m25014d("RTX", 101, "audio/midi");
        m25014d("OTA", 101, "audio/midi");
        m25014d("MP4", 201, MimeTypes.VIDEO_MP4);
        m25014d("M4V", 202, MimeTypes.VIDEO_MP4);
        m25014d("3GP", 203, MimeTypes.VIDEO_H263);
        m25014d("3GPP", 203, MimeTypes.VIDEO_H263);
        m25014d("3G2", HttpStatus.SC_NO_CONTENT, "video/3gpp2");
        m25014d("3GPP2", HttpStatus.SC_NO_CONTENT, "video/3gpp2");
        m25014d("WMV", HttpStatus.SC_RESET_CONTENT, "video/x-ms-wmv");
        m25014d("SKM", HttpStatus.SC_PARTIAL_CONTENT, "video/skm");
        m25014d("K3G", 207, "video/k3g");
        m25014d("AVI", TodoConstants.TODO_TYPE_CAMERA_MODE_ACTION, "video/avi");
        m25014d("ASF", TodoConstants.TODO_TYPE_CAMERA_MODE_FUNNY, "video/asf");
        m25014d("MOV", TodoConstants.TODO_TYPE_CAMERA_MODE_PIP, MimeTypes.VIDEO_MP4);
        m25014d("FLV", TodoConstants.TODO_TYPE_CAMERA_MODE_FB, MimeTypes.VIDEO_MP4);
        m25014d("JPG", HttpStatus.SC_MOVED_PERMANENTLY, "image/jpeg");
        m25014d("JPEG", HttpStatus.SC_MOVED_PERMANENTLY, "image/jpeg");
        m25014d("GIF", 302, "image/gif");
        m25014d("PNG", HttpStatus.SC_SEE_OTHER, "image/png");
        m25014d("BMP", HttpStatus.SC_NOT_MODIFIED, "image/x-ms-bmp");
        m25014d("WBMP", 305, "image/vnd.wap.wbmp");
        m25014d("M3U", 401, "audio/x-mpegurl");
        m25014d("PLS", HttpStatus.SC_PAYMENT_REQUIRED, "audio/x-scpls");
        m25014d("WPL", HttpStatus.SC_FORBIDDEN, "application/vnd.ms-wpl");
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
        C8557a aVar = (C8557a) ccw.get(str.substring(lastIndexOf + 1).toUpperCase(Locale.US));
        if (aVar == null) {
            return 0;
        }
        return aVar.ccx;
    }

    public static boolean IsImageFileType(int i) {
        return i >= 301 && i <= 399;
    }

    public static boolean IsVideoFileType(int i) {
        return i >= 201 && i <= 299;
    }

    /* renamed from: d */
    static void m25014d(String str, int i, String str2) {
        ccw.put(str, new C8557a(i, str2));
    }
}
