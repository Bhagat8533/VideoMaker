package com.introvd.template.editor.slideshow.funny.adapter;

import android.content.Context;
import android.support.p021v4.app.Fragment;
import com.introvd.template.editor.slideshow.funny.view.FunnyTabView;
import com.introvd.template.template.model.TemplatePackageInfo;

/* renamed from: com.introvd.template.editor.slideshow.funny.adapter.a */
public class C6819a {
    private Context context;
    private TemplatePackageInfo dgY;
    private FunnyTabView dgZ;
    private Fragment fragment;

    /* renamed from: com.introvd.template.editor.slideshow.funny.adapter.a$a */
    public static final class C6821a {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public TemplatePackageInfo dgY;
        /* access modifiers changed from: private */
        public Fragment fragment;

        /* renamed from: a */
        public C6821a mo30391a(TemplatePackageInfo templatePackageInfo) {
            this.dgY = templatePackageInfo;
            return this;
        }

        public C6819a arG() {
            return new C6819a(this);
        }

        /* renamed from: e */
        public C6821a mo30393e(Fragment fragment2) {
            this.fragment = fragment2;
            return this;
        }

        /* renamed from: fu */
        public C6821a mo30394fu(Context context2) {
            this.context = context2;
            return this;
        }
    }

    private C6819a(C6821a aVar) {
        this.context = aVar.context;
        this.dgY = aVar.dgY;
        this.fragment = aVar.fragment;
    }

    public FunnyTabView arF() {
        if (this.dgZ == null) {
            this.dgZ = new FunnyTabView(this.context);
            this.dgZ.mo30402aq(getTitle(), this.dgY.strIcon);
        }
        return this.dgZ;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    public long getId() {
        return Long.valueOf(this.dgY.strGroupCode).longValue();
    }

    public String getTitle() {
        return this.dgY.strTitle;
    }
}
