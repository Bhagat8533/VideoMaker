package com.introvd.template.explorer;

import com.google.android.exoplayer2.util.MimeTypes;

/* renamed from: com.introvd.template.explorer.b */
public class C7138b {
    private static final String[] dxH = {"MP3", "M4A", "AAC"};
    private static final String[] dxI = {"MP4", "3GP", "3G2", "M4V", "3GPP", "MOV"};
    private static final String[] dxJ = {"JPG", "BMP", "JPEG", "PNG", "GIF"};
    private static final String[] dxK = {MimeTypes.AUDIO_AMR_NB, "audio/3gpp2", "audio/aac", "audio/mp3", MimeTypes.AUDIO_MP4, MimeTypes.AUDIO_MPEG, "audio/mpeg3", "audio/mpg", "audio/x-aac", "audio/x-m4a", "audio/x-mp3", "audio/x-mpeg", "audio/x-mpeg3", "audio/x-mpg"};
    private static final String[] dxL = {MimeTypes.VIDEO_MP4, MimeTypes.VIDEO_MPEG, MimeTypes.VIDEO_H263, "video/3gpp2", "video/x-m4v", "video/x-mpeg"};
    private static final String[] dxM = {"image/jpeg", "image/jpg", "image/png", "image/bmp", "image/gif", "image/jpe", "image/jpeg2000", "image/jpeg2000-image", "image/x-bmp", "image/x-png"};

    public static String[] avO() {
        return dxJ;
    }

    public static String[] avP() {
        return dxI;
    }

    public static String[] avQ() {
        return dxH;
    }

    public static String[] avR() {
        return dxM;
    }

    public static String[] avS() {
        return dxL;
    }

    public static String[] avT() {
        return dxK;
    }
}
