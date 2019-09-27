package com.introvd.template.systemevent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class ScreenLockUnlockMonitor {
    Handler mHandler;

    public class ScreenOnReceiver extends BroadcastReceiver {
        final /* synthetic */ ScreenLockUnlockMonitor ejZ;

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Message obtain = Message.obtain();
            obtain.what = 1001;
            Bundle bundle = new Bundle();
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                bundle.putString("Key_Screen_LockUnlock", "android.intent.action.SCREEN_ON");
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                bundle.putString("Key_Screen_LockUnlock", "android.intent.action.USER_PRESENT");
            } else {
                bundle.putString("Key_Screen_LockUnlock", "android.intent.action.SCREEN_OFF");
            }
            obtain.setData(bundle);
            if (this.ejZ.mHandler != null) {
                this.ejZ.mHandler.sendMessage(obtain);
            }
        }
    }
}
