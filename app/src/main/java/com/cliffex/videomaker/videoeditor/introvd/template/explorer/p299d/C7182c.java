package com.introvd.template.explorer.p299d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.sns.gallery.ISnsGallery;
import com.introvd.template.sns.gallery.SnsGalleryInfoListener;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import com.introvd.template.vivaexplorermodule.R;
import com.quvideo.auth.instagram.sns.C4743c;
import com.xiaoying.p448a.p450b.p451a.C9539a;
import com.xiaoying.p448a.p450b.p451a.C9558f;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.explorer.d.c */
public class C7182c implements ISnsGallery {
    private static final String TAG = "c";
    /* access modifiers changed from: private */
    public SnsGalleryInfoListener dCP;
    private boolean dCZ = true;
    private boolean dDa = true;
    /* access modifiers changed from: private */
    public String dDb;
    /* access modifiers changed from: private */
    public volatile boolean dDe = false;
    /* access modifiers changed from: private */
    public volatile boolean dDf = false;
    /* access modifiers changed from: private */
    public List<MediaGroupItem> dDr = new ArrayList();
    /* access modifiers changed from: private */
    public String dDs = "";
    /* access modifiers changed from: private */
    public MSize dDt;
    /* access modifiers changed from: private */
    public ExecutorService executorService = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public Handler mHandler = new C7186b();

    /* renamed from: com.introvd.template.explorer.d.c$a */
    private class C7184a extends ExAsyncTask<Object, Integer, Integer> {
        private Activity activity;
        private String dDu;

        public C7184a(Activity activity2, String str) {
            this.activity = activity2;
            this.dDu = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Integer doInBackground(Object... objArr) {
            int i;
            C4743c cVar = new C4743c(this.activity);
            StringBuilder sb = new StringBuilder();
            sb.append("https://api.instagram.com/v1/users/self/media/recent?access_token=");
            sb.append(cVar.mo25213Ep());
            String sb2 = sb.toString();
            try {
                if (!TextUtils.isEmpty(C7182c.this.dDs)) {
                    sb2 = C7182c.this.dDs;
                    C7182c.this.dDs = "";
                }
                i = C7182c.this.mo31662a(new URI(sb2), this.dDu);
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            return Integer.valueOf(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public void onPostExecute(Integer num) {
            if (C7182c.this.dCP != null) {
                if (C7182c.this.dDr == null) {
                    C7182c.this.dDr = new ArrayList();
                }
                C7182c.this.dCP.onSyncAlbumsSuccess(C7182c.this.dDr);
                if (C7182c.this.executorService != null) {
                    C7182c.this.executorService.execute(new Runnable() {
                        public void run() {
                            C7157a.m21187g(31, C7182c.this.dDr);
                        }
                    });
                }
            }
            if (TextUtils.isEmpty(C7182c.this.dDs) || C7182c.this.dDe || !C7182c.this.dDf) {
                C7190g.m21248a((Context) this.activity, true, 31, (C7188e) null, true);
                C7182c.this.mHandler.sendMessage(C7182c.this.mHandler.obtainMessage(4098, this.activity));
            } else {
                C7182c.this.getMediaData(this.activity, C7182c.this.dDb, C7182c.this.dDt);
            }
            super.onPostExecute(num);
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
        }
    }

    /* renamed from: com.introvd.template.explorer.d.c$b */
    private static class C7186b extends Handler {
        private C7186b() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 4097:
                    C4586g.m11704a((Context) (Activity) message.obj, R.string.xiaoying_str_com_wait_tip, (OnCancelListener) null, true);
                    return;
                case 4098:
                    Activity activity = (Activity) message.obj;
                    if (activity != null && !activity.isFinishing()) {
                        C4586g.m11696Sm();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public int mo31662a(URI uri, String str) throws JSONException {
        int i = 0;
        C9539a a = C9558f.m27502a(0, uri.toString(), null, 0, 0);
        if (a == null || !a.aRo()) {
            return 0;
        }
        String aRp = a.aRp();
        if (TextUtils.isEmpty(aRp)) {
            return 0;
        }
        Log.i(TAG, aRp);
        JSONObject jSONObject = new JSONObject(aRp);
        this.dDr = C7190g.m21247a(jSONObject.getJSONArray("data"), str, this.dDr, this.dCZ, this.dDa);
        String b = C7190g.m21251b(C7190g.m21252c(jSONObject, "pagination"), "next_url");
        if (!TextUtils.isEmpty(b)) {
            this.dDs = b;
        }
        if (this.dDr != null) {
            i = this.dDr.size();
        }
        return i;
    }

    public void getAlbums(Activity activity, MSize mSize) {
        if (this.dCP != null) {
            this.dCP.onSyncAlbumsSuccess(this.dDr);
        }
    }

    public void getMediaData(Activity activity, String str, MSize mSize) {
        this.dDe = false;
        this.dDb = str;
        this.dDt = mSize;
        if (TextUtils.isEmpty(C7157a.dCF)) {
            C7157a.dCF = new C4743c(activity).getId();
        }
        if (TextUtils.isEmpty(this.dDs)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4097, activity));
        }
        this.dDf = C4600l.m11739k(activity, false);
        if (!this.dDf) {
            ToastUtils.show((Context) activity, R.string.xiaoying_str_com_msg_network_inactive, 1);
        }
        if ((C7190g.m21249ae(activity, 31) || !TextUtils.isEmpty(this.dDs) || this.dDr == null || this.dDr.size() < 1) && this.dDf) {
            if (this.dDr != null && TextUtils.isEmpty(this.dDs)) {
                this.dDr.clear();
            }
            new C7184a(activity, str).execute((Params[]) new Object[]{activity, str});
        } else if (this.dCP != null) {
            if (this.dDr == null || this.dDr.size() < 1) {
                this.dDr = C7157a.m21191qW(31);
            }
            if (this.dDr == null) {
                this.dDr = new ArrayList();
            }
            this.dCP.onSyncAlbumsSuccess(this.dDr);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4098, activity));
        }
    }

    public void setSnsGalleryInfoListener(SnsGalleryInfoListener snsGalleryInfoListener) {
        this.dCP = snsGalleryInfoListener;
    }

    public void stopFectchData() {
        this.dDe = true;
    }

    public void updateShowMode(int i) {
        switch (i) {
            case ISnsGallery.BOTH_MODE /*5632*/:
                this.dCZ = true;
                this.dDa = true;
                return;
            case ISnsGallery.VIDEO_MODE /*5633*/:
                this.dDa = false;
                this.dCZ = true;
                return;
            case ISnsGallery.IMAGE_MODE /*5634*/:
                this.dDa = true;
                this.dCZ = false;
                return;
            default:
                return;
        }
    }
}
