package com.introvd.template.common.p236ui.banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.p021v4.view.PagerAdapter;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.aiii.android.arouter.p091c.C1919a;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.app.videoplayer.C4469b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.p236ui.RtlViewPager;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoH5UrlFromParamHandler;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.common.ui.banner.LoopViewPager */
public class LoopViewPager extends RtlViewPager implements Runnable {
    /* access modifiers changed from: private */
    public List<PagerFormatData> bDn = null;
    /* access modifiers changed from: private */
    public List<ImageView> cgA = null;
    private List<DynamicLoadingImageView> cgB = null;
    /* access modifiers changed from: private */
    public View[] cgC = null;
    /* access modifiers changed from: private */
    public LoopViewPager cgD = null;
    private C5320b cgE = null;
    private int cgF = 0;
    /* access modifiers changed from: private */
    public TextView cgG = null;
    private String cgH;
    private int cgI = -1;
    /* access modifiers changed from: private */
    public OnMyPageChangeListener cgJ;
    boolean cgo = false;
    /* access modifiers changed from: private */
    public float cgp = 1.0f;
    /* access modifiers changed from: private */
    public boolean cgq = false;
    /* access modifiers changed from: private */
    public boolean cgr = false;
    private boolean cgs = false;
    private boolean cgt = false;
    /* access modifiers changed from: private */
    public int cgu = 0;
    /* access modifiers changed from: private */
    public int cgv = 5000;
    /* access modifiers changed from: private */
    public long cgw = 0;
    /* access modifiers changed from: private */
    public int cgx = -1;
    /* access modifiers changed from: private */
    public int cgy = -1;
    /* access modifiers changed from: private */
    public ViewGroup cgz = null;
    public int mBannerCode = 11;
    private float mCornerRadius;
    long startTime = 0;

    /* renamed from: com.introvd.template.common.ui.banner.LoopViewPager$OnMyPageChangeListener */
    public interface OnMyPageChangeListener {
        void onPageSelected(int i);
    }

    /* renamed from: com.introvd.template.common.ui.banner.LoopViewPager$PagerFormatData */
    public static class PagerFormatData {
        public String description;

        /* renamed from: id */
        public String f3453id;
        public String imgUrl;
        public String name;
        public Object todoCode;
        public String todoContent;

        public String getBehavName() {
            return !TextUtils.isEmpty(this.description) ? this.description : !TextUtils.isEmpty(this.name) ? this.name : this.imgUrl;
        }
    }

    /* renamed from: com.introvd.template.common.ui.banner.LoopViewPager$a */
    private class C5319a implements Runnable {
        private C5319a() {
        }

        public void run() {
            if (System.currentTimeMillis() - LoopViewPager.this.cgw >= ((long) LoopViewPager.this.cgv)) {
                LoopViewPager.this.cgr = false;
                return;
            }
            long l = ((long) LoopViewPager.this.cgv) - (System.currentTimeMillis() - LoopViewPager.this.cgw);
            if (l < 0) {
                l = 0;
            }
            LoopViewPager.this.postDelayed(this, l);
        }
    }

    /* renamed from: com.introvd.template.common.ui.banner.LoopViewPager$b */
    class C5320b extends PagerAdapter {
        private List<DynamicLoadingImageView> cgO;

        public C5320b(List<DynamicLoadingImageView> list) {
            this.cgO = new ArrayList(list);
        }

        /* renamed from: aA */
        public synchronized void mo26740aA(List<DynamicLoadingImageView> list) {
            this.cgO = new ArrayList(list);
            notifyDataSetChanged();
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i < this.cgO.size()) {
                viewGroup.removeView((View) this.cgO.get(i));
            }
        }

        public int getCount() {
            return this.cgO.size();
        }

        public float getPageWidth(int i) {
            return LoopViewPager.this.cgp;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = (View) this.cgO.get(i);
            viewGroup.addView(view);
            return view;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public LoopViewPager(Context context) {
        super(context);
        m14462ef(context);
    }

    public LoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14462ef(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14451a(int i, PagerFormatData pagerFormatData, int i2) {
        String str;
        switch (i) {
            case 11:
                str = "Template_Banner_Click";
                UserBehaviorABTestUtils.onEventTemplateBanner(getContext(), i2, pagerFormatData.name, pagerFormatData.f3453id, false);
                break;
            case 40:
                String str2 = TextUtils.isEmpty(pagerFormatData.name) ? this.cgH : pagerFormatData.name;
                UserBehaviorUtilsV5.onEventExploreBanner(getContext(), str2, i2, false);
                UserBehaviorABTestUtils.onEventExploreBanner(getContext(), i2, str2, pagerFormatData.f3453id, false);
                break;
            case 41:
                String str3 = TextUtils.isEmpty(pagerFormatData.name) ? this.cgH : pagerFormatData.name;
                UserBehaviorUtilsV5.onEventExploreSingleRecommend(getContext(), false, str3);
                UserBehaviorABTestUtils.onEventShowExploreRecommend(getContext(), i2, str3, pagerFormatData.f3453id, false);
                break;
            case 101:
                str = "Home_Banner_Click";
                break;
            case 10503:
            case 10504:
                str = "Home_Bottom_Banner_Click";
                if ((pagerFormatData.todoCode instanceof Integer) && ((Integer) pagerFormatData.todoCode).intValue() == 16004) {
                    C7835b.m22861lq("首页运营位");
                    break;
                }
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", pagerFormatData.getBehavName());
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i2);
            hashMap.put("order", sb.toString());
            UserBehaviorLog.onKVEvent(getContext(), str, hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14452a(int i, String str, String str2, int i2) {
        String str3;
        if (i == 11) {
            str3 = "Template_Banner_Show";
            UserBehaviorABTestUtils.onEventTemplateBanner(getContext(), i2, str, str2, true);
        } else if (i != 101) {
            switch (i) {
                case 10503:
                case 10504:
                    str3 = "Home_Create_Banner_Show";
                    break;
                default:
                    str3 = null;
                    break;
            }
        } else {
            str3 = "Home_Banner_Show";
        }
        if (!TextUtils.isEmpty(str3) && m14464fu(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("order", String.valueOf(i2));
            UserBehaviorLog.onKVEvent(getContext(), str3, hashMap);
        }
    }

    /* renamed from: az */
    private List<DynamicLoadingImageView> m14457az(List<PagerFormatData> list) {
        if (list == null) {
            return null;
        }
        if (this.cgB == null) {
            this.cgB = new ArrayList();
        } else {
            this.cgB.clear();
        }
        ColorDrawable colorDrawable = new ColorDrawable(1711276032);
        final int i = 0;
        while (i < this.cgu && list.size() > i) {
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            final PagerFormatData pagerFormatData = (PagerFormatData) list.get(i);
            DynamicLoadingImageView dynamicLoadingImageView = new DynamicLoadingImageView(getContext());
            dynamicLoadingImageView.setCornerRadius(this.mCornerRadius);
            dynamicLoadingImageView.setRoundEnable(true, true, true, true);
            if (i == 0) {
                if (this.cgq) {
                    DynamicLoadingImageView dynamicLoadingImageView2 = new DynamicLoadingImageView(getContext());
                    dynamicLoadingImageView2.setCornerRadius(this.mCornerRadius);
                    dynamicLoadingImageView2.setRoundEnable(true, true, true, true);
                    if (this.cgu - 1 < list.size()) {
                        PagerFormatData pagerFormatData2 = (PagerFormatData) list.get(this.cgu - 1);
                        if (pagerFormatData2 != null) {
                            ImageLoader.loadImage(pagerFormatData2.imgUrl, this.cgI, this.cgI, (Drawable) colorDrawable, dynamicLoadingImageView2);
                        }
                    }
                    this.cgB.add(dynamicLoadingImageView2);
                }
                dynamicLoadingImageView.setPadding(this.cgF, 0, this.cgF, 0);
            } else {
                dynamicLoadingImageView.setPadding(0, 0, this.cgF, 0);
            }
            ImageLoader.loadImage(pagerFormatData.imgUrl, this.cgI, this.cgI, (Drawable) colorDrawable, dynamicLoadingImageView);
            dynamicLoadingImageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (pagerFormatData.todoCode != null) {
                        ICommonFuncRouter iCommonFuncRouter = (ICommonFuncRouter) C1919a.m5529sc().mo10356i(ICommonFuncRouter.class);
                        TODOParamModel tODOParamModel = new TODOParamModel();
                        tODOParamModel.mTODOCode = ((Integer) pagerFormatData.todoCode).intValue();
                        tODOParamModel.mJsonParam = pagerFormatData.todoContent;
                        String str = LoopViewPager.this.mBannerCode == 11 ? TodoH5UrlFromParamHandler.FROM_TEMPLATE_BANNER : (LoopViewPager.this.mBannerCode == 41 || LoopViewPager.this.mBannerCode == 40) ? TodoH5UrlFromParamHandler.FROM_EXPLORE_BANNER : LoopViewPager.this.mBannerCode == 10503 ? TodoH5UrlFromParamHandler.FROM_TYPE_CREATION_BANNER : LoopViewPager.this.mBannerCode == 10504 ? TodoH5UrlFromParamHandler.FROM_EXPORT_RESULT_BANNER : TodoH5UrlFromParamHandler.FROM_OTHER_BANNER;
                        TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, str, pagerFormatData.name);
                        iCommonFuncRouter.executeTodo((Activity) LoopViewPager.this.getContext(), tODOParamModel, null);
                        LoopViewPager.this.m14451a(LoopViewPager.this.mBannerCode, pagerFormatData, i);
                    }
                }
            });
            dynamicLoadingImageView.setLayoutParams(layoutParams);
            this.cgB.add(dynamicLoadingImageView);
            if (i == this.cgu - 1 && this.cgq) {
                DynamicLoadingImageView dynamicLoadingImageView3 = new DynamicLoadingImageView(getContext());
                dynamicLoadingImageView3.setCornerRadius(this.mCornerRadius);
                dynamicLoadingImageView3.setRoundEnable(true, true, true, true);
                ImageLoader.loadImage(((PagerFormatData) list.get(0)).imgUrl, this.cgI, this.cgI, (Drawable) colorDrawable, dynamicLoadingImageView3);
                this.cgB.add(dynamicLoadingImageView3);
            }
            i++;
        }
        return this.cgB;
    }

    /* renamed from: ef */
    private void m14462ef(Context context) {
        this.cgD = this;
        this.cgD.addOnPageChangeListener(new OnPageChangeListener() {
            int cgK = 0;

            /* renamed from: i */
            private PagerFormatData m14473i(List<PagerFormatData> list, int i) {
                if (list == null || i < 0 || list.size() <= i) {
                    return null;
                }
                return (PagerFormatData) list.get(i);
            }

            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                if (LoopViewPager.this.cgq) {
                    if (i == LoopViewPager.this.cgu + 1) {
                        LoopViewPager.this.cgD.setCurrentItem(1, false);
                    }
                    if (i == 0 && ((double) f) < 1.0E-5d) {
                        LoopViewPager.this.cgD.setCurrentItem(LoopViewPager.this.cgu, false);
                    }
                }
            }

            public void onPageSelected(int i) {
                if (i > 0 && i < LoopViewPager.this.cgu + 1) {
                    if (!(LoopViewPager.this.cgG == null || LoopViewPager.this.bDn == null)) {
                        PagerFormatData pagerFormatData = (PagerFormatData) LoopViewPager.this.bDn.get(i - 1);
                        if (pagerFormatData != null) {
                            LoopViewPager.this.cgG.setText(pagerFormatData.name);
                        }
                    }
                    int i2 = i - 1;
                    if (!(LoopViewPager.this.cgz == null || LoopViewPager.this.cgA == null)) {
                        if (this.cgK >= 0 && this.cgK < LoopViewPager.this.cgA.size()) {
                            ((ImageView) LoopViewPager.this.cgA.get(this.cgK)).setImageResource(LoopViewPager.this.cgy);
                        }
                        this.cgK = i2;
                        if (i2 >= 0 && i2 < LoopViewPager.this.cgA.size()) {
                            ((ImageView) LoopViewPager.this.cgA.get(i2)).setImageResource(LoopViewPager.this.cgx);
                        }
                    }
                    if (LoopViewPager.this.cgJ != null) {
                        LoopViewPager.this.cgJ.onPageSelected(i2);
                    }
                    if (i2 >= 0) {
                        PagerFormatData i3 = m14473i(LoopViewPager.this.bDn, i2);
                        LoopViewPager.this.m14452a(LoopViewPager.this.mBannerCode, i3 != null ? i3.name : "list_OOB", i3 != null ? i3.f3453id : "-1", i2);
                    }
                }
            }
        });
        this.cgD.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        LoopViewPager.this.cgr = true;
                        if (LoopViewPager.this.cgC != null) {
                            for (View enabled : LoopViewPager.this.cgC) {
                                enabled.setEnabled(false);
                            }
                            break;
                        }
                        break;
                    case 1:
                        LoopViewPager.this.cgw = System.currentTimeMillis();
                        LoopViewPager.this.postDelayed(new C5319a(), (long) LoopViewPager.this.cgv);
                        if (LoopViewPager.this.cgC != null) {
                            for (View enabled2 : LoopViewPager.this.cgC) {
                                enabled2.setEnabled(true);
                            }
                            break;
                        }
                        break;
                }
                return false;
            }
        });
    }

    /* renamed from: fu */
    private boolean m14464fu(String str) {
        boolean z = false;
        if (Constants.getScreenSize() == null) {
            return false;
        }
        float g = C4469b.m11340g(this, new Rect(0, 0, Constants.getScreenSize().width, Constants.getScreenSize().height));
        StringBuilder sb = new StringBuilder();
        sb.append("getViewDisplayPoint : ");
        sb.append(g);
        LogUtilsV2.m14230i(sb.toString());
        if (g < 1.0f) {
            return false;
        }
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LoopViewPager");
        sb2.append(str);
        String appSettingStr = instance.getAppSettingStr(sb2.toString(), "0");
        try {
            if ("0".equals(appSettingStr) || System.currentTimeMillis() - C2575a.parseLong(appSettingStr) > DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS) {
                z = true;
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public int getRealCurrentItem() {
        if (!this.cgq) {
            return super.getCurrentItem();
        }
        int currentItem = super.getCurrentItem();
        if (currentItem > 0 && currentItem < this.cgu + 1) {
            return currentItem - 1;
        }
        if (currentItem == 0) {
            return this.cgu - 1;
        }
        return 0;
    }

    public OnMyPageChangeListener getmOnMyPageChangeListener() {
        return this.cgJ;
    }

    public void handleCollision(View[] viewArr) {
        this.cgC = viewArr;
    }

    public final void init(List<PagerFormatData> list, boolean z, boolean z2) {
        this.cgu = list.size();
        this.bDn = list;
        this.cgs = z;
        this.cgq = z2;
        this.cgE = new C5320b(m14457az(list));
        this.cgD.setAdapter(this.cgE);
        if (this.cgq) {
            postDelayed(this, (long) this.cgv);
            this.cgD.setCurrentItem(1, false);
            if (this.cgG != null && list.size() > 0) {
                this.cgG.setText(((PagerFormatData) list.get(0)).name);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r4 != null) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initIndicator(int r4, int r5, android.view.ViewGroup r6) {
        /*
            r3 = this;
            r3.cgx = r4
            r3.cgy = r5
            r3.cgz = r6
            android.view.ViewGroup r4 = r3.cgz
            if (r4 == 0) goto L_0x00c7
            android.view.ViewGroup r4 = r3.cgz
            android.view.ViewParent r4 = r4.getParent()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r5 = 0
            if (r4 == 0) goto L_0x0020
            int r6 = xiaoying.quvideo.com.vivabase.C10122R.C10124id.txtview_banner_title
            android.view.View r4 = r4.findViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r4 = r5
        L_0x0021:
            android.view.ViewGroup r6 = r3.cgz
            r6.removeAllViews()
            r6 = 0
            if (r4 == 0) goto L_0x004a
            java.util.List<com.introvd.template.common.ui.banner.LoopViewPager$PagerFormatData> r0 = r3.bDn
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x004a
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.cgG = r4
            android.widget.TextView r4 = r3.cgG
            java.util.List<com.introvd.template.common.ui.banner.LoopViewPager$PagerFormatData> r5 = r3.bDn
            java.lang.Object r5 = r5.get(r6)
            com.introvd.template.common.ui.banner.LoopViewPager$PagerFormatData r5 = (com.introvd.template.common.p236ui.banner.LoopViewPager.PagerFormatData) r5
            java.lang.String r5 = r5.name
            r4.setText(r5)
            android.widget.TextView r4 = r3.cgG
            r4.setVisibility(r6)
            goto L_0x0057
        L_0x004a:
            android.widget.TextView r4 = r3.cgG
            if (r4 == 0) goto L_0x0055
            android.widget.TextView r4 = r3.cgG
            r0 = 8
            r4.setVisibility(r0)
        L_0x0055:
            r3.cgG = r5
        L_0x0057:
            java.util.List<android.widget.ImageView> r4 = r3.cgA
            if (r4 != 0) goto L_0x0063
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r3.cgA = r4
            goto L_0x0068
        L_0x0063:
            java.util.List<android.widget.ImageView> r4 = r3.cgA
            r4.clear()
        L_0x0068:
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r5 = -2
            r4.<init>(r5, r5)
        L_0x006e:
            int r5 = r3.cgu
            if (r6 >= r5) goto L_0x00b7
            android.widget.ImageView r5 = new android.widget.ImageView
            android.content.Context r0 = r3.getContext()
            r5.<init>(r0)
            if (r6 != 0) goto L_0x0083
            int r0 = r3.cgx
            r5.setImageResource(r0)
            goto L_0x0088
        L_0x0083:
            int r0 = r3.cgy
            r5.setImageResource(r0)
        L_0x0088:
            if (r6 <= 0) goto L_0x00a7
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            r2 = 5
            if (r0 < r1) goto L_0x009d
            android.content.Context r0 = r3.getContext()
            int r0 = com.introvd.template.p203b.C4583d.m11670O(r0, r2)
            r4.setMarginStart(r0)
            goto L_0x00a7
        L_0x009d:
            android.content.Context r0 = r3.getContext()
            int r0 = com.introvd.template.p203b.C4583d.m11670O(r0, r2)
            r4.leftMargin = r0
        L_0x00a7:
            r5.setLayoutParams(r4)
            java.util.List<android.widget.ImageView> r0 = r3.cgA
            r0.add(r5)
            android.view.ViewGroup r0 = r3.cgz
            r0.addView(r5)
            int r6 = r6 + 1
            goto L_0x006e
        L_0x00b7:
            int r4 = r3.cgx
            if (r4 <= 0) goto L_0x00c6
            int r4 = r3.cgy
            if (r4 <= 0) goto L_0x00c6
            android.view.ViewGroup r4 = r3.cgz
            if (r4 == 0) goto L_0x00c6
            r4 = 1
            r3.cgt = r4
        L_0x00c6:
            return
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.p236ui.banner.LoopViewPager.initIndicator(int, int, android.view.ViewGroup):void");
    }

    public void notifyDataChanged(List<PagerFormatData> list) {
        if (this.cgE != null) {
            this.cgE.mo26740aA(m14457az(list));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cgo = true;
        LogUtilsV2.m14227d("onDetachedFromWindow = ");
    }

    public void onPause() {
        this.cgs = false;
    }

    public void onResume() {
        this.cgs = true;
    }

    public void run() {
        if (!this.cgo && this.cgu > 1) {
            boolean z = false;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.startTime >= ((long) this.cgv)) {
                this.startTime = currentTimeMillis;
                z = true;
            }
            if (this.cgs && !this.cgr && z) {
                int currentItem = this.cgD.getCurrentItem() + 1;
                if (currentItem == this.cgu + 1) {
                    currentItem = 1;
                }
                this.cgD.setCurrentItem(currentItem, true);
            }
            postDelayed(this, (long) this.cgv);
        }
    }

    public void setAutoLoopRate(int i) {
        this.cgv = i;
    }

    public void setCornerRadius(float f) {
        this.mCornerRadius = f;
    }

    public void setPageTitle(String str) {
        this.cgH = str;
    }

    public void setPlaceHolderImg(int i) {
        this.cgI = i;
    }

    public void setmOnMyPageChangeListener(OnMyPageChangeListener onMyPageChangeListener) {
        this.cgJ = onMyPageChangeListener;
    }
}
