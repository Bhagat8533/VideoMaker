package com.introvd.template.app.model;

public class ShareToAppInfo {
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 2;
    public Extend extend;
    public String packageName;
    public int type;
    public String url;

    public static class Extend {
        public String desc;
        public String image;
        public String title;
    }
}
