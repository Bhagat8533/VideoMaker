package com.introvd.template.datacenter;

import android.content.Context;
import android.content.Intent;

public class SocialServiceMiscNotify extends BaseSocialNotify {
    private static SocialServiceMiscNotify INSTANCE = null;
    private static final String TAG = "SocialServiceMiscNotify";

    private SocialServiceMiscNotify() {
    }

    public static synchronized SocialServiceMiscNotify getInstance() {
        SocialServiceMiscNotify socialServiceMiscNotify;
        synchronized (SocialServiceMiscNotify.class) {
            if (INSTANCE == null) {
                INSTANCE = new SocialServiceMiscNotify();
            }
            socialServiceMiscNotify = INSTANCE;
        }
        return socialServiceMiscNotify;
    }

    public synchronized void onHandleIntentFailed(Context context, Intent intent) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02b7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02b8, code lost:
        r7 = r0;
        r34 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:112:0x02b0, B:121:0x02c7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNotify(android.content.Context r40, java.lang.String r41, java.lang.Object r42, int r43, int r44, android.content.Intent r45, com.introvd.template.p243e.C5542a r46) {
        /*
            r39 = this;
            r8 = r40
            r9 = r41
            r10 = r42
            r11 = r43
            r12 = r44
            r13 = r45
            if (r11 != 0) goto L_0x000f
            return
        L_0x000f:
            r14 = 0
            if (r13 == 0) goto L_0x0017
            android.os.Bundle r1 = r45.getExtras()
            goto L_0x0018
        L_0x0017:
            r1 = r14
        L_0x0018:
            if (r1 != 0) goto L_0x001f
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
        L_0x001f:
            r15 = r1
            java.lang.String r1 = "social_method"
            r15.putString(r1, r9)
            r4 = 0
            r6 = 0
            r1 = r15
            r2 = r41
            r3 = r44
            fillFeedbackParam(r1, r2, r3, r4, r6)
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r11 == r1) goto L_0x006f
            r1 = 65536(0x10000, float:9.18355E-41)
            if (r11 != r1) goto L_0x005e
            if (r12 == 0) goto L_0x005e
            java.lang.String r1 = "socialservice.action.MISC"
            boolean r1 = com.introvd.template.datacenter.SocialExceptionHandler.handleErrCode(r8, r1, r9, r12, r14)     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x005e
            r4 = 0
            r6 = 0
            r1 = r40
            r2 = r41
            r3 = r44
            reportNetworkError(r1, r2, r3, r4, r6)     // Catch:{ all -> 0x0056 }
            r7 = r39
            r7.onHandleIntentFailed(r8, r13)     // Catch:{ all -> 0x01a4 }
            goto L_0x0060
        L_0x0056:
            r0 = move-exception
            r7 = r39
        L_0x0059:
            r7 = r0
            r34 = r15
            goto L_0x069f
        L_0x005e:
            r7 = r39
        L_0x0060:
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r43
            r5 = r15
            r6 = r46
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        L_0x006f:
            r7 = r39
            java.lang.String r1 = "template.roll.detail"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x069b }
            if (r1 == 0) goto L_0x01b8
            boolean r1 = r10 instanceof com.xiaoying.p448a.C9567f     // Catch:{ Exception -> 0x01a7 }
            if (r1 != 0) goto L_0x008c
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r43
            r5 = r15
            r6 = r46
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        L_0x008c:
            r1 = r10
            com.xiaoying.a.f r1 = (com.xiaoying.p448a.C9567f) r1     // Catch:{ Exception -> 0x01a7 }
            if (r1 == 0) goto L_0x01a1
            android.content.ContentResolver r4 = r40.getContentResolver()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = "TemplateRoll"
            android.net.Uri r5 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r5)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r6 = "TemplateMonetization"
            android.net.Uri r6 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r6)     // Catch:{ Exception -> 0x01a7 }
            java.lang.Object r1 = r1.eRH     // Catch:{ Exception -> 0x01a7 }
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ Exception -> 0x01a7 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01a7 }
            android.content.ContentValues r10 = new android.content.ContentValues     // Catch:{ Exception -> 0x01a7 }
            r10.<init>()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r14 = "code"
            java.lang.String r14 = r1.optString(r14)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r3 = "tcid"
            java.lang.String r3 = r1.optString(r3)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r2 = "engineVer"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r7 = "downUrl"
            java.lang.String r7 = r1.optString(r7)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r8 = "lang"
            java.lang.String r8 = r1.optString(r8)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r11 = "price"
            java.lang.String r11 = r1.optString(r11)     // Catch:{ Exception -> 0x01a7 }
            r26 = r15
            java.lang.String r15 = "wordInfo"
            java.lang.String r15 = r1.optString(r15)     // Catch:{ Exception -> 0x019f }
            java.lang.String r9 = "imageInfo"
            java.lang.String r9 = r1.optString(r9)     // Catch:{ Exception -> 0x019f }
            r27 = r12
            java.lang.String r12 = "orderno"
            java.lang.String r12 = r1.optString(r12)     // Catch:{ Exception -> 0x019f }
            java.lang.String r13 = "newFlag"
            r29 = r6
            java.lang.String r6 = "0"
            java.lang.String r6 = r1.optString(r13, r6)     // Catch:{ Exception -> 0x019f }
            java.lang.String r13 = "event"
            java.lang.String r19 = r1.optString(r13)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "code"
            r10.put(r1, r14)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "tcid"
            r10.put(r1, r3)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "enginever"
            r10.put(r1, r2)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "downurl"
            r10.put(r1, r7)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "lang"
            r10.put(r1, r8)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "price"
            r10.put(r1, r11)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "wordinfos"
            r10.put(r1, r15)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "xytinfos"
            r10.put(r1, r9)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "orderno"
            r10.put(r1, r12)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "newflag"
            r10.put(r1, r6)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = "code = ?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ Exception -> 0x019f }
            r2 = 0
            r6[r2] = r14     // Catch:{ Exception -> 0x019f }
            int r1 = r4.update(r5, r10, r1, r6)     // Catch:{ Exception -> 0x019f }
            if (r1 > 0) goto L_0x013b
            r4.insert(r5, r10)     // Catch:{ Exception -> 0x019f }
        L_0x013b:
            boolean r1 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x019f }
            if (r1 == 0) goto L_0x0166
            java.lang.String r1 = "ttid = ?"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x019f }
            r3 = 0
            r2[r3] = r14     // Catch:{ Exception -> 0x019f }
            r5 = r29
            int r1 = r4.delete(r5, r1, r2)     // Catch:{ Exception -> 0x019f }
            java.lang.String r2 = TAG     // Catch:{ Exception -> 0x019f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x019f }
            r3.<init>()     // Catch:{ Exception -> 0x019f }
            java.lang.String r4 = "updateTemplateLockInfo delcount="
            r3.append(r4)     // Catch:{ Exception -> 0x019f }
            r3.append(r1)     // Catch:{ Exception -> 0x019f }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x019f }
            com.introvd.template.common.LogUtils.m14222e(r2, r1)     // Catch:{ Exception -> 0x019f }
            goto L_0x0181
        L_0x0166:
            r5 = r29
            java.lang.String r20 = ""
            java.lang.String r21 = ""
            java.lang.String r22 = ""
            java.lang.String r23 = ""
            java.lang.String r24 = ""
            r16 = r4
            r17 = r3
            r18 = r14
            android.content.ContentValues r1 = com.introvd.template.datacenter.TemplateDataDao.updateTemplateLockInfo(r16, r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x019f }
            if (r1 == 0) goto L_0x0181
            r4.insert(r5, r1)     // Catch:{ Exception -> 0x019f }
        L_0x0181:
            java.lang.String r1 = TAG     // Catch:{ Exception -> 0x019f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x019f }
            r2.<init>()     // Catch:{ Exception -> 0x019f }
            java.lang.String r3 = "ROLL_DETAIL time consume="
            r2.append(r3)     // Catch:{ Exception -> 0x019f }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x019f }
            r5 = 0
            long r3 = r3 - r27
            r2.append(r3)     // Catch:{ Exception -> 0x019f }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x019f }
            com.introvd.template.common.LogUtils.m14222e(r1, r2)     // Catch:{ Exception -> 0x019f }
            goto L_0x01ae
        L_0x019f:
            r0 = move-exception
            goto L_0x01aa
        L_0x01a1:
            r26 = r15
            goto L_0x01ae
        L_0x01a4:
            r0 = move-exception
            goto L_0x0059
        L_0x01a7:
            r0 = move-exception
            r26 = r15
        L_0x01aa:
            r1 = r0
            r1.printStackTrace()     // Catch:{ all -> 0x01b2 }
        L_0x01ae:
            r34 = r26
            goto L_0x0683
        L_0x01b2:
            r0 = move-exception
            r7 = r0
            r34 = r26
            goto L_0x069f
        L_0x01b8:
            r26 = r15
            java.lang.String r1 = "template.item.info"
            r3 = r41
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0697 }
            if (r1 == 0) goto L_0x02bd
            boolean r1 = r10 instanceof com.xiaoying.p448a.C9567f     // Catch:{ Exception -> 0x02ac }
            if (r1 != 0) goto L_0x01d8
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r43
            r5 = r26
            r6 = r46
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        L_0x01d8:
            java.lang.String r1 = "TemplateInfo"
            android.net.Uri r1 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r1)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r2 = "TemplateCard"
            android.net.Uri r2 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r2)     // Catch:{ Exception -> 0x02ac }
            com.xiaoying.a.f r10 = (com.xiaoying.p448a.C9567f) r10     // Catch:{ Exception -> 0x02ac }
            android.content.ContentResolver r9 = r40.getContentResolver()     // Catch:{ Exception -> 0x02ac }
            java.lang.Object r4 = r10.eRH     // Catch:{ Exception -> 0x02ac }
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ Exception -> 0x02ac }
            r5 = 1
            android.content.ContentValues[] r6 = new android.content.ContentValues[r5]     // Catch:{ Exception -> 0x02ac }
            java.lang.String r5 = "c"
            java.lang.String r12 = r4.optString(r5)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r5 = "a"
            java.lang.String r20 = r4.optString(r5)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r5 = "w"
            java.lang.String r14 = r4.optString(r5)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r5 = "d"
            java.lang.String r17 = r4.optString(r5)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r5 = "e"
            java.lang.String r18 = r4.optString(r5)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r5 = "f"
            java.lang.String r19 = r4.optString(r5)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r5 = "x"
            r4.optString(r5)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r5 = "g"
            java.lang.String r16 = r4.optString(r5)     // Catch:{ Exception -> 0x02ac }
            java.lang.String r5 = "h"
            java.lang.String r15 = r4.optString(r5)     // Catch:{ Exception -> 0x02ac }
            r11 = r9
            r13 = r20
            android.content.ContentValues r5 = com.introvd.template.datacenter.TemplateDataDao.updateTemplateLockInfo(r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x02ac }
            if (r5 == 0) goto L_0x0242
            r7 = 0
            r6[r7] = r5     // Catch:{ Exception -> 0x023c }
            java.lang.String r5 = "TemplateMonetization"
            android.net.Uri r5 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r5)     // Catch:{ Exception -> 0x023c }
            r9.bulkInsert(r5, r6)     // Catch:{ Exception -> 0x023c }
            goto L_0x0242
        L_0x023c:
            r0 = move-exception
            r1 = r0
            r5 = r26
            goto L_0x02b0
        L_0x0242:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02ac }
            android.content.ContentValues r11 = com.introvd.template.datacenter.TemplateDataDao.getTemplateInfoContentValues(r4, r5)     // Catch:{ Exception -> 0x02ac }
            android.content.ContentValues r12 = com.introvd.template.datacenter.TemplateDataDao.getTemplateCardContentValues(r4)     // Catch:{ Exception -> 0x02ac }
            if (r11 == 0) goto L_0x0276
            java.lang.String r7 = "ttid = ?"
            java.lang.String r4 = "ttid"
            java.lang.String[] r6 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x023c }
            r4 = 1
            java.lang.String[] r8 = new java.lang.String[r4]     // Catch:{ Exception -> 0x023c }
            r4 = 0
            r8[r4] = r20     // Catch:{ Exception -> 0x023c }
            r13 = 0
            r4 = r9
            r5 = r1
            r14 = r9
            r9 = r13
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x023c }
            if (r4 == 0) goto L_0x0277
            int r5 = r4.getCount()     // Catch:{ Exception -> 0x023c }
            if (r5 > 0) goto L_0x0272
            r14.insert(r1, r11)     // Catch:{ Exception -> 0x023c }
        L_0x0272:
            r4.close()     // Catch:{ Exception -> 0x023c }
            goto L_0x0277
        L_0x0276:
            r14 = r9
        L_0x0277:
            if (r12 == 0) goto L_0x029c
            java.lang.String r7 = "ttid = ?"
            java.lang.String r1 = "ttid"
            java.lang.String[] r6 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x023c }
            r1 = 1
            java.lang.String[] r8 = new java.lang.String[r1]     // Catch:{ Exception -> 0x023c }
            r1 = 0
            r8[r1] = r20     // Catch:{ Exception -> 0x023c }
            r9 = 0
            r4 = r14
            r5 = r2
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x023c }
            if (r1 == 0) goto L_0x029c
            int r4 = r1.getCount()     // Catch:{ Exception -> 0x023c }
            if (r4 > 0) goto L_0x0299
            r14.insert(r2, r12)     // Catch:{ Exception -> 0x023c }
        L_0x0299:
            r1.close()     // Catch:{ Exception -> 0x023c }
        L_0x029c:
            java.lang.String r1 = "XiaoYingServerResponse"
            java.lang.Object r2 = r10.eRH     // Catch:{ Exception -> 0x02ac }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02ac }
            r5 = r26
            r5.putString(r1, r2)     // Catch:{ Exception -> 0x02aa }
            goto L_0x02b3
        L_0x02aa:
            r0 = move-exception
            goto L_0x02af
        L_0x02ac:
            r0 = move-exception
            r5 = r26
        L_0x02af:
            r1 = r0
        L_0x02b0:
            r1.printStackTrace()     // Catch:{ all -> 0x02b7 }
        L_0x02b3:
            r34 = r5
            goto L_0x0683
        L_0x02b7:
            r0 = move-exception
            r7 = r0
            r34 = r5
            goto L_0x069f
        L_0x02bd:
            r5 = r26
            java.lang.String r1 = "template.packages.info"
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0693 }
            if (r1 == 0) goto L_0x03e3
            boolean r1 = r10 instanceof com.xiaoying.p448a.C9567f     // Catch:{ Exception -> 0x03dc }
            if (r1 != 0) goto L_0x02d9
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r43
            r6 = r46
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        L_0x02d9:
            r1 = r10
            com.xiaoying.a.f r1 = (com.xiaoying.p448a.C9567f) r1     // Catch:{ Exception -> 0x03dc }
            if (r1 == 0) goto L_0x02b3
            java.lang.String r2 = "request_param1"
            java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x03dc }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x03dc }
            r4.<init>()     // Catch:{ Exception -> 0x03dc }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x03dc }
            r6.<init>()     // Catch:{ Exception -> 0x03dc }
            java.lang.String r6 = "TemplatePackage"
            android.net.Uri r6 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r6)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r7 = "templategrouplist"
            java.lang.Object r1 = r1.getObject(r7)     // Catch:{ Exception -> 0x03dc }
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch:{ Exception -> 0x03dc }
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ Exception -> 0x03dc }
            r7.<init>()     // Catch:{ Exception -> 0x03dc }
            r8 = 0
        L_0x0302:
            int r9 = r1.length()     // Catch:{ Exception -> 0x03dc }
            if (r8 >= r9) goto L_0x03b1
            org.json.JSONObject r9 = r1.getJSONObject(r8)     // Catch:{ Exception -> 0x03dc }
            r7.clear()     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "groupcode"
            java.lang.String r10 = r9.optString(r10)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r11 = "groupcode"
            r7.put(r11, r10)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "lang"
            java.lang.String r11 = "lang"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "appminver"
            java.lang.String r11 = "appminver"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "size"
            java.lang.String r11 = "size"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "publishtime"
            java.lang.String r11 = "publishtime"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "expiredtime"
            java.lang.String r11 = "expiretime"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "orderno"
            java.lang.String r11 = "orderno"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "cover"
            java.lang.String r11 = "icon"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "banner"
            java.lang.String r11 = "banner"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "newcount"
            java.lang.String r11 = "newcount"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "desc"
            java.lang.String r11 = "intro"
            java.lang.String r11 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x03dc }
            java.lang.String r10 = "title"
            java.lang.String r11 = "title"
            java.lang.String r9 = r9.optString(r11)     // Catch:{ Exception -> 0x03dc }
            r7.put(r10, r9)     // Catch:{ Exception -> 0x03dc }
            boolean r9 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x03dc }
            if (r9 != 0) goto L_0x039e
            java.lang.String r9 = "modelcode"
            r7.put(r9, r2)     // Catch:{ Exception -> 0x03dc }
        L_0x039e:
            android.content.ContentProviderOperation$Builder r9 = android.content.ContentProviderOperation.newInsert(r6)     // Catch:{ Exception -> 0x03dc }
            android.content.ContentProviderOperation$Builder r9 = r9.withValues(r7)     // Catch:{ Exception -> 0x03dc }
            android.content.ContentProviderOperation r9 = r9.build()     // Catch:{ Exception -> 0x03dc }
            r4.add(r9)     // Catch:{ Exception -> 0x03dc }
            int r8 = r8 + 1
            goto L_0x0302
        L_0x03b1:
            android.content.ContentResolver r1 = r40.getContentResolver()     // Catch:{ Throwable -> 0x03d5 }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x03d5 }
            if (r7 != 0) goto L_0x03c6
            java.lang.String r7 = "modelcode=?"
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ Throwable -> 0x03d5 }
            r9 = 0
            r8[r9] = r2     // Catch:{ Throwable -> 0x03d5 }
            r1.delete(r6, r7, r8)     // Catch:{ Throwable -> 0x03d5 }
        L_0x03c6:
            boolean r2 = r4.isEmpty()     // Catch:{ Throwable -> 0x03d5 }
            if (r2 != 0) goto L_0x02b3
            java.lang.String r2 = r6.getAuthority()     // Catch:{ Throwable -> 0x03d5 }
            r1.applyBatch(r2, r4)     // Catch:{ Throwable -> 0x03d5 }
            goto L_0x02b3
        L_0x03d5:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()     // Catch:{ Exception -> 0x03dc }
            goto L_0x02b3
        L_0x03dc:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()     // Catch:{ all -> 0x02b7 }
            goto L_0x02b3
        L_0x03e3:
            java.lang.String r1 = "template.packages.detail"
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0693 }
            if (r1 == 0) goto L_0x02b3
            boolean r1 = r10 instanceof com.xiaoying.p448a.C9567f     // Catch:{ Exception -> 0x0679 }
            if (r1 != 0) goto L_0x03fd
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r43
            r6 = r46
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        L_0x03fd:
            r1 = r10
            com.xiaoying.a.f r1 = (com.xiaoying.p448a.C9567f) r1     // Catch:{ Exception -> 0x0679 }
            if (r1 == 0) goto L_0x02b3
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0679 }
            r2.<init>()     // Catch:{ Exception -> 0x0679 }
            java.lang.String r4 = "TemplatePackageDetail"
            android.net.Uri r4 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r4)     // Catch:{ Exception -> 0x0679 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0679 }
            r6.<init>()     // Catch:{ Exception -> 0x0679 }
            java.lang.String r7 = "TemplateCard"
            android.net.Uri r7 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r7)     // Catch:{ Exception -> 0x0679 }
            android.content.ContentResolver r15 = r40.getContentResolver()     // Catch:{ Exception -> 0x0679 }
            java.lang.String r8 = "templatelist"
            java.lang.Object r1 = r1.getObject(r8)     // Catch:{ Exception -> 0x0679 }
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch:{ Exception -> 0x0679 }
            if (r1 != 0) goto L_0x0434
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r43
            r6 = r46
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        L_0x0434:
            android.content.ContentValues r14 = new android.content.ContentValues     // Catch:{ Exception -> 0x0679 }
            r14.<init>()     // Catch:{ Exception -> 0x0679 }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ Exception -> 0x0679 }
            r12.<init>()     // Catch:{ Exception -> 0x0679 }
            int r11 = r1.length()     // Catch:{ Exception -> 0x0679 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0679 }
            r10.<init>()     // Catch:{ Exception -> 0x0679 }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0679 }
            android.os.Bundle r8 = r45.getExtras()     // Catch:{ Exception -> 0x0679 }
            java.lang.String r9 = "request_type"
            java.lang.String r13 = r8.getString(r9)     // Catch:{ Exception -> 0x0679 }
            if (r11 <= 0) goto L_0x0637
            r9 = 0
        L_0x0458:
            if (r9 >= r11) goto L_0x0637
            org.json.JSONObject r8 = r1.getJSONObject(r9)     // Catch:{ Exception -> 0x0679 }
            r14.clear()     // Catch:{ Exception -> 0x0679 }
            r12.clear()     // Catch:{ Exception -> 0x0679 }
            r30 = r1
            java.lang.String r1 = "scene"
            java.lang.String r1 = r8.optString(r1)     // Catch:{ Exception -> 0x0679 }
            java.lang.String r3 = "scenecode"
            java.lang.String r3 = r8.optString(r3)     // Catch:{ Exception -> 0x0679 }
            r31 = r9
            java.lang.String r9 = "sceneicon"
            java.lang.String r9 = r8.optString(r9)     // Catch:{ Exception -> 0x0679 }
            r32 = r10
            java.lang.String r10 = "ttid"
            java.lang.String r10 = r8.optString(r10)     // Catch:{ Exception -> 0x0679 }
            r33 = r11
            java.lang.String r11 = "tcid"
            java.lang.String r11 = r8.optString(r11)     // Catch:{ Exception -> 0x0679 }
            r34 = r5
            java.lang.String r5 = "event"
            java.lang.String r5 = r8.optString(r5)     // Catch:{ Exception -> 0x0671 }
            r35 = r15
            java.lang.String r15 = "groupcode"
            r12.put(r15, r13)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r15 = "orderno"
            r36 = r13
            java.lang.String r13 = "orderno"
            r37 = r5
            r5 = 0
            int r13 = r8.optInt(r13, r5)     // Catch:{ Exception -> 0x0671 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x0671 }
            r12.put(r15, r13)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r13 = "ttid"
            r12.put(r13, r10)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r13 = "tcid"
            r12.put(r13, r11)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r13 = "pi_scene_code"
            r12.put(r13, r3)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r13 = "pi_scene_icon"
            r12.put(r13, r9)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r13 = "pi_scene_name"
            r12.put(r13, r1)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r13 = "updatetime"
            java.lang.Long r15 = java.lang.Long.valueOf(r17)     // Catch:{ Exception -> 0x0671 }
            r12.put(r13, r15)     // Catch:{ Exception -> 0x0671 }
            android.content.ContentProviderOperation$Builder r13 = android.content.ContentProviderOperation.newInsert(r4)     // Catch:{ Exception -> 0x0671 }
            android.content.ContentProviderOperation$Builder r13 = r13.withValues(r12)     // Catch:{ Exception -> 0x0671 }
            android.content.ContentProviderOperation r13 = r13.build()     // Catch:{ Exception -> 0x0671 }
            r2.add(r13)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r13 = "tcid"
            r14.put(r13, r11)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r13 = "ttid"
            r14.put(r13, r10)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r13 = "scene"
            r14.put(r13, r1)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r1 = "scene_code"
            r14.put(r1, r3)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r1 = "scene_icon"
            r14.put(r1, r9)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r1 = "ver"
            java.lang.String r3 = "ver"
            java.lang.String r3 = r8.optString(r3)     // Catch:{ Exception -> 0x0671 }
            r14.put(r1, r3)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r1 = "title"
            java.lang.String r1 = r8.optString(r1)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r3 = "title"
            r14.put(r3, r1)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r3 = "intro"
            java.lang.String r15 = r8.optString(r3)     // Catch:{ Exception -> 0x0671 }
            boolean r3 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0671 }
            if (r3 != 0) goto L_0x051e
            java.lang.String r3 = "intro"
            r14.put(r3, r15)     // Catch:{ Exception -> 0x0671 }
        L_0x051e:
            java.lang.String r3 = "icon"
            java.lang.String r3 = r8.optString(r3)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r9 = "icon"
            r14.put(r9, r3)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r9 = "previewurl"
            java.lang.String r13 = r8.optString(r9)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r9 = "previewtype"
            int r9 = r8.optInt(r9)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "previewurl"
            r14.put(r5, r13)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "previewtype"
            r38 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "lang"
            java.lang.String r12 = "lang"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "mark"
            java.lang.String r12 = "flag"
            int r12 = r8.optInt(r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "appminver"
            java.lang.String r12 = "appminver"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "size"
            java.lang.String r12 = "size"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "authorname"
            java.lang.String r12 = "author"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "publishtime"
            java.lang.String r12 = "publishtime"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "likecount"
            java.lang.String r12 = "likecount"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "downcount"
            java.lang.String r12 = "downcount"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "points"
            java.lang.String r12 = "points"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "duration"
            java.lang.String r12 = "duration"
            java.lang.String r12 = r8.optString(r12)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "updatetime"
            java.lang.Long r12 = java.lang.Long.valueOf(r17)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r5 = "audioFlag"
            java.lang.String r12 = "audioFlag"
            int r8 = r8.optInt(r12)     // Catch:{ Exception -> 0x0671 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0671 }
            r14.put(r5, r8)     // Catch:{ Exception -> 0x0671 }
            android.content.ContentProviderOperation$Builder r5 = android.content.ContentProviderOperation.newInsert(r7)     // Catch:{ Exception -> 0x0671 }
            android.content.ContentProviderOperation$Builder r5 = r5.withValues(r14)     // Catch:{ Exception -> 0x0671 }
            android.content.ContentProviderOperation r5 = r5.build()     // Catch:{ Exception -> 0x0671 }
            r6.add(r5)     // Catch:{ Exception -> 0x0671 }
            boolean r5 = android.text.TextUtils.isEmpty(r37)     // Catch:{ Exception -> 0x0671 }
            if (r5 != 0) goto L_0x0615
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0671 }
            r5.<init>()     // Catch:{ Exception -> 0x0671 }
            java.lang.String r8 = ""
            r5.append(r8)     // Catch:{ Exception -> 0x0671 }
            r5.append(r9)     // Catch:{ Exception -> 0x0671 }
            java.lang.String r12 = r5.toString()     // Catch:{ Exception -> 0x0671 }
            r8 = r35
            r25 = r31
            r9 = r11
            r5 = r32
            r19 = r33
            r11 = r37
            r20 = r38
            r21 = r36
            r22 = r14
            r14 = r1
            r1 = r35
            r16 = r3
            android.content.ContentValues r3 = com.introvd.template.datacenter.TemplateDataDao.updateTemplateLockInfo(r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0671 }
            if (r3 == 0) goto L_0x0623
            r5.add(r3)     // Catch:{ Exception -> 0x0671 }
            goto L_0x0623
        L_0x0615:
            r22 = r14
            r25 = r31
            r5 = r32
            r19 = r33
            r1 = r35
            r21 = r36
            r20 = r38
        L_0x0623:
            int r9 = r25 + 1
            r15 = r1
            r10 = r5
            r11 = r19
            r12 = r20
            r13 = r21
            r14 = r22
            r1 = r30
            r5 = r34
            r3 = r41
            goto L_0x0458
        L_0x0637:
            r34 = r5
            r5 = r10
            r1 = r15
            boolean r3 = r6.isEmpty()     // Catch:{ Throwable -> 0x0673 }
            if (r3 != 0) goto L_0x0648
            java.lang.String r3 = r7.getAuthority()     // Catch:{ Throwable -> 0x0673 }
            r1.applyBatch(r3, r6)     // Catch:{ Throwable -> 0x0673 }
        L_0x0648:
            boolean r3 = r2.isEmpty()     // Catch:{ Throwable -> 0x0673 }
            if (r3 != 0) goto L_0x0655
            java.lang.String r3 = r4.getAuthority()     // Catch:{ Throwable -> 0x0673 }
            r1.applyBatch(r3, r2)     // Catch:{ Throwable -> 0x0673 }
        L_0x0655:
            int r2 = r5.size()     // Catch:{ Throwable -> 0x0673 }
            if (r2 <= 0) goto L_0x0683
            java.lang.String r2 = "TemplateMonetization"
            android.net.Uri r2 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r2)     // Catch:{ Throwable -> 0x0673 }
            int r3 = r5.size()     // Catch:{ Throwable -> 0x0673 }
            android.content.ContentValues[] r3 = new android.content.ContentValues[r3]     // Catch:{ Throwable -> 0x0673 }
            java.lang.Object[] r3 = r5.toArray(r3)     // Catch:{ Throwable -> 0x0673 }
            android.content.ContentValues[] r3 = (android.content.ContentValues[]) r3     // Catch:{ Throwable -> 0x0673 }
            r1.bulkInsert(r2, r3)     // Catch:{ Throwable -> 0x0673 }
            goto L_0x0683
        L_0x0671:
            r0 = move-exception
            goto L_0x067c
        L_0x0673:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()     // Catch:{ Exception -> 0x0671 }
            goto L_0x0683
        L_0x0679:
            r0 = move-exception
            r34 = r5
        L_0x067c:
            r1 = r0
            r1.printStackTrace()     // Catch:{ all -> 0x0681 }
            goto L_0x0683
        L_0x0681:
            r0 = move-exception
            goto L_0x069e
        L_0x0683:
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r43
            r5 = r34
            r6 = r46
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        L_0x0693:
            r0 = move-exception
            r34 = r5
            goto L_0x069e
        L_0x0697:
            r0 = move-exception
            r34 = r26
            goto L_0x069e
        L_0x069b:
            r0 = move-exception
            r34 = r15
        L_0x069e:
            r7 = r0
        L_0x069f:
            r1 = r39
            r2 = r40
            r3 = r41
            r4 = r43
            r5 = r34
            r6 = r46
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialServiceMiscNotify.onNotify(android.content.Context, java.lang.String, java.lang.Object, int, int, android.content.Intent, com.introvd.template.e.a):void");
    }
}
