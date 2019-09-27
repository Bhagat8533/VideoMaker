package com.introvd.template.plugin.downloader.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class DownloadStatus implements Parcelable {
    public static final Creator<DownloadStatus> CREATOR = new Creator<DownloadStatus>() {
        /* renamed from: L */
        public DownloadStatus createFromParcel(Parcel parcel) {
            return new DownloadStatus(parcel);
        }

        /* renamed from: tp */
        public DownloadStatus[] newArray(int i) {
            return new DownloadStatus[i];
        }
    };
    public boolean eav = false;
    private long eaw;
    private long eax;

    public DownloadStatus() {
    }

    public DownloadStatus(long j, long j2) {
        this.eax = j;
        this.eaw = j2;
    }

    protected DownloadStatus(Parcel parcel) {
        boolean z = false;
        if (parcel.readByte() != 0) {
            z = true;
        }
        this.eav = z;
        this.eaw = parcel.readLong();
        this.eax = parcel.readLong();
    }

    public DownloadStatus(boolean z, long j, long j2) {
        this.eav = z;
        this.eax = j;
        this.eaw = j2;
    }

    public long aGk() {
        return this.eax;
    }

    public long aGl() {
        return (long) ((this.eaw == 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : (((double) this.eax) * 1.0d) / ((double) this.eaw)) * 100.0d);
    }

    /* renamed from: aS */
    public void mo33493aS(long j) {
        this.eaw = j;
    }

    /* renamed from: aT */
    public void mo33494aT(long j) {
        this.eax = j;
    }

    public long aaZ() {
        return this.eaw;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.eav ? (byte) 1 : 0);
        parcel.writeLong(this.eaw);
        parcel.writeLong(this.eax);
    }
}
