package com.introvd.template.common.utils;

import com.introvd.template.common.model.Range;
import java.util.ArrayList;
import java.util.Iterator;

public class RangeUtils {
    public static Range getAdjacentRange(ArrayList<Range> arrayList, int i, boolean z) {
        Range range = null;
        if (arrayList != null && arrayList.size() > 0 && i >= 0 && i < arrayList.size()) {
            Range range2 = (Range) arrayList.get(i);
            if (z) {
                if (range2 != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Range range3 = (Range) it.next();
                        if (!(range3 == null || range3 == range2 || range3.getmPosition() > range2.getmPosition())) {
                            if (range == null || range3.getLimitValue() > range.getLimitValue()) {
                                range = range3;
                            }
                        }
                    }
                }
            } else if (range2 != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Range range4 = (Range) it2.next();
                    if (!(range4 == null || range4 == range2 || range4.getLimitValue() < range2.getLimitValue())) {
                        if (range == null || range4.getmPosition() < range.getmPosition()) {
                            range = range4;
                        }
                    }
                }
            }
        }
        return range;
    }

    public static int getAvailableLen(ArrayList<Range> arrayList, int i, int i2) {
        if (arrayList == null || getValueOfRange(i, arrayList) >= 0) {
            return 0;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Range nextRange = getNextRange(i, arrayList);
            if (nextRange != null) {
                return nextRange.getmPosition() - i;
            }
        }
        return i2 - i;
    }

    public static Range getInterSectedRange(Range range, Range range2) {
        if (range == null || range2 == null || range.getmTimeLength() <= 0 || range2.getmTimeLength() <= 0) {
            return null;
        }
        int i = range.getmPosition() <= range2.getmPosition() ? range.getmPosition() : range2.getmPosition();
        int limitValue = range.getLimitValue() > range2.getLimitValue() ? range.getLimitValue() : range2.getLimitValue();
        range.setmPosition(i);
        range.setmTimeLength(limitValue - i);
        return range;
    }

    public static Range getNextRange(int i, ArrayList<Range> arrayList) {
        Range range = null;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Range range2 = (Range) arrayList.get(i2);
                if (!range2.contains(i) && range2.getmPosition() > i && (range == null || range.getmPosition() > range2.getmPosition())) {
                    range = range2;
                }
            }
        }
        return range;
    }

    public static ArrayList<Range> getRangesWithoutIntersection(ArrayList<Range> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        ArrayList<Range> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Range range = new Range((Range) it.next());
            Iterator it2 = arrayList2.iterator();
            Range range2 = null;
            while (it2.hasNext()) {
                Range range3 = (Range) it2.next();
                if (isRangesIntersection(range3, range)) {
                    range2 = getInterSectedRange(range3, range);
                    if (range2 != null) {
                        break;
                    }
                }
            }
            if (range2 != null) {
                arrayList3.clear();
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    Range range4 = (Range) it3.next();
                    if (!(range4 == range2 || !isRangesIntersection(range4, range) || getInterSectedRange(range2, range4) == null)) {
                        arrayList3.add(range4);
                    }
                }
                arrayList2.removeAll(arrayList3);
            } else {
                arrayList2.add(range);
            }
        }
        return arrayList2;
    }

    public static int getValueOfRange(int i, ArrayList<Range> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Range range = (Range) arrayList.get(i2);
                if (range != null && range.contains(i)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public static boolean isRangesIntersection(Range range, Range range2) {
        boolean z = false;
        if (range == null || range2 == null || range.getmTimeLength() <= 0 || range2.getmTimeLength() <= 0) {
            return false;
        }
        int i = range.getmPosition();
        int i2 = range2.getmPosition();
        int limitValue = range2.getLimitValue();
        int limitValue2 = range.getLimitValue();
        boolean z2 = i > limitValue;
        boolean z3 = limitValue2 < i2;
        if (!z2 && !z3) {
            z = true;
        }
        return z;
    }
}
