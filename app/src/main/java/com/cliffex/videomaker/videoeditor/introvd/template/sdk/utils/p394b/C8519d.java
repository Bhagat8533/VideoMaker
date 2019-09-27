package com.introvd.template.sdk.utils.p394b;

import android.graphics.RectF;
import com.introvd.template.sdk.model.VeRange;
import java.util.Arrays;
import xiaoying.engine.clip.QClip.QCamExportedEffectData;

/* renamed from: com.introvd.template.sdk.utils.b.d */
public class C8519d {
    public QCamExportedEffectData[] camExportEffectDataArray;
    private RectF cropRect = null;
    private int edS = 0;
    private boolean edU = false;
    private boolean edV = false;
    private int ehJ = -1;
    private int ehK = -1;
    private boolean ehL = false;
    public String ehM = "";
    private String mClipReverseFilePath = "";
    public String mEffectPath = "";
    public VeRange mTrimVeRange = null;

    public C8519d(int i, int i2) {
        this.ehJ = i;
        this.ehK = i2;
    }

    public int aHX() {
        return this.edS;
    }

    public RectF aJw() {
        return this.cropRect;
    }

    public int aJx() {
        return this.ehJ;
    }

    public int aJy() {
        return this.ehK;
    }

    public boolean aJz() {
        return this.ehL;
    }

    public String getmClipReverseFilePath() {
        return this.mClipReverseFilePath;
    }

    public boolean isClipReverse() {
        return this.edV;
    }

    public boolean isbIsReverseMode() {
        return this.edU;
    }

    /* renamed from: ju */
    public void mo34707ju(boolean z) {
        this.ehL = z;
    }

    /* renamed from: l */
    public void mo34708l(RectF rectF) {
        this.cropRect = rectF;
    }

    public void setIsClipReverse(boolean z) {
        this.edV = z;
    }

    public void setbIsReverseMode(boolean z) {
        this.edU = z;
    }

    public void setmClipReverseFilePath(String str) {
        this.mClipReverseFilePath = str;
    }

    /* renamed from: tV */
    public void mo34712tV(int i) {
        this.edS = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClipParamsData{mStartPos=");
        sb.append(this.ehJ);
        sb.append(", mEndPos=");
        sb.append(this.ehK);
        sb.append(", mTrimVeRange=");
        sb.append(this.mTrimVeRange);
        sb.append(", mRotate=");
        sb.append(this.edS);
        sb.append(", bCrop=");
        sb.append(this.ehL);
        sb.append(", cropRect=");
        sb.append(this.cropRect);
        sb.append(", mEffectPath='");
        sb.append(this.mEffectPath);
        sb.append('\'');
        sb.append(", digitalWMarkCode='");
        sb.append(this.ehM);
        sb.append('\'');
        sb.append(", camExportEffectDataArray=");
        sb.append(Arrays.toString(this.camExportEffectDataArray));
        sb.append(", mClipReverseFilePath='");
        sb.append(this.mClipReverseFilePath);
        sb.append('\'');
        sb.append(", bIsReverseMode=");
        sb.append(this.edU);
        sb.append(", isClipReverse=");
        sb.append(this.edV);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: ux */
    public void mo34714ux(int i) {
        this.ehJ = i;
    }

    /* renamed from: uy */
    public void mo34715uy(int i) {
        this.ehK = i;
    }
}
