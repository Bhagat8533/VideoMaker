package com.introvd.template.sdk.database.model;

import android.support.annotation.Keep;

@Keep
public class DBClip {
    public Long _id;
    public String url;

    public DBClip() {
    }

    public DBClip(Long l, String str) {
        this._id = l;
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public Long get_id() {
        return this._id;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void set_id(Long l) {
        this._id = l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DBClip{_id=");
        sb.append(this._id);
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
