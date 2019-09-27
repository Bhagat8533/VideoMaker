package com.introvd.template.sdk.model.editor;

public class ThumbInfo {
    private int duration = 0;
    private int position = 0;

    public int getDuration() {
        return this.duration;
    }

    public int getPosition() {
        return this.position;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("position=");
        stringBuffer.append(this.position);
        stringBuffer.append(";duration=");
        stringBuffer.append(this.duration);
        return stringBuffer.toString();
    }
}
