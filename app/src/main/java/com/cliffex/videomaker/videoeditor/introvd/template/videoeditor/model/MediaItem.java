package com.introvd.template.videoeditor.model;

import android.graphics.Bitmap;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.sns.MediaType;
import com.introvd.template.sns.SnsType;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaItem implements Serializable {
    public String album;
    public String artist;
    public long date;
    public String displayTitle;
    public long duration;
    public int iState = -1;
    public boolean isDownloading = false;
    public boolean isFromDownloaded = false;
    public long lTemplateId = 0;
    public int leftTimeStamp;
    public Bitmap mThumb;
    public int mediaId;
    public MediaType mediaType;
    public int nMask = -1;
    public String path;
    public String resolution;
    public int rightTimeStamp;
    public SnsType snsType;
    public String title;

    public MediaItem() {
    }

    public MediaItem(String str) {
        fromJSONString(str);
    }

    public final void fromJSONString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.title = jSONObject.optString("title");
            this.displayTitle = jSONObject.optString("displayTitle");
            this.path = jSONObject.optString("path");
            this.resolution = jSONObject.optString("resolution");
            this.artist = jSONObject.optString(SocialConstDef.MEDIA_ITEM_ARTIST);
            this.album = jSONObject.optString("album");
            this.mediaId = jSONObject.optInt("mediaId", 0);
            this.duration = jSONObject.optLong("duration", 0);
            this.date = jSONObject.optLong("date", 0);
        } catch (Exception unused) {
        }
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.title != null) {
                jSONObject.put("title", this.title);
            }
            if (this.displayTitle != null) {
                jSONObject.put("displayTitle", this.displayTitle);
            }
            if (this.path != null) {
                jSONObject.put("path", this.path);
            }
            if (this.resolution != null) {
                jSONObject.put("resolution", this.resolution);
            }
            if (this.artist != null) {
                jSONObject.put(SocialConstDef.MEDIA_ITEM_ARTIST, this.artist);
            }
            if (this.album != null) {
                jSONObject.put("album", this.album);
            }
            jSONObject.put("mediaId", this.mediaId);
            jSONObject.put("duration", this.duration);
            jSONObject.put("date", this.date);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
