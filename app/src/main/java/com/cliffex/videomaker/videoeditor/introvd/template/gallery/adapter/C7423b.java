package com.introvd.template.gallery.adapter;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.imageloader.ImageLoader.SourceType;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.explorer.p300e.C7211d;
import com.introvd.template.gallery.view.GalleryFooterViewV2;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import com.introvd.template.xygallery.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.gallery.adapter.b */
public class C7423b extends C1008a<C7427b> {
    private List<MediaGroupItem> dCR = new ArrayList();
    private Map<String, Integer> dEw;
    private final int dGS;
    private boolean dGT = true;
    /* access modifiers changed from: private */
    public GalleryFooterViewV2 dGU;
    /* access modifiers changed from: private */
    public C7426a dGV;
    private Context mContext;

    /* renamed from: com.introvd.template.gallery.adapter.b$a */
    public interface C7426a {
        /* renamed from: hk */
        void mo32074hk(int i);
    }

    /* renamed from: com.introvd.template.gallery.adapter.b$b */
    class C7427b extends C1034u {
        RelativeLayout dGY;
        ImageView dGZ;
        TextView dHa;
        TextView dHb;
        ImageView dhg;

        C7427b(View view) {
            super(view);
            if (view != C7423b.this.dGU) {
                this.dGY = (RelativeLayout) view.findViewById(R.id.layout_album_item);
                this.dhg = (ImageView) view.findViewById(R.id.edit_album_cover);
                this.dGZ = (ImageView) view.findViewById(R.id.file_new_icon);
                this.dHa = (TextView) view.findViewById(R.id.edit_album_title);
                this.dHb = (TextView) view.findViewById(R.id.edit_album_item_num);
            }
        }
    }

    public C7423b(Context context) {
        this.mContext = context;
        this.dGS = C4583d.m11670O(context, 15);
    }

    /* renamed from: b */
    private void m21939b(final C7427b bVar, int i) {
        if (this.dCR != null && i >= 0 && i < this.dCR.size()) {
            MediaGroupItem mediaGroupItem = (MediaGroupItem) this.dCR.get(i);
            if (mediaGroupItem != null) {
                LayoutParams layoutParams = bVar.dGY.getLayoutParams();
                layoutParams.width = (Constants.getScreenSize().width - (this.dGS * 3)) / 2;
                layoutParams.height = (Constants.getScreenSize().width - (this.dGS * 3)) / 2;
                bVar.dGY.setLayoutParams(layoutParams);
                bVar.dGY.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (C7423b.this.dGV != null) {
                            C7423b.this.dGV.mo32074hk(bVar.getAdapterPosition());
                        }
                    }
                });
                if (mediaGroupItem.coverPhotoUrl != null) {
                    ImageLoader.loadImage(this.mContext, R.drawable.xiaoying_com_default_pic_bg, mediaGroupItem.coverPhotoUrl, bVar.dhg);
                } else {
                    ImageLoader.loadImage(this.mContext, R.drawable.xiaoying_com_default_pic_bg, ((ExtMediaItem) mediaGroupItem.mediaItemList.get(0)).thumbUrl, bVar.dhg);
                }
                bVar.dHb.setText(String.valueOf(mediaGroupItem.countForSns));
                bVar.dHa.setText(mediaGroupItem.strGroupDisplayName);
            }
        }
    }

    /* renamed from: c */
    private void m21940c(final C7427b bVar, int i) {
        if (getItemViewType(bVar.getAdapterPosition()) == 0) {
            LayoutParams layoutParams = bVar.dGY.getLayoutParams();
            layoutParams.width = (Constants.getScreenSize().width - (this.dGS * 3)) / 2;
            layoutParams.height = (Constants.getScreenSize().width - (this.dGS * 3)) / 2;
            bVar.dGY.setLayoutParams(layoutParams);
            bVar.dGY.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C7423b.this.dGV != null) {
                        C7423b.this.dGV.mo32074hk(bVar.getAdapterPosition());
                    }
                }
            });
            MediaGroupItem mediaGroupItem = (MediaGroupItem) this.dCR.get(i);
            ExtMediaItem extMediaItem = null;
            if (mediaGroupItem.mediaItemList.size() > 0) {
                extMediaItem = (ExtMediaItem) mediaGroupItem.mediaItemList.get(0);
            }
            if (extMediaItem != null || !TextUtils.isEmpty(mediaGroupItem.coverPhotoUrl)) {
                Integer num = (Integer) this.dEw.get(mediaGroupItem.strParentPath);
                if (this.mContext != null) {
                    if (num != null) {
                        try {
                            mediaGroupItem.strGroupDisplayName = this.mContext.getResources().getString(num.intValue());
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    bVar.dHa.setText(mediaGroupItem.strGroupDisplayName);
                    if (mediaGroupItem.lNewItemCount > 0) {
                        bVar.dGZ.setVisibility(0);
                    } else {
                        bVar.dGZ.setVisibility(4);
                    }
                    int a = C7149c.m21122a(mediaGroupItem);
                    int b = C7149c.m21137b(mediaGroupItem);
                    int i2 = a > 0 ? R.drawable.xiaoying_com_default_video_bg : R.drawable.xiaoying_com_default_pic_bg;
                    int i3 = a + b;
                    if (i3 == 0) {
                        bVar.dHb.setText(String.valueOf(mediaGroupItem.mediaItemList.size()));
                    } else {
                        bVar.dHb.setText(String.valueOf(i3));
                    }
                    if (extMediaItem != null && !TextUtils.isEmpty(extMediaItem.path)) {
                        ImageLoader.loadImage(this.mContext, i2, extMediaItem.path, bVar.dhg, SourceType.IMAGE);
                    } else if (!TextUtils.isEmpty(mediaGroupItem.coverPhotoUrl)) {
                        ImageLoader.loadImage(this.mContext, i2, mediaGroupItem.coverPhotoUrl, bVar.dhg, SourceType.IMAGE);
                    }
                }
            }
        } else if (getItemViewType(i) == 1) {
        }
    }

    /* renamed from: T */
    public C7427b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return (this.dGU == null || i != 1) ? new C7427b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gallery_item_folder, viewGroup, false)) : new C7427b(this.dGU);
    }

    /* renamed from: a */
    public void mo32065a(C7426a aVar) {
        this.dGV = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(C7427b bVar, int i) {
        if (this.dGT) {
            m21940c(bVar, i);
        } else {
            m21939b(bVar, i);
        }
    }

    /* renamed from: a */
    public void mo32067a(GalleryFooterViewV2 galleryFooterViewV2) {
        this.dGU = galleryFooterViewV2;
        notifyItemInserted(getItemCount() - 1);
    }

    public void ayW() {
        if (this.dGU != null) {
            this.dGU = null;
            notifyItemRemoved(getItemCount() - 1);
        }
    }

    /* renamed from: bY */
    public void mo32069bY(List<MediaGroupItem> list) {
        this.dGT = false;
        if (list != null) {
            this.dCR.clear();
            this.dCR.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* renamed from: bZ */
    public void mo32070bZ(List<MediaGroupItem> list) {
        this.dGT = true;
        if (list != null) {
            this.dEw = C7211d.ayb();
            this.dCR.clear();
            this.dCR.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        if (this.dGT) {
            return this.dGU != null ? this.dCR.size() + 1 : this.dCR.size();
        }
        return this.dCR == null ? 0 : this.dCR.size();
    }

    public int getItemViewType(int i) {
        return (this.dGU != null && i == getItemCount() - 1) ? 1 : 0;
    }

    /* renamed from: ro */
    public MediaGroupItem mo32071ro(int i) {
        return (MediaGroupItem) this.dCR.get(i);
    }
}
