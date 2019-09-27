package com.introvd.template.editor.gallery;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.videotrim.p288b.C6962c;
import com.introvd.template.editor.videotrim.p288b.C6963d;
import com.introvd.template.editor.videotrim.p288b.C6965e;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.C8545d;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.ironsource.sdk.controller.BannerJSAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.gallery.c */
public class C6345c {
    /* access modifiers changed from: private */
    public static WeakReference<Context> cSY;
    private C6963d cSU;
    /* access modifiers changed from: private */
    public volatile List<TrimedClipItemDataModel> cSV;
    /* access modifiers changed from: private */
    public volatile Object cSW = new Object();
    /* access modifiers changed from: private */
    public volatile boolean cSX = false;
    /* access modifiers changed from: private */
    public volatile Map<String, List<TrimedClipItemDataModel>> cSZ;
    /* access modifiers changed from: private */
    public volatile boolean cTa = true;
    private volatile boolean cTb = false;
    /* access modifiers changed from: private */
    public volatile C1495b cTc;
    private C6965e cTd = new C6965e() {
        /* renamed from: aU */
        public void mo29355aU(List<TrimedClipItemDataModel> list) {
            C4596h.m11717Sq();
            C6345c.this.cSV = list;
            C6345c.this.cSX = true;
            C6345c.this.amI();
            StringBuilder sb = new StringBuilder();
            sb.append("service run locknotify=");
            sb.append(Thread.currentThread().getName());
            LogUtilsV2.m14230i(sb.toString());
            synchronized (C6345c.this.cSW) {
                C6345c.this.cSW.notify();
            }
        }

        /* renamed from: aV */
        public void mo29356aV(List<TrimedClipItemDataModel> list) {
            C4596h.m11717Sq();
            String[] strArr = new String[list.size()];
            int i = 0;
            for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                if (FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                    int i2 = i + 1;
                    strArr[i] = trimedClipItemDataModel.mExportPath;
                    trimedClipItemDataModel.mExportPath = "";
                    i = i2;
                }
            }
            FileUtils.deleteFiles(strArr);
            C6345c.this.cSX = false;
            C6345c.this.amI();
            StringBuilder sb = new StringBuilder();
            sb.append("service cancel locknotify=");
            sb.append(Thread.currentThread().getName());
            LogUtilsV2.m14230i(sb.toString());
            synchronized (C6345c.this.cSW) {
                C6345c.this.cSW.notify();
            }
        }

        public void amb() {
            StringBuilder sb = new StringBuilder();
            sb.append("onProducerReleased bExportSuc=");
            sb.append(C6345c.this.cSX);
            LogUtilsV2.m14230i(sb.toString());
        }

        /* renamed from: b */
        public void mo29358b(TrimedClipItemDataModel trimedClipItemDataModel) {
            Context context = (Context) C6345c.cSY.get();
            if (context != null) {
                Intent intent = new Intent("com.quvideo.vivavideo.xyeditor.transcode.secondaryupdate");
                intent.putExtra("progress", 20);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        }

        /* renamed from: c */
        public void mo29359c(TrimedClipItemDataModel trimedClipItemDataModel) {
            StringBuilder sb = new StringBuilder();
            sb.append("service run onExportItemFail timeout =");
            sb.append(Thread.currentThread().getName());
            LogUtilsV2.m14230i(sb.toString());
            Intent intent = new Intent("com.quvideo.vivavideo.xyeditor.transcode.update");
            intent.putExtra("result", BannerJSAdapter.FAIL);
            intent.putExtra("rawpath", trimedClipItemDataModel.mRawFilePath);
            List list = (List) C6345c.this.cSZ.get(trimedClipItemDataModel.mRawFilePath);
            intent.putExtra(SocialConstDef.SEARCH_HISTORY_COUNT, list == null ? 0 : list.size());
            LocalBroadcastManager.getInstance((Context) C6345c.cSY.get()).sendBroadcast(intent);
        }

        /* renamed from: d */
        public void mo29360d(TrimedClipItemDataModel trimedClipItemDataModel) {
            Context context = (Context) C6345c.cSY.get();
            if (context != null) {
                if (trimedClipItemDataModel.mStreamSizeVe != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(trimedClipItemDataModel.mStreamSizeVe.width);
                    sb.append("x");
                    sb.append(trimedClipItemDataModel.mStreamSizeVe.height);
                    C6344b.m18177bx(context, sb.toString());
                    long currentTimeMillis = System.currentTimeMillis() - C6345c.this.startTime;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(currentTimeMillis);
                    C6344b.m18178by(context, sb2.toString());
                    C6345c.this.startTime = System.currentTimeMillis();
                }
                Intent intent = new Intent("com.quvideo.vivavideo.xyeditor.transcode.update");
                intent.putExtra("result", "suc");
                intent.putExtra("rawpath", trimedClipItemDataModel.mRawFilePath);
                List list = (List) C6345c.this.cSZ.get(trimedClipItemDataModel.mRawFilePath);
                intent.putExtra(SocialConstDef.SEARCH_HISTORY_COUNT, list == null ? 0 : list.size());
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("service run onExportItemSuc timeout =");
                sb3.append(Thread.currentThread().getName());
                sb3.append("$$$$ ");
                sb3.append(trimedClipItemDataModel.mRawFilePath);
                LogUtilsV2.m14230i(sb3.toString());
            }
        }

        /* renamed from: d */
        public void mo29361d(List<TrimedClipItemDataModel> list, String str) {
            C4596h.m11717Sq();
            String[] strArr = new String[list.size()];
            int i = 0;
            for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                if (FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                    int i2 = i + 1;
                    strArr[i] = trimedClipItemDataModel.mExportPath;
                    trimedClipItemDataModel.mExportPath = "";
                    i = i2;
                }
            }
            FileUtils.deleteFiles(strArr);
            C6345c.this.amI();
            C6345c.this.cSX = false;
            StringBuilder sb = new StringBuilder();
            sb.append("service run fail locknotify=");
            sb.append(Thread.currentThread().getName());
            LogUtilsV2.m14230i(sb.toString());
            synchronized (C6345c.this.cSW) {
                C6345c.this.cSW.notify();
            }
        }

        public void onProgress(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onProgress progress=");
            sb.append(i);
            LogUtilsV2.m14230i(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("service onProgress locknotify=");
            sb2.append(Thread.currentThread().getName());
            LogUtilsV2.m14230i(sb2.toString());
            Context context = (Context) C6345c.cSY.get();
            if (context != null) {
                Intent intent = new Intent("com.quvideo.vivavideo.xyeditor.transcode.secondaryupdate");
                intent.putExtra("progress", ((i * 80) / 100) + 20);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile long startTime = 0;

    public C6345c(Context context) {
        cSY = new WeakReference<>(context);
    }

    /* renamed from: J */
    private List<TrimedClipItemDataModel> m18188J(Map<String, List<TrimedClipItemDataModel>> map) {
        ArrayList arrayList = new ArrayList();
        if (map == null) {
            return arrayList;
        }
        for (String str : map.keySet()) {
            List<TrimedClipItemDataModel> list = (List) map.get(str);
            if (list != null && list.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                TrimedClipItemDataModel trimedClipItemDataModel = null;
                for (TrimedClipItemDataModel trimedClipItemDataModel2 : list) {
                    arrayList2.add(new VeRange(trimedClipItemDataModel2.mVeRangeInRawVideo));
                    if (trimedClipItemDataModel == null) {
                        trimedClipItemDataModel = new TrimedClipItemDataModel();
                        trimedClipItemDataModel.mRawFilePath = trimedClipItemDataModel2.mRawFilePath;
                        trimedClipItemDataModel.mStreamSizeVe = trimedClipItemDataModel2.mStreamSizeVe;
                        trimedClipItemDataModel.mEncType = trimedClipItemDataModel2.mEncType;
                        trimedClipItemDataModel.bNeedTranscode = trimedClipItemDataModel2.bNeedTranscode;
                        trimedClipItemDataModel.bCropFeatureEnable = Boolean.valueOf(false);
                        if (C6348d.amK().amL() == 1) {
                            trimedClipItemDataModel.mRotate = trimedClipItemDataModel2.mRotate;
                        }
                    }
                }
                VeRange aT = m18197aT(arrayList2);
                if (trimedClipItemDataModel != null) {
                    trimedClipItemDataModel.mVeRangeInRawVideo = new VeRange(aT);
                }
                arrayList.add(trimedClipItemDataModel);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m18194a(Map<String, List<TrimedClipItemDataModel>> map, List<TrimedClipItemDataModel> list) {
        if (list != null) {
            for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                if (trimedClipItemDataModel.isExported.booleanValue() && map.containsKey(trimedClipItemDataModel.mRawFilePath)) {
                    for (TrimedClipItemDataModel trimedClipItemDataModel2 : (List) map.get(trimedClipItemDataModel.mRawFilePath)) {
                        trimedClipItemDataModel2.mExportPath = trimedClipItemDataModel.mExportPath;
                        int i = trimedClipItemDataModel.mVeRangeInRawVideo.getmPosition();
                        int i2 = trimedClipItemDataModel2.mVeRangeInRawVideo.getmPosition();
                        if (i < i2) {
                            trimedClipItemDataModel2.mVeRangeInRawVideo.setmPosition(i2 - i);
                        }
                        trimedClipItemDataModel2.isExported = Boolean.valueOf(true);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m18195a(ContentResolver contentResolver, String str, TrimedClipItemDataModel trimedClipItemDataModel) {
        LogUtilsV2.m14228e("imgTranscode in");
        String str2 = trimedClipItemDataModel.mRawFilePath;
        if (!TextUtils.equals(str2, trimedClipItemDataModel.mExportPath) && !TextUtils.isEmpty(trimedClipItemDataModel.mExportPath)) {
            return false;
        }
        if (!str2.endsWith(".gif")) {
            str2 = C8545d.m24986e(str2, C8572y.m25097ou(str), true);
        }
        trimedClipItemDataModel.mExportPath = str2;
        LogUtilsV2.m14228e("imgTranscode out");
        return true;
    }

    /* renamed from: aT */
    private VeRange m18197aT(List<VeRange> list) {
        int i = -1;
        int i2 = -1;
        for (VeRange veRange : list) {
            if (veRange != null) {
                if (i < 0) {
                    i = veRange.getmPosition();
                } else if (veRange.getmPosition() < i) {
                    i = veRange.getmPosition();
                }
                if (i2 < 0) {
                    i2 = veRange.getLimitValue();
                } else if (i2 < veRange.getLimitValue()) {
                    i2 = veRange.getLimitValue();
                }
            }
        }
        return new VeRange(i, i2 - i);
    }

    /* access modifiers changed from: private */
    public void amI() {
        if (this.cSU != null) {
            this.cSU.release();
            this.cSU = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hV */
    public void m18203hV(String str) {
        Context context = (Context) cSY.get();
        if (context != null) {
            ArrayList<TrimedClipItemDataModel> arrayList = new ArrayList<>(C6348d.amK().amO());
            this.cSZ = new HashMap();
            for (TrimedClipItemDataModel trimedClipItemDataModel : arrayList) {
                if (trimedClipItemDataModel.isImage.booleanValue()) {
                    if (!this.cTb) {
                        if (m18195a(context.getContentResolver(), str, trimedClipItemDataModel)) {
                            Intent intent = new Intent("com.quvideo.vivavideo.xyeditor.transcode.update");
                            intent.putExtra("result", "suc");
                            intent.putExtra("rawpath", trimedClipItemDataModel.mRawFilePath);
                            intent.putExtra(SocialConstDef.SEARCH_HISTORY_COUNT, trimedClipItemDataModel.repeatCount);
                            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                        }
                    } else {
                        return;
                    }
                } else if (trimedClipItemDataModel.bNeedTranscode && TextUtils.isEmpty(trimedClipItemDataModel.mExportPath)) {
                    if (this.cSZ.containsKey(trimedClipItemDataModel.mRawFilePath)) {
                        ((List) this.cSZ.get(trimedClipItemDataModel.mRawFilePath)).add(trimedClipItemDataModel);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(trimedClipItemDataModel);
                        this.cSZ.put(trimedClipItemDataModel.mRawFilePath, arrayList2);
                    }
                }
            }
            List J = m18188J(this.cSZ);
            if (J.size() <= 0) {
                if (!this.cTb) {
                    LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.quvideo.vivavideo.xyeditor.transcode.done"));
                }
            } else if (!this.cTb) {
                this.cSU = new C6963d(context, J, C8501a.aJs().aJv(), str);
                this.cSU.dpE = false;
                this.cSU.dpD = false;
                this.cSU.mo30626a((C6962c) this.cTd);
                this.startTime = System.currentTimeMillis();
                if (!this.cSU.auu()) {
                    LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.quvideo.vivavideo.xyeditor.transcode.done"));
                    return;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("service run lockwait=");
                    sb.append(Thread.currentThread().getName());
                    LogUtilsV2.m14230i(sb.toString());
                    synchronized (this.cSW) {
                        this.cSW.wait();
                    }
                    if (!this.cTb) {
                        m18194a(this.cSZ, this.cSV);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("service run lockwait timeout =");
                        sb2.append(Thread.currentThread().getName());
                        LogUtilsV2.m14230i(sb2.toString());
                        if (!this.cTb) {
                            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.quvideo.vivavideo.xyeditor.transcode.done"));
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("service run bExportSuc=");
                            sb3.append(this.cSX);
                            LogUtilsV2.m14230i(sb3.toString());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void amH() {
        LogUtilsV2.m14228e("cancelTranscode in");
        this.cTb = true;
        if (this.cSU != null) {
            this.cSU.alW();
            this.cSU = null;
        }
        if (this.cTc != null) {
            this.cTc.dispose();
            this.cTc = null;
        }
        LogUtilsV2.m14228e("cancelTranscode out");
    }

    /* renamed from: hU */
    public boolean mo29352hU(final String str) {
        Context context = (Context) cSY.get();
        if (context == null || !this.cTa) {
            return false;
        }
        if (!C6386d.asR()) {
            ToastUtils.show(context, context.getResources().getString(R.string.xiaoying_str_com_msg_low_diskspace_warning), 0);
            return false;
        }
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                LogUtilsV2.m14230i("onSubscribe");
                C6345c.this.cTc = bVar;
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                LogUtilsV2.m14230i("onNext");
                C6345c.this.m18203hV(str);
                C6345c.this.cTa = true;
                LogUtilsV2.m14230i("onNext done");
            }

            public void onComplete() {
                LogUtilsV2.m14230i("onComplete");
            }

            public void onError(Throwable th) {
                LogUtilsV2.m14230i("onError");
            }
        });
        return true;
    }

    public void release() {
        if (!this.cTb) {
            amH();
        }
        if (this.cSV != null) {
            this.cSV.clear();
            this.cSV = null;
        }
        if (this.cSZ != null) {
            this.cSZ.clear();
            this.cSZ = null;
        }
    }
}
