package com.cliffex.videomaker.videoeditor.introvd.template.router.todoCode;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.camera.CameraRouter;
import com.introvd.template.router.community.VivaCommunityRouter;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.router.user.UserRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import com.introvd.template.router.todoCode.BaseTodoInterceptor;
import com.introvd.template.router.todoCode.TODOParamModel;

public class BizAppTodoActionManager {
    private static volatile BizAppTodoActionManager instance;
    private final String[] todoActionInterceptorKeys = {AppRouter.BIZAPP_TODO_INTERCEPTOR, EditorRouter.EDITOR_TODO_INTERCEPTOR, VivaCommunityRouter.COMMUNITY_TODO_INTERCEPTOR, CameraRouter.CAMERA_TODO_INTERCEPTOR, GalleryRouter.GALLERY_TODO_INTERCEPTOR, UserRouter.BIZ_USER_TODO_INTERCEPTOR, TemplateRouter.TEMPLATE_TODO_INTERCEPTOR};
    private Map<String, com.introvd.template.router.todoCode.BaseTodoInterceptor> todoInterceptorMap = new LinkedHashMap();

    private BizAppTodoActionManager() {
        String[] strArr;
        for (String str : this.todoActionInterceptorKeys) {
            BaseTodoInterceptor baseTodoInterceptor = (BaseTodoInterceptor) C1919a.m5529sc().mo10355al(str).mo10412rX();
            if (baseTodoInterceptor != null) {
                this.todoInterceptorMap.put(str, baseTodoInterceptor);
            }
        }
    }

    public static BizAppTodoActionManager getInstance() {
        if (instance == null) {
            synchronized (BizAppTodoActionManager.class) {
                if (instance == null) {
                    instance = new BizAppTodoActionManager();
                }
            }
        }
        return instance;
    }


    public final void executeQATestTodo(Context context, TODOParamModel tODOParamModel, Bundle bundle) {
        for (BaseTodoInterceptor baseTodoInterceptor : this.todoInterceptorMap.values()) {
            if (baseTodoInterceptor != null && baseTodoInterceptor.executeQATestTodo(context, tODOParamModel, bundle)) {
                return;
            }
        }
    }

    public final void executeTodo(Activity activity, TODOParamModel tODOParamModel) {
        for (BaseTodoInterceptor baseTodoInterceptor : this.todoInterceptorMap.values()) {
            if (baseTodoInterceptor != null && baseTodoInterceptor.executeTodo(activity, tODOParamModel)) {
                return;
            }
        }
    }

    public final void executeTodo(Activity activity, TODOParamModel tODOParamModel, Bundle bundle) {
        for (BaseTodoInterceptor baseTodoInterceptor : this.todoInterceptorMap.values()) {
            if (baseTodoInterceptor != null && baseTodoInterceptor.executeTodo(activity, tODOParamModel, bundle)) {
                return;
            }
        }
    }

    public final String getTodoCodeName(int i) {
        String str = null;
        for (BaseTodoInterceptor baseTodoInterceptor : this.todoInterceptorMap.values()) {
            if (baseTodoInterceptor != null) {
                str = baseTodoInterceptor.getTodoCodeName(i);
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        return sb.toString();
    }

    public BaseTodoInterceptor geteTodoInterceptorByKey(String str) {
        return (BaseTodoInterceptor) this.todoInterceptorMap.get(str);
    }
}
