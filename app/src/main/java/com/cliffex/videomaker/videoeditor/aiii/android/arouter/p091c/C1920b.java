package com.aiii.android.arouter.p091c;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.p021v4.app.ActivityCompat;
import android.widget.Toast;
import com.aiii.android.arouter.core.C1927a;
import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.facade.p095b.C1943a;
import com.aiii.android.arouter.facade.p095b.C1944b;
import com.aiii.android.arouter.facade.service.AutowiredService;
import com.aiii.android.arouter.facade.service.DegradeService;
import com.aiii.android.arouter.facade.service.InterceptorService;
import com.aiii.android.arouter.facade.service.PathReplaceService;
import com.aiii.android.arouter.facade.template.C1948b;
import com.aiii.android.arouter.p090b.C1916a;
import com.aiii.android.arouter.p090b.C1917b;
import com.aiii.android.arouter.p090b.C1918c;
import com.aiii.android.arouter.p092d.C1931b;
import com.aiii.android.arouter.p093e.C1937b;
import com.aiii.android.arouter.p093e.C1940e;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.aiii.android.arouter.c.b */
final class C1920b {
    private static volatile ThreadPoolExecutor asS = C1931b.m5558si();
    private static volatile boolean atB = false;
    static C1948b atC = new C1937b("ARouter::");
    private static volatile boolean atD = false;
    private static volatile boolean atE = false;
    private static volatile boolean atF = false;
    private static volatile C1920b atG = null;
    private static InterceptorService atH;
    private static Context mContext;

    private C1920b() {
    }

    /* renamed from: am */
    private String m5537am(String str) {
        if (C1940e.isEmpty(str) || !str.startsWith("/")) {
            throw new C1916a("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String substring = str.substring(1, str.indexOf("/", 1));
            if (!C1940e.isEmpty(substring)) {
                return substring;
            }
            throw new C1916a("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to extract default group! ");
            sb.append(e.getMessage());
            atC.mo10379j("ARouter::", sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public Object m5538b(Context context, C1941a aVar, int i, C1944b bVar) {
        if (context == null) {
            context = mContext;
        }
        final Context context2 = context;
        switch (aVar.getType()) {
            case ACTIVITY:
                final Intent intent = new Intent(context2, aVar.getDestination());
                intent.putExtras(aVar.getExtras());
                int flags = aVar.getFlags();
                if (-1 != flags) {
                    intent.setFlags(flags);
                } else if (!(context2 instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                Handler handler = new Handler(Looper.getMainLooper());
                final int i2 = i;
                final C1941a aVar2 = aVar;
                final C1944b bVar2 = bVar;
                C19222 r0 = new Runnable() {
                    public void run() {
                        if (i2 > 0) {
                            ActivityCompat.startActivityForResult((Activity) context2, intent, i2, aVar2.mo10407rS());
                        } else {
                            ActivityCompat.startActivity(context2, intent, aVar2.mo10407rS());
                        }
                        if (!(aVar2.mo10408rT() == 0 && aVar2.mo10409rU() == 0) && (context2 instanceof Activity)) {
                            ((Activity) context2).overridePendingTransition(aVar2.mo10408rT(), aVar2.mo10409rU());
                        }
                        if (bVar2 != null) {
                            bVar2.mo10422e(aVar2);
                        }
                    }
                };
                handler.post(r0);
                return null;
            case PROVIDER:
                return aVar.mo10410rV();
            case BOARDCAST:
            case CONTENT_PROVIDER:
            case FRAGMENT:
                try {
                    Object newInstance = aVar.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (newInstance instanceof Fragment) {
                        ((Fragment) newInstance).setArguments(aVar.getExtras());
                    } else if (newInstance instanceof android.support.p021v4.app.Fragment) {
                        ((android.support.p021v4.app.Fragment) newInstance).setArguments(aVar.getExtras());
                    }
                    return newInstance;
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Fetch fragment instance error, ");
                    sb.append(C1940e.m5577a(e.getStackTrace()));
                    atC.mo10380k("ARouter::", sb.toString());
                    break;
                }
        }
        return null;
    }

    /* renamed from: b */
    protected static synchronized boolean m5539b(Application application) {
        synchronized (C1920b.class) {
            mContext = application;
            C1927a.m5553a(mContext, asS);
            atC.mo10378h("ARouter::", "ARouter init success!");
            atB = true;
        }
        return true;
    }

    static void inject(Object obj) {
        AutowiredService autowiredService = (AutowiredService) C1919a.m5529sc().mo10355al("/arouter/service/autowired").mo10412rX();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    /* renamed from: sd */
    static synchronized void m5540sd() {
        synchronized (C1920b.class) {
            atE = true;
            atC.mo10378h("ARouter::", "ARouter openDebug");
        }
    }

    /* renamed from: se */
    static boolean m5541se() {
        return atE;
    }

    /* renamed from: sf */
    static synchronized void m5542sf() {
        synchronized (C1920b.class) {
            atC.mo10376aH(true);
            atC.mo10378h("ARouter::", "ARouter openLog");
        }
    }

    /* renamed from: sg */
    protected static C1920b m5543sg() {
        if (atB) {
            if (atG == null) {
                synchronized (C1920b.class) {
                    if (atG == null) {
                        atG = new C1920b();
                    }
                }
            }
            return atG;
        }
        throw new C1917b("ARouterCore::Init::Invoke init(context) first!");
    }

    /* renamed from: sh */
    static void m5544sh() {
        atH = (InterceptorService) C1919a.m5529sc().mo10355al("/arouter/service/interceptor").mo10412rX();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo10358a(Context context, C1941a aVar, int i, C1944b bVar) {
        try {
            C1927a.m5556b(aVar);
            if (bVar != null) {
                bVar.mo10420c(aVar);
            }
            if (aVar.mo10411rW()) {
                return m5538b(context, aVar, i, bVar);
            }
            InterceptorService interceptorService = atH;
            final Context context2 = context;
            final int i2 = i;
            final C1944b bVar2 = bVar;
            final C1941a aVar2 = aVar;
            C19211 r2 = new C1943a() {
                /* renamed from: a */
                public void mo10362a(C1941a aVar) {
                    C1920b.this.m5538b(context2, aVar, i2, bVar2);
                }

                /* renamed from: d */
                public void mo10363d(Throwable th) {
                    if (bVar2 != null) {
                        bVar2.mo10423f(aVar2);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Navigation failed, termination by interceptor : ");
                    sb.append(th.getMessage());
                    C1920b.atC.mo10378h("ARouter::", sb.toString());
                }
            };
            interceptorService.doInterceptions(aVar, r2);
            return null;
        } catch (C1918c e) {
            atC.mo10379j("ARouter::", e.getMessage());
            if (m5541se()) {
                Context context3 = mContext;
                StringBuilder sb = new StringBuilder();
                sb.append("There's no route matched!\n Path = [");
                sb.append(aVar.getPath());
                sb.append("]\n Group = [");
                sb.append(aVar.getGroup());
                sb.append(RequestParameters.RIGHT_BRACKETS);
                Toast.makeText(context3, sb.toString(), 1).show();
            }
            if (bVar != null) {
                bVar.mo10421d(aVar);
            } else {
                DegradeService degradeService = (DegradeService) C1919a.m5529sc().mo10356i(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, aVar);
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: al */
    public C1941a mo10359al(String str) {
        if (!C1940e.isEmpty(str)) {
            PathReplaceService pathReplaceService = (PathReplaceService) C1919a.m5529sc().mo10356i(PathReplaceService.class);
            if (pathReplaceService != null) {
                str = pathReplaceService.forString(str);
            }
            return mo10361l(str, m5537am(str));
        }
        throw new C1916a("ARouter::Parameter is invalid!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public <T> T mo10360i(Class<? extends T> cls) {
        try {
            C1941a ak = C1927a.m5555ak(cls.getName());
            if (ak == null) {
                ak = C1927a.m5555ak(cls.getSimpleName());
            }
            C1927a.m5556b(ak);
            return ak.mo10410rV();
        } catch (C1918c e) {
            atC.mo10379j("ARouter::", e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public C1941a mo10361l(String str, String str2) {
        if (C1940e.isEmpty(str) || C1940e.isEmpty(str2)) {
            throw new C1916a("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) C1919a.m5529sc().mo10356i(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return new C1941a(str, str2);
    }
}
