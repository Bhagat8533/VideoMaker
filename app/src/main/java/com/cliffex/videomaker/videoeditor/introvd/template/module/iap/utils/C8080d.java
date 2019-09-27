package com.introvd.template.module.iap.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* renamed from: com.introvd.template.module.iap.utils.d */
public class C8080d {
    /* renamed from: a */
    private static void m23447a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        try {
            return file.exists() && file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.io.ObjectOutputStream] */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: type inference failed for: r0v29 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v2
      assigns: []
      uses: []
      mth insns count: 57
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m23448e(java.lang.Object r2, java.lang.String r3) {
        /*
            if (r2 != 0) goto L_0x0003
            return
        L_0x0003:
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            java.io.File r3 = r0.getParentFile()
            boolean r1 = r3.exists()
            if (r1 != 0) goto L_0x0015
            r3.mkdirs()
        L_0x0015:
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x001e
            r0.delete()
        L_0x001e:
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0048, all -> 0x0045 }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0048, all -> 0x0045 }
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x003d, all -> 0x0039 }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x003d, all -> 0x0039 }
            r0.writeObject(r2)     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            r0.flush()     // Catch:{ FileNotFoundException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            m23447a(r1)
            goto L_0x0056
        L_0x0033:
            r2 = move-exception
            goto L_0x003b
        L_0x0035:
            r2 = move-exception
            goto L_0x003f
        L_0x0037:
            r2 = move-exception
            goto L_0x0043
        L_0x0039:
            r2 = move-exception
            r0 = r3
        L_0x003b:
            r3 = r1
            goto L_0x005b
        L_0x003d:
            r2 = move-exception
            r0 = r3
        L_0x003f:
            r3 = r1
            goto L_0x004a
        L_0x0041:
            r2 = move-exception
            r0 = r3
        L_0x0043:
            r3 = r1
            goto L_0x0050
        L_0x0045:
            r2 = move-exception
            r0 = r3
            goto L_0x005b
        L_0x0048:
            r2 = move-exception
            r0 = r3
        L_0x004a:
            r2.printStackTrace()     // Catch:{ all -> 0x005a }
            goto L_0x0053
        L_0x004e:
            r2 = move-exception
            r0 = r3
        L_0x0050:
            r2.printStackTrace()     // Catch:{ all -> 0x005a }
        L_0x0053:
            m23447a(r3)
        L_0x0056:
            m23447a(r0)
            return
        L_0x005a:
            r2 = move-exception
        L_0x005b:
            m23447a(r3)
            m23447a(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.module.iap.utils.C8080d.m23448e(java.lang.Object, java.lang.String):void");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r4v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v13, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.io.Closeable, java.io.ObjectInputStream] */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* JADX WARNING: type inference failed for: r4v24 */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r4v26 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v3
      assigns: []
      uses: []
      mth insns count: 71
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 15 */
    /* renamed from: lV */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object m23449lV(java.lang.String r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = r0.exists()
            r1 = 0
            if (r4 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0043, ClassNotFoundException -> 0x003c, all -> 0x0037 }
            r4.<init>(r0)     // Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0043, ClassNotFoundException -> 0x003c, all -> 0x0037 }
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0031, ClassNotFoundException -> 0x002e, all -> 0x0029 }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0031, ClassNotFoundException -> 0x002e, all -> 0x0029 }
            java.lang.Object r2 = r0.readObject()     // Catch:{ FileNotFoundException -> 0x0027, IOException -> 0x0025, ClassNotFoundException -> 0x0023 }
            m23447a(r4)
            m23447a(r0)
            r1 = r2
            goto L_0x0056
        L_0x0023:
            r2 = move-exception
            goto L_0x003f
        L_0x0025:
            r2 = move-exception
            goto L_0x0046
        L_0x0027:
            r2 = move-exception
            goto L_0x004d
        L_0x0029:
            r0 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0058
        L_0x002e:
            r2 = move-exception
            r0 = r1
            goto L_0x003f
        L_0x0031:
            r2 = move-exception
            r0 = r1
            goto L_0x0046
        L_0x0034:
            r2 = move-exception
            r0 = r1
            goto L_0x004d
        L_0x0037:
            r4 = move-exception
            r0 = r1
            r1 = r4
            r4 = r0
            goto L_0x0058
        L_0x003c:
            r2 = move-exception
            r4 = r1
            r0 = r4
        L_0x003f:
            r2.printStackTrace()     // Catch:{ all -> 0x0057 }
            goto L_0x0050
        L_0x0043:
            r2 = move-exception
            r4 = r1
            r0 = r4
        L_0x0046:
            r2.printStackTrace()     // Catch:{ all -> 0x0057 }
            goto L_0x0050
        L_0x004a:
            r2 = move-exception
            r4 = r1
            r0 = r4
        L_0x004d:
            r2.printStackTrace()     // Catch:{ all -> 0x0057 }
        L_0x0050:
            m23447a(r4)
            m23447a(r0)
        L_0x0056:
            return r1
        L_0x0057:
            r1 = move-exception
        L_0x0058:
            m23447a(r4)
            m23447a(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.module.iap.utils.C8080d.m23449lV(java.lang.String):java.lang.Object");
    }
}
