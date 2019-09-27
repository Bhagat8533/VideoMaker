package com.introvd.template.sns;

public class SnsFriend {
    private String mAvatar = null;
    private String mNickName = null;
    private boolean mSelected = false;
    private String mUid = null;

    public SnsFriend(String str, String str2, String str3) {
        this.mUid = str;
        this.mNickName = str2;
        this.mAvatar = str3;
    }

    public String getmAvatar() {
        return this.mAvatar;
    }

    public String getmNickName() {
        return this.mNickName;
    }

    public String getmUid() {
        return this.mUid;
    }

    public boolean ismSelected() {
        return this.mSelected;
    }

    public void setmAvatar(String str) {
        this.mAvatar = str;
    }

    public void setmNickName(String str) {
        this.mNickName = str;
    }

    public void setmSelected(boolean z) {
        this.mSelected = z;
    }

    public void setmUid(String str) {
        this.mUid = str;
    }
}
