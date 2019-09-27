package com.introvd.template.vivaiap.payment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayResult implements Parcelable {
    public static final Creator<PayResult> CREATOR = new Creator<PayResult>() {
        /* renamed from: P */
        public PayResult createFromParcel(Parcel parcel) {
            return new PayResult(parcel);
        }

        /* renamed from: vL */
        public PayResult[] newArray(int i) {
            return new PayResult[i];
        }
    };
    private final int code;
    private final String dNw;
    private boolean eBh = true;
    private Bundle eBi;
    private final String message;
    private final boolean success;

    protected PayResult(Parcel parcel) {
        boolean z = true;
        this.code = parcel.readInt();
        this.message = parcel.readString();
        this.success = parcel.readByte() != 0;
        this.dNw = parcel.readString();
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.eBh = z;
        this.eBi = parcel.readBundle(getClass().getClassLoader());
    }

    public PayResult(boolean z, int i, String str, String str2) {
        this.success = z;
        this.code = i;
        this.message = str2;
        this.dNw = str;
        this.eBi = new Bundle();
    }

    public String aAB() {
        return this.dNw;
    }

    /* access modifiers changed from: 0000 */
    public boolean aNA() {
        return this.eBh;
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jN */
    public void mo35877jN(boolean z) {
        this.eBh = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayResult{code=");
        sb.append(this.code);
        sb.append(", message='");
        sb.append(this.message);
        sb.append('\'');
        sb.append(", success=");
        sb.append(this.success);
        sb.append(", refresh=");
        sb.append(this.eBh);
        sb.append(", extra=");
        sb.append(this.eBi);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeByte(this.success ? (byte) 1 : 0);
        parcel.writeString(this.dNw);
        parcel.writeByte(this.eBh ? (byte) 1 : 0);
        parcel.writeBundle(this.eBi);
    }
}
