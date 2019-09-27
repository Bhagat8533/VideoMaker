package com.introvd.template.app.api.model;

import android.support.annotation.Keep;
import com.google.gson.JsonObject;
import java.util.List;

@Keep
public class FeatureRequestResult {
    public List<FeatureItem> list;
    public int total;

    @Keep
    public static class FeatureItem {

        /* renamed from: id */
        public int f3373id;
        public JsonObject obj;
        public int orderno;
        public String parentmodelcode;
        public String title;
        public int type;
        public int viewtype;
    }
}
