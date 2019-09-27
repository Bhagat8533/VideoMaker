package com.introvd.template.sdk.database.model;

import android.support.annotation.Keep;

@Keep
public class DBClipRef {
    public Long _id;
    public long clip_id;
    public long prj_id;

    public DBClipRef() {
    }

    public DBClipRef(Long l, long j, long j2) {
        this._id = l;
        this.prj_id = j;
        this.clip_id = j2;
    }

    public long getClip_id() {
        return this.clip_id;
    }

    public long getPrj_id() {
        return this.prj_id;
    }

    public Long get_id() {
        return this._id;
    }

    public void setClip_id(long j) {
        this.clip_id = j;
    }

    public void setPrj_id(long j) {
        this.prj_id = j;
    }

    public void set_id(Long l) {
        this._id = l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DBClipRef{_id=");
        sb.append(this._id);
        sb.append(", prj_id=");
        sb.append(this.prj_id);
        sb.append(", clip_id=");
        sb.append(this.clip_id);
        sb.append('}');
        return sb.toString();
    }
}
