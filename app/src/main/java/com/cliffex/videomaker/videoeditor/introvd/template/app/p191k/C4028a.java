package com.introvd.template.app.p191k;

import com.introvd.template.R;
import com.introvd.template.common.model.AppStateModel;

/* renamed from: com.introvd.template.app.k.a */
public class C4028a {
    /* renamed from: hh */
    public static int m9996hh(int i) {
        return i == 1 ? R.string.xiaoying_str_community_setting_about_privacy_terms : i == 2 ? R.string.xiaoying_str_community_setting_about_privacy_terms : i == 3 ? R.string.xiaoying_str_setting_about_privacy_text1 : i == 4 ? R.string.xiaoying_str_setting_about_privacy_text2 : i == 5 ? R.string.xiaoying_str_setting_about_privacy_text3 : R.string.xiaoying_str_community_setting_about_privacy_terms;
    }

    /* renamed from: hi */
    public static String m9997hi(int i) {
        return i == 1 ? "http://www1.xiaoying.tv/userprotocol/userprotocol.html" : i == 2 ? "https://hybrid.xiaoying.tv/web/vivavideo/agreement.html" : i == 3 ? "https://hybrid.xiaoying.tv/web/vivavideo/terms_privacy.html" : i == 4 ? "https://hybrid.xiaoying.tv/web/vivavideo/Copyright_disclaimer.html" : i == 5 ? "https://hybrid.xiaoying.tv/web/vivavideo/community_guidelines.html" : !AppStateModel.getInstance().isInChina() ? "https://hybrid.xiaoying.tv/web/vivavideo/agreement.html" : "http://www1.xiaoying.tv/userprotocol/userprotocol.html";
    }
}
