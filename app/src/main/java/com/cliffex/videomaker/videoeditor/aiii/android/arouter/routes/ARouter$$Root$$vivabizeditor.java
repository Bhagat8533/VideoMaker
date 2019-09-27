package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.template.C1951e;
import com.aiii.android.arouter.facade.template.C1952f;
import com.introvd.template.router.editor.EditorRouter;
import java.util.Map;

public class ARouter$$Root$$vivabizeditor implements C1952f {
    public void loadInto(Map<String, Class<? extends C1951e>> map) {
        map.put("Fuction", ARouter$$Group$$Fuction.class);
        map.put("Funny", ARouter$$Group$$Funny.class);
        map.put("PipEditor", ARouter$$Group$$PipEditor.class);
        map.put("Slide", ARouter$$Group$$Slide.class);
        map.put("Story", ARouter$$Group$$Story.class);
        map.put("VideoEditor", ARouter$$Group$$VideoEditor.class);
        map.put("XYVideoEditor", ARouter$$Group$$XYVideoEditor.class);
        map.put("export", ARouter$$Group$$export.class);
        map.put("gallery", ARouter$$Group$$gallery.class);
        map.put(EditorRouter.ENTRANCE_STUDIO, ARouter$$Group$$studio.class);
    }
}
