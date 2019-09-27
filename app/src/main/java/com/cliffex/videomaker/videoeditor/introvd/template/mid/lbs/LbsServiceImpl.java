package com.introvd.template.mid.lbs;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.lbs.ILbsService;
import com.introvd.template.router.lbs.LocationInfo;
import com.introvd.template.router.lbs.PlaceListener;

@C1942a(mo10417rZ = "/lbs/service")
public class LbsServiceImpl implements ILbsService {
    public LocationInfo getCurrentLocation() {
        LogUtilsV2.m14227d("LBSLBSLBS->getCurrentLocation");
        return C7567a.azU().getCurrentLocation();
    }

    public void init(Context context) {
    }

    public void init(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("LBSLBSLBS->init isChina = ");
        sb.append(z);
        LogUtilsV2.m14227d(sb.toString());
        C7567a.azU().mo32458Q(context, z);
    }

    public void queryPlace(Context context, String str, int i, int i2, PlaceListener placeListener) {
        LogUtilsV2.m14227d("LBSLBSLBS->queryPlace");
        C7568b.azV().mo32465a(context, str, i, i2, placeListener);
    }

    public boolean recordLocation(boolean z, boolean z2) {
        LogUtilsV2.m14227d("LBSLBSLBS->recordLocation");
        return C7567a.azU().recordLocation(z, z2);
    }

    public void resetLocation() {
        LogUtilsV2.m14227d("LBSLBSLBS->resetLocation");
        C7567a.azU().resetLocation();
    }

    public void setAutoStop(boolean z) {
        LogUtilsV2.m14227d("LBSLBSLBS->setAutoStop");
        C7567a.azU().setAutoStop(z);
    }

    public void unInit() {
        LogUtilsV2.m14227d("LBSLBSLBS->unInit");
        C7567a.azU().uninit();
    }

    public void updateLocationCache() {
        LogUtilsV2.m14227d("LBSLBSLBS->updateLocationCache");
        C7567a.azU().updateLocationCache();
    }
}
