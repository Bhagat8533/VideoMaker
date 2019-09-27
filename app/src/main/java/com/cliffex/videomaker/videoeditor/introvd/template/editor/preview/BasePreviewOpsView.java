package com.introvd.template.editor.preview;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.preview.p273d.C6563a;
import com.introvd.template.editor.preview.p273d.C6563a.C6564a;

@SuppressLint({"ViewConstructor"})
public abstract class BasePreviewOpsView extends BaseOperationView<C5686a> {
    private C6563a cZq;

    public BasePreviewOpsView(Activity activity) {
        super(activity, C5686a.class);
        this.cyF = true;
    }

    private void aoE() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && !activity.isFinishing() && getEditor() != null) {
            this.cZq = new C6563a(activity, getEditor().adK());
            this.cZq.mo29882a(new C6564a() {
                /* renamed from: gr */
                public void mo29755gr(boolean z) {
                    if (BasePreviewOpsView.this.getVideoOperator() != null) {
                        BasePreviewOpsView.this.getVideoOperator().mo29695gm(z);
                    }
                }
            });
        }
    }

    public void aeq() {
        if (this.cZq != null) {
            this.cZq.aeq();
        }
    }

    public void aex() {
        super.aex();
        aoE();
    }

    /* renamed from: gq */
    public void mo29751gq(boolean z) {
        if (!z && this.cZq != null) {
            this.cZq.aqy();
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        LogUtilsV2.m14227d("onDestroy");
        if (this.cZq != null) {
            this.cZq.onDestroy();
            this.cZq = null;
        }
    }

    public void onActivityPause() {
        super.onActivityPause();
    }

    public void onActivityResume() {
        super.onActivityResume();
        if (this.cZq != null) {
            this.cZq.aqy();
        }
    }

    /* renamed from: oq */
    public void mo29752oq(int i) {
    }

    /* renamed from: or */
    public boolean mo29753or(int i) {
        return false;
    }

    public void setFocusTab(int i) {
    }
}
