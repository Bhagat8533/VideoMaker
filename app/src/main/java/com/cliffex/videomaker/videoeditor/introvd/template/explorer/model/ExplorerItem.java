package com.introvd.template.explorer.model;

import java.util.ArrayList;

public class ExplorerItem {
    public static final int SEARCH_TYPE_APP_DATABASE = 1;
    public static final int SEARCH_TYPE_APP_DEFAULT = 0;
    public static final int SEARCH_TYPE_FILES_IN_FOLDER = 3;
    public static final int SEARCH_TYPE_MEDIASTORE = 2;
    public boolean isPrjDeleted;
    private int mCount = 0;
    public String mDisplayName;
    public int mDisplayType;
    private int mFirstFileId;
    private String mFirstFilePath;
    public int mFolderType;
    public int mInputType;
    public ArrayList<String> mMimeList;
    public ArrayList<String> mPathList;
    public int mSearchType = 0;
    public int mSortOrder;
    public boolean mbIsDCIM = false;
    public int prjId;

    public int getCount() {
        return this.mCount;
    }

    public int getFirstFileId() {
        return this.mFirstFileId;
    }

    public String getFirstFilePath() {
        return this.mFirstFilePath;
    }

    public void setCount(int i) {
        this.mCount = i;
    }

    public void setFirstFileId(int i) {
        this.mFirstFileId = i;
    }

    public void setFirstFilePath(String str) {
        this.mFirstFilePath = str;
    }
}
