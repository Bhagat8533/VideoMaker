package com.introvd.template.module.p326ad.p331e;

import android.os.Bundle;
import android.util.DisplayMetrics;
import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.entity.AdPlacementInfo;
import com.introvd.template.module.p326ad.p334h.C7661b;

/* renamed from: com.introvd.template.module.ad.e.k */
public class C7618k implements PlacementIdProvider {
    private Bundle dNh = new Bundle();

    public AdPlacementInfo getPlacementInfo(int i, int i2) {
        String str = "";
        if (i == 43) {
            str = C7609b.m22414kl("XYINT_EXPORT_PROCESSING");
            DisplayMetrics aAz = C7661b.aAz();
            if (aAz != null) {
                int i3 = aAz.widthPixels;
                int i4 = (int) (((double) i3) * 0.5625d);
                this.dNh.putInt("width", i3);
                this.dNh.putInt("height", i4);
            }
        }
        return new AdPlacementInfo(str, this.dNh);
    }
}
