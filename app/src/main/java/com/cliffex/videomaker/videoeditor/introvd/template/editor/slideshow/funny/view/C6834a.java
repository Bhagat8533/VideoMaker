package com.introvd.template.editor.slideshow.funny.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.editor.R;
import com.introvd.template.module.iap.C8048e;

/* renamed from: com.introvd.template.editor.slideshow.funny.view.a */
public class C6834a extends BaseItem {
    public C6834a(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.funny_template_feedback_item;
    }

    /* access modifiers changed from: protected */
    public int getSpanSize() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        baseHolder.findViewById(R.id.tv_feedback).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8048e.aBe().mo23635a(C6834a.this.getActivity(), -1, true);
            }
        });
    }
}
