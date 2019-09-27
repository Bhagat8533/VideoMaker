package com.introvd.template.editor.effects.music;

import android.app.Activity;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.preview.p271b.C6554e;
import com.introvd.template.explorer.music.XYMusicFragment;
import com.introvd.template.explorer.p297b.C7140b;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.io.File;
import org.greenrobot.eventbus.C10021c;

public class MusicOperationView extends AudioEditBaseView<C6181b> {
    protected XYMusicFragment bRj;
    protected TextView cGX;
    protected ImageView cKG;
    private OnClickListener cKP = new OnClickListener() {
        public void onClick(View view) {
            ((C6181b) MusicOperationView.this.getEditor()).adX();
            if (view.equals(MusicOperationView.this.cGX)) {
                if (MusicOperationView.this.currentState == 0) {
                    MusicOperationView.this.mo28985Wy();
                } else if (MusicOperationView.this.currentState == 1) {
                    C6183d.m17713eW(MusicOperationView.this.getContext());
                    MusicOperationView.this.alf();
                } else if (MusicOperationView.this.currentState == 2) {
                    MusicOperationView.this.ajM();
                }
            } else if (view.equals(MusicOperationView.this.cKG)) {
                MusicOperationView.this.ajN();
            } else if (view.equals(MusicOperationView.this.cNc)) {
                MusicOperationView.this.m17687fF(true);
            } else if (view.equals(MusicOperationView.this.cNd)) {
                MusicOperationView.this.m17687fF(false);
            }
        }
    };
    protected ImageView cNc;
    protected ImageView cNd;

    public MusicOperationView(Activity activity) {
        super(activity, C6181b.class);
    }

    /* access modifiers changed from: private */
    public boolean alg() {
        if (this.bRj == null) {
            return false;
        }
        ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).remove(this.bRj).commitAllowingStateLoss();
        this.bRj.mo31826a((C7140b) null);
        this.bRj = null;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: fF */
    public void m17687fF(boolean z) {
        if (((C6181b) getEditor()).akY() != null) {
            VeRange aIc = ((C6181b) getEditor()).akY().aIc();
            if (aIc != null) {
                Range range = new Range(aIc.getmPosition(), aIc.getmTimeLength());
                if (range.getmTimeLength() <= 1000) {
                    ToastUtils.show(getContext(), R.string.editor_bgm_duration_short_for_fade, 0);
                    return;
                }
                if (((C6181b) getEditor()).mo29001a(z, !z ? !((C6181b) getEditor()).cNb : !((C6181b) getEditor()).cNa, range)) {
                    if (z) {
                        ((C6181b) getEditor()).cNa = true ^ ((C6181b) getEditor()).cNa;
                        this.cNc.setImageResource(((C6181b) getEditor()).cNa ? R.drawable.editor_selector_music_fade_in_on : R.drawable.editor_selector_music_fade_in_off);
                        C6182c.show(getContext(), ((C6181b) getEditor()).cNa ? R.string.xiaoying_str_eidtor_fx_volume_fade_in : R.string.xiaoying_str_eidtor_fx_volume_fade_in_close, 0);
                    } else {
                        ((C6181b) getEditor()).cNb = true ^ ((C6181b) getEditor()).cNb;
                        this.cNd.setImageResource(((C6181b) getEditor()).cNb ? R.drawable.editor_selector_music_fade_out_on : R.drawable.editor_selector_music_fade_out_off);
                        C6182c.show(getContext(), ((C6181b) getEditor()).cNb ? R.string.xiaoying_str_eidtor_fx_volume_fade_out : R.string.xiaoying_str_eidtor_fx_volume_fade_out_close, 0);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Wy */
    public final void mo28985Wy() {
        ((C6181b) getEditor()).adX();
        if (((C6181b) getEditor()).mo28998ne(((C6181b) getEditor()).adZ()) < 500) {
            ToastUtils.show(getContext().getApplicationContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
            return;
        }
        if (this.bRj == null) {
            this.bRj = (XYMusicFragment) C1919a.m5529sc().mo10355al(MusicParams.URL).mo10399f(MusicParams.EXTRA_CATEGORY_ID, this.cMQ).mo10412rX();
            this.bRj.mo31826a((C7140b) new C7140b() {
                /* renamed from: WC */
                public void mo25762WC() {
                    MusicOperationView.this.alg();
                }

                /* renamed from: c */
                public void mo25763c(MusicDataItem musicDataItem) {
                    if (musicDataItem != null && !TextUtils.isEmpty(musicDataItem.filePath) && new File(musicDataItem.filePath).exists()) {
                        MusicOperationView.this.mo28846d(musicDataItem);
                    }
                }

                /* renamed from: cZ */
                public void mo25764cZ(boolean z) {
                }
            });
            ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).add(R.id.fl_container, (Fragment) this.bRj).commitAllowingStateLoss();
        } else {
            ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).show(this.bRj).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: protected */
    public void ajM() {
        if (this.currentState == 2) {
            ((C6181b) getEditor()).adX();
            Range addingRange = this.cyJ.getAddingRange();
            if (addingRange == null || addingRange.getmTimeLength() < 500) {
                ajN();
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
                return;
            }
            int size = ((C6181b) getEditor()).aiz().size();
            if (size > 0 && ((C6181b) getEditor()).mo28993f(size - 1, addingRange)) {
                this.cyJ.mo28413c(new Range(addingRange));
            }
            ((C6181b) getEditor()).mo27870ep(true);
            int limitValue = addingRange.getLimitValue();
            if (((C6181b) getEditor()).mo28995nb(limitValue)) {
                limitValue--;
            }
            ((C6181b) getEditor()).mo27868b(0, ((C6181b) getEditor()).adO().getDuration(), false, limitValue);
            ((C6181b) getEditor()).mo27846H(limitValue, false);
            mo28850mL(limitValue);
            ald();
            this.cMO = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void ajN() {
        if (this.currentState == 2) {
            ((C6181b) getEditor()).adX();
            int size = ((C6181b) getEditor()).aiz().size();
            if (size > 0) {
                int i = size - 1;
                C8441b bVar = (C8441b) ((C6181b) getEditor()).aiz().get(i);
                if (C8540q.m24962m(((C6181b) getEditor()).adO(), i)) {
                    ((C6181b) getEditor()).aiz().remove(bVar);
                    ((C6181b) getEditor()).mo27870ep(true);
                    getVideoOperator().mo29676a(this.cMO, null, false);
                    ((C6181b) getEditor()).mo27868b(0, ((C6181b) getEditor()).adO().getDuration(), false, this.cMO);
                    mo28850mL(this.cMO);
                    this.cMO = 0;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void akj() {
        this.cKG = (ImageView) findViewById(R.id.iv_editor_audio_operation_cancel);
        this.cGX = (TextView) findViewById(R.id.tv_editor_audio_operation);
        this.cNc = (ImageView) findViewById(R.id.iv_editor_music_fade_in);
        this.cNd = (ImageView) findViewById(R.id.iv_editor_music_fade_out);
        if (!TextUtils.isEmpty(this.cMQ)) {
            postDelayed(new Runnable() {
                public void run() {
                    MusicOperationView.this.mo28985Wy();
                }
            }, 300);
        }
    }

    /* access modifiers changed from: protected */
    public void akk() {
        this.cLQ.setTitle(R.string.xiaoying_str_ve_multi_bgm_title);
    }

    /* access modifiers changed from: protected */
    public void akl() {
        super.akl();
        this.cGX.setOnClickListener(this.cKP);
        this.cKG.setOnClickListener(this.cKP);
        this.cNc.setOnClickListener(this.cKP);
        this.cNd.setOnClickListener(this.cKP);
    }

    /* access modifiers changed from: protected */
    public void akm() {
        C6183d.m17712eV(getContext());
    }

    /* access modifiers changed from: protected */
    public boolean akn() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean ako() {
        return alg();
    }

    /* access modifiers changed from: protected */
    public void akq() {
    }

    /* access modifiers changed from: protected */
    public void ald() {
        C10021c.aZH().mo38492aA(new C6554e());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo28846d(MusicDataItem musicDataItem) {
        if (C8540q.m24900I(((C6181b) getEditor()).adO())) {
            C8540q.m24902K(((C6181b) getEditor()).adO());
        }
        int adZ = ((C6181b) getEditor()).adZ();
        int ne = ((C6181b) getEditor()).mo28998ne(adZ);
        int srcLen = musicDataItem.getSrcLen();
        int i = musicDataItem.startTimeStamp;
        this.cMO = adZ;
        if (((C6181b) getEditor()).mo28989a(musicDataItem.filePath, adZ, ne, i, srcLen, 50) == null) {
            return false;
        }
        ((C6181b) getEditor()).mo27870ep(false);
        ((C6181b) getEditor()).mo27873h(adZ, ne, true);
        this.cyJ.mo28414cx(adZ, ne + adZ);
        mo28851ms(2);
        return true;
    }

    /* renamed from: fE */
    public void mo28986fE(boolean z) {
        if (z) {
            this.cNc.setVisibility(0);
            this.cNd.setVisibility(0);
            this.cNc.setImageResource(((C6181b) getEditor()).cNa ? R.drawable.editor_selector_music_fade_in_on : R.drawable.editor_selector_music_fade_in_off);
            this.cNd.setImageResource(((C6181b) getEditor()).cNb ? R.drawable.editor_selector_music_fade_out_on : R.drawable.editor_selector_music_fade_out_off);
            return;
        }
        this.cNc.setVisibility(8);
        this.cNd.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    /* renamed from: fs */
    public void mo28847fs(boolean z) {
        C6183d.m17710G(getContext().getApplicationContext(), z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ft */
    public void mo28848ft(boolean z) {
        C6183d.m17711H(getContext().getApplicationContext(), z);
    }

    /* access modifiers changed from: protected */
    public int getOperationViewLayout() {
        return R.layout.editor_effect_audio_music_option_layout;
    }

    /* access modifiers changed from: protected */
    /* renamed from: mL */
    public final void mo28850mL(int i) {
        if (((C6181b) getEditor()).mo28997nd(this.cyJ.mo28430mp(i))) {
            mo28851ms(1);
        } else {
            mo28851ms(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ms */
    public final void mo28851ms(int i) {
        if (this.currentState != i || ((C6181b) getEditor()).cML) {
            this.currentState = i;
            ((C6181b) getEditor()).cML = false;
            switch (this.currentState) {
                case 0:
                    this.cLR.setVisibility(8);
                    this.cKG.setVisibility(8);
                    this.cLQ.setBtnVisibility(true);
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    this.cGX.setVisibility(0);
                    mo28986fE(false);
                    this.cyJ.aiL();
                    break;
                case 1:
                    this.cLR.mo28980nh(((C6181b) getEditor()).currentVolume);
                    this.cLR.setVisibility(0);
                    this.cKG.setVisibility(8);
                    this.cLQ.setBtnVisibility(true);
                    this.cGX.setText(R.string.xiaoying_str_person_video_delete);
                    this.cGX.setVisibility(0);
                    mo28986fE(true);
                    this.cyJ.mo28429mo(((C6181b) getEditor()).cMM);
                    break;
                case 2:
                    ((C6181b) getEditor()).mo27870ep(false);
                    this.cLQ.setBtnVisibility(false);
                    this.cLR.setVisibility(8);
                    this.cKG.setVisibility(0);
                    this.cGX.setText(R.string.xiaoying_str_ve_trim_finish_btn_title);
                    this.cGX.setVisibility(0);
                    mo28986fE(false);
                    break;
            }
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        alg();
    }

    public void onActivityPause() {
        super.onActivityPause();
        if (this.currentState == 2) {
            ajM();
        }
        this.cyJ.setFineTuningEnable(true);
    }

    /* access modifiers changed from: protected */
    public void releaseAll() {
    }
}
