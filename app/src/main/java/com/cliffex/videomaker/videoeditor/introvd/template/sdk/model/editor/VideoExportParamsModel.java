package com.introvd.template.sdk.model.editor;

import android.graphics.Rect;
import com.introvd.template.sdk.model.GifExpModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.VeMSize;

public class VideoExportParamsModel {
    public static final int VIDEO_EXP_TYPE_1080P = 2;
    public static final int VIDEO_EXP_TYPE_720P = 1;
    public static final int VIDEO_EXP_TYPE_AUDIO = 6;
    public static final int VIDEO_EXP_TYPE_GIF = 3;
    public static final int VIDEO_EXP_TYPE_NORMAL = 0;
    public static final int VIDEO_EXP_TYPE_QHD = 4;
    public static final int VIDEO_EXP_TYPE_UHD = 5;
    public String assignedPath;
    public String auid = "";
    public boolean bHDExport;
    public boolean bNeedUpdatePathToPrj = true;
    public boolean bShowNicknameInWaterMark = true;
    public boolean bShowWaterMark = true;
    public boolean bTransitionStatic = false;
    public int decodeType = 2;
    public String duid = "";
    public int encodeType = 512;
    public Integer expType = Integer.valueOf(0);
    public GifExpModel gifParam;
    public boolean isBlack;
    public boolean isExportLocal = false;
    public boolean isForceSWExp = false;
    public boolean isMvPrj = true;
    public boolean isSingleHW = false;
    public boolean isSlidePrj;
    public Rect mCropRegion = null;
    public VeRange mExportVeRange;
    public String mPrjPath;
    public VeMSize mStreamSizeVe;
    public Long mWaterMarkTemplateId = Long.valueOf(0);
    public String username = "";
    public float videoBitrateScales = 1.0f;

    public boolean is2k4kExp() {
        return this.expType.intValue() == 4 || this.expType.intValue() == 5;
    }

    public boolean isAudioExp() {
        return this.expType.intValue() == 6;
    }

    public boolean isGifExp() {
        return this.expType.intValue() == 3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoExportParamsModel{assignedPath='");
        sb.append(this.assignedPath);
        sb.append('\'');
        sb.append(", mPrjPath='");
        sb.append(this.mPrjPath);
        sb.append('\'');
        sb.append(", bHDExport=");
        sb.append(this.bHDExport);
        sb.append(", mStreamSizeVe=");
        sb.append(this.mStreamSizeVe);
        sb.append(", isBlack=");
        sb.append(this.isBlack);
        sb.append(", isMvPrj=");
        sb.append(this.isMvPrj);
        sb.append(", mExportVeRange=");
        sb.append(this.mExportVeRange);
        sb.append(", bNeedUpdatePathToPrj=");
        sb.append(this.bNeedUpdatePathToPrj);
        sb.append(", mCropRegion=");
        sb.append(this.mCropRegion);
        sb.append(", bShowWaterMark=");
        sb.append(this.bShowWaterMark);
        sb.append(", mWaterMarkTemplateId=");
        sb.append(this.mWaterMarkTemplateId);
        sb.append(", username='");
        sb.append(this.username);
        sb.append('\'');
        sb.append(", auid='");
        sb.append(this.auid);
        sb.append('\'');
        sb.append(", duid='");
        sb.append(this.duid);
        sb.append('\'');
        sb.append(", bShowNicknameInWaterMark=");
        sb.append(this.bShowNicknameInWaterMark);
        sb.append(", expType=");
        sb.append(this.expType);
        sb.append(", isSingleHW=");
        sb.append(this.isSingleHW);
        sb.append(", gifParam=");
        sb.append(this.gifParam);
        sb.append(", decodeType=");
        sb.append(this.decodeType);
        sb.append(", encodeType=");
        sb.append(this.encodeType);
        sb.append(", isSlidePrj=");
        sb.append(this.isSlidePrj);
        sb.append('}');
        return sb.toString();
    }
}
