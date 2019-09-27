package com.introvd.template.editor.common.p249c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Environment;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.bitmapfun.util.Utils;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.p203b.C4602m;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.download.C8702c;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.download.C8708f;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8743l;
import com.introvd.template.template.p409g.C8762d;
import com.ironsource.environment.ConnectivityService;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.editor.common.c.b */
public class C5845b {
    /* access modifiers changed from: private */
    public static final String TAG = "b";
    /* access modifiers changed from: private */
    public List<TemplateInfo> cEX = new ArrayList();
    /* access modifiers changed from: private */
    public List<TemplateInfo> cEY = new ArrayList();
    private List<TemplateInfo> cEZ = new ArrayList();
    /* access modifiers changed from: private */
    public int cFa = 40;
    /* access modifiers changed from: private */
    public String cFb;
    private C8703d cFc;
    /* access modifiers changed from: private */
    public C1495b cFd;
    /* access modifiers changed from: private */
    public Context context;
    private C8708f csV = new C8702c() {
        /* renamed from: b */
        public void mo24951b(Long l) {
        }

        /* renamed from: c */
        public void mo24952c(long j, int i) {
        }

        /* renamed from: c */
        public void mo24953c(Long l) {
            String access$400 = C5845b.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Download template success ,lTTID：");
            sb.append(l.toString());
            LogUtils.m14222e(access$400, sb.toString());
            C5845b.this.running = false;
            C5845b.this.m16364a(l, true);
        }

        /* renamed from: o */
        public void mo27389o(Long l) {
        }

        /* renamed from: p */
        public void mo27390p(Long l) {
            C5845b.this.running = false;
            C5845b.this.m16364a(l, false);
        }
    };
    /* access modifiers changed from: private */
    public boolean running;

    public C5845b(Context context2, String str) {
        this.context = context2;
        this.cFb = str;
        this.cFc = new C8703d(context2, this.csV);
        C1834l.m5260c(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, TimeUnit.MILLISECONDS).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Long>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                C5845b.this.cFd = bVar;
            }

            /* renamed from: h */
            public void mo9886K(Long l) {
                C5845b.this.cFa = (C5845b.this.ahz() * 2) + 40;
                C5845b.this.resume();
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: a */
    private static TemplateInfo m16359a(List<TemplateInfo> list, long j) {
        if (list != null && list.size() > 0) {
            for (TemplateInfo templateInfo : list) {
                if (templateInfo != null && j == C2575a.m7391rq(templateInfo.ttid)) {
                    return templateInfo;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16364a(Long l, boolean z) {
        C8735f.aMf().mo35153qn(C8450a.m24469bn(l.longValue()));
        if (this.cEY != null) {
            TemplateInfo a = m16359a(this.cEY, l.longValue());
            this.cEY.remove(a);
            if (this.cEZ != null) {
                this.cEZ.add(a);
            }
            C5843c.agO().mo28227b(this.cFb, this.cEZ);
            if (ahx()) {
                release();
            } else if (ahy()) {
                m16373k((TemplateInfo) this.cEY.get(0));
            } else {
                pause();
            }
        }
    }

    private static boolean ahw() {
        boolean z = true;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return true;
        }
        if (Utils.getUsableSpace(Environment.getExternalStorageDirectory()) < 104857600) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public boolean ahx() {
        if (this.cEZ == null || this.cEZ.size() < this.cFa) {
            return this.cEY != null && this.cEY.size() == 0;
        }
        return true;
    }

    private boolean ahy() {
        return ((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    /* access modifiers changed from: private */
    public int ahz() {
        if (ahy()) {
            int rssi = ((WifiManager) this.context.getApplicationContext().getSystemService(ConnectivityService.NETWORK_TYPE_WIFI)).getConnectionInfo().getRssi();
            if (rssi > -50 && rssi < 0) {
                LogUtils.m14222e(TAG, "wifi最强");
                return 4;
            } else if (rssi > -70 && rssi < -50) {
                LogUtils.m14222e(TAG, "wifi较强");
                return 3;
            } else if (rssi > -80 && rssi < -70) {
                LogUtils.m14222e(TAG, "wifi较弱");
                return 2;
            } else if (rssi <= -100 || rssi >= -80) {
                return 0;
            } else {
                LogUtils.m14222e(TAG, "wifi微弱");
                return 1;
            }
        } else {
            LogUtils.m14222e(TAG, "无wifi连接");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gV */
    public List<TemplateInfo> m16372gV(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.equals(C8399c.ecX)) {
            return C8743l.m25551cH(this.context, C8399c.ecX);
        }
        if (str.equals(C8399c.ecY) || str.equals(C8399c.ecZ) || str.equals(C8399c.eda) || str.equals(C8399c.edb) || str.equals(C8399c.edc) || str.equals(C8399c.edd)) {
            return arrayList;
        }
        str.equals(C8399c.ede);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m16373k(TemplateInfo templateInfo) {
        if (this.cFc != null) {
            if (!ahw()) {
                release();
            } else if (C5843c.agO().agP()) {
                pause();
            } else if (AppPreferencesSetting.getInstance().getAppSettingInt(C5527a.cnQ, 1) != 1) {
                pause();
            } else {
                LogUtils.m14222e(TAG, "Execute Single Template Download...");
                this.running = true;
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.mType = "theme";
                effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
                effectInfoModel.setmUrl(templateInfo.strUrl);
                this.cFc.mo35077a(effectInfoModel, "theme");
                C8735f.aMf().mo35136D(templateInfo);
            }
        }
    }

    private void pause() {
        if (this.cFc != null) {
            this.cFc.mo35076VD();
            this.cFc = null;
            C5844a.m16355X(this.context, this.cEZ.size());
        }
    }

    /* access modifiers changed from: private */
    public void resume() {
        if (this.cEX == null || this.cEX.size() <= 0) {
            if (this.cFc == null) {
                this.cFc = new C8703d(this.context, this.csV);
            }
            ahv();
        } else if (!ahx() && ahz() > 0 && !this.running && this.cEY != null && this.cEY.size() > 0) {
            if (this.cFc == null) {
                this.cFc = new C8703d(this.context, this.csV);
            }
            m16373k((TemplateInfo) this.cEY.get(0));
        }
    }

    public void ahv() {
        if (ahy() && !this.running && this.cEZ.size() <= 0) {
            C1834l.m5254a((C1839n<T>) new C1839n<List<TemplateInfo>>() {
                /* renamed from: a */
                public void mo10177a(C1838m<List<TemplateInfo>> mVar) throws Exception {
                    C5845b.this.running = true;
                    mVar.mo9791K(C5845b.this.m16372gV(C5845b.this.cFb));
                }
            }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<List<TemplateInfo>, C1840o<List<TemplateInfo>>>() {
                /* renamed from: aE */
                public C1840o<List<TemplateInfo>> apply(List<TemplateInfo> list) {
                    if (list == null || list.size() == 0) {
                        return C1834l.m5263w(new RuntimeException("data empty,please retry!"));
                    }
                    C8739i.m25524ho(C5845b.this.context);
                    C5845b.this.cEX.clear();
                    for (TemplateInfo templateInfo : list) {
                        long rq = C2575a.m7391rq(templateInfo.ttid);
                        boolean v = C8739i.m25530v(Long.valueOf(rq));
                        boolean bu = C8739i.m25522bu(rq);
                        if (!v && !bu) {
                            C5845b.this.cEX.add(templateInfo);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    if (C5845b.this.cEX != null && C5845b.this.cEX.size() > 0) {
                        C8762d.aMt().mo35219Q(C5845b.this.context, true);
                        for (TemplateInfo templateInfo2 : C5845b.this.cEX) {
                            if (C8762d.aMt().mo35228bE(C2575a.m7391rq(templateInfo2.ttid))) {
                                arrayList.add(templateInfo2);
                            }
                        }
                    }
                    return C1834l.m5257ah(arrayList);
                }
            }).mo10170g((C1518f<? super C1834l<Throwable>, ? extends C1840o<?>>) new C4602m<Object,Object>(10, HttpStatus.SC_INTERNAL_SERVER_ERROR)).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<List<TemplateInfo>, C1840o<Boolean>>() {
                /* renamed from: aE */
                public C1840o<Boolean> apply(List<TemplateInfo> list) {
                    C5845b.this.running = false;
                    if (list == null || list.size() == 0) {
                        return C1834l.m5257ah(Boolean.valueOf(false));
                    }
                    C5845b.this.cEY = list;
                    if (C5845b.this.ahx()) {
                        return C1834l.m5257ah(Boolean.valueOf(false));
                    }
                    C5845b.this.m16373k((TemplateInfo) C5845b.this.cEY.get(0));
                    return C1834l.m5257ah(Boolean.valueOf(true));
                }
            }).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                /* renamed from: b */
                public void mo9886K(Boolean bool) {
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    LogUtils.m14222e(C5845b.TAG, "TemplateSilentCenter task onError:empty data");
                }
            });
        }
    }

    public void release() {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("do release!!!~~~Downloaded List Size:");
        sb.append(this.cEZ.size());
        LogUtils.m14222e(str, sb.toString());
        this.running = false;
        pause();
        if (this.cFd != null && !this.cFd.aAy()) {
            this.cFd.dispose();
        }
    }
}
