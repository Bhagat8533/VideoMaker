package com.introvd.template.gallery.storyboard;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.xygallery.R;
import java.util.List;

/* renamed from: com.introvd.template.gallery.storyboard.b */
public class C7487b extends C7485a {
    private boolean dJg = false;

    /* renamed from: com.introvd.template.gallery.storyboard.b$a */
    private class C7489a {
        ImageView bVD;
        RelativeLayout cJe;
        TextView dJi;
        TextView dJj;
        ImageView dJk;
        ImageView dJl;
        RelativeLayout dJm;
        ImageView diN;

        private C7489a() {
        }
    }

    public C7487b(Context context) {
        super(context);
    }

    /* renamed from: H */
    public /* bridge */ /* synthetic */ Animation mo32201H(int i, int i2, int i3) {
        return super.mo32201H(i, i2, i3);
    }

    public /* bridge */ /* synthetic */ void azn() {
        super.azn();
    }

    public /* bridge */ /* synthetic */ boolean azo() {
        return super.azo();
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo32204c(View view, int i, int i2, int i3) {
        super.mo32204c(view, i, i2, i3);
    }

    /* renamed from: dj */
    public /* bridge */ /* synthetic */ void mo32205dj(int i, int i2) {
        super.mo32205dj(i, i2);
    }

    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    public /* bridge */ /* synthetic */ int getFocusIndex() {
        return super.getFocusIndex();
    }

    public Object getItem(int i) {
        if (i < 0 || i >= this.mItemInfoList.size()) {
            return null;
        }
        return this.mItemInfoList.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        C7489a aVar;
        StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) this.mItemInfoList.get(i);
        if (view == null) {
            C7489a aVar2 = new C7489a();
            View inflate = this.dIk.inflate(R.layout.gallery_item_storyboard_clipitem, null);
            aVar2.diN = (ImageView) inflate.findViewById(R.id.icon);
            aVar2.dJk = (ImageView) inflate.findViewById(R.id.img_delete);
            aVar2.bVD = (ImageView) inflate.findViewById(R.id.img_focus);
            aVar2.cJe = (RelativeLayout) inflate.findViewById(R.id.item_layout);
            aVar2.dJm = (RelativeLayout) inflate.findViewById(R.id.thumb_layout);
            aVar2.dJj = (TextView) inflate.findViewById(R.id.text_num);
            aVar2.dJi = (TextView) inflate.findViewById(R.id.text_clip_duration);
            aVar2.dJl = (ImageView) inflate.findViewById(R.id.img_video_mark);
            LayoutParams layoutParams = (LayoutParams) aVar2.cJe.getLayoutParams();
            layoutParams.width = this.bvC;
            layoutParams.height = layoutParams.width;
            aVar2.cJe.setLayoutParams(layoutParams);
            inflate.setTag(aVar2);
            View view2 = inflate;
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (C7489a) view.getTag();
        }
        view.setVisibility(0);
        view.clearAnimation();
        aVar.dJk.setVisibility(0);
        aVar.dJj.setVisibility(4);
        int i2 = i + 1;
        if (i2 >= 100) {
            aVar.dJj.setTextSize(2, 9.0f);
        } else {
            aVar.dJj.setTextSize(2, 10.0f);
        }
        if (!this.dJg) {
            storyBoardItemInfo.orderNo = i2;
        }
        aVar.dJj.setText(String.valueOf(storyBoardItemInfo.orderNo));
        if (storyBoardItemInfo.bmpThumbnail != null) {
            if (storyBoardItemInfo.mRotation > 0.0f) {
                aVar.diN.setRotation(storyBoardItemInfo.mRotation);
            } else {
                aVar.diN.setRotation(0.0f);
            }
            aVar.diN.setImageBitmap(storyBoardItemInfo.bmpThumbnail);
        } else {
            ImageLoader.loadImage(this.mContext, R.drawable.drawable_color_black, storyBoardItemInfo.mSourcePath, aVar.diN);
        }
        if (storyBoardItemInfo.isVideo) {
            aVar.dJl.setVisibility(0);
            aVar.dJi.setVisibility(0);
            aVar.dJl.setImageResource(R.drawable.gallery_icon_audio_type_video);
            aVar.dJi.setText(C4580b.m11637V((long) ((int) storyBoardItemInfo.lDuration)));
        } else if (storyBoardItemInfo.isGif) {
            aVar.dJl.setVisibility(0);
            aVar.dJi.setVisibility(8);
            aVar.dJl.setImageResource(R.drawable.gallery_icon_audio_type_gif);
        } else {
            aVar.dJi.setVisibility(4);
            aVar.dJl.setVisibility(8);
        }
        aVar.dJk.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C7487b.this.dIp) {
                    C7487b.this.dIr = i;
                    if (C7487b.this.mHandler != null) {
                        C7487b.this.mHandler.sendMessage(C7487b.this.mHandler.obtainMessage(12290, i, 0));
                    }
                }
            }
        });
        if (i >= this.dIr && -1 != this.dIr && !this.dIp) {
            mo32204c(view, i, this.bvC, this.cEs);
        } else if (this.dIr != getCount() || -1 == this.dIr) {
            this.dIq = false;
        } else {
            this.dIq = true;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(12291));
        }
        if (this.dIm && i == this.dIl && !this.dIn) {
            view.setVisibility(4);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(8193);
            this.mHandler.sendEmptyMessageDelayed(8193, 100);
        }
        if (this.dJg) {
            aVar.dJk.setVisibility(8);
            aVar.bVD.setVisibility(0);
            aVar.dJj.setVisibility(0);
        } else {
            aVar.dJk.setVisibility(0);
            aVar.bVD.setVisibility(8);
            aVar.dJj.setVisibility(8);
        }
        return view;
    }

    /* renamed from: il */
    public /* bridge */ /* synthetic */ void mo32209il(boolean z) {
        super.mo32209il(z);
    }

    /* renamed from: im */
    public /* bridge */ /* synthetic */ void mo32210im(boolean z) {
        super.mo32210im(z);
    }

    /* renamed from: in */
    public /* bridge */ /* synthetic */ void mo32211in(boolean z) {
        super.mo32211in(z);
    }

    /* renamed from: io */
    public /* bridge */ /* synthetic */ void mo32212io(boolean z) {
        super.mo32212io(z);
    }

    /* renamed from: ip */
    public void mo32225ip(boolean z) {
        this.dJg = z;
        notifyDataSetChanged();
    }

    /* renamed from: rA */
    public /* bridge */ /* synthetic */ void mo32213rA(int i) {
        super.mo32213rA(i);
    }

    /* renamed from: rB */
    public /* bridge */ /* synthetic */ void mo32214rB(int i) {
        super.mo32214rB(i);
    }

    /* renamed from: rx */
    public /* bridge */ /* synthetic */ int mo32215rx(int i) {
        return super.mo32215rx(i);
    }

    /* renamed from: ry */
    public /* bridge */ /* synthetic */ void mo32216ry(int i) {
        super.mo32216ry(i);
    }

    /* renamed from: rz */
    public /* bridge */ /* synthetic */ void mo32217rz(int i) {
        super.mo32217rz(i);
    }

    public /* bridge */ /* synthetic */ void setHandler(Handler handler) {
        super.setHandler(handler);
    }

    public /* bridge */ /* synthetic */ void setList(List list) {
        super.setList(list);
    }
}
