package com.introvd.template.datacenter;

import android.content.ContentValues;
import com.introvd.template.C4677g;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import org.json.JSONObject;

public class TemplateDataDao {
    private static final String TAG = "TemplateDataDao";

    public static ContentValues getTemplateCardContentValues(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        String optString = jSONObject.optString("c");
        String optString2 = jSONObject.optString(C5878a.TAG);
        String optString3 = jSONObject.optString("m");
        String optString4 = jSONObject.optString("m1");
        String optString5 = jSONObject.optString("sceneIcon");
        jSONObject.optString("w");
        contentValues.put("tcid", optString);
        contentValues.put("ttid", optString2);
        contentValues.put("scene", optString3);
        contentValues.put("scene_code", optString4);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_SCENE_ICON, optString5);
        String optString6 = jSONObject.optString(C7234b.TAG);
        String optString7 = jSONObject.optString("d");
        String optString8 = jSONObject.optString("e");
        String optString9 = jSONObject.optString("f");
        String optString10 = jSONObject.optString(C4677g.TAG);
        int optInt = jSONObject.optInt("h");
        String optString11 = jSONObject.optString("i");
        contentValues.put("ver", optString6);
        contentValues.put("title", optString7);
        contentValues.put("intro", optString8);
        contentValues.put("icon", optString9);
        contentValues.put("previewurl", optString10);
        contentValues.put("previewtype", Integer.valueOf(optInt));
        contentValues.put("lang", optString11);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_MARK, Integer.valueOf(jSONObject.optInt("j")));
        contentValues.put("appminver", jSONObject.optString("k"));
        contentValues.put("size", jSONObject.optString("l"));
        contentValues.put(SocialConstDef.TEMPLATE_CARD_AUTHORID, jSONObject.optString("n"));
        contentValues.put(SocialConstDef.TEMPLATE_CARD_AUTHORNAME, jSONObject.optString("o"));
        contentValues.put("publishtime", jSONObject.optString(TtmlNode.TAG_P));
        contentValues.put(SocialConstDef.TEMPLATE_CARD_LIKECOUNT, jSONObject.optString("q"));
        contentValues.put(SocialConstDef.TEMPLATE_CARD_DOWNCOUNT, jSONObject.optString("r"));
        contentValues.put("points", jSONObject.optString("t"));
        contentValues.put("mission", jSONObject.optString("u"));
        contentValues.put("duration", jSONObject.optString("v"));
        contentValues.put("url", jSONObject.optString("x"));
        contentValues.put(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG, Integer.valueOf(jSONObject.optInt(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG)));
        contentValues.put(SocialConstDef.TEMPLATE_CARD_SUBTCID, jSONObject.optString(SocialConstDef.TEMPLATE_CARD_SUBTCID));
        return contentValues;
    }

    public static ContentValues getTemplateInfoContentValues(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        String optString = jSONObject.optString("c");
        String optString2 = jSONObject.optString(C5878a.TAG);
        String optString3 = jSONObject.optString("m");
        String optString4 = jSONObject.optString("m1");
        String optString5 = jSONObject.optString("sceneIcon");
        jSONObject.optString("w");
        contentValues.put("orderno", Integer.valueOf(jSONObject.optInt("s", 0)));
        contentValues.put("updatetime", Long.valueOf(j));
        contentValues.put("ttid", optString2);
        contentValues.put("tcid", optString);
        contentValues.put(SocialConstDef.TEMPLATE_INFO_SCENE_CODE, optString4);
        contentValues.put(SocialConstDef.TEMPLATE_INFO_SCENE_NAME, optString3);
        contentValues.put(SocialConstDef.TEMPLATE_INFO_SCENE_ICON, optString5);
        contentValues.put(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG, Integer.valueOf(jSONObject.optInt(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG)));
        contentValues.put(SocialConstDef.TEMPLATE_CARD_SUBTCID, jSONObject.optString(SocialConstDef.TEMPLATE_CARD_SUBTCID));
        return contentValues;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.ContentValues updateTemplateLockInfo(android.content.ContentResolver r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            r1 = r13
            r2 = r15
            r0 = r16
            r3 = r18
            java.lang.String r4 = TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "updateTemplateLockInfo strEvent="
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.introvd.template.common.LogUtils.m14223i(r4, r5)
            java.lang.String r4 = TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "updateTemplateLockInfo ttid="
            r5.append(r6)
            r5.append(r15)
            java.lang.String r6 = ";prevUrl="
            r5.append(r6)
            r5.append(r3)
            java.lang.String r6 = ";"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.introvd.template.common.LogUtils.m14223i(r4, r5)
            boolean r4 = android.text.TextUtils.isEmpty(r16)
            r5 = 0
            if (r4 == 0) goto L_0x0047
            return r5
        L_0x0047:
            java.lang.String r4 = "0"
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006e }
            r8.<init>(r0)     // Catch:{ JSONException -> 0x006e }
            java.lang.String r0 = "code"
            java.lang.String r9 = r8.optString(r0)     // Catch:{ JSONException -> 0x006e }
            java.lang.String r0 = "parameter"
            org.json.JSONObject r0 = r8.getJSONObject(r0)     // Catch:{ JSONException -> 0x006c }
            java.lang.String r4 = "expire_time"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ JSONException -> 0x006c }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x006a }
            r7 = r0
            goto L_0x0074
        L_0x006a:
            r0 = move-exception
            goto L_0x0071
        L_0x006c:
            r0 = move-exception
            goto L_0x0070
        L_0x006e:
            r0 = move-exception
            r9 = r4
        L_0x0070:
            r4 = r6
        L_0x0071:
            r0.printStackTrace()
        L_0x0074:
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 != 0) goto L_0x0139
            r6 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0095 }
            if (r0 != 0) goto L_0x0087
            int r0 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0095 }
            r8 = r0
            goto L_0x0088
        L_0x0087:
            r8 = 0
        L_0x0088:
            boolean r0 = android.text.TextUtils.isEmpty(r17)     // Catch:{ Exception -> 0x0093 }
            if (r0 != 0) goto L_0x009a
            int r0 = java.lang.Integer.parseInt(r17)     // Catch:{ Exception -> 0x0093 }
            goto L_0x009b
        L_0x0093:
            r0 = move-exception
            goto L_0x0097
        L_0x0095:
            r0 = move-exception
            r8 = 0
        L_0x0097:
            r0.printStackTrace()
        L_0x009a:
            r0 = 0
        L_0x009b:
            r9 = 1
            if (r8 > 0) goto L_0x00ae
            java.lang.String r0 = "TemplateMonetization"
            android.net.Uri r0 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r0)
            java.lang.String r3 = "ttid = ?"
            java.lang.String[] r4 = new java.lang.String[r9]
            r4[r6] = r2
            r13.delete(r0, r3, r4)
            return r5
        L_0x00ae:
            if (r4 != 0) goto L_0x00b2
            java.lang.String r4 = ""
        L_0x00b2:
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
            if (r0 != 0) goto L_0x00eb
            java.lang.String r0 = "title"
            r4 = r19
            r10.put(r0, r4)
        L_0x00eb:
            boolean r0 = android.text.TextUtils.isEmpty(r20)
            if (r0 != 0) goto L_0x00f8
            java.lang.String r0 = "intro"
            r4 = r20
            r10.put(r0, r4)
        L_0x00f8:
            boolean r0 = android.text.TextUtils.isEmpty(r21)
            if (r0 != 0) goto L_0x0105
            java.lang.String r0 = "iconurl"
            r4 = r21
            r10.put(r0, r4)
        L_0x0105:
            boolean r0 = android.text.TextUtils.isEmpty(r18)
            if (r0 != 0) goto L_0x0110
            java.lang.String r0 = "previewurl"
            r10.put(r0, r3)
        L_0x0110:
            java.lang.String r0 = "TemplateMonetization"
            android.net.Uri r0 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r0)
            java.lang.String r3 = "ttid = ?"
            java.lang.String[] r4 = new java.lang.String[r9]
            r4[r6] = r2
            int r0 = r13.update(r0, r10, r3, r4)
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "updateTemplateLockInfo updateCount="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.introvd.template.common.LogUtils.m14223i(r1, r2)
            if (r0 > 0) goto L_0x0139
            return r10
        L_0x0139:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDataDao.updateTemplateLockInfo(android.content.ContentResolver, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.ContentValues");
    }
}
