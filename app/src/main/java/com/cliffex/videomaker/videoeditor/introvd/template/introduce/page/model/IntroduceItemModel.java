package com.introvd.template.introduce.page.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class IntroduceItemModel implements Parcelable {
    public static final Creator<IntroduceItemModel> CREATOR = new Creator<IntroduceItemModel>() {
        public IntroduceItemModel createFromParcel(Parcel parcel) {
            IntroduceItemModel introduceItemModel = new IntroduceItemModel();
            introduceItemModel.todoCode = parcel.readInt();
            introduceItemModel.todoContent = parcel.readString();
            introduceItemModel.title = parcel.readString();
            introduceItemModel.desc = parcel.readString();
            introduceItemModel.mediaItems = parcel.createTypedArrayList(IntroduceMediaItem.CREATOR);
            return introduceItemModel;
        }

        public IntroduceItemModel[] newArray(int i) {
            return new IntroduceItemModel[i];
        }
    };
    /* access modifiers changed from: private */
    public String desc;
    /* access modifiers changed from: private */
    public ArrayList<IntroduceMediaItem> mediaItems;
    /* access modifiers changed from: private */
    public String title;
    /* access modifiers changed from: private */
    public int todoCode;
    /* access modifiers changed from: private */
    public String todoContent;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String desc;
        /* access modifiers changed from: private */
        public ArrayList<IntroduceMediaItem> mediaItems;
        /* access modifiers changed from: private */
        public String title;
        /* access modifiers changed from: private */
        public int todoCode;
        /* access modifiers changed from: private */
        public String todoContent;

        public IntroduceItemModel build() {
            return new IntroduceItemModel(this);
        }

        public Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public Builder mediaItem(ArrayList<IntroduceMediaItem> arrayList) {
            this.mediaItems = arrayList;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder todoCode(int i) {
            this.todoCode = i;
            return this;
        }

        public Builder todoContent(String str) {
            this.todoContent = str;
            return this;
        }
    }

    public IntroduceItemModel() {
    }

    private IntroduceItemModel(Builder builder) {
        this.todoCode = builder.todoCode;
        this.todoContent = builder.todoContent;
        this.title = builder.title;
        this.desc = builder.desc;
        this.mediaItems = builder.mediaItems;
    }

    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<IntroduceMediaItem> getMediaItems() {
        return this.mediaItems;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTodoCode() {
        return this.todoCode;
    }

    public String getTodoContent() {
        return this.todoContent;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setMediaItems(ArrayList<IntroduceMediaItem> arrayList) {
        this.mediaItems = arrayList;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTodoCode(int i) {
        this.todoCode = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.todoCode);
        parcel.writeString(this.todoContent);
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeTypedList(this.mediaItems);
    }
}
