package com.introvd.template.app.push;

import androidx.work.C1219h.C1220a;
import androidx.work.C1322k;
import androidx.work.Data.C1203a;
import androidx.work.Worker;
import androidx.work.Worker.C1208a;
import com.google.gson.Gson;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;

public class AppQATestWorker extends Worker {
    /* renamed from: b */
    public static void m10165b(TODOParamModel tODOParamModel) {
        LogUtilsV2.m14227d("Jamin Network worker schedule:");
        C1322k os = C1322k.m4389os();
        if (os != null) {
            os.mo9317F("com.introvd.template.app.utils.action.appQATest");
            os.mo9428a(((C1220a) ((C1220a) new C1220a(AppQATestWorker.class).mo9432G("com.introvd.template.app.utils.action.appQATest")).mo9433c(new C1203a().mo9152a("INTENT_DATA_KEY_P1", new Gson().toJson((Object) tODOParamModel)).mo9155oo())).mo9195op());
        }
    }

    /* renamed from: oy */
    public C1208a mo9162oy() {
        BizAppTodoActionManager.getInstance().executeQATestTodo(getApplicationContext(), (TODOParamModel) new Gson().fromJson(mo9161ox().getString("INTENT_DATA_KEY_P1", null), TODOParamModel.class), null);
        return C1208a.SUCCESS;
    }
}
