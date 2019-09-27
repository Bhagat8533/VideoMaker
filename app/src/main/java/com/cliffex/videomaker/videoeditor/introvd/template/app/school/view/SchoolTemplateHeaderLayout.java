package com.introvd.template.app.school.view;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Context;
import android.support.p021v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.introvd.template.R;
import com.introvd.template.app.school.C4205m;
import com.introvd.template.app.school.p196b.C4162b;
import com.introvd.template.router.AppRouter;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class SchoolTemplateHeaderLayout extends LinearLayout implements C0068f {
    private SchoolTemplateListView bAl;
    private View bAm;
    private View bAn;

    public SchoolTemplateHeaderLayout(Context context) {
        super(context);
        m10702Iu();
    }

    public SchoolTemplateHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10702Iu();
    }

    public SchoolTemplateHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10702Iu();
    }

    /* renamed from: Iu */
    private void m10702Iu() {
        LayoutInflater.from(getContext()).inflate(R.layout.app_view_school_template_header, this, true);
        this.bAn = findViewById(R.id.layoutRecTempTitle);
        this.bAm = findViewById(R.id.layoutVideoLabelTitle);
        this.bAl = (SchoolTemplateListView) findViewById(R.id.layoutSchoolTemplate);
        if (getContext() instanceof FragmentActivity) {
            ((FragmentActivity) getContext()).getLifecycle().mo152a(this.bAl);
        }
        findViewById(R.id.btnRecTempMore).setOnClickListener(new C4271c(this));
    }

    /* renamed from: OK */
    private void m10703OK() {
        AppRouter.startTemplateList(getContext(), 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: bK */
    public /* synthetic */ void m10705bK(View view) {
        if (view.getContext() instanceof Activity) {
            C4205m.m10501dP("");
            m10703OK();
        }
    }

    /* renamed from: Kp */
    public void mo24267Kp() {
        this.bAl.mo24272Kp();
    }

    /* renamed from: hx */
    public boolean mo24268hx(int i) {
        int[] iArr = new int[2];
        this.bAn.getLocationOnScreen(iArr);
        return i >= iArr[1];
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4162b bVar) {
        if (bVar != null) {
            int i = 0;
            if (bVar.mo23986Oe()) {
                this.bAn.setVisibility(bVar.mo23987Of() ? 8 : 0);
                this.bAl.setVisibility(bVar.mo23987Of() ? 8 : 0);
            }
            if (bVar.mo23988Og()) {
                View view = this.bAm;
                if (bVar.mo23989Oh()) {
                    i = 8;
                }
                view.setVisibility(i);
            }
        }
    }

    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onPause() {
        C10021c.aZH().mo38496az(this);
    }

    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onResume() {
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
    }
}
