package com.introvd.template.router.community;

import com.ironsource.mediationsdk.logger.IronSourceError;

public class WhatsAppStatus {
    public static final int IMAGE = 2;
    public static final int OTHER = 0;
    public static final int VIDEO = 1;
    public long duration;
    public String fileName;
    public int hasSave;
    public int height;

    /* renamed from: id */
    public int f3573id;
    public boolean isPostCheck = true;
    public String path;
    public String thumbnailPath;
    public int type;
    public int width;

    public WhatsAppStatus() {
    }

    private WhatsAppStatus(int i, int i2, String str, String str2, String str3, long j, int i3, int i4) {
        this.f3573id = i;
        this.type = i2;
        this.path = str;
        this.thumbnailPath = str2;
        this.fileName = str3;
        this.duration = j;
        this.width = i3;
        this.height = i4;
    }

    public static WhatsAppStatus newInstance(int i, int i2, String str, String str2, String str3, long j, int i3, int i4) {
        WhatsAppStatus whatsAppStatus = new WhatsAppStatus(i, i2, str, str2, str3, j, i3, i4);
        return whatsAppStatus;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WhatsAppStatus) {
            WhatsAppStatus whatsAppStatus = (WhatsAppStatus) obj;
            if (!(whatsAppStatus.type == this.type && whatsAppStatus.path == null) ? !whatsAppStatus.path.equals(this.path) || whatsAppStatus.thumbnailPath != null ? !whatsAppStatus.thumbnailPath.equals(this.thumbnailPath) || whatsAppStatus.fileName != null ? !(whatsAppStatus.fileName.equals(this.fileName) && whatsAppStatus.duration == this.duration && whatsAppStatus.width == this.width && whatsAppStatus.height == this.height) : this.fileName != null : this.thumbnailPath != null : this.path != null) {
                return true;
            }
        }
        return false;
    }

    public boolean getIsPostCheck() {
        return this.isPostCheck;
    }

    public int hashCode() {
        return ((((((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.type) * 31) + this.path.hashCode()) * 31) + this.thumbnailPath.hashCode()) * 31) + this.fileName.hashCode()) * 31) + Long.valueOf(this.duration).hashCode()) * 31) + this.width) * 31) + this.height;
    }

    public void setHasSave(boolean z) {
        if (z) {
            this.hasSave = 1;
        } else {
            this.hasSave = 0;
        }
    }

    public void setIsPostCheck(boolean z) {
        this.isPostCheck = z;
    }
}
