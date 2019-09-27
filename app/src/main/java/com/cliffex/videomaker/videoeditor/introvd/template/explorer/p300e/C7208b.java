package com.introvd.template.explorer.p300e;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.explorer.C7138b;
import com.introvd.template.explorer.model.ExplorerItem;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.videoeditor.model.MediaItem;
import com.p131c.p132a.p135c.C2575a;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.introvd.template.explorer.e.b */
public class C7208b {
    private static ArrayList<String> dEs = new ArrayList<>();
    private static final String[] dEt = C7138b.avT();
    private static final String[] dEu = C7138b.avR();
    private static final String[] dEv = C7138b.avS();

    /* renamed from: a */
    public static ArrayList<String> m21284a(ExplorerItem explorerItem) {
        LogUtils.m14223i("ExplorerUtilFunc", "getFileListsInFolder in");
        ArrayList<String> arrayList = new ArrayList<>();
        if (explorerItem == null || explorerItem.mPathList == null || explorerItem.mPathList.size() == 0) {
            return arrayList;
        }
        C72091 r1 = new FileFilter() {
            public boolean accept(File file) {
                boolean z = false;
                if (file == null || !file.exists()) {
                    return false;
                }
                String absolutePath = file.getAbsolutePath();
                if (file.isDirectory()) {
                    if (!C7208b.m21290jt(absolutePath) && !absolutePath.contains(CommonConfigure.APP_DEFAULT_EXPORT_SUB_PATH)) {
                        z = true;
                    }
                    return z;
                } else if (file.isFile()) {
                    return !absolutePath.contains(CommonConfigure.APP_DEFAULT_EXPORT_SUB_PATH);
                } else {
                    return true;
                }
            }
        };
        ArrayList o = m21292o(explorerItem.mMimeList);
        for (int i = 0; i < explorerItem.mPathList.size(); i++) {
            m21285a((String) explorerItem.mPathList.get(i), o, arrayList, r1);
        }
        o.clear();
        LogUtils.m14223i("ExplorerUtilFunc", "getFileListsInFolder out");
        return arrayList;
    }

    /* renamed from: a */
    public static void m21285a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, FileFilter fileFilter) {
        if (str != null && !str.isEmpty() && arrayList != null && arrayList.size() != 0) {
            File file = new File(str);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles(fileFilter);
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        String path = file2.getPath();
                        if (file2.isDirectory()) {
                            m21285a(path, arrayList, arrayList2, fileFilter);
                        } else {
                            try {
                                if (file2.length() != 0) {
                                    String upperCase = file2.getName().toUpperCase(Locale.US);
                                    int size = arrayList.size();
                                    int i = 0;
                                    while (true) {
                                        if (i >= size) {
                                            break;
                                        } else if (upperCase.endsWith((String) arrayList.get(i))) {
                                            arrayList2.add(path);
                                            break;
                                        } else {
                                            i++;
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r9 != null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
        if (r9 != null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004a, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004e  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m21286b(android.content.Context r8, android.net.Uri r9, java.lang.String r10) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0052
            if (r9 == 0) goto L_0x0052
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 == 0) goto L_0x000c
            goto L_0x0052
        L_0x000c:
            android.content.ContentResolver r2 = r8.getContentResolver()
            java.lang.String r5 = "_data = ?"
            r8 = 1
            java.lang.String[] r6 = new java.lang.String[r8]
            r8 = 0
            r6[r8] = r10
            java.lang.String r10 = "title"
            java.lang.String[] r4 = new java.lang.String[]{r10}     // Catch:{ Throwable -> 0x0042, all -> 0x003f }
            r7 = 0
            r3 = r9
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Throwable -> 0x0042, all -> 0x003f }
            if (r9 != 0) goto L_0x002c
            if (r9 == 0) goto L_0x002b
            r9.close()
        L_0x002b:
            return r0
        L_0x002c:
            boolean r10 = r9.moveToNext()     // Catch:{ Throwable -> 0x003d }
            if (r10 == 0) goto L_0x0037
            java.lang.String r8 = r9.getString(r8)     // Catch:{ Throwable -> 0x003d }
            r0 = r8
        L_0x0037:
            if (r9 == 0) goto L_0x004a
        L_0x0039:
            r9.close()
            goto L_0x004a
        L_0x003d:
            r8 = move-exception
            goto L_0x0044
        L_0x003f:
            r8 = move-exception
            r9 = r0
            goto L_0x004c
        L_0x0042:
            r8 = move-exception
            r9 = r0
        L_0x0044:
            r8.printStackTrace()     // Catch:{ all -> 0x004b }
            if (r9 == 0) goto L_0x004a
            goto L_0x0039
        L_0x004a:
            return r0
        L_0x004b:
            r8 = move-exception
        L_0x004c:
            if (r9 == 0) goto L_0x0051
            r9.close()
        L_0x0051:
            throw r8
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p300e.C7208b.m21286b(android.content.Context, android.net.Uri, java.lang.String):java.lang.String");
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    public static boolean m21287c(Context context, MediaItem mediaItem, int i) {
        if ((i & 1) != 0) {
            mediaItem.date = FileUtils.getFileDate(mediaItem.path);
        }
        boolean z = true;
        if ((i & 2) != 0) {
            mediaItem.title = null;
            if (context != null && MediaFileUtils.IsAudioFileType(MediaFileUtils.GetFileMediaType(mediaItem.path))) {
                mediaItem.title = m21286b(context, Media.EXTERNAL_CONTENT_URI, mediaItem.path);
            }
            if (TextUtils.isEmpty(mediaItem.title)) {
                int lastIndexOf = mediaItem.path.lastIndexOf("/");
                int lastIndexOf2 = mediaItem.path.lastIndexOf(".");
                if (lastIndexOf2 < lastIndexOf) {
                    lastIndexOf2 = mediaItem.path.length();
                }
                if (TextUtils.isEmpty(mediaItem.title)) {
                    int i2 = lastIndexOf + 1;
                    if (i2 >= 0 && i2 <= lastIndexOf2 && lastIndexOf2 <= mediaItem.path.length()) {
                        mediaItem.title = mediaItem.path.substring(i2, lastIndexOf2);
                    }
                }
            }
        }
        if ((i & 4) != 0) {
            int GetFileMediaType = MediaFileUtils.GetFileMediaType(mediaItem.path);
            if (GetFileMediaType == 0 || MediaFileUtils.IsAudioFileType(GetFileMediaType) || MediaFileUtils.IsVideoFileType(GetFileMediaType)) {
                String str = mediaItem.path;
                AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("media_duration_");
                sb.append(str);
                int appSettingInt = instance.getAppSettingInt(sb.toString(), -1);
                if (appSettingInt >= 0) {
                    mediaItem.duration = (long) appSettingInt;
                } else {
                    mediaItem.duration = 0;
                    if (GetFileMediaType == 210) {
                        mediaItem.duration = (long) m21289js(str);
                    } else {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            mediaItem.duration = (long) C2575a.parseInt(mediaMetadataRetriever.extractMetadata(9));
                            mediaMetadataRetriever.release();
                        } catch (Exception unused) {
                            mediaMetadataRetriever.release();
                            z = false;
                        } catch (Throwable th) {
                            mediaMetadataRetriever.release();
                            throw th;
                        }
                    }
                    AppPreferencesSetting instance2 = AppPreferencesSetting.getInstance();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("media_duration_");
                    sb2.append(str);
                    instance2.setAppSettingInt(sb2.toString(), (int) mediaItem.duration);
                }
            }
        }
        return z;
    }

    /* renamed from: dF */
    public static void m21288dF(Context context) {
        LogUtils.m14223i("ExplorerUtilFunc", "Util_PauseOtherAudioPlayback");
        Intent intent = new Intent("com.diii.music.musicservicecommand");
        intent.putExtra("command", "pause");
        context.sendBroadcast(intent);
        Intent intent2 = new Intent("com.lge.fmradio.action.FMRADIO_SHUTDOWN");
        intent2.putExtra("command", "pause");
        context.sendBroadcast(intent2);
    }

    /* renamed from: js */
    private static int m21289js(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            i = C8572y.m25085d(C8501a.aJs().aJv(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            i = 0;
        }
        return i;
    }

    /* renamed from: jt */
    public static boolean m21290jt(String str) {
        LogUtils.m14223i("ExplorerUtilFunc", "checkHideFolder in");
        if (str == null || str.isEmpty() || !new File(str).isDirectory()) {
            return false;
        }
        if (str.indexOf("/.") >= 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".nomedia");
        if (new File(sb.toString()).exists()) {
            return true;
        }
        LogUtils.m14223i("ExplorerUtilFunc", "checkHideFolder out");
        return false;
    }

    /* renamed from: ju */
    public static String m21291ju(String str) {
        return MediaFileUtils.GetFileMimeType(str);
    }

    /* renamed from: o */
    private static ArrayList<String> m21292o(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            MediaFileUtils.GetMediaFileExt((String) arrayList.get(i));
        }
        return arrayList2;
    }
}
