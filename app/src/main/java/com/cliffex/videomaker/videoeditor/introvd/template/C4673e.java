package com.introvd.template;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import android.support.p021v4.content.CursorLoader;
import android.text.TextUtils;
import com.introvd.template.app.C4388u;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.Utils;
import com.introvd.template.common.bitmapfun.DelayRecycleBitmapTask;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.TaskService;
import com.introvd.template.p173a.C3570a;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8356h;
import com.introvd.template.router.common.CommonParams;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.e */
class C4673e {
    private static final String TAG = "e";
    private C4675a bfD = null;
    private boolean bfE = true;

    /* renamed from: com.introvd.template.e$a */
    private static class C4675a extends Handler {
        private int bfG = -1;
        final long bfH;
        private WeakReference<Activity> mContextRef;

        public C4675a(Activity activity, long j) {
            this.mContextRef = new WeakReference<>(activity);
            this.bfH = j;
        }

        /* JADX WARNING: Removed duplicated region for block: B:94:0x0211  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r18) {
            /*
                r17 = this;
                r1 = r17
                r2 = r18
                java.lang.ref.WeakReference<android.app.Activity> r0 = r1.mContextRef
                java.lang.Object r0 = r0.get()
                r4 = r0
                android.app.Activity r4 = (android.app.Activity) r4
                if (r4 != 0) goto L_0x0010
                return
            L_0x0010:
                long r5 = r1.bfH
                java.lang.String r0 = "AppRunningMode"
                r3 = 0
                java.lang.Object r0 = com.introvd.template.common.MagicCode.getMagicParam(r5, r0, r3)
                r11 = r0
                com.introvd.template.d.d r11 = (com.introvd.template.p242d.C5530d) r11
                if (r11 != 0) goto L_0x001f
                return
            L_0x001f:
                java.lang.Object r0 = r11.coc
                boolean r0 = r0 instanceof android.net.Uri
                if (r0 == 0) goto L_0x002a
                java.lang.Object r0 = r11.coc
                android.net.Uri r0 = (android.net.Uri) r0
                goto L_0x002b
            L_0x002a:
                r0 = r3
            L_0x002b:
                android.net.Uri r10 = r11.coe
                int r5 = r2.what
                r6 = 1001(0x3e9, float:1.403E-42)
                r12 = 0
                if (r5 != r6) goto L_0x003a
                r2 = 1000(0x3e8, double:4.94E-321)
                r1.sendEmptyMessageDelayed(r12, r2)
                return
            L_0x003a:
                int r5 = r2.what
                r7 = 1000(0x3e8, float:1.401E-42)
                r8 = -1
                r13 = 1
                if (r5 != r7) goto L_0x0223
                boolean r5 = com.introvd.template.p173a.C3570a.m8779RU()
                int r9 = r2.arg1
                if (r9 == r13) goto L_0x01dc
                switch(r9) {
                    case 11: goto L_0x01dc;
                    case 12: goto L_0x0073;
                    case 13: goto L_0x0073;
                    case 14: goto L_0x004f;
                    default: goto L_0x004d;
                }
            L_0x004d:
                goto L_0x020f
            L_0x004f:
                if (r5 == 0) goto L_0x020e
                java.lang.String r0 = "/XYVideoEditor/PreLoad"
                com.aiii.android.arouter.facade.a r0 = com.introvd.template.router.VivaRouter.getRouterBuilder(r0)     // Catch:{ Throwable -> 0x0066 }
                android.content.Intent r3 = r4.getIntent()     // Catch:{ Throwable -> 0x0066 }
                android.os.Bundle r3 = r3.getExtras()     // Catch:{ Throwable -> 0x0066 }
                r0.mo10400g(r3)     // Catch:{ Throwable -> 0x0066 }
                r0.mo10382H(r4)     // Catch:{ Throwable -> 0x0066 }
                goto L_0x006e
            L_0x0066:
                int r0 = com.introvd.template.R.string.xiaoying_str_ve_msg_import_unsupport_file
                com.introvd.template.common.ToastUtils.show(r4, r0, r13)
                r4.finish()
            L_0x006e:
                r11.mo27243dI(r13)
                goto L_0x020f
            L_0x0073:
                if (r5 == 0) goto L_0x020e
                long r14 = r1.bfH
                java.lang.String r5 = "AppRunningMode"
                java.lang.Object r5 = com.introvd.template.common.MagicCode.getMagicParam(r14, r5, r3)
                com.introvd.template.d.d r5 = (com.introvd.template.p242d.C5530d) r5
                if (r5 == 0) goto L_0x00ac
                int r9 = r5.cob
                if (r9 != r13) goto L_0x00ac
                int r9 = r2.arg1
                r14 = 12
                if (r9 != r14) goto L_0x00ac
                java.lang.String r3 = "/XYVideoEditor/PreLoad"
                com.aiii.android.arouter.facade.a r3 = com.introvd.template.router.VivaRouter.getRouterBuilder(r3)
                android.content.Intent r5 = r4.getIntent()
                android.os.Bundle r5 = r5.getExtras()
                r3.mo10400g(r5)
                if (r0 == 0) goto L_0x00a7
                java.lang.String r5 = "file_path"
                java.lang.String r0 = r0.getPath()
                r3.mo10399f(r5, r0)
            L_0x00a7:
                r3.mo10382H(r4)
                goto L_0x01d8
            L_0x00ac:
                if (r5 == 0) goto L_0x00bb
                int r9 = r5.cnV
                if (r9 != r7) goto L_0x00bb
                com.introvd.template.router.editor.gallery.GalleryRouter r0 = com.introvd.template.router.editor.gallery.GalleryRouter.getInstance()
                r0.launchPhotoEdit(r4, r3, r3)
                goto L_0x01d8
            L_0x00bb:
                if (r5 == 0) goto L_0x00ca
                int r7 = r5.cnV
                if (r7 != r6) goto L_0x00ca
                com.introvd.template.router.editor.gallery.GalleryRouter r0 = com.introvd.template.router.editor.gallery.GalleryRouter.getInstance()
                r0.launchVideoEdit(r4, r3, r3)
                goto L_0x01d8
            L_0x00ca:
                if (r5 == 0) goto L_0x00d4
                int r3 = r5.cnV
                r6 = 1002(0x3ea, float:1.404E-42)
                if (r3 != r6) goto L_0x00d4
                goto L_0x01d8
            L_0x00d4:
                if (r5 == 0) goto L_0x0170
                int r3 = r5.cnV
                r6 = 2001(0x7d1, float:2.804E-42)
                if (r3 == r6) goto L_0x00e8
                int r3 = r5.cnV
                r6 = 2002(0x7d2, float:2.805E-42)
                if (r3 == r6) goto L_0x00e8
                int r3 = r5.cnV
                r6 = 2003(0x7d3, float:2.807E-42)
                if (r3 != r6) goto L_0x0170
            L_0x00e8:
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.List<android.net.Uri> r0 = r11.cod
                if (r0 == 0) goto L_0x0115
                java.util.List<android.net.Uri> r0 = r11.cod
                int r0 = r0.size()
                if (r0 <= 0) goto L_0x0115
                java.util.List<android.net.Uri> r0 = r11.cod
                java.util.Iterator r0 = r0.iterator()
            L_0x00ff:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x0115
                java.lang.Object r3 = r0.next()
                android.net.Uri r3 = (android.net.Uri) r3
                if (r3 == 0) goto L_0x00ff
                java.lang.String r3 = r3.getPath()
                r9.add(r3)
                goto L_0x00ff
            L_0x0115:
                com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
                java.lang.String r3 = "key_pref_gallery_new_version"
                boolean r0 = r0.getAppSettingBoolean(r3, r12)
                if (r0 == 0) goto L_0x0130
                com.introvd.template.router.editor.gallery.GalleryRouter r3 = com.introvd.template.router.editor.gallery.GalleryRouter.getInstance()
                r0 = -1
                int r6 = r5.cnV
                long r7 = r1.bfH
                r5 = r0
                r3.launchExtraIntentGallery(r4, r5, r6, r7, r9, r10)
                goto L_0x01d8
            L_0x0130:
                java.lang.String r0 = "/XYVideoEditor/VideoTrim"
                com.aiii.android.arouter.facade.a r0 = com.introvd.template.router.VivaRouter.getRouterBuilder(r0)
                java.lang.String r3 = "item_position"
                com.aiii.android.arouter.facade.a r0 = r0.mo10406h(r3, r8)
                java.lang.String r3 = "extra_intent_mode_key"
                int r5 = r5.cnV
                com.aiii.android.arouter.facade.a r0 = r0.mo10406h(r3, r5)
                java.lang.String r3 = "IntentMagicCode"
                long r5 = r1.bfH
                com.aiii.android.arouter.facade.a r0 = r0.mo10386a(r3, r5)
                int r3 = com.introvd.template.R.anim.xiaoying_activity_enter
                int r5 = com.introvd.template.R.anim.xiaoying_activity_exit
                com.aiii.android.arouter.facade.a r0 = r0.mo10394aZ(r3, r5)
                int r3 = r9.size()
                if (r3 <= 0) goto L_0x0165
                java.lang.String r3 = "file_path"
                java.lang.Object r5 = r9.get(r12)
                java.lang.String r5 = (java.lang.String) r5
                r0.mo10399f(r3, r5)
            L_0x0165:
                if (r10 == 0) goto L_0x016c
                java.lang.String r3 = "output"
                r0.mo10387a(r3, r10)
            L_0x016c:
                r0.mo10382H(r4)
                goto L_0x01d8
            L_0x0170:
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x01d4 }
                r9.<init>()     // Catch:{ Exception -> 0x01d4 }
                if (r0 == 0) goto L_0x017e
                java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x01d4 }
                r9.add(r0)     // Catch:{ Exception -> 0x01d4 }
            L_0x017e:
                com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Exception -> 0x01d4 }
                java.lang.String r3 = "key_pref_gallery_new_version"
                boolean r0 = r0.getAppSettingBoolean(r3, r12)     // Catch:{ Exception -> 0x01d4 }
                if (r0 == 0) goto L_0x0196
                com.introvd.template.router.editor.gallery.GalleryRouter r3 = com.introvd.template.router.editor.gallery.GalleryRouter.getInstance()     // Catch:{ Exception -> 0x01d4 }
                r5 = -1
                r6 = 0
                long r7 = r1.bfH     // Catch:{ Exception -> 0x01d4 }
                r3.launchExtraIntentGallery(r4, r5, r6, r7, r9, r10)     // Catch:{ Exception -> 0x01d4 }
                goto L_0x01d8
            L_0x0196:
                java.lang.String r0 = "/XYVideoEditor/VideoTrim"
                com.aiii.android.arouter.facade.a r0 = com.introvd.template.router.VivaRouter.getRouterBuilder(r0)     // Catch:{ Exception -> 0x01d4 }
                java.lang.String r3 = "item_position"
                com.aiii.android.arouter.facade.a r0 = r0.mo10406h(r3, r8)     // Catch:{ Exception -> 0x01d4 }
                java.lang.String r3 = "extra_intent_mode_key"
                com.aiii.android.arouter.facade.a r0 = r0.mo10406h(r3, r12)     // Catch:{ Exception -> 0x01d4 }
                java.lang.String r3 = "IntentMagicCode"
                long r5 = r1.bfH     // Catch:{ Exception -> 0x01d4 }
                com.aiii.android.arouter.facade.a r0 = r0.mo10386a(r3, r5)     // Catch:{ Exception -> 0x01d4 }
                int r3 = com.introvd.template.R.anim.xiaoying_activity_enter     // Catch:{ Exception -> 0x01d4 }
                int r5 = com.introvd.template.R.anim.xiaoying_activity_exit     // Catch:{ Exception -> 0x01d4 }
                com.aiii.android.arouter.facade.a r0 = r0.mo10394aZ(r3, r5)     // Catch:{ Exception -> 0x01d4 }
                int r3 = r9.size()     // Catch:{ Exception -> 0x01d4 }
                if (r3 <= 0) goto L_0x01c9
                java.lang.String r3 = "file_path"
                java.lang.Object r5 = r9.get(r12)     // Catch:{ Exception -> 0x01d4 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x01d4 }
                r0.mo10399f(r3, r5)     // Catch:{ Exception -> 0x01d4 }
            L_0x01c9:
                if (r10 == 0) goto L_0x01d0
                java.lang.String r3 = "output"
                r0.mo10387a(r3, r10)     // Catch:{ Exception -> 0x01d4 }
            L_0x01d0:
                r0.mo10382H(r4)     // Catch:{ Exception -> 0x01d4 }
                goto L_0x01d8
            L_0x01d4:
                r0 = move-exception
                r0.printStackTrace()
            L_0x01d8:
                r11.mo27243dI(r13)
                goto L_0x020f
            L_0x01dc:
                if (r5 == 0) goto L_0x020e
                android.view.Window r0 = r4.getWindow()
                r0.setBackgroundDrawable(r3)
                int r0 = r11.cnW
                com.introvd.template.router.todoCode.TODOParamModel r5 = new com.introvd.template.router.todoCode.TODOParamModel
                r5.<init>()
                r5.mTODOCode = r0
                com.introvd.template.router.todoCode.BizAppTodoActionManager r0 = com.introvd.template.router.todoCode.BizAppTodoActionManager.getInstance()
                r0.executeTodo(r4, r5, r3)
                r11.mo27243dI(r13)
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.lang.String r3 = "which"
                java.lang.String r5 = "camera"
                r0.put(r3, r5)
                android.content.Context r3 = r4.getApplicationContext()
                java.lang.String r4 = "Intent_Launch"
                com.introvd.template.common.UserBehaviorLog.onKVEvent(r3, r4, r0)
                goto L_0x020f
            L_0x020e:
                r12 = 1
            L_0x020f:
                if (r12 == 0) goto L_0x0222
                int r0 = r2.what
                int r3 = r2.arg1
                int r4 = r2.arg2
                java.lang.Object r2 = r2.obj
                android.os.Message r0 = r1.obtainMessage(r0, r3, r4, r2)
                r2 = 100
                r1.sendMessageDelayed(r0, r2)
            L_0x0222:
                return
            L_0x0223:
                int r0 = r2.what
                if (r0 == 0) goto L_0x022c
                int r0 = r2.what
                if (r0 == r13) goto L_0x022c
                return
            L_0x022c:
                int r0 = r2.what
                r1.removeMessages(r0)
                int r0 = r2.what
                int r5 = r1.bfG
                int r6 = r1.bfG
                r7 = 8
                r9 = 7
                r10 = 6
                r11 = 5
                r14 = 4
                r15 = 3
                r12 = 2
                r16 = 500(0x1f4, float:7.0E-43)
                if (r6 != r8) goto L_0x0251
                boolean r3 = com.introvd.template.p173a.C3570a.m8779RU()
                if (r3 == 0) goto L_0x024d
                r3 = 0
                r5 = 0
                goto L_0x02ed
            L_0x024d:
                r3 = 500(0x1f4, float:7.0E-43)
                goto L_0x02ed
            L_0x0251:
                int r6 = r1.bfG
                if (r6 != 0) goto L_0x0259
                r3 = 0
                r5 = 1
                goto L_0x02ed
            L_0x0259:
                int r6 = r1.bfG
                if (r6 != r13) goto L_0x0286
                boolean r3 = com.introvd.template.p173a.C3570a.m8779RU()
                if (r3 == 0) goto L_0x024d
                com.introvd.template.i r3 = com.introvd.template.C4681i.m12184Gp()
                com.introvd.template.AppMiscListener r3 = r3.mo25016Gr()
                android.content.Context r5 = r4.getApplicationContext()
                r3.initPushClient(r5)
                com.introvd.template.i r3 = com.introvd.template.C4681i.m12184Gp()
                com.introvd.template.AppMiscListener r3 = r3.mo25016Gr()
                android.content.Context r4 = r4.getApplicationContext()
                r3.setPushTag(r4, r13)
                r3 = 500(0x1f4, float:7.0E-43)
                r5 = 2
                goto L_0x02ed
            L_0x0286:
                int r6 = r1.bfG
                if (r6 != r12) goto L_0x028e
                r3 = 500(0x1f4, float:7.0E-43)
                r5 = 3
                goto L_0x02ed
            L_0x028e:
                int r6 = r1.bfG
                if (r6 != r15) goto L_0x02b8
                android.content.Intent r3 = r4.getIntent()
                java.lang.String r5 = "PushService"
                java.lang.String r3 = r3.getStringExtra(r5)
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                r3 = r3 ^ r13
                if (r3 == 0) goto L_0x02b4
                com.aiii.android.arouter.c.a r3 = com.aiii.android.arouter.p091c.C1919a.m5529sc()
                java.lang.Class<com.introvd.template.router.community.ICommunityAPI> r5 = com.introvd.template.router.community.ICommunityAPI.class
                java.lang.Object r3 = r3.mo10356i(r5)
                com.introvd.template.router.community.ICommunityAPI r3 = (com.introvd.template.router.community.ICommunityAPI) r3
                if (r3 == 0) goto L_0x02b4
                r3.refreshMessageStatisticalInfo(r4)
            L_0x02b4:
                r3 = 500(0x1f4, float:7.0E-43)
                r5 = 4
                goto L_0x02ed
            L_0x02b8:
                int r6 = r1.bfG
                if (r6 != r14) goto L_0x02c3
                com.introvd.template.p374q.C8356h.m24103gT(r4)
                r3 = 500(0x1f4, float:7.0E-43)
                r5 = 5
                goto L_0x02ed
            L_0x02c3:
                int r4 = r1.bfG
                if (r4 != r11) goto L_0x02d4
                boolean r4 = com.introvd.template.common.CommonConfigure.IS_CRASH_LOG_UPLOAD
                if (r4 != 0) goto L_0x02d0
                java.lang.String r4 = com.introvd.template.common.CommonConfigure.APP_CRASH_PATH
                com.introvd.template.common.FileUtils.deleteFolderSubFiles(r4, r3)
            L_0x02d0:
                r3 = 500(0x1f4, float:7.0E-43)
                r5 = 6
                goto L_0x02ed
            L_0x02d4:
                int r3 = r1.bfG
                if (r3 != r10) goto L_0x02dc
                r3 = 500(0x1f4, float:7.0E-43)
                r5 = 7
                goto L_0x02ed
            L_0x02dc:
                int r3 = r1.bfG
                if (r3 != r9) goto L_0x02e5
                r3 = 500(0x1f4, float:7.0E-43)
                r5 = 8
                goto L_0x02ed
            L_0x02e5:
                int r3 = r1.bfG
                if (r3 != r7) goto L_0x024d
                r3 = 500(0x1f4, float:7.0E-43)
                r5 = 100
            L_0x02ed:
                r1.bfG = r5
                if (r0 == r13) goto L_0x02fb
                r0 = 100
                if (r5 == r0) goto L_0x02fb
                int r0 = r2.what
                long r2 = (long) r3
                r1.sendEmptyMessageDelayed(r0, r2)
            L_0x02fb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.C4673e.C4675a.handleMessage(android.os.Message):void");
        }
    }

    C4673e() {
    }

    /* renamed from: bp */
    private static boolean m12164bp(Context context) {
        long appSettingLong = AppPreferencesSetting.getInstance().getAppSettingLong("com_quvideo_xiaoying_intentutil_destroy_peroid", 0);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        if (currentTimeMillis - appSettingLong < 86400000) {
            LogUtilsV2.m14227d("in one day , kill process and no pending task.");
            Process.killProcess(Process.myPid());
            return true;
        }
        AppPreferencesSetting.getInstance().setAppSettingLong("com_quvideo_xiaoying_intentutil_destroy_peroid", currentTimeMillis);
        BaseSocialNotify.removeAllPendingIntent(context);
        if (BaseSocialNotify.isNetworkAvaliable(context)) {
            z = true ^ C8345d.m24065co(VivaBaseApplication.m8749FZ(), "ServiceAutoShutDown");
        }
        if (z) {
            C4388u.m11056HE();
            C3570a.m8781x(7, false);
            C4388u.m11057HF();
            if (CommonConfigure.EN_APP_KILL_PROCESS) {
                C8356h.m24104gU(context);
            }
            LogUtils.m14223i(TAG, "exitGlobal-->2");
        } else {
            if (CommonConfigure.EN_APP_KILL_PROCESS) {
                TaskService.doPendingTask(context, 0);
            }
            LogUtils.m14223i(TAG, "exitGlobal-->1");
        }
        return z;
    }

    /* renamed from: d */
    private static String m12165d(Context context, Uri uri) {
        CursorLoader cursorLoader = new CursorLoader(context, uri, new String[]{SocialConstDef.MEDIA_ITEM_DATA}, null, null, null);
        Cursor loadInBackground = cursorLoader.loadInBackground();
        String str = null;
        if (loadInBackground == null) {
            return null;
        }
        try {
            int columnIndexOrThrow = loadInBackground.getColumnIndexOrThrow(SocialConstDef.MEDIA_ITEM_DATA);
            if (loadInBackground.moveToFirst()) {
                str = loadInBackground.getString(columnIndexOrThrow);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            loadInBackground.close();
            throw th;
        }
        loadInBackground.close();
        return str;
    }

    /* renamed from: e */
    private static String m12166e(Context context, Uri uri) {
        String parseInputUri = Utils.parseInputUri(uri, context, true);
        if (FileUtils.isFileExisted(parseInputUri) && MediaFileUtils.IsSupportedVideoFileType(MediaFileUtils.GetFileMediaType(parseInputUri))) {
            return parseInputUri;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
        if ((r9 instanceof android.net.Uri) == false) goto L_0x0054;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ba  */
    /* renamed from: q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m12167q(android.app.Activity r19) {
        /*
            r0 = r19
            android.content.Intent r1 = r19.getIntent()
            r2 = -1
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r3 = r19.hashCode()
            long r3 = (long) r3
            java.lang.String r5 = r1.getAction()
            java.lang.String r6 = TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "handleIntent strAction="
            r7.append(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            com.introvd.template.common.LogUtils.m14223i(r6, r7)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            android.os.Bundle r7 = r1.getExtras()
            r8 = 0
            if (r7 == 0) goto L_0x0068
            boolean r9 = com.introvd.template.p242d.C5529c.m14972ax(r0, r5)
            if (r9 == 0) goto L_0x0042
            java.lang.String r8 = "android.intent.extra.STREAM"
            java.util.ArrayList r8 = r1.getParcelableArrayListExtra(r8)
            goto L_0x0054
        L_0x0042:
            android.net.Uri r9 = r1.getData()
            if (r9 != 0) goto L_0x0053
            java.lang.String r9 = "android.intent.extra.STREAM"
            java.lang.Object r9 = r7.get(r9)
            boolean r10 = r9 instanceof android.net.Uri
            if (r10 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r8 = r9
        L_0x0054:
            java.lang.String r9 = "output"
            java.lang.Object r7 = r7.get(r9)
            boolean r9 = r7 instanceof java.lang.String
            if (r9 == 0) goto L_0x0065
            java.lang.String r7 = (java.lang.String) r7
            android.net.Uri r7 = android.net.Uri.parse(r7)
            goto L_0x0069
        L_0x0065:
            android.net.Uri r7 = (android.net.Uri) r7
            goto L_0x0069
        L_0x0068:
            r7 = r8
        L_0x0069:
            java.lang.String r9 = "extra_intent_mode_key"
            int r9 = r1.getIntExtra(r9, r2)
            r13 = 0
            r14 = 1
            if (r9 <= 0) goto L_0x00ee
            java.lang.String r15 = "android.intent.action.SEND"
            boolean r15 = r15.equals(r5)
            if (r15 == 0) goto L_0x00a8
            java.lang.String r15 = "android.intent.extra.STREAM"
            android.os.Parcelable r15 = r1.getParcelableExtra(r15)
            android.net.Uri r15 = (android.net.Uri) r15
            java.lang.String r10 = com.introvd.template.common.Utils.parseInputUri(r15, r0, r14)
            boolean r16 = com.introvd.template.common.FileUtils.isFileExisted(r10)
            if (r16 == 0) goto L_0x009a
            java.io.File r15 = new java.io.File
            r15.<init>(r10)
            android.net.Uri r10 = android.net.Uri.fromFile(r15)
            r6.add(r10)
            goto L_0x00e9
        L_0x009a:
            int r1 = com.introvd.template.R.string.xiaoying_str_ve_clip_add_msg_invalid_file
            boolean r3 = com.introvd.template.common.Utils.isSupportedContentUri(r15)
            if (r3 != 0) goto L_0x00a4
            int r1 = com.introvd.template.R.string.xiaoying_str_ve_msg_only_support_local_file
        L_0x00a4:
            com.introvd.template.common.ToastUtils.show(r0, r1, r14)
            return r2
        L_0x00a8:
            java.lang.String r10 = "android.intent.action.SEND_MULTIPLE"
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x00e9
            java.lang.String r10 = "android.intent.extra.STREAM"
            java.util.ArrayList r10 = r1.getParcelableArrayListExtra(r10)
            java.util.Iterator r10 = r10.iterator()
        L_0x00ba:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x00dd
            java.lang.Object r15 = r10.next()
            android.net.Uri r15 = (android.net.Uri) r15
            java.lang.String r15 = com.introvd.template.common.Utils.parseInputUri(r15, r0, r14)
            boolean r16 = com.introvd.template.common.FileUtils.isFileExisted(r15)
            if (r16 == 0) goto L_0x00ba
            java.io.File r12 = new java.io.File
            r12.<init>(r15)
            android.net.Uri r12 = android.net.Uri.fromFile(r12)
            r6.add(r12)
            goto L_0x00ba
        L_0x00dd:
            int r10 = r6.size()
            if (r10 != 0) goto L_0x00e9
            int r1 = com.introvd.template.R.string.xiaoying_str_ve_clip_add_msg_invalid_file
            com.introvd.template.common.ToastUtils.show(r0, r1, r14)
            return r2
        L_0x00e9:
            r10 = r8
        L_0x00ea:
            r12 = 13
            goto L_0x015b
        L_0x00ee:
            boolean r10 = r8 instanceof android.net.Uri
            if (r10 == 0) goto L_0x0114
            android.net.Uri r8 = (android.net.Uri) r8
            java.lang.String r10 = m12166e(r0, r8)
            if (r10 == 0) goto L_0x0106
            java.io.File r8 = new java.io.File
            r8.<init>(r10)
            android.net.Uri r8 = android.net.Uri.fromFile(r8)
            r10 = r8
            r8 = 1
            goto L_0x0116
        L_0x0106:
            int r1 = com.introvd.template.R.string.xiaoying_str_ve_clip_add_msg_invalid_file
            boolean r3 = com.introvd.template.common.Utils.isSupportedContentUri(r8)
            if (r3 != 0) goto L_0x0110
            int r1 = com.introvd.template.R.string.xiaoying_str_ve_msg_only_support_local_file
        L_0x0110:
            com.introvd.template.common.ToastUtils.show(r0, r1, r14)
            return r2
        L_0x0114:
            r10 = r8
            r8 = 0
        L_0x0116:
            java.lang.String r12 = "com.introvd.template.Gallery_MV_Laucher"
            boolean r12 = r12.equals(r5)
            if (r12 == 0) goto L_0x0120
        L_0x011e:
            r12 = 1
            goto L_0x015b
        L_0x0120:
            java.lang.String r12 = "com.introvd.template.Camera_Laucher"
            boolean r12 = r12.equals(r5)
            if (r12 == 0) goto L_0x0129
            goto L_0x011e
        L_0x0129:
            if (r8 == 0) goto L_0x0132
            boolean r12 = com.introvd.template.p242d.C5529c.m14973ay(r0, r5)
            if (r12 == 0) goto L_0x0132
            goto L_0x00ea
        L_0x0132:
            if (r8 == 0) goto L_0x013d
            boolean r12 = com.introvd.template.p242d.C5529c.m14974az(r0, r5)
            if (r12 == 0) goto L_0x013d
        L_0x013a:
            r12 = 12
            goto L_0x015b
        L_0x013d:
            boolean r12 = com.introvd.template.p242d.C5529c.m14971aA(r0, r5)
            if (r12 == 0) goto L_0x0146
            r12 = 11
            goto L_0x015b
        L_0x0146:
            boolean r12 = com.introvd.template.p242d.C5529c.m14972ax(r0, r5)
            if (r12 == 0) goto L_0x0151
            r8 = 14
            r12 = 14
            goto L_0x015b
        L_0x0151:
            if (r8 == 0) goto L_0x0154
            goto L_0x013a
        L_0x0154:
            int r8 = com.introvd.template.p242d.C5530d.m14976aj(r19)
            if (r8 == r14) goto L_0x011e
            r12 = 0
        L_0x015b:
            java.lang.String r8 = "ProjectDelMode"
            int r8 = r1.getIntExtra(r8, r2)
            java.lang.String r15 = "ShareMode"
            int r15 = r1.getIntExtra(r15, r2)
            java.lang.String r14 = "ExportMode"
            int r14 = r1.getIntExtra(r14, r2)
            java.lang.String r11 = "CaptureMode"
            r2 = 201(0xc9, float:2.82E-43)
            int r11 = r1.getIntExtra(r11, r2)
            java.lang.String r2 = "ExportPageMode"
            int r2 = r1.getIntExtra(r2, r13)
            r17 = r3
            java.lang.String r3 = "ImportMode"
            int r3 = r1.getIntExtra(r3, r13)
            java.lang.String r4 = "SplashMode"
            int r1 = r1.getIntExtra(r4, r13)
            r4 = -1
            if (r8 != r4) goto L_0x019b
            r13 = 11
            if (r12 == r13) goto L_0x0197
            r13 = 12
            if (r12 != r13) goto L_0x0195
            goto L_0x0199
        L_0x0195:
            r8 = 0
            goto L_0x019d
        L_0x0197:
            r13 = 12
        L_0x0199:
            r8 = 2
            goto L_0x019d
        L_0x019b:
            r13 = 12
        L_0x019d:
            if (r9 != r4) goto L_0x01a7
            if (r12 != r13) goto L_0x01a4
            r9 = 100
            goto L_0x01b7
        L_0x01a4:
            r0 = -1
            r9 = 0
            goto L_0x01b8
        L_0x01a7:
            boolean r0 = com.introvd.template.p242d.C5529c.m14974az(r0, r5)
            if (r0 == 0) goto L_0x01b7
            boolean r0 = com.introvd.template.p242d.C5529c.m14975km(r9)
            if (r0 == 0) goto L_0x01b7
            r0 = -1
            r12 = 12
            goto L_0x01b8
        L_0x01b7:
            r0 = -1
        L_0x01b8:
            if (r15 != r0) goto L_0x01c6
            r4 = 12
            if (r12 == r4) goto L_0x01c5
            r4 = 11
            if (r12 != r4) goto L_0x01c3
            goto L_0x01c5
        L_0x01c3:
            r15 = 1
            goto L_0x01c6
        L_0x01c5:
            r15 = 0
        L_0x01c6:
            if (r14 != r0) goto L_0x01cc
            r0 = 201(0xc9, float:2.82E-43)
            r14 = 1
            goto L_0x01ce
        L_0x01cc:
            r0 = 201(0xc9, float:2.82E-43)
        L_0x01ce:
            if (r11 >= r0) goto L_0x01d7
            r4 = 1
            if (r11 == r4) goto L_0x01d4
            goto L_0x01d8
        L_0x01d4:
            r0 = 202(0xca, float:2.83E-43)
            goto L_0x01d8
        L_0x01d7:
            r0 = r11
        L_0x01d8:
            com.introvd.template.d.d r4 = new com.introvd.template.d.d
            r4.<init>()
            r4.cnU = r12
            r4.cnW = r0
            r4.cnV = r9
            r4.cnX = r8
            r4.cnY = r15
            r4.cnZ = r14
            r4.coa = r2
            r4.cob = r3
            r4.coc = r10
            r4.cod = r6
            r4.coe = r7
            r0 = 1
            if (r1 != r0) goto L_0x01f7
            goto L_0x01f8
        L_0x01f7:
            r0 = 0
        L_0x01f8:
            r4.cof = r0
            java.lang.String r0 = "AppRunningMode"
            r1 = r17
            com.introvd.template.common.MagicCode.setMagicParam(r1, r0, r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.C4673e.m12167q(android.app.Activity):int");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00a2 */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ae A[SYNTHETIC, Splitter:B:54:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b3 A[SYNTHETIC, Splitter:B:58:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bb A[SYNTHETIC, Splitter:B:66:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c0 A[SYNTHETIC, Splitter:B:70:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0103  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m12168r(final android.app.Activity r14) {
        /*
            int r0 = r14.hashCode()
            long r0 = (long) r0
            java.lang.String r2 = "AppRunningMode"
            r3 = 0
            java.lang.Object r0 = com.introvd.template.common.MagicCode.getMagicParam(r0, r2, r3)
            com.introvd.template.d.d r0 = (com.introvd.template.p242d.C5530d) r0
            r1 = 0
            if (r0 != 0) goto L_0x0012
            return r1
        L_0x0012:
            android.net.Uri r2 = r0.coe
            java.lang.Class<com.introvd.template.router.editor.IEditorService> r4 = com.introvd.template.router.editor.IEditorService.class
            com.aiii.android.arouter.facade.template.c r4 = com.introvd.template.router.BizServiceManager.getService(r4)
            com.introvd.template.router.editor.IEditorService r4 = (com.introvd.template.router.editor.IEditorService) r4
            if (r4 == 0) goto L_0x0023
            java.lang.String r5 = r4.getExportedFilePath()
            goto L_0x0024
        L_0x0023:
            r5 = r3
        L_0x0024:
            android.content.Intent r6 = new android.content.Intent
            android.content.Intent r7 = r14.getIntent()
            r6.<init>(r7)
            int r7 = r0.cnU
            r8 = 12
            r9 = -1
            r10 = 11
            if (r7 == r10) goto L_0x003a
            int r7 = r0.cnU
            if (r7 != r8) goto L_0x0042
        L_0x003a:
            boolean r7 = com.introvd.template.common.FileUtils.isFileExisted(r5)
            if (r7 != 0) goto L_0x0042
            r7 = 0
            goto L_0x0043
        L_0x0042:
            r7 = -1
        L_0x0043:
            r11 = 1
            if (r7 != r9) goto L_0x00d0
            int r12 = r0.cnU
            if (r12 == r10) goto L_0x004e
            int r12 = r0.cnU
            if (r12 != r8) goto L_0x00d0
        L_0x004e:
            if (r2 != 0) goto L_0x005b
            java.io.File r2 = new java.io.File
            r2.<init>(r5)
            android.net.Uri r2 = android.net.Uri.fromFile(r2)
            r8 = r5
            goto L_0x0076
        L_0x005b:
            java.lang.String r8 = r2.getScheme()
            if (r8 == 0) goto L_0x0072
            android.net.Uri r12 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            java.lang.String r12 = r12.getScheme()
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0072
            java.lang.String r8 = m12165d(r14, r2)
            goto L_0x0076
        L_0x0072:
            java.lang.String r8 = r2.getPath()
        L_0x0076:
            if (r8 == 0) goto L_0x00d0
            boolean r8 = android.text.TextUtils.equals(r5, r8)
            if (r8 != 0) goto L_0x00d0
            int r8 = r0.cnU
            if (r8 != r10) goto L_0x00c7
            android.content.ContentResolver r8 = r14.getContentResolver()     // Catch:{ Exception -> 0x00b7, all -> 0x00aa }
            java.io.OutputStream r8 = r8.openOutputStream(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00aa }
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            java.io.File r13 = new java.io.File     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            r13.<init>(r5)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            if (r8 == 0) goto L_0x009d
            com.introvd.template.common.FileUtils.copyFile(r12, r8)     // Catch:{ Exception -> 0x00b9, all -> 0x009a }
            goto L_0x009d
        L_0x009a:
            r14 = move-exception
            r3 = r12
            goto L_0x00ac
        L_0x009d:
            if (r8 == 0) goto L_0x00a2
            r8.close()     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r12.close()     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00c4
        L_0x00a6:
            r14 = move-exception
            goto L_0x00ac
        L_0x00a8:
            r12 = r3
            goto L_0x00b9
        L_0x00aa:
            r14 = move-exception
            r8 = r3
        L_0x00ac:
            if (r8 == 0) goto L_0x00b1
            r8.close()     // Catch:{ Exception -> 0x00b1 }
        L_0x00b1:
            if (r3 == 0) goto L_0x00b6
            r3.close()     // Catch:{ Exception -> 0x00b6 }
        L_0x00b6:
            throw r14
        L_0x00b7:
            r8 = r3
            r12 = r8
        L_0x00b9:
            if (r8 == 0) goto L_0x00be
            r8.close()     // Catch:{ Exception -> 0x00be }
        L_0x00be:
            if (r12 == 0) goto L_0x00c3
            r12.close()     // Catch:{ Exception -> 0x00c3 }
        L_0x00c3:
            r7 = 0
        L_0x00c4:
            r8 = r2
            r2 = 1
            goto L_0x00d2
        L_0x00c7:
            java.io.File r2 = new java.io.File
            r2.<init>(r5)
            android.net.Uri r2 = android.net.Uri.fromFile(r2)
        L_0x00d0:
            r8 = r2
            r2 = 0
        L_0x00d2:
            if (r2 == 0) goto L_0x00eb
            if (r7 != r9) goto L_0x00eb
            int r2 = r0.cnU
            if (r2 != r10) goto L_0x00eb
            android.content.Context r2 = r14.getApplicationContext()
            java.lang.String[] r9 = new java.lang.String[r11]
            r9[r1] = r5
            com.introvd.template.e$1 r5 = new com.introvd.template.e$1
            r5.<init>(r6, r14)
            com.introvd.template.p203b.C4580b.m11643a(r2, r9, r3, r5)
            goto L_0x00ec
        L_0x00eb:
            r1 = 1
        L_0x00ec:
            if (r1 == 0) goto L_0x00fe
            if (r8 == 0) goto L_0x00f8
            r6.setData(r8)
            java.lang.String r1 = "output"
            r6.putExtra(r1, r8)
        L_0x00f8:
            r14.setResult(r7, r6)
            r14.finish()
        L_0x00fe:
            int r14 = r0.cnX
            r1 = 2
            if (r14 != r1) goto L_0x010f
            int r14 = r0.cnU
            if (r14 != r10) goto L_0x0109
            r14 = 3
            goto L_0x010a
        L_0x0109:
            r14 = 1
        L_0x010a:
            if (r4 == 0) goto L_0x010f
            r4.clearProject(r14, r11)
        L_0x010f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.C4673e.m12168r(android.app.Activity):int");
    }

    /* renamed from: s */
    private long m12169s(Activity activity) {
        long hashCode = (long) activity.hashCode();
        activity.getIntent().putExtra(CommonParams.INTENT_MAGIC_CODE, hashCode);
        C4388u.m11059bL(activity);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("int magic code:");
        sb.append(hashCode);
        LogUtils.m14223i(str, sb.toString());
        int count = MagicCode.getCount();
        MagicCode.register(hashCode);
        int q = m12167q(activity);
        if (q < 0) {
            MagicCode.unregister(hashCode);
            activity.finish();
            return 0;
        }
        C5530d dVar = (C5530d) MagicCode.getMagicParam(hashCode, "AppRunningMode", null);
        if (dVar != null && dVar.cof) {
            activity.setTheme(R.style.Theme_XiaoYingNoSplash);
        }
        if (count == 0 && C8345d.m24069gQ(activity.getApplicationContext())) {
            C8345d.m24060R(activity.getApplicationContext(), "ServiceAutoShutDown", String.valueOf(true));
        } else if ((q == 13 || q == 14) && dVar != null && dVar.cnY == 1) {
            C8345d.m24060R(activity.getApplicationContext(), "ServiceAutoShutDown", String.valueOf(true));
        }
        if (C5530d.m14977kn(q)) {
            MagicCode.setAlias(hashCode, 0);
            MagicCode.setMagicParam(hashCode, "XiaoYingActivityWeakRef", new WeakReference(activity));
        }
        return hashCode;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo25008c(Activity activity, int i) {
        try {
            C4388u.m11055HD().mo24453HG();
        } catch (Exception unused) {
            activity.finish();
        }
        m12169s(activity);
        this.bfD = new C4675a(activity, (long) i);
        String dD = C4582c.m11667dD(activity);
        String FO = C3569a.m8776FO();
        this.bfD.sendMessageDelayed(this.bfD.obtainMessage(1001, TextUtils.equals(FO, "") ? 1 : 0, (dD.equals(FO) || TextUtils.isEmpty(FO)) ? 0 : 1), 500);
    }

    /* access modifiers changed from: 0000 */
    public void onResume(Activity activity) {
        C5530d dVar = (C5530d) MagicCode.getMagicParam((long) activity.hashCode(), "AppRunningMode", null);
        if (dVar != null) {
            if (C5530d.m14977kn(dVar.cnU) || !dVar.aaO()) {
                if (this.bfE) {
                    this.bfE = false;
                    if ("com.introvd.template.Gallery_MV_Laucher".equals(activity.getIntent().getAction())) {
                        activity.getIntent().setAction("");
                    }
                    this.bfD.sendMessage(this.bfD.obtainMessage(1000, dVar.cnU, 0, null));
                } else if ("com.introvd.template.Gallery_MV_Laucher".equals(activity.getIntent().getAction())) {
                    m12167q(activity);
                    activity.getIntent().setAction("");
                    this.bfD.sendMessage(this.bfD.obtainMessage(1000, 1, 0, null));
                }
                this.bfD.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            m12168r(activity);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public void mo25010t(Activity activity) {
        if (this.bfD != null) {
            this.bfD.removeCallbacksAndMessages(null);
        }
        DelayRecycleBitmapTask.unInit();
        long hashCode = (long) activity.hashCode();
        if (((C5530d) MagicCode.getMagicParam(hashCode, "AppRunningMode", null)) != null) {
            MagicCode.unregister(hashCode);
            int count = MagicCode.getCount();
            if ((count == 0 ? m12164bp(activity) : true) && !CommonConfigure.EN_APP_KILL_PROCESS) {
                C4388u.closeDatabase(activity.getApplicationContext(), true);
            }
            if (count == 0) {
                AppPreferencesSetting.getInstance().setAppSettingBoolean("AppSafeExit", true);
            }
            if (C8345d.m24065co(activity.getApplicationContext(), "AppAutoShutDown")) {
                C4388u.closeDatabase(activity.getApplicationContext(), true);
                C8347f.aKf().uninit();
                System.exit(0);
            }
        }
    }
}
