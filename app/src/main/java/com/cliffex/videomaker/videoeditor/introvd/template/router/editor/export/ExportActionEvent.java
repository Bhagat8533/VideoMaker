package com.introvd.template.router.editor.export;

public class ExportActionEvent {
    public static final int STATE_CANCEL = 3;
    public static final int STATE_EXPORTING_CAHNGE = 4;
    public static final int STATE_FAIL = 2;
    public static final int STATE_FINISH = 1;
    public static final int STATE_PREPARE = 0;
    public boolean bFromExp;
    public boolean isExporting;
    public int state;
    public long uniqueId;
    public String videoPath = "";

    public ExportActionEvent(long j, int i) {
        this.uniqueId = j;
        this.state = i;
    }

    public ExportActionEvent(long j, int i, String str, boolean z) {
        this.uniqueId = j;
        this.state = i;
        this.videoPath = str;
        this.bFromExp = z;
    }

    public ExportActionEvent(long j, int i, boolean z) {
        this.uniqueId = j;
        this.state = i;
        this.isExporting = z;
    }
}
