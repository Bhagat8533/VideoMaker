package com.introvd.template.router.lbs;

import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;

public interface ILbsService extends C1949c {
    LocationInfo getCurrentLocation();

    void init(Context context, boolean z);

    void queryPlace(Context context, String str, int i, int i2, PlaceListener placeListener);

    boolean recordLocation(boolean z, boolean z2);

    void resetLocation();

    void setAutoStop(boolean z);

    void unInit();

    void updateLocationCache();
}
