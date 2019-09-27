package com.introvd.template.editor.widget.scalerotate.p295a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8530i;

/* renamed from: com.introvd.template.editor.widget.scalerotate.a.d */
public class C7069d implements C7068c {
    private MSize csP;

    public C7069d(MSize mSize) {
        this.csP = mSize;
    }

    /* renamed from: q */
    public Bitmap mo31043q(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState == null || TextUtils.isEmpty(scaleRotateViewState.mStylePath) || this.csP == null) {
            return null;
        }
        return C8530i.m24757b(C8501a.aJs().aJv(), scaleRotateViewState, scaleRotateViewState.mStylePath, new VeMSize(this.csP.width, this.csP.height));
    }
}
