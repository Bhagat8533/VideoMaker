package com.introvd.template.camera.model;

import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.sdk.model.editor.DataLyricsItem;
import com.introvd.template.sdk.model.editor.DataPIPIItem;
import xiaoying.engine.clip.QClip.QCamExportedEffectData;

public class SaveRequest {
    public static final int SAVE_REQUEST_TYPE_CLIP = 1;
    public static final int SAVE_REQUEST_TYPE_EXIT = -1;
    public boolean bMakeClipThumbnail = true;
    public QCamExportedEffectData[] camExportEffectDataArray;
    public long dateTaken;
    public int effectConfigureIndex = 0;
    public String effectFilepath = "";
    public int endPos;
    public float fTimeScale;
    public String filePath;
    public boolean hasModifyEndPos;
    public int insertPosition;
    public boolean isNewVideoClip;
    public boolean isVideo;
    public boolean isVirtualFile;
    public DataLyricsItem lyricsItem = null;
    public MusicDataItem musicItem = null;
    public int nSaveRequestType = 1;
    public Object objExtInfo = null;
    public int orientation;
    public DataPIPIItem pipItem = null;
    public int startPos;
}
