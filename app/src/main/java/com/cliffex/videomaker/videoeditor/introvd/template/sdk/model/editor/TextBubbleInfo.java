package com.introvd.template.sdk.model.editor;

import android.graphics.RectF;
import java.io.Serializable;
import java.util.List;

public class TextBubbleInfo implements Serializable {
    public boolean bSupportAnim = false;
    public boolean isAnimOn = true;
    public int mBubbleSubtype = 0;
    public List<TextBubble> mTextBubbleList;
    public int mTextEditableState = 0;

    public static class TextBubble {
        public String mDftText = "";
        public int mDftTextColor = 0;
        public String mFontPath = "";
        public int mParamID;
        public ShadowInfo mShadowInfo = new ShadowInfo();
        public StrokeInfo mStrokeInfo = new StrokeInfo();
        public String mText = "Hello";
        public int mTextAlignment = 0;
        public int mTextColor = -1;
        public RectF mTextRegion;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TextBubble textBubble = (TextBubble) obj;
            if (this.mParamID == textBubble.mParamID && this.mTextColor == textBubble.mTextColor && this.mDftTextColor == textBubble.mDftTextColor && this.mTextAlignment == textBubble.mTextAlignment && this.mTextRegion.equals(textBubble.mTextRegion) && this.mText.equals(textBubble.mText) && this.mDftText.equals(textBubble.mDftText) && this.mFontPath.equals(textBubble.mFontPath) && this.mShadowInfo.equals(textBubble.mShadowInfo)) {
                return this.mStrokeInfo.equals(textBubble.mStrokeInfo);
            }
            return false;
        }

        public void reset() {
            this.mText = this.mDftText;
            this.mTextColor = this.mDftTextColor;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextBubbleInfo textBubbleInfo = (TextBubbleInfo) obj;
        if (this.mBubbleSubtype != textBubbleInfo.mBubbleSubtype || this.bSupportAnim != textBubbleInfo.bSupportAnim || this.isAnimOn != textBubbleInfo.isAnimOn || this.mTextEditableState != textBubbleInfo.mTextEditableState) {
            return false;
        }
        if (this.mTextBubbleList == null || textBubbleInfo.mTextBubbleList == null) {
            if (!(this.mTextBubbleList == null && textBubbleInfo.mTextBubbleList == null)) {
                z = false;
            }
            return z;
        }
        if (this.mTextBubbleList.size() != textBubbleInfo.mTextBubbleList.size()) {
            z = false;
        }
        return z;
    }

    public String getDftText() {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            return dftTextBubble.mDftText;
        }
        return null;
    }

    public TextBubble getDftTextBubble() {
        if (this.mTextBubbleList == null || this.mTextBubbleList.size() <= 0) {
            return null;
        }
        return (TextBubble) this.mTextBubbleList.get(0);
    }

    public String getFontPath() {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            return dftTextBubble.mFontPath;
        }
        return null;
    }

    public String getText() {
        TextBubble dftTextBubble = getDftTextBubble();
        return dftTextBubble != null ? dftTextBubble.mText : "";
    }

    public int getTextAlignment() {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            return dftTextBubble.mTextAlignment;
        }
        return 0;
    }

    public int getTextColor() {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            return dftTextBubble.mTextColor;
        }
        return -1;
    }

    public int getTextDftColor() {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            return dftTextBubble.mDftTextColor;
        }
        return -1;
    }

    public ShadowInfo getTextShadowInfo() {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            return dftTextBubble.mShadowInfo;
        }
        return null;
    }

    public StrokeInfo getTextStrokeInfo() {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            return dftTextBubble.mStrokeInfo;
        }
        return null;
    }

    public boolean isAnimOn() {
        return this.isAnimOn;
    }

    public boolean isSupportAnim() {
        return this.bSupportAnim;
    }

    public void reset() {
        if (this.mTextBubbleList != null) {
            for (TextBubble reset : this.mTextBubbleList) {
                reset.reset();
            }
        }
    }

    public void setAnimOn(boolean z) {
        this.isAnimOn = z;
    }

    public void setDftText(String str) {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            dftTextBubble.mDftText = str;
        }
    }

    public void setFontPath(String str) {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            dftTextBubble.mFontPath = str;
        }
    }

    public void setSupportAnim(boolean z) {
        this.bSupportAnim = z;
    }

    public void setText(String str) {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            dftTextBubble.mText = str;
        }
    }

    public void setTextColor(int i) {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            dftTextBubble.mTextColor = i;
        }
    }

    public void setTextShadowInfo(ShadowInfo shadowInfo) {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            dftTextBubble.mShadowInfo = shadowInfo;
        }
    }

    public void setTextStrokeInfo(StrokeInfo strokeInfo) {
        TextBubble dftTextBubble = getDftTextBubble();
        if (dftTextBubble != null) {
            dftTextBubble.mStrokeInfo = strokeInfo;
        }
    }
}
