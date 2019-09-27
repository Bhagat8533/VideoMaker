package com.introvd.template.app.school.p198db.template;

import com.introvd.template.app.school.p198db.C4175a;
import com.introvd.template.app.school.p198db.dao.gen.C4183b;
import com.introvd.template.app.school.p198db.dao.gen.TemplateItemInfoDao;
import com.introvd.template.app.school.p198db.dao.gen.TemplateItemInfoDao.Properties;
import java.util.List;
import org.greenrobot.p490a.p495e.C10008j;

/* renamed from: com.introvd.template.app.school.db.template.b */
public class C4185b implements C4184a {
    private TemplateItemInfoDao byC;

    public C4185b(C4183b bVar) {
        if (bVar != null) {
            this.byC = bVar.mo24097Od();
        }
    }

    /* renamed from: D */
    public List<TemplateItemInfo> mo24147D(long j) {
        return this.byC.queryBuilder().mo38464a(Properties.bxS.mo38481aC(Long.valueOf(j)), new C10008j[0]).bas().list();
    }

    /* renamed from: E */
    public void mo24148E(long j) {
        this.byC.queryBuilder().mo38464a(Properties.bxS.mo38481aC(Long.valueOf(j)), new C10008j[0]).bau().bam();
        C4175a.m10395NW().mo24017NZ();
    }

    /* renamed from: d */
    public void mo24064O(TemplateItemInfo templateItemInfo) {
        this.byC.insertOrReplace(templateItemInfo);
    }
}
