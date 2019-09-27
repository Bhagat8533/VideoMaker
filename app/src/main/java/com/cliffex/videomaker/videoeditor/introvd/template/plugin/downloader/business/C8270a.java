package com.introvd.template.plugin.downloader.business;

import com.introvd.template.plugin.downloader.entity.C8312a;
import com.introvd.template.plugin.downloader.entity.DownloadStatus;

/* renamed from: com.introvd.template.plugin.downloader.business.a */
public class C8270a {
    /* renamed from: a */
    public static C8312a m23856a(int i, String str, DownloadStatus downloadStatus) {
        return m23858a(i, str, null, null, downloadStatus);
    }

    /* renamed from: a */
    private static C8312a m23857a(int i, String str, DownloadStatus downloadStatus, Throwable th) {
        C8312a a = m23856a(i, str, downloadStatus);
        a.setError(th);
        return a;
    }

    /* renamed from: a */
    public static C8312a m23858a(int i, String str, String str2, String str3, DownloadStatus downloadStatus) {
        C8312a aVar = new C8312a();
        if (downloadStatus == null) {
            downloadStatus = new DownloadStatus();
        }
        aVar.mo33503b(downloadStatus);
        aVar.setName(str2);
        aVar.setPath(str3);
        aVar.setFlag(i);
        aVar.setUrl(str);
        return aVar;
    }

    /* renamed from: a */
    public static C8312a m23859a(String str, DownloadStatus downloadStatus) {
        return m23856a(9990, str, downloadStatus);
    }

    /* renamed from: a */
    public static C8312a m23860a(String str, DownloadStatus downloadStatus, Throwable th) {
        return m23857a(9995, str, downloadStatus, th);
    }

    /* renamed from: a */
    public static C8312a m23861a(String str, String str2, String str3, DownloadStatus downloadStatus) {
        return m23858a(9994, str, str2, str3, downloadStatus);
    }

    /* renamed from: b */
    public static C8312a m23862b(String str, DownloadStatus downloadStatus) {
        return m23856a(9991, str, downloadStatus);
    }

    /* renamed from: c */
    public static C8312a m23863c(String str, DownloadStatus downloadStatus) {
        return m23856a(9992, str, downloadStatus);
    }

    /* renamed from: d */
    public static C8312a m23864d(String str, DownloadStatus downloadStatus) {
        return m23856a(9993, str, downloadStatus);
    }
}
