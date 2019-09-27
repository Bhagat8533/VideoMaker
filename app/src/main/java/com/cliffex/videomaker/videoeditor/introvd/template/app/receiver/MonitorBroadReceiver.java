package com.introvd.template.app.receiver;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.introvd.template.C4681i;
import com.introvd.template.app.C4388u;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p207c.C4612a;
import com.introvd.template.p374q.C8343b;
import com.introvd.template.p374q.C8356h;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.community.ICommunityService;
import java.io.File;
import java.net.URLDecoder;

public class MonitorBroadReceiver extends BroadcastReceiver {
    private static String TAG = "MonitorBroadReceiver";

    /* renamed from: R */
    public static void m10221R(Context context, String str) {
        if (!str.equals("android.intent.action.MEDIA_MOUNTED")) {
            m10223cv(context);
            Intent intent = new Intent();
            intent.setAction("com.introvd.template.nosdcard");
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    /* renamed from: c */
    public static void m10222c(Context context, long j) {
        int i;
        Context context2 = context;
        if (j != -1) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                int i2 = 65536;
                String str = null;
                ContentResolver contentResolver2 = contentResolver;
                Cursor query = contentResolver2.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_DOWNLOAD), new String[]{"state", "local", "remote"}, "_id = ?", new String[]{String.valueOf(j)}, null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        i2 = query.getInt(query.getColumnIndex("state"));
                        String string = query.getString(query.getColumnIndex("local"));
                        query.getString(query.getColumnIndex("remote"));
                        str = string;
                    }
                    query.close();
                    i = i2;
                } else {
                    i = 65536;
                }
                if (str != null) {
                    String decode = URLDecoder.decode(str, "UTF-8");
                    int i3 = -1;
                    String str2 = "userdata = ?";
                    String[] strArr = {String.valueOf(j)};
                    Cursor query2 = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_URLCACHE), new String[]{"type"}, str2, strArr, null);
                    if (query2 != null) {
                        if (query2.moveToNext()) {
                            i3 = query2.getInt(query2.getColumnIndex("type"));
                        }
                        query2.close();
                    }
                    if (i != 131072) {
                        contentResolver.delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_URLCACHE), str2, strArr);
                        FileUtils.deleteFile(decode);
                        return;
                    }
                    String str3 = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Download successfully:");
                    sb.append(decode);
                    LogUtils.m14222e(str3, sb.toString());
                    if (i3 == 4097 || (i3 >= 0 && i3 <= 3)) {
                        if (decode != null && decode.startsWith("file://")) {
                            decode = decode.replace("file://", "");
                        }
                        if (FileUtils.isFileExisted(decode)) {
                            File file = new File(decode);
                            if (file.length() > 0) {
                                if (i3 != 0) {
                                    if (i3 != 3) {
                                        if (i3 == 4097) {
                                            handle3rdApkTest(context, decode);
                                        }
                                    }
                                }
                                if (i3 == 0) {
                                    C4388u.closeDatabase(context, true);
                                }
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.addFlags(268435456);
                                C4612a.m11759a(intent, "application/vnd.android.package-archive", file, true);
                                try {
                                    context.startActivity(intent);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: cv */
    private static void m10223cv(Context context) {
        C8343b.m24053gO(context);
        C8356h.m24101gO(context);
        ICommunityService iCommunityService = (ICommunityService) BizServiceManager.getService(ICommunityService.class);
        if (iCommunityService != null) {
            iCommunityService.stopAllPublish(context);
        }
    }

    private static void handle3rdApkTest(Context context, String str) {
        if (C4388u.m11055HD() != null && !TextUtils.isEmpty(str)) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_key_3rd_apk_local_url", str);
            C4681i.m12184Gp().mo25016Gr().handle3rdApkTest(context, str);
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                StringBuilder sb = new StringBuilder();
                sb.append("Receive Network getAction = ");
                sb.append(action);
                sb.append(",isInitialStickyBroadcast = ");
                sb.append(isInitialStickyBroadcast());
                LogUtilsV2.m14227d(sb.toString());
                if (isInitialStickyBroadcast()) {
                    return;
                }
            }
            if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                try {
                    C4129a.schedule();
                } catch (Exception e) {
                    C5523b.logException(e);
                }
            } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_SHARED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
                m10221R(context, action);
            } else if (SocialServiceDef.ACTION_DOWNLOAD_COMPLETED.equals(action)) {
                m10222c(context, intent.getLongExtra("_id", -1));
            }
        }
    }
}
