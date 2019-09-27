package com.introvd.template.sdk.model.template;

import android.text.TextUtils;
import java.util.List;
import java.util.regex.Pattern;

public class CategoryTemplateInfo implements Comparable<CategoryTemplateInfo> {
    public int dataType;
    public String sceneCode;
    public String sceneName;
    public List<Long> templateList;

    public CategoryTemplateInfo(String str, String str2, List<Long> list, int i) {
        this.sceneCode = str;
        this.sceneName = str2;
        this.templateList = list;
        this.dataType = i;
    }

    private boolean cotainRecomend(int i) {
        return i == 1 || i == 2;
    }

    private boolean isInteger(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[\\-|\\+]?\\d+").matcher(str).matches();
    }

    private int sortBySceneCode(String str, String str2) {
        if (isInteger(str) && isInteger(str2)) {
            return Integer.valueOf(str).intValue() - Integer.valueOf(str2).intValue();
        }
        return isInteger(str2) ? 1 : -1;
    }

    public int compareTo(CategoryTemplateInfo categoryTemplateInfo) {
        return (!cotainRecomend(categoryTemplateInfo.dataType) || !cotainRecomend(this.dataType)) ? categoryTemplateInfo.dataType == this.dataType ? sortBySceneCode(categoryTemplateInfo.sceneCode, this.sceneCode) : categoryTemplateInfo.dataType - this.dataType : sortBySceneCode(categoryTemplateInfo.sceneCode, this.sceneCode);
    }
}
