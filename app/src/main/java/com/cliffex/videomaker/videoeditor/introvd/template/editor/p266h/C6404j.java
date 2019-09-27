package com.introvd.template.editor.p266h;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.introvd.template.sdk.model.GifExpModel;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.utils.C8572y;

/* renamed from: com.introvd.template.editor.h.j */
public class C6404j {
    /* renamed from: a */
    public static VideoExportParamsModel m18433a(Context context, String str, boolean z, int i, GifExpModel gifExpModel, boolean z2) {
        VideoExportParamsModel videoExportParamsModel = new VideoExportParamsModel();
        videoExportParamsModel.assignedPath = "";
        videoExportParamsModel.isMvPrj = z;
        boolean z3 = true;
        videoExportParamsModel.bHDExport = i == 1 || 2 == i || 4 == i || 5 == i;
        videoExportParamsModel.bShowWaterMark = !C8072q.aBx().mo33072ku(C7825a.WATER_MARK.getId());
        UtilsPrefs with = UtilsPrefs.with(context, EditorRouter.VIVA_EDITOR_PREF_FILENAME, true);
        if (with.readBoolean(EditorRouter.KEY_FORCE_SHOW_LOGO_WATERMARK, false)) {
            videoExportParamsModel.bShowWaterMark = true;
        }
        videoExportParamsModel.expType = Integer.valueOf(0);
        if (gifExpModel != null) {
            videoExportParamsModel.expType = Integer.valueOf(3);
            videoExportParamsModel.gifParam = gifExpModel;
            videoExportParamsModel.bNeedUpdatePathToPrj = false;
        } else {
            videoExportParamsModel.expType = Integer.valueOf(i);
        }
        videoExportParamsModel.decodeType = C8572y.aJl();
        videoExportParamsModel.encodeType = C8572y.aJm();
        videoExportParamsModel.isSingleHW = C5842b.ahg();
        if (UserServiceProxy.isLogin()) {
            String userId = UserServiceProxy.getUserId();
            if (!TextUtils.isEmpty(userId)) {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo != null) {
                    videoExportParamsModel.username = userInfo.nickname;
                }
                videoExportParamsModel.auid = userId;
            }
        }
        boolean isInChina = AppStateModel.getInstance().isInChina();
        boolean ku = C8072q.aBx().mo33072ku(C7825a.WATER_MARK.getId());
        if ((!isInChina || ku || z2) && !asZ()) {
            z3 = false;
        }
        videoExportParamsModel.bShowNicknameInWaterMark = z3;
        videoExportParamsModel.duid = C4580b.m11653dz(context);
        videoExportParamsModel.mStreamSizeVe = C8404c.m24244nD(str);
        videoExportParamsModel.bTransitionStatic = with.readBoolean(EditorRouter.VIVA_EDITOR_PREF_KEY_TRANSITION_STATIC, false);
        videoExportParamsModel.isExportLocal = z2;
        return videoExportParamsModel;
    }

    private static boolean asZ() {
        return AppStateModel.getInstance().isCommunitySupport() && C5842b.ahb();
    }
}
