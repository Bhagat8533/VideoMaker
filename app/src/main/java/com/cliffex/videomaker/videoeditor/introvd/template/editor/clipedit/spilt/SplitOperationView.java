package com.introvd.template.editor.clipedit.spilt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Point;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.crash.C5526d;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.clipedit.trim.C5822a;
import com.introvd.template.editor.clipedit.trim.C5822a.C5829c;
import com.introvd.template.editor.clipedit.trim.C5832c;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.preview.p271b.C6550a;
import com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.utils.p394b.C8540q;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

@SuppressLint({"ViewConstructor"})
public class SplitOperationView extends BaseOperationView<C5792a> {
    /* access modifiers changed from: private */
    public C5822a cCF;
    private C8440a cCG;
    /* access modifiers changed from: private */
    public boolean cCH = false;
    private C5829c cCI = new C5829c() {
        public void afS() {
            LogUtilsV2.m14227d("onSeekStart");
            ((C5792a) SplitOperationView.this.getEditor()).aea();
        }

        /* renamed from: lr */
        public void mo28063lr(int i) {
            SplitOperationView.this.isModified = true;
            StringBuilder sb = new StringBuilder();
            sb.append("onSeekPosChange destTime = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            ((C5792a) SplitOperationView.this.getEditor()).mo27874kY(i - SplitOperationView.this.offset);
        }

        /* renamed from: ls */
        public void mo28064ls(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onSeekEnd destTime = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            ((C5792a) SplitOperationView.this.getEditor()).aeb();
            if (SplitOperationView.this.cCH) {
                ((C5792a) SplitOperationView.this.getEditor()).adY();
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean isModified = false;
    /* access modifiers changed from: private */
    public int offset = 0;
    private int startPos = 0;

    public SplitOperationView(Activity activity) {
        super(activity, C5792a.class);
    }

    /* access modifiers changed from: private */
    public boolean aeV() {
        if (!aeA() || getActivity() == null) {
            return false;
        }
        String string = getActivity().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getActivity(), getContext().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                SplitOperationView.this.exit();
            }
        }).mo10313qu().show();
        return true;
    }

    /* access modifiers changed from: private */
    public void afQ() {
        if (this.cCF == null) {
            exit();
            return;
        }
        int agB = this.cCF.agp().agB();
        int agC = this.cCF.agp().agC();
        if (((C5792a) getEditor()).mo28065A(agB, agC, this.cCF.getCurrentTime())) {
            ((C5792a) this.cyD).mo27884a(C6312c.CLIP_SPLIT, false, true);
            m16093cq(agB, agC);
        } else {
            ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_basic_split_notavail_tip, 0);
        }
    }

    private void afR() {
        this.cCF = new C5822a((RelativeLayout) findViewById(R.id.layout_trim_relate), C8540q.m24956i(((C5792a) getEditor()).adO(), ((C5792a) getEditor()).getFocusIndex()), this.cCG, ((C5792a) getEditor()).getFocusIndex());
        this.cCF.mo28124a(this.cCI);
        this.cCF.mo28136eI(true);
        this.startPos = this.cCG.aHV() / 2;
        this.offset = 0;
        this.cCF.mo28146lG(this.startPos + this.offset);
        this.cCF.mo28143lD(this.startPos + this.offset);
    }

    /* renamed from: cq */
    private void m16093cq(final int i, final int i2) {
        C4586g.m11703a(getContext(), R.string.xiaoying_str_com_loading, (OnCancelListener) null);
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                boolean B = ((C5792a) SplitOperationView.this.getEditor()).mo28066B(i, i2, SplitOperationView.this.cCF.getCurrentTime());
                if (B) {
                    C6293a.anj().ann();
                    ((C5792a) SplitOperationView.this.getEditor()).adL().mo34669jt(true);
                    C10021c.aZH().mo38492aA(new C6550a(2));
                } else {
                    C6293a.anj().anm();
                }
                if (!B) {
                    throw new C5526d("Split Failed");
                }
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                C4586g.m11695Sl();
                SplitOperationView.this.exit();
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                C4586g.m11695Sl();
                SplitOperationView.this.exit();
            }
        });
    }

    public boolean aeA() {
        return this.isModified;
    }

    public void aex() {
        super.aex();
        if (((C5792a) getEditor()).aeK().size() == 0) {
            exit();
            return;
        }
        this.cCG = ((C5792a) getEditor()).mo27893lf(((C5792a) getEditor()).getFocusIndex());
        if (this.cCG == null || this.cCG.aHR() <= 0) {
            exit();
            return;
        }
        ((C5792a) getEditor()).setClipIndex(((C5792a) getEditor()).getFocusIndex());
        Terminator terminator = (Terminator) findViewById(R.id.terminator);
        terminator.setTitle(R.string.xiaoying_str_ve_split_clip_title);
        terminator.setTerminatorListener(new C5858a() {
            public void aeW() {
                if (!SplitOperationView.this.aeV()) {
                    SplitOperationView.this.exit();
                }
            }

            public void aeX() {
                SplitOperationView.this.afQ();
                C5793b.m16118ex(SplitOperationView.this.getContext());
            }
        });
        afR();
    }

    public C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                return false;
            }

            public boolean aet() {
                LogUtilsV2.m14227d("isFineTuningAble");
                return true;
            }

            public void aeu() {
                LogUtilsV2.m14227d("onFineTuningDown");
                ((C5792a) SplitOperationView.this.getEditor()).adX();
            }

            public int aev() {
                LogUtilsV2.m14227d("onFineTuningStart");
                if (SplitOperationView.this.cCF == null) {
                    return 0;
                }
                return SplitOperationView.this.cCF.getCurrentTime() - SplitOperationView.this.offset;
            }

            public void aew() {
                LogUtilsV2.m14227d("onFineTuningUp");
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("onValidateTime curTime = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (SplitOperationView.this.cCF == null || i < 0) {
                    return 0;
                }
                int agq = (SplitOperationView.this.cCF.agq() - 1) - VeAdvanceTrimGallery.dxa;
                if (i > agq) {
                    i = agq;
                }
                C5832c agp = SplitOperationView.this.cCF.agp();
                if (agp != null) {
                    int agB = agp.agB() - SplitOperationView.this.offset;
                    int agC = agp.agC() - SplitOperationView.this.offset;
                    if (i < agB) {
                        return agB;
                    }
                    if (i > agC) {
                        return agC;
                    }
                }
                return i;
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                SplitOperationView.this.isModified = true;
                StringBuilder sb = new StringBuilder();
                sb.append("onFineTuningChange position = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (SplitOperationView.this.cCF != null) {
                    SplitOperationView.this.cCF.mo28146lG(i + SplitOperationView.this.offset);
                }
            }
        };
    }

    public int getLayoutId() {
        return R.layout.editor_clip_split_ops;
    }

    public int getPlayerInitTime() {
        StringBuilder sb = new StringBuilder();
        sb.append("getPlayerInitTime startPos = ");
        sb.append(this.startPos);
        LogUtilsV2.m14227d(sb.toString());
        return this.startPos;
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerReady progress = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPlaying progress = ");
                sb.append(i);
                sb.append(",isUserSeeking = ");
                sb.append(z);
                LogUtilsV2.m14227d(sb.toString());
                if (SplitOperationView.this.cCF != null && !z) {
                    SplitOperationView.this.cCF.mo28146lG(i + SplitOperationView.this.offset);
                    SplitOperationView.this.cCH = true;
                }
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPause progress = ");
                sb.append(i);
                sb.append(",isUserSeeking = ");
                sb.append(z);
                LogUtilsV2.m14227d(sb.toString());
                if (SplitOperationView.this.cCF != null && !z) {
                    SplitOperationView.this.cCF.mo28146lG(i + SplitOperationView.this.offset);
                    SplitOperationView.this.cCH = false;
                }
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerStop progress = ");
                sb.append(i);
                sb.append(",isUserSeeking = ");
                sb.append(z);
                LogUtilsV2.m14227d(sb.toString());
                if (SplitOperationView.this.cCF != null && !z) {
                    SplitOperationView.this.cCF.mo28146lG(i + SplitOperationView.this.offset);
                    SplitOperationView.this.cCH = false;
                }
            }

            public void aes() {
            }
        };
    }

    public int getStreamType() {
        return 2;
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.cCF != null) {
            this.cCF.destroy();
            this.cCF = null;
        }
    }

    public boolean onBackPressed() {
        ((C5792a) getEditor()).adX();
        return aeV() || super.onBackPressed();
    }
}
