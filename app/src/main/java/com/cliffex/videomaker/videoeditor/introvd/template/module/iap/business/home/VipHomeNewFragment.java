package com.introvd.template.module.iap.business.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8061k;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.home.p358a.C7962b;
import com.introvd.template.module.iap.business.home.p358a.C7967c;
import com.introvd.template.module.iap.business.home.p358a.C7968d;
import com.introvd.template.module.iap.business.home.p359b.C7970a;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.vip.p360a.C8033i;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.router.AdRouter.VipHomeParams;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.router.user.UserServiceProxy;
import com.yan.rippledrawable.RippleLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@LDPProtect
public class VipHomeNewFragment extends Fragment implements C7988a {
    private ListView dTM;
    private GridView dTN;
    private TextView dTO;
    /* access modifiers changed from: private */
    public List<C7967c> dTP = new ArrayList();
    /* access modifiers changed from: private */
    public int dTQ = -1;
    /* access modifiers changed from: private */
    public C7986h dTR = new C7986h(this);

    /* renamed from: com.introvd.template.module.iap.business.home.VipHomeNewFragment$a */
    private abstract class C7957a<T> extends BaseAdapter {
        private int dTV = -1;
        private List<T> items;

        C7957a(List<T> list) {
            this.items = list;
        }

        C7957a(List<T> list, int i) {
            this.items = list;
            this.dTV = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: F */
        public View mo32925F(View view, int i) {
            int itemViewType = getItemViewType(i);
            if (view == null || !(view.getTag() instanceof Integer) || ((Integer) view.getTag()).intValue() == itemViewType) {
                return view;
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: G */
        public View mo32926G(View view, int i) {
            view.setTag(Integer.valueOf(getItemViewType(i)));
            return view;
        }

        public int getCount() {
            int size = this.items == null ? 0 : this.items.size();
            return this.dTV != -1 ? Math.min(size, this.dTV) : size;
        }

        public Object getItem(int i) {
            if (this.items == null) {
                return null;
            }
            return this.items.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return VipHomeNewFragment.this.dTP.size() <= 2 ? 1 : 2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Pz */
    public void m23100Pz() {
        if (!C8048e.aBe().mo23644bB(true)) {
            ToastUtils.show(getContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
            return;
        }
        if (C8048e.aBe().isInChina()) {
            if (!UserServiceProxy.isLogin()) {
                C8048e.aBe().mo23621Mm();
            }
            this.dTR.mo32975PA();
        } else {
            C8048e.aBe().mo23636a((Activity) getActivity(), (OnClickListener) new OnClickListener() {
                public void onClick(View view) {
                    VipHomeNewFragment.this.dTR.mo32975PA();
                }
            });
        }
    }

    private void aDD() {
        if (this.dTP.isEmpty()) {
            if (C8048e.aBe().isInChina()) {
                ArrayList arrayList = new ArrayList();
                for (C7832c cVar : this.dTR.getItems()) {
                    C7967c cVar2 = new C7967c();
                    cVar2.goodsId = cVar.getId();
                    cVar2.title = cVar.getName();
                    cVar2.description = cVar.getLabel();
                    cVar2.dQa = cVar.mo32756sp();
                    cVar2.dQb = cVar.aCB();
                    arrayList.add(cVar2);
                }
                this.dTP.addAll(arrayList);
            } else {
                C7962b.m23138a(new C7968d() {
                    /* renamed from: cl */
                    public void mo32916cl(List<C7967c> list) {
                        if (list != null && !list.isEmpty() && !VipHomeNewFragment.this.isDetached()) {
                            VipHomeNewFragment.this.dTP.clear();
                            VipHomeNewFragment.this.dTP.addAll(list);
                            VipHomeNewFragment.this.aDE();
                        }
                    }
                });
                this.dTP.clear();
                List aDK = C7962b.aDK();
                if (aDK != null) {
                    this.dTP.addAll(aDK);
                }
            }
        }
        aDE();
    }

    /* access modifiers changed from: private */
    public void aDE() {
        ((C7957a) this.dTM.getAdapter()).notifyDataSetChanged();
        ((C7957a) this.dTN.getAdapter()).notifyDataSetChanged();
        if (this.dTQ == -1) {
            ListView listView = this.dTM;
            this.dTQ = 0;
            listView.setSelection(0);
        }
        this.dTQ = Math.min(this.dTQ, this.dTP.size() - 1);
        aDG();
    }

    private void aDF() {
        if (getView() != null) {
            TextView textView = (TextView) getView().findViewById(R.id.tv_vip_during);
            textView.setText(this.dTR.aDB());
            textView.setVisibility(TextUtils.isEmpty(textView.getText()) ? 8 : 0);
        }
    }

    /* access modifiers changed from: private */
    public void aDG() {
        if (this.dTP.isEmpty() || this.dTQ >= this.dTP.size()) {
            this.dTO.setVisibility(8);
            return;
        }
        this.dTO.setVisibility(0);
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(((C7967c) this.dTP.get(this.dTQ)).goodsId);
        if (cVar != null) {
            if (!C8061k.m23411kF(C8061k.m23408kC(cVar.getId()))) {
                if (cVar.aCy()) {
                    this.dTO.setText(R.string.xiaoying_str_vip_subscribe);
                } else {
                    this.dTO.setText(R.string.xiaoying_str_vip_pay_continue);
                }
                this.dTO.setEnabled(true);
            } else {
                this.dTO.setText(R.string.xiaoying_str_vip_purchased);
                this.dTO.setEnabled(false);
            }
        }
    }

    /* renamed from: dh */
    private void m23106dh(View view) {
        this.dTM = (ListView) view.findViewById(R.id.ll_goods);
        this.dTM.setAdapter(new C7957a<C7967c>(this.dTP) {
            public View getView(final int i, View view, ViewGroup viewGroup) {
                View F = mo32925F(view, i);
                int i2 = 0;
                switch (getItemViewType(i)) {
                    case 1:
                        if (F == null) {
                            F = VipHomeNewFragment.this.getLayoutInflater().inflate(R.layout.iap_vip_item_home_new_goods_down_2, viewGroup, false);
                            break;
                        }
                        break;
                    case 2:
                        if (F == null) {
                            F = VipHomeNewFragment.this.getLayoutInflater().inflate(R.layout.iap_vip_item_home_new_goods, viewGroup, false);
                            break;
                        }
                        break;
                }
                mo32926G(F, i);
                boolean z = true;
                F.setClickable(true);
                View findViewById = F.findViewById(R.id.rl_item_layout);
                View findViewById2 = F.findViewById(R.id.rl_item_layout);
                if (i != VipHomeNewFragment.this.dTQ) {
                    z = false;
                }
                findViewById2.setSelected(z);
                C7967c cVar = (C7967c) VipHomeNewFragment.this.dTP.get(i);
                if (cVar == null) {
                    return F;
                }
                TextView textView = (TextView) F.findViewById(R.id.tv_title);
                textView.setText(cVar.title);
                textView.setVisibility(TextUtils.isEmpty(cVar.title) ? 8 : 0);
                TextView textView2 = (TextView) F.findViewById(R.id.tv_description);
                textView2.setText(cVar.description);
                textView2.setVisibility(TextUtils.isEmpty(cVar.description) ? 8 : 0);
                TextView textView3 = (TextView) F.findViewById(R.id.tv_price);
                textView3.setText(cVar.dQa);
                textView3.setVisibility(TextUtils.isEmpty(cVar.dQa) ? 8 : 0);
                TextView textView4 = (TextView) F.findViewById(R.id.tv_previous_price);
                textView4.setText(cVar.dQb);
                textView4.getPaint().setFlags(16);
                textView4.setVisibility(TextUtils.isEmpty(cVar.dQb) ? 8 : 0);
                TextView textView5 = (TextView) F.findViewById(R.id.tv_label);
                textView5.setText(cVar.label);
                if (TextUtils.isEmpty(cVar.label)) {
                    i2 = 8;
                }
                textView5.setVisibility(i2);
                findViewById.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        VipHomeNewFragment.this.dTQ = i;
                        C79492.this.notifyDataSetChanged();
                        VipHomeNewFragment.this.aDG();
                    }
                });
                return F;
            }
        });
    }

    /* renamed from: di */
    private void m23107di(View view) {
        this.dTN = (GridView) view.findViewById(R.id.gv_functions);
        this.dTN.setNumColumns(4);
        final List aDm = new C7990j(1, getArguments() != null ? getArguments().getString(VipHomeParams.VIP_HOME_INIT_GOODS_ID) : null).aDm();
        this.dTN.setAdapter(new C7957a<C7970a>(8, aDm) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                View F = mo32925F(view, i);
                switch (getItemViewType(i)) {
                    case 1:
                        if (F == null) {
                            F = VipHomeNewFragment.this.getLayoutInflater().inflate(R.layout.iap_vip_item_home_new_function_style_2, viewGroup, false);
                            break;
                        }
                        break;
                    case 2:
                        if (F == null) {
                            F = VipHomeNewFragment.this.getLayoutInflater().inflate(R.layout.iap_vip_item_home_new_function, viewGroup, false);
                            break;
                        }
                        break;
                }
                mo32926G(F, i);
                F.setClickable(true);
                TextView textView = (TextView) F.findViewById(R.id.tv_privilege_title);
                C7970a aVar = (C7970a) aDm.get(i);
                ((ImageView) F.findViewById(R.id.iv_privilege_icon)).setImageResource(aVar.aDN());
                textView.setText(aVar.aDO());
                return F;
            }
        });
    }

    /* renamed from: dj */
    private void m23108dj(View view) {
        if (getActivity() != null) {
            final FragmentActivity activity = getActivity();
            View findViewById = view.findViewById(R.id.vip_home_close);
            findViewById.setBackground(RippleLayout.m27642a(null, ContextCompat.getDrawable(getContext(), R.drawable.iap_vip_shape_circle_ripple_mask), RippleLayout.DEFAULT_COLOR));
            findViewById.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    activity.onBackPressed();
                }
            });
            view.findViewById(R.id.tv_restore).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    VipHomeNewFragment.this.m23100Pz();
                }
            });
            this.dTO = (TextView) view.findViewById(R.id.tv_btn_pay);
            this.dTO.setBackground(RippleLayout.m27642a(this.dTO.getBackground(), this.dTO.getBackground(), ContextCompat.getColor(getContext(), R.color.color_66ffffff)));
            this.dTO.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!VipHomeNewFragment.this.dTP.isEmpty()) {
                        C8049f.aBf().mo33081a(activity, ((C7967c) VipHomeNewFragment.this.dTP.get(Math.min(VipHomeNewFragment.this.dTP.size() - 1, Math.max(0, VipHomeNewFragment.this.dTQ)))).goodsId, null, null);
                    }
                }
            });
            m23109dk(view);
        }
    }

    /* renamed from: dk */
    private void m23109dk(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(C8048e.aBe().mo23613ME());
        sb.append("");
        String lowerCase = sb.toString().toLowerCase();
        View findViewById = view.findViewById(R.id.vip_home_service_text);
        View findViewById2 = view.findViewById(R.id.iv_support);
        boolean z = lowerCase.startsWith(Locale.CHINESE.getLanguage()) || lowerCase.startsWith(Locale.JAPANESE.getLanguage()) || lowerCase.startsWith(Locale.KOREAN.getLanguage());
        C79557 r2 = new OnClickListener() {
            public void onClick(View view) {
                C8048e.aBe().mo23637a((Activity) VipHomeNewFragment.this.getActivity(), C8048e.aBe().mo23647dD("https://hybrid.xiaoying.tv/web/vivaVideo/TermsPrivacy.html"), VipHomeNewFragment.this.getResources().getString(R.string.xiaoying_str_vip_subscription_desc));
            }
        };
        if (z) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
            findViewById.setOnClickListener(r2);
            return;
        }
        findViewById.setVisibility(8);
        findViewById2.setVisibility(0);
        findViewById2.setOnClickListener(r2);
    }

    /* renamed from: E */
    public void mo32913E(boolean z, boolean z2) {
        if (getActivity() != null) {
            if (z) {
                C8048e.aBe().mo23642b(getActivity(), false);
            } else {
                C8048e.aBe().mo23623Mo();
                if (!z2 && !C8049f.aBf().mo33077EO()) {
                    C8049f.aBf().mo33094aF(getActivity());
                }
            }
        }
    }

    public void aDC() {
        aDD();
    }

    public Context getContext() {
        return super.getContext() == null ? C8048e.aBe().getContext() : super.getContext();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.iap_vip_frgment_home_new, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        this.dTR.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dTR.aDz();
        m23107di(view);
        m23106dh(view);
        m23108dj(view);
        aDD();
        aDF();
    }

    /* renamed from: sD */
    public void mo32915sD(int i) {
        aDF();
        aDG();
        if (getActivity() != null) {
            if (i == 1) {
                getActivity().setResult(-1);
            }
            if (this.dTR != null && this.dTR.aDA()) {
                C8033i.m23243e(getActivity(), i, "vip page");
            }
        }
    }
}
