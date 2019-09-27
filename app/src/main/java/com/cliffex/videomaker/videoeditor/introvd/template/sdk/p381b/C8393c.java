package com.introvd.template.sdk.p381b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.VeMSize;
import java.util.List;
import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.sdk.b.c */
public class C8393c {
    /* renamed from: a */
    public static void m24209a(SharedPreferences sharedPreferences, int i) {
        Editor edit = sharedPreferences.edit();
        edit.putString("pref_camera_id_key", Integer.toString(i));
        edit.apply();
    }

    /* renamed from: a */
    public static boolean m24210a(VeMSize veMSize, List<Size> list, Parameters parameters) {
        return m24211a(veMSize, list, parameters, false);
    }

    /* renamed from: a */
    public static boolean m24211a(VeMSize veMSize, List<Size> list, Parameters parameters, boolean z) {
        boolean z2 = false;
        if (list == null || list.size() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("===========Screen Size is:");
        sb.append(veMSize.width);
        sb.append("x");
        sb.append(veMSize.height);
        C8554j.m25008i("CameraSettings", sb.toString());
        VeMSize veMSize2 = new VeMSize((int) QUtils.VIDEO_RES_720P_WIDTH, (int) QUtils.VIDEO_RES_720P_HEIGHT);
        if (veMSize.width * veMSize.height <= 153600) {
            veMSize2.width = 320;
            veMSize2.height = 240;
        }
        Size size = null;
        int i = Integer.MAX_VALUE;
        int i2 = veMSize2.width * veMSize2.height;
        for (Size size2 : list) {
            int abs = Math.abs((size2.width * size2.height) - i2);
            if (abs < i) {
                size = size2;
                i = abs;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("===========Camera supported Preview size is:");
            sb2.append(size2.width);
            sb2.append("x");
            sb2.append(size2.height);
            C8554j.m25008i("CameraSettings", sb2.toString());
        }
        if (size != null) {
            parameters.setPreviewSize(size.width, size.height);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("===========Final matched Preview size is:");
            sb3.append(size.width);
            sb3.append("x");
            sb3.append(size.height);
            C8554j.m25008i("CameraSettings", sb3.toString());
        }
        if (size != null) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: c */
    public static void m24212c(SharedPreferences sharedPreferences) {
        int i = 0;
        try {
            i = sharedPreferences.getInt("pref_local_version_key", 0);
        } catch (Exception unused) {
        }
        if (i != 1) {
            Editor edit = sharedPreferences.edit();
            edit.putInt("pref_local_version_key", 1);
            edit.apply();
        }
    }

    /* renamed from: d */
    public static void m24213d(SharedPreferences sharedPreferences) {
        int i = 0;
        try {
            i = sharedPreferences.getInt("pref_version_key", 0);
        } catch (Exception unused) {
        }
        if (i != 4) {
            Editor edit = sharedPreferences.edit();
            if (i == 0) {
                i = 1;
            }
            if (i == 1) {
                String string = sharedPreferences.getString("pref_camera_jpegquality_key", "85");
                String str = "65".equals(string) ? "normal" : "75".equals(string) ? "fine" : "superfine";
                edit.putString("pref_camera_jpegquality_key", str);
                i = 2;
            }
            if (i == 2) {
                edit.putString("pref_camera_recordlocation_key", "on");
                i = 3;
            }
            if (i == 3) {
                edit.remove("pref_camera_videoquality_key");
                edit.remove("pref_camera_video_duration_key");
            }
            edit.putInt("pref_version_key", 4);
            edit.apply();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* renamed from: gL */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.hardware.Camera.Size m24214gL(android.content.Context r6) {
        /*
            r0 = 0
            com.introvd.template.sdk.b.b r1 = com.introvd.template.sdk.p381b.C8392b.aHk()     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            android.hardware.Camera r2 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            r1.mo33943a(r2)     // Catch:{ Exception -> 0x0040 }
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ Exception -> 0x0040 }
            java.util.List r3 = r1.getSupportedPreviewSizes()     // Catch:{ Exception -> 0x0040 }
            com.introvd.template.sdk.utils.VeMSize r4 = new com.introvd.template.sdk.utils.VeMSize     // Catch:{ Exception -> 0x0040 }
            r4.<init>()     // Catch:{ Exception -> 0x0040 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0040 }
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()     // Catch:{ Exception -> 0x0040 }
            int r5 = r6.widthPixels     // Catch:{ Exception -> 0x0040 }
            r4.width = r5     // Catch:{ Exception -> 0x0040 }
            int r6 = r6.heightPixels     // Catch:{ Exception -> 0x0040 }
            r4.height = r6     // Catch:{ Exception -> 0x0040 }
            boolean r6 = m24210a(r4, r3, r1)     // Catch:{ Exception -> 0x0040 }
            if (r6 != 0) goto L_0x0036
            r6 = 640(0x280, float:8.97E-43)
            r3 = 480(0x1e0, float:6.73E-43)
            r1.setPreviewSize(r6, r3)     // Catch:{ Exception -> 0x0040 }
        L_0x0036:
            android.hardware.Camera$Size r6 = r1.getPreviewSize()     // Catch:{ Exception -> 0x0040 }
            if (r2 == 0) goto L_0x003f
            r2.release()
        L_0x003f:
            return r6
        L_0x0040:
            r6 = move-exception
            goto L_0x0047
        L_0x0042:
            r6 = move-exception
            r2 = r0
            goto L_0x0068
        L_0x0045:
            r6 = move-exception
            r2 = r0
        L_0x0047:
            java.lang.String r1 = "CameraSettings"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r3.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = "exception :"
            r3.append(r4)     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0067 }
            r3.append(r6)     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0067 }
            com.introvd.template.sdk.utils.C8554j.m25007e(r1, r6)     // Catch:{ all -> 0x0067 }
            if (r2 == 0) goto L_0x0066
            r2.release()
        L_0x0066:
            return r0
        L_0x0067:
            r6 = move-exception
        L_0x0068:
            if (r2 == 0) goto L_0x006d
            r2.release()
        L_0x006d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.p381b.C8393c.m24214gL(android.content.Context):android.hardware.Camera$Size");
    }
}
