package com.introvd.template.app.school.testa;

import android.support.annotation.Keep;
import com.introvd.template.xyui.p420a.C9155c;

@Keep
public class BottomRecyclerDataModel extends C9155c {
    public static final int TYPE_COURSE = 2;
    public static final int TYPE_GAP = 3;
    public static final int TYPE_TEMPLATE = 1;
    public Object data;
    public long labelID;
    public int labelIndexInList;
    public String labelName;
    public String title;
    public int type = 1;
}
