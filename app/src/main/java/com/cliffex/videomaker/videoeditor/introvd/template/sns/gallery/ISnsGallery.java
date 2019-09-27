package com.introvd.template.sns.gallery;

import android.app.Activity;
import com.introvd.template.common.MSize;

public interface ISnsGallery {
    public static final int BOTH_MODE = 5632;
    public static final int IMAGE_MODE = 5634;
    public static final int VIDEO_MODE = 5633;

    void getAlbums(Activity activity, MSize mSize);

    void getMediaData(Activity activity, String str, MSize mSize);

    void setSnsGalleryInfoListener(SnsGalleryInfoListener snsGalleryInfoListener);

    void stopFectchData();

    void updateShowMode(int i);
}
