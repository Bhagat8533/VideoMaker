package com.introvd.template.ads;

import android.text.TextUtils;
import android.util.SparseArray;
import com.introvd.template.ads.entity.AdServerParam;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class AdParamMgr {
    private static final SparseArray<AdServerParam> bgy = new SparseArray<>();

    public interface DataAdapter<T> {
        AdServerParam onDataConvert(T t);
    }

    /* renamed from: gc */
    private static AdServerParam m8818gc(int i) {
        return (AdServerParam) bgy.get(i);
    }

    public static int getAdType(int i) {
        AdServerParam gc = m8818gc(i);
        if (gc != null) {
            return gc.adType;
        }
        return -1;
    }

    public static <T> T getExtraInfoByKey(int i, String str) {
        T t;
        AdServerParam gc = m8818gc(i);
        if (gc == null || TextUtils.isEmpty(gc.extraJson)) {
            return null;
        }
        try {
            t = new JSONObject(gc.extraJson).opt(str);
        } catch (JSONException e) {
            e.printStackTrace();
            t = null;
        }
        return t;
    }

    public static int getLoadStrategy(int i) {
        AdServerParam gc = m8818gc(i);
        if (gc != null) {
            return gc.strategy;
        }
        return 0;
    }

    public static int getPositionInGroup(int i) {
        AdServerParam gc = m8818gc(i);
        if (gc != null) {
            return gc.adPositionInGroup;
        }
        return 0;
    }

    public static List<Integer> getProviderList(int i) {
        AdServerParam gc = m8818gc(i);
        return gc != null ? gc.getProviderList() : new ArrayList();
    }

    public static long getWaitTime(int i) {
        AdServerParam gc = m8818gc(i);
        if (gc != null) {
            return gc.waitTime;
        }
        return 0;
    }

    public static boolean isAdConfigValid(int i) {
        return m8818gc(i) != null;
    }

    public static <T> void updateConfig(List<T> list, DataAdapter<T> dataAdapter) {
        if (list != null) {
            for (T onDataConvert : list) {
                AdServerParam onDataConvert2 = dataAdapter.onDataConvert(onDataConvert);
                if (onDataConvert2 != null) {
                    bgy.put(onDataConvert2.position, onDataConvert2);
                }
            }
        }
    }
}
