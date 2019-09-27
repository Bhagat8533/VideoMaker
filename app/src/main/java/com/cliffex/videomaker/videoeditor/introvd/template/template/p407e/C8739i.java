package com.introvd.template.template.p407e;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.p021v4.util.LongSparseArray;
import android.text.TextUtils;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.Utils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@LDPProtect
/* renamed from: com.introvd.template.template.e.i */
public class C8739i {
    private static LongSparseArray<C8740a> ete = new LongSparseArray<>();
    private static List<Long> etf = new ArrayList();
    private static List<Long> etg = new ArrayList();

    /* renamed from: com.introvd.template.template.e.i$a */
    public static class C8740a {
        public Date buG = null;
        public int cIs;
        public String eth = "";
        public String eti;
        public int etj = 0;
        public int etk = 0;
        public String etl = "";
        public String etm;
        public String mIconUrl;
        public String mTCID = "";
        public String mTitle;
    }

    /* renamed from: b */
    public static boolean m25521b(Context context, Long l) {
        if (ete == null || ete.indexOfKey(l.longValue()) < 0) {
            return false;
        }
        C8740a aVar = (C8740a) ete.get(l.longValue());
        aVar.etj = 1;
        return m25525m(context, aVar.eth, aVar.etj);
    }

    /* renamed from: bu */
    public static boolean m25522bu(long j) {
        boolean z = false;
        if (!C8072q.aBx().mo33072ku(C7825a.ALL_TEMPLATE.getId()) && !AppPreferencesSetting.getInstance().getAppSettingBoolean("key_unlock_for_rate", false) && ete != null && ete.indexOfKey(j) >= 0) {
            C8740a aVar = (C8740a) ete.get(j);
            if (aVar != null && aVar.etj == 0 && (aVar.buG == null || C4584e.m11681c(new Date(), aVar.buG))) {
                if (aVar.cIs == 16003) {
                    z = true;
                }
                if (z && etf != null && !etf.contains(Long.valueOf(j))) {
                    etf.add(Long.valueOf(j));
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: cC */
    public static boolean m25523cC(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            if (!Utils.isOfficalVersion(context)) {
                ToastUtils.show(context, "素材解锁ID不能为空", 1);
            }
            return false;
        }
        if (m25527qr(str)) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("key_unlock_for_rate", true);
        }
        try {
            return m25521b(context, Long.decode(str));
        } catch (Exception e) {
            C5523b.logException(e);
            return false;
        }
    }

    /* renamed from: ho */
    public static boolean m25524ho(Context context) {
        if (context == null) {
            return false;
        }
        Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_MONETIZATION), new String[]{"tcid", "ttid", SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCODE, SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCONTENT, "expiretime", SocialConstDef.TEMPLATEMONETIZATION_ITEM_LOCKSTATE, "previewtype", "previewurl", "title", "intro", "iconurl"}, null, null, null);
        if (query == null) {
            return false;
        }
        int count = query.getCount();
        if (count == ete.size() || count <= 0) {
            query.close();
            return false;
        }
        try {
            ete.clear();
            etg.clear();
        } catch (ArrayIndexOutOfBoundsException e) {
            ete = new LongSparseArray<>();
            C5523b.logException(e);
        }
        query.moveToFirst();
        do {
            String string = query.getString(query.getColumnIndex("tcid"));
            String string2 = query.getString(query.getColumnIndex("ttid"));
            int i = query.getInt(query.getColumnIndex(SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCODE));
            String string3 = query.getString(query.getColumnIndex(SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCONTENT));
            String string4 = query.getString(query.getColumnIndex("expiretime"));
            int i2 = query.getInt(query.getColumnIndex(SocialConstDef.TEMPLATEMONETIZATION_ITEM_LOCKSTATE));
            int i3 = query.getInt(query.getColumnIndex("previewtype"));
            String string5 = query.getString(query.getColumnIndex("previewurl"));
            String string6 = query.getString(query.getColumnIndex("title"));
            String string7 = query.getString(query.getColumnIndex("intro"));
            String string8 = query.getString(query.getColumnIndex("iconurl"));
            C8740a aVar = new C8740a();
            aVar.mTCID = string;
            aVar.eth = string2;
            aVar.cIs = i;
            aVar.eti = string3;
            aVar.etj = i2;
            aVar.etk = i3;
            aVar.etl = string5;
            if (!TextUtils.isEmpty(string4)) {
                aVar.buG = C4584e.m11684eH(string4);
            }
            aVar.mTitle = string6;
            aVar.etm = string7;
            aVar.mIconUrl = string8;
            try {
                ete.put(Long.decode(string2).longValue(), aVar);
            } catch (Exception e2) {
                C5523b.logException(e2);
            }
        } while (query.moveToNext());
        query.close();
        return true;
    }

    public static boolean isNeedToPurchase(String str) {
        try {
            return m25529u(Long.decode(str));
        } catch (Exception e) {
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append("-");
            sb.append(str);
            sb.append("-");
            hashMap.put("Err_Purchase_TTID", sb.toString());
            UserBehaviorLog.onAliEvent("Dev_Event_App_Error_analysis", hashMap);
            return false;
        }
    }

    /* renamed from: m */
    private static boolean m25525m(Context context, String str, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_MONETIZATION);
        ContentValues contentValues = new ContentValues();
        contentValues.put(SocialConstDef.TEMPLATEMONETIZATION_ITEM_LOCKSTATE, Integer.valueOf(i));
        return contentResolver.update(tableUri, contentValues, "ttid = ?", new String[]{str}) > 0;
    }

    /* renamed from: qq */
    public static boolean m25526qq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return m25530v(Long.valueOf(C2575a.m7391rq(str)));
        } catch (NumberFormatException e) {
            C5523b.logException(e);
            return false;
        }
    }

    /* renamed from: qr */
    public static boolean m25527qr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return m25522bu(Long.decode(str).longValue());
        } catch (Exception e) {
            C5523b.logException(e);
            return false;
        }
    }

    /* renamed from: qs */
    public static boolean m25528qs(String str) {
        try {
            return m25533y(Long.decode(str));
        } catch (Exception e) {
            C5523b.logException(e);
            return false;
        }
    }

    /* renamed from: u */
    public static boolean m25529u(Long l) {
        boolean z = false;
        if (ete == null || ete.indexOfKey(l.longValue()) < 0) {
            return false;
        }
        C8740a aVar = (C8740a) ete.get(l.longValue());
        if (aVar != null && aVar.cIs == 1110) {
            z = true;
        }
        return z;
    }

    /* renamed from: v */
    public static boolean m25530v(Long l) {
        boolean z = false;
        if (C8072q.aBx().mo33070i(C7825a.ALL.getId(), C7825a.PREMIUM_PACK.getId(), C7825a.AD.getId()) || ete == null || ete.indexOfKey(l.longValue()) < 0) {
            return false;
        }
        C8740a aVar = (C8740a) ete.get(l.longValue());
        if (aVar == null) {
            return false;
        }
        TemplateItemData bD = C8762d.aMt().mo35227bD(l.longValue());
        if ((bD != null && !bD.shouldOnlineDownload()) || aVar.etj != 0) {
            return false;
        }
        if (aVar.buG != null && !C4584e.m11681c(new Date(), aVar.buG)) {
            return false;
        }
        if (aVar.cIs == 1109) {
            z = true;
        }
        if (z && etf != null && !etf.contains(l)) {
            etf.add(l);
        }
        return z;
    }

    /* renamed from: w */
    public static String m25531w(Long l) {
        return (ete == null || ete.indexOfKey(l.longValue()) < 0) ? "" : ((C8740a) ete.get(l.longValue())).etl;
    }

    /* renamed from: x */
    public static C8740a m25532x(Long l) {
        if (ete == null || ete.indexOfKey(l.longValue()) < 0) {
            return null;
        }
        return (C8740a) ete.get(l.longValue());
    }

    /* renamed from: y */
    public static boolean m25533y(Long l) {
        if (ete == null || ete.size() <= 0) {
            return false;
        }
        C8740a aVar = (C8740a) ete.get(l.longValue());
        if (aVar == null) {
            return false;
        }
        if (etg.indexOf(l) > 0) {
            return true;
        }
        if (!(aVar.cIs == 1113)) {
            return false;
        }
        etg.add(l);
        return true;
    }
}
