package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.editor.VideoEditorActivity;
import com.introvd.template.editor.XiaoYingPreLoadActivity;
import com.introvd.template.editor.clipedit.sort.EditorSortActivity;
import com.introvd.template.editor.common.view.EditLessonFragment;
import com.introvd.template.editor.effects.collage.LocalAlbumActivity;
import com.introvd.template.editor.export.ExportServiceImpl;
import com.introvd.template.editor.fast.FastEditorActivity;
import com.introvd.template.editor.impl.EditorApplicationLifeCycleImpl;
import com.introvd.template.editor.impl.EditorMainActivityLifeCycleImpl;
import com.introvd.template.editor.impl.EditorUserLifeCycleImpl;
import com.introvd.template.editor.preview.EditorPreviewActivity;
import com.introvd.template.editor.preview.clipsort.ClipSortActivity;
import com.introvd.template.editor.provider.EditorServiceImpl;
import com.introvd.template.editor.todo.EditorTodoInterceptorImpl;
import com.introvd.template.editor.videotrim.VideoTrimActivity;
import com.introvd.template.router.editor.EditorRouter;
import java.util.Map;

public class ARouter$$Group$$XYVideoEditor implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(EditorRouter.EDITOR_CLIP_SORT_URL, RouteMeta.build(C1945a.ACTIVITY, ClipSortActivity.class, "/xyvideoeditor/clipsort", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.COLLAGE_URL, RouteMeta.build(C1945a.ACTIVITY, LocalAlbumActivity.class, "/xyvideoeditor/collagealbum", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.EDITOR_EDIT_LESSON_URL, RouteMeta.build(C1945a.FRAGMENT, EditLessonFragment.class, "/xyvideoeditor/editlesson", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.PROXY_MAIN_APP, RouteMeta.build(C1945a.PROVIDER, EditorApplicationLifeCycleImpl.class, "/xyvideoeditor/editorapplifecycle", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.EDITOR_PREVIEW_URL, RouteMeta.build(C1945a.ACTIVITY, EditorPreviewActivity.class, "/xyvideoeditor/editorpreview", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.EDITOR_SORT_URL, RouteMeta.build(C1945a.ACTIVITY, EditorSortActivity.class, "/xyvideoeditor/editorsort", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.PROXY_USER, RouteMeta.build(C1945a.PROVIDER, EditorUserLifeCycleImpl.class, "/xyvideoeditor/editoruserlifecycle", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.FAST_EDITOR_URL, RouteMeta.build(C1945a.ACTIVITY, FastEditorActivity.class, "/xyvideoeditor/fasteditor", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.PROXY_MAIN_ACTIVITY, RouteMeta.build(C1945a.PROVIDER, EditorMainActivityLifeCycleImpl.class, "/xyvideoeditor/mainactlifecycle", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.EDITOR_PRE_LOAD, RouteMeta.build(C1945a.ACTIVITY, XiaoYingPreLoadActivity.class, "/xyvideoeditor/preload", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.EDITOR_URL, RouteMeta.build(C1945a.ACTIVITY, VideoEditorActivity.class, "/xyvideoeditor/videoeditor", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.EDITOR_VIDEO_TRIM, RouteMeta.build(C1945a.ACTIVITY, VideoTrimActivity.class, "/xyvideoeditor/videotrim", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.BIZ_VIDEO_EXPORT_SERVICE, RouteMeta.build(C1945a.PROVIDER, ExportServiceImpl.class, "/xyvideoeditor/biz_video_export_service", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.EDITOR_SERVICE, RouteMeta.build(C1945a.PROVIDER, EditorServiceImpl.class, "/xyvideoeditor/editor_service", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
        map.put(EditorRouter.EDITOR_TODO_INTERCEPTOR, RouteMeta.build(C1945a.PROVIDER, EditorTodoInterceptorImpl.class, "/xyvideoeditor/todointerceptor", "xyvideoeditor", null, -1, Integer.MIN_VALUE));
    }
}
