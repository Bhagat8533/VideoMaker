package com.introvd.template.sdk.model.editor;

import android.graphics.Bitmap;
import com.introvd.template.sdk.model.template.TemplateInfo;

public class StoryBoardItemInfo {
    public boolean bAudioEnable = false;
    public boolean bAudioOn = false;
    public boolean bSyncThumb;
    public Bitmap bmpThumbnail;
    public String coverUrl;
    public boolean isGif;
    public boolean isVideo;
    public long lDuration;
    public long lTemplateId;
    public long lTransDuration = -1;
    public EffectInfoModel mEffectInfo;
    public TemplateInfo mFontInfo = null;
    public String mFontName = "";
    public String mFontPath = "";
    public float mRotation = 0.0f;
    public String mSourcePath;
    public int orderNo = 0;
}
