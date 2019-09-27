package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.camera.CameraActivity;
import com.introvd.template.camera.CameraActivityNew;
import com.introvd.template.camera.CameraTodoInterceptorImpl;
import com.introvd.template.camera.SimulateCameraActivity;
import com.introvd.template.router.camera.CameraRouter;
import java.util.Map;

public class ARouter$$Group$$vivacamera implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(CameraRouter.URL_NEW, RouteMeta.build(C1945a.ACTIVITY, CameraActivityNew.class, CameraRouter.URL_NEW, "vivacamera", null, -1, Integer.MIN_VALUE));
        map.put(CameraRouter.URL_OLD, RouteMeta.build(C1945a.ACTIVITY, CameraActivity.class, CameraRouter.URL_OLD, "vivacamera", null, -1, Integer.MIN_VALUE));
        map.put(CameraRouter.URL_SIMULATE, RouteMeta.build(C1945a.ACTIVITY, SimulateCameraActivity.class, CameraRouter.URL_SIMULATE, "vivacamera", null, -1, Integer.MIN_VALUE));
        map.put(CameraRouter.CAMERA_TODO_INTERCEPTOR, RouteMeta.build(C1945a.PROVIDER, CameraTodoInterceptorImpl.class, "/vivacamera/todointerceptor", "vivacamera", null, -1, Integer.MIN_VALUE));
    }
}
