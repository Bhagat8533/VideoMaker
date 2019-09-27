package com.introvd.template.editor.todo;

import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.todoCode.TODOParamModel;

/* renamed from: com.introvd.template.editor.todo.b */
public class C6931b {
    /* renamed from: a */
    public static String m20190a(TODOParamModel tODOParamModel, Builder builder, EditorIntentInfo editorIntentInfo) {
        int i = tODOParamModel.mTODOCode;
        if (i == 420) {
            builder.setSourceMode(0);
            editorIntentInfo.baseMode = 0;
            editorIntentInfo.tabType = 1;
            editorIntentInfo.secondaryMode = 1002;
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
        } else if (i == 422) {
            builder.setSourceMode(0);
            editorIntentInfo.baseMode = 0;
            editorIntentInfo.tabType = 1;
            editorIntentInfo.secondaryMode = 1006;
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
        } else if (i == 428) {
            builder.setSourceMode(0);
            editorIntentInfo.baseMode = 0;
            editorIntentInfo.tabType = 1;
            editorIntentInfo.secondaryMode = 1001;
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
        } else if (i == 435) {
            builder.setSourceMode(0);
            editorIntentInfo.baseMode = 0;
            editorIntentInfo.tabType = 1;
            editorIntentInfo.secondaryMode = 1011;
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
        } else if (i != 440) {
            switch (i) {
                case 411:
                    builder.setSourceMode(1);
                    editorIntentInfo.baseMode = 0;
                    editorIntentInfo.tabType = 1;
                    editorIntentInfo.secondaryMode = 1010;
                    editorIntentInfo.paramMap.put(EditorRouter.KEY_PARAMS_CLIP_REVERSE, "trueeer");
                    return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                case 412:
                    builder.setSourceMode(1);
                    editorIntentInfo.baseMode = 0;
                    editorIntentInfo.tabType = 1;
                    editorIntentInfo.secondaryMode = 1016;
                    return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                case 413:
                    builder.setSourceMode(1);
                    editorIntentInfo.baseMode = 0;
                    editorIntentInfo.tabType = 1;
                    editorIntentInfo.secondaryMode = 1004;
                    return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                case 414:
                    builder.setSourceMode(1);
                    editorIntentInfo.baseMode = 0;
                    editorIntentInfo.tabType = 1;
                    editorIntentInfo.secondaryMode = 1005;
                    return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                default:
                    return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
            }
        } else {
            builder.setSourceMode(0);
            editorIntentInfo.baseMode = 0;
            editorIntentInfo.tabType = 1;
            editorIntentInfo.secondaryMode = 1019;
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
        }
    }
}
