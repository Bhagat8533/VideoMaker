package com.introvd.template.template.download;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.introvd.template.C4677g;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.Utils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.datacenter.TaskService;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.data.C8657a;
import com.introvd.template.template.data.C8670b;
import com.introvd.template.template.data.api.model.TemplateDownloadInfo;
import com.introvd.template.template.data.api.model.TemplateResponseRoll.ImageInfo;
import com.introvd.template.template.data.api.model.TemplateResponseRoll.ImageSimpleInfoItem;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8762d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;

/* renamed from: com.introvd.template.template.download.b */
public class C8692b extends C8691a {
    /* access modifiers changed from: private */
    public static final String TAG = "b";
    private Map<String, C8698a> elh = Collections.synchronizedMap(new LinkedHashMap());
    /* access modifiers changed from: private */
    public Handler eli = null;
    /* access modifiers changed from: private */
    public boolean elj = false;
    List<C8701c> elk = Collections.synchronizedList(new ArrayList());
    private HandlerThread mHandlerThread;

    /* renamed from: com.introvd.template.template.download.b$a */
    public static class C8698a {
        public C8699b elu = null;
        public boolean elv = false;
        public long elw;
        public int elx;
        public String ely;
    }

    /* renamed from: com.introvd.template.template.download.b$b */
    private static class C8699b extends ExAsyncTask<Object, Integer, String> {
        /* access modifiers changed from: private */
        public LinkedBlockingQueue<Integer> dCI = new LinkedBlockingQueue<>();
        /* access modifiers changed from: private */
        public Context elA = null;
        private int elB = 0;
        private C8692b elC;
        private int elD = 0;
        private String elE = null;
        private Bundle elF = null;
        private String elG = null;
        private final Handler elH;
        /* access modifiers changed from: private */
        public boolean elI = false;
        /* access modifiers changed from: private */
        public Map<Long, Integer> elJ = Collections.synchronizedMap(new LinkedHashMap());
        /* access modifiers changed from: private */
        public long elz = 0;
        private Handler mHandler = null;

        public C8699b(C8692b bVar, Context context, Handler handler, Handler handler2, int i, int i2, String str, Bundle bundle) {
            this.elA = context.getApplicationContext();
            this.mHandler = handler;
            this.elB = i;
            this.elC = bVar;
            this.elD = i2;
            this.elE = str;
            this.elF = bundle;
            this.elH = handler2;
        }

        /* renamed from: P */
        private void m25334P(String str, int i) {
            Message obtainMessage = this.mHandler.obtainMessage(this.elB, 65283, i, str);
            obtainMessage.setData(this.elF);
            m25342k(obtainMessage);
            if (this.elG != null) {
                this.elC.mo35065jm(this.elG);
            }
            if (this.elD == 4 && i == 131072) {
                Object obj = this.elF.get("ttid");
                if (obj != null) {
                    String bn = obj instanceof Long ? C8450a.m24469bn(((Long) obj).longValue()) : String.valueOf(obj);
                    String string = this.elF.getString("ver");
                    if (bn != null) {
                        C8692b.m25299V(this.elA, bn, string);
                    }
                }
            }
        }

        /* renamed from: k */
        private void m25342k(Message message) {
            if (this.mHandler != null) {
                String aKw = C8692b.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("msg:");
                sb.append(message.what);
                sb.append(",arg1:");
                sb.append(message.arg1);
                sb.append(",arg2:");
                sb.append(message.arg2);
                LogUtils.m14222e(aKw, sb.toString());
                Bundle data = message.getData();
                if (data != null) {
                    String aKw2 = C8692b.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("bundle:");
                    sb2.append(data);
                    LogUtils.m14222e(aKw2, sb2.toString());
                } else {
                    LogUtils.m14222e(C8692b.TAG, "bundle is empty");
                }
                this.mHandler.sendMessage(message);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(new Integer[0]);
            if (!isCancelled()) {
                int intValue = numArr[0].intValue();
                if (this.elD == 4) {
                    intValue = ((intValue * 80) / 100) + 10;
                }
                Message obtainMessage = this.mHandler.obtainMessage(this.elB, 65282, intValue, null);
                obtainMessage.setData(this.elF);
                m25342k(obtainMessage);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x020a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                android.content.Context r0 = r14.elA
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                r0 = 0
                r2 = r15[r0]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r15 = r15[r3]
                java.lang.String r15 = (java.lang.String) r15
                boolean r4 = android.text.TextUtils.isEmpty(r2)
                if (r4 != 0) goto L_0x020c
                java.lang.String r4 = "http://"
                boolean r4 = r2.startsWith(r4)
                if (r4 != 0) goto L_0x0020
                goto L_0x020c
            L_0x0020:
                r14.elG = r2
                android.content.Context r4 = r14.elA
                android.content.ContentResolver r4 = r4.getContentResolver()
                java.lang.String r11 = "remote = ?"
                java.lang.String r5 = "URLCache"
                android.net.Uri r6 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r5)
                java.lang.String r5 = "local"
                java.lang.String[] r7 = new java.lang.String[]{r5}
                java.lang.String[] r9 = new java.lang.String[r3]
                r9[r0] = r2
                r10 = 0
                r5 = r4
                r8 = r11
                android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)
                r12 = 0
                if (r5 == 0) goto L_0x00d5
                boolean r6 = r5.moveToFirst()
                if (r6 == 0) goto L_0x0054
                java.lang.String r6 = r5.getString(r0)
                java.lang.String r6 = com.introvd.template.p203b.C4580b.m11655eA(r6)
                goto L_0x0055
            L_0x0054:
                r6 = r1
            L_0x0055:
                r5.close()
                boolean r5 = android.text.TextUtils.isEmpty(r6)
                if (r5 != 0) goto L_0x00d5
                java.io.File r5 = new java.io.File
                r5.<init>(r6)
                boolean r7 = r5.isFile()
                if (r7 == 0) goto L_0x009d
                boolean r7 = r5.exists()
                if (r7 == 0) goto L_0x009d
                long r7 = r5.length()
                int r5 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r5 <= 0) goto L_0x009d
                boolean r0 = android.text.TextUtils.isEmpty(r15)
                if (r0 == 0) goto L_0x007f
                r15 = r6
                goto L_0x009c
            L_0x007f:
                boolean r0 = r6.equals(r15)
                if (r0 != 0) goto L_0x009c
                java.io.File r0 = new java.io.File
                r0.<init>(r15)
                java.io.File r0 = r0.getParentFile()
                if (r0 == 0) goto L_0x009b
                java.lang.String r0 = r0.getAbsolutePath()
                com.introvd.template.common.FileUtils.createMultilevelDirectory(r0)
                com.introvd.template.common.FileUtils.copyFile(r6, r15)
                goto L_0x009c
            L_0x009b:
                r15 = r1
            L_0x009c:
                return r15
            L_0x009d:
                java.lang.String r5 = "URLCache"
                android.net.Uri r5 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r5)
                java.lang.String[] r6 = new java.lang.String[r3]
                r6[r0] = r2
                r4.delete(r5, r11, r6)
                java.lang.String r5 = "Download"
                android.net.Uri r6 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r5)
                java.lang.String r5 = "_id"
                java.lang.String[] r7 = new java.lang.String[]{r5}
                java.lang.String[] r9 = new java.lang.String[r3]
                r9[r0] = r2
                r10 = 0
                r5 = r4
                r8 = r11
                android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)
                if (r5 == 0) goto L_0x00d5
                boolean r6 = r5.moveToNext()
                if (r6 == 0) goto L_0x00d2
                long r6 = r5.getLong(r0)
                android.content.Context r8 = r14.elA
                com.introvd.template.datacenter.DownloadService.cancelDownload(r8, r6)
            L_0x00d2:
                r5.close()
            L_0x00d5:
                int r5 = r14.elD
                android.content.Context r6 = r14.elA
                long r5 = com.introvd.template.datacenter.DownloadService.enqueue(r6, r2, r15, r0, r5)
                r14.elz = r5
                int r15 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
                if (r15 > 0) goto L_0x00e4
                return r1
            L_0x00e4:
                com.introvd.template.template.download.b$a r15 = new com.introvd.template.template.download.b$a
                r15.<init>()
                r15.elu = r14
                r15.elw = r5
                int r7 = r14.elB
                r15.elx = r7
                android.os.Bundle r7 = r14.elF
                if (r7 == 0) goto L_0x011a
                android.os.Bundle r7 = r14.elF
                java.lang.String r8 = "ttid"
                java.lang.String r7 = r7.getString(r8)
                if (r7 == 0) goto L_0x011a
                java.lang.String r8 = "remote = ?"
                android.content.ContentValues r9 = new android.content.ContentValues
                r9.<init>()
                java.lang.String r10 = "userdata"
                r9.put(r10, r7)
                java.lang.String r10 = "Download"
                android.net.Uri r10 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r10)
                java.lang.String[] r11 = new java.lang.String[r3]
                r11[r0] = r2
                r4.update(r10, r9, r8, r11)
                r15.ely = r7
            L_0x011a:
                com.introvd.template.template.download.b r7 = r14.elC
                r7.m25304a(r2, r15)
                com.introvd.template.template.download.b$b$1 r15 = new com.introvd.template.template.download.b$b$1
                android.os.Handler r7 = r14.elH
                r15.<init>(r7)
                java.lang.String r7 = "Download"
                android.net.Uri r7 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r7)
                r4.registerContentObserver(r7, r3, r15)
                android.content.Context r7 = r14.elA
                com.introvd.template.datacenter.DownloadService.startDownload(r7, r5)
                r7 = 65536(0x10000, float:9.18355E-41)
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                r8 = 327680(0x50000, float:4.59177E-40)
                r9 = 131072(0x20000, float:1.83671E-40)
                java.util.concurrent.LinkedBlockingQueue<java.lang.Integer> r10 = r14.dCI     // Catch:{ Exception -> 0x0184, all -> 0x0166 }
                java.lang.Object r10 = r10.take()     // Catch:{ Exception -> 0x0184, all -> 0x0166 }
                java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ Exception -> 0x0184, all -> 0x0166 }
                boolean r7 = r14.elI
                if (r7 != 0) goto L_0x0153
                boolean r7 = r14.isCancelled()
                if (r7 == 0) goto L_0x0151
                goto L_0x0153
            L_0x0151:
                r7 = 0
                goto L_0x0154
            L_0x0153:
                r7 = 1
            L_0x0154:
                if (r7 != 0) goto L_0x0162
                int r11 = r10.intValue()
                if (r11 == r9) goto L_0x0162
                int r11 = r10.intValue()
                if (r11 != r8) goto L_0x0189
            L_0x0162:
                r4.unregisterContentObserver(r15)
                goto L_0x0189
            L_0x0166:
                r1 = move-exception
                boolean r2 = r14.elI
                if (r2 != 0) goto L_0x0171
                boolean r2 = r14.isCancelled()
                if (r2 == 0) goto L_0x0172
            L_0x0171:
                r0 = 1
            L_0x0172:
                if (r0 != 0) goto L_0x0180
                int r0 = r7.intValue()
                if (r0 == r9) goto L_0x0180
                int r0 = r7.intValue()
                if (r0 != r8) goto L_0x0183
            L_0x0180:
                r4.unregisterContentObserver(r15)
            L_0x0183:
                throw r1
            L_0x0184:
                r4.unregisterContentObserver(r15)
                r10 = r7
                r7 = 1
            L_0x0189:
                if (r7 != 0) goto L_0x01ef
                java.lang.String r15 = com.introvd.template.template.download.C8692b.TAG
                java.lang.String r8 = "Download OK"
                com.introvd.template.common.LogUtils.m14222e(r15, r8)
                int r15 = r10.intValue()
                if (r15 != r9) goto L_0x01ed
                android.content.Context r15 = r14.elA
                java.lang.String r8 = "local"
                java.lang.String r15 = com.introvd.template.datacenter.DownloadService.getFieldValue(r15, r5, r8)
                java.lang.String r15 = com.introvd.template.p203b.C4580b.m11655eA(r15)
                android.content.ContentValues r8 = new android.content.ContentValues
                r8.<init>()
                java.lang.String r9 = "remote"
                r8.put(r9, r2)
                java.lang.String r2 = "local"
                java.lang.String r9 = com.introvd.template.p203b.C4580b.m11662ez(r15)
                r8.put(r2, r9)
                java.lang.String r2 = "time"
                java.sql.Timestamp r9 = new java.sql.Timestamp
                long r10 = java.lang.System.currentTimeMillis()
                r9.<init>(r10)
                java.lang.String r9 = r9.toString()
                r8.put(r2, r9)
                java.lang.String r2 = "URLCache"
                android.net.Uri r2 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r2)
                r4.insert(r2, r8)
                int r2 = r14.elD
                r8 = 4
                if (r2 == r8) goto L_0x0208
                java.lang.String r2 = "_id = ?"
                java.lang.String r8 = "Download"
                android.net.Uri r8 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r8)
                java.lang.String[] r3 = new java.lang.String[r3]
                java.lang.String r5 = java.lang.String.valueOf(r5)
                r3[r0] = r5
                r4.delete(r8, r2, r3)
                goto L_0x0208
            L_0x01ed:
                r15 = r1
                goto L_0x0208
            L_0x01ef:
                long r2 = r14.elz
                int r15 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
                if (r15 <= 0) goto L_0x01fe
                android.content.Context r15 = r14.elA
                if (r15 == 0) goto L_0x01fe
                android.content.Context r15 = r14.elA
                com.introvd.template.datacenter.DownloadService.cancelDownload(r15, r5)
            L_0x01fe:
                java.lang.String r15 = com.introvd.template.template.download.C8692b.TAG
                java.lang.String r0 = "Download failed"
                com.introvd.template.common.LogUtils.m14222e(r15, r0)
                goto L_0x01ed
            L_0x0208:
                if (r7 == 0) goto L_0x020b
                r15 = r1
            L_0x020b:
                return r15
            L_0x020c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.download.C8692b.C8699b.doInBackground(java.lang.Object[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
            m25334P(null, 327680);
            LogUtils.m14222e("DownloadUIMgr", "onCancelled()");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            m25334P(str, TextUtils.isEmpty(str) ? 65536 : 131072);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        public void quit() {
            this.elI = true;
            LogUtils.m14222e(C8692b.TAG, "send onCancelled()");
            this.dCI.add(Integer.valueOf(327680));
            cancel(false);
        }
    }

    /* renamed from: com.introvd.template.template.download.b$c */
    private static class C8701c {
        public int elL;
        public Bundle elM;
        public String ely;
        public String strMission;
        public String strVer;

        private C8701c() {
        }
    }

    public C8692b(Context context, Handler handler) {
        super(context, handler);
        init();
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public static void m25299V(Context context, String str, String str2) {
        try {
            String locale = Locale.getDefault().toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SocialServiceDef.EXTRAS_REQUEST_TYPE, str);
            jSONObject.put("version", str2);
            jSONObject.put("lang", locale);
            jSONObject.put("social_method", SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_DOWNCONFIRM);
            jSONObject.put(SocialServiceDef.TODO_ACTION, SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC);
            String jSONObject2 = jSONObject.toString();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SocialConstDef.TASK_MAIN_TYPE, Integer.valueOf(3));
            contentValues.put(SocialConstDef.TASK_SUB_TYPE, Integer.valueOf(0));
            contentValues.put(SocialConstDef.TASK_SUB_STATE, Integer.valueOf(0));
            contentValues.put("state", Integer.valueOf(0));
            contentValues.put(SocialConstDef.TASK_USER_DATA, jSONObject2);
            context.getContentResolver().insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TASK), contentValues);
            TaskService.doPendingTask(context, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m25304a(String str, C8698a aVar) {
        this.elh.put(str, aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25311b(String str, String str2, int i, String str3, Bundle bundle) {
        for (String pf : aKv()) {
            C8698a pf2 = mo35066pf(pf);
            if (pf2.ely != null && pf2.ely.equals(str)) {
                return;
            }
        }
        this.eli.sendMessage(this.eli.obtainMessage(1, str));
        C8701c cVar = new C8701c();
        cVar.ely = str;
        cVar.strVer = str2;
        cVar.elL = i;
        cVar.strMission = str3;
        if (bundle != null) {
            cVar.elM = bundle;
        }
        this.eli.sendMessage(this.eli.obtainMessage(0, cVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized boolean m25312b(String str, String str2, int i, int i2, String str3, Bundle bundle) {
        boolean z;
        synchronized (this) {
            z = false;
            if (aKu() >= 100) {
                return false;
            }
            C8698a pf = mo35066pf(str);
            if (pf != null && pf.elu != null && !pf.elu.isCancelled()) {
                return true;
            }
            try {
                C8699b bVar = new C8699b(this, this.bbr, this.mHandler, this.mHandler, i, i2, str3, bundle);
                bVar.execute((Params[]) new Object[]{str, str2});
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m25314c(String str, String str2, int i, String str3, Bundle bundle) {
        Message obtainMessage = this.mHandler.obtainMessage(i, 65282, 10, null);
        if (bundle != null) {
            obtainMessage.setData(bundle);
        }
        m25318j(obtainMessage);
        if (this.eli != null) {
            this.eli.sendEmptyMessageDelayed(3, 0);
        }
        if (bundle != null) {
            try {
                String string = bundle.getString("b");
                String pe = m25319pe(string);
                if (!TextUtils.isEmpty(pe)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    sb.append(pe);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(CommonConfigure.APP_DATA_PATH);
                    sb3.append("Templates/");
                    String sb4 = sb3.toString();
                    C4677g.m12179cT(sb4);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(sb4);
                    sb5.append(sb2);
                    String sb6 = sb5.toString();
                    if (bundle == null) {
                        bundle = new Bundle();
                        bundle.putString("ttid", str);
                    }
                    Bundle bundle2 = bundle;
                    bundle2.putString("ver", str2);
                    m25312b(string, sb6, i, 4, str3, bundle2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m25315c(Context context, String str, List<String> list) {
        if (context == null || TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return false;
        }
        C8745n.m25557cL(context, str);
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_ROLL_MAP);
        ArrayList arrayList = new ArrayList();
        for (String templateID : m25316d(context, str, list)) {
            Long valueOf = Long.valueOf(C8762d.aMt().getTemplateID(templateID));
            contentValues.put(SocialConstDef.TEMPLATEROLLMAP_ITEM_ROLLCODE, str);
            contentValues.put("ttid", valueOf);
            arrayList.add(ContentProviderOperation.newInsert(tableUri).withValues(contentValues).build());
        }
        try {
            if (!arrayList.isEmpty()) {
                contentResolver.applyBatch(tableUri.getAuthority(), arrayList);
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    private List<String> m25316d(Context context, String str, List<String> list) {
        ImageInfo cv = C8657a.m25215cv(context, str);
        if (list == null || list.size() == 0 || cv == null || TextUtils.isEmpty(cv.simpleInfoList)) {
            return list;
        }
        List list2 = (List) new Gson().fromJson(cv.simpleInfoList, new TypeToken<List<ImageSimpleInfoItem>>() {
        }.getType());
        if (list2 == null || list2.size() != list.size()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            ImageSimpleInfoItem imageSimpleInfoItem = (ImageSimpleInfoItem) list2.get(i);
            if (imageSimpleInfoItem != null && !TextUtils.isEmpty(imageSimpleInfoItem.ttid)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str2 = (String) list.get(i2);
                    if (imageSimpleInfoItem.ttid.equalsIgnoreCase(C8450a.m24469bn(C8762d.aMt().getTemplateID(str2)))) {
                        arrayList.add(str2);
                    }
                }
            }
        }
        return (arrayList.size() == 0 || arrayList.size() != list.size()) ? list : arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25317d(String str, String str2, int i, String str3, Bundle bundle) {
        C1848s f = C8670b.m25246bc(str, str2).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi());
        final int i2 = i;
        final Bundle bundle2 = bundle;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        C86953 r1 = new C1850u<TemplateDownloadInfo>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: b */
            public void onSuccess(TemplateDownloadInfo templateDownloadInfo) {
                Message obtainMessage = C8692b.this.mHandler.obtainMessage(i2, 65282, 10, null);
                obtainMessage.setData(bundle2);
                C8692b.this.m25318j(obtainMessage);
                if (C8692b.this.eli != null) {
                    C8692b.this.eli.sendEmptyMessageDelayed(3, 0);
                }
                try {
                    String str = templateDownloadInfo.downloadUrl;
                    String pe = C8692b.m25319pe(str);
                    if (!TextUtils.isEmpty(pe)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CommonConfigure.APP_DATA_PATH);
                        sb.append("Templates/");
                        String sb2 = sb.toString();
                        C4677g.m12179cT(sb2);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(sb2);
                        sb3.append(pe);
                        String sb4 = sb3.toString();
                        Bundle bundle = bundle2;
                        if (bundle2 == null) {
                            bundle = new Bundle();
                            bundle.putString("ttid", str4);
                        }
                        Bundle bundle2 = bundle;
                        bundle2.putString("ver", str5);
                        C8692b.this.m25312b(str, sb4, i2, 4, str6, bundle2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onError(Throwable th) {
                Message obtainMessage = C8692b.this.mHandler.obtainMessage(i2, 65282, 10, null);
                obtainMessage.setData(bundle2);
                C8692b.this.m25318j(obtainMessage);
                if (C8692b.this.eli != null) {
                    C8692b.this.eli.sendEmptyMessageDelayed(3, 0);
                }
                Message obtainMessage2 = C8692b.this.mHandler.obtainMessage(i2, 65283, 65536, null);
                obtainMessage2.setData(bundle2);
                C8692b.this.m25318j(obtainMessage2);
            }
        };
        f.mo10188a((C1850u<? super T>) r1);
    }

    private void init() {
        this.mHandlerThread = Utils.getHandlerThreadFromCommon();
        this.eli = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        C8692b.this.elk.add((C8701c) message.obj);
                        sendEmptyMessage(2);
                        break;
                    case 1:
                        if (!C8692b.this.elk.isEmpty()) {
                            String str = (String) message.obj;
                            if (str != null) {
                                for (int size = C8692b.this.elk.size() - 1; size >= 0; size--) {
                                    C8701c cVar = (C8701c) C8692b.this.elk.get(size);
                                    if (!(cVar == null || cVar.ely == null || !cVar.ely.equals(str))) {
                                        C8692b.this.elk.remove(size);
                                    }
                                }
                                break;
                            }
                        } else {
                            return;
                        }
                        break;
                    case 2:
                        removeMessages(2);
                        if (!C8692b.this.elk.isEmpty()) {
                            if (!C8692b.this.elj) {
                                try {
                                    C8701c cVar2 = (C8701c) C8692b.this.elk.remove(0);
                                    C8692b.this.elj = true;
                                    if (cVar2.elM.containsKey("b")) {
                                        C8692b.this.m25314c(cVar2.ely, cVar2.strVer, cVar2.elL, cVar2.strMission, cVar2.elM);
                                    } else {
                                        C8692b.this.m25317d(cVar2.ely, cVar2.strVer, cVar2.elL, cVar2.strMission, cVar2.elM);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            sendEmptyMessageDelayed(2, 100);
                            break;
                        } else {
                            return;
                        }
                    case 3:
                        C8692b.this.elj = false;
                        sendEmptyMessageDelayed(2, 0);
                        break;
                }
                super.handleMessage(message);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public synchronized void m25318j(Message message) {
        if (this.mHandler != null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("msg:");
            sb.append(message.what);
            sb.append(",arg1:");
            sb.append(message.arg1);
            sb.append(",arg2:");
            sb.append(message.arg2);
            LogUtils.m14222e(str, sb.toString());
            Bundle data = message.getData();
            if (data != null) {
                String str2 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("bundle:");
                sb2.append(data);
                LogUtils.m14222e(str2, sb2.toString());
            } else {
                LogUtils.m14222e(TAG, "bundle is empty");
            }
            this.mHandler.sendMessage(message);
        }
    }

    /* renamed from: pe */
    public static String m25319pe(String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf >= 0) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return null;
    }

    /* renamed from: a */
    public int mo35058a(long j, final int i, final Bundle bundle) {
        String str;
        String str2;
        String str3;
        Context context = this.bbr;
        int i2 = 0;
        Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_CARD), new String[]{"ttid", "mission", "size"}, "upper(ttid) = ?", new String[]{C8450a.m24469bn(j).toUpperCase(Locale.US)}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    str2 = query.getString(0);
                    str3 = query.getString(1);
                    i2 = query.getInt(2);
                } else {
                    str2 = null;
                    str3 = null;
                }
                query.close();
                str = str3;
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        } else {
            str2 = null;
            str = null;
        }
        Message obtainMessage = this.mHandler.obtainMessage(i, 65281, 131072, null);
        if (bundle != null) {
            obtainMessage.setData(bundle);
        }
        m25318j(obtainMessage);
        final String valueOf = String.valueOf(QEngine.VERSION_NUMBER);
        CharSequence string = (bundle == null || !bundle.containsKey("b")) ? null : bundle.getString("b");
        if (str2 != null || !TextUtils.isEmpty(string)) {
            Message obtainMessage2 = this.mHandler.obtainMessage(i, 65282, 10, null);
            if (bundle != null) {
                obtainMessage2.setData(bundle);
            }
            m25318j(obtainMessage2);
            m25311b(str2, valueOf, i, str, bundle);
        } else {
            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ITEM_INFO, (C8354a) new C8354a() {
                /* renamed from: a */
                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                    C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_ITEM_INFO);
                    Message obtainMessage = C8692b.this.mHandler.obtainMessage(i, 65282, 10, null);
                    if (bundle != null) {
                        obtainMessage.setData(bundle);
                    }
                    C8692b.this.m25318j(obtainMessage);
                    if (i == 131072) {
                        C8739i.m25524ho(context);
                        try {
                            JSONObject jSONObject = new JSONObject(bundle.getString(SocialServiceDef.XIAOYING_SERVER_RESPONSE));
                            C8692b.this.m25311b(jSONObject.getString(C5878a.TAG), valueOf, i, jSONObject.optString("u"), bundle);
                        } catch (Exception unused) {
                            Message obtainMessage2 = C8692b.this.mHandler.obtainMessage(i, 65283, 65536, null);
                            if (bundle != null) {
                                obtainMessage2.setData(bundle);
                            }
                            C8692b.this.m25318j(obtainMessage2);
                        }
                    } else {
                        Message obtainMessage3 = C8692b.this.mHandler.obtainMessage(i, 65283, 65536, null);
                        if (bundle != null) {
                            obtainMessage3.setData(bundle);
                        }
                        C8692b.this.m25318j(obtainMessage3);
                    }
                }
            });
            C8346e.m24072U(context, String.valueOf(QTemplateIDUtils.getTemplateType(j)), C8450a.m24469bn(j));
        }
        return i2;
    }

    /* renamed from: a */
    public void mo35059a(String str, int i, String str2, Bundle bundle) {
        if (FileUtils.isFileExisted(str)) {
            try {
                final String str3 = str2;
                final Bundle bundle2 = bundle;
                final String str4 = str;
                final int i2 = i;
                C86964 r1 = new ExAsyncTask<Object, Integer, Integer>() {
                    private List<String> elr = null;

                    /* renamed from: uH */
                    private void m25331uH(int i) {
                        if (C8692b.this.mHandler != null) {
                            Message obtainMessage = C8692b.this.mHandler.obtainMessage(i2, 65282, i, null);
                            obtainMessage.setData(bundle2);
                            C8692b.this.m25318j(obtainMessage);
                        }
                    }

                    /* access modifiers changed from: protected */
                    /* renamed from: d */
                    public Integer doInBackground(Object... objArr) {
                        int i;
                        ArrayList<String> arrayList = new ArrayList<>();
                        int i2 = 0;
                        String str = (String) objArr[0];
                        if (!FileUtils.isFileExisted(str)) {
                            return Integer.valueOf(SocialServiceDef.SERVER_STATE_USER_CANCEL);
                        }
                        m25331uH(0);
                        this.elr = C8762d.aMt().mo35222a(str, arrayList, 1, str3, true);
                        if (bundle2 != null && bundle2.containsKey("RollId")) {
                            C8692b.this.m25315c(C8692b.this.bbr, bundle2.getString("RollId"), this.elr);
                        }
                        publishProgress(Integer.valueOf(50));
                        if (!arrayList.isEmpty()) {
                            i = 131072;
                            int size = arrayList.size() + 1;
                            for (String str2 : arrayList) {
                                if (C8762d.aMt().getTemplateID(str2) < 0) {
                                    FileUtils.deleteFile(str2);
                                    i = 65536;
                                }
                                i2++;
                                m25331uH(((i2 * 50) / size) + 50);
                            }
                        } else {
                            i = 65536;
                        }
                        m25331uH(100);
                        return Integer.valueOf(i);
                    }

                    /* access modifiers changed from: protected */
                    /* renamed from: l */
                    public void onPostExecute(Integer num) {
                        C8692b.this.bbr.getContentResolver().delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_DOWNLOAD), "local = ?", new String[]{String.valueOf(str4)});
                        if (num.intValue() == 131072) {
                            if (C8692b.this.mHandler != null) {
                                Message obtainMessage = C8692b.this.mHandler.obtainMessage(i2, 65283, 131072, this.elr);
                                obtainMessage.setData(bundle2);
                                C8692b.this.m25318j(obtainMessage);
                            }
                        } else if (num.intValue() == 65536 && C8692b.this.mHandler != null) {
                            Message obtainMessage2 = C8692b.this.mHandler.obtainMessage(i2, 65283, 65536, null);
                            obtainMessage2.setData(bundle2);
                            C8692b.this.m25318j(obtainMessage2);
                        }
                    }
                };
                r1.execute((Params[]) new Object[]{str});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo35060a(String str, String str2, int i, String str3, Bundle bundle) {
        Message obtainMessage = this.mHandler.obtainMessage(i, 65281, 131072, null);
        obtainMessage.setData(bundle);
        m25318j(obtainMessage);
        m25311b(str, str2, i, str3, bundle);
    }

    /* renamed from: a */
    public boolean mo35061a(String str, String str2, int i, int i2, String str3) {
        return mo35062a(str, str2, i, i2, str3, (Bundle) null);
    }

    /* renamed from: a */
    public synchronized boolean mo35062a(String str, String str2, int i, int i2, String str3, Bundle bundle) {
        Message obtainMessage = this.mHandler.obtainMessage(i, 65281, 131072, null);
        obtainMessage.setData(bundle);
        m25318j(obtainMessage);
        return m25312b(str, str2, i, i2, str3, bundle);
    }

    public int aKu() {
        return this.elh.size() + this.elk.size();
    }

    public synchronized Set<String> aKv() {
        HashSet hashSet;
        hashSet = new HashSet();
        if (this.elh.size() > 0) {
            hashSet.addAll(this.elh.keySet());
        }
        return hashSet;
    }

    /* renamed from: jm */
    public void mo35065jm(String str) {
        if (str != null) {
            C8698a aVar = (C8698a) this.elh.get(str);
            if (aVar != null) {
                if (aVar.elu != null) {
                    aVar.elu.quit();
                    aVar.elu = null;
                }
                this.elh.remove(str);
            }
        }
    }

    /* renamed from: pf */
    public synchronized C8698a mo35066pf(String str) {
        return (C8698a) this.elh.get(str);
    }

    /* renamed from: pg */
    public synchronized void mo35067pg(String str) {
        if (str != null) {
            this.eli.sendMessage(this.eli.obtainMessage(1, str));
            for (String str2 : aKv()) {
                C8698a pf = mo35066pf(str2);
                if (pf.ely != null && pf.ely.equals(str)) {
                    mo35065jm(str2);
                }
            }
        }
    }
}
