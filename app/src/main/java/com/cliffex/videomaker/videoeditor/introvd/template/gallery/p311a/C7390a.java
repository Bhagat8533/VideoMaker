package com.introvd.template.gallery.p311a;

import android.text.TextUtils;
import com.introvd.template.router.app.config.AppConfigObserver;
import com.introvd.template.router.editor.EditorRouter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.gallery.a.a */
public class C7390a extends AppConfigObserver {
    /* renamed from: jK */
    private void m21792jK(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            if (split.length > 1) {
                try {
                    C7391b.dHt = Integer.valueOf(split[0]).intValue();
                    C7391b.dHu = Integer.valueOf(split[1]).intValue();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onChange(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                m21792jK(jSONObject.optString("Gallery_MV_Pic_Count"));
                boolean z = false;
                C7391b.dHv = jSONObject.optInt("Gallery_Thumbnail_Trim_Icon", 0) == 1;
                if (jSONObject.optInt("Gallery_Filter_Refine_Android", 0) == 1) {
                    z = true;
                }
                C7391b.dHw = z;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
