package com.introvd.template.sdk.model.editor;

import com.introvd.template.sdk.model.VeRange;
import xiaoying.engine.clip.QClip;

public class PIPItemInfo {
    private QClip mClip;
    private int mItemIndex = -1;
    private int mSrcDuration;
    private VeRange mVeRange;

    public QClip getmClip() {
        return this.mClip;
    }

    public int getmItemIndex() {
        return this.mItemIndex;
    }

    public VeRange getmRange() {
        return this.mVeRange;
    }

    public int getmSrcDuration() {
        return this.mSrcDuration;
    }

    public void setmClip(QClip qClip) {
        this.mClip = qClip;
    }

    public void setmItemIndex(int i) {
        this.mItemIndex = i;
    }

    public void setmRange(VeRange veRange) {
        this.mVeRange = veRange;
    }

    public void setmSrcDuration(int i) {
        this.mSrcDuration = i;
    }
}
