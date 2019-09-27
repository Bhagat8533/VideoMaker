package com.introvd.template.datacenter;

import android.content.Context;
import android.content.Intent;
import android.support.p021v4.content.LocalBroadcastManager;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.introvd.template.C4677g;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.p374q.C8358i;
import com.xiaoying.p448a.C9567f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SocialExceptionHandler {
    public static final int ACCOUNT_ERROR_ACCOUNT_NOT_EXIST = 102;
    public static final int ACCOUNT_ERROR_FREEZED_ACCOUNT = 105;
    public static final int ACCOUNT_ERROR_INACTIVE_ACCOUNT = 104;
    public static final int ACCOUNT_ERROR_INVALID_3RD_TOKEN = 110;
    public static final int ACCOUNT_ERROR_INVALID_ACCOUNT = 107;
    public static final int ACCOUNT_ERROR_INVALID_AUID = 101;
    public static final int ACCOUNT_ERROR_NICKNAME_EXIST = 113;
    public static final int ACCOUNT_ERROR_NICKNAME_RESERVED = 114;
    public static final int ACCOUNT_ERROR_WRONG_ACCOUNT_OR_PWD = 103;
    public static final int BUSINESS_ERROR_INVALID_BIDORPWD = 115;
    public static final int BUSINESS_ERROR_INVALID_PARAM = 116;
    public static final int COMMON_ERROR_ACCESS_DENIED = 24;
    public static final int COMMON_ERROR_APPKEY = 6;
    public static final int COMMON_ERROR_APPSECRET = 7;
    public static final int COMMON_ERROR_BAD_REQUEST = 22;
    public static final int COMMON_ERROR_EXCEED_REQUEST = 23;
    public static final int COMMON_ERROR_INVALID_PARAM = 20;
    public static final int COMMON_ERROR_INVALID_TOKEN = 50;
    public static final int COMMON_ERROR_INVALID_UPLOADTOKEN = 60;
    public static final int COMMON_ERROR_NO_PERMISSION = 4;
    public static final int COMMON_ERROR_REPEAT_REQUEST = 25;
    public static final int COMMON_ERROR_SERVICE_BUSY = 13;
    public static final int COMMON_ERROR_SERVICE_INTERNALFAIL = 10;
    public static final int COMMON_ERROR_SERVICE_NOT_IMPLEMENT = 11;
    public static final int COMMON_ERROR_SERVICE_UNAVAILABLE = 12;
    public static final int COMMON_ERROR_SIGNATURE = 21;
    public static final int COMMON_ERROR_UNAUTHORIZED = 5;
    public static final int COMMON_ERROR_UNSUPPORT_API = 3;
    public static final int COMMON_ERROR_UPLOAD_SERVICE = 14;
    public static final int COMMON_ERROR_USER_UNAUTHORIZED = 52;
    public static final int CONTENT_ERROR_ACCOUNT_COMMENT_FORBIDDEN = 871;
    public static final int CONTENT_ERROR_DEVICE_COMMENT_FORBIDDEN = 872;
    public static final int CONTENT_ERROR_HAS_SENSITIVE_WORDS = 870;
    public static final int CONTENT_ERROR_IN_BLACK_LIST = 873;
    public static final String KEY_SERVICE_ERROR_CODE = "ServiceErrorCode";
    public static final int PUBLISH_ERROR_ACTIVITY_VIDEO_EXIST = 308;
    public static final int PUBLISH_ERROR_VIDEO_LIST_EXIST = 307;
    public static final int PUBLISH_ERROR_VIDEO_VERIFY_FAIL = 314;
    public static final int USER_ERROR_DEVICE_FREEZED = 203;
    public static final int USER_ERROR_DEVICE_INFO_CHANGED = 201;
    public static final int USER_ERROR_DEVICE_INVALID_DUID = 202;
    private static Map<String, ServerAvailableAccessItem> mServerAvailableAccessItem = Collections.synchronizedMap(new LinkedHashMap());
    private static final ServerAvailableAccessItem s_AvailableAccessItem = new ServerAvailableAccessItem();

    public static class ServerAvailableAccessItem {
        public long lAvailableTime = 0;
        public int nErrCode = 0;
    }

    static final ServerAvailableAccessItem getServerAccessAvailable(Context context, String str, String str2) {
        ServerAvailableAccessItem serverAvailableAccessItem = (ServerAvailableAccessItem) mServerAvailableAccessItem.get("url_blockall");
        if (!isServerAccessAvailable(serverAvailableAccessItem)) {
            return serverAvailableAccessItem;
        }
        String urlKey = SocialService.getUrlKey(str, str2);
        ServerAvailableAccessItem serverAvailableAccessItem2 = (ServerAvailableAccessItem) mServerAvailableAccessItem.get(urlKey);
        if (!isServerAccessAvailable(serverAvailableAccessItem2)) {
            return serverAvailableAccessItem2;
        }
        if ("s".equals(urlKey)) {
            return s_AvailableAccessItem;
        }
        ServerAvailableAccessItem serverAvailableAccessItem3 = (ServerAvailableAccessItem) mServerAvailableAccessItem.get("d");
        if (!isServerAccessAvailable(serverAvailableAccessItem3)) {
            return serverAvailableAccessItem3;
        }
        if (TtmlNode.TAG_P.equals(urlKey) || "v".equals(urlKey) || C4677g.TAG.equals(urlKey) || "h".equals(urlKey) || Event.SEARCH.equals(urlKey) || "u".equals(urlKey)) {
            ServerAvailableAccessItem serverAvailableAccessItem4 = (ServerAvailableAccessItem) mServerAvailableAccessItem.get(C5878a.TAG);
            if (!isServerAccessAvailable(serverAvailableAccessItem4)) {
                return serverAvailableAccessItem4;
            }
        }
        return s_AvailableAccessItem;
    }

    public static boolean handleErrCode(Context context, String str, String str2, int i, Object obj) {
        if (i == 50) {
            SocialService.syncDeviceLogout(context);
            TempUserProxy.clearExpireTime();
            SocialService.syncDeviceLogout(context);
            C8358i.m24110gW(context);
            C8358i.m24109gV(context);
            if (context == null) {
                return true;
            }
            LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent("ACTION_token_invalid"));
            return true;
        } else if (i == 52 || i == 60 || i == 110) {
            return true;
        } else {
            switch (i) {
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    return true;
                default:
                    switch (i) {
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            return true;
                        default:
                            switch (i) {
                                case 20:
                                case 21:
                                case 22:
                                case 25:
                                    break;
                                case 23:
                                case 24:
                                    return true;
                                default:
                                    switch (i) {
                                        case 101:
                                            TempUserProxy.clearUserInfo();
                                            return true;
                                        case 102:
                                        case 103:
                                        case 104:
                                        case 105:
                                            return true;
                                        default:
                                            switch (i) {
                                                case 115:
                                                case 116:
                                                    return true;
                                                default:
                                                    switch (i) {
                                                        case 201:
                                                        case 202:
                                                            SocialService.syncDeviceLogout(context);
                                                            SocialService.syncDeviceUnregister(context);
                                                            return true;
                                                        case 203:
                                                            return true;
                                                        default:
                                                            if (!(i == 10002 || i == 10003 || i < 900)) {
                                                                return true;
                                                            }
                                                    }
                                            }
                                    }
                            }
                            return false;
                    }
            }
        }
    }

    public static int handleException(Context context, C9567f fVar) {
        int i = 65536;
        if (fVar == null) {
            return 65536;
        }
        if (fVar.eRF == 0) {
            i = 131072;
        } else if (fVar.eRF != 1) {
            i = 0;
        }
        return i;
    }

    static boolean isServerAccessAvailable(ServerAvailableAccessItem serverAvailableAccessItem) {
        boolean z = true;
        if (serverAvailableAccessItem == null || serverAvailableAccessItem.nErrCode == 0 || serverAvailableAccessItem.lAvailableTime == 0) {
            return true;
        }
        if (System.currentTimeMillis() <= serverAvailableAccessItem.lAvailableTime) {
            z = false;
        }
        return z;
    }

    public static void setServerAccessAvailable(Context context, String str, String str2, int i, long j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SocialService.getUrlKey(str, str2));
        if (i == 52 || i == 105) {
            if (!arrayList.contains("v")) {
                arrayList.add(0, "v");
            }
            if (!arrayList.contains(C5878a.TAG)) {
                arrayList.add(0, C5878a.TAG);
            }
        } else if (i != 203) {
            switch (i) {
                case 115:
                case 116:
                    if (!arrayList.contains("url_blockall")) {
                        arrayList.add(0, "url_blockall");
                        break;
                    }
                    break;
            }
        } else if (!arrayList.contains("d")) {
            arrayList.add(0, "d");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            ServerAvailableAccessItem serverAvailableAccessItem = (ServerAvailableAccessItem) mServerAvailableAccessItem.get(str3);
            if (serverAvailableAccessItem == null) {
                serverAvailableAccessItem = new ServerAvailableAccessItem();
                mServerAvailableAccessItem.put(str3, serverAvailableAccessItem);
            }
            serverAvailableAccessItem.nErrCode = i;
            long j2 = 0;
            if (j != 0) {
                j2 = System.currentTimeMillis() + j;
            }
            serverAvailableAccessItem.lAvailableTime = j2;
            String str4 = SocialServiceDef.SOCIAL_SERVICE_NAME;
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(" API is avaliable after ");
            sb.append(j / 1000);
            sb.append("s");
            LogUtils.m14222e(str4, sb.toString());
        }
    }
}
