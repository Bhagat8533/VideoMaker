package com.introvd.template.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.introvd.template.R;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.MD5;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.DownloadService;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4598j;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.setting.ISettingRouter;
import com.introvd.template.router.sns.MyResolveInfo;
import com.introvd.template.router.sns.PopupVideoShareInfo.Builder;
import com.introvd.template.router.sns.PopupVideoShareInfo.OnPopupItemClickListener;
import com.introvd.template.router.todoCode.BaseTodoInterceptor;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.sns.SnsShareInfo;
import com.introvd.template.sns.SnsShareManager;
import com.introvd.template.sns.SnsShareTypeUtil;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.sns.base.p228b.C4982c;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/app/todoInterceptor")
public class AppTodoInterceptorImpl extends BaseTodoInterceptor {
    private static final String GOOGLEPLAY_APP_URL_MARKET_PRE = "market://";
    private static final String GOOGLEPLAY_APP_URL_PRE = "https://play.google.com/store/apps/";
    private static String MAP_KEY_COVERURL = "coverURL";
    private static String MAP_KEY_DESC = "desc";
    private static String MAP_KEY_PUID = "puid";
    private static String MAP_KEY_PVER = "ver";
    private static String MAP_KEY_VIEW_URL = "viewURL";
    /* access modifiers changed from: private */
    public static boolean isTesing;
    private static Map<String, String> storeMap = new HashMap();

    static {
        storeMap.put("24", "com.huawei.appmarket");
    }

    private static void appBootUsageTodo(Activity activity, TODOParamModel tODOParamModel) {
        Map featchStrInfoFromJson = featchStrInfoFromJson(tODOParamModel.mJsonParam, new String[]{"storeurl", "openurl"});
        if (featchStrInfoFromJson != null && featchStrInfoFromJson.size() > 0) {
            String str = (String) featchStrInfoFromJson.get("storeurl");
            if (C4580b.m11631B(activity, str)) {
                activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(str));
            } else {
                lauchMarket4App(activity, str);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doAppFollowUs(android.app.Activity r2, java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0030 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0030 }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1, r4)     // Catch:{ Exception -> 0x0030 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0030 }
            if (r4 != 0) goto L_0x0014
            r0.setPackage(r3)     // Catch:{ Exception -> 0x0030 }
        L_0x0014:
            android.content.Context r3 = r2.getApplicationContext()     // Catch:{ Exception -> 0x0030 }
            boolean r3 = isIntentAvailable(r3, r0)     // Catch:{ Exception -> 0x0030 }
            if (r3 == 0) goto L_0x0022
            r2.startActivity(r0)     // Catch:{ Exception -> 0x0022 }
            return
        L_0x0022:
            android.net.Uri r3 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0030 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x0030 }
            java.lang.String r5 = "android.intent.action.VIEW"
            r4.<init>(r5, r3)     // Catch:{ Exception -> 0x0030 }
            r2.startActivity(r4)     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.AppTodoInterceptorImpl.doAppFollowUs(android.app.Activity, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static void executePrivilegeAwardTodoCode(Activity activity, String str) {
        if (!C4600l.m11739k(activity, true)) {
            ToastUtils.show((Context) activity, R.string.xiaoying_str_com_msg_network_inactive, 1);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("snsTypeList");
            if (optJSONArray != null) {
                if (optJSONArray.length() != 0) {
                    final String optString = jSONObject.optString("awardId");
                    final String optString2 = jSONObject.optString("title");
                    final String optString3 = jSONObject.optString("desc");
                    final int parseInt = C2575a.parseInt(jSONObject.optString(TODOParamModel.ACTIVITY_TODO_PARAM_SHARETYPE));
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String string = optJSONArray.getString(i);
                        if (!TextUtils.isEmpty(string) && TextUtils.isDigitsOnly(string)) {
                            arrayList.add(SnsShareTypeUtil.getMyResolveInfoBySnsType(activity.getApplicationContext(), C2575a.parseInt(string)));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        final String optString4 = jSONObject.optString("videoUrl");
                        final String optString5 = jSONObject.optString("url");
                        if (arrayList.size() > 1) {
                            Builder myResolveInfoList = new Builder().myResolveInfoList(arrayList);
                            final Activity activity2 = activity;
                            C36594 r3 = new OnPopupItemClickListener() {
                                public void onItemClick(MyResolveInfo myResolveInfo) {
                                    AppTodoInterceptorImpl.sharePrivilegeAward(activity2, myResolveInfo, parseInt, optString, optString2, optString3, optString4, optString5);
                                }
                            };
                            SnsShareManager.showVideoShareDialog(activity, myResolveInfoList.onPopupItemClickListener(r3).build());
                        } else {
                            sharePrivilegeAward(activity, (MyResolveInfo) arrayList.get(0), parseInt, optString, optString2, optString3, optString4, optString5);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x0430  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x020e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void executeURLTodo(android.app.Activity r7, com.introvd.template.router.todoCode.TODOParamModel r8, android.os.Bundle r9) {
        /*
            java.lang.String r0 = r8.mJsonParam
            java.lang.String r0 = parserUrl(r0)
            if (r0 == 0) goto L_0x0014
            java.lang.String r1 = "%"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x0014
            java.lang.String r0 = com.introvd.template.p324m.C7566b.m22321bX(r7, r0)
        L_0x0014:
            int r1 = r8.mTODOCode
            r2 = 911(0x38f, float:1.277E-42)
            if (r1 == r2) goto L_0x0447
            r2 = 915(0x393, float:1.282E-42)
            if (r1 == r2) goto L_0x043f
            r2 = 17001(0x4269, float:2.3823E-41)
            r3 = 1
            if (r1 == r2) goto L_0x03f6
            r2 = 0
            switch(r1) {
                case 901: goto L_0x031e;
                case 902: goto L_0x0174;
                case 903: goto L_0x016b;
                case 904: goto L_0x00f7;
                case 905: goto L_0x00c3;
                case 906: goto L_0x0094;
                case 907: goto L_0x0074;
                case 908: goto L_0x006d;
                case 909: goto L_0x0066;
                default: goto L_0x0027;
            }
        L_0x0027:
            switch(r1) {
                case 924: goto L_0x004f;
                case 925: goto L_0x002c;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0447
        L_0x002c:
            java.lang.String r8 = r8.mJsonParam     // Catch:{ Exception -> 0x0049 }
            java.lang.String r8 = parserUrl(r8)     // Catch:{ Exception -> 0x0049 }
            android.content.Intent r9 = new android.content.Intent     // Catch:{ Exception -> 0x0049 }
            java.lang.String r0 = "android.intent.action.VIEW"
            r9.<init>(r0)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r8 = formatVivaUrl(r7, r8)     // Catch:{ Exception -> 0x0049 }
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x0049 }
            r9.setData(r8)     // Catch:{ Exception -> 0x0049 }
            r7.startActivity(r9)     // Catch:{ Exception -> 0x0049 }
            goto L_0x0447
        L_0x0049:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0447
        L_0x004f:
            java.lang.String r8 = r8.mJsonParam     // Catch:{ Exception -> 0x0060 }
            java.lang.String r8 = parserUrl(r8)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r8 = formatVivaUrl(r7, r8)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r9 = " "
            com.introvd.template.router.AppRouter.startWebPage(r7, r8, r9)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0447
        L_0x0060:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0447
        L_0x0066:
            java.lang.String r8 = r8.mJsonParam
            start3rdApp(r7, r8)
            goto L_0x0447
        L_0x006d:
            r8 = -1
            com.introvd.template.app.utils.C4395c.m11088a(r7, r8)
            goto L_0x0447
        L_0x0074:
            java.lang.String r9 = com.introvd.template.module.p325a.C7572a.m22335jR(r0)
            java.lang.String r8 = r8.mJsonParam
            java.lang.String r8 = parserPackageName(r8)
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x0089
            launchStore(r7, r9)
            goto L_0x0447
        L_0x0089:
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0447
            lauchMarket4App(r7, r8)
            goto L_0x0447
        L_0x0094:
            java.lang.String r9 = ""
            java.lang.String r0 = r8.mJsonParam
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00a4
            java.lang.String r8 = r8.mJsonParam
            java.lang.String r9 = parserKeyword(r8)
        L_0x00a4:
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            if (r8 != 0) goto L_0x0447
            java.lang.String r8 = "/VivaCommunity/SearchVideoListActivity/entry"
            com.aiii.android.arouter.facade.a r8 = com.introvd.template.router.VivaRouter.getRouterBuilder(r8)
            java.lang.String r0 = "extra_video_tag"
            com.aiii.android.arouter.facade.a r8 = r8.mo10399f(r0, r9)
            int r9 = com.introvd.template.R.anim.activity_right_enter_translate
            int r0 = com.introvd.template.R.anim.activity_left_exit_translate
            com.aiii.android.arouter.facade.a r8 = r8.mo10394aZ(r9, r0)
            r8.mo10382H(r7)
            goto L_0x0447
        L_0x00c3:
            java.lang.String r8 = com.introvd.template.module.p325a.C7572a.m22335jR(r0)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x00da
            java.lang.String r9 = "https://play.google.com/store/apps/"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x00da
            launchStore(r7, r8)
            goto L_0x0447
        L_0x00da:
            android.content.Intent r9 = new android.content.Intent     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r0 = "android.intent.action.VIEW"
            r9.<init>(r0)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = formatVivaUrl(r7, r8)     // Catch:{ Exception -> 0x00f1 }
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x00f1 }
            r9.setData(r8)     // Catch:{ Exception -> 0x00f1 }
            r7.startActivity(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x0447
        L_0x00f1:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0447
        L_0x00f7:
            java.lang.String r8 = r8.mJsonParam
            java.util.HashMap r8 = parseSnsShare(r8)
            java.lang.String r9 = "snstype"
            java.lang.Object r9 = r8.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x016a
            boolean r9 = android.text.TextUtils.isDigitsOnly(r9)
            if (r9 != 0) goto L_0x0112
            goto L_0x016a
        L_0x0112:
            java.lang.String r9 = "snstype"
            java.lang.Object r9 = r8.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r9 = r9.intValue()
            java.lang.String r0 = "title"
            java.lang.Object r0 = r8.get(r0)
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r0 = "desc"
            java.lang.Object r0 = r8.get(r0)
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r0 = "image"
            java.lang.Object r0 = r8.get(r0)
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r0 = "url"
            java.lang.Object r8 = r8.get(r0)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r5 = formatVivaUrl(r7, r8)
            r0 = r7
            r1 = r9
            r2 = r6
            shareToSns(r0, r1, r2, r3, r4, r5)
            com.introvd.template.router.sns.MyResolveInfo r8 = com.introvd.template.sns.SnsShareTypeUtil.getMyResolveInfoBySnsType(r7, r9)
            if (r8 == 0) goto L_0x0447
            java.lang.CharSequence r9 = r8.label
            if (r9 == 0) goto L_0x0447
            r9 = 27
            java.lang.String r9 = com.introvd.template.p242d.C5527a.m14968kj(r9)
            java.lang.CharSequence r8 = r8.label
            java.lang.String r8 = r8.toString()
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.onEventVideoShare(r7, r9, r8, r6)
            goto L_0x0447
        L_0x016a:
            return
        L_0x016b:
            java.lang.String r8 = formatVivaUrl(r7, r0)
            startDownload(r7, r8)
            goto L_0x0447
        L_0x0174:
            boolean r1 = com.introvd.template.p203b.C4600l.m11739k(r7, r3)
            if (r1 != 0) goto L_0x017b
            return
        L_0x017b:
            java.lang.String r0 = com.introvd.template.module.p325a.C7572a.m22335jR(r0)
            java.lang.String r1 = ""
            java.lang.String r3 = ""
            if (r9 == 0) goto L_0x0191
            java.lang.String r1 = "content_title"
            java.lang.String r1 = r9.getString(r1)
            java.lang.String r3 = "pushMessageId"
            java.lang.String r3 = r9.getString(r3)
        L_0x0191:
            java.lang.String r9 = com.introvd.template.router.todoCode.TodoH5UrlFromParamHandler.getFromParam(r8)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x01a1
            java.lang.String r9 = "push_"
            java.lang.String r9 = com.introvd.template.router.todoCode.TodoH5UrlFromParamHandler.creatFromTitle(r9, r3)
        L_0x01a1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "902 fromTitle : "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.introvd.template.common.LogUtilsV2.m14227d(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x01c8
            java.lang.String r3 = "https://play.google.com/store/apps/"
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x01c8
            launchStore(r7, r0)
            goto L_0x0447
        L_0x01c8:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01e8 }
            java.lang.String r4 = r8.mJsonParam     // Catch:{ JSONException -> 0x01e8 }
            r3.<init>(r4)     // Catch:{ JSONException -> 0x01e8 }
            java.lang.String r4 = "existParam"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ JSONException -> 0x01e8 }
            java.lang.String r5 = "getAppMode"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r6 = "useHybrid"
            java.lang.String r3 = r3.optString(r6)     // Catch:{ JSONException -> 0x01e3 }
            r2 = r3
            goto L_0x01ee
        L_0x01e3:
            r3 = move-exception
            goto L_0x01eb
        L_0x01e5:
            r3 = move-exception
            r5 = r2
            goto L_0x01eb
        L_0x01e8:
            r3 = move-exception
            r4 = r2
            r5 = r4
        L_0x01eb:
            r3.printStackTrace()
        L_0x01ee:
            java.lang.String r3 = "1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x020e
            java.lang.String r7 = r8.mJsonParam
            java.lang.String r7 = parserUrl(r7)
            java.lang.Class<com.introvd.template.router.app.IAppService> r8 = com.introvd.template.router.app.IAppService.class
            com.aiii.android.arouter.facade.template.c r8 = com.introvd.template.router.BizServiceManager.getService(r8)
            com.introvd.template.router.app.IAppService r8 = (com.introvd.template.router.app.IAppService) r8
            if (r8 == 0) goto L_0x020d
            java.lang.String r7 = com.introvd.template.router.todoCode.TodoH5UrlFromParamHandler.addFromParamToUrl(r7, r9)
            r8.startHybridPage(r7)
        L_0x020d:
            return
        L_0x020e:
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r8 != 0) goto L_0x02c3
            java.lang.String r8 = "1"
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x02c3
            java.lang.String r8 = com.introvd.template.router.user.UserServiceProxy.getUserId()
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 != 0) goto L_0x0284
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            java.lang.String r3 = "_xiaoyingapp"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.introvd.template.common.MD5.md5(r2)
            if (r2 != 0) goto L_0x023f
            java.lang.String r2 = ""
        L_0x023f:
            java.lang.String r2 = r2.toUpperCase()
            java.lang.String r3 = "?"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x0268
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "&a="
            r3.append(r0)
            r3.append(r8)
            java.lang.String r8 = "&b="
            r3.append(r8)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            goto L_0x0284
        L_0x0268:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "?a="
            r3.append(r0)
            r3.append(r8)
            java.lang.String r8 = "&b="
            r3.append(r8)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
        L_0x0284:
            android.app.Application r8 = r7.getApplication()
            java.lang.String r8 = com.introvd.template.p203b.C4580b.m11653dz(r8)
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 != 0) goto L_0x02c3
            java.lang.String r2 = "?"
            boolean r2 = r0.contains(r2)
            if (r2 == 0) goto L_0x02af
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "&c="
            r2.append(r0)
            r2.append(r8)
            java.lang.String r0 = r2.toString()
            goto L_0x02c3
        L_0x02af:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "?c="
            r2.append(r0)
            r2.append(r8)
            java.lang.String r0 = r2.toString()
        L_0x02c3:
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r8 != 0) goto L_0x0311
            java.lang.String r8 = "1"
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L_0x0311
            com.introvd.template.common.model.AppStateModel r8 = com.introvd.template.common.model.AppStateModel.getInstance()
            boolean r8 = r8.isOpenCommunityEnabled()
            if (r8 == 0) goto L_0x02de
            java.lang.String r8 = "openCommunity"
            goto L_0x02e0
        L_0x02de:
            java.lang.String r8 = "tool"
        L_0x02e0:
            java.lang.String r2 = "?"
            boolean r2 = r0.contains(r2)
            if (r2 == 0) goto L_0x02fd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "&appMode="
            r2.append(r0)
            r2.append(r8)
            java.lang.String r0 = r2.toString()
            goto L_0x0311
        L_0x02fd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "?appMode="
            r2.append(r0)
            r2.append(r8)
            java.lang.String r0 = r2.toString()
        L_0x0311:
            java.lang.String r8 = formatVivaUrl(r7, r0)
            java.lang.String r8 = com.introvd.template.router.todoCode.TodoH5UrlFromParamHandler.addFromParamToUrl(r8, r9)
            com.introvd.template.router.AppRouter.startWebPage(r7, r8, r1)
            goto L_0x0447
        L_0x031e:
            java.lang.String r8 = formatVivaUrl(r7, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L_0x0329
            return
        L_0x0329:
            if (r9 == 0) goto L_0x0338
            java.lang.String r0 = "content_title"
            java.lang.String r2 = r9.getString(r0)
            java.lang.String r0 = "content_url"
            java.lang.String r9 = r9.getString(r0)
            goto L_0x0339
        L_0x0338:
            r9 = r2
        L_0x0339:
            com.introvd.template.router.community.VideoPlayIntentInfo r0 = new com.introvd.template.router.community.VideoPlayIntentInfo
            r0.<init>()
            java.util.Map r1 = getVideoPlaybackRequest(r8)
            r0.videoUrl = r8
            java.lang.String r8 = MAP_KEY_PUID
            boolean r8 = r1.containsKey(r8)
            if (r8 == 0) goto L_0x0357
            java.lang.String r8 = MAP_KEY_PUID
            java.lang.Object r8 = r1.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r0.puid = r8
            goto L_0x035b
        L_0x0357:
            java.lang.String r8 = ""
            r0.puid = r8
        L_0x035b:
            java.lang.String r8 = MAP_KEY_PVER
            boolean r8 = r1.containsKey(r8)
            if (r8 == 0) goto L_0x036e
            java.lang.String r8 = MAP_KEY_PVER
            java.lang.Object r8 = r1.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r0.pver = r8
            goto L_0x0372
        L_0x036e:
            java.lang.String r8 = ""
            r0.pver = r8
        L_0x0372:
            java.lang.String r8 = MAP_KEY_VIEW_URL
            boolean r8 = r1.containsKey(r8)
            if (r8 == 0) goto L_0x0385
            java.lang.String r8 = MAP_KEY_VIEW_URL
            java.lang.Object r8 = r1.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r0.webUrl = r8
            goto L_0x0389
        L_0x0385:
            java.lang.String r8 = ""
            r0.webUrl = r8
        L_0x0389:
            boolean r8 = android.text.TextUtils.isEmpty(r2)
            if (r8 == 0) goto L_0x03a7
            java.lang.String r8 = MAP_KEY_DESC
            boolean r8 = r1.containsKey(r8)
            if (r8 == 0) goto L_0x03a2
            java.lang.String r8 = MAP_KEY_DESC
            java.lang.Object r8 = r1.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r0.desc = r8
            goto L_0x03a9
        L_0x03a2:
            java.lang.String r8 = ""
            r0.desc = r8
            goto L_0x03a9
        L_0x03a7:
            r0.desc = r2
        L_0x03a9:
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            if (r8 == 0) goto L_0x03c7
            java.lang.String r8 = MAP_KEY_COVERURL
            boolean r8 = r1.containsKey(r8)
            if (r8 == 0) goto L_0x03c2
            java.lang.String r8 = MAP_KEY_COVERURL
            java.lang.Object r8 = r1.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r0.coverUrl = r8
            goto L_0x03c9
        L_0x03c2:
            java.lang.String r8 = ""
            r0.coverUrl = r8
            goto L_0x03c9
        L_0x03c7:
            r0.coverUrl = r9
        L_0x03c9:
            r8 = 0
            r0.playPosition = r8
            java.lang.String r8 = "/VivaCommunity/VideoPlayerActivity/entry"
            com.aiii.android.arouter.facade.a r8 = com.introvd.template.router.VivaRouter.getRouterBuilder(r8)
            java.lang.String r9 = "extra_video_play_intent_info"
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.String r0 = r1.toJson(r0)
            com.aiii.android.arouter.facade.a r8 = r8.mo10399f(r9, r0)
            java.lang.String r9 = "extra_intent_type"
            r0 = 4097(0x1001, float:5.741E-42)
            com.aiii.android.arouter.facade.a r8 = r8.mo10406h(r9, r0)
            int r9 = com.introvd.template.R.anim.activity_right_enter_translate
            int r0 = com.introvd.template.R.anim.activity_left_exit_translate
            com.aiii.android.arouter.facade.a r8 = r8.mo10394aZ(r9, r0)
            r8.mo10382H(r7)
            goto L_0x0447
        L_0x03f6:
            java.lang.String r9 = ""
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0426 }
            java.lang.String r8 = r8.mJsonParam     // Catch:{ JSONException -> 0x0426 }
            r1.<init>(r8)     // Catch:{ JSONException -> 0x0426 }
            java.lang.String r8 = "notificationType"
            int r8 = r1.optInt(r8)     // Catch:{ JSONException -> 0x0426 }
            java.lang.String r2 = "developerPayload"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ JSONException -> 0x0424 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0424 }
            if (r4 != 0) goto L_0x041d
            java.lang.String r4 = "QUVIDEO"
            int r4 = r2.indexOf(r4)     // Catch:{ JSONException -> 0x0424 }
            java.lang.String r0 = r2.substring(r0, r4)     // Catch:{ JSONException -> 0x0424 }
            r9 = r0
        L_0x041d:
            java.lang.String r0 = "paymentState"
            int r0 = r1.optInt(r0)     // Catch:{ JSONException -> 0x0424 }
            goto L_0x042d
        L_0x0424:
            r0 = move-exception
            goto L_0x0429
        L_0x0426:
            r8 = move-exception
            r0 = r8
            r8 = 0
        L_0x0429:
            r0.printStackTrace()
            r0 = 1
        L_0x042d:
            r1 = 7
            if (r8 != r1) goto L_0x0436
            java.lang.String r9 = "app"
            com.introvd.template.common.behavior.UserBehaviorUtils.recordSubscribePushClick(r7, r8, r0, r9)
            goto L_0x0447
        L_0x0436:
            java.lang.String r1 = "gpcenter"
            com.introvd.template.common.behavior.UserBehaviorUtils.recordSubscribePushClick(r7, r8, r0, r1)
            com.introvd.template.router.AppRouter.launchMarketSubscribe(r7, r9)
            goto L_0x0447
        L_0x043f:
            appBootUsageTodo(r7, r8)     // Catch:{ Exception -> 0x0443 }
            goto L_0x0447
        L_0x0443:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0447:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.AppTodoInterceptorImpl.executeURLTodo(android.app.Activity, com.introvd.template.router.todoCode.TODOParamModel, android.os.Bundle):void");
    }

    private static Map<String, String> featchStrInfoFromJson(String str, String[] strArr) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (String str2 : strArr) {
                String optString = jSONObject.optString(str2);
                if (!TextUtils.isEmpty(optString)) {
                    hashMap.put(str2, optString);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static String formatVivaUrl(Context context, String str) {
        boolean z;
        if (TextUtils.isEmpty(str) || context == null) {
            return str;
        }
        URI create = URI.create(str);
        if (!create.getHost().contains("xiaoying.tv") && !create.getHost().contains("vivavideo.tv")) {
            return str;
        }
        String query = create.getQuery();
        if (TextUtils.isEmpty(query)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("?");
            str = sb.toString();
            query = "";
            z = false;
        } else {
            z = true;
        }
        if (!query.contains("Language=")) {
            String b = C4580b.m11644b(Locale.getDefault());
            ISettingRouter iSettingRouter = (ISettingRouter) BizServiceManager.getService(ISettingRouter.class);
            if (iSettingRouter != null) {
                b = C4580b.m11644b(C4598j.m11732eK(iSettingRouter.getAppSettedLocaleModel(context).value));
            }
            String[] split = b.split("_");
            if (!b.equals("zh_TW") && !b.equals("zh_CN") && split.length >= 1) {
                b = b.equals("zh_HK") ? "zh_TW" : split[0];
            }
            if (z) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(RequestParameters.AMPERSAND);
                str = sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("Language=");
            sb3.append(b);
            str = sb3.toString();
            z = true;
        }
        if (!query.contains("Country=")) {
            String countryCode = AppStateModel.getInstance().getCountryCode();
            if (z) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(RequestParameters.AMPERSAND);
                str = sb4.toString();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("Country=");
            sb5.append(countryCode);
            str = sb5.toString();
            z = true;
        }
        if (!query.contains("AppKey=")) {
            String dx = C4580b.m11651dx(context);
            if (z) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append(RequestParameters.AMPERSAND);
                str = sb6.toString();
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str);
            sb7.append("AppKey=");
            sb7.append(dx);
            str = sb7.toString();
        }
        return str;
    }

    private static Map<String, String> getVideoPlaybackRequest(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String[] split = str.split("[?]");
        if (str.length() > 1 && split.length > 1 && split[1] != null) {
            str = split[1];
        }
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String[] strArr = {MAP_KEY_VIEW_URL, MAP_KEY_PUID, MAP_KEY_PVER, MAP_KEY_COVERURL, MAP_KEY_DESC};
        String[] strArr2 = {RequestParameters.AMPERSAND, RequestParameters.AMPERSAND, RequestParameters.AMPERSAND, RequestParameters.AMPERSAND, null};
        int length = str.length();
        for (int i = 0; i < strArr.length; i++) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(strArr[i]);
                sb.append(RequestParameters.EQUAL);
                int indexOf = str.indexOf(sb.toString());
                if (indexOf != -1) {
                    int length2 = indexOf + strArr[i].length() + 1;
                    int indexOf2 = strArr2[i] != null ? str.indexOf(strArr2[i], length2) : length;
                    if (!TextUtils.isEmpty(str.substring(length2, indexOf2))) {
                        hashMap.put(strArr[i], str.substring(length2, indexOf2));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void lauchMarket4App(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(str);
        intent.setData(Uri.parse(sb.toString()));
        try {
            String dy = C4580b.m11652dy(activity.getApplicationContext());
            if (storeMap.containsKey(dy)) {
                String str2 = (String) storeMap.get(dy);
                if (C4580b.m11631B(activity, str2)) {
                    intent.setPackage(str2);
                }
            }
            activity.startActivity(intent);
        } catch (Exception unused) {
            ToastUtils.show((Context) activity, R.string.xiaoying_str_studio_msg_app_not_found, 0);
        }
    }

    private static void launchStore(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !C4580b.m11654e(activity, str)) {
            String replace = str.startsWith(GOOGLEPLAY_APP_URL_PRE) ? str.replace(GOOGLEPLAY_APP_URL_PRE, GOOGLEPLAY_APP_URL_MARKET_PRE) : str;
            if (replace.startsWith(GOOGLEPLAY_APP_URL_MARKET_PRE)) {
                try {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(replace)));
                } catch (Exception unused) {
                    ToastUtils.show((Context) activity, R.string.xiaoying_str_studio_msg_app_not_found, 0);
                }
            } else {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        }
    }

    public static String makeOpenUrlTodoContent(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static HashMap<String, String> parseSnsShare(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            hashMap.put("title", jSONObject.getString("title"));
            hashMap.put(SocialConstDef.SHARE_SNS_TYPE, jSONObject.getString(SocialConstDef.SHARE_SNS_TYPE));
            hashMap.put("desc", jSONObject.getString("desc"));
            hashMap.put("image", jSONObject.getString("image"));
            hashMap.put("url", jSONObject.getString("url"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    private static String parserKeyword(String str) {
        String str2 = "";
        try {
            return new JSONObject(str).getString("keyword");
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    private static String parserPackageName(String str) {
        String str2 = "";
        try {
            return new JSONObject(str).getString("PackageName");
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    private static String parserUrl(String str) {
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            try {
                if (!TextUtils.isEmpty(optString)) {
                    return optString;
                }
                str2 = jSONObject.optString("fileurl");
                return str2;
            } catch (Exception e) {
                Exception exc = e;
                str2 = optString;
                e = exc;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return str2;
        }
    }

    private void preprocessSomething(TODOParamModel tODOParamModel) {
        try {
            JsonObject jsonObject = (JsonObject) new Gson().fromJson(tODOParamModel.mJsonParam, JsonObject.class);
            if (jsonObject.has("preprocess_hide_creation_tip") && "yes".equals(jsonObject.get("preprocess_hide_creation_tip").getAsString())) {
                AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_help_V2_show_flag", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static void sharePrivilegeAward(Activity activity, MyResolveInfo myResolveInfo, int i, final String str, String str2, String str3, String str4, String str5) {
        SnsShareInfo.Builder snsShareListener = new SnsShareInfo.Builder().strTitle(str2).strDesc(str3).strImgUrl(str5).strLinkUrl(str4).snsShareListener(new C4982c() {
            public void onHandleIntentShare(int i) {
            }

            public void onShareCanceled(int i) {
            }

            public void onShareFailed(int i, int i2, String str) {
            }

            public void onShareSuccess(int i) {
                if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                    C1848s privilegeAward = UserServiceProxy.setPrivilegeAward(str);
                    if (privilegeAward != null) {
                        privilegeAward.mo10196g(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                            /* renamed from: a */
                            public void mo9883a(C1495b bVar) {
                            }

                            /* renamed from: a */
                            public void onSuccess(JsonObject jsonObject) {
                            }

                            public void onError(Throwable th) {
                                th.printStackTrace();
                            }
                        });
                    }
                }
            }
        });
        if (i == 0) {
            SnsShareManager.shareImage(activity, myResolveInfo.snsType, snsShareListener.build());
        } else {
            SnsShareManager.shareLink(activity, myResolveInfo.snsType, snsShareListener.build(), C5527a.m14968kj(27));
        }
    }

    private static void shareToSns(Activity activity, int i, String str, String str2, String str3, String str4) {
        SnsShareManager.shareLink(activity, i, new SnsShareInfo.Builder().strTitle(str).strDesc(str2).strImgUrl(str3).strLinkUrl(str4).build(), C5527a.m14968kj(27));
    }

    private static void start3rdApp(Activity activity, String str) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("PackageName")) {
                str2 = jSONObject.getString("PackageName");
            }
            if (jSONObject.has("appurl")) {
                str3 = jSONObject.getString("appurl");
            }
            if (jSONObject.has("weburl")) {
                str4 = jSONObject.getString("weburl");
            }
            doAppFollowUs(activity, str2, str3, str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void startDownload(Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            externalStoragePublicDirectory.mkdirs();
            String md5 = MD5.md5(str);
            if (!TextUtils.isEmpty(md5)) {
                StringBuilder sb = new StringBuilder();
                sb.append(externalStoragePublicDirectory.getPath());
                sb.append("/");
                sb.append(md5);
                sb.append(".apk");
                String sb2 = sb.toString();
                if (FileUtils.isFileExisted(sb2)) {
                    FileUtils.deleteFile(sb2);
                }
                ContentResolver contentResolver = activity.getContentResolver();
                Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_URLCACHE);
                long enqueue = DownloadService.enqueue(activity, str, sb2, 1, 3);
                ContentValues contentValues = new ContentValues();
                contentValues.put("local", C4580b.m11662ez(sb2));
                contentValues.put("remote", str);
                contentValues.put("type", Integer.valueOf(3));
                contentValues.put("userdata", String.valueOf(enqueue));
                contentResolver.insert(tableUri, contentValues);
                DownloadService.startDownload(activity, enqueue);
                ToastUtils.show((Context) activity, R.string.xiaoying_str_com_msg_download, 0);
            }
        }
    }

    private static void startDownloadTestAPK(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            externalStoragePublicDirectory.mkdirs();
            String md5 = MD5.md5(str);
            if (!TextUtils.isEmpty(md5)) {
                StringBuilder sb = new StringBuilder();
                sb.append(externalStoragePublicDirectory.getPath());
                sb.append("/");
                sb.append(md5);
                sb.append(".apk");
                String sb2 = sb.toString();
                if (FileUtils.isFileExisted(sb2)) {
                    FileUtils.deleteFile(sb2);
                }
                ContentResolver contentResolver = context.getContentResolver();
                Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_URLCACHE);
                long enqueue = DownloadService.enqueue(context, str, sb2, 1, 4097);
                ContentValues contentValues = new ContentValues();
                contentValues.put("local", C4580b.m11662ez(sb2));
                contentValues.put("remote", str);
                contentValues.put("type", Integer.valueOf(4097));
                contentValues.put("userdata", String.valueOf(enqueue));
                contentResolver.insert(tableUri, contentValues);
                DownloadService.startDownload(context, enqueue);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean executeQATestTodo(android.content.Context r13, com.introvd.template.router.todoCode.TODOParamModel r14, android.os.Bundle r15) {
        /*
            r12 = this;
            int r15 = r14.mTODOCode
            r0 = 1
            switch(r15) {
                case 10001: goto L_0x0040;
                case 10002: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            r13 = 0
            return r13
        L_0x0008:
            java.lang.String r15 = ""
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0030 }
            java.lang.String r14 = r14.mJsonParam     // Catch:{ Exception -> 0x0030 }
            r1.<init>(r14)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r14 = "url"
            java.lang.String r14 = r1.getString(r14)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r14 = com.introvd.template.p324m.C7566b.m22321bX(r13, r14)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r15 = "auto"
            boolean r15 = r1.getBoolean(r15)     // Catch:{ Exception -> 0x002b }
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = "pref_key_3rd_apk_auto_load"
            r1.setAppSettingBoolean(r2, r15)     // Catch:{ Exception -> 0x002b }
            goto L_0x0035
        L_0x002b:
            r15 = move-exception
            r11 = r15
            r15 = r14
            r14 = r11
            goto L_0x0031
        L_0x0030:
            r14 = move-exception
        L_0x0031:
            r14.printStackTrace()
            r14 = r15
        L_0x0035:
            boolean r15 = android.text.TextUtils.isEmpty(r14)
            if (r15 != 0) goto L_0x00b3
            startDownloadTestAPK(r13, r14)
            goto L_0x00b3
        L_0x0040:
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r14 = r14.mJsonParam     // Catch:{ Throwable -> 0x00b3 }
            r15.<init>(r14)     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r14 = "url"
            java.lang.String r14 = r15.optString(r14)     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r1 = "type"
            java.lang.String r6 = r15.optString(r1)     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r1 = "0"
            boolean r7 = r1.equals(r6)     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r1 = "param"
            java.lang.String r15 = r15.optString(r1)     // Catch:{ Throwable -> 0x00b3 }
            boolean r1 = isTesing     // Catch:{ Throwable -> 0x00b3 }
            if (r1 == 0) goto L_0x0064
            goto L_0x00b3
        L_0x0064:
            isTesing = r0     // Catch:{ Throwable -> 0x00b3 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00b3 }
            com.introvd.template.q.f r8 = com.introvd.template.p374q.C8347f.aKf()     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r9 = "passthrough.httprequest"
            com.introvd.template.app.AppTodoInterceptorImpl$3 r10 = new com.introvd.template.app.AppTodoInterceptorImpl$3     // Catch:{ Throwable -> 0x00b3 }
            r1 = r10
            r2 = r12
            r5 = r14
            r1.<init>(r3, r5, r6)     // Catch:{ Throwable -> 0x00b3 }
            r8.mo33601a(r9, r10)     // Catch:{ Throwable -> 0x00b3 }
            boolean r1 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Throwable -> 0x00b3 }
            if (r1 == 0) goto L_0x008a
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r7)     // Catch:{ Throwable -> 0x00b3 }
            r1 = 0
            com.introvd.template.p374q.C8346e.m24073a(r13, r14, r15, r1)     // Catch:{ Throwable -> 0x00b3 }
            goto L_0x00b3
        L_0x008a:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ Throwable -> 0x00b3 }
            r1.<init>()     // Catch:{ Throwable -> 0x00b3 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00b3 }
            r2.<init>(r15)     // Catch:{ Throwable -> 0x00b3 }
            java.util.Iterator r15 = r2.keys()     // Catch:{ Throwable -> 0x00b3 }
        L_0x0098:
            boolean r3 = r15.hasNext()     // Catch:{ Throwable -> 0x00b3 }
            if (r3 == 0) goto L_0x00ac
            java.lang.Object r3 = r15.next()     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r4 = r2.getString(r3)     // Catch:{ Throwable -> 0x00b3 }
            r1.putString(r3, r4)     // Catch:{ Throwable -> 0x00b3 }
            goto L_0x0098
        L_0x00ac:
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r7)     // Catch:{ Throwable -> 0x00b3 }
            com.introvd.template.p374q.C8346e.m24073a(r13, r14, r15, r1)     // Catch:{ Throwable -> 0x00b3 }
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.AppTodoInterceptorImpl.executeQATestTodo(android.content.Context, com.introvd.template.router.todoCode.TODOParamModel, android.os.Bundle):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean executeTodo(final android.app.Activity r10, com.introvd.template.router.todoCode.TODOParamModel r11, android.os.Bundle r12) {
        /*
            r9 = this;
            r9.preprocessSomething(r11)
            int r0 = r11.mTODOCode
            r1 = 1
            switch(r0) {
                case 901: goto L_0x03b5;
                case 902: goto L_0x03b5;
                case 903: goto L_0x03b5;
                case 904: goto L_0x03b5;
                case 905: goto L_0x03b5;
                case 906: goto L_0x03b5;
                case 907: goto L_0x03b5;
                case 908: goto L_0x03b5;
                case 909: goto L_0x03b5;
                case 910: goto L_0x03a1;
                case 911: goto L_0x03b5;
                default: goto L_0x0009;
            }
        L_0x0009:
            r2 = 0
            switch(r0) {
                case 917: goto L_0x0364;
                case 918: goto L_0x0342;
                case 919: goto L_0x031e;
                case 920: goto L_0x030c;
                default: goto L_0x000d;
            }
        L_0x000d:
            switch(r0) {
                case 924: goto L_0x03b5;
                case 925: goto L_0x03b5;
                default: goto L_0x0010;
            }
        L_0x0010:
            r3 = 2
            r4 = 0
            r5 = 0
            switch(r0) {
                case 942: goto L_0x0304;
                case 943: goto L_0x026a;
                case 944: goto L_0x0259;
                case 945: goto L_0x0228;
                default: goto L_0x0017;
            }
        L_0x0017:
            switch(r0) {
                case 10001: goto L_0x021f;
                case 10002: goto L_0x021f;
                default: goto L_0x001a;
            }
        L_0x001a:
            r4 = -1
            switch(r0) {
                case 15001: goto L_0x01ff;
                case 15002: goto L_0x01fa;
                case 15003: goto L_0x01ed;
                default: goto L_0x001e;
            }
        L_0x001e:
            switch(r0) {
                case 16007: goto L_0x017e;
                case 16008: goto L_0x0179;
                default: goto L_0x0021;
            }
        L_0x0021:
            switch(r0) {
                case 1: goto L_0x03b8;
                case 120: goto L_0x0158;
                case 442: goto L_0x0151;
                case 915: goto L_0x03b5;
                case 940: goto L_0x00d2;
                case 999: goto L_0x009e;
                case 3002: goto L_0x0093;
                case 16004: goto L_0x0041;
                case 17001: goto L_0x03b5;
                case 21001: goto L_0x0025;
                default: goto L_0x0024;
            }
        L_0x0024:
            return r2
        L_0x0025:
            java.lang.String r12 = r11.mJsonParam
            if (r12 == 0) goto L_0x003b
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0037 }
            java.lang.String r11 = r11.mJsonParam     // Catch:{ Throwable -> 0x0037 }
            r12.<init>(r11)     // Catch:{ Throwable -> 0x0037 }
            java.lang.String r11 = "id"
            long r11 = r12.getLong(r11)     // Catch:{ Throwable -> 0x0037 }
            goto L_0x003c
        L_0x0037:
            r11 = move-exception
            r11.printStackTrace()
        L_0x003b:
            r11 = r5
        L_0x003c:
            com.introvd.template.app.utils.C4395c.m11088a(r10, r11)
            goto L_0x03b8
        L_0x0041:
            java.lang.String r12 = ""
            java.lang.String r0 = "platinum"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ NullPointerException | JSONException -> 0x0073 }
            java.lang.String r11 = r11.mJsonParam     // Catch:{ NullPointerException | JSONException -> 0x0073 }
            r3.<init>(r11)     // Catch:{ NullPointerException | JSONException -> 0x0073 }
            java.lang.String r11 = "packagetype"
            java.lang.String r11 = r3.optString(r11)     // Catch:{ NullPointerException | JSONException -> 0x0073 }
            java.lang.String r0 = "accurateFrom"
            java.lang.String r0 = r3.optString(r0)     // Catch:{ NullPointerException | JSONException -> 0x006e }
            java.lang.String r12 = "fromTodocode"
            java.lang.String r12 = r3.optString(r12)     // Catch:{ NullPointerException | JSONException -> 0x006c }
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch:{ NullPointerException | JSONException -> 0x006c }
            if (r3 != 0) goto L_0x007b
            java.lang.String r3 = "Iap_Domestic_Todo_Code"
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ NullPointerException | JSONException -> 0x006c }
            com.introvd.template.module.iap.business.p356e.C7897a.m23022b(r12, r3, r2)     // Catch:{ NullPointerException | JSONException -> 0x006c }
            goto L_0x007b
        L_0x006c:
            r12 = move-exception
            goto L_0x0078
        L_0x006e:
            r0 = move-exception
            r8 = r0
            r0 = r12
            r12 = r8
            goto L_0x0078
        L_0x0073:
            r11 = move-exception
            r8 = r12
            r12 = r11
            r11 = r0
            r0 = r8
        L_0x0078:
            r12.printStackTrace()
        L_0x007b:
            r4 = r11
            com.introvd.template.module.iap.h r2 = com.introvd.template.module.iap.C8049f.aBf()
            r5 = 0
            boolean r11 = android.text.TextUtils.isEmpty(r0)
            if (r11 == 0) goto L_0x008b
            java.lang.String r11 = "todoCode"
            r6 = r11
            goto L_0x008c
        L_0x008b:
            r6 = r0
        L_0x008c:
            r7 = -1
            r3 = r10
            r2.mo33097b(r3, r4, r5, r6, r7)
            goto L_0x03b8
        L_0x0093:
            boolean r11 = com.introvd.template.router.user.UserServiceProxy.isLogin()
            if (r11 != 0) goto L_0x03b8
            com.introvd.template.router.LoginRouter.startSettingBindAccountActivity(r10)
            goto L_0x03b8
        L_0x009e:
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r2 = com.introvd.template.p242d.C5527a.cnQ
            r0.setAppSettingInt(r2, r1)
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r2 = "key_saved_home_tab_time"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            long r4 = java.lang.System.currentTimeMillis()
            r3.append(r4)
            java.lang.String r4 = ""
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.setAppSettingStr(r2, r3)
            com.introvd.template.i r0 = com.introvd.template.C4681i.m12184Gp()
            com.introvd.template.AppMiscListener r0 = r0.mo25016Gr()
            r0.executeTodoCode(r10, r11, r12)
            goto L_0x03b8
        L_0x00d2:
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r5 = com.introvd.template.p242d.C5527a.cnQ
            r0.setAppSettingInt(r5, r2)
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r5 = com.introvd.template.router.community.util.CommunityPageTabConstants.KEY_SAVED_TAB_ID
            r0.setAppSettingInt(r5, r3)
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r3 = "key_saved_home_tab_time"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            long r6 = java.lang.System.currentTimeMillis()
            r5.append(r6)
            java.lang.String r6 = ""
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r0.setAppSettingStr(r3, r5)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0140 }
            java.lang.String r3 = r11.mJsonParam     // Catch:{ JSONException -> 0x0140 }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x0140 }
            java.lang.String r3 = "ignoreVideoHotHint"
            boolean r2 = r0.optBoolean(r3, r2)     // Catch:{ JSONException -> 0x0140 }
            com.aiii.android.arouter.c.a r3 = com.aiii.android.arouter.p091c.C1919a.m5529sc()     // Catch:{ JSONException -> 0x0140 }
            java.lang.Class<com.introvd.template.router.community.ICommunityAPI> r5 = com.introvd.template.router.community.ICommunityAPI.class
            java.lang.Object r3 = r3.mo10356i(r5)     // Catch:{ JSONException -> 0x0140 }
            com.introvd.template.router.community.ICommunityAPI r3 = (com.introvd.template.router.community.ICommunityAPI) r3     // Catch:{ JSONException -> 0x0140 }
            if (r3 == 0) goto L_0x0130
            if (r2 != 0) goto L_0x0130
            com.introvd.template.common.model.AppStateModel r2 = com.introvd.template.common.model.AppStateModel.getInstance()     // Catch:{ JSONException -> 0x0140 }
            boolean r2 = r2.isMiddleEast()     // Catch:{ JSONException -> 0x0140 }
            if (r2 == 0) goto L_0x0130
            boolean r2 = com.introvd.template.app.ApplicationBase.biq     // Catch:{ JSONException -> 0x0140 }
            if (r2 == 0) goto L_0x0130
            r3.setVideoHotHintEnabled()     // Catch:{ JSONException -> 0x0140 }
        L_0x0130:
            java.lang.String r2 = "categoryId"
            int r0 = r0.optInt(r2, r4)     // Catch:{ JSONException -> 0x0140 }
            com.introvd.template.common.AppPreferencesSetting r2 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ JSONException -> 0x0140 }
            java.lang.String r3 = "hot_category_id"
            r2.setAppSettingInt(r3, r0)     // Catch:{ JSONException -> 0x0140 }
            goto L_0x0144
        L_0x0140:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0144:
            com.introvd.template.i r0 = com.introvd.template.C4681i.m12184Gp()
            com.introvd.template.AppMiscListener r0 = r0.mo25016Gr()
            r0.executeTodoCode(r10, r11, r12)
            goto L_0x03b8
        L_0x0151:
            r11 = 9
            com.introvd.template.router.editor.EditorRouter.launchLocalFileAlbumAndGotoMusicExtractActivity(r10, r1, r11)
            goto L_0x03b8
        L_0x0158:
            android.content.Intent r11 = r10.getIntent()
            java.lang.String r12 = "IntentMagicCode"
            long r11 = r11.getLongExtra(r12, r5)
            java.lang.String r0 = "/xysetting/SettingActivityV6/entry"
            com.aiii.android.arouter.facade.a r0 = com.introvd.template.router.VivaRouter.getRouterBuilder(r0)
            java.lang.String r3 = "IntentMagicCode"
            com.aiii.android.arouter.facade.a r11 = r0.mo10386a(r3, r11)
            java.lang.String r12 = "key_go_feedback"
            com.aiii.android.arouter.facade.a r11 = r11.mo10391a(r12, r2)
            r11.mo10382H(r10)
            goto L_0x03b8
        L_0x0179:
            com.introvd.template.router.AdRouter.launchVipExchange(r10)
            goto L_0x03b8
        L_0x017e:
            com.introvd.template.common.model.AppStateModel r12 = com.introvd.template.common.model.AppStateModel.getInstance()
            boolean r12 = r12.isInChina()
            if (r12 == 0) goto L_0x03b8
            java.lang.String r12 = "todoCode"
            java.lang.String r0 = ""
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01c9 }
            java.lang.String r11 = r11.mJsonParam     // Catch:{ JSONException -> 0x01c9 }
            r5.<init>(r11)     // Catch:{ JSONException -> 0x01c9 }
            java.lang.String r11 = "msgId"
            java.lang.String r11 = r5.optString(r11)     // Catch:{ JSONException -> 0x01c9 }
            java.lang.String r3 = "defaultSubId"
            java.lang.String r3 = r5.optString(r3)     // Catch:{ JSONException -> 0x01c3 }
            java.lang.String r0 = "accurateFrom"
            java.lang.String r0 = r5.optString(r0)     // Catch:{ JSONException -> 0x01bf }
            java.lang.String r4 = "fromTodocode"
            java.lang.String r4 = r5.optString(r4)     // Catch:{ JSONException -> 0x01bd }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x01bd }
            if (r5 != 0) goto L_0x01d2
            java.lang.String r5 = "Iap_Domestic_Todo_Code"
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ JSONException -> 0x01bd }
            com.introvd.template.module.iap.business.p356e.C7897a.m23022b(r4, r5, r6)     // Catch:{ JSONException -> 0x01bd }
            goto L_0x01d2
        L_0x01bd:
            r4 = move-exception
            goto L_0x01cf
        L_0x01bf:
            r0 = move-exception
            r8 = r4
            r4 = r0
            goto L_0x01ce
        L_0x01c3:
            r3 = move-exception
            r8 = r3
            r3 = r0
            r0 = r4
            r4 = r8
            goto L_0x01cf
        L_0x01c9:
            r11 = move-exception
            r8 = r4
            r4 = r11
            r11 = r3
            r3 = r0
        L_0x01ce:
            r0 = r8
        L_0x01cf:
            r4.printStackTrace()
        L_0x01d2:
            boolean r4 = android.text.TextUtils.isEmpty(r11)
            if (r4 != 0) goto L_0x01d9
            goto L_0x01da
        L_0x01d9:
            r11 = r12
        L_0x01da:
            boolean r12 = android.text.TextUtils.isEmpty(r0)
            if (r12 != 0) goto L_0x01e1
            r11 = r0
        L_0x01e1:
            java.lang.String r12 = com.introvd.template.module.iap.business.p356e.C7898b.dSW
            java.lang.String[] r0 = new java.lang.String[r2]
            com.introvd.template.module.iap.business.p356e.C7897a.m23022b(r11, r12, r0)
            com.introvd.template.router.AdRouter.launchVipRenew(r10, r3)
            goto L_0x03b8
        L_0x01ed:
            com.introvd.template.i r11 = com.introvd.template.C4681i.m12184Gp()
            com.introvd.template.AppMiscListener r11 = r11.mo25016Gr()
            r11.showRateDialog(r10)
            goto L_0x03b8
        L_0x01fa:
            com.introvd.template.app.p192l.C4031a.m10003N(r10)
            goto L_0x03b8
        L_0x01ff:
            java.lang.String r11 = r11.mJsonParam     // Catch:{ JSONException -> 0x020d }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x020d }
            r12.<init>(r11)     // Catch:{ JSONException -> 0x020d }
            java.lang.String r11 = "dialogid"
            int r11 = r12.optInt(r11)     // Catch:{ JSONException -> 0x020d }
            goto L_0x0212
        L_0x020d:
            r11 = move-exception
            r11.printStackTrace()
            r11 = -1
        L_0x0212:
            com.introvd.template.i r12 = com.introvd.template.C4681i.m12184Gp()
            com.introvd.template.AppMiscListener r12 = r12.mo25016Gr()
            r12.showPopupWindow(r10, r11)
            goto L_0x03b8
        L_0x021f:
            android.content.Context r10 = r10.getApplicationContext()
            r9.executeQATestTodo(r10, r11, r12)
            goto L_0x03b8
        L_0x0228:
            org.json.JSONObject r11 = r11.getJsonObj()
            if (r11 == 0) goto L_0x0234
            java.lang.String r12 = "ttid"
            java.lang.String r4 = r11.optString(r12)
        L_0x0234:
            boolean r11 = android.text.TextUtils.isEmpty(r4)
            if (r11 == 0) goto L_0x023b
            return r1
        L_0x023b:
            b.b.s r11 = com.introvd.template.app.school.api.C4153h.m10367dR(r4)
            b.b.r r12 = p037b.p050b.p076j.C1820a.aVi()
            b.b.s r11 = r11.mo10196g(r12)
            b.b.r r12 = p037b.p050b.p051a.p053b.C1487a.aUa()
            b.b.s r11 = r11.mo10194f(r12)
            com.introvd.template.app.AppTodoInterceptorImpl$2 r12 = new com.introvd.template.app.AppTodoInterceptorImpl$2
            r12.<init>(r10)
            r11.mo10188a(r12)
            goto L_0x03b8
        L_0x0259:
            org.json.JSONObject r11 = r11.getJsonObj()
            if (r11 == 0) goto L_0x0265
            java.lang.String r12 = "puiddigest"
            java.lang.String r4 = r11.optString(r12)
        L_0x0265:
            com.introvd.template.app.utils.C4395c.m11093b(r10, r3, r4)
            goto L_0x03b8
        L_0x026a:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x02fe }
            java.lang.String r11 = r11.mJsonParam     // Catch:{ Exception -> 0x02fe }
            r12.<init>(r11)     // Catch:{ Exception -> 0x02fe }
            java.lang.String r11 = "url"
            java.lang.String r11 = r12.optString(r11)     // Catch:{ Exception -> 0x02fe }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x02fe }
            if (r12 == 0) goto L_0x027e
            return r1
        L_0x027e:
            android.net.Uri r12 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x02fe }
            java.lang.String r0 = "puid"
            java.lang.String r0 = r12.getQueryParameter(r0)     // Catch:{ Exception -> 0x02fe }
            long r5 = com.p131c.p132a.p135c.C2575a.m7390m(r0, r5)     // Catch:{ Exception -> 0x02fe }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02fe }
            java.lang.String r3 = "ver"
            java.lang.String r3 = r12.getQueryParameter(r3)     // Catch:{ Exception -> 0x02fe }
            int r3 = com.p131c.p132a.p135c.C2575a.parseInt(r3, r2)     // Catch:{ Exception -> 0x02fe }
            java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x02fe }
            java.lang.String r3 = "ayid"
            java.lang.String r12 = r12.getQueryParameter(r3)     // Catch:{ Exception -> 0x02fe }
            int r12 = com.p131c.p132a.p135c.C2575a.parseInt(r12, r2)     // Catch:{ Exception -> 0x02fe }
            java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x02fe }
            com.introvd.template.router.todoCode.TODOParamModel r12 = new com.introvd.template.router.todoCode.TODOParamModel     // Catch:{ Exception -> 0x02fe }
            r12.<init>()     // Catch:{ Exception -> 0x02fe }
            r3 = 902(0x386, float:1.264E-42)
            r12.mTODOCode = r3     // Catch:{ Exception -> 0x02fe }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x02fe }
            r3.<init>()     // Catch:{ Exception -> 0x02fe }
            java.lang.String r5 = "existParam"
            r3.put(r5, r2)     // Catch:{ JSONException -> 0x02cd }
            java.lang.String r5 = "getAppMode"
            r3.put(r5, r2)     // Catch:{ JSONException -> 0x02cd }
            java.lang.String r2 = "useHybrid"
            r3.put(r2, r1)     // Catch:{ JSONException -> 0x02cd }
            java.lang.String r2 = "url"
            r3.put(r2, r11)     // Catch:{ JSONException -> 0x02cd }
            goto L_0x02d1
        L_0x02cd:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ Exception -> 0x02fe }
        L_0x02d1:
            java.lang.String r11 = r3.toString()     // Catch:{ Exception -> 0x02fe }
            r12.mJsonParam = r11     // Catch:{ Exception -> 0x02fe }
            com.aiii.android.arouter.c.a r11 = com.aiii.android.arouter.p091c.C1919a.m5529sc()     // Catch:{ Exception -> 0x02fe }
            java.lang.Class<com.introvd.template.router.common.ICommonFuncRouter> r2 = com.introvd.template.router.common.ICommonFuncRouter.class
            java.lang.Object r11 = r11.mo10356i(r2)     // Catch:{ Exception -> 0x02fe }
            com.introvd.template.router.common.ICommonFuncRouter r11 = (com.introvd.template.router.common.ICommonFuncRouter) r11     // Catch:{ Exception -> 0x02fe }
            if (r11 == 0) goto L_0x03b8
            r11.executeTodo(r10, r12, r4)     // Catch:{ Exception -> 0x02fe }
            b.b.s r10 = com.introvd.template.app.school.api.C4147b.m10337a(r0)     // Catch:{ Exception -> 0x02fe }
            b.b.r r11 = p037b.p050b.p076j.C1820a.aVi()     // Catch:{ Exception -> 0x02fe }
            b.b.s r10 = r10.mo10196g(r11)     // Catch:{ Exception -> 0x02fe }
            com.introvd.template.app.AppTodoInterceptorImpl$1 r11 = new com.introvd.template.app.AppTodoInterceptorImpl$1     // Catch:{ Exception -> 0x02fe }
            r11.<init>()     // Catch:{ Exception -> 0x02fe }
            r10.mo10188a(r11)     // Catch:{ Exception -> 0x02fe }
            goto L_0x03b8
        L_0x02fe:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x03b8
        L_0x0304:
            com.introvd.template.app.youngermode.C4545a.m11477V(r10)
            r10.finish()
            goto L_0x03b8
        L_0x030c:
            boolean r12 = com.introvd.template.router.user.UserServiceProxy.isLogin()
            if (r12 == 0) goto L_0x0319
            java.lang.String r11 = r11.mJsonParam
            executePrivilegeAwardTodoCode(r10, r11)
            goto L_0x03b8
        L_0x0319:
            com.introvd.template.router.LoginRouter.startSettingBindAccountActivity(r10)
            goto L_0x03b8
        L_0x031e:
            boolean r11 = com.introvd.template.router.user.UserServiceProxy.isLogin()
            if (r11 == 0) goto L_0x033d
            java.lang.String r11 = "/app/UserGradePage"
            com.aiii.android.arouter.facade.a r11 = com.introvd.template.router.VivaRouter.getRouterBuilder(r11)
            java.lang.String r12 = "intent_extra_key_default_page_index"
            com.aiii.android.arouter.facade.a r11 = r11.mo10406h(r12, r1)
            int r12 = com.introvd.template.R.anim.activity_right_enter_translate
            int r0 = com.introvd.template.R.anim.activity_left_exit_translate
            com.aiii.android.arouter.facade.a r11 = r11.mo10394aZ(r12, r0)
            r11.mo10382H(r10)
            goto L_0x03b8
        L_0x033d:
            com.introvd.template.router.LoginRouter.startSettingBindAccountActivity(r10)
            goto L_0x03b8
        L_0x0342:
            boolean r11 = com.introvd.template.router.user.UserServiceProxy.isLogin()
            if (r11 == 0) goto L_0x0360
            java.lang.String r11 = "/app/UserGradePage"
            com.aiii.android.arouter.facade.a r11 = com.introvd.template.router.VivaRouter.getRouterBuilder(r11)
            java.lang.String r12 = "intent_extra_key_default_page_index"
            com.aiii.android.arouter.facade.a r11 = r11.mo10406h(r12, r2)
            int r12 = com.introvd.template.R.anim.activity_right_enter_translate
            int r0 = com.introvd.template.R.anim.activity_left_exit_translate
            com.aiii.android.arouter.facade.a r11 = r11.mo10394aZ(r12, r0)
            r11.mo10382H(r10)
            goto L_0x03b8
        L_0x0360:
            com.introvd.template.router.LoginRouter.startSettingBindAccountActivity(r10)
            goto L_0x03b8
        L_0x0364:
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r3 = com.introvd.template.p242d.C5527a.cnQ
            r0.setAppSettingInt(r3, r2)
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r2 = com.introvd.template.router.community.util.CommunityPageTabConstants.KEY_SAVED_TAB_ID
            r3 = 3
            r0.setAppSettingInt(r2, r3)
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r2 = "key_saved_home_tab_time"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            long r4 = java.lang.System.currentTimeMillis()
            r3.append(r4)
            java.lang.String r4 = ""
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.setAppSettingStr(r2, r3)
            com.introvd.template.i r0 = com.introvd.template.C4681i.m12184Gp()
            com.introvd.template.AppMiscListener r0 = r0.mo25016Gr()
            r0.executeTodoCode(r10, r11, r12)
            goto L_0x03b8
        L_0x03a1:
            java.lang.String r11 = "Ad_Shuffle_Enter_Click"
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            com.introvd.template.common.UserBehaviorLog.onKVEvent(r10, r11, r12)
            java.lang.String r11 = "/XYAD/ShuffleAdActivity/entry"
            com.aiii.android.arouter.facade.a r11 = com.introvd.template.router.VivaRouter.getRouterBuilder(r11)
            r11.mo10382H(r10)
            goto L_0x03b8
        L_0x03b5:
            executeURLTodo(r10, r11, r12)
        L_0x03b8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.AppTodoInterceptorImpl.executeTodo(android.app.Activity, com.introvd.template.router.todoCode.TODOParamModel, android.os.Bundle):boolean");
    }

    public String getTodoCodeName(int i) {
        switch (i) {
            case TodoConstants.TODO_TYPE_OPEN_URL /*902*/:
            case TodoConstants.TODO_TYPE_OPEN_URL_JD /*924*/:
                return "打开外链";
            case TodoConstants.TODO_TYPE_DOWNLOAD_APK /*903*/:
                return "APK下载";
            case TodoConstants.TODO_TYPE_OPEN_URL_BY_BROWSER /*905*/:
            case TodoConstants.TODO_TYPE_OPEN_URL_BY_BROWSER_JD /*925*/:
                return "借助浏览器打开链接";
            case TodoConstants.TODO_TYPE_OPEN_APP_STORE /*907*/:
                return "进入应用市场";
            case TodoConstants.TODO_TYPE_GOTO_FEEDBACK /*908*/:
                return "进入用户反馈";
            case TodoConstants.TODO_TYPE_SHOW_SHUFFLE_ADS /*910*/:
                return "shuffle";
            case TodoConstants.TODO_TYPE_SHOW_FAQ /*911*/:
                return "进入FAG";
            case TodoConstants.TODO_TYPE_HOME_MORE /*4007*/:
                return "more tools";
            default:
                return null;
        }
    }
}
