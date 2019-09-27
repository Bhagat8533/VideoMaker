package com.aiii.android.arouter.core;

import android.content.Context;
import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.facade.p095b.C1943a;
import com.aiii.android.arouter.facade.service.InterceptorService;
import com.aiii.android.arouter.facade.template.IInterceptor;
import com.aiii.android.arouter.p090b.C1916a;
import com.aiii.android.arouter.p091c.C1919a;
import com.aiii.android.arouter.p092d.C1930a;
import com.aiii.android.arouter.p093e.C1938c;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

@C1942a(mo10417rZ = "/arouter/service/interceptor")
public class InterceptorServiceImpl implements InterceptorService {
    /* access modifiers changed from: private */
    public static boolean interceptorHasInit;
    /* access modifiers changed from: private */
    public static final Object interceptorInitLock = new Object();

    /* access modifiers changed from: private */
    public static void _excute(final int i, final C1930a aVar, final C1941a aVar2) {
        if (i < C1929b.ata.size()) {
            ((IInterceptor) C1929b.ata.get(i)).process(aVar2, new C1943a() {
                /* renamed from: a */
                public void mo10362a(C1941a aVar) {
                    aVar.countDown();
                    InterceptorServiceImpl._excute(i + 1, aVar, aVar);
                }

                /* renamed from: d */
                public void mo10363d(Throwable th) {
                    aVar2.mo10414s(th == null ? new C1916a("No message.") : th.getMessage());
                    aVar.cancel();
                }
            });
        }
    }

    private static void checkInterceptorsInitStatus() {
        synchronized (interceptorInitLock) {
            while (!interceptorHasInit) {
                try {
                    interceptorInitLock.wait(10000);
                } catch (InterruptedException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ARouter::Interceptor init cost too much time error! reason = [");
                    sb.append(e.getMessage());
                    sb.append(RequestParameters.RIGHT_BRACKETS);
                    throw new C1916a(sb.toString());
                }
            }
        }
    }

    public void doInterceptions(final C1941a aVar, final C1943a aVar2) {
        if (C1929b.ata == null || C1929b.ata.size() <= 0) {
            aVar2.mo10362a(aVar);
        } else {
            checkInterceptorsInitStatus();
            if (!interceptorHasInit) {
                aVar2.mo10363d(new C1916a("Interceptors initialization takes too much time."));
                return;
            }
            C1927a.asS.execute(new Runnable() {
                public void run() {
                    C1930a aVar = new C1930a(C1929b.ata.size());
                    try {
                        InterceptorServiceImpl._excute(0, aVar, aVar);
                        aVar.await((long) aVar.getTimeout(), TimeUnit.SECONDS);
                        if (aVar.getCount() > 0) {
                            aVar2.mo10363d(new C1916a("The interceptor processing timed out."));
                        } else if (aVar.getTag() != null) {
                            aVar2.mo10363d(new C1916a(aVar.getTag().toString()));
                        } else {
                            aVar2.mo10362a(aVar);
                        }
                    } catch (Exception e) {
                        aVar2.mo10363d(e);
                    }
                }
            });
        }
    }

    public void init(final Context context) {
        C1927a.asS.execute(new Runnable() {
            public void run() {
                if (C1938c.m5572b(C1929b.asZ)) {
                    for (Entry value : C1929b.asZ.entrySet()) {
                        Class cls = (Class) value.getValue();
                        try {
                            IInterceptor iInterceptor = (IInterceptor) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                            iInterceptor.init(context);
                            C1929b.ata.add(iInterceptor);
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ARouter::ARouter init interceptor error! name = [");
                            sb.append(cls.getName());
                            sb.append("], reason = [");
                            sb.append(e.getMessage());
                            sb.append(RequestParameters.RIGHT_BRACKETS);
                            throw new C1916a(sb.toString());
                        }
                    }
                    InterceptorServiceImpl.interceptorHasInit = true;
                    C1919a.atC.mo10378h("ARouter::", "ARouter interceptors init over.");
                    synchronized (InterceptorServiceImpl.interceptorInitLock) {
                        InterceptorServiceImpl.interceptorInitLock.notifyAll();
                    }
                }
            }
        });
    }
}
