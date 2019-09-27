package com.introvd.template.app.publish;

import android.app.Activity;
import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.common.Constants;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sns.OnIconClickListener;
import com.introvd.template.sns.SnsResItem;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.app.publish.a */
public class C4092a extends C1008a<C4094a> {
    private OnClickListener acD;
    private int bvC;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public List<SnsResItem> mItemInfoList;
    /* access modifiers changed from: private */
    public OnIconClickListener mListener;

    /* renamed from: com.introvd.template.app.publish.a$a */
    public static class C4094a extends C1034u {
        private SparseArray<View> bvE = new SparseArray<>();
        View bvF;

        public C4094a(View view) {
            super(view);
            this.bvF = view;
        }

        /* renamed from: n */
        public View mo23776n(int i) {
            View view = (View) this.bvE.get(i);
            if (view != null) {
                return view;
            }
            View findViewById = this.bvF.findViewById(i);
            this.bvE.put(i, findViewById);
            return findViewById;
        }
    }

    public C4092a(Activity activity, List<SnsResItem> list, OnIconClickListener onIconClickListener) {
        this.bvC = -1;
        this.acD = new OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                C4092a.this.mListener.onIconClick((SnsResItem) C4092a.this.mItemInfoList.get(intValue));
                HashMap hashMap = new HashMap();
                hashMap.put("platform", ((SnsResItem) C4092a.this.mItemInfoList.get(intValue)).strDes);
                UserBehaviorLog.onKVEvent(C4092a.this.mContext, "Result_Video_Share", hashMap);
            }
        };
        this.bvC = m10158Nm();
        this.mItemInfoList = list;
        this.mListener = onIconClickListener;
        this.mContext = activity;
    }

    /* renamed from: Nm */
    private int m10158Nm() {
        if (this.bvC <= 0) {
            int P = C4583d.m11671P(50.0f);
            int i = 0;
            if (Constants.getScreenSize() != null) {
                i = (int) (((float) (Constants.getScreenSize().width - C4583d.m11671P(120.0f))) / 4.5f);
            }
            if (i > P) {
                P = i;
            }
            this.bvC = P;
        }
        return this.bvC;
    }

    /* renamed from: a */
    public void onBindViewHolder(C4094a aVar, int i) {
        SnsResItem snsResItem = (SnsResItem) this.mItemInfoList.get(i);
        TextView textView = (TextView) aVar.mo23776n(R.id.btn_share_text);
        ImageView imageView = (ImageView) aVar.mo23776n(R.id.btn_share_img);
        LayoutParams layoutParams = imageView.getLayoutParams();
        textView.setVisibility(8);
        layoutParams.width = m10158Nm();
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(snsResItem.mIconCircleResId);
        textView.setText(snsResItem.mTitleResId);
        imageView.setTag(Integer.valueOf(i));
        imageView.setOnClickListener(this.acD);
    }

    public int getItemCount() {
        if (this.mItemInfoList == null) {
            return 0;
        }
        return this.mItemInfoList.size();
    }

    /* renamed from: i */
    public C4094a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C4094a(LayoutInflater.from(this.mContext).inflate(R.layout.app_intl_publish_item, viewGroup, false));
    }
}
