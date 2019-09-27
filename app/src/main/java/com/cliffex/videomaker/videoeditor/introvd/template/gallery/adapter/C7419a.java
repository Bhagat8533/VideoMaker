package com.introvd.template.gallery.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.imageloader.ImageLoader.SourceType;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.gallery.C7431b;
import com.introvd.template.gallery.p314d.C7474b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sns.MediaType;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.xygallery.R;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import xiaoying.utils.QError;

/* renamed from: com.introvd.template.gallery.adapter.a */
public class C7419a {
    private int cUw = 148;
    /* access modifiers changed from: private */
    public C7422a dGJ;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: com.introvd.template.gallery.adapter.a$a */
    static class C7422a {
        RelativeLayout bMj;
        RelativeLayout cJe;
        ImageView dGN;
        RelativeLayout dGO;
        TextView dGP;
        ImageView dGQ;
        ImageView dGR;
        ImageView dze;

        C7422a() {
        }
    }

    public C7419a(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.dGJ = new C7422a();
        this.dGJ.dze = (ImageView) relativeLayout.findViewById(R.id.img_icon);
        this.dGJ.cJe = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout);
        this.dGJ.dGO = (RelativeLayout) relativeLayout.findViewById(R.id.layout_video_mark);
        this.dGJ.dGP = (TextView) relativeLayout.findViewById(R.id.txt_video_duration);
        this.dGJ.dGN = (ImageView) relativeLayout.findViewById(R.id.img_click_mask);
        this.dGJ.bMj = (RelativeLayout) relativeLayout.findViewById(R.id.xiaoying_gallery_preview_layout);
        this.dGJ.dGR = (ImageView) relativeLayout.findViewById(R.id.gallery_preview_btn);
        this.dGJ.dGQ = (ImageView) relativeLayout.findViewById(R.id.xiaoying_item_gif_mark);
        this.cUw = DeviceInfo.getScreenSize(this.mContext).width - (C4583d.m11670O(this.mContext, 1) * 3);
        this.cUw /= 4;
    }

    /* renamed from: a */
    public void mo32060a(C7149c cVar, final int i, final int i2) {
        ExtMediaItem de = cVar.mo31616de(i, i2);
        if (de != null) {
            int GetFileMediaType = MediaFileUtils.GetFileMediaType(de.path);
            boolean z = GetFileMediaType == 210;
            LayoutParams layoutParams = (LayoutParams) this.dGJ.cJe.getLayoutParams();
            int i3 = this.cUw;
            layoutParams.height = i3;
            layoutParams.width = i3;
            this.dGJ.cJe.setLayoutParams(layoutParams);
            if (MediaFileUtils.IsImageFileType(GetFileMediaType) || de.mediaType == MediaType.MEDIA_TYPE_IMAGE) {
                ImageLoader.loadImage(this.mContext, R.drawable.xiaoying_com_default_pic_bg, de.path, this.dGJ.dze, SourceType.IMAGE);
                if (C7431b.aym().ayo()) {
                    this.dGJ.dGR.setImageResource(R.drawable.gallery_img_preview_icon);
                } else {
                    this.dGJ.bMj.setVisibility(8);
                }
                this.dGJ.dGQ.setVisibility(C7474b.m22085jM(de.path) ? 0 : 8);
                this.dGJ.dGO.setVisibility(8);
                this.dGJ.dGP.setVisibility(8);
            } else if ((MediaFileUtils.IsVideoFileType(GetFileMediaType) || de.duration > 0) && de.mediaType != MediaType.MEDIA_TYPE_VIDEO) {
                if (z) {
                    ImageLoader.loadImage(this.mContext, R.drawable.xiaoying_com_default_video_bg, this.dGJ.dze);
                } else {
                    ImageLoader.loadImage(this.mContext, R.drawable.xiaoying_com_default_video_bg, de.path, this.dGJ.dze, SourceType.VIDEO);
                }
                this.dGJ.dGO.setVisibility(0);
                this.dGJ.dGP.setText(C4580b.m11658eD(C4580b.m11637V((long) ((int) de.duration))));
                this.dGJ.dGP.setVisibility(0);
                if (C7431b.aym().ayn()) {
                    this.dGJ.dGR.setImageResource(R.drawable.gallery_video_preview_icon);
                } else {
                    this.dGJ.bMj.setVisibility(8);
                }
            } else if (de.mediaType == MediaType.MEDIA_TYPE_VIDEO) {
                ImageLoader.loadImage(this.mContext, R.drawable.xiaoying_com_default_video_bg, de.thumbUrl, this.dGJ.dze, SourceType.VIDEO);
                this.dGJ.dGO.setVisibility(0);
                if (de.duration > 0) {
                    this.dGJ.dGP.setText(C4580b.m11658eD(C4580b.m11637V((long) ((int) de.duration))));
                    this.dGJ.dGP.setVisibility(0);
                } else {
                    this.dGJ.dGP.setVisibility(8);
                }
                if (C7431b.aym().ayn()) {
                    this.dGJ.dGR.setImageResource(R.drawable.gallery_video_preview_icon);
                } else {
                    this.dGJ.bMj.setVisibility(8);
                }
            }
            C2579b.m7399a(new C2582a<View>() {
                public void onClick(View view) {
                    C2564c.m7327dA(C7419a.this.dGJ.dGR);
                    C7419a.this.mHandler.sendMessage(C7419a.this.mHandler.obtainMessage(20483, i, i2));
                }
            }, this.dGJ.bMj);
            C2579b.m7398a(new C2582a<View>() {
                public void onClick(View view) {
                    C7419a.this.mHandler.sendMessage(C7419a.this.mHandler.obtainMessage(QError.QERR_DISPLAY_INIT_FAIL, i, i2));
                }
            }, MediaFileUtils.IsImageFileType(GetFileMediaType) || de.mediaType == MediaType.MEDIA_TYPE_IMAGE ? 50 : 500, this.dGJ.dGN);
        }
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }
}
