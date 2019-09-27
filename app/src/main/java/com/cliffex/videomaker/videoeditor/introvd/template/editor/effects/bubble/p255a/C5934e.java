package com.introvd.template.editor.effects.bubble.p255a;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.nav.C6184a;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.utils.p394b.C8536m;
import com.introvd.template.template.model.StoryBoardXytItemInfo;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2570b;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.effects.bubble.a.e */
public class C5934e extends C1008a<C5937b> {
    private int cJn = -1;
    /* access modifiers changed from: private */
    public C5936a cJo;
    private int cwZ = -1;
    public List<StoryBoardItemInfo> mItemInfoList;

    /* renamed from: pX */
    private LayoutInflater f3491pX;

    /* renamed from: com.introvd.template.editor.effects.bubble.a.e$a */
    public interface C5936a {
        /* renamed from: z */
        void mo28560z(View view, int i);
    }

    /* renamed from: com.introvd.template.editor.effects.bubble.a.e$b */
    public static class C5937b extends C1034u {
        RelativeLayout bDs;
        ImageView bVD;
        DynamicLoadingImageView bVz;

        public C5937b(View view) {
            super(view);
        }
    }

    public C5934e(Context context) {
        this.f3491pX = LayoutInflater.from(context);
    }

    /* renamed from: a */
    private void m16641a(StoryBoardItemInfo storyBoardItemInfo, DynamicLoadingImageView dynamicLoadingImageView) {
        if (storyBoardItemInfo != null) {
            if (storyBoardItemInfo instanceof StoryBoardXytItemInfo) {
                StoryBoardXytItemInfo storyBoardXytItemInfo = (StoryBoardXytItemInfo) storyBoardItemInfo;
                if (!TextUtils.isEmpty(storyBoardXytItemInfo.mThumbPath) && storyBoardXytItemInfo.mThumbPath.startsWith(SocialService.CONST_URL_HTTP_PREFIX)) {
                    ImageLoader.loadImage(storyBoardXytItemInfo.mThumbPath, dynamicLoadingImageView);
                    return;
                } else if (FileUtils.isFileExisted(storyBoardXytItemInfo.mThumbPath)) {
                    ImageLoader.loadImage(storyBoardXytItemInfo.mThumbPath, dynamicLoadingImageView);
                    return;
                }
            }
            long j = storyBoardItemInfo.lTemplateId > 0 ? storyBoardItemInfo.lTemplateId : storyBoardItemInfo.mEffectInfo == null ? 0 : storyBoardItemInfo.mEffectInfo.mTemplateId;
            if (j > 0) {
                String templateExternalFile = C8762d.aMt().getTemplateExternalFile(j, 0, 3);
                if (FileUtils.isFileExisted(templateExternalFile)) {
                    ImageLoader.loadImage(templateExternalFile, dynamicLoadingImageView);
                    return;
                }
            }
            if (storyBoardItemInfo.bmpThumbnail != null) {
                dynamicLoadingImageView.setImageBitmap(storyBoardItemInfo.bmpThumbnail);
            } else {
                C2570b.m7336hy(dynamicLoadingImageView.getContext()).mo12209w(new C6184a(storyBoardItemInfo.mEffectInfo != null ? storyBoardItemInfo.mEffectInfo.mPath : null, C8536m.cnS, C8536m.cnT)).mo12869dX(C8536m.cnS, C8536m.cnT).mo12186g(dynamicLoadingImageView);
            }
        }
    }

    /* renamed from: E */
    public C5937b onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f3491pX.inflate(R.layout.editor_effect_bubble_roll_item_layout, viewGroup, false);
        C5937b bVar = new C5937b(inflate);
        bVar.bDs = (RelativeLayout) inflate.findViewById(R.id.item_layout);
        bVar.bVz = (DynamicLoadingImageView) inflate.findViewById(R.id.div_roll_thumb);
        bVar.bVD = (ImageView) inflate.findViewById(R.id.iv_focus);
        return bVar;
    }

    /* renamed from: a */
    public void mo28554a(C5936a aVar) {
        this.cJo = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C5937b bVar, final int i) {
        bVar.bDs.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5934e.this.cJo != null) {
                    C5934e.this.cJo.mo28560z(view, i);
                }
            }
        });
        StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) this.mItemInfoList.get(i);
        if (storyBoardItemInfo != null) {
            m16641a(storyBoardItemInfo, bVar.bVz);
            if (this.cwZ == i) {
                bVar.bVD.setVisibility(0);
            } else {
                bVar.bVD.setVisibility(4);
            }
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(C5937b bVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(bVar, i);
        } else if (((StoryBoardItemInfo) this.mItemInfoList.get(i)) != null) {
            if (this.cwZ == i) {
                bVar.bVD.setVisibility(0);
            } else {
                bVar.bVD.setVisibility(4);
            }
        } else {
            return;
        }
        super.onBindViewHolder(bVar, i, list);
    }

    public int getItemCount() {
        if (this.mItemInfoList != null) {
            return this.mItemInfoList.size();
        }
        return 0;
    }

    /* renamed from: h */
    public void mo28557h(ArrayList<StoryBoardItemInfo> arrayList) {
        this.mItemInfoList = arrayList;
    }

    /* renamed from: kP */
    public void mo28558kP(int i) {
        this.cJn = this.cwZ;
        this.cwZ = i;
        notifyItemChanged(this.cJn, "");
        notifyItemChanged(this.cwZ, "");
    }
}
