package com.introvd.template.editor.clipedit.transition.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.transition.C5802b;
import com.introvd.template.editor.clipedit.transition.C5803c;
import com.introvd.template.editor.clipedit.transition.TransitionInfo;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.template.p409g.C8762d;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.clipedit.transition.recycler.b */
public class C5805b extends C1008a<C5807a> {
    private C5804a cCS;
    private LinearLayoutManager cDe;
    private C5802b cDg;
    private HashMap<Long, SoftReference<Bitmap>> cDh = new HashMap<>();
    private int cDi;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: pX */
    private LayoutInflater f3483pX;

    /* renamed from: com.introvd.template.editor.clipedit.transition.recycler.b$a */
    public static class C5807a extends C1034u {
        DynamicLoadingImageView cDk;
        ImageView cDl;
        ImageView cDm;
        ImageView cDn;
        LinearLayout cDo;
        DynamicLoadingImageView cDp;
        TextView cDq;
        TextView cpp;

        public C5807a(View view) {
            super(view);
        }
    }

    public C5805b(Context context, LinearLayoutManager linearLayoutManager, C5804a aVar, C5802b bVar) {
        this.mContext = context.getApplicationContext();
        this.f3483pX = LayoutInflater.from(this.mContext);
        this.cDi = C4583d.m11670O(this.mContext, 2);
        this.cDe = linearLayoutManager;
        this.cCS = aVar;
        this.cDg = bVar;
    }

    /* renamed from: a */
    private void m16171a(ImageView imageView, LinearLayout linearLayout, TextView textView, int i, int i2) {
        if (i == 0) {
            imageView.setVisibility(0);
            linearLayout.setVisibility(8);
        } else if (i == 1) {
            imageView.setVisibility(8);
            linearLayout.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            linearLayout.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append("%");
            textView.setText(sb.toString());
        }
    }

    /* renamed from: a */
    private void m16172a(ImageView imageView, boolean z) {
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    /* renamed from: a */
    private boolean m16173a(TransitionInfo transitionInfo) {
        if (transitionInfo.state == 2) {
            return false;
        }
        boolean z = true;
        if (transitionInfo.state == 0) {
            int aw = this.cCS.mo28097aw(transitionInfo.cCN);
            if (aw >= 0) {
                notifyItemChanged(aw + 1);
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                if (transitionInfo.state != 0) {
                    z = false;
                }
                effectInfoModel.setbNeedDownload(z);
                effectInfoModel.mName = transitionInfo.name;
                effectInfoModel.mTemplateId = transitionInfo.cCN;
                effectInfoModel.mPath = transitionInfo.path;
                effectInfoModel.mThumbUrl = transitionInfo.thumbUrl;
                effectInfoModel.setmConfigureCount(transitionInfo.cCO);
                effectInfoModel.setmUrl(transitionInfo.url);
                this.cDg.mo28085b(effectInfoModel);
            }
            return false;
        }
        try {
            if (!TextUtils.isEmpty(transitionInfo.path) && !this.cDg.afT()) {
                int focusIndex = this.cCS.getFocusIndex() + 1;
                int gP = this.cCS.mo28101gP(transitionInfo.path) + 1;
                this.cDg.mo28086gN(this.cCS.agc());
                C5803c.m16156e(this.mContext, transitionInfo.name, transitionInfo.cCN);
                notifyItemChanged(focusIndex);
                m16177lx(gP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /* renamed from: c */
    private void m16175c(TextView textView, String str) {
        if (ParametersKeys.ORIENTATION_NONE.equals(str.toLowerCase())) {
            textView.setText(R.string.xiaoying_str_ve_template_empty_title);
        } else {
            textView.setText(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lw */
    public boolean m16176lw(int i) {
        boolean z = false;
        if (i == 0) {
            this.cDg.aeP();
            return false;
        }
        TransitionInfo lv = this.cCS.mo28104lv(i - 1);
        if (lv != null && m16173a(lv)) {
            z = true;
        }
        return z;
    }

    /* renamed from: lx */
    private void m16177lx(int i) {
        View childAt = this.cDe.getChildAt(i - this.cDe.findFirstVisibleItemPosition());
        if (childAt != null) {
            ImageView imageView = (ImageView) childAt.findViewById(R.id.bg_selected);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            childAt.invalidate();
            return;
        }
        this.cDe.scrollToPositionWithOffset(i, 0);
    }

    /* renamed from: A */
    public C5807a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f3483pX.inflate(R.layout.editor_transition_recycler_item_layout, viewGroup, false);
        C5807a aVar = new C5807a(inflate);
        aVar.cDk = (DynamicLoadingImageView) inflate.findViewById(R.id.item_cover);
        aVar.cDk.setCornerRadius((float) this.cDi);
        aVar.cDl = (ImageView) inflate.findViewById(R.id.icon_new);
        aVar.cDm = (ImageView) inflate.findViewById(R.id.bg_selected);
        aVar.cDn = (ImageView) inflate.findViewById(R.id.icon_lock);
        aVar.cDo = (LinearLayout) inflate.findViewById(R.id.ll_progress);
        aVar.cDp = (DynamicLoadingImageView) inflate.findViewById(R.id.bg_download_progress);
        aVar.cDq = (TextView) inflate.findViewById(R.id.text_download_progress);
        ImageLoader.loadImage(R.drawable.xiaoying_cam_filter_download_loading, aVar.cDp);
        aVar.cpp = (TextView) inflate.findViewById(R.id.item_name);
        return aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C5807a aVar, final int i) {
        boolean z = false;
        if (i == 0) {
            aVar.cDk.setImageResource(R.drawable.xiaoying_cam_icon_filter_store);
            aVar.cpp.setText(R.string.xiaoying_str_template_get_more);
            aVar.cDn.setVisibility(8);
            aVar.cDo.setVisibility(8);
            aVar.cDm.setVisibility(8);
            if (this.cCS.agd()) {
                aVar.cDl.setVisibility(0);
            } else {
                aVar.cDl.setVisibility(8);
            }
        } else {
            aVar.cDl.setVisibility(8);
            TransitionInfo lv = this.cCS.mo28104lv(i - 1);
            if (lv == null) {
                m16175c(aVar.cpp, "");
                m16171a(aVar.cDn, aVar.cDo, aVar.cDq, 0, 0);
                aVar.cDm.setVisibility(8);
                aVar.cDk.setImageResource(R.drawable.xiaoying_cam_thumb_filter_none);
                return;
            }
            if (!TextUtils.isEmpty(this.cCS.agc()) && this.cCS.agc().equals(lv.path)) {
                z = true;
            }
            m16172a(aVar.cDm, z);
            m16175c(aVar.cpp, lv.name == null ? "" : lv.name);
            m16171a(aVar.cDn, aVar.cDo, aVar.cDq, lv.state, lv.progress);
            if (i == 1) {
                aVar.cDk.setImageResource(R.drawable.xiaoying_cam_thumb_filter_none);
            } else if (!TextUtils.isEmpty(lv.thumbUrl)) {
                ImageLoader.loadImage(lv.thumbUrl, aVar.cDk);
            } else {
                Bitmap bitmap = null;
                if (this.cDh != null && this.cDh.containsKey(Long.valueOf(lv.cCN))) {
                    SoftReference softReference = (SoftReference) this.cDh.get(Long.valueOf(lv.cCN));
                    if (softReference != null) {
                        Bitmap bitmap2 = (Bitmap) softReference.get();
                        if (bitmap2 != null && !bitmap2.isRecycled()) {
                            bitmap = bitmap2;
                        }
                    }
                }
                if (bitmap == null) {
                    bitmap = C8762d.aMt().mo35220a(lv.cCN, C4583d.m11671P(71.0f), C4583d.m11671P(71.0f), C8501a.aJs().aJv());
                    if (!(this.cDh == null || bitmap == null)) {
                        this.cDh.put(Long.valueOf(lv.cCN), new SoftReference(bitmap));
                    }
                }
                if (bitmap != null) {
                    aVar.cDk.setImageBitmap(bitmap);
                    aVar.cDk.invalidate();
                }
            }
        }
        aVar.cDk.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5805b.this.mContext != null) {
                    C5805b.this.m16176lw(i);
                }
            }
        });
    }

    /* renamed from: d */
    public void mo28107d(long j, String str) {
        int c = this.cCS.mo28098c(j, str);
        if (c >= 0) {
            notifyItemChanged(c + 1);
            return;
        }
        this.cCS.afY();
        notifyDataSetChanged();
    }

    /* renamed from: e */
    public void mo28108e(long j, int i) {
        int f = this.cCS.mo28099f(j, i);
        if (f >= 0) {
            View childAt = this.cDe.getChildAt((f + 1) - this.cDe.findFirstVisibleItemPosition());
            if (childAt != null) {
                ImageView imageView = (ImageView) childAt.findViewById(R.id.icon_lock);
                LinearLayout linearLayout = (LinearLayout) childAt.findViewById(R.id.ll_progress);
                TextView textView = (TextView) childAt.findViewById(R.id.text_download_progress);
                if (!(imageView == null || linearLayout == null || textView == null)) {
                    if (i >= 0) {
                        imageView.setVisibility(8);
                        linearLayout.setVisibility(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append(i);
                        sb.append("%");
                        textView.setText(sb.toString());
                    } else {
                        if (i == -2) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(8);
                        }
                        linearLayout.setVisibility(8);
                    }
                }
                childAt.invalidate();
            }
        }
    }

    /* renamed from: gQ */
    public void mo28109gQ(String str) {
        TransitionInfo gO = this.cCS.mo28100gO(str);
        if (gO != null) {
            m16173a(gO);
        }
    }

    public int getItemCount() {
        return this.cCS.getCount() + 1;
    }
}
