package com.introvd.template.common.threadpool;

import com.p085a.p086a.C1863a;
import com.p085a.p086a.C1866b;
import com.p085a.p086a.C1867c;

public class ThreadPoolWrapper {
    private static ThreadPoolWrapper cfA;
    private C1867c cfB = new C1867c();

    private ThreadPoolWrapper() {
        this.cfB.mo10230fE(2);
        this.cfB.mo10231fF(5);
        this.cfB.mo10228a(C1866b.FirstInFistRun);
        this.cfB.mo10227a(C1863a.ThrowExecption);
    }

    public static ThreadPoolWrapper getIns() {
        if (cfA == null) {
            cfA = new ThreadPoolWrapper();
        }
        return cfA;
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            this.cfB.execute(runnable);
        }
    }
}
