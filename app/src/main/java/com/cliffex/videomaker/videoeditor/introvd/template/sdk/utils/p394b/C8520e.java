package com.introvd.template.sdk.utils.p394b;

import android.text.TextUtils;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.C8379a;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.utils.C8554j;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import xiaoying.engine.base.IQHWCodecQuery;
import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.sdk.utils.b.e */
public class C8520e implements IQHWCodecQuery {
    private String appVersionName;
    private String ehN;
    private String ehO;
    private String ehP;
    private String ehQ;

    public C8520e(String str) {
        this.appVersionName = str;
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("vername should not empty");
        }
    }

    /* renamed from: a */
    public static long m24656a(Date date, Date date2) {
        if (date == null || date2 == null) {
            return 0;
        }
        return Math.abs(date.getTime() - date2.getTime()) / 1000;
    }

    /* renamed from: aZ */
    private String m24657aZ(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("_");
        sb.append(str2);
        String sb2 = sb.toString();
        C8379a aGZ = C8410e.aGX().aGZ();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(sb2);
        String string = aGZ.getString(sb3.toString(), "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        m24660x(str2, false);
        C8379a aGZ2 = C8410e.aGX().aGZ();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append(sb2);
        return aGZ2.getString(sb4.toString(), "");
    }

    /* renamed from: f */
    public static boolean m24658f(String str, long j) {
        Date date;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(str);
        } catch (ParseException unused) {
            date = null;
        }
        if (m24656a(new Date(), date) <= j) {
            z = false;
        }
        return z;
    }

    public static String getGpuType() {
        return C8410e.aGX().aGZ().getString("pref_key_gpu_type", "");
    }

    /* renamed from: oB */
    private static boolean m24659oB(String str) {
        C8379a aGZ = C8410e.aGX().aGZ();
        StringBuilder sb = new StringBuilder();
        sb.append("pref_key_hwdec_counts");
        sb.append(str);
        return !TextUtils.isEmpty(aGZ.getString(sb.toString(), ""));
    }

    public static void recordDataRefreshTime(String str) {
        C8410e.aGX().aGZ().setString(str, new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date()));
    }

    /* renamed from: x */
    public static synchronized boolean m24660x(String str, boolean z) {
        synchronized (C8520e.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("_");
            sb.append(str);
            String sb2 = sb.toString();
            C8379a aGZ = C8410e.aGX().aGZ();
            String str2 = "HW_PARAMS_CACHE_TIME";
            String string = aGZ.getString(str2, "");
            if (z || !m24659oB(sb2) || m24658f(string, 28800)) {
                int[] iArr = new int[25];
                boolean[] zArr = new boolean[4];
                byte[] bArr = new byte[32];
                int[] iArr2 = new int[1];
                int[] iArr3 = new int[8];
                boolean[] zArr2 = new boolean[1];
                String str3 = "";
                try {
                    String and = C8401d.and();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(and);
                    sb3.append("ini/hw_codec_cap.xml");
                    str3 = sb3.toString();
                } catch (Exception unused) {
                }
                boolean[] zArr3 = zArr2;
                int[] iArr4 = iArr3;
                int[] iArr5 = iArr2;
                if (QUtils.getHWCodecCap(str3, iArr, zArr, iArr3, bArr, iArr2, zArr3) == 0) {
                    String arrays = Arrays.toString(iArr);
                    String arrays2 = Arrays.toString(zArr);
                    String arrays3 = Arrays.toString(iArr4);
                    String arrays4 = Arrays.toString(zArr3);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("cacheHWParams cacheDecResult=");
                    sb4.append(arrays);
                    sb4.append(";cacheEncs=");
                    sb4.append(arrays2);
                    C8554j.m25008i("MyQHWCodecQuery", sb4.toString());
                    String replace = arrays.replace('[', ' ').replace(']', ' ');
                    String replace2 = arrays2.replace('[', ' ').replace(']', ' ');
                    String replace3 = arrays3.replace('[', ' ').replace(']', ' ');
                    String replace4 = arrays4.replace('[', ' ').replace(']', ' ');
                    String str4 = new String(bArr, 0, iArr5[0], Charset.forName("UTF-8"));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("pref_key_hwdec_counts");
                    sb5.append(sb2);
                    aGZ.setString(sb5.toString(), replace);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("pref_key_hwenc_cap");
                    sb6.append(sb2);
                    aGZ.setString(sb6.toString(), replace2);
                    aGZ.setString("pref_key_gpu_type", str4);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("pref_key_import_formats");
                    sb7.append(sb2);
                    aGZ.setString(sb7.toString(), replace3);
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("pref_key_hwdec_beta_state");
                    sb8.append(sb2);
                    aGZ.setString(sb8.toString(), replace4);
                    recordDataRefreshTime(str2);
                } else {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("pref_key_hwdec_counts");
                    sb9.append(sb2);
                    aGZ.setString(sb9.toString(), "");
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("pref_key_hwenc_cap");
                    sb10.append(sb2);
                    aGZ.setString(sb10.toString(), "");
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append("pref_key_import_formats");
                    sb11.append(sb2);
                    aGZ.setString(sb11.toString(), "");
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append("pref_key_hwdec_beta_state");
                    sb12.append(sb2);
                    aGZ.setString(sb12.toString(), "");
                }
            }
        }
        return true;
    }

    public boolean getBetaTestedFlag() {
        if (TextUtils.isEmpty(this.ehQ)) {
            this.ehQ = m24657aZ("pref_key_hwdec_beta_state", this.appVersionName);
        }
        if (!TextUtils.isEmpty(this.ehQ)) {
            try {
                Boolean valueOf = Boolean.valueOf(this.ehQ.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP)[0].trim());
                StringBuilder sb = new StringBuilder();
                sb.append("cacheHWDecBetaState=");
                sb.append(this.ehQ);
                sb.append(";bEncFlag=");
                sb.append(valueOf);
                C8554j.m25008i("MyQHWCodecQuery", sb.toString());
                return valueOf.booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int getMAXHWDecCount(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("index=");
        sb.append(i);
        C8554j.m25008i("MyQHWCodecQuery", sb.toString());
        if (TextUtils.isEmpty(this.ehN)) {
            this.ehN = m24657aZ("pref_key_hwdec_counts", this.appVersionName);
        }
        if (!TextUtils.isEmpty(this.ehN)) {
            String[] split = this.ehN.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            if (i >= 0 && i < split.length) {
                try {
                    Integer valueOf = Integer.valueOf(split[i].trim());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("cacheHWDec=");
                    sb2.append(this.ehN);
                    sb2.append(";decCount=");
                    sb2.append(valueOf);
                    sb2.append(";index=");
                    sb2.append(i);
                    C8554j.m25008i("MyQHWCodecQuery", sb2.toString());
                    return valueOf.intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("getMAXHWDecCount=0;index=");
        sb3.append(i);
        C8554j.m25008i("MyQHWCodecQuery", sb3.toString());
        return 0;
    }

    public boolean queryHWEncCap(int i) {
        if (TextUtils.isEmpty(this.ehO)) {
            this.ehO = m24657aZ("pref_key_hwenc_cap", this.appVersionName);
        }
        if (!TextUtils.isEmpty(this.ehO)) {
            String[] split = this.ehO.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            if (i >= 0 && i < split.length) {
                try {
                    Boolean valueOf = Boolean.valueOf(split[i].trim());
                    StringBuilder sb = new StringBuilder();
                    sb.append("cacheHWEnc=");
                    sb.append(this.ehO);
                    sb.append(";bEncFlag=");
                    sb.append(valueOf);
                    sb.append(";index=");
                    sb.append(i);
                    C8554j.m25008i("MyQHWCodecQuery", sb.toString());
                    return valueOf.booleanValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("queryHWEncCap=false;index=");
        sb2.append(i);
        C8554j.m25008i("MyQHWCodecQuery", sb2.toString());
        return false;
    }

    public int queryVideoImportFormat(int i) {
        if (TextUtils.isEmpty(this.ehP)) {
            this.ehP = m24657aZ("pref_key_import_formats", this.appVersionName);
        }
        if (!TextUtils.isEmpty(this.ehP)) {
            String[] split = this.ehP.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            if (i >= 0 && i < split.length) {
                try {
                    Integer valueOf = Integer.valueOf(split[i].trim());
                    StringBuilder sb = new StringBuilder();
                    sb.append("cacheFormats=");
                    sb.append(this.ehP);
                    sb.append(";iformat=");
                    sb.append(valueOf);
                    sb.append(";index=");
                    sb.append(i);
                    C8554j.m25008i("MyQHWCodecQuery", sb.toString());
                    return valueOf.intValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
