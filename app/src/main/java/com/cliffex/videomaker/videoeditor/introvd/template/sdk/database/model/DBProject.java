package com.introvd.template.sdk.database.model;

import android.support.annotation.Keep;

@Keep
public class DBProject {
    public Long _id;
    public String activityData;
    public int cameraCode;
    public int clip_count;
    public String coverURL;
    public String create_time;
    public long duration;
    public int duration_limit;
    public int editCode;
    public long effectID;
    public String entrance;
    public String export_url;
    public String extras;
    public int is_deleted;
    public int is_modified;
    public String modify_time;
    public int streamHeight;
    public int streamWidth;
    public int theme_type;
    public String thumbnail;
    public String title;
    public int todoCode;
    public String url;
    public String version;
    public String video_desc;
    public String video_template_info;

    public DBProject() {
    }

    public DBProject(Long l, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, long j, int i2, int i3, int i4, int i5, int i6, String str8, int i7, int i8, int i9, long j2, int i10, String str9, String str10, String str11, String str12, String str13) {
        this._id = l;
        this.url = str;
        this.export_url = str2;
        this.thumbnail = str3;
        this.coverURL = str4;
        this.version = str5;
        this.create_time = str6;
        this.modify_time = str7;
        this.clip_count = i;
        this.duration = j;
        this.duration_limit = i2;
        this.streamWidth = i3;
        this.streamHeight = i4;
        this.is_deleted = i5;
        this.is_modified = i6;
        this.entrance = str8;
        this.todoCode = i7;
        this.editCode = i8;
        this.cameraCode = i9;
        this.effectID = j2;
        this.theme_type = i10;
        this.video_template_info = str9;
        this.title = str10;
        this.video_desc = str11;
        this.activityData = str12;
        this.extras = str13;
    }

    public String getActivityData() {
        return this.activityData;
    }

    public int getCameraCode() {
        return this.cameraCode;
    }

    public int getClip_count() {
        return this.clip_count;
    }

    public String getCoverURL() {
        return this.coverURL;
    }

    public String getCreate_time() {
        return this.create_time;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getDuration_limit() {
        return this.duration_limit;
    }

    public int getEditCode() {
        return this.editCode;
    }

    public long getEffectID() {
        return this.effectID;
    }

    public String getEntrance() {
        return this.entrance;
    }

    public String getExport_url() {
        return this.export_url;
    }

    public String getExtras() {
        return this.extras;
    }

    public int getIs_deleted() {
        return this.is_deleted;
    }

    public int getIs_modified() {
        return this.is_modified;
    }

    public String getModify_time() {
        return this.modify_time;
    }

    public int getStreamHeight() {
        return this.streamHeight;
    }

    public int getStreamWidth() {
        return this.streamWidth;
    }

    public int getTheme_type() {
        return this.theme_type;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTodoCode() {
        return this.todoCode;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public String getVideo_desc() {
        return this.video_desc;
    }

    public String getVideo_template_info() {
        return this.video_template_info;
    }

    public Long get_id() {
        return this._id;
    }

    public void setActivityData(String str) {
        this.activityData = str;
    }

    public void setCameraCode(int i) {
        this.cameraCode = i;
    }

    public void setClip_count(int i) {
        this.clip_count = i;
    }

    public void setCoverURL(String str) {
        this.coverURL = str;
    }

    public void setCreate_time(String str) {
        this.create_time = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setDuration_limit(int i) {
        this.duration_limit = i;
    }

    public void setEditCode(int i) {
        this.editCode = i;
    }

    public void setEffectID(long j) {
        this.effectID = j;
    }

    public void setEntrance(String str) {
        this.entrance = str;
    }

    public void setExport_url(String str) {
        this.export_url = str;
    }

    public void setExtras(String str) {
        this.extras = str;
    }

    public void setIs_deleted(int i) {
        this.is_deleted = i;
    }

    public void setIs_modified(int i) {
        this.is_modified = i;
    }

    public void setModify_time(String str) {
        this.modify_time = str;
    }

    public void setStreamHeight(int i) {
        this.streamHeight = i;
    }

    public void setStreamWidth(int i) {
        this.streamWidth = i;
    }

    public void setTheme_type(int i) {
        this.theme_type = i;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTodoCode(int i) {
        this.todoCode = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setVideo_desc(String str) {
        this.video_desc = str;
    }

    public void setVideo_template_info(String str) {
        this.video_template_info = str;
    }

    public void set_id(Long l) {
        this._id = l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DBProject{_id=");
        sb.append(this._id);
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", export_url='");
        sb.append(this.export_url);
        sb.append('\'');
        sb.append(", thumbnail='");
        sb.append(this.thumbnail);
        sb.append('\'');
        sb.append(", coverURL='");
        sb.append(this.coverURL);
        sb.append('\'');
        sb.append(", version='");
        sb.append(this.version);
        sb.append('\'');
        sb.append(", create_time='");
        sb.append(this.create_time);
        sb.append('\'');
        sb.append(", modify_time='");
        sb.append(this.modify_time);
        sb.append('\'');
        sb.append(", clip_count=");
        sb.append(this.clip_count);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", duration_limit=");
        sb.append(this.duration_limit);
        sb.append(", streamWidth=");
        sb.append(this.streamWidth);
        sb.append(", streamHeight=");
        sb.append(this.streamHeight);
        sb.append(", is_deleted=");
        sb.append(this.is_deleted);
        sb.append(", is_modified=");
        sb.append(this.is_modified);
        sb.append(", entrance='");
        sb.append(this.entrance);
        sb.append('\'');
        sb.append(", todoCode=");
        sb.append(this.todoCode);
        sb.append(", editCode=");
        sb.append(this.editCode);
        sb.append(", cameraCode=");
        sb.append(this.cameraCode);
        sb.append(", effectID=");
        sb.append(this.effectID);
        sb.append(", theme_type=");
        sb.append(this.theme_type);
        sb.append(", video_template_info='");
        sb.append(this.video_template_info);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.title);
        sb.append('\'');
        sb.append(", video_desc='");
        sb.append(this.video_desc);
        sb.append('\'');
        sb.append(", activityData='");
        sb.append(this.activityData);
        sb.append('\'');
        sb.append(", extras='");
        sb.append(this.extras);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
