package com.introvd.template.p399t;

import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p399t.C8611b.C8614b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.C9796aa;
import okhttp3.C9798ab;
import okhttp3.C9802ac;
import okhttp3.C9804ad;
import okhttp3.C9814e;
import okhttp3.C9822i;
import okhttp3.C9934p;
import okhttp3.C9934p.C9937a;
import okhttp3.C9940r;
import okhttp3.C9947v;
import okhttp3.C9954y;
import org.json.JSONException;
import org.json.JSONObject;
import p468e.C9655c;
import p468e.C9659e;

/* renamed from: com.introvd.template.t.a */
public class C8609a extends C9934p {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final long eBD;
    private long eBE;
    private long eBF;
    private long eBG;
    private String eBH;
    private C9934p eBI;
    private C8614b eBJ;
    private HashMap<String, String> eBK;
    private HashMap<String, String> eBL;
    private int errorCode = 0;
    private int responseCode = 0;

    /* renamed from: com.introvd.template.t.a$a */
    static class C8610a implements C9937a {
        private C8614b eBJ;
        private C9937a eBM;

        C8610a(C9937a aVar, C8614b bVar) {
            this.eBM = aVar;
            this.eBJ = bVar;
        }

        /* renamed from: h */
        public C9934p mo34918h(C9814e eVar) {
            C9934p h = this.eBM != null ? this.eBM.mo34918h(eVar) : null;
            return C8611b.m25145rk(eVar.aVO().aVr().aWl()) ? new C8609a(h, null) : new C8609a(h, this.eBJ);
        }
    }

    C8609a(C9934p pVar, C8614b bVar) {
        this.eBI = pVar;
        this.eBJ = bVar;
        this.eBD = System.nanoTime();
    }

    /* renamed from: a */
    private static String m25117a(C9796aa aaVar) throws Exception {
        C9798ab aWZ = aaVar.aWZ();
        String str = null;
        if (!(aWZ != null)) {
            return null;
        }
        C9655c cVar = new C9655c();
        aWZ.writeTo(cVar);
        Charset charset = UTF8;
        C9947v contentType = aWZ.contentType();
        if (contentType != null) {
            charset = contentType.mo38188b(UTF8);
        }
        if (m25119a(cVar) && charset != null) {
            str = URLDecoder.decode(new String(cVar.mo37335nW(), charset));
        }
        return str;
    }

    /* renamed from: a */
    private String m25118a(C9802ac acVar) throws Exception {
        C9804ad aXh = acVar.aXh();
        if (!(aXh == null || acVar.aTm() == 200)) {
            C9659e source = aXh.source();
            try {
                source.mo37316co(Long.MAX_VALUE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            C9655c aYT = source.aYT();
            Charset charset = UTF8;
            C9947v contentType = aXh.contentType();
            if (contentType != null) {
                charset = contentType.mo38188b(UTF8);
            }
            if (m25119a(aYT) && charset != null) {
                return new String(aYT.clone().mo37335nW(), charset);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m25119a(C9655c cVar) {
        try {
            C9655c cVar2 = new C9655c();
            cVar.mo37288a(cVar2, 0, cVar.size() < 64 ? cVar.size() : 64);
            int i = 0;
            while (true) {
                if (i >= 16) {
                    break;
                } else if (cVar2.aYW()) {
                    break;
                } else {
                    int aZe = cVar2.aZe();
                    if (Character.isISOControl(aZe) && !Character.isWhitespace(aZe)) {
                        return false;
                    }
                    i++;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: bN */
    private long m25120bN(long j) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - j);
    }

    /* renamed from: rj */
    private int m25121rj(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optInt(IronSourceConstants.EVENTS_ERROR_CODE);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /* renamed from: a */
    public void mo34898a(C9814e eVar) {
        if (this.eBI != null) {
            this.eBI.mo34898a(eVar);
        }
    }

    /* renamed from: a */
    public void mo34899a(C9814e eVar, long j) {
        super.mo34899a(eVar, j);
        if (this.eBI != null) {
            this.eBI.mo34899a(eVar, j);
        }
    }

    /* renamed from: a */
    public void mo34900a(C9814e eVar, String str) {
        if (this.eBI != null) {
            this.eBI.mo34900a(eVar, str);
        }
        this.eBE = System.nanoTime();
    }

    /* renamed from: a */
    public void mo34901a(C9814e eVar, String str, List<InetAddress> list) {
        if (this.eBI != null) {
            this.eBI.mo34901a(eVar, str, list);
        }
        if (this.eBE > 0) {
            long bN = m25120bN(this.eBE);
            if (bN < DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS) {
                if (this.eBJ != null) {
                    String aWn = eVar.aVO().aVr().aWn();
                    this.eBK = new HashMap<>();
                    this.eBK.put("path", aWn);
                    this.eBK.put("cost", String.valueOf(bN));
                }
                this.eBE = 0;
            }
        }
    }

    /* renamed from: a */
    public void mo34902a(C9814e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        if (this.eBI != null) {
            this.eBI.mo34902a(eVar, inetSocketAddress, proxy);
        }
        this.eBF = System.nanoTime();
    }

    /* renamed from: a */
    public void mo34903a(C9814e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, C9954y yVar) {
        if (this.eBI != null) {
            this.eBI.mo34903a(eVar, inetSocketAddress, proxy, yVar);
        }
        if (this.eBF > 0) {
            long bN = m25120bN(this.eBF);
            if (bN < DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS && this.eBJ != null) {
                String aWn = eVar.aVO().aVr().aWn();
                this.eBL = new HashMap<>();
                this.eBL.put("path", aWn);
                this.eBL.put("cost", String.valueOf(bN));
            }
        }
    }

    /* renamed from: a */
    public void mo34904a(C9814e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, C9954y yVar, IOException iOException) {
        super.mo34904a(eVar, inetSocketAddress, proxy, yVar, iOException);
        if (this.eBI != null) {
            this.eBI.mo34904a(eVar, inetSocketAddress, proxy, yVar, iOException);
        }
    }

    /* renamed from: a */
    public void mo34905a(C9814e eVar, C9796aa aaVar) {
        super.mo34905a(eVar, aaVar);
        this.eBH = aaVar.mo37748sM("X-Xiaoying-Security-traceid");
        if (this.eBI != null) {
            this.eBI.mo34905a(eVar, aaVar);
        }
    }

    /* renamed from: a */
    public void mo34906a(C9814e eVar, C9822i iVar) {
        if (this.eBI != null) {
            this.eBI.mo34906a(eVar, iVar);
        }
        this.eBG = System.nanoTime();
    }

    /* renamed from: a */
    public void mo34907a(C9814e eVar, C9940r rVar) {
        if (this.eBI != null) {
            this.eBI.mo34907a(eVar, rVar);
        }
    }

    /* renamed from: b */
    public void mo34908b(C9814e eVar) {
        super.mo34908b(eVar);
        if (this.eBI != null) {
            this.eBI.mo34908b(eVar);
        }
    }

    /* renamed from: b */
    public void mo34909b(C9814e eVar, long j) {
        super.mo34909b(eVar, j);
        if (this.eBI != null) {
            this.eBI.mo34899a(eVar, j);
        }
    }

    /* renamed from: b */
    public void mo34910b(C9814e eVar, IOException iOException) {
        super.mo34910b(eVar, iOException);
        if (this.eBI != null) {
            this.eBI.mo34910b(eVar, iOException);
        }
    }

    /* renamed from: b */
    public void mo34911b(C9814e eVar, C9802ac acVar) {
        super.mo34911b(eVar, acVar);
        if (this.eBI != null) {
            this.eBI.mo34911b(eVar, acVar);
        }
        this.responseCode = acVar.aTm();
        try {
            this.errorCode = m25121rj(m25118a(acVar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo34912b(C9814e eVar, C9822i iVar) {
        if (this.eBI != null) {
            this.eBI.mo34912b(eVar, iVar);
        }
        if (this.eBG > 0) {
            long bN = m25120bN(this.eBG);
            if (bN < DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS) {
                if (this.eBJ != null) {
                    String aWn = eVar.aVO().aVr().aWn();
                    HashMap hashMap = new HashMap();
                    hashMap.put("path", aWn);
                    hashMap.put("cost", String.valueOf(bN));
                    if (this.eBH != null) {
                        hashMap.put("X-Xiaoying-Security-traceid", this.eBH);
                    }
                    this.eBJ.mo23416e("dev_api_request", hashMap);
                }
                this.eBG = 0;
            }
        }
    }

    /* renamed from: c */
    public void mo34913c(C9814e eVar) {
        super.mo34913c(eVar);
        if (this.eBI != null) {
            this.eBI.mo34913c(eVar);
        }
    }

    /* renamed from: d */
    public void mo34914d(C9814e eVar) {
        super.mo34914d(eVar);
        if (this.eBI != null) {
            this.eBI.mo34914d(eVar);
        }
    }

    /* renamed from: e */
    public void mo34915e(C9814e eVar) {
        super.mo34915e(eVar);
        if (this.eBI != null) {
            this.eBI.mo34915e(eVar);
        }
    }

    /* renamed from: f */
    public void mo34916f(C9814e eVar) {
        super.mo34916f(eVar);
        if (this.eBI != null) {
            this.eBI.mo34916f(eVar);
        }
    }

    /* renamed from: g */
    public void mo34917g(C9814e eVar) {
        Object obj;
        super.mo34917g(eVar);
        if (this.eBI != null) {
            this.eBI.mo34917g(eVar);
        }
        if (this.eBD > 0) {
            String tVar = eVar.aVO().aVr().toString();
            String aWn = eVar.aVO().aVr().aWn();
            String aTz = eVar.aVO().aTz();
            try {
                obj = m25117a(eVar.aVO());
            } catch (Exception e) {
                e.printStackTrace();
                obj = null;
            }
            long bN = m25120bN(this.eBD);
            if (bN < DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS && this.eBJ != null) {
                if (this.eBK != null) {
                    if (this.eBH != null) {
                        this.eBK.put("X-Xiaoying-Security-traceid", this.eBH);
                    }
                    this.eBJ.mo23416e("dev_api_dns", this.eBK);
                }
                if (this.eBL != null) {
                    if (this.eBH != null) {
                        this.eBL.put("X-Xiaoying-Security-traceid", this.eBH);
                    }
                    this.eBJ.mo23416e("dev_api_connect", this.eBL);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Method", aTz);
                hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_URL, tVar);
                hashMap.put("Param", obj);
                hashMap.put("StatusCode", String.valueOf(this.responseCode));
                hashMap.put("ErrorCode", String.valueOf(this.errorCode));
                hashMap.put("CostMills", String.valueOf(bN));
                hashMap.put("MethodName", aWn);
                if (this.errorCode != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(aWn);
                    sb.append("_");
                    sb.append(this.errorCode);
                    sb.append("");
                    hashMap.put("MethodName_ErrorCode", sb.toString());
                }
                if (this.eBH != null) {
                    hashMap.put("X-Xiaoying-Security-traceid", this.eBH);
                }
                this.eBJ.mo23416e("DEV_Event_API_Analysis", hashMap);
            }
        }
    }
}
