package com.introvd.template.router.editor.studio;

public class StudioActionEvent {
    public static final int ACTION_DELETE = 0;
    public int action;
    public int from;

    public StudioActionEvent(int i, int i2) {
        this.action = i;
        this.from = i2;
    }
}
