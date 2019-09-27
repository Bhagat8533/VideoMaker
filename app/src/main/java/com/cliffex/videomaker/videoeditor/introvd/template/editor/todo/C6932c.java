package com.introvd.template.editor.todo;

import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import org.json.JSONObject;

/* renamed from: com.introvd.template.editor.todo.c */
public class C6932c {
    /* renamed from: a */
    public static String m20191a(TODOParamModel tODOParamModel, Builder builder, EditorIntentInfo editorIntentInfo) {
        int i = tODOParamModel.mTODOCode;
        if (i == 430) {
            builder.setSourceMode(0);
            editorIntentInfo.baseMode = 0;
            editorIntentInfo.tabType = 2;
            editorIntentInfo.secondaryMode = 2003;
            if (tODOParamModel != null) {
                JSONObject jsonObj = tODOParamModel.getJsonObj();
                if (jsonObj != null) {
                    editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_TEMPLATE_ROLL_ID, jsonObj.optString("roll"));
                }
            }
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
        } else if (i == 437) {
            builder.setSourceMode(0);
            editorIntentInfo.baseMode = 0;
            editorIntentInfo.tabType = 2;
            editorIntentInfo.secondaryMode = 2005;
            if (tODOParamModel != null) {
                JSONObject jsonObj2 = tODOParamModel.getJsonObj();
                if (jsonObj2 != null) {
                    editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_TEMPLATE_CATEGORY_ID, jsonObj2.optString("category"));
                }
            }
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
        } else if (i == 439) {
            String str = "0";
            JSONObject jsonObj3 = tODOParamModel.getJsonObj();
            if (jsonObj3 != null) {
                str = jsonObj3.optString("style", "0");
            }
            builder.setSourceMode(0);
            editorIntentInfo.baseMode = 0;
            editorIntentInfo.tabType = 2;
            editorIntentInfo.secondaryMode = EditorModes.EFFECT_MOSAIC_MODE;
            editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAM_MOSAIC_TYPE, str);
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
        } else if (i != 441) {
            switch (i) {
                case 415:
                    builder.setSourceMode(0);
                    editorIntentInfo.baseMode = 0;
                    editorIntentInfo.tabType = 2;
                    editorIntentInfo.secondaryMode = 2002;
                    if (tODOParamModel != null) {
                        JSONObject jsonObj4 = tODOParamModel.getJsonObj();
                        if (jsonObj4 != null) {
                            editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_TEMPLATE_ROLL_ID, jsonObj4.optString("roll"));
                        }
                    }
                    editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_EVENT_ID, String.valueOf(4));
                    return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                case 416:
                    builder.setSourceMode(0);
                    editorIntentInfo.baseMode = 0;
                    editorIntentInfo.tabType = 2;
                    editorIntentInfo.secondaryMode = 2002;
                    editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_EVENT_ID, String.valueOf(3));
                    return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                case 417:
                    builder.setSourceMode(0);
                    editorIntentInfo.baseMode = 0;
                    editorIntentInfo.tabType = 2;
                    editorIntentInfo.secondaryMode = 2002;
                    editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_EVENT_ID, String.valueOf(2));
                    return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                case TodoConstants.TODO_TYPE_EDITOR_DUB_CHOOSE /*418*/:
                    builder.setSourceMode(0);
                    editorIntentInfo.baseMode = 0;
                    editorIntentInfo.tabType = 2;
                    editorIntentInfo.secondaryMode = 2006;
                    editorIntentInfo.paramMap.put(EditorRouter.KEY_PARAMS_DUB_CHOOSE, "dub");
                    if (tODOParamModel != null) {
                        JSONObject jsonObj5 = tODOParamModel.getJsonObj();
                        if (jsonObj5 != null) {
                            editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_TEMPLATE_CATEGORY_ID, jsonObj5.optString("category"));
                        }
                    }
                    return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                default:
                    switch (i) {
                        case TodoConstants.TODO_TYPE_EDITOR_BASIC_COLLAGE /*432*/:
                            builder.setSourceMode(0);
                            editorIntentInfo.baseMode = 0;
                            editorIntentInfo.tabType = 2;
                            editorIntentInfo.secondaryMode = 2001;
                            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                        case TodoConstants.TODO_TYPE_EDITOR_BASIC_FX /*433*/:
                            builder.setSourceMode(0);
                            editorIntentInfo.baseMode = 0;
                            editorIntentInfo.tabType = 2;
                            editorIntentInfo.secondaryMode = 2004;
                            if (tODOParamModel != null) {
                                JSONObject jsonObj6 = tODOParamModel.getJsonObj();
                                if (jsonObj6 != null) {
                                    editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_TEMPLATE_PACKAGE_ID, jsonObj6.optString("package"));
                                }
                            }
                            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                        default:
                            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
                    }
            }
        } else {
            builder.setSourceMode(0);
            editorIntentInfo.baseMode = 0;
            editorIntentInfo.tabType = 2;
            editorIntentInfo.secondaryMode = 2008;
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, builder.build(), editorIntentInfo, tODOParamModel);
        }
    }
}
