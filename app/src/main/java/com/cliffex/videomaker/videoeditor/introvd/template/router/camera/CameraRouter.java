package com.introvd.template.router.camera;

import android.app.Activity;
import android.os.Parcelable;
import aoptest.chandler.com.vivarouter.R;
import com.introvd.template.router.BaseRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.app.IFreezeService;
import com.introvd.template.router.camera.CameraIntentInfo.Builder;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.user.UserServiceProxy;
import java.util.HashMap;
import java.util.Map.Entry;

public class CameraRouter extends BaseRouter {
    public static final int ADJUST_CAMERA_BACK = 0;
    public static final int ADJUST_CAMERA_BOTH = 2;
    public static final int ADJUST_CAMERA_FRONT = 1;
    public static final int ADJUST_CAMERA_NONE = -1;
    public static final String CAMERA_TODO_INTERCEPTOR = "/vivacamera/todoInterceptor";
    static final String GROUP_NAME = "/vivacamera/";
    public static final int INTENT_MODE_ACTIVITY = 4099;
    public static final int INTENT_MODE_AD_EDITER = 4098;
    public static final int INTENT_MODE_CAMERA = 4100;
    public static final int INTENT_MODE_CAM_ADJUST = 4102;
    public static final int INTENT_MODE_EDIT_PIP = 4103;
    public static final int INTENT_MODE_NORMAL = 4097;
    public static final int INTENT_MODE_SIMPLE_EDIT = 4101;
    public static final String KEY_CAMERA_ADJUST_MODE = "key_camera_adjust_mode";
    public static final String KEY_CAMERA_INTENT = "key_camera_intent";
    public static final String KEY_CAMERA_MODE = "key_camera_mode";
    public static final String KEY_CAMERA_MODE_PARAM = "key_camera_mode_param";
    public static final String KEY_CAMERA_PREVIEW_OLDPRJ = "key_camera_preview_oldprj";
    public static final String KEY_INTENT_CLIP_INSERT_POSITION = "key_intent_clip_insert_position";
    public static final String KEY_PREFER_HAS_ENTER_CAMERA = "pre_has_entered_camera";
    public static final String KEY_PREF_LAST_CAMERA_MODE_PARAM = "key_pref_last_camera_mode_param";
    public static final String URL_NEW = "/vivacamera/new_version";
    public static final String URL_OLD = "/vivacamera/old_version";
    public static final String URL_SIMULATE = "/vivacamera/simulate";

    public static void launchCameraForResult(Activity activity, CameraIntentInfo cameraIntentInfo, Parcelable parcelable, int i) {
        IFreezeService iFreezeService = (IFreezeService) BizServiceManager.getService(IFreezeService.class);
        if (iFreezeService != null) {
            int freezeCode = iFreezeService.getFreezeCode();
            if (freezeCode == 203) {
                iFreezeService.showFreezeDialog(activity, UserServiceProxy.getUserId(), freezeCode);
                return;
            }
        }
        startTodoCodeForCamera(activity, cameraIntentInfo, parcelable, i);
    }

    public static void launchCameraForResult(Activity activity, boolean z, HashMap<String, Object> hashMap, int i) {
        IFreezeService iFreezeService = (IFreezeService) BizServiceManager.getService(IFreezeService.class);
        if (iFreezeService != null) {
            int freezeCode = iFreezeService.getFreezeCode();
            if (freezeCode == 203) {
                iFreezeService.showFreezeDialog(activity, UserServiceProxy.getUserId(), freezeCode);
                return;
            }
        }
        CameraIntentInfo map2bean = map2bean(hashMap);
        Parcelable parcelable = (Parcelable) hashMap.get(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
        map2bean.magicCode = activity.getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
        map2bean.bNewCam = z;
        startTodoCodeForCamera(activity, map2bean, parcelable, i);
    }

    public static void launchSimulateCamera(Activity activity, Parcelable parcelable) {
        getRouterBuilder(activity.getApplication(), URL_SIMULATE).mo10387a(TodoConstants.KEY_TODOCODE_PARAM_MODEL, parcelable).mo10394aZ(R.anim.activity_enter_hold, R.anim.activity_enter_hold).mo10382H(activity);
    }

    private static CameraIntentInfo map2bean(HashMap<String, Object> hashMap) {
        Object obj;
        if (hashMap == null) {
            return null;
        }
        Builder builder = new Builder();
        for (Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                obj = entry.getValue();
                if (obj == null) {
                    continue;
                }
            } else {
                obj = null;
            }
            if (str != null) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -1592945045:
                        if (str.equals(KEY_CAMERA_MODE_PARAM)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1433343210:
                        if (str.equals(KEY_CAMERA_INTENT)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1127627619:
                        if (str.equals(KEY_CAMERA_MODE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 656679961:
                        if (str.equals(KEY_CAMERA_ADJUST_MODE)) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1184949475:
                        if (str.equals(KEY_INTENT_CLIP_INSERT_POSITION)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1845541769:
                        if (str.equals("new_prj")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 2048619626:
                        if (str.equals("activityID")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (!(obj instanceof Integer)) {
                            break;
                        } else {
                            builder.setCameraMode(((Integer) obj).intValue());
                            break;
                        }
                    case 1:
                        if (!(obj instanceof Integer)) {
                            break;
                        } else {
                            builder.setCameraIntent(((Integer) obj).intValue());
                            break;
                        }
                    case 2:
                        if (!(obj instanceof Integer)) {
                            break;
                        } else {
                            builder.setCameraModeParam(((Integer) obj).intValue());
                            break;
                        }
                    case 3:
                        if (!(obj instanceof String)) {
                            break;
                        } else {
                            builder.setActivityID((String) obj);
                            break;
                        }
                    case 4:
                        if (!(obj instanceof Integer)) {
                            break;
                        } else {
                            builder.setNewPrj(((Integer) obj).intValue());
                            break;
                        }
                    case 5:
                        if (!(obj instanceof Integer)) {
                            break;
                        } else {
                            builder.setIntentClipInsertPosition(((Integer) obj).intValue());
                            break;
                        }
                    case 6:
                        if (!(obj instanceof Integer)) {
                            break;
                        } else {
                            builder.setCameraAdjustMode(((Integer) obj).intValue());
                            break;
                        }
                }
            } else {
                return null;
            }
        }
        return builder.build();
    }

    private static void startTodoCodeForCamera(Activity activity, CameraIntentInfo cameraIntentInfo, Parcelable parcelable, int i) {
        String str = cameraIntentInfo.bNewCam ? URL_NEW : URL_OLD;
        getRouterBuilder(activity.getApplication(), str).mo10399f(PassThoughUrlGenerator.EXTRA_PASS_THROUGH_URL, PassThoughUrlGenerator.generateUrl(str, cameraIntentInfo, parcelable)).mo10394aZ(R.anim.activity_enter_hold, R.anim.activity_enter_hold).mo10396b(activity, i);
    }
}
