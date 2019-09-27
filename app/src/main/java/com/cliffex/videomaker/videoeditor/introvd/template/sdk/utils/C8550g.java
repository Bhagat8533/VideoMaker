package com.introvd.template.sdk.utils;

import android.os.HandlerThread;

/* renamed from: com.introvd.template.sdk.utils.g */
public class C8550g {
    private static HandlerThread cdy;

    /* renamed from: com.introvd.template.sdk.utils.g$a */
    private static class C8551a extends HandlerThread {
        private boolean cdz = false;

        public C8551a(String str, int i) {
            super(str, i);
        }

        public void interrupt() {
        }

        public boolean quit() {
            return false;
        }

        public boolean quitSafely() {
            return false;
        }

        public synchronized void start() {
            if (!this.cdz) {
                super.start();
                this.cdz = true;
            }
        }
    }

    public static synchronized HandlerThread getHandlerThreadFromCommon() {
        HandlerThread handlerThread;
        synchronized (C8550g.class) {
            if (cdy == null) {
                cdy = new C8551a("CommonHandlerThread", 10);
                cdy.start();
            }
            handlerThread = cdy;
        }
        return handlerThread;
    }
}
