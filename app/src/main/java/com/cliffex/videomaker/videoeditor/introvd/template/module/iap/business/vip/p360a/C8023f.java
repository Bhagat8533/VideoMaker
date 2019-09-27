package com.introvd.template.module.iap.business.vip.p360a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.introvd.template.module.iap.R;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.vip.a.f */
class C8023f extends BaseAdapter {
    private List<String> bvs;
    private Context context;
    private int dUD = R.layout.iap_vip_recycle_item_function_dialog_layout;

    /* renamed from: com.introvd.template.module.iap.business.vip.a.f$a */
    class C8024a {
        TextView dUE;

        C8024a() {
        }
    }

    C8023f(Context context2, List<String> list) {
        this.context = context2;
        this.bvs = list;
    }

    public int getCount() {
        if (this.bvs != null) {
            return this.bvs.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        return this.bvs.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C8024a aVar;
        String str = (String) this.bvs.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(this.dUD, null);
            aVar = new C8024a();
            aVar.dUE = (TextView) view.findViewById(R.id.vip_home_dialog_item);
            view.setTag(aVar);
        } else {
            aVar = (C8024a) view.getTag();
        }
        aVar.dUE.setText(str);
        return view;
    }
}
