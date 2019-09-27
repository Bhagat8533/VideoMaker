package com.introvd.template.router.explorer;

public class MusicDataItem {
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

    public boolean isRangeValid() {
        return this.startTimeStamp >= 0 && this.stopTimeStamp > 0 && this.stopTimeStamp > this.startTimeStamp && this.currentTimeStamp >= this.startTimeStamp && this.currentTimeStamp <= this.stopTimeStamp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MusicDataItem{filePath='");
        sb.append(this.filePath);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.title);
        sb.append('\'');
        sb.append(", startTimeStamp=");
        sb.append(this.startTimeStamp);
        sb.append(", stopTimeStamp=");
        sb.append(this.stopTimeStamp);
        sb.append(", currentTimeStamp=");
        sb.append(this.currentTimeStamp);
        sb.append('}');
        return sb.toString();
    }
}
