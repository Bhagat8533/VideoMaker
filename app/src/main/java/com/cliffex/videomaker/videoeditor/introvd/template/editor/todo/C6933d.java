package com.introvd.template.editor.todo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.p244a.C5553a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.slide.SlideshowRouter;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.slide.p392a.C8460a;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.todo.d */
public class C6933d {
    private static C6933d dkh;
    private HashMap<String, String> dki = new HashMap<>();

    private C6933d() {
    }

    public static C6933d asD() {
        if (dkh == null) {
            dkh = new C6933d();
        }
        return dkh;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30581a(Activity activity, TODOParamModel tODOParamModel) {
        if (C8460a.m24502n(tODOParamModel.getJsonObj())) {
            GalleryRouter.getInstance().launchSlideSpecificPicker(activity, tODOParamModel, C8460a.m24505q(tODOParamModel.getJsonObj()), C8460a.m24504p(tODOParamModel.getJsonObj()), C8460a.m24497i(tODOParamModel.getJsonObj()));
            return;
        }
        SlideshowRouter.launchSlideEdit(activity, (Parcelable) tODOParamModel);
    }

    /* renamed from: a */
    public void mo30582a(Activity activity, TODOParamModel tODOParamModel, int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("executeTodo nTodoCode: ");
        sb.append(i);
        sb.append(" strActivityId: ");
        sb.append(str);
        LogUtils.m14223i("JoinEventMgr", sb.toString());
        C5553a.m15009b(tODOParamModel == null ? "0" : String.valueOf(tODOParamModel.mTODOCode), EditorRouter.COMMON_BEHAVIOR_POSITION_WEB, true);
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            iEditorService.setProjectExtraInfo();
        }
        if (i == 401) {
            GalleryRouter.getInstance().launchVideoEdit(activity, tODOParamModel, str);
        } else if (i == 408) {
            GalleryRouter.getInstance().launchPhotoEdit(activity, tODOParamModel, str);
        } else if (i != 423) {
            if (!(activity == null || activity.getIntent() == null)) {
                activity.getIntent().removeExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
            }
            Bundle bundle = new Bundle();
            bundle.putString("activityID", str);
            bundle.putString(EditorRouter.COMMON_PARAM_POSITION, EditorRouter.COMMON_BEHAVIOR_POSITION_WEB);
            TODOParamModel tODOParamModel2 = new TODOParamModel();
            tODOParamModel2.mTODOCode = i;
            tODOParamModel2.mJsonParam = str;
            BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel2, bundle);
        } else if (C5837a.agH().agM()) {
            mo30581a(activity, tODOParamModel);
        } else {
            SlideshowRouter.launchSlideshowEdit(activity, tODOParamModel);
        }
    }

    /* renamed from: iK */
    public String mo30583iK(String str) {
        return (String) this.dki.get(str);
    }

    public void setTagInfo(String str) {
        this.dki.put(str, str);
    }
}
