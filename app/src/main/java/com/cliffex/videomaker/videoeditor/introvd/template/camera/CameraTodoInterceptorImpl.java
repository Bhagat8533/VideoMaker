package com.introvd.template.camera;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.camera.p231d.C5024a;
import com.introvd.template.camera.p231d.C5024a.C5026a;
import com.introvd.template.p324m.C7563a;
import com.introvd.template.p363o.C8086a;
import com.introvd.template.p363o.C8099d;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.camera.CameraIntentInfo;
import com.introvd.template.router.camera.CameraRouter;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.todoCode.BaseTodoInterceptor;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.quvideo.rescue.C4905b;
import org.json.JSONException;
import org.json.JSONObject;

@C1942a(mo10417rZ = "/vivacamera/todoInterceptor")
public class CameraTodoInterceptorImpl extends BaseTodoInterceptor {
    /* access modifiers changed from: private */
    public static boolean getAutoCloseParam(String str) {
        try {
            return new JSONObject(str).optBoolean(TodoConstants.KEY_TODOCODE_PARAM_AUTOCLOSE);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void handlerCameraTodo(final Activity activity, int i, int i2, TODOParamModel tODOParamModel, Bundle bundle) {
        C8522g.aJA().ebQ = -1;
        C5024a aVar = new C5024a(i, i2, tODOParamModel, bundle);
        aVar.mo25874a((C5026a) new C5026a() {
            /* renamed from: a */
            public void mo24971a(CameraIntentInfo cameraIntentInfo, TODOParamModel tODOParamModel) {
                if (tODOParamModel == null || TextUtils.isEmpty(tODOParamModel.mJsonParam)) {
                    C7563a.m22315a(activity, cameraIntentInfo, null, false);
                } else {
                    C8558m.egR = tODOParamModel.mJsonParam;
                    C7563a.m22315a(activity, cameraIntentInfo, tODOParamModel, CameraTodoInterceptorImpl.getAutoCloseParam(tODOParamModel.mJsonParam));
                }
                C4905b.m12546fR(9);
            }
        });
        aVar.mo25875ab(activity);
    }

    public boolean executeTodo(final Activity activity, final TODOParamModel tODOParamModel, Bundle bundle) {
        int i = 0;
        switch (tODOParamModel.mTODOCode) {
            case 201:
                handlerCameraTodo(activity, 256, 1, tODOParamModel, bundle);
                break;
            case 202:
                handlerCameraTodo(activity, 512, 1, tODOParamModel, bundle);
                break;
            case 207:
                handlerCameraTodo(activity, 256, 6, tODOParamModel, bundle);
                break;
            case TodoConstants.TODO_TYPE_CAMERA_MODE_ACTION /*208*/:
                handlerCameraTodo(activity, 256, 7, tODOParamModel, bundle);
                break;
            case TodoConstants.TODO_TYPE_CAMERA_MODE_FUNNY /*209*/:
                handlerCameraTodo(activity, 256, 8, tODOParamModel, bundle);
                break;
            case TodoConstants.TODO_TYPE_CAMERA_MODE_PIP /*210*/:
                handlerCameraTodo(activity, 256, 9, tODOParamModel, bundle);
                break;
            case TodoConstants.TODO_TYPE_CAMERA_MODE_FB /*211*/:
                handlerCameraTodo(activity, 256, 10, tODOParamModel, bundle);
                break;
            case TodoConstants.TODO_TYPE_CAMERA_MODE_FB6 /*215*/:
                handlerCameraTodo(activity, 256, 10, tODOParamModel, bundle);
                break;
            case TodoConstants.TODO_TYPE_CAMERA_MODE_HD6 /*216*/:
                handlerCameraTodo(activity, 256, 1, tODOParamModel, bundle);
                break;
            case TodoConstants.TODO_TYPE_CAMERA_MODE_MV6 /*217*/:
                handlerCameraTodo(activity, 256, 6, tODOParamModel, bundle);
                break;
            case TodoConstants.TODO_TYPE_CAMERA_TANABATA /*218*/:
                C8522g.aJA().ebQ = -1;
                C8558m.egR = tODOParamModel.mJsonParam;
                C8086a.m23466a(activity, (C8099d) new C8099d() {
                    /* renamed from: PP */
                    public void mo24403PP() {
                        CameraRouter.launchSimulateCamera(activity, tODOParamModel);
                        activity.finish();
                    }

                    /* renamed from: PQ */
                    public void mo24404PQ() {
                    }
                });
                break;
            case TodoConstants.TODO_TYPE_CAMERA_MODE_PERFECT /*219*/:
                handlerCameraTodo(activity, 256, 12, tODOParamModel, bundle);
                break;
            default:
                return false;
        }
        String string = bundle == null ? EditorRouter.COMMON_BEHAVIOR_POSITION_OTHER : bundle.getString(EditorRouter.COMMON_PARAM_POSITION, EditorRouter.COMMON_BEHAVIOR_POSITION_OTHER);
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            if (tODOParamModel != null) {
                i = tODOParamModel.mTODOCode;
            }
            iEditorService.updateCommonBehaviorParam(i, string, true);
        }
        return true;
    }

    public String getTodoCodeName(int i) {
        return super.getTodoCodeName(i);
    }
}
