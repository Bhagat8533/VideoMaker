package com.introvd.template.template.data.p406db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.TemplateDataDao;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.data.api.model.TemplateResponseRoll;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.template.data.db.c */
public class C8690c {
    /* renamed from: a */
    public static int m25285a(ContentResolver contentResolver, Uri uri, String str) {
        if (contentResolver == null || uri == null) {
            return 0;
        }
        return contentResolver.delete(uri, "tcid = ?", new String[]{str});
    }

    /* renamed from: a */
    public static int m25286a(ContentResolver contentResolver, Uri uri, String str, String str2) {
        return contentResolver.delete(uri, "tcid = ? AND subtcid = ?", new String[]{str, str2});
    }

    /* renamed from: a */
    public static int m25287a(ContentResolver contentResolver, Uri uri, List<TemplateResponseRoll> list) {
        String str;
        ContentResolver contentResolver2 = contentResolver;
        Uri uri2 = uri;
        List<TemplateResponseRoll> list2 = list;
        if (contentResolver2 == null || uri2 == null || list2 == null) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            ContentValues contentValues = new ContentValues();
            TemplateResponseRoll templateResponseRoll = (TemplateResponseRoll) list2.get(i);
            String str2 = templateResponseRoll.index;
            String str3 = templateResponseRoll.categoryIndex;
            String str4 = templateResponseRoll.subCategoryIndex;
            String str5 = templateResponseRoll.engineVersion;
            String str6 = templateResponseRoll.downloadUrl;
            String str7 = templateResponseRoll.language;
            String str8 = templateResponseRoll.price;
            String str9 = templateResponseRoll.wordInfo;
            try {
                str = new Gson().toJson((Object) templateResponseRoll.imageInfoJson);
            } catch (Exception unused) {
                str = "";
            }
            String str10 = templateResponseRoll.order;
            int i2 = size;
            String str11 = templateResponseRoll.newFlag;
            int i3 = templateResponseRoll.isShow;
            int i4 = i;
            contentValues.put("code", str2);
            contentValues.put("tcid", str3);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_ENGINEVER, str5);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_DOWNURL, str6);
            contentValues.put("lang", str7);
            contentValues.put("price", str8);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_WORDINFO, str9);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_XYTINFO, str);
            contentValues.put("orderno", str10);
            contentValues.put("newflag", str11);
            contentValues.put("subtype", str4);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_ISSHOW, Integer.valueOf(i3));
            if (contentResolver2.update(uri2, contentValues, "code=?", new String[]{str2}) <= 0) {
                contentResolver2.insert(uri2, contentValues);
            }
            i = i4 + 1;
            size = i2;
            list2 = list;
        }
        return 0;
    }

    /* renamed from: a */
    public static ContentValues m25288a(TemplateResponseInfo templateResponseInfo) {
        if (templateResponseInfo == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        String str = templateResponseInfo.categoryIndex;
        String str2 = templateResponseInfo.index;
        String str3 = templateResponseInfo.sceneName;
        String str4 = templateResponseInfo.sceneIndex;
        String str5 = templateResponseInfo.sceneIcon;
        contentValues.put("tcid", str);
        contentValues.put("ttid", str2);
        contentValues.put("scene", str3);
        contentValues.put("scene_code", str4);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_SCENE_ICON, str5);
        String str6 = templateResponseInfo.engineVersion;
        String str7 = templateResponseInfo.name;
        String str8 = templateResponseInfo.description;
        String str9 = templateResponseInfo.thumbUrl;
        String str10 = templateResponseInfo.previewUrl;
        contentValues.put("ver", str6);
        contentValues.put("title", str7);
        contentValues.put("intro", str8);
        contentValues.put("icon", str9);
        contentValues.put("previewurl", str10);
        contentValues.put("previewtype", templateResponseInfo.previewType);
        contentValues.put("lang", templateResponseInfo.language);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_MARK, templateResponseInfo.bitFlag);
        contentValues.put("appminver", templateResponseInfo.minSupportVersion);
        contentValues.put("size", templateResponseInfo.fileSize);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_AUTHORID, templateResponseInfo.authorId);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_AUTHORNAME, templateResponseInfo.authorName);
        contentValues.put("publishtime", templateResponseInfo.publishTime);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_LIKECOUNT, templateResponseInfo.favorTimes);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_DOWNCOUNT, templateResponseInfo.downloadTimes);
        contentValues.put("points", templateResponseInfo.scoreToDownload);
        if (templateResponseInfo.appEventType != null) {
            contentValues.put("mission", new Gson().toJson((JsonElement) templateResponseInfo.appEventType));
        }
        contentValues.put("duration", templateResponseInfo.duration);
        contentValues.put("url", templateResponseInfo.downloadUrl);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG, templateResponseInfo.audioFlag);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_SUBTCID, templateResponseInfo.subtcid);
        return contentValues;
    }

    /* renamed from: a */
    public static ContentValues m25289a(TemplateResponseInfo templateResponseInfo, long j) {
        if (templateResponseInfo == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        String str = templateResponseInfo.categoryIndex;
        String str2 = templateResponseInfo.index;
        String str3 = templateResponseInfo.sceneName;
        String str4 = templateResponseInfo.sceneIndex;
        String str5 = templateResponseInfo.sceneIcon;
        contentValues.put("orderno", templateResponseInfo.order);
        contentValues.put("updatetime", Long.valueOf(j));
        contentValues.put("ttid", str2);
        contentValues.put("tcid", str);
        contentValues.put(SocialConstDef.TEMPLATE_INFO_SCENE_CODE, str4);
        contentValues.put(SocialConstDef.TEMPLATE_INFO_SCENE_NAME, str3);
        contentValues.put(SocialConstDef.TEMPLATE_INFO_SCENE_ICON, str5);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG, templateResponseInfo.audioFlag);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_SUBTCID, templateResponseInfo.subtcid);
        return contentValues;
    }

    /* renamed from: b */
    public static int m25290b(ContentResolver contentResolver, Uri uri, String str) {
        return contentResolver.delete(uri, "tcid = ?", new String[]{str});
    }

    /* renamed from: b */
    public static int m25291b(ContentResolver contentResolver, Uri uri, List<TemplateResponseRoll> list) {
        int i;
        String str;
        ContentResolver contentResolver2 = contentResolver;
        Uri uri2 = uri;
        List<TemplateResponseRoll> list2 = list;
        if (contentResolver2 == null || uri2 == null || list2 == null) {
            return 0;
        }
        int size = list.size();
        ContentValues[] contentValuesArr = new ContentValues[size];
        int i2 = 0;
        while (i2 < size) {
            ContentValues contentValues = new ContentValues();
            TemplateResponseRoll templateResponseRoll = (TemplateResponseRoll) list2.get(i2);
            String str2 = templateResponseRoll.index;
            String str3 = templateResponseRoll.categoryIndex;
            String str4 = templateResponseRoll.subCategoryIndex;
            String str5 = templateResponseRoll.engineVersion;
            String str6 = templateResponseRoll.downloadUrl;
            String str7 = templateResponseRoll.language;
            String str8 = templateResponseRoll.price;
            String str9 = templateResponseRoll.wordInfo;
            if (templateResponseRoll.imageInfoJson != null) {
                i = size;
                str = new Gson().toJson((Object) templateResponseRoll.imageInfoJson);
            } else {
                i = size;
                str = "";
            }
            String str10 = templateResponseRoll.order;
            String str11 = templateResponseRoll.newFlag;
            int i3 = templateResponseRoll.isShow;
            contentValues.put("code", str2);
            contentValues.put("tcid", str3);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_ENGINEVER, str5);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_DOWNURL, str6);
            contentValues.put("lang", str7);
            contentValues.put("price", str8);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_WORDINFO, str9);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_XYTINFO, str);
            contentValues.put("orderno", str10);
            contentValues.put("newflag", str11);
            contentValues.put("subtype", str4);
            contentValues.put(SocialConstDef.TEMPLATE_ROLL_ISSHOW, Integer.valueOf(i3));
            contentValuesArr[i2] = contentValues;
            i2++;
            size = i;
            contentResolver2 = contentResolver;
            uri2 = uri;
            list2 = list;
        }
        try {
            contentResolver2.bulkInsert(uri2, contentValuesArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    /* renamed from: c */
    public static int m25292c(ContentResolver contentResolver, Uri uri, List<TemplateResponseInfo> list) {
        long currentTimeMillis = System.currentTimeMillis();
        int size = list.size();
        ContentValues[] contentValuesArr = new ContentValues[size];
        for (int i = 0; i < size; i++) {
            ContentValues a = m25289a((TemplateResponseInfo) list.get(i), currentTimeMillis);
            if (a != null) {
                contentValuesArr[i] = a;
            }
        }
        try {
            contentResolver.bulkInsert(uri, contentValuesArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    /* renamed from: g */
    public static int m25293g(Context context, List<TemplateResponseRoll> list) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_MONETIZATION);
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            TemplateResponseRoll templateResponseRoll = (TemplateResponseRoll) list.get(i);
            String str = templateResponseRoll.index;
            if (!TextUtils.isEmpty(str)) {
                String str2 = templateResponseRoll.categoryIndex;
                String str3 = templateResponseRoll.event;
                if (!m25296pd(str3)) {
                    int delete = contentResolver.delete(tableUri, "ttid = ?", new String[]{str});
                    StringBuilder sb = new StringBuilder();
                    sb.append("updateTemplateLockInfo delcount=");
                    sb.append(delete);
                    LogUtilsV2.m14228e(sb.toString());
                } else {
                    ContentValues updateTemplateLockInfo = updateTemplateLockInfo(contentResolver, str2, str, str3, "", "", "", "", "");
                    if (updateTemplateLockInfo != null) {
                        arrayList.add(updateTemplateLockInfo);
                    }
                }
            }
        }
        try {
            if (arrayList.size() > 0) {
                contentResolver.bulkInsert(tableUri, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    /* renamed from: h */
    public static int m25294h(Context context, List<TemplateResponseInfo> list) {
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
        ContentResolver contentResolver = context.getContentResolver();
        int size = list.size();
        ContentValues[] contentValuesArr = new ContentValues[size];
        for (int i = 0; i < size; i++) {
            ContentValues a = m25288a((TemplateResponseInfo) list.get(i));
            if (a != null) {
                contentValuesArr[i] = a;
            }
        }
        try {
            contentResolver.bulkInsert(tableUri, contentValuesArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    /* renamed from: i */
    public static int m25295i(Context context, List<TemplateResponseInfo> list) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_MONETIZATION);
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        char c = 0;
        int i = 0;
        while (i < size) {
            TemplateResponseInfo templateResponseInfo = (TemplateResponseInfo) list.get(i);
            String str = templateResponseInfo.index;
            String str2 = templateResponseInfo.categoryIndex;
            String str3 = templateResponseInfo.eventExtra;
            String str4 = templateResponseInfo.name;
            String str5 = templateResponseInfo.description;
            String str6 = templateResponseInfo.thumbUrl;
            String str7 = templateResponseInfo.previewUrl;
            if (!m25296pd(str3)) {
                String[] strArr = new String[1];
                strArr[c] = str;
                int delete = contentResolver.delete(tableUri, "ttid = ?", strArr);
                StringBuilder sb = new StringBuilder();
                sb.append("updateTemplateLockInfo delcount=");
                sb.append(delete);
                LogUtilsV2.m14228e(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(templateResponseInfo.previewType);
                ContentValues updateTemplateLockInfo = TemplateDataDao.updateTemplateLockInfo(contentResolver, str2, str, str3, sb2.toString(), str7, str4, str5, str6);
                if (updateTemplateLockInfo != null) {
                    arrayList.add(updateTemplateLockInfo);
                }
            }
            i++;
            c = 0;
        }
        try {
            if (arrayList.size() > 0) {
                int bulkInsert = contentResolver.bulkInsert(tableUri, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("updateTemplateLockInfo count=");
                sb3.append(bulkInsert);
                LogUtilsV2.m14230i(sb3.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    /* renamed from: pd */
    private static boolean m25296pd(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (new JSONObject(str).optInt("code") > 0) {
                z = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.ContentValues updateTemplateLockInfo(android.content.ContentResolver r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            r1 = r13
            r2 = r15
            r0 = r16
            r3 = r18
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "updateTemplateLockInfo strEvent="
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.introvd.template.common.LogUtilsV2.m14230i(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "updateTemplateLockInfo ttid="
            r4.append(r5)
            r4.append(r15)
            java.lang.String r5 = ";prevUrl="
            r4.append(r5)
            r4.append(r3)
            java.lang.String r5 = ";"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.introvd.template.common.LogUtilsV2.m14230i(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r16)
            r5 = 0
            if (r4 == 0) goto L_0x0043
            return r5
        L_0x0043:
            java.lang.String r4 = "0"
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006a }
            r8.<init>(r0)     // Catch:{ JSONException -> 0x006a }
            java.lang.String r0 = "code"
            java.lang.String r9 = r8.optString(r0)     // Catch:{ JSONException -> 0x006a }
            java.lang.String r0 = "parameter"
            org.json.JSONObject r0 = r8.getJSONObject(r0)     // Catch:{ JSONException -> 0x0068 }
            java.lang.String r4 = "expire_time"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x0068 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0066 }
            r7 = r0
            goto L_0x0070
        L_0x0066:
            r0 = move-exception
            goto L_0x006d
        L_0x0068:
            r0 = move-exception
            goto L_0x006c
        L_0x006a:
            r0 = move-exception
            r9 = r4
        L_0x006c:
            r4 = r6
        L_0x006d:
            r0.printStackTrace()
        L_0x0070:
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 != 0) goto L_0x0133
            r6 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0091 }
            if (r0 != 0) goto L_0x0083
            int r0 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0091 }
            r8 = r0
            goto L_0x0084
        L_0x0083:
            r8 = 0
        L_0x0084:
            boolean r0 = android.text.TextUtils.isEmpty(r17)     // Catch:{ Exception -> 0x008f }
            if (r0 != 0) goto L_0x0096
            int r0 = java.lang.Integer.parseInt(r17)     // Catch:{ Exception -> 0x008f }
            goto L_0x0097
        L_0x008f:
            r0 = move-exception
            goto L_0x0093
        L_0x0091:
            r0 = move-exception
            r8 = 0
        L_0x0093:
            r0.printStackTrace()
        L_0x0096:
            r0 = 0
        L_0x0097:
            r9 = 1
            if (r8 > 0) goto L_0x00aa
            java.lang.String r0 = "TemplateMonetization"
            android.net.Uri r0 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r0)
            java.lang.String r3 = "ttid = ?"
            java.lang.String[] r4 = new java.lang.String[r9]
            r4[r6] = r2
            r13.delete(r0, r3, r4)
            return r5
        L_0x00aa:
            if (r4 != 0) goto L_0x00ae
            java.lang.String r4 = ""
        L_0x00ae:
            android.content.ContentValues r10 = new android.content.ContentValues
            r10.<init>()
            java.lang.String r11 = "tcid"
            r12 = r14
            r10.put(r11, r14)
            java.lang.String r11 = "ttid"
            r10.put(r11, r15)
            java.lang.String r11 = "todocode"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r10.put(r11, r8)
            java.lang.String r8 = "todocontent"
            r10.put(r8, r7)
            java.lang.String r7 = "expiretime"
            r10.put(r7, r4)
            java.lang.String r4 = "previewtype"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10.put(r4, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r19)
            if (r0 != 0) goto L_0x00e7
            java.lang.String r0 = "title"
            r4 = r19
            r10.put(r0, r4)
        L_0x00e7:
            boolean r0 = android.text.TextUtils.isEmpty(r20)
            if (r0 != 0) goto L_0x00f4
            java.lang.String r0 = "intro"
            r4 = r20
            r10.put(r0, r4)
        L_0x00f4:
            boolean r0 = android.text.TextUtils.isEmpty(r21)
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = "iconurl"
            r4 = r21
            r10.put(r0, r4)
        L_0x0101:
            boolean r0 = android.text.TextUtils.isEmpty(r18)
            if (r0 != 0) goto L_0x010c
            java.lang.String r0 = "previewurl"
            r10.put(r0, r3)
        L_0x010c:
            java.lang.String r0 = "TemplateMonetization"
            android.net.Uri r0 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r0)
            java.lang.String r3 = "ttid = ?"
            java.lang.String[] r4 = new java.lang.String[r9]
            r4[r6] = r2
            int r0 = r13.update(r0, r10, r3, r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateTemplateLockInfo updateCount="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.introvd.template.common.LogUtilsV2.m14230i(r1)
            if (r0 > 0) goto L_0x0133
            return r10
        L_0x0133:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.data.p406db.C8690c.updateTemplateLockInfo(android.content.ContentResolver, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.ContentValues");
    }
}
