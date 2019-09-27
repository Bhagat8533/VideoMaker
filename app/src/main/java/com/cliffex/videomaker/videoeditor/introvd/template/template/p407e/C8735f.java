package com.introvd.template.template.p407e;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.Utils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p374q.C8344c;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.model.template.TemplateRollModel;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.template.e.f */
public class C8735f {
    private static C8735f esR;
    private int bFv = 0;
    private String bgc;
    private List<TemplateInfo> esL = Collections.synchronizedList(new ArrayList());
    private Map<String, TemplateInfo> esS = Collections.synchronizedMap(new HashMap());
    private List<TemplateInfo> esT = Collections.synchronizedList(new ArrayList());
    private List<TemplateInfo> esU = Collections.synchronizedList(new ArrayList());
    private List<TemplateInfo> esV = Collections.synchronizedList(new ArrayList());
    private List<TemplateInfo> esW = Collections.synchronizedList(new ArrayList());
    private List<TemplateInfo> esX = Collections.synchronizedList(new ArrayList());
    private List<TemplateInfo> esY = Collections.synchronizedList(new ArrayList());
    private List<TemplateInfo> esZ = Collections.synchronizedList(new ArrayList());
    private List<TemplateInfo> eta = Collections.synchronizedList(new ArrayList());
    private Map<String, Integer> etb = new HashMap();
    private int mViewType = 0;

    private C8735f() {
    }

    /* renamed from: X */
    public static RollInfo m25474X(Context context, String str, String str2) {
        if (str2 != null) {
            str2 = str2.trim();
        }
        List a = m25476a(context, SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_ROLL), str, str2);
        if (a == null || a.size() <= 0) {
            return null;
        }
        return m25475a(str, (TemplateRollModel) a.get(0));
    }

    /* renamed from: a */
    public static RollInfo m25475a(String str, TemplateRollModel templateRollModel) {
        RollInfo rollInfo = new RollInfo();
        if (templateRollModel != null) {
            if (templateRollModel.mRollIconInfo != null) {
                rollInfo.strIcon = templateRollModel.mRollIconInfo.mIconUrl;
                rollInfo.strIntro = templateRollModel.mRollScriptInfo.rollSimpleIntro;
                rollInfo.strTitle = templateRollModel.mRollScriptInfo.rollTitle;
            }
            rollInfo.rollModel = templateRollModel;
            rollInfo.ttid = templateRollModel.rollCode;
            rollInfo.nMark = templateRollModel.mNewFlag;
            rollInfo.strSubType = templateRollModel.strSubType;
        }
        rollInfo.tcid = str;
        rollInfo.nFlag = 0;
        rollInfo.nState = 1;
        rollInfo.strVer = "0";
        return rollInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x010d, code lost:
        if (r1 != null) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.close();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.introvd.template.sdk.model.template.TemplateRollModel> m25476a(android.content.Context r19, android.net.Uri r20, java.lang.String r21, java.lang.String r22) {
        /*
            java.lang.String r1 = "code"
            java.lang.String r2 = "tcid"
            java.lang.String r3 = "enginever"
            java.lang.String r4 = "downurl"
            java.lang.String r5 = "lang"
            java.lang.String r6 = "price"
            java.lang.String r7 = "wordinfos"
            java.lang.String r8 = "xytinfos"
            java.lang.String r9 = "newflag"
            java.lang.String r10 = "orderno"
            java.lang.String r11 = "subtype"
            java.lang.String r12 = "isShow"
            java.lang.String[] r15 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12}
            android.content.ContentResolver r13 = r19.getContentResolver()
            java.lang.String r1 = "tcid= ? "
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]
            r4 = 0
            r3[r4] = r21
            boolean r5 = android.text.TextUtils.isEmpty(r22)
            if (r5 != 0) goto L_0x0046
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " and code= ? "
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r3[r4] = r21
            r3[r2] = r22
        L_0x0046:
            r16 = r1
            r17 = r3
            r18 = 0
            r14 = r20
            android.database.Cursor r1 = r13.query(r14, r15, r16, r17, r18)
            if (r1 != 0) goto L_0x0056
            r0 = 0
            return r0
        L_0x0056:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x005b:
            boolean r2 = r1.moveToNext()     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            if (r2 == 0) goto L_0x010d
            com.introvd.template.sdk.model.template.TemplateRollModel r2 = new com.introvd.template.sdk.model.template.TemplateRollModel     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.<init>()     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "code"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.rollCode = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "tcid"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.strTCID = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "subtype"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.strSubType = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "enginever"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.engineVer = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "downurl"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.rollDownUrl = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "lang"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.lang = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "price"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.rollPrice = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "wordinfos"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.rollScript = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "newflag"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            int r3 = r1.getInt(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.mNewFlag = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "isShow"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            int r3 = r1.getInt(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.isShowInMC = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "xytinfos"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.rollXytInfos = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            com.introvd.template.sdk.model.template.RollScriptInfo r3 = r2.getRollScriptInfo()     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.mRollScriptInfo = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r2.rollXytInfos     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            com.introvd.template.sdk.model.template.RollIconInfo r3 = r2.getRollIconInfo(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.mRollIconInfo = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = "orderno"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            int r3 = com.p131c.p132a.p135c.C2575a.parseInt(r3)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r2.mOrderNum = r3     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            r0.add(r2)     // Catch:{ Throwable -> 0x011a, all -> 0x0113 }
            goto L_0x005b
        L_0x010d:
            if (r1 == 0) goto L_0x011e
        L_0x010f:
            r1.close()     // Catch:{ Exception -> 0x011e }
            goto L_0x011e
        L_0x0113:
            r0 = move-exception
            if (r1 == 0) goto L_0x0119
            r1.close()     // Catch:{ Exception -> 0x0119 }
        L_0x0119:
            throw r0
        L_0x011a:
            if (r1 == 0) goto L_0x011e
            goto L_0x010f
        L_0x011e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8735f.m25476a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    public static void m25477a(TemplateInfo templateInfo, int i, String str, int i2) {
        LogUtils.m14223i("TemplateInfoMgr", "UpdateItemState");
        if (templateInfo != null) {
            TemplateItemData bD = C8762d.aMt().mo35227bD(C2575a.m7391rq(templateInfo.ttid));
            templateInfo.nViewType = i;
            if (Utils.isNewVersion(templateInfo.strAppminver, str)) {
                templateInfo.nState = 4;
            } else if (templateInfo instanceof RollInfo) {
                if (templateInfo.nState != 8) {
                    if (aMf().mo35138F(templateInfo)) {
                        templateInfo.nState = 8;
                    } else if (C8745n.m25561qv(((RollInfo) templateInfo).rollModel.rollCode)) {
                        templateInfo.nState = 6;
                    } else {
                        templateInfo.nState = 1;
                    }
                }
            } else if (templateInfo.nState == 8 || aMf().mo35138F(templateInfo)) {
                if (aMf().mo35138F(templateInfo)) {
                    templateInfo.nState = 8;
                }
            } else if (bD == null || bD.shouldOnlineDownload() || bD.nDelFlag == 1) {
                templateInfo.nState = 1;
            } else {
                templateInfo.nFlag = i2;
                if (templateInfo.nFlag == 0) {
                    templateInfo.nState = 6;
                } else if (templateInfo.nFlag == 1) {
                    templateInfo.nState = 3;
                }
            }
        }
    }

    public static synchronized C8735f aMf() {
        C8735f fVar;
        synchronized (C8735f.class) {
            if (esR == null) {
                esR = new C8735f();
            }
            fVar = esR;
        }
        return fVar;
    }

    /* renamed from: o */
    public static TemplateInfo m25478o(Cursor cursor) {
        TemplateInfo templateInfo = new TemplateInfo();
        templateInfo.ttid = cursor.getString(cursor.getColumnIndex("ttid"));
        templateInfo.strVer = cursor.getString(cursor.getColumnIndex("ver"));
        templateInfo.tcid = cursor.getString(cursor.getColumnIndex("tcid"));
        templateInfo.subtcid = cursor.getString(cursor.getColumnIndex(SocialConstDef.TEMPLATE_CARD_SUBTCID));
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
        templateInfo.nPoints = cursor.getInt(cursor.getColumnIndex("points"));
        templateInfo.strUrl = cursor.getString(cursor.getColumnIndex("url"));
        templateInfo.strMission = cursor.getString(cursor.getColumnIndex("mission"));
        templateInfo.strDuration = cursor.getString(cursor.getColumnIndex("duration"));
        int columnIndex = cursor.getColumnIndex("orderno");
        if (columnIndex >= 0) {
            templateInfo.nOrderno = cursor.getInt(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex(SocialConstDef.TEMPLATE_INFO_SCENE_CODE);
        if (columnIndex2 >= 0) {
            templateInfo.strSceneCode = cursor.getString(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex(SocialConstDef.TEMPLATE_INFO_SCENE_NAME);
        if (columnIndex3 >= 0) {
            templateInfo.strSceneName = cursor.getString(columnIndex3);
        }
        int columnIndex4 = cursor.getColumnIndex(SocialConstDef.TEMPLATE_INFO_SCENE_ICON);
        if (columnIndex4 >= 0) {
            templateInfo.strSceneIcon = cursor.getString(columnIndex4);
        }
        return templateInfo;
    }

    /* renamed from: qm */
    public static boolean m25479qm(String str) {
        return C8399c.ede.equals(str) || C8399c.edb.equals(str) || C8399c.ecY.equals(str);
    }

    /* renamed from: C */
    public void mo35135C(TemplateInfo templateInfo) {
        m25477a(templateInfo, this.mViewType, this.bgc, this.bFv);
    }

    /* renamed from: D */
    public void mo35136D(TemplateInfo templateInfo) {
        if (this.esS == null) {
            this.esS = new HashMap();
        }
        if (templateInfo != null && !this.esS.containsKey(templateInfo.ttid)) {
            this.esS.put(templateInfo.ttid, templateInfo);
        }
    }

    /* renamed from: E */
    public boolean mo35137E(TemplateInfo templateInfo) {
        if (m25479qm(templateInfo.tcid)) {
            return mo35138F(templateInfo);
        }
        return false;
    }

    /* renamed from: F */
    public boolean mo35138F(TemplateInfo templateInfo) {
        return this.esS != null && this.esS.containsKey(templateInfo.ttid);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0048 */
    /* renamed from: Y */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> mo35139Y(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.content.ContentResolver r1 = r8.getContentResolver()
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.String r4 = "tcid = ? AND subtcid = ?"
            java.lang.String r2 = "TemplateInfoView"
            android.net.Uri r2 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r2)
            r3 = 0
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]
            r6 = 0
            r5[r6] = r9
            r6 = 1
            r5[r6] = r10
            r6 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6)
            if (r10 != 0) goto L_0x002a
            return r0
        L_0x002a:
            boolean r0 = r10.moveToNext()     // Catch:{ Throwable -> 0x0048, all -> 0x004c }
            if (r0 == 0) goto L_0x0048
            com.introvd.template.sdk.model.template.TemplateInfo r0 = m25478o(r10)     // Catch:{ Throwable -> 0x0048, all -> 0x004c }
            java.lang.String r1 = com.introvd.template.sdk.p383c.C8399c.edf     // Catch:{ Throwable -> 0x0048, all -> 0x004c }
            boolean r1 = r1.equals(r9)     // Catch:{ Throwable -> 0x0048, all -> 0x004c }
            if (r1 != 0) goto L_0x003f
            r7.mo35135C(r0)     // Catch:{ Throwable -> 0x0048, all -> 0x004c }
        L_0x003f:
            r1 = 7
            int r2 = r0.nState     // Catch:{ Throwable -> 0x0048, all -> 0x004c }
            if (r1 == r2) goto L_0x002a
            r8.add(r0)     // Catch:{ Throwable -> 0x0048, all -> 0x004c }
            goto L_0x002a
        L_0x0048:
            r10.close()     // Catch:{ Exception -> 0x0051 }
            goto L_0x0051
        L_0x004c:
            r8 = move-exception
            r10.close()     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            throw r8
        L_0x0051:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8735f.mo35139Y(android.content.Context, java.lang.String, java.lang.String):java.util.List");
    }

    /* renamed from: Z */
    public TemplateInfo mo35140Z(Context context, String str, String str2) {
        TemplateInfo be = mo35144be(str, str2);
        if (be == null) {
            Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.VIEW_NAME_TEMPLATE_INFO), null, "tcid = ? and ttid = ?", new String[]{str, str2}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    be = m25478o(query);
                }
                query.close();
            }
        }
        return be;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003b */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> mo35141a(java.lang.String r8, android.content.ContentResolver r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r4 = "tcid = ?"
            java.lang.String r1 = "TemplateInfoView"
            android.net.Uri r2 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r1)
            r1 = 1
            java.lang.String[] r5 = new java.lang.String[r1]
            r1 = 0
            r5[r1] = r8
            r3 = 0
            r6 = 0
            r1 = r9
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)
            if (r9 != 0) goto L_0x001d
            return r0
        L_0x001d:
            boolean r1 = r9.moveToNext()     // Catch:{ Throwable -> 0x003b, all -> 0x003f }
            if (r1 == 0) goto L_0x003b
            com.introvd.template.sdk.model.template.TemplateInfo r1 = m25478o(r9)     // Catch:{ Throwable -> 0x003b, all -> 0x003f }
            java.lang.String r2 = com.introvd.template.sdk.p383c.C8399c.edf     // Catch:{ Throwable -> 0x003b, all -> 0x003f }
            boolean r2 = r2.equals(r8)     // Catch:{ Throwable -> 0x003b, all -> 0x003f }
            if (r2 != 0) goto L_0x0032
            r7.mo35135C(r1)     // Catch:{ Throwable -> 0x003b, all -> 0x003f }
        L_0x0032:
            r2 = 7
            int r3 = r1.nState     // Catch:{ Throwable -> 0x003b, all -> 0x003f }
            if (r2 == r3) goto L_0x001d
            r0.add(r1)     // Catch:{ Throwable -> 0x003b, all -> 0x003f }
            goto L_0x001d
        L_0x003b:
            r9.close()     // Catch:{ Exception -> 0x0044 }
            goto L_0x0044
        L_0x003f:
            r8 = move-exception
            r9.close()     // Catch:{ Exception -> 0x0043 }
        L_0x0043:
            throw r8
        L_0x0044:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8735f.mo35141a(java.lang.String, android.content.ContentResolver):java.util.List");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0036 */
    /* renamed from: aa */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo35142aa(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.content.ContentResolver r1 = r8.getContentResolver()
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            java.lang.String r4 = "tcid = ? AND subtcid = ?"
            java.lang.String r8 = "TemplateInfoView"
            android.net.Uri r2 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r8)
            r3 = 0
            r8 = 2
            java.lang.String[] r5 = new java.lang.String[r8]
            r5[r0] = r9
            r8 = 1
            r5[r8] = r10
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 != 0) goto L_0x0024
            return r0
        L_0x0024:
            boolean r9 = r8.moveToNext()     // Catch:{ Throwable -> 0x0036, all -> 0x003a }
            if (r9 == 0) goto L_0x0036
            com.introvd.template.sdk.model.template.TemplateInfo r9 = m25478o(r8)     // Catch:{ Throwable -> 0x0036, all -> 0x003a }
            r10 = 7
            int r9 = r9.nState     // Catch:{ Throwable -> 0x0036, all -> 0x003a }
            if (r10 != r9) goto L_0x0024
            int r0 = r0 + 1
            goto L_0x0024
        L_0x0036:
            r8.close()     // Catch:{ Exception -> 0x003f }
            goto L_0x003f
        L_0x003a:
            r9 = move-exception
            r8.close()     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            throw r9
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8735f.mo35142aa(android.content.Context, java.lang.String, java.lang.String):int");
    }

    /* renamed from: aq */
    public boolean mo35143aq(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int intValue = 1 << Integer.valueOf(str).intValue();
            return (C8344c.m24058k(context, SocialServiceDef.UNION_KEY_TEMPLATE_INFO_NEW_FLAG, 0) & intValue) == intValue;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: be */
    public TemplateInfo mo35144be(String str, String str2) {
        TemplateInfo templateInfo;
        this.esL = mo35151qk(str);
        TemplateInfo templateInfo2 = null;
        if (this.esL == null) {
            return null;
        }
        try {
            synchronized (this.esL) {
                Iterator it = this.esL.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        templateInfo = null;
                        break;
                    }
                    templateInfo = (TemplateInfo) it.next();
                    if (templateInfo.ttid.equals(str2)) {
                        break;
                    }
                }
            }
            templateInfo2 = templateInfo;
        } catch (ConcurrentModificationException unused) {
        }
        return templateInfo2;
    }

    /* renamed from: cA */
    public String mo35145cA(Context context, String str) {
        String[] strArr = {str};
        Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_DOWNLOAD), null, "userdata = ?", strArr, null);
        String str2 = null;
        if (query != null) {
            if (query.moveToFirst()) {
                str2 = query.getString(query.getColumnIndex("remote"));
            }
            query.close();
        }
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r9 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r9 != null) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[Catch:{ Throwable -> 0x003d, all -> 0x0033 }] */
    /* renamed from: cB */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.introvd.template.sdk.model.template.TemplateInfo mo35146cB(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch:{ all -> 0x0043 }
            r8 = 1
            java.lang.String[] r4 = new java.lang.String[r8]     // Catch:{ all -> 0x0043 }
            r8 = 0
            r4[r8] = r9     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "ttid = ?"
            java.lang.String r8 = "TemplateInfoView"
            android.net.Uri r1 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r8)     // Catch:{ all -> 0x0043 }
            r2 = 0
            r8 = 0
            java.lang.String r5 = "publishtime desc"
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Throwable -> 0x003d, all -> 0x0033 }
            if (r9 == 0) goto L_0x002d
            boolean r0 = r9.moveToFirst()     // Catch:{ Throwable -> 0x002b, all -> 0x0029 }
            if (r0 == 0) goto L_0x002d
            com.introvd.template.sdk.model.template.TemplateInfo r0 = m25478o(r9)     // Catch:{ Throwable -> 0x002b, all -> 0x0029 }
            r8 = r0
            goto L_0x002d
        L_0x0029:
            r8 = move-exception
            goto L_0x0037
        L_0x002b:
            goto L_0x003e
        L_0x002d:
            if (r9 == 0) goto L_0x0041
        L_0x002f:
            r9.close()     // Catch:{ all -> 0x0043 }
            goto L_0x0041
        L_0x0033:
            r9 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0037:
            if (r9 == 0) goto L_0x003c
            r9.close()     // Catch:{ all -> 0x0043 }
        L_0x003c:
            throw r8     // Catch:{ all -> 0x0043 }
        L_0x003d:
            r9 = r8
        L_0x003e:
            if (r9 == 0) goto L_0x0041
            goto L_0x002f
        L_0x0041:
            monitor-exit(r7)
            return r8
        L_0x0043:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8735f.mo35146cB(android.content.Context, java.lang.String):com.introvd.template.sdk.model.template.TemplateInfo");
    }

    /* renamed from: cz */
    public void mo35147cz(Context context, String str) {
        int i;
        LogUtils.m14223i("TemplateInfoMgr", "dbTemplateInfoQuery");
        this.esL = mo35151qk(str);
        if (this.esL != null && context != null) {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                if (m25479qm(str)) {
                    C8745n.updateRollTemplateMapInfo(context);
                    List<TemplateRollModel> a = m25476a(context, SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_ROLL), str, "");
                    if (a != null) {
                        int i2 = 0;
                        this.esL.clear();
                        for (TemplateRollModel a2 : a) {
                            RollInfo a3 = m25475a(str, a2);
                            mo35135C(a3);
                            if (7 == a3.nState) {
                                i2++;
                            } else {
                                this.esL.add(a3);
                            }
                        }
                        this.etb.put(str, Integer.valueOf(i2));
                    }
                } else if (this.esL != null) {
                    this.esL.clear();
                    if (str.equals(C8399c.ecX)) {
                        List Y = mo35139Y(context, C8399c.ecX, String.valueOf(C8451b.THEME.code));
                        if (!(this.esL == null || Y == null)) {
                            this.esL.addAll(Y);
                        }
                        i = mo35142aa(context, C8399c.ecX, String.valueOf(C8451b.THEME.code));
                    } else {
                        List a4 = mo35141a(str, contentResolver);
                        if (!(this.esL == null || a4 == null)) {
                            this.esL.addAll(a4);
                        }
                        i = mo35150p(contentResolver, str);
                    }
                    this.etb.put(str, Integer.valueOf(i));
                }
            }
        }
    }

    /* renamed from: l */
    public void mo35148l(Context context, String str, int i) {
        LogUtils.m14223i("TemplateInfoMgr", "TempalteInfoMgr init");
        mo35156ve(i);
        this.bgc = Utils.getAppVersion(context);
        this.esL = mo35151qk(str);
    }

    /* renamed from: m */
    public void mo35149m(Context context, String str, boolean z) {
        if (C4580b.m11656eB(str)) {
            int k = C8344c.m24058k(context, SocialServiceDef.UNION_KEY_TEMPLATE_INFO_NEW_FLAG, 0);
            int intValue = 1 << Integer.valueOf(str).intValue();
            C8344c.m24054P(context, SocialServiceDef.UNION_KEY_TEMPLATE_INFO_NEW_FLAG, String.valueOf(z ? (~intValue) & k : intValue | k));
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo35150p(android.content.ContentResolver r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r3 = "tcid = ?"
            java.lang.String r0 = "TemplateInfoView"
            android.net.Uri r1 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r0)
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            r6 = 0
            r4[r6] = r9
            r2 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5)
            if (r8 != 0) goto L_0x0018
            return r6
        L_0x0018:
            boolean r9 = r8.moveToNext()     // Catch:{ Throwable -> 0x002a, all -> 0x002e }
            if (r9 == 0) goto L_0x002a
            com.introvd.template.sdk.model.template.TemplateInfo r9 = m25478o(r8)     // Catch:{ Throwable -> 0x002a, all -> 0x002e }
            r0 = 7
            int r9 = r9.nState     // Catch:{ Throwable -> 0x002a, all -> 0x002e }
            if (r0 != r9) goto L_0x0018
            int r6 = r6 + 1
            goto L_0x0018
        L_0x002a:
            r8.close()     // Catch:{ Exception -> 0x0033 }
            goto L_0x0033
        L_0x002e:
            r9 = move-exception
            r8.close()     // Catch:{ Exception -> 0x0032 }
        L_0x0032:
            throw r9
        L_0x0033:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8735f.mo35150p(android.content.ContentResolver, java.lang.String):int");
    }

    /* renamed from: qk */
    public List<TemplateInfo> mo35151qk(String str) {
        if (C8399c.ecX.equals(str)) {
            return this.esT;
        }
        if (C8399c.ecY.equals(str)) {
            return this.esU;
        }
        if (C8399c.ecZ.equals(str)) {
            return this.esW;
        }
        if (C8399c.edb.equals(str)) {
            return this.esV;
        }
        if (C8399c.edd.equals(str)) {
            return this.esX;
        }
        if (C8399c.ede.equals(str)) {
            return this.esZ;
        }
        if (C8399c.edc.equals(str)) {
            return this.esY;
        }
        if (C8399c.edf.equals(str)) {
            return this.eta;
        }
        return null;
    }

    /* renamed from: ql */
    public int mo35152ql(String str) {
        this.esL = mo35151qk(str);
        if (this.esL == null) {
            return 0;
        }
        return this.esL.size();
    }

    /* renamed from: qn */
    public void mo35153qn(String str) {
        if (this.esS != null) {
            this.esS.remove(str);
        }
    }

    /* renamed from: qo */
    public boolean mo35154qo(String str) {
        return this.esS != null && this.esS.containsKey(str);
    }

    /* renamed from: qp */
    public TemplateInfo mo35155qp(String str) {
        if (this.esS == null || !this.esS.containsKey(str)) {
            return null;
        }
        return (TemplateInfo) this.esS.get(str);
    }

    /* renamed from: ve */
    public void mo35156ve(int i) {
        this.bFv = i;
    }

    /* renamed from: vf */
    public void mo35157vf(int i) {
        this.mViewType = i;
    }
}
