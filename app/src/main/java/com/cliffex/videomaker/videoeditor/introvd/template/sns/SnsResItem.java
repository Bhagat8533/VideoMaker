package com.introvd.template.sns;

public class SnsResItem {
    public int mIconCircleResId;
    public int mIconResId;
    public int mIconSmallResId;
    public boolean mShare;
    public int mSnsType;
    public int mTitleResId;
    public String mTitleResStr;
    public String strDes;

    public SnsResItem(int i, int i2, int i3, int i4) {
        this.mSnsType = i;
        this.mIconResId = i2;
        this.mIconSmallResId = i3;
        this.mTitleResId = i4;
    }

    public SnsResItem(int i, int i2, int i3, String str) {
        this.mSnsType = i;
        this.mIconResId = i2;
        this.mIconSmallResId = i3;
        this.mTitleResStr = str;
    }
}
