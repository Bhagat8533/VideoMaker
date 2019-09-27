package com.introvd.template.camera.p233ui.facial;

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
import com.introvd.template.camera.p233ui.facial.C5139d.C5140a;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8741j;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.vivacamera.R;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.introvd.template.camera.ui.facial.b */
public class C5134b extends C1008a<C5137a> {
    /* access modifiers changed from: private */
    public C5141e bVt;
    /* access modifiers changed from: private */
    public List<TemplateInfo> bVu = new ArrayList();
    private String bVv = "";
    private Map<String, SoftReference<Bitmap>> bVw = Collections.synchronizedMap(new LinkedHashMap<String, SoftReference<Bitmap>>(20, 0.75f, true) {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Entry<String, SoftReference<Bitmap>> entry) {
            boolean z = size() > 20;
            if (z) {
                remove(entry.getKey());
            }
            return z;
        }
    });
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.camera.ui.facial.b$a */
    static class C5137a extends C1034u {
        ImageView bSD;
        RelativeLayout bSy;
        DynamicLoadingImageView bVA;
        ImageView bVB;
        ImageView bVC;
        ImageView bVD;
        ImageView bVE;
        DynamicLoadingImageView bVz;

        C5137a(View view) {
            super(view);
            this.bSy = (RelativeLayout) view.findViewById(R.id.main_layout);
            this.bVz = (DynamicLoadingImageView) view.findViewById(R.id.img_filter_thumb);
            this.bSD = (ImageView) view.findViewById(R.id.img_download_flag);
            this.bVC = (ImageView) view.findViewById(R.id.img_new_flag);
            this.bVB = (ImageView) view.findViewById(R.id.img_lock_flag);
            this.bVA = (DynamicLoadingImageView) view.findViewById(R.id.download_progress);
            ImageLoader.loadImage(R.drawable.xiaoying_cam_filter_download_loading, this.bVA);
            this.bVD = (ImageView) view.findViewById(R.id.img_filter_focus);
            this.bVE = (ImageView) view.findViewById(R.id.img_audio);
        }
    }

    public C5134b(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    private void m13878a(ImageView imageView, int i) {
        if ((i & 1) == 1) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m13879a(C5137a aVar, TemplateInfo templateInfo, String str, boolean z) {
        if (templateInfo.nState != 1 || z) {
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
    }

    /* renamed from: a */
    private void m13880a(C5137a aVar, List<C5139d> list) {
        Boolean bool = null;
        Boolean bool2 = null;
        for (C5139d dVar : list) {
            if (dVar.mo26042XF() != null) {
                bool = dVar.mo26042XF();
            }
            if (dVar.mo26041XE() != null) {
                bool2 = dVar.mo26041XE();
            }
        }
        int i = 8;
        if (!(bool == null || aVar.bVA == null)) {
            if (bool.booleanValue()) {
                aVar.bVA.setVisibility(0);
                aVar.bSD.setVisibility(4);
            } else {
                aVar.bVA.setVisibility(8);
            }
        }
        if (bool2 != null && aVar.bVD != null) {
            ImageView imageView = aVar.bVD;
            if (bool2.booleanValue()) {
                i = 0;
            }
            imageView.setVisibility(i);
        }
    }

    /* renamed from: a */
    private void m13881a(DynamicLoadingImageView dynamicLoadingImageView, String str) {
        dynamicLoadingImageView.clearAnimation();
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

    /* renamed from: B */
    public void mo26031B(int i, boolean z) {
        notifyItemChanged(i + 1, new C5140a().mo26045p(Boolean.valueOf(z)).mo26043XG());
    }

    /* renamed from: a */
    public void onBindViewHolder(final C5137a aVar, int i) {
        int i2 = 0;
        if (i == 0) {
            DynamicLoadingImageView dynamicLoadingImageView = aVar.bVz;
            StringBuilder sb = new StringBuilder();
            sb.append("res:///");
            sb.append(R.drawable.xiaoying_camera_icon_nothing);
            dynamicLoadingImageView.setImageURI(Uri.parse(sb.toString()));
            aVar.bSD.setVisibility(4);
            aVar.bVA.setVisibility(8);
            ImageView imageView = aVar.bVD;
            if (!TextUtils.isEmpty(this.bVv)) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            aVar.bVC.setVisibility(8);
            aVar.bVB.setVisibility(8);
            aVar.bVE.setVisibility(8);
        } else {
            DynamicLoadingImageView dynamicLoadingImageView2 = aVar.bVz;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("res:///");
            sb2.append(R.drawable.xiaoying_com_dialog_transparent);
            dynamicLoadingImageView2.setImageURI(Uri.parse(sb2.toString()));
            TemplateInfo templateInfo = null;
            int i3 = i - 1;
            if (i3 >= 0 && i3 < this.bVu.size()) {
                templateInfo = (TemplateInfo) this.bVu.get(i3);
            }
            if (templateInfo != null) {
                String str = templateInfo.ttid;
                boolean z = !TextUtils.isEmpty(C8762d.aMt().mo35225bB(C2575a.parseLong(str)));
                m13879a(aVar, templateInfo, str, z);
                m13878a(aVar.bVC, templateInfo.nMark);
                m13881a(aVar.bVz, templateInfo.strIcon);
                aVar.bVA.setTag(str);
                aVar.bVA.setVisibility(8);
                if (templateInfo.nState == 8 && !z) {
                    aVar.bVA.setVisibility(0);
                }
                if (TextUtils.isEmpty(this.bVv) || !this.bVv.equals(str)) {
                    aVar.bVD.setVisibility(8);
                } else {
                    aVar.bVD.setVisibility(0);
                }
                ImageView imageView2 = aVar.bVE;
                if (templateInfo.audioFlag != 1) {
                    i2 = 8;
                }
                imageView2.setVisibility(i2);
            } else {
                return;
            }
        }
        aVar.bSy.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int adapterPosition = aVar.getAdapterPosition();
                if (adapterPosition >= 0) {
                    if (adapterPosition != 0) {
                        TemplateInfo templateInfo = null;
                        int i = adapterPosition - 1;
                        if (i >= 0 && i < C5134b.this.bVu.size()) {
                            templateInfo = (TemplateInfo) C5134b.this.bVu.get(i);
                        }
                        if (templateInfo != null) {
                            boolean z = !TextUtils.isEmpty(C8762d.aMt().mo35225bB(C2575a.parseLong(templateInfo.ttid)));
                            if (templateInfo.nState == 1) {
                                if (C5134b.this.bVt != null && C5134b.this.bVt.mo26014e(i, templateInfo)) {
                                    view.findViewById(R.id.img_download_flag).setVisibility(4);
                                }
                            } else if (z || templateInfo.nState != 8) {
                                if ((templateInfo.nMark & 1) == 1) {
                                    C8741j.m25535cE(C5134b.this.mContext, templateInfo.ttid);
                                    templateInfo.nMark &= -2;
                                }
                                if (C8739i.m25527qr(templateInfo.ttid) || C8739i.m25526qq(templateInfo.ttid)) {
                                    if (C5134b.this.bVt != null) {
                                        C5134b.this.bVt.mo26013d(i, templateInfo);
                                    }
                                } else if (C5134b.this.bVt != null) {
                                    C5134b.this.bVt.mo26012c(i, templateInfo);
                                }
                            }
                        }
                    } else if (C5134b.this.bVt != null) {
                        C5134b.this.bVt.mo26011XC();
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void onBindViewHolder(C5137a aVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(aVar, i);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof C5139d) {
                arrayList.add((C5139d) next);
            }
        }
        m13880a(aVar, (List<C5139d>) arrayList);
    }

    /* renamed from: a */
    public void mo26034a(C5141e eVar) {
        this.bVt = eVar;
    }

    /* renamed from: ay */
    public void mo26035ay(List<TemplateInfo> list) {
        if (list != null) {
            this.bVu = list;
            notifyDataSetChanged();
        }
    }

    /* renamed from: fe */
    public void mo26036fe(String str) {
        if (!this.bVv.equals(str)) {
            int ff = mo26037ff(this.bVv);
            int ff2 = mo26037ff(str);
            if (ff >= 0) {
                notifyItemChanged(ff, new C5140a().mo26044o(Boolean.valueOf(false)).mo26043XG());
            }
            if (ff2 >= 0) {
                notifyItemChanged(ff2, new C5140a().mo26044o(Boolean.valueOf(true)).mo26043XG());
            }
        } else if (TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.bVv)) {
                int ff3 = mo26037ff(this.bVv);
                if (ff3 >= 0) {
                    notifyItemChanged(ff3, new C5140a().mo26044o(Boolean.valueOf(false)).mo26043XG());
                }
            }
            notifyItemChanged(0, new C5140a().mo26044o(Boolean.valueOf(true)).mo26043XG());
        }
        this.bVv = str;
    }

    /* renamed from: ff */
    public int mo26037ff(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        for (int i = 0; i < this.bVu.size(); i++) {
            if (str.equals(((TemplateInfo) this.bVu.get(i)).ttid)) {
                return i + 1;
            }
        }
        return -1;
    }

    public int getItemCount() {
        return this.bVu.size() + 1;
    }

    /* renamed from: r */
    public C5137a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C5137a(LayoutInflater.from(this.mContext).inflate(R.layout.cam_recycler_item_fd_effect, viewGroup, false));
    }
}
