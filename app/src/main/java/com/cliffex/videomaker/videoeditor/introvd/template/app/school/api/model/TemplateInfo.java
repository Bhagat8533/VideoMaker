package com.introvd.template.app.school.api.model;

import android.content.res.Resources;
import android.support.annotation.Keep;
import android.text.TextPaint;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p199v5.common.p200ui.videolist.C4436b;
import com.introvd.template.p203b.C4583d;
import p464d.C9646b;
import p464d.p466b.p467a.C9649c;

@Keep
public final class TemplateInfo {
    private String auiddigest = "";
    private String channel = "";
    private CommodityInfo commodityInfo = new CommodityInfo();
    private String country = "";
    private String coverUrl = "";
    private String description = "";
    private int eventCode = -1;
    private String eventContent = "";
    private Number flag = Integer.valueOf(0);
    private int height;

    /* renamed from: id */
    private Number f3388id = Integer.valueOf(0);
    private boolean isVip;
    private Number platform = Integer.valueOf(0);
    private Number state = Integer.valueOf(0);
    private String templateUrl = "";
    private String title = "";
    private String ttid = "";
    private Number useCount = Integer.valueOf(0);
    private UserInfo userInfo = new UserInfo();
    private Number ver = Integer.valueOf(0);
    private String videoUrl = "";
    private int width;

    public final String formatDesc() {
        TextPaint textPaint = new TextPaint();
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        C9649c.m27671i(FZ, "VivaBaseApplication.getIns()");
        Resources resources = FZ.getResources();
        C9649c.m27671i(resources, "VivaBaseApplication.getIns().resources");
        textPaint.setTextSize((resources.getDisplayMetrics().density * ((float) 13)) + 0.5f);
        int breakText = textPaint.breakText(this.description, true, ((float) C4583d.m11673ii(200)) * 1.0f, null);
        if (breakText > this.description.length()) {
            breakText = this.description.length();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        String str = this.description;
        if (str != null) {
            String substring = str.substring(0, breakText);
            C9649c.m27671i(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(" ”");
            return sb.toString();
        }
        throw new C9646b("null cannot be cast to non-null type java.lang.String");
    }

    public final String formatUseCount() {
        String string = VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_count_of_people_used, new Object[]{C4436b.m11214M(VivaBaseApplication.m8749FZ(), this.useCount.intValue())});
        C9649c.m27671i(string, "VivaBaseApplication.getI…eCount.toInt())\n        )");
        return string;
    }

    public final String getAuiddigest() {
        return this.auiddigest;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final CommodityInfo getCommodityInfo() {
        return this.commodityInfo;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getEventCode() {
        return this.eventCode;
    }

    public final String getEventContent() {
        return this.eventContent;
    }

    public final Number getFlag() {
        return this.flag;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Number getId() {
        return this.f3388id;
    }

    public final Number getPlatform() {
        return this.platform;
    }

    public final Number getState() {
        return this.state;
    }

    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTtid() {
        return this.ttid;
    }

    public final Number getUseCount() {
        return this.useCount;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final Number getVer() {
        return this.ver;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setAuiddigest(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.auiddigest = str;
    }

    public final void setChannel(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.channel = str;
    }

    public final void setCommodityInfo(CommodityInfo commodityInfo2) {
        C9649c.m27672j(commodityInfo2, "<set-?>");
        this.commodityInfo = commodityInfo2;
    }

    public final void setCountry(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.country = str;
    }

    public final void setCoverUrl(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void setDescription(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.description = str;
    }

    public final void setEventCode(int i) {
        this.eventCode = i;
    }

    public final void setEventContent(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.eventContent = str;
    }

    public final void setFlag(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.flag = number;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setId(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.f3388id = number;
    }

    public final void setPlatform(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.platform = number;
    }

    public final void setState(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.state = number;
    }

    public final void setTemplateUrl(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.templateUrl = str;
    }

    public final void setTitle(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.title = str;
    }

    public final void setTtid(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.ttid = str;
    }

    public final void setUseCount(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.useCount = number;
    }

    public final void setUserInfo(UserInfo userInfo2) {
        C9649c.m27672j(userInfo2, "<set-?>");
        this.userInfo = userInfo2;
    }

    public final void setVer(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.ver = number;
    }

    public final void setVideoUrl(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.videoUrl = str;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    public final void setWidth(int i) {
        this.width = i;
    }
}
