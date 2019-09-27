package com.introvd.template.sdk.editor.p389c;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8550g;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8569v;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8529h;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.editor.c.d */
public class C8438d {
    /* renamed from: a */
    public static int m24388a(Context context, String str, QStoryboard qStoryboard, C8435a aVar) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            i = C8548e.m24998oc(str.substring(0, str.lastIndexOf(47) + 1));
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i != 0) {
            return i;
        }
        C8437c cVar = new C8437c(str, aVar, C8550g.getHandlerThreadFromCommon().getLooper());
        C8529h hVar = new C8529h();
        int a = hVar.mo34784a(context, cVar, qStoryboard);
        if (a != 0) {
            return a;
        }
        int nQ = hVar.mo34786nQ(str);
        return nQ != 0 ? nQ : nQ;
    }

    /* renamed from: a */
    public static long m24389a(QEngine qEngine, int i, int i2, int i3, int i4, int i5) {
        return (long) QUtils.caculateVideoBitrate(qEngine, i3, i, i4, i5, m24394uh(i2), i2, aIF());
    }

    /* renamed from: a */
    private static VeMSize m24390a(VeMSize veMSize, int i, int i2) {
        VeMSize b = C8572y.m25078b(veMSize, new VeMSize(i, i));
        int i3 = i2 + 8;
        if (b.height < i3 && b.height > i2) {
            b.height = i2;
        }
        if (b.width < i3 && b.width > i2) {
            b.width = i2;
        }
        return (b.width > i2 || b.height > i2) ? C8569v.m25057a(veMSize, new VeMSize(i2, i2)) : b;
    }

    /* renamed from: a */
    public static void m24391a(QEngine qEngine, String str, Handler handler) {
        QStoryboard qStoryboard = new QStoryboard();
        if (qStoryboard.init(qEngine, null) == 0 && handler != null) {
            C8436b bVar = new C8436b(qStoryboard, handler);
            C8529h hVar = new C8529h();
            hVar.mo34784a(null, bVar, qStoryboard);
            if (!C8548e.isFileExisted(str)) {
                C8554j.m25007e("ProjectUtil", ">>>>>>>>>>>>>>loadStoryBoard MSG_PROJECT_LOAD_FAILED 2");
                handler.sendEmptyMessage(268443650);
            } else if (hVar.mo34785nP(str) != 0) {
                C8554j.m25007e("ProjectUtil", ">>>>>>>>>>>>>>loadStoryBoard MSG_PROJECT_LOAD_FAILED 1");
                handler.sendEmptyMessage(268443650);
            }
        }
    }

    public static int aIF() {
        return 3;
    }

    /* renamed from: b */
    public static long m24392b(QStoryboard qStoryboard, VideoExportParamsModel videoExportParamsModel) {
        int i;
        int i2;
        int i3;
        int i4 = videoExportParamsModel.isGifExp() ? 10 : 4;
        VeMSize b = m24393b(videoExportParamsModel);
        int i5 = 0;
        if (b != null) {
            i5 = b.width;
            i = b.height;
        } else {
            i = 0;
        }
        if (i5 == 0 && i == 0) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                QVideoInfo qVideoInfo = (QVideoInfo) dataClip.getProperty(12291);
                if (qVideoInfo != null) {
                    i3 = qVideoInfo.get(3);
                    i2 = qVideoInfo.get(4);
                    int y = C8572y.m25105y(qStoryboard);
                    if (videoExportParamsModel.isGifExp() && videoExportParamsModel.gifParam != null) {
                        y = videoExportParamsModel.gifParam.expFps;
                    }
                    return ((m24389a(C8501a.aJs().aJv(), y, videoExportParamsModel.encodeType, i4, i3, i2) + 128000) * ((long) qStoryboard.getDuration())) / 8000;
                }
            }
        }
        i2 = i;
        i3 = i5;
        int y2 = C8572y.m25105y(qStoryboard);
        y2 = videoExportParamsModel.gifParam.expFps;
        return ((m24389a(C8501a.aJs().aJv(), y2, videoExportParamsModel.encodeType, i4, i3, i2) + 128000) * ((long) qStoryboard.getDuration())) / 8000;
    }

    /* renamed from: b */
    public static VeMSize m24393b(VideoExportParamsModel videoExportParamsModel) {
        VeMSize veMSize = videoExportParamsModel.mStreamSizeVe;
        if (veMSize == null) {
            return null;
        }
        if (veMSize.width == 368 && veMSize.height == 640) {
            veMSize.width = 360;
            veMSize.height = QUtils.VIDEO_RES_VGA_WIDTH;
        } else if (veMSize.height == 368 && veMSize.width == 640) {
            veMSize.width = QUtils.VIDEO_RES_VGA_WIDTH;
            veMSize.height = 360;
        }
        if (videoExportParamsModel.expType.intValue() == 1) {
            veMSize = m24390a(veMSize, (int) QUtils.VIDEO_RES_720P_HEIGHT, (int) QUtils.VIDEO_RES_720P_WIDTH);
        } else if (videoExportParamsModel.expType.intValue() == 2) {
            veMSize = m24390a(veMSize, (int) QUtils.VIDEO_RES_1080P_HEIGHT, (int) QUtils.VIDEO_RES_1080P_WIDTH);
        } else if (videoExportParamsModel.expType.intValue() == 4) {
            veMSize = m24390a(veMSize, (int) QUtils.VIDEO_RES_2K_HEIGHT, (int) QUtils.VIDEO_RES_2K_WIDTH);
        } else if (videoExportParamsModel.expType.intValue() == 5) {
            veMSize = m24390a(veMSize, (int) QUtils.VIDEO_RES_4K_HEIGHT, (int) QUtils.VIDEO_RES_4K_WIDTH);
        } else if (videoExportParamsModel.isGifExp() && videoExportParamsModel.gifParam != null) {
            veMSize = C8572y.m25078b(veMSize, videoExportParamsModel.gifParam.expSize);
        }
        C8572y.m25094g(veMSize);
        return veMSize;
    }

    /* renamed from: uh */
    private static int m24394uh(int i) {
        return i == 512 ? 1 : 2;
    }
}
