package com.introvd.template.editor.provider;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.router.editor.EditorRouter;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.introvd.template.editor.provider.b */
public class C6707b {
    private Map<Integer, EditorToolItem> deC = new LinkedHashMap();
    private List<Integer> deD = new ArrayList();
    private EditorToolItem deE;
    private List<Integer> deF;
    private Context mContext;

    public C6707b(Context context, List<Integer> list) {
        this.mContext = context;
        this.deF = list;
        aqz();
        m19488b(this.deC, this.deF);
    }

    private void aqz() {
        EditorToolItem editorToolItem = new EditorToolItem(1002, R.drawable.editor_icon_param_adjust_tool, this.mContext.getString(R.string.xiaoying_str_ve_video_param_adjust));
        EditorToolItem editorToolItem2 = new EditorToolItem(1001, R.drawable.editor_icon_filter_tool, this.mContext.getString(R.string.xiaoying_str_ve_effect_title));
        EditorToolItem editorToolItem3 = new EditorToolItem(1006, R.drawable.editor_icon_ratio_tool, this.mContext.getString(R.string.xiaoying_str_ve_edit_ratio_title));
        EditorToolItem editorToolItem4 = new EditorToolItem(1011, R.drawable.editor_icon_clip_transition_tool, this.mContext.getString(R.string.xiaoying_str_ve_transition_title));
        EditorToolItem editorToolItem5 = new EditorToolItem(1017, R.drawable.editor_icon_clip_anim_on_tool, this.mContext.getString(R.string.xiaoying_str_ve_edit_pic_anim_title));
        EditorToolItem editorToolItem6 = new EditorToolItem(1004, R.drawable.editor_icon_split_tool, this.mContext.getString(R.string.xiaoying_str_ve_split_clip_title));
        EditorToolItem editorToolItem7 = new EditorToolItem(1019, R.drawable.editor_icon_clip_magic_sound, this.mContext.getString(R.string.xiaoying_str_clip_func_magic_sound));
        String string = this.mContext.getString(R.string.xiaoying_str_ve_basic_trim_title);
        String string2 = this.mContext.getString(R.string.xiaoying_str_ve_img_duration_title);
        int i = R.drawable.editor_icon_trim_tool;
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("(");
        sb.append(string2);
        sb.append(")");
        EditorToolItem editorToolItem8 = new EditorToolItem(1003, i, sb.toString());
        EditorToolItem editorToolItem9 = new EditorToolItem(1005, R.drawable.editor_icon_speed_tool, this.mContext.getString(R.string.xiaoying_str_ve_basic_speed_tool_title));
        EditorToolItem editorToolItem10 = new EditorToolItem(1007, R.drawable.editor_icon_tool_mute_on, this.mContext.getString(R.string.xiaoying_str_ve_basic_mute_title));
        EditorToolItem editorToolItem11 = new EditorToolItem(1009, R.drawable.editor_icon_duplicate_tool, this.mContext.getString(R.string.xiaoying_str_ve_basic_duplicate_title));
        EditorToolItem editorToolItem12 = new EditorToolItem(1010, R.drawable.editor_icon_reverse_tool, this.mContext.getString(R.string.xiaoying_str_ve_basic_more_menu_reverse_title));
        EditorToolItem editorToolItem13 = editorToolItem5;
        EditorToolItem editorToolItem14 = new EditorToolItem(3, R.drawable.editor_icon_sort_tool, this.mContext.getString(R.string.xiaoying_str_edit_preview_sorting));
        EditorToolItem editorToolItem15 = new EditorToolItem(1012, R.drawable.editor_icon_clip_multiselect_tool, this.mContext.getString(R.string.xiaoying_str_ve_storyboard_title_btn_text_multiselect));
        EditorToolItem editorToolItem16 = new EditorToolItem(1013, R.drawable.editor_icon_rotate_tool, this.mContext.getString(R.string.xiaoying_str_ve_basic_rotate_title));
        EditorToolItem editorToolItem17 = editorToolItem4;
        EditorToolItem editorToolItem18 = new EditorToolItem(1018, R.drawable.editor_icon_clip_order_tool, this.mContext.getString(R.string.xiaoying_str_clip_order_title));
        this.deE = new EditorToolItem(1008, R.drawable.editor_icon_clip_delete_tool, this.mContext.getString(R.string.xiaoying_str_com_delete_title));
        this.deC.put(Integer.valueOf(1001), editorToolItem2);
        this.deC.put(Integer.valueOf(1006), editorToolItem3);
        this.deC.put(Integer.valueOf(1003), editorToolItem8);
        this.deC.put(Integer.valueOf(1004), editorToolItem6);
        this.deC.put(Integer.valueOf(1019), editorToolItem7);
        this.deC.put(Integer.valueOf(1009), editorToolItem11);
        this.deC.put(Integer.valueOf(1005), editorToolItem9);
        this.deC.put(Integer.valueOf(1002), editorToolItem);
        this.deC.put(Integer.valueOf(1010), editorToolItem12);
        this.deC.put(Integer.valueOf(1007), editorToolItem10);
        this.deC.put(Integer.valueOf(1013), editorToolItem16);
        this.deC.put(Integer.valueOf(1011), editorToolItem17);
        this.deC.put(Integer.valueOf(1017), editorToolItem13);
        this.deC.put(Integer.valueOf(1012), editorToolItem15);
        this.deC.put(Integer.valueOf(1018), editorToolItem18);
        this.deC.put(Integer.valueOf(3), editorToolItem14);
        this.deD.add(Integer.valueOf(1001));
        this.deD.add(Integer.valueOf(1005));
        this.deD.add(Integer.valueOf(1002));
        this.deD.add(Integer.valueOf(1019));
        this.deD.add(Integer.valueOf(1007));
        this.deD.add(Integer.valueOf(1011));
        this.deD.add(Integer.valueOf(1017));
    }

    /* renamed from: b */
    public static void m19488b(Map<Integer, EditorToolItem> map, List<Integer> list) {
        if (list != null && !list.isEmpty()) {
            Set<Integer> keySet = map.keySet();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (Integer num : keySet) {
                if (!list.contains(num)) {
                    arrayList.add(num);
                }
            }
            for (Integer remove : arrayList) {
                map.remove(remove);
            }
        }
    }

    /* renamed from: gV */
    public ArrayList<EditorToolItem> mo30176gV(boolean z) {
        ArrayList arrayList = new ArrayList();
        String ahs = C5842b.ahs();
        if (!TextUtils.isEmpty(ahs)) {
            String[] split = ahs.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = C2575a.parseInt(split[i]);
            }
            for (int i2 : iArr) {
                if (this.deC.get(Integer.valueOf(i2)) == null) {
                    break;
                }
                arrayList.add(this.deC.get(Integer.valueOf(i2)));
            }
            if (arrayList.size() != iArr.length) {
                arrayList.clear();
                arrayList.addAll(this.deC.values());
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList2 = new ArrayList(this.deC.values());
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                EditorToolItem editorToolItem = (EditorToolItem) arrayList2.get(i3);
                if (!arrayList.contains(editorToolItem)) {
                    hashMap.put(Integer.valueOf(i3), editorToolItem);
                }
            }
            if (!hashMap.isEmpty()) {
                for (Entry entry : hashMap.entrySet()) {
                    arrayList.add(((Integer) entry.getKey()).intValue(), entry.getValue());
                }
            }
        } else {
            arrayList.addAll(this.deC.values());
        }
        if (!z) {
            return arrayList;
        }
        ArrayList<EditorToolItem> arrayList3 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            EditorToolItem editorToolItem2 = (EditorToolItem) it.next();
            if (this.deD.contains(Integer.valueOf(editorToolItem2.mode))) {
                if (editorToolItem2.mode == 1007) {
                    editorToolItem2.coverResID = R.drawable.editor_icon_tool_mute_on;
                } else if (editorToolItem2.mode == 1017) {
                    editorToolItem2.coverResID = R.drawable.editor_icon_clip_anim_on_tool;
                }
                arrayList3.add(editorToolItem2);
            }
        }
        arrayList3.add(this.deE);
        arrayList.clear();
        return arrayList3;
    }
}
