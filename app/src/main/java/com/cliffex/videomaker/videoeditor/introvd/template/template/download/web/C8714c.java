package com.introvd.template.template.download.web;

import android.app.Activity;
import com.introvd.template.common.callback.SimpleResultCallback;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.todoCode.BaseTodoInterceptor;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;

/* renamed from: com.introvd.template.template.download.web.c */
public class C8714c extends SimpleResultCallback {
    private Activity activity;
    private String activityId;
    private TODOParamModel todoParamModel;

    public C8714c(Activity activity2, TODOParamModel tODOParamModel, String str) {
        this.activity = activity2;
        this.todoParamModel = tODOParamModel;
        this.activityId = str;
    }

    public void onResult(int i) {
        if (i == -1) {
            BizAppTodoActionManager.getInstance().executeTodo(this.activity, this.todoParamModel, null);
            if (this.todoParamModel != null && this.todoParamModel.getAutoCloseParam()) {
                this.activity.finish();
            }
        } else if (i == 1) {
            BaseTodoInterceptor baseTodoInterceptor = BizAppTodoActionManager.getInstance().geteTodoInterceptorByKey(EditorRouter.EDITOR_TODO_INTERCEPTOR);
            if (baseTodoInterceptor != null) {
                baseTodoInterceptor.executeTodo(this.activity, this.todoParamModel, this.todoParamModel.mTODOCode, this.activityId);
            }
            if (this.todoParamModel != null && this.todoParamModel.getAutoCloseParam()) {
                this.activity.finish();
            }
        }
    }
}
