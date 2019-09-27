package com.introvd.template.template.p407e;

import android.app.Activity;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;

/* renamed from: com.introvd.template.template.e.c */
public class C8728c {
    /* renamed from: a */
    public static void m25457a(Activity activity, String str, Long l, String str2) {
        int i;
        int i2;
        if (C8522g.aJA() != null) {
            long longExtra = activity.getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
            if (C8399c.ecX.equals(str) && QTemplateIDUtils.isPhotoTemplate(l.longValue())) {
                str2 = null;
            }
            GalleryIntentInfo build = new Builder().setSourceMode(0).setAction(3).setNewPrj(true).setMagicCode(longExtra).setStrTCID(str).setTemplateID(l.longValue()).build();
            EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
            editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_EVENT_ID, String.valueOf(1));
            editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_TCID, str);
            editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_TEMPLATE_ID, String.valueOf(l));
            editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_TEMPLATE_PATH, str2);
            editorIntentInfo.baseMode = 0;
            int i3 = 2002;
            if (str.equals(C8399c.ecY)) {
                i2 = 1001;
            } else if (str.equals(C8399c.ecZ)) {
                i2 = 1011;
            } else {
                if (str.equals(C8399c.edf)) {
                    editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_EVENT_ID, String.valueOf(2));
                } else if (!str.equals(C8399c.edb)) {
                    if (str.equals(C8399c.edc)) {
                        i3 = 2005;
                    } else if (str.equals(C8399c.edd)) {
                        i3 = 2004;
                    } else if (str.equals(C8399c.ede)) {
                        i3 = 2003;
                    } else {
                        if (C8399c.ecX.equals(str)) {
                            if (l.longValue() != 0 && C8450a.m24467bl(l.longValue())) {
                                build.setSourceMode(2);
                            }
                            i = 0;
                        } else {
                            i = 1;
                        }
                        i2 = -1;
                        editorIntentInfo.tabType = i;
                        editorIntentInfo.secondaryMode = i2;
                        GalleryRouter.getInstance().launchGalleryActivity(activity, -1, build, editorIntentInfo);
                    }
                }
                i = 2;
                editorIntentInfo.tabType = i;
                editorIntentInfo.secondaryMode = i2;
                GalleryRouter.getInstance().launchGalleryActivity(activity, -1, build, editorIntentInfo);
            }
            i = 1;
            editorIntentInfo.tabType = i;
            editorIntentInfo.secondaryMode = i2;
            GalleryRouter.getInstance().launchGalleryActivity(activity, -1, build, editorIntentInfo);
        }
    }
}
