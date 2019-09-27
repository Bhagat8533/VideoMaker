package com.introvd.template.editor.effects.bubble.subtitle.p256a;

import android.content.Context;
import android.view.MotionEvent;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p266h.C6408m;
import com.introvd.template.p414ui.dialog.C8950d;
import com.introvd.template.p414ui.dialog.C8950d.C8955b;
import com.introvd.template.p414ui.dialog.C8950d.C8956c;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.utils.C8562q;

/* renamed from: com.introvd.template.editor.effects.bubble.subtitle.a.b */
public class C6002b extends BaseController<C6001a> {
    private C8950d cIV;
    /* access modifiers changed from: private */
    public Context context;
    private C8956c cxJ = new C8956c() {
        /* renamed from: a */
        public void mo27683a(int i, CharSequence charSequence) {
            if (i == 1) {
                ((C6001a) C6002b.this.getMvpView()).mo28645hk(charSequence.toString());
            }
        }
    };
    private C8955b cxK = new C8955b() {
        /* renamed from: gv */
        public boolean mo27669gv(String str) {
            if (C6408m.m18454iO(str)) {
                return true;
            }
            ToastUtils.show(C6002b.this.context, R.string.xiaoying_str_ve_msg_no_valid_char, 0);
            return false;
        }
    };

    /* renamed from: a */
    public void mo28683a(Context context2, ScaleRotateViewState scaleRotateViewState, MotionEvent motionEvent) {
        MSize surfaceSize = ((C6001a) getMvpView()).getSurfaceSize();
        if (surfaceSize != null) {
            float x = motionEvent.getX();
            float b = (float) C8562q.m25044b(x, surfaceSize.width, 10000);
            float b2 = (float) C8562q.m25044b(motionEvent.getY(), surfaceSize.height, 10000);
            StringBuilder sb = new StringBuilder();
            sb.append("x:");
            sb.append(b);
            sb.append(",y:");
            sb.append(b2);
            LogUtils.m14223i("TextTapEvent", sb.toString());
        }
        if (this.cIV != null && this.cIV.isShowing()) {
            this.cIV.dismiss();
            this.cIV = null;
        }
        this.cIV = new C8950d(context2, scaleRotateViewState.getTextBubbleText(), this.cxJ, false);
        this.cIV.mo35604a(this.cxK);
        this.cIV.mo35594dR(R.string.xiaoying_str_com_cancel, R.string.xiaoying_str_com_ok);
        try {
            this.cIV.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void attachView(C6001a aVar) {
        super.attachView(aVar);
    }

    public void detachView() {
        super.detachView();
    }

    public void init(Context context2) {
        this.context = context2;
    }

    public void release() {
        if (this.cIV != null && this.cIV.isShowing()) {
            this.cIV.dismiss();
            this.cIV = null;
        }
    }
}
