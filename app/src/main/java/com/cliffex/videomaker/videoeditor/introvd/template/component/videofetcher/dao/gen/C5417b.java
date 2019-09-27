package com.introvd.template.component.videofetcher.dao.gen;

import com.introvd.template.component.videofetcher.p239c.C5391a;
import java.util.Map;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.C9980c;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p493c.C9984d;
import org.greenrobot.p490a.p494d.C9986a;

/* renamed from: com.introvd.template.component.videofetcher.dao.gen.b */
public class C5417b extends C9980c {
    private final C9986a cko;
    private final DownloadInfoBeanDao ckp = new DownloadInfoBeanDao(this.cko, this);

    public C5417b(C9972a aVar, C9984d dVar, Map<Class<? extends C9964a<?, ?>>, C9986a> map) {
        super(aVar);
        this.cko = ((C9986a) map.get(DownloadInfoBeanDao.class)).clone();
        this.cko.mo38395d(dVar);
        registerDao(C5391a.class, this.ckp);
    }

    public DownloadInfoBeanDao aac() {
        return this.ckp;
    }
}
