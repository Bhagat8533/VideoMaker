package com.introvd.template.gallery.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.p024v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.gallery.AbstractGalleryFragment;
import com.introvd.template.gallery.C7431b;
import com.introvd.template.gallery.C7444c;
import com.introvd.template.gallery.p313c.C7447b;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.xygallery.R;

@C1942a(mo10417rZ = "/MediaGallery/OtherAlbum")
public class GalleryOthersFragment extends AbstractGalleryFragment {
    private C7447b dHD;

    /* renamed from: d */
    public static AbstractGalleryFragment m22094d(int i, boolean z, int i2) {
        Bundle bundle = new Bundle();
        GalleryOthersFragment galleryOthersFragment = new GalleryOthersFragment();
        bundle.putBoolean(MediaGalleryRouter.KEY_INTENT_HDSUPPORT, z);
        bundle.putInt(MediaGalleryRouter.KEY_INTENT_ADDMODE, i);
        bundle.putInt(MediaGalleryRouter.KEY_GALLERY_ACTION, i2);
        galleryOthersFragment.setArguments(bundle);
        return galleryOthersFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32016a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i = 0;
        this.bwy = layoutInflater.inflate(R.layout.gallery_fragment_others, viewGroup, false);
        this.dFm = (RecyclerView) this.bwy.findViewById(R.id.rc_folder);
        this.dFn = (RecyclerView) this.bwy.findViewById(R.id.gallery_detail_listview);
        ayl();
        C7447b bVar = new C7447b(getActivity(), C7444c.GALLERY_TAB_OTHERS, this.dFm, this.dFn, this.dFp);
        this.dHD = bVar;
        this.dHD.setCallbackHandler(this.bLS);
        this.dHD.mo32120cR(this.dFo);
        int i2 = getArguments() != null ? getArguments().getInt(MediaGalleryRouter.KEY_GALLERY_ACTION) : 0;
        if (getArguments() != null) {
            this.dHD.mo32122e(getArguments().getInt(MediaGalleryRouter.KEY_INTENT_ADDMODE), getArguments().getBoolean(MediaGalleryRouter.KEY_INTENT_HDSUPPORT), i2);
        }
        if (i2 == 6) {
            C7431b.aym().mo32086nB(i2);
            i = 1;
        } else if (i2 == 8 || i2 == 9) {
            C7431b.aym().mo32086nB(i2);
        } else {
            i = C7431b.aym().getSourceType();
        }
        mo32017ai(i, true);
    }

    /* renamed from: ai */
    public void mo32017ai(int i, boolean z) {
        if (this.dHD != null) {
            this.dHD.mo32115ai(i, z);
        }
    }

    public void ayi() {
        if (this.dHD != null) {
            this.dHD.ayi();
        }
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

    public void setCallbackHandler(Handler handler) {
        this.bLS = handler;
    }
}
