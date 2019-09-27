package com.introvd.template.datacenter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.supportin.media.ExifInterface;
import android.text.TextUtils;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.p243e.C5542a;
import com.introvd.template.p309f.C7347a;
import com.introvd.template.p321k.C7549a;
import com.introvd.template.p321k.C7550b.C7551a;
import com.introvd.template.p321k.C7552c;
import com.introvd.template.p321k.C7554d;
import com.xiaoying.p448a.C9537b;
import com.xiaoying.p448a.C9561c;
import com.xiaoying.p448a.p449a.C9534a;
import com.xiaoying.p448a.p450b.p451a.C9558f;
import java.io.File;
import java.lang.ref.WeakReference;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class DownloadService extends BaseIntentService implements C7551a {
    public static final int DOWNLOAD_SERVER_RESULT_FAIL = 65536;
    public static final int DOWNLOAD_SERVER_RESULT_PENDING = 0;
    public static final int DOWNLOAD_SERVER_RESULT_RUNNING = 196608;
    public static final int DOWNLOAD_SERVER_RESULT_STOPPED = 262144;
    public static final int DOWNLOAD_SERVER_RESULT_SUCCESS = 131072;
    public static final int DOWNLOAD_SERVER_RESULT_USER_END = 327680;
    private static final int DOWNLOAD_SERVICE_DEFAULT_PRIORITY = 100;
    private static final int DOWNLOAD_SERVICE_MAX_TASK = 5;
    private static final String INTERNAL_EXTRAS_DOWNLOAD_TASK_STATUS = "Status";
    private static final int MSG_INTERNAL_MAIN = 1;
    private static final int MSG_INTERNAL_THREAD = 0;
    private static final String TAG = "DownloadService";
    private static final Map<Long, DownloadParam> mHttpDownloadParamMap = Collections.synchronizedMap(new LinkedHashMap());
    private static MainHandler mMainHandler = null;
    private static C5542a mServiceInternalCB;
    private static boolean mbClearTemporaryFile = false;

    private static class DownloadParam {
        C7549a downloader;
        long lLastRunningMsgTimestamp;
        int nLastProgress;
        int nSubType;
        int nUIShowType;
        String strTitle;

        private DownloadParam() {
        }
    }

    private static class MainHandler extends Handler {
        private final WeakReference<Context> mContextRef;

        public MainHandler(Context context, Looper looper) {
            super(looper);
            this.mContextRef = new WeakReference<>(context);
        }

        public void handleMessage(Message message) {
            Context context = (Context) this.mContextRef.get();
            if (context != null && message.obj != null) {
                if (message.what == 0) {
                    if (message.obj instanceof Intent) {
                        DownloadService.onHandleDownloadEvent(context, (Intent) message.obj);
                    }
                } else if (message.obj instanceof Bundle) {
                    Bundle bundle = (Bundle) message.obj;
                    int i = bundle.getInt("result");
                    long j = bundle.getLong("_id");
                    if (i == 65536 || i == 131072 || (i != 196608 && (i == 262144 || i == 327680 || i == 393216))) {
                        DownloadService.stopTask(context, j, false);
                        if (!TextUtils.isEmpty(SocialServiceDef.ACTION_DOWNLOAD_COMPLETED)) {
                            Intent intent = new Intent(SocialServiceDef.ACTION_DOWNLOAD_COMPLETED);
                            intent.putExtra("_id", j);
                            intent.setPackage(context.getPackageName());
                            context.sendBroadcast(intent);
                        }
                        DownloadService.startDownload(context, -268637123572819L);
                    }
                }
            }
        }
    }

    public DownloadService() {
        super(TAG);
        if (mServiceInternalCB == null) {
            mServiceInternalCB = this;
        }
    }

    private void autoRestartDownloading() {
        int size = mHttpDownloadParamMap.size();
        if (size < 5) {
            ContentResolver contentResolver = getContentResolver();
            Cursor a = C7347a.m21672a(contentResolver, 0);
            if (a != null) {
                while (a.moveToNext()) {
                    String string = a.getString(a.getColumnIndex("remote"));
                    String string2 = a.getString(a.getColumnIndex("local"));
                    long j = (long) a.getInt(a.getColumnIndex("_id"));
                    if (string2 == null || string2.isEmpty()) {
                        if (string == null) {
                            continue;
                        } else {
                            string2 = getTempFileName(string);
                            if (string2 == null) {
                                continue;
                            }
                        }
                    }
                    if (mHttpDownloadParamMap.get(Long.valueOf(j)) != null) {
                        continue;
                    } else {
                        String str = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(string);
                        sb.append(" start downloading...");
                        LogUtils.m14223i(str, sb.toString());
                        DownloadParam downloadParam = new DownloadParam();
                        C7549a dVar = C9558f.aRt() ? new C7554d(string, string2, j) : new C7552c(string, string2, j);
                        dVar.mo32414a(this);
                        downloadParam.downloader = dVar;
                        downloadParam.nUIShowType = a.getInt(a.getColumnIndex("maintype"));
                        downloadParam.nSubType = a.getInt(a.getColumnIndex("subtype"));
                        int lastIndexOf = string2.lastIndexOf(File.separator);
                        if (lastIndexOf > 0) {
                            string2 = string2.substring(lastIndexOf + 1);
                        }
                        downloadParam.strTitle = string2;
                        mHttpDownloadParamMap.put(Long.valueOf(j), downloadParam);
                        C7347a.m21679a(contentResolver, string, 0, 196608);
                        dVar.start();
                        size++;
                        if (size >= 5) {
                            break;
                        }
                    }
                }
                a.close();
            }
        }
    }

    public static void cancelDownload(Context context, long j) {
        Intent intent = new Intent(SocialServiceDef.ACTION_FILES_DOWNLOAD);
        intent.putExtra("_id", j);
        intent.putExtra(SocialServiceDef.EXTRAS_DOWNLOAD_TASK_SILENT, true);
        intent.putExtra("clear", true);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    public static long enqueue(Context context, String str, String str2, int i, int i2) {
        if (TextUtils.isEmpty(str) || context == null || str.startsWith(File.separator)) {
            return -1;
        }
        init(context);
        ContentResolver contentResolver = context.getContentResolver();
        long c = C7347a.m21681c(contentResolver, str);
        if (mHttpDownloadParamMap.get(Long.valueOf(c)) != null) {
            return c;
        }
        C7347a.m21680b(contentResolver, str);
        return C7347a.m21671a(contentResolver, str, str2, i, i2, 0, 0, 0, getCurrentSQLTimestamp());
    }

    private static String getCurrentSQLTimestamp() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    public static int getDownloadProgress(Context context, long j) {
        init(context);
        String fieldValue = getFieldValue(context, j, SocialConstDef.DOWNLOAD_CURRENT_SIZE);
        if (TextUtils.isEmpty(fieldValue)) {
            return 0;
        }
        String fieldValue2 = getFieldValue(context, j, SocialConstDef.DOWNLOAD_TOTAL);
        if (TextUtils.isEmpty(fieldValue2)) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(fieldValue);
            int parseInt2 = Integer.parseInt(fieldValue2);
            if (parseInt2 == 0) {
                return 0;
            }
            return (int) ((((long) parseInt) * 100) / ((long) parseInt2));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getDownloadState(Context context, long j) {
        init(context);
        String fieldValue = getFieldValue(context, j, "state");
        if (fieldValue == null) {
            return -1;
        }
        try {
            return Integer.parseInt(fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getFieldValue(Context context, long j, String str) {
        if (str == null) {
            return null;
        }
        boolean z = true;
        if (SocialConstDef.DOWNLOAD_CURRENT_SIZE.equals(str) || SocialConstDef.DOWNLOAD_TOTAL.equals(str) || "priority".equals(str) || "speed".equals(str) || "state".equals(str) || "maintype".equals(str) || "subtype".equals(str)) {
            z = false;
        }
        return C7347a.m21673a(context.getContentResolver(), z, j, str);
    }

    private String getTempFileName(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf != -1) {
            str = str.substring(lastIndexOf + 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SocialServiceDef.SOCIAL_DOWNLOAD_PATH);
        sb.append("tmp_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(str);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void init(android.content.Context r8) {
        /*
            java.lang.Class<com.introvd.template.datacenter.DownloadService> r0 = com.introvd.template.datacenter.DownloadService.class
            monitor-enter(r0)
            if (r8 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            initMyUri(r8)     // Catch:{ all -> 0x006f }
            com.introvd.template.datacenter.DownloadService$MainHandler r1 = mMainHandler     // Catch:{ all -> 0x006f }
            if (r1 != 0) goto L_0x0021
            android.os.HandlerThread r1 = com.introvd.template.common.Utils.getHandlerThreadFromCommon()     // Catch:{ all -> 0x006f }
            com.introvd.template.datacenter.DownloadService$MainHandler r2 = new com.introvd.template.datacenter.DownloadService$MainHandler     // Catch:{ all -> 0x006f }
            android.content.Context r8 = r8.getApplicationContext()     // Catch:{ all -> 0x006f }
            android.os.Looper r1 = r1.getLooper()     // Catch:{ all -> 0x006f }
            r2.<init>(r8, r1)     // Catch:{ all -> 0x006f }
            mMainHandler = r2     // Catch:{ all -> 0x006f }
        L_0x0021:
            boolean r8 = mbClearTemporaryFile     // Catch:{ all -> 0x006f }
            if (r8 != 0) goto L_0x006d
            r8 = 1
            mbClearTemporaryFile = r8     // Catch:{ all -> 0x006f }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x006d }
            java.lang.String r1 = com.introvd.template.datacenter.SocialServiceDef.SOCIAL_DOWNLOAD_PATH     // Catch:{ Exception -> 0x006d }
            r8.<init>(r1)     // Catch:{ Exception -> 0x006d }
            boolean r1 = r8.isDirectory()     // Catch:{ Exception -> 0x006d }
            if (r1 != 0) goto L_0x0037
            monitor-exit(r0)
            return
        L_0x0037:
            java.io.File[] r8 = r8.listFiles()     // Catch:{ Exception -> 0x006d }
            if (r8 == 0) goto L_0x006b
            int r1 = r8.length     // Catch:{ Exception -> 0x006d }
            if (r1 != 0) goto L_0x0041
            goto L_0x006b
        L_0x0041:
            int r1 = r8.length     // Catch:{ Exception -> 0x006d }
            r2 = 0
        L_0x0043:
            if (r2 >= r1) goto L_0x006d
            r3 = r8[r2]     // Catch:{ Exception -> 0x006d }
            java.lang.String r4 = r3.getPath()     // Catch:{ Exception -> 0x006d }
            java.lang.String r5 = ".part"
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x006d }
            if (r4 == 0) goto L_0x0068
            long r4 = r3.lastModified()     // Catch:{ Exception -> 0x006d }
            r6 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            long r4 = r4 + r6
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x006d }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0068
            r3.delete()     // Catch:{ Exception -> 0x006d }
        L_0x0068:
            int r2 = r2 + 1
            goto L_0x0043
        L_0x006b:
            monitor-exit(r0)
            return
        L_0x006d:
            monitor-exit(r0)
            return
        L_0x006f:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.DownloadService.init(android.content.Context):void");
    }

    private static void initMyUri(Context context) {
        SocialProvider.init(context);
    }

    private boolean isEnable() {
        return true;
    }

    /* access modifiers changed from: private */
    public static void onHandleDownloadEvent(Context context, Intent intent) {
        long j;
        int i;
        int i2;
        Context context2 = context;
        Intent intent2 = intent;
        if (context2 != null) {
            int intExtra = intent2.getIntExtra(INTERNAL_EXTRAS_DOWNLOAD_TASK_STATUS, -1);
            String stringExtra = intent2.getStringExtra("remote");
            long longExtra = intent2.getLongExtra("_id", 0);
            boolean booleanExtra = intent2.getBooleanExtra(SocialServiceDef.EXTRAS_DOWNLOAD_TASK_SILENT, false);
            C7549a aVar = null;
            DownloadParam downloadParam = (DownloadParam) mHttpDownloadParamMap.get(Long.valueOf(longExtra));
            if (downloadParam != null) {
                aVar = downloadParam.downloader;
            }
            ContentResolver contentResolver = context.getContentResolver();
            switch (intExtra) {
                case 1:
                    if (aVar != null) {
                        long aaY = aVar.aaY();
                        long aaZ = aVar.aaZ();
                        long j2 = aaZ == 0 ? 2147483647L : aaZ;
                        long aba = aVar.aba();
                        int i3 = j2 == 0 ? 0 : (int) ((100 * aaY) / j2);
                        String str = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(stringExtra);
                        sb.append(" download ");
                        sb.append(i3);
                        sb.append("%,");
                        sb.append(aba / 1024);
                        sb.append("KB/s");
                        LogUtils.m14223i(str, sb.toString());
                        j = longExtra;
                        C7347a.m21677a(contentResolver, longExtra, aaZ, aaY, aba);
                        booleanExtra = aVar.aaX();
                        i = i3;
                        break;
                    } else {
                        return;
                    }
                case 2:
                    C7347a.m21675a(contentResolver, longExtra, 131072);
                    String str2 = TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Download Done: ");
                    sb2.append(stringExtra);
                    LogUtils.m14223i(str2, sb2.toString());
                    j = longExtra;
                    i = 100;
                    break;
                case 3:
                case 5:
                    String str3 = TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Download Fail or cancel: ");
                    sb3.append(stringExtra);
                    LogUtils.m14223i(str3, sb3.toString());
                    C7347a.m21675a(contentResolver, longExtra, intExtra == 3 ? 65536 : 262144);
                    i = getDownloadProgress(context2, longExtra);
                    j = longExtra;
                    break;
                case 4:
                    if (aVar != null) {
                        C7347a.m21676a(contentResolver, longExtra, aVar.aaZ());
                        booleanExtra = aVar.aaX();
                        String str4 = TAG;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Connected: ");
                        sb4.append(stringExtra);
                        LogUtils.m14223i(str4, sb4.toString());
                        j = longExtra;
                        i = 0;
                        break;
                    } else {
                        return;
                    }
                default:
                    j = longExtra;
                    i = 0;
                    break;
            }
            if (intExtra != 5) {
                switch (intExtra) {
                    case 2:
                        i2 = 131072;
                        break;
                    case 3:
                        i2 = 65536;
                        break;
                    default:
                        i2 = 196608;
                        break;
                }
            } else {
                i2 = 262144;
            }
            reportResult(j, stringExtra, i2, !booleanExtra, i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processSingleTask(long r15, java.lang.String r17, java.lang.String r18, int r19, boolean r20, boolean r21) {
        /*
            r14 = this;
            r0 = r14
            r9 = r17
            r1 = 1
            if (r20 == 0) goto L_0x002c
            r2 = r15
            stopTask(r14, r2, r1)
            r4 = 262144(0x40000, float:3.67342E-40)
            r6 = -1
            r1 = r15
            r3 = r17
            r5 = r21
            reportResult(r1, r3, r4, r5, r6)
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "download stop:"
            r2.append(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.introvd.template.common.LogUtils.m14222e(r1, r2)
            return
        L_0x002c:
            r2 = r15
            java.util.Map<java.lang.Long, com.introvd.template.datacenter.DownloadService$DownloadParam> r4 = mHttpDownloadParamMap
            java.lang.Long r5 = java.lang.Long.valueOf(r15)
            boolean r4 = r4.containsKey(r5)
            r5 = 0
            if (r4 == 0) goto L_0x008a
            java.lang.String r1 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            java.lang.String r6 = " has alread been downloading:"
            r4.append(r6)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.introvd.template.common.LogUtils.m14223i(r1, r4)
            java.util.Map<java.lang.Long, com.introvd.template.datacenter.DownloadService$DownloadParam> r1 = mHttpDownloadParamMap
            java.lang.Long r4 = java.lang.Long.valueOf(r15)
            java.lang.Object r1 = r1.get(r4)
            com.introvd.template.datacenter.DownloadService$DownloadParam r1 = (com.introvd.template.datacenter.DownloadService.DownloadParam) r1
            if (r1 != 0) goto L_0x0063
            r1 = 0
            goto L_0x0065
        L_0x0063:
            com.introvd.template.k.a r1 = r1.downloader
        L_0x0065:
            if (r1 == 0) goto L_0x007e
            long r6 = r1.aaZ()
            long r10 = r1.aaY()
            r12 = 0
            int r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x0076
            goto L_0x007c
        L_0x0076:
            r4 = 100
            long r10 = r10 * r4
            long r10 = r10 / r6
            int r5 = (int) r10
        L_0x007c:
            r6 = r5
            goto L_0x007f
        L_0x007e:
            r6 = 0
        L_0x007f:
            r4 = 196608(0x30000, float:2.75506E-40)
            r1 = r15
            r3 = r17
            r5 = r21
            reportResult(r1, r3, r4, r5, r6)
            return
        L_0x008a:
            boolean r4 = android.text.TextUtils.isEmpty(r17)
            if (r4 == 0) goto L_0x0091
            return
        L_0x0091:
            android.content.ContentResolver r4 = r14.getContentResolver()
            if (r18 != 0) goto L_0x00a3
            android.content.ContentResolver r6 = r14.getContentResolver()
            java.lang.String r6 = com.introvd.template.p309f.C7347a.m21683d(r6, r9)
            if (r6 == 0) goto L_0x00a5
            r8 = 0
            goto L_0x00a6
        L_0x00a3:
            r6 = r18
        L_0x00a5:
            r8 = 1
        L_0x00a6:
            if (r6 != 0) goto L_0x00b1
            java.lang.String r1 = r14.getTempFileName(r9)
            if (r1 != 0) goto L_0x00af
            return
        L_0x00af:
            r5 = r1
            goto L_0x00b2
        L_0x00b1:
            r5 = r6
        L_0x00b2:
            r7 = 0
            r1 = r4
            r2 = r15
            r4 = r17
            r6 = r19
            com.introvd.template.p309f.C7347a.m21678a(r1, r2, r4, r5, r6, r7, r8)
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            java.lang.String r3 = " inserted download list"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.introvd.template.common.LogUtils.m14223i(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.DownloadService.processSingleTask(long, java.lang.String, java.lang.String, int, boolean, boolean):void");
    }

    private static void reportResult(long j, String str, int i, boolean z, int i2) {
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putInt("progress", i2);
            bundle.putString("remote", str);
            bundle.putInt("result", i);
            bundle.putLong("_id", j);
            int i3 = i == 196608 ? -1 : 1;
            if (i3 != -1) {
                mMainHandler.sendMessage(mMainHandler.obtainMessage(i3, 0, 0, bundle));
            }
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("reportResult, id:");
            sb.append(j);
            sb.append(", url:");
            sb.append(str);
            sb.append(", state:");
            sb.append(i);
            sb.append(", progress:");
            sb.append(i2);
            LogUtils.m14222e(str2, sb.toString());
        }
    }

    public static void startDownload(Context context, long j) {
        if (j != -1) {
            Intent intent = new Intent(SocialServiceDef.ACTION_FILES_DOWNLOAD);
            intent.putExtra("_id", j);
            intent.putExtra(SocialServiceDef.EXTRAS_DOWNLOAD_TASK_SILENT, false);
            intent.setPackage(context.getPackageName());
            C9561c.m27511k(context, intent);
        }
    }

    private synchronized void stopAllTask() {
        Set keySet = mHttpDownloadParamMap.keySet();
        if (keySet != null && keySet.size() > 0) {
            for (Long l : new HashSet(keySet)) {
                C7549a aVar = ((DownloadParam) mHttpDownloadParamMap.get(l)).downloader;
                if (aVar != null) {
                    aVar.stop();
                }
            }
        }
        mHttpDownloadParamMap.clear();
        C7347a.m21674a(getContentResolver(), 262144, 131072);
    }

    public static void stopDownload(Context context, long j) {
        Intent intent = new Intent(SocialServiceDef.ACTION_FILES_DOWNLOAD);
        intent.putExtra("_id", j);
        intent.putExtra(SocialServiceDef.EXTRAS_DOWNLOAD_TASK_SILENT, true);
        intent.putExtra("stop", true);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* access modifiers changed from: private */
    public static void stopTask(Context context, long j, boolean z) {
        if (mHttpDownloadParamMap != null) {
            DownloadParam downloadParam = (DownloadParam) mHttpDownloadParamMap.get(Long.valueOf(j));
            if (!(downloadParam == null || downloadParam.downloader == null)) {
                downloadParam.downloader.stop();
                downloadParam.downloader = null;
                mHttpDownloadParamMap.remove(Long.valueOf(j));
            }
        }
        if (z) {
            C7347a.m21675a(context.getContentResolver(), j, 262144);
        }
    }

    public void onCreate() {
        super.onCreate();
        initMyUri(getApplicationContext());
    }

    public long onEvent(int i, int i2, long j, long j2, Object obj) {
        int i3 = i2;
        C7549a aVar = (C7549a) obj;
        if (aVar == null) {
            return 0;
        }
        long abd = aVar.abd();
        String abb = aVar.abb();
        boolean aaX = aVar.aaX();
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                DownloadParam downloadParam = (DownloadParam) mHttpDownloadParamMap.get(Long.valueOf(abd));
                if (i3 == 1 && downloadParam != null && downloadParam.nSubType == 7) {
                    long aaY = aVar.aaY();
                    long aaZ = aVar.aaZ();
                    int i4 = aaZ == 0 ? 0 : (int) ((aaY * 100) / aaZ);
                    if (i4 > 0 && i4 < 100) {
                        return 0;
                    }
                }
                Intent intent = new Intent(SocialServiceDef.ACTION_FILES_DOWNLOAD);
                intent.putExtra("remote", abb);
                intent.putExtra("_id", abd);
                intent.putExtra(INTERNAL_EXTRAS_DOWNLOAD_TASK_STATUS, i3);
                intent.putExtra(SocialServiceDef.EXTRAS_DOWNLOAD_TASK_SILENT, aaX);
                if (i3 == 1) {
                    Message obtainMessage = mMainHandler.obtainMessage(0, 0, 0, intent);
                    mMainHandler.handleMessage(obtainMessage);
                    obtainMessage.recycle();
                } else {
                    mMainHandler.sendMessage(mMainHandler.obtainMessage(0, 0, 0, intent));
                }
                Throwable abe = aVar.abe();
                if (abe != null) {
                    String activeNetworkName = BaseSocialNotify.getActiveNetworkName(getApplicationContext());
                    HashMap hashMap = new HashMap();
                    String message = abe.getMessage();
                    if (TextUtils.isEmpty(message)) {
                        message = abe.getClass().getSimpleName();
                    }
                    if (!message.contains("unmatch content-len")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("[url]");
                        sb.append(aVar.abb());
                        sb.append(",msg:");
                        sb.append(message);
                        String sb2 = sb.toString();
                        C9537b.m27461bv("DEV_EVENT_Error_Download", sb2);
                        hashMap.put(SocialConstDef.TBL_NAME_MESSAGE, sb2);
                        hashMap.put("Lang", Locale.getDefault().toString());
                        hashMap.put("Network", String.valueOf(activeNetworkName));
                        hashMap.put(ExifInterface.TAG_MODEL, Build.MODEL);
                        hashMap.put("url", aVar.abb());
                        C9561c.aRh().onKVEvent(getApplicationContext(), "DEV_EVENT_Error_Download", hashMap);
                    }
                }
                if (!(downloadParam == null || downloadParam.nUIShowType == 0)) {
                    Bundle bundle = new Bundle();
                    if (i3 == 1) {
                        long currentTimeMillis = System.currentTimeMillis();
                        int downloadProgress = getDownloadProgress(this, abd);
                        if (currentTimeMillis - downloadParam.lLastRunningMsgTimestamp <= 500 && downloadProgress - downloadParam.nLastProgress <= 5) {
                            return 0;
                        }
                        if (downloadProgress > 0 && downloadParam.nLastProgress == downloadProgress) {
                            return 0;
                        }
                        downloadParam.lLastRunningMsgTimestamp = currentTimeMillis;
                        downloadParam.nLastProgress = downloadProgress;
                        bundle.putInt(SocialConstDef.TASK_PROGRESS_1, downloadProgress);
                        bundle.putInt(SocialConstDef.TASK_PROGRESS_2, 100);
                        bundle.putInt("state", 196608);
                    } else if (i3 != 2 && i3 != 3 && i3 != 5) {
                        return 0;
                    } else {
                        bundle.putInt("state", i3 == 2 ? 131072 : 65536);
                    }
                    try {
                        bundle.putInt("_id", (int) abd);
                        bundle.putString(SocialConstDef.TASK_USER_DATA, downloadParam.strTitle);
                        onExecuteServiceNotify("key_notification", 0, bundle);
                        break;
                    } catch (Exception unused) {
                        break;
                    }
                }
                break;
        }
        return 0;
    }

    public void onHandleIntent(Intent intent) {
        Intent intent2 = intent;
        try {
            if (isEnable() && intent2 != null) {
                String action = intent.getAction();
                if (action != null && SocialServiceDef.ACTION_FILES_DOWNLOAD.equals(action)) {
                    if (!FileUtils.isDirectoryExisted(SocialServiceDef.SOCIAL_DOWNLOAD_PATH)) {
                        FileUtils.createMultilevelDirectory(SocialServiceDef.SOCIAL_DOWNLOAD_PATH);
                    }
                    init(this);
                    if (intent2.getIntExtra(INTERNAL_EXTRAS_DOWNLOAD_TASK_STATUS, -1) != -1) {
                        onHandleDownloadEvent(this, intent);
                        autoRestartDownloading();
                        return;
                    }
                    boolean booleanExtra = intent2.getBooleanExtra("stop", false);
                    boolean booleanExtra2 = intent2.getBooleanExtra("clear", false);
                    boolean z = !intent2.getBooleanExtra(SocialServiceDef.EXTRAS_DOWNLOAD_TASK_SILENT, false);
                    boolean booleanExtra3 = intent2.getBooleanExtra("CtrlAll", false);
                    ContentResolver contentResolver = getContentResolver();
                    if (booleanExtra3) {
                        if (booleanExtra || booleanExtra2) {
                            stopAllTask();
                            LogUtils.m14222e(TAG, "Stopped All Task");
                        }
                        if (booleanExtra2) {
                            C7347a.m21682c(contentResolver);
                            LogUtils.m14222e(TAG, "Clear All Pending Task");
                        }
                        if (intent2.getBooleanExtra("restart", false)) {
                            LogUtils.m14222e(TAG, "Restart All Pending Task");
                            C7347a.m21674a(getContentResolver(), 0, 131072);
                        }
                    } else {
                        long longExtra = intent2.getLongExtra("_id", -1);
                        String stringExtra = intent2.getStringExtra("remote");
                        if (stringExtra == null && longExtra == -1) {
                            LogUtils.m14222e(TAG, "Invalid param for download");
                            autoRestartDownloading();
                            return;
                        }
                        if (TextUtils.isEmpty(stringExtra) && longExtra > 0) {
                            stringExtra = getFieldValue(this, longExtra, "remote");
                        }
                        String str = stringExtra;
                        if (TextUtils.isEmpty(str)) {
                            String str2 = TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("strRemote is empty:");
                            sb.append(str);
                            LogUtils.m14222e(str2, sb.toString());
                            autoRestartDownloading();
                            return;
                        } else if (booleanExtra2 || booleanExtra) {
                            stopTask(this, longExtra, booleanExtra);
                            if (booleanExtra2) {
                                String fieldValue = getFieldValue(this, longExtra, "local");
                                if (!TextUtils.isEmpty(fieldValue)) {
                                    C7549a.m22299fW(fieldValue);
                                }
                                C7347a.m21680b(contentResolver, str);
                                String str3 = TAG;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Clear Task: ");
                                sb2.append(str);
                                LogUtils.m14222e(str3, sb2.toString());
                            }
                            reportResult(longExtra, str, 327680, z, 0);
                        } else {
                            String stringExtra2 = intent2.getStringExtra("local");
                            int intExtra = intent2.getIntExtra("priority", 100);
                            String str4 = TAG;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Process Task: ");
                            sb3.append(str);
                            LogUtils.m14222e(str4, sb3.toString());
                            processSingleTask(longExtra, str, stringExtra2, intExtra, booleanExtra, z);
                        }
                    }
                    autoRestartDownloading();
                }
            }
        } catch (Throwable th) {
            SocialService.reportSocialError(this, TAG, C9534a.code9999.getCode(), th.getMessage());
        }
    }
}
