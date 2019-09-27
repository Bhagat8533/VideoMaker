package com.introvd.template.editor.slideshow.story;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.Constants;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.effects.C5910b;
import com.introvd.template.editor.effects.ColorfulSeekLayout;
import com.introvd.template.editor.slideshow.story.p286b.C6851b;
import com.introvd.template.editor.slideshow.story.p286b.C6859d;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.parammodels.PickCoverParams;
import com.introvd.template.router.slide.SlideshowRouter;

@C1942a(mo10417rZ = "/Slide/Cover")
public class SimpleCoverActivity extends EventActivity implements C6851b {
    RelativeLayout clu;
    /* access modifiers changed from: private */
    public String ctC = "";
    ImageView dhV;
    ImageView dhW;
    SurfaceView dhX;
    ColorfulSeekLayout dhY;
    /* access modifiers changed from: private */
    public C6859d dhZ;
    private int dia;

    private void abu() {
        MSize asm = this.dhZ.asm();
        if (asm != null) {
            LayoutParams layoutParams = new LayoutParams(asm.width, asm.height);
            layoutParams.addRule(13);
            this.clu.setLayoutParams(layoutParams);
            this.clu.invalidate();
        }
    }

    private void initUI() {
        this.dhV = (ImageView) findViewById(R.id.xiaoying_btn_finish);
        this.dhW = (ImageView) findViewById(R.id.img_back);
        this.clu = (RelativeLayout) findViewById(R.id.preview_layout);
        this.dhY = (ColorfulSeekLayout) findViewById(R.id.timeline_layout);
        this.dhY.setOnVideoEditorSeekListener(new C5910b() {
            public void aav() {
                SimpleCoverActivity.this.dhZ.play();
            }

            public void pauseVideo() {
                SimpleCoverActivity.this.dhZ.pause();
            }
        });
        this.dhY.setmOnTimeLineSeekListener(this.dhZ.aso());
        this.dhY.postDelayed(new Runnable() {
            public void run() {
                SimpleCoverActivity.this.dhY.mo28319a(SimpleCoverActivity.this.dhZ.getStoryboard(), SimpleCoverActivity.this.dhZ.asn());
            }
        }, 100);
        this.dhW.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SimpleCoverActivity.this.abA();
            }
        });
        this.dhV.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SimpleCoverActivity.this.dhZ.mo30494iH(SimpleCoverActivity.this.ctC);
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
        this.dhX = (SurfaceView) findViewById(R.id.surface_view);
        this.dhZ.mo30492b(this.dhX.getHolder());
    }

    public MSize adN() {
        return new MSize(Constants.getScreenSize().width, (Constants.getScreenSize().height - C5840b.cEx) - C4583d.m11673ii(48));
    }

    public Activity getActivity() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        mo22815FX();
        setContentView(R.layout.editor_act_slide_cover_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.ctC = extras.getString(PickCoverParams.ACTIVITY_COVER_PICK_RESULT_KEY);
            this.dia = (int) extras.getLong(PickCoverParams.ACTIVITY_COVER_PICK_TIME_POSITION_KEY);
            z = extras.getBoolean(SlideshowRouter.KEY_INTENT_PRJ_SLIDE, true);
        } else {
            z = false;
        }
        this.dhZ = new C6859d();
        this.dhZ.attachView((C6851b) this);
        this.dhZ.mo30483a((Context) this, z, this.dia, false);
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
        if (z) {
            Intent intent = new Intent();
            intent.putExtra(PickCoverParams.ACTIVITY_COVER_PICK_TIME_POSITION_KEY, i);
            setResult(-1, intent);
        } else {
            setResult(0);
        }
        abA();
    }
}
