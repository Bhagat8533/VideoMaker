package com.introvd.template.editor.todo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.template.ITemplateService;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.router.todoCode.BaseTodoInterceptor;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.template.C8622a;
import com.introvd.template.template.download.web.C8714c;
import com.introvd.template.template.p407e.C8735f;
import com.p131c.p132a.p135c.C2575a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@C1942a(mo10417rZ = "/XYVideoEditor/todoInterceptor")
public class EditorTodoInterceptorImpl extends BaseTodoInterceptor {
    private FragmentBase downloadFragment;

    private boolean checkTemplate(final Activity activity, final TODOParamModel tODOParamModel, Bundle bundle) {
        ITemplateService iTemplateService = (ITemplateService) BizServiceManager.getService(ITemplateService.class);
        boolean z = iTemplateService != null ? !iTemplateService.checkTodoParamXytExist(activity.getApplicationContext(), tODOParamModel) : false;
        final String str = null;
        if (bundle != null) {
            str = bundle.getString("activityID", null);
        }
        int i = bundle != null ? bundle.getInt(TODOParamModel.TODO_PARAM_PAGE_FROM, -1) : -1;
        if (i != -1) {
            try {
                JSONObject jSONObject = new JSONObject(tODOParamModel.mJsonParam);
                jSONObject.put(TODOParamModel.TODO_PARAM_PAGE_FROM, i);
                tODOParamModel.mJsonParam = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (z) {
            if (C4600l.m11739k(activity, true) && (activity instanceof FragmentActivity)) {
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        EditorTodoInterceptorImpl.this.showDownloadFragment((FragmentActivity) activity, tODOParamModel, str);
                    }
                });
            }
            return true;
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            executeTodo(activity, tODOParamModel, tODOParamModel.mTODOCode, str);
            if (tODOParamModel.getAutoCloseParam()) {
                activity.finish();
            }
            return true;
        }
    }

    private static void dispathTemplateTodo(Activity activity, TODOParamModel tODOParamModel) {
        switch (tODOParamModel.mTODOCode) {
            case 603:
                String parserTcid = parserTcid(tODOParamModel.mJsonParam);
                if (612 == tODOParamModel.mTODOCode) {
                    parserTcid = C8399c.ede;
                }
                C8345d.m24070l(activity.getApplicationContext(), parserTcid, false);
                if (TextUtils.equals(parserTcid, C8399c.edf)) {
                    TemplateRouter.launchFontActivity(activity, C8399c.edf, tODOParamModel);
                    return;
                } else if (TextUtils.equals(parserTcid, C8399c.ecY)) {
                    TemplateRouter.launchFilterActivity(activity, parserTcid, tODOParamModel);
                    return;
                } else if (TextUtils.equals(parserTcid, C8399c.edd)) {
                    TemplateRouter.launchAnimateFrameActivity(activity, parserTcid, tODOParamModel);
                    return;
                } else {
                    TemplateRouter.launchTemplateInfoActivity(activity, parserTcid, true, tODOParamModel);
                    return;
                }
            case 605:
                TemplateRouter.getRouterBuilder(activity.getApplication(), TemplateRouter.URL_TEMPLATE_CATEGORY).mo10382H(activity);
                return;
            case 606:
                HashMap parserPreviewTodoContent = parserPreviewTodoContent(tODOParamModel.mJsonParam);
                TemplateRouter.getRouterBuilder(activity.getApplication(), TemplateRouter.URL_TEMPLATE_PREVIEW).mo10406h(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TYPE, C2575a.parseInt((String) parserPreviewTodoContent.get("type"))).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_URL, (String) parserPreviewTodoContent.get("url")).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TTID, (String) parserPreviewTodoContent.get("ttid")).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_VER, (String) parserPreviewTodoContent.get("ver")).mo10382H(activity);
                return;
            case 610:
                HashMap parserPreviewTodoContent2 = parserPreviewTodoContent(tODOParamModel.mJsonParam);
                String str = (String) parserPreviewTodoContent2.get("tcid");
                String str2 = (String) parserPreviewTodoContent2.get(SocialConstDef.TEMPLATEROLLMAP_ITEM_ROLLCODE);
                RollInfo X = C8735f.m25474X(activity, str, str2);
                C1941a routerBuilder = C8399c.ecY.equals(str) ? TemplateRouter.getRouterBuilder(activity.getApplication(), TemplateRouter.URL_FILTER_DETAIL) : TemplateRouter.getRouterBuilder(activity.getApplication(), TemplateRouter.URL_TEMPLATE_ROLL_DETAIL);
                routerBuilder.mo10391a(TemplateRouter.BUNDLE_SELF_APPLY_KEY, true);
                if (X == null) {
                    routerBuilder.mo10399f(TemplateRouter.KEY_TEMPLATE_ROLL_CODE, str2);
                } else if (C8399c.ecY.equals(str)) {
                    C8622a.ctW = X;
                } else {
                    C8622a.ekc = X;
                }
                routerBuilder.mo10399f(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID, str);
                routerBuilder.mo10382H(activity);
                return;
            case 611:
                HashMap parserPreviewTodoContent3 = parserPreviewTodoContent(tODOParamModel.mJsonParam);
                TemplateRouter.getRouterBuilder(activity.getApplication(), TemplateRouter.URL_TEMPLATE_PREVIEW).mo10391a(TemplateRouter.TEMPLATE_CARD_PREVIEWTYPE_IAP_KEY, true).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_URL, (String) parserPreviewTodoContent3.get("url")).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TTID, (String) parserPreviewTodoContent3.get("ttid")).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_VER, (String) parserPreviewTodoContent3.get("ver")).mo10382H(activity);
                return;
            case TodoConstants.TODO_TYPE_DOWNLOAD_TEMPLATE_PACKAGE /*1108*/:
                TemplateRouter.getRouterBuilder(activity.getApplication(), TemplateRouter.URL_TEMPLATE_PACKAGE).mo10399f(TemplateRouter.EXTRA_KEY_TEMPLATE_PACKAGE_GROUPCODE, parserTodoParam(tODOParamModel.mJsonParam)).mo10382H(activity);
                return;
            default:
                return;
        }
    }

    private static HashMap<String, String> parserPreviewTodoContent(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("url")) {
                hashMap.put("url", jSONObject.getString("url"));
            }
            if (jSONObject.has("type")) {
                hashMap.put("type", String.valueOf(jSONObject.getInt("type")));
            }
            if (jSONObject.has("ttid")) {
                hashMap.put("ttid", jSONObject.getString("ttid"));
            }
            if (jSONObject.has("ver")) {
                hashMap.put("ver", jSONObject.getString("ver"));
            }
            if (jSONObject.has("tcid")) {
                hashMap.put("tcid", jSONObject.getString("tcid"));
            }
            if (jSONObject.has(SocialConstDef.TEMPLATEROLLMAP_ITEM_ROLLCODE)) {
                hashMap.put(SocialConstDef.TEMPLATEROLLMAP_ITEM_ROLLCODE, jSONObject.getString(SocialConstDef.TEMPLATEROLLMAP_ITEM_ROLLCODE));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    private static String parserTcid(String str) {
        String str2 = "";
        try {
            return new JSONObject(str).getString("TCID");
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    private static String parserTodoParam(String str) {
        String str2 = "";
        try {
            return new JSONObject(str).getString("code");
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    private static boolean prepareEmptyPrj(Activity activity, String str) {
        C8522g aJA = C8522g.aJA();
        if (aJA == null) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            C8558m.egR = str;
        }
        aJA.ebQ = -1;
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        String[] strArr = {"", ""};
        if (iEditorService != null) {
            strArr = iEditorService.getCommonBehaviorParam();
        }
        aJA.mo34756b(activity.getApplicationContext(), null, false, strArr[0], strArr[1]);
        return false;
    }

    /* access modifiers changed from: private */
    public void showDownloadFragment(FragmentActivity fragmentActivity, TODOParamModel tODOParamModel, String str) {
        if (this.downloadFragment == null || this.downloadFragment.getActivity() != fragmentActivity) {
            this.downloadFragment = (FragmentBase) C1919a.m5529sc().mo10355al(TemplateRouter.URL_TEMPLATE_WEB_DOWNLOAD).mo10387a(TodoConstants.KEY_TODOCODE_PARAM_MODEL, (Parcelable) tODOParamModel).mo10412rX();
            this.downloadFragment.setResultCallback(new C8714c(fragmentActivity, tODOParamModel, str));
            fragmentActivity.getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) this.downloadFragment).commitAllowingStateLoss();
            return;
        }
        this.downloadFragment.setResultCallback(new C8714c(fragmentActivity, tODOParamModel, str));
        this.downloadFragment.setFragmentParams(tODOParamModel);
    }

    public static String todoCode2URL(Activity activity, TODOParamModel tODOParamModel) {
        Builder magicCode = new Builder().setSourceMode(0).setNewPrj(true).setAction(0).setMagicCode(activity.getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0));
        EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
        int i = tODOParamModel.mTODOCode;
        if (i == 401) {
            magicCode.setSourceMode(0);
            editorIntentInfo.tabType = C3742b.m9111II().mo23126IT();
            editorIntentInfo.from = EditorRouter.ENTRANCE_EDIT;
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, magicCode.build(), editorIntentInfo, tODOParamModel);
        } else if (i != 408) {
            if (i != 428) {
                if (i != 430) {
                    switch (i) {
                        case 411:
                        case 412:
                        case 413:
                        case 414:
                        case 420:
                        case 422:
                            break;
                        case 415:
                        case 416:
                        case 417:
                        case TodoConstants.TODO_TYPE_EDITOR_DUB_CHOOSE /*418*/:
                            break;
                        case 419:
                            magicCode.setSourceMode(0);
                            editorIntentInfo.baseMode = 0;
                            editorIntentInfo.tabType = 3;
                            editorIntentInfo.secondaryMode = -1;
                            editorIntentInfo.paramMap.put(EditorRouter.KEY_PARAMS_THEME_MUSIC_DOWNLOAD, "true");
                            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, magicCode.build(), editorIntentInfo, tODOParamModel);
                        case TodoConstants.TODO_TYPE_EDITOR_GIF_MAKER /*421*/:
                            magicCode.setSourceMode(0).setExtraIntentMode(2004);
                            editorIntentInfo.baseMode = 1;
                            editorIntentInfo.secondaryMode = -1;
                            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, magicCode.build(), editorIntentInfo, tODOParamModel);
                        default:
                            switch (i) {
                                case TodoConstants.TODO_TYPE_EDITOR_BASIC_COLLAGE /*432*/:
                                case TodoConstants.TODO_TYPE_EDITOR_BASIC_FX /*433*/:
                                    break;
                                default:
                                    switch (i) {
                                        case TodoConstants.TODO_TYPE_EDITOR_BASIC_TRANSITION /*435*/:
                                        case TodoConstants.TODO_TYPE_EDITOR_MAGIC_SOUND /*440*/:
                                            break;
                                        case TodoConstants.TODO_TYPE_EDITOR_FAST /*436*/:
                                            magicCode.setSourceMode(1).setLimitRangeCount(1);
                                            editorIntentInfo.baseMode = 2;
                                            editorIntentInfo.autoPlay = false;
                                            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, magicCode.build(), editorIntentInfo, tODOParamModel);
                                        case TodoConstants.TODO_TYPE_EDITOR_BGM /*437*/:
                                        case TodoConstants.TODO_TYPE_EDITOR_MOSAIC /*439*/:
                                        case TodoConstants.TODO_TYPE_EDITOR_CUSTOM_WATERMARK /*441*/:
                                            break;
                                        case TodoConstants.TODO_TYPE_EDITOR_TEMPLATE_APPLY /*438*/:
                                            String str = "";
                                            try {
                                                JSONObject jsonObj = tODOParamModel.getJsonObj();
                                                if (jsonObj != null) {
                                                    str = new JSONObject(jsonObj.optString("theme")).optString("ttid", "");
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                            magicCode.setSourceMode(0);
                                            editorIntentInfo.baseMode = 0;
                                            editorIntentInfo.tabType = 0;
                                            editorIntentInfo.paramMap.put(EditorRouter.MAP_PARAMS_TEMPLATE_ID, str);
                                            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, magicCode.build(), editorIntentInfo, tODOParamModel);
                                        default:
                                            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, magicCode.build(), editorIntentInfo, tODOParamModel);
                                    }
                            }
                    }
                }
                return C6932c.m20191a(tODOParamModel, magicCode, editorIntentInfo);
            }
            return C6931b.m20190a(tODOParamModel, magicCode, editorIntentInfo);
        } else {
            magicCode.setSourceMode(2);
            editorIntentInfo.tabType = 0;
            editorIntentInfo.autoPlay = true;
            editorIntentInfo.from = EditorRouter.ENTRANCE_MV;
            return PassThoughUrlGenerator.generateUrl(GalleryRouter.URL, magicCode.build(), editorIntentInfo, tODOParamModel);
        }
    }

    public boolean executeTodo(Activity activity, TODOParamModel tODOParamModel, int i, String str) {
        if (tODOParamModel != null && TextUtils.isEmpty(str)) {
            return executeTodo(activity, tODOParamModel, null);
        }
        C6933d.asD().mo30582a(activity, tODOParamModel, i, str);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        dispathTemplateTodo(r6, r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean executeTodo(android.app.Activity r6, com.introvd.template.router.todoCode.TODOParamModel r7, android.os.Bundle r8) {
        /*
            r5 = this;
            r0 = 1
            if (r8 == 0) goto L_0x0012
            java.lang.String r1 = "key_check_template_download"
            boolean r1 = r8.getBoolean(r1)
            if (r1 == 0) goto L_0x0012
            boolean r1 = r5.checkTemplate(r6, r7, r8)
            if (r1 == 0) goto L_0x0012
            return r0
        L_0x0012:
            int r1 = r7.mTODOCode
            r2 = -1
            switch(r1) {
                case 408: goto L_0x00c9;
                case 409: goto L_0x00b1;
                default: goto L_0x0018;
            }
        L_0x0018:
            r3 = 0
            switch(r1) {
                case 411: goto L_0x00c9;
                case 412: goto L_0x00c9;
                case 413: goto L_0x00c9;
                case 414: goto L_0x00c9;
                case 415: goto L_0x00c9;
                case 416: goto L_0x00c9;
                case 417: goto L_0x00c9;
                case 418: goto L_0x00c9;
                case 419: goto L_0x00c9;
                case 420: goto L_0x00c9;
                case 421: goto L_0x00c9;
                case 422: goto L_0x00c9;
                case 423: goto L_0x0078;
                case 424: goto L_0x0074;
                case 425: goto L_0x005a;
                case 426: goto L_0x0038;
                default: goto L_0x001c;
            }
        L_0x001c:
            switch(r1) {
                case 432: goto L_0x00c9;
                case 433: goto L_0x00c9;
                default: goto L_0x001f;
            }
        L_0x001f:
            switch(r1) {
                case 435: goto L_0x00c9;
                case 436: goto L_0x00c9;
                case 437: goto L_0x00c9;
                case 438: goto L_0x00c9;
                case 439: goto L_0x00c9;
                case 440: goto L_0x00c9;
                case 441: goto L_0x00c9;
                default: goto L_0x0022;
            }
        L_0x0022:
            switch(r1) {
                case 605: goto L_0x0033;
                case 606: goto L_0x0033;
                default: goto L_0x0025;
            }
        L_0x0025:
            switch(r1) {
                case 610: goto L_0x0033;
                case 611: goto L_0x0033;
                case 612: goto L_0x00c9;
                default: goto L_0x0028;
            }
        L_0x0028:
            switch(r1) {
                case 401: goto L_0x00c9;
                case 428: goto L_0x00c9;
                case 430: goto L_0x00c9;
                case 603: goto L_0x0033;
                case 701: goto L_0x002c;
                case 1108: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            return r3
        L_0x002c:
            java.lang.String r1 = r7.mJsonParam
            com.introvd.template.router.StudioRouter.launchStudioActivity(r6, r1)
            goto L_0x00d4
        L_0x0033:
            dispathTemplateTodo(r6, r7)
            goto L_0x00d4
        L_0x0038:
            org.json.JSONObject r1 = r7.getJsonObj()
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0046
            java.lang.String r2 = "code"
            java.lang.String r2 = r1.optString(r2)
        L_0x0046:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = ""
            com.introvd.template.router.slide.FunnySlideRouter.launchTemplateDetail(r6, r1, r2)
            goto L_0x00d4
        L_0x0053:
            int r1 = r7.mTODOCode
            com.introvd.template.router.slide.FunnySlideRouter.launchTemplateInfo(r6, r1)
            goto L_0x00d4
        L_0x005a:
            java.lang.String r1 = r7.mJsonParam
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00d4
            java.lang.Class<com.introvd.template.router.editor.IEditorService> r1 = com.introvd.template.router.editor.IEditorService.class
            com.aiii.android.arouter.facade.template.c r1 = com.introvd.template.router.BizServiceManager.getService(r1)
            com.introvd.template.router.editor.IEditorService r1 = (com.introvd.template.router.editor.IEditorService) r1
            if (r1 == 0) goto L_0x00d4
            java.lang.String r2 = r7.mJsonParam
            java.lang.String r4 = "Local_Notification_unexported"
            r1.enterPreview(r6, r2, r3, r4)
            goto L_0x00d4
        L_0x0074:
            com.introvd.template.editor.provider.C6703a.m19483as(r6)
            goto L_0x00d4
        L_0x0078:
            if (r8 == 0) goto L_0x0081
            java.lang.String r1 = "pageFrom"
            int r1 = r8.getInt(r1, r2)
            goto L_0x0082
        L_0x0081:
            r1 = -1
        L_0x0082:
            if (r1 == r2) goto L_0x009b
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r3 = r7.mJsonParam     // Catch:{ JSONException -> 0x0097 }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r3 = "pageFrom"
            r2.put(r3, r1)     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = r2.toString()     // Catch:{ JSONException -> 0x0097 }
            r7.mJsonParam = r1     // Catch:{ JSONException -> 0x0097 }
            goto L_0x009b
        L_0x0097:
            r1 = move-exception
            r1.printStackTrace()
        L_0x009b:
            com.introvd.template.editor.common.a r1 = com.introvd.template.editor.common.C5837a.agH()
            boolean r1 = r1.agM()
            if (r1 == 0) goto L_0x00ad
            com.introvd.template.editor.todo.d r1 = com.introvd.template.editor.todo.C6933d.asD()
            r1.mo30581a(r6, r7)
            goto L_0x00d4
        L_0x00ad:
            com.introvd.template.router.slide.SlideshowRouter.launchSlideshowEdit(r6, r7)
            goto L_0x00d4
        L_0x00b1:
            java.lang.String r1 = r7.mJsonParam
            boolean r1 = prepareEmptyPrj(r6, r1)
            if (r1 == 0) goto L_0x00ba
            goto L_0x00d4
        L_0x00ba:
            android.content.Intent r1 = r6.getIntent()
            java.lang.String r2 = "new_prj"
            r1.putExtra(r2, r0)
            java.lang.String r1 = ""
            com.introvd.template.router.editor.pip.PIPDesignerRouter.launchPipDesigner(r6, r1)
            goto L_0x00d4
        L_0x00c9:
            java.lang.String r1 = todoCode2URL(r6, r7)
            com.introvd.template.router.editor.gallery.GalleryRouter r3 = com.introvd.template.router.editor.gallery.GalleryRouter.getInstance()
            r3.launchActivity(r6, r1, r2)
        L_0x00d4:
            if (r8 != 0) goto L_0x00d9
            java.lang.String r6 = "400"
            goto L_0x00e1
        L_0x00d9:
            java.lang.String r6 = "common_param_position"
            java.lang.String r1 = "400"
            java.lang.String r6 = r8.getString(r6, r1)
        L_0x00e1:
            if (r7 != 0) goto L_0x00e6
            java.lang.String r7 = "0"
            goto L_0x00f9
        L_0x00e6:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r7 = r7.mTODOCode
            r8.append(r7)
            java.lang.String r7 = ""
            r8.append(r7)
            java.lang.String r7 = r8.toString()
        L_0x00f9:
            com.introvd.template.editor.p244a.C5553a.m15009b(r7, r6, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.todo.EditorTodoInterceptorImpl.executeTodo(android.app.Activity, com.introvd.template.router.todoCode.TODOParamModel, android.os.Bundle):boolean");
    }

    public String getTodoCodeName(int i) {
        if (i == 201) {
            return "随拍模式";
        }
        if (i == 401) {
            return "视频编辑";
        }
        if (i == 603) {
            return "进入指定种类的模板列表";
        }
        if (i == 605) {
            return "进入素材中心主页";
        }
        if (i == 701) {
            return "工作室";
        }
        if (i == 1108) {
            return "模板下载";
        }
        switch (i) {
            case 207:
                return "音乐镜头";
            case TodoConstants.TODO_TYPE_CAMERA_MODE_ACTION /*208*/:
                return "特效镜头";
            case TodoConstants.TODO_TYPE_CAMERA_MODE_FUNNY /*209*/:
                return "搞怪镜头";
            case TodoConstants.TODO_TYPE_CAMERA_MODE_PIP /*210*/:
                return "画中画镜头";
            case TodoConstants.TODO_TYPE_CAMERA_MODE_FB /*211*/:
                return "美颜镜头";
            default:
                switch (i) {
                    case TodoConstants.TODO_TYPE_CAMERA_MODE_FB6 /*215*/:
                        return "美颜镜头V6";
                    case TodoConstants.TODO_TYPE_CAMERA_MODE_HD6 /*216*/:
                        return "高清镜头V6";
                    case TodoConstants.TODO_TYPE_CAMERA_MODE_MV6 /*217*/:
                        return "音乐镜头V6";
                    default:
                        switch (i) {
                            case 408:
                                return "photoMV编辑";
                            case 409:
                                return "画中画编辑";
                            default:
                                return null;
                        }
                }
        }
    }
}
