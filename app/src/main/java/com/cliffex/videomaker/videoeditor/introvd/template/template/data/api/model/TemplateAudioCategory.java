package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TemplateAudioCategory implements Serializable {
    public static final int COPY_RIGHT_NEED_DIALOG = 1;
    public static final int COPY_RIGHT_NO_LIMIT = 0;
    @SerializedName("copyrightFlag")
    public int copyrightFlag;
    @SerializedName("cover")
    public String coverUrl;
    @SerializedName("classid")
    public String index;
    @SerializedName("classname")
    public String name;
    @SerializedName("orderno")
    public int order;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MusicCopyRight {
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TemplateAudioCategory templateAudioCategory = (TemplateAudioCategory) obj;
        if (this.index == null || !this.index.equals(templateAudioCategory.index)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        if (this.index != null) {
            return this.index.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateAudioCategory{index='");
        sb.append(this.index);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", order=");
        sb.append(this.order);
        sb.append(", coverUrl='");
        sb.append(this.coverUrl);
        sb.append('\'');
        sb.append(", copyrightFlag='");
        sb.append(this.copyrightFlag);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
