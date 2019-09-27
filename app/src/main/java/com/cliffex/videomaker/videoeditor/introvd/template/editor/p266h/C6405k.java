package com.introvd.template.editor.p266h;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.sdk.p384d.C8404c;

/* renamed from: com.introvd.template.editor.h.k */
public class C6405k extends ExAsyncTask<Object, Void, String> {
    private Context context;

    public C6405k(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Object... objArr) {
        Process.setThreadPriority(0);
        return C8404c.aHI();
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
            if (iAppService != null) {
                iAppService.showNotification(this.context, 4099, str);
            }
        }
        super.onPostExecute(str);
    }
}
