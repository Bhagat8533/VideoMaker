package com.introvd.template.p414ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.dialog.C8966i.C8968a;
import java.util.ArrayList;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.c */
public class C8945c extends C8943a implements OnClickListener, OnItemClickListener {
    private C8948b ewA;
    private Object ewB = null;
    private Object ewC = null;
    /* access modifiers changed from: private */
    public ArrayList<C8965h> ewx;
    private GridView ewy;
    private C8947a ewz;
    private Context mContext;
    /* access modifiers changed from: private */
    public LayoutInflater mInflater;

    /* renamed from: com.introvd.template.ui.dialog.c$a */
    private class C8947a extends BaseAdapter {
        private C8947a() {
        }

        public int getCount() {
            return C8945c.this.ewx.size();
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C8949c cVar;
            C8965h hVar = (C8965h) C8945c.this.ewx.get(i);
            if (view == null) {
                view = C8945c.this.mInflater.inflate(C10122R.C10126layout.xiaoying_com_dialog_grid_item, null);
                cVar = new C8949c();
                cVar.dze = (ImageView) view.findViewById(C10122R.C10124id.img_icon);
                cVar.ewE = (TextView) view.findViewById(C10122R.C10124id.txt_name);
                view.setTag(cVar);
            } else {
                cVar = (C8949c) view.getTag();
            }
            if (hVar != null) {
                if (-1 != hVar.dUD) {
                    cVar.dze.setImageResource(hVar.dUD);
                } else {
                    cVar.dze.setImageDrawable(hVar.exo);
                }
                cVar.ewE.setText(hVar.exp);
            }
            return view;
        }
    }

    /* renamed from: com.introvd.template.ui.dialog.c$b */
    public interface C8948b {
        void buttonClick(int i);

        void itemClick(int i);
    }

    /* renamed from: com.introvd.template.ui.dialog.c$c */
    private static class C8949c {
        ImageView dze;
        TextView ewE;

        private C8949c() {
        }
    }

    public C8945c(Context context, ArrayList<C8965h> arrayList, C8948b bVar) {
        super(context);
        this.mInflater = LayoutInflater.from(context);
        this.f3621PM = this.mInflater.inflate(C10122R.C10126layout.xiaoying_com_dialog_grid, null);
        this.mContext = context;
        this.ewx = arrayList;
        this.ewA = bVar;
        this.ewN.f3623zd = this.f3621PM;
        this.mContext = context;
        this.ewy = (GridView) this.f3621PM.findViewById(C10122R.C10124id.gridview);
    }

    /* renamed from: Q */
    public void mo31986Q(Object obj) {
        this.ewC = obj;
    }

    public void onClick(View view) {
        switch ((C8968a) view.getTag()) {
            case POSITIVE:
                if (this.ewA != null) {
                    this.ewA.buttonClick(1);
                    break;
                }
                break;
            case NEGATIVE:
                if (this.ewA != null) {
                    this.ewA.buttonClick(0);
                    break;
                }
                break;
        }
        dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ewz = new C8947a();
        this.ewy.setAdapter(this.ewz);
        this.ewy.setOnItemClickListener(this);
        int size = (this.ewx.size() / 3) + (this.ewx.size() % 3 == 0 ? 0 : 1);
        if (this.ewx.size() <= 9) {
            LayoutParams layoutParams = (LayoutParams) this.ewy.getLayoutParams();
            layoutParams.height = C4583d.m11670O(this.mContext, size * 82);
            this.ewy.setLayoutParams(layoutParams);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) this.ewy.getLayoutParams();
        layoutParams2.height = C4583d.m11670O(this.mContext, 287);
        this.ewy.setLayoutParams(layoutParams2);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.ewA != null) {
            this.ewA.itemClick(i);
        }
        dismiss();
    }

    public void setButtonText(int i) {
        this.ewN.amB = this.ewN.context.getText(i);
    }
}
