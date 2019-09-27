package com.introvd.template.editor.slideshow.funny;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.MSize;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.slideshow.adapter.C6741a;
import com.introvd.template.editor.slideshow.funny.adapter.C6822b;
import com.introvd.template.editor.slideshow.funny.p283a.C6803a;
import com.introvd.template.editor.slideshow.funny.p283a.C6818b;
import com.introvd.template.editor.slideshow.funny.view.FunnyThemeMusicView;
import com.introvd.template.editor.slideshow.model.SlideModel;
import com.introvd.template.editor.slideshow.model.SlideSceneModel;
import com.introvd.template.editor.slideshow.p278a.C6738a;
import com.introvd.template.editor.slideshow.p279b.C6753a;
import com.introvd.template.editor.slideshow.p281d.C6781a;
import com.introvd.template.editor.widget.HighLView;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.PublishParams.DomeSocialPublishParams;
import com.introvd.template.router.slide.FunnySlideRouter;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p133a.C2564c.C2569a;
import java.util.List;

@C1942a(mo10417rZ = "/Funny/Editor")
public class FunnyEditActivity extends EventActivity implements OnClickListener, C6818b {
    ImageButton cFn;
    ImageButton clC;
    RelativeLayout dfa;
    /* access modifiers changed from: private */
    public C6803a dgA;
    private C6822b dgB;
    /* access modifiers changed from: private */
    public FunnyThemeMusicView dgC;
    RelativeLayout dgt;
    LinearLayout dgu;
    TextView dgv;
    RecyclerView dgw;
    HighLView dgx;
    String dgy;
    String dgz;

    /* renamed from: Kl */
    private void m19764Kl() {
        this.cFn = (ImageButton) findViewById(R.id.back_btn);
        this.clC = (ImageButton) findViewById(R.id.play_btn);
        this.dgv = (TextView) findViewById(R.id.export_btn);
        this.dfa = (RelativeLayout) findViewById(R.id.surface_layout);
        this.dgt = (RelativeLayout) findViewById(R.id.surface_fake_layout);
        this.dgx = (HighLView) findViewById(R.id.high_light_view);
        this.dgu = (LinearLayout) findViewById(R.id.modify_bgm_layout);
        this.clC.setOnClickListener(this);
        this.cFn.setOnClickListener(this);
        this.dgv.setOnClickListener(this);
        this.dgu.setOnClickListener(this);
        this.dgw = (RecyclerView) findViewById(R.id.rc_material);
        this.dgw.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.dgw.mo7733a((C1018h) new C6741a(C4583d.m11671P(10.0f)));
    }

    private void abu() {
        MSize surfaceSize = this.dgA.getSurfaceSize();
        if (surfaceSize != null) {
            LayoutParams layoutParams = new LayoutParams(surfaceSize.width, surfaceSize.height);
            layoutParams.addRule(13);
            this.dfa.setLayoutParams(layoutParams);
            this.dfa.invalidate();
        }
    }

    /* renamed from: hb */
    private void m19767hb(boolean z) {
        if (z) {
            if (this.dgC == null) {
                this.dgC = new FunnyThemeMusicView(this);
                this.dgC.mo30408a(this.dgA.arI(), this.dgA.arH());
                ((ViewGroup) findViewById(R.id.root)).addView(this.dgC, new LayoutParams(-1, -1));
            }
            if (this.dgC.isHidden()) {
                C2564c.m7322a(this.dgC, (float) C5840b.cEx, 0.0f, new C2569a() {
                    public void onFinish() {
                        FunnyEditActivity.this.dgC.onHiddenChanged(false);
                    }
                });
            }
        } else if (this.dgC != null && !this.dgC.isHidden()) {
            C2564c.m7324b(this.dgC, 0.0f, (float) C5840b.cEx, new C2569a() {
                public void onFinish() {
                    FunnyEditActivity.this.dgC.onHiddenChanged(true);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: FV */
    public String[] mo22813FV() {
        return new String[]{FunnySlideRouter.ACTION_FINISH_FUNNY_ACTIVITY};
    }

    /* renamed from: a */
    public void mo30323a(int i, SlideSceneModel slideSceneModel) {
        if (this.dgB != null) {
            this.dgB.mo30396a(i, slideSceneModel);
        }
    }

    public void abA() {
        finish();
    }

    public void arv() {
        m19767hb(false);
    }

    public View arw() {
        return this.dgt;
    }

    /* renamed from: bE */
    public void mo30327bE(List<SlideSceneModel> list) {
        if (list != null && list.size() > 0) {
            if (this.dgB == null) {
                this.dgB = new C6822b(this);
                this.dgB.mo30398b(new C6753a() {
                    /* renamed from: a */
                    public void mo30215a(int i, SlideModel slideModel) {
                        if (slideModel != null) {
                            FunnyEditActivity.this.dgA.mo30367pd(slideModel.getPreviewPos());
                        }
                    }
                });
                this.dgw.setAdapter(this.dgB);
            }
            this.dgB.mo30399bH(list);
        }
    }

    public Activity getActivity() {
        return this;
    }

    /* renamed from: hc */
    public void mo30329hc(boolean z) {
        if (z) {
            SurfaceView surfaceView = new SurfaceView(this);
            this.dfa.addView(surfaceView, new LayoutParams(-1, -1));
            this.dgA.mo30360b(surfaceView.getHolder());
            abu();
            return;
        }
        this.dgA.aoe();
        C6781a.asc().mo30315fv(getApplicationContext());
        abA();
    }

    /* renamed from: hd */
    public void mo30330hd(boolean z) {
        if (z) {
            this.clC.setSelected(true);
            if (this.dgx.isShown()) {
                this.dgx.setVisibility(8);
                return;
            }
            return;
        }
        this.clC.setSelected(false);
        List arL = this.dgA.arL();
        if (arL == null || arL.size() <= 0) {
            this.dgx.setVisibility(8);
            return;
        }
        this.dgx.setDataList(arL);
        this.dgx.invalidate();
        this.dgx.setVisibility(0);
    }

    public void onBackPressed() {
        if (this.dgC == null || this.dgC.isHidden()) {
            this.dgA.arR();
            return;
        }
        if (!this.dgC.onBackPressed()) {
            m19767hb(false);
        }
    }

    public void onClick(View view) {
        if (!C4580b.m11632Sf()) {
            if (view == this.clC) {
                C2564c.m7327dA(view);
                if (this.clC.isSelected()) {
                    this.dgA.pause();
                } else {
                    this.dgA.mo30367pd(0);
                    this.dgA.play();
                }
            } else if (view == this.cFn) {
                C2564c.m7327dA(view);
                this.dgA.arR();
            } else {
                boolean z = true;
                if (view == this.dgv) {
                    C2564c.m7327dA(view);
                    Context applicationContext = getApplicationContext();
                    if (this.dgC == null || !this.dgC.asb()) {
                        z = false;
                    }
                    C6738a.m19556M(applicationContext, z);
                    if (this.dgA != null && this.dgA.arM()) {
                        C4586g.m11704a((Context) this, R.string.xiaoying_str_com_loading, (OnCancelListener) null, false);
                        this.dgA.aoe();
                        this.dgv.postDelayed(new Runnable() {
                            public void run() {
                                C4586g.m11696Sm();
                                boolean isInIndia = AppStateModel.getInstance().isInIndia();
                                boolean isMiddleEast = AppStateModel.getInstance().isMiddleEast();
                                if (isInIndia || isMiddleEast) {
                                    VivaRouter.getRouterBuilder(DomeSocialPublishParams.URL).mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_FROM_SOCIAL, true).mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_SLIDE_SHOW_VIDEO, true).mo10394aZ(R.anim.activity_enter, R.anim.activity_exit).mo10382H(FunnyEditActivity.this);
                                } else {
                                    FunnySlideRouter.launchFunnyShare(FunnyEditActivity.this, FunnyEditActivity.this.dgy, FunnyEditActivity.this.dgz);
                                }
                            }
                        }, 500);
                    }
                } else if (view == this.dgu) {
                    C2564c.show(this.dgu.getChildAt(0));
                    this.dgA.pause();
                    m19767hb(true);
                    C6738a.m19564fn(getApplicationContext());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        setContentView(R.layout.editor_act_funny_edit);
        long longExtra = getIntent().getLongExtra(FunnySlideRouter.INTENT_KEY_APPLY_THEME_ID, 0);
        this.dgz = C8762d.aMt().mo35241l(longExtra, 4);
        this.dgy = C8450a.m24469bn(longExtra);
        mo22812FU();
        this.dgA = new C6803a();
        this.dgA.attachView((C6818b) this);
        this.dgA.mo30362h(this, longExtra);
        m19764Kl();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.dgA.release();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.dgA.onActivityPause();
        if (isFinishing()) {
            this.dgA.aoe();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.dgA.onActivityResume();
    }

    /* renamed from: pg */
    public void mo30332pg(int i) {
        if (this.dgB != null) {
            this.dgB.mo30400pa(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo22820q(Intent intent) {
        if (FunnySlideRouter.ACTION_FINISH_FUNNY_ACTIVITY.equals(intent.getAction())) {
            this.dgA.aoe();
            if (intent.getBooleanExtra(FunnySlideRouter.DELETE_FUNNY_VIDEO_FILE, true)) {
                C6781a.asc().mo30315fv(getApplicationContext());
            }
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent(FunnySlideRouter.ACTION_FINISH_FUNNY_INFO_ACTIVITY));
            abA();
        }
    }
}
