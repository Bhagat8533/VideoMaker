package com.introvd.template.template.p404d;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.flurry.android.Constants;
import com.introvd.template.C4681i;
import com.introvd.template.common.LogUtils;
import com.introvd.template.datacenter.DownloadService;
import com.introvd.template.datacenter.SocialConstDef;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.template.d.a */
public abstract class C8645a {
    protected static String BASE_URL;
    protected static String elY;
    private static final String[] elZ = {"fixed_height_downsampled", "fixed_width_downsampled", "fixed_height_small", "fixed_width_small", "downsized"};
    private ExecutorService ema = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public long emb;
    private ExecutorService emc = Executors.newSingleThreadExecutor();
    private C8650c emd = null;
    private C8650c eme = null;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.template.d.a$a */
    private class C8647a implements Runnable {
        Context context = null;
        long dCG;
        LinkedBlockingQueue<Integer> dCI = new LinkedBlockingQueue<>();
        C8653d emi;
        C8652c emj;
        Handler handler;

        C8647a(Context context2, C8653d dVar, C8652c cVar, Handler handler2) {
            this.context = context2;
            this.emi = dVar;
            this.emj = cVar;
            C8645a.this.mContext = context2;
            this.handler = handler2;
        }

        public void run() {
            if (this.context != null && !TextUtils.isEmpty(this.emi.emn)) {
                String ps = C8645a.m25199ps(this.emi.emo);
                this.dCG = DownloadService.enqueue(this.context, this.emi.emn, ps, 0, 6);
                C86481 r1 = new ContentObserver(this.handler) {
                    public void onChange(boolean z) {
                        int downloadState = DownloadService.getDownloadState(C8647a.this.context, C8647a.this.dCG);
                        if (downloadState == 196608) {
                            int downloadProgress = DownloadService.getDownloadProgress(C8647a.this.context, C8647a.this.dCG);
                            if (C8647a.this.emj != null) {
                                C8647a.this.emj.mo30969q(downloadProgress, C8647a.this.emi.emo);
                            }
                        } else if (downloadState != 0) {
                            C8647a.this.dCI.add(Integer.valueOf(DownloadService.getDownloadProgress(C8647a.this.context, C8647a.this.dCG) == 100 ? 131072 : 65536));
                        }
                    }
                };
                ContentResolver contentResolver = this.context.getContentResolver();
                contentResolver.registerContentObserver(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_DOWNLOAD), true, r1);
                if (this.dCG > 0) {
                    DownloadService.startDownload(this.context, this.dCG);
                    C8645a.this.emb = this.dCG;
                    if (this.emj != null) {
                        this.emj.onStart();
                    }
                }
                try {
                    this.dCI.take();
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    contentResolver.unregisterContentObserver(r1);
                    throw th;
                }
                contentResolver.unregisterContentObserver(r1);
                int downloadState = DownloadService.getDownloadState(this.context, this.dCG);
                if (downloadState == 131072) {
                    if (this.emj != null) {
                        this.emj.mo30967iV(ps);
                    }
                } else if (downloadState == 65536 && this.emj != null) {
                    this.emj.auK();
                }
            }
        }
    }

    /* renamed from: com.introvd.template.template.d.a$b */
    private class C8649b {
        List<C8653d> eml;
        C8650c emm;

        private C8649b() {
        }

        public void onDestroy() {
            this.eml = null;
            this.emm = null;
        }
    }

    /* renamed from: com.introvd.template.template.d.a$c */
    private class C8650c {
        int count;
        int offset;
        int totalCount;

        private C8650c() {
            this.totalCount = 0;
            this.offset = 0;
            this.count = 0;
        }

        /* renamed from: a */
        public void mo34954a(C8650c cVar) {
            if (cVar != null) {
                this.totalCount = cVar.totalCount;
                this.offset = cVar.offset;
                this.count = cVar.count;
            }
        }
    }

    protected C8645a() {
    }

    /* renamed from: R */
    private String m25187R(String str, int i) {
        StringBuilder sb = new StringBuilder(BASE_URL);
        if (str == null) {
            sb.append("/trending?");
        } else {
            sb.append("/search?");
            sb.append("q=");
            sb.append(m25196pp(str));
            sb.append(RequestParameters.AMPERSAND);
        }
        sb.append("rating=g&limit=");
        sb.append(30);
        sb.append("&offset=");
        sb.append(i);
        sb.append(RequestParameters.AMPERSAND);
        sb.append("api_key=2n3t62Ve10zZu");
        Locale locale = C4681i.m12184Gp().mo25017Gs().getResources().getConfiguration().locale;
        sb.append(RequestParameters.AMPERSAND);
        sb.append("lang=");
        sb.append(aKA());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append("");
        LogUtils.m14223i("gif time0-1-1", sb2.toString());
        LogUtils.m14222e("gif url", sb.toString());
        return sb.toString();
    }

    /* renamed from: a */
    private List<C8653d> m25191a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i).optJSONObject("images");
            C8653d dVar = null;
            for (String optJSONObject2 : elZ) {
                C8653d t = m25201t(optJSONObject.optJSONObject(optJSONObject2));
                if (t != null) {
                    if (t.height > t.width) {
                        t.emp = Math.abs(t.height - 480);
                    } else {
                        t.emp = Math.abs(t.width - 480);
                    }
                    if (dVar == null || dVar.emp > t.emp) {
                        dVar = t;
                    }
                }
            }
            if (dVar != null) {
                C8653d t2 = m25201t(optJSONObject.optJSONObject("fixed_width_still"));
                dVar.emo = t2.emn;
                dVar.height = t2.height;
                dVar.width = t2.width;
            }
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m25192a(final String str, final C8651b bVar, final C8650c cVar) {
        this.emc.execute(new Runnable() {
            public void run() {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                sb.append("");
                LogUtils.m14223i("gif time0-2-1", sb.toString());
                C8649b a = C8645a.this.m25197pq(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                sb2.append("");
                LogUtils.m14223i("gif time0-2-2", sb2.toString());
                if (bVar == null) {
                    return;
                }
                if (a == null || cVar == null) {
                    Log.e("", "");
                    return;
                }
                cVar.mo34954a(a.emm);
                cVar.offset += 30;
                bVar.mo27627aG(a.eml);
                a.onDestroy();
            }
        });
    }

    private String aKA() {
        return C4681i.m12184Gp().mo25017Gs().getResources().getConfiguration().locale.toString().replace("_", "-");
    }

    /* renamed from: dI */
    private static String m25193dI(String str) {
        try {
            return new URI(str).getPath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: fl */
    private static byte[] m25194fl(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (instance == null) {
                return str.getBytes(Charset.forName("UTF-8"));
            }
            instance.update(str.getBytes(Charset.forName("UTF-8")));
            return instance.digest();
        } catch (NoSuchAlgorithmException unused) {
            return str.getBytes(Charset.forName("UTF-8"));
        }
    }

    /* renamed from: l */
    public static List<C8653d> m25195l(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr == null) {
            return arrayList;
        }
        for (String str : strArr) {
            C8653d dVar = new C8653d();
            dVar.emn = str;
            dVar.emo = str;
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* renamed from: pp */
    private String m25196pp(String str) {
        return Pattern.compile("[' ']+").matcher(str.trim()).replaceAll("+");
    }

    /* access modifiers changed from: private */
    /* renamed from: pq */
    public C8649b m25197pq(String str) {
        try {
            String entityUtils = EntityUtils.toString(new DefaultHttpClient().execute(new HttpGet(str)).getEntity(), "UTF-8");
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append("");
            LogUtils.m14223i("gif time0-2-1-1", sb.toString());
            C8649b pr = m25198pr(entityUtils);
            String str2 = "gif time0-2-1-2";
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                sb2.append("");
                LogUtils.m14223i(str2, sb2.toString());
                return pr;
            } catch (Exception unused) {
                return pr;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: pr */
    private C8649b m25198pr(String str) {
        C8649b bVar = new C8649b();
        String str2 = "gif time0-2-1-2-1";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append("");
            LogUtils.m14223i(str2, sb.toString());
            JSONObject jSONObject = new JSONObject(str);
            bVar.eml = m25191a(jSONObject.optJSONArray("data"));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            sb2.append("");
            LogUtils.m14223i("gif time0-2-1-2-2", sb2.toString());
            bVar.emm = m25202u(jSONObject.optJSONObject("pagination"));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(System.currentTimeMillis());
            sb3.append("");
            LogUtils.m14223i("gif time0-2-1-2-3", sb3.toString());
        } catch (JSONException unused) {
        }
        return bVar;
    }

    /* renamed from: ps */
    public static String m25199ps(String str) {
        String dI = m25193dI(str);
        if (TextUtils.isEmpty(dI)) {
            dI = String.valueOf(System.currentTimeMillis());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(elY);
        sb.append(File.separator);
        sb.append(toHexString(m25194fl(dI), ""));
        sb.append(".gif");
        return sb.toString();
    }

    /* renamed from: pt */
    public static boolean m25200pt(String str) {
        return "Giphy".equals(str);
    }

    /* renamed from: t */
    private C8653d m25201t(JSONObject jSONObject) {
        C8653d dVar = new C8653d();
        dVar.height = jSONObject.optInt("height");
        dVar.width = jSONObject.optInt("width");
        dVar.emn = jSONObject.optString("url");
        return dVar;
    }

    private static String toHexString(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString(b & Constants.UNKNOWN));
            sb.append(str);
        }
        return sb.toString();
    }

    /* renamed from: u */
    private C8650c m25202u(JSONObject jSONObject) {
        C8650c cVar = new C8650c();
        cVar.count = jSONObject.optInt(SocialConstDef.SEARCH_HISTORY_COUNT);
        cVar.totalCount = jSONObject.optInt("total_count");
        cVar.offset = jSONObject.optInt("offset");
        return cVar;
    }

    /* renamed from: a */
    public void mo34945a(Context context, C8653d dVar, C8652c cVar, Handler handler) {
        if (this.ema.isTerminated() || this.ema.isShutdown()) {
            this.ema = Executors.newSingleThreadExecutor();
        }
        ExecutorService executorService = this.ema;
        C8647a aVar = new C8647a(context, dVar, cVar, handler);
        executorService.execute(aVar);
    }

    /* renamed from: a */
    public void mo34946a(C8651b bVar) {
        int i;
        if (this.eme != null) {
            i = this.eme.offset;
        } else {
            this.eme = new C8650c();
            i = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("");
        LogUtils.m14223i("gif time0-1", sb.toString());
        String R = m25187R(null, i);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        sb2.append("");
        LogUtils.m14223i("gif time0-2", sb2.toString());
        m25192a(R, bVar, this.eme);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(System.currentTimeMillis());
        sb3.append("");
        LogUtils.m14223i("gif time0-3", sb3.toString());
    }

    /* renamed from: a */
    public void mo34947a(String str, C8651b bVar) {
        int i;
        if (this.emd != null) {
            i = this.emd.offset;
        } else {
            this.emd = new C8650c();
            i = 0;
        }
        m25192a(m25187R(str, i), bVar, this.emd);
    }

    public void aKB() {
        this.emd = null;
    }

    public void aKC() {
        this.eme = null;
    }
}
