package com.introvd.template.sdk.model;

import java.util.Comparator;

public class ComparatorBaseObject implements Comparator<BaseObject> {
    public int compare(BaseObject baseObject, BaseObject baseObject2) {
        if (baseObject == null) {
            return baseObject2 != null ? -1 : 0;
        }
        if (baseObject2 == null || baseObject.mOrderNum > baseObject2.mOrderNum) {
            return 1;
        }
        return baseObject.mOrderNum < baseObject2.mOrderNum ? -1 : 0;
    }
}
