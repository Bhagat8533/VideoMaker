package com.introvd.template.app.utils;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ShortcutInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.filecache.FileCache;
import com.introvd.template.common.filecache.FileCache.Builder;
import com.introvd.template.crash.C5523b;
import com.introvd.template.p207c.C4613b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p055c.C1505b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.utils.e */
public class C4402e {
    /* renamed from: Z */
    public static boolean m11113Z(Context context, String str) {
        boolean z = true;
        if (m11123dh(context)) {
            return true;
        }
        try {
            String aa = m11116aa(context, "com.diii.launcher.permission.READ_SETTINGS");
            StringBuilder sb = new StringBuilder();
            sb.append("content://");
            sb.append(aa);
            sb.append("/favorites?notify=true");
            Cursor query = context.getContentResolver().query(Uri.parse(sb.toString()), new String[]{"title"}, "title=?", new String[]{str}, null);
            if (query == null || query.getCount() <= 0) {
                z = false;
            }
            if (query != null) {
                query.close();
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m11114a(Context context, String str, int i, String str2, String str3) {
        if (VERSION.SDK_INT >= 26) {
            C4613b.m11765e(context, Arrays.asList(new ShortcutInfo[]{C4613b.m11764b(context, new Intent(str), i, str3, str2, str2).toShortcutInfo()}));
        }
    }

    /* renamed from: a */
    public static void m11115a(Context context, String str, String str2, int i, String str3) {
        if (VERSION.SDK_INT < 26 || C4613b.m11763at(context, "SHORT_CUT_MV") || !C4613b.isRequestPinShortcutSupported(context)) {
            m11118b(context, str, str2, i, str3);
            return;
        }
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        C4613b.m11762a(context, intent, i, "SHORT_CUT_MV", str3, str3);
    }

    /* renamed from: aa */
    private static String m11116aa(Context context, String str) {
        List<PackageInfo> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            list = context.getPackageManager().getInstalledPackages(8);
        } catch (Exception e) {
            C5523b.logException(e);
            list = null;
        }
        if (list == null) {
            return null;
        }
        for (PackageInfo packageInfo : list) {
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (str.equals(providerInfo.readPermission) || str.equals(providerInfo.writePermission)) {
                        return providerInfo.authority;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* renamed from: ab */
    public static void m11117ab(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("BRAND", Build.BRAND);
            hashMap.put("HARDWARE", Build.HARDWARE);
            hashMap.put("MODEL", Build.MODEL);
            UserBehaviorLog.onKVEvent(context, str, hashMap);
        }
    }

    /* renamed from: b */
    private static boolean m11118b(final Context context, String str, String str2, int i, final String str3) {
        if (context == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        final FileCache build = new Builder(context, Map.class).setCacheKey("ShortCutFileCacheName").setFileSaveInternal(false).build();
        C1834l f = C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Map>() {
            /* renamed from: l */
            public Map apply(Boolean bool) {
                Map map = (Map) build.getCacheSync();
                return map == null ? new HashMap() : map;
            }
        });
        final String str4 = str2;
        final String str5 = str;
        final String str6 = str3;
        final Context context2 = context;
        final int i2 = i;
        C44053 r1 = new C1517e<Map>() {
            /* renamed from: G */
            public void accept(Map map) {
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                sb.append(str5);
                String sb2 = sb.toString();
                if (map == null || !map.containsKey(sb2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(">>>>>>add doOnNext run");
                    sb3.append(Thread.currentThread().getName());
                    LogUtilsV2.m14228e(sb3.toString());
                    C4402e.m11117ab(context2.getApplicationContext(), "Intent_Launch_Icon_Add");
                    C4402e.m11119c(context2, str5, str4, i2, str6);
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(sb2, str6);
                    build.saveCache(map);
                    return;
                }
                if (!TextUtils.equals(str6, (String) map.get(sb2))) {
                    C4402e.m11123dh(context2);
                }
                throw C1505b.m4703z(new Throwable("no need create shortcut."));
            }
        };
        f.mo10161e((C1517e<? super T>) r1).mo10164f(10, TimeUnit.SECONDS).mo10161e((C1517e<? super T>) new C1517e<Map>() {
            /* renamed from: G */
            public void accept(Map map) {
                StringBuilder sb = new StringBuilder();
                sb.append(">>>>>>checkExist doOnNext run");
                sb.append(Thread.currentThread().getName());
                LogUtilsV2.m14228e(sb.toString());
                boolean Z = C4402e.m11113Z(context, str3);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(">>>>>> exist=");
                sb2.append(Z);
                LogUtilsV2.m14228e(sb2.toString());
                if (Z) {
                    C4402e.m11117ab(context, "Intent_Launch_Icon_Exist");
                }
            }
        }).mo10149b((C1842q<? super T>) new C1842q<Map>() {
            /* renamed from: F */
            public void mo9886K(Map map) {
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m11119c(Context context, String str, String str2, int i, String str3) {
        Intent intent = new Intent("com.diii.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str3);
        intent.putExtra("duplicate", false);
        if (str2 == null) {
            str2 = context.getClass().getName();
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", m11124i(context, str, str2));
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, i));
        context.sendBroadcast(intent);
    }

    /* renamed from: c */
    public static void m11120c(Context context, String str, String str2, String str3) {
        Intent intent = new Intent("com.diii.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str3);
        if (str2 == null) {
            str2 = context.getClass().getName();
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", m11124i(context, str, str2));
        context.sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: dh */
    public static boolean m11123dh(Context context) {
        return m11116aa(context, "com.diii.launcher.permission.READ_SETTINGS") == null;
    }

    /* renamed from: i */
    private static Intent m11124i(Context context, String str, String str2) {
        Intent intent = new Intent();
        if (TextUtils.isEmpty(str)) {
            intent.setPackage(context.getPackageName());
            intent.setClassName(context.getPackageName(), str2);
        } else {
            intent.setAction(str);
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(603996160);
        }
        return intent;
    }
}
