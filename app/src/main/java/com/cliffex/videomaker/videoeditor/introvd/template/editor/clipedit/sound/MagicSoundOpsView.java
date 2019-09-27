package com.introvd.template.editor.clipedit.sound;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.clipedit.C5694a;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.player.p267a.C6488e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p133a.C2564c.C2569a;
import java.util.List;

@LDPProtect
@SuppressLint({"ViewConstructor"})
public class MagicSoundOpsView extends BaseOperationView<C5694a> {
    private List<Integer> cCf;
    /* access modifiers changed from: private */
    public View cCg = null;
    /* access modifiers changed from: private */
    public View cCh = null;
    /* access modifiers changed from: private */
    public SeekBar cCi;
    private C5770c cCj;
    /* access modifiers changed from: private */
    public C4576e cCk;
    private float cCl = 0.0f;
    /* access modifiers changed from: private */
    public float cCm = 0.0f;
    /* access modifiers changed from: private */
    public float cCn = 0.0f;

    public MagicSoundOpsView(Activity activity) {
        super(activity, C5694a.class);
    }

    private void aeR() {
        ((Terminator) findViewById(R.id.terminator)).setTerminatorListener(new C5858a() {
            public void aeW() {
                if (MagicSoundOpsView.this.afE()) {
                    MagicSoundOpsView.this.afH();
                    return;
                }
                if (!MagicSoundOpsView.this.aeV()) {
                    MagicSoundOpsView.this.exit();
                }
            }

            public void aeX() {
                if (MagicSoundOpsView.this.afE()) {
                    boolean ku = C8072q.aBx().mo33072ku(C7825a.MAGIC_SOUND.getId());
                    if (!C8049f.aBf().aBr() || ku) {
                        MagicSoundOpsView.this.cCm = MagicSoundOpsView.this.cCn;
                        MagicSoundOpsView.this.afH();
                    } else {
                        C8049f.aBf().mo33097b(MagicSoundOpsView.this.getContext(), null, C7825a.MAGIC_SOUND.getId(), "VoiceChanger", -1);
                    }
                } else {
                    if (MagicSoundOpsView.this.aeA()) {
                        MagicSoundOpsView.this.m16016aq(MagicSoundOpsView.this.cCm);
                    }
                    MagicSoundOpsView.this.exit();
                }
            }
        });
    }

    private void aeT() {
        final View findViewById = findViewById(R.id.apply_all_layout);
        this.cCh = findViewById(R.id.apply_all_btn);
        if (((C5694a) getEditor()).aeL()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C4580b.m11632Sf() && view == findViewById) {
                        C2564c.m7330dy(MagicSoundOpsView.this.cCh);
                        MagicSoundOpsView.this.cCh.setSelected(!MagicSoundOpsView.this.cCh.isSelected());
                    }
                }
            });
            return;
        }
        this.cCh.setSelected(false);
        findViewById.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public boolean afE() {
        return this.cCg != null && this.cCg.getVisibility() == 0;
    }

    private void afF() {
        if (this.cCg == null) {
            this.cCg = findViewById(R.id.include_self_magic_sound);
            this.cCi = (SeekBar) findViewById(R.id.sb_volume);
            this.cCi.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    MagicSoundOpsView.this.cCn = (float) (i - 16);
                }

                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    MagicSoundOpsView.this.m16015ap(MagicSoundOpsView.this.cCn);
                    C5769b.afC();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void afG() {
        if (this.cCg.getVisibility() != 0) {
            this.cCg.setVisibility(0);
            C2564c.m7322a(this.cCg, (float) C5840b.cEx, 0.0f, new C2569a() {
                public void onFinish() {
                    if (MagicSoundOpsView.this.cCi != null) {
                        MagicSoundOpsView.this.cCi.setProgress((int) (MagicSoundOpsView.this.cCm + 16.0f));
                    }
                    if (!C8072q.aBx().mo33072ku(C7825a.MAGIC_SOUND.getId()) && !C4577f.m11630i(MagicSoundOpsView.this.cCk)) {
                        MagicSoundOpsView.this.cCk = C4577f.m11623a(MagicSoundOpsView.this.getContext(), (View) MagicSoundOpsView.this, "VoiceChanger", -1);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void afH() {
        if (this.cCj != null) {
            this.cCj.mo28041a(C5767a.m16035ao(this.cCm));
            m16015ap(this.cCm);
            ((C5694a) getEditor()).adX();
        }
        C4577f.m11629e(this.cCk);
        ((C5694a) getEditor()).adX();
        C2564c.m7324b(this.cCg, 0.0f, (float) C5840b.cEx, new C2569a() {
            public void onFinish() {
                MagicSoundOpsView.this.cCg.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: ap */
    public void m16015ap(float f) {
        getVideoOperator().mo29686b(new C6488e(((C5694a) getEditor()).getFocusIndex(), f, ((C5694a) getEditor()).adZ()));
    }

    /* access modifiers changed from: private */
    /* renamed from: aq */
    public void m16016aq(float f) {
        ((C5694a) getEditor()).mo27884a(C6312c.CLIP_MAGIC_SOUND, this.cCh.isSelected(), false);
        if (this.cCh.isSelected()) {
            for (int i = 0; i < ((C5694a) getEditor()).adQ().getClipCount(); i++) {
                m16027h(i, f);
            }
        } else if (this.cCf != null) {
            for (Integer intValue : this.cCf) {
                m16027h(intValue.intValue(), f);
            }
        }
    }

    /* renamed from: ar */
    private void m16017ar(float f) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_magic_sound);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.cCj = new C5770c(getContext(), C5767a.m16035ao(f), C5767a.afA(), new C5772a() {
            /* renamed from: b */
            public void mo28037b(C5768a aVar) {
                if (aVar.cBP) {
                    C5769b.afB();
                    MagicSoundOpsView.this.afG();
                    return;
                }
                MagicSoundOpsView.this.cCm = aVar.cBR;
                MagicSoundOpsView.this.m16015ap(MagicSoundOpsView.this.cCm);
                C5769b.m16036gL(C5767a.getName((int) MagicSoundOpsView.this.cCm));
            }
        });
        recyclerView.setAdapter(this.cCj);
        recyclerView.mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                if (recyclerView.mo7746aN(view) == 0) {
                    rect.set(C4583d.m11673ii(17), 0, C4583d.m11673ii(7), 0);
                } else {
                    rect.set(C4583d.m11673ii(7), 0, C4583d.m11673ii(7), 0);
                }
            }
        });
    }

    /* renamed from: h */
    private void m16027h(int i, float f) {
        C8537n.m24799a(C8540q.m24956i(((C5694a) getEditor()).adO(), i), f);
    }

    private void initData() {
        this.cCl = m16033lq(((C5694a) getEditor()).getFocusIndex());
        this.cCm = this.cCl;
    }

    private void initUI() {
        aeR();
        aeT();
        m16017ar(this.cCl);
        afF();
    }

    /* renamed from: lq */
    private float m16033lq(int i) {
        return C8537n.m24840s(C8540q.m24956i(((C5694a) getEditor()).adO(), i));
    }

    public boolean aeA() {
        return this.cCm != this.cCl || this.cCh.isSelected();
    }

    public boolean aeV() {
        if (!aeA() || getActivity() == null || getActivity().isFinishing()) {
            return false;
        }
        C8978m.m26348af(getActivity(), getActivity().getString(R.string.xiaoying_str_com_cancel), getActivity().getString(R.string.xiaoying_str_com_ok)).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                MagicSoundOpsView.this.exit();
            }
        }).mo10313qu().show();
        return true;
    }

    public void aex() {
        super.aex();
        this.cCf = ((C5694a) getEditor()).aeK();
        if (this.cCf == null || this.cCf.size() == 0) {
            exit();
            return;
        }
        initData();
        initUI();
    }

    public int getLayoutId() {
        return R.layout.editor_clip_magic_sound_ops;
    }

    public int getStreamType() {
        return 2;
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        C4577f.m11629e(this.cCk);
    }

    public void onActivityResume() {
        super.onActivityResume();
        if (C8072q.aBx().mo33072ku(C7825a.MAGIC_SOUND.getId())) {
            C4577f.m11629e(this.cCk);
        }
    }

    public boolean onBackPressed() {
        ((C5694a) getEditor()).adX();
        boolean z = true;
        if (afE()) {
            afH();
            return true;
        }
        if (!aeV() && !super.onBackPressed()) {
            z = false;
        }
        return z;
    }
}
