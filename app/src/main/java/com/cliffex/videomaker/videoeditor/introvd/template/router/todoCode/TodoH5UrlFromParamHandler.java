package com.introvd.template.router.todoCode;

import android.net.Uri;
import android.text.TextUtils;

public class TodoH5UrlFromParamHandler {
    public static final String FROM_APP_POPUP = "appPopup_";
    public static final String FROM_EXPLORE_BANNER = "exploreBanner_";
    public static final String FROM_EXPORT_RESULT_BANNER = "exportBanner_";
    public static final String FROM_MESSAGE = "message_";
    public static final String FROM_OTHER_BANNER = "otherBanner_";
    public static final String FROM_PUSH = "push_";
    public static final String FROM_TEMPLATE_BANNER = "templateBanner_";
    public static final String FROM_TYPE_ACT_BANNER = "actBanner_";
    public static final String FROM_TYPE_CREATION_BANNER = "createBanner_";
    public static final String FROM_TYPE_CREATION_FUN = "createFun_";
    public static final String FROM_TYPE_HOT_VIDEO_OP = "hotOp_";

    public static void addFromParam(TODOParamModel tODOParamModel, String str, String str2) {
        tODOParamModel.setTodoParam("fromTitle", creatFromTitle(str, str2));
    }

    public static String addFromParamToUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.contains("?")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("&fromTitle=");
            sb.append(Uri.encode(str2));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("?fromTitle=");
        sb2.append(Uri.encode(str2));
        return sb2.toString();
    }

    public static String creatFromTitle(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String getFromParam(TODOParamModel tODOParamModel) {
        return tODOParamModel.getTodoParamValue("fromTitle");
    }
}
