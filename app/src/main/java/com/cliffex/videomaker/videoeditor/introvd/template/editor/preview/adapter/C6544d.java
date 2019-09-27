package com.introvd.template.editor.preview.adapter;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.preview.C6549b;
import com.p131c.p132a.p133a.C2564c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.introvd.template.editor.preview.adapter.d */
public class C6544d extends C1008a<C6546a> {
    private boolean bIV;
    private ArrayList<EditorToolItem> dao = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<EditorToolItem> dap = new ArrayList<>();
    /* access modifiers changed from: private */
    public C6547b daq;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.editor.preview.adapter.d$a */
    class C6546a extends C1034u {
        TextView alJ;
        ImageView cUD;
        ImageView dau;
        ImageView dav;

        /* renamed from: pc */
        ImageView f3511pc;

        C6546a(View view) {
            super(view);
            this.f3511pc = (ImageView) view.findViewById(R.id.tool_icon);
            this.alJ = (TextView) view.findViewById(R.id.tool_title);
            this.dau = (ImageView) view.findViewById(R.id.iv_tool_item_oval_flag);
            this.cUD = (ImageView) view.findViewById(R.id.iv_tool_item_vip_flag);
            this.dav = (ImageView) view.findViewById(R.id.iv_tool_item_new_flag);
        }
    }

    /* renamed from: com.introvd.template.editor.preview.adapter.d$b */
    public interface C6547b {
        /* renamed from: nI */
        void mo29860nI(int i);
    }

    public C6544d(Context context) {
        this.mContext = context;
        this.bIV = AppStateModel.getInstance().isInChina();
    }

    /* renamed from: j */
    private int m18982j(List<EditorToolItem> list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((EditorToolItem) list.get(i2)).mode == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: k */
    private EditorToolItem m18983k(List<EditorToolItem> list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            EditorToolItem editorToolItem = (EditorToolItem) list.get(i2);
            if (editorToolItem.mode == i) {
                return editorToolItem;
            }
        }
        return null;
    }

    /* renamed from: J */
    public C6546a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C6546a(LayoutInflater.from(this.mContext).inflate(R.layout.editor_preview_ops_tool_item, viewGroup, false));
    }

    /* renamed from: Y */
    public void mo29850Y(int i, boolean z) {
        int j = m18982j(this.dap, i);
        if (j >= 0 && j < this.dap.size()) {
            EditorToolItem editorToolItem = (EditorToolItem) this.dap.get(j);
            if (editorToolItem.bHightL != z) {
                editorToolItem.bHightL = z;
                notifyItemChanged(j);
            }
        }
    }

    /* renamed from: Z */
    public void mo29851Z(int i, boolean z) {
        if (C5843c.agO().agU()) {
            int j = m18982j(this.dap, i);
            if (z) {
                if (j < 0) {
                    int j2 = m18982j(this.dao, i);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.dap.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(m18982j(this.dao, ((EditorToolItem) it.next()).mode)));
                    }
                    arrayList.add(Integer.valueOf(j2));
                    Collections.sort(arrayList);
                    int indexOf = arrayList.indexOf(Integer.valueOf(j2));
                    EditorToolItem k = m18983k(this.dao, i);
                    if (k != null && indexOf >= 0) {
                        this.dap.add(indexOf, k);
                        notifyItemInserted(indexOf);
                    }
                }
            } else if (j >= 0) {
                this.dap.remove(j);
                notifyItemRemoved(j);
            }
        } else {
            int j3 = m18982j(this.dap, i);
            if (j3 >= 0 && j3 < this.dap.size() && ((EditorToolItem) this.dap.get(j3)).enable != z) {
                ((EditorToolItem) this.dap.get(j3)).enable = z;
                notifyItemChanged(j3);
            }
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(final C6546a aVar, int i) {
        LayoutParams layoutParams = aVar.itemView.getLayoutParams();
        layoutParams.width = (Constants.getScreenSize().width * 2) / 11;
        aVar.itemView.setLayoutParams(layoutParams);
        final EditorToolItem editorToolItem = (EditorToolItem) this.dap.get(i);
        if (editorToolItem != null) {
            aVar.f3511pc.setImageResource(editorToolItem.coverResID);
            if (!TextUtils.equals(editorToolItem.titleResID, aVar.alJ.getText())) {
                aVar.alJ.setText(editorToolItem.titleResID);
            }
            float f = 0.5f;
            aVar.alJ.setAlpha(editorToolItem.enable ? 1.0f : 0.5f);
            ImageView imageView = aVar.f3511pc;
            if (editorToolItem.enable) {
                f = 1.0f;
            }
            imageView.setAlpha(f);
            if (this.bIV) {
                aVar.alJ.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.editor_tool_domestic_text_size));
            } else {
                aVar.alJ.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.editor_tool_normal_text_size));
            }
            if (editorToolItem.bHightL) {
                aVar.dau.setVisibility(0);
                int i2 = editorToolItem.mode;
                if (i2 != 2007) {
                    switch (i2) {
                        case 2001:
                            aVar.dau.setImageResource(R.drawable.editor_shape_collage_color_point);
                            break;
                        case 2002:
                            aVar.dau.setImageResource(R.drawable.editor_shape_text_color_point);
                            break;
                        case 2003:
                            aVar.dau.setImageResource(R.drawable.editor_shape_sticker_color_point);
                            break;
                        case 2004:
                            aVar.dau.setImageResource(R.drawable.editor_shape_fx_color_point);
                            break;
                    }
                } else {
                    aVar.dau.setImageResource(R.drawable.editor_shape_mosaic_color_point);
                }
            } else {
                aVar.dau.setVisibility(8);
                aVar.dau.setImageResource(0);
            }
            if (editorToolItem.mode == 1002 || editorToolItem.mode == 2007 || editorToolItem.mode == 2008) {
                aVar.cUD.setVisibility(0);
            } else {
                aVar.cUD.setVisibility(8);
            }
            boolean ahh = C5842b.ahh();
            if (editorToolItem.mode == 1019) {
                aVar.cUD.setVisibility(!ahh ? 0 : 8);
            }
            if (editorToolItem.mode != 1019 || !ahh) {
                aVar.dav.setVisibility(8);
            } else {
                aVar.dav.setVisibility(0);
            }
            aVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (editorToolItem.mode == 1019) {
                        C5842b.ahi();
                        aVar.dav.setVisibility(8);
                        aVar.cUD.setVisibility(0);
                    }
                    int adapterPosition = aVar.getAdapterPosition();
                    if (adapterPosition != -1) {
                        if (!editorToolItem.enable) {
                            C6549b.m18997Z(C6544d.this.mContext, editorToolItem.mode);
                            return;
                        }
                        C2564c.m7327dA(aVar.f3511pc);
                        if (C6544d.this.daq != null) {
                            C6544d.this.daq.mo29860nI(((EditorToolItem) C6544d.this.dap.get(adapterPosition)).mode);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo29853a(C6547b bVar) {
        this.daq = bVar;
    }

    public ArrayList<EditorToolItem> apg() {
        return this.dao;
    }

    /* renamed from: b */
    public void mo29855b(int i, String str, int i2) {
        int j = m18982j(this.dap, i);
        if (j >= 0 && j < this.dap.size() && !((EditorToolItem) this.dap.get(j)).titleResID.equals(str)) {
            ((EditorToolItem) this.dap.get(j)).titleResID = str;
            ((EditorToolItem) this.dap.get(j)).coverResID = i2;
            notifyItemChanged(j);
        }
    }

    public int getItemCount() {
        return this.dap.size();
    }

    /* renamed from: gx */
    public void mo29856gx(boolean z) {
        int j = m18982j(this.dap, 1007);
        if (j >= 0 && j < this.dap.size()) {
            ((EditorToolItem) this.dap.get(j)).coverResID = z ? R.drawable.editor_icon_tool_mute_on : R.drawable.editor_icon_tool_mute_off;
            notifyItemChanged(j);
        }
    }

    /* renamed from: gy */
    public void mo29857gy(boolean z) {
        int j = m18982j(this.dap, 1017);
        if (j >= 0 && j < this.dap.size()) {
            ((EditorToolItem) this.dap.get(j)).coverResID = z ? R.drawable.editor_icon_clip_anim_on_tool : R.drawable.editor_icon_clip_anim_off_tool;
            notifyItemChanged(j);
        }
    }

    /* renamed from: k */
    public void mo29858k(ArrayList<EditorToolItem> arrayList) {
        this.dao.clear();
        this.dao.addAll(arrayList);
        this.dap.clear();
        if (C5843c.agO().agU()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                EditorToolItem editorToolItem = (EditorToolItem) it.next();
                if (editorToolItem.enable) {
                    this.dap.add(editorToolItem);
                }
            }
        } else {
            this.dap.addAll(arrayList);
        }
        notifyDataSetChanged();
    }
}
