package com.introvd.template.app.p183g;

import android.app.Application;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.apicore.C3630h;
import com.introvd.template.apicore.C3641s;
import com.introvd.template.apicore.C3644v;
import com.introvd.template.apicore.C3646w;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p399t.C8611b.C8613a;
import com.introvd.template.p399t.C8611b.C8614b;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.quvideo.xyvideoplayer.library.C9199e;
import com.quvideo.xyvideoplayer.library.C9199e.C9200a;
import java.util.HashMap;
import java.util.Locale;
import okhttp3.C9951x.C9953a;

/* renamed from: com.introvd.template.app.g.a */
public class C3880a {
    /* renamed from: a */
    public static void m9555a(Application application) {
        C3644v.m8930k(application);
        C3644v.m8927a((C3630h) new C3630h() {
            /* renamed from: GU */
            public String mo22971GU() {
                return UserServiceProxy.getUserId();
            }

            /* renamed from: GV */
            public String mo22972GV() {
                return DeviceUserProxy.getDuid();
            }

            public String getDeviceToken() {
                return DeviceUserProxy.getDeviceToken();
            }

            public String getLanguage() {
                return C4580b.m11644b(Locale.getDefault());
            }

            public String getUserToken() {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo == null) {
                    return null;
                }
                return userInfo.token;
            }
        });
        C3644v.m8929b(new C3641s() {
            /* JADX WARNING: Removed duplicated region for block: B:19:0x00c2  */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo22985a(com.introvd.template.apicore.C3639p r8) {
                /*
                    r7 = this;
                    com.introvd.template.app.b.b r0 = com.introvd.template.app.p177b.C3742b.m9111II()
                    boolean r0 = r0.mo23129IW()
                    if (r0 == 0) goto L_0x0101
                    if (r8 != 0) goto L_0x000e
                    goto L_0x0101
                L_0x000e:
                    java.lang.String r0 = r8.toString()
                    com.introvd.template.common.LogUtilsV2.m14227d(r0)
                    java.lang.String r0 = r8.url
                    java.lang.String r1 = r8.bhD
                    java.lang.String r2 = ""
                    java.net.URI r3 = new java.net.URI     // Catch:{ URISyntaxException -> 0x0055 }
                    r3.<init>(r0)     // Catch:{ URISyntaxException -> 0x0055 }
                    java.lang.String r4 = r3.getQuery()     // Catch:{ URISyntaxException -> 0x0055 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x0053 }
                    r1.<init>()     // Catch:{ URISyntaxException -> 0x0053 }
                    java.lang.String r5 = r3.getScheme()     // Catch:{ URISyntaxException -> 0x0053 }
                    r1.append(r5)     // Catch:{ URISyntaxException -> 0x0053 }
                    java.lang.String r5 = "://"
                    r1.append(r5)     // Catch:{ URISyntaxException -> 0x0053 }
                    java.lang.String r5 = r3.getHost()     // Catch:{ URISyntaxException -> 0x0053 }
                    r1.append(r5)     // Catch:{ URISyntaxException -> 0x0053 }
                    java.lang.String r5 = r3.getPath()     // Catch:{ URISyntaxException -> 0x0053 }
                    r1.append(r5)     // Catch:{ URISyntaxException -> 0x0053 }
                    java.lang.String r1 = r1.toString()     // Catch:{ URISyntaxException -> 0x0053 }
                    java.lang.String r0 = r3.getPath()     // Catch:{ URISyntaxException -> 0x004e }
                    r2 = r0
                    r0 = r1
                    goto L_0x005b
                L_0x004e:
                    r0 = move-exception
                    r6 = r1
                    r1 = r0
                    r0 = r6
                    goto L_0x0058
                L_0x0053:
                    r1 = move-exception
                    goto L_0x0058
                L_0x0055:
                    r3 = move-exception
                    r4 = r1
                    r1 = r3
                L_0x0058:
                    r1.printStackTrace()
                L_0x005b:
                    java.util.HashMap r1 = new java.util.HashMap
                    r1.<init>()
                    java.lang.String r3 = "Method"
                    java.lang.String r5 = r8.method
                    r1.put(r3, r5)
                    java.lang.String r3 = "URL"
                    r1.put(r3, r0)
                    java.lang.String r0 = "Param"
                    r1.put(r0, r4)
                    java.lang.String r0 = "StatusCode"
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    int r4 = r8.statusCode
                    r3.append(r4)
                    java.lang.String r4 = ""
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r1.put(r0, r3)
                    java.lang.String r0 = "ErrorCode"
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    int r4 = r8.errorCode
                    r3.append(r4)
                    java.lang.String r4 = ""
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r1.put(r0, r3)
                    java.lang.String r0 = "CostMills"
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    long r4 = r8.bhE
                    r3.append(r4)
                    java.lang.String r4 = ""
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r1.put(r0, r3)
                    java.lang.String r0 = "MethodName"
                    r1.put(r0, r2)
                    int r0 = r8.errorCode
                    if (r0 == 0) goto L_0x00e2
                    java.lang.String r0 = "MethodName_ErrorCode"
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    r3.append(r2)
                    java.lang.String r4 = "_"
                    r3.append(r4)
                    int r4 = r8.errorCode
                    r3.append(r4)
                    java.lang.String r4 = ""
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r1.put(r0, r3)
                L_0x00e2:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "OkHttpEventListener request["
                    r0.append(r1)
                    r0.append(r2)
                    java.lang.String r1 = " ] cost : "
                    r0.append(r1)
                    long r1 = r8.bhE
                    r0.append(r1)
                    java.lang.String r8 = r0.toString()
                    com.introvd.template.common.LogUtilsV2.m14227d(r8)
                    return
                L_0x0101:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.p183g.C3880a.C38822.mo22985a(com.introvd.template.apicore.p):void");
            }
        });
        C3644v.m8928a(new C8613a().mo34919a(new C8614b() {
            /* renamed from: e */
            public void mo23416e(String str, HashMap<String, String> hashMap) {
                if (C3742b.m9111II().mo23129IW()) {
                    UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), str, hashMap);
                }
            }
        }).mo34920rl(DeviceInfo.getOpenUDID(application.getApplicationContext())));
        C9199e.aOk().mo36275a(new C9200a() {
            /* renamed from: LX */
            public C9953a mo23417LX() {
                return C3646w.m8931Hb();
            }
        });
    }
}
