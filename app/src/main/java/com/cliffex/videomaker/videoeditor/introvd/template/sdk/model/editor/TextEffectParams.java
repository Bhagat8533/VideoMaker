package com.introvd.template.sdk.model.editor;

import android.graphics.Rect;
import android.graphics.RectF;
import xiaoying.engine.base.QRange;
import xiaoying.engine.clip.QEffect;

public class TextEffectParams {
    public boolean bShowStaticPicture = false;
    private boolean isAnimOn = false;
    private boolean isApplyInWholeClip = false;
    private boolean isHorFlip = false;
    private boolean isVerFlip = false;
    private float mAlpha = 1.0f;
    private float mAngle;
    private String mEffectStylePath;
    private String mFontPath = "";
    public float mLayerID = 0.0f;
    private Rect mResultRect;
    private ShadowInfo mShadowInfo;
    private StrokeInfo mStrokeInfo;
    private int mStyleDuration = 0;
    private long mTemplateId;
    private int mTextAlignment = 0;
    private int mTextRangeLen;
    private int mTextRangeStart;
    private RectF mTextRect;
    private int mTxtColor;
    private String mTxtContent;
    private int mVersion;
    private int nClipIndex = 0;

    public int getClipIndex() {
        return this.nClipIndex;
    }

    public void getEffectRange(QEffect qEffect) {
        QRange qRange = (QRange) qEffect.getProperty(4098);
        if (qRange != null) {
            int i = qRange.get(0);
            int i2 = qRange.get(1);
            setmTextRangeStart(i);
            setmTextRangeLen(i2);
        }
    }

    public int getVersion() {
        return this.mVersion;
    }

    public float getmAlpha() {
        return this.mAlpha;
    }

    public float getmAngle() {
        return this.mAngle;
    }

    public String getmEffectStylePath() {
        return this.mEffectStylePath;
    }

    public String getmFontPath() {
        return this.mFontPath;
    }

    public Rect getmResultRect() {
        return this.mResultRect;
    }

    public ShadowInfo getmShadowInfo() {
        return this.mShadowInfo;
    }

    public StrokeInfo getmStrokeInfo() {
        return this.mStrokeInfo;
    }

    public int getmStyleDuration() {
        return this.mStyleDuration;
    }

    public long getmTemplateId() {
        return this.mTemplateId;
    }

    public int getmTextAlignment() {
        return this.mTextAlignment;
    }

    public int getmTextRangeLen() {
        return this.mTextRangeLen;
    }

    public int getmTextRangeStart() {
        return this.mTextRangeStart;
    }

    public RectF getmTextRect() {
        return this.mTextRect;
    }

    public int getmTxtColor() {
        return this.mTxtColor;
    }

    public String getmTxtContent() {
        return this.mTxtContent;
    }

    public boolean isAnimOn() {
        return this.isAnimOn;
    }

    public boolean isApplyInWholeClip() {
        return this.isApplyInWholeClip;
    }

    public boolean isHorFlip() {
        return this.isHorFlip;
    }

    public boolean isVerFlip() {
        return this.isVerFlip;
    }

    public void setAnimOn(boolean z) {
        this.isAnimOn = z;
    }

    public void setApplyInWholeClip(boolean z) {
        this.isApplyInWholeClip = z;
    }

    public void setClipIndex(int i) {
        this.nClipIndex = i;
    }

    public void setHorFlip(boolean z) {
        this.isHorFlip = z;
    }

    public void setVerFlip(boolean z) {
        this.isVerFlip = z;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public void setmAlpha(float f) {
        this.mAlpha = f;
    }

    public void setmAngle(float f) {
        this.mAngle = f;
    }

    public void setmEffectStylePath(String str) {
        this.mEffectStylePath = str;
    }

    public void setmFontPath(String str) {
        this.mFontPath = str;
    }

    public void setmResultRect(Rect rect) {
        this.mResultRect = rect;
    }

    public void setmShadowInfo(ShadowInfo shadowInfo) {
        this.mShadowInfo = shadowInfo;
    }

    public void setmStrokeInfo(StrokeInfo strokeInfo) {
        this.mStrokeInfo = strokeInfo;
    }

    public void setmStyleDuration(int i) {
        this.mStyleDuration = i;
    }

    public void setmTemplateId(long j) {
        this.mTemplateId = j;
    }

    public void setmTextAlignment(int i) {
        this.mTextAlignment = i;
    }

    public void setmTextRangeLen(int i) {
        this.mTextRangeLen = i;
    }

    public void setmTextRangeStart(int i) {
        this.mTextRangeStart = i;
    }

    public void setmTextRect(RectF rectF) {
        this.mTextRect = rectF;
    }

    public void setmTxtColor(int i) {
        this.mTxtColor = i;
    }

    public void setmTxtContent(String str) {
        this.mTxtContent = str;
    }
}
