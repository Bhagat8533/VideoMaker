package com.introvd.template.app.school.api.model;

import android.support.annotation.Keep;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p199v5.common.p200ui.videolist.C4436b;
import com.introvd.template.xyui.p420a.C9155c;
import java.util.List;
import p464d.p465a.C9633a;
import p464d.p466b.p467a.C9649c;

@Keep
public final class VideoInfo extends C9155c {
    private Number auid = Integer.valueOf(0);
    private Number ayid = Integer.valueOf(0);
    private String coverUrl = "";
    private String descrip = "";
    private String extend = "";
    private List<String> keywordList = C9633a.emptyList();
    private String logoUrl = "";
    private Number puid = Integer.valueOf(0);
    private Number studiograde = Integer.valueOf(0);
    private String title = "";
    private Number useCount = Integer.valueOf(0);
    private String userName = "";
    private Number ver = Integer.valueOf(0);
    private String videoUrl = "";
    private String webUrl = "";

    public final String formatUserName() {
        StringBuilder sb = new StringBuilder();
        sb.append(VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_creator_course_author));
        sb.append(this.userName);
        return sb.toString();
    }

    public final String formatWatchCount() {
        String string = VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_creator_course_play_count, new Object[]{C4436b.m11214M(VivaBaseApplication.m8749FZ(), this.useCount.intValue())});
        C9649c.m27671i(string, "VivaBaseApplication.getI…Ins(), useCount.toInt()))");
        return string;
    }

    public final Number getAuid() {
        return this.auid;
    }

    public final Number getAyid() {
        return this.ayid;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDescrip() {
        return this.descrip;
    }

    public final String getExtend() {
        return this.extend;
    }

    public final String getKeyword(int i) {
        return i >= this.keywordList.size() ? "" : (String) this.keywordList.get(i);
    }

    public final List<String> getKeywordList() {
        return this.keywordList;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final Number getPuid() {
        return this.puid;
    }

    public final Number getStudiograde() {
        return this.studiograde;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Number getUseCount() {
        return this.useCount;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final Number getVer() {
        return this.ver;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public final void setAuid(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.auid = number;
    }

    public final void setAyid(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.ayid = number;
    }

    public final void setCoverUrl(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void setDescrip(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.descrip = str;
    }

    public final void setExtend(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.extend = str;
    }

    public final void setKeywordList(List<String> list) {
        C9649c.m27672j(list, "<set-?>");
        this.keywordList = list;
    }

    public final void setLogoUrl(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.logoUrl = str;
    }

    public final void setPuid(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.puid = number;
    }

    public final void setStudiograde(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.studiograde = number;
    }

    public final void setTitle(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.title = str;
    }

    public final void setUseCount(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.useCount = number;
    }

    public final void setUserName(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.userName = str;
    }

    public final void setVer(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.ver = number;
    }

    public final void setVideoUrl(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.videoUrl = str;
    }

    public final void setWebUrl(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.webUrl = str;
    }
}
