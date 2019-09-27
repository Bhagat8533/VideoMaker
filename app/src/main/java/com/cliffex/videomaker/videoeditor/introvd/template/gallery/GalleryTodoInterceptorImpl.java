package com.introvd.template.gallery;

import android.app.Activity;
import android.os.Bundle;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.router.todoCode.BaseTodoInterceptor;
import com.introvd.template.router.todoCode.TODOParamModel;

@C1942a(mo10417rZ = "/gallerySelf/todoInterceptor")
public class GalleryTodoInterceptorImpl extends BaseTodoInterceptor {
    public boolean executeTodo(Activity activity, TODOParamModel tODOParamModel, Bundle bundle) {
        return super.executeTodo(activity, tODOParamModel, bundle);
    }

    public String getTodoCodeName(int i) {
        return super.getTodoCodeName(i);
    }
}
