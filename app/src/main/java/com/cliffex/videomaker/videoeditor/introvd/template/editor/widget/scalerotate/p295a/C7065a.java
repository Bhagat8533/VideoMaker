package com.introvd.template.editor.widget.scalerotate.p295a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8539p;
import xiaoying.engine.base.QStyle.QAnimatedFrameTemplateInfo;
import xiaoying.engine.base.QUtils;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.editor.widget.scalerotate.a.a */
public class C7065a implements C7068c {
    /* renamed from: q */
    public Bitmap mo31043q(ScaleRotateViewState scaleRotateViewState) {
        QAnimatedFrameTemplateInfo qAnimatedFrameTemplateInfo;
        if (scaleRotateViewState == null || TextUtils.isEmpty(scaleRotateViewState.mStylePath)) {
            return null;
        }
        try {
            qAnimatedFrameTemplateInfo = QUtils.getAnimatedFrameInfo(C8501a.aJs().aJv(), scaleRotateViewState.mStylePath, new QSize(480, 480));
        } catch (StackOverflowError unused) {
            qAnimatedFrameTemplateInfo = null;
        }
        if (qAnimatedFrameTemplateInfo == null) {
            return null;
        }
        return C8539p.m24891a(scaleRotateViewState.mStylePath, qAnimatedFrameTemplateInfo.examplePos, scaleRotateViewState.mFrameWidth, scaleRotateViewState.mFrameHeight, C8501a.aJs().aJv());
    }
}
