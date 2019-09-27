package com.introvd.template.router.editor;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.todoCode.TODOParamModel;
import java.util.List;
import java.util.Map;
import p037b.p050b.C1834l;

public interface IEditorService extends C1949c {
    public static final String RESULT_ACTION_THEME_APPLY_FAIL = "action_theme_apply_fail";
    public static final String RESULT_ACTION_THEME_APPLY_SUC = "action_theme_apply_suc";

    int GetHWDecoderVersion();

    int GetHWEncoderVersion();

    void applyTheme(Context context, String str, String str2);

    void clearProject(int i, boolean z);

    void createProjectAndPreview(Activity activity, String str, boolean z);

    void enterPreview(Activity activity, String str, boolean z, String str2);

    String[] getCommonBehaviorParam();

    Map<String, String> getCurProjectMaterialInfo(Context context, int i);

    int getDraftLayoutHeight(Context context);

    C1834l<List<String>> getDraftThumbnailList(Context context);

    int getEngineVersion();

    String getExportedFilePath();

    String getGoogleKey();

    String getGpuType();

    int getStudioDraftCount(Context context);

    View getStudioItemView(Context context);

    String getTagInfoByActivityId(String str);

    void handleJoinEvent(Activity activity, String str, String str2, String str3, String str4);

    void handleJoinEventInfo(Activity activity, TODOParamModel tODOParamModel, int i, String str);

    void initProjectUpdateHandle();

    void initVeSdkDB();

    boolean isHD2KSupport();

    boolean isHD4KSupport();

    boolean isHDExportBetaTest();

    boolean isHigherHDExport();

    boolean isPureHD2KSupport();

    boolean isPureHD4KSupport();

    void libraryMgrSetContext(Context context);

    boolean loadLibraryBaseMode();

    void removeCommonBehaviorParam();

    void savePrj(Context context, String str);

    void scanGallery();

    void scanProject();

    void setProjectExtraInfo();

    void setTagInfo(String str);

    void setUserWaterMarkShowNickName(boolean z);

    void startAllInitService();

    void startPrjScanService(Context context);

    void updateCommonBehaviorParam(int i, String str, boolean z);

    void updateQualityParams(int i, float f, float f2, float f3);

    void upgradeMgrSetContext(Context context);

    boolean userWaterMarkShowNickName();
}
