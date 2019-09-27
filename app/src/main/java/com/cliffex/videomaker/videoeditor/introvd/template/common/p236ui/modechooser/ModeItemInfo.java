package com.introvd.template.common.p236ui.modechooser;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.introvd.template.common.ui.modechooser.ModeItemInfo */
public class ModeItemInfo {
    public int adCount;
    public ArrayList<AdItemInfo> adItemInfoList;
    public String bgEndColor;
    public String bgStartColor;
    private int chW = 1;
    public String description = "";
    public long expirationMillis;
    public boolean isInVideoList = false;
    public boolean isNew;
    public boolean isVideoListEnd = true;
    public boolean isVideoListStart = false;
    public int itemId;
    public Object itemImgBackupRes;
    public String itemImgUrl;
    public String itemName;
    public int itemNameBackupRes;
    public String mParentModelCode = "";
    public VideoInfo mVideoInfo = null;
    public int mViewType = 1;
    public String modelCode = "0";
    public String modelContent = "";
    public int rawId;
    public String textColor;
    public String title = "";
    public int todoCode;
    public String todoParameter;

    /* renamed from: com.introvd.template.common.ui.modechooser.ModeItemInfo$AdItemInfo */
    public static class AdItemInfo {
        public String adImgUrl;
        public String adName;
        public int adTodoCode;
        public String adTodoParameter;
        public String description = "";
        public int duration;
        public String expireTime;
        public VideoInfo mVideoInfo;
        public String modelCode = "";
        public String modelContent = "";
        public String startTime;
    }

    /* renamed from: com.introvd.template.common.ui.modechooser.ModeItemInfo$VideoInfo */
    public static class VideoInfo {
        private Date chX;
        private int chY = 10000;
        public String mCoverUrl = "";
        public String mDesc = "";
        public String mFileUrl = "";
        public int mHeight = 0;
        public long mLikeCount = 0;
        public String mStrPubTime = "";
        public String mTitle = "";
        public int mVer = 0;
        public String mVideoPlayUrl = "";
        public long mViewCount = 0;
        public int mWidth = 0;
        public String puid = "";

        public VideoInfo() {
        }

        public VideoInfo(VideoInfo videoInfo) {
            if (videoInfo != null) {
                this.mCoverUrl = videoInfo.mCoverUrl;
                this.mVideoPlayUrl = videoInfo.mVideoPlayUrl;
                this.mFileUrl = videoInfo.mFileUrl;
                this.puid = videoInfo.puid;
                this.mWidth = videoInfo.mWidth;
                this.mHeight = videoInfo.mHeight;
                this.mVer = videoInfo.mVer;
                this.mViewCount = videoInfo.mViewCount;
                this.mLikeCount = videoInfo.mLikeCount;
                this.mDesc = videoInfo.mDesc;
                this.mTitle = videoInfo.mTitle;
            }
        }

        /* renamed from: fv */
        private int m14524fv(String str) {
            int i = 10000;
            if (!TextUtils.isEmpty(str)) {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    i += Character.getNumericValue(str.charAt(i2)) * 100;
                }
            }
            return i;
        }

        /* renamed from: fw */
        private int m14525fw(String str) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                i += Character.getNumericValue(str.charAt(i2)) * 100;
            }
            return i;
        }

        /* renamed from: fx */
        private Date m14526fx(String str) {
            try {
                return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        public long getLikeCount() {
            int fw = m14525fw(this.puid) / 50;
            if (TextUtils.isEmpty(this.mStrPubTime)) {
                return (long) fw;
            }
            if (this.chX == null) {
                this.chX = m14526fx(this.mStrPubTime);
            }
            this.chY = m14524fv(this.puid);
            if (this.chX == null) {
                return (long) fw;
            }
            return ((long) fw) + (((System.currentTimeMillis() - this.chX.getTime()) / ((long) this.chY)) / 100);
        }

        public long getViewCount() {
            int fw = m14525fw(this.puid);
            if (TextUtils.isEmpty(this.mStrPubTime)) {
                return (long) fw;
            }
            if (this.chX == null) {
                this.chX = m14526fx(this.mStrPubTime);
            }
            this.chY = m14524fv(this.puid);
            if (this.chX == null) {
                return (long) fw;
            }
            return ((long) fw) + ((System.currentTimeMillis() - this.chX.getTime()) / ((long) this.chY));
        }
    }

    public int getModeType() {
        if (this.chW != 2) {
            return this.chW;
        }
        if (!isTileImageGroup()) {
            return 23;
        }
        return (this.adItemInfoList == null || this.adItemInfoList.size() <= 2) ? 21 : 22;
    }

    public long getViewCount() {
        if (this.mVideoInfo != null) {
            return this.mVideoInfo.mViewCount;
        }
        return 0;
    }

    public boolean isAdvItem() {
        return this.chW == 101;
    }

    public boolean isImageItem() {
        return this.chW == 1 || this.chW == 2;
    }

    public boolean isTileImageGroup() {
        return this.mViewType == 1;
    }

    public boolean isVideoItem() {
        return this.chW == 3 || this.chW == 4 || this.chW == 6;
    }

    public void setModeType(int i) {
        this.chW = i;
    }
}
