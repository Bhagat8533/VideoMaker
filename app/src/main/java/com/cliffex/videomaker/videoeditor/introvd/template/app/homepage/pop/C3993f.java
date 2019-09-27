package com.introvd.template.app.homepage.pop;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.WindowManager.BadTokenException;
import com.introvd.template.R;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.introduce.C7517a;
import com.introvd.template.introduce.dialog.C7524a;
import com.introvd.template.introduce.dialog.C7524a.C7528a;
import com.introvd.template.introduce.dialog.C7529b;
import com.introvd.template.introduce.dialog.C7529b.C7531a;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.p131c.p132a.C2561a;
import com.quvideo.priority.p217a.C4892c;
import com.quvideo.priority.p217a.C4892c.C4893a;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.homepage.pop.f */
public class C3993f extends C4892c {
    private boolean bsE = true;

    public C3993f(C4893a aVar) {
        super(aVar);
    }

    /* renamed from: KW */
    private void m9876KW() {
        if ("1".equals(C7897a.m23024c("Iap_default_init_home_tab_id", new String[0]))) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("name", "新功能介绍页");
            C8048e.aBe().mo23653g("viva_home_popup_record", hashMap);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(final Activity activity) {
        if (this.bsE || C2561a.aOR() == 4 || C2561a.aOS() || C4560d.m11516RN().isYoungerMode() || !C4023a.m9973MK().mo23673ML() || AppPreferencesSetting.getInstance().getAppSettingBoolean("key_pref_show_feature_introduce", false)) {
            return false;
        }
        AppPreferencesSetting.getInstance().setAppSettingBoolean("key_pref_show_feature_introduce", true);
        C7529b azL = new C7531a().mo32325rL(R.drawable.creation_func_mosaic_logo).mo32322jO(activity.getString(R.string.xiaoying_com_upgrade_mosaic_title)).mo32323jP(activity.getString(R.string.xiaoying_com_upgrade_mosaic_content)).mo32324rK(TodoConstants.TODO_TYPE_EDITOR_MOSAIC).azL();
        C7529b azL2 = new C7531a().mo32325rL(R.drawable.creation_func_magic_sound_logo).mo32322jO(activity.getString(R.string.xiaoying_str_clip_func_magic_sound)).mo32323jP(activity.getString(R.string.xiaoying_str_editor_feature_magic_sound_desc)).mo32324rK(TodoConstants.TODO_TYPE_EDITOR_MAGIC_SOUND).azL();
        C7531a rL = new C7531a().mo32325rL(R.drawable.creation_func_undo_logo);
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getString(R.string.xiaoying_str_editor_undo_title));
        sb.append("/");
        sb.append(activity.getString(R.string.xiaoying_str_editor_redo_title));
        C7529b azL3 = rL.mo32322jO(sb.toString()).mo32323jP(activity.getString(R.string.xiaoying_str_editor_feature_undo_desc)).mo32324rK(-1).azL();
        ArrayList arrayList = new ArrayList();
        arrayList.add(azL);
        arrayList.add(azL2);
        arrayList.add(azL3);
        C7524a azJ = new C7528a(activity, arrayList).mo32316is(false).mo32315b(new C7517a() {
            /* renamed from: gW */
            public void mo23600gW(int i) {
                TODOParamModel tODOParamModel = new TODOParamModel();
                tODOParamModel.mTODOCode = i;
                tODOParamModel.mJsonParam = "";
                BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel);
            }
        }).azJ();
        azJ.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                C3993f.this.mo25344EW();
            }
        });
        try {
            azJ.show();
            m9876KW();
        } catch (BadTokenException unused) {
        }
        return true;
    }
}
