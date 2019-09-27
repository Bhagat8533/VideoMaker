package com.introvd.template.sns;

import com.quvideo.sns.base.p228b.C4982c;

public class SnsShareInfo {
    public boolean isNeedWXProgram;
    public C4982c snsShareListener;
    public String strActivityID;
    public String strAuid;
    public String strChooserTitle;
    public String strDesc;
    public String strImgUrl;
    public String strLinkUrl;
    public String strPuid;
    public String strPver;
    public String strQuote;
    public String strTitle;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean isNeedWXProgram;
        public C4982c snsShareListener;
        /* access modifiers changed from: private */
        public String strActivityID = "";
        /* access modifiers changed from: private */
        public String strAuid = "";
        /* access modifiers changed from: private */
        public String strChooserTitle = "";
        /* access modifiers changed from: private */
        public String strDesc = "";
        /* access modifiers changed from: private */
        public String strImgUrl = "";
        /* access modifiers changed from: private */
        public String strLinkUrl = "";
        /* access modifiers changed from: private */
        public String strPuid = "";
        /* access modifiers changed from: private */
        public String strPver = "";
        public String strQuote;
        /* access modifiers changed from: private */
        public String strTitle = "";

        public SnsShareInfo build() {
            return new SnsShareInfo(this);
        }

        public Builder isNeedWXProgram(boolean z) {
            this.isNeedWXProgram = z;
            return this;
        }

        public Builder snsShareListener(C4982c cVar) {
            this.snsShareListener = cVar;
            return this;
        }

        public Builder strActivityID(String str) {
            this.strActivityID = str;
            return this;
        }

        public Builder strAuid(String str) {
            this.strAuid = str;
            return this;
        }

        public Builder strChooserTitle(String str) {
            this.strChooserTitle = str;
            return this;
        }

        public Builder strDesc(String str) {
            this.strDesc = str;
            return this;
        }

        public Builder strImgUrl(String str) {
            this.strImgUrl = str;
            return this;
        }

        public Builder strLinkUrl(String str) {
            this.strLinkUrl = str;
            return this;
        }

        public Builder strPuid(String str) {
            this.strPuid = str;
            return this;
        }

        public Builder strPver(String str) {
            this.strPver = str;
            return this;
        }

        public Builder strQuote(String str) {
            this.strQuote = str;
            return this;
        }

        public Builder strTitle(String str) {
            this.strTitle = str;
            return this;
        }
    }

    private SnsShareInfo(Builder builder) {
        this.strTitle = builder.strTitle;
        this.strDesc = builder.strDesc;
        this.strQuote = builder.strQuote;
        this.strImgUrl = builder.strImgUrl;
        this.strLinkUrl = builder.strLinkUrl;
        this.strChooserTitle = builder.strChooserTitle;
        this.strPuid = builder.strPuid;
        this.strPver = builder.strPver;
        this.strAuid = builder.strAuid;
        this.strActivityID = builder.strActivityID;
        this.isNeedWXProgram = builder.isNeedWXProgram;
        this.snsShareListener = builder.snsShareListener;
    }
}
