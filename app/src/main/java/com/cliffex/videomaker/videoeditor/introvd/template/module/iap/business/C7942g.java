package com.introvd.template.module.iap.business;

import android.content.Context;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.p351b.C7830c;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.p339c.C7689a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.g */
class C7942g {

    /* renamed from: com.introvd.template.module.iap.business.g$a */
    private static class C7943a extends C7928f {
        private RecyclerView ama;

        C7943a(Context context, List<C7830c> list) {
            super(context, list);
        }

        /* renamed from: ci */
        private void m23084ci(List<C7830c> list) {
            if ((this.ama.getLayoutManager() instanceof GridLayoutManager ? ((GridLayoutManager) this.ama.getLayoutManager()).mo7557kr() : 1) == 2) {
                int ceil = (int) Math.ceil(((double) list.size()) / ((double) 2));
                int ceil2 = (int) Math.ceil(((double) ceil) / ((double) 4));
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < ceil2; i++) {
                    int i2 = 0;
                    while (true) {
                        int min = Math.min(ceil - (i * 4), 4);
                        if (i2 >= min) {
                            break;
                        }
                        if (i2 < list.size()) {
                            arrayList.add(list.get(i2));
                        }
                        int i3 = min + i2;
                        if (i3 < list.size()) {
                            arrayList.add(list.get(i3));
                        }
                        i2++;
                    }
                    list.removeAll(arrayList);
                }
                list.clear();
                list.addAll(arrayList);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ch */
        public void mo32891ch(List<C7830c> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            m23084ci(list);
            super.mo32891ch(list);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            this.ama = recyclerView;
        }
    }

    /* renamed from: a */
    private static void m23080a(RecyclerView recyclerView, TextView textView) {
        recyclerView.setNestedScrollingEnabled(false);
        Context context = recyclerView.getContext();
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2, 0, false));
        recyclerView.setAdapter(new C7943a(context, new ArrayList(0)));
        if (textView != null) {
            if (C8072q.aBx().isVip()) {
                textView.setText(R.string.iap_vip_renew_privilege_list_vip);
            } else {
                textView.setText(R.string.iap_vip_renew_privilege_list_no_vip);
            }
        }
    }

    private static int aBT() {
        return C7899c.aDg().getInt("user_enter_times", 0);
    }

    /* renamed from: d */
    private static C7928f m23081d(View view, int i, int i2, int i3) {
        if (!(view instanceof ViewGroup) || !(view.findViewById(i) instanceof RecyclerView)) {
            return null;
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        TextView textView = (TextView) view.findViewById(i2);
        if (i3 >= 0) {
            m23083sn(i3 + 1);
        } else {
            view.setPadding(0, C7689a.m22599ii(30), 0, 0);
        }
        m23080a(recyclerView, textView);
        return (C7928f) recyclerView.getAdapter();
    }

    /* renamed from: h */
    static C7928f m23082h(View view, int i, int i2, int i3, int i4) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        if (recyclerView != null) {
            return (C7928f) recyclerView.getAdapter();
        }
        int aBT = aBT();
        return aBT < 3 ? m23081d(((ViewStub) view.findViewById(i3)).inflate(), i, i2, aBT) : m23081d(((ViewStub) view.findViewById(i4)).inflate(), i, i2, -1);
    }

    /* renamed from: sn */
    private static void m23083sn(int i) {
        C7899c.aDg().setInt("user_enter_times", i);
    }
}
