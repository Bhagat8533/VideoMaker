package com.introvd.template.template.p409g;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.editor.TemplateItemData.Builder;
import java.util.ArrayList;

/* renamed from: com.introvd.template.template.g.c */
public class C8761c {
    private static Uri etO;

    /* renamed from: a */
    public static void m25606a(ContentResolver contentResolver, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SocialConstDef.TEMPLATE_DELETE_FLAG, Integer.valueOf(0));
        String[] strArr = {String.valueOf(j), String.valueOf(1)};
        contentResolver.update(getTableUri(), contentValues, "template_id = ? AND delFlag = ?", strArr);
    }

    /* renamed from: a */
    public static void m25607a(ContentResolver contentResolver, TemplateItemData templateItemData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SocialConstDef.TEMPLATE_ID, Long.valueOf(templateItemData.lID));
        contentValues.put("from_type", Integer.valueOf(templateItemData.nFromType));
        contentValues.put("url", templateItemData.strPath);
        contentValues.put("ver", Integer.valueOf(templateItemData.nVersion));
        contentValues.put("updatetime", Long.valueOf(templateItemData.lUpdateTime));
        contentValues.put("orderno", Integer.valueOf(templateItemData.nOrder));
        contentValues.put(SocialConstDef.TEMPLATE_FAVORITE, Integer.valueOf(templateItemData.nFavorite));
        contentValues.put("layout", Integer.valueOf(templateItemData.nLayoutFlag));
        contentValues.put(SocialConstDef.TEMPLATE_SUB_ORDERNO, Integer.valueOf(templateItemData.nSubOrder));
        contentValues.put("title", templateItemData.strTitleJSON);
        contentValues.put(SocialConstDef.TEMPLATE_CONFIGURE_COUNT, Integer.valueOf(templateItemData.nConfigureCount));
        contentValues.put("downFlag", Integer.valueOf(templateItemData.getNeedDownloadFlag()));
        contentValues.put(SocialConstDef.TEMPLATE_EXT_INFO, templateItemData.strExtInfo);
        contentValues.put("mission", templateItemData.strMission);
        contentValues.put("mresult", templateItemData.strMissionResult);
        contentValues.put("scene_code", templateItemData.strSceneCode);
        contentResolver.insert(getTableUri(), contentValues);
    }

    /* renamed from: b */
    public static void m25608b(ContentResolver contentResolver, long j) {
        contentResolver.delete(getTableUri(), "template_id = ?", new String[]{String.valueOf(j)});
    }

    /* renamed from: c */
    public static void m25609c(ContentResolver contentResolver, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SocialConstDef.TEMPLATE_DELETE_FLAG, Integer.valueOf(1));
        String[] strArr = {String.valueOf(j)};
        contentResolver.update(getTableUri(), contentValues, "template_id = ?", strArr);
    }

    private static Uri getTableUri() {
        if (etO == null) {
            synchronized (C8761c.class) {
                if (etO == null) {
                    etO = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE);
                }
            }
        }
        return etO;
    }

    /* renamed from: i */
    public static ArrayList<TemplateItemData> m25610i(ContentResolver contentResolver) {
        Cursor cursor;
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(getTableUri(), new String[]{SocialConstDef.TEMPLATE_ID, "url", "orderno", "from_type", "ver", "updatetime", SocialConstDef.TEMPLATE_FAVORITE, SocialConstDef.TEMPLATE_SUB_ORDERNO, "layout", SocialConstDef.TEMPLATE_EXT_INFO, "title", SocialConstDef.TEMPLATE_CONFIGURE_COUNT, "downFlag", "mission", "mresult", SocialConstDef.TEMPLATE_DELETE_FLAG, "scene_code"}, null, null, "orderno DESC, updatetime");
        if (query == null) {
            return null;
        }
        if (query.getCount() == 0) {
            query.close();
            return null;
        }
        ArrayList<TemplateItemData> arrayList = new ArrayList<>();
        while (query.moveToNext()) {
            long j = query.getLong(0);
            String string = query.getString(1);
            try {
                int i = query.getInt(2);
                int i2 = query.getInt(3);
                int i3 = query.getInt(4);
                long j2 = (long) query.getInt(5);
                int i4 = query.getInt(6);
                int i5 = query.getInt(7);
                int i6 = query.getInt(8);
                String string2 = query.getString(9);
                String string3 = query.getString(10);
                int i7 = query.getInt(11);
                int i8 = query.getInt(12);
                cursor = query;
                try {
                    ArrayList<TemplateItemData> arrayList2 = arrayList;
                    String string4 = query.getString(16);
                    int i9 = i7;
                    int i10 = i8;
                    int i11 = query.getInt(15);
                    r3 = r3;
                    try {
                        Builder builder = new Builder(string, j, i3, i2, j2);
                        TemplateItemData build = builder.nOrder(i).nOriOrder(i).nFavorite(i4).nSubOrder(i5).nLayoutFlag(i6).strExtInfo(string2).strTitleJSON(string3).nConfigureCount(i9).nNeedDownloadFlag(i10).strSceneCode(string4).nDelFlag(i11).build();
                        arrayList = arrayList2;
                        arrayList.add(build);
                    } catch (Throwable unused) {
                        arrayList = arrayList2;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                cursor = query;
            }
            query = cursor;
        }
        query.close();
        return arrayList;
    }
}
