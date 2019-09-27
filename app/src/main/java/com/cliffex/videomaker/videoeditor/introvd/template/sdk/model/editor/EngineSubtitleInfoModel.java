package com.introvd.template.sdk.model.editor;

import com.introvd.template.sdk.model.VeRange;
import java.io.Serializable;

public class EngineSubtitleInfoModel implements Serializable {
    public int groupId = 0;
    public int mClipIndex = 0;
    public int mClipStartPos = 0;
    public int mGroupType = 0;
    public int mIndex = 0;
    public String mTemplatePath = "";
    public String mText = "";
    public VeRange mTimeVeRange = null;
    public ScaleRotateViewState textState = null;

    public int getEffectLen() {
        if (this.mTimeVeRange == null) {
            return 0;
        }
        return this.mTimeVeRange.getmTimeLength();
    }

    public int getPreviewTime() {
        return this.mTimeVeRange != null ? this.mClipStartPos + this.mTimeVeRange.getmPosition() + 1 : this.mClipStartPos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.mTimeVeRange != null ? this.mTimeVeRange.getmPosition() : 0;
        sb.append("EngineSubtitleInfoModel mTimePos=");
        sb.append(i);
        sb.append(";mIndex=");
        sb.append(this.mIndex);
        sb.append(";mGroupType=");
        sb.append(this.mGroupType);
        sb.append(";mText=");
        sb.append(this.mText);
        sb.append("\r\nmTemplatePath=");
        sb.append(this.mTemplatePath);
        return super.toString();
    }
}
