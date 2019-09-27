package com.introvd.template.introduce.page.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

@Keep
public class IntroduceModel implements Parcelable {
    public static final Creator<IntroduceModel> CREATOR = new Creator<IntroduceModel>() {
        public IntroduceModel createFromParcel(Parcel parcel) {
            return new IntroduceModel(parcel);
        }

        public IntroduceModel[] newArray(int i) {
            return new IntroduceModel[i];
        }
    };
    private String buttontext;
    private String buttonurl;
    private String communityinfo;
    private String description;
    private List<String> text;
    private String title;
    private List<UrlArrayBean> urlarray;

    @Keep
    public static class UrlArrayBean implements Parcelable {
        public static final Creator<UrlArrayBean> CREATOR = new Creator<UrlArrayBean>() {
            public UrlArrayBean createFromParcel(Parcel parcel) {
                return new UrlArrayBean(parcel);
            }

            public UrlArrayBean[] newArray(int i) {
                return new UrlArrayBean[i];
            }
        };
        private String coverurl;
        private int height;
        private String type;
        private String url;
        private int width;

        public UrlArrayBean() {
        }

        protected UrlArrayBean(Parcel parcel) {
            this.type = parcel.readString();
            this.url = parcel.readString();
            this.coverurl = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public String getCoverurl() {
            return this.coverurl;
        }

        public int getHeight() {
            return this.height;
        }

        public String getType() {
            return this.type;
        }

        public String getUrl() {
            return this.url;
        }

        public int getWidth() {
            return this.width;
        }

        public void setCoverurl(String str) {
            this.coverurl = str;
        }

        public void setHeight(int i) {
            this.height = i;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setWidth(int i) {
            this.width = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.type);
            parcel.writeString(this.url);
            parcel.writeString(this.coverurl);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
        }
    }

    public IntroduceModel() {
    }

    protected IntroduceModel(Parcel parcel) {
        this.buttontext = parcel.readString();
        this.description = parcel.readString();
        this.title = parcel.readString();
        this.buttonurl = parcel.readString();
        this.communityinfo = parcel.readString();
        this.text = parcel.createStringArrayList();
        this.urlarray = new ArrayList();
        parcel.readList(this.urlarray, UrlArrayBean.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String getButtontext() {
        return this.buttontext;
    }

    public String getButtonurl() {
        return this.buttonurl;
    }

    public String getCommunityinfo() {
        return this.communityinfo;
    }

    public String getDescription() {
        return this.description;
    }

    public List<String> getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public List<UrlArrayBean> getUrlArray() {
        return this.urlarray;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.buttontext);
        parcel.writeString(this.description);
        parcel.writeString(this.title);
        parcel.writeString(this.buttonurl);
        parcel.writeString(this.communityinfo);
        parcel.writeStringList(this.text);
        parcel.writeList(this.urlarray);
    }
}
