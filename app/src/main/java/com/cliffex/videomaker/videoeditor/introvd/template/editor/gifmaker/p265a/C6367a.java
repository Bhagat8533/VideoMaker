package com.introvd.template.editor.gifmaker.p265a;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.p203b.C4580b;
import com.p131c.p132a.p133a.C2564c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.gifmaker.a.a */
public class C6367a extends C1008a<C6370b> {
    private int cUw;
    /* access modifiers changed from: private */
    public C6369a cUx;
    private Context mContext;
    private List<EditorToolItem> mItemInfoList = new ArrayList();

    /* renamed from: com.introvd.template.editor.gifmaker.a.a$a */
    public interface C6369a {
        /* renamed from: hk */
        void mo29412hk(int i);
    }

    /* renamed from: com.introvd.template.editor.gifmaker.a.a$b */
    static class C6370b extends C1034u {
        ImageButton cUB;
        TextView cUC;
        ImageView cUD;

        C6370b(View view) {
            super(view);
            this.cUB = (ImageButton) view.findViewById(R.id.tool_cover);
            this.cUC = (TextView) view.findViewById(R.id.tool_title);
            this.cUD = (ImageView) view.findViewById(R.id.iv_item_vip_flag);
        }
    }

    public C6367a(Context context) {
        this.mContext = context;
        this.cUw = (int) (((float) Constants.getScreenSize().width) / 5.5f);
    }

    /* renamed from: H */
    public C6370b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C6370b(LayoutInflater.from(this.mContext).inflate(R.layout.editor_gifmaker_tool_item_layout, viewGroup, false));
    }

    /* renamed from: a */
    public void mo29415a(C6369a aVar) {
        this.cUx = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(final C6370b bVar, int i) {
        final EditorToolItem editorToolItem = (EditorToolItem) this.mItemInfoList.get(i);
        if (editorToolItem != null) {
            LayoutParams layoutParams = bVar.itemView.getLayoutParams();
            layoutParams.width = this.cUw;
            layoutParams.height = this.cUw;
            bVar.itemView.setLayoutParams(layoutParams);
            bVar.cUC.setText(editorToolItem.titleResID);
            ImageLoader.loadImage(this.mContext, editorToolItem.coverResID, (ImageView) bVar.cUB);
            if (editorToolItem.mode == 1002) {
                bVar.cUD.setVisibility(0);
            } else {
                bVar.cUD.setVisibility(8);
            }
            bVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C4580b.m11632Sf() && C6367a.this.cUx != null) {
                        C2564c.m7327dA(bVar.cUB);
                        C6367a.this.cUx.mo29412hk(editorToolItem.mode);
                    }
                }
            });
        }
    }

    /* renamed from: ba */
    public void mo29417ba(List<EditorToolItem> list) {
        if (list != null && list.size() > 0) {
            this.mItemInfoList = list;
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        if (this.mItemInfoList == null) {
            return 0;
        }
        return this.mItemInfoList.size();
    }
}
