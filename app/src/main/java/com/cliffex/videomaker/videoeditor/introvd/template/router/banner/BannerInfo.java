package com.introvd.template.router.banner;

public class BannerInfo {
    public int contentType;
    public int hasSave;

    /* renamed from: id */
    public int f3572id;
    public int orderNum;
    public int pageType;
    public String strContentTitle;
    public String strContentUrl;
    public String strDesc;
    public String strTodoContent;
    public int todoType;

    public void setSave(boolean z) {
        if (z) {
            this.hasSave = 1;
        } else {
            this.hasSave = 0;
        }
    }
}
