package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1950d;
import com.introvd.template.editor.export.ExportServiceImpl;
import com.introvd.template.editor.provider.EditorServiceImpl;
import com.introvd.template.router.editor.EditorRouter;
import java.util.Map;

public class ARouter$$Providers$$vivabizeditor implements C1950d {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.introvd.template.router.editor.export.IExportService", RouteMeta.build(C1945a.PROVIDER, ExportServiceImpl.class, EditorRouter.BIZ_VIDEO_EXPORT_SERVICE, "XYVideoEditor", null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.router.editor.IEditorService", RouteMeta.build(C1945a.PROVIDER, EditorServiceImpl.class, EditorRouter.EDITOR_SERVICE, "XYVideoEditor", null, -1, Integer.MIN_VALUE));
    }
}
