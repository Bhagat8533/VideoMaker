package com.introvd.template.editor.effects.dub;

import android.app.Activity;
import android.graphics.Rect;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.dub.recordview.RecordView;
import com.introvd.template.editor.effects.dub.title.DubChooseTitleView;
import com.introvd.template.editor.effects.dub.title.DubChooseTitleView.C6106a;
import com.introvd.template.editor.effects.music.AudioEditBaseView;
import com.introvd.template.explorer.music.XYMusicEffectFragment;
import com.introvd.template.explorer.p297b.C7140b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p363o.C8092b;
import com.introvd.template.p363o.C8100e;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p381b.p382a.C8387c;
import com.introvd.template.sdk.utils.C8572y;
import com.vivavideo.component.permission.C9295b;
import java.io.File;

public class DubOperationView extends AudioEditBaseView<C6102b> {
    protected TextView cGX;
    /* access modifiers changed from: private */
    public DubChooseTitleView cKE;
    protected LinearLayout cKF;
    protected ImageView cKG;
    protected RecordView cKH;
    protected FrameLayout cKI;
    protected XYMusicEffectFragment cKJ;
    protected boolean cKK = false;
    private C6101a cKL;
    private String cKM = "";
    /* access modifiers changed from: private */
    public int cKN = 0;
    private boolean cKO;
    private OnClickListener cKP = new OnClickListener() {
        public void onClick(View view) {
            ((C6102b) DubOperationView.this.getEditor()).adX();
            if (view.equals(DubOperationView.this.cGX)) {
                if (DubOperationView.this.currentState == 0) {
                    DubOperationView.this.mo28834Wy();
                } else if (DubOperationView.this.currentState == 1) {
                    C6103c.m17405eR(DubOperationView.this.getContext());
                    DubOperationView.this.alf();
                }
            } else if (view.equals(DubOperationView.this.cKG)) {
                DubOperationView.this.ajN();
            }
        }
    };
    private OnTouchListener cKQ = new OnTouchListener() {
        private long cKS = 0;

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(DubOperationView.this.cKE.getCurrentChooseMode() == 0 && (DubOperationView.this.currentState == 0 || DubOperationView.this.currentState == 2))) {
                return false;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (DubOperationView.this.m17379f(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.cKS = System.currentTimeMillis();
                        ((C6102b) DubOperationView.this.getEditor()).adX();
                        ((C6102b) DubOperationView.this.getEditor()).mo27870ep(true);
                        ((C6102b) DubOperationView.this.getEditor()).mo27873h(0, ((C6102b) DubOperationView.this.getEditor()).adO().getDuration(), false);
                        if (DubOperationView.this.currentState != 0) {
                            if (DubOperationView.this.currentState == 2) {
                                DubOperationView.this.ajM();
                                break;
                            }
                        } else if (C9295b.m26985b(DubOperationView.this.getContext().getApplicationContext(), C8092b.dXx)) {
                            DubOperationView.this.cKN = 0;
                            int adZ = ((C6102b) DubOperationView.this.getEditor()).adZ();
                            int ne = ((C6102b) DubOperationView.this.getEditor()).mo28998ne(adZ);
                            if (ne <= 500) {
                                ToastUtils.show(DubOperationView.this.getContext().getApplicationContext(), R.string.xiaoying_str_ve_msg_ve_dub_avail_empty_duration_too_short, 0);
                                break;
                            } else {
                                DubOperationView.this.cKN = ne + adZ;
                                DubOperationView.this.cMO = adZ;
                                DubOperationView.this.startRecording();
                                break;
                            }
                        } else {
                            C8100e.m23485aS(DubOperationView.this.getActivity());
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
                case 1:
                case 3:
                    DubOperationView.this.cKG.setImageResource(R.drawable.editor_btn_effect_add_cancel_n);
                    if (DubOperationView.this.currentState == 2) {
                        long currentTimeMillis = System.currentTimeMillis() - this.cKS;
                        if (!DubOperationView.this.m17382g(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                            if (currentTimeMillis >= 500) {
                                DubOperationView.this.ajM();
                                break;
                            }
                        } else {
                            DubOperationView.this.ajN();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (DubOperationView.this.currentState == 2) {
                        if (!DubOperationView.this.m17382g(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                            DubOperationView.this.cKG.setImageResource(R.drawable.editor_btn_effect_add_cancel_n);
                            break;
                        } else {
                            DubOperationView.this.cKG.setImageResource(R.drawable.editor_btn_effect_add_cancel_p);
                            break;
                        }
                    }
                    break;
            }
            return true;
        }
    };

    public DubOperationView(Activity activity) {
        super(activity, C6102b.class);
    }

    /* access modifiers changed from: private */
    public boolean akp() {
        if (this.cKJ == null || !this.cKK) {
            return false;
        }
        ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().hide(this.cKJ).commitAllowingStateLoss();
        this.cKK = false;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m17379f(View view, int i, int i2) {
        Rect rect = new Rect();
        int left = ((ViewGroup) this.cKH.getParent()).getLeft();
        int top = ((ViewGroup) this.cKH.getParent()).getTop();
        this.cKH.getHitRect(rect);
        rect.offset(left, top);
        rect.inset(0, -10);
        return rect.contains(i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: fr */
    public void m17380fr(boolean z) {
        if (z) {
            if (!this.cKO || !TextUtils.isEmpty(this.cMQ)) {
                mo28834Wy();
            }
            this.cKO = false;
        } else {
            akp();
        }
        ((C6102b) getEditor()).cML = true;
        mo28850mL(((C6102b) getEditor()).adZ());
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m17382g(View view, int i, int i2) {
        Rect rect = new Rect();
        int left = ((ViewGroup) this.cKG.getParent()).getLeft();
        int top = ((ViewGroup) this.cKG.getParent()).getTop();
        this.cKG.getHitRect(rect);
        if (C4580b.m11666qi()) {
            rect.left = (Constants.getScreenSize().width - rect.left) - this.cKG.getWidth();
            rect.right = rect.left + this.cKG.getWidth();
        }
        rect.offset(left, top);
        rect.inset(0, -10);
        return rect.contains(i, i2);
    }

    /* renamed from: hr */
    private boolean m17384hr(String str) {
        boolean z = true;
        if (this.cKL == null) {
            CommonConfigure.APP_DEFAULT_AUDIO_SAMPLERATE = C8387c.m24162T(getContext().getApplicationContext(), true);
            this.cKL = new C6101a();
            this.cKL.init();
        } else {
            this.cKL.akg();
        }
        if (str.endsWith("tmp.3gp")) {
            return false;
        }
        if (this.cKL.mo28858hq(str) != 0) {
            z = false;
        }
        return z;
    }

    private void setOnRecordingState(boolean z) {
        if (z) {
            ((C6102b) getEditor()).mo28994fD(false);
            this.cLQ.setBtnVisibility(false);
            this.cyJ.setFineTuningEnable(false);
            this.cyJ.setDisablePauseBtn(true);
            ((C6102b) getEditor()).setTouchDownPausable(false);
            return;
        }
        ((C6102b) getEditor()).mo28994fD(true);
        this.cLQ.setBtnVisibility(true);
        this.cyJ.setFineTuningEnable(true);
        this.cyJ.setDisablePauseBtn(false);
        ((C6102b) getEditor()).setTouchDownPausable(true);
    }

    /* access modifiers changed from: private */
    public void startRecording() {
        if (this.currentState == 0) {
            if (this.cKL != null) {
                this.cKL.akg();
            }
            ProjectItem ahP = ((C6102b) getEditor()).adK().aHf();
            if (ahP != null && ahP.mProjectDataItem != null) {
                this.cKM = C8572y.m25098ov(ahP.mProjectDataItem.strPrjURL);
                int adZ = ((C6102b) getEditor()).adZ();
                int ne = ((C6102b) getEditor()).mo28998ne(adZ);
                if (m17384hr(this.cKM)) {
                    mo28851ms(2);
                    ((C6102b) getEditor()).mo27870ep(false);
                    setOnRecordingState(true);
                    ((C6102b) getEditor()).mo27868b(adZ, ne, true, adZ);
                    this.cyJ.mo28424j(adZ, ne + adZ, false);
                    this.cKH.setAnimMode(1);
                } else {
                    ((C6102b) getEditor()).mo27870ep(true);
                    ((C6102b) getEditor()).mo27873h(0, ((C6102b) getEditor()).adO().getDuration(), false);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Wy */
    public final void mo28834Wy() {
        ((C6102b) getEditor()).adX();
        if (((C6102b) getEditor()).mo28998ne(((C6102b) getEditor()).adZ()) < 500) {
            ToastUtils.show(getContext().getApplicationContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
            return;
        }
        if (this.cKJ == null) {
            this.cKJ = (XYMusicEffectFragment) C1919a.m5529sc().mo10355al(MusicParams.URL_EFFECT).mo10399f(MusicParams.EXTRA_CATEGORY_ID, this.cMQ).mo10412rX();
            this.cKJ.mo31820a((C7140b) new C7140b() {
                /* renamed from: WC */
                public void mo25762WC() {
                }

                /* renamed from: c */
                public void mo25763c(MusicDataItem musicDataItem) {
                    DubOperationView.this.akp();
                    if (musicDataItem != null && !TextUtils.isEmpty(musicDataItem.filePath) && new File(musicDataItem.filePath).exists()) {
                        C6103c.m17402bk(DubOperationView.this.getContext(), musicDataItem.title);
                        DubOperationView.this.mo28846d(musicDataItem);
                    }
                }

                /* renamed from: cZ */
                public void mo25764cZ(boolean z) {
                }
            });
            ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_bottom, R.anim.activity_slide_out_to_bottom).add(R.id.fl_container, (Fragment) this.cKJ).commitAllowingStateLoss();
        } else {
            ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_bottom, R.anim.activity_slide_out_to_bottom).show(this.cKJ).commitAllowingStateLoss();
        }
        this.cKK = true;
    }

    /* access modifiers changed from: protected */
    public void ajM() {
        if (this.currentState == 2) {
            ((C6102b) getEditor()).adX();
            this.cKH.setAnimMode(2);
            setOnRecordingState(false);
            int adZ = ((C6102b) getEditor()).adZ();
            this.cyJ.aiL();
            ((C6102b) getEditor()).cMM = -1;
            if (!TextUtils.isEmpty(this.cKM)) {
                if (this.cKL != null) {
                    this.cKL.akg();
                }
                int min = Math.min(this.cKN, adZ);
                if (min - this.cMO >= 500) {
                    C6103c.m17403eP(getContext());
                    ((C6102b) getEditor()).adL().mo34669jt(true);
                    C8441b a = ((C6102b) getEditor()).mo28989a(this.cKM, this.cMO, min - this.cMO, 0, min - this.cMO, 50);
                    if (a != null) {
                        VeRange aIc = a.aIc();
                        this.cyJ.mo28413c(new Range(aIc != null ? new Range(aIc.getmPosition(), aIc.getmTimeLength()) : null));
                    }
                    if (((C6102b) getEditor()).mo28995nb(min)) {
                        min--;
                    }
                    ((C6102b) getEditor()).mo27870ep(true);
                    ((C6102b) getEditor()).mo27868b(0, ((C6102b) getEditor()).adO().getDuration(), false, min);
                    ((C6102b) getEditor()).mo27846H(min, false);
                    mo28850mL(min);
                } else {
                    ajN();
                    ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
                }
            } else {
                ((C6102b) getEditor()).mo27870ep(true);
                ((C6102b) getEditor()).mo27868b(0, ((C6102b) getEditor()).adO().getDuration(), false, adZ);
                mo28850mL(adZ);
            }
            if (this.cKL != null) {
                this.cKL.unInit();
                this.cKL = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void ajN() {
        ((C6102b) getEditor()).adX();
        this.cKH.setAnimMode(2);
        setOnRecordingState(false);
        if (this.currentState == 2) {
            this.cKL.akg();
        }
        FileUtils.deleteFile(this.cKM);
        ((C6102b) getEditor()).mo27870ep(true);
        ((C6102b) getEditor()).mo27868b(0, ((C6102b) getEditor()).adO().getDuration(), false, this.cMO);
        ((C6102b) getEditor()).mo27846H(this.cMO, false);
        mo28850mL(this.cMO);
        this.cMO = 0;
    }

    /* access modifiers changed from: protected */
    public void akj() {
        this.cKG = (ImageView) findViewById(R.id.iv_editor_audio_operation_cancel);
        this.cGX = (TextView) findViewById(R.id.tv_editor_audio_operation);
        this.cKF = (LinearLayout) findViewById(R.id.ll_editor_audio_record_touch);
        this.cKH = (RecordView) findViewById(R.id.view_editor_audio_record);
        this.cKI = (FrameLayout) findViewById(R.id.fl_container);
        LayoutParams layoutParams = (LayoutParams) this.cKI.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, C4583d.m11670O(getContext(), 44));
        this.cKI.setLayoutParams(layoutParams);
        this.cKI.setPadding(0, C4583d.m11670O(getContext(), 44), 0, 0);
        EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class);
        if (editorIntentInfo != null && !TextUtils.isEmpty((String) editorIntentInfo.paramMap.get(EditorRouter.KEY_PARAMS_DUB_CHOOSE))) {
            this.cKO = true;
        }
    }

    /* access modifiers changed from: protected */
    public void akk() {
        this.cKE = new DubChooseTitleView(getContext());
        this.cKE.setOnChooseModeChangeListener(new C6106a() {
            /* renamed from: js */
            public void mo28853js(int i) {
                switch (i) {
                    case 0:
                        DubOperationView.this.m17380fr(false);
                        return;
                    case 1:
                        DubOperationView.this.m17380fr(true);
                        return;
                    default:
                        return;
                }
            }
        });
        this.cLQ.setTitleContentLayout(this.cKE);
    }

    /* access modifiers changed from: protected */
    public void akl() {
        super.akl();
        this.cGX.setOnClickListener(this.cKP);
        this.cKG.setOnClickListener(this.cKP);
        this.cKF.setOnTouchListener(this.cKQ);
        if (this.cKO) {
            this.cKE.akt();
        }
    }

    /* access modifiers changed from: protected */
    public void akm() {
        C6103c.m17404eQ(getContext());
    }

    /* access modifiers changed from: protected */
    public boolean akn() {
        return akp();
    }

    /* access modifiers changed from: protected */
    public boolean ako() {
        return akp();
    }

    /* access modifiers changed from: protected */
    public void akq() {
        ((C6102b) getEditor()).mo27870ep(true);
        ((C6102b) getEditor()).setTouchDownPausable(false);
        ajM();
    }

    /* access modifiers changed from: protected */
    public void akr() {
        super.akr();
        this.cKE.mo28867fu(false);
    }

    /* access modifiers changed from: protected */
    public void aks() {
        super.aks();
        if (this.currentState == 0) {
            this.cKE.mo28867fu(true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo28846d(MusicDataItem musicDataItem) {
        int adZ = ((C6102b) getEditor()).adZ();
        int ne = ((C6102b) getEditor()).mo28998ne(adZ);
        int i = musicDataItem.startTimeStamp;
        int srcLen = musicDataItem.getSrcLen();
        int i2 = ne < srcLen ? ne : srcLen;
        if (i2 < 500) {
            ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
            return false;
        }
        C8441b a = ((C6102b) getEditor()).mo28989a(musicDataItem.filePath, adZ, i2, i, i2, 50);
        if (a == null) {
            return false;
        }
        VeRange aIc = a.aIc();
        Range range = null;
        if (aIc != null) {
            range = new Range(aIc.getmPosition(), aIc.getmTimeLength());
        }
        this.cyJ.mo28413c(range);
        mo28850mL(((C6102b) getEditor()).adZ());
        ((C6102b) getEditor()).mo27870ep(false);
        C6102b bVar = (C6102b) getEditor();
        if (((C6102b) getEditor()).mo28995nb(i2)) {
            i2--;
        }
        bVar.mo27873h(adZ, i2, true);
        return true;
    }

    /* access modifiers changed from: protected */
    public void finish() {
        super.finish();
        if (this.cyD != null) {
            ((C6102b) this.cyD).aix();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: fs */
    public void mo28847fs(boolean z) {
        C6103c.m17400E(getContext().getApplicationContext(), z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ft */
    public void mo28848ft(boolean z) {
        C6103c.m17401F(getContext().getApplicationContext(), z);
    }

    /* access modifiers changed from: protected */
    public int getOperationViewLayout() {
        return R.layout.editor_effect_audio_dub_option_layout;
    }

    /* access modifiers changed from: protected */
    /* renamed from: mL */
    public final void mo28850mL(int i) {
        if (((C6102b) getEditor()).mo28997nd(this.cyJ.mo28430mp(i))) {
            mo28851ms(1);
        } else {
            mo28851ms(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ms */
    public final void mo28851ms(int i) {
        if (this.currentState != i || ((C6102b) getEditor()).cML) {
            this.currentState = i;
            ((C6102b) getEditor()).cML = false;
            switch (this.currentState) {
                case 0:
                    this.cKE.mo28867fu(true);
                    this.cLR.setVisibility(8);
                    this.cKG.setVisibility(8);
                    if (this.cKE.getCurrentChooseMode() == 0) {
                        this.cGX.setVisibility(8);
                        this.cKH.setVisibility(0);
                        this.cKH.setBegin(true);
                    } else {
                        this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                        this.cGX.setVisibility(0);
                        this.cKH.setVisibility(8);
                        this.cKH.setAnimMode(0);
                    }
                    this.cyJ.aiL();
                    break;
                case 1:
                    this.cKE.mo28867fu(false);
                    this.cLR.mo28980nh(((C6102b) getEditor()).currentVolume);
                    this.cLR.setVisibility(0);
                    this.cKG.setVisibility(8);
                    this.cGX.setText(R.string.xiaoying_str_person_video_delete);
                    this.cGX.setVisibility(0);
                    this.cKH.setVisibility(8);
                    this.cKH.setAnimMode(0);
                    this.cyJ.mo28429mo(((C6102b) getEditor()).cMM);
                    break;
                case 2:
                    ((C6102b) getEditor()).mo27870ep(false);
                    this.cKE.mo28867fu(false);
                    this.cLR.setVisibility(8);
                    this.cGX.setVisibility(8);
                    this.cKG.setVisibility(0);
                    this.cKH.setBegin(false);
                    break;
            }
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.cKJ != null) {
            try {
                ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().remove(this.cKJ).commitAllowingStateLoss();
                this.cKJ.mo31820a((C7140b) null);
                this.cKJ = null;
                this.cKK = false;
            } catch (Exception unused) {
            }
        }
    }

    public void onActivityPause() {
        super.onActivityPause();
        if (this.currentState == 2) {
            ajM();
        }
    }

    /* access modifiers changed from: protected */
    public void releaseAll() {
        if (this.cKL != null) {
            this.cKL.unInit();
            this.cKL = null;
        }
    }
}
