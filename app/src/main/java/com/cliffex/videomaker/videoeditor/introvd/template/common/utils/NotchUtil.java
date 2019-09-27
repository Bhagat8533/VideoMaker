package com.introvd.template.common.utils;

import android.content.Context;
import android.os.Build;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import java.util.Arrays;
import java.util.List;

public class NotchUtil {
    private static final List<String> ciO = Arrays.asList(new String[]{"ANE-AL00", "ANE-TL00", "PADM00", "vivo Y83A", "Redmi 6 Pro", "MI 8", "MI 8 SE", "MI8 Explorer Edition", "Nokia X6", "X6", "Lenovo L78011"});

    /* renamed from: ei */
    private static boolean m14568ei(Context context) {
        StringBuilder sb;
        try {
            Class loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            boolean booleanValue = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("hasNotchInScreen ret=");
            sb2.append(booleanValue);
            LogUtilsV2.m14228e(sb2.toString());
            return booleanValue;
        } catch (ClassNotFoundException unused) {
            sb = new StringBuilder();
            sb.append("hasNotchInScreen ret=");
            sb.append(false);
            LogUtilsV2.m14228e(sb.toString());
            return false;
        } catch (NoSuchMethodException unused2) {
            sb = new StringBuilder();
            sb.append("hasNotchInScreen ret=");
            sb.append(false);
            LogUtilsV2.m14228e(sb.toString());
            return false;
        } catch (Exception unused3) {
            sb = new StringBuilder();
            sb.append("hasNotchInScreen ret=");
            sb.append(false);
            LogUtilsV2.m14228e(sb.toString());
            return false;
        } catch (Throwable unused4) {
            sb = new StringBuilder();
            sb.append("hasNotchInScreen ret=");
            sb.append(false);
            LogUtilsV2.m14228e(sb.toString());
            return false;
        }
    }

    public static boolean hasNotchAtOPPO(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Exception unused) {
            LogUtils.m14222e("Notch", "hasNotchAtOPPO Exception");
        } catch (Throwable unused2) {
        }
        return false;
    }

    public static boolean hasNotchAtVivo(Context context) {
        try {
            Class loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue();
        } catch (ClassNotFoundException unused) {
            LogUtils.m14222e("Notch", "hasNotchAtVivo ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            LogUtils.m14222e("Notch", "hasNotchAtVivo NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            LogUtils.m14222e("Notch", "hasNotchAtVivo Exception");
            return false;
        } catch (Throwable unused4) {
            return false;
        }
    }

    public static boolean isNotchDevice() {
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        return ciO.contains(Build.MODEL) || m14568ei(FZ) || hasNotchAtOPPO(FZ) || hasNotchAtVivo(FZ);
    }
}
