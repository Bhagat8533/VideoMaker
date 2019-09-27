package com.introvd.template.editor.fast;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.Constants;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseEditorActivity;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.p266h.C6375c;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.widget.timeline.C7125c;
import com.introvd.template.router.StudioRouter;
import com.quvideo.mobile.component.imageview.p214a.C4767b;

@C1942a(mo10417rZ = "/XYVideoEditor/FastEditor")
public class FastEditorActivity extends BaseEditorActivity {
    private void abm() {
        C5839a.m16332ez(getApplicationContext());
        if (C6386d.m18370a((Activity) this, false, this.cyl.adK().aHe())) {
            this.cyl.ahU();
            C4767b.clearCache(this);
            finish();
        }
    }

    private void abn() {
        StudioRouter.launchStudioActivity(this);
        this.cyl.ahU();
        finish();
    }

    private void abo() {
        if (this.cyi != null && !this.cyi.onBackPressed()) {
            this.cym.aie();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo27769a(BaseOperationView baseOperationView, boolean z) {
        if (super.mo27769a(baseOperationView, z)) {
            MSize mSize = new MSize();
            mSize.width = Constants.getScreenSize().width;
            mSize.height = (Constants.getScreenSize().height - C5840b.cEB) - C5840b.cEA;
            this.cyl.mo27717b(mSize);
            this.cyk.setPlayerInitTime(0);
            this.cyk.mo29657oe(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int aeh() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int aei() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void ael() {
        super.ael();
        C7125c.m21081r(this.cyl.aia());
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo27775e(int i, Bundle bundle) {
        if (super.mo27775e(i, bundle)) {
            MSize mSize = new MSize();
            mSize.width = Constants.getScreenSize().width;
            mSize.height = Constants.getScreenSize().height - C5840b.cEz;
            this.cyl.mo27717b(mSize);
            this.cyk.setPlayerInitTime(C5852d.agW().agY());
            this.cyk.mo29657oe(0);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: eq */
    public void mo27776eq(boolean z) {
        super.mo27776eq(z);
    }

    /* renamed from: kq */
    public void mo27338kq(int i) {
        super.mo27338kq(i);
        switch (i) {
            case 0:
                abo();
                return;
            case 1:
                abn();
                return;
            case 2:
                abm();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: kr */
    public void mo27339kr(int i) {
        super.mo27339kr(i);
        switch (i) {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C6375c.asF().mo29427fK(this);
        setContentView(R.layout.editor_act_fast_main);
        this.cyh = (RelativeLayout) findViewById(R.id.editor_content_layout);
    }
}
