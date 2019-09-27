package com.introvd.template.sdk.database.p385a;

import com.introvd.template.sdk.database.model.DBClip;
import com.introvd.template.sdk.database.model.DBClipDao;
import com.introvd.template.sdk.database.model.DBClipDao.Properties;
import com.introvd.template.sdk.database.model.DaoSession;
import com.introvd.template.sdk.model.editor.DataItemClip;
import java.util.List;
import org.greenrobot.p490a.p495e.C10008j;

/* renamed from: com.introvd.template.sdk.database.a.a */
public class C8407a {
    private DBClipDao edr;

    public C8407a(DaoSession daoSession) {
        this.edr = daoSession.getDBClipDao();
    }

    /* renamed from: a */
    public long mo33984a(DataItemClip dataItemClip) {
        DBClip dBClip = new DBClip();
        dBClip.url = dataItemClip.strClipURL;
        return this.edr.insert(dBClip);
    }

    /* renamed from: aX */
    public String mo33985aX(long j) {
        List list = this.edr.queryBuilder().mo38464a(Properties._id.mo38481aC(Long.valueOf(j)), new C10008j[0]).bas().list();
        if (list == null || list.size() <= 0) {
            return null;
        }
        return ((DBClip) list.get(0)).url;
    }

    /* renamed from: aY */
    public void mo33986aY(long j) {
        this.edr.deleteByKey(Long.valueOf(j));
    }

    /* renamed from: nA */
    public long mo33987nA(String str) {
        List list = this.edr.queryBuilder().mo38464a(Properties.Url.mo38481aC(str), new C10008j[0]).bas().list();
        if (list == null || list.size() <= 0) {
            return -1;
        }
        return ((DBClip) list.get(0))._id.longValue();
    }
}
