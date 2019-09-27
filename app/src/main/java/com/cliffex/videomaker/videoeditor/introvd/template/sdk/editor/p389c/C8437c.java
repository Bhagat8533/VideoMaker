package com.introvd.template.sdk.editor.p389c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.introvd.template.sdk.utils.C8554j;

/* renamed from: com.introvd.template.sdk.editor.c.c */
public class C8437c extends Handler {
    private String eeX = "";
    private C8435a eeY = null;

    public C8437c(String str, C8435a aVar, Looper looper) {
        super(looper);
        this.eeX = str;
        this.eeY = aVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 268443653:
                C8554j.m25010v("ProjectSaveHandler", ">>>>>>>>>>>>>> MSG_PROJECT_SAVE_SUCCEEDED");
                if (this.eeY != null) {
                    this.eeY.mo34199nJ(this.eeX);
                    return;
                }
                return;
            case 268443654:
                C8554j.m25010v("ProjectSaveHandler", ">>>>>>>>>>>>>> MSG_PROJECT_SAVE_FAILED");
                if (this.eeY != null) {
                    this.eeY.mo34200nK(this.eeX);
                    return;
                }
                return;
            case 268443655:
                C8554j.m25007e("ProjectSaveHandler", "NOTICE: >>>>>>>>>>>>>> MSG_PROJECT_SAVE_CANCELED should not happen");
                if (this.eeY != null) {
                    this.eeY.mo34200nK(this.eeX);
                    return;
                }
                return;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("NOTICE: >>>>>>>>>>>>>> MSG_PROJECT_SAVE default msg=");
                sb.append(message.what);
                C8554j.m25007e("ProjectSaveHandler", sb.toString());
                return;
        }
    }
}
