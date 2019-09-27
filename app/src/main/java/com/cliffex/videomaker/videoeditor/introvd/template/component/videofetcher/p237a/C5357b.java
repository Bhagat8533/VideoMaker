package com.introvd.template.component.videofetcher.p237a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.component.videofetcher.C5355a;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.dao.C5412b;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import com.introvd.template.component.videofetcher.p239c.C5392b;
import com.introvd.template.component.videofetcher.p239c.C5393c;
import com.introvd.template.component.videofetcher.p239c.C5397g;
import com.introvd.template.component.videofetcher.p239c.C5398h;
import com.introvd.template.component.videofetcher.p240d.C5404b;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.component.videofetcher.utils.C5492i;
import com.introvd.template.plugin.downloader.C8251a;
import com.introvd.template.plugin.downloader.entity.C8312a;
import com.introvd.template.plugin.downloader.entity.DownloadStatus;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.C1834l;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.component.videofetcher.a.b */
public class C5357b {
    private static C5357b cjb;
    /* access modifiers changed from: private */
    public Map<String, C1495b> cja = new HashMap();
    private final int cjc = 100;
    private C5397g cjd;

    private C5357b() {
        if (this.cjd == null) {
            synchronized (C5357b.class) {
                if (this.cjd == null) {
                    this.cjd = new C5397g();
                }
            }
        }
    }

    /* renamed from: ZJ */
    public static final C5357b m14586ZJ() {
        if (cjb == null) {
            synchronized (C5357b.class) {
                if (cjb == null) {
                    cjb = new C5357b();
                }
            }
        }
        return cjb;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14592a(DownloadStatus downloadStatus, String str, String str2, String str3) {
        C10021c aZH = C10021c.aZH();
        C5391a aVar = new C5391a(str2, str, downloadStatus.aGl(), 9);
        aZH.mo38493aB(aVar);
        if (downloadStatus.aGl() < 100) {
            C10021c aZH2 = C10021c.aZH();
            StringBuilder sb = new StringBuilder();
            sb.append(C5355a.ciX);
            sb.append(str);
            C5393c cVar = new C5393c(str, str2, sb.toString(), str3, (int) downloadStatus.aGl());
            aZH2.mo38492aA(cVar);
        }
        C10021c.aZH().mo38493aB(new C5392b(str, (int) downloadStatus.aGl(), 0));
        m14593a(str, str2, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14593a(String str, String str2, boolean z) {
        synchronized (C5357b.class) {
            if (this.cjd != null) {
                this.cjd.name = str;
                if (!TextUtils.isEmpty(this.cjd.name) && this.cjd.name.equals(str)) {
                    if (!z && !this.cjd.ckh) {
                        C10021c.aZH().mo38492aA(this.cjd);
                        C5492i.aaE().mo27179aj(str, str2);
                        this.cjd.ckh = true;
                    }
                    if (z) {
                        this.cjd.ckh = false;
                    }
                }
            }
        }
    }

    /* renamed from: au */
    public static void m14594au(Context context, String str) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(new File(str)));
        context.sendBroadcast(intent);
        StringBuilder sb = new StringBuilder();
        sb.append("sendBroadcast--");
        sb.append(str);
        C5489g.m14902d("ruomiz", sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m14595f(Context context, String str, String str2, String str3) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, str2);
            C5402d.m14716ZG().mo27029a(context.getApplicationContext(), str3, hashMap);
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    /* renamed from: k */
    public void m14596k(final String str, String str2, final String str3) {
        C1834l.m5257ah(new C5391a()).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<C5391a>() {
            /* renamed from: a */
            public void accept(C5391a aVar) throws Exception {
                aVar.setName(str);
                aVar.setAddress(str3);
                StringBuilder sb = new StringBuilder();
                sb.append(C5355a.ciX);
                sb.append(str);
                aVar.filePath = sb.toString();
                C5489g.m14902d("ruomiz", "TASKmanager----insertOrReplace-insertOrReplace");
                if (C5412b.m14731ZZ().aaa() != null) {
                    C5412b.m14731ZZ().aaa().mo27039b(aVar);
                }
            }
        }).mo10152c(C1820a.aVi()).mo10128a((C1517e<? super T>) new C1517e<C5391a>() {
            /* renamed from: a */
            public void accept(C5391a aVar) throws Exception {
                C5391a f = C5492i.aaE().mo27180f(aVar);
                C5489g.m14902d("ruomiz", "TASKmanager----updateByName-updateByName");
                if (C5412b.m14731ZZ().aaa() != null) {
                    C5412b.m14731ZZ().aaa().mo27040c(f);
                }
                C10021c.aZH().mo38492aA(new C5398h(str, 5));
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C5489g.m14902d("ruomiz", th.toString());
            }
        });
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    public void mo26925a(Context context, String str, String str2, String str3, String str4, C5404b bVar) {
        final String str5 = str;
        String str6 = str2;
        StringBuilder sb = new StringBuilder();
        sb.append("startdownloadvideoUrl-----");
        sb.append(str2);
        C5489g.m14902d("ruomiz", sb.toString());
        C8251a gI = C8251a.m23820gI(context.getApplicationContext());
        final String str7 = str3;
        gI.mo33410tl(3).mo33411tm(5).mo33409t(str2, str, str7).aTR();
        m14593a(str, str2, false);
        C1834l mE = gI.mo33405mE(str2);
        final String str8 = str2;
        final String str9 = str4;
        final C5404b bVar2 = bVar;
        final Context context2 = context;
        C53581 r0 = new C1517e<C8312a>() {
            /* renamed from: a */
            public void accept(C8312a aVar) throws Exception {
                switch (aVar.getFlag()) {
                    case 9990:
                        C5489g.m14902d("ruomiz", "TASKmanager----NORMAL-NORMAL");
                        C10021c aZH = C10021c.aZH();
                        String str = str5;
                        String str2 = str8;
                        StringBuilder sb = new StringBuilder();
                        sb.append(C5355a.ciX);
                        sb.append(str5);
                        C5393c cVar = new C5393c(str, str2, sb.toString(), str9, 0, 0);
                        aZH.mo38492aA(cVar);
                        C5357b.this.m14593a(str5, str8, false);
                        return;
                    case 9991:
                        C5489g.m14902d("ruomiz", "TASKmanager----WAITING-WAITING");
                        C10021c aZH2 = C10021c.aZH();
                        String str3 = str5;
                        String str4 = str8;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(C5355a.ciX);
                        sb2.append(str5);
                        C5393c cVar2 = new C5393c(str3, str4, sb2.toString(), str9, 0, 0);
                        aZH2.mo38492aA(cVar2);
                        if (bVar2 != null) {
                            bVar2.mo27032a(str8, 9991, 0);
                        }
                        C5357b.this.m14593a(str5, str8, false);
                        return;
                    case 9992:
                        DownloadStatus aGe = aVar.aGe();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("startdownloadSTARTED--");
                        sb3.append(aGe.aGl());
                        C5489g.m14902d("ruomiz", sb3.toString());
                        C5357b.this.m14592a(aGe, str5, str8, str9);
                        if (bVar2 != null) {
                            bVar2.mo27032a(str8, 9992, aGe.aGl());
                            return;
                        }
                        return;
                    case 9994:
                        C5489g.m14904i("ruomiz", "bitmap--下载完成-");
                        String str5 = str5;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(C5355a.ciX);
                        sb4.append(str5);
                        C10021c.aZH().mo38493aB(new C5391a(str5, sb4.toString(), 8));
                        C5357b.this.m14593a(str5, str8, true);
                        C10021c aZH3 = C10021c.aZH();
                        C5391a aVar2 = new C5391a(str8, str5, 100, 9);
                        aZH3.mo38493aB(aVar2);
                        C5489g.m14902d("ruomiz", "TASKmanager----COMPLETED-COMPLETED");
                        if (bVar2 != null) {
                            bVar2.mo27032a(str8, 9994, 200);
                        }
                        Context context = context2;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(C5355a.ciX);
                        sb5.append(str5);
                        C5357b.m14594au(context, sb5.toString());
                        C5357b.this.m14596k(str5, str7, str8);
                        C5357b.this.m14595f(context2, "result", "success", str9);
                        if (C5357b.this.cja != null && C5357b.this.cja.get(str8) != null && !((C1495b) C5357b.this.cja.get(str8)).aAy()) {
                            ((C1495b) C5357b.this.cja.get(str8)).dispose();
                            C5357b.this.cja.remove(str8);
                            return;
                        }
                        return;
                    case 9995:
                        C5489g.m14902d("ruomiz", "TASKmanager----FAILED-FAILED");
                        C10021c aZH4 = C10021c.aZH();
                        String str6 = str5;
                        String str7 = str8;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(C5355a.ciX);
                        sb6.append(str5);
                        C5393c cVar3 = new C5393c(str6, str7, sb6.toString(), str9, 0, 3);
                        aZH4.mo38492aA(cVar3);
                        C5357b.this.m14593a(str5, str8, false);
                        C10021c.aZH().mo38492aA(new C5392b(str5, 0, 3));
                        C5357b.this.m14595f(context2, "result", ParametersKeys.FAILED, str9);
                        C10021c aZH5 = C10021c.aZH();
                        C5391a aVar3 = new C5391a(str8, str5, 200, 6);
                        aZH5.mo38493aB(aVar3);
                        if (bVar2 != null) {
                            bVar2.mo27032a(str8, 9995, 0);
                        }
                        if (C5357b.this.cja != null && C5357b.this.cja.get(str8) != null && !((C1495b) C5357b.this.cja.get(str8)).aAy()) {
                            ((C1495b) C5357b.this.cja.get(str8)).dispose();
                            C5357b.this.cja.remove(str8);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        C1495b a = mE.mo10128a((C1517e<? super T>) r0, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C5489g.m14902d("ruomiz", th.toString());
            }
        });
        if (!this.cja.containsKey(str2)) {
            this.cja.put(str2, a);
        }
    }

    /* renamed from: d */
    public void mo26926d(Context context, String str, String str2, String str3) {
        C8251a.m23820gI(context.getApplicationContext()).mo33410tl(1).mo33407mG(str2).aTR();
        if (!(this.cja == null || this.cja.get(str2) == null || ((C1495b) this.cja.get(str2)).aAy())) {
            ((C1495b) this.cja.get(str2)).dispose();
            this.cja.remove(str2);
        }
        C10021c aZH = C10021c.aZH();
        C5391a aVar = new C5391a(str2, str, 0, 2);
        aZH.mo38493aB(aVar);
        m14595f(context, "result", "cancel", str3);
        StringBuilder sb = new StringBuilder();
        sb.append("deleteDownload----videoUrl--");
        sb.append(str2);
        sb.append("--eventKey--");
        sb.append(str3);
        C5489g.m14902d("ruomiz", sb.toString());
    }

    /* renamed from: e */
    public void mo26927e(Context context, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("restartDwonload----videoUrl--");
        sb.append(str2);
        sb.append("--filePath--");
        sb.append(str3);
        C5489g.m14902d("ruomiz", sb.toString());
        C8251a.m23820gI(context.getApplicationContext()).mo33409t(str2, str, str3).aTR();
    }

    /* renamed from: m */
    public void mo26928m(Context context, String str, String str2) {
        C8251a.m23820gI(context.getApplicationContext()).mo33406mF(str2).aTR();
        StringBuilder sb = new StringBuilder();
        sb.append("stopDownload--");
        sb.append(str2);
        C5489g.m14902d("ruomiz", sb.toString());
    }
}
