package com.introvd.template.editor.base;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.effects.VideoEditorSeekLayout;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;

public abstract class BaseVipOperationView<T extends C5686a> extends BaseOperationView<T> {
    protected boolean cyH = false;
    private C4576e cyI;
    protected VideoEditorSeekLayout cyJ;

    public BaseVipOperationView(Activity activity, Class cls) {
        super(activity, cls);
    }

    /* access modifiers changed from: protected */
    public void aeD() {
        if (aeE()) {
            mo27844et(true);
        }
    }

    /* access modifiers changed from: protected */
    public boolean aeE() {
        return this.cyJ != null && this.cyJ.aeE();
    }

    /* access modifiers changed from: protected */
    public boolean aeF() {
        return C8072q.aBx().mo33072ku(C7825a.KEY_FRAME.getId());
    }

    /* access modifiers changed from: protected */
    public boolean aeG() {
        if (getContext() == null || !aeE() || !C8049f.aBf().aBr() || C8072q.aBx().mo33072ku(C7825a.KEY_FRAME.getId())) {
            return false;
        }
        C8049f.aBf().mo33097b(getContext(), C8070o.aBw(), C7825a.KEY_FRAME.getId(), "key_frame", 4152);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: et */
    public void mo27844et(boolean z) {
        if (aeF() || !z) {
            C4577f.m11629e(this.cyI);
            return;
        }
        if (!C4577f.m11630i(this.cyI) && getContext() != null) {
            this.cyI = C4577f.m11623a(getContext(), (View) this, "key_frame", -1);
        }
    }

    /* access modifiers changed from: protected */
    public void finish() {
        super.finish();
        C4577f.m11629e(this.cyI);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 4152) {
                this.cyH = true;
                aeD();
            } else {
                this.cyH = false;
            }
        }
    }
}
