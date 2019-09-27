package com.introvd.template.app.school.p198db.classes;

import com.introvd.template.app.school.p198db.C4175a;
import com.introvd.template.app.school.p198db.dao.gen.C4183b;
import com.introvd.template.app.school.p198db.dao.gen.DBClassInfoDao;
import com.introvd.template.app.school.p198db.dao.gen.DBClassInfoDao.Properties;
import java.util.List;
import org.greenrobot.p490a.p495e.C10008j;

/* renamed from: com.introvd.template.app.school.db.classes.a */
public class C4178a implements C4179b {
    private DBClassInfoDao bxQ;

    public C4178a(C4183b bVar) {
        if (bVar != null) {
            this.bxQ = bVar.mo24096Oc();
        }
    }

    /* renamed from: b */
    public void mo24064O(DBClassInfo dBClassInfo) {
        this.bxQ.insertOrReplace(dBClassInfo);
    }

    /* renamed from: hn */
    public List<DBClassInfo> mo24066hn(int i) {
        return this.bxQ.queryBuilder().mo38464a(Properties.bxS.mo38481aC(Integer.valueOf(i)), new C10008j[0]).bas().list();
    }

    /* renamed from: ho */
    public void mo24067ho(int i) {
        this.bxQ.queryBuilder().mo38464a(Properties.bxS.mo38481aC(Integer.valueOf(i)), new C10008j[0]).bau().bam();
        C4175a.m10395NW().mo24017NZ();
    }
}
