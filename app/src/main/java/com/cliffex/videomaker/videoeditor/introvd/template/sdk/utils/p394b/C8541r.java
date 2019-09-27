package com.introvd.template.sdk.utils.p394b;

import com.introvd.template.sdk.model.editor.VideoInfo;
import com.introvd.template.sdk.utils.VeMSize;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QUtils.QVideoImportFormat;
import xiaoying.engine.base.QVideoInfo;

/* renamed from: com.introvd.template.sdk.utils.b.r */
public class C8541r {
    /* renamed from: a */
    public static int m24978a(QVideoImportFormat qVideoImportFormat) {
        if (qVideoImportFormat != null) {
            return qVideoImportFormat.mVideoFormat;
        }
        return 2;
    }

    /* renamed from: e */
    public static VideoInfo m24979e(QEngine qEngine, String str) {
        QVideoInfo videoInfo = QUtils.getVideoInfo(qEngine, str);
        return videoInfo != null ? new VideoInfo(videoInfo.get(3), videoInfo.get(4), videoInfo.get(5)) : new VideoInfo();
    }

    /* renamed from: f */
    public static VeMSize m24980f(QEngine qEngine, String str) {
        VideoInfo e = m24979e(qEngine, str);
        return new VeMSize(e.frameWidth, e.frameHeight);
    }
}
