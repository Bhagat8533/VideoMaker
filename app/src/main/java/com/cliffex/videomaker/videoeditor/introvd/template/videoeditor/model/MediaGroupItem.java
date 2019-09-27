package com.introvd.template.videoeditor.model;

import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.sns.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MediaGroupItem implements Serializable {
    public static final int ITEM_MEDIA_TYPE_NONE = 0;
    public static final int ITEM_MEDIA_TYPE_PHOTO = 1;
    public static final int ITEM_MEDIA_TYPE_VIDEO = 2;
    public String albumId;
    BROWSE_TYPE browseType = null;
    public int countForSns = 0;
    public String coverPhotoUrl;
    boolean isVirtualFile = false;
    public long lFlag;
    public long lGroupExtInfo;
    public long lGroupTimestamp;
    public long lNewItemCount = 0;
    public ArrayList<ExtMediaItem> mediaItemList;
    public Map<String, ExtMediaItem> mediaItemMap = new HashMap();
    public MediaType mediaType;
    public String strGroupDisplayName;
    public String strParentPath;

    public void add(ExtMediaItem extMediaItem) {
        if (!this.mediaItemMap.containsKey(extMediaItem.path)) {
            this.mediaItemMap.put(extMediaItem.path, extMediaItem);
            this.mediaItemList.add(extMediaItem);
        }
        if (extMediaItem.lFlag != 0) {
            this.lNewItemCount++;
        }
    }

    public void add(ExtMediaItem extMediaItem, int i) {
        int GetFileMediaType = MediaFileUtils.GetFileMediaType(extMediaItem.path);
        boolean z = true;
        if ((i != 1 || !MediaFileUtils.IsImageFileType(GetFileMediaType)) && ((i != 2 || !MediaFileUtils.IsVideoFileType(GetFileMediaType)) && i != 0)) {
            z = false;
        }
        if (z && !this.mediaItemMap.containsKey(extMediaItem.path)) {
            this.mediaItemMap.put(extMediaItem.path, extMediaItem);
            this.mediaItemList.add(extMediaItem);
            if (extMediaItem.lFlag != 0) {
                this.lNewItemCount++;
            }
        }
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public BROWSE_TYPE getBrowseType() {
        return this.browseType;
    }

    public int getCountForSns() {
        return this.countForSns;
    }

    public String getCoverPhotoUrl() {
        return this.coverPhotoUrl;
    }

    public ArrayList<ExtMediaItem> getMediaItemList() {
        return this.mediaItemList;
    }

    public Map<String, ExtMediaItem> getMediaItemMap() {
        return this.mediaItemMap;
    }

    public MediaType getMediaType() {
        return this.mediaType;
    }

    public String getStrGroupDisplayName() {
        return this.strGroupDisplayName;
    }

    public String getStrParentPath() {
        return this.strParentPath;
    }

    public long getlFlag() {
        return this.lFlag;
    }

    public long getlGroupExtInfo() {
        return this.lGroupExtInfo;
    }

    public long getlGroupTimestamp() {
        return this.lGroupTimestamp;
    }

    public long getlNewItemCount() {
        return this.lNewItemCount;
    }

    public boolean isVirtualFile() {
        return this.isVirtualFile;
    }

    public void remove(int i) {
        if (this.mediaItemList != null && i >= 0 && i < this.mediaItemList.size()) {
            ExtMediaItem extMediaItem = (ExtMediaItem) this.mediaItemList.remove(i);
            if (extMediaItem != null) {
                this.mediaItemMap.remove(extMediaItem.path);
                if (extMediaItem.lFlag != 0) {
                    this.lNewItemCount--;
                }
            }
        }
    }

    public void remove(ExtMediaItem extMediaItem) {
        if (extMediaItem != null && extMediaItem.path != null) {
            this.mediaItemList.remove(extMediaItem);
            this.mediaItemMap.remove(extMediaItem.path);
        }
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setBrowseType(BROWSE_TYPE browse_type) {
        this.browseType = browse_type;
    }

    public void setCountForSns(int i) {
        this.countForSns = i;
    }

    public void setCoverPhotoUrl(String str) {
        this.coverPhotoUrl = str;
    }

    public void setMediaItemList(ArrayList<ExtMediaItem> arrayList) {
        this.mediaItemList = arrayList;
    }

    public void setMediaItemMap(Map<String, ExtMediaItem> map) {
        this.mediaItemMap = map;
    }

    public void setMediaType(MediaType mediaType2) {
        this.mediaType = mediaType2;
    }

    public void setStrGroupDisplayName(String str) {
        this.strGroupDisplayName = str;
    }

    public void setStrParentPath(String str) {
        this.strParentPath = str;
    }

    public void setVirtualFile(boolean z) {
        this.isVirtualFile = z;
    }

    public void setlFlag(long j) {
        this.lFlag = j;
    }

    public void setlGroupExtInfo(long j) {
        this.lGroupExtInfo = j;
    }

    public void setlGroupTimestamp(long j) {
        this.lGroupTimestamp = j;
    }

    public void setlNewItemCount(long j) {
        this.lNewItemCount = j;
    }
}
