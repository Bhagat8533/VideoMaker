package com.introvd.template.editor.preview.theme.duration;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.preview.p271b.C6550a;
import com.introvd.template.editor.preview.p271b.C6552c;
import com.introvd.template.editor.preview.theme.C6664c;
import com.introvd.template.editor.preview.theme.duration.SeekBarDuration.C6666a;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.utils.p394b.C8540q;
import org.greenrobot.eventbus.C10021c;
import xiaoying.engine.base.QRange;
import xiaoying.engine.clip.QClip;

@SuppressLint({"ViewConstructor"})
public class ThemeDurationView extends BaseOperationView<C5686a> {
    private int cDs;
    private RelativeLayout ddm;
    /* access modifiers changed from: private */
    public SeekBarDuration ddn;
    private String ddo = "";
    /* access modifiers changed from: private */
    public int ddp;

    public ThemeDurationView(Activity activity) {
        super(activity, C5686a.class);
    }

    /* renamed from: Nu */
    private void m19379Nu() {
        this.ddm.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ThemeDurationView.this.alO();
                ThemeDurationView.this.exit();
            }
        });
    }

    /* access modifiers changed from: private */
    public void alO() {
        C10021c.aZH().mo38492aA(new C6552c());
        C10021c.aZH().mo38492aA(new C6550a(2));
        if (!TextUtils.isEmpty(this.ddo)) {
            C6664c.m19368bG(getContext(), this.ddo);
        }
        getEditor().mo27846H(0, this.ddn.getProgress() != this.cDs);
    }

    private int getFirstImgDuration() {
        if (getEditor().adQ() != null) {
            int count = getEditor().adQ().getCount();
            for (int i = 0; i < count; i++) {
                C8440a tX = getEditor().adQ().mo34307tX(i);
                if (tX != null && !tX.isCover() && tX.isImage()) {
                    return tX.aHV();
                }
            }
        }
        return 2000;
    }

    /* renamed from: oO */
    private float m19387oO(int i) {
        if (i <= 1) {
            return 0.1f;
        }
        return ((float) i) / 10.0f;
    }

    /* access modifiers changed from: private */
    /* renamed from: oP */
    public void m19388oP(int i) {
        if (getEditor() != null && getEditor().adK() != null && getEditor().adK().aHe() != null && getEditor().adK().aHe().isMVPrj() && getEditor().adQ() != null) {
            float oO = m19387oO(i);
            StringBuilder sb = new StringBuilder();
            sb.append("value：");
            sb.append(oO);
            LogUtils.m14222e("IOOOIII", sb.toString());
            this.ddo = String.valueOf(oO);
            int count = getEditor().adQ().getCount();
            for (int i2 = 0; i2 < count; i2++) {
                C8440a tX = getEditor().adQ().mo34307tX(i2);
                if (tX != null && !tX.isCover() && tX.isImage()) {
                    QClip i3 = C8540q.m24956i(getEditor().adO(), i2);
                    if (i3 != null) {
                        QRange aHT = tX.aHT();
                        if (aHT.get(0) < 0) {
                            aHT.set(0, 0);
                            C5839a.m16330eA(VivaBaseApplication.m8749FZ());
                        }
                        aHT.set(1, (int) (1000.0f * oO));
                        if (i3.setProperty(12292, aHT) == 0) {
                            C8540q.m24903L(getEditor().adO());
                            if (getEditor().adS() != null) {
                                getEditor().adS().mo34143b(getEditor().adO(), true);
                            }
                        }
                    }
                }
            }
            if (getVideoOperator() != null) {
                getVideoOperator().setAutoPlayWhenReady(true);
                getVideoOperator().mo29687cH(0, 0);
            }
        }
    }

    public void aex() {
        super.aex();
        this.ddm = (RelativeLayout) findViewById(R.id.layout_2lev_hide);
        this.ddn = (SeekBarDuration) findViewById(R.id.seekBarDuration);
        this.cDs = this.ddn.mo30053oL(getFirstImgDuration());
        this.ddn.setProgress(this.cDs);
        this.ddn.setTvDuration(this.cDs);
        this.ddn.setOnSeekBarChangeListener(new C6666a() {
            public void agf() {
            }

            public void agg() {
                ThemeDurationView.this.getEditor().adX();
                ThemeDurationView.this.ddp = ThemeDurationView.this.ddn.getProgress();
            }

            public void agh() {
                int progress = ThemeDurationView.this.ddn.getProgress();
                ThemeDurationView.this.ddn.mo30055oN(progress);
                if (ThemeDurationView.this.ddp != progress) {
                    ThemeDurationView.this.ddp = progress;
                    ThemeDurationView.this.m19388oP(progress);
                    ThemeDurationView.this.cyD.adL().mo34669jt(true);
                }
            }
        });
        m19379Nu();
    }

    public int getLayoutId() {
        return R.layout.editor_theme_duration_view;
    }

    public int getViewHeight() {
        return C4583d.m11673ii(190);
    }

    public boolean onBackPressed() {
        alO();
        return false;
    }
}
