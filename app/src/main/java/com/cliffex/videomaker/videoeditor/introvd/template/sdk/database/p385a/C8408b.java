package com.introvd.template.sdk.database.p385a;

import com.introvd.template.sdk.database.model.DBClipRef;
import com.introvd.template.sdk.database.model.DBClipRefDao;
import com.introvd.template.sdk.database.model.DBClipRefDao.Properties;
import com.introvd.template.sdk.database.model.DaoSession;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.p490a.p495e.C10008j;

/* renamed from: com.introvd.template.sdk.database.a.b */
public class C8408b {
    private DBClipRefDao eds;

    public C8408b(DaoSession daoSession) {
        this.eds = daoSession.getDBClipRefDao();
    }

    /* renamed from: aZ */
    public int mo33988aZ(long j) {
        return (int) this.eds.queryBuilder().mo38464a(Properties.Clip_id.mo38481aC(Long.valueOf(j)), new C10008j[0]).count();
    }

    /* renamed from: b */
    public void mo33989b(long j, long j2, boolean z) {
        if (z) {
            DBClipRef dBClipRef = new DBClipRef();
            dBClipRef.prj_id = j;
            dBClipRef.clip_id = j2;
            this.eds.insert(dBClipRef);
            return;
        }
        int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
        if (i != 0 && j2 != -1) {
            List list = this.eds.queryBuilder().mo38464a(Properties.Prj_id.mo38481aC(Long.valueOf(j)), Properties.Clip_id.mo38481aC(Long.valueOf(j2))).list();
            if (list != null && list.size() > 0) {
                this.eds.delete(list.get(0));
            }
        } else if (i != 0) {
            this.eds.queryBuilder().mo38464a(Properties.Prj_id.mo38481aC(Long.valueOf(j)), new C10008j[0]).bau().bam();
        } else if (j2 != -1) {
            this.eds.queryBuilder().mo38464a(Properties.Clip_id.mo38481aC(Long.valueOf(j2)), new C10008j[0]).bau().bam();
        }
    }

    /* renamed from: ba */
    public ArrayList<Long> mo33990ba(long j) {
        List<DBClipRef> list = this.eds.queryBuilder().mo38464a(Properties.Prj_id.mo38481aC(Long.valueOf(j)), new C10008j[0]).bas().list();
        ArrayList<Long> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        for (DBClipRef dBClipRef : list) {
            if (!arrayList.contains(Long.valueOf(dBClipRef.clip_id))) {
                arrayList.add(Long.valueOf(dBClipRef.clip_id));
            }
        }
        return arrayList;
    }

    /* renamed from: bb */
    public void mo33991bb(long j) {
        this.eds.queryBuilder().mo38464a(Properties.Clip_id.mo38481aC(Long.valueOf(j)), new C10008j[0]).bau().bam();
    }

    /* renamed from: bc */
    public void mo33992bc(long j) {
        List<DBClipRef> list = this.eds.queryBuilder().mo38464a(Properties.Prj_id.mo38481aC(Integer.valueOf(Integer.MAX_VALUE)), new C10008j[0]).bas().list();
        if (list != null) {
            for (DBClipRef dBClipRef : list) {
                dBClipRef.prj_id = j;
            }
            this.eds.updateInTx((Iterable<T>) list);
        }
    }
}
