package com.introvd.template.component.videofetcher.p241ui;

import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p237a.C5363c;
import com.introvd.template.component.videofetcher.p239c.C5394d;
import com.introvd.template.component.videofetcher.p239c.C5397g;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.component.videofetcher.utils.C5492i;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.introvd.template.component.videofetcher.ui.MainFetcherActivity */
public class MainFetcherActivity extends FragmentActivity {
    private StatusFragment cle;
    private DownloadFragment clf;
    protected TextView clg;
    protected TextView clh;
    protected LinearLayout cli;
    private TextView clj;
    private List<String> clk;
    private FrameLayout cll;
    private LinearLayout clm;
    private OnClickListener cln = new OnClickListener() {
        public void onClick(View view) {
            if (view.getId() != R.id.fetcher_back) {
                MainFetcherActivity.this.m14785kd(view.getId());
            } else if (!MainFetcherActivity.this.isFinishing()) {
                MainFetcherActivity.this.finish();
            }
        }
    };

    /* renamed from: Oj */
    private void m14781Oj() {
        this.clk = new ArrayList();
        this.clg = (TextView) findViewById(R.id.tab_status);
        this.clh = (TextView) findViewById(R.id.tab_download);
        this.cll = (FrameLayout) findViewById(R.id.tab_download_container);
        this.clm = (LinearLayout) findViewById(R.id.tab_status_container);
        this.clj = (TextView) findViewById(R.id.tab_item_count);
        this.cli = (LinearLayout) findViewById(R.id.fetcher_tablayout);
        C5363c.addEffectForViews(MainFetcherActivity.class.getSimpleName(), this.clm);
        C5363c.addEffectForViews(MainFetcherActivity.class.getSimpleName(), this.cll);
        this.cll.setOnClickListener(this.cln);
        this.clm.setOnClickListener(this.cln);
        m14785kd(R.id.tab_status_container);
    }

    /* renamed from: b */
    private void m14783b(FragmentTransaction fragmentTransaction) {
        if (this.cle != null) {
            fragmentTransaction.hide(this.cle);
        }
        if (this.clf != null) {
            fragmentTransaction.hide(this.clf);
        }
    }

    /* renamed from: dD */
    private void m14784dD(boolean z) {
        this.clg.setSelected(z);
        this.clh.setSelected(!z);
    }

    /* access modifiers changed from: private */
    /* renamed from: kd */
    public void m14785kd(int i) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        m14783b(beginTransaction);
        if (i == R.id.tab_status_container) {
            if (this.cle == null) {
                this.cle = new StatusFragment();
                beginTransaction.add(R.id.fetcher_container, (Fragment) this.cle);
            } else {
                beginTransaction.show(this.cle);
            }
            m14784dD(true);
        } else if (i == R.id.tab_download_container) {
            if (this.clf == null) {
                this.clf = new DownloadFragment();
                beginTransaction.add(R.id.fetcher_container, (Fragment) this.clf);
            } else {
                beginTransaction.show(this.clf);
            }
            m14784dD(false);
            if (this.clj != null && this.clj.getVisibility() == 0) {
                this.clj.setVisibility(8);
                if (this.clk != null && !this.clk.isEmpty()) {
                    this.clk.clear();
                }
            }
        }
        beginTransaction.commit();
    }

    public void onBackPressed() {
        if (this.cle != null && !this.cle.isHidden()) {
            C5489g.m14902d("ruomiz", "statusfragment--onBackPressed");
            this.cle.aam();
        } else if (this.clf == null || this.clf.isHidden()) {
            finish();
            overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
        } else {
            this.clf.aam();
            C5489g.m14902d("ruomiz", "mDownloadFragment");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fetcher_act_main);
        m14781Oj();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C5492i.aaE().aaF();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onExit(C5394d dVar) {
        if (dVar.name == 7 && !isFinishing()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38496az(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C10021c.aZH().mo38494ax(this);
    }

    @C10031j(aZK = ThreadMode.MAIN, aZL = true)
    public void onTabCount(C5397g gVar) {
        C5489g.m14902d("ruomiz", "onTabCount");
        if (this.clk == null) {
            return;
        }
        if (this.clk.isEmpty() || !this.clk.contains(gVar.name)) {
            this.clk.add(gVar.name);
            this.clj.setVisibility(0);
            TextView textView = this.clj;
            StringBuilder sb = new StringBuilder();
            sb.append(this.clk.size());
            sb.append("");
            textView.setText(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("add count--");
            sb2.append(this.clk.size());
            C5489g.m14902d("ruomiz", sb2.toString());
        }
    }
}
