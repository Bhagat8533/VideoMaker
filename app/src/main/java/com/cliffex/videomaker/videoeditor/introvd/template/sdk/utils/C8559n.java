package com.introvd.template.sdk.utils;

import android.text.TextUtils;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;

/* renamed from: com.introvd.template.sdk.utils.n */
public class C8559n {
    public static boolean egS = true;

    /* renamed from: a */
    private static long m25037a(boolean z, boolean z2, boolean z3, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("zh_")) {
            return (!z || !z2) ? z2 ? 5404319552844595216L : 5404319552844595201L : z3 ? 5404319552844595210L : 5404319552844595220L;
        }
        if (!z || !z2) {
            return z2 ? 5404319552844595216L : 5404319552844595202L;
        }
        return 5404319552844595211L;
    }

    /* renamed from: a */
    public static Long m25038a(VideoExportParamsModel videoExportParamsModel, String str) {
        long j = 0;
        if (egS) {
            if (videoExportParamsModel == null || !videoExportParamsModel.bShowWaterMark || videoExportParamsModel.mWaterMarkTemplateId.longValue() <= 0) {
                boolean z = true;
                boolean z2 = videoExportParamsModel != null && videoExportParamsModel.bShowNicknameInWaterMark && !TextUtils.isEmpty(videoExportParamsModel.auid);
                if (videoExportParamsModel == null || videoExportParamsModel.bShowWaterMark || z2) {
                    boolean z3 = videoExportParamsModel == null || videoExportParamsModel.bShowWaterMark;
                    if (videoExportParamsModel == null || !videoExportParamsModel.isExportLocal) {
                        z = false;
                    }
                    j = m25037a(z3, z2, z, str);
                }
            } else {
                j = videoExportParamsModel.mWaterMarkTemplateId.longValue();
            }
        }
        return Long.valueOf(j);
    }

    /* renamed from: bp */
    public static boolean m25039bp(long j) {
        return j == 5404319552844595210L || j == 5404319552844595216L || j == 5404319552844595220L || j == 5404319552844595211L;
    }
}
