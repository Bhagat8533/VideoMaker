package com.introvd.template.explorer.p299d;

import android.app.Activity;
import com.introvd.template.common.MSize;
import com.introvd.template.sns.gallery.ISnsGallery;
import com.introvd.template.sns.gallery.SnsGalleryInfoListener;

/* renamed from: com.introvd.template.explorer.d.d */
public final class C7187d {
    private static volatile C7187d dDz;
    private SnsGalleryInfoListener dCP;
    private C7163b dDx = null;
    private C7182c dDy = null;

    private C7187d() {
    }

    public static C7187d axT() {
        if (dDz == null) {
            synchronized (C7187d.class) {
                if (dDz == null) {
                    dDz = new C7187d();
                }
            }
        }
        return dDz;
    }

    /* renamed from: qZ */
    private ISnsGallery m21241qZ(int i) {
        if (i == 28) {
            if (this.dDx == null) {
                this.dDx = new C7163b();
            }
            return this.dDx;
        } else if (i != 31) {
            return null;
        } else {
            if (this.dDy == null) {
                this.dDy = new C7182c();
            }
            return this.dDy;
        }
    }

    /* renamed from: a */
    public void mo31667a(int i, Activity activity, MSize mSize) {
        ISnsGallery qZ = m21241qZ(i);
        if (qZ != null && this.dCP != null) {
            qZ.setSnsGalleryInfoListener(this.dCP);
            qZ.getAlbums(activity, mSize);
        }
    }

    /* renamed from: a */
    public void mo31668a(int i, Activity activity, String str, MSize mSize) {
        ISnsGallery qZ = m21241qZ(i);
        if (qZ != null && this.dCP != null) {
            qZ.setSnsGalleryInfoListener(this.dCP);
            qZ.getMediaData(activity, str, mSize);
        }
    }

    /* renamed from: qY */
    public void mo31669qY(int i) {
        ISnsGallery qZ = m21241qZ(i);
        if (qZ != null && this.dCP != null) {
            qZ.stopFectchData();
        }
    }

    public void setSnsGalleryInfoListener(SnsGalleryInfoListener snsGalleryInfoListener) {
        this.dCP = snsGalleryInfoListener;
    }
}
