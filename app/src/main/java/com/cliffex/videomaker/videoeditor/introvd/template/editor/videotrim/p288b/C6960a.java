package com.introvd.template.editor.videotrim.p288b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.FileUtils;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.C8564s;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8537n;
import xiaoying.engine.QEngine;
import xiaoying.engine.clip.QClip;

@SuppressLint({"UseValueOf"})
/* renamed from: com.introvd.template.editor.videotrim.b.a */
public class C6960a extends ExAsyncTask<Void, Void, Bitmap> {
    private int aeD = 0;
    private TrimedClipItemDataModel dpt;
    private QClip dpu = null;
    private boolean dpv = false;
    private Handler mHandler;

    public C6960a(TrimedClipItemDataModel trimedClipItemDataModel, int i, QEngine qEngine, Handler handler) {
        this.dpt = trimedClipItemDataModel;
        this.dpv = FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath);
        if (this.dpv) {
            this.dpu = C8537n.m24824f(trimedClipItemDataModel.mExportPath, qEngine);
        } else {
            this.dpu = C8537n.m24824f(trimedClipItemDataModel.mRawFilePath, qEngine);
        }
        this.aeD = i;
        this.mHandler = handler;
    }

    /* renamed from: s */
    private Long m20326s(Bitmap bitmap) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        C8564s.aJi().mo34803a(valueOf, bitmap);
        return valueOf;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Bitmap doInBackground(Void... voidArr) {
        Bitmap bitmap;
        if (this.dpt == null || this.dpu == null) {
            bitmap = null;
        } else {
            VeRange veRange = this.dpt.mVeRangeInRawVideo;
            if (this.dpt.mRotate.intValue() > 0) {
                this.dpu.setProperty(12315, Integer.valueOf(this.dpt.mRotate.intValue()));
            } else {
                this.dpu.setProperty(12315, new Integer(0));
            }
            if (this.dpt.bCrop.booleanValue()) {
                this.dpu.setProperty(12295, new Integer(65538));
            } else {
                this.dpu.setProperty(12295, new Integer(1));
            }
            int dI = C8572y.m25087dI(this.aeD, 4);
            bitmap = (Bitmap) C8572y.m25066a(this.dpu, this.dpv ? 0 : veRange.getmPosition(), dI, dI, true, false, 65538, true, false);
            this.dpt.mThumbKey = m20326s(bitmap);
        }
        if (this.dpv && this.dpu != null) {
            this.dpu.unInit();
            this.dpu = null;
        }
        return bitmap;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (!(bitmap == null || this.dpt == null || bitmap.isRecycled())) {
            this.dpt.mThumbnail = bitmap;
        }
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(1048577);
            obtainMessage.obj = this.dpt;
            this.mHandler.sendMessage(obtainMessage);
        }
    }
}
