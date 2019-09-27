package com.introvd.template.template.p407e;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.model.TemplateGroupInfo;
import com.introvd.template.template.model.TemplatePackageInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.template.e.k */
public class C8742k {
    private static C8742k etn;
    private Map<String, TemplateInfo> esS = Collections.synchronizedMap(new HashMap());
    private Map<String, List<TemplateInfo>> eto = new HashMap();

    private C8742k() {
    }

    public static synchronized C8742k aMi() {
        C8742k kVar;
        synchronized (C8742k.class) {
            if (etn == null) {
                etn = new C8742k();
            }
            kVar = etn;
        }
        return kVar;
    }

    /* renamed from: db */
    public static List<TemplateGroupInfo> m25537db(List<TemplatePackageInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (TemplatePackageInfo templatePackageInfo : list) {
                TemplateGroupInfo templateGroupInfo = new TemplateGroupInfo();
                templateGroupInfo.showList = true;
                templateGroupInfo.showGroup = true;
                templateGroupInfo.strGroupDisplayName = templatePackageInfo.strTitle;
                templateGroupInfo.strGroupCode = templatePackageInfo.strGroupCode;
                templateGroupInfo.thumbPath = templatePackageInfo.strIcon;
                arrayList.add(templateGroupInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: o */
    private TemplateInfo m25538o(Cursor cursor) {
        TemplateInfo templateInfo = new TemplateInfo();
        templateInfo.ttid = cursor.getString(cursor.getColumnIndex("ttid"));
        templateInfo.strVer = cursor.getString(cursor.getColumnIndex("ver"));
        templateInfo.tcid = cursor.getString(cursor.getColumnIndex("tcid"));
        templateInfo.strTitle = cursor.getString(cursor.getColumnIndex("title"));
        templateInfo.strIntro = cursor.getString(cursor.getColumnIndex("intro"));
        templateInfo.strIcon = cursor.getString(cursor.getColumnIndex("icon"));
        templateInfo.strPreviewurl = cursor.getString(cursor.getColumnIndex("previewurl"));
        templateInfo.nPreviewtype = cursor.getInt(cursor.getColumnIndex("previewtype"));
        templateInfo.strLang = cursor.getString(cursor.getColumnIndex("lang"));
        templateInfo.nMark = cursor.getInt(cursor.getColumnIndex(SocialConstDef.TEMPLATE_CARD_MARK));
        templateInfo.strAppminver = cursor.getString(cursor.getColumnIndex("appminver"));
        templateInfo.nSize = cursor.getInt(cursor.getColumnIndex("size"));
        templateInfo.strScene = cursor.getString(cursor.getColumnIndex("scene"));
        templateInfo.strAuthorid = cursor.getString(cursor.getColumnIndex(SocialConstDef.TEMPLATE_CARD_AUTHORID));
        templateInfo.strAuthorname = cursor.getString(cursor.getColumnIndex(SocialConstDef.TEMPLATE_CARD_AUTHORNAME));
        templateInfo.strPublishtime = cursor.getString(cursor.getColumnIndex("publishtime"));
        templateInfo.nLikecount = cursor.getInt(cursor.getColumnIndex(SocialConstDef.TEMPLATE_CARD_LIKECOUNT));
        templateInfo.nDowncount = cursor.getInt(cursor.getColumnIndex(SocialConstDef.TEMPLATE_CARD_DOWNCOUNT));
        templateInfo.nOrderno = cursor.getInt(cursor.getColumnIndex("orderno"));
        templateInfo.nPoints = cursor.getInt(cursor.getColumnIndex("points"));
        templateInfo.strUrl = cursor.getString(cursor.getColumnIndex("url"));
        templateInfo.strMission = cursor.getString(cursor.getColumnIndex("mission"));
        templateInfo.strDuration = cursor.getString(cursor.getColumnIndex("duration"));
        templateInfo.strSceneCode = cursor.getString(cursor.getColumnIndex(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_CODE));
        templateInfo.strSceneName = cursor.getString(cursor.getColumnIndex(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_NAME));
        templateInfo.strSceneIcon = cursor.getString(cursor.getColumnIndex(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_ICON));
        templateInfo.audioFlag = cursor.getInt(cursor.getColumnIndex(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG));
        return templateInfo;
    }

    /* renamed from: p */
    private TemplatePackageInfo m25539p(Cursor cursor) {
        TemplatePackageInfo templatePackageInfo = new TemplatePackageInfo();
        templatePackageInfo.strGroupCode = cursor.getString(cursor.getColumnIndex("groupcode"));
        templatePackageInfo.strLang = cursor.getString(cursor.getColumnIndex("lang"));
        templatePackageInfo.strAppminver = cursor.getString(cursor.getColumnIndex("appminver"));
        templatePackageInfo.strFileSize = cursor.getString(cursor.getColumnIndex("size"));
        templatePackageInfo.strPublishtime = cursor.getString(cursor.getColumnIndex("publishtime"));
        templatePackageInfo.strExpiretime = cursor.getString(cursor.getColumnIndex("expiredtime"));
        templatePackageInfo.nOrderno = cursor.getInt(cursor.getColumnIndex("orderno"));
        templatePackageInfo.strIcon = cursor.getString(cursor.getColumnIndex("cover"));
        templatePackageInfo.strBannerUrl = cursor.getString(cursor.getColumnIndex(SocialConstDef.TEMPLATE_PACKAGE_BANNER));
        templatePackageInfo.nNewCount = cursor.getInt(cursor.getColumnIndex("newcount"));
        templatePackageInfo.strIntro = cursor.getString(cursor.getColumnIndex("desc"));
        templatePackageInfo.strTitle = cursor.getString(cursor.getColumnIndex("title"));
        templatePackageInfo.strModelCode = cursor.getString(cursor.getColumnIndex("modelcode"));
        return templatePackageInfo;
    }

    /* renamed from: D */
    public void mo35174D(TemplateInfo templateInfo) {
        if (this.esS == null) {
            this.esS = new HashMap();
        }
        if (templateInfo != null && !this.esS.containsKey(templateInfo.ttid)) {
            this.esS.put(templateInfo.ttid, templateInfo);
        }
    }

    /* renamed from: ad */
    public TemplateInfo mo35175ad(Context context, String str, String str2) {
        TemplateInfo templateInfo;
        if (context == null || str == null || str2 == null) {
            return null;
        }
        mo35178cz(context, str);
        List qt = mo35183qt(str);
        if (qt != null && qt.size() > 0) {
            Iterator it = qt.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                templateInfo = (TemplateInfo) it.next();
                if (str2.equals(templateInfo.ttid)) {
                    break;
                }
            }
        }
        templateInfo = null;
        return templateInfo;
    }

    /* renamed from: cA */
    public String mo35176cA(Context context, String str) {
        return C8735f.aMf().mo35145cA(context, str);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0031 */
    /* renamed from: cG */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.introvd.template.template.model.TemplatePackageInfo> mo35177cG(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.ContentResolver r1 = r8.getContentResolver()
            if (r1 != 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.String r4 = "modelcode = ?"
            java.lang.String r8 = "TemplatePackage"
            android.net.Uri r2 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r8)
            r3 = 0
            r8 = 1
            java.lang.String[] r5 = new java.lang.String[r8]
            r8 = 0
            r5[r8] = r9
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 != 0) goto L_0x0023
            return r0
        L_0x0023:
            boolean r9 = r8.moveToNext()     // Catch:{ Exception -> 0x0031, all -> 0x0035 }
            if (r9 == 0) goto L_0x0031
            com.introvd.template.template.model.TemplatePackageInfo r9 = r7.m25539p(r8)     // Catch:{ Exception -> 0x0031, all -> 0x0035 }
            r0.add(r9)     // Catch:{ Exception -> 0x0031, all -> 0x0035 }
            goto L_0x0023
        L_0x0031:
            r8.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x003a
        L_0x0035:
            r9 = move-exception
            r8.close()     // Catch:{ Exception -> 0x0039 }
        L_0x0039:
            throw r9
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8742k.mo35177cG(android.content.Context, java.lang.String):java.util.List");
    }

    /* renamed from: cz */
    public void mo35178cz(Context context, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.VIEW_NAME_TEMPLATE_PACKAGE_DETAIL), null, "groupcode = ?", new String[]{str}, null);
            if (query != null) {
                ArrayList arrayList = new ArrayList();
                C8735f.aMf().mo35156ve(1);
                while (query.moveToNext()) {
                    try {
                        TemplateInfo o = m25538o(query);
                        C8735f.aMf().mo35135C(o);
                        if (7 != o.nState) {
                            arrayList.add(o);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        try {
                            query.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                if (this.eto != null) {
                    this.eto.put(str, arrayList);
                }
                try {
                    query.close();
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* renamed from: e */
    public TemplatePackageInfo mo35179e(List<TemplatePackageInfo> list, String str) {
        for (TemplatePackageInfo templatePackageInfo : list) {
            if (templatePackageInfo.strGroupCode.equals(str)) {
                return templatePackageInfo;
            }
        }
        return null;
    }

    /* renamed from: e */
    public void mo35180e(Context context, String str, List<TemplatePackageInfo> list) {
        if (context != null && !TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_PACKAGE);
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < list.size(); i++) {
                TemplatePackageInfo templatePackageInfo = (TemplatePackageInfo) list.get(i);
                if (templatePackageInfo != null) {
                    contentValues.clear();
                    contentValues.put("groupcode", templatePackageInfo.strGroupCode);
                    contentValues.put("lang", templatePackageInfo.strLang);
                    contentValues.put("appminver", templatePackageInfo.strAppminver);
                    contentValues.put("size", templatePackageInfo.strFileSize);
                    contentValues.put("publishtime", templatePackageInfo.strPublishtime);
                    contentValues.put("expiredtime", templatePackageInfo.strExpiretime);
                    contentValues.put("orderno", String.valueOf(templatePackageInfo.nOrderno));
                    contentValues.put("cover", templatePackageInfo.strIcon);
                    contentValues.put(SocialConstDef.TEMPLATE_PACKAGE_BANNER, templatePackageInfo.strBannerUrl);
                    contentValues.put("newcount", String.valueOf(templatePackageInfo.nNewCount));
                    contentValues.put("desc", templatePackageInfo.strIntro);
                    contentValues.put("title", templatePackageInfo.strTitle);
                    if (!TextUtils.isEmpty(str)) {
                        contentValues.put("modelcode", str);
                    }
                    arrayList.add(ContentProviderOperation.newInsert(tableUri).withValues(contentValues).build());
                }
            }
            try {
                ContentResolver contentResolver = context.getContentResolver();
                if (!TextUtils.isEmpty(str)) {
                    contentResolver.delete(tableUri, "modelcode=?", new String[]{str});
                }
                if (!arrayList.isEmpty()) {
                    contentResolver.applyBatch(tableUri.getAuthority(), arrayList);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: f */
    public void mo35181f(Context context, String str, List<TemplateInfo> list) {
        if (context != null && !TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_PACKAGE_DETAIL);
            ArrayList arrayList2 = new ArrayList();
            Uri tableUri2 = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
            long currentTimeMillis = System.currentTimeMillis();
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            ContentValues contentValues2 = new ContentValues();
            for (TemplateInfo templateInfo : list) {
                contentValues.clear();
                contentValues2.clear();
                contentValues.put("groupcode", str);
                contentValues.put("orderno", Integer.valueOf(templateInfo.nOrderno));
                contentValues.put("ttid", templateInfo.ttid);
                contentValues.put("tcid", templateInfo.tcid);
                contentValues.put(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_CODE, templateInfo.strSceneCode);
                contentValues.put(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_ICON, templateInfo.strSceneIcon);
                contentValues.put(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_NAME, templateInfo.strSceneName);
                contentValues.put("updatetime", Long.valueOf(currentTimeMillis));
                arrayList.add(ContentProviderOperation.newInsert(tableUri).withValues(contentValues).build());
                contentValues2.put("tcid", templateInfo.ttid);
                contentValues2.put("ttid", templateInfo.tcid);
                contentValues2.put("scene", templateInfo.strSceneName);
                contentValues2.put("scene_code", templateInfo.strSceneCode);
                contentValues2.put(SocialConstDef.TEMPLATE_CARD_SCENE_ICON, templateInfo.strSceneIcon);
                contentValues2.put("ver", templateInfo.strVer);
                contentValues2.put("title", templateInfo.strTitle);
                contentValues2.put("intro", templateInfo.strIntro);
                contentValues2.put("icon", templateInfo.strIcon);
                contentValues2.put("previewurl", templateInfo.strPreviewurl);
                contentValues2.put("previewtype", Integer.valueOf(templateInfo.nPreviewtype));
                contentValues2.put("lang", templateInfo.strLang);
                contentValues2.put(SocialConstDef.TEMPLATE_CARD_MARK, Integer.valueOf(templateInfo.nMark));
                contentValues2.put("appminver", templateInfo.strAppminver);
                contentValues2.put("size", String.valueOf(templateInfo.nSize));
                contentValues2.put(SocialConstDef.TEMPLATE_CARD_AUTHORNAME, templateInfo.strAuthorname);
                contentValues2.put("publishtime", templateInfo.strPublishtime);
                contentValues2.put(SocialConstDef.TEMPLATE_CARD_LIKECOUNT, String.valueOf(templateInfo.nLikecount));
                contentValues2.put(SocialConstDef.TEMPLATE_CARD_DOWNCOUNT, String.valueOf(templateInfo.nDowncount));
                contentValues2.put("points", String.valueOf(templateInfo.nPoints));
                contentValues2.put("duration", templateInfo.strDuration);
                contentValues2.put("updatetime", Long.valueOf(currentTimeMillis));
                contentValues2.put(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG, Integer.valueOf(templateInfo.audioFlag));
                arrayList2.add(ContentProviderOperation.newInsert(tableUri2).withValues(contentValues2).build());
            }
            try {
                if (!arrayList2.isEmpty()) {
                    contentResolver.applyBatch(tableUri2.getAuthority(), arrayList2);
                }
                if (!arrayList.isEmpty()) {
                    contentResolver.applyBatch(tableUri.getAuthority(), arrayList);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: hp */
    public List<TemplatePackageInfo> mo35182hp(Context context) {
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return arrayList;
        }
        Cursor query = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_PACKAGE), null, null, null, null);
        if (query == null) {
            return arrayList;
        }
        while (query.moveToNext()) {
            try {
                arrayList.add(m25539p(query));
            } finally {
                try {
                    query.close();
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    /* renamed from: qt */
    public List<TemplateInfo> mo35183qt(String str) {
        if (this.eto.containsKey(str)) {
            return (List) this.eto.get(str);
        }
        return null;
    }

    public void uninit() {
    }
}
