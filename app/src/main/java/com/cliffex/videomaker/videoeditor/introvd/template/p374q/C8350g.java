package com.introvd.template.p374q;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.LogUtils;
import com.introvd.template.datacenter.DownloadService;
import com.introvd.template.datacenter.IService;
import com.introvd.template.datacenter.IServiceCallback.Stub;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.datacenter.TaskService;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.introvd.template.q.g */
public class C8350g {
    /* access modifiers changed from: private */
    public static final String TAG = "g";
    private boolean ejm = false;
    protected Map<String, C8355b> ejn = Collections.synchronizedMap(new LinkedHashMap());
    /* access modifiers changed from: private */
    public Stub ejo = new Stub() {
        public void onServiceNotify(String str, int i, Bundle bundle) {
            Context context = (Context) C8350g.this.mContextRef.get();
            if (context != null && !C8350g.this.ejn.isEmpty()) {
                HashSet hashSet = new HashSet();
                try {
                    hashSet.addAll(C8350g.this.ejn.keySet());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (!hashSet.isEmpty()) {
                    String access$100 = C8350g.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onServiceNotify,key[");
                    sb.append(str);
                    sb.append("],result[");
                    sb.append(i);
                    sb.append(RequestParameters.RIGHT_BRACKETS);
                    LogUtils.m14222e(access$100, sb.toString());
                    Iterator it = hashSet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str2 = (String) it.next();
                        try {
                            C8355b bVar = (C8355b) C8350g.this.ejn.get(str2);
                            if (bVar == null) {
                                C8350g.this.ejn.remove(str2);
                            } else if (bVar.ejk.equals(str)) {
                                bVar.ejl.mo23009a(context, str, i, bundle);
                                break;
                            }
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            C8350g.this.ejn.remove(str2);
                        }
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public IService ejp = null;
    /* access modifiers changed from: private */
    public ServiceConnection ejq = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtils.m14221d(C8350g.TAG, "onServiceConnected");
            C8350g.this.ejp = IService.Stub.asInterface(iBinder);
            try {
                C8350g.this.ejp.registerCallback(C8350g.this.ejo);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.m14221d(C8350g.TAG, "onServiceDisconnected");
            C8350g.this.ejp = null;
        }
    };
    /* access modifiers changed from: private */
    public WeakReference<Context> mContextRef;

    /* renamed from: com.introvd.template.q.g$a */
    public interface C8354a {
        /* renamed from: a */
        void mo23009a(Context context, String str, int i, Bundle bundle);
    }

    /* renamed from: com.introvd.template.q.g$b */
    private static class C8355b {
        /* access modifiers changed from: private */
        public final String ejk;
        /* access modifiers changed from: private */
        public final C8354a ejl;

        public C8355b(String str, C8354a aVar) {
            this.ejk = str;
            this.ejl = aVar;
        }
    }

    public C8350g(Context context, final Class<?> cls) {
        this.mContextRef = new WeakReference<>(context.getApplicationContext());
        if (this.ejp == null) {
            new ExAsyncTask<Void, Void, Integer>() {
                /* access modifiers changed from: protected */
                /* renamed from: c */
                public Integer doInBackground(Void... voidArr) {
                    Intent intent;
                    Context context = (Context) C8350g.this.mContextRef.get();
                    if (context == null) {
                        return Integer.valueOf(-1);
                    }
                    String str = null;
                    if (cls == SocialService.class) {
                        str = SocialServiceDef.ACTION_SOCIAL_SERVICE_VIDEO;
                    } else if (cls == DownloadService.class) {
                        str = SocialServiceDef.ACTION_FILES_DOWNLOAD;
                    } else if (cls == TaskService.class) {
                        str = SocialServiceDef.ACTION_SOCIAL_TASK;
                    }
                    if (str != null) {
                        intent = new Intent(str);
                        intent.setPackage(context.getPackageName());
                    } else {
                        intent = new Intent(context, cls);
                    }
                    try {
                        context.bindService(intent, C8350g.this.ejq, 1);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return Integer.valueOf(0);
                }

                /* access modifiers changed from: protected */
                /* renamed from: l */
                public void onPostExecute(Integer num) {
                    super.onPostExecute(num);
                }
            }.execute((Params[]) new Void[0]);
        }
    }

    /* renamed from: a */
    public synchronized void mo33606a(String str, C8354a aVar) {
        this.ejn.put(str, new C8355b(str, aVar));
    }

    /* renamed from: oT */
    public synchronized void mo33607oT(String str) {
        this.ejn.remove(str);
    }

    public void release() {
        Context context = (Context) this.mContextRef.get();
        if (context != null && this.ejm) {
            context.unbindService(this.ejq);
            this.ejm = false;
        }
    }
}
