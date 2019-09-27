package com.introvd.template.datacenter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class TemplateDBRefactUtil {
    private static final String TBL_NAME_TEMPLATE_INFO = "TemplateInfoNew";
    private static final String TBL_NAME_TEMPLATE_INFO_RECOMMEND = "TemplateInfoRecommend";
    private static final String TBL_NAME_TEMPLATE_PACKAGE_DETAIL = "TemplatePackageDetailNew";

    public enum VALUE_TYPE {
        TYPE_STRING,
        TYPE_INT,
        TYPE_LONG,
        TYPE_DOUBLE,
        TYPE_FLOAT,
        TYPE_BLOB
    }

    private static final List<ContentValues> convertCursorToCV(Cursor cursor, String[] strArr, VALUE_TYPE[] value_typeArr) throws Exception {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int[] iArr = new int[length];
        while (cursor.moveToNext()) {
            for (int i = 0; i < length; i++) {
                iArr[i] = cursor.getColumnIndex(strArr[i]);
            }
            ContentValues contentValues = new ContentValues();
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr[i2] > -1) {
                    if (value_typeArr[i2] == VALUE_TYPE.TYPE_STRING) {
                        contentValues.put(strArr[i2], cursor.getString(iArr[i2]));
                    } else if (value_typeArr[i2] == VALUE_TYPE.TYPE_INT) {
                        contentValues.put(strArr[i2], Integer.valueOf(cursor.getInt(iArr[i2])));
                    } else if (value_typeArr[i2] == VALUE_TYPE.TYPE_LONG) {
                        contentValues.put(strArr[i2], Long.valueOf(cursor.getLong(iArr[i2])));
                    } else if (value_typeArr[i2] == VALUE_TYPE.TYPE_DOUBLE) {
                        contentValues.put(strArr[i2], Double.valueOf(cursor.getDouble(iArr[i2])));
                    } else if (value_typeArr[i2] == VALUE_TYPE.TYPE_FLOAT) {
                        contentValues.put(strArr[i2], Float.valueOf(cursor.getFloat(iArr[i2])));
                    } else if (value_typeArr[i2] == VALUE_TYPE.TYPE_BLOB) {
                        contentValues.put(strArr[i2], cursor.getBlob(iArr[i2]));
                    }
                }
            }
            arrayList.add(contentValues);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplate(android.database.sqlite.SQLiteDatabase r26, android.database.sqlite.SQLiteDatabase r27) {
        /*
            r1 = 0
            r26.beginTransaction()     // Catch:{ Exception -> 0x00ef, all -> 0x00ea }
            java.lang.String r0 = "select * from Template"
            r2 = r26
            android.database.Cursor r3 = r2.rawQuery(r0, r1)     // Catch:{ Exception -> 0x00e8 }
            if (r3 == 0) goto L_0x00da
            java.lang.String r4 = "template_id"
            java.lang.String r5 = "title"
            java.lang.String r6 = "points"
            java.lang.String r7 = "price"
            java.lang.String r8 = "logo"
            java.lang.String r9 = "url"
            java.lang.String r10 = "from_type"
            java.lang.String r11 = "orderno"
            java.lang.String r12 = "ver"
            java.lang.String r13 = "updatetime"
            java.lang.String r14 = "favorite"
            java.lang.String r15 = "suborder"
            java.lang.String r16 = "layout"
            java.lang.String r17 = "extInfo"
            java.lang.String r18 = "configureCount"
            java.lang.String r19 = "downFlag"
            java.lang.String r20 = "description"
            java.lang.String r21 = "mission"
            java.lang.String r22 = "mresult"
            java.lang.String r23 = "delFlag"
            java.lang.String r24 = "scene_code"
            java.lang.String r25 = "appFlag"
            java.lang.String[] r0 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25}     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4 = 22
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r4 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r4]     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_LONG     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_FLOAT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_FLOAT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 7
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 8
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 9
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_LONG     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 10
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 11
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 12
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 13
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 14
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 15
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 16
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 17
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 18
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 19
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 20
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r5 = 21
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            java.util.List r0 = convertCursorToCV(r3, r0, r4)     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
        L_0x00c6:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            if (r4 == 0) goto L_0x00da
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            android.content.ContentValues r4 = (android.content.ContentValues) r4     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            java.lang.String r5 = "Template"
            r6 = r27
            r6.replace(r5, r1, r4)     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            goto L_0x00c6
        L_0x00da:
            r26.setTransactionSuccessful()     // Catch:{ Exception -> 0x00e5, all -> 0x00e3 }
            if (r3 == 0) goto L_0x00fa
            r3.close()
            goto L_0x00fa
        L_0x00e3:
            r0 = move-exception
            goto L_0x0100
        L_0x00e5:
            r0 = move-exception
            r1 = r3
            goto L_0x00f2
        L_0x00e8:
            r0 = move-exception
            goto L_0x00f2
        L_0x00ea:
            r0 = move-exception
            r2 = r26
        L_0x00ed:
            r3 = r1
            goto L_0x0100
        L_0x00ef:
            r0 = move-exception
            r2 = r26
        L_0x00f2:
            r0.printStackTrace()     // Catch:{ all -> 0x00fe }
            if (r1 == 0) goto L_0x00fa
            r1.close()
        L_0x00fa:
            r26.endTransaction()
            return
        L_0x00fe:
            r0 = move-exception
            goto L_0x00ed
        L_0x0100:
            if (r3 == 0) goto L_0x0105
            r3.close()
        L_0x0105:
            r26.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplate(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplateCard(android.database.sqlite.SQLiteDatabase r31, android.database.sqlite.SQLiteDatabase r32) {
        /*
            r1 = 0
            r31.beginTransaction()     // Catch:{ Exception -> 0x0117, all -> 0x0112 }
            java.lang.String r0 = "select * from TemplateCard"
            r2 = r31
            android.database.Cursor r3 = r2.rawQuery(r0, r1)     // Catch:{ Exception -> 0x0110 }
            if (r3 == 0) goto L_0x0102
            java.lang.String r4 = "ttid"
            java.lang.String r5 = "ver"
            java.lang.String r6 = "tcid"
            java.lang.String r7 = "title"
            java.lang.String r8 = "intro"
            java.lang.String r9 = "icon"
            java.lang.String r10 = "previewurl"
            java.lang.String r11 = "previewtype"
            java.lang.String r12 = "lang"
            java.lang.String r13 = "mark"
            java.lang.String r14 = "appminver"
            java.lang.String r15 = "size"
            java.lang.String r16 = "scene"
            java.lang.String r17 = "scene_code"
            java.lang.String r18 = "authorid"
            java.lang.String r19 = "authorname"
            java.lang.String r20 = "publishtime"
            java.lang.String r21 = "likecount"
            java.lang.String r22 = "downcount"
            java.lang.String r23 = "points"
            java.lang.String r24 = "url"
            java.lang.String r25 = "mission"
            java.lang.String r26 = "mresult"
            java.lang.String r27 = "duration"
            java.lang.String r28 = "updatetime"
            java.lang.String r29 = "iconcolor"
            java.lang.String r30 = "bigicon"
            java.lang.String[] r0 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30}     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4 = 27
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r4 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r4]     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 7
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 8
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 9
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 10
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 11
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 12
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 13
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 14
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 15
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 16
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 17
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 18
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 19
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 20
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 21
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 22
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 23
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 24
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_LONG     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 25
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r5 = 26
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r4[r5] = r6     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.util.List r0 = convertCursorToCV(r3, r0, r4)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x010d, all -> 0x010b }
        L_0x00ee:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            if (r4 == 0) goto L_0x0102
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            android.content.ContentValues r4 = (android.content.ContentValues) r4     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.lang.String r5 = "TemplateCard"
            r6 = r32
            r6.replace(r5, r1, r4)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            goto L_0x00ee
        L_0x0102:
            r31.setTransactionSuccessful()     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            if (r3 == 0) goto L_0x0122
            r3.close()
            goto L_0x0122
        L_0x010b:
            r0 = move-exception
            goto L_0x0128
        L_0x010d:
            r0 = move-exception
            r1 = r3
            goto L_0x011a
        L_0x0110:
            r0 = move-exception
            goto L_0x011a
        L_0x0112:
            r0 = move-exception
            r2 = r31
        L_0x0115:
            r3 = r1
            goto L_0x0128
        L_0x0117:
            r0 = move-exception
            r2 = r31
        L_0x011a:
            r0.printStackTrace()     // Catch:{ all -> 0x0126 }
            if (r1 == 0) goto L_0x0122
            r1.close()
        L_0x0122:
            r31.endTransaction()
            return
        L_0x0126:
            r0 = move-exception
            goto L_0x0115
        L_0x0128:
            if (r3 == 0) goto L_0x012d
            r3.close()
        L_0x012d:
            r31.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateCard(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplateFontInfo(android.database.sqlite.SQLiteDatabase r8, android.database.sqlite.SQLiteDatabase r9) {
        /*
            r0 = 0
            r8.beginTransaction()     // Catch:{ Exception -> 0x0068 }
            java.lang.String r1 = "select * from TemplateFontInfo"
            android.database.Cursor r1 = r8.rawQuery(r1, r0)     // Catch:{ Exception -> 0x0068 }
            if (r1 == 0) goto L_0x0057
            java.lang.String r2 = "ttid"
            java.lang.String r3 = "tcid"
            java.lang.String r4 = "iconurl"
            java.lang.String r5 = "fontname"
            java.lang.String r6 = "ordernum"
            java.lang.String r7 = "localpath"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7}     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r3 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r3 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r3]     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r4 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_LONG     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r4 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r4 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r4 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r4 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r4 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            java.util.List r2 = convertCursorToCV(r1, r2, r3)     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
        L_0x0045:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            if (r3 == 0) goto L_0x0057
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            java.lang.String r4 = "TemplateFontInfo"
            r9.replace(r4, r0, r3)     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            goto L_0x0045
        L_0x0057:
            r8.setTransactionSuccessful()     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            if (r1 == 0) goto L_0x0071
            r1.close()
            goto L_0x0071
        L_0x0060:
            r9 = move-exception
            goto L_0x0075
        L_0x0062:
            r9 = move-exception
            r0 = r1
            goto L_0x0069
        L_0x0065:
            r9 = move-exception
            r1 = r0
            goto L_0x0075
        L_0x0068:
            r9 = move-exception
        L_0x0069:
            r9.printStackTrace()     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x0071
            r0.close()
        L_0x0071:
            r8.endTransaction()
            return
        L_0x0075:
            if (r1 == 0) goto L_0x007a
            r1.close()
        L_0x007a:
            r8.endTransaction()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateFontInfo(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplateInfo(android.database.sqlite.SQLiteDatabase r9, android.database.sqlite.SQLiteDatabase r10) {
        /*
            r0 = 0
            r9.beginTransaction()     // Catch:{ Exception -> 0x006a }
            java.lang.String r1 = "select * from TemplateInfoNew"
            android.database.Cursor r1 = r9.rawQuery(r1, r0)     // Catch:{ Exception -> 0x006a }
            if (r1 == 0) goto L_0x0059
            java.lang.String r2 = "ttid"
            java.lang.String r3 = "updatetime"
            java.lang.String r4 = "orderno"
            java.lang.String r5 = "tcid"
            java.lang.String r6 = "ti_scene_code"
            java.lang.String r7 = "ti_scene_name"
            java.lang.String r8 = "ti_scene_icon"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8}     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r3 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r3]     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_LONG     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            java.util.List r2 = convertCursorToCV(r1, r2, r3)     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
        L_0x0047:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            java.lang.String r4 = "TemplateInfo"
            r10.replace(r4, r0, r3)     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            goto L_0x0047
        L_0x0059:
            r9.setTransactionSuccessful()     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            if (r1 == 0) goto L_0x0073
            r1.close()
            goto L_0x0073
        L_0x0062:
            r10 = move-exception
            goto L_0x0077
        L_0x0064:
            r10 = move-exception
            r0 = r1
            goto L_0x006b
        L_0x0067:
            r10 = move-exception
            r1 = r0
            goto L_0x0077
        L_0x006a:
            r10 = move-exception
        L_0x006b:
            r10.printStackTrace()     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0073
            r0.close()
        L_0x0073:
            r9.endTransaction()
            return
        L_0x0077:
            if (r1 == 0) goto L_0x007c
            r1.close()
        L_0x007c:
            r9.endTransaction()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateInfo(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplateInfoRecommend(android.database.sqlite.SQLiteDatabase r9, android.database.sqlite.SQLiteDatabase r10) {
        /*
            r0 = 0
            r9.beginTransaction()     // Catch:{ Exception -> 0x006a }
            java.lang.String r1 = "select * from TemplateInfoRecommend"
            android.database.Cursor r1 = r9.rawQuery(r1, r0)     // Catch:{ Exception -> 0x006a }
            if (r1 == 0) goto L_0x0059
            java.lang.String r2 = "ttid"
            java.lang.String r3 = "updatetime"
            java.lang.String r4 = "orderno"
            java.lang.String r5 = "tcid"
            java.lang.String r6 = "ti_scene_code"
            java.lang.String r7 = "ti_scene_name"
            java.lang.String r8 = "ti_scene_icon"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8}     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r3 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r3]     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_LONG     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r4 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            java.util.List r2 = convertCursorToCV(r1, r2, r3)     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
        L_0x0047:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            java.lang.String r4 = "TemplateInfoRecommend"
            r10.replace(r4, r0, r3)     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            goto L_0x0047
        L_0x0059:
            r9.setTransactionSuccessful()     // Catch:{ Exception -> 0x0064, all -> 0x0062 }
            if (r1 == 0) goto L_0x0073
            r1.close()
            goto L_0x0073
        L_0x0062:
            r10 = move-exception
            goto L_0x0077
        L_0x0064:
            r10 = move-exception
            r0 = r1
            goto L_0x006b
        L_0x0067:
            r10 = move-exception
            r1 = r0
            goto L_0x0077
        L_0x006a:
            r10 = move-exception
        L_0x006b:
            r10.printStackTrace()     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0073
            r0.close()
        L_0x0073:
            r9.endTransaction()
            return
        L_0x0077:
            if (r1 == 0) goto L_0x007c
            r1.close()
        L_0x007c:
            r9.endTransaction()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateInfoRecommend(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplateMonetization(android.database.sqlite.SQLiteDatabase r13, android.database.sqlite.SQLiteDatabase r14) {
        /*
            r0 = 0
            r13.beginTransaction()     // Catch:{ Exception -> 0x008f }
            java.lang.String r1 = "select * from TemplateMonetization"
            android.database.Cursor r1 = r13.rawQuery(r1, r0)     // Catch:{ Exception -> 0x008f }
            if (r1 == 0) goto L_0x007e
            java.lang.String r2 = "ttid"
            java.lang.String r3 = "tcid"
            java.lang.String r4 = "todocode"
            java.lang.String r5 = "todocontent"
            java.lang.String r6 = "expiretime"
            java.lang.String r7 = "lockstate"
            java.lang.String r8 = "previewurl"
            java.lang.String r9 = "previewtype"
            java.lang.String r10 = "title"
            java.lang.String r11 = "intro"
            java.lang.String r12 = "iconurl"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12}     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3 = 11
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r3 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r3]     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 7
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 8
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 9
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r4 = 10
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            java.util.List r2 = convertCursorToCV(r1, r2, r3)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
        L_0x006c:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            if (r3 == 0) goto L_0x007e
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            java.lang.String r4 = "TemplateMonetization"
            r14.replace(r4, r0, r3)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            goto L_0x006c
        L_0x007e:
            r13.setTransactionSuccessful()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            if (r1 == 0) goto L_0x0098
            r1.close()
            goto L_0x0098
        L_0x0087:
            r14 = move-exception
            goto L_0x009c
        L_0x0089:
            r14 = move-exception
            r0 = r1
            goto L_0x0090
        L_0x008c:
            r14 = move-exception
            r1 = r0
            goto L_0x009c
        L_0x008f:
            r14 = move-exception
        L_0x0090:
            r14.printStackTrace()     // Catch:{ all -> 0x008c }
            if (r0 == 0) goto L_0x0098
            r0.close()
        L_0x0098:
            r13.endTransaction()
            return
        L_0x009c:
            if (r1 == 0) goto L_0x00a1
            r1.close()
        L_0x00a1:
            r13.endTransaction()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateMonetization(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplatePackage(android.database.sqlite.SQLiteDatabase r17, android.database.sqlite.SQLiteDatabase r18) {
        /*
            r1 = 0
            r17.beginTransaction()     // Catch:{ Exception -> 0x00a7, all -> 0x00a2 }
            java.lang.String r0 = "select * from TemplatePackage"
            r2 = r17
            android.database.Cursor r3 = r2.rawQuery(r0, r1)     // Catch:{ Exception -> 0x00a0 }
            if (r3 == 0) goto L_0x0092
            java.lang.String r4 = "groupcode"
            java.lang.String r5 = "lang"
            java.lang.String r6 = "appminver"
            java.lang.String r7 = "size"
            java.lang.String r8 = "publishtime"
            java.lang.String r9 = "expiredtime"
            java.lang.String r10 = "orderno"
            java.lang.String r11 = "cover"
            java.lang.String r12 = "banner"
            java.lang.String r13 = "desc"
            java.lang.String r14 = "title"
            java.lang.String r15 = "modelcode"
            java.lang.String r16 = "newcount"
            java.lang.String[] r0 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16}     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4 = 13
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r4 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r4]     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 7
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 8
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 9
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 10
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 11
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r5 = 12
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r4[r5] = r6     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.util.List r0 = convertCursorToCV(r3, r0, r4)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
        L_0x007e:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r4 == 0) goto L_0x0092
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            android.content.ContentValues r4 = (android.content.ContentValues) r4     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r5 = "TemplatePackage"
            r6 = r18
            r6.replace(r5, r1, r4)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            goto L_0x007e
        L_0x0092:
            r17.setTransactionSuccessful()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r3 == 0) goto L_0x00b2
            r3.close()
            goto L_0x00b2
        L_0x009b:
            r0 = move-exception
            goto L_0x00b8
        L_0x009d:
            r0 = move-exception
            r1 = r3
            goto L_0x00aa
        L_0x00a0:
            r0 = move-exception
            goto L_0x00aa
        L_0x00a2:
            r0 = move-exception
            r2 = r17
        L_0x00a5:
            r3 = r1
            goto L_0x00b8
        L_0x00a7:
            r0 = move-exception
            r2 = r17
        L_0x00aa:
            r0.printStackTrace()     // Catch:{ all -> 0x00b6 }
            if (r1 == 0) goto L_0x00b2
            r1.close()
        L_0x00b2:
            r17.endTransaction()
            return
        L_0x00b6:
            r0 = move-exception
            goto L_0x00a5
        L_0x00b8:
            if (r3 == 0) goto L_0x00bd
            r3.close()
        L_0x00bd:
            r17.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplatePackage(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplatePackageDetail(android.database.sqlite.SQLiteDatabase r9, android.database.sqlite.SQLiteDatabase r10) {
        /*
            r0 = 0
            r9.beginTransaction()     // Catch:{ Exception -> 0x006f }
            java.lang.String r1 = "select * from TemplatePackageDetailNew"
            android.database.Cursor r1 = r9.rawQuery(r1, r0)     // Catch:{ Exception -> 0x006f }
            if (r1 == 0) goto L_0x005e
            java.lang.String r2 = "ttid"
            java.lang.String r3 = "updatetime"
            java.lang.String r4 = "groupcode"
            java.lang.String r5 = "orderno"
            java.lang.String r6 = "tcid"
            java.lang.String r7 = "pi_scene_code"
            java.lang.String r8 = "pi_scene_name"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8}     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r3 = 7
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r3 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r3]     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r4 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r4 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_LONG     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r4 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r4 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r4 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r4 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r4 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            java.util.List r2 = convertCursorToCV(r1, r2, r3)     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
        L_0x004c:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            if (r3 == 0) goto L_0x005e
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            java.lang.String r4 = "TemplatePackageDetail"
            r10.replace(r4, r0, r3)     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            goto L_0x004c
        L_0x005e:
            r9.setTransactionSuccessful()     // Catch:{ Exception -> 0x0069, all -> 0x0067 }
            if (r1 == 0) goto L_0x0078
            r1.close()
            goto L_0x0078
        L_0x0067:
            r10 = move-exception
            goto L_0x007c
        L_0x0069:
            r10 = move-exception
            r0 = r1
            goto L_0x0070
        L_0x006c:
            r10 = move-exception
            r1 = r0
            goto L_0x007c
        L_0x006f:
            r10 = move-exception
        L_0x0070:
            r10.printStackTrace()     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x0078
            r0.close()
        L_0x0078:
            r9.endTransaction()
            return
        L_0x007c:
            if (r1 == 0) goto L_0x0081
            r1.close()
        L_0x0081:
            r9.endTransaction()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplatePackageDetail(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplateRecommendRoll(android.database.sqlite.SQLiteDatabase r14, android.database.sqlite.SQLiteDatabase r15) {
        /*
            r0 = 0
            r14.beginTransaction()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r1 = "select * from TemplateRecommendRoll"
            android.database.Cursor r1 = r14.rawQuery(r1, r0)     // Catch:{ Exception -> 0x0097 }
            if (r1 == 0) goto L_0x0086
            java.lang.String r2 = "code"
            java.lang.String r3 = "tcid"
            java.lang.String r4 = "enginever"
            java.lang.String r5 = "downurl"
            java.lang.String r6 = "lang"
            java.lang.String r7 = "price"
            java.lang.String r8 = "newflag"
            java.lang.String r9 = "isShow"
            java.lang.String r10 = "wordinfos"
            java.lang.String r11 = "orderno"
            java.lang.String r12 = "subtype"
            java.lang.String r13 = "xytinfos"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3 = 12
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r3 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r3]     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 7
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 8
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 9
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 10
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 11
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.util.List r2 = convertCursorToCV(r1, r2, r3)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
        L_0x0074:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            if (r3 == 0) goto L_0x0086
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.lang.String r4 = "TemplateRecommendRoll"
            r15.replace(r4, r0, r3)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            goto L_0x0074
        L_0x0086:
            r14.setTransactionSuccessful()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            if (r1 == 0) goto L_0x00a0
            r1.close()
            goto L_0x00a0
        L_0x008f:
            r15 = move-exception
            goto L_0x00a4
        L_0x0091:
            r15 = move-exception
            r0 = r1
            goto L_0x0098
        L_0x0094:
            r15 = move-exception
            r1 = r0
            goto L_0x00a4
        L_0x0097:
            r15 = move-exception
        L_0x0098:
            r15.printStackTrace()     // Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x00a0
            r0.close()
        L_0x00a0:
            r14.endTransaction()
            return
        L_0x00a4:
            if (r1 == 0) goto L_0x00a9
            r1.close()
        L_0x00a9:
            r14.endTransaction()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateRecommendRoll(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplateRoll(android.database.sqlite.SQLiteDatabase r14, android.database.sqlite.SQLiteDatabase r15) {
        /*
            r0 = 0
            r14.beginTransaction()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r1 = "select * from TemplateRoll"
            android.database.Cursor r1 = r14.rawQuery(r1, r0)     // Catch:{ Exception -> 0x0097 }
            if (r1 == 0) goto L_0x0086
            java.lang.String r2 = "code"
            java.lang.String r3 = "tcid"
            java.lang.String r4 = "enginever"
            java.lang.String r5 = "downurl"
            java.lang.String r6 = "lang"
            java.lang.String r7 = "price"
            java.lang.String r8 = "newflag"
            java.lang.String r9 = "isShow"
            java.lang.String r10 = "wordinfos"
            java.lang.String r11 = "orderno"
            java.lang.String r12 = "subtype"
            java.lang.String r13 = "xytinfos"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3 = 12
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r3 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r3]     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 7
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 8
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 9
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 10
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r4 = 11
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            r3[r4] = r5     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.util.List r2 = convertCursorToCV(r1, r2, r3)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
        L_0x0074:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            if (r3 == 0) goto L_0x0086
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            java.lang.String r4 = "TemplateRoll"
            r15.replace(r4, r0, r3)     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            goto L_0x0074
        L_0x0086:
            r14.setTransactionSuccessful()     // Catch:{ Exception -> 0x0091, all -> 0x008f }
            if (r1 == 0) goto L_0x00a0
            r1.close()
            goto L_0x00a0
        L_0x008f:
            r15 = move-exception
            goto L_0x00a4
        L_0x0091:
            r15 = move-exception
            r0 = r1
            goto L_0x0098
        L_0x0094:
            r15 = move-exception
            r1 = r0
            goto L_0x00a4
        L_0x0097:
            r15 = move-exception
        L_0x0098:
            r15.printStackTrace()     // Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x00a0
            r0.close()
        L_0x00a0:
            r14.endTransaction()
            return
        L_0x00a4:
            if (r1 == 0) goto L_0x00a9
            r1.close()
        L_0x00a9:
            r14.endTransaction()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateRoll(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplateRollMap(android.database.sqlite.SQLiteDatabase r6, android.database.sqlite.SQLiteDatabase r7) {
        /*
            r0 = 0
            r6.beginTransaction()     // Catch:{ Exception -> 0x004c }
            java.lang.String r1 = "select * from TemplateRollMap"
            android.database.Cursor r1 = r6.rawQuery(r1, r0)     // Catch:{ Exception -> 0x004c }
            if (r1 == 0) goto L_0x003b
            java.lang.String r2 = "rollcode"
            java.lang.String r3 = "ttid"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r3 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r3 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r3]     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r4 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r4 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r5 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_LONG     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.util.List r2 = convertCursorToCV(r1, r2, r3)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
        L_0x0029:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.lang.String r4 = "TemplateRollMap"
            r7.replace(r4, r0, r3)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            goto L_0x0029
        L_0x003b:
            r6.setTransactionSuccessful()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            if (r1 == 0) goto L_0x0055
            r1.close()
            goto L_0x0055
        L_0x0044:
            r7 = move-exception
            goto L_0x0059
        L_0x0046:
            r7 = move-exception
            r0 = r1
            goto L_0x004d
        L_0x0049:
            r7 = move-exception
            r1 = r0
            goto L_0x0059
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            r7.printStackTrace()     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0055
            r0.close()
        L_0x0055:
            r6.endTransaction()
            return
        L_0x0059:
            if (r1 == 0) goto L_0x005e
            r1.close()
        L_0x005e:
            r6.endTransaction()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateRollMap(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void moveTemplateScene(android.database.sqlite.SQLiteDatabase r18, android.database.sqlite.SQLiteDatabase r19) {
        /*
            r1 = 0
            r18.beginTransaction()     // Catch:{ Exception -> 0x00af, all -> 0x00aa }
            java.lang.String r0 = "select * from TemplateScene"
            r2 = r18
            android.database.Cursor r3 = r2.rawQuery(r0, r1)     // Catch:{ Exception -> 0x00a8 }
            if (r3 == 0) goto L_0x009a
            java.lang.String r4 = "tcid"
            java.lang.String r5 = "scene_code"
            java.lang.String r6 = "orderNo"
            java.lang.String r7 = "lang"
            java.lang.String r8 = "name"
            java.lang.String r9 = "desc"
            java.lang.String r10 = "thumb"
            java.lang.String r11 = "newcount"
            java.lang.String r12 = "fromtype"
            java.lang.String r13 = "color"
            java.lang.String r14 = "bigicon"
            java.lang.String r15 = "previewvideo"
            java.lang.String r16 = "imgurl"
            java.lang.String r17 = "instagramimglist"
            java.lang.String[] r0 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17}     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4 = 14
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE[] r4 = new com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE[r4]     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 0
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 1
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 2
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 3
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 4
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 5
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 6
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 7
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 8
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_INT     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 9
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 10
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 11
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 12
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r5 = 13
            com.introvd.template.datacenter.TemplateDBRefactUtil$VALUE_TYPE r6 = com.introvd.template.datacenter.TemplateDBRefactUtil.VALUE_TYPE.TYPE_STRING     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r4[r5] = r6     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.util.List r0 = convertCursorToCV(r3, r0, r4)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
        L_0x0086:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r4 == 0) goto L_0x009a
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            android.content.ContentValues r4 = (android.content.ContentValues) r4     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r5 = "TemplateScene"
            r6 = r19
            r6.replace(r5, r1, r4)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            goto L_0x0086
        L_0x009a:
            r18.setTransactionSuccessful()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r3 == 0) goto L_0x00ba
            r3.close()
            goto L_0x00ba
        L_0x00a3:
            r0 = move-exception
            goto L_0x00c0
        L_0x00a5:
            r0 = move-exception
            r1 = r3
            goto L_0x00b2
        L_0x00a8:
            r0 = move-exception
            goto L_0x00b2
        L_0x00aa:
            r0 = move-exception
            r2 = r18
        L_0x00ad:
            r3 = r1
            goto L_0x00c0
        L_0x00af:
            r0 = move-exception
            r2 = r18
        L_0x00b2:
            r0.printStackTrace()     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x00ba
            r1.close()
        L_0x00ba:
            r18.endTransaction()
            return
        L_0x00be:
            r0 = move-exception
            goto L_0x00ad
        L_0x00c0:
            if (r3 == 0) goto L_0x00c5
            r3.close()
        L_0x00c5:
            r18.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateScene(android.database.sqlite.SQLiteDatabase, android.database.sqlite.SQLiteDatabase):void");
    }

    static void removeOldTemplate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("DROP VIEW IF EXISTS TemplateInfoView");
            sQLiteDatabase.execSQL("DROP VIEW IF EXISTS TemplatePackageDetailView");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Template");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplateRoll");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplateRecommendRoll");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplateRollMap");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplateMonetization");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplateFontInfo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplateScene");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplatePackage");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplateCard");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplateInfoNew");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplateInfoRecommend");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS TemplatePackageDetailNew");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }
}
