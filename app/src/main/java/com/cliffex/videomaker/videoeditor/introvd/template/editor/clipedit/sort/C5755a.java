package com.introvd.template.editor.clipedit.sort;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.p414ui.view.p415a.C8986a.C8987a;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.introvd.template.editor.clipedit.sort.a */
public class C5755a extends C1008a<C5758b> implements C8987a {
    private ArrayList<EditorToolItem> cBD = new ArrayList<>();
    /* access modifiers changed from: private */
    public C5757a cBI;
    private Context context;

    /* renamed from: com.introvd.template.editor.clipedit.sort.a$a */
    public interface C5757a {
        /* renamed from: X */
        void mo28027X(C1034u uVar);
    }

    /* renamed from: com.introvd.template.editor.clipedit.sort.a$b */
    class C5758b extends C1034u {
        TextView cBL;
        RelativeLayout cBM;
        ImageView mIcon;

        C5758b(View view) {
            super(view);
            this.cBL = (TextView) view.findViewById(R.id.item_text);
            this.mIcon = (ImageView) view.findViewById(R.id.item_icon);
            this.cBM = (RelativeLayout) view.findViewById(R.id.item_button);
        }
    }

    public C5755a(Context context2, ArrayList<EditorToolItem> arrayList) {
        this.context = context2;
        if (arrayList != null && arrayList.size() > 0) {
            this.cBD.addAll(arrayList);
        }
    }

    /* renamed from: a */
    public void mo28028a(C5757a aVar) {
        this.cBI = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(final C5758b bVar, int i) {
        EditorToolItem editorToolItem = (EditorToolItem) this.cBD.get(i);
        bVar.cBL.setText(editorToolItem.titleResID);
        bVar.mIcon.setImageResource(editorToolItem.coverResID);
        bVar.cBM.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (C5755a.this.cBI != null) {
                    C5755a.this.cBI.mo28027X(bVar);
                }
                return true;
            }
        });
    }

    public ArrayList<EditorToolItem> afz() {
        return this.cBD;
    }

    /* renamed from: cp */
    public void mo28031cp(int i, int i2) {
        if (i < i2) {
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                Collections.swap(this.cBD, i3, i4);
                i3 = i4;
            }
        } else {
            for (int i5 = i; i5 > i2; i5--) {
                Collections.swap(this.cBD, i5, i5 - 1);
            }
        }
        notifyItemMoved(i, i2);
    }

    public int getItemCount() {
        if (this.cBD == null) {
            return 0;
        }
        return this.cBD.size() - 1;
    }

    /* renamed from: lo */
    public void mo28032lo(int i) {
        this.cBD.remove(i);
        notifyItemRemoved(i);
    }

    /* renamed from: y */
    public C5758b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C5758b(LayoutInflater.from(this.context).inflate(R.layout.editor_sort_tool_list_item_layout, viewGroup, false));
    }
}
