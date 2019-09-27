package com.introvd.template.sdk.model.template;

import java.util.ArrayList;
import java.util.List;

public class RollIconInfo implements Cloneable {
    public String mBigIconUrl;
    public String mIconUrl;
    public List<RollXytInfo> mXytList;

    public static ArrayList<RollXytInfo> cloneList(List<RollXytInfo> list) throws CloneNotSupportedException {
        ArrayList<RollXytInfo> arrayList = new ArrayList<>(list.size());
        for (RollXytInfo clone : list) {
            arrayList.add((RollXytInfo) clone.clone());
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            RollIconInfo rollIconInfo = (RollIconInfo) super.clone();
            try {
                rollIconInfo.mXytList = cloneList(rollIconInfo.mXytList);
                return rollIconInfo;
            } catch (CloneNotSupportedException unused) {
                return rollIconInfo;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }
}
