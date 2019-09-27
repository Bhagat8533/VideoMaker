package com.introvd.template.app.community.usergrade;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C0373b;
import android.support.design.widget.TabLayout;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.community.usergrade.C3797h.C3799a;
import com.introvd.template.app.p194n.C4069a;
import com.introvd.template.app.p194n.C4069a.C4070a;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.exchange.C7916c;
import com.introvd.template.module.iap.business.exchange.C7923e;
import com.introvd.template.module.iap.business.exchange.C7923e.C7927a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.module.iap.p341b.p343b.C7735c;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.AdRouter;
import com.introvd.template.router.AppRouter.UserGradePageParam;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.xyui.viewpager.ListViewPagerAdapter;
import java.util.ArrayList;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p073g.C1810c;
import xiaoying.engine.base.QDisplayContext;

@C1942a(mo10417rZ = "/app/UserGradePage")
public class UserGradePage extends EventActivity {
    /* access modifiers changed from: private */
    public Toolbar afF;
    private UserGradeInfoView blj;
    /* access modifiers changed from: private */
    public TextView blk;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout bll;
    /* access modifiers changed from: private */
    public RecyclerView blm;
    /* access modifiers changed from: private */
    public RecyclerView bln;
    private boolean blo;
    /* access modifiers changed from: private */
    public boolean blp = true;
    private C3792e blq;
    private C3795g blr;
    /* access modifiers changed from: private */
    public ViewGroup bls;

    /* access modifiers changed from: private */
    /* renamed from: IE */
    public void m9254IE() {
        C3800i Iz = C3797h.m9288Ix().mo23279Iz();
        if (Iz != null) {
            this.blj.mo23252a(Iz);
        }
        m9255IF();
        if (C3797h.m9288Ix().mo23275IA() != null) {
            this.blq.setDataList(new ArrayList(C3797h.m9288Ix().mo23275IA()));
            View headerView = this.blq.getHeaderView();
            if (headerView == null) {
                headerView = LayoutInflater.from(this).inflate(R.layout.iap_vip_recycle_item_user_privilege_top, this.blm, false);
                this.blq.mo23273bG(headerView);
            }
            View findViewById = headerView.findViewById(R.id.rl_top_privilege);
            View findViewById2 = headerView.findViewById(R.id.rl_top_purchase);
            TextView textView = (TextView) headerView.findViewById(R.id.tv_priority_tip);
            findViewById2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C7897a.m23022b("Privilege", C7898b.dSW, new String[0]);
                    AdRouter.launchVipRenew(UserGradePage.this);
                }
            });
            if (C8072q.aBx().isVip()) {
                if (C7916c.aCW().aCX()) {
                    textView.setText(R.string.iap_vip_privilege_top_vip_package_desc);
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(8);
                }
                findViewById2.setVisibility(8);
            } else {
                findViewById2.setVisibility(0);
                findViewById.setVisibility(8);
            }
            this.blq.notifyDataSetChanged();
        }
        if (C3797h.m9288Ix().mo23276IB() != null) {
            this.blr.setDataList(new ArrayList(C3797h.m9288Ix().mo23276IB()));
            this.blr.notifyDataSetChanged();
        }
    }

    /* renamed from: IF */
    private void m9255IF() {
        if (TextUtils.isEmpty(UserServiceProxy.getUserId())) {
            this.blk.setText("0");
        } else {
            C4069a.m10113a(new C4070a() {
                public void onError() {
                    UserGradePage.this.blk.setText("0");
                }
            });
        }
    }

    /* renamed from: gt */
    private void m9264gt(int i) {
        XYViewPager xYViewPager = (XYViewPager) findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ArrayList arrayList = new ArrayList();
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(R.layout.user_grade_info_listview, null);
        this.blm = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.blq = new C3792e();
        this.blm.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.blm.setAdapter(this.blq);
        arrayList.add(inflate);
        View inflate2 = from.inflate(R.layout.user_grade_info_listview, null);
        this.bln = (RecyclerView) inflate2.findViewById(R.id.recycler_view);
        this.blr = new C3795g();
        this.bln.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.bln.setAdapter(this.blr);
        arrayList.add(inflate2);
        ListViewPagerAdapter listViewPagerAdapter = new ListViewPagerAdapter(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(getString(R.string.xiaoying_str_user_score_my_privileges));
        arrayList2.add(getString(R.string.xiaoying_str_user_score_my_task));
        listViewPagerAdapter.mo36226di(arrayList2);
        xYViewPager.setAdapter(listViewPagerAdapter);
        tabLayout.setupWithViewPager(xYViewPager);
        xYViewPager.validateDatasetObserver();
        xYViewPager.setCurrentItem(i);
        xYViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (!UserGradePage.this.blp) {
                    return;
                }
                if (i == 0) {
                    UserGradePage.this.blm.scrollToPosition(0);
                } else {
                    UserGradePage.this.bln.scrollToPosition(0);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(R.style.Theme_XiaoYingNoSplash);
        setContentView(R.layout.activity_user_grade_page);
        this.bls = (ViewGroup) findViewById(R.id.fl_vivacoin);
        this.blj = (UserGradeInfoView) findViewById(R.id.user_grade_info_view);
        this.blk = (TextView) findViewById(R.id.textview_left_coin);
        this.afF = (Toolbar) findViewById(R.id.toolbar);
        this.afF.setNavigationIcon(R.drawable.vivavideo_back);
        this.afF.setNavigationOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                UserGradePage.this.finish();
            }
        });
        if (C7916c.aCW().mo32880sz(2) > 0) {
            this.bls.addView(C7923e.m23058s(this.bls));
        } else {
            this.bls.removeAllViews();
        }
        ((AppBarLayout) findViewById(R.id.appbar_layout)).mo1528a((C0373b) new C0373b() {
            /* renamed from: d */
            public void mo1603d(AppBarLayout appBarLayout, int i) {
                UserGradePage.this.afF.setTitleTextColor(Color.argb(((-i) * 255) / C4583d.m11670O(UserGradePage.this, QDisplayContext.DISPLAY_ROTATION_270), 255, 255, 255));
                UserGradePage.this.blp = i >= 0;
                UserGradePage.this.bll.setEnabled(UserGradePage.this.blp);
            }
        });
        this.bll = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        this.bll.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                if (!C4600l.m11739k(UserGradePage.this, true)) {
                    ToastUtils.show((Context) UserGradePage.this, R.string.xiaoying_str_com_msg_network_inactive, 1);
                    UserGradePage.this.bll.setRefreshing(false);
                }
                C8049f.aBf().restoreGoodsAndPurchaseInfo();
                C3797h.m9288Ix().mo23278Iy();
                C3786c.m9273Iv().mo23269a(UserGradePage.this, null, null);
            }
        });
        m9264gt(getIntent().getIntExtra(UserGradePageParam.INTENT_EXTRA_KEY_DEFAULT_PAGE_INDEX, 0));
        m9254IE();
        this.bll.setRefreshing(true);
        C3797h.m9288Ix().mo23278Iy();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C3799a aVar) {
        m9254IE();
        this.bll.setRefreshing(false);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7735c cVar) {
        if (cVar != null) {
            m9254IE();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        C10021c.aZH().mo38496az(this);
        this.blo = true;
        super.onPause();
        C7923e.unregister();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C10021c.aZH().mo38494ax(this);
        if (this.blo) {
            m9255IF();
            this.blo = false;
        }
        m9254IE();
        C7923e.m23057a(new C7927a() {
            /* renamed from: c */
            public void mo23257c(boolean z, String str) {
                C1848s.m5326ai(Boolean.valueOf(z)).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
                    /* renamed from: e */
                    public void onSuccess(Boolean bool) {
                        if (bool.booleanValue()) {
                            UserGradePage.this.m9254IE();
                            if (UserGradePage.this.bls != null) {
                                UserGradePage.this.bls.removeAllViews();
                            }
                            ToastUtils.show(UserGradePage.this.getApplicationContext(), R.string.iap_vip_privilege_result_success, 0);
                            return;
                        }
                        ToastUtils.show(UserGradePage.this.getApplicationContext(), R.string.iap_vip_privilege_result_fail, 0);
                    }

                    public void onError(Throwable th) {
                        ToastUtils.show(UserGradePage.this.getApplicationContext(), R.string.iap_vip_privilege_result_fail, 0);
                    }
                });
            }
        });
    }
}
