package com.introvd.template.p207c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.support.p021v4.content.p022pm.ShortcutInfoCompat;
import android.support.p021v4.content.p022pm.ShortcutInfoCompat.Builder;
import android.support.p021v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import com.introvd.template.crash.C5523b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.c.b */
public class C4613b {
    /* renamed from: a */
    public static void m11762a(Context context, Intent intent, int i, String str, String str2, String str3) {
        if (context != null && intent != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            if (shortcutManager.isRequestPinShortcutSupported()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                shortcutManager.enableShortcuts(arrayList);
                try {
                    shortcutManager.requestPinShortcut(m11764b(context, intent, i, str, str2, str3).toShortcutInfo(), null);
                } catch (IllegalStateException e) {
                    C5523b.logException(e);
                }
            }
        }
    }

    /* renamed from: at */
    public static boolean m11763at(Context context, String str) {
        for (ShortcutInfo id : ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getPinnedShortcuts()) {
            if (id.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static ShortcutInfoCompat m11764b(Context context, Intent intent, int i, String str, String str2, String str3) {
        return new Builder(context, str).setShortLabel(str2).setLongLabel(str3).setIcon(IconCompat.createWithResource(context, i)).setIntent(intent).build();
    }

    /* renamed from: e */
    public static void m11765e(Context context, List<ShortcutInfo> list) {
        if (context != null && list != null) {
            try {
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(list);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean isRequestPinShortcutSupported(Context context) {
        return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    }
}
