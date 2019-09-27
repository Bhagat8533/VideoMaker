package com.introvd.template.app.school.p198db.dao.gen;

import com.introvd.template.app.school.p198db.classes.DBClassInfo;
import com.introvd.template.app.school.p198db.template.TemplateItemInfo;
import java.util.Map;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.C9980c;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p493c.C9984d;
import org.greenrobot.p490a.p494d.C9986a;

/* renamed from: com.introvd.template.app.school.db.dao.gen.b */
public class C4183b extends C9980c {
    private final C9986a byi;
    private final C9986a byj;
    private final DBClassInfoDao byk = new DBClassInfoDao(this.byi, this);
    private final TemplateItemInfoDao byl = new TemplateItemInfoDao(this.byj, this);

    public C4183b(C9972a aVar, C9984d dVar, Map<Class<? extends C9964a<?, ?>>, C9986a> map) {
        super(aVar);
        this.byi = ((C9986a) map.get(DBClassInfoDao.class)).clone();
        this.byi.mo38395d(dVar);
        this.byj = ((C9986a) map.get(TemplateItemInfoDao.class)).clone();
        this.byj.mo38395d(dVar);
        registerDao(DBClassInfo.class, this.byk);
        registerDao(TemplateItemInfo.class, this.byl);
    }

    /* renamed from: Oc */
    public DBClassInfoDao mo24096Oc() {
        return this.byk;
    }

    /* renamed from: Od */
    public TemplateItemInfoDao mo24097Od() {
        return this.byl;
    }

    public void clear() {
        this.byi.aZZ();
        this.byj.aZZ();
    }
}
