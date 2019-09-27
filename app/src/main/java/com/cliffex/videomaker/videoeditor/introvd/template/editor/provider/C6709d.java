package com.introvd.template.editor.provider;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.provider.d */
public class C6709d {
    private Map<Integer, EditorToolItem> deC = new LinkedHashMap();
    private List<Integer> deF;
    private QStoryboard deJ;
    private Context mContext;

    public C6709d(Context context, QStoryboard qStoryboard, List<Integer> list) {
        this.mContext = context;
        this.deJ = qStoryboard;
        this.deF = list;
        aqz();
        C6707b.m19488b(this.deC, list);
    }

    private void aqz() {
        int j = C8540q.m24958j(this.deJ, 3);
        int j2 = C8540q.m24958j(this.deJ, 20);
        int j3 = C8540q.m24958j(this.deJ, 40);
        int j4 = C8540q.m24958j(this.deJ, 8);
        int j5 = C8540q.m24958j(this.deJ, 6);
        EditorToolItem editorToolItem = new EditorToolItem(2001, R.drawable.editor_icon_effect_collage_tool, this.mContext.getString(R.string.xiaoying_str_com_home_edit_pip), j2 > 0);
        EditorToolItem editorToolItem2 = new EditorToolItem(2006, R.drawable.editor_icon_effect_dubbing_tool, this.mContext.getString(R.string.xiaoying_str_ve_dub_title));
        EditorToolItem editorToolItem3 = new EditorToolItem(2004, R.drawable.editor_icon_effect_fx_tool, this.mContext.getString(R.string.xiaoying_str_ve_animate_frame_title), j5 > 0);
        EditorToolItem editorToolItem4 = new EditorToolItem(2005, R.drawable.editor_icon_effect_music_tool, this.mContext.getString(R.string.xiaoying_str_ve_multi_bgm_title));
        EditorToolItem editorToolItem5 = new EditorToolItem(2003, R.drawable.editor_icon_effect_sticker_tool_icon, this.mContext.getString(R.string.xiaoying_str_editor_sticker_title), j4 > 0);
        EditorToolItem editorToolItem6 = new EditorToolItem(2002, R.drawable.editor_icon_effect_subtitle_tool, this.mContext.getString(R.string.xiaoying_str_ve_subtitle_title), j > 0);
        EditorToolItem editorToolItem7 = new EditorToolItem(EditorModes.EFFECT_MOSAIC_MODE, R.drawable.editor_icon_effect_mosaic_tool, this.mContext.getString(R.string.xiaoying_str_ve_mosaic_title), j3 > 0);
        EditorToolItem editorToolItem8 = new EditorToolItem(2008, R.drawable.editor_icon_effect_watermark_tool, this.mContext.getString(R.string.xiaoying_str_editor_custom_watermark_short));
        this.deC.put(Integer.valueOf(2005), editorToolItem4);
        this.deC.put(Integer.valueOf(2002), editorToolItem6);
        if (C3742b.m9111II().mo23150JR()) {
            this.deC.put(Integer.valueOf(EditorModes.EFFECT_MOSAIC_MODE), editorToolItem7);
        }
        this.deC.put(Integer.valueOf(2003), editorToolItem5);
        this.deC.put(Integer.valueOf(2008), editorToolItem8);
        this.deC.put(Integer.valueOf(2001), editorToolItem);
        this.deC.put(Integer.valueOf(2004), editorToolItem3);
        this.deC.put(Integer.valueOf(2006), editorToolItem2);
    }

    public ArrayList<EditorToolItem> aqA() {
        ArrayList<EditorToolItem> arrayList = new ArrayList<>();
        String aht = C5842b.aht();
        if (!TextUtils.isEmpty(aht)) {
            String[] split = aht.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = C2575a.parseInt(split[i]);
            }
            for (int valueOf : iArr) {
                arrayList.add(this.deC.get(Integer.valueOf(valueOf)));
            }
        } else {
            arrayList.addAll(this.deC.values());
        }
        return arrayList;
    }
}
