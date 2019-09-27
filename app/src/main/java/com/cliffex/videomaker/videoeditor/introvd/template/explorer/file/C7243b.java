package com.introvd.template.explorer.file;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.explorer.file.C7241a.C7242a;
import com.introvd.template.vivaexplorermodule.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.explorer.file.b */
public class C7243b extends BaseAdapter {
    private List<C7241a> bSa = new ArrayList();
    /* access modifiers changed from: private */
    public C7245a dyT = null;
    /* access modifiers changed from: private */
    public int dza = 0;
    public LayoutInflater mInflater;

    /* renamed from: com.introvd.template.explorer.file.b$a */
    public interface C7245a {
        void aws();
    }

    /* renamed from: com.introvd.template.explorer.file.b$b */
    class C7246b {
        RelativeLayout cJe;
        ImageView dze;
        TextView dzf;
        CheckBox dzg;
        RelativeLayout dzh;
        ImageView dzi;

        C7246b() {
        }
    }

    public C7243b(Context context, C7245a aVar) {
        this.mInflater = LayoutInflater.from(context);
        this.dyT = aVar;
    }

    public boolean awu() {
        return this.bSa.size() == this.dza;
    }

    /* renamed from: bN */
    public void mo31769bN(List<C7241a> list) {
        this.bSa = list;
        this.dza = 0;
    }

    public int getCount() {
        return this.bSa.size();
    }

    public Object getItem(int i) {
        return this.bSa.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final C7241a aVar = (C7241a) this.bSa.get(i);
        C7246b bVar = new C7246b();
        if (view == null) {
            view = this.mInflater.inflate(R.layout.xiaoying_com_file_item, null);
            bVar.dze = (ImageView) view.findViewById(R.id.file_icon);
            bVar.dzf = (TextView) view.findViewById(R.id.file_name);
            bVar.dzg = (CheckBox) view.findViewById(R.id.file_select);
            bVar.dzh = (RelativeLayout) view.findViewById(R.id.check_layout);
            bVar.cJe = (RelativeLayout) view.findViewById(R.id.item_layout);
            bVar.dzi = (ImageView) view.findViewById(R.id.file_item_divider);
            view.setTag(bVar);
        } else {
            bVar = (C7246b) view.getTag();
        }
        if (aVar.awt() == C7242a.DIREC_OR_FILE) {
            bVar.dzh.setVisibility(0);
        } else {
            bVar.dzh.setVisibility(4);
        }
        if (i < this.bSa.size() - 1) {
            bVar.dzi.setVisibility(0);
        } else {
            bVar.dzi.setVisibility(4);
        }
        bVar.dze.setBackgroundDrawable(aVar.getIcon());
        bVar.dzf.setText(aVar.getFileName());
        bVar.dzg.setChecked(aVar.isSelectable());
        final CheckBox checkBox = bVar.dzg;
        bVar.dzg.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                aVar.setSelectable(!aVar.isSelectable());
                checkBox.setChecked(aVar.isSelectable());
                if (aVar.isSelectable()) {
                    C7243b.this.dza = C7243b.this.dza + 1;
                } else {
                    C7243b.this.dza = C7243b.this.dza - 1;
                }
                if (C7243b.this.dyT != null) {
                    C7243b.this.dyT.aws();
                }
            }
        });
        return view;
    }

    /* renamed from: hW */
    public void mo31774hW(boolean z) {
        if (z) {
            this.dza = this.bSa.size();
        } else {
            this.dza = 0;
        }
    }
}
