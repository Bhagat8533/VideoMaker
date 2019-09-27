package com.introvd.template.sdk.slide.p392a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.slide.C8467b;
import com.introvd.template.sdk.slide.C8475d;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8565t;
import com.introvd.template.sdk.utils.p393a.C8484b;
import com.introvd.template.sdk.utils.p394b.C8501a;
import xiaoying.engine.base.IQSessionStateListener;
import xiaoying.engine.base.QSessionState;
import xiaoying.engine.slideshowsession.QSlideShowSession;

/* renamed from: com.introvd.template.sdk.slide.a.b */
public class C8461b {
    /* access modifiers changed from: private */
    public static final String TAG = "b";
    private C8501a bOK;
    private IQSessionStateListener efK = new IQSessionStateListener() {
        public int onSessionStatus(QSessionState qSessionState) {
            return 0;
        }
    };
    /* access modifiers changed from: private */
    public C8467b egm = null;
    private C8464b egn;
    private C8463a ego;
    /* access modifiers changed from: private */
    public C8465c egp;
    private Context mContext;
    private HandlerThread mHandlerThread;

    /* renamed from: com.introvd.template.sdk.slide.a.b$a */
    private class C8463a extends C8484b<Void, Void, Boolean> {
        private C8463a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            try {
                C8553i.setContext(C8410e.aGX().getContext());
                C8553i.m25005ut(23);
                return Boolean.valueOf(C8461b.this.aIX() == 0);
            } catch (Throwable th) {
                th.printStackTrace();
                return Boolean.valueOf(false);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                C8565t.show(C8410e.aGX().getContext(), C8410e.aGX().aGW(), 0);
            }
        }
    }

    /* renamed from: com.introvd.template.sdk.slide.a.b$b */
    private static class C8464b extends Handler {
        private C8461b egr = null;

        public C8464b(Looper looper, C8461b bVar) {
            super(looper);
            this.egr = bVar;
        }

        public void handleMessage(Message message) {
            C8461b bVar = this.egr;
            if (bVar != null) {
                C8467b a = bVar.egm;
                switch (message.what) {
                    case 268443649:
                        if (a != null) {
                            boolean z = true;
                            a.setCacheFlag(2, true);
                            if (message.arg1 != 1) {
                                z = false;
                            }
                            a.mo34596jp(z);
                            a.mo34597jq(message.obj == null ? false : ((Boolean) message.obj).booleanValue());
                            C8410e.aGX().aGZ().setBoolean("pref_res_lost_msg_show", false);
                        }
                        if (bVar.egp != null) {
                            bVar.egp.aqF();
                        }
                        C8554j.m25007e(C8461b.TAG, ">>>>>>>>>> MSG_PROJECT_LOAD_SUCCEEDED");
                        break;
                    case 268443650:
                    case 268443651:
                        if (a != null) {
                            a.setCacheFlag(3, false);
                            a.release();
                        }
                        if (bVar.egp != null) {
                            if (message.what == 268443650) {
                                bVar.egp.aqG();
                            } else {
                                bVar.egp.aqH();
                            }
                        }
                        C8554j.m25007e(C8461b.TAG, ">>>>>>>>>>>>>> MSG_PROJECT_LOAD_CANCELED");
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.sdk.slide.a.b$c */
    public interface C8465c {
        void aqF();

        void aqG();

        void aqH();
    }

    public C8461b(C8467b bVar, C8501a aVar, Context context) {
        this.egm = bVar;
        this.bOK = aVar;
        this.mContext = context;
        this.mHandlerThread = new HandlerThread("ProjectLoadUtils", 0);
        this.mHandlerThread.start();
        this.egn = new C8464b(this.mHandlerThread.getLooper(), this);
    }

    /* access modifiers changed from: private */
    public int aIX() {
        String str = this.egm.mProjectDataItem.strPrjURL;
        if (this.egm.dfW != null) {
            this.egm.dfW.unInit();
        }
        this.egm.dfW = new QSlideShowSession();
        if (this.egm.dfW.init(this.bOK.aJv(), this.efK) != 0) {
            if (this.egn != null) {
                this.egn.sendEmptyMessage(268443650);
            }
            this.egm.dfW = null;
            return 3;
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>>>>>>>>>> updateStoryBoard projectPath=");
        sb.append(str);
        C8554j.m25007e(str2, sb.toString());
        C8475d dVar = new C8475d();
        if (dVar.mo34623a(this.mContext, this.egn, this.egm.dfW) != 0) {
            if (this.egn != null) {
                this.egn.sendEmptyMessage(268443650);
            }
            dVar.unInit();
            return 5;
        }
        System.currentTimeMillis();
        if (C8548e.isFileExisted(str)) {
            this.egm.setCacheFlag(1, true);
            int nP = dVar.mo34624nP(str);
            if (!(nP == 0 || this.egn == null)) {
                this.egn.sendEmptyMessage(268443650);
            }
            return nP;
        }
        C8554j.m25007e(TAG, ">>>>>>>>>>>>>> MSG_PROJECT_LOAD_FAILED");
        if (this.egn != null) {
            this.egn.sendEmptyMessage(268443650);
        }
        return 1;
    }

    /* renamed from: a */
    public void mo34591a(C8465c cVar) {
        this.egp = cVar;
    }

    public void aIW() {
        if (this.egm != null) {
            this.ego = new C8463a();
            this.ego.mo34652e(new Void[0]);
        }
    }
}
