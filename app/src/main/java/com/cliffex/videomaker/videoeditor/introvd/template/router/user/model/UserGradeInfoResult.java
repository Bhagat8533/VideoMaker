package com.introvd.template.router.user.model;

import android.support.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;

@Keep
public class UserGradeInfoResult {
    @SerializedName("b")
    public UserGradeInfoDto gradeInfoDto;
    @SerializedName("a")
    public List<UserPrivilegeInfo> privilegeInfo;
    @SerializedName("c")
    public List<UserGradeTaskInfo> taskInfoList;
}
