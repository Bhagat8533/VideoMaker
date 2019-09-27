package com.introvd.template.p414ui.dialog;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.introvd.template.p207c.C4612a;
import com.introvd.template.p414ui.dialog.C8945c.C8948b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.ui.dialog.e */
public class C8957e {
    /* renamed from: a */
    public static ArrayList<C8965h> m26314a(List<ResolveInfo> list, PackageManager packageManager) {
        ArrayList<C8965h> arrayList = new ArrayList<>();
        for (ResolveInfo resolveInfo : list) {
            C8965h hVar = new C8965h();
            hVar.dUD = -1;
            hVar.exo = resolveInfo.loadIcon(packageManager);
            hVar.exp = resolveInfo.loadLabel(packageManager);
            arrayList.add(hVar);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m26315a(Activity activity, String str, String str2, String str3, int[] iArr) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(activity.getApplicationContext().getPackageName());
        return m26316a(activity, str, str2, str3, iArr, arrayList);
    }

    /* renamed from: a */
    public static boolean m26316a(final Activity activity, String str, String str2, String str3, int[] iArr, List<String> list) {
        if (activity == null || activity.isFinishing() || iArr == null || iArr.length < 1) {
            return false;
        }
        final Intent intent = new Intent(str);
        C4612a.m11759a(intent, str3, new File(str2), true);
        PackageManager packageManager = activity.getPackageManager();
        final List d = m26317d(packageManager.queryIntentActivities(intent, 65536), list);
        ArrayList a = m26314a(d, packageManager);
        if (a.size() <= 0) {
            return false;
        }
        if (a.size() == 1) {
            ResolveInfo resolveInfo = (ResolveInfo) d.get(0);
            if (!(resolveInfo == null || resolveInfo.activityInfo == null)) {
                intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                activity.startActivity(intent);
            }
            return true;
        }
        C8945c cVar = new C8945c(activity, a, new C8948b() {
            public void buttonClick(int i) {
            }

            public void itemClick(int i) {
                ResolveInfo resolveInfo = (ResolveInfo) d.get(i);
                if (resolveInfo != null && resolveInfo.activityInfo != null) {
                    intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                    activity.startActivity(intent);
                }
            }
        });
        cVar.setButtonText(iArr[0]);
        cVar.show();
        return true;
    }

    /* renamed from: d */
    public static List<ResolveInfo> m26317d(List<ResolveInfo> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (ResolveInfo resolveInfo : list) {
                String str = resolveInfo.activityInfo.packageName;
                if (list2 == null || !list2.contains(str)) {
                    arrayList.add(resolveInfo);
                }
            }
        }
        return arrayList;
    }
}
