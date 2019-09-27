package com.introvd.template.router.template;

import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.todoCode.TODOParamModel;

public interface ITemplateService extends C1949c {
    boolean checkTodoParamXytExist(Context context, TODOParamModel tODOParamModel);

    boolean checkXytExist(Context context, long j);

    void downloadXyt(Context context, long j, String str, TemplateAPICallback templateAPICallback);

    boolean isAnimSubtitleRollcode(String str);

    boolean isNeedToPurchase(String str);

    void updateRollTemplateMapInfo(Context context);
}
