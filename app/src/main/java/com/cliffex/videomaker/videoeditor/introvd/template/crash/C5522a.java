package com.introvd.template.crash;

import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.introvd.template.C4676f;
import com.introvd.template.C4681i;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.user.UserServiceProxy;
import com.quvideo.rescue.p225f.C4942b;
import com.vivavideo.component.crash.C9287h;
import com.vivavideo.mobile.h5core.refresh.H5PullHeader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.introvd.template.crash.a */
public class C5522a {
    /* renamed from: a */
    private static String m14962a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return toHexString(instance.digest(), ":");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String aaP() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n<<");
        sb.append(C4681i.bgr);
        StringBuilder sb2 = new StringBuilder(sb.toString());
        String at = m14963at(System.currentTimeMillis());
        if (!TextUtils.isEmpty(at)) {
            sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb2.append(at);
        }
        if (UserServiceProxy.isLogin() && !TextUtils.isEmpty(UserServiceProxy.getUserId())) {
            sb2.append(",uid=");
            sb2.append(UserServiceProxy.getUserId());
        }
        String aaQ = aaQ();
        if (!TextUtils.isEmpty(aaQ)) {
            sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb2.append(aaQ);
        }
        Locale locale = VivaBaseApplication.m8749FZ().getResources().getConfiguration().locale;
        if (locale != null) {
            String language = locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                sb2.append(",lang=");
                sb2.append(language);
            }
        }
        if (!(VivaBaseApplication.m8749FZ() == null || AppStateModel.getInstance() == null)) {
            String countryCode = AppStateModel.getInstance().getCountryCode();
            if (!TextUtils.isEmpty(countryCode)) {
                sb2.append(",countryCode=");
                sb2.append(countryCode);
            }
        }
        String bq = C4676f.m12173bq(VivaBaseApplication.m8749FZ());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(bq);
        sb3.append("-");
        sb3.append(Thread.currentThread().getName());
        sb3.append("-");
        sb3.append(Thread.currentThread().getId());
        String sb4 = sb3.toString();
        if (!TextUtils.isEmpty(sb4)) {
            sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb2.append(sb4);
        }
        try {
            String a = m14962a(VivaBaseApplication.m8749FZ().getPackageManager().getPackageInfo(VivaBaseApplication.m8749FZ().getPackageName(), 64).signatures[0].toByteArray(), "SHA1");
            if (!TextUtils.isEmpty(a)) {
                sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                sb2.append(a);
            }
        } catch (NameNotFoundException unused) {
        }
        sb2.append(">>");
        return sb2.toString();
    }

    private static String aaQ() {
        int i = C4942b.m12636i(VivaBaseApplication.m8749FZ());
        if (i == 4) {
            return "NET_2G";
        }
        if (i == 8) {
            return "NET_3G";
        }
        if (i == 16) {
            return "NET_4G";
        }
        if (i == 32) {
            return "NET_EXCEPTION";
        }
        switch (i) {
            case 0:
                return "NET_OFF";
            case 1:
                return "NET_UNKNOWN";
            case 2:
                return "NET_WIFI";
            default:
                return "UNKNOW";
        }
    }

    /* renamed from: at */
    private static String m14963at(long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(H5PullHeader.TIME_FORMAT, Locale.CHINA);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            return simpleDateFormat.format(new Date(j));
        } catch (Exception e) {
            C5523b.m14966t(e);
            return String.valueOf(j);
        }
    }

    /* renamed from: s */
    static Throwable m14964s(Throwable th) {
        return C9287h.m26982a(th, aaP());
    }

    private static String toHexString(byte[] bArr, String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (i < bArr.length - 1) {
            sb.append(cArr[(bArr[i] & 240) >>> 4]);
            sb.append(cArr[bArr[i] & 15]);
            if (str != null) {
                sb.append(str);
            }
            i++;
        }
        sb.append(cArr[(bArr[i] & 240) >>> 4]);
        sb.append(cArr[bArr[i] & 15]);
        return sb.toString();
    }
}
