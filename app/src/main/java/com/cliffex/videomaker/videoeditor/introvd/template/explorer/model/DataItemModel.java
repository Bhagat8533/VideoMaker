package com.introvd.template.explorer.model;

import android.graphics.Bitmap;
import java.io.Serializable;

public class DataItemModel implements Serializable {
    private boolean isDownloaded = false;
    private long lTemplateId = 0;
    private int mDuration = 0;
    public int mIndex = 0;
    public String mName;
    public int mNameStrId;
    public String mPath;
    public int mResId;
    public Bitmap mThumbnail;
    public int sortIndex;

    public DataItemModel() {
    }

    public DataItemModel(int i, int i2) {
        this.mResId = i;
        this.mNameStrId = i2;
    }

    public DataItemModel(int i, int i2, int i3, int i4) {
        this.mIndex = i;
        this.mResId = i2;
        this.mNameStrId = i3;
        this.sortIndex = i4;
    }

    public DataItemModel(int i, int i2, String str) {
        this.mResId = i;
        this.mNameStrId = i2;
        this.mPath = str;
    }

    public DataItemModel(int i, String str, String str2) {
        this.mResId = i;
        this.mName = str;
        this.mPath = str2;
    }

    public long getlTemplateId() {
        return this.lTemplateId;
    }

    public int getmDuration() {
        return this.mDuration;
    }

    public boolean isDownloaded() {
        return this.isDownloaded;
    }

    public void setDownloaded(boolean z) {
        this.isDownloaded = z;
    }

    public void setlTemplateId(long j) {
        this.lTemplateId = j;
    }

    public void setmDuration(int i) {
        this.mDuration = i;
    }
}
