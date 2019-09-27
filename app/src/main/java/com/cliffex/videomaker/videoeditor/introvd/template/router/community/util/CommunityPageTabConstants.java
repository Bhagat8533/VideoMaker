package com.introvd.template.router.community.util;

public class CommunityPageTabConstants {
    public static final String KEY_HOT_CATEGORY_SUB_ID = "hot_category_id";
    public static final String KEY_SAVED_TAB_ID;
    private static String KEY_SUB_TAB_LATEST_ID = "key_sub_tab_latest_id";
    public static final int TAB_ID_FIND = 3;
    public static final int TAB_ID_FOLLOW_VIDEO = 1;
    public static final int TAB_ID_HOT = 2;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_SUB_TAB_LATEST_ID);
        sb.append("_FindTab");
        KEY_SAVED_TAB_ID = sb.toString();
    }
}
