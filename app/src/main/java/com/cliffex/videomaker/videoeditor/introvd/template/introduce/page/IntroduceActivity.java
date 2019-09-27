package com.introvd.template.introduce.page;

import android.app.Activity;
import android.arch.lifecycle.C0069g;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p021v4.view.ViewPager;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.introduce.page.model.IntroduceItemModel;
import com.introvd.template.introduce.page.model.IntroduceMediaItem.Builder;
import com.introvd.template.introduce.page.model.IntroduceModel;
import com.introvd.template.introduce.page.model.IntroduceModel.UrlArrayBean;
import com.introvd.template.xyui.p421b.C9162a;
import com.introvd.template.xyui.viewpager.ViewPagerAdapter;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntroduceActivity extends EventActivity implements C0069g {
    private LinearLayout dLm;
    private List<IntroduceItemModel> dLo = new ArrayList();
    /* access modifiers changed from: private */
    public int dLq = -1;
    private OnPageChangeListener dLr = new OnPageChangeListener() {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (IntroduceActivity.this.dLq != i) {
                IntroduceActivity.this.m22271rN(i);
            }
        }
    };
    private ViewPagerAdapter dLv;

    /* renamed from: yH */
    private ViewPager f3556yH;

    /* renamed from: Kl */
    private void m22264Kl() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.dLo.size(); i++) {
            IntroduceItemModel introduceItemModel = (IntroduceItemModel) this.dLo.get(i);
            IntroduceItemView rM = m22270rM(introduceItemModel.getTodoCode());
            if (i == 0) {
                rM.setFocusStatus(true);
            }
            getLifecycle().mo152a(rM);
            rM.mo32331a(introduceItemModel);
            arrayList.add(rM);
        }
        this.dLv = new ViewPagerAdapter(arrayList);
        this.f3556yH.setAdapter(this.dLv);
        this.f3556yH.addOnPageChangeListener(this.dLr);
        m22271rN(0);
    }

    /* renamed from: Oj */
    private void m22265Oj() {
        this.dLm = (LinearLayout) findViewById(R.id.dot_container);
        this.f3556yH = (ViewPager) findViewById(R.id.viewPager);
        azI();
    }

    /* renamed from: a */
    public static void m22267a(Activity activity, String str, String str2, ArrayList<IntroduceModel> arrayList) {
        Intent intent = new Intent(activity, IntroduceActivity.class);
        intent.putExtra("intent_key_introduce_todocode", str);
        intent.putExtra("intent_key_introduce_todocontent", str2);
        intent.putParcelableArrayListExtra("intent_key_introduce_info", arrayList);
        activity.startActivity(intent);
    }

    private void azI() {
        if (this.dLo.size() > 1) {
            this.dLm.removeAllViews();
            for (int i = 0; i < this.dLo.size(); i++) {
                ImageView imageView = new ImageView(this);
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                layoutParams.width = C9162a.m26662O(getApplicationContext(), 8);
                layoutParams.height = C9162a.m26662O(getApplicationContext(), 8);
                if (i > 0) {
                    if (VERSION.SDK_INT >= 17) {
                        layoutParams.setMarginStart(C9162a.m26662O(getApplicationContext(), 10));
                    } else {
                        layoutParams.leftMargin = C9162a.m26662O(getApplicationContext(), 10);
                    }
                }
                imageView.setImageResource(R.drawable.introduce_pager_dot_1);
                this.dLm.addView(imageView, layoutParams);
            }
        }
    }

    /* renamed from: cc */
    private boolean m22269cc(List<IntroduceModel> list) {
        boolean z = false;
        if (list == null || list.size() == 0) {
            finish();
            return false;
        }
        String stringExtra = getIntent().getStringExtra("intent_key_introduce_todocode");
        String stringExtra2 = getIntent().getStringExtra("intent_key_introduce_todocontent");
        for (IntroduceModel introduceModel : list) {
            ArrayList arrayList = new ArrayList();
            List<UrlArrayBean> urlArray = introduceModel.getUrlArray();
            if (urlArray != null && urlArray.size() > 0) {
                for (UrlArrayBean urlArrayBean : urlArray) {
                    arrayList.add(new Builder().isImage(!"video".equals(urlArrayBean.getType())).previewUrl(urlArrayBean.getUrl()).coverUrl(urlArrayBean.getCoverurl()).width(urlArrayBean.getWidth()).height(urlArrayBean.getHeight()).build());
                }
            }
            this.dLo.add(new IntroduceItemModel.Builder().title(introduceModel.getTitle()).desc(introduceModel.getDescription()).todoCode(C2575a.parseInt(stringExtra)).todoContent(stringExtra2).mediaItem(arrayList).build());
        }
        if (!(this.dLo == null || this.dLo.size() == 0)) {
            z = true;
        }
        return z;
    }

    /* renamed from: rM */
    private IntroduceItemView m22270rM(int i) {
        return i == 16009 ? new IntroduceIapItemView(this) : new IntroduceItemView(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: rN */
    public void m22271rN(int i) {
        if (i >= 0 && i < this.dLo.size()) {
            if (this.dLq >= 0 && this.dLq < this.dLo.size()) {
                View childAt = this.dLm.getChildAt(this.dLq);
                if (childAt instanceof ImageView) {
                    ((ImageView) childAt).setImageResource(R.drawable.introduce_pager_dot_1);
                }
                View mN = this.dLv.mo36228mN(this.dLq);
                if (mN instanceof IntroduceItemView) {
                    ((IntroduceItemView) mN).setFocusStatus(false);
                }
            }
            View childAt2 = this.dLm.getChildAt(i);
            if (childAt2 instanceof ImageView) {
                ((ImageView) childAt2).setImageResource(R.drawable.introduce_pager_dot_1_focus);
            }
            View mN2 = this.dLv.mo36228mN(i);
            if (mN2 instanceof IntroduceItemView) {
                ((IntroduceItemView) mN2).setFocusStatus(true);
            }
            this.dLq = i;
        }
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_introduce_layout);
        if (!m22269cc(getIntent().getParcelableArrayListExtra("intent_key_introduce_info"))) {
            finish();
            return;
        }
        UserBehaviorLog.onKVEvent(getApplicationContext(), "Media_Buy_Inapp_Page_Show", new HashMap());
        m22265Oj();
        m22264Kl();
    }
}
