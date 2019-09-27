package com.introvd.template.app.p199v5.common.p200ui.videolist;

import android.content.Context;
import com.introvd.template.R;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo.VideoInfo;
import java.math.BigDecimal;

/* renamed from: com.introvd.template.app.v5.common.ui.videolist.b */
public class C4436b {
    public String bGb;
    public String bGc;
    public int bGd;
    public int bGe;
    public int bGf;
    public String bGg;
    public int bGh;
    public String strCoverURL;
    public String strPublishtime;
    public String strPuid;
    public String strPver;
    public String strTitle;

    /* renamed from: M */
    public static String m11214M(Context context, int i) {
        String str = "";
        if (context == null) {
            return str;
        }
        if (AppStateModel.getInstance().isInChina()) {
            if (i < 10000) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("");
                return sb.toString();
            }
            return context.getString(R.string.xiaoying_str_com_count_w_f, new Object[]{Float.valueOf(((float) i) / 10000.0f)});
        } else if (i < 1000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append("");
            return sb2.toString();
        } else if (i < 1000000) {
            BigDecimal bigDecimal = new BigDecimal((double) (((float) i) / 1000.0f));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(bigDecimal.setScale(1, 4));
            sb3.append("K");
            return sb3.toString();
        } else {
            BigDecimal bigDecimal2 = new BigDecimal((double) (((float) i) / 1000000.0f));
            StringBuilder sb4 = new StringBuilder();
            sb4.append(bigDecimal2.setScale(1, 4));
            sb4.append("M");
            return sb4.toString();
        }
    }

    /* renamed from: g */
    public static C4436b m11215g(ModeItemInfo modeItemInfo) {
        if (modeItemInfo == null || modeItemInfo.mVideoInfo == null) {
            return null;
        }
        C4436b bVar = new C4436b();
        bVar.strTitle = modeItemInfo.title;
        VideoInfo videoInfo = modeItemInfo.mVideoInfo;
        if (videoInfo != null) {
            bVar.strPuid = videoInfo.puid;
            bVar.strPver = String.valueOf(videoInfo.mVer);
        }
        bVar.bGb = modeItemInfo.mVideoInfo.mCoverUrl;
        bVar.strCoverURL = modeItemInfo.mVideoInfo.mCoverUrl;
        bVar.bGc = modeItemInfo.mVideoInfo.mFileUrl;
        bVar.bGd = modeItemInfo.mVideoInfo.mWidth;
        bVar.bGe = modeItemInfo.mVideoInfo.mHeight;
        bVar.strPublishtime = modeItemInfo.mVideoInfo.mStrPubTime;
        bVar.bGf = (int) modeItemInfo.getViewCount();
        bVar.bGg = modeItemInfo.description;
        return bVar;
    }
}
