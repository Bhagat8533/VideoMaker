package com.introvd.template.explorer.p298c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.explorer.C7138b;
import com.introvd.template.explorer.p300e.C7208b;
import com.introvd.template.explorer.p300e.C7210c;
import com.introvd.template.explorer.p308ui.C7344b;
import com.introvd.template.explorer.p308ui.C7344b.C7346a;
import com.introvd.template.videoeditor.model.MediaItem;
import com.introvd.template.vivaexplorermodule.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.introvd.template.explorer.c.b */
public class C7142b {
    private static final int dzk = ((Runtime.getRuntime().availableProcessors() * 3) + 2);
    private static final String dzn = Environment.getExternalStorageDirectory().getAbsolutePath();
    private static final String dzo;
    private static final String dzp;
    private static final String dzq;
    private static final String dzr;
    private static final String dzs;
    private int dyE = 1;
    public C7147a dyS;
    /* access modifiers changed from: private */
    public List<File> dzl = new ArrayList();
    private int dzm = 0;
    private C7148b dzt = new C7148b(this);
    /* access modifiers changed from: private */
    public C7344b dzu;
    private boolean dzv = true;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.explorer.c.b$a */
    public interface C7147a {
        void awr();
    }

    /* renamed from: com.introvd.template.explorer.c.b$b */
    private static class C7148b extends Handler {
        private final WeakReference<C7142b> mContextRef;

        public C7148b(C7142b bVar) {
            this.mContextRef = new WeakReference<>(bVar);
        }

        public void handleMessage(Message message) {
            C7142b bVar = (C7142b) this.mContextRef.get();
            if (bVar != null) {
                switch (message.what) {
                    case 2:
                        if (bVar.dzu != null) {
                            bVar.dzu.mo31990ra(R.drawable.xiaoying_com_scanning_finish);
                            bVar.dzu.mo31987jq(bVar.mContext.getResources().getQuantityString(R.plurals.xiaoying_str_ve_gallery_file_found_plurals, bVar.dzl.size(), new Object[]{Integer.valueOf(bVar.dzl.size())}));
                            bVar.dzu.setButtonText(R.string.xiaoying_str_com_done);
                            break;
                        }
                        break;
                    case 3:
                        removeMessages(3);
                        String str = (String) message.obj;
                        if (bVar.dzu != null) {
                            bVar.dzu.mo31987jq(str);
                            break;
                        }
                        break;
                }
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(dzn);
        sb.append("/Android/data/");
        sb.append(CommonConfigure.APP_PACKAGE_FULLNAME);
        dzo = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dzn);
        sb2.append("/");
        sb2.append(CommonConfigure.APP_PACKAGE_NAME);
        dzp = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(CommonConfigure.APP_PACKAGE_NAME);
        sb3.append("/Music");
        dzq = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(CommonConfigure.APP_PACKAGE_NAME);
        sb4.append("/Videos");
        dzr = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(CommonConfigure.APP_PACKAGE_NAME);
        sb5.append("/Templates");
        dzs = sb5.toString();
    }

    public C7142b(Context context, int i, C7147a aVar) {
        this.mContext = context;
        this.dyE = i;
        this.dyS = aVar;
    }

    private void awv() {
        mo31601hX(true);
        if (this.dzu != null) {
            this.dzu.dismiss();
        }
        this.dzu = new C7344b(this.mContext, new C7346a() {
            public void awx() {
                if (!C7142b.this.aww()) {
                    C7142b.this.mo31601hX(false);
                } else if (C7142b.this.dyS != null) {
                    C7142b.this.dyS.awr();
                }
            }
        });
        this.dzu.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (!C7142b.this.aww()) {
                    C7142b.this.mo31601hX(false);
                } else if (C7142b.this.dyS != null) {
                    C7142b.this.dyS.awr();
                }
            }
        });
        this.dzu.setButtonText(R.string.xiaoying_str_com_cancel);
        this.dzu.show();
    }

    /* access modifiers changed from: private */
    public boolean aww() {
        return this.dzm == 0;
    }

    /* renamed from: b */
    private boolean m21109b(String str, String[] strArr) {
        String fileType = FileUtils.getFileType(str);
        if (TextUtils.isEmpty(fileType)) {
            return false;
        }
        for (String equalsIgnoreCase : strArr) {
            if (fileType.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ja */
    private boolean m21112ja(String str) {
        return str.contains("/.");
    }

    /* renamed from: qB */
    private List<String> m21113qB(int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 4) {
            return C7210c.aya();
        }
        if (i != 6) {
            switch (i) {
                case 1:
                    return C7210c.axY();
                case 2:
                    return C7210c.axZ();
                default:
                    return arrayList;
            }
        } else {
            List axZ = C7210c.axZ();
            List bV = C7210c.m21293bV(axZ);
            arrayList.addAll(axZ);
            arrayList.addAll(bV);
            return arrayList;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: qC */
    public synchronized void m21114qC(int i) {
        this.dzm += i;
        if (this.dzm == 0 && this.dzt != null) {
            this.dzt.sendMessage(this.dzt.obtainMessage(2));
        }
    }

    /* renamed from: x */
    private boolean m21115x(String str, int i) {
        boolean z = false;
        if (i != 4) {
            if (i != 6) {
                switch (i) {
                    case 1:
                        if (m21109b(str, C7138b.avQ())) {
                            return true;
                        }
                        break;
                    case 2:
                        if (m21109b(str, C7138b.avP())) {
                            return true;
                        }
                        break;
                }
            } else {
                if (m21109b(str, C7138b.avO()) || m21109b(str, C7138b.avP())) {
                    z = true;
                }
                return z;
            }
        } else if (m21109b(str, C7138b.avO())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m21116y(File file) {
        this.dzt.sendMessage(this.dzt.obtainMessage(3, file.getPath()));
        if (this.dzv && !mo31602x(file) && file.exists()) {
            if (file.isFile() && file.length() > 100) {
                if (m21115x(file.getName(), this.dyE)) {
                    m21117z(file);
                }
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File y : listFiles) {
                        m21116y(y);
                    }
                }
            }
        }
    }

    /* renamed from: z */
    private synchronized void m21117z(File file) {
        if (this.dzl != null) {
            MediaItem mediaItem = new MediaItem();
            mediaItem.path = file.getAbsolutePath();
            if (C7208b.m21287c(this.mContext, mediaItem, 7)) {
                C7149c.m21129a(this.mContext, mediaItem, C7208b.m21291ju(mediaItem.path));
                this.dzl.add(file);
            }
        }
    }

    public void awl() {
        this.dzl.clear();
        List<String> qB = m21113qB(this.dyE);
        this.dzm = qB.size();
        boolean z = this.dzm > 0;
        awv();
        if (z) {
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(dzk);
            for (final String str : qB) {
                newFixedThreadPool.execute(new Runnable() {
                    public void run() {
                        try {
                            C7142b.this.m21116y(new File(str));
                            C7142b.this.m21114qC(-1);
                        } catch (Exception e) {
                            e.printStackTrace();
                            C7142b.this.m21114qC(-1);
                        }
                    }
                });
            }
        } else if (this.dzt != null) {
            this.dzt.sendMessage(this.dzt.obtainMessage(2));
        }
    }

    /* renamed from: bO */
    public void mo31600bO(List<String> list) {
        this.dzl.clear();
        this.dzm = list.size();
        if (this.dzm > 0) {
            awv();
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(dzk);
            for (final String str : list) {
                newFixedThreadPool.execute(new Runnable() {
                    public void run() {
                        try {
                            C7142b.this.m21116y(new File(str));
                            C7142b.this.m21114qC(-1);
                        } catch (Exception e) {
                            e.printStackTrace();
                            C7142b.this.m21114qC(-1);
                        }
                    }
                });
            }
            return;
        }
        ToastUtils.show(this.mContext, this.mContext.getString(R.string.xiaoying_str_ve_gallery_selected_dir_or_file), 0);
    }

    /* renamed from: hX */
    public void mo31601hX(boolean z) {
        this.dzv = z;
    }

    /* renamed from: x */
    public boolean mo31602x(File file) {
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            if (!absolutePath.contains(dzr) && (absolutePath.contains(dzo) || absolutePath.contains(dzp) || absolutePath.contains("/secure") || absolutePath.contains("/asec") || absolutePath.contains("/obb") || absolutePath.contains("/legacy") || absolutePath.contains(dzq) || absolutePath.contains(dzs) || m21112ja(absolutePath))) {
                return true;
            }
        }
        return false;
    }
}
