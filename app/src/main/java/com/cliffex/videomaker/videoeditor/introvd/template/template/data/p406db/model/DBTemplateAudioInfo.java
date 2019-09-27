package com.introvd.template.template.data.p406db.model;

import android.support.annotation.Keep;
import com.introvd.template.template.data.p406db.C8687a;
import com.vivavideo.p428a.p429a.C9275b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Keep
@C9275b(aPw = "template_audio")
/* renamed from: com.introvd.template.template.data.db.model.DBTemplateAudioInfo */
public class DBTemplateAudioInfo extends C8687a {
    public static final int TYPE_AUDIO_EFFECT = 1;
    public static final int TYPE_MUSIC = 0;
    @C9275b(mo36464Fs = "album")
    public String album;
    @C9275b(mo36464Fs = "audio_url")
    public String audioUrl;
    @C9275b(mo36464Fs = "author")
    public String author;
    @C9275b(mo36464Fs = "categoryId")
    public String categoryId;
    @C9275b(mo36464Fs = "categoryName")
    public String categoryName;
    @C9275b(mo36464Fs = "categoryOrder")
    public int categoryOrder;
    @C9275b(mo36464Fs = "cover_url")
    public String coverUrl;
    @C9275b(mo36464Fs = "createTime")
    public long createTime;
    @C9275b(mo36464Fs = "duration")
    public int duration;
    @C9275b(mo36464Fs = "id", mo36466Fu = true)
    public String index;
    public boolean isDownloaded;
    @C9275b(mo36464Fs = "musicFilePath")
    public String musicFilePath;
    @C9275b(mo36464Fs = "type")
    public int musicType;
    @C9275b(mo36464Fs = "name")
    public String name;
    @C9275b(mo36464Fs = "new_flag")
    public String newFlag;
    @C9275b(mo36464Fs = "order")
    public long order;
    public String timeStr;

    @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.introvd.template.template.data.db.model.DBTemplateAudioInfo$DBTemplateAudioType */
    public @interface DBTemplateAudioType {
    }

    public DBTemplateAudioInfo() {
    }

    public DBTemplateAudioInfo(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, long j, long j2, String str8, String str9, int i2, String str10, int i3) {
        this.index = str;
        this.coverUrl = str2;
        this.audioUrl = str3;
        this.name = str4;
        this.duration = i;
        this.author = str5;
        this.album = str6;
        this.newFlag = str7;
        this.order = j;
        this.createTime = j2;
        this.categoryId = str8;
        this.categoryName = str9;
        this.categoryOrder = i2;
        this.musicFilePath = str10;
        this.musicType = i3;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getAudioUrl() {
        return this.audioUrl;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getCategoryOrder() {
        return this.categoryOrder;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getIndex() {
        return this.index;
    }

    public String getMusicFilePath() {
        return this.musicFilePath;
    }

    public int getMusicType() {
        return this.musicType;
    }

    public String getName() {
        return this.name;
    }

    public String getNewFlag() {
        return this.newFlag;
    }

    public long getOrder() {
        return this.order;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public void setAudioUrl(String str) {
        this.audioUrl = str;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCategoryOrder(int i) {
        this.categoryOrder = i;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setIndex(String str) {
        this.index = str;
    }

    public void setMusicFilePath(String str) {
        this.musicFilePath = str;
    }

    public void setMusicType(int i) {
        this.musicType = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNewFlag(String str) {
        this.newFlag = str;
    }

    public void setOrder(long j) {
        this.order = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateAudioInfo{index='");
        sb.append(this.index);
        sb.append('\'');
        sb.append('\'');
        sb.append(", coverUrl='");
        sb.append(this.coverUrl);
        sb.append('\'');
        sb.append(", audioUrl='");
        sb.append(this.audioUrl);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", duration='");
        sb.append(this.duration);
        sb.append('\'');
        sb.append(", author='");
        sb.append(this.author);
        sb.append('\'');
        sb.append(", album='");
        sb.append(this.album);
        sb.append('\'');
        sb.append(", newFlag='");
        sb.append(this.newFlag);
        sb.append('\'');
        sb.append(", order='");
        sb.append(this.order);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
