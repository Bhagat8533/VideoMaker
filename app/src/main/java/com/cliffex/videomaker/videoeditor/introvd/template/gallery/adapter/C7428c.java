package com.introvd.template.gallery.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.p021v4.widget.Space;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.gallery.model.ItemInfo;
import com.introvd.template.gallery.p314d.C7472a;
import com.introvd.template.videoeditor.model.MEDIA_TYPE;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import com.introvd.template.xygallery.R;
import java.util.ArrayList;

/* renamed from: com.introvd.template.gallery.adapter.c */
public class C7428c extends C1008a<C7429a> {
    private int dHc = 4;
    private int dHd = 0;
    /* access modifiers changed from: private */
    public View dHe;
    private ArrayList<ItemInfo> dHf = new ArrayList<>();
    private C7149c dqZ;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: com.introvd.template.gallery.adapter.c$a */
    class C7429a extends C1034u {
        RelativeLayout dHg;
        TextView dHh;
        RelativeLayout dHi;
        RelativeLayout dHj;
        RelativeLayout dHk;
        RelativeLayout dHl;
        C7419a dHm;
        C7419a dHn;
        C7419a dHo;
        C7419a dHp;

        C7429a(View view) {
            super(view);
            if (view != C7428c.this.dHe) {
                this.dHg = (RelativeLayout) view.findViewById(R.id.layout_header_title);
                this.dHh = (TextView) view.findViewById(R.id.header_title);
                this.dHi = (RelativeLayout) view.findViewById(R.id.clip_layout01);
                this.dHj = (RelativeLayout) view.findViewById(R.id.clip_layout02);
                this.dHk = (RelativeLayout) view.findViewById(R.id.clip_layout03);
                this.dHl = (RelativeLayout) view.findViewById(R.id.clip_layout04);
                this.dHm = new C7419a(C7428c.this.mContext, this.dHi);
                this.dHn = new C7419a(C7428c.this.mContext, this.dHj);
                this.dHo = new C7419a(C7428c.this.mContext, this.dHk);
                this.dHp = new C7419a(C7428c.this.mContext, this.dHl);
                this.dHm.setHandler(C7428c.this.mHandler);
                this.dHn.setHandler(C7428c.this.mHandler);
                this.dHo.setHandler(C7428c.this.mHandler);
                this.dHp.setHandler(C7428c.this.mHandler);
            }
        }
    }

    public C7428c(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
        this.dHe = new Space(this.mContext);
        this.dHe.setLayoutParams(new LayoutParams(-1, C7472a.m22084gc(this.mContext) + 20));
    }

    /* renamed from: a */
    private void m21950a(C7429a aVar, ItemInfo itemInfo) {
        if (1 == itemInfo.childNum) {
            aVar.dHi.setVisibility(0);
            aVar.dHj.setVisibility(8);
            aVar.dHk.setVisibility(8);
            aVar.dHl.setVisibility(8);
            aVar.dHm.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex);
        } else if (2 == itemInfo.childNum) {
            aVar.dHi.setVisibility(0);
            aVar.dHj.setVisibility(0);
            aVar.dHk.setVisibility(8);
            aVar.dHl.setVisibility(8);
            aVar.dHm.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex);
            aVar.dHn.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex + 1);
        } else if (3 == itemInfo.childNum) {
            aVar.dHi.setVisibility(0);
            aVar.dHj.setVisibility(0);
            aVar.dHk.setVisibility(0);
            aVar.dHl.setVisibility(8);
            aVar.dHm.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex);
            aVar.dHn.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex + 1);
            aVar.dHo.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex + 2);
        } else if (4 == itemInfo.childNum) {
            aVar.dHi.setVisibility(0);
            aVar.dHj.setVisibility(0);
            aVar.dHk.setVisibility(0);
            aVar.dHl.setVisibility(0);
            aVar.dHm.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex);
            aVar.dHn.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex + 1);
            aVar.dHo.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex + 2);
            aVar.dHp.mo32060a(this.dqZ, itemInfo.groupNum, itemInfo.childStartIndex + 3);
        }
    }

    private void ayX() {
        this.dHd = 0;
        if (this.dqZ != null) {
            int groupCount = this.dqZ.getGroupCount();
            for (int i = 0; i < groupCount; i++) {
                int childrenCount = getChildrenCount(i);
                if (childrenCount % this.dHc == 0) {
                    this.dHd += childrenCount / this.dHc;
                } else {
                    this.dHd += (childrenCount / this.dHc) + 1;
                }
            }
            this.dHd += groupCount;
        }
        ayY();
    }

    private void ayY() {
        if (this.dHf != null) {
            this.dHf.clear();
        }
        if (this.dqZ != null) {
            int groupCount = this.dqZ.getGroupCount();
            for (int i = 0; i < groupCount; i++) {
                int childrenCount = getChildrenCount(i);
                if (childrenCount <= 0) {
                    this.dHd--;
                } else {
                    ItemInfo itemInfo = new ItemInfo();
                    itemInfo.groupNum = i;
                    itemInfo.childNum = 0;
                    this.dHf.add(itemInfo);
                    int i2 = 0;
                    while (childrenCount >= this.dHc) {
                        ItemInfo itemInfo2 = new ItemInfo();
                        itemInfo2.groupNum = i;
                        itemInfo2.childNum = this.dHc;
                        itemInfo2.childStartIndex = i2;
                        this.dHf.add(itemInfo2);
                        childrenCount -= this.dHc;
                        i2 += this.dHc;
                    }
                    if (childrenCount < this.dHc && childrenCount > 0) {
                        ItemInfo itemInfo3 = new ItemInfo();
                        itemInfo3.groupNum = i;
                        itemInfo3.childNum = childrenCount;
                        itemInfo3.childStartIndex = i2;
                        this.dHf.add(itemInfo3);
                    }
                }
            }
        }
    }

    private int getChildrenCount(int i) {
        if (this.dqZ != null) {
            return this.dqZ.mo31619qD(i);
        }
        return 0;
    }

    /* renamed from: rp */
    private boolean m21953rp(int i) {
        return this.dHf != null && this.dHf.size() > i && ((ItemInfo) this.dHf.get(i)).childNum == 0;
    }

    /* renamed from: U */
    public C7429a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return (this.dHe == null || i != 1) ? new C7429a(LayoutInflater.from(this.mContext).inflate(R.layout.gallery_include_media_list_item, viewGroup, false)) : new C7429a(this.dHe);
    }

    /* renamed from: a */
    public void onBindViewHolder(C7429a aVar, int i) {
        if (getItemViewType(aVar.getAdapterPosition()) == 0 && this.dqZ != null) {
            if (m21953rp(i)) {
                if (i == 0) {
                    aVar.itemView.setTag(Integer.valueOf(1));
                } else {
                    aVar.itemView.setTag(Integer.valueOf(2));
                }
                aVar.dHi.setVisibility(8);
                aVar.dHj.setVisibility(8);
                aVar.dHk.setVisibility(8);
                aVar.dHl.setVisibility(8);
                aVar.dHg.setVisibility(0);
                if (i < this.dHf.size()) {
                    MediaGroupItem qE = this.dqZ.mo31620qE(((ItemInfo) this.dHf.get(i)).groupNum);
                    if (qE != null) {
                        if (this.dqZ.awA() == MEDIA_TYPE.MEDIA_TYPE_FROM_XIAOYING) {
                            aVar.dHh.setText(qE.strGroupDisplayName);
                        } else {
                            aVar.dHh.setText(C7472a.m22083bW(this.mContext, qE.strGroupDisplayName));
                        }
                    }
                }
            } else {
                aVar.itemView.setTag(Integer.valueOf(3));
                aVar.dHg.setVisibility(8);
                if (i < this.dHf.size()) {
                    ItemInfo itemInfo = (ItemInfo) this.dHf.get(i);
                    if (itemInfo != null) {
                        m21950a(aVar, itemInfo);
                    }
                }
            }
            if (i < this.dHf.size()) {
                MediaGroupItem qE2 = this.dqZ.mo31620qE(((ItemInfo) this.dHf.get(i)).groupNum);
                if (qE2 != null) {
                    if (this.dqZ.awA() == MEDIA_TYPE.MEDIA_TYPE_FROM_XIAOYING) {
                        aVar.itemView.setContentDescription(qE2.strGroupDisplayName);
                    } else {
                        aVar.itemView.setContentDescription(C7472a.m22083bW(this.mContext, qE2.strGroupDisplayName));
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo32077d(C7149c cVar) {
        if (this.dqZ != null) {
            this.dqZ.unInit();
        }
        this.dqZ = cVar;
        ayX();
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.dHe == null ? this.dHd : this.dHd + 1;
    }

    public int getItemViewType(int i) {
        return (this.dHe != null && i == getItemCount() - 1) ? 1 : 0;
    }
}
