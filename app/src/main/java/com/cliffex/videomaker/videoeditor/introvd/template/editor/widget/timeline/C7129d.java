package com.introvd.template.editor.widget.timeline;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.introvd.template.editor.widget.timeline.d */
public class C7129d {
    private static int dvN;
    private static ThreadFactory dvO;
    private static ExecutorService dvP;

    static /* synthetic */ int avH() {
        int i = dvN;
        dvN = i + 1;
        return i;
    }

    public static void destroy() {
        dvN = 0;
        dvO = null;
        if (dvP != null && !dvP.isShutdown()) {
            dvP.shutdown();
            dvP = null;
        }
    }

    /* renamed from: j */
    public static void m21090j(Runnable runnable) {
        if (dvO == null) {
            dvO = new ThreadFactory() {
                public Thread newThread(Runnable runnable) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ThumbN-");
                    sb.append(C7129d.avH());
                    return new Thread(runnable, sb.toString());
                }
            };
        }
        if (dvP == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), dvO);
            dvP = threadPoolExecutor;
        }
        dvP.submit(runnable);
    }
}
