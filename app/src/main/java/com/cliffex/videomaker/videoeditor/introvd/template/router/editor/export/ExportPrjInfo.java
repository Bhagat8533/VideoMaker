package com.introvd.template.router.editor.export;

public class ExportPrjInfo {
    public long _id;
    public int iPrjDuration;
    public boolean isMVPrj;
    public boolean isModified;
    public String prjName;
    public int prjThemeType;
    public String strCreateTime;
    public String strPrjURL;

    public static final class Builder {
        /* access modifiers changed from: private */
        public long _id;
        /* access modifiers changed from: private */
        public int iPrjDuration;
        /* access modifiers changed from: private */
        public boolean isMVPrj;
        /* access modifiers changed from: private */
        public boolean isModified;
        /* access modifiers changed from: private */
        public String prjName;
        /* access modifiers changed from: private */
        public int prjThemeType;
        /* access modifiers changed from: private */
        public String strCreateTime;
        /* access modifiers changed from: private */
        public String strPrjURL;

        public Builder _id(long j) {
            this._id = j;
            return this;
        }

        public ExportPrjInfo build() {
            return new ExportPrjInfo(this);
        }

        public Builder iPrjDuration(int i) {
            this.iPrjDuration = i;
            return this;
        }

        public Builder isMVPrj(boolean z) {
            this.isMVPrj = z;
            return this;
        }

        public Builder isModified(boolean z) {
            this.isModified = z;
            return this;
        }

        public Builder prjName(String str) {
            this.prjName = str;
            return this;
        }

        public Builder prjThemeType(int i) {
            this.prjThemeType = i;
            return this;
        }

        public Builder strCreateTime(String str) {
            this.strCreateTime = str;
            return this;
        }

        public Builder strPrjURL(String str) {
            this.strPrjURL = str;
            return this;
        }
    }

    private ExportPrjInfo(Builder builder) {
        this._id = -1;
        this.iPrjDuration = 0;
        this.strCreateTime = null;
        this._id = builder._id;
        this.strPrjURL = builder.strPrjURL;
        this.isModified = builder.isModified;
        this.isMVPrj = builder.isMVPrj;
        this.prjName = builder.prjName;
        this.iPrjDuration = builder.iPrjDuration;
        this.strCreateTime = builder.strCreateTime;
        this.prjThemeType = builder.prjThemeType;
    }
}
