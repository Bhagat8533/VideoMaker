package com.aiii.sdk.android.oss.common;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.aiii.sdk.android.oss.ClientConfiguration;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import com.vivavideo.mobile.h5core.refresh.H5PullHeader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OSSLogToFileUtils {
    private static final String LOG_DIR_NAME = "OSSLog";
    /* access modifiers changed from: private */
    public static long LOG_MAX_SIZE = 5242880;
    /* access modifiers changed from: private */
    public static OSSLogToFileUtils instance;
    private static LogThreadPoolManager logService = LogThreadPoolManager.newInstance();
    private static Context sContext;
    /* access modifiers changed from: private */
    public static File sLogFile;
    /* access modifiers changed from: private */
    public static SimpleDateFormat sLogSDF = new SimpleDateFormat(H5PullHeader.TIME_FORMAT);
    private boolean useSdCard = true;

    private static class WriteCall implements Runnable {
        private Object mStr;

        public WriteCall(Object obj) {
            this.mStr = obj;
        }

        private PrintWriter printEx(PrintWriter printWriter) {
            StringBuilder sb = new StringBuilder();
            sb.append("crash_time：");
            sb.append(OSSLogToFileUtils.sLogSDF.format(new Date()));
            printWriter.println(sb.toString());
            ((Throwable) this.mStr).printStackTrace(printWriter);
            return printWriter;
        }

        public void run() {
            if (OSSLogToFileUtils.sLogFile != null) {
                OSSLogToFileUtils.getInstance();
                if (OSSLogToFileUtils.getLogFileSize(OSSLogToFileUtils.sLogFile) > OSSLogToFileUtils.LOG_MAX_SIZE) {
                    OSSLogToFileUtils.getInstance().resetLogFile();
                }
                try {
                    PrintWriter printWriter = new PrintWriter(new FileWriter(OSSLogToFileUtils.sLogFile, true), true);
                    if (this.mStr instanceof Throwable) {
                        printEx(printWriter);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(OSSLogToFileUtils.getInstance().getFunctionInfo(null));
                        sb.append(" - ");
                        sb.append(this.mStr.toString());
                        printWriter.println(sb.toString());
                    }
                    printWriter.println("------>end of log");
                    printWriter.println();
                    printWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private OSSLogToFileUtils() {
    }

    /* access modifiers changed from: private */
    public String getFunctionInfo(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(RequestParameters.LEFT_BRACKETS);
        sb.append(sLogSDF.format(new Date()));
        sb.append(RequestParameters.RIGHT_BRACKETS);
        return sb.toString();
    }

    public static OSSLogToFileUtils getInstance() {
        if (instance == null) {
            synchronized (OSSLogToFileUtils.class) {
                if (instance == null) {
                    instance = new OSSLogToFileUtils();
                }
            }
        }
        return instance;
    }

    public static long getLocalLogFileSize() {
        return getLogFileSize(sLogFile);
    }

    /* access modifiers changed from: private */
    public File getLogFile() {
        File file;
        boolean z = false;
        if (!this.useSdCard || !Environment.getExternalStorageState().equals("mounted")) {
            if (readSystemSpace() > LOG_MAX_SIZE / 1024) {
                z = true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(sContext.getFilesDir().getPath());
            sb.append(File.separator);
            sb.append(LOG_DIR_NAME);
            file = new File(sb.toString());
        } else {
            if (readSDCardSpace() > LOG_MAX_SIZE / 1024) {
                z = true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Environment.getExternalStorageDirectory().getPath());
            sb2.append(File.separator);
            sb2.append(LOG_DIR_NAME);
            file = new File(sb2.toString());
        }
        File file2 = null;
        if (z) {
            if (!file.exists()) {
                file.mkdirs();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(file.getPath());
            sb3.append("/logs.csv");
            file2 = new File(sb3.toString());
            if (!file2.exists()) {
                createNewFile(file2);
            }
        }
        return file2;
    }

    public static long getLogFileSize(File file) {
        if (file == null || !file.exists()) {
            return 0;
        }
        return file.length();
    }

    public static void init(Context context, ClientConfiguration clientConfiguration) {
        OSSLog.logDebug("init ...", false);
        if (clientConfiguration != null) {
            LOG_MAX_SIZE = clientConfiguration.getMaxLogSize();
        }
        if (sContext == null || instance == null || sLogFile == null || !sLogFile.exists()) {
            sContext = context.getApplicationContext();
            instance = getInstance();
            logService.addExecuteTask(new Runnable() {
                public void run() {
                    OSSLogToFileUtils.sLogFile = OSSLogToFileUtils.instance.getLogFile();
                    if (OSSLogToFileUtils.sLogFile != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("LogFilePath is: ");
                        sb.append(OSSLogToFileUtils.sLogFile.getPath());
                        OSSLog.logInfo(sb.toString(), false);
                        if (OSSLogToFileUtils.LOG_MAX_SIZE < OSSLogToFileUtils.getLogFileSize(OSSLogToFileUtils.sLogFile)) {
                            OSSLog.logInfo("init reset log file", false);
                            OSSLogToFileUtils.instance.resetLogFile();
                        }
                    }
                }
            });
            return;
        }
        OSSLog.logDebug("LogToFileUtils has been init ...", false);
    }

    private long readSDCardSpace() {
        long j;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            j = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } else {
            j = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sd卡存储空间:");
        sb.append(String.valueOf(j));
        sb.append("kb");
        OSSLog.logDebug(sb.toString(), false);
        return j;
    }

    private long readSystemSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        long availableBlocks = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024;
        StringBuilder sb = new StringBuilder();
        sb.append("内部存储空间:");
        sb.append(String.valueOf(availableBlocks));
        sb.append("kb");
        OSSLog.logDebug(sb.toString(), false);
        return availableBlocks;
    }

    public static void reset() {
        sContext = null;
        instance = null;
        sLogFile = null;
    }

    public void createNewFile(File file) {
        try {
            file.createNewFile();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Create log file failure !!! ");
            sb.append(e.toString());
            OSSLog.logError(sb.toString(), false);
        }
    }

    public void deleteLogFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(sLogFile.getParent());
        sb.append("/logs.csv");
        File file = new File(sb.toString());
        if (file.exists()) {
            OSSLog.logDebug("delete Log File ... ", false);
            file.delete();
        }
    }

    public void deleteLogFileDir() {
        deleteLogFile();
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        sb.append(File.separator);
        sb.append(LOG_DIR_NAME);
        File file = new File(sb.toString());
        if (file.exists()) {
            OSSLog.logDebug("delete Log FileDir ... ", false);
            file.delete();
        }
    }

    public void resetLogFile() {
        OSSLog.logDebug("Reset Log File ... ", false);
        if (!sLogFile.getParentFile().exists()) {
            OSSLog.logDebug("Reset Log make File dir ... ", false);
            sLogFile.getParentFile().mkdir();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sLogFile.getParent());
        sb.append("/logs.csv");
        File file = new File(sb.toString());
        if (file.exists()) {
            file.delete();
        }
        createNewFile(file);
    }

    public void setUseSdCard(boolean z) {
        this.useSdCard = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void write(java.lang.Object r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = com.aiii.sdk.android.oss.common.OSSLog.isEnableLog()     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002c
            android.content.Context r0 = sContext     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002a
            com.aiii.sdk.android.oss.common.OSSLogToFileUtils r0 = instance     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002a
            java.io.File r0 = sLogFile     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0014
            goto L_0x002a
        L_0x0014:
            java.io.File r0 = sLogFile     // Catch:{ all -> 0x002e }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x001f
            r1.resetLogFile()     // Catch:{ all -> 0x002e }
        L_0x001f:
            com.aiii.sdk.android.oss.common.OSSLogToFileUtils$WriteCall r0 = new com.aiii.sdk.android.oss.common.OSSLogToFileUtils$WriteCall     // Catch:{ all -> 0x002e }
            r0.<init>(r2)     // Catch:{ all -> 0x002e }
            com.aiii.sdk.android.oss.common.LogThreadPoolManager r2 = logService     // Catch:{ all -> 0x002e }
            r2.addExecuteTask(r0)     // Catch:{ all -> 0x002e }
            goto L_0x002c
        L_0x002a:
            monitor-exit(r1)
            return
        L_0x002c:
            monitor-exit(r1)
            return
        L_0x002e:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.sdk.android.oss.common.OSSLogToFileUtils.write(java.lang.Object):void");
    }
}
