package com.introvd.template.p242d;

import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.ironsource.sdk.constants.Constants.ParametersKeys;

/* renamed from: com.introvd.template.d.a */
public class C5527a {
    public static String cnA = "key_file_path";
    public static String cnB = "key_seek_position";
    public static String cnC = "key_video_title";
    public static String cnD = "key_video_description";
    public static String cnE = "key_video_puid";
    public static String cnF = "key_video_pver";
    public static String cnG = "key_video_cover_url";
    public static String cnH = "key_video_page_url";
    public static String cnI = "key_intent_type";
    public static String cnJ = "key_register_first";
    public static String cnK = "key_intent_data";
    public static String cnL = "xiaoying";
    public static String cnM = "path";
    public static String cnN = "creation";
    public static String cnO = "video";
    public static String cnP = "user";
    public static String cnQ = "key_home_layout_latest_tab_id";

    /* renamed from: kj */
    public static String m14968kj(int i) {
        if (i == 2) {
            return "activity";
        }
        if (i == 1) {
            return "hot";
        }
        if (i == 4) {
            return "my videos";
        }
        if (i == 5) {
            return "follow";
        }
        if (i == 6) {
            return "new list";
        }
        if (i == 7) {
            return "message";
        }
        if (i == 3) {
            return "other's videos";
        }
        if (i == 13) {
            return "my like videos";
        }
        if (i == 12) {
            return "other's like videos";
        }
        if (i == 15) {
            return Event.SEARCH;
        }
        if (i == 16) {
            return "search user";
        }
        if (i == 44) {
            return "search whole";
        }
        if (i == 20) {
            return "nearby";
        }
        if (i == 0) {
            return "video detail";
        }
        if (i == 21 || i == 11) {
            return "recommend user";
        }
        if (i == 23) {
            return "creation";
        }
        if (i == 25) {
            return "video explorer";
        }
        if (i == 22) {
            return "explore";
        }
        if (i == 26) {
            return "liveshow";
        }
        if (i == 8) {
            return "fans list";
        }
        if (i == 9) {
            return "follow list";
        }
        if (i == 28) {
            return "follow request";
        }
        if (i == 29) {
            return ParametersKeys.WEB_VIEW;
        }
        if (i == 30) {
            return "top user";
        }
        if (i == 31) {
            return "explore recommend user";
        }
        if (i == 33) {
            return "hot category";
        }
        if (i == 34) {
            return "message friends";
        }
        if (i == 35) {
            return "follow recommend user";
        }
        if (i == 38) {
            return "my hot videos";
        }
        if (i == 39) {
            return "others hot videos";
        }
        if (i == 40) {
            return "video detail recommend videos";
        }
        if (i == 37) {
            return "video player";
        }
        if (i == 42) {
            return "related videos";
        }
        if (i == 41) {
            return "feed video";
        }
        if (i == 43) {
            return "big card videos";
        }
        if (i == 45) {
            return "search recommend user";
        }
        if (i == 46) {
            return "follow recommend videos";
        }
        if (i == 47) {
            return "ExportResultPage";
        }
        if (i == 27) {
            return "TodoCode";
        }
        if (m14969kk(i) != null) {
            return m14969kk(i);
        }
        if (m14970kl(i) != null) {
            return m14970kl(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("other : ");
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: kk */
    private static String m14969kk(int i) {
        if (i == 49) {
            return "首页模版";
        }
        if (i == 51) {
            return "拍同款";
        }
        if (i == 50) {
            return "模版集合页";
        }
        return null;
    }

    /* renamed from: kl */
    private static String m14970kl(int i) {
        if (i == 52) {
            return "首页教程";
        }
        if (i == 53) {
            return "教程集合页";
        }
        return null;
    }
}
