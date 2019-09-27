package com.introvd.template.editor.provider;

import android.content.Context;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.model.EditorToolItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.introvd.template.editor.provider.e */
public class C6710e {
    private Map<Integer, EditorToolItem> deK = new LinkedHashMap();
    private Map<Integer, EditorToolItem> deL = new LinkedHashMap();
    private Context mContext;

    public C6710e(Context context) {
        this.mContext = context;
        aqz();
    }

    private void aqz() {
        EditorToolItem editorToolItem = new EditorToolItem(1001, R.drawable.editor_fast_icon_filter_tool, this.mContext.getString(R.string.xiaoying_str_ve_effect_title));
        EditorToolItem editorToolItem2 = new EditorToolItem(1006, R.drawable.editor_fast_icon_ratio_tool, this.mContext.getString(R.string.xiaoying_str_ve_edit_ratio_title));
        EditorToolItem editorToolItem3 = new EditorToolItem(1005, R.drawable.editor_fast_icon_speed_tool, this.mContext.getString(R.string.xiaoying_str_ve_basic_speed_tool_title));
        EditorToolItem editorToolItem4 = new EditorToolItem(1003, R.drawable.editor_fast_icon_trim_tool, this.mContext.getString(R.string.xiaoying_str_ve_basic_trim_title));
        EditorToolItem editorToolItem5 = new EditorToolItem(2005, R.drawable.editor_fast_icon_effect_music_tool, this.mContext.getString(R.string.xiaoying_str_ve_bgm_title));
        EditorToolItem editorToolItem6 = new EditorToolItem(2003, R.drawable.editor_fast_effect_sticker_tool_icon, this.mContext.getString(R.string.xiaoying_str_editor_sticker_title), false);
        EditorToolItem editorToolItem7 = new EditorToolItem(2002, R.drawable.editor_fast_effect_subtitle_tool_icon, this.mContext.getString(R.string.xiaoying_str_ve_subtitle_title), false);
        this.deK.put(Integer.valueOf(1001), editorToolItem);
        this.deK.put(Integer.valueOf(1006), editorToolItem2);
        this.deK.put(Integer.valueOf(1005), editorToolItem3);
        this.deK.put(Integer.valueOf(1003), editorToolItem4);
        this.deK.put(Integer.valueOf(2005), editorToolItem5);
        this.deL.put(Integer.valueOf(2002), editorToolItem7);
        this.deL.put(Integer.valueOf(2003), editorToolItem6);
    }

    public ArrayList<EditorToolItem> aqA() {
        return new ArrayList<>(this.deK.values());
    }

    public ArrayList<EditorToolItem> aqB() {
        return new ArrayList<>(this.deL.values());
    }
}
