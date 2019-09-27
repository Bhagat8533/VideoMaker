package com.introvd.template.editor.studio;

import android.content.Context;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.GridLayoutManager.C0986b;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.sdk.p390f.C8445a;
import java.util.List;

/* renamed from: com.introvd.template.editor.studio.a */
public class C6892a extends C4417b<C8445a> {
    private Context context;
    private boolean diH = false;
    /* access modifiers changed from: private */
    public C6912c diI = null;
    private int diJ;

    /* renamed from: com.introvd.template.editor.studio.a$a */
    private class C6897a extends C1034u {
        public C6897a(View view) {
            super(view);
        }
    }

    /* renamed from: com.introvd.template.editor.studio.a$b */
    private class C6898b extends C1034u {
        /* access modifiers changed from: private */
        public ImageView diN;
        /* access modifiers changed from: private */
        public ImageView diO;
        /* access modifiers changed from: private */
        public TextView diP;

        public C6898b(View view) {
            super(view);
            this.diN = (ImageView) view.findViewById(R.id.studio_img_project_thumb);
            this.diO = (ImageView) view.findViewById(R.id.studio_img_delete);
            this.diP = (TextView) view.findViewById(R.id.studio_item_time_duration);
        }
    }

    public C6892a(Context context2) {
        this.context = context2;
        if (Constants.getScreenSize() != null) {
            this.diJ = Constants.getScreenSize().width / 3;
        } else {
            this.diJ = 0;
        }
    }

    /* renamed from: a */
    public void mo30542a(C6912c cVar) {
        this.diI = cVar;
    }

    public List<C8445a> getDataList() {
        return this.mList;
    }

    public int getItemCount() {
        int i = (isSupportHeaderItem() ? 1 : 0) + (isSupportFooterItem() ? 1 : 0);
        return this.mList == null ? i : i + this.mList.size();
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public boolean isSupportFooterItem() {
        return true;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            if (gridLayoutManager.mo7557kr() > 0) {
                gridLayoutManager.mo7544a(new C0986b() {
                    /* renamed from: bU */
                    public int mo7575bU(int i) {
                        return C6892a.this.isFooterItem(i) ? 3 : 1;
                    }
                });
            }
        }
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, int i) {
        final int realItemPosition = getRealItemPosition(i);
        final C8445a aVar = (C8445a) getListItem(realItemPosition, true);
        if (aVar != null) {
            C6898b bVar = (C6898b) uVar;
            LayoutParams layoutParams = (LayoutParams) bVar.diN.getLayoutParams();
            layoutParams.width = this.diJ;
            layoutParams.height = this.diJ;
            bVar.itemView.setTag(Integer.valueOf(realItemPosition));
            bVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C4580b.m11632Sf() && C6892a.this.diI != null) {
                        C6892a.this.diI.mo30557a(aVar);
                    }
                }
            });
            bVar.itemView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (((Integer) view.getTag()).intValue() < 0 || C6892a.this.diI == null) {
                        return false;
                    }
                    C6892a.this.diI.mo30560c(aVar);
                    return true;
                }
            });
            String str = aVar.strPrjThumbnail;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(FileUtils.fileSize(str));
            ImageLoader.loadImageWithSignature(this.context, str, bVar.diN, sb.toString());
            bVar.diP.setText(C4580b.m11637V(aVar.egs));
            bVar.diO.setTag(Integer.valueOf(i));
            bVar.diO.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C6892a.this.diI != null) {
                        C6892a.this.diI.mo30558a(aVar, realItemPosition);
                    }
                }
            });
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return new C6897a(LayoutInflater.from(this.context).inflate(R.layout.editor_studio_recyclerview_item_layout, null));
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new C6898b(LayoutInflater.from(this.context).inflate(R.layout.editor_studio_grid_comm_item_layout, null));
    }

    public void removeItem(int i) {
        if (this.mList != null && this.mList.size() - 1 >= i) {
            this.mList.remove(i);
        }
        notifyDataSetChanged();
    }

    public void setDataList(List<C8445a> list) {
        super.setDataList(list);
    }
}
