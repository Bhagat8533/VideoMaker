package com.introvd.template.vivaiap.payment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayParam implements Parcelable {
    public static final Creator<PayParam> CREATOR = new Creator<PayParam>() {
        /* renamed from: O */
        public PayParam createFromParcel(Parcel parcel) {
            return new PayParam(parcel);
        }

        /* renamed from: vJ */
        public PayParam[] newArray(int i) {
            return new PayParam[i];
        }
    };
    private String channel;
    private String country;
    private String currency;
    private final String dNw;
    private String description;
    private String eBe;
    private int eBg;
    private boolean eBh;
    private Bundle eBi;
    private String title;
    private String type;
    private String userId;

    /* renamed from: com.introvd.template.vivaiap.payment.PayParam$a */
    public static class C9046a {
        private String channel;
        private String country;
        private String currency;
        private String dNw;
        private String description;
        private String eBe;
        private int eBg;
        private boolean eBh = true;
        private String title;
        private String type;
        private String userId;

        public C9046a(String str, String str2) {
            this.eBe = str;
            this.dNw = str2;
        }

        public PayParam aNB() {
            PayParam payParam = new PayParam(this.eBe, this.dNw, this.title, this.description, this.eBg, this.type, this.channel, this.userId, this.currency, this.country, this.eBh);
            return payParam;
        }

        /* renamed from: jM */
        public C9046a mo35863jM(boolean z) {
            this.eBh = z;
            return this;
        }

        /* renamed from: ra */
        public C9046a mo35864ra(String str) {
            this.title = str;
            return this;
        }

        /* renamed from: rb */
        public C9046a mo35865rb(String str) {
            this.description = str;
            return this;
        }

        /* renamed from: rc */
        public C9046a mo35866rc(String str) {
            this.channel = str;
            return this;
        }

        /* renamed from: rd */
        public C9046a mo35867rd(String str) {
            this.userId = str;
            return this;
        }

        /* renamed from: re */
        public C9046a mo35868re(String str) {
            this.currency = str;
            return this;
        }

        /* renamed from: rf */
        public C9046a mo35869rf(String str) {
            this.country = str;
            return this;
        }

        /* renamed from: vK */
        public C9046a mo35870vK(int i) {
            this.eBg = i;
            return this;
        }
    }

    protected PayParam(Parcel parcel) {
        this.eBe = parcel.readString();
        this.dNw = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.eBg = parcel.readInt();
        this.type = parcel.readString();
        this.channel = parcel.readString();
        this.userId = parcel.readString();
        this.currency = parcel.readString();
        this.country = parcel.readString();
        this.eBh = parcel.readByte() != 0;
        this.eBi = parcel.readBundle(getClass().getClassLoader());
    }

    public PayParam(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, String str9, boolean z) {
        this.eBe = str;
        this.dNw = str2;
        this.title = str3;
        this.description = str4;
        this.eBg = i;
        this.type = str5;
        this.channel = str6;
        this.userId = str7;
        this.currency = str8;
        this.country = str9;
        this.eBh = z;
        this.eBi = new Bundle();
    }

    public String aAB() {
        return this.dNw;
    }

    public String aEO() {
        return this.eBe;
    }

    /* access modifiers changed from: 0000 */
    public boolean aNA() {
        return this.eBh;
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getExtra() {
        return this.eBi;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.eBe);
        parcel.writeString(this.dNw);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeInt(this.eBg);
        parcel.writeString(this.type);
        parcel.writeString(this.channel);
        parcel.writeString(this.userId);
        parcel.writeString(this.currency);
        parcel.writeString(this.country);
        parcel.writeByte(this.eBh ? (byte) 1 : 0);
        parcel.writeBundle(this.eBi);
    }
}
