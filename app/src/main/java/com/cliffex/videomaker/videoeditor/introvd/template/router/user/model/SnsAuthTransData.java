package com.introvd.template.router.user.model;

import com.introvd.template.router.user.SnsAuthListener;

public class SnsAuthTransData {
    public boolean isSpecialLogin;
    public SnsAuthListener snsAuthListener;
    public int snsType;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean isSpecialLogin;
        /* access modifiers changed from: private */
        public SnsAuthListener snsAuthListener;
        /* access modifiers changed from: private */
        public int snsType;

        public SnsAuthTransData build() {
            return new SnsAuthTransData(this);
        }

        public Builder isSpecialLogin(boolean z) {
            this.isSpecialLogin = z;
            return this;
        }

        public Builder snsAuthListener(SnsAuthListener snsAuthListener2) {
            this.snsAuthListener = snsAuthListener2;
            return this;
        }

        public Builder snsType(int i) {
            this.snsType = i;
            return this;
        }
    }

    private SnsAuthTransData(Builder builder) {
        this.snsType = builder.snsType;
        this.snsAuthListener = builder.snsAuthListener;
        this.isSpecialLogin = builder.isSpecialLogin;
    }
}
