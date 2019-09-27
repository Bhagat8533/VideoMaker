package com.introvd.template.picker.p369d;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.picker.R;
import com.introvd.template.xyui.ripple.MaterialRippleLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.picker.d.c */
public class C8219c {
    private static long bKD;

    /* renamed from: Sf */
    public static boolean m23735Sf() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - bKD) < 500) {
            return true;
        }
        bKD = currentTimeMillis;
        return false;
    }

    /* renamed from: c */
    public static List<String> m23736c(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        if (list2.size() > list.size()) {
            List<String> list3 = list2;
            list2 = list;
            list = list3;
        }
        HashMap hashMap = new HashMap(list.size());
        for (String put : list) {
            hashMap.put(put, Integer.valueOf(1));
        }
        for (String str : list2) {
            if (hashMap.get(str) != null) {
                hashMap.put(str, Integer.valueOf(2));
            } else {
                arrayList.add(str);
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == 1) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    /* renamed from: dn */
    public static void m23737dn(View view) {
        MaterialRippleLayout.m26682dp(view).mo36192vU(view.getContext().getResources().getColor(R.color.black)).mo36189aW(0.3f).mo36191jS(true).mo36190jR(true).aOe();
    }

    /* renamed from: f */
    public static void m23738f(final Context context, final List<String> list) {
        C1834l.m5254a((C1839n<T>) new C1839n<Void>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Void> mVar) {
                for (String str : list) {
                    if (!TextUtils.isEmpty(str)) {
                        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_MEDIA_ITEM);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("flag", Integer.valueOf(0));
                        context.getApplicationContext().getContentResolver().update(tableUri, contentValues, "_data = ?", new String[]{str});
                    }
                }
            }
        }).mo10157d(C1820a.aVi()).aTR();
    }
}
