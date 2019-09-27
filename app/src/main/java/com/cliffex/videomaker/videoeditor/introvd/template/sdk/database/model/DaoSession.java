package com.introvd.template.sdk.database.model;

import java.util.Map;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.C9980c;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p493c.C9984d;
import org.greenrobot.p490a.p494d.C9986a;

public class DaoSession extends C9980c {
    private final DBClipDao dBClipDao = new DBClipDao(this.dBClipDaoConfig, this);
    private final C9986a dBClipDaoConfig;
    private final DBClipRefDao dBClipRefDao = new DBClipRefDao(this.dBClipRefDaoConfig, this);
    private final C9986a dBClipRefDaoConfig;
    private final DBProjectDao dBProjectDao = new DBProjectDao(this.dBProjectDaoConfig, this);
    private final C9986a dBProjectDaoConfig;

    public DaoSession(C9972a aVar, C9984d dVar, Map<Class<? extends C9964a<?, ?>>, C9986a> map) {
        super(aVar);
        this.dBClipDaoConfig = ((C9986a) map.get(DBClipDao.class)).clone();
        this.dBClipDaoConfig.mo38395d(dVar);
        this.dBClipRefDaoConfig = ((C9986a) map.get(DBClipRefDao.class)).clone();
        this.dBClipRefDaoConfig.mo38395d(dVar);
        this.dBProjectDaoConfig = ((C9986a) map.get(DBProjectDao.class)).clone();
        this.dBProjectDaoConfig.mo38395d(dVar);
        registerDao(DBClip.class, this.dBClipDao);
        registerDao(DBClipRef.class, this.dBClipRefDao);
        registerDao(DBProject.class, this.dBProjectDao);
    }

    public void clear() {
        this.dBClipDaoConfig.aZZ();
        this.dBClipRefDaoConfig.aZZ();
        this.dBProjectDaoConfig.aZZ();
    }

    public DBClipDao getDBClipDao() {
        return this.dBClipDao;
    }

    public DBClipRefDao getDBClipRefDao() {
        return this.dBClipRefDao;
    }

    public DBProjectDao getDBProjectDao() {
        return this.dBProjectDao;
    }
}
