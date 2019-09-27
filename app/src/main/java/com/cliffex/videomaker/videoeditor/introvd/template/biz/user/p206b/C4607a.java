package com.introvd.template.biz.user.p206b;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.biz.user.p206b.C4608b.C4610a;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p374q.C8358i;
import com.introvd.template.router.user.UserServiceProxy;

/* renamed from: com.introvd.template.biz.user.b.a */
public class C4607a implements C4610a {
    private static C4607a bLJ;
    private Context mContext;

    /* renamed from: SR */
    public static C4607a m11749SR() {
        if (bLJ == null) {
            bLJ = new C4607a();
        }
        return bLJ;
    }

    /* renamed from: SS */
    private void m11750SS() {
        if (this.mContext != null) {
            Cursor query = this.mContext.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SNS), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        int i = query.getInt(query.getColumnIndex("type"));
                        if (query.getInt(query.getColumnIndex(SocialConstDef.SNS_BIND_FLAG)) == 1) {
                            C8358i.m24108cs(this.mContext, String.valueOf(i));
                        }
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                query.close();
            }
        }
    }

    /* renamed from: fZ */
    public void mo24878fZ(int i) {
        C8358i.m24108cs(this.mContext, String.valueOf(i));
    }

    public String getScreenNameBySnsType(int i) {
        if (this.mContext == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        Cursor query = this.mContext.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SNS), null, "where type = ? ", new String[]{sb.toString()}, null);
        if (query == null) {
            return "";
        }
        String str = "";
        try {
            if (query.moveToNext()) {
                str = query.getString(query.getColumnIndex("nickname"));
            }
        } catch (Throwable th) {
            query.close();
            throw th;
        }
        query.close();
        return str;
    }

    public void init(Context context) {
        this.mContext = context;
        C4608b.m11752ST().mo24884a(this);
        m11750SS();
    }

    public boolean isAuthed(int i) {
        boolean z = false;
        if (this.mContext == null || i == 38 || i == 29) {
            return false;
        }
        if (i == 31 || i == 28 || i == 3) {
            return C4608b.m11752ST().mo24883C(this.mContext, i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        Cursor query = this.mContext.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SNS), null, "where type = ? ", new String[]{sb.toString()}, null);
        if (query == null) {
            return false;
        }
        try {
            if (query.moveToNext()) {
                long j = query.getLong(query.getColumnIndex("expiredtime"));
                String string = query.getString(query.getColumnIndex("uid"));
                long j2 = query.getLong(query.getColumnIndex("updatetime"));
                if (TextUtils.isEmpty(string)) {
                    query.close();
                    return false;
                } else if (Math.abs(System.currentTimeMillis() - j2) / 1000 > j - 3600) {
                    query.close();
                    return false;
                } else {
                    z = true;
                }
            }
        } catch (Throwable th) {
            query.close();
            throw th;
        }
        query.close();
        return z;
    }

    public void onAuthComplete(int i, Bundle bundle) {
        if (this.mContext != null && bundle != null && !TextUtils.isEmpty(UserServiceProxy.getUserId())) {
            C8358i.m24107a(this.mContext, String.valueOf(i), bundle, true);
        }
    }
}
