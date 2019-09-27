package com.introvd.template.p379s;

import android.content.Context;
import android.support.p021v4.content.LocalBroadcastManager;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.p362n.C8085a;
import com.xiaoying.p448a.p449a.C9535b;
import com.xiaoying.tool.upload.C9569a;
import com.xiaoying.tool.upload.p458c.C9578b;
import com.xiaoying.tool.upload.p460e.C9589a;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

/* renamed from: com.introvd.template.s.a */
public class C8374a extends ExAsyncTask<Object, Void, Integer> {
    private Context context;
    final LinkedBlockingQueue<Integer> dLO = new LinkedBlockingQueue<>();
    private String ekb;

    public C8374a(Context context2, String str) {
        this.context = context2.getApplicationContext();
        this.ekb = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Integer doInBackground(Object... objArr) {
        String str = objArr[0];
        try {
            JSONObject jSONObject = new JSONObject(objArr[1]);
            int checkRecvFlagAndUploadType = SocialService.checkRecvFlagAndUploadType(jSONObject.optString("c"), jSONObject.optString(C5878a.TAG));
            if (checkRecvFlagAndUploadType != 0) {
                return Integer.valueOf(checkRecvFlagAndUploadType);
            }
            C9578b createUploaderFileEntity = SocialService.createUploaderFileEntity(str, jSONObject, this.ekb);
            C9569a aRv = C9569a.aRv();
            Context context2 = this.context;
            StringBuilder sb = new StringBuilder();
            sb.append("file_");
            sb.append(str);
            aRv.mo37090a(context2, sb.toString(), createUploaderFileEntity, (C9589a) new C8085a(this.dLO));
            int i = 327680;
            try {
                if (((Integer) this.dLO.take()).intValue() == 1) {
                    i = 131072;
                    String optString = jSONObject.optString(C5878a.TAG);
                    LocalBroadcastManager.getInstance(this.context).sendBroadcast(C9535b.m27458B(Integer.parseInt(optString), jSONObject.optString("m")));
                } else {
                    LocalBroadcastManager.getInstance(this.context).sendBroadcast(C9535b.m27459wH(Integer.parseInt(jSONObject.optString(C5878a.TAG))));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Integer.valueOf(i);
        } catch (Exception e2) {
            e2.printStackTrace();
            return Integer.valueOf(65536);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void onPostExecute(Integer num) {
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        try {
            this.dLO.put(Integer.valueOf(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
