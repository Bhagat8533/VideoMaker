package com.introvd.template.sns.gallery;

import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import java.util.List;

public interface SnsGalleryInfoListener {
    void onSyncAlbumsError();

    void onSyncAlbumsSuccess(List<MediaGroupItem> list);

    void onSyncMediaDataError();

    void onSyncMediaDataSuccess(List<ExtMediaItem> list);
}
