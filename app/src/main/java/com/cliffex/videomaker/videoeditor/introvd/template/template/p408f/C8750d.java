package com.introvd.template.template.p408f;

import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.template.p404d.C8645a;

/* renamed from: com.introvd.template.template.f.d */
public class C8750d extends C8645a {
    /* renamed from: jM */
    public static boolean m25573jM(String str) {
        return str != null && str.toLowerCase().contains(".gif");
    }

    /* renamed from: qy */
    public static StoryBoardItemInfo m25574qy(String str) {
        StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
        storyBoardItemInfo.mEffectInfo = new EffectInfoModel();
        storyBoardItemInfo.mEffectInfo.mPath = str;
        storyBoardItemInfo.mEffectInfo.mName = str;
        storyBoardItemInfo.mEffectInfo.setbNeedDownload(false);
        storyBoardItemInfo.mEffectInfo.setDownloading(false);
        storyBoardItemInfo.mEffectInfo.setDownloaded(true);
        storyBoardItemInfo.isVideo = false;
        storyBoardItemInfo.lDuration = 0;
        storyBoardItemInfo.bmpThumbnail = null;
        return storyBoardItemInfo;
    }

    /* renamed from: qz */
    public static String m25575qz(String str) {
        return m25199ps(str);
    }
}
