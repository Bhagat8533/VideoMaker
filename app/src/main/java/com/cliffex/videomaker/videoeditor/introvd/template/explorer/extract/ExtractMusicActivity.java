package com.introvd.template.explorer.extract;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.explorer.music.p303a.C7256a;
import com.introvd.template.explorer.music.p304b.C7265d;
import com.introvd.template.explorer.p308ui.C7343a;
import com.introvd.template.explorer.p308ui.WaveSeekBar;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.explorer.ExplorerRouter;
import com.introvd.template.router.explorer.ExplorerRouter.ExtractMusicNextActionParams;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.p395a.C8513g;
import com.introvd.template.sdk.utils.p394b.p395a.C8514h;
import com.introvd.template.sdk.utils.p397d.C8547b;
import com.introvd.template.vivaexplorermodule.R;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.io.File;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.p054b.C1494a;
import xiaoying.basedef.QRange;

@LDPProtect
@C1942a(mo10417rZ = "/Explorer/VideoExtract")
public class ExtractMusicActivity extends EventActivity implements C7236c, C8513g {
    public static final String TAG = "ExtractMusicActivity";
    ImageView bIa;
    private C1494a compositeDisposable;
    ImageButton cti;
    RelativeLayout dxQ;
    SurfaceView dxR;
    WaveSeekBar dxS;
    TextView dxT;
    ImageView dxU;
    C7343a dxV;
    private String dxW;
    private int dxX;
    /* access modifiers changed from: private */
    public C7225a dxY;
    private C8514h dxZ;

    /* renamed from: Oj */
    private void m21305Oj() {
        avX();
        this.dxQ = (RelativeLayout) findViewById(R.id.layout_surface);
        this.dxR = (SurfaceView) findViewById(R.id.surface_view);
        this.dxY.mo31727c(this.dxR.getHolder());
        this.cti = (ImageButton) findViewById(R.id.play_btn);
        this.bIa = (ImageView) findViewById(R.id.btn_back);
        this.dxT = (TextView) findViewById(R.id.btn_confirm);
        this.dxU = (ImageView) findViewById(R.id.icon_vip);
        this.dxV = new C7343a(this);
        if (1 == this.dxX) {
            this.dxU.setVisibility(8);
            this.dxT.setText(getResources().getString(R.string.xiaoying_music_extract_direct_btn_confirm_text));
        } else {
            this.dxU.setVisibility(0);
            this.dxT.setText(getResources().getString(R.string.xiaoying_str_com_add));
        }
        ams();
        abu();
    }

    private void abu() {
        VeMSize awh = this.dxY.awh();
        if (awh != null) {
            LayoutParams layoutParams = new LayoutParams(awh.width, awh.height);
            layoutParams.addRule(13);
            this.dxQ.setLayoutParams(layoutParams);
            this.dxQ.invalidate();
        }
    }

    private void ams() {
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                if (ExtractMusicActivity.this.cti.isSelected()) {
                    ExtractMusicActivity.this.dxY.pause();
                } else {
                    ExtractMusicActivity.this.dxY.play();
                }
            }
        }, this.cti);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                ExtractMusicActivity.this.dxY.pause();
            }
        }, this.dxQ);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                ExtractMusicActivity.this.finish();
            }
        }, this.bIa);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                ExtractMusicActivity.this.m21308cP(view);
            }
        }, this.dxT);
    }

    private void avW() {
        this.dxX = getIntent().getIntExtra(ExtractMusicNextActionParams.KEY_NEXT_ACTION, 0);
    }

    private void avX() {
        this.dxS = (WaveSeekBar) findViewById(R.id.wave_view);
        if (this.dxY != null) {
            this.dxS.setWaveChangeCallback(this.dxY.awi());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cP */
    public void m21308cP(View view) {
        int selectedMinValue = this.dxS.getSelectedMinValue();
        int selectedMaxValue = this.dxS.getSelectedMaxValue();
        if (1 == this.dxX) {
            m21309l(C8547b.m24989a(C8501a.aJs().aJv(), new QRange(selectedMinValue, selectedMaxValue - selectedMinValue), this.dxW, false, false));
        } else if (!C8049f.aBf().aBr() || C8072q.aBx().mo33072ku(C7825a.AUDIO_EXTRA.getId())) {
            C2564c.m7327dA(view);
            C7256a.m21414fT(getApplicationContext());
            MusicDataItem musicDataItem = new MusicDataItem();
            musicDataItem.filePath = this.dxW;
            musicDataItem.startTimeStamp = selectedMinValue;
            musicDataItem.stopTimeStamp = selectedMaxValue;
            C10021c.aZH().mo38492aA(new C7265d(true, musicDataItem));
            finish();
        } else {
            C8049f.aBf().mo33097b(this, C8070o.aBw(), C7825a.AUDIO_EXTRA.getId(), "audio_extraction", -1);
        }
    }

    /* renamed from: l */
    private void m21309l(TrimedClipItemDataModel trimedClipItemDataModel) {
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.getMediaSavePath());
        sb.append(C8468c.aIR());
        sb.append(File.separator);
        String fileName = FileUtils.getFileName(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C8401d.ane());
        sb2.append(fileName);
        this.dxZ = new C8514h(getApplicationContext(), C8501a.aJs().aJv(), sb2.toString());
        this.dxZ.init();
        this.dxZ.mo34696a((C8513g) this);
        this.dxZ.mo34698q(trimedClipItemDataModel);
    }

    public void abA() {
        finish();
    }

    public MSize adN() {
        return new MSize(Constants.getScreenSize().width, (Constants.getScreenSize().height - C4583d.m11673ii(44)) - C4583d.m11673ii(220));
    }

    public void amb() {
        C8554j.m25007e(TAG, " onProducerReleased");
        this.dxV.dismiss();
    }

    public void avY() {
        C8554j.m25007e(TAG, " onExtractStart");
        this.dxV.show();
    }

    public void avZ() {
        C8554j.m25007e(TAG, " onExtractCancel");
        this.dxV.dismiss();
    }

    public Activity getHostActivity() {
        return this;
    }

    /* renamed from: hd */
    public void mo31700hd(boolean z) {
        if (z) {
            this.cti.setSelected(true);
        } else {
            this.cti.setSelected(false);
        }
    }

    /* renamed from: iY */
    public void mo31701iY(String str) {
        C8554j.m25007e(TAG, " onExtractSuccess");
        this.dxV.dismiss();
        ExplorerRouter.launchMusicDirectExtractActivity(this, str, 4153);
    }

    /* renamed from: nF */
    public void mo31702nF(int i) {
        this.dxS.mo31965a(0, i, new double[]{0.1d, 0.1d, 0.3d, 0.6d, 0.9d, 0.4d, 0.6d, 0.5d, 0.7d, 1.0d, 0.9d, 0.7d, 1.0d, 0.3d, 0.4d, 0.2d, 0.5d, 0.6d, 0.4d, 0.7d, 0.3d, 0.1d, 0.1d, 0.3d, 0.6d, 0.9d, 0.4d, 0.6d, 0.5d, 0.7d, 1.0d, 0.9d, 0.7d, 1.0d, 0.3d, 0.4d, 0.2d, 0.5d, 0.6d, 0.4d, 0.7d, 0.3d, 0.1d, 0.1d, 0.3d, 0.6d, 0.9d, 0.4d, 0.6d, 0.5d, 0.7d, 1.0d, 0.9d, 0.7d, 1.0d, 0.3d, 0.4d, 0.2d, 0.5d, 0.6d, 0.4d, 0.7d, 0.3d, 0.1d, 0.1d, 0.3d, 0.6d, 0.9d, 0.4d, 0.6d, 0.5d, 0.7d, 1.0d, 0.9d, 0.7d, 1.0d, 0.3d, 0.4d, 0.2d, 0.5d, 0.6d, 0.4d, 0.7d, 0.3d, 0.1d, 0.1d, 0.3d, 0.6d, 0.9d, 0.4d, 0.6d, 0.5d, 0.7d, 1.0d, 0.9d, 0.7d, 1.0d, 0.3d, 0.4d, 0.2d, 0.5d, 0.6d, 0.4d, 0.7d, 0.3d, 0.1d, 0.1d, 0.3d, 0.6d, 0.9d, 0.4d, 0.6d, 0.5d, 0.7d, 1.0d, 0.9d, 0.7d, 1.0d, 0.3d, 0.4d, 0.2d, 0.5d, 0.6d, 0.4d, 0.7d, 0.3d, 0.1d, 0.1d, 0.3d, 0.6d, 0.9d, 0.4d, 0.6d, 0.5d, 0.7d, 1.0d, 0.9d, 0.7d, 1.0d, 0.3d, 0.4d, 0.2d, 0.5d, 0.6d, 0.4d, 0.7d, 0.3d, 0.1d, 0.1d, 0.3d, 0.6d, 0.9d, 0.4d, 0.6d, 0.5d, 0.7d, 1.0d, 0.9d, 0.7d, 1.0d, 0.3d, 0.4d, 0.2d, 0.5d, 0.6d, 0.4d, 0.7d, 0.3d, 0.1d, 0.1d, 0.3d, 0.6d, 0.9d, 0.4d, 0.6d, 0.5d, 0.7d, 1.0d, 0.9d, 0.7d, 1.0d, 0.3d, 0.4d, 0.2d, 0.5d, 0.6d, 0.4d, 0.7d, 0.3d, 0.1d, 0.1d}, 0, i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (4153 == i && -1 == i2) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        setContentView(R.layout.explorer_extract_music_activity_layout);
        this.dxW = getIntent().getStringExtra(ExplorerRouter.INTENT_KEY_VIDEO_FILE_PATH);
        this.compositeDisposable = new C1494a();
        this.dxY = new C7225a();
        this.dxY.attachView((C7236c) this);
        this.dxY.mo31726bR(getApplicationContext(), this.dxW);
        avW();
        m21305Oj();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.dxY != null) {
            this.dxY.onActivityPause();
        }
        if (isFinishing()) {
            if (this.dxY != null) {
                this.dxY.release();
            }
            if (this.compositeDisposable != null) {
                this.compositeDisposable.clear();
            }
        }
    }

    public void onProgress(int i) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(" progress = ");
        sb.append(i);
        C8554j.m25007e(str, sb.toString());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.dxY != null) {
            this.dxY.onActivityResume();
        }
    }

    /* renamed from: qx */
    public void mo31704qx(int i) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(" onExtractFail errcode = ");
        sb.append(i);
        C8554j.m25007e(str, sb.toString());
        this.dxV.dismiss();
    }
}
