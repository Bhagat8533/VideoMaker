package com.introvd.template.editor.common.model;

import xiaoying.engine.base.QStyle.QEffectPropertyData;

public class ClipEditPanelStateModel {
    private boolean bAnimEnable = true;
    private boolean bAudioEnable = true;
    private boolean bPanZoomEnable = false;
    private boolean bReversed = false;
    private int groupId = -3;
    private boolean isImageClip = false;
    private QEffectPropertyData[] mClipParamDatas = null;

    public int getGroupId() {
        return this.groupId;
    }

    public QEffectPropertyData[] getmClipParamDatas() {
        return this.mClipParamDatas;
    }

    public boolean isImageClip() {
        return this.isImageClip;
    }

    public boolean isbAnimEnable() {
        return this.bAnimEnable;
    }

    public boolean isbAudioEnable() {
        return this.bAudioEnable;
    }

    public boolean isbPanZoomEnable() {
        return this.bPanZoomEnable;
    }

    public boolean isbReversed() {
        return this.bReversed;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public void setImageClip(boolean z) {
        this.isImageClip = z;
    }

    public void setbAnimEnable(boolean z) {
        this.bAnimEnable = z;
    }

    public void setbAudioEnable(boolean z) {
        this.bAudioEnable = z;
    }

    public void setbPanZoomEnable(boolean z) {
        this.bPanZoomEnable = z;
    }

    public void setbReversed(boolean z) {
        this.bReversed = z;
    }

    public void setmClipParamDatas(QEffectPropertyData[] qEffectPropertyDataArr) {
        this.mClipParamDatas = qEffectPropertyDataArr;
    }
}
