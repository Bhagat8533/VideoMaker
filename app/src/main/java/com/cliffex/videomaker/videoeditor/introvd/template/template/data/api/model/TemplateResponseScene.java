package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TemplateResponseScene {
    @SerializedName("scenelist")
    public List<Scene> sceneList;

    public static class Scene {
        @SerializedName("bigicon")
        public String bigThumbUrl;
        @SerializedName("tcid")
        public String categoryIndex;
        public String color;
        @SerializedName("intro")
        public String description;
        @SerializedName("code")
        public String index;
        @SerializedName("instagramimglist")
        public String instagramImgList;
        public String name;
        @SerializedName("newcount")
        public String newCount;
        @SerializedName("orderno")
        public String order;
        @SerializedName("previewvideo")
        public String previewUrl;
        @SerializedName("imgurl")
        public String smallThumbUrl;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Scene{index='");
            sb.append(this.index);
            sb.append('\'');
            sb.append(", name='");
            sb.append(this.name);
            sb.append('\'');
            sb.append(", description='");
            sb.append(this.description);
            sb.append('\'');
            sb.append(", order='");
            sb.append(this.order);
            sb.append('\'');
            sb.append(", newCount='");
            sb.append(this.newCount);
            sb.append('\'');
            sb.append(", categoryIndex='");
            sb.append(this.categoryIndex);
            sb.append('\'');
            sb.append(", color='");
            sb.append(this.color);
            sb.append('\'');
            sb.append(", bigThumbUrl='");
            sb.append(this.bigThumbUrl);
            sb.append('\'');
            sb.append(", previewUrl='");
            sb.append(this.previewUrl);
            sb.append('\'');
            sb.append(", smallThumbUrl='");
            sb.append(this.smallThumbUrl);
            sb.append('\'');
            sb.append(", instagramImgList='");
            sb.append(this.instagramImgList);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateScene{sceneList=");
        sb.append(this.sceneList);
        sb.append('}');
        return sb.toString();
    }
}
