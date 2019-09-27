package com.introvd.template.datacenter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.supportin.media.ExifInterface;
import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.introvd.template.C4677g;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.ExAsyncTask.Status;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.HtmlUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.Utils;
import com.introvd.template.datacenter.model.ProjectSocialParameter;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.p243e.C5542a;
import com.introvd.template.p374q.C8344c;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.p379s.C8374a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.editor.IEditorService;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.xiaoying.p448a.C9537b;
import com.xiaoying.p448a.C9561c;
import com.xiaoying.p448a.C9562d;
import com.xiaoying.p448a.C9567f;
import com.xiaoying.p448a.p449a.C9534a;
import com.xiaoying.p448a.p449a.C9535b;
import com.xiaoying.p448a.p450b.p451a.C9560g;
import com.xiaoying.tool.upload.p458c.C9578b;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class SocialService extends BaseIntentService {
    private static final long ACCESS_TOKEN_EXPIRED_THRESHOLD = 3600000;
    public static final String CONST_URL_HTTP_PREFIX = "http://";
    private static final String EVENT_KEY_VIDEO_UPLOAD_EXCEPTION = "Error_VideoUploadException";
    public static final String EVENT_KEY_VIDEO_UPLOAD_FAIL_ALIONLY = "Dev_Event_Upload_Fail";
    private static final int MSG_SEND_UPGRADE_BROADCAST = 1;
    public static int NETWORK_CONNECT_TIMEOUT = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    public static int NETWORK_RESPONSE_TIMEOUT = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    public static final String PREF_VIDEO_UPLOAD_ERR_KEY = "pref_video_upload_err_key";
    /* access modifiers changed from: private */
    public static final String TAG = "SocialService";
    public static boolean isAWSUseHttps = false;
    private static Handler mHandler;
    static HashMap<String, Long> mResendAPIMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public static final Executor mServiceExecutor = Executors.newCachedThreadPool();
    static C9562d mSocialClient;
    private static String mStrBroadcastVersion;
    private static String mStrLastAppVersion;

    private static class MainHandler extends Handler {
        final WeakReference<SocialService> mSocialServiceRef;

        public MainHandler(Looper looper, SocialService socialService) {
            super(looper);
            this.mSocialServiceRef = new WeakReference<>(socialService);
        }

        public void handleMessage(Message message) {
            SocialService socialService = (SocialService) this.mSocialServiceRef.get();
            if (socialService != null) {
                if (message.what == 1) {
                    removeMessages(1);
                    String str = null;
                    if (message.obj != null) {
                        str = String.valueOf(message.obj);
                    }
                    if (str != null && !str.isEmpty()) {
                        Intent intent = new Intent(SocialServiceDef.ACTION_APK_VERSION_NEW_AVALIABLE);
                        intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_VERSION, str);
                        LocalBroadcastManager.getInstance(socialService).sendBroadcast(intent);
                    }
                }
                super.handleMessage(message);
            }
        }
    }

    private static class RunIntentInExecutor {
        static List<ExAsyncTask> mRunningList = new ArrayList();

        private RunIntentInExecutor() {
        }

        static void cancelAll() {
            synchronized (RunIntentInExecutor.class) {
                try {
                    for (ExAsyncTask exAsyncTask : mRunningList) {
                        if (exAsyncTask.getStatus() != Status.FINISHED) {
                            exAsyncTask.cancel(true);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        static void execute(SocialService socialService, Intent intent) {
            C55401 r0 = new ExAsyncTask<Object, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Object... objArr) {
                    String str;
                    SocialService socialService = objArr[0];
                    Intent intent = objArr[1];
                    try {
                        String action = intent.getAction();
                        if (action == null) {
                            return null;
                        }
                        str = intent.getStringExtra("social_method");
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (SocialServiceDef.ACTION_SOCIAL_SERVICE_USER.equals(action)) {
                                socialService.onUserIntent(intent);
                            } else if (SocialServiceDef.ACTION_SOCIAL_SERVICE_VIDEO.equals(action)) {
                                socialService.onVideoIntent(intent);
                            } else if (SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC.equals(action)) {
                                socialService.onMiscIntent(intent);
                            } else if (SocialServiceDef.ACTION_SOCIAL_SERVICE_INTERACTION.equals(action)) {
                                socialService.onInteractionIntent(intent);
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            String access$400 = SocialService.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("API [");
                            sb.append(str);
                            sb.append("] total cost:");
                            sb.append(currentTimeMillis2 - currentTimeMillis);
                            LogUtils.m14222e(access$400, sb.toString());
                        } catch (Throwable th) {
                            th = th;
                            LogUtils.m14222e(SocialService.TAG, th.getMessage());
                            th.printStackTrace();
                            socialService.reportSocialError(str, C9534a.code9999.getCode(), th.getMessage());
                            return null;
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        str = null;
                        LogUtils.m14222e(SocialService.TAG, th.getMessage());
                        th.printStackTrace();
                        socialService.reportSocialError(str, C9534a.code9999.getCode(), th.getMessage());
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onCancelled() {
                    synchronized (RunIntentInExecutor.class) {
                        RunIntentInExecutor.mRunningList.remove(this);
                    }
                    super.onCancelled();
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    synchronized (RunIntentInExecutor.class) {
                        RunIntentInExecutor.mRunningList.remove(this);
                    }
                    super.onPostExecute(voidR);
                }
            };
            synchronized (RunIntentInExecutor.class) {
                mRunningList.add(r0);
            }
            r0.executeOnExecutor(SocialService.mServiceExecutor, socialService, intent);
        }
    }

    public SocialService() {
        super("SocialService");
        SocialServiceVideoNotify.setServiceCB(this);
        mHandler = new MainHandler(Utils.getHandlerThreadFromCommon().getLooper(), this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0149, code lost:
        return 0;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int UserLoginSync(android.content.Context r17, android.content.Intent r18, com.introvd.template.p243e.C5542a r19) {
        /*
            r0 = r17
            java.lang.Class<com.introvd.template.datacenter.SocialService> r9 = com.introvd.template.datacenter.SocialService.class
            monitor-enter(r9)
            boolean r1 = initXiaoyingClient(r17)     // Catch:{ all -> 0x0166 }
            if (r1 == 0) goto L_0x014a
            java.lang.String r1 = com.introvd.template.datacenter.BaseSocialNotify.getActiveNetworkName(r17)     // Catch:{ all -> 0x0166 }
            if (r1 != 0) goto L_0x0013
            goto L_0x014a
        L_0x0013:
            int r1 = com.introvd.template.datacenter.SocialServiceUserNotify.getUserLoginState()     // Catch:{ all -> 0x0166 }
            r2 = 1
            r8 = 0
            if (r1 != r2) goto L_0x002e
            com.introvd.template.datacenter.SocialServiceUserNotify r1 = com.introvd.template.datacenter.SocialServiceUserNotify.getInstance()     // Catch:{ all -> 0x0166 }
            java.lang.String r3 = "account.login"
            r4 = 0
            r5 = 131072(0x20000, float:1.83671E-40)
            r6 = 0
            r2 = r17
            r7 = r18
            r1.onNotify(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0166 }
            monitor-exit(r9)
            return r8
        L_0x002e:
            int r10 = syncDeviceLogin()     // Catch:{ all -> 0x0166 }
            if (r10 == 0) goto L_0x0047
            com.introvd.template.datacenter.SocialServiceUserNotify r1 = com.introvd.template.datacenter.SocialServiceUserNotify.getInstance()     // Catch:{ all -> 0x0166 }
            java.lang.String r3 = "account.login"
            r4 = 0
            r5 = 65536(0x10000, float:9.18355E-41)
            r2 = r17
            r6 = r10
            r7 = r18
            r1.onNotify(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0166 }
            monitor-exit(r9)
            return r10
        L_0x0047:
            java.lang.String r1 = com.introvd.template.datacenter.TempUserProxy.getUserId()     // Catch:{ all -> 0x0166 }
            java.lang.String r3 = com.introvd.template.datacenter.TempUserProxy.getUserToken()     // Catch:{ all -> 0x0166 }
            int r4 = com.introvd.template.datacenter.TempUserProxy.getSNSType()     // Catch:{ all -> 0x0166 }
            java.lang.String r5 = com.introvd.template.datacenter.TempUserProxy.getSNSId()     // Catch:{ all -> 0x0166 }
            java.lang.String r6 = com.introvd.template.datacenter.TempUserProxy.getSNSToken()     // Catch:{ all -> 0x0166 }
            long r11 = com.introvd.template.datacenter.TempUserProxy.getExpiredTime()     // Catch:{ all -> 0x0166 }
            boolean r7 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0166 }
            if (r7 != 0) goto L_0x0148
            if (r4 <= 0) goto L_0x0148
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0166 }
            if (r7 != 0) goto L_0x0148
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0166 }
            if (r7 == 0) goto L_0x0075
            goto L_0x0148
        L_0x0075:
            com.xiaoying.a.d r7 = mSocialClient     // Catch:{ all -> 0x0166 }
            java.lang.String r13 = "f"
            r7.mo37065bw(r13, r1)     // Catch:{ all -> 0x0166 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0166 }
            r15 = 3600000(0x36ee80, double:1.7786363E-317)
            long r13 = r13 + r15
            r1 = 131072(0x20000, float:1.83671E-40)
            r7 = 0
            int r13 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0099
            com.xiaoying.a.d r4 = mSocialClient     // Catch:{ all -> 0x0166 }
            java.lang.String r5 = "h"
            r4.mo37065bw(r5, r3)     // Catch:{ all -> 0x0166 }
            r15 = r18
            r2 = r7
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x010c
        L_0x0099:
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0166 }
            com.xiaoying.a.d r15 = mSocialClient     // Catch:{ all -> 0x0166 }
            java.lang.String r2 = "h"
            r15.mo37065bw(r2, r7)     // Catch:{ all -> 0x0166 }
            java.lang.String r2 = "social_method"
            r15 = r18
            java.lang.String r2 = r15.getStringExtra(r2)     // Catch:{ all -> 0x0166 }
            com.xiaoying.a.d r7 = mSocialClient     // Catch:{ all -> 0x0166 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0166 }
            com.xiaoying.a.f r2 = r7.mo37070p(r4, r5, r6, r2)     // Catch:{ all -> 0x0166 }
            int r4 = com.introvd.template.datacenter.SocialExceptionHandler.handleException(r0, r2)     // Catch:{ all -> 0x0166 }
            int r5 = r2.eRF     // Catch:{ all -> 0x0166 }
            r6 = 2
            if (r5 != r6) goto L_0x00c1
            monitor-exit(r9)
            return r8
        L_0x00c1:
            if (r4 != r1) goto L_0x0100
            java.lang.Object r2 = r2.eRH     // Catch:{ all -> 0x0166 }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ all -> 0x0166 }
            java.lang.String r3 = "a"
            java.lang.Object r3 = r2.opt(r3)     // Catch:{ all -> 0x0166 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ all -> 0x0166 }
            java.lang.String r5 = "a"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ all -> 0x0166 }
            java.lang.String r6 = "b"
            long r6 = r3.optLong(r6)     // Catch:{ all -> 0x0166 }
            r11 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r11
            long r11 = r13 + r6
            java.lang.String r3 = "b"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ all -> 0x0166 }
            recordServerLoginTime(r0, r3)     // Catch:{ all -> 0x0166 }
            java.lang.String r3 = "c"
            java.lang.Object r2 = r2.opt(r3)     // Catch:{ all -> 0x0166 }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ all -> 0x0166 }
            if (r2 == 0) goto L_0x00fc
            java.lang.String r3 = "a"
            java.lang.String r2 = r2.optString(r3)     // Catch:{ all -> 0x0166 }
            r7 = r2
            goto L_0x00fd
        L_0x00fc:
            r7 = 0
        L_0x00fd:
            r3 = r5
            r2 = 0
            goto L_0x010b
        L_0x0100:
            int r5 = r2.getErrorCode()     // Catch:{ all -> 0x0166 }
            java.lang.String r7 = r2.aRm()     // Catch:{ all -> 0x0166 }
            r10 = r5
            r2 = r7
            r7 = 0
        L_0x010b:
            r5 = r4
        L_0x010c:
            if (r5 != r1) goto L_0x0121
            com.introvd.template.datacenter.SocialServiceUserNotify.setXYAccessToken(r3)     // Catch:{ all -> 0x0166 }
            com.introvd.template.datacenter.SocialServiceUserNotify.setXYAccessTokenExpiredTime(r11)     // Catch:{ all -> 0x0166 }
            r1 = 1
            com.introvd.template.datacenter.SocialServiceUserNotify.setUserLoginState(r1)     // Catch:{ all -> 0x0166 }
            handleNewAppVersion(r7)     // Catch:{ all -> 0x0166 }
            if (r3 == 0) goto L_0x0135
            com.introvd.template.datacenter.TempUserProxy.saveToken(r3, r11)     // Catch:{ all -> 0x0166 }
            goto L_0x0135
        L_0x0121:
            r1 = 65536(0x10000, float:9.18355E-41)
            if (r5 != r1) goto L_0x0135
            r1 = -1
            com.introvd.template.datacenter.SocialServiceUserNotify.setUserLoginState(r1)     // Catch:{ all -> 0x0166 }
            java.lang.String r1 = "account.login"
            reportSocialError(r0, r1, r10, r2)     // Catch:{ all -> 0x0166 }
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0166 }
            java.lang.String r2 = "userLogin login failed!"
            com.introvd.template.common.LogUtils.m14222e(r1, r2)     // Catch:{ all -> 0x0166 }
        L_0x0135:
            com.introvd.template.datacenter.SocialServiceUserNotify r1 = com.introvd.template.datacenter.SocialServiceUserNotify.getInstance()     // Catch:{ all -> 0x0166 }
            java.lang.String r3 = "account.login"
            r4 = 0
            r2 = r17
            r6 = r10
            r7 = r18
            r8 = r19
            r1.onNotify(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0166 }
            monitor-exit(r9)
            return r10
        L_0x0148:
            monitor-exit(r9)
            return r8
        L_0x014a:
            r15 = r18
            com.introvd.template.datacenter.SocialServiceUserNotify r1 = com.introvd.template.datacenter.SocialServiceUserNotify.getInstance()     // Catch:{ all -> 0x0166 }
            java.lang.String r3 = "account.login"
            r4 = 0
            r5 = 65536(0x10000, float:9.18355E-41)
            r6 = 1001(0x3e9, float:1.403E-42)
            r2 = r17
            r7 = r18
            r1.onNotify(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0166 }
            com.xiaoying.a.a.a r0 = com.xiaoying.p448a.p449a.C9534a.code9902     // Catch:{ all -> 0x0166 }
            int r0 = r0.getCode()     // Catch:{ all -> 0x0166 }
            monitor-exit(r9)
            return r0
        L_0x0166:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialService.UserLoginSync(android.content.Context, android.content.Intent, com.introvd.template.e.a):int");
    }

    public static void UserLogoutSync(Context context, C5542a aVar) {
        if (initXiaoyingClient(context) && mSocialClient != null) {
            TempUserProxy.clearExpireTime();
            SocialServiceUserNotify.setXYAccessToken(null);
            SocialServiceUserNotify.setXYAccessTokenExpiredTime(0);
            SocialServiceUserNotify.setUserLoginState(0);
            SocialServiceUserNotify.getInstance().onNotify(context, SocialServiceDef.SOCIAL_USER_METHOD_LOGOUT, null, 131072, 0, null, aVar);
            int sNSType = TempUserProxy.getSNSType();
            String userId = TempUserProxy.getUserId();
            if (!TextUtils.isEmpty(userId)) {
                mSocialClient.mo37066bx(String.valueOf(sNSType), userId);
            }
        }
    }

    private static synchronized void checkNewAppVersionIfNeccessary() {
        synchronized (SocialService.class) {
            if (mHandler != null) {
                if (!TextUtils.isEmpty(mStrLastAppVersion)) {
                    if (C8345d.aKc()) {
                        mHandler.sendMessageDelayed(mHandler.obtainMessage(1, mStrLastAppVersion), DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                        mStrBroadcastVersion = mStrLastAppVersion;
                        mStrLastAppVersion = null;
                    }
                }
            }
        }
    }

    public static int checkRecvFlagAndUploadType(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            if (!str2.equals(SocialServiceDef.USER_INFO_STATE_INVALID) && !str2.equals("10") && !str2.equals("13")) {
                return 65536;
            }
            str = "0";
        }
        return (TextUtils.isEmpty(str) || (!str.equals("-1") && !str.equals("3"))) ? 0 : 131072;
    }

    public static C9578b createUploaderFileEntity(String str, JSONObject jSONObject, String str2) {
        C9578b bVar = new C9578b();
        bVar.mo37132sh(jSONObject.optString("d"));
        bVar.mo37130sf(str);
        bVar.mo37131sg(new File(str2).getAbsolutePath());
        bVar.mo37133si(jSONObject.optString("j"));
        bVar.mo37134sj(jSONObject.optString("e"));
        bVar.mo37135sk(jSONObject.optString("f"));
        bVar.mo37136sl(jSONObject.optString("h"));
        bVar.mo37137sm(jSONObject.optString("o"));
        bVar.mo37138sn(jSONObject.optString(TtmlNode.TAG_P));
        bVar.mo37139so(jSONObject.optString("n"));
        bVar.mo37140sp(jSONObject.optString("q"));
        bVar.mo37141sq(jSONObject.optString(C4677g.TAG));
        bVar.eUe = isAWSUseHttps;
        return bVar;
    }

    private void doFileUploadRequest(String str, String str2, String str3) {
        C8374a aVar = new C8374a(this, str3);
        try {
            aVar.executeOnExecutor(mServiceExecutor, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fileUpload(Context context, String str, int i, String str2) {
        if (FileUtils.isFileExisted(str)) {
            try {
                String fileName = FileUtils.getFileName(str);
                String E = C9560g.m27509E(new File(str));
                C9567f a = mSocialClient.mo37060a("", fileName, FileUtils.getFileType(str), E, FileUtils.fileSize(str), i);
                if (SocialExceptionHandler.handleException(this, a) != 131072 || a.eRH == null) {
                    LocalBroadcastManager.getInstance(context).sendBroadcast(C9535b.m27459wH(i));
                    return;
                }
                doFileUploadRequest(str, a.eRH.toString(), str2);
            } catch (Exception e) {
                e.printStackTrace();
                LocalBroadcastManager.getInstance(context).sendBroadcast(C9535b.m27459wH(i));
            }
        }
    }

    private int formatServerDuration(String str) {
        int i;
        int i2 = 0;
        if (TextUtils.isEmpty(str) || !str.contains(":")) {
            return 0;
        }
        try {
            String[] split = str.split(":");
            i = 0;
            while (i2 < split.length) {
                try {
                    i = (i * 60) + Integer.parseInt(split[i2]);
                    i2++;
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            i = 0;
        }
        return i * 1000;
    }

    private static long formatServerTime2AndroidMS(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 14) {
            return 0;
        }
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(str).getTime();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private static String getSecret(Context context, String str) {
        String str2 = null;
        try {
            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
            if (iEditorService == null) {
                return null;
            }
            iEditorService.libraryMgrSetContext(context);
            if (iEditorService.loadLibraryBaseMode()) {
                str2 = SimpleSocialSecurity.getInstance(context.getApplicationContext()).createMD5Encrypt(str, SimpleSocialSecurity.getInstance(context.getApplicationContext()).makeAppSecretKey(str, new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(System.currentTimeMillis())), DeviceInfo.getLocalMacAddress(context)));
            }
            return str2;
        } catch (Throwable th) {
            LogUtils.m14222e(TAG, th.getMessage());
        }
    }

    public static String getUrlKey(String str, String str2) {
        return SocialServiceDef.ACTION_SOCIAL_SERVICE_VIDEO.equals(str) ? "v" : str2.startsWith("device.") ? "d" : str2.startsWith("account.") ? C5878a.TAG : str2.startsWith("user.") ? "u" : str2.startsWith("template.") ? "t" : str2.startsWith("activity.") ? "y" : str2.startsWith("comment.") ? TtmlNode.TAG_P : str2.startsWith("follow.") ? C4677g.TAG : str2.startsWith("messagecenter.") ? "m" : str2.startsWith("search.") ? Event.SEARCH : str2.startsWith("im.") ? "h" : str2.startsWith("support.") ? "s" : str2.startsWith("share.") ? "v" : str2.startsWith("recommend.") ? "r" : "Unknown";
    }

    private static synchronized void handleNewAppVersion(String str) {
        synchronized (SocialService.class) {
            if (str != null) {
                if (!str.equals(mStrLastAppVersion)) {
                    if (!str.equals(mStrBroadcastVersion)) {
                        mStrLastAppVersion = str;
                        checkNewAppVersionIfNeccessary();
                    }
                }
            }
        }
    }

    private boolean handlePassThroughMethod(final Intent intent) {
        final String stringExtra = intent.getStringExtra("social_method");
        if (TextUtils.isEmpty(stringExtra) || !stringExtra.startsWith("passthrough.")) {
            return false;
        }
        new ExAsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0091, code lost:
                if (com.xiaoying.p448a.p450b.p451a.C9558f.m27502a(1, "http://reportevent.xiaoying.co/event", r2, com.xiaoying.p448a.C9537b.getConnectionTimeout(), com.xiaoying.p448a.C9537b.getSocketTimeout()).aRo() == false) goto L_0x011c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x011a, code lost:
                if (r13.aRo() == false) goto L_0x011c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x0120, code lost:
                if (r1 != false) goto L_0x0139;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x0137, code lost:
                if (r1 == false) goto L_0x0147;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x0139, code lost:
                r0.putString("social_method", r0);
                r12.this$0.onExecuteServiceNotify("key_api_method", r3, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x0148, code lost:
                return null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
                r13 = th;
             */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x001d, B:34:0x00f6] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00f6 */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x010c A[Catch:{ Throwable -> 0x002b, all -> 0x0028 }] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x0127  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0028 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x001d] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Void doInBackground(java.lang.Void... r13) {
                /*
                    r12 = this;
                    android.content.Intent r13 = r4
                    android.os.Bundle r13 = r13.getExtras()
                    android.os.Bundle r0 = new android.os.Bundle
                    r0.<init>()
                    r1 = 1
                    r2 = 0
                    r3 = 131072(0x20000, float:1.83671E-40)
                    java.lang.String r4 = "passthrough.callback"
                    java.lang.String r5 = r0     // Catch:{ Throwable -> 0x0136, all -> 0x0123 }
                    boolean r4 = r4.equals(r5)     // Catch:{ Throwable -> 0x0136, all -> 0x0123 }
                    r5 = 65536(0x10000, float:9.18355E-41)
                    if (r4 == 0) goto L_0x002e
                    if (r13 == 0) goto L_0x0120
                    android.content.Intent r13 = r4     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    android.os.Bundle r13 = r13.getExtras()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r0.putAll(r13)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    goto L_0x0120
                L_0x0028:
                    r13 = move-exception
                    goto L_0x0125
                L_0x002b:
                    goto L_0x0137
                L_0x002e:
                    java.lang.String r4 = "passthrough.reportevent"
                    java.lang.String r6 = r0     // Catch:{ Throwable -> 0x0136, all -> 0x0123 }
                    boolean r4 = r4.equals(r6)     // Catch:{ Throwable -> 0x0136, all -> 0x0123 }
                    if (r4 == 0) goto L_0x0095
                    java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r2.<init>()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    org.apache.http.message.BasicNameValuePair r4 = new org.apache.http.message.BasicNameValuePair     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r6 = "from"
                    java.lang.String r7 = "request_video_from"
                    java.lang.String r7 = r13.getString(r7)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r4.<init>(r6, r7)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r2.add(r4)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    org.apache.http.message.BasicNameValuePair r4 = new org.apache.http.message.BasicNameValuePair     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r6 = "eventid"
                    java.lang.String r7 = "request_type"
                    java.lang.String r7 = r13.getString(r7)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r4.<init>(r6, r7)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r2.add(r4)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    org.apache.http.message.BasicNameValuePair r4 = new org.apache.http.message.BasicNameValuePair     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r6 = "userjson"
                    java.lang.String r7 = "request_param1"
                    java.lang.String r7 = r13.getString(r7)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r4.<init>(r6, r7)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r2.add(r4)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r4 = "request_param2"
                    java.lang.String r13 = r13.getString(r4)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    if (r13 == 0) goto L_0x007f
                    org.apache.http.message.BasicNameValuePair r4 = new org.apache.http.message.BasicNameValuePair     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r6 = "comjson"
                    r4.<init>(r6, r13)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r2.add(r4)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                L_0x007f:
                    java.lang.String r13 = "http://reportevent.xiaoying.co/event"
                    int r4 = com.xiaoying.p448a.C9537b.getConnectionTimeout()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    int r6 = com.xiaoying.p448a.C9537b.getSocketTimeout()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    com.xiaoying.a.b.a.a r13 = com.xiaoying.p448a.p450b.p451a.C9558f.m27502a(r1, r13, r2, r4, r6)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    boolean r13 = r13.aRo()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    if (r13 != 0) goto L_0x0120
                    goto L_0x011c
                L_0x0095:
                    java.lang.String r13 = "passthrough.httprequest"
                    java.lang.String r4 = r0     // Catch:{ Throwable -> 0x0136, all -> 0x0123 }
                    boolean r13 = r13.equals(r4)     // Catch:{ Throwable -> 0x0136, all -> 0x0123 }
                    if (r13 == 0) goto L_0x011f
                    android.content.Intent r13 = r4     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r2 = "request_param1"
                    java.lang.String r13 = r13.getStringExtra(r2)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    android.content.Intent r2 = r4     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r4 = "request_param2"
                    java.lang.String r2 = r2.getStringExtra(r4)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    android.content.Intent r4 = r4     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r6 = "request_type"
                    int r4 = r4.getIntExtra(r6, r1)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r6 = "request_param1"
                    r0.putString(r6, r13)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    r6.<init>()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    if (r7 != 0) goto L_0x00f6
                    org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    r7.<init>(r2)     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    java.util.Iterator r2 = r7.keys()     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                L_0x00d0:
                    boolean r8 = r2.hasNext()     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    if (r8 == 0) goto L_0x00f6
                    java.lang.Object r8 = r2.next()     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    java.lang.Object r9 = r7.opt(r8)     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    if (r9 == 0) goto L_0x00d0
                    org.apache.http.message.BasicNameValuePair r10 = new org.apache.http.message.BasicNameValuePair     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    java.lang.String r11 = r9.toString()     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    r10.<init>(r8, r11)     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    r6.add(r10)     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    r0.putString(r8, r9)     // Catch:{ Throwable -> 0x00f6, all -> 0x0028 }
                    goto L_0x00d0
                L_0x00f6:
                    int r2 = com.xiaoying.p448a.C9537b.getConnectionTimeout()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    int r7 = com.xiaoying.p448a.C9537b.getSocketTimeout()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    com.xiaoying.a.b.a.a r13 = com.xiaoying.p448a.p450b.p451a.C9558f.m27502a(r4, r13, r6, r2, r7)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    java.lang.String r2 = r13.aRp()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    int r4 = r13.aRq()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    if (r2 == 0) goto L_0x0111
                    java.lang.String r6 = "ResponseRawData"
                    r0.putString(r6, r2)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                L_0x0111:
                    java.lang.String r2 = "ResponseHttpCode"
                    r0.putInt(r2, r4)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    boolean r13 = r13.aRo()     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                    if (r13 != 0) goto L_0x0120
                L_0x011c:
                    r3 = 65536(0x10000, float:9.18355E-41)
                    goto L_0x0120
                L_0x011f:
                    r1 = 0
                L_0x0120:
                    if (r1 == 0) goto L_0x0147
                    goto L_0x0139
                L_0x0123:
                    r13 = move-exception
                    r1 = 0
                L_0x0125:
                    if (r1 == 0) goto L_0x0135
                    java.lang.String r1 = r0
                    java.lang.String r2 = "social_method"
                    r0.putString(r2, r1)
                    com.introvd.template.datacenter.SocialService r1 = com.introvd.template.datacenter.SocialService.this
                    java.lang.String r2 = "key_api_method"
                    r1.onExecuteServiceNotify(r2, r3, r0)
                L_0x0135:
                    throw r13
                L_0x0136:
                    r1 = 0
                L_0x0137:
                    if (r1 == 0) goto L_0x0147
                L_0x0139:
                    java.lang.String r13 = "social_method"
                    java.lang.String r1 = r0
                    r0.putString(r13, r1)
                    com.introvd.template.datacenter.SocialService r13 = com.introvd.template.datacenter.SocialService.this
                    java.lang.String r1 = "key_api_method"
                    r13.onExecuteServiceNotify(r1, r3, r0)
                L_0x0147:
                    r13 = 0
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialService.C55391.doInBackground(java.lang.Void[]):java.lang.Void");
            }
        }.execute((Params[]) new Void[0]);
        return true;
    }

    public static String htmlDecode(String str) {
        return HtmlUtils.decode(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0239 A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x031c A[Catch:{ Throwable -> 0x0323 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0325 A[SYNTHETIC, Splitter:B:119:0x0325] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0365 A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0081 A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091 A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c6 A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00da A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ee A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0102 A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0113 A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0126 A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x012a A[Catch:{ Throwable -> 0x008a, all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0221 A[SYNTHETIC, Splitter:B:94:0x0221] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x022a A[SYNTHETIC, Splitter:B:99:0x022a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean initXiaoyingClient(android.content.Context r12) {
        /*
            java.lang.Class<com.introvd.template.datacenter.SocialService> r0 = com.introvd.template.datacenter.SocialService.class
            monitor-enter(r0)
            int r1 = NETWORK_CONNECT_TIMEOUT     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.setConnectionTimeout(r1)     // Catch:{ all -> 0x03af }
            int r1 = NETWORK_RESPONSE_TIMEOUT     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.setSocketTimeout(r1)     // Catch:{ all -> 0x03af }
            java.lang.String r1 = "SocialURLMap"
            java.lang.Object r1 = com.xiaoying.p448a.C9537b.m27463rU(r1)     // Catch:{ all -> 0x03af }
            r2 = 0
            if (r1 != 0) goto L_0x0018
            monitor-exit(r0)
            return r2
        L_0x0018:
            com.xiaoying.a.d r1 = mSocialClient     // Catch:{ all -> 0x03af }
            r3 = 1
            if (r1 != 0) goto L_0x03ad
            java.lang.String r1 = com.introvd.template.channel.C5206b.m14212dV(r12)     // Catch:{ all -> 0x03af }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x03af }
            if (r4 == 0) goto L_0x0030
            java.lang.String r12 = TAG     // Catch:{ all -> 0x03af }
            java.lang.String r1 = "invalid app key"
            com.introvd.template.common.LogUtils.m14222e(r12, r1)     // Catch:{ all -> 0x03af }
            monitor-exit(r0)
            return r2
        L_0x0030:
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "yyyyMMddHHmmss"
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ all -> 0x03af }
            r4.<init>(r5, r6)     // Catch:{ all -> 0x03af }
            r5 = 0
            java.lang.Class<com.introvd.template.router.editor.IEditorService> r6 = com.introvd.template.router.editor.IEditorService.class
            com.aiii.android.arouter.facade.template.c r6 = com.introvd.template.router.BizServiceManager.getService(r6)     // Catch:{ Throwable -> 0x008a, all -> 0x007a }
            com.introvd.template.router.editor.IEditorService r6 = (com.introvd.template.router.editor.IEditorService) r6     // Catch:{ Throwable -> 0x008a, all -> 0x007a }
            if (r6 == 0) goto L_0x004a
            r6.libraryMgrSetContext(r12)     // Catch:{ Throwable -> 0x008a, all -> 0x007a }
            r6.loadLibraryBaseMode()     // Catch:{ Throwable -> 0x008a, all -> 0x007a }
        L_0x004a:
            java.lang.String r6 = getSecret(r12, r1)     // Catch:{ Throwable -> 0x008a, all -> 0x007a }
            if (r6 != 0) goto L_0x006a
            android.content.Context r7 = r12.getApplicationContext()     // Catch:{ Throwable -> 0x008b, all -> 0x0067 }
            com.introvd.template.datacenter.SimpleSocialSecurity r7 = com.introvd.template.datacenter.SimpleSocialSecurity.getInstance(r7)     // Catch:{ Throwable -> 0x008b, all -> 0x0067 }
            java.util.Date r8 = new java.util.Date     // Catch:{ Throwable -> 0x008b, all -> 0x0067 }
            r8.<init>()     // Catch:{ Throwable -> 0x008b, all -> 0x0067 }
            java.lang.String r8 = r4.format(r8)     // Catch:{ Throwable -> 0x008b, all -> 0x0067 }
            java.lang.String r7 = r7.makeSecretKey(r8)     // Catch:{ Throwable -> 0x008b, all -> 0x0067 }
            r6 = r7
            goto L_0x006a
        L_0x0067:
            r12 = move-exception
            r5 = r6
            goto L_0x007b
        L_0x006a:
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x03af }
            if (r7 == 0) goto L_0x0097
            java.util.Date r6 = new java.util.Date     // Catch:{ all -> 0x03af }
            r6.<init>()     // Catch:{ all -> 0x03af }
        L_0x0075:
            java.lang.String r6 = r4.format(r6)     // Catch:{ all -> 0x03af }
            goto L_0x0097
        L_0x007a:
            r12 = move-exception
        L_0x007b:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x03af }
            if (r1 == 0) goto L_0x0089
            java.util.Date r1 = new java.util.Date     // Catch:{ all -> 0x03af }
            r1.<init>()     // Catch:{ all -> 0x03af }
            r4.format(r1)     // Catch:{ all -> 0x03af }
        L_0x0089:
            throw r12     // Catch:{ all -> 0x03af }
        L_0x008a:
            r6 = r5
        L_0x008b:
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x03af }
            if (r7 == 0) goto L_0x0097
            java.util.Date r6 = new java.util.Date     // Catch:{ all -> 0x03af }
            r6.<init>()     // Catch:{ all -> 0x03af }
            goto L_0x0075
        L_0x0097:
            java.lang.String r4 = com.introvd.template.common.CommonConfigure.APP_LOG_PATH     // Catch:{ all -> 0x03af }
            boolean r4 = com.introvd.template.common.FileUtils.isDirectoryExisted(r4)     // Catch:{ all -> 0x03af }
            r7 = 31
            if (r4 != 0) goto L_0x00ab
            boolean r4 = com.introvd.template.common.Utils.isOfficalVersion(r12)     // Catch:{ all -> 0x03af }
            if (r4 == 0) goto L_0x00ab
            int r4 = com.introvd.template.common.LogUtils.mlogLevel     // Catch:{ all -> 0x03af }
            if (r4 != r7) goto L_0x00b0
        L_0x00ab:
            com.xiaoying.p448a.C9537b.m27462kr(r3)     // Catch:{ all -> 0x03af }
            com.introvd.template.common.LogUtils.mlogLevel = r7     // Catch:{ all -> 0x03af }
        L_0x00b0:
            com.introvd.template.util.a r4 = new com.introvd.template.util.a     // Catch:{ all -> 0x03af }
            android.content.Context r7 = r12.getApplicationContext()     // Catch:{ all -> 0x03af }
            java.lang.String r8 = com.introvd.template.common.CommonConfigure.APP_LOG_PATH     // Catch:{ all -> 0x03af }
            r4.<init>(r7, r8)     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.m27460a(r4)     // Catch:{ all -> 0x03af }
            java.lang.String r4 = "DelayServerErr"
            java.lang.Object r4 = com.xiaoying.p448a.C9537b.m27463rU(r4)     // Catch:{ all -> 0x03af }
            if (r4 != 0) goto L_0x00d2
            java.lang.String r4 = "DelayServerErr"
            r7 = 900000(0xdbba0, double:4.44659E-318)
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.setParameter(r4, r7)     // Catch:{ all -> 0x03af }
        L_0x00d2:
            java.lang.String r4 = "DelayDULocked"
            java.lang.Object r4 = com.xiaoying.p448a.C9537b.m27463rU(r4)     // Catch:{ all -> 0x03af }
            if (r4 != 0) goto L_0x00e6
            java.lang.String r4 = "DelayDULocked"
            r7 = 14400000(0xdbba00, double:7.1145453E-317)
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.setParameter(r4, r7)     // Catch:{ all -> 0x03af }
        L_0x00e6:
            java.lang.String r4 = "DelayOther"
            java.lang.Object r4 = com.xiaoying.p448a.C9537b.m27463rU(r4)     // Catch:{ all -> 0x03af }
            if (r4 != 0) goto L_0x00fa
            java.lang.String r4 = "DelayOther"
            r7 = 300000(0x493e0, double:1.482197E-318)
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.setParameter(r4, r7)     // Catch:{ all -> 0x03af }
        L_0x00fa:
            java.lang.String r4 = "SetSSL"
            java.lang.Object r4 = com.xiaoying.p448a.C9537b.m27463rU(r4)     // Catch:{ all -> 0x03af }
            if (r4 != 0) goto L_0x010b
            java.lang.String r4 = "SetSSL"
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.setParameter(r4, r7)     // Catch:{ all -> 0x03af }
        L_0x010b:
            java.lang.String r4 = "SetMethodName"
            java.lang.Object r4 = com.xiaoying.p448a.C9537b.m27463rU(r4)     // Catch:{ all -> 0x03af }
            if (r4 != 0) goto L_0x011c
            java.lang.String r4 = "SetMethodName"
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.setParameter(r4, r7)     // Catch:{ all -> 0x03af }
        L_0x011c:
            java.lang.String r4 = "SocialURLMap"
            java.lang.Object r4 = com.xiaoying.p448a.C9537b.m27463rU(r4)     // Catch:{ all -> 0x03af }
            boolean r7 = r4 instanceof java.util.HashMap     // Catch:{ all -> 0x03af }
            if (r7 == 0) goto L_0x012a
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ all -> 0x03af }
            goto L_0x034b
        L_0x012a:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x03af }
            r4.<init>()     // Catch:{ all -> 0x03af }
            java.lang.String r7 = com.introvd.template.common.CommonConfigure.APP_SOCIAL_SERVER_URL_CFG_FULLNAME     // Catch:{ all -> 0x03af }
            boolean r7 = com.introvd.template.common.FileUtils.isFileExisted(r7)     // Catch:{ all -> 0x03af }
            if (r7 == 0) goto L_0x0233
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0218, all -> 0x0215 }
            java.io.File r8 = new java.io.File     // Catch:{ Throwable -> 0x0218, all -> 0x0215 }
            java.lang.String r9 = com.introvd.template.common.CommonConfigure.APP_SOCIAL_SERVER_URL_CFG_FULLNAME     // Catch:{ Throwable -> 0x0218, all -> 0x0215 }
            r8.<init>(r9)     // Catch:{ Throwable -> 0x0218, all -> 0x0215 }
            r7.<init>(r8)     // Catch:{ Throwable -> 0x0218, all -> 0x0215 }
            org.apache.http.util.ByteArrayBuffer r5 = new org.apache.http.util.ByteArrayBuffer     // Catch:{ Throwable -> 0x0213 }
            r8 = 1024(0x400, float:1.435E-42)
            r5.<init>(r8)     // Catch:{ Throwable -> 0x0213 }
            byte[] r8 = new byte[r8]     // Catch:{ Throwable -> 0x0213 }
        L_0x014c:
            int r9 = r7.read(r8)     // Catch:{ Throwable -> 0x0213 }
            r10 = -1
            if (r9 == r10) goto L_0x0157
            r5.append(r8, r2, r9)     // Catch:{ Throwable -> 0x0213 }
            goto L_0x014c
        L_0x0157:
            java.lang.String r8 = new java.lang.String     // Catch:{ Throwable -> 0x0213 }
            byte[] r5 = r5.buffer()     // Catch:{ Throwable -> 0x0213 }
            r8.<init>(r5)     // Catch:{ Throwable -> 0x0213 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0213 }
            r5.<init>(r8)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "d"
            java.lang.String r9 = "d"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "a"
            java.lang.String r9 = "a"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "u"
            java.lang.String r9 = "u"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "v"
            java.lang.String r9 = "v"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "s"
            java.lang.String r9 = "s"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "r"
            java.lang.String r9 = "r"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "m"
            java.lang.String r9 = "m"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "t"
            java.lang.String r9 = "t"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "y"
            java.lang.String r9 = "y"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "p"
            java.lang.String r9 = "p"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "g"
            java.lang.String r9 = "g"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "search"
            java.lang.String r9 = "search"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "h"
            java.lang.String r9 = "h"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "ad"
            java.lang.String r9 = "ad"
            java.lang.String r9 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r9)     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r8 = "push"
            java.lang.String r9 = "push"
            java.lang.String r5 = r5.optString(r9)     // Catch:{ Throwable -> 0x0213 }
            r4.put(r8, r5)     // Catch:{ Throwable -> 0x0213 }
            r7.close()     // Catch:{ IOException -> 0x020e }
            goto L_0x0233
        L_0x020e:
            r5 = move-exception
        L_0x020f:
            r5.printStackTrace()     // Catch:{ all -> 0x03af }
            goto L_0x0233
        L_0x0213:
            r5 = move-exception
            goto L_0x021c
        L_0x0215:
            r12 = move-exception
            r7 = r5
            goto L_0x0228
        L_0x0218:
            r7 = move-exception
            r11 = r7
            r7 = r5
            r5 = r11
        L_0x021c:
            r5.printStackTrace()     // Catch:{ all -> 0x0227 }
            if (r7 == 0) goto L_0x0233
            r7.close()     // Catch:{ IOException -> 0x0225 }
            goto L_0x0233
        L_0x0225:
            r5 = move-exception
            goto L_0x020f
        L_0x0227:
            r12 = move-exception
        L_0x0228:
            if (r7 == 0) goto L_0x0232
            r7.close()     // Catch:{ IOException -> 0x022e }
            goto L_0x0232
        L_0x022e:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x03af }
        L_0x0232:
            throw r12     // Catch:{ all -> 0x03af }
        L_0x0233:
            boolean r5 = r4.isEmpty()     // Catch:{ all -> 0x03af }
            if (r5 == 0) goto L_0x0312
            boolean r5 = com.introvd.template.common.Utils.isOfficalVersion(r12)     // Catch:{ all -> 0x03af }
            if (r5 == 0) goto L_0x02a9
            java.lang.String r5 = "d"
            java.lang.String r7 = "https://d.api.xiaoying.co/api/rest/d"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "a"
            java.lang.String r7 = "https://a.api.xiaoying.co/api/rest/a"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "u"
            java.lang.String r7 = "https://u.api.xiaoying.co/api/rest/u"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "v"
            java.lang.String r7 = "http://v.api.xiaoying.co/api/rest/v"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "s"
            java.lang.String r7 = "http://s.api.xiaoying.co/api/rest/s"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "r"
            java.lang.String r7 = "http://r.api.xiaoying.co/api/rest/r"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "m"
            java.lang.String r7 = "http://m.api.xiaoying.co/api/rest/m"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "t"
            java.lang.String r7 = "http://t.api.xiaoying.co/api/rest/t"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "y"
            java.lang.String r7 = "http://y.api.xiaoying.co/api/rest/y"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "p"
            java.lang.String r7 = "http://p.api.xiaoying.co/api/rest/p"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "g"
            java.lang.String r7 = "http://g.api.xiaoying.co/api/rest/g"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "search"
            java.lang.String r7 = "http://search.api.xiaoying.co/api/rest/search"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "h"
            java.lang.String r7 = "https://h.api.xiaoying.co/api/rest/h"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "ad"
            java.lang.String r7 = "http://s.api.xiaoying.co/api/rest/ad"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "push"
            java.lang.String r7 = "http://push.api.xiaoying.co/api/rest/push"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            goto L_0x0312
        L_0x02a9:
            java.lang.String r5 = "d"
            java.lang.String r7 = "https://d.api.pre.xiaoying.co/api/rest/d"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "a"
            java.lang.String r7 = "https://a.api.pre.xiaoying.co/api/rest/a"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "u"
            java.lang.String r7 = "https://u.api.pre.xiaoying.co/api/rest/u"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "v"
            java.lang.String r7 = "http://v.api.pre.xiaoying.co/api/rest/v"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "s"
            java.lang.String r7 = "http://s.api.pre.xiaoying.co/api/rest/s"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "r"
            java.lang.String r7 = "http://r.api.pre.xiaoying.co/api/rest/r"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "m"
            java.lang.String r7 = "http://m.api.pre.xiaoying.co/api/rest/m"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "t"
            java.lang.String r7 = "http://t.api.pre.xiaoying.co/api/rest/t"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "y"
            java.lang.String r7 = "http://y.api.pre.xiaoying.co/api/rest/y"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "p"
            java.lang.String r7 = "http://p.api.pre.xiaoying.co/api/rest/p"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "g"
            java.lang.String r7 = "http://g.api.pre.xiaoying.co/api/rest/g"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "search"
            java.lang.String r7 = "http://search.api.pre.xiaoying.co/api/rest/search"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "h"
            java.lang.String r7 = "https://h.api.pre.xiaoying.co/api/rest/h"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "ad"
            java.lang.String r7 = "http://s.api.pre.xiaoying.co/api/rest/ad"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "push"
            java.lang.String r7 = "http://push.api.pre.xiaoying.co/api/rest/push"
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
        L_0x0312:
            java.lang.String r5 = "SetSSL"
            java.lang.Object r5 = com.xiaoying.p448a.C9537b.m27463rU(r5)     // Catch:{ Throwable -> 0x0323 }
            boolean r7 = r5 instanceof java.lang.Boolean     // Catch:{ Throwable -> 0x0323 }
            if (r7 == 0) goto L_0x0323
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Throwable -> 0x0323 }
            boolean r5 = r5.booleanValue()     // Catch:{ Throwable -> 0x0323 }
            r2 = r5
        L_0x0323:
            if (r2 != 0) goto L_0x034b
            java.util.Set r2 = r4.keySet()     // Catch:{ all -> 0x03af }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x03af }
        L_0x032d:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x03af }
            if (r5 == 0) goto L_0x034b
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x03af }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x03af }
            java.lang.Object r7 = r4.get(r5)     // Catch:{ all -> 0x03af }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x03af }
            java.lang.String r8 = "https://"
            java.lang.String r9 = "http://"
            java.lang.String r7 = r7.replace(r8, r9)     // Catch:{ all -> 0x03af }
            r4.put(r5, r7)     // Catch:{ all -> 0x03af }
            goto L_0x032d
        L_0x034b:
            java.lang.String r2 = "AppContext"
            android.content.Context r5 = r12.getApplicationContext()     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.setParameter(r2, r5)     // Catch:{ all -> 0x03af }
            java.lang.String r2 = "SocialURLMap"
            com.xiaoying.p448a.C9537b.setParameter(r2, r4)     // Catch:{ all -> 0x03af }
            java.lang.String r2 = "AppKey"
            java.lang.String r2 = com.xiaoying.p448a.C9537b.getParameter(r2)     // Catch:{ all -> 0x03af }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x03af }
            if (r2 == 0) goto L_0x036a
            java.lang.String r2 = "AppKey"
            com.xiaoying.p448a.C9537b.setParameter(r2, r1)     // Catch:{ all -> 0x03af }
        L_0x036a:
            java.lang.String r2 = "AppSecret"
            com.xiaoying.p448a.C9537b.setParameter(r2, r6)     // Catch:{ all -> 0x03af }
            java.lang.String r2 = "XiaoYingID"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03af }
            r4.<init>()     // Catch:{ all -> 0x03af }
            java.lang.String r5 = "[A]"
            r4.append(r5)     // Catch:{ all -> 0x03af }
            java.lang.String r5 = com.introvd.template.common.DeviceInfo.getOpenUDID(r12)     // Catch:{ all -> 0x03af }
            r4.append(r5)     // Catch:{ all -> 0x03af }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03af }
            com.xiaoying.p448a.C9537b.setParameter(r2, r4)     // Catch:{ all -> 0x03af }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ all -> 0x03af }
            r2.<init>()     // Catch:{ all -> 0x03af }
            java.lang.String r4 = "k"
            java.lang.String r12 = com.introvd.template.common.Utils.getAppVersion(r12)     // Catch:{ all -> 0x03af }
            r2.putString(r4, r12)     // Catch:{ all -> 0x03af }
            java.lang.String r12 = "salt"
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x03af }
            r4 = 10
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r4)     // Catch:{ all -> 0x03af }
            r2.putString(r12, r1)     // Catch:{ all -> 0x03af }
            com.xiaoying.a.d r12 = new com.xiaoying.a.d     // Catch:{ all -> 0x03af }
            r12.<init>(r2)     // Catch:{ all -> 0x03af }
            mSocialClient = r12     // Catch:{ all -> 0x03af }
        L_0x03ad:
            monitor-exit(r0)
            return r3
        L_0x03af:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialService.initXiaoyingClient(android.content.Context):boolean");
    }

    private boolean isDeviceInfoChanged(String str, String str2, String str3, String str4, String str5) {
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        boolean z = str2 != null && !instance.getAppSettingStr("DevInfo_PhoneModel", "").equals(str2);
        String appSettingStr = instance.getAppSettingStr("DevInfo_OSVer", "");
        if (str3 != null && !appSettingStr.equals(str3)) {
            z = true;
        }
        String appSettingStr2 = instance.getAppSettingStr("DevInfo_OperCode", "");
        if (str5 != null && !appSettingStr2.equals(str5)) {
            z = true;
        }
        String appSettingStr3 = instance.getAppSettingStr("DevInfo_NetworkMode", "");
        if (str4 != null && !appSettingStr3.equals(str4)) {
            z = true;
        }
        if (!instance.getAppSettingStr("DevInfo_PrjCount", "").equals(str)) {
            return true;
        }
        return z;
    }

    private boolean isEnable() {
        return true;
    }

    public static boolean isMethodRequireDeviceLoginOK(String str, String str2) {
        return !TextUtils.isEmpty(str2) && !str2.startsWith("support") && !str2.startsWith("template");
    }

    public static boolean isMethodRequireUserLoginOK(String str, String str2) {
        if (SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC.equals(str)) {
            return false;
        }
        if (SocialServiceDef.ACTION_SOCIAL_SERVICE_VIDEO.equals(str)) {
            return !SocialServiceDef.SOCIAL_PROJECT_METHOD_GET_VIDEO_URL.equals(str2);
        }
        if (!SocialServiceDef.ACTION_SOCIAL_SERVICE_INTERACTION.equals(str) && SocialServiceDef.ACTION_SOCIAL_SERVICE_USER.equals(str)) {
            return SocialServiceDef.SOCIAL_USER_METHOD_UNBIND.equals(str2);
        }
        return false;
    }

    public static String makeViewURLWithFromApp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        while (str.endsWith(RequestParameters.AMPERSAND)) {
            str = str.substring(0, str.length() - 1);
        }
        if (!str.endsWith("/") && !str.contains("?")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            str = sb.toString();
        }
        String dU = C5206b.m14211dU(context);
        if (TextUtils.isEmpty(dU)) {
            dU = "Unknown";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fromApp=");
        sb2.append(dU);
        String sb3 = sb2.toString();
        if (!str.contains("fromApp=")) {
            if (str.contains("?")) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(RequestParameters.AMPERSAND);
                sb4.append(sb3);
                str = sb4.toString();
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("?");
                sb5.append(sb3);
                str = sb5.toString();
            }
        }
        return str;
    }

    private String makeViewURLWithFromApp(String str) {
        return makeViewURLWithFromApp(this, str);
    }

    /* access modifiers changed from: private */
    public void onInteractionIntent(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("social_method");
            if (stringExtra != null) {
                SocialServiceInteractionNotify instance = SocialServiceInteractionNotify.getInstance();
                Bundle bundle = new Bundle();
                bundle.putInt("errCode", -1);
                bundle.putInt("wParam", 0);
                bundle.putInt("lParam", 0);
                intent.putExtras(bundle);
                mResendAPIMap.remove(stringExtra);
                instance.onNotify(this, stringExtra, null, 131072, -1, intent, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0350  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMiscIntent(android.content.Intent r23) {
        /*
            r22 = this;
            r8 = r22
            r6 = r23
            java.lang.String r0 = "social_method"
            java.lang.String r2 = r6.getStringExtra(r0)
            com.introvd.template.datacenter.SocialServiceMiscNotify r0 = com.introvd.template.datacenter.SocialServiceMiscNotify.getInstance()
            java.lang.String r1 = "support.patch"
            boolean r1 = r2.equals(r1)
            r5 = 131072(0x20000, float:1.83671E-40)
            if (r1 == 0) goto L_0x0134
            java.lang.String r1 = "misc_phone_model"
            java.lang.String r10 = r6.getStringExtra(r1)
            java.lang.String r1 = "misc_sdk_version"
            java.lang.String r11 = r6.getStringExtra(r1)
            java.lang.String r1 = com.introvd.template.common.CpuFeatures.getCpuHardWare()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 == 0) goto L_0x0030
            java.lang.String r1 = "Unknown"
        L_0x0030:
            r12 = r1
            java.lang.String r1 = com.introvd.template.common.CpuFeatures.getCpuArch()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 == 0) goto L_0x003d
            java.lang.String r1 = "0"
        L_0x003d:
            r14 = r1
            java.lang.String r1 = com.introvd.template.common.CpuFeatures.getCpuRevision()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 == 0) goto L_0x004a
            java.lang.String r1 = "0"
        L_0x004a:
            r18 = r1
            java.lang.String r1 = com.introvd.template.common.CpuFeatures.getCpuPart()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 == 0) goto L_0x0058
            java.lang.String r1 = "0"
        L_0x0058:
            r17 = r1
            java.lang.String r1 = com.introvd.template.common.CpuFeatures.getCpuVariant()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 == 0) goto L_0x0066
            java.lang.String r1 = "0"
        L_0x0066:
            r16 = r1
            java.lang.String r1 = com.introvd.template.common.CpuFeatures.getCpuFeatures()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 == 0) goto L_0x0074
            java.lang.String r1 = "0"
        L_0x0074:
            r13 = r1
            java.lang.String r1 = com.introvd.template.common.CpuFeatures.getCpuImplementer()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 == 0) goto L_0x0081
            java.lang.String r1 = "0"
        L_0x0081:
            r15 = r1
            com.xiaoying.a.d r9 = mSocialClient
            com.xiaoying.a.f r1 = r9.mo37064b(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            int r9 = com.introvd.template.datacenter.SocialExceptionHandler.handleException(r8, r1)
            if (r9 != r5) goto L_0x0109
            int r10 = r1.aRn()
            if (r10 <= 0) goto L_0x0105
            android.content.Intent r11 = new android.content.Intent
            java.lang.String r12 = "localbroadcast.action.PATCH.upgrade"
            r11.<init>(r12)
            r12 = 0
        L_0x009c:
            if (r12 >= r10) goto L_0x00fb
            java.lang.Object r13 = r1.mo37089wG(r12)
            org.json.JSONObject r13 = (org.json.JSONObject) r13
            java.lang.String r14 = "a"
            java.lang.String r14 = r13.optString(r14)
            java.lang.String r15 = "c"
            java.lang.String r15 = r13.optString(r15)
            java.lang.String r3 = "b"
            java.lang.String r3 = r13.optString(r3)
            java.lang.String r7 = "d"
            java.lang.String r7 = r13.optString(r7)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r4 = "URL"
            r13.append(r4)
            r13.append(r14)
            java.lang.String r4 = r13.toString()
            r11.putExtra(r4, r15)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r13 = "Version"
            r4.append(r13)
            r4.append(r14)
            java.lang.String r4 = r4.toString()
            r11.putExtra(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Desc"
            r3.append(r4)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r11.putExtra(r3, r7)
            int r12 = r12 + 1
            goto L_0x009c
        L_0x00fb:
            android.support.v4.content.LocalBroadcastManager r1 = android.support.p021v4.content.LocalBroadcastManager.getInstance(r22)
            r1.sendBroadcast(r11)
            r1 = 1
            r4 = 1
            goto L_0x0106
        L_0x0105:
            r4 = 0
        L_0x0106:
            r3 = 0
            r7 = -1
            goto L_0x0112
        L_0x0109:
            int r7 = r1.getErrorCode()
            java.lang.String r3 = r1.aRm()
            r4 = 0
        L_0x0112:
            if (r9 == r5) goto L_0x0122
            r1 = 900(0x384, float:1.261E-42)
            if (r7 < r1) goto L_0x0122
            java.lang.String r1 = "localbroadcast.action.PATCH.upgrade"
            r8.reportSocialError(r1, r7, r3)
            r1 = 8193(0x2001, float:1.1481E-41)
            r4 = 8193(0x2001, float:1.1481E-41)
            goto L_0x0131
        L_0x0122:
            long r10 = java.lang.System.currentTimeMillis()
            com.introvd.template.p374q.C8346e.m24078l(r8, r10)
            if (r4 != 0) goto L_0x0130
            r1 = 12290(0x3002, float:1.7222E-41)
            r4 = 12290(0x3002, float:1.7222E-41)
            goto L_0x0131
        L_0x0130:
            r4 = 0
        L_0x0131:
            r5 = r7
            goto L_0x0329
        L_0x0134:
            java.lang.String r1 = "support.crashlog"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0159
            java.lang.String r1 = "request_param1"
            java.lang.String r1 = r6.getStringExtra(r1)
            java.lang.String r3 = "request_param2"
            r4 = 9
            int r3 = r6.getIntExtra(r3, r4)
            java.lang.String r4 = "request_param3"
            java.lang.String r4 = r6.getStringExtra(r4)
            android.content.Context r7 = r22.getApplicationContext()
            r8.fileUpload(r7, r1, r3, r4)
            goto L_0x0324
        L_0x0159:
            java.lang.String r1 = "template.roll.detail"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x019d
            java.lang.String r1 = "request_type"
            java.lang.String r1 = r6.getStringExtra(r1)
            java.lang.String r3 = "version"
            java.lang.String r3 = r6.getStringExtra(r3)
            java.lang.String r4 = "request_param1"
            java.lang.String r4 = r6.getStringExtra(r4)
            com.xiaoying.a.d r7 = mSocialClient
            com.xiaoying.a.f r3 = r7.mo37058A(r1, r4, r3)
            int r1 = com.introvd.template.datacenter.SocialExceptionHandler.handleException(r8, r3)
            if (r1 != r5) goto L_0x0184
        L_0x017f:
            r19 = 0
            r20 = -1
            goto L_0x0191
        L_0x0184:
            java.lang.String r4 = r3.aRm()
            int r7 = r3.getErrorCode()
        L_0x018c:
            r19 = r4
            r20 = r7
            r3 = 0
        L_0x0191:
            r9 = r1
            r5 = r20
            r4 = 0
            r21 = r19
            r19 = r3
            r3 = r21
            goto L_0x032b
        L_0x019d:
            java.lang.String r1 = "template.item.info"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01d0
            java.lang.String r1 = "tcid"
            java.lang.String r1 = r6.getStringExtra(r1)
            java.lang.String r3 = "ttid"
            java.lang.String r3 = r6.getStringExtra(r3)
            java.lang.String r4 = "version"
            java.lang.String r4 = r6.getStringExtra(r4)
            com.xiaoying.a.d r7 = mSocialClient
            com.xiaoying.a.f r3 = r7.mo37059B(r1, r3, r4)
            if (r3 != 0) goto L_0x01c0
            return
        L_0x01c0:
            int r1 = com.introvd.template.datacenter.SocialExceptionHandler.handleException(r8, r3)
            if (r1 != r5) goto L_0x01c7
            goto L_0x017f
        L_0x01c7:
            java.lang.String r4 = r3.aRm()
            int r7 = r3.getErrorCode()
            goto L_0x018c
        L_0x01d0:
            java.lang.String r1 = "template.packages.info"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01fd
            java.lang.String r1 = "request_type"
            java.lang.String r1 = r6.getStringExtra(r1)
            java.lang.String r3 = "request_param1"
            java.lang.String r3 = r6.getStringExtra(r3)
            com.xiaoying.a.d r4 = mSocialClient
            com.xiaoying.a.f r3 = r4.mo37067by(r1, r3)
            if (r3 != 0) goto L_0x01ed
            return
        L_0x01ed:
            int r1 = com.introvd.template.datacenter.SocialExceptionHandler.handleException(r8, r3)
            if (r1 != r5) goto L_0x01f4
            goto L_0x017f
        L_0x01f4:
            java.lang.String r4 = r3.aRm()
            int r7 = r3.getErrorCode()
            goto L_0x018c
        L_0x01fd:
            java.lang.String r1 = "template.packages.detail"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x022c
            java.lang.String r1 = "request_type"
            java.lang.String r1 = r6.getStringExtra(r1)
            java.lang.String r3 = "version"
            java.lang.String r3 = r6.getStringExtra(r3)
            com.xiaoying.a.d r4 = mSocialClient
            com.xiaoying.a.f r3 = r4.mo37068bz(r1, r3)
            if (r3 != 0) goto L_0x021a
            return
        L_0x021a:
            int r1 = com.introvd.template.datacenter.SocialExceptionHandler.handleException(r8, r3)
            if (r1 != r5) goto L_0x0222
            goto L_0x017f
        L_0x0222:
            java.lang.String r4 = r3.aRm()
            int r7 = r3.getErrorCode()
            goto L_0x018c
        L_0x022c:
            java.lang.String r1 = "activity.banner.page"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x02f3
            java.lang.String r1 = "request_param1"
            java.lang.String r1 = r6.getStringExtra(r1)
            java.lang.String r3 = "request_param2"
            java.lang.String r3 = r6.getStringExtra(r3)
            java.lang.String r4 = "request_type"
            r7 = 0
            int r4 = r6.getIntExtra(r4, r7)
            com.xiaoying.a.d r7 = mSocialClient
            com.xiaoying.a.f r3 = r7.mo37069m(r4, r1, r3)
            int r1 = com.introvd.template.datacenter.SocialExceptionHandler.handleException(r8, r3)
            if (r1 != r5) goto L_0x02e1
            com.aiii.android.arouter.c.a r4 = com.aiii.android.arouter.p091c.C1919a.m5529sc()
            java.lang.Class<com.introvd.template.router.banner.IBannerService> r5 = com.introvd.template.router.banner.IBannerService.class
            java.lang.Object r4 = r4.mo10356i(r5)
            com.introvd.template.router.banner.IBannerService r4 = (com.introvd.template.router.banner.IBannerService) r4
            if (r4 != 0) goto L_0x0262
            return
        L_0x0262:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r7 = r3.aRn()
            r9 = 0
        L_0x026c:
            if (r9 >= r7) goto L_0x02d4
            com.introvd.template.router.banner.BannerInfo r10 = new com.introvd.template.router.banner.BannerInfo
            r10.<init>()
            java.lang.Object r11 = r3.mo37089wG(r9)
            org.json.JSONObject r11 = (org.json.JSONObject) r11
            java.lang.String r12 = "f"
            int r12 = r11.optInt(r12)
            r10.f3572id = r12
            java.lang.String r12 = "e"
            r13 = 0
            int r12 = r11.optInt(r12, r13)
            r10.pageType = r12
            java.lang.String r12 = "a"
            int r12 = r11.optInt(r12)
            r10.orderNum = r12
            java.lang.String r12 = "b"
            int r12 = r11.optInt(r12)
            r10.contentType = r12
            java.lang.String r12 = "c"
            java.lang.String r12 = r11.optString(r12)
            r10.strContentTitle = r12
            java.lang.String r12 = "i"
            java.lang.String r12 = r11.optString(r12)
            r10.strDesc = r12
            java.lang.String r12 = "d"
            org.json.JSONObject r11 = r11.optJSONObject(r12)
            java.lang.String r12 = "a"
            java.lang.String r12 = r11.optString(r12)
            r10.strContentUrl = r12
            java.lang.String r12 = "b"
            org.json.JSONObject r11 = r11.optJSONObject(r12)
            java.lang.String r12 = "a"
            int r12 = r11.optInt(r12)
            r10.todoType = r12
            java.lang.String r12 = "b"
            java.lang.String r11 = r11.optString(r12)
            r10.strTodoContent = r11
            r5.add(r10)
            int r9 = r9 + 1
            goto L_0x026c
        L_0x02d4:
            android.content.Context r7 = r22.getApplicationContext()
            r4.saveBanner(r7, r5)
            r19 = r3
            r3 = 0
            r20 = -1
            goto L_0x02ee
        L_0x02e1:
            java.lang.String r4 = r3.aRm()
            int r7 = r3.getErrorCode()
            r3 = r4
            r20 = r7
            r19 = 0
        L_0x02ee:
            r9 = r1
            r5 = r20
            r4 = 0
            goto L_0x032b
        L_0x02f3:
            java.lang.String r1 = "support.report.app.info"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0324
            java.lang.String r1 = "request_param1"
            java.lang.String r1 = r6.getStringExtra(r1)
            com.xiaoying.a.d r3 = mSocialClient
            com.xiaoying.a.f r1 = r3.mo37072rX(r1)
            if (r1 != 0) goto L_0x030a
            return
        L_0x030a:
            int r3 = com.introvd.template.datacenter.SocialExceptionHandler.handleException(r8, r1)
            if (r3 != r5) goto L_0x0317
            r19 = r1
            r9 = r3
            r3 = 0
            r4 = 0
            r5 = -1
            goto L_0x032b
        L_0x0317:
            java.lang.String r4 = r1.aRm()
            int r1 = r1.getErrorCode()
            r5 = r1
            r9 = r3
            r3 = r4
            r4 = 0
            goto L_0x0329
        L_0x0324:
            r3 = 0
            r4 = 0
            r5 = -1
            r9 = 131072(0x20000, float:1.83671E-40)
        L_0x0329:
            r19 = 0
        L_0x032b:
            if (r6 == 0) goto L_0x034c
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r7 = "errCode"
            r1.putInt(r7, r5)
            java.lang.String r7 = "wParam"
            r1.putInt(r7, r4)
            java.lang.String r4 = "lParam"
            r7 = 0
            r1.putInt(r4, r7)
            if (r3 == 0) goto L_0x0349
            java.lang.String r4 = "errMsg"
            r1.putString(r4, r3)
        L_0x0349:
            r6.putExtras(r1)
        L_0x034c:
            r1 = 50
            if (r5 != r1) goto L_0x0357
            boolean r1 = r22.tryResendAPI(r23)
            if (r1 == 0) goto L_0x0357
            return
        L_0x0357:
            java.util.HashMap<java.lang.String, java.lang.Long> r1 = mResendAPIMap
            r1.remove(r2)
            r1 = r22
            r3 = r19
            r4 = r9
            r6 = r23
            r7 = r22
            r0.onNotify(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialService.onMiscIntent(android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    public void onUserIntent(Intent intent) {
        String str;
        Bundle bundle;
        String str2;
        String str3;
        Bundle bundle2;
        Intent intent2 = intent;
        if (intent2 != null) {
            Context applicationContext = getApplicationContext();
            String stringExtra = intent2.getStringExtra("social_method");
            if (stringExtra != null) {
                SocialServiceUserNotify instance = SocialServiceUserNotify.getInstance();
                int i = 0;
                int i2 = 131072;
                if (stringExtra.equals(SocialServiceDef.SOCIAL_USER_METHOD_REGISTER)) {
                    mSocialClient.mo37065bw("f", null);
                    mSocialClient.mo37065bw("h", null);
                    SocialServiceUserNotify.setUserLoginState(0);
                    String stringExtra2 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_LOGINTYPE);
                    String stringExtra3 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_NAME);
                    String stringExtra4 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_PASSWORD);
                    String stringExtra5 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_SNS_SCREENNAME);
                    String stringExtra6 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_SNS_AVATAR);
                    String str4 = "";
                    try {
                        str3 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_COUNTRY);
                    } catch (Exception e) {
                        e.printStackTrace();
                        str3 = str4;
                    }
                    C9567f b = mSocialClient.mo37063b(stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, str3);
                    int handleException = SocialExceptionHandler.handleException(this, b);
                    if (handleException == 131072) {
                        String rV = mSocialClient.mo37071rV("f");
                        String htmlDecode = htmlDecode(b.getString(C7234b.TAG));
                        String string = b.getString("c");
                        String string2 = b.getString("d");
                        String string3 = b.getString("e");
                        String string4 = b.getString("f");
                        String string5 = b.getString(C4677g.TAG);
                        bundle2 = new Bundle();
                        bundle2.putString(SocialConstDef.USER_REGISTER_KEY, C9537b.getParameter("XiaoYingID"));
                        bundle2.putString(SocialConstDef.USER_XY_UID, rV);
                        bundle2.putString("logo", string);
                        bundle2.putString("studio_name", htmlDecode);
                        bundle2.putString("d", string2);
                        bundle2.putString("e", string3);
                        if (string4 != null) {
                            bundle2.putString("f", string4);
                        }
                        if (string5 != null) {
                            bundle2.putString(C4677g.TAG, string5);
                        }
                        str = null;
                    } else {
                        String aRm = b.aRm();
                        i = b.getErrorCode();
                        reportSocialError(SocialServiceDef.SOCIAL_USER_METHOD_REGISTER, i, aRm);
                        str = aRm;
                        bundle2 = null;
                    }
                    i2 = handleException;
                    bundle = bundle2;
                } else if (stringExtra.equals(SocialServiceDef.SOCIAL_USER_METHOD_LOGIN)) {
                    instance.onNotify(applicationContext, SocialServiceDef.SOCIAL_USER_METHOD_LOGIN, null, 0, 0, intent, this);
                    UserLoginSync(applicationContext, intent2, this);
                    return;
                } else if (stringExtra.equals(SocialServiceDef.SOCIAL_USER_METHOD_LOGOUT)) {
                    UserLogoutSync(applicationContext, this);
                    return;
                } else if (stringExtra.equals(SocialServiceDef.SOCIAL_USER_METHOD_LOCATION)) {
                    String stringExtra7 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_GPS_ACCURACY);
                    String stringExtra8 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_LONGITUDE);
                    String stringExtra9 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_LATITUDE);
                    String stringExtra10 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_ADDRESS);
                    String stringExtra11 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_ADDRESS_DETAIL);
                    String stringExtra12 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_PERMITTYPE);
                    if (stringExtra12 == null) {
                        stringExtra12 = "6";
                    }
                    String str5 = stringExtra12;
                    String stringExtra13 = intent2.getStringExtra(SocialServiceDef.EXTRAS_USER_MAPTYPE);
                    if (stringExtra13 == null) {
                        stringExtra13 = "0";
                    }
                    String str6 = stringExtra13;
                    C9567f a = mSocialClient.mo37061a(stringExtra7, stringExtra8, stringExtra9, stringExtra11, stringExtra10, SocialServiceVideoNotify.formatToServerDateTime(System.currentTimeMillis()), str5, str6);
                    int handleException2 = SocialExceptionHandler.handleException(this, a);
                    if (handleException2 != 131072) {
                        str2 = a.aRm();
                        i = a.getErrorCode();
                    } else {
                        str2 = null;
                    }
                    if (handleException2 != 131072) {
                        reportSocialError(SocialServiceDef.SOCIAL_USER_METHOD_LOCATION, i, str);
                    }
                    i2 = handleException2;
                    bundle = null;
                } else {
                    bundle = null;
                    str = null;
                }
                if (i != 50 || !stringExtra.equals(SocialServiceDef.SOCIAL_USER_METHOD_LOCATION) || !tryResendAPI(intent)) {
                    mResendAPIMap.remove(stringExtra);
                    if (intent2 != null) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("errCode", i);
                        bundle3.putInt("wParam", 0);
                        bundle3.putInt("lParam", 0);
                        if (str != null) {
                            bundle3.putString("errMsg", str);
                        }
                        intent2.putExtras(bundle3);
                    }
                    instance.onNotify(this, stringExtra, bundle, i2, i, intent, this);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onVideoIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("social_method");
        SocialServiceVideoNotify instance = SocialServiceVideoNotify.getInstance();
        String stringExtra2 = intent.getStringExtra(SocialServiceDef.EXTRAS_PROJECT_ID);
        BaseSocialNotify.getActiveNetworkName(this);
        if (SocialServiceDef.SOCIAL_PROJECT_METHOD_GET_VIDEO_URL.equals(stringExtra) || !isMethodRequireUserLoginOK(intent.getAction(), stringExtra) || SocialServiceUserNotify.getXYAccessToken() != null) {
            Bundle bundle = new Bundle();
            intent.getStringExtra(SocialServiceDef.EXTRAS_PROJECT_PUID);
            ProjectSocialParameter publishParam = instance.getPublishParam(stringExtra2);
            bundle.putInt("errCode", -1);
            bundle.putInt("wParam", 0);
            bundle.putInt("lParam", 0);
            intent.putExtras(bundle);
            instance.onNotify(this, stringExtra, publishParam, 131072, -1, intent, this);
        }
    }

    private static void recordServerLoginTime(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            C8344c.m24054P(context, SocialServiceDef.KEY_XIAOYING_SERVICE_LOGINTIME, String.valueOf(formatServerTime2AndroidMS(str)));
        }
    }

    public static void reportSocialError(Context context, String str, int i, String str2) {
        if (context != null) {
            String activeNetworkName = BaseSocialNotify.getActiveNetworkName(context);
            if ((i < C9534a.code9920.getCode() || i >= 930) && i != C9534a.code9993.getCode() && i != C9534a.code9994.getCode()) {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("Tag:");
                sb.append(str);
                sb.append(",code:");
                sb.append(i);
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(str2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sb2);
                    sb3.append(",msg:");
                    sb3.append(str2);
                    sb2 = sb3.toString();
                }
                hashMap.put(SocialConstDef.TBL_NAME_MESSAGE, sb2);
                hashMap.put("ErrCode", String.valueOf(i));
                hashMap.put("Network", String.valueOf(activeNetworkName));
                hashMap.put("Method", String.valueOf(str));
                hashMap.put(ExifInterface.TAG_MODEL, Build.MODEL);
                LogUtils.m14222e(TAG, sb2);
                String str3 = i == C9534a.code9998.getCode() ? EVENT_KEY_VIDEO_UPLOAD_EXCEPTION : i <= 900 ? "DEV_EVENT_Server_Error" : "DEV_EVENT_Social_Event";
                C9561c.aRh().onKVEvent(context, str3, hashMap);
            }
        }
    }

    /* access modifiers changed from: private */
    public void reportSocialError(String str, int i, String str2) {
        reportSocialError(this, str, i, str2);
    }

    private static synchronized int syncDeviceLogin() {
        synchronized (SocialService.class) {
            String duid = DeviceUserProxy.getDuid();
            String deviceToken = DeviceUserProxy.getDeviceToken();
            StringBuilder sb = new StringBuilder();
            sb.append("syncDeviceLogin deviceId = ");
            sb.append(duid);
            sb.append(",deviceToken = ");
            sb.append(deviceToken);
            LogUtilsV2.m14227d(sb.toString());
            if (!TextUtils.isEmpty(duid)) {
                if (!TextUtils.isEmpty(deviceToken)) {
                    mSocialClient.mo37065bw("e", duid);
                    mSocialClient.mo37065bw("device_h", deviceToken);
                    return 0;
                }
            }
            int code = C9534a.code9902.getCode();
            return code;
        }
    }

    public static boolean syncDeviceLogout(Context context) {
        if (mSocialClient == null) {
            return false;
        }
        if (!TextUtils.isEmpty(mSocialClient.mo37071rV("device_h"))) {
            mSocialClient.mo37065bw("device_h", null);
        }
        return true;
    }

    public static synchronized boolean syncDeviceUnregister(Context context) {
        synchronized (SocialService.class) {
            if (mSocialClient == null) {
                return false;
            }
            mSocialClient.mo37065bw("e", null);
            return true;
        }
    }

    private boolean tryResendAPI(Intent intent) {
        boolean z = false;
        if (intent == null || intent.getAction() == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra("social_method");
        if (stringExtra == null) {
            return false;
        }
        SocialExceptionHandler.handleErrCode(this, SocialServiceDef.ACTION_SOCIAL_SERVICE_MISC, stringExtra, 50, null);
        Long l = (Long) mResendAPIMap.get(stringExtra);
        if (l == null) {
            l = Long.valueOf(0);
        }
        Long valueOf = Long.valueOf(l.longValue() + 1);
        if (valueOf.longValue() < 2) {
            mResendAPIMap.put(stringExtra, valueOf);
            intent.setPackage(getPackageName());
            C9561c.m27511k(this, intent);
            z = true;
        } else {
            mResendAPIMap.remove(stringExtra);
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00af A[Catch:{ Exception -> 0x006a, Throwable -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d8 A[SYNTHETIC, Splitter:B:60:0x00d8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r13) {
        /*
            r12 = this;
            java.lang.String r0 = "Unknown"
            boolean r1 = r12.isEnable()     // Catch:{ Throwable -> 0x01be }
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            if (r13 != 0) goto L_0x000c
            return
        L_0x000c:
            java.lang.String r1 = r13.getAction()     // Catch:{ Throwable -> 0x01be }
            if (r1 != 0) goto L_0x0013
            return
        L_0x0013:
            boolean r2 = r12.handlePassThroughMethod(r13)     // Catch:{ Throwable -> 0x01be }
            if (r2 == 0) goto L_0x001a
            return
        L_0x001a:
            boolean r2 = initXiaoyingClient(r12)     // Catch:{ Throwable -> 0x01be }
            if (r2 != 0) goto L_0x0021
            return
        L_0x0021:
            java.lang.String r2 = "social_method"
            java.lang.String r2 = r13.getStringExtra(r2)     // Catch:{ Throwable -> 0x01be }
            if (r2 != 0) goto L_0x002a
            return
        L_0x002a:
            checkNewAppVersionIfNeccessary()     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r0 = "account.unbind"
            boolean r0 = r2.equals(r0)     // Catch:{ Throwable -> 0x01bc }
            r3 = 0
            if (r0 == 0) goto L_0x0055
            com.xiaoying.a.d r0 = mSocialClient     // Catch:{ Throwable -> 0x01bc }
            if (r0 == 0) goto L_0x0055
            com.introvd.template.datacenter.SocialService.RunIntentInExecutor.cancelAll()     // Catch:{ Throwable -> 0x01bc }
            com.introvd.template.datacenter.SocialServiceUserNotify r4 = com.introvd.template.datacenter.SocialServiceUserNotify.getInstance()     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r6 = "account.unbind"
            r7 = 0
            r8 = 131072(0x20000, float:1.83671E-40)
            r9 = 0
            r5 = r12
            r10 = r13
            r11 = r12
            r4.onNotify(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Throwable -> 0x01bc }
            com.xiaoying.a.d r13 = mSocialClient     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r0 = "h"
            r13.mo37065bw(r0, r3)     // Catch:{ Throwable -> 0x01bc }
            return
        L_0x0055:
            android.content.Context r0 = r12.getApplicationContext()     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r4 = "AppIsBusy"
            boolean r0 = com.introvd.template.p374q.C8345d.m24065co(r0, r4)     // Catch:{ Throwable -> 0x01bc }
            r4 = 0
            if (r0 == 0) goto L_0x0065
            r0 = 10
            goto L_0x0066
        L_0x0065:
            r0 = 0
        L_0x0066:
            android.os.Process.setThreadPriority(r0)     // Catch:{ Exception -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Throwable -> 0x01bc }
        L_0x006e:
            java.lang.String r0 = "socialservice.action.USER"
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x01bc }
            if (r0 == 0) goto L_0x007c
            com.introvd.template.datacenter.SocialServiceUserNotify r0 = com.introvd.template.datacenter.SocialServiceUserNotify.getInstance()     // Catch:{ Throwable -> 0x01bc }
        L_0x007a:
            r3 = r0
            goto L_0x00a3
        L_0x007c:
            java.lang.String r0 = "socialservice.action.VIDEO"
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x01bc }
            if (r0 == 0) goto L_0x0089
            com.introvd.template.datacenter.SocialServiceVideoNotify r0 = com.introvd.template.datacenter.SocialServiceVideoNotify.getInstance()     // Catch:{ Throwable -> 0x01bc }
            goto L_0x007a
        L_0x0089:
            java.lang.String r0 = "socialservice.action.MISC"
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x01bc }
            if (r0 == 0) goto L_0x0096
            com.introvd.template.datacenter.SocialServiceMiscNotify r0 = com.introvd.template.datacenter.SocialServiceMiscNotify.getInstance()     // Catch:{ Throwable -> 0x01bc }
            goto L_0x007a
        L_0x0096:
            java.lang.String r0 = "socialservice.action.INTERACTION"
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x01bc }
            if (r0 == 0) goto L_0x00a3
            com.introvd.template.datacenter.SocialServiceInteractionNotify r0 = com.introvd.template.datacenter.SocialServiceInteractionNotify.getInstance()     // Catch:{ Throwable -> 0x01bc }
            goto L_0x007a
        L_0x00a3:
            com.introvd.template.datacenter.SocialExceptionHandler$ServerAvailableAccessItem r0 = com.introvd.template.datacenter.SocialExceptionHandler.getServerAccessAvailable(r12, r1, r2)     // Catch:{ all -> 0x01ba }
            boolean r5 = com.introvd.template.datacenter.SocialExceptionHandler.isServerAccessAvailable(r0)     // Catch:{ all -> 0x01ba }
            r6 = 4098(0x1002, float:5.743E-42)
            if (r5 != 0) goto L_0x00d8
            int r8 = r0.nErrCode     // Catch:{ all -> 0x01ba }
            if (r8 == 0) goto L_0x00d7
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Throwable -> 0x01bc }
            r0.<init>()     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r1 = "errCode"
            r0.putInt(r1, r8)     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r1 = "wParam"
            r0.putInt(r1, r6)     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r1 = "lParam"
            r0.putInt(r1, r4)     // Catch:{ Throwable -> 0x01bc }
            r13.putExtras(r0)     // Catch:{ Throwable -> 0x01bc }
            if (r3 == 0) goto L_0x00d6
            r6 = 0
            r7 = 65536(0x10000, float:9.18355E-41)
            r4 = r12
            r5 = r2
            r9 = r13
            r10 = r12
            r3.onNotify(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x01bc }
        L_0x00d6:
            return
        L_0x00d7:
            return
        L_0x00d8:
            int r0 = com.introvd.template.datacenter.BaseSocialNotify.checkNetworkPrefAndState(r12, r4)     // Catch:{ all -> 0x01ba }
            switch(r0) {
                case -1: goto L_0x00e5;
                case 0: goto L_0x00e2;
                default: goto L_0x00df;
            }     // Catch:{ all -> 0x01ba }
        L_0x00df:
            com.xiaoying.a.a.a r0 = com.xiaoying.p448a.p449a.C9534a.code_N2     // Catch:{ all -> 0x01ba }
            goto L_0x00ef
        L_0x00e2:
            r0 = 0
            r8 = 0
            goto L_0x00f6
        L_0x00e5:
            r0 = 4097(0x1001, float:5.741E-42)
            com.xiaoying.a.a.a r5 = com.xiaoying.p448a.p449a.C9534a.code_N1     // Catch:{ all -> 0x01ba }
            int r5 = r5.getCode()     // Catch:{ all -> 0x01ba }
            r8 = r5
            goto L_0x00f6
        L_0x00ef:
            int r0 = r0.getCode()     // Catch:{ all -> 0x01ba }
            r8 = r0
            r0 = 4098(0x1002, float:5.743E-42)
        L_0x00f6:
            if (r8 == 0) goto L_0x011c
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ Throwable -> 0x01bc }
            r1.<init>()     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r5 = "errCode"
            r1.putInt(r5, r8)     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r5 = "wParam"
            r1.putInt(r5, r0)     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r0 = "lParam"
            r1.putInt(r0, r4)     // Catch:{ Throwable -> 0x01bc }
            r13.putExtras(r1)     // Catch:{ Throwable -> 0x01bc }
            if (r3 == 0) goto L_0x011b
            r6 = 0
            r7 = 65536(0x10000, float:9.18355E-41)
            r4 = r12
            r5 = r2
            r9 = r13
            r10 = r12
            r3.onNotify(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x01bc }
        L_0x011b:
            return
        L_0x011c:
            boolean r0 = isMethodRequireDeviceLoginOK(r1, r2)     // Catch:{ Throwable -> 0x01bc }
            if (r0 == 0) goto L_0x013d
            com.xiaoying.a.d r0 = mSocialClient     // Catch:{ Throwable -> 0x01bc }
            boolean r0 = r0.aRj()     // Catch:{ Throwable -> 0x01bc }
            if (r0 != 0) goto L_0x013d
            int r8 = syncDeviceLogin()     // Catch:{ Throwable -> 0x01bc }
            if (r8 == 0) goto L_0x013d
            if (r3 == 0) goto L_0x013c
            r6 = 0
            r7 = 65536(0x10000, float:9.18355E-41)
            r4 = r12
            r5 = r2
            r9 = r13
            r10 = r12
            r3.onNotify(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x01bc }
        L_0x013c:
            return
        L_0x013d:
            boolean r0 = isMethodRequireUserLoginOK(r1, r2)     // Catch:{ Throwable -> 0x01bc }
            r5 = 1
            if (r0 == 0) goto L_0x014e
            java.lang.String r0 = com.introvd.template.datacenter.TempUserProxy.getUserId()     // Catch:{ Throwable -> 0x01bc }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x01bc }
            r0 = r0 ^ r5
            goto L_0x014f
        L_0x014e:
            r0 = 0
        L_0x014f:
            com.xiaoying.a.d r6 = mSocialClient     // Catch:{ Throwable -> 0x01bc }
            if (r6 == 0) goto L_0x0175
            java.lang.String r6 = com.introvd.template.datacenter.TempUserProxy.getUserId()     // Catch:{ Throwable -> 0x01bc }
            if (r6 == 0) goto L_0x0175
            java.lang.String r6 = com.introvd.template.datacenter.TempUserProxy.getUserToken()     // Catch:{ Throwable -> 0x01bc }
            if (r6 == 0) goto L_0x0175
            com.xiaoying.a.d r6 = mSocialClient     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r7 = "f"
            java.lang.String r8 = com.introvd.template.datacenter.TempUserProxy.getUserId()     // Catch:{ Throwable -> 0x01bc }
            r6.mo37065bw(r7, r8)     // Catch:{ Throwable -> 0x01bc }
            com.xiaoying.a.d r6 = mSocialClient     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r7 = "h"
            java.lang.String r8 = com.introvd.template.datacenter.TempUserProxy.getUserToken()     // Catch:{ Throwable -> 0x01bc }
            r6.mo37065bw(r7, r8)     // Catch:{ Throwable -> 0x01bc }
        L_0x0175:
            if (r0 != 0) goto L_0x017d
            boolean r0 = isMethodRequireUserLoginOK(r1, r2)     // Catch:{ Throwable -> 0x01bc }
            if (r0 == 0) goto L_0x01b6
        L_0x017d:
            int r0 = com.introvd.template.datacenter.SocialServiceUserNotify.getUserLoginState()     // Catch:{ Throwable -> 0x01bc }
            if (r0 == r5) goto L_0x01b6
            int r8 = UserLoginSync(r12, r13, r12)     // Catch:{ Throwable -> 0x01bc }
            int r0 = com.introvd.template.datacenter.SocialServiceUserNotify.getUserLoginState()     // Catch:{ Throwable -> 0x01bc }
            if (r0 == r5) goto L_0x01b6
            if (r3 == 0) goto L_0x01b5
            r3.onHandleIntentFailed(r12, r13)     // Catch:{ Throwable -> 0x01bc }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Throwable -> 0x01bc }
            r0.<init>()     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r1 = "errCode"
            r0.putInt(r1, r8)     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r1 = "wParam"
            r5 = 4099(0x1003, float:5.744E-42)
            r0.putInt(r1, r5)     // Catch:{ Throwable -> 0x01bc }
            java.lang.String r1 = "lParam"
            r0.putInt(r1, r4)     // Catch:{ Throwable -> 0x01bc }
            r13.putExtras(r0)     // Catch:{ Throwable -> 0x01bc }
            r6 = 0
            r7 = 65536(0x10000, float:9.18355E-41)
            r4 = r12
            r5 = r2
            r9 = r13
            r10 = r12
            r3.onNotify(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x01bc }
        L_0x01b5:
            return
        L_0x01b6:
            com.introvd.template.datacenter.SocialService.RunIntentInExecutor.execute(r12, r13)     // Catch:{ Throwable -> 0x01bc }
            goto L_0x01cd
        L_0x01ba:
            r13 = move-exception
            throw r13     // Catch:{ Throwable -> 0x01bc }
        L_0x01bc:
            r13 = move-exception
            goto L_0x01c0
        L_0x01be:
            r13 = move-exception
            r2 = r0
        L_0x01c0:
            com.xiaoying.a.a.a r0 = com.xiaoying.p448a.p449a.C9534a.code9999
            int r0 = r0.getCode()
            java.lang.String r13 = r13.getMessage()
            r12.reportSocialError(r2, r0, r13)
        L_0x01cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialService.onHandleIntent(android.content.Intent):void");
    }
}
