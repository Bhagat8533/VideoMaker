package com.introvd.template.editor.effects.customwatermark;

import android.text.TextUtils;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.introvd.template.editor.effects.customwatermark.e */
public class C6092e {
    /* renamed from: a */
    public static C8441b m17356a(ScaleRotateViewState scaleRotateViewState, int i) {
        if (scaleRotateViewState == null || TextUtils.isEmpty(scaleRotateViewState.mStylePath)) {
            return null;
        }
        VeRange veRange = new VeRange(0, i);
        C8441b bVar = new C8441b();
        bVar.mo34280r(scaleRotateViewState);
        bVar.mo34273b(veRange);
        bVar.groupId = 50;
        bVar.mo34279nG(scaleRotateViewState.mStylePath);
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092 A[SYNTHETIC, Splitter:B:33:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0 A[SYNTHETIC, Splitter:B:40:0x00a0] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m17357a(java.lang.String r5, com.introvd.template.editor.effects.customwatermark.C6096h r6) {
        /*
            if (r6 == 0) goto L_0x00a9
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r0 = r6.cKy
            if (r0 == 0) goto L_0x00a9
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r0 = r6.cKy
            java.lang.String r0 = r0.mStylePath
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0012
            goto L_0x00a9
        L_0x0012:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0019
            return
        L_0x0019:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH
            r0.append(r1)
            java.lang.String r1 = "xywatermarks/"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x003a
            r1.mkdirs()
        L_0x003a:
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r1 = r6.cKy
            java.lang.String r1 = r1.mStylePath
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH
            r2.append(r3)
            java.lang.String r3 = "xywatermarks/.pictures/"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r1 = m17363n(r1, r2, r5)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x005f
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r2 = r6.cKy
            r2.mStylePath = r1
        L_0x005f:
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r5)
            r5 = 0
            boolean r0 = r1.exists()     // Catch:{ Exception -> 0x008c }
            if (r0 != 0) goto L_0x006e
            r1.createNewFile()     // Catch:{ Exception -> 0x008c }
        L_0x006e:
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x008c }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008c }
            r2.<init>(r1)     // Catch:{ Exception -> 0x008c }
            r0.<init>(r2)     // Catch:{ Exception -> 0x008c }
            r0.writeObject(r6)     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
            r0.flush()     // Catch:{ Exception -> 0x0085, all -> 0x0082 }
            r0.close()     // Catch:{ Exception -> 0x0096 }
            goto L_0x009a
        L_0x0082:
            r6 = move-exception
            r5 = r0
            goto L_0x009e
        L_0x0085:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x008d
        L_0x008a:
            r6 = move-exception
            goto L_0x009e
        L_0x008c:
            r0 = move-exception
        L_0x008d:
            r0.printStackTrace()     // Catch:{ all -> 0x008a }
            if (r5 == 0) goto L_0x009a
            r5.close()     // Catch:{ Exception -> 0x0096 }
            goto L_0x009a
        L_0x0096:
            r5 = move-exception
            r5.printStackTrace()
        L_0x009a:
            m17359b(r6)
            return
        L_0x009e:
            if (r5 == 0) goto L_0x00a8
            r5.close()     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a8
        L_0x00a4:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00a8:
            throw r6
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.effects.customwatermark.C6092e.m17357a(java.lang.String, com.introvd.template.editor.effects.customwatermark.h):void");
    }

    public static void ajZ() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DATA_PATH);
        sb.append("xywatermarks/");
        File file = new File(sb.toString(), "commonwatermark.txt");
        if (file.isFile()) {
            try {
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CommonConfigure.APP_DATA_PATH);
        sb2.append("xywatermarks/.pictures/");
        m17358an(sb2.toString(), "common");
    }

    /* renamed from: an */
    private static void m17358an(String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str2.contains(".")) {
                str2 = str2.substring(0, str2.lastIndexOf("."));
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File delete : file.listFiles(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return str.contains(str2);
                    }
                })) {
                    delete.delete();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6 A[SYNTHETIC, Splitter:B:30:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1 A[SYNTHETIC, Splitter:B:36:0x00b1] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m17359b(com.introvd.template.editor.effects.customwatermark.C6096h r4) {
        /*
            if (r4 == 0) goto L_0x00ba
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r0 = r4.cKy
            if (r0 == 0) goto L_0x00ba
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r0 = r4.cKy
            java.lang.String r0 = r0.mStylePath
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0012
            goto L_0x00ba
        L_0x0012:
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r0 = r4.cKy
            java.lang.String r0 = r0.mStylePath
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH
            r1.append(r2)
            java.lang.String r2 = "xywatermarks/.pictures/"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "common"
            r2.append(r3)
            java.lang.String r3 = "."
            int r3 = r0.lastIndexOf(r3)
            java.lang.String r3 = r0.substring(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = m17363n(r0, r1, r2)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0052
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r1 = r4.cKy
            r1.mStylePath = r0
        L_0x0052:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH
            r0.append(r1)
            java.lang.String r1 = "xywatermarks/"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0073
            r1.mkdirs()
        L_0x0073:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "commonwatermark.txt"
            r1.<init>(r0, r2)
            r0 = 0
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00a0 }
            if (r2 != 0) goto L_0x0084
            r1.createNewFile()     // Catch:{ Exception -> 0x00a0 }
        L_0x0084:
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x00a0 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a0 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00a0 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00a0 }
            r2.writeObject(r4)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            r2.flush()     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            r2.close()     // Catch:{ Exception -> 0x00aa }
            goto L_0x00ae
        L_0x0098:
            r4 = move-exception
            r0 = r2
            goto L_0x00af
        L_0x009b:
            r4 = move-exception
            r0 = r2
            goto L_0x00a1
        L_0x009e:
            r4 = move-exception
            goto L_0x00af
        L_0x00a0:
            r4 = move-exception
        L_0x00a1:
            r4.printStackTrace()     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x00ae
            r0.close()     // Catch:{ Exception -> 0x00aa }
            goto L_0x00ae
        L_0x00aa:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00ae:
            return
        L_0x00af:
            if (r0 == 0) goto L_0x00b9
            r0.close()     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b9:
            throw r4
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.effects.customwatermark.C6092e.m17359b(com.introvd.template.editor.effects.customwatermark.h):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073 A[SYNTHETIC, Splitter:B:31:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007a A[SYNTHETIC, Splitter:B:36:0x007a] */
    /* renamed from: hm */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.introvd.template.editor.effects.customwatermark.C6096h m17360hm(java.lang.String r3) {
        /*
            com.introvd.template.module.iap.h r0 = com.introvd.template.module.iap.C8049f.aBf()
            boolean r0 = r0.aBr()
            r1 = 0
            if (r0 == 0) goto L_0x001c
            com.introvd.template.module.iap.p r0 = com.introvd.template.module.iap.C8072q.aBx()
            com.introvd.template.module.iap.business.a.a r2 = com.introvd.template.module.iap.business.p349a.C7825a.USER_WATER_MARK
            java.lang.String r2 = r2.getId()
            boolean r0 = r0.mo33072ku(r2)
            if (r0 != 0) goto L_0x001c
            return r1
        L_0x001c:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0023
            return r1
        L_0x0023:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH
            r0.append(r2)
            java.lang.String r2 = "xywatermarks/"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r0, r3)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x0048
            java.lang.String r3 = "commonwatermark.txt"
            java.io.File r2 = new java.io.File
            r2.<init>(r0, r3)
        L_0x0048:
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            java.lang.Object r0 = r3.readObject()     // Catch:{ Exception -> 0x005a }
            com.introvd.template.editor.effects.customwatermark.h r0 = (com.introvd.template.editor.effects.customwatermark.C6096h) r0     // Catch:{ Exception -> 0x005a }
            r1 = r0
            goto L_0x005e
        L_0x005a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0067 }
        L_0x005e:
            r3.close()     // Catch:{ Exception -> 0x0062 }
            goto L_0x0076
        L_0x0062:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0076
        L_0x0067:
            r0 = move-exception
            goto L_0x006e
        L_0x0069:
            r0 = move-exception
            r3 = r1
            goto L_0x0078
        L_0x006c:
            r0 = move-exception
            r3 = r1
        L_0x006e:
            r0.printStackTrace()     // Catch:{ all -> 0x0077 }
            if (r3 == 0) goto L_0x0076
            r3.close()     // Catch:{ Exception -> 0x0062 }
        L_0x0076:
            return r1
        L_0x0077:
            r0 = move-exception
        L_0x0078:
            if (r3 == 0) goto L_0x0082
            r3.close()     // Catch:{ Exception -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0082:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.effects.customwatermark.C6092e.m17360hm(java.lang.String):com.introvd.template.editor.effects.customwatermark.h");
    }

    /* renamed from: hn */
    public static void m17361hn(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(CommonConfigure.APP_DATA_PATH);
            sb.append("xywatermarks/");
            File file = new File(sb.toString(), str);
            if (file.isFile()) {
                try {
                    file.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CommonConfigure.APP_DATA_PATH);
            sb2.append("xywatermarks/.pictures/");
            m17358an(sb2.toString(), str);
        }
    }

    /* renamed from: ho */
    public static String m17362ho(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty(substring) || substring.length() < 4) {
            return substring;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(substring.substring(0, substring.length() - 4));
        sb.append(".txt");
        return sb.toString();
    }

    /* renamed from: n */
    private static String m17363n(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return "";
        }
        if (str3.length() <= 4 || str.lastIndexOf(".") < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3.substring(0, str3.length() - 4));
        sb.append(str.substring(str.lastIndexOf(".")));
        String sb2 = sb.toString();
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(sb2);
        if (!FileUtils.copyFile(str, sb3.toString())) {
            return "";
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str2);
        sb4.append(sb2);
        return sb4.toString();
    }
}
