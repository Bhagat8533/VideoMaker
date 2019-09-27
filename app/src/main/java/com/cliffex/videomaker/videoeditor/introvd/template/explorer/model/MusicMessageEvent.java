package com.introvd.template.explorer.model;

public class MusicMessageEvent {
    public static final String MSG_EVENT_CLEAR_FOCUS_LOCAL = "msg_event_clear_focus_local";
    public static final String MSG_EVENT_CLEAR_FOCUS_MINE = "msg_event_clear_focus_mine";
    public static final String MSG_EVENT_CLEAR_FOCUS_ONLINE = "msg_event_clear_focus_online";
    public static final String MSG_EVENT_DOWNLOAD_THEME = "msg_event_item_downloaded";
    public static final String MSG_EVENT_FINISH_THEME_CENTER = "msg_event_finish_theme_center";
    public final String message;
    public final String path;

    public MusicMessageEvent(String str, String str2) {
        this.message = str;
        this.path = str2;
    }
}
