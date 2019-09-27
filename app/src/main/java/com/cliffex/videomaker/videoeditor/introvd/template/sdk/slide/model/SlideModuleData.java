package com.introvd.template.sdk.slide.model;

public class SlideModuleData {
    private String desc;
    private int materialNum;
    private String title;

    public static class Builder {
        /* access modifiers changed from: private */
        public String desc;
        /* access modifiers changed from: private */
        public int materialNum;
        /* access modifiers changed from: private */
        public String title;

        public SlideModuleData build() {
            return new SlideModuleData(this);
        }

        public Builder setDesc(String str) {
            this.desc = str;
            return this;
        }

        public Builder setMaterialNum(int i) {
            this.materialNum = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    public SlideModuleData(Builder builder) {
        this.title = builder.title;
        this.desc = builder.desc;
        this.materialNum = builder.materialNum;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getMaterialNum() {
        return this.materialNum;
    }

    public String getTitle() {
        return this.title;
    }
}
