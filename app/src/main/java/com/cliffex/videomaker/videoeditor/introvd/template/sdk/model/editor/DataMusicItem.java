package com.introvd.template.sdk.model.editor;

import com.introvd.template.sdk.utils.C8548e;

public class DataMusicItem {
    public int currentTimeStamp;
    public String filePath;
    public int startTimeStamp;
    public int stopTimeStamp;
    public String title;

    public int getSrcLen() {
        int i = this.stopTimeStamp - this.startTimeStamp;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public boolean isValidItem() {
        return C8548e.isFileExisted(this.filePath) && this.stopTimeStamp > this.startTimeStamp && this.currentTimeStamp >= this.startTimeStamp && this.currentTimeStamp <= this.stopTimeStamp;
    }
}
