package com.introvd.template.editor.provider;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p021v4.content.LocalBroadcastManager;
import android.view.View;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.datacenter.project.OldProjectItem;
import com.introvd.template.datacenter.project.PrjTableUpgradeUtil;
import com.introvd.template.datacenter.project.PrjTableUpgradeUtil.IProjectUpdateListener;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.p244a.C5553a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p252e.C5879b;
import com.introvd.template.editor.p266h.C6405k;
import com.introvd.template.editor.service.ProjectScanService;
import com.introvd.template.editor.service.StoryboardOpService;
import com.introvd.template.editor.studio.C6913d;
import com.introvd.template.editor.studio.StudioItemView;
import com.introvd.template.editor.todo.C6928a;
import com.introvd.template.editor.todo.C6933d;
import com.introvd.template.explorer.p300e.C7212e;
import com.introvd.template.explorer.p300e.C7213f;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.community.CommunityServiceProxy;
import com.introvd.template.router.community.publish.PublishProjectInfo;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.database.C8405a;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8567u;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8520e;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.p131c.p132a.C2561a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QSecurityUtil;

@C1942a(mo10417rZ = "/XYVideoEditor/editor_service")
public class EditorServiceImpl implements IEditorService {
    private static final byte[][] KEY_ARRAY_LIST = {new byte[]{118, 105, 118, 97, 118, 105, 100, 101, 111}, new byte[]{115, 108, 105, 100, 101, 112, 108, 117, 115}, new byte[]{107, 97, 109, 115, 116, 97, 114}};
    private static final int[] KEY_RES_ARRAY = {R.string.google_key1, R.string.google_key2, R.string.google_key3};
    private static final int[] KEY_RES_ARRAY_LITE = {R.string.google_lite_key1, R.string.google_lite_key2, R.string.google_lite_key3};
    private static final int[] KEY_RES_ARRAY_PRO = {R.string.google_pro_key1, R.string.google_pro_key2, R.string.google_pro_key3};

    /* access modifiers changed from: private */
    public void addClipToStoryBoard(List<TrimedClipItemDataModel> list) {
        C8522g aJA = C8522g.aJA();
        C8501a aJs = C8501a.aJs();
        if (list != null) {
            int w = C8540q.m24976w(aJA.aHd());
            for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                if (trimedClipItemDataModel != null) {
                    if (trimedClipItemDataModel.isImage.booleanValue()) {
                        String str = trimedClipItemDataModel.mExportPath;
                        if (str != null) {
                            int i = w;
                            for (int i2 = 0; i2 < trimedClipItemDataModel.repeatCount.intValue(); i2++) {
                                if (aJA.mo34725a(str, aJs, i, -1, -1, trimedClipItemDataModel.mRotate.intValue(), false) == 0) {
                                    i++;
                                }
                            }
                            w = i;
                        }
                    } else if (aJA.mo34724a(trimedClipItemDataModel, aJs, w, true) == 0) {
                        w++;
                    }
                }
            }
        }
    }

    private void asyncAddClipAndPreview(final Activity activity, final List<TrimedClipItemDataModel> list) {
        C4586g.m11703a((Context) activity, R.string.xiaoying_str_com_loading, (OnCancelListener) null);
        C1834l.m5257ah(list).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<List<TrimedClipItemDataModel>>() {
            /* renamed from: V */
            public void accept(List<TrimedClipItemDataModel> list) {
                for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                    String str = trimedClipItemDataModel.mRawFilePath;
                    if ((trimedClipItemDataModel.isExported.booleanValue() || trimedClipItemDataModel.isImage.booleanValue()) && FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                        str = trimedClipItemDataModel.mExportPath;
                    }
                    C8522g.m24676iP(str);
                }
                EditorServiceImpl.this.addClipToStoryBoard(list);
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<TrimedClipItemDataModel>>() {
            /* renamed from: R */
            public void mo9886K(List<TrimedClipItemDataModel> list) {
                C4586g.m11696Sm();
                EditorServiceImpl.this.saveCurrProject();
                EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
                editorIntentInfo.tabType = 0;
                editorIntentInfo.autoPlay = true;
                EditorRouter.launchEditorActivity(activity, editorIntentInfo);
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                C4586g.m11696Sm();
            }
        });
    }

    private static void loadProject(final Activity activity, String str, final boolean z, final String str2) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("prj_load_callback_action");
        LocalBroadcastManager.getInstance(activity.getApplicationContext()).registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
                if (!"prj_load_callback_action".equals(intent.getAction())) {
                    return;
                }
                if (intent.getBooleanExtra("prj_load_cb_intent_data_flag", true)) {
                    C8381b aIQ = z ? C8468c.aIQ() : C8522g.aJA();
                    if (!aIQ.aHb()) {
                        aIQ.mo33874S(activity.getApplicationContext(), false);
                    }
                    int a = C8446b.aIZ().mo34315a(activity.getApplicationContext(), aIQ.aHe());
                    if (aIQ.aHe() != null) {
                        aIQ.aHe().strExtra = C8558m.m25029ol(aIQ.aHe().strExtra);
                        C1820a.aVi().mo10058o(new Runnable() {
                            public void run() {
                                if (!z) {
                                    C8522g.aJA().aHc();
                                } else {
                                    C8468c.aIQ().aHc();
                                }
                            }
                        });
                    }
                    C6913d.m20147a(activity, a, aIQ, str2);
                    return;
                }
                C4586g.m11695Sl();
                ToastUtils.show(context, R.string.xiaoying_str_ve_project_load_fail, 0);
            }
        }, intentFilter);
        ProjectScanService.m19510j(activity.getApplicationContext(), str, z);
    }

    private void prepareEmptyPrj() {
        Context applicationContext = VivaBaseApplication.m8749FZ().getApplicationContext();
        C8522g aJA = C8522g.aJA();
        aJA.ebQ = -1;
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        String[] strArr = {"", ""};
        if (iEditorService != null) {
            strArr = iEditorService.getCommonBehaviorParam();
        }
        aJA.mo34756b(applicationContext, null, false, strArr[0], strArr[1]);
    }

    /* access modifiers changed from: private */
    public void saveCurrProject() {
        DataItemProject aHe = C8522g.aJA().aHe();
        if (aHe == null) {
            prepareEmptyPrj();
            aHe = C8522g.aJA().aHe();
            if (aHe == null) {
                return;
            }
        }
        StoryboardOpService.savePrj(VivaBaseApplication.m8749FZ().getApplicationContext(), aHe.strPrjURL);
    }

    public int GetHWDecoderVersion() {
        return QUtils.GetHWDecoderVersion();
    }

    public int GetHWEncoderVersion() {
        return QUtils.GetHWEncoderVersion();
    }

    public void applyTheme(Context context, String str, String str2) {
        StoryboardOpService.applyTheme(context, str, str2);
    }

    public void clearProject(int i, boolean z) {
        ContentResolver contentResolver = VivaBaseApplication.m8749FZ().getApplicationContext().getContentResolver();
        C8522g aJA = C8522g.aJA();
        DataItemProject aHe = aJA.aHe();
        if (aHe != null) {
            aJA.mo34734a(contentResolver, aHe.strPrjURL, i, z);
        }
    }

    public void createProjectAndPreview(Activity activity, String str, boolean z) {
        prepareEmptyPrj();
        TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
        trimedClipItemDataModel.mExportPath = str;
        trimedClipItemDataModel.isImage = Boolean.valueOf(!z);
        ArrayList arrayList = new ArrayList();
        arrayList.add(trimedClipItemDataModel);
        asyncAddClipAndPreview(activity, arrayList);
    }

    public void enterPreview(Activity activity, String str, boolean z, String str2) {
        loadProject(activity, str, z, str2);
    }

    public String[] getCommonBehaviorParam() {
        String[] strArr = {"", ""};
        strArr[0] = C5553a.bix;
        strArr[1] = C5553a.cyL;
        return strArr;
    }

    public Map<String, String> getCurProjectMaterialInfo(Context context, int i) {
        HashMap hashMap = new HashMap();
        QStoryboard aHd = C8522g.aJA().aHd();
        if (aHd == null) {
            return hashMap;
        }
        String G = C8540q.m24898G(aHd);
        if (FileUtils.isFileExisted(G)) {
            hashMap.put("musicName", C7213f.m21300D(context, G, ""));
        }
        DataItemProject aHe = C8522g.aJA().aHe();
        JSONObject a = C5554b.m15012a(context, aHd, aHe._id);
        if (a != null) {
            if (C8558m.m25019aW(aHe.strExtra, "prj_reshare_flag")) {
                try {
                    a.put("SNS_SHARE", "YES");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            hashMap.put("prjTemplates", a.toString());
        }
        return hashMap;
    }

    public int getDraftLayoutHeight(Context context) {
        return StudioItemView.getDraftLayoutHeight(context);
    }

    public C1834l<List<String>> getDraftThumbnailList(Context context) {
        return C8446b.aIZ().mo34318ao(context, 0);
    }

    public int getEngineVersion() {
        return QEngine.VERSION_NUMBER;
    }

    public String getExportedFilePath() {
        DataItemProject aHe = C8522g.aJA().aHe();
        if (aHe != null) {
            return aHe.strPrjExportURL;
        }
        return null;
    }

    public String getGoogleKey() {
        StringBuilder sb = new StringBuilder();
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        sb.delete(0, sb.length());
        int[] iArr = (C2561a.aOR() == 3 || C2561a.aOS()) ? KEY_RES_ARRAY_LITE : C2561a.aOR() == 4 ? KEY_RES_ARRAY_PRO : KEY_RES_ARRAY;
        for (int i = 0; i < iArr.length; i++) {
            sb.append(QSecurityUtil.decrypt("DES", new String(KEY_ARRAY_LIST[i]), FZ.getString(iArr[i])));
        }
        return sb.toString();
    }

    public String getGpuType() {
        return C8520e.getGpuType();
    }

    public int getStudioDraftCount(Context context) {
        if (C8446b.aIZ().getCount() == 0) {
            C8446b.aIZ().mo34316am(context, 0);
        }
        return C8446b.aIZ().getCount();
    }

    public View getStudioItemView(Context context) {
        return new StudioItemView(context);
    }

    public String getTagInfoByActivityId(String str) {
        return C6933d.asD().mo30583iK(str);
    }

    public void handleJoinEvent(Activity activity, String str, String str2, String str3, String str4) {
        C6928a.handleJoinEvent(activity, str, str2, str3, str4);
    }

    public void handleJoinEventInfo(Activity activity, TODOParamModel tODOParamModel, int i, String str) {
        C6933d.asD().mo30582a(activity, tODOParamModel, i, str);
    }

    public void init(Context context) {
    }

    public void initProjectUpdateHandle() {
        PrjTableUpgradeUtil.setProjectUpdateListener(new IProjectUpdateListener() {
            public void handleProjectUpdate(ArrayList<OldProjectItem> arrayList) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    OldProjectItem oldProjectItem = (OldProjectItem) it.next();
                    DataItemProject dataItemProject = new DataItemProject();
                    dataItemProject.strPrjURL = oldProjectItem.strPrjURL;
                    dataItemProject.strPrjExportURL = oldProjectItem.strPrjExportURL;
                    dataItemProject.iPrjClipCount = oldProjectItem.iPrjClipCount;
                    dataItemProject.iPrjDuration = oldProjectItem.iPrjDuration;
                    dataItemProject.strPrjThumbnail = oldProjectItem.strPrjThumbnail;
                    dataItemProject.strCoverURL = oldProjectItem.strCoverURL;
                    dataItemProject.strPrjVersion = oldProjectItem.strPrjVersion;
                    dataItemProject.strCreateTime = oldProjectItem.strCreateTime;
                    dataItemProject.strModifyTime = oldProjectItem.strModifyTime;
                    dataItemProject.iIsDeleted = oldProjectItem.iIsDeleted;
                    dataItemProject.streamWidth = oldProjectItem.streamWidth;
                    dataItemProject.streamHeight = oldProjectItem.streamHeight;
                    dataItemProject.usedEffectTempId = oldProjectItem.usedEffectTempId;
                    dataItemProject.todoCode = oldProjectItem.todoCode;
                    dataItemProject.editStatus = oldProjectItem.editStatus;
                    dataItemProject.iCameraCode = oldProjectItem.iCameraCode;
                    dataItemProject.iIsModified = oldProjectItem.iIsModified;
                    dataItemProject.nDurationLimit = oldProjectItem.nDurationLimit;
                    dataItemProject.entrance = oldProjectItem.entrance;
                    dataItemProject.videoTemplateInfo = oldProjectItem.videoTemplateInfo;
                    dataItemProject.prjThemeType = oldProjectItem.prjThemeType;
                    dataItemProject.strPrjTitle = oldProjectItem.strPrjTitle;
                    dataItemProject.strVideoDesc = oldProjectItem.strVideoDesc;
                    dataItemProject.strActivityData = oldProjectItem.strActivityData;
                    dataItemProject.strExtra = oldProjectItem.strExtra;
                    dataItemProject._id = C8404c.m24239c(dataItemProject);
                    PublishProjectInfo publishProjectInfo = new PublishProjectInfo();
                    publishProjectInfo.prjId = dataItemProject._id;
                    publishProjectInfo.iPrjGpsAccuracy = oldProjectItem.iPrjGpsAccuracy;
                    publishProjectInfo.dPrjLatitude = oldProjectItem.dPrjLatitude;
                    publishProjectInfo.dPrjLongitude = oldProjectItem.dPrjLongitude;
                    publishProjectInfo.strPrjAddress = oldProjectItem.strPrjAddress;
                    publishProjectInfo.strPrjAddressDetail = oldProjectItem.strPrjAddressDetail;
                    CommunityServiceProxy.updatePublishProjectInfo(publishProjectInfo);
                }
            }
        });
    }

    public void initVeSdkDB() {
        C8405a.aHD().mo33982cG(VivaBaseApplication.m8749FZ());
    }

    public boolean isHD2KSupport() {
        return C3742b.m9111II().mo23148JP() && C8549f.isHD2KSupport();
    }

    public boolean isHD4KSupport() {
        return C3742b.m9111II().mo23148JP() && C8549f.isHD4KSupport();
    }

    public boolean isHDExportBetaTest() {
        return C8549f.aJg();
    }

    public boolean isHigherHDExport() {
        return C8549f.aJg() && C8549f.aJc();
    }

    public boolean isPureHD2KSupport() {
        try {
            return C8549f.isHD2KSupport();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isPureHD4KSupport() {
        try {
            return C8549f.isHD4KSupport();
        } catch (Exception unused) {
            return false;
        }
    }

    public void libraryMgrSetContext(Context context) {
        C8553i.setContext(context);
    }

    public boolean loadLibraryBaseMode() {
        return C8553i.m25005ut(1);
    }

    public void removeCommonBehaviorParam() {
        C5553a.aeH();
    }

    public void savePrj(Context context, String str) {
        StoryboardOpService.savePrj(context, str);
    }

    public void scanGallery() {
        new C7212e(VivaBaseApplication.m8749FZ()).execute((Params[]) new Object[0]);
    }

    public void scanProject() {
        new C6405k(VivaBaseApplication.m8749FZ()).execute((Params[]) new Object[0]);
    }

    public void setProjectExtraInfo() {
        C8558m.egQ = true;
    }

    public void setTagInfo(String str) {
        C6933d.asD().setTagInfo(str);
    }

    public void setUserWaterMarkShowNickName(boolean z) {
        C5842b.m16339eS(z);
    }

    public void startAllInitService() {
        C5879b.m16420fc(VivaBaseApplication.m8749FZ());
        C5879b.m16421fd(VivaBaseApplication.m8749FZ());
        C5879b.m16422fe(VivaBaseApplication.m8749FZ());
    }

    public void startPrjScanService(Context context) {
        ProjectScanService.m19506fl(context);
    }

    public void updateCommonBehaviorParam(int i, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        C5553a.m15009b(sb.toString(), str, z);
    }

    public void updateQualityParams(int i, float f, float f2, float f3) {
        if (i < 0 || i > 100) {
            i = 70;
        }
        if (f <= 0.0f) {
            f = 1.0f;
        }
        if (f2 <= 0.0f) {
            f = 1.0f;
        }
        if (f3 <= 0.0f) {
            f = 1.0f;
        }
        C8522g.aJA().mo34732a(i, f, f2, f3);
    }

    public void upgradeMgrSetContext(Context context) {
        C8567u.setContext(context);
    }

    public boolean userWaterMarkShowNickName() {
        return C5842b.ahb();
    }
}
