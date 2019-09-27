package com.introvd.template.app.welcomepage.snsview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.introvd.template.R;
import com.introvd.template.app.welcomepage.snsview.SnsLoginListView.C4514a;
import com.introvd.template.common.ViewClickEffectMgr;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.app.welcomepage.snsview.b */
class C4529b extends BaseAdapter {
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (C4529b.this.bJc != null && intValue >= 0) {
                C4515b bVar = (C4515b) C4529b.this.bJe.get(intValue);
                if (bVar.type == 0) {
                    C4529b.this.bJc.mo24732a(bVar.bJs);
                } else if (bVar.type == 1 && C4529b.this.bJd != null) {
                    C4529b.this.bJd.mo24733bY(view);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public C4514a bJc;
    /* access modifiers changed from: private */
    public C4531a bJd;
    /* access modifiers changed from: private */
    public List<C4515b> bJe = new ArrayList();
    private Context mContext;

    /* renamed from: com.introvd.template.app.welcomepage.snsview.b$a */
    interface C4531a {
        /* renamed from: bY */
        void mo24733bY(View view);
    }

    /* renamed from: com.introvd.template.app.welcomepage.snsview.b$b */
    class C4532b {
        public ImageView bJg;

        C4532b() {
        }
    }

    C4529b(Context context, C4514a aVar, C4531a aVar2) {
        this.mContext = context;
        this.bJc = aVar;
        this.bJd = aVar2;
    }

    /* renamed from: ie */
    private int m11444ie(int i) {
        if (i == 46) {
            return R.drawable.wel_vivavideo_share_huawei;
        }
        if (i == 1) {
            return R.drawable.wel_vivavideo_share_weibo;
        }
        if (i == 7 || i == 47) {
            return R.drawable.wel_vivavideo_share_weixin;
        }
        if (i == 11 || i == 10) {
            return R.drawable.wel_vivavideo_share_qq;
        }
        if (i == 28) {
            return R.drawable.v5_user_login_fb_img;
        }
        if (i == 25) {
            return R.drawable.v5_xiaoying_login_google;
        }
        if (i == 31) {
            return R.drawable.v5_xiaoying_login_instagram;
        }
        if (i == 38) {
            return R.drawable.vivavideo_login_line_n;
        }
        if (i == 3) {
            return R.drawable.vivavideo_login_phone_n;
        }
        if (i == 29) {
            return R.drawable.vivavideo_login_twitter_n;
        }
        if (i == 48) {
            return R.drawable.wel_vivavideo_share_phone_cn;
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: au */
    public void mo24750au(List<C4515b> list) {
        this.bJe = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.bJe.size();
    }

    public Object getItem(int i) {
        return this.bJe.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return ((C4515b) this.bJe.get(i)).type == 2 ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C4532b bVar;
        C4515b bVar2 = (C4515b) this.bJe.get(i);
        if (view != null) {
            bVar = (C4532b) view.getTag();
        } else if (bVar2.type != 2) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.layout_sns_login_gridview_item_view, null);
            bVar = new C4532b();
            bVar.bJg = (ImageView) view.findViewById(R.id.iv_sns_login_griditem);
            if (BaseSnsLoginView.bIU == 5) {
                bVar.bJg.setScaleX(0.8f);
                bVar.bJg.setScaleY(0.8f);
            }
            view.setTag(bVar);
        } else {
            view = new View(this.mContext);
            bVar = new C4532b();
            view.setTag(bVar);
        }
        if (bVar2.type != 2) {
            if (bVar2.type == 0) {
                bVar.bJg.setImageResource(m11444ie(bVar2.bJs.mSnsCode));
            } else {
                bVar.bJg.setImageResource(R.drawable.wel_vivavideo_result_more);
            }
            bVar.bJg.setTag(Integer.valueOf(i));
            bVar.bJg.setOnClickListener(this.acD);
            ViewClickEffectMgr.addEffectForViews(C4529b.class.getSimpleName(), bVar.bJg);
        }
        return view;
    }

    public int getViewTypeCount() {
        return 2;
    }
}
