package com.introvd.template.editor.advance;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.editor.R;
import com.introvd.template.p375r.p376a.C8360a;
import com.introvd.template.p375r.p376a.C8360a.C8363b;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.template.model.StoryBoardXytItemInfo;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;

/* renamed from: com.introvd.template.editor.advance.d */
public class C5597d extends C8360a<StoryBoardItemInfo> {
    public C5597d(Context context) {
        super(context);
        mo33622uD(R.layout.editor_pick_cover_roll_item_layout);
    }

    /* renamed from: a */
    private void m15330a(StoryBoardItemInfo storyBoardItemInfo, DynamicLoadingImageView dynamicLoadingImageView) {
        if (storyBoardItemInfo != null) {
            if (storyBoardItemInfo instanceof StoryBoardXytItemInfo) {
                StoryBoardXytItemInfo storyBoardXytItemInfo = (StoryBoardXytItemInfo) storyBoardItemInfo;
                if (FileUtils.isFileExisted(storyBoardXytItemInfo.mThumbPath)) {
                    ImageLoader.loadImage(storyBoardXytItemInfo.mThumbPath, dynamicLoadingImageView);
                    return;
                } else if (!TextUtils.isEmpty(storyBoardXytItemInfo.mThumbPath) && storyBoardXytItemInfo.mThumbPath.startsWith(SocialService.CONST_URL_HTTP_PREFIX)) {
                    ImageLoader.loadImage(storyBoardXytItemInfo.mThumbPath, dynamicLoadingImageView);
                    return;
                }
            }
            if (!TextUtils.isEmpty(storyBoardItemInfo.coverUrl)) {
                ImageLoader.loadImage(storyBoardItemInfo.coverUrl, dynamicLoadingImageView);
            } else if (storyBoardItemInfo.bmpThumbnail != null) {
                dynamicLoadingImageView.setImageBitmap(storyBoardItemInfo.bmpThumbnail);
            } else {
                dynamicLoadingImageView.setImageBitmap(null);
            }
        }
    }

    /* renamed from: a */
    public void mo27530a(C8363b bVar, int i) {
        StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) this.mItemInfoList.get(i);
        if (storyBoardItemInfo != null) {
            m15330a(storyBoardItemInfo, (DynamicLoadingImageView) bVar.mo33625n(R.id.icon));
            ImageView imageView = (ImageView) bVar.mo33625n(R.id.img_focus);
            if (ajC() == i) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(4);
            }
        }
    }

    public void acE() {
        notifyDataSetChanged();
    }

    /* renamed from: h */
    public void mo27532h(ArrayList<StoryBoardItemInfo> arrayList) {
        this.mItemInfoList = arrayList;
        acE();
    }

    /* renamed from: kP */
    public void mo27533kP(int i) {
        super.mo27533kP(i);
    }

    /* renamed from: kQ */
    public void mo27534kQ(int i) {
        notifyItemChanged(i);
    }
}
