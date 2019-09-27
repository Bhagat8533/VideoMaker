package com.introvd.template.template.info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.introvd.template.template.info.p410a.C8816a;
import com.introvd.template.template.info.p410a.C8839e;
import com.introvd.template.template.info.p411b.C8853a;
import com.introvd.template.template.info.p411b.C8854b;
import com.introvd.template.template.p407e.C8733e;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p134b.C2571a;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.List;

@C1942a(mo10417rZ = "/Template/AnimateFrame")
public class AnimateFrameActivity extends EventActivity implements C8853a {
    private static final String TAG = "AnimateFrameActivity";

    /* renamed from: Vu */
    private RecyclerView f3599Vu;
    private ImageView bIa;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout btY;
    private TextView die;
    private LinearLayout dqs;
    private OnRefreshListener eks = new OnRefreshListener() {
        public void onRefresh() {
            if (!C4600l.m11739k(AnimateFrameActivity.this, true)) {
                ToastUtils.longShow(AnimateFrameActivity.this.getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive);
                AnimateFrameActivity.this.btY.setRefreshing(false);
                return;
            }
            AnimateFrameActivity.this.emz.mo35384dM(1, 2000);
        }
    };
    private RelativeLayout emv;
    private Button emw;
    private ImageButton emx;
    /* access modifiers changed from: private */
    public C8816a emy;
    /* access modifiers changed from: private */
    public C8854b emz;

    private void initUI() {
        this.btY = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.btY.setColorSchemeResources(R.color.color_ff8e00);
        this.btY.setOnRefreshListener(this.eks);
        this.f3599Vu = (RecyclerView) findViewById(R.id.recyclerView);
        this.dqs = (LinearLayout) findViewById(R.id.loading_layout);
        this.emw = (Button) findViewById(R.id.try_btn);
        this.emv = (RelativeLayout) findViewById(R.id.net_error_layout);
        this.die = (TextView) findViewById(R.id.tv_title);
        this.bIa = (ImageView) findViewById(R.id.btn_back);
        this.emx = (ImageButton) findViewById(R.id.btn_manager);
        if (aKK()) {
            this.emx.setVisibility(8);
        }
        this.die.setText(this.emz.aLD());
        this.f3599Vu.setLayoutManager(new GridLayoutManager(this, 2));
        this.f3599Vu.mo7733a((C1018h) new C8839e(2, C4583d.m11673ii(10), true, true));
        this.emy = new C8816a(this, C8399c.edd);
        this.emy.mo35308a(this.emz.aLC());
        this.f3599Vu.setAdapter(this.emy);
        this.f3599Vu.mo7737a((C1022l) new C2571a() {
            public void auG() {
                super.auG();
                if (AnimateFrameActivity.this.emy != null) {
                    AnimateFrameActivity.this.emy.mo35312uI(6);
                }
            }

            /* renamed from: d */
            public void mo8096d(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    ImageLoader.resumeRequest(AnimateFrameActivity.this.getApplicationContext());
                } else if (i == 1) {
                    ImageLoader.pauseRequest(AnimateFrameActivity.this.getApplicationContext());
                }
                super.mo8096d(recyclerView, i);
            }
        });
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
            }
        }, this.emw);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                AnimateFrameActivity.this.finish();
            }
        }, this.bIa);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.show(view);
                AnimateFrameActivity.this.emz.aLB();
            }
        }, this.emx);
    }

    /* renamed from: S */
    public void mo35250S(String str, int i) {
        if (this.emy != null) {
            this.emy.mo35307S(str, i);
        }
    }

    public void aKH() {
        if (this.emz.aLA() == 0) {
            this.emv.setVisibility(0);
            this.dqs.setVisibility(4);
        }
    }

    public void aKI() {
        this.dqs.setVisibility(0);
        this.emv.setVisibility(4);
    }

    public int aKJ() {
        if (this.emy != null) {
            return this.emy.aLu();
        }
        return 0;
    }

    public boolean aKK() {
        if (getIntent().getExtras() != null) {
            return getIntent().getExtras().getBoolean(TemplateRouter.EXTRA_KEY_NEED_ACTIVITY_RESULT, false);
        }
        return false;
    }

    public Activity getHostActivity() {
        return this;
    }

    /* renamed from: jD */
    public void mo35256jD(boolean z) {
        if (this.dqs != null) {
            this.dqs.setVisibility(8);
        }
        if (!z) {
            this.emy.mo35312uI(0);
        }
    }

    /* renamed from: n */
    public void mo35257n(List<TemplateInfo> list, int i) {
        this.btY.setRefreshing(false);
        List aMd = C8733e.aMa().aMd();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("on Data Refresh , size:");
        sb.append(aMd.size());
        LogUtils.m14222e(str, sb.toString());
        this.emy.mo35310cQ(aMd);
    }

    public void notifyDataSetChanged() {
        if (this.emy != null) {
            this.emy.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9098 || i == 4368 || i == 9527 || i == 4369) {
            this.emz.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.template_activity_animate_frame);
        this.emz = new C8854b();
        this.emz.attachView((C8853a) this);
        this.emz.mo35383bR(getApplicationContext(), C8399c.edd);
        initUI();
        this.emz.aLz();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            this.emz.release();
        }
    }

    /* renamed from: pu */
    public void mo35259pu(String str) {
        if (this.emy != null) {
            this.emy.mo35311pG(str);
        }
    }

    /* renamed from: uI */
    public void mo35260uI(int i) {
        if (this.emy != null) {
            this.emy.mo35312uI(i);
        }
    }

    /* renamed from: z */
    public void mo35261z(String str, boolean z) {
        if (this.emy != null) {
            this.emy.mo35311pG(str);
        }
    }
}
