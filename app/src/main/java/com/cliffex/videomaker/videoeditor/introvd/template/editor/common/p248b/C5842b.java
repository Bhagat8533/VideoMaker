package com.introvd.template.editor.common.p248b;

import com.introvd.template.common.AppPreferencesSetting;

/* renamed from: com.introvd.template.editor.common.b.b */
public class C5842b extends C5841a {
    private static volatile C5842b cEW;

    private C5842b() {
    }

    public static C5842b aha() {
        if (cEW == null) {
            synchronized (C5842b.class) {
                if (cEW == null) {
                    cEW = new C5842b();
                }
            }
        }
        return cEW;
    }

    public static boolean ahb() {
        return aha().mo28219NS().getBoolean("pref_user_water_mark_show_nickname", false);
    }

    public static void ahc() {
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        if (instance.isContainsKey("pref_user_water_mark_show_nickname").booleanValue()) {
            m16339eS(instance.getAppSettingBoolean("pref_user_water_mark_show_nickname", false));
            instance.removeAppKey("pref_user_water_mark_show_nickname");
        }
        if (instance.isContainsKey("key_editor_clipedit_tool_list_order").booleanValue()) {
            m16341gS(instance.getAppSettingStr("key_editor_clipedit_tool_list_order", ""));
            instance.removeAppKey("key_editor_clipedit_tool_list_order");
        }
        if (instance.isContainsKey("key_editor_effects_tool_list_order").booleanValue()) {
            m16342gT(instance.getAppSettingStr("key_editor_effects_tool_list_order", ""));
            instance.removeAppKey("key_editor_effects_tool_list_order");
        }
        if (instance.isContainsKey("key_editor_gifmaker_tool_list_order").booleanValue()) {
            m16343gU(instance.getAppSettingStr("key_editor_gifmaker_tool_list_order", ""));
            instance.removeAppKey("key_editor_gifmaker_tool_list_order");
        }
    }

    public static void ahd() {
        aha().mo28219NS().setBoolean("KEY_prop_singlehw_v2", true);
    }

    public static boolean ahe() {
        return aha().mo28219NS().getBoolean("KEY_prop_singlehw_v2", false);
    }

    public static void ahf() {
        aha().mo28219NS().setBoolean("KEY_prop_exp_singlehw_v2", true);
    }

    public static boolean ahg() {
        return aha().mo28219NS().getBoolean("KEY_prop_exp_singlehw_v2", false);
    }

    public static boolean ahh() {
        return aha().mo28219NS().getBoolean("key_NewFlag_MagicSound", true);
    }

    public static void ahi() {
        aha().mo28219NS().setBoolean("key_NewFlag_MagicSound", false);
    }

    public static boolean ahj() {
        return aha().mo28219NS().getBoolean("prefer_key_slide_edit_insert_file_tip", false);
    }

    public static void ahk() {
        aha().mo28219NS().setBoolean("key_show_replace_watermark_tip", false);
    }

    public static boolean ahl() {
        return aha().mo28219NS().getBoolean("key_show_replace_watermark_tip", true);
    }

    public static void ahm() {
        aha().mo28219NS().setBoolean("key_add_effect_key_frame", false);
    }

    public static boolean ahn() {
        return aha().mo28219NS().getBoolean("key_add_effect_key_frame", true);
    }

    public static void aho() {
        aha().mo28219NS().setBoolean("key_delete_effect_key_frame", false);
    }

    public static boolean ahp() {
        return aha().mo28219NS().getBoolean("key_delete_effect_key_frame", true);
    }

    public static void ahq() {
        aha().mo28219NS().setBoolean("key_add_more_effect_key_frame", false);
    }

    public static boolean ahr() {
        return aha().mo28219NS().getBoolean("key_add_more_effect_key_frame", true);
    }

    public static String ahs() {
        return aha().mo28219NS().getString("key_editor_clipedit_tool_list_order", "");
    }

    public static String aht() {
        return aha().mo28219NS().getString("key_editor_effects_tool_list_order", "");
    }

    public static String ahu() {
        return aha().mo28219NS().getString("key_editor_gifmaker_tool_list_order", "");
    }

    /* renamed from: eS */
    public static void m16339eS(boolean z) {
        aha().mo28219NS().setBoolean("pref_user_water_mark_show_nickname", z);
    }

    /* renamed from: eT */
    public static void m16340eT(boolean z) {
        aha().mo28219NS().setBoolean("prefer_key_slide_edit_insert_file_tip", z);
    }

    /* renamed from: gS */
    public static void m16341gS(String str) {
        aha().mo28219NS().setString("key_editor_clipedit_tool_list_order", str);
    }

    /* renamed from: gT */
    public static void m16342gT(String str) {
        aha().mo28219NS().setString("key_editor_effects_tool_list_order", str);
    }

    /* renamed from: gU */
    public static void m16343gU(String str) {
        aha().mo28219NS().setString("key_editor_gifmaker_tool_list_order", str);
    }

    /* renamed from: NR */
    public String mo28218NR() {
        return "xy_editor_comSp";
    }
}
