package com.introvd.template.mid.lbs;

import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.lbs.LocationInfo;

public abstract class AbsLbsManager implements C1949c {
    public abstract LocationInfo getCurrentLocation();

    public abstract boolean initLbs(Context context);

    public abstract boolean isAutoStop();

    public abstract void notifyLocationUpdate();

    public abstract boolean recordLocation(boolean z, boolean z2);

    public abstract void resetLocation();

    public abstract void setAutoStop(boolean z);

    public abstract void uninit();
}
