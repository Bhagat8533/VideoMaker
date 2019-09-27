package com.introvd.template.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sns.SnsType;

public class ImgPreviewDataItem extends TrimedClipItemDataModel implements Parcelable {
    public static final Creator<ImgPreviewDataItem> CREATOR = new Creator<ImgPreviewDataItem>() {
        public ImgPreviewDataItem createFromParcel(Parcel parcel) {
            return new ImgPreviewDataItem(parcel);
        }

        public ImgPreviewDataItem[] newArray(int i) {
            return new ImgPreviewDataItem[i];
        }
    };
    public SnsType snsType;

    public ImgPreviewDataItem() {
    }

    protected ImgPreviewDataItem(Parcel parcel) {
        super(parcel);
        int readInt = parcel.readInt();
        this.snsType = readInt == -1 ? null : SnsType.values()[readInt];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.snsType == null ? -1 : this.snsType.ordinal());
    }
}
