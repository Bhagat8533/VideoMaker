package com.introvd.template.explorer.music.online;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.explorer.music.item.C7301c;
import com.introvd.template.explorer.music.p303a.C7256a;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.vivaexplorermodule.R;
import java.util.HashSet;

/* renamed from: com.introvd.template.explorer.music.online.a */
class C7339a {
    private HashSet<String> dCp;

    C7339a() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("editor_music_copy_right_key", null);
        if (!TextUtils.isEmpty(appSettingStr)) {
            this.dCp = (HashSet) new Gson().fromJson(appSettingStr, HashSet.class);
        }
        if (this.dCp == null) {
            this.dCp = new HashSet<>();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo31964a(Context context, C7301c cVar) {
        if (context == null || cVar == null || TextUtils.isEmpty(cVar.getId()) || !cVar.axr() || this.dCp.contains(cVar.getId())) {
            return false;
        }
        this.dCp.add(cVar.getId());
        C8978m.m26349hs(context).mo10296do(R.string.xiaoying_str_music_copy_right_content).mo10300ds(context.getResources().getColor(R.color.color_ff5e13)).mo10299dr(R.string.xiaoying_str_com_ok).mo10313qu().show();
        String json = new Gson().toJson((Object) this.dCp);
        StringBuilder sb = new StringBuilder();
        sb.append("categorySet = ");
        sb.append(json);
        LogUtilsV2.m14227d(sb.toString());
        C7256a.awZ();
        AppPreferencesSetting.getInstance().setAppSettingStr("editor_music_copy_right_key", json);
        return true;
    }
}
