package com.introvd.template.common;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.app.api.model.SnsConfigResult;
import com.introvd.template.datacenter.SocialConstDef;
import java.util.ArrayList;
import java.util.List;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

public class SnsConfigMgr {
    private static List<Integer> ccF = new ArrayList();
    private static final int[] ccG = {28, 31, 25, 3, 29, 38};
    private static final int[] ccH = {28, 3, 25, 31, 29, 38};
    private static final int[] ccI = {25, 31, 29, 38};
    private static final int[] ccJ = {3, 31, 25, 29, 38};

    public static class SnsItemInfo {
        public boolean isMain;
        public String mCountryCode = "";
        public String mDesc = "";
        public String mShareParam = "";
        public int mShareType = 1;
        public int mSnsCode = 0;
        public String mSnsLogo = "";
        public String mSnsName = "";
        public String mTitle = "";
    }

    static {
        ccF.add(Integer.valueOf(40));
        ccF.add(Integer.valueOf(11));
        ccF.add(Integer.valueOf(1));
        ccF.add(Integer.valueOf(45));
        ccF.add(Integer.valueOf(28));
        ccF.add(Integer.valueOf(26));
        ccF.add(Integer.valueOf(31));
        ccF.add(Integer.valueOf(32));
        ccF.add(Integer.valueOf(38));
        ccF.add(Integer.valueOf(33));
        ccF.add(Integer.valueOf(4));
        ccF.add(Integer.valueOf(29));
        ccF.add(Integer.valueOf(7));
        ccF.add(Integer.valueOf(43));
    }

    public static List<SnsItemInfo> getDefaultSnsConfigItemList() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < 6) {
            SnsItemInfo snsItemInfo = new SnsItemInfo();
            snsItemInfo.mSnsCode = ccG[i];
            snsItemInfo.isMain = i < 3;
            arrayList.add(snsItemInfo);
            i++;
        }
        return arrayList;
    }

    public static void getSnsConfig(final String str) {
        C3727b.m9080J(str, "0").mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<SnsConfigResult>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }

            public void onSuccess(List<SnsConfigResult> list) {
                Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SNS_CONFIG);
                ContentResolver contentResolver = VivaBaseApplication.m8749FZ().getContentResolver();
                contentResolver.delete(tableUri, "countrycode= ?  ", new String[]{str});
                ContentValues contentValues = new ContentValues();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    SnsConfigResult snsConfigResult = (SnsConfigResult) list.get(i);
                    contentValues.clear();
                    contentValues.put("orderno", Integer.valueOf(snsConfigResult.orderno));
                    contentValues.put(SocialConstDef.SNSCONFIG_ITEM_COUNTRYCODE, str);
                    if (!TextUtils.isEmpty(snsConfigResult.snscode)) {
                        contentValues.put(SocialConstDef.SNSCONFIG_ITEM_SNSCODE, snsConfigResult.snscode);
                    }
                    if (!TextUtils.isEmpty(snsConfigResult.snsname)) {
                        contentValues.put(SocialConstDef.SNSCONFIG_ITEM_SNSNAME, snsConfigResult.snsname);
                    }
                    if (!TextUtils.isEmpty(snsConfigResult.snslogo)) {
                        contentValues.put(SocialConstDef.SNSCONFIG_ITEM_SNSLOGO, snsConfigResult.snslogo);
                    }
                    contentValues.put(SocialConstDef.SNSCONFIG_ITEM_ISINTENT, Integer.valueOf(snsConfigResult.isintent));
                    if (!TextUtils.isEmpty(snsConfigResult.intentparam)) {
                        contentValues.put(SocialConstDef.SNSCONFIG_ITEM_INTENTPARAM, snsConfigResult.intentparam);
                    }
                    if (!TextUtils.isEmpty(snsConfigResult.title)) {
                        contentValues.put("title", snsConfigResult.title);
                    }
                    if (!TextUtils.isEmpty(snsConfigResult.desc)) {
                        contentValues.put("desc", snsConfigResult.desc);
                    }
                    contentValues.put(SocialConstDef.SNSCONFIG_ITEM_PAGETYPE, Integer.valueOf(snsConfigResult.pagetype));
                    contentValues.put(SocialConstDef.SNSCONFIG_ITEM_ISMAIN, Integer.valueOf(snsConfigResult.ismain));
                    contentResolver.insert(tableUri, contentValues);
                }
            }
        });
    }

    public static List<SnsItemInfo> getSnsConfigItemList(Context context, String str, String str2) {
        String[] strArr;
        String str3;
        String str4 = str2;
        String[] strArr2 = {"orderno", SocialConstDef.SNSCONFIG_ITEM_COUNTRYCODE, SocialConstDef.SNSCONFIG_ITEM_SNSCODE, SocialConstDef.SNSCONFIG_ITEM_SNSNAME, SocialConstDef.SNSCONFIG_ITEM_SNSLOGO, SocialConstDef.SNSCONFIG_ITEM_ISINTENT, SocialConstDef.SNSCONFIG_ITEM_INTENTPARAM, "title", "desc", SocialConstDef.SNSCONFIG_ITEM_ISMAIN};
        ContentResolver contentResolver = context.getContentResolver();
        if ("0".equals(str4)) {
            str3 = "countrycode= ?";
            strArr = new String[]{str};
        } else {
            str3 = "countrycode= ? and pagetype= ?";
            strArr = new String[]{str, str4};
        }
        Cursor query = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SNS_CONFIG), strArr2, str3, strArr, "orderno asc");
        if (query == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                SnsItemInfo snsItemInfo = new SnsItemInfo();
                snsItemInfo.mCountryCode = query.getString(query.getColumnIndex(SocialConstDef.SNSCONFIG_ITEM_COUNTRYCODE));
                snsItemInfo.mSnsCode = query.getInt(query.getColumnIndex(SocialConstDef.SNSCONFIG_ITEM_SNSCODE));
                snsItemInfo.mSnsName = query.getString(query.getColumnIndex(SocialConstDef.SNSCONFIG_ITEM_SNSNAME));
                snsItemInfo.mSnsLogo = query.getString(query.getColumnIndex(SocialConstDef.SNSCONFIG_ITEM_SNSLOGO));
                snsItemInfo.mShareType = query.getInt(query.getColumnIndex(SocialConstDef.SNSCONFIG_ITEM_ISINTENT));
                snsItemInfo.mShareParam = query.getString(query.getColumnIndex(SocialConstDef.SNSCONFIG_ITEM_INTENTPARAM));
                snsItemInfo.mTitle = query.getString(query.getColumnIndex("title"));
                snsItemInfo.mDesc = query.getString(query.getColumnIndex("desc"));
                snsItemInfo.isMain = query.getInt(query.getColumnIndex(SocialConstDef.SNSCONFIG_ITEM_ISMAIN)) == 0;
                arrayList.add(snsItemInfo);
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        return arrayList;
    }

    public static List<Integer> loadSnsConfigInfos(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        List<SnsItemInfo> snsConfigItemList = getSnsConfigItemList(context, str, "1");
        if (snsConfigItemList == null || snsConfigItemList.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SnsItemInfo snsItemInfo : snsConfigItemList) {
            if (ccF.contains(Integer.valueOf(snsItemInfo.mSnsCode)) && !arrayList.contains(Integer.valueOf(snsItemInfo.mSnsCode))) {
                arrayList.add(Integer.valueOf(snsItemInfo.mSnsCode));
            }
        }
        return arrayList;
    }
}
