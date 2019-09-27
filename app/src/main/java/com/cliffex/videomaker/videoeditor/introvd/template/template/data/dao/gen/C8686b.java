package com.introvd.template.template.data.dao.gen;

import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import java.util.Map;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.C9980c;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p493c.C9984d;
import org.greenrobot.p490a.p494d.C9986a;

/* renamed from: com.introvd.template.template.data.dao.gen.b */
public class C8686b extends C9980c {
    private final C9986a ela;
    private final DBTemplateAudioInfoDao elb = new DBTemplateAudioInfoDao(this.ela, this);

    public C8686b(C9972a aVar, C9984d dVar, Map<Class<? extends C9964a<?, ?>>, C9986a> map) {
        super(aVar);
        this.ela = ((C9986a) map.get(DBTemplateAudioInfoDao.class)).clone();
        this.ela.mo38395d(dVar);
        registerDao(DBTemplateAudioInfo.class, this.elb);
    }

    public DBTemplateAudioInfoDao aKr() {
        return this.elb;
    }
}
