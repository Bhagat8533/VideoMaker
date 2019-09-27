package com.introvd.template.editor.slideshow.story;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.Constants;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.title.C5866b;
import com.introvd.template.editor.common.title.EditorTitle;
import com.introvd.template.editor.effects.C5910b;
import com.introvd.template.editor.effects.ColorfulSeekLayout;
import com.introvd.template.editor.slideshow.story.p286b.C6851b;
import com.introvd.template.editor.slideshow.story.p286b.C6859d;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.PublishParams.DomeSocialPublishParams;
import com.introvd.template.router.community.svip.ISvipAPI;
import com.introvd.template.router.slide.SlideshowRouter;
import com.introvd.template.sdk.p391g.C8450a;

@C1942a(mo10417rZ = "/Story/Preview")
public class StoryPreviewActivity extends EventActivity implements C6851b {
    private RelativeLayout bMj;
    private SurfaceView cYf;
    private EditorTitle dfg;
    /* access modifiers changed from: private */
    public ColorfulSeekLayout dhY;
    /* access modifiers changed from: private */
    public C6859d dhZ;

    private void abu() {
        MSize asm = this.dhZ.asm();
        if (asm != null) {
            LayoutParams layoutParams = new LayoutParams(asm.width, asm.height);
            layoutParams.addRule(13);
            this.bMj.setLayoutParams(layoutParams);
            this.bMj.invalidate();
        }
    }

    private void initUI() {
        this.dfg = (EditorTitle) findViewById(R.id.slide_title_layout);
        this.bMj = (RelativeLayout) findViewById(R.id.preview_layout);
        this.dhY = (ColorfulSeekLayout) findViewById(R.id.silde_timeline_layout);
        this.dhY.setOnVideoEditorSeekListener(new C5910b() {
            public void aav() {
                StoryPreviewActivity.this.dhZ.play();
            }

            public void pauseVideo() {
                StoryPreviewActivity.this.dhZ.pause();
            }
        });
        this.dhY.setmOnTimeLineSeekListener(this.dhZ.aso());
        this.dhY.postDelayed(new Runnable() {
            public void run() {
                StoryPreviewActivity.this.dhY.mo28319a(StoryPreviewActivity.this.dhZ.getStoryboard(), StoryPreviewActivity.this.dhZ.asn());
            }
        }, 100);
        this.dfg.setTitleListener(new C5866b() {
            public void ahD() {
                StudioRouter.launchStudioActivity(StoryPreviewActivity.this);
                StoryPreviewActivity.this.abA();
            }

            public void ahE() {
                String bn = C8450a.m24469bn(StoryPreviewActivity.this.dhZ.are());
                ISvipAPI iSvipAPI = (ISvipAPI) BizServiceManager.getService(ISvipAPI.class);
                if (iSvipAPI == null || !iSvipAPI.checkCommodityNeedLogin(bn)) {
                    VivaRouter.getRouterBuilder(DomeSocialPublishParams.URL).mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_FROM_SOCIAL, false).mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_SLIDE_SHOW_VIDEO, true).mo10394aZ(R.anim.activity_enter, R.anim.activity_exit).mo10382H(StoryPreviewActivity.this);
                    StoryPreviewActivity.this.abA();
                }
            }

            public void onBack() {
                StoryPreviewActivity.this.dhZ.arn();
            }
        });
    }

    /* renamed from: J */
    public void mo30448J(int i, boolean z) {
        if (this.dhY != null) {
            this.dhY.mo28315J(i, z);
        }
    }

    /* renamed from: K */
    public void mo30449K(int i, boolean z) {
        if (this.dhY != null) {
            this.dhY.mo28316K(i, z);
        }
    }

    /* renamed from: L */
    public void mo30450L(int i, boolean z) {
        if (this.dhY != null) {
            this.dhY.mo28317L(i, z);
        }
    }

    /* renamed from: M */
    public void mo30451M(int i, boolean z) {
        if (this.dhY != null) {
            this.dhY.mo28318M(i, z);
        }
    }

    public void abA() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void abt() {
        this.cYf = (SurfaceView) findViewById(R.id.surface_view);
        this.dhZ.mo30492b(this.cYf.getHolder());
    }

    public MSize adN() {
        return new MSize(Constants.getScreenSize().width, Constants.getScreenSize().height - C5840b.cEx);
    }

    public Activity getActivity() {
        return this;
    }

    public void onBackPressed() {
        this.dhZ.arn();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        setContentView(R.layout.editor_act_story_preview_layout);
        boolean booleanExtra = getIntent().getBooleanExtra(SlideshowRouter.KEY_INTENT_PREVIEW_AUTOPLAY, false);
        this.dhZ = new C6859d();
        this.dhZ.attachView((C6851b) this);
        this.dhZ.mo30483a((Context) this, true, 0, booleanExtra);
        initUI();
        abu();
        abt();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.dhZ.release();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.dhZ.onActivityPause();
        if (isFinishing()) {
            this.dhZ.aoe();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.dhZ.onActivityResume();
    }

    /* renamed from: p */
    public void mo30456p(boolean z, int i) {
    }
}
