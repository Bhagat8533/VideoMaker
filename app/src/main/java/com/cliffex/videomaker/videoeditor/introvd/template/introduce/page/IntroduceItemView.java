package com.introvd.template.introduce.page;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.p021v4.view.ViewPager;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.C3855d;
import com.introvd.template.common.Constants;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.introduce.page.model.IntroduceItemModel;
import com.introvd.template.introduce.page.model.IntroduceMediaItem;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.xyui.RoundedTextView;
import com.introvd.template.xyui.viewpager.ViewPagerAdapter;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.greenrobot.eventbus.C10021c;

public class IntroduceItemView extends RelativeLayout implements C0068f {
    /* access modifiers changed from: private */
    public int cIs;
    RoundedTextView cqq;
    /* access modifiers changed from: private */
    public boolean cwn;
    ViewPager dLB;
    TextView dLC;
    TextView dLD;
    /* access modifiers changed from: private */
    public IntroduceItemModel dLE;
    LinearLayout dLm;
    TextView dLn;
    /* access modifiers changed from: private */
    public int dLq;
    private OnPageChangeListener dLr;
    ViewPagerAdapter dLv;
    private ArrayList<IntroduceMediaItem> mediaItemList;

    public IntroduceItemView(Context context) {
        this(context, null);
    }

    public IntroduceItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IntroduceItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLq = -1;
        this.mediaItemList = new ArrayList<>();
        this.dLr = new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (IntroduceItemView.this.dLq != i) {
                    View mN = IntroduceItemView.this.dLv.mo36228mN(IntroduceItemView.this.dLq);
                    View mN2 = IntroduceItemView.this.dLv.mo36228mN(i);
                    if (mN instanceof IntroduceMediaView) {
                        ((IntroduceMediaView) mN).setFocusStatus(false);
                    }
                    if (mN2 instanceof IntroduceMediaView) {
                        ((IntroduceMediaView) mN2).setFocusStatus(IntroduceItemView.this.cwn);
                    }
                    IntroduceItemView.this.m22285rN(i);
                }
            }
        };
        mo32326Oj();
    }

    private void ams() {
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                if (IntroduceItemView.this.getContext() instanceof Activity) {
                    ((Activity) IntroduceItemView.this.getContext()).finish();
                }
            }
        }, this.dLn);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                if (IntroduceItemView.this.cIs > 0) {
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = IntroduceItemView.this.cIs;
                    tODOParamModel.mJsonParam = IntroduceItemView.this.dLE.getTodoContent();
                    C10021c.aZH().mo38492aA(new C3855d(tODOParamModel));
                    UserBehaviorLog.onKVEvent(IntroduceItemView.this.getContext(), "Media_Buy_Inapp_Page_Click", new HashMap());
                }
                if (IntroduceItemView.this.getContext() instanceof Activity) {
                    ((Activity) IntroduceItemView.this.getContext()).finish();
                }
            }
        }, this.cqq);
    }

    private void azI() {
        if (this.mediaItemList.size() > 1) {
            this.dLm.removeAllViews();
            for (int i = 0; i < this.mediaItemList.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                layoutParams.width = C4583d.m11670O(getContext(), 8);
                layoutParams.height = C4583d.m11670O(getContext(), 8);
                if (i > 0) {
                    if (VERSION.SDK_INT >= 17) {
                        layoutParams.setMarginStart(C4583d.m11670O(getContext(), 10));
                    } else {
                        layoutParams.leftMargin = C4583d.m11670O(getContext(), 10);
                    }
                }
                imageView.setImageResource(R.drawable.introduce_pager_dot);
                this.dLm.addView(imageView, layoutParams);
            }
        }
    }

    private void azN() {
        if (Constants.getScreenSize().height - Constants.getScreenSize().width >= C4583d.m11673ii(275)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLC.getLayoutParams();
            layoutParams.topMargin = Constants.getScreenSize().width + C4583d.m11673ii(48);
            this.dLC.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dLC.getLayoutParams();
        layoutParams2.topMargin = Constants.getScreenSize().width + C4583d.m11673ii(18);
        this.dLC.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.cqq.getLayoutParams();
        layoutParams3.topMargin = C4583d.m11673ii(25);
        this.cqq.setLayoutParams(layoutParams3);
    }

    private void azO() {
        int ii = C4583d.m11673ii(36);
        int d = m22283d(this.dLD, this.dLD.getText().toString());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLD.getLayoutParams();
        if (d < ii) {
            layoutParams.height = ii;
        } else {
            layoutParams.height = d;
        }
        int ii2 = C4583d.m11673ii(10);
        int ii3 = C4583d.m11673ii(20);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.topMargin = ii2;
            layoutParams.setMarginStart(ii3);
            layoutParams.setMarginEnd(ii3);
        } else {
            layoutParams.setMargins(ii3, ii2, ii3, 0);
        }
        this.dLD.setLayoutParams(layoutParams);
    }

    private void azP() {
        ArrayList aOj = this.dLv.aOj();
        if (aOj != null && aOj.size() > 0) {
            Iterator it = aOj.iterator();
            while (it.hasNext()) {
                IntroduceMediaView introduceMediaView = (IntroduceMediaView) it.next();
                introduceMediaView.setFocusStatus(false);
                introduceMediaView.azR();
            }
        }
    }

    /* renamed from: d */
    private int m22283d(TextView textView, String str) {
        TextPaint paint = textView.getPaint();
        return ((int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent)) * ((int) ((paint.measureText(str) / ((float) (Constants.getScreenSize().width - C4583d.m11673ii(40)))) + 1.0f));
    }

    /* access modifiers changed from: private */
    /* renamed from: rN */
    public void m22285rN(int i) {
        if (i >= 0 && i < this.mediaItemList.size()) {
            if (this.dLq >= 0 && this.dLq < this.mediaItemList.size()) {
                View childAt = this.dLm.getChildAt(this.dLq);
                if (childAt instanceof ImageView) {
                    ((ImageView) childAt).setImageResource(R.drawable.introduce_pager_dot);
                }
            }
            View childAt2 = this.dLm.getChildAt(i);
            if (childAt2 instanceof ImageView) {
                ((ImageView) childAt2).setImageResource(R.drawable.introduce_pager_dot_focus);
            }
            this.dLq = i;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public void mo32326Oj() {
        LayoutInflater.from(getContext()).inflate(R.layout.introduce_item_view_layout, this, true);
        this.dLB = (ViewPager) findViewById(R.id.viewPager);
        this.dLm = (LinearLayout) findViewById(R.id.dot_container);
        this.cqq = (RoundedTextView) findViewById(R.id.apply_btn);
        this.dLn = (TextView) findViewById(R.id.btn_skip);
        this.dLC = (TextView) findViewById(R.id.tv_title);
        this.dLD = (TextView) findViewById(R.id.tv_desc);
        ViewGroup.LayoutParams layoutParams = this.dLB.getLayoutParams();
        int i = Constants.getScreenSize().width;
        layoutParams.height = i;
        layoutParams.width = i;
        this.dLB.setLayoutParams(layoutParams);
        azN();
        ams();
    }

    /* renamed from: a */
    public void mo32331a(IntroduceItemModel introduceItemModel) {
        this.dLE = introduceItemModel;
        this.cIs = introduceItemModel.getTodoCode();
        this.mediaItemList = introduceItemModel.getMediaItems();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mediaItemList.size(); i++) {
            IntroduceMediaItem introduceMediaItem = (IntroduceMediaItem) this.mediaItemList.get(i);
            IntroduceMediaView introduceMediaView = new IntroduceMediaView(getContext());
            introduceMediaView.mo32340a(introduceMediaItem);
            arrayList.add(introduceMediaView);
            if (i == 0) {
                introduceMediaView.setFocusStatus(this.cwn);
            }
        }
        if (this.cIs > 0) {
            this.cqq.setVisibility(0);
        } else {
            this.cqq.setVisibility(4);
        }
        if (!TextUtils.isEmpty(introduceItemModel.getTitle())) {
            this.dLC.setText(introduceItemModel.getTitle());
        }
        if (!TextUtils.isEmpty(introduceItemModel.getDesc())) {
            this.dLD.setText(introduceItemModel.getDesc());
        }
        azO();
        this.dLv = new ViewPagerAdapter(arrayList);
        this.dLB.setAdapter(this.dLv);
        this.dLB.addOnPageChangeListener(this.dLr);
        azI();
        m22285rN(0);
    }

    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onActivityCreate() {
    }

    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onActivityDestroy() {
        azP();
    }

    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onActivityPause() {
    }

    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onActivityResume() {
    }

    @C0078n(mo161n = C0062a.ON_STOP)
    public void onActivityStop() {
    }

    public void setFocusStatus(boolean z) {
        this.cwn = z;
        if (!z) {
            azP();
        } else if (this.dLv != null) {
            View mN = this.dLv.mo36228mN(this.dLq);
            if (mN instanceof IntroduceMediaView) {
                ((IntroduceMediaView) mN).setFocusStatus(true);
            }
        }
    }
}
