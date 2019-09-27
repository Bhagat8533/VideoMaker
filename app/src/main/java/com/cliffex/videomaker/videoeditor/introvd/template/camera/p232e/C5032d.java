package com.introvd.template.camera.p232e;

import android.os.Process;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.FileUtils;
import java.io.File;

/* renamed from: com.introvd.template.camera.e.d */
public class C5032d {
    /* access modifiers changed from: private */
    public boolean bMx = false;

    /* renamed from: YQ */
    public void mo25886YQ() {
        try {
            new ExAsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    try {
                        Process.setThreadPriority(10);
                    } catch (Exception unused) {
                    }
                    try {
                        String mediaSavePath = CommonConfigure.getMediaSavePath();
                        String[] list = new File(mediaSavePath).list();
                        if (list == null) {
                            return null;
                        }
                        int i = 0;
                        while (true) {
                            if (i >= list.length) {
                                break;
                            }
                            while (C5032d.this.bMx) {
                                Thread.sleep(500);
                            }
                            if (isCancelled()) {
                                break;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(CommonConfigure.APP_PROJECT_PATH);
                            sb.append(list[i]);
                            sb.append(".prj");
                            if (!FileUtils.isFileExisted(sb.toString())) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(mediaSavePath);
                                sb2.append(list[i]);
                                try {
                                    File file = new File(sb2.toString());
                                    String[] list2 = file.list();
                                    int length = list2 != null ? list2.length : 0;
                                    if (file.isDirectory() && length == 0 && file.lastModified() <= System.currentTimeMillis() - 86400000) {
                                        file.delete();
                                    }
                                } catch (Exception unused2) {
                                }
                            }
                            i++;
                        }
                        return null;
                    } catch (Exception unused3) {
                    }
                }
            }.execute((Params[]) new Void[0]);
        } catch (Exception unused) {
        }
    }
}
