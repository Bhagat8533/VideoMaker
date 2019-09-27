package com.introvd.template.sdk.p380a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.utils.C8548e;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.a.b */
public abstract class C8381b<T> {
    public int ebQ = -1;
    protected volatile List<T> ebR;
    protected HashMap<String, T> ebS = new HashMap<>();
    protected HandlerThread ebT = null;

    protected C8381b() {
    }

    /* renamed from: O */
    public static DataItemProject m24131O(Context context, String str, String str2) {
        if (context == null || !C8548e.isFileExisted(str)) {
            return null;
        }
        DataItemProject dataItemProject = new DataItemProject();
        String a = m24132a(context, new Date(), str2);
        String fileName = C8548e.getFileName(str);
        dataItemProject.strCreateTime = a;
        dataItemProject.strModifyTime = a;
        dataItemProject.strPrjTitle = "";
        dataItemProject.strPrjURL = str;
        StringBuilder sb = new StringBuilder();
        sb.append(C8401d.ane());
        sb.append(fileName);
        sb.append(".jpg");
        dataItemProject.strPrjThumbnail = sb.toString();
        return dataItemProject;
    }

    /* renamed from: a */
    public static String m24132a(Context context, Date date, String str) {
        return context != null ? new SimpleDateFormat(str, Locale.US).format(date) : "";
    }

    public static List<String> aHi() {
        ArrayList arrayList = new ArrayList();
        String ane = C8401d.ane();
        if (C8548e.isDirectoryExisted(ane)) {
            File[] listFiles = new File(ane).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.exists()) {
                        String absolutePath = file.getAbsolutePath();
                        if (absolutePath.endsWith(".prj")) {
                            arrayList.add(absolutePath);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static int aHj() {
        String ane = C8401d.ane();
        if (C8548e.isDirectoryExisted(ane)) {
            String[] list = new File(ane).list();
            if (list != null) {
                int i = 0;
                for (String str : list) {
                    if (!TextUtils.isEmpty(str) && !str.contains("_zip") && str.endsWith(".prj")) {
                        i++;
                    }
                }
                return i;
            }
        }
        return 0;
    }

    /* renamed from: S */
    public synchronized void mo33874S(Context context, boolean z) {
    }

    /* renamed from: a */
    public void mo33875a(Context context, String str, int i, boolean z) {
    }

    /* renamed from: a */
    public final void mo33876a(DataItemProject dataItemProject, boolean z) {
        if (dataItemProject != null) {
            mo33886b(dataItemProject, z);
            dataItemProject._id = C8404c.m24239c(dataItemProject);
        }
    }

    /* renamed from: a */
    public boolean mo33877a(Handler handler, boolean z) {
        return false;
    }

    public boolean aHb() {
        return false;
    }

    public final void aHc() {
        if (aHf() != null) {
            try {
                C8404c.m24239c(aHe());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public QStoryboard aHd() {
        return null;
    }

    public DataItemProject aHe() {
        return null;
    }

    public C8380a aHf() {
        return null;
    }

    public void aHg() {
    }

    public List<T> aHh() {
        return this.ebR;
    }

    /* renamed from: aV */
    public int mo33885aV(long j) {
        int count = getCount();
        for (int i = 0; i < count; i++) {
            DataItemProject tz = mo33891tz(i);
            if (tz != null && j == tz._id) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo33886b(DataItemProject dataItemProject, boolean z);

    /* access modifiers changed from: protected */
    /* renamed from: ck */
    public void mo33887ck(Context context, String str) {
        if (context != null) {
            try {
                context.getContentResolver().delete(Media.EXTERNAL_CONTENT_URI, "_data= ?", new String[]{str});
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public int getCount() {
        return 0;
    }

    /* renamed from: nt */
    public int mo33889nt(String str) {
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo33890o(ContentResolver contentResolver, String str) {
        String nC = C8404c.m24243nC(str);
        if (!TextUtils.isEmpty(nC)) {
            C8548e.deleteFile(nC);
        }
    }

    /* renamed from: tz */
    public DataItemProject mo33891tz(int i) {
        return null;
    }
}
