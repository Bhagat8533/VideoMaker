package com.introvd.template.editor.advance;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8741j;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.introvd.template.editor.advance.c */
public class C5593c extends C1008a<C5596a> {
    private List<TemplateInfo> bVu = new ArrayList();
    private Map<String, SoftReference<Bitmap>> bVw = Collections.synchronizedMap(new LinkedHashMap<String, SoftReference<Bitmap>>(20, 0.75f, true) {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Entry<String, SoftReference<Bitmap>> entry) {
            boolean z = size() > 20;
            if (z) {
                SoftReference softReference = (SoftReference) entry.getValue();
                if (softReference != null) {
                    Bitmap bitmap = (Bitmap) softReference.get();
                    remove(entry.getKey());
                }
            }
            return z;
        }
    });
    /* access modifiers changed from: private */
    public C5604i cuZ;
    private String cva;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: pX */
    private LayoutInflater f3477pX;

    /* renamed from: com.introvd.template.editor.advance.c$a */
    public static class C5596a extends C1034u {
        ImageView bSD;
        RelativeLayout bSy;
        DynamicLoadingImageView bVA;
        ImageView bVB;
        ImageView bVC;
        ImageView bVD;
        DynamicLoadingImageView bVz;

        public C5596a(View view) {
            super(view);
        }
    }

    public C5593c(Context context) {
        this.f3477pX = LayoutInflater.from(context);
        this.mContext = context;
    }

    /* renamed from: a */
    private void m15318a(ImageView imageView, int i) {
        if ((i & 1) == 1) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m15320a(DynamicLoadingImageView dynamicLoadingImageView, String str) {
        if (!(this.bVw == null || this.bVw.get(str) == null)) {
            Bitmap bitmap = (Bitmap) ((SoftReference) this.bVw.get(str)).get();
            if (bitmap != null && !bitmap.isRecycled()) {
                dynamicLoadingImageView.setPlaceholderImage((Drawable) new BitmapDrawable(bitmap));
            }
        }
        if (!TextUtils.isEmpty(str)) {
            ImageLoader.loadImage(str, dynamicLoadingImageView);
        } else {
            dynamicLoadingImageView.setImageResource(R.drawable.emoji_1f61c);
        }
    }

    /* renamed from: gg */
    private boolean m15322gg(String str) {
        return !TextUtils.isEmpty(this.cva) && this.cva.equals(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: gh */
    public void m15323gh(String str) {
        this.cva = str;
        notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: kO */
    public TemplateInfo m15324kO(int i) {
        if (this.bVu == null || i < 0 || i >= this.bVu.size()) {
            return null;
        }
        return (TemplateInfo) this.bVu.get(i);
    }

    /* renamed from: a */
    public void onBindViewHolder(C5596a aVar, final int i) {
        aVar.bSy.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TemplateInfo a = C5593c.this.m15324kO(i);
                if (a != null) {
                    boolean z = !TextUtils.isEmpty(C8762d.aMt().mo35225bB(C2575a.parseLong(a.ttid)));
                    if (a.nState == 1) {
                        if (C5593c.this.cuZ != null && C5593c.this.cuZ.mo27542e(i, a)) {
                            view.findViewById(R.id.img_download_flag).setVisibility(4);
                        }
                    } else if (z || a.nState != 8) {
                        if ((a.nMark & 1) == 1) {
                            C8741j.m25535cE(C5593c.this.mContext, a.ttid);
                            a.nMark &= -2;
                        }
                        if (C8739i.m25527qr(a.ttid) || C8739i.m25526qq(a.ttid)) {
                            if (C5593c.this.cuZ != null) {
                                C5593c.this.cuZ.mo27541d(i, a);
                            }
                            return;
                        }
                        if (C5593c.this.cuZ != null) {
                            C5593c.this.cuZ.mo27540c(i, a);
                        }
                        if (a.nState != 1) {
                            C5593c.this.m15323gh(a.ttid);
                        }
                    }
                }
            }
        });
        DynamicLoadingImageView dynamicLoadingImageView = aVar.bVz;
        StringBuilder sb = new StringBuilder();
        sb.append("res:///");
        sb.append(R.drawable.xiaoying_com_dialog_transparent);
        dynamicLoadingImageView.setImageURI(Uri.parse(sb.toString()));
        TemplateInfo kO = m15324kO(i);
        if (kO != null) {
            String str = kO.ttid;
            boolean z = !TextUtils.isEmpty(C8762d.aMt().mo35225bB(C2575a.parseLong(str)));
            if (kO.nState != 1 || z) {
                aVar.bSD.setVisibility(4);
                aVar.bVB.setVisibility(4);
            } else if (C8739i.m25527qr(str)) {
                aVar.bSD.setVisibility(4);
                aVar.bVB.setVisibility(0);
            } else if (C8739i.m25526qq(str)) {
                aVar.bSD.setVisibility(4);
                aVar.bVB.setVisibility(0);
            } else {
                aVar.bSD.setVisibility(0);
                aVar.bVB.setVisibility(4);
            }
            m15318a(aVar.bVC, kO.nMark);
            aVar.bVz.clearAnimation();
            m15320a(aVar.bVz, kO.strIcon);
            aVar.bVA.setTag(str);
            aVar.bVA.setVisibility(8);
            if (kO.nState == 8 && !z) {
                aVar.bVA.setVisibility(0);
            }
            if (m15322gg(str)) {
                aVar.bVD.setVisibility(0);
            } else {
                aVar.bVD.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    public void mo27524a(C5604i iVar) {
        this.cuZ = iVar;
    }

    /* renamed from: ay */
    public void mo27525ay(List<TemplateInfo> list) {
        if (list != null) {
            this.bVu = list;
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.bVu.size();
    }

    /* renamed from: gf */
    public void mo27526gf(String str) {
        this.cva = str;
    }

    /* renamed from: x */
    public C5596a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f3477pX.inflate(R.layout.editor_pick_cover_package_item_layout, viewGroup, false);
        C5596a aVar = new C5596a(inflate);
        aVar.bSy = (RelativeLayout) inflate.findViewById(R.id.main_layout);
        aVar.bVz = (DynamicLoadingImageView) inflate.findViewById(R.id.img_filter_thumb);
        aVar.bSD = (ImageView) inflate.findViewById(R.id.img_download_flag);
        aVar.bVC = (ImageView) inflate.findViewById(R.id.img_new_flag);
        aVar.bVB = (ImageView) inflate.findViewById(R.id.img_lock_flag);
        aVar.bVA = (DynamicLoadingImageView) inflate.findViewById(R.id.download_progress);
        ImageLoader.loadImage(R.drawable.xiaoying_cam_filter_download_loading, aVar.bVA);
        aVar.bVD = (ImageView) inflate.findViewById(R.id.img_filter_focus);
        return aVar;
    }
}
