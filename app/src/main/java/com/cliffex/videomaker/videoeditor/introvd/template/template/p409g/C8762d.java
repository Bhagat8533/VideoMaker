package com.introvd.template.template.p409g;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.support.p021v4.util.LongSparseArray;
import android.text.TextUtils;
import android.util.SparseArray;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8398b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8500b;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8554j;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QExternalFileInfo;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QBitmapFactory;
import xiaoying.utils.QColorSpace;
import xiaoying.utils.QStreamAssets;

/* renamed from: com.introvd.template.template.g.d */
public class C8762d {
    private static final String TAG = "d";
    private static final long[] etQ = {QStyle.NONE_THEME_TEMPLATE_ID, 72060892572811379L, QStyle.NONE_THEME_TEMPLATE_ID};
    private static final Long[][] etS = {new Long[]{Long.valueOf(216172782113783858L), Long.valueOf(216172782113783867L)}, new Long[]{Long.valueOf(216172782113783862L), Long.valueOf(216172782113783868L)}, new Long[]{Long.valueOf(216172782113783866L), Long.valueOf(216172782113783869L)}, new Long[]{Long.valueOf(288230376151711847L), Long.valueOf(288230376151711852L)}, new Long[]{Long.valueOf(288230376151711842L), Long.valueOf(288230376151711854L)}, new Long[]{Long.valueOf(288230376151711850L), Long.valueOf(288230376151711851L)}};
    private static C8762d etT;
    private static final int etU = C8500b.m24591P(50.0f);
    private static final int etV = ((int) (C8398b.ecV * 50.0f));
    private static final long[] etY = {QStyle.NONE_FILTER_TEMPLATE_ID, QStyle.NONE_TRANSITION_TEMPLATE_ID, QStyle.NONE_THEME_TEMPLATE_ID, QStyle.DEFAULT_BUBBLE_TEMPLATE_ID};
    private static final long[] etZ = {QStyle.NONE_FILTER_TEMPLATE_ID, QStyle.NONE_TRANSITION_TEMPLATE_ID, QStyle.NONE_THEME_TEMPLATE_ID, QStyle.NONE_ANIMATED_FRAME_TEMPLATE_ID, QStyle.NONE_BUBBLE_TEMPLATE_ID, QStyle.NONE_MUSIC_TEMPLATE_ID, QStyle.NONE_POSTER_TEMPLATE_ID, QStyle.DEFAULT_BUBBLE_TEMPLATE_ID};
    private static final LongSparseArray<Integer> eua = new LongSparseArray<>();
    private static final long[] euq = {288233674686595128L};
    private boolean dmh;
    private final LongSparseArray<Long> etR = new LongSparseArray<>();
    public Map<Integer, List<Long>> etW = Collections.synchronizedMap(new LinkedHashMap());
    private boolean etX;
    private long[] eub;
    private long[] euc;
    private long[] eud;
    private long[] eue;
    private long[] euf;
    private long[] eug;
    private long[] euh;
    private long[] eui;
    private long[] euj;
    private long[] euk;
    private long[] eul;
    private long[] eum;
    private long[] eun;
    private long[] euo = null;
    private long[] eup;
    private Map<Long, TemplateItemData> eur;
    private boolean eus;
    private Map<String, Long> eut;
    private AssetManager mAssetManager;
    private Context mContext;

    private C8762d() {
    }

    /* renamed from: A */
    private static String m25611A(int i, String str) {
        String str2 = "";
        try {
            return !TextUtils.isEmpty(str) ? new JSONObject(str).getString(String.valueOf(i)) : str2;
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00dc  */
    /* renamed from: Z */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.introvd.template.sdk.model.editor.TemplateItemData m25612Z(java.lang.String r23, int r24) {
        /*
            r22 = this;
            r1 = 0
            xiaoying.engine.base.QStyle r2 = new xiaoying.engine.base.QStyle     // Catch:{ Throwable -> 0x00d8, all -> 0x00cf }
            r2.<init>()     // Catch:{ Throwable -> 0x00d8, all -> 0x00cf }
            r0 = 1
            r4 = r23
            int r0 = r2.create(r4, r1, r0)     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            r11.<init>()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            if (r0 != 0) goto L_0x00c1
            long r5 = r2.getID()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            xiaoying.utils.QSize r0 = new xiaoying.utils.QSize     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            r0.<init>()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            r2.getThemeExportSize(r0)     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            int r12 = r0.mWidth     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            int r0 = r0.mHeight     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            int r13 = r2.getThemeCoverPosition()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            int r7 = r2.getVersion()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            int r14 = r2.getSupportedLayouts()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            xiaoying.engine.base.QStyle$QExternalFileInfo[] r3 = r2.getExternalFileInfos()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            int r15 = r2.getConfigureCount()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            boolean r9 = r2.getDummyFlag()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            int r16 = r2.getCategroyID()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            r8 = 4
            java.lang.String r10 = r2.getTemplateName(r8)     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            r11.put(r8, r10)     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            r8 = 1033(0x409, float:1.448E-42)
            java.lang.String r10 = r2.getTemplateName(r8)     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            r11.put(r8, r10)     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            r10 = r22
            java.lang.String r8 = r10.m25614a(r3)     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            if (r24 != 0) goto L_0x0065
            r3 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r1 = new com.introvd.template.sdk.model.editor.TemplateItemData$Builder     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00cc, all -> 0x00c8 }
            r19 = r2
            r2 = r3
            r3 = r1
            r4 = r23
            r20 = r13
            r13 = r8
            r8 = r24
            r21 = r0
            r0 = r9
            r9 = r17
            r3.<init>(r4, r5, r7, r8, r9)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r1 = r1.nOrder(r2)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r1 = r1.nOriOrder(r2)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r1 = r1.nLayoutFlag(r14)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r1 = r1.strExtInfo(r13)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            java.lang.String r2 = r11.toString()     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r1 = r1.strTitleJSON(r2)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r1 = r1.nConfigureCount(r15)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r0 = r1.nNeedDownloadFlag(r0)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            java.lang.String r1 = java.lang.String.valueOf(r16)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r0 = r0.strSceneCode(r1)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r0 = r0.streamWidth(r12)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            r1 = r21
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r0 = r0.streamHeight(r1)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            r1 = r20
            com.introvd.template.sdk.model.editor.TemplateItemData$Builder r0 = r0.coverPos(r1)     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            com.introvd.template.sdk.model.editor.TemplateItemData r0 = r0.build()     // Catch:{ Throwable -> 0x00bf, all -> 0x00bd }
            r1 = r0
            goto L_0x00c4
        L_0x00bd:
            r0 = move-exception
            goto L_0x00d2
        L_0x00bf:
            goto L_0x00da
        L_0x00c1:
            r19 = r2
            r1 = 0
        L_0x00c4:
            r19.destroy()
            goto L_0x00e0
        L_0x00c8:
            r0 = move-exception
            r19 = r2
            goto L_0x00d2
        L_0x00cc:
            r19 = r2
            goto L_0x00da
        L_0x00cf:
            r0 = move-exception
            r19 = 0
        L_0x00d2:
            if (r19 == 0) goto L_0x00d7
            r19.destroy()
        L_0x00d7:
            throw r0
        L_0x00d8:
            r19 = 0
        L_0x00da:
            if (r19 == 0) goto L_0x00df
            r19.destroy()
        L_0x00df:
            r1 = 0
        L_0x00e0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8762d.m25612Z(java.lang.String, int):com.introvd.template.sdk.model.editor.TemplateItemData");
    }

    @SafeVarargs
    /* renamed from: a */
    public static TemplateInfo m25613a(String str, List<TemplateInfo>... listArr) {
        try {
            for (List<TemplateInfo> it : listArr) {
                for (TemplateInfo templateInfo : it) {
                    if (TextUtils.equals(str, templateInfo.ttid)) {
                        return templateInfo;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    private String m25614a(QExternalFileInfo[] qExternalFileInfoArr) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (qExternalFileInfoArr != null && qExternalFileInfoArr.length > 0) {
                for (QExternalFileInfo qExternalFileInfo : qExternalFileInfoArr) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("fileID", qExternalFileInfo.fileID);
                    jSONObject.put("subTemplateID", qExternalFileInfo.subTemplateID);
                    jSONObject.put("fileName", qExternalFileInfo.fileName);
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0127, code lost:
        if ((((long) r5.nLayoutFlag) & (r21 & 31)) == 0) goto L_0x0132;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.ArrayList<java.lang.Long> m25615a(int r20, long r21, java.util.ArrayList<java.lang.Long> r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r3 = r23.iterator()
        L_0x000d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0138
            java.lang.Object r4 = r3.next()
            java.lang.Long r4 = (java.lang.Long) r4
            java.util.Map<java.lang.Long, com.introvd.template.sdk.model.editor.TemplateItemData> r5 = r0.eur
            java.lang.Object r5 = r5.get(r4)
            com.introvd.template.sdk.model.editor.TemplateItemData r5 = (com.introvd.template.sdk.model.editor.TemplateItemData) r5
            if (r5 != 0) goto L_0x0024
            goto L_0x000d
        L_0x0024:
            int r6 = r5.nDelFlag
            r7 = 1
            if (r6 != r7) goto L_0x002a
            goto L_0x000d
        L_0x002a:
            long r8 = r4.longValue()
            int r6 = xiaoying.engine.base.QStyle.QTemplateIDUtils.getTemplateType(r8)
            if (r6 == r1) goto L_0x0035
            goto L_0x000d
        L_0x0035:
            long r8 = r4.longValue()
            boolean r6 = r0.mo35230bG(r8)
            if (r6 != 0) goto L_0x0040
            goto L_0x000d
        L_0x0040:
            r8 = 65536(0x10000, double:3.2379E-319)
            long r8 = r21 & r8
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0056
            long r8 = r4.longValue()
            boolean r6 = r0.mo35232bI(r8)
            if (r6 == 0) goto L_0x0056
            goto L_0x000d
        L_0x0056:
            r8 = 524288(0x80000, double:2.590327E-318)
            long r8 = r21 & r8
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x006a
            long r8 = r4.longValue()
            boolean r6 = xiaoying.engine.base.QStyle.QTemplateIDUtils.isOfflineTemplate(r8)
            if (r6 == 0) goto L_0x006a
            goto L_0x000d
        L_0x006a:
            r8 = 3145728(0x300000, double:1.554196E-317)
            long r8 = r21 & r8
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0094
            long r8 = r4.longValue()
            boolean r6 = xiaoying.engine.base.QStyle.QTemplateIDUtils.isPhotoTemplate(r8)
            r8 = 1048576(0x100000, double:5.180654E-318)
            long r8 = r21 & r8
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0087
            if (r6 == 0) goto L_0x0087
            goto L_0x000d
        L_0x0087:
            r8 = 2097152(0x200000, double:1.0361308E-317)
            long r8 = r21 & r8
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0094
            if (r6 != 0) goto L_0x0094
            goto L_0x000d
        L_0x0094:
            r6 = 4
            if (r1 != r6) goto L_0x00f3
            long r12 = r4.longValue()
            boolean r6 = xiaoying.engine.base.QStyle.QTemplateIDUtils.isFunnyEffectTemplate(r12)
            if (r24 == 0) goto L_0x00a5
            if (r6 != 0) goto L_0x00a5
            goto L_0x000d
        L_0x00a5:
            if (r25 == 0) goto L_0x00ab
            if (r6 == 0) goto L_0x00ab
            goto L_0x000d
        L_0x00ab:
            long r13 = r4.longValue()
            boolean r6 = xiaoying.engine.base.QStyle.QTemplateIDUtils.isFBPreProcessTemplate(r13)
            if (r26 == 0) goto L_0x00b9
            if (r6 != 0) goto L_0x00b9
            goto L_0x000d
        L_0x00b9:
            if (r28 == 0) goto L_0x00bf
            if (r6 == 0) goto L_0x00bf
            goto L_0x000d
        L_0x00bf:
            long r15 = r4.longValue()
            boolean r6 = xiaoying.engine.base.QStyle.QTemplateIDUtils.isFBPostProcessTemplate(r15)
            if (r27 == 0) goto L_0x00cd
            if (r6 != 0) goto L_0x00cd
            goto L_0x000d
        L_0x00cd:
            if (r29 == 0) goto L_0x00d3
            if (r6 == 0) goto L_0x00d3
            goto L_0x000d
        L_0x00d3:
            r17 = 268435456(0x10000000, double:1.32624737E-315)
            long r17 = r21 & r17
            int r6 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x00de
            r6 = 1
            goto L_0x00df
        L_0x00de:
            r6 = 0
        L_0x00df:
            long r17 = r4.longValue()
            int r8 = xiaoying.engine.base.QStyle.QTemplateIDUtils.getTemplateSubType(r17)
            r7 = 6
            if (r8 != r7) goto L_0x00ec
            r7 = 1
            goto L_0x00ed
        L_0x00ec:
            r7 = 0
        L_0x00ed:
            if (r6 == 0) goto L_0x00f3
            if (r7 == 0) goto L_0x00f3
            goto L_0x000d
        L_0x00f3:
            r6 = 131072(0x20000, double:6.47582E-319)
            long r6 = r21 & r6
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0104
            int r6 = r5.nFavorite
            r7 = 1
            r6 = r6 & r7
            if (r6 != 0) goto L_0x0105
            goto L_0x000d
        L_0x0104:
            r7 = 1
        L_0x0105:
            r17 = 262144(0x40000, double:1.295163E-318)
            long r17 = r21 & r17
            int r6 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0114
            int r6 = r5.nFromType
            if (r6 == r7) goto L_0x0114
            goto L_0x000d
        L_0x0114:
            int r6 = r5.nLayoutFlag
            r7 = -1
            if (r6 == r7) goto L_0x012a
            int r6 = (r21 > r10 ? 1 : (r21 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x012a
            r6 = 31
            long r6 = r21 & r6
            int r8 = r5.nLayoutFlag
            long r0 = (long) r8
            long r0 = r0 & r6
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x012a
            goto L_0x0132
        L_0x012a:
            java.lang.String r0 = r5.strPath
            if (r0 == 0) goto L_0x0132
            r0 = 0
            r2.add(r0, r4)
        L_0x0132:
            r0 = r19
            r1 = r20
            goto L_0x000d
        L_0x0138:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8762d.m25615a(int, long, java.util.ArrayList, boolean, boolean, boolean, boolean, boolean, boolean):java.util.ArrayList");
    }

    /* renamed from: a */
    private void m25616a(String str, String str2, ArrayList<String> arrayList) {
        String[] strArr;
        if (str2.contains(";")) {
            strArr = str2.split("\\;");
        } else {
            strArr = new String[]{str2};
        }
        m25617a(str, strArr, arrayList);
    }

    /* renamed from: a */
    private void m25617a(String str, String[] strArr, ArrayList<String> arrayList) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    String absolutePath = file.getAbsolutePath();
                    if (!absolutePath.endsWith("Templates/push")) {
                        m25617a(absolutePath, strArr, arrayList);
                    }
                } else if (file.isFile()) {
                    String lowerCase = file.getName().toLowerCase(Locale.US);
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (lowerCase.endsWith(strArr[i])) {
                            arrayList.add(file.getAbsolutePath());
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m25618a(ArrayList<Long> arrayList, LongSparseArray<Long> longSparseArray) {
        if (arrayList != null && arrayList.size() > 0 && longSparseArray != null && longSparseArray.size() > 0) {
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                arrayList.remove(Long.valueOf(longSparseArray.keyAt(i)));
            }
        }
    }

    public static synchronized C8762d aMt() {
        C8762d dVar;
        synchronized (C8762d.class) {
            if (etT == null) {
                etT = new C8762d();
            }
            dVar = etT;
        }
        return dVar;
    }

    private void aMu() {
        if (eua != null) {
            eua.put(864691128455135257L, Integer.valueOf(1));
            eua.put(864691128455135256L, Integer.valueOf(1));
            eua.put(864691128455135252L, Integer.valueOf(1));
        }
    }

    /* renamed from: bA */
    private boolean m25619bA(long j) {
        if (j == -1) {
            return false;
        }
        TemplateItemData bD = mo35227bD(j);
        if (bD == null) {
            return false;
        }
        boolean z = true;
        if (bD.nFromType == 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: d */
    private ArrayList<Long> m25620d(long j, boolean z) {
        if (this.eur == null || this.eur.isEmpty() || QTemplateIDUtils.getTemplateType(j) != 1) {
            return null;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        HashSet<Long> hashSet = new HashSet<>();
        Set keySet = this.eur.keySet();
        try {
            if (keySet.size() > 0) {
                hashSet.addAll(keySet);
            }
        } catch (Exception unused) {
        }
        long templateSeqenceID = QTemplateIDUtils.getTemplateSeqenceID(j);
        for (Long l : hashSet) {
            if (l.longValue() != j && QTemplateIDUtils.isThemeSubTemplate(l.longValue()) && templateSeqenceID == QTemplateIDUtils.getTemplateSeqenceID(l.longValue())) {
                arrayList.add(l);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                TemplateItemData templateItemData = (TemplateItemData) this.eur.get(Long.valueOf(longValue));
                if (templateItemData == null || templateItemData.strPath == null) {
                    m25624k(longValue, 0);
                } else if (!z) {
                    m25624k(longValue, 1);
                } else {
                    m25625l(templateItemData.lID, templateItemData.strExtInfo);
                    C8548e.deleteFile(templateItemData.strPath);
                    C8758a.m25583cN(this.mContext, templateItemData.strPath);
                }
            }
        } catch (Exception unused2) {
        }
        return arrayList;
    }

    /* renamed from: e */
    private long m25621e(String str, int i, boolean z) {
        long j;
        try {
            TemplateItemData Z = m25612Z(str, i);
            if (Z == null) {
                return -1;
            }
            j = Z.lID;
            try {
                TemplateItemData bD = mo35227bD(j);
                if (bD != null) {
                    if (z && bD.nDelFlag == 1) {
                        bD.nDelFlag = 0;
                        C8761c.m25606a(this.mContext.getContentResolver(), j);
                    }
                    if (bD.nDelFlag == 1) {
                        return -1;
                    }
                    if (m25627qF(str) && !m25627qF(bD.strPath)) {
                        return -1;
                    }
                    if (Z.shouldOnlineDownload() && !bD.shouldOnlineDownload()) {
                        return -1;
                    }
                    Z.nOrder = bD.nOrder;
                    Z.nSubOrder = bD.nSubOrder;
                    Z.nFavorite = bD.nFavorite;
                    if (bD.strPath != null) {
                        this.eut.remove(bD.strPath);
                    }
                    if (bD.strPath != null && !bD.strPath.equals(Z.strPath) && !bD.strPath.startsWith(C8401d.aGT())) {
                        String str2 = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("    delete4:");
                        sb.append(bD.strPath);
                        C8554j.m25007e(str2, sb.toString());
                        C8548e.deleteFile(bD.strPath);
                    }
                }
                if (this.eur != null) {
                    this.eur.put(Long.valueOf(Z.lID), Z);
                }
                this.eut.put(Z.strPath, Long.valueOf(Z.lID));
                C8761c.m25607a(this.mContext.getContentResolver(), Z);
            } catch (Throwable unused) {
            }
            return j;
        } catch (Throwable unused2) {
            j = -1;
        }
    }

    /* renamed from: hr */
    private boolean m25622hr(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            ArrayList arrayList = new ArrayList();
            ArrayList i = C8761c.m25610i(contentResolver);
            if (i != null) {
                if (i.size() != 0) {
                    Iterator it = i.iterator();
                    while (it.hasNext()) {
                        TemplateItemData templateItemData = (TemplateItemData) it.next();
                        if (!C8450a.m24475nY(templateItemData.strPath)) {
                            arrayList.add(Long.valueOf(templateItemData.lID));
                        } else {
                            this.eur.put(Long.valueOf(templateItemData.lID), templateItemData);
                            this.eut.put(templateItemData.strPath, Long.valueOf(templateItemData.lID));
                        }
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        m25624k(((Long) arrayList.get(i2)).longValue(), 0);
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: i */
    private boolean m25623i(long j, long j2) {
        long j3 = j & 263882790666240L;
        boolean z = true;
        if (j3 <= 0) {
            return true;
        }
        if ((j3 >> 44) != j2) {
            z = false;
        }
        return z;
    }

    /* renamed from: k */
    private boolean m25624k(long j, int i) {
        if (this.eur == null || this.mContext == null) {
            return false;
        }
        TemplateItemData templateItemData = (TemplateItemData) this.eur.remove(Long.valueOf(j));
        if (!(templateItemData == null || templateItemData.strPath == null)) {
            this.eut.remove(templateItemData.strPath);
        }
        ContentResolver contentResolver = this.mContext.getContentResolver();
        if (1 == i) {
            C8761c.m25609c(contentResolver, j);
        } else {
            C8761c.m25608b(contentResolver, j);
        }
        return true;
    }

    /* renamed from: l */
    private void m25625l(long j, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String templateExternalFile = getTemplateExternalFile(j, jSONObject.optInt("subTemplateID"), jSONObject.optInt("fileID"));
                    if (templateExternalFile != null && C8450a.m24475nY(templateExternalFile)) {
                        String qI = m25629qI(templateExternalFile);
                        if (!arrayList.contains(qI)) {
                            arrayList.add(qI);
                        }
                        C8548e.deleteFile(templateExternalFile);
                    }
                }
                String absolutePath = new File(C8401d.aGR()).getAbsolutePath();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!str2.equals(absolutePath)) {
                        File file = new File(str2);
                        if (file.exists() && file.isDirectory()) {
                            String[] list = file.list();
                            if (list == null || list.length == 0) {
                                C8548e.deleteDirectory(str2);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                C8554j.m25007e(TAG, e.toString());
            }
        }
    }

    /* renamed from: qE */
    private boolean m25626qE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long templateID = getTemplateID(str);
        return templateID != -1 ? m25619bA(templateID) : m25627qF(str);
    }

    /* renamed from: qF */
    private boolean m25627qF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(QStreamAssets.ASSETS_THEME);
    }

    /* renamed from: qH */
    private boolean m25628qH(String str) {
        boolean z = false;
        if (this.eur == null || this.eur.isEmpty()) {
            return false;
        }
        if (!TextUtils.equals(str, "assets_android://xiaoying/theme/4300000000000055.xyt")) {
            if (getTemplateID(str) != -1) {
                z = true;
            }
            return z;
        } else if (!this.eur.containsKey(Long.valueOf(4827858800541171797L))) {
            return false;
        } else {
            TemplateItemData templateItemData = (TemplateItemData) this.eur.get(Long.valueOf(4827858800541171797L));
            if (templateItemData == null || templateItemData.strExtInfo == null || !templateItemData.strExtInfo.contains("0x4300000000000055")) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: qI */
    private String m25629qI(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:10|11|12|(1:14)|15|16|(2:17|(3:19|(2:21|43)(2:22|(5:41|24|(1:26)(1:27)|28|(1:30)(3:31|(1:35)|36))(1:44))|40)(1:42))|38) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e A[Catch:{ Exception -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0099 A[EDGE_INSN: B:42:0x0099->B:38:0x0099 ?: BREAK  
    EDGE_INSN: B:42:0x0099->B:38:0x0099 ?: BREAK  , SYNTHETIC] */
    /* renamed from: B */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.Long> mo35218B(java.lang.String r7, boolean r8) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0099 }
            r2 = 0
            if (r1 == 0) goto L_0x000d
            return r2
        L_0x000d:
            android.content.Context r1 = r6.mContext     // Catch:{ Exception -> 0x0099 }
            com.introvd.template.template.p409g.C8758a.m25583cN(r1, r7)     // Catch:{ Exception -> 0x0099 }
            java.util.Map<java.lang.Long, com.introvd.template.sdk.model.editor.TemplateItemData> r1 = r6.eur     // Catch:{ Exception -> 0x0099 }
            if (r1 == 0) goto L_0x0098
            java.util.Map<java.lang.Long, com.introvd.template.sdk.model.editor.TemplateItemData> r1 = r6.eur     // Catch:{ Exception -> 0x0099 }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0099 }
            if (r1 == 0) goto L_0x0020
            goto L_0x0098
        L_0x0020:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ Exception -> 0x0099 }
            r1.<init>()     // Catch:{ Exception -> 0x0099 }
            java.util.Map<java.lang.Long, com.introvd.template.sdk.model.editor.TemplateItemData> r2 = r6.eur     // Catch:{ Exception -> 0x0099 }
            java.util.Set r2 = r2.keySet()     // Catch:{ Exception -> 0x0099 }
            int r3 = r2.size()     // Catch:{ Exception -> 0x0034 }
            if (r3 <= 0) goto L_0x0034
            r1.addAll(r2)     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0099 }
        L_0x0038:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0099 }
            if (r2 == 0) goto L_0x0099
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0099 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ Exception -> 0x0099 }
            java.util.Map<java.lang.Long, com.introvd.template.sdk.model.editor.TemplateItemData> r3 = r6.eur     // Catch:{ Exception -> 0x0099 }
            java.lang.Object r2 = r3.get(r2)     // Catch:{ Exception -> 0x0099 }
            com.introvd.template.sdk.model.editor.TemplateItemData r2 = (com.introvd.template.sdk.model.editor.TemplateItemData) r2     // Catch:{ Exception -> 0x0099 }
            if (r2 != 0) goto L_0x004f
            goto L_0x0038
        L_0x004f:
            java.lang.String r3 = r2.strPath     // Catch:{ Exception -> 0x0099 }
            boolean r3 = r7.equals(r3)     // Catch:{ Exception -> 0x0099 }
            if (r3 == 0) goto L_0x0038
            r1 = 0
            if (r8 == 0) goto L_0x005c
            r8 = 0
            goto L_0x0060
        L_0x005c:
            boolean r8 = r6.m25626qE(r7)     // Catch:{ Exception -> 0x0099 }
        L_0x0060:
            r3 = 1
            if (r8 == 0) goto L_0x006e
            long r7 = r2.lID     // Catch:{ Exception -> 0x0099 }
            r6.m25624k(r7, r3)     // Catch:{ Exception -> 0x0099 }
            long r7 = r2.lID     // Catch:{ Exception -> 0x0099 }
            r6.m25620d(r7, r1)     // Catch:{ Exception -> 0x0099 }
            goto L_0x0099
        L_0x006e:
            long r4 = r2.lID     // Catch:{ Exception -> 0x0099 }
            java.lang.String r8 = r2.strExtInfo     // Catch:{ Exception -> 0x0099 }
            r6.m25625l(r4, r8)     // Catch:{ Exception -> 0x0099 }
            long r4 = r2.lID     // Catch:{ Exception -> 0x0099 }
            r6.m25624k(r4, r1)     // Catch:{ Exception -> 0x0099 }
            long r4 = r2.lID     // Catch:{ Exception -> 0x0099 }
            java.lang.Long r8 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0099 }
            r0.add(r8)     // Catch:{ Exception -> 0x0099 }
            long r1 = r2.lID     // Catch:{ Exception -> 0x0099 }
            java.util.ArrayList r8 = r6.m25620d(r1, r3)     // Catch:{ Exception -> 0x0099 }
            if (r8 == 0) goto L_0x0094
            boolean r1 = r8.isEmpty()     // Catch:{ Exception -> 0x0099 }
            if (r1 != 0) goto L_0x0094
            r0.addAll(r8)     // Catch:{ Exception -> 0x0099 }
        L_0x0094:
            com.introvd.template.sdk.utils.C8548e.deleteFile(r7)     // Catch:{ Exception -> 0x0099 }
            goto L_0x0099
        L_0x0098:
            return r2
        L_0x0099:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8762d.mo35218B(java.lang.String, boolean):java.util.ArrayList");
    }

    /* renamed from: Q */
    public boolean mo35219Q(Context context, boolean z) {
        Long[][] lArr;
        this.etX = z;
        this.mContext = context.getApplicationContext();
        this.mAssetManager = context.getAssets();
        if (this.dmh) {
            return true;
        }
        for (Long[] lArr2 : etS) {
            this.etR.put(lArr2[0].longValue(), lArr2[1]);
        }
        this.eul = new long[0];
        this.eui = new long[0];
        this.euj = new long[0];
        this.eub = new long[0];
        this.euo = new long[0];
        this.euk = new long[0];
        this.euf = new long[0];
        this.eug = new long[0];
        this.euh = new long[0];
        this.euc = new long[0];
        this.eud = new long[0];
        this.eue = new long[0];
        this.eum = new long[0];
        this.eun = new long[0];
        this.eup = new long[0];
        if (this.eut == null) {
            this.eut = Collections.synchronizedMap(new LinkedHashMap());
        }
        if (this.eur == null) {
            this.eur = Collections.synchronizedMap(new LinkedHashMap());
            m25622hr(context);
        }
        aMu();
        this.dmh = true;
        return true;
    }

    /* renamed from: a */
    public Bitmap mo35220a(long j, int i, int i2, QEngine qEngine) {
        Bitmap bitmap;
        TemplateItemData templateItemData = (TemplateItemData) this.eur.get(Long.valueOf(j));
        if (templateItemData == null || templateItemData.strPath == null) {
            return null;
        }
        if (i <= 0) {
            i = etU;
        }
        if (i2 <= 0) {
            i2 = etU;
        }
        int templateType = QTemplateIDUtils.getTemplateType(j);
        if (templateType != 12) {
            switch (templateType) {
                case 8:
                    i = 0;
                    i2 = 0;
                    break;
                case 9:
                    if (i <= etU) {
                        i = (etU * 3) / 2;
                    }
                    if (i2 <= etU) {
                        i2 = (etU * 3) / 2;
                        break;
                    }
                    break;
            }
        } else {
            int i3 = etV;
            if ((templateItemData.nLayoutFlag & 8) == 8) {
                i2 = etV;
                i = (etV * 16) / 9;
            } else if ((templateItemData.nLayoutFlag & 2) == 2) {
                i2 = etV;
                i = (etV * 4) / 3;
            } else {
                i = etV;
                i2 = etV;
            }
        }
        QBitmap createQBitmapBlank_noSkia = QBitmapFactory.createQBitmapBlank_noSkia(i, i2, QColorSpace.QPAF_RGB32_A8R8G8B8);
        if (createQBitmapBlank_noSkia == null) {
            return null;
        }
        QStyle qStyle = new QStyle();
        try {
            if (qStyle.create(templateItemData.strPath, null, 1) != 0) {
                bitmap = null;
            } else if (qStyle.getThumbnail(qEngine, createQBitmapBlank_noSkia) != 0) {
                return null;
            } else {
                bitmap = QAndroidBitmapFactory.createBitmapFromQBitmap(createQBitmapBlank_noSkia, false);
            }
            qStyle.destroy();
            createQBitmapBlank_noSkia.recycle();
            return bitmap;
        } catch (Throwable unused) {
            return null;
        } finally {
            qStyle.destroy();
            createQBitmapBlank_noSkia.recycle();
        }
    }

    /* renamed from: a */
    public List<String> mo35221a(String str, List<String> list, int i, String str2) {
        return mo35222a(str, list, i, str2, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x016d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo35222a(java.lang.String r11, java.util.List<java.lang.String> r12, int r13, java.lang.String r14, boolean r15) {
        /*
            r10 = this;
            boolean r14 = android.text.TextUtils.isEmpty(r11)
            r0 = 0
            if (r14 == 0) goto L_0x0008
            return r0
        L_0x0008:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.lang.String r1 = com.introvd.template.sdk.utils.C8548e.getFileExtFromAbPath(r11)
            java.lang.String r2 = ".zip"
            boolean r1 = r1.equalsIgnoreCase(r2)
            r2 = 1
            if (r1 != 0) goto L_0x0020
            r14.add(r11)
            r3 = r0
            goto L_0x0094
        L_0x0020:
            java.lang.String r3 = r10.m25629qI(r11)     // Catch:{ Exception -> 0x0061, all -> 0x005d }
            java.util.ArrayList r3 = com.introvd.template.sdk.utils.C8573z.UnZipFolder(r11, r3)     // Catch:{ Exception -> 0x0061, all -> 0x005d }
            if (r13 != r2) goto L_0x0032
            android.content.Context r4 = r10.mContext     // Catch:{ Exception -> 0x0030 }
            com.introvd.template.template.p409g.C8758a.m25583cN(r4, r11)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0032
        L_0x0030:
            r4 = move-exception
            goto L_0x0063
        L_0x0032:
            com.introvd.template.sdk.utils.C8548e.deleteFile(r11)     // Catch:{ Exception -> 0x0030 }
            if (r3 == 0) goto L_0x0094
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0094
            java.util.Iterator r4 = r3.iterator()
        L_0x0041:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0094
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = com.introvd.template.sdk.utils.C8548e.getFileExtFromAbPath(r5)
            java.lang.String r7 = ".xyt"
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x0041
            r14.add(r5)
            goto L_0x0041
        L_0x005d:
            r11 = move-exception
            r3 = r0
            goto L_0x015b
        L_0x0061:
            r4 = move-exception
            r3 = r0
        L_0x0063:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x015a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x015a }
            com.introvd.template.sdk.utils.C8554j.m25007e(r5, r4)     // Catch:{ all -> 0x015a }
            if (r3 == 0) goto L_0x0094
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0094
            java.util.Iterator r4 = r3.iterator()
        L_0x0078:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0094
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = com.introvd.template.sdk.utils.C8548e.getFileExtFromAbPath(r5)
            java.lang.String r7 = ".xyt"
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x0078
            r14.add(r5)
            goto L_0x0078
        L_0x0094:
            boolean r4 = r14.isEmpty()
            if (r4 == 0) goto L_0x009b
            return r0
        L_0x009b:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4 = 0
            r5 = 0
        L_0x00a2:
            int r6 = r14.size()
            if (r5 >= r6) goto L_0x00dd
            java.lang.Object r6 = r14.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = com.introvd.template.sdk.utils.C8548e.getFileExtFromAbPath(r6)
            java.lang.String r8 = ".xyt"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 != 0) goto L_0x00bb
            goto L_0x00da
        L_0x00bb:
            if (r15 != 0) goto L_0x00c3
            boolean r7 = r10.m25628qH(r6)
            if (r7 != 0) goto L_0x00da
        L_0x00c3:
            long r6 = r10.m25621e(r6, r13, r15)
            r8 = -1
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x00ce
            goto L_0x00de
        L_0x00ce:
            com.introvd.template.sdk.model.editor.TemplateItemData r6 = r10.mo35227bD(r6)
            if (r6 != 0) goto L_0x00d5
            goto L_0x00de
        L_0x00d5:
            java.lang.String r6 = r6.strPath
            r0.add(r6)
        L_0x00da:
            int r5 = r5 + 1
            goto L_0x00a2
        L_0x00dd:
            r2 = 0
        L_0x00de:
            if (r12 == 0) goto L_0x00e6
            r12.clear()
            r12.addAll(r14)
        L_0x00e6:
            if (r2 == 0) goto L_0x0159
            java.lang.String r12 = TAG
            java.lang.String r13 = "===========Start rollback==========="
            com.introvd.template.sdk.utils.C8554j.m25007e(r12, r13)
            if (r1 == 0) goto L_0x0130
            if (r3 == 0) goto L_0x014f
            boolean r11 = r3.isEmpty()
            if (r11 != 0) goto L_0x014f
            java.util.Iterator r11 = r3.iterator()
        L_0x00fd:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x014f
            java.lang.Object r12 = r11.next()
            java.lang.String r12 = (java.lang.String) r12
            long r13 = r10.getTemplateID(r12)
            r1 = 0
            int r15 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r15 <= 0) goto L_0x0116
            r10.m25624k(r13, r4)
        L_0x0116:
            com.introvd.template.sdk.utils.C8548e.deleteFile(r12)
            java.lang.String r13 = TAG
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "    delete2:"
            r14.append(r15)
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            com.introvd.template.sdk.utils.C8554j.m25007e(r13, r12)
            goto L_0x00fd
        L_0x0130:
            boolean r12 = r10.m25627qF(r11)
            if (r12 != 0) goto L_0x014f
            com.introvd.template.sdk.utils.C8548e.deleteFile(r11)
            java.lang.String r12 = TAG
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "    delete3:"
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            com.introvd.template.sdk.utils.C8554j.m25007e(r12, r11)
        L_0x014f:
            java.lang.String r11 = TAG
            java.lang.String r12 = "===========End rollback==========="
            com.introvd.template.sdk.utils.C8554j.m25007e(r11, r12)
            r0.clear()
        L_0x0159:
            return r0
        L_0x015a:
            r11 = move-exception
        L_0x015b:
            if (r3 == 0) goto L_0x0183
            boolean r12 = r3.isEmpty()
            if (r12 != 0) goto L_0x0183
            java.util.Iterator r12 = r3.iterator()
        L_0x0167:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0183
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r15 = com.introvd.template.sdk.utils.C8548e.getFileExtFromAbPath(r13)
            java.lang.String r0 = ".xyt"
            boolean r15 = r15.equalsIgnoreCase(r0)
            if (r15 == 0) goto L_0x0167
            r14.add(r13)
            goto L_0x0167
        L_0x0183:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8762d.mo35222a(java.lang.String, java.util.List, int, java.lang.String, boolean):java.util.List");
    }

    /* renamed from: a */
    public void mo35223a(ArrayList<String> arrayList, boolean z, int i, String str) {
        if (arrayList != null && !arrayList.isEmpty()) {
            boolean z2 = true;
            if (!this.eus) {
                if (this.mContext != null) {
                    C8553i.setContext(this.mContext.getApplicationContext());
                }
                C8553i.m25005ut(55);
                this.eus = true;
            } else {
                z2 = false;
            }
            Thread currentThread = Thread.currentThread();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                mo35222a((String) arrayList.get(i2), null, i, str, z);
                if (currentThread.isInterrupted()) {
                    break;
                }
            }
            if (z2) {
                this.eus = false;
            }
        }
    }

    /* renamed from: aa */
    public String mo35224aa(String str, int i) {
        return mo35241l(getTemplateID(str), i);
    }

    /* renamed from: bB */
    public String mo35225bB(long j) {
        if (this.eur == null) {
            return null;
        }
        TemplateItemData templateItemData = (TemplateItemData) this.eur.get(Long.valueOf(j));
        if (templateItemData != null) {
            return templateItemData.strPath;
        }
        return null;
    }

    /* renamed from: bC */
    public int mo35226bC(long j) {
        if (this.eur == null) {
            return 0;
        }
        TemplateItemData templateItemData = (TemplateItemData) this.eur.get(Long.valueOf(j));
        if (templateItemData == null || templateItemData.strPath == null) {
            return 0;
        }
        return templateItemData.nFavorite;
    }

    /* renamed from: bD */
    public TemplateItemData mo35227bD(long j) {
        if (this.eur == null) {
            return null;
        }
        return (TemplateItemData) this.eur.get(Long.valueOf(j));
    }

    /* renamed from: bE */
    public boolean mo35228bE(long j) {
        TemplateItemData bD = mo35227bD(j);
        if (bD == null || bD.shouldOnlineDownload()) {
            return true;
        }
        String str = bD.strPath;
        return TextUtils.isEmpty(str) || !C8548e.isFileExisted(str);
    }

    /* renamed from: bF */
    public int mo35229bF(long j) {
        TemplateItemData bD = mo35227bD(j);
        if (bD != null) {
            return bD.nLayoutFlag;
        }
        return 0;
    }

    /* renamed from: bG */
    public boolean mo35230bG(long j) {
        if (QTemplateIDUtils.getTemplateType(j) == 2) {
            return false;
        }
        return QTemplateIDUtils.isPublicTemplate(j);
    }

    /* renamed from: bH */
    public boolean mo35231bH(long j) {
        return (mo35226bC(j) & 1) != 0;
    }

    /* renamed from: bI */
    public boolean mo35232bI(long j) {
        long[] jArr = etZ;
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (jArr[i] == j) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: bJ */
    public long mo35233bJ(long j) {
        return ((Long) this.etR.get(j, Long.valueOf(j))).longValue();
    }

    /* renamed from: bK */
    public boolean mo35234bK(long j) {
        return eua != null && eua.containsKey(j);
    }

    /* renamed from: c */
    public ArrayList<Long> mo35235c(int i, long j, long j2) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        int i2 = i;
        if (this.eur == null || this.eur.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(this.eur.keySet());
        } catch (Exception unused) {
        }
        m25618a(arrayList, this.etR);
        boolean z = (j & 4194304) != 0;
        boolean z2 = (j & 8388608) != 0;
        boolean z3 = (j & 16777216) != 0;
        boolean z4 = (j & 33554432) != 0;
        boolean z5 = (j & 67108864) != 0;
        boolean z6 = (j & 134217728) != 0;
        ArrayList a = m25615a(i, j, arrayList, z, z2, z3, z4, z5, z6);
        if (a.size() > 0) {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                if (!m25623i(((Long) it.next()).longValue(), j2)) {
                    it.remove();
                }
            }
        }
        for (long valueOf : euq) {
            a.remove(Long.valueOf(valueOf));
        }
        if (!this.etX) {
            for (long valueOf2 : this.eup) {
                a.remove(Long.valueOf(valueOf2));
            }
        }
        ArrayList<Long> arrayList2 = new ArrayList<>();
        if ((j & 65536) == 0) {
            if (i2 == 4 && z4) {
                a.add(Long.valueOf(QStyle.NONE_FILTER_TEMPLATE_ID));
            }
            for (long j3 : etY) {
                int i3 = 0;
                while (true) {
                    if (i3 >= a.size()) {
                        break;
                    }
                    long longValue = ((Long) a.get(i3)).longValue();
                    if (j3 == longValue) {
                        arrayList2.add(Long.valueOf(j3));
                        TemplateItemData bD = mo35227bD(longValue);
                        if (bD != null) {
                            bD.nOrder = -1;
                            bD.nOriOrder = -1;
                        }
                        a.remove(i3);
                    } else {
                        i3++;
                    }
                }
            }
        }
        List list = (List) this.etW.get(Integer.valueOf(i));
        if (list != null && !list.isEmpty()) {
            try {
                for (Long l : new ArrayList(list)) {
                    if (a.remove(l)) {
                        arrayList2.add(l);
                        TemplateItemData bD2 = mo35227bD(l.longValue());
                        if (bD2 != null && (bD2.nOrder == 0 || bD2.nOrder == Integer.MAX_VALUE)) {
                            bD2.nOrder = -1;
                            bD2.nOriOrder = -1;
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        int i4 = 0;
        while (i4 < a.size()) {
            long longValue2 = ((Long) a.get(i4)).longValue();
            TemplateItemData bD3 = mo35227bD(longValue2);
            if (bD3 == null || bD3.nFromType != 1) {
                i4++;
            } else {
                arrayList2.add(Long.valueOf(longValue2));
                a.remove(i4);
            }
        }
        switch (i2) {
            case 1:
                if ((j & 1048576) == 0) {
                    jArr = this.euh;
                    break;
                } else {
                    jArr = this.eug;
                    break;
                }
            case 3:
                jArr = this.euf;
                break;
            case 4:
                if (!z) {
                    if (!z3) {
                        if (!z4) {
                            long[][] jArr4 = {this.eud, this.eue, this.eub, this.euc};
                            if (z5) {
                                jArr2 = null;
                                jArr4[0] = null;
                            } else {
                                jArr2 = null;
                            }
                            if (z6) {
                                jArr4[1] = jArr2;
                            }
                            if (z2) {
                                jArr4[3] = jArr2;
                            }
                            int i5 = 0;
                            for (long[] jArr5 : jArr4) {
                                if (jArr5 != null) {
                                    i5 += jArr5.length;
                                }
                            }
                            jArr = new long[i5];
                            int i6 = 0;
                            for (long[] jArr6 : jArr4) {
                                if (jArr6 != null) {
                                    System.arraycopy(jArr6, 0, jArr, i6, jArr6.length);
                                    i6 += jArr6.length;
                                }
                            }
                            break;
                        } else {
                            jArr = this.eue;
                            break;
                        }
                    } else {
                        jArr = this.eud;
                        break;
                    }
                } else {
                    jArr = this.euc;
                    break;
                }
            case 5:
                jArr = this.eum;
                break;
            case 6:
                jArr = this.eul;
                break;
            case 7:
                jArr = this.euj;
                break;
            case 8:
                jArr = this.euk;
                break;
            case 9:
                jArr = this.eui;
                break;
            case 12:
                jArr = this.euo;
                break;
            case 13:
                jArr = this.eun;
                break;
            default:
                jArr = null;
                break;
        }
        if (jArr != null) {
            for (long j4 : jArr) {
                int i7 = 0;
                while (true) {
                    if (i7 < a.size()) {
                        if (j4 == ((Long) a.get(i7)).longValue()) {
                            if ((72057594037927935L & j4) != 0 || arrayList2.isEmpty()) {
                                arrayList2.add(Long.valueOf(j4));
                            } else {
                                arrayList2.add(0, Long.valueOf(j4));
                            }
                            a.remove(i7);
                            String str = TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("TMPLATEresult sqTemplateId:");
                            sb.append(j4);
                            C8554j.m25008i(str, sb.toString());
                        } else {
                            i7++;
                        }
                    }
                }
            }
        }
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TMPLATEresult count:");
        sb2.append(arrayList2.size());
        C8554j.m25008i(str2, sb2.toString());
        arrayList2.addAll(a);
        int i8 = 4;
        if (i2 == 4) {
            if (!z6 && !z4) {
                ArrayList arrayList3 = new ArrayList();
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    long longValue3 = ((Long) arrayList2.get(size)).longValue();
                    TemplateItemData bD4 = mo35227bD(longValue3);
                    if (!(bD4 == null || bD4.nFromType == 1 || !QTemplateIDUtils.isFBPostProcessTemplate(longValue3))) {
                        arrayList3.add(0, arrayList2.remove(size));
                    }
                }
                arrayList2.addAll(arrayList3);
            }
            i8 = 4;
        }
        if (i2 == i8 && !z2 && !z) {
            ArrayList arrayList4 = new ArrayList();
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                long longValue4 = ((Long) arrayList2.get(size2)).longValue();
                TemplateItemData bD5 = mo35227bD(longValue4);
                if (bD5 != null && bD5.nFromType != 1 && QTemplateIDUtils.isFunnyEffectTemplate(longValue4)) {
                    arrayList4.add(0, arrayList2.remove(size2));
                }
            }
            arrayList2.addAll(arrayList4);
        }
        final ArrayList arrayList5 = new ArrayList(arrayList2);
        if (!arrayList2.isEmpty()) {
            Collections.sort(arrayList2, new Comparator<Long>() {
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
                    if (r0.indexOf(r6) <= r0.indexOf(r7)) goto L_0x0034;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public int compare(java.lang.Long r6, java.lang.Long r7) {
                    /*
                        r5 = this;
                        com.introvd.template.template.g.d r0 = com.introvd.template.template.p409g.C8762d.this
                        long r1 = r6.longValue()
                        com.introvd.template.sdk.model.editor.TemplateItemData r0 = r0.mo35227bD(r1)
                        com.introvd.template.template.g.d r1 = com.introvd.template.template.p409g.C8762d.this
                        long r2 = r7.longValue()
                        com.introvd.template.sdk.model.editor.TemplateItemData r1 = r1.mo35227bD(r2)
                        r2 = 0
                        if (r0 == 0) goto L_0x0036
                        if (r1 != 0) goto L_0x001a
                        goto L_0x0036
                    L_0x001a:
                        int r0 = r0.nOrder
                        int r1 = r1.nOrder
                        r3 = -1
                        r4 = 1
                        if (r0 <= r1) goto L_0x0024
                    L_0x0022:
                        r2 = 1
                        goto L_0x0035
                    L_0x0024:
                        if (r0 != r1) goto L_0x0034
                        java.util.ArrayList r0 = r0     // Catch:{ Throwable -> 0x0035 }
                        int r6 = r0.indexOf(r6)     // Catch:{ Throwable -> 0x0035 }
                        java.util.ArrayList r0 = r0     // Catch:{ Throwable -> 0x0035 }
                        int r7 = r0.indexOf(r7)     // Catch:{ Throwable -> 0x0035 }
                        if (r6 > r7) goto L_0x0022
                    L_0x0034:
                        r2 = -1
                    L_0x0035:
                        return r2
                    L_0x0036:
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8762d.C87631.compare(java.lang.Long, java.lang.Long):int");
                }
            });
        }
        return arrayList2;
    }

    /* renamed from: c */
    public void mo35236c(Context context, String str, int i, boolean z) {
        if (this.eur != null) {
            ArrayList arrayList = new ArrayList();
            m25616a(str, ".xyt;.zip", arrayList);
            mo35223a(arrayList, z, i, (String) null);
        }
    }

    /* renamed from: d */
    public String mo35237d(String str, String str2, int i) {
        String str3;
        String A = m25611A(i, str2);
        if (TextUtils.isEmpty(A)) {
            QStyle qStyle = new QStyle();
            if (qStyle.create(str, null, 1) != 0) {
                qStyle.destroy();
                return null;
            }
            str3 = qStyle.getTemplateName(i);
            qStyle.destroy();
        } else {
            str3 = A;
        }
        return str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r8 = r2.optString("fileName");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (android.text.TextUtils.isEmpty(r8) == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r6 = m25629qI(r6.strPath);
        r9 = new java.lang.StringBuilder();
        r9.append(r6);
        r9.append(java.io.File.separator);
        r9.append(r8);
        r6 = r9.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r6.endsWith(".xyt") == false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        if (getTemplateID(r6) >= 0) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0070, code lost:
        mo35221a(r6, null, r6.startsWith(xiaoying.utils.QStreamAssets.ASSETS_THEME) ^ true ? 1 : 0, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        if (r6.startsWith(xiaoying.utils.QStreamAssets.ASSETS_THEME) == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0084, code lost:
        r7 = r6.replace("assets_android://xiaoying/", com.introvd.template.sdk.C8401d.aGR());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0092, code lost:
        if (com.introvd.template.sdk.utils.C8548e.isFileExisted(r7) != false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0094, code lost:
        com.introvd.template.sdk.utils.C8548e.createMultilevelDirectory(new java.io.File(r7).getParent());
        com.introvd.template.sdk.utils.C8548e.copyFileFromAssets(r6.substring(xiaoying.utils.QStreamAssets.ASSETS_THEME.length()), r7, r5.mAssetManager);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b2, code lost:
        r7 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTemplateExternalFile(long r6, int r8, int r9) {
        /*
            r5 = this;
            com.introvd.template.template.g.d r0 = aMt()
            com.introvd.template.sdk.model.editor.TemplateItemData r6 = r0.mo35227bD(r6)
            r7 = 0
            if (r6 != 0) goto L_0x000c
            return r7
        L_0x000c:
            java.lang.String r0 = r6.strExtInfo
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0015
            return r7
        L_0x0015:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r1 = r6.strExtInfo     // Catch:{ Exception -> 0x00b8 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00b8 }
            r1 = 0
        L_0x001d:
            int r2 = r0.length()     // Catch:{ Exception -> 0x00b8 }
            if (r1 >= r2) goto L_0x00b8
            org.json.JSONObject r2 = r0.getJSONObject(r1)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r3 = "subTemplateID"
            int r3 = r2.optInt(r3)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r4 = "fileID"
            int r4 = r2.optInt(r4)     // Catch:{ Exception -> 0x00b8 }
            if (r8 != r3) goto L_0x00b4
            if (r4 != r9) goto L_0x00b4
            java.lang.String r8 = "fileName"
            java.lang.String r8 = r2.optString(r8)     // Catch:{ Exception -> 0x00b8 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00b2 }
            if (r9 == 0) goto L_0x0044
            return r7
        L_0x0044:
            java.lang.String r6 = r6.strPath     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r6 = r5.m25629qI(r6)     // Catch:{ Exception -> 0x00b2 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2 }
            r9.<init>()     // Catch:{ Exception -> 0x00b2 }
            r9.append(r6)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x00b2 }
            r9.append(r6)     // Catch:{ Exception -> 0x00b2 }
            r9.append(r8)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = ".xyt"
            boolean r8 = r6.endsWith(r8)     // Catch:{ Exception -> 0x00b0 }
            if (r8 == 0) goto L_0x007c
            long r8 = r5.getTemplateID(r6)     // Catch:{ Exception -> 0x00b0 }
            r0 = 0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x00b0
            java.lang.String r8 = "assets_android://"
            boolean r8 = r6.startsWith(r8)     // Catch:{ Exception -> 0x00b0 }
            r8 = r8 ^ 1
            r5.mo35221a(r6, r7, r8, r7)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00b0
        L_0x007c:
            java.lang.String r7 = "assets_android://"
            boolean r7 = r6.startsWith(r7)     // Catch:{ Exception -> 0x00b0 }
            if (r7 == 0) goto L_0x00b0
            java.lang.String r7 = "assets_android://xiaoying/"
            java.lang.String r8 = com.introvd.template.sdk.C8401d.aGR()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r7 = r6.replace(r7, r8)     // Catch:{ Exception -> 0x00b0 }
            boolean r8 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r7)     // Catch:{ Exception -> 0x00b8 }
            if (r8 != 0) goto L_0x00b8
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00b8 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r8 = r8.getParent()     // Catch:{ Exception -> 0x00b8 }
            com.introvd.template.sdk.utils.C8548e.createMultilevelDirectory(r8)     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r8 = "assets_android://"
            int r8 = r8.length()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r6 = r6.substring(r8)     // Catch:{ Exception -> 0x00b8 }
            android.content.res.AssetManager r8 = r5.mAssetManager     // Catch:{ Exception -> 0x00b8 }
            com.introvd.template.sdk.utils.C8548e.copyFileFromAssets(r6, r7, r8)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b8
        L_0x00b0:
            r7 = r6
            goto L_0x00b8
        L_0x00b2:
            r7 = r8
            goto L_0x00b8
        L_0x00b4:
            int r1 = r1 + 1
            goto L_0x001d
        L_0x00b8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8762d.getTemplateExternalFile(long, int, int):java.lang.String");
    }

    public long getTemplateID(String str) {
        long j = -1;
        if (this.eut == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        Long l = (Long) this.eut.get(str);
        if (l != null) {
            j = l.longValue();
        }
        return j;
    }

    /* renamed from: h */
    public ArrayList<Long> mo35240h(int i, long j) {
        return mo35235c(i, j, 0);
    }

    /* renamed from: l */
    public String mo35241l(long j, int i) {
        if (this.eur == null) {
            return null;
        }
        TemplateItemData templateItemData = (TemplateItemData) this.eur.get(Long.valueOf(j));
        if (templateItemData == null || templateItemData.strPath == null) {
            return null;
        }
        if (templateItemData.mTitleList == null) {
            templateItemData.mTitleList = new SparseArray<>();
        }
        String str = (String) templateItemData.mTitleList.get(i);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String d = mo35237d(templateItemData.strPath, templateItemData.strTitleJSON, i);
        if (!TextUtils.isEmpty(d)) {
            templateItemData.mTitleList.put(i, d);
        }
        return d;
    }

    /* renamed from: qG */
    public ArrayList<Long> mo35242qG(String str) {
        return mo35218B(str, false);
    }

    public void uninit() {
        if (this.eur != null) {
            this.eur.clear();
            this.eur = null;
        }
        if (this.eut != null) {
            this.eut.clear();
            this.eut = null;
        }
        this.dmh = false;
    }

    /* renamed from: vk */
    public String mo35244vk(int i) {
        if (i < 0 || i >= etQ.length) {
            i = 0;
        }
        return mo35225bB(etQ[i]);
    }

    /* renamed from: vl */
    public String mo35245vl(int i) {
        long vm = mo35246vm(i);
        return vm > 0 ? mo35225bB(vm) : "";
    }

    /* renamed from: vm */
    public long mo35246vm(int i) {
        if (i == 1) {
            return QStyle.NONE_THEME_TEMPLATE_ID;
        }
        if (i == 9) {
            return QStyle.DEFAULT_BUBBLE_TEMPLATE_ID;
        }
        switch (i) {
            case 3:
                return QStyle.NONE_TRANSITION_TEMPLATE_ID;
            case 4:
                return QStyle.NONE_FILTER_TEMPLATE_ID;
            default:
                return 0;
        }
    }

    /* renamed from: vn */
    public TemplateConditionModel mo35247vn(int i) {
        TemplateConditionModel templateConditionModel = new TemplateConditionModel();
        templateConditionModel.mLayoutMode = i;
        templateConditionModel.isPhoto = true;
        return templateConditionModel;
    }
}
