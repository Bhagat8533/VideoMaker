package com.introvd.template.sdk.model.editor;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.introvd.template.sdk.model.StylePositionModel;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;
import java.io.Serializable;

public class ScaleRotateViewState implements Serializable {
    private static final long serialVersionUID = 1441663473695516809L;
    public boolean bNeedTranslate = false;
    public int groupID = 0;
    public boolean isDftTemplate = false;
    public boolean isHorFlip = false;
    public boolean isVerFlip = false;
    public transient Rect mActRelativeRect = null;
    public float mAlpha = 1.0f;
    public transient Bitmap mBitmap = null;
    public float mDegree = 0.0f;
    public int mExampleThumbPos = 0;
    public float mFrameHeight = 0.0f;
    public float mFrameWidth = 0.0f;
    public int mLineNum = 1;
    public int mMinDuration = 0;
    public int mOutlineEllipse = 12;
    public int mOutlineStrokeColor = -34994;
    public int mPadding = 10;
    public StylePositionModel mPosInfo = new StylePositionModel();
    public float mStrokeWidth = 3.0f;
    public String mStylePath = "";
    public TextBubbleInfo mTextBubbleInfo = new TextBubbleInfo();
    public int mVersion = 0;
    public transient RectF mViewRect;
    public int maxCharCount = 10;

    public ScaleRotateViewState() {
    }

    public ScaleRotateViewState(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState != null) {
            this.mVersion = scaleRotateViewState.mVersion;
            this.groupID = scaleRotateViewState.groupID;
            this.bNeedTranslate = scaleRotateViewState.bNeedTranslate;
            this.mTextBubbleInfo = scaleRotateViewState.mTextBubbleInfo;
            this.mPadding = scaleRotateViewState.mPadding;
            this.mPosInfo = new StylePositionModel(scaleRotateViewState.mPosInfo.getmCenterPosX(), scaleRotateViewState.mPosInfo.getmCenterPosY(), scaleRotateViewState.mPosInfo.getmWidth(), scaleRotateViewState.mPosInfo.getmHeight());
            this.mDegree = scaleRotateViewState.mDegree;
            this.mStrokeWidth = scaleRotateViewState.mStrokeWidth;
            this.mOutlineEllipse = scaleRotateViewState.mOutlineEllipse;
            this.mOutlineStrokeColor = scaleRotateViewState.mOutlineStrokeColor;
            this.maxCharCount = scaleRotateViewState.maxCharCount;
            this.mFrameWidth = scaleRotateViewState.mFrameWidth;
            this.mFrameHeight = scaleRotateViewState.mFrameHeight;
            this.mExampleThumbPos = scaleRotateViewState.mExampleThumbPos;
            this.mMinDuration = scaleRotateViewState.mMinDuration;
            this.mViewRect = scaleRotateViewState.mViewRect;
            this.isDftTemplate = scaleRotateViewState.isDftTemplate;
            this.mLineNum = scaleRotateViewState.mLineNum;
            this.mStylePath = scaleRotateViewState.mStylePath;
            this.isHorFlip = scaleRotateViewState.isHorFlip;
            this.isVerFlip = scaleRotateViewState.isVerFlip;
            this.mActRelativeRect = scaleRotateViewState.mActRelativeRect;
            this.mAlpha = scaleRotateViewState.mAlpha;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaleRotateViewState)) {
            return false;
        }
        ScaleRotateViewState scaleRotateViewState = (ScaleRotateViewState) obj;
        if (this.mVersion != scaleRotateViewState.mVersion || this.groupID != scaleRotateViewState.groupID || this.bNeedTranslate != scaleRotateViewState.bNeedTranslate || Float.compare(scaleRotateViewState.mDegree, this.mDegree) != 0 || this.maxCharCount != scaleRotateViewState.maxCharCount || Float.compare(scaleRotateViewState.mFrameWidth, this.mFrameWidth) != 0 || Float.compare(scaleRotateViewState.mFrameHeight, this.mFrameHeight) != 0 || this.mMinDuration != scaleRotateViewState.mMinDuration || this.isDftTemplate != scaleRotateViewState.isDftTemplate || this.mLineNum != scaleRotateViewState.mLineNum || this.isHorFlip != scaleRotateViewState.isHorFlip || this.isVerFlip != scaleRotateViewState.isVerFlip || this.mAlpha != scaleRotateViewState.mAlpha) {
            return false;
        }
        if (this.mPosInfo == null ? scaleRotateViewState.mPosInfo != null : !this.mPosInfo.equals(scaleRotateViewState.mPosInfo)) {
            return false;
        }
        if (this.mStylePath == null ? scaleRotateViewState.mStylePath != null : !this.mStylePath.equals(scaleRotateViewState.mStylePath)) {
            return false;
        }
        if (this.mTextBubbleInfo == null ? scaleRotateViewState.mTextBubbleInfo != null : !this.mTextBubbleInfo.equals(scaleRotateViewState.mTextBubbleInfo)) {
            return false;
        }
        if (this.mActRelativeRect != null) {
            z = this.mActRelativeRect.equals(scaleRotateViewState.mActRelativeRect);
        } else if (scaleRotateViewState.mActRelativeRect != null) {
            z = false;
        }
        return z;
    }

    public RectF getRectArea() {
        if (this.mPosInfo != null) {
            return this.mPosInfo.getRectArea();
        }
        return null;
    }

    public ShadowInfo getShadowInfo() {
        if (this.mTextBubbleInfo != null) {
            return this.mTextBubbleInfo.getTextShadowInfo();
        }
        return null;
    }

    public StrokeInfo getStrokeInfo() {
        if (this.mTextBubbleInfo != null) {
            return this.mTextBubbleInfo.getTextStrokeInfo();
        }
        return null;
    }

    public int getTextAlignment() {
        if (this.mTextBubbleInfo != null) {
            return this.mTextBubbleInfo.getTextAlignment();
        }
        return 0;
    }

    public TextBubble getTextBubble() {
        if (this.mTextBubbleInfo != null) {
            return this.mTextBubbleInfo.getDftTextBubble();
        }
        return null;
    }

    public String getTextBubbleDftText() {
        return this.mTextBubbleInfo != null ? this.mTextBubbleInfo.getDftText() : "";
    }

    public String getTextBubbleText() {
        return this.mTextBubbleInfo != null ? this.mTextBubbleInfo.getText() : "";
    }

    public int getTextColor() {
        if (this.mTextBubbleInfo != null) {
            return this.mTextBubbleInfo.getTextColor();
        }
        return -1;
    }

    public int getTextDftColor() {
        if (this.mTextBubbleInfo != null) {
            return this.mTextBubbleInfo.getTextDftColor();
        }
        return -1;
    }

    public String getTextFontPath() {
        return this.mTextBubbleInfo != null ? this.mTextBubbleInfo.getFontPath() : "";
    }

    public boolean isAnimOn() {
        if (this.mTextBubbleInfo != null) {
            return this.mTextBubbleInfo.isAnimOn();
        }
        return false;
    }

    public boolean isSupportAnim() {
        if (this.mTextBubbleInfo != null) {
            return this.mTextBubbleInfo.isSupportAnim();
        }
        return false;
    }

    public void setAnimOn(boolean z) {
        if (this.mTextBubbleInfo != null) {
            this.mTextBubbleInfo.setAnimOn(z);
        }
    }

    public void setFontPath(String str) {
        if (this.mTextBubbleInfo != null) {
            this.mTextBubbleInfo.setFontPath(str);
        }
    }

    public void setHorFlip(boolean z) {
        this.isHorFlip = z;
    }

    public void setShadowInfo(ShadowInfo shadowInfo) {
        if (this.mTextBubbleInfo != null) {
            this.mTextBubbleInfo.setTextShadowInfo(shadowInfo);
        }
    }

    public void setStrokeInfo(StrokeInfo strokeInfo) {
        if (this.mTextBubbleInfo != null) {
            this.mTextBubbleInfo.setTextStrokeInfo(strokeInfo);
        }
    }

    public void setSupportAnim(boolean z) {
        if (this.mTextBubbleInfo != null) {
            this.mTextBubbleInfo.setSupportAnim(z);
        }
    }

    public void setTextBubbleDftText(String str) {
        if (this.mTextBubbleInfo != null) {
            this.mTextBubbleInfo.setDftText(str);
        }
    }

    public void setTextBubbleText(String str) {
        if (this.mTextBubbleInfo != null) {
            this.mTextBubbleInfo.setText(str);
        }
    }

    public void setTextColor(int i) {
        if (this.mTextBubbleInfo != null) {
            this.mTextBubbleInfo.setTextColor(i);
        }
    }

    public void setVerFlip(boolean z) {
        this.isVerFlip = z;
    }
}
