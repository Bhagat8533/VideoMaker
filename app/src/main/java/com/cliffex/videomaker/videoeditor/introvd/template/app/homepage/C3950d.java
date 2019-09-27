package com.introvd.template.app.homepage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.aiii.android.arouter.p091c.C1919a;
import com.bumptech.glide.C2176e;
import com.bumptech.glide.load.C2267a;
import com.bumptech.glide.load.p118b.C2396p;
import com.bumptech.glide.p111e.C2202f;
import com.bumptech.glide.p111e.p112a.C2185h;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.banner.BannerInfo;
import com.introvd.template.router.banner.IBannerService;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.homepage.d */
public class C3950d {
    private static C3950d bqK;
    /* access modifiers changed from: private */
    public HashMap<Integer, C3955a> bqL = new HashMap<>();
    private HashMap<Integer, String> bqM = new HashMap<>();
    /* access modifiers changed from: private */
    public BannerInfo bqN;
    /* access modifiers changed from: private */
    public String bqO;
    /* access modifiers changed from: private */
    public boolean bqP;

    /* renamed from: com.introvd.template.app.homepage.d$a */
    private class C3955a {
        public String bqR;
        public String bqS;
        public boolean bqT;
        public boolean bqU;

        /* renamed from: id */
        public int f3382id;
        public String title;

        private C3955a() {
        }
    }

    /* renamed from: com.introvd.template.app.homepage.d$b */
    private class C3956b implements C2202f<File> {
        C3955a bqV;
        boolean bqW;

        C3956b(C3955a aVar, boolean z) {
            this.bqV = aVar;
            this.bqW = z;
        }

        /* renamed from: a */
        public boolean mo11956a(C2396p pVar, Object obj, C2185h<File> hVar, boolean z) {
            return false;
        }

        /* renamed from: a */
        public boolean mo11957a(File file, Object obj, C2185h<File> hVar, C2267a aVar, boolean z) {
            if (this.bqW) {
                this.bqV.bqU = true;
            } else {
                this.bqV.bqT = true;
            }
            return false;
        }
    }

    private C3950d() {
    }

    /* renamed from: Lm */
    public static C3950d m9740Lm() {
        if (bqK == null) {
            bqK = new C3950d();
        }
        return bqK;
    }

    /* renamed from: Lp */
    private void m9741Lp() {
        for (C3955a aVar : this.bqL.values()) {
            if (!aVar.bqT && !TextUtils.isEmpty(aVar.bqR)) {
                m9745a(aVar.bqR, (C2202f<File>) new C3956b<File>(aVar, false));
            }
            if (!aVar.bqU && !TextUtils.isEmpty(aVar.bqS)) {
                m9745a(aVar.bqS, (C2202f<File>) new C3956b<File>(aVar, true));
            }
        }
    }

    /* renamed from: a */
    private void m9745a(String str, C2202f<File> fVar) {
        C2176e.m6137am(VivaBaseApplication.m8749FZ()).mo12207tR().mo12179aO(str).mo12181b(fVar).mo12189tM();
    }

    /* renamed from: Ln */
    public BannerInfo mo23509Ln() {
        return this.bqN;
    }

    /* renamed from: Lo */
    public boolean mo23510Lo() {
        if (this.bqL.isEmpty()) {
            return false;
        }
        if (!TextUtils.isEmpty(this.bqO) && !this.bqP) {
            m9745a(this.bqO, (C2202f<File>) new C2202f<File>() {
                /* renamed from: a */
                public boolean mo11956a(C2396p pVar, Object obj, C2185h<File> hVar, boolean z) {
                    return false;
                }

                /* renamed from: a */
                public boolean mo11957a(File file, Object obj, C2185h<File> hVar, C2267a aVar, boolean z) {
                    C3950d.this.bqP = true;
                    return false;
                }
            });
        }
        for (C3955a aVar : this.bqL.values()) {
            if (aVar.bqU) {
                if (!aVar.bqT) {
                }
            }
            m9741Lp();
            return false;
        }
        return this.bqP;
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: cl */
    public void mo23511cl(Context context) {
        if (context != null) {
            IBannerService iBannerService = (IBannerService) C1919a.m5529sc().mo10356i(IBannerService.class);
            if (iBannerService != null) {
                iBannerService.queryBannerInfo(context.getApplicationContext(), -1).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<List<BannerInfo>>() {
                    /* renamed from: V */
                    public void accept(List<BannerInfo> list) throws Exception {
                        for (BannerInfo bannerInfo : list) {
                            if (bannerInfo.pageType == 6001) {
                                C3950d.this.bqN = bannerInfo;
                            } else if (bannerInfo.pageType == 18006 || bannerInfo.pageType == 18001 || bannerInfo.pageType == 18002 || bannerInfo.pageType == 18003 || bannerInfo.pageType == 18004 || bannerInfo.pageType == 18005) {
                                C3955a aVar = null;
                                if (C3950d.this.bqL.containsKey(Integer.valueOf(bannerInfo.pageType))) {
                                    aVar = (C3955a) C3950d.this.bqL.get(Integer.valueOf(bannerInfo.pageType));
                                } else if (bannerInfo.pageType == 18006) {
                                    C3950d.this.bqO = bannerInfo.strContentUrl;
                                } else {
                                    C3955a aVar2 = new C3955a();
                                    aVar2.bqT = false;
                                    aVar2.bqU = false;
                                    C3950d.this.bqL.put(Integer.valueOf(bannerInfo.pageType), aVar2);
                                    aVar = aVar2;
                                }
                                if (aVar != null) {
                                    if (bannerInfo.orderNum == 0) {
                                        aVar.bqS = bannerInfo.strContentUrl;
                                    } else {
                                        aVar.bqR = bannerInfo.strContentUrl;
                                    }
                                    aVar.f3382id = bannerInfo.f3572id;
                                    aVar.title = bannerInfo.strContentTitle;
                                }
                            }
                        }
                    }
                }).mo10152c(C1487a.aUa()).mo10128a((C1517e<? super T>) new C1517e<List<BannerInfo>>() {
                    /* renamed from: V */
                    public void accept(List<BannerInfo> list) throws Exception {
                        C3950d.this.mo23510Lo();
                    }
                }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
                    /* renamed from: m */
                    public void accept(Throwable th) throws Exception {
                        StringBuilder sb = new StringBuilder();
                        sb.append("--homeIcons--queryBannerInfo--");
                        sb.append(th.toString());
                        LogUtilsV2.m14227d(sb.toString());
                    }
                });
            }
        }
    }

    /* renamed from: gF */
    public String mo23512gF(int i) {
        C3955a aVar = (C3955a) this.bqL.get(Integer.valueOf(i));
        return aVar == null ? "" : aVar.title;
    }

    /* renamed from: gG */
    public int mo23513gG(int i) {
        C3955a aVar = (C3955a) this.bqL.get(Integer.valueOf(i));
        if (aVar == null) {
            return -1;
        }
        return aVar.f3382id;
    }

    /* renamed from: gH */
    public String mo23514gH(int i) {
        return i == 18006 ? this.bqO : (String) this.bqM.get(Integer.valueOf(i));
    }

    /* renamed from: p */
    public String mo23515p(int i, boolean z) {
        C3955a aVar = (C3955a) this.bqL.get(Integer.valueOf(i));
        if (aVar == null) {
            return "";
        }
        return z ? aVar.bqS : aVar.bqR;
    }
}
