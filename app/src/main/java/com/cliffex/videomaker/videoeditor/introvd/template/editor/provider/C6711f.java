package com.introvd.template.editor.provider;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.router.editor.EditorRouter;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.introvd.template.editor.provider.f */
public class C6711f {
    private Map<Integer, EditorToolItem> deC = new LinkedHashMap();
    private Context mContext;

    public C6711f(Context context) {
        this.mContext = context;
        aqz();
    }

    private void aqz() {
        EditorToolItem editorToolItem = new EditorToolItem(1005, R.drawable.editor_icon_speed_tool, this.mContext.getString(R.string.xiaoying_str_ve_basic_more_menu_speed_title));
        EditorToolItem editorToolItem2 = new EditorToolItem(1002, R.drawable.editor_icon_param_adjust_tool, this.mContext.getString(R.string.xiaoying_str_ve_video_param_adjust));
        EditorToolItem editorToolItem3 = new EditorToolItem(1001, R.drawable.editor_icon_filter_tool, this.mContext.getString(R.string.xiaoying_str_ve_effect_title));
        EditorToolItem editorToolItem4 = new EditorToolItem(1004, R.drawable.editor_icon_split_tool, this.mContext.getString(R.string.xiaoying_str_ve_split_clip_title));
        EditorToolItem editorToolItem5 = new EditorToolItem(1003, R.drawable.editor_icon_trim_tool, this.mContext.getString(R.string.xiaoying_str_ve_basic_trim_title));
        EditorToolItem editorToolItem6 = new EditorToolItem(1013, R.drawable.editor_icon_rotate_tool, this.mContext.getString(R.string.xiaoying_str_ve_basic_rotate_title));
        EditorToolItem editorToolItem7 = new EditorToolItem(1006, R.drawable.editor_icon_ratio_tool, this.mContext.getString(R.string.xiaoying_str_ve_edit_ratio_title));
        EditorToolItem editorToolItem8 = new EditorToolItem(2002, R.drawable.editor_icon_effect_subtitle_tool, this.mContext.getString(R.string.xiaoying_str_ve_subtitle_title));
        EditorToolItem editorToolItem9 = new EditorToolItem(2001, R.drawable.editor_icon_effect_collage_tool, this.mContext.getString(R.string.xiaoying_str_com_home_edit_pip));
        EditorToolItem editorToolItem10 = new EditorToolItem(2004, R.drawable.editor_icon_effect_fx_tool, this.mContext.getString(R.string.xiaoying_str_ve_animate_frame_title));
        EditorToolItem editorToolItem11 = new EditorToolItem(2003, R.drawable.editor_icon_effect_sticker_tool_icon, this.mContext.getString(R.string.xiaoying_str_editor_sticker_title));
        this.deC.put(Integer.valueOf(2006), editorToolItem);
        this.deC.put(Integer.valueOf(2005), editorToolItem7);
        this.deC.put(Integer.valueOf(1001), editorToolItem3);
        this.deC.put(Integer.valueOf(1003), editorToolItem5);
        this.deC.put(Integer.valueOf(1004), editorToolItem4);
        this.deC.put(Integer.valueOf(1013), editorToolItem6);
        this.deC.put(Integer.valueOf(1002), editorToolItem2);
        this.deC.put(Integer.valueOf(2002), editorToolItem8);
        this.deC.put(Integer.valueOf(2001), editorToolItem9);
        this.deC.put(Integer.valueOf(2003), editorToolItem11);
        this.deC.put(Integer.valueOf(2004), editorToolItem10);
    }

    public ArrayList<EditorToolItem> aqA() {
        ArrayList<EditorToolItem> arrayList = new ArrayList<>();
        String ahu = C5842b.ahu();
        if (!TextUtils.isEmpty(ahu)) {
            String[] split = ahu.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
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
