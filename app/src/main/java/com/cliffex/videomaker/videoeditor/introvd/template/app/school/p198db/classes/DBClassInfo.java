package com.introvd.template.app.school.p198db.classes;

import android.support.annotation.Keep;
import com.vivavideo.p428a.p429a.C9275b;

@Keep
@C9275b(aPw = "class_info")
/* renamed from: com.introvd.template.app.school.db.classes.DBClassInfo */
public class DBClassInfo {
    public long auid;
    public int ayid;
    public String coverUrl;
    public String desc;
    public String description;
    public String extend;

    /* renamed from: id */
    private Long f3390id;
    public String keywordsJson;
    public long labelId;
    public String logoUrl;
    public long puid;
    public int studioGrade;
    public String title;
    public int useCount;
    public String userName;
    public int ver;
    public String videoUrl;
    public String webUrl;

    public DBClassInfo() {
    }

    public DBClassInfo(Long l, long j, long j2, int i, long j3, String str, String str2, int i2, int i3, String str3, String str4, String str5, int i4, String str6, String str7, String str8, String str9, String str10) {
        this.f3390id = l;
        this.labelId = j;
        this.puid = j2;
        this.ver = i;
        this.auid = j3;
        this.extend = str;
        this.desc = str2;
        this.ayid = i2;
        this.useCount = i3;
        this.title = str3;
        this.description = str4;
        this.userName = str5;
        this.studioGrade = i4;
        this.coverUrl = str6;
        this.videoUrl = str7;
        this.logoUrl = str8;
        this.keywordsJson = str9;
        this.webUrl = str10;
    }

    public long getAuid() {
        return this.auid;
    }

    public int getAyid() {
        return this.ayid;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDescription() {
        return this.description;
    }

    public String getExtend() {
        return this.extend;
    }

    public Long getId() {
        return this.f3390id;
    }

    public String getKeywordsJson() {
        return this.keywordsJson;
    }

    public long getLabelId() {
        return this.labelId;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public long getPuid() {
        return this.puid;
    }

    public int getStudioGrade() {
        return this.studioGrade;
    }

    public String getTitle() {
        return this.title;
    }

    public int getUseCount() {
        return this.useCount;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getVer() {
        return this.ver;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setAuid(int i) {
        this.auid = (long) i;
    }

    public void setAuid(long j) {
        this.auid = j;
    }

    public void setAyid(int i) {
        this.ayid = i;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setId(Long l) {
        this.f3390id = l;
    }

    public void setKeywordsJson(String str) {
        this.keywordsJson = str;
    }

    public void setLabelId(long j) {
        this.labelId = j;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public void setPuid(int i) {
        this.puid = (long) i;
    }

    public void setPuid(long j) {
        this.puid = j;
    }

    public void setStudioGrade(int i) {
        this.studioGrade = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUseCount(int i) {
        this.useCount = i;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setVer(int i) {
        this.ver = i;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }
}
