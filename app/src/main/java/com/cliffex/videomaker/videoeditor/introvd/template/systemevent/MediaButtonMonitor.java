package com.introvd.template.systemevent;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import com.introvd.template.router.todoCode.TodoConstants;

public class MediaButtonMonitor {
    Handler mHandler;

    public class MediaButtonEventReceiver extends BroadcastReceiver {
        final /* synthetic */ MediaButtonMonitor ejY;

        public void onReceive(Context context, Intent intent) {
            if (!this.ejY.m25107gY(context)) {
                abortBroadcast();
                boolean z = false;
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    if (intent.getIntExtra("state", 0) == 0) {
                        Message obtain = Message.obtain();
                        obtain.what = TodoConstants.TODO_TYPE_QA_TEST;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("HEADSET_PLUG_Key", null);
                        obtain.setData(bundle);
                        if (this.ejY.mHandler != null) {
                            this.ejY.mHandler.sendMessage(obtain);
                        }
                    }
                } else if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                    KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                    if (keyEvent != null) {
                        if (keyEvent.getAction() == 1) {
                            z = true;
                        }
                        if (!z) {
                            Message obtain2 = Message.obtain();
                            obtain2.what = 10000;
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelable("Media_Buttion_Key", intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
                            obtain2.setData(bundle2);
                            if (this.ejY.mHandler != null) {
                                this.ejY.mHandler.sendMessage(obtain2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gY */
    public boolean m25107gY(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (keyguardManager != null) {
            return keyguardManager.inKeyguardRestrictedInputMode();
        }
        return true;
    }
}
