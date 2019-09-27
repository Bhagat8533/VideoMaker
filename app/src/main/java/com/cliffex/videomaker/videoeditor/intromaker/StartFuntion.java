package com.cliffex.videomaker.videoeditor.intromaker;

import android.app.Activity;

import com.cliffex.videomaker.videoeditor.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;

public class StartFuntion {
    public static void startCameraPhoto(Activity activity) {
        TODOParamModel todoParamModel = new TODOParamModel();
        todoParamModel.mJsonParam = null;
        todoParamModel.mTODOCode = 201;
        BizAppTodoActionManager.getInstance().executeTodo(activity, todoParamModel);
    }

    public static void startCreateIntroVideo(Activity activity) {
        TODOParamModel todoParamModel = new TODOParamModel();
        todoParamModel.mJsonParam = null;
        todoParamModel.mTODOCode = 408;
        BizAppTodoActionManager.getInstance().executeTodo(activity, todoParamModel);
    }

    public static void startEditVideo(Activity activity) {
        TODOParamModel todoParamModel = new TODOParamModel();
        todoParamModel.mJsonParam = null;
        todoParamModel.mTODOCode = 401;
        BizAppTodoActionManager.getInstance().executeTodo(activity, todoParamModel);
    }

    public static void startCameraSelfie(Activity activity) {
        TODOParamModel todoParamModel = new TODOParamModel();
        todoParamModel.mJsonParam = null;
        todoParamModel.mTODOCode = TodoConstants.TODO_TYPE_CAMERA_MODE_FB;
        BizAppTodoActionManager.getInstance().executeTodo(activity, todoParamModel);
    }

    public static void startIntroStudio(Activity activity) {
        TODOParamModel todoParamModel = new TODOParamModel();
        todoParamModel.mJsonParam = null;
        todoParamModel.mTODOCode = TodoConstants.TODO_TYPE_STUDIO;
        BizAppTodoActionManager.getInstance().executeTodo(activity, todoParamModel);
    }

    public static void startThemeStore(Activity activity) {
        TODOParamModel todoParamModel = new TODOParamModel();
        todoParamModel.mJsonParam = null;
        todoParamModel.mTODOCode = 605;
        BizAppTodoActionManager.getInstance().executeTodo(activity, todoParamModel);
    }

    public static void startGhepVideo(Activity activity) {
        TODOParamModel todoParamModel = new TODOParamModel();
        todoParamModel.mJsonParam = null;
        todoParamModel.mTODOCode = 409;
        BizAppTodoActionManager.getInstance().executeTodo(activity, todoParamModel);
    }
}
