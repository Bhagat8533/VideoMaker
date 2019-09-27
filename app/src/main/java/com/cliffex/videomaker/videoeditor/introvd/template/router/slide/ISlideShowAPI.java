package com.introvd.template.router.slide;

import com.aiii.android.arouter.facade.template.C1949c;
import com.google.gson.JsonArray;
import p037b.p050b.C1848s;

public interface ISlideShowAPI extends C1949c {
    public static final String URL = "/CommSlide/ISlideShowAPI";

    C1848s<JsonArray> getSlideVideoList(boolean z);
}
