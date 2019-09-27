package com.introvd.template.sdk.model.editor;

public class VideoInfo {
    public int duration;
    public int frameHeight;
    public int frameWidth;

    public VideoInfo() {
    }

    public VideoInfo(int i, int i2, int i3) {
        this.frameWidth = i;
        this.frameHeight = i2;
        this.duration = i3;
    }
}
