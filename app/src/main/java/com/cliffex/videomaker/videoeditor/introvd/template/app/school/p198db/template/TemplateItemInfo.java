package com.introvd.template.app.school.p198db.template;

import android.support.annotation.Keep;
import com.vivavideo.p428a.p429a.C9275b;

@Keep
@C9275b(aPw = "Template_Item_Info")
/* renamed from: com.introvd.template.app.school.db.template.TemplateItemInfo */
public class TemplateItemInfo {
    public String auiddigest;
    public String channel;
    public String commodityInfo;
    public String country;
    public String coverUrl;
    public String description;
    public int eventCode;
    public String eventContent;
    public int flag;
    public int height;

    /* renamed from: id */
    public long f3391id;
    private long indexid;
    public boolean isVip;
    public long labelId;
    public int platform;
    public int state;
    public String templateUrl;
    public String title;
    public String ttid;
    public long useCount;
    public String userInfo;
    public long ver;
    public String videoUrl;
    public int width;

    public TemplateItemInfo() {
    }

    public TemplateItemInfo(long j, long j2, long j3, String str, long j4, long j5, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6, int i4, String str7, String str8, boolean z, String str9, int i5, String str10, int i6, String str11, String str12) {
        this.labelId = j;
        this.indexid = j2;
        this.f3391id = j3;
        this.ttid = str;
        this.ver = j4;
        this.useCount = j5;
        this.title = str2;
        this.description = str3;
        this.coverUrl = str4;
        this.videoUrl = str5;
        this.width = i;
        this.height = i2;
        this.state = i3;
        this.templateUrl = str6;
        this.eventCode = i4;
        this.eventContent = str7;
        this.auiddigest = str8;
        this.isVip = z;
        this.country = str9;
        this.platform = i5;
        this.channel = str10;
        this.flag = i6;
        this.commodityInfo = str11;
        this.userInfo = str12;
    }

    public String getAuiddigest() {
        return this.auiddigest;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCommodityInfo() {
        return this.commodityInfo;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public String getEventContent() {
        return this.eventContent;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getHeight() {
        return this.height;
    }

    public long getId() {
        return this.f3391id;
    }

    public long getIndexid() {
        return this.indexid;
    }

    public boolean getIsVip() {
        return this.isVip;
    }

    public long getLabelId() {
        return this.labelId;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getState() {
        return this.state;
    }

    public String getTemplateUrl() {
        return this.templateUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTtid() {
        return this.ttid;
    }

    public long getUseCount() {
        return this.useCount;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public long getVer() {
        return this.ver;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public void setAuiddigest(String str) {
        this.auiddigest = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCommodityInfo(String str) {
        this.commodityInfo = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEventCode(int i) {
        this.eventCode = i;
    }

    public void setEventContent(String str) {
        this.eventContent = str;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setId(long j) {
        this.f3391id = j;
    }

    public void setIndexid(long j) {
        this.indexid = j;
    }

    public void setIsVip(boolean z) {
        this.isVip = z;
    }

    public void setLabelId(long j) {
        this.labelId = j;
    }

    public void setPlatform(int i) {
        this.platform = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setTemplateUrl(String str) {
        this.templateUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTtid(String str) {
        this.ttid = str;
    }

    public void setUseCount(long j) {
        this.useCount = j;
    }

    public void setUserInfo(String str) {
        this.userInfo = str;
    }

    public void setVer(long j) {
        this.ver = j;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
