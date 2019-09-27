package com.introvd.template.editor.slideshow.p278a;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.introvd.template.editor.slideshow.a.c */
public class C6740c {
    /* renamed from: a */
    public static void m19582a(Context context, int i, Map<Integer, Map<Integer, TrimedClipItemDataModel>> map) {
        for (int i2 = 0; i2 < i; i2++) {
            Map map2 = (Map) map.get(Integer.valueOf(i2));
            if (map2 != null) {
                for (TrimedClipItemDataModel trimedClipItemDataModel : map2.values()) {
                    m19585f(context, i2 + 1, trimedClipItemDataModel.isImage.booleanValue() ? "图片" : "视频");
                }
            }
        }
    }

    /* renamed from: bP */
    public static void m19583bP(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        UserBehaviorLog.onKVEvent(context, "Click_Template_PreviewBtn", hashMap);
    }

    /* renamed from: bQ */
    public static void m19584bQ(Context context, String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("Name", str);
        }
        UserBehaviorLog.onKVEvent(context, "Pageview_Template", hashMap);
    }

    /* renamed from: f */
    private static void m19585f(Context context, int i, String str) {
        String format = String.format(Locale.US, "Click_Template_Module%d_Add", new Object[]{Integer.valueOf(i)});
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, format, hashMap);
    }

    /* renamed from: ft */
    public static void m19586ft(Context context) {
        UserBehaviorLog.onKVEvent(context, "Click_Template_DeleteBtn", new HashMap());
    }

    /* renamed from: g */
    public static void m19587g(Context context, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", String.valueOf(j));
        UserBehaviorLog.onKVEvent(context, "Click_Template_SaveToDraft", hashMap);
    }
}
