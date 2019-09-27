package com.introvd.template.editor.p266h;

import android.os.Process;
import android.text.TextUtils;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.introvd.template.editor.h.q */
public class C6412q extends Thread {
    public void execute() {
        start();
    }

    public void run() {
        try {
            Process.setThreadPriority(10);
            FileUtils.deleteFolderSubFiles(CommonConfigure.APP_DATA_PATH_INNER, new FilenameFilter() {
                public boolean accept(File file, String str) {
                    if (TextUtils.indexOf(str, "XiaoYing_tmp_editor_") != 0) {
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("TmpFileDelTask filename:");
                    sb.append(str);
                    LogUtils.m14223i("TmpFileDelTask", sb.toString());
                    return true;
                }
            });
        } catch (Throwable th) {
            LogUtils.m14223i("TmpFileDelTask", th.getMessage());
        }
        super.run();
    }
}
