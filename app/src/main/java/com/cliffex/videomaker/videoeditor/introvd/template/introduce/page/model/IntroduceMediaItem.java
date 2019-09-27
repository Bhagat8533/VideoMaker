package com.introvd.template.introduce.page.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IntroduceMediaItem implements Parcelable {
    public static final Creator<IntroduceMediaItem> CREATOR = new Creator<IntroduceMediaItem>() {
        public IntroduceMediaItem createFromParcel(Parcel parcel) {
            IntroduceMediaItem introduceMediaItem = new IntroduceMediaItem();
            introduceMediaItem.isImage = parcel.readByte() != 0;
            introduceMediaItem.previewUrl = parcel.readString();
            introduceMediaItem.coverUrl = parcel.readString();
            introduceMediaItem.width = parcel.readInt();
            introduceMediaItem.height = parcel.readInt();
            return introduceMediaItem;
        }

        public IntroduceMediaItem[] newArray(int i) {
            return new IntroduceMediaItem[i];
        }
    };
    /* access modifiers changed from: private */
    public String coverUrl;
    /* access modifiers changed from: private */
    public int height;
    /* access modifiers changed from: private */
    public boolean isImage;
    /* access modifiers changed from: private */
    public String previewUrl;
    /* access modifiers changed from: private */
    public int width;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String coverUrl;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        public boolean isImage;
        /* access modifiers changed from: private */
        public String previewUrl;
        /* access modifiers changed from: private */
        public int width;

        public IntroduceMediaItem build() {
            return new IntroduceMediaItem(this);
        }

        public Builder coverUrl(String str) {
            this.coverUrl = str;
            return this;
        }

        public Builder height(int i) {
            this.height = i;
            return this;
        }

        public Builder isImage(boolean z) {
            this.isImage = z;
            return this;
        }

        public Builder previewUrl(String str) {
            this.previewUrl = str;
            return this;
        }

        public Builder width(int i) {
            this.width = i;
            return this;
        }
    }

    public IntroduceMediaItem() {
    }

    private IntroduceMediaItem(Builder builder) {
        this.isImage = builder.isImage;
        this.previewUrl = builder.previewUrl;
        this.coverUrl = builder.coverUrl;
        this.width = builder.width;
        this.height = builder.height;
    }

    public int describeContents() {
        return 0;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isImage() {
        return this.isImage;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isImage ? (byte) 1 : 0);
        parcel.writeString(this.previewUrl);
        parcel.writeString(this.coverUrl);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }
}
