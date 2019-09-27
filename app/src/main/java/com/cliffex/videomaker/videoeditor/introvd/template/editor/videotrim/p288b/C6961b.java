package com.introvd.template.editor.videotrim.p288b;

import android.os.Handler;
import android.os.Message;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.LogUtils;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.introvd.template.editor.videotrim.b.b */
public class C6961b extends ExAsyncTask<Void, Void, Boolean> {
    private WeakReference<C8522g> csY = null;
    private WeakReference<C8501a> cta = null;
    private ArrayList<TrimedClipItemDataModel> cuo = null;
    private boolean dpw = false;
    private Handler mHandler = null;

    public C6961b(C8522g gVar, C8501a aVar, Handler handler, ArrayList<TrimedClipItemDataModel> arrayList, boolean z) {
        this.csY = new WeakReference<>(gVar);
        this.cta = new WeakReference<>(aVar);
        this.dpw = z;
        this.mHandler = handler;
        this.cuo = arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean doInBackground(Void... voidArr) {
        if (this.cuo == null || this.cuo.size() <= 0) {
            LogUtils.m14223i("InsertClipsToPrjTask_TAG", "import video no clip transcoded -->");
        } else {
            C8522g gVar = (C8522g) this.csY.get();
            if (gVar != null) {
                gVar.aJC();
                boolean z = gVar.aHd() != null;
                StringBuilder sb = new StringBuilder();
                sb.append("import video clip transcoded bValidStoryboard=");
                sb.append(z);
                sb.append("  -->");
                LogUtils.m14223i("InsertClipsToPrjTask_TAG", sb.toString());
                if (z) {
                    int size = this.cuo.size();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("import video doInBackground insertEffect file count size=");
                    sb2.append(size);
                    sb2.append("-->");
                    LogUtils.m14223i("InsertClipsToPrjTask_TAG", sb2.toString());
                    boolean z2 = false;
                    for (int i = 0; i < size; i++) {
                        TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) this.cuo.get(i);
                        if (trimedClipItemDataModel != null) {
                            trimedClipItemDataModel.bCropFeatureEnable = Boolean.valueOf(trimedClipItemDataModel.bCropFeatureEnable.booleanValue() && !this.dpw);
                            if (gVar.mo34724a(trimedClipItemDataModel, (C8501a) this.cta.get(), i, true) == 0) {
                                z2 = true;
                            }
                        }
                    }
                    return Boolean.valueOf(z2);
                }
            }
        }
        return Boolean.valueOf(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        LogUtils.m14223i("InsertClipsToPrjTask_TAG", "import video onpostexecute -->");
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(2097168);
            obtainMessage.arg1 = bool.booleanValue() ? 1 : 0;
            this.mHandler.sendMessage(obtainMessage);
        }
    }
}
