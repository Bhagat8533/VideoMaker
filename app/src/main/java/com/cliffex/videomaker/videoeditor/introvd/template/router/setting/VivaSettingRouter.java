package com.introvd.template.router.setting;

public class VivaSettingRouter {
    public static final String VIVA_SETTING_PREF_FILENAME = "viva_setting";

    public static class SettingLocalLocaleParams {
        public static final String LOCALE_DEFAULT_VALUE = "default";
        public static final String LOCALE_LOCAL_SETTING_URL = "/xysetting/LocalLocaleSet/entry";
        public static final String PREF_KEY_LOCAL_CHOOSED_LANGUAGE = "pref_local_choose_language_key";
        public static final String ROUTER_GROUP = "/xysetting/";
    }

    public class SettingLocaleParams {
        public static final String BUNDLE_DATA_KEY_MODE = "setting_mode";
        public static final String DEFAULT_INDIA_LOCALE_VALUE = "Hindi";
        public static final String LOCALE_4CNT_INDIA_SETTING_URL = "/xysetting/IndiaCntLocaleSet/entry";
        public static final String PREF_KEY_INDIA_CNT_CHOOSED_LANGUAGE = "pref_india_choose_language_key";

        public SettingLocaleParams() {
        }
    }

    public class SettingPrams {
        public static final String BUNDLE_DATA_KEY_GO_FEEDBACK = "key_go_feedback";
        public static final String URL = "/xysetting/SettingActivityV6/entry";

        public SettingPrams() {
        }
    }
}
