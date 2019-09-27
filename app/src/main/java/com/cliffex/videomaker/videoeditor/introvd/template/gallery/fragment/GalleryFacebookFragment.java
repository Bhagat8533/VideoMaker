package com.introvd.template.gallery.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.p024v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.gallery.AbstractGalleryFragment;
import com.introvd.template.gallery.C7431b;
import com.introvd.template.gallery.C7444c;
import com.introvd.template.gallery.p313c.C7447b;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.xygallery.R;

public class GalleryFacebookFragment extends AbstractGalleryFragment {
    private C7447b dHD;
    private View dHE;

    /* renamed from: d */
    public static AbstractGalleryFragment m22086d(int i, boolean z, int i2) {
        Bundle bundle = new Bundle();
        GalleryFacebookFragment galleryFacebookFragment = new GalleryFacebookFragment();
        bundle.putBoolean(MediaGalleryRouter.KEY_INTENT_HDSUPPORT, z);
        bundle.putInt(MediaGalleryRouter.KEY_INTENT_ADDMODE, i);
        bundle.putInt(MediaGalleryRouter.KEY_GALLERY_ACTION, i2);
        galleryFacebookFragment.setArguments(bundle);
        return galleryFacebookFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32016a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.bwy = layoutInflater.inflate(R.layout.gallery_fragment_facebook, viewGroup, false);
        this.dFm = (RecyclerView) this.bwy.findViewById(R.id.rc_folder);
        this.dFn = (RecyclerView) this.bwy.findViewById(R.id.gallery_detail_listview);
        ayl();
        this.dHE = this.bwy.findViewById(R.id.layout_sns_login);
        C7447b bVar = new C7447b(getActivity(), C7444c.GALLERY_TAB_FACEBOOK, this.dFm, this.dFn, this.dFp);
        this.dHD = bVar;
        this.dHD.setCallbackHandler(this.bLS);
        this.dHD.mo32120cR(this.dFo);
        this.dHD.mo32121cV(this.dHE);
        if (getArguments() != null) {
            this.dHD.mo32122e(getArguments().getInt(MediaGalleryRouter.KEY_INTENT_ADDMODE), getArguments().getBoolean(MediaGalleryRouter.KEY_INTENT_HDSUPPORT), getArguments().getInt(MediaGalleryRouter.KEY_GALLERY_ACTION));
        }
        mo32017ai(C7431b.aym().getSourceType(), true);
    }

    /* renamed from: ai */
    public void mo32017ai(int i, boolean z) {
        if (this.dHD != null) {
            this.dHD.mo32115ai(i, z);
        }
    }

    public void ayi() {
        this.dHD.ayi();
    }

    public boolean ayj() {
        return this.dHD == null || this.dHD.ayj();
    }

    public boolean ayk() {
        return this.dHD != null && this.dHD.ayk();
    }

    /* renamed from: cR */
    public void mo32022cR(View view) {
        this.dFo = view;
    }

    public void onDetach() {
        super.onDetach();
        if (this.dHD != null) {
            this.dHD.azi();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void setCallbackHandler(Handler handler) {
        this.bLS = handler;
    }
}
