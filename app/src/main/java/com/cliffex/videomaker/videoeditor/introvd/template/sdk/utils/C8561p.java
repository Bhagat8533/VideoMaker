package com.introvd.template.sdk.utils;

import com.introvd.template.sdk.model.VeRange;
import xiaoying.engine.base.QRange;

/* renamed from: com.introvd.template.sdk.utils.p */
public class C8561p {
    /* renamed from: d */
    public static VeRange m25041d(QRange qRange) {
        if (qRange != null) {
            return new VeRange(qRange.get(0), qRange.get(1));
        }
        return null;
    }
}
