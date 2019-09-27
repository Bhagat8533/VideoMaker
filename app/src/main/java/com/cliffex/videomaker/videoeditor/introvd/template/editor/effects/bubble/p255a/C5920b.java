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
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.template.model.StoryBoardXytItemInfo;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.effects.bubble.a.b */
public class C5920b extends C1008a<C5923b> {
    /* access modifiers changed from: private */
    public C5922a cIX;
    private int cwZ = -1;
    public List<StoryBoardItemInfo> mItemInfoList;

    /* renamed from: pX */
    private LayoutInflater f3485pX;

    /* renamed from: com.introvd.template.editor.effects.bubble.a.b$a */
    public interface C5922a {
        /* renamed from: z */
        void mo28536z(View view, int i);
    }

    /* renamed from: com.introvd.template.editor.effects.bubble.a.b$b */
    public static class C5923b extends C1034u {
        RelativeLayout bDs;
        ImageView bVD;
        DynamicLoadingImageView bVz;

        public C5923b(View view) {
            super(view);
        }
    }

    public C5920b(Context context) {
        this.f3485pX = LayoutInflater.from(context);
    }

    /* renamed from: a */
    private void m16601a(StoryBoardItemInfo storyBoardItemInfo, DynamicLoadingImageView dynamicLoadingImageView) {
        if (storyBoardItemInfo instanceof StoryBoardXytItemInfo) {
            StoryBoardXytItemInfo storyBoardXytItemInfo = (StoryBoardXytItemInfo) storyBoardItemInfo;
            if (!TextUtils.isEmpty(storyBoardXytItemInfo.mThumbPath) && (FileUtils.isFileExisted(storyBoardXytItemInfo.mThumbPath) || storyBoardXytItemInfo.mThumbPath.startsWith(SocialService.CONST_URL_HTTP_PREFIX))) {
                ImageLoader.loadImage(storyBoardXytItemInfo.mThumbPath, dynamicLoadingImageView);
                return;
            }
        }
        if (storyBoardItemInfo.bmpThumbnail != null) {
            dynamicLoadingImageView.setImageBitmap(storyBoardItemInfo.bmpThumbnail);
        } else {
            dynamicLoadingImageView.setImageBitmap(null);
        }
    }

    /* renamed from: B */
    public C5923b onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f3485pX.inflate(R.layout.editor_effect_anim_text_roll_item_layout, viewGroup, false);
        C5923b bVar = new C5923b(inflate);
        bVar.bDs = (RelativeLayout) inflate.findViewById(R.id.item_layout);
        bVar.bVz = (DynamicLoadingImageView) inflate.findViewById(R.id.div_roll_thumb);
        bVar.bVD = (ImageView) inflate.findViewById(R.id.iv_focus);
        return bVar;
    }

    /* renamed from: a */
    public void mo28530a(C5922a aVar) {
        this.cIX = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C5923b bVar, final int i) {
        bVar.bDs.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5920b.this.cIX != null) {
                    C5920b.this.cIX.mo28536z(view, i);
                }
            }
        });
        StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) this.mItemInfoList.get(i);
        if (storyBoardItemInfo != null) {
            m16601a(storyBoardItemInfo, bVar.bVz);
            if (this.cwZ == i) {
                bVar.bVD.setVisibility(0);
            } else {
                bVar.bVD.setVisibility(4);
            }
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(C5923b bVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(bVar, i);
        } else if (this.cwZ == i) {
            bVar.bVD.setVisibility(0);
        } else {
            bVar.bVD.setVisibility(4);
        }
    }

    public int getItemCount() {
        if (this.mItemInfoList != null) {
            return this.mItemInfoList.size();
        }
        return 0;
    }

    /* renamed from: h */
    public void mo28533h(ArrayList<StoryBoardItemInfo> arrayList) {
        this.mItemInfoList = arrayList;
    }

    /* renamed from: kP */
    public void mo28534kP(int i) {
        int i2 = this.cwZ;
        this.cwZ = i;
        notifyItemChanged(i2, "");
        notifyItemChanged(this.cwZ, "");
    }
}
