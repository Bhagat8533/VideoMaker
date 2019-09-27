package com.introvd.template.mid.lbs;

import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.lbs.PlaceListener;

public abstract class AbsPlaceService implements C1949c {
    public abstract void query(Context context, String str, String str2, int i, int i2, PlaceListener placeListener);

    public abstract void unInit();
}
