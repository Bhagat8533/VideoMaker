package com.introvd.template.p324m;

import android.app.Activity;
import android.os.Parcelable;
import com.introvd.template.p363o.C8086a;
import com.introvd.template.p363o.C8099d;
import com.introvd.template.router.camera.CameraIntentInfo;
import com.introvd.template.router.camera.CameraRouter;
import com.introvd.template.router.todoCode.TodoConstants;
import java.util.HashMap;

/* renamed from: com.introvd.template.m.a */
public class C7563a {
    /* renamed from: a */
    public static void m22315a(final Activity activity, final CameraIntentInfo cameraIntentInfo, final Parcelable parcelable, final boolean z) {
        C8086a.m23466a(activity, (C8099d) new C8099d() {
            /* renamed from: PP */
            public void mo24403PP() {
                CameraRouter.launchCameraForResult(activity, cameraIntentInfo, parcelable, -1);
                if (z && activity != null) {
                    activity.finish();
                }
            }

            /* renamed from: PQ */
            public void mo24404PQ() {
            }
        });
    }

    /* renamed from: a */
    public static void m22316a(final Activity activity, final HashMap<String, Object> hashMap) {
        C8086a.m23466a(activity, (C8099d) new C8099d() {
            /* renamed from: PP */
            public void mo24403PP() {
                CameraRouter.launchCameraForResult(activity, true, hashMap, -1);
                if ((hashMap.containsKey(TodoConstants.KEY_TODOCODE_PARAM_AUTOCLOSE) ? ((Boolean) hashMap.get(TodoConstants.KEY_TODOCODE_PARAM_AUTOCLOSE)).booleanValue() : false) && activity != null) {
                    activity.finish();
                }
            }

            /* renamed from: PQ */
            public void mo24404PQ() {
            }
        });
    }
}
