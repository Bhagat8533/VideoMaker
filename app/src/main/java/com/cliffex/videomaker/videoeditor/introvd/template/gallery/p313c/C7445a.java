package com.introvd.template.gallery.p313c;

import android.content.Context;
import android.view.ViewGroup;
import com.introvd.template.xygallery.R;

/* renamed from: com.introvd.template.gallery.c.a */
public abstract class C7445a {
    protected int dHF = 0;
    protected C7446a dHG;
    protected ViewGroup dHH;
    protected Context mContext;

    /* renamed from: com.introvd.template.gallery.c.a$a */
    public interface C7446a {
        /* renamed from: rn */
        void mo32046rn(int i);
    }

    protected C7445a(ViewGroup viewGroup) {
        this.dHH = viewGroup;
        this.mContext = viewGroup.getContext();
    }

    /* renamed from: a */
    public void mo32106a(C7446a aVar) {
        this.dHG = aVar;
    }

    public int amG() {
        return 0;
    }

    public void azd() {
    }

    public int aze() {
        return this.dHF;
    }

    /* renamed from: rq */
    public void mo32110rq(int i) {
    }

    /* renamed from: rr */
    public void mo32111rr(int i) {
    }

    /* renamed from: rs */
    public void mo32112rs(int i) {
        this.dHH.setVisibility(i);
    }

    /* renamed from: rt */
    public int mo32113rt(int i) {
        switch (i) {
            case 0:
                return R.string.xiaoying_str_ve_gallery_filter_menu_item_video_only;
            case 1:
                return R.string.xiaoying_str_ve_gallery_filter_menu_item_photo_only;
            default:
                return R.string.xiaoying_str_ve_gallery_filter_menu_item_video_only;
        }
    }

    public void setFocusTab(int i) {
    }
}
