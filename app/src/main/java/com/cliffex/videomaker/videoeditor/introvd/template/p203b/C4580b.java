package com.introvd.template.p203b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.MediaStore.Video.Media;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.performance.PerformanceServiceProxy;
import com.introvd.template.router.setting.ISettingRouter;
import com.xiaoying.p448a.C9537b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.b.b */
public class C4580b {
    private static long bKD = 0;
    private static long bKE = 0;
    public static String bKF = "Xz75qh84fogl9abCdeIjk2nPr3s6T1Umv0wy";
    private static String bKG;

    /* renamed from: B */
    public static boolean m11631B(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: Sf */
    public static boolean m11632Sf() {
        return m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    /* renamed from: Sg */
    public static boolean m11633Sg() {
        return m11660eF("zh");
    }

    /* renamed from: Sh */
    public static boolean m11634Sh() {
        return "zh".equalsIgnoreCase(Locale.getDefault().getLanguage()) && AppStateModel.COUNTRY_CODE_Taiwan.equalsIgnoreCase(Locale.getDefault().getCountry());
    }

    /* renamed from: Si */
    public static String m11635Si() {
        String parameter = C9537b.getParameter("LanguageCode");
        return TextUtils.isEmpty(parameter) ? Locale.getDefault().toString() : parameter;
    }

    /* renamed from: Sj */
    public static boolean m11636Sj() {
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        return "OPPO".equalsIgnoreCase(str2) || "VIVO".equalsIgnoreCase(str2) || "OPPO".equalsIgnoreCase(str) || "VIVO".equalsIgnoreCase(str);
    }

    /* renamed from: V */
    public static String m11637V(long j) {
        String str;
        String str2 = "";
        if (j < 0) {
            j = 0;
        }
        long j2 = (j + 500) / 1000;
        if (j2 >= 3600) {
            try {
                str = String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Long.valueOf(j2 / 3600), Long.valueOf((j2 % 3600) / 60), Long.valueOf(j2 % 60)});
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ex:");
                sb.append(e.getMessage());
                LogUtils.m14222e("CommonUtil", sb.toString());
            }
        } else {
            str = String.format(Locale.US, "%2d:%02d", new Object[]{Long.valueOf((j2 % 3600) / 60), Long.valueOf(j2 % 60)});
        }
        str2 = str;
        return str2.trim();
    }

    /* renamed from: W */
    public static String m11638W(long j) {
        StringBuilder sb = new StringBuilder();
        while (j != 0) {
            sb.append(bKF.charAt(Math.abs((int) (j % ((long) bKF.length())))));
            j /= (long) bKF.length();
        }
        return sb.toString();
    }

    /* renamed from: W */
    public static List<String> m11639W(String str, String str2) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        ArrayList arrayList = new ArrayList();
        for (boolean find = matcher.find(); find; find = matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static long m11640a(Date date, Date date2) {
        if (date == null || date2 == null) {
            return 0;
        }
        return Math.abs(date.getTime() - date2.getTime()) / 1000;
    }

    /* renamed from: a */
    public static Bitmap m11641a(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        float f = (float) i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m11642a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(i);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        Matrix matrix = new Matrix();
        float f = (((float) i2) + 0.0f) / ((float) height);
        matrix.postScale(f, f);
        return Bitmap.createBitmap(createBitmap, 0, 0, width, height, matrix, true);
    }

    /* renamed from: a */
    public static void m11643a(Context context, String[] strArr, String[] strArr2, final OnScanCompletedListener onScanCompletedListener) {
        if (context != null && strArr != null && strArr.length != 0) {
            final Uri uri = Media.EXTERNAL_CONTENT_URI;
            final ContentResolver contentResolver = context.getContentResolver();
            final String[] strArr3 = {SocialConstDef.MEDIA_ITEM_DATE_ADDED, SocialConstDef.MEDIA_ITEM_DATE_MODIFIED};
            MediaScannerConnection.scanFile(context, strArr, strArr2, new OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    String str2 = str;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Cursor query = contentResolver.query(uri, strArr3, "_data = ?", new String[]{str2}, null);
                    if (query != null) {
                        if (query.moveToNext()) {
                            long j = query.getLong(0);
                            long j2 = query.getLong(1);
                            long j3 = 1;
                            String valueOf = String.valueOf(j);
                            String valueOf2 = String.valueOf(j2);
                            String valueOf3 = String.valueOf(currentTimeMillis);
                            if ((valueOf.length() > 1 && valueOf.length() - valueOf3.length() >= 2) || (valueOf2.length() > 1 && valueOf2.length() - valueOf3.length() >= 2)) {
                                j3 = 1000;
                            }
                            ContentValues contentValues = new ContentValues();
                            long j4 = (long) 86400;
                            if (Math.abs(j - currentTimeMillis) > j4) {
                                contentValues.put(SocialConstDef.MEDIA_ITEM_DATE_ADDED, Long.valueOf(currentTimeMillis * j3));
                            }
                            if (Math.abs(j2 - currentTimeMillis) > j4) {
                                contentValues.put(SocialConstDef.MEDIA_ITEM_DATE_MODIFIED, Long.valueOf(currentTimeMillis * j3));
                            }
                            if (contentValues.size() > 0) {
                                contentResolver.update(uri, contentValues, "_data = ?", new String[]{str2});
                            }
                        }
                        query.close();
                    }
                    if (onScanCompletedListener != null) {
                        onScanCompletedListener.onScanCompleted(str2, uri);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static String m11644b(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String locale2 = locale.toString();
        String[] split = locale2.split("_");
        if (split.length <= 2) {
            return locale2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
        sb.append("_");
        sb.append(split[1]);
        return sb.toString();
    }

    /* renamed from: bM */
    public static boolean m11645bM(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = (long) i2;
        boolean z = bKE == j;
        if (Math.abs(currentTimeMillis - bKD) < ((long) i) && z) {
            return true;
        }
        bKD = currentTimeMillis;
        bKE = j;
        return false;
    }

    /* renamed from: dA */
    public static boolean m11646dA(Context context) {
        if (context == null) {
            return true;
        }
        return m11659eE(m11651dx(context));
    }

    /* renamed from: dB */
    public static boolean m11647dB(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        String dx = m11651dx(context);
        if (dx.startsWith("10") && dx.endsWith("33")) {
            z = true;
        }
        return z;
    }

    /* renamed from: dC */
    public static boolean m11648dC(Context context) {
        return (VERSION.SDK_INT >= 17 ? System.getInt(context.getContentResolver(), "always_finish_activities", 0) : System.getInt(context.getContentResolver(), "always_finish_activities", 0)) == 1;
    }

    /* renamed from: dv */
    public static boolean m11649dv(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        String dx = m11651dx(context);
        boolean fakeGoogle = PerformanceServiceProxy.getFakeGoogle();
        if ((dx.startsWith("10") && (dx.endsWith("01") || dx.endsWith("GP") || dx.endsWith("38"))) || C8048e.aBe().mo23629Mu() || C8048e.aBe().mo23630Mv() || C8048e.aBe().mo23632Mx() || fakeGoogle) {
            z = true;
        }
        return z;
    }

    /* renamed from: dw */
    public static boolean m11650dw(Context context) {
        if (context == null) {
            return false;
        }
        return m11651dx(context).endsWith("24");
    }

    /* renamed from: dx */
    public static String m11651dx(Context context) {
        String str = "10000000";
        if (context == null) {
            return str;
        }
        if (bKG == null) {
            bKG = C5206b.m14212dV(context);
            if (TextUtils.isEmpty(bKG)) {
                bKG = str;
            }
        }
        return bKG;
    }

    /* renamed from: dy */
    public static String m11652dy(Context context) {
        String dx = m11651dx(context);
        return (TextUtils.isEmpty(dx) || dx.length() < 2) ? "00" : dx.substring(dx.length() - 2, dx.length());
    }

    /* renamed from: dz */
    public static String m11653dz(Context context) {
        String duid = DeviceUserProxy.getDuid();
        return !TextUtils.isEmpty(duid) ? duid : "";
    }

    /* renamed from: e */
    public static boolean m11654e(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        for (ResolveInfo resolveInfo : activity.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.applicationInfo.packageName.equals("com.diii.vending")) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent.setFlags(270532608);
                intent.setComponent(componentName);
                activity.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    @Deprecated
    /* renamed from: eA */
    public static String m11655eA(String str) {
        return str;
    }

    /* renamed from: eB */
    public static boolean m11656eB(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[0-9]+");
    }

    /* renamed from: eC */
    public static String m11657eC(String str) {
        String str2 = "";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str.substring(0, 4));
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(str.substring(5, 7));
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(str.substring(8, 10));
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            sb7.append(str.substring(11, 13));
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(sb8);
            sb9.append(str.substring(14, 16));
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            sb11.append(str.substring(17, 19));
            return sb11.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: eD */
    public static String m11658eD(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" ");
        return sb.toString();
    }

    /* renamed from: eE */
    private static boolean m11659eE(String str) {
        boolean z = true;
        if (str == null) {
            return true;
        }
        List W = m11639W(str, "^10\\d{4}(((O|H)\\d{1})|01)$");
        if (W == null || W.size() <= 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: eF */
    public static boolean m11660eF(String str) {
        return TextUtils.equals(Locale.getDefault().getLanguage(), str);
    }

    /* renamed from: eG */
    public static boolean m11661eG(String str) {
        return !TextUtils.isEmpty(str) && !str.startsWith(SocialService.CONST_URL_HTTP_PREFIX) && !str.startsWith("https://");
    }

    /* renamed from: ez */
    public static String m11662ez(String str) {
        return str;
    }

    /* renamed from: f */
    public static boolean m11663f(String str, long j) {
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
        if (m11640a(new Date(), date) <= j) {
            z = false;
        }
        return z;
    }

    /* renamed from: ig */
    public static boolean m11664ig(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - bKD) < ((long) i)) {
            return true;
        }
        bKD = currentTimeMillis;
        return false;
    }

    /* renamed from: ih */
    public static String m11665ih(int i) {
        String str;
        String str2 = "";
        if (i < 0) {
            i = 0;
        }
        int i2 = i / 100;
        if (i2 >= 36000) {
            try {
                str = String.format(Locale.US, "%02d:%02d:%02d.%1d", new Object[]{Integer.valueOf(i2 / 36000), Integer.valueOf((i2 % 36000) / 600), Integer.valueOf((i2 % 60) / 10), Integer.valueOf(i2 % 10)});
            } catch (Exception unused) {
            }
        } else {
            str = String.format(Locale.US, "%2d:%02d.%1d", new Object[]{Integer.valueOf((i2 % 36000) / 600), Integer.valueOf((i2 % 600) / 10), Integer.valueOf(i2 % 10)});
        }
        str2 = str;
        return str2.trim();
    }

    /* renamed from: qi */
    public static boolean m11666qi() {
        boolean z = false;
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        if (FZ == null) {
            return false;
        }
        if (!((FZ.getApplicationInfo().flags & 4194304) == 4194304)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Context applicationContext = FZ.getApplicationContext();
        ISettingRouter iSettingRouter = (ISettingRouter) C1919a.m5529sc().mo10356i(ISettingRouter.class);
        if (iSettingRouter != null) {
            locale = C4598j.m11732eK(iSettingRouter.getAppSettedLocaleModel(applicationContext).value);
        }
        if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
            z = true;
        }
        return z;
    }
}
