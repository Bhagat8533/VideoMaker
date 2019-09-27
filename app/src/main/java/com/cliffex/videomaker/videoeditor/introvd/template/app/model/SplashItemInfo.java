package com.introvd.template.app.model;

import com.introvd.template.app.splash.C4360b;
import com.p131c.p132a.p135c.C2575a;
import java.util.Date;

public class SplashItemInfo {
    public static String TIME_FORMAT = "yyyyMMddHHmmss";
    public long lId;
    public String mEventCode = "";
    public String mEventParam = "";
    public String mExpireTime = "";
    public String mLang = "";
    public String mPublishTime = "";
    public String mStayTime = "";
    public String mTitle = "";
    public String mUrl = "";

    public Date getExpireTime() {
        return C4360b.m10952ee(this.mExpireTime);
    }

    public Date getPublishTime() {
        return C4360b.m10952ee(this.mPublishTime);
    }

    public int getStayTime() {
        return C2575a.parseInt(this.mStayTime) * 1000;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplashItemInfo{lId=");
        sb.append(this.lId);
        sb.append(", mLang='");
        sb.append(this.mLang);
        sb.append('\'');
        sb.append(", mTitle='");
        sb.append(this.mTitle);
        sb.append('\'');
        sb.append(", mUrl='");
        sb.append(this.mUrl);
        sb.append('\'');
        sb.append(", mExpireTime='");
        sb.append(this.mExpireTime);
        sb.append('\'');
        sb.append(", mPublishTime='");
        sb.append(this.mPublishTime);
        sb.append('\'');
        sb.append(", mStayTime='");
        sb.append(this.mStayTime);
        sb.append('\'');
        sb.append(", mEventCode='");
        sb.append(this.mEventCode);
        sb.append('\'');
        sb.append(", mEventParam='");
        sb.append(this.mEventParam);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
