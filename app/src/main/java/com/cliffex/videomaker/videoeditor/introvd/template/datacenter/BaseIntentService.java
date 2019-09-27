package com.introvd.template.datacenter;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.introvd.template.datacenter.IService.Stub;
import com.introvd.template.p243e.C5542a;

public class BaseIntentService extends IntentService implements C5542a {
    private Stub mBinder = new Stub() {
        public void registerCallback(IServiceCallback iServiceCallback) {
            synchronized (BaseIntentService.this.mCBSyncObject) {
                if (iServiceCallback != null) {
                    try {
                        BaseIntentService.this.mCallbacks.register(iServiceCallback);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public void unregisterCallback(IServiceCallback iServiceCallback) {
            synchronized (BaseIntentService.this.mCBSyncObject) {
                if (iServiceCallback != null) {
                    try {
                        BaseIntentService.this.mCallbacks.unregister(iServiceCallback);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public Object mCBSyncObject = new Object();
    /* access modifiers changed from: private */
    public RemoteCallbackList<IServiceCallback> mCallbacks = new RemoteCallbackList<>();
    private Handler mHandler = null;
    private HandlerThread mHandlerThread;

    public BaseIntentService(String str) {
        super(str);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void onCreate() {
        super.onCreate();
        SocialProvider.init(this);
        if (this.mHandlerThread == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(".ServiceInternalCB");
            this.mHandlerThread = new HandlerThread(sb.toString(), 10);
            this.mHandlerThread.start();
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        }
    }

    public void onDestroy() {
        if (this.mHandlerThread != null) {
            this.mHandlerThread.quit();
            this.mHandlerThread = null;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        super.onDestroy();
    }

    public void onExecuteServiceNotify(final String str, final int i, final Bundle bundle) {
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    try {
                        int beginBroadcast = BaseIntentService.this.mCallbacks.beginBroadcast();
                        for (int i = 0; i < beginBroadcast; i++) {
                            try {
                                ((IServiceCallback) BaseIntentService.this.mCallbacks.getBroadcastItem(i)).onServiceNotify(str, i, bundle);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                        BaseIntentService.this.mCallbacks.finishBroadcast();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public void onHandleIntent(Intent intent) {
    }
}
