package com.introvd.template.router.editor.export;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.p021v4.app.FragmentActivity;
import android.widget.ImageView;
import com.aiii.android.arouter.facade.template.C1949c;
import java.util.List;

public interface IExportService extends C1949c {
    boolean beginExportVideo(FragmentActivity fragmentActivity, boolean z, boolean z2, String str, boolean z3);

    boolean checkDurationOverLimit(FragmentActivity fragmentActivity, boolean z);

    void clickChangeCover(FragmentActivity fragmentActivity, boolean z);

    String getApplyThemeHexId(FragmentActivity fragmentActivity);

    String getApplyThemeName(FragmentActivity fragmentActivity);

    String getApplyThemeSubId(FragmentActivity fragmentActivity, String str);

    String getExportFileName(int i);

    ExportPrjInfo getExportPrjInfo(FragmentActivity fragmentActivity);

    String getPrjCoverPath(FragmentActivity fragmentActivity);

    String getPrjEntrance(Context context, long j);

    String getPrjExportUrl(FragmentActivity fragmentActivity);

    String getPrjThumbnailPath(FragmentActivity fragmentActivity);

    List<Integer> getProjectVIPList(FragmentActivity fragmentActivity);

    PublishDetailInfo getPublishDetailInfo(FragmentActivity fragmentActivity);

    String getSubtitleEffectText(FragmentActivity fragmentActivity);

    String getVideoCoverTitle(String str);

    ExportVideoInfo getVideoInfoByExpType(FragmentActivity fragmentActivity);

    void handleBackClickJump(FragmentActivity fragmentActivity, int i, long j);

    void handleExport(FragmentActivity fragmentActivity, boolean z, String str, boolean z2);

    void handleExportClick(FragmentActivity fragmentActivity, boolean z, boolean z2, String str, boolean z3);

    void handleExportVideoActivityResult(FragmentActivity fragmentActivity, int i, int i2, Intent intent);

    boolean hasVIP(FragmentActivity fragmentActivity, int i);

    boolean isExportSpaceEnough(FragmentActivity fragmentActivity, String str);

    boolean isFunnyVideo(FragmentActivity fragmentActivity);

    boolean isStoryVideo(FragmentActivity fragmentActivity);

    String lauchPickCoverActivity(Activity activity, String str, String str2, String str3);

    void loadCover(FragmentActivity fragmentActivity, int i, int i2, ImageView imageView);

    boolean registerExportVideoListener(FragmentActivity fragmentActivity, long j, long j2, boolean z);

    boolean showExportChoose(FragmentActivity fragmentActivity, boolean z, boolean z2, String str, boolean z3, IExportTpyeChoose iExportTpyeChoose);

    void updatePublishDetailInfo(FragmentActivity fragmentActivity, PublishDetailInfo publishDetailInfo);
}
