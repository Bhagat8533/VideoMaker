package com.introvd.template.component.videofetcher.utils;

import android.content.Context;
import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.introvd.template.component.videofetcher.utils.k */
public class C5497k {
    private static final List<String> ciO = Arrays.asList(new String[]{"ANE-AL00", "ANE-TL00", "PADM00", "vivo Y83A", "Redmi 6 Pro", "MI 8", "MI 8 SE", "MI8 Explorer Edition", "Nokia X6", "X6"});

    /* renamed from: ei */
    private static boolean m14919ei(Context context) {
        String str;
        StringBuilder sb;
        try {
            Class loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            boolean booleanValue = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("hasNotchInScreen ret=");
            sb2.append(booleanValue);
            C5489g.m14903e("ruomiz", sb2.toString());
            return booleanValue;
        } catch (ClassNotFoundException unused) {
            str = "ruomiz";
            sb = new StringBuilder();
            sb.append("hasNotchInScreen ret=");
            sb.append(false);
            C5489g.m14903e(str, sb.toString());
            return false;
        } catch (NoSuchMethodException unused2) {
            str = "ruomiz";
            sb = new StringBuilder();
            sb.append("hasNotchInScreen ret=");
            sb.append(false);
            C5489g.m14903e(str, sb.toString());
            return false;
        } catch (Exception unused3) {
            str = "ruomiz";
            sb = new StringBuilder();
            sb.append("hasNotchInScreen ret=");
            sb.append(false);
            C5489g.m14903e(str, sb.toString());
            return false;
        } catch (Throwable unused4) {
            str = "ruomiz";
            sb = new StringBuilder();
            sb.append("hasNotchInScreen ret=");
            sb.append(false);
            C5489g.m14903e(str, sb.toString());
            return false;
        }
    }

    /* renamed from: em */
    public static boolean m14920em(Context context) {
        return ciO.contains(Build.MODEL) || m14919ei(context) || hasNotchAtOPPO(context) || hasNotchAtVivo(context);
    }

    public static boolean hasNotchAtOPPO(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Exception unused) {
            C5489g.m14903e("Notch", "hasNotchAtOPPO Exception");
        } catch (Throwable unused2) {
        }
        return false;
    }

    public static boolean hasNotchAtVivo(Context context) {
        try {
            Class loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue();
        } catch (ClassNotFoundException unused) {
            C5489g.m14903e("Notch", "hasNotchAtVivo ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            C5489g.m14903e("Notch", "hasNotchAtVivo NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            C5489g.m14903e("Notch", "hasNotchAtVivo Exception");
            return false;
        } catch (Throwable unused4) {
            return false;
        }
    }
}
