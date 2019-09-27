package com.introvd.template.sns;

import android.net.Uri;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.LogUtilsV2;

public class WeiXinProgramShareUtils {
    public static final int SHARE_TYPE_ACTIVITY = 3;
    public static final int SHARE_TYPE_PROFILE = 2;
    public static final int SHARE_TYPE_VIDEO = 1;

    private static String createProgramPath(int i, SnsShareInfo snsShareInfo) {
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("/pages/videoDetail/videoDetail?videoId=");
            sb.append(snsShareInfo.strPuid);
            sb.append("&ver=");
            sb.append(snsShareInfo.strPver);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("pages/xyPlusIndex/xyPlusIndex?actualPath=");
            sb3.append(Uri.encode(sb2));
            return sb3.toString();
        } else if (i == 2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("pages/mine/mine?uId=");
            sb4.append(snsShareInfo.strAuid);
            return sb4.toString();
        } else if (i != 3) {
            return "";
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pages/activityDetail/activityDetail?activityId=");
            sb5.append(snsShareInfo.strActivityID);
            return sb5.toString();
        }
    }

    static String getShareToWXProPageUrl(int i, int i2, SnsShareInfo snsShareInfo) {
        String str = null;
        if (i != 7) {
            return null;
        }
        if ((i2 == 1 && C3742b.m9111II().mo23131IY()) || ((i2 == 2 && C3742b.m9111II().mo23132IZ()) || (i2 == 3 && C3742b.m9111II().mo23154Ja()))) {
            str = createProgramPath(i2, snsShareInfo);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("share to WeiXin Program : ");
        sb.append(str);
        LogUtilsV2.m14227d(sb.toString());
        return str;
    }
}
