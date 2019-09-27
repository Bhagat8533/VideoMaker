package com.introvd.template.template.p407e;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.introvd.template.C4677g;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.data.C8657a;
import com.introvd.template.template.data.C8670b;
import com.introvd.template.template.data.api.model.TemplateDownloadInfo;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.download.C8692b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import p469f.C9740h;

/* renamed from: com.introvd.template.template.e.b */
public class C8720b {
    private static Map<String, SoftReference<Bitmap>> esB = Collections.synchronizedMap(new LinkedHashMap<String, SoftReference<Bitmap>>(20, 0.75f, true) {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Entry<String, SoftReference<Bitmap>> entry) {
            return size() > 20;
        }
    });
    private static Map<String, SoftReference<Bitmap>> esC = Collections.synchronizedMap(new LinkedHashMap<String, SoftReference<Bitmap>>(20, 0.75f, true) {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Entry<String, SoftReference<Bitmap>> entry) {
            return size() > 20;
        }
    });
    /* access modifiers changed from: private */
    public C8692b bMP;
    /* access modifiers changed from: private */
    public String ekf = C8399c.edf;
    /* access modifiers changed from: private */
    public C8727c emM;
    private int emQ = 50;
    private Map<String, Integer> esA = new HashMap();
    private int esx = 1;
    private C8725a esy;
    private Map<String, C8726b> esz = new HashMap();
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.template.e.b$a */
    private static class C8725a extends Handler {
        private final WeakReference<C8720b> cuV;

        C8725a(C8720b bVar) {
            super(Looper.getMainLooper());
            this.cuV = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            C8720b bVar = (C8720b) this.cuV.get();
            if (bVar != null) {
                switch (message.what) {
                    case 4097:
                        String string = message.getData().getString("ttid");
                        int i = message.arg1;
                        StringBuilder sb = new StringBuilder();
                        sb.append("MSG_DOWNLOAD_FONT_FILE msgstate=");
                        sb.append(i);
                        sb.append(";progress=");
                        sb.append(message.arg2);
                        sb.append(";templateId=");
                        sb.append(string);
                        LogUtils.m14222e("FontInfoManager", sb.toString());
                        switch (message.arg1) {
                            case 65282:
                                if (bVar.emM != null) {
                                    bVar.m25428X(string, message.arg2);
                                    break;
                                }
                                break;
                            case 65283:
                                String str = (String) message.obj;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("MSG_DOWNLOAD_FONT_FILE destPath=");
                                sb2.append(str);
                                LogUtils.m14222e("FontInfoManager", sb2.toString());
                                if (message.arg2 != 131072) {
                                    bVar.m25439qb(string);
                                    break;
                                } else {
                                    bVar.m25438m(bVar.mContext, bVar.ekf, string, str);
                                    bVar.m25440qc(string);
                                    break;
                                }
                        }
                    case 4098:
                        if (message.arg1 == 65283 && message.arg2 == 131072 && bVar.emM != null) {
                            bVar.emM.adE();
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: com.introvd.template.template.e.b$b */
    public interface C8726b {
        /* renamed from: gi */
        boolean mo27537gi(String str);

        /* renamed from: gj */
        boolean mo27538gj(String str);

        /* renamed from: u */
        boolean mo27539u(String str, int i);
    }

    /* renamed from: com.introvd.template.template.e.b$c */
    public interface C8727c {
        boolean adC();

        boolean adD();

        boolean adE();
    }

    public C8720b(Context context) {
        this.mContext = context;
        this.esy = new C8725a(this);
        this.bMP = new C8692b(context, this.esy);
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public void m25428X(String str, int i) {
        this.esA.put(str, Integer.valueOf(i));
        if (this.esz != null) {
            C8726b bVar = (C8726b) this.esz.get(str);
            if (bVar != null) {
                bVar.mo27539u(str, i);
            }
        }
    }

    /* renamed from: cx */
    private boolean m25436cx(Context context, String str) {
        return this.esA != null && this.esA.containsKey(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean m25438m(Context context, String str, String str2, String str3) {
        TemplateInfo be = C8735f.aMf().mo35144be(str, str2);
        if (be != null) {
            try {
                Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_FONT_INFO);
                ContentResolver contentResolver = context.getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put("tcid", str);
                contentValues.put("ttid", Long.decode(str2));
                contentValues.put("iconurl", be.strIcon);
                contentValues.put(SocialConstDef.TEMPLATEFONTINFO_ITEM_NAME, be.strTitle);
                contentValues.put(SocialConstDef.TEMPLATEFONTINFO_ITEM_LOCALPATH, str3);
                contentResolver.insert(tableUri, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: qb */
    public void m25439qb(String str) {
        this.esA.remove(str);
        if (this.esz != null) {
            C8726b bVar = (C8726b) this.esz.get(str);
            if (bVar != null) {
                bVar.mo27538gj(str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: qc */
    public void m25440qc(String str) {
        this.esA.remove(str);
        if (this.esz != null) {
            C8726b bVar = (C8726b) this.esz.get(str);
            if (bVar != null) {
                bVar.mo27537gi(str);
            }
        }
    }

    /* renamed from: A */
    public Bitmap mo35101A(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String qe = mo35112qe(str);
        if (!FileUtils.isFileExisted(qe)) {
            return null;
        }
        if (z) {
            if (esC.containsKey(str)) {
                SoftReference softReference = (SoftReference) esC.get(str);
                if (!(softReference == null || softReference.get() == null)) {
                    return (Bitmap) softReference.get();
                }
            }
        } else if (esB.containsKey(str)) {
            SoftReference softReference2 = (SoftReference) esB.get(str);
            if (!(softReference2 == null || softReference2.get() == null)) {
                return (Bitmap) softReference2.get();
            }
        }
        int P = C4583d.m11671P(17.0f);
        Bitmap decodeFile = BitmapFactory.decodeFile(qe);
        Bitmap a = C4580b.m11642a(decodeFile, -1, P);
        Bitmap a2 = C4580b.m11642a(decodeFile, -34994, P);
        esB.put(str, new SoftReference(a));
        esC.put(str, new SoftReference(a2));
        return z ? a2 : a;
    }

    /* renamed from: a */
    public void mo35102a(C8727c cVar) {
        this.emM = cVar;
    }

    /* renamed from: a */
    public void mo35103a(String str, C8726b bVar) {
        mo35109pZ(str);
        if (this.esz != null) {
            this.esz.put(str, bVar);
        }
    }

    public void aLV() {
        this.esx = 1;
        C8670b.m25245a(this.ekf, this.emQ, this.esx, 3, 0, "").mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateResponseInfo>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
                if (C8720b.this.emM != null) {
                    C8720b.this.emM.adC();
                }
                try {
                    if ((th instanceof C9740h) && ((C9740h) th).baz().baJ() != null) {
                        UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), C8720b.this.ekf, ((JsonObject) new Gson().fromJson(((C9740h) th).baz().baJ().charStream(), JsonObject.class)).get(IronSourceConstants.EVENTS_ERROR_CODE).getAsInt(), 3, ParametersKeys.FAILED, "tb");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onSuccess(List<TemplateResponseInfo> list) {
                C8720b.this.aLX();
                if (C8720b.this.emM != null) {
                    C8720b.this.emM.adD();
                }
                if (list.size() == 0) {
                    UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), C8720b.this.ekf, -1, 3, "success", "tb");
                }
            }
        });
    }

    public List<TemplateInfo> aLW() {
        C8735f.aMf().mo35147cz(this.mContext, this.ekf);
        List<TemplateInfo> qk = C8735f.aMf().mo35151qk(this.ekf);
        if (qk == null || qk.size() <= 0) {
            return qk;
        }
        ArrayList<TemplateInfo> arrayList = new ArrayList<>(qk);
        for (TemplateInfo templateInfo : arrayList) {
            if (templateInfo != null) {
                if (mo35107cw(this.mContext, templateInfo.ttid)) {
                    templateInfo.nState = 6;
                } else if (m25436cx(this.mContext, templateInfo.ttid)) {
                    templateInfo.nState = 8;
                } else {
                    templateInfo.nState = 1;
                }
            }
        }
        return arrayList;
    }

    public void aLX() {
        List<TemplateInfo> aLW = aLW();
        if (aLW != null && aLW.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(CommonConfigure.APP_DATA_PATH);
            sb.append("xyfonts/.icons/");
            C4677g.m12179cT(sb.toString());
            try {
                for (TemplateInfo templateInfo : aLW) {
                    String qe = mo35112qe(templateInfo.ttid);
                    if (!TextUtils.isEmpty(qe) && !FileUtils.isFileExisted(qe)) {
                        this.bMP.mo35061a(templateInfo.strIcon, qe, 4098, 6, (String) null);
                    }
                }
            } catch (Exception e) {
                C5523b.logException(e);
            }
        }
    }

    /* renamed from: cw */
    public boolean mo35107cw(Context context, String str) {
        TemplateInfo cu = C8657a.m25214cu(context, str);
        if (cu != null) {
            return FileUtils.isFileExisted(cu.strUrl);
        }
        return false;
    }

    /* renamed from: hb */
    public List<TemplateInfo> mo35108hb(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_FONT_INFO), new String[]{"ttid", "iconurl", SocialConstDef.TEMPLATEFONTINFO_ITEM_LOCALPATH}, null, null, "ordernum asc ");
            if (query != null) {
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    do {
                        arrayList.add(C8657a.m25216n(query));
                    } while (query.moveToNext());
                }
                query.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: pZ */
    public void mo35109pZ(String str) {
        if (this.esz != null && this.esz.containsKey(str)) {
            this.esz.remove(str);
        }
    }

    /* renamed from: qa */
    public int mo35110qa(String str) {
        if (this.esA == null || !this.esA.containsKey(str)) {
            return 0;
        }
        return ((Integer) this.esA.get(str)).intValue();
    }

    /* renamed from: qd */
    public boolean mo35111qd(final String str) {
        if (mo35107cw(this.mContext, str)) {
            return false;
        }
        m25428X(str, 0);
        C8670b.m25246bc(str, "327683").mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<TemplateDownloadInfo>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: b */
            public void onSuccess(TemplateDownloadInfo templateDownloadInfo) {
                try {
                    String str = templateDownloadInfo.downloadUrl;
                    String str2 = templateDownloadInfo.templateId;
                    String pe = C8692b.m25319pe(str);
                    String str3 = null;
                    if (pe != null) {
                        str3 = pe.toLowerCase();
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        if (str3.endsWith("ttf") || str3.endsWith("otf")) {
                            C8720b.this.m25428X(str2, 0);
                            StringBuilder sb = new StringBuilder();
                            sb.append(System.currentTimeMillis());
                            sb.append(pe);
                            String sb2 = sb.toString();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(CommonConfigure.APP_DATA_PATH);
                            sb3.append("xyfonts/");
                            String sb4 = sb3.toString();
                            C4677g.m12179cT(sb4);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(sb4);
                            sb5.append(str2);
                            sb5.append(FileUtils.getFileExtFromAbPath(sb2));
                            String sb6 = sb5.toString();
                            Bundle bundle = new Bundle();
                            bundle.putString("ttid", str2);
                            C8720b.this.bMP.mo35062a(str, sb6, 4097, 5, (String) null, bundle);
                            return;
                        }
                    }
                    C8720b.this.m25439qb(str2);
                } catch (Exception e) {
                    e.printStackTrace();
                    C8720b.this.m25439qb(str);
                }
            }

            public void onError(Throwable th) {
                C8720b.this.m25439qb(str);
            }
        });
        return false;
    }

    /* renamed from: qe */
    public String mo35112qe(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DATA_PATH);
        sb.append("xyfonts/.icons/");
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(".png");
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb2);
        sb5.append(sb4);
        return sb5.toString();
    }

    /* renamed from: qf */
    public String mo35113qf(String str) {
        TemplateInfo cu = C8657a.m25214cu(this.mContext, str);
        if (cu != null) {
            return cu.strUrl;
        }
        return null;
    }

    public boolean release() {
        this.esz.clear();
        this.esz = null;
        this.esA.clear();
        if (this.esy != null) {
            this.esy.removeCallbacksAndMessages(null);
            this.esy = null;
        }
        if (esB != null) {
            esB.clear();
        }
        if (esC != null) {
            esC.clear();
        }
        return true;
    }
}
