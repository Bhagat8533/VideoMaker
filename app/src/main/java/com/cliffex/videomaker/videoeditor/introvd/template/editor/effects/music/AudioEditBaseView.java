package com.introvd.template.editor.effects.music;

import android.app.Activity;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.effects.C5910b;
import com.introvd.template.editor.effects.VideoEditorSeekLayout;
import com.introvd.template.editor.effects.music.C6180a;
import com.introvd.template.editor.effects.music.EditorVolumeSetView.C6176a;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.widget.timeline.C7124b;
import com.introvd.template.explorer.music.p304b.C7263b;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.explorer.MusicDataItem;
import java.util.Iterator;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public abstract class AudioEditBaseView<T extends C6180a> extends BaseOperationView<T> {
    private C7124b cGq = new C7124b() {
        /* renamed from: a */
        public boolean mo28344a(int i, Range range) {
            AudioEditBaseView.this.m17656g(i, range);
            return false;
        }

        public void acD() {
            if (AudioEditBaseView.this.currentState == 1 || AudioEditBaseView.this.currentState == 0) {
                ((C6180a) AudioEditBaseView.this.getEditor()).mo27873h(0, ((C6180a) AudioEditBaseView.this.getEditor()).adO().getDuration(), false);
                ((C6180a) AudioEditBaseView.this.getEditor()).mo27870ep(true);
            }
        }

        public void acd() {
            ((C6180a) AudioEditBaseView.this.getEditor()).aeb();
        }

        /* renamed from: iD */
        public void mo28349iD(int i) {
            ((C6180a) AudioEditBaseView.this.getEditor()).mo27874kY(i);
            if (AudioEditBaseView.this.currentState == 1 || AudioEditBaseView.this.currentState == 0) {
                AudioEditBaseView.this.mo28850mL(i);
            }
        }

        /* renamed from: kz */
        public void mo28352kz(int i) {
            ((C6180a) AudioEditBaseView.this.getEditor()).adX();
            ((C6180a) AudioEditBaseView.this.getEditor()).aea();
            if (AudioEditBaseView.this.currentState == 1 || AudioEditBaseView.this.currentState == 0) {
                ((C6180a) AudioEditBaseView.this.getEditor()).mo27873h(0, ((C6180a) AudioEditBaseView.this.getEditor()).adO().getDuration(), false);
                ((C6180a) AudioEditBaseView.this.getEditor()).mo27870ep(true);
            }
            if (AudioEditBaseView.this.cyJ != null) {
                AudioEditBaseView.this.mo28848ft(AudioEditBaseView.this.cyJ.acx());
            }
        }
    };
    protected Terminator cLQ;
    protected EditorVolumeSetView cLR;
    protected RelativeLayout cMN;
    /* access modifiers changed from: protected */
    public int cMO = 0;
    protected boolean cMP = false;
    protected String cMQ = "";
    /* access modifiers changed from: protected */
    public volatile int currentState = -1;
    protected VideoEditorSeekLayout cyJ;

    public AudioEditBaseView(Activity activity, Class cls) {
        super(activity, cls);
    }

    /* renamed from: Nu */
    private void m17648Nu() {
        this.cLR.setVolumeSetListener(new C6176a() {
            /* renamed from: mu */
            public void mo28584mu(int i) {
                ((C6180a) AudioEditBaseView.this.getEditor()).aki();
                AudioEditBaseView.this.m17658ng(i);
            }
        });
        this.cyJ.mo28397a(getEditor(), ((C6180a) getEditor()).aiz());
        this.cyJ.setOnOperationCallback(getVideoOperator());
        this.cyJ.setmState(1);
        this.cyJ.setmOnTimeLineSeekListener(this.cGq);
        this.cyJ.setOnVideoEditorSeekListener(new C5910b() {
            public void aav() {
                if (AudioEditBaseView.this.cyJ != null && AudioEditBaseView.this.getVideoOperator() != null) {
                    ((C6180a) AudioEditBaseView.this.getEditor()).adY();
                }
            }

            public void pauseVideo() {
                ((C6180a) AudioEditBaseView.this.getEditor()).adX();
            }
        });
        akl();
    }

    private void ajb() {
        akk();
        this.cLQ.setTerminatorListener(new C5858a() {
            public void aeW() {
                if (!AudioEditBaseView.this.afX()) {
                    AudioEditBaseView.this.finish();
                }
                AudioEditBaseView.this.cyJ.setFineTuningEnable(true);
            }

            public void aeX() {
                AudioEditBaseView.this.alc();
                AudioEditBaseView.this.cyJ.setFineTuningEnable(true);
            }
        });
    }

    private void alb() {
        EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class);
        if (editorIntentInfo != null) {
            this.cMQ = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_CATEGORY_ID);
        }
    }

    /* access modifiers changed from: private */
    public boolean alc() {
        if (akn()) {
            return true;
        }
        if (this.currentState == 2) {
            ajM();
        } else {
            if (!(!((C6180a) getEditor()).aiw() || ((C6180a) getEditor()).adK() == null || ((C6180a) getEditor()).adK().aHe() == null)) {
                ((C6180a) getEditor()).adK().aHe().setBGMMode(true);
            }
            ald();
            ((C6180a) getEditor()).adX();
            finish();
        }
        return true;
    }

    private void ale() {
        Iterator it = ((C6180a) this.cyD).mo28465aK(((C6180a) this.cyD).aiz()).iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue() - i;
            if (intValue < 0 || !((C6180a) getEditor()).mo28999nf(intValue)) {
                LogUtils.m14222e("BGMEFFECT", "------delBGMEffect fail ~!!!!!");
            } else {
                this.cyJ.mo28426ml(intValue);
                ((C6180a) getEditor()).mo27870ep(true);
                i++;
            }
        }
        getVideoOperator().mo29676a(((C6180a) getEditor()).adZ(), null, false);
        mo28850mL(((C6180a) getEditor()).adZ());
        ((C6180a) getEditor()).mo28997nd(-1);
        this.cyJ.setCurrentFocusPos(-1);
        mo28851ms(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m17656g(int i, Range range) {
        ((C6180a) getEditor()).mo28993f(i, range);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m17657l(int i, int i2, boolean z) {
        if (i == 0 && !this.cMP && !z && this.currentState != 2) {
            this.cMP = true;
            akr();
            this.cyJ.aiL();
            ((C6180a) getEditor()).cMM = -1;
        } else if (i == 1 || i == 2) {
            if (this.cMP) {
                this.cMP = false;
                if (i == 2) {
                    ((C6180a) getEditor()).mo27870ep(true);
                    ((C6180a) getEditor()).mo27873h(0, ((C6180a) getEditor()).adO().getDuration(), false);
                }
            }
            if ((this.currentState == 1 || this.currentState == 0) && this.cyJ.getFocusState() == 0) {
                aks();
                if (!z) {
                    mo28850mL(i2);
                }
            }
            if (i == 2 && !this.cMP && this.currentState == 2) {
                akq();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ng */
    public void m17658ng(int i) {
        akm();
        ((C6180a) getEditor()).mo28996nc(i);
    }

    public final void aex() {
        super.aex();
        if (getEditor() == null) {
            finish();
            return;
        }
        alb();
        View findViewById = findViewById(R.id.rl_bottom_audio_op);
        LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = C5840b.cEx;
        layoutParams.width = -1;
        findViewById.setLayoutParams(layoutParams);
        this.cLR = (EditorVolumeSetView) findViewById(R.id.view_effect_volume_set);
        this.cyJ = (VideoEditorSeekLayout) findViewById(R.id.seek_layout_editor_audio);
        this.cMN = (RelativeLayout) findViewById(R.id.rl_editor_audio_op_container);
        this.cMN.addView(LayoutInflater.from(getContext()).inflate(getOperationViewLayout(), null));
        this.cLQ = (Terminator) findViewById(R.id.terminator);
        akj();
        ajb();
        m17648Nu();
        this.cyJ.mo28392J(((C6180a) getEditor()).adZ(), false);
        mo28850mL(((C6180a) getEditor()).adZ());
    }

    public final boolean aey() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean afX() {
        ((C6180a) getEditor()).adX();
        if (ako()) {
            return true;
        }
        if (this.currentState == 2) {
            ajN();
            return true;
        } else if (((C6180a) getEditor()).aiw()) {
            C8978m.m26348af(getActivity(), getActivity().getString(R.string.xiaoying_str_com_cancel), getActivity().getString(R.string.xiaoying_str_com_ok)).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    ((C6180a) AudioEditBaseView.this.getEditor()).restore();
                    AudioEditBaseView.this.finish();
                }
            }).mo10313qu().show();
            return true;
        } else {
            releaseAll();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void ajM();

    /* access modifiers changed from: protected */
    public abstract void ajN();

    /* access modifiers changed from: protected */
    public abstract void akj();

    /* access modifiers changed from: protected */
    public abstract void akk();

    /* access modifiers changed from: protected */
    public void akl() {
    }

    /* access modifiers changed from: protected */
    public abstract void akm();

    /* access modifiers changed from: protected */
    public abstract boolean akn();

    /* access modifiers changed from: protected */
    public abstract boolean ako();

    /* access modifiers changed from: protected */
    public abstract void akq();

    /* access modifiers changed from: protected */
    public void akr() {
        if (this.cMN != null) {
            this.cMN.setVisibility(4);
        }
        if (this.cLR != null) {
            this.cLR.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void aks() {
        if (this.cMN != null) {
            this.cMN.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void ald() {
    }

    /* access modifiers changed from: protected */
    public final void alf() {
        if (((C6180a) getEditor()).cMM < 0) {
            return;
        }
        if (((C6180a) getEditor()).ala()) {
            this.cyJ.mo28426ml(((C6180a) getEditor()).cMM);
            ((C6180a) getEditor()).mo27870ep(true);
            getVideoOperator().mo29676a(((C6180a) getEditor()).adZ(), null, false);
            mo28850mL(((C6180a) getEditor()).adZ());
            ((C6180a) getEditor()).mo28997nd(-1);
            this.cyJ.setCurrentFocusPos(-1);
            mo28851ms(0);
            return;
        }
        LogUtils.m14222e("BGMEFFECT", "------delBGMEffect fail ~!!!!!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract boolean mo28846d(MusicDataItem musicDataItem);

    /* access modifiers changed from: protected */
    /* renamed from: fs */
    public abstract void mo28847fs(boolean z);

    /* access modifiers changed from: protected */
    /* renamed from: ft */
    public abstract void mo28848ft(boolean z);

    public final C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                AudioEditBaseView.this.cyJ.mo28411b(aVar);
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                if (AudioEditBaseView.this.getEditor() == null || !aet()) {
                    return false;
                }
                ((C6180a) AudioEditBaseView.this.getEditor()).adX();
                return true;
            }

            public boolean aet() {
                return AudioEditBaseView.this.cyJ.ait();
            }

            public void aeu() {
                AudioEditBaseView.this.cyJ.aeu();
                AudioEditBaseView.this.cyJ.aiM();
            }

            public int aev() {
                return AudioEditBaseView.this.cyJ.aev();
            }

            public void aew() {
                AudioEditBaseView.this.cyJ.aew();
                if (AudioEditBaseView.this.currentState == 1 || AudioEditBaseView.this.currentState == 2) {
                    AudioEditBaseView.this.mo28847fs(AudioEditBaseView.this.cyJ.aiP());
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                return AudioEditBaseView.this.cyJ.mo28423hV(i);
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                AudioEditBaseView.this.cyJ.mo28425lb(i);
            }
        };
    }

    public final int getLayoutId() {
        return R.layout.editor_effect_audio_layout;
    }

    /* access modifiers changed from: protected */
    public abstract int getOperationViewLayout();

    public final C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                if (AudioEditBaseView.this.cyJ != null) {
                    AudioEditBaseView.this.cyJ.mo28392J(i, z);
                }
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                if (AudioEditBaseView.this.cyJ != null) {
                    AudioEditBaseView.this.cyJ.mo28393K(i, z);
                }
                AudioEditBaseView.this.m17657l(0, i, z);
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                if (AudioEditBaseView.this.cyJ != null) {
                    AudioEditBaseView.this.cyJ.mo28394L(i, z);
                }
                AudioEditBaseView.this.m17657l(1, i, z);
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                if (AudioEditBaseView.this.cyJ != null) {
                    AudioEditBaseView.this.cyJ.mo28395M(i, z);
                }
                AudioEditBaseView.this.m17657l(2, i, z);
            }

            public void aes() {
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: mL */
    public abstract void mo28850mL(int i);

    /* access modifiers changed from: protected */
    /* renamed from: ms */
    public abstract void mo28851ms(int i);

    public void onActivityCreate() {
        super.onActivityCreate();
        C10021c.aZH().mo38494ax(this);
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.cyJ != null) {
            this.cyJ.destroy();
        }
        C10021c.aZH().mo38496az(this);
    }

    public void onActivityPause() {
        super.onActivityPause();
        ((C6180a) getEditor()).mo27870ep(true);
        ((C6180a) getEditor()).setTouchDownPausable(true);
    }

    public final boolean onBackPressed() {
        this.cyJ.setFineTuningEnable(true);
        return afX();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7263b bVar) {
        if (bVar.axj() == 2) {
            LogUtilsV2.m14227d("Jamin MusicDBOperationEvent OPERATION_TYPE_DELETE");
            ale();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void releaseAll();
}
