package com.introvd.base.fulrryconfig;

public class MoreApp {
    private String des;
    private String linkBanner;
    private String linkIcon;
    private String name;
    private String pkm;
    private String priority;

    public MoreApp(String pkm2, String linkIcon2, String des2, String linkBanner2, String name2, String priority2) {
        this.pkm = pkm2;
        this.linkIcon = linkIcon2;
        this.des = des2;
        this.linkBanner = linkBanner2;
        this.name = name2;
        this.priority = priority2;
    }

    public String getPkm() {
        return this.pkm;
    }

    public void setPkm(String pkm2) {
        this.pkm = pkm2;
    }

    public String getLinkIcon() {
        return this.linkIcon;
    }

    public void setLinkIcon(String linkIcon2) {
        this.linkIcon = linkIcon2;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des2) {
        this.des = des2;
    }

    public String getLinkBanner() {
        return this.linkBanner;
    }

    public void setLinkBanner(String linkBanner2) {
        this.linkBanner = linkBanner2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority2) {
        this.priority = priority2;
    }
}
