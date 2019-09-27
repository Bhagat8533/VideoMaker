package com.introvd.template.editor.effects.collage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseVipOperationView;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.effects.C5910b;
import com.introvd.template.editor.effects.PlayerFakeView;
import com.introvd.template.editor.effects.PlayerFakeView.C5889a;
import com.introvd.template.editor.effects.PlayerFakeView.C5892d;
import com.introvd.template.editor.effects.VideoEditorSeekLayout;
import com.introvd.template.editor.effects.collage.title.CollageChooseTitleView;
import com.introvd.template.editor.effects.collage.title.CollageChooseTitleView.C6075a;
import com.introvd.template.editor.effects.nav.C6185b;
import com.introvd.template.editor.effects.nav.NavEffectTitleLayout;
import com.introvd.template.editor.effects.p253a.C5900b;
import com.introvd.template.editor.effects.p253a.C5909e;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.editor.widget.picker.EditorGalleryBoard;
import com.introvd.template.editor.widget.picker.EditorGalleryBoard.C7045d;
import com.introvd.template.editor.widget.picker.p294b.C7059a;
import com.introvd.template.editor.widget.scalerotate.p295a.C7065a;
import com.introvd.template.editor.widget.timeline.C7124b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.template.p408f.C8750d;
import com.p131c.p132a.C2561a;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.clip.QClip;

@SuppressLint({"ViewConstructor"})
public class CollageOpsView extends BaseVipOperationView<C6072a> {
    /* access modifiers changed from: private */
    public EditorGalleryBoard cAH;
    public int cGU = 2;
    public int cGV = 0;
    private NavEffectTitleLayout cGW;
    private TextView cGX;
    /* access modifiers changed from: private */
    public PlayerFakeView cGY;
    private C7124b cGq = new C7124b() {
        /* renamed from: a */
        public boolean mo28344a(int i, Range range) {
            StringBuilder sb = new StringBuilder();
            sb.append("onUpdateRange = index = ");
            sb.append(i);
            sb.append(", mVeRange = ");
            sb.append(range);
            LogUtilsV2.m14227d(sb.toString());
            CollageOpsView.this.m17238d(range);
            return false;
        }

        public void acD() {
            LogUtilsV2.m14227d("onStartMove = ");
            if (CollageOpsView.this.cGU == 3 && CollageOpsView.this.getVideoOperator() != null && CollageOpsView.this.getEditor() != null && ((C6072a) CollageOpsView.this.getEditor()).adO() != null) {
                LogUtils.m14222e("CollageSetRangeee", "onStartMove()");
                ((C6072a) CollageOpsView.this.getEditor()).mo27873h(0, ((C6072a) CollageOpsView.this.getEditor()).adO().getDuration(), false);
            }
        }

        public void acd() {
            LogUtilsV2.m14227d("onEndSeek = ");
            ((C6072a) CollageOpsView.this.getEditor()).aeb();
            if ((CollageOpsView.this.cGU == 1 || CollageOpsView.this.cGU == 3) && CollageOpsView.this.cyJ != null && !CollageOpsView.this.cyJ.aiO()) {
                CollageOpsView.this.ajr();
            }
        }

        /* renamed from: dY */
        public void mo28347dY(boolean z) {
            LogUtilsV2.m14227d("onStartDrag = ");
        }

        /* renamed from: iD */
        public void mo28349iD(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("progress = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            ((C6072a) CollageOpsView.this.getEditor()).mo27874kY(i);
            if (CollageOpsView.this.cHe != null) {
                CollageOpsView.this.cHe.mo28494cA(i, ((C6072a) CollageOpsView.this.getEditor()).getCurrentEditEffectIndex());
            }
        }

        /* renamed from: kz */
        public void mo28352kz(int i) {
            ((C6072a) CollageOpsView.this.getEditor()).adX();
            ((C6072a) CollageOpsView.this.getEditor()).aea();
            if (CollageOpsView.this.cyJ != null) {
                C6073b.m17301C(CollageOpsView.this.getContext(), CollageOpsView.this.cyJ.acx());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onStartSeek = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
        }
    };
    /* access modifiers changed from: private */
    public C5900b cHe;
    /* access modifiers changed from: private */
    public AtomicBoolean cIc = new AtomicBoolean(false);
    private ImageView cIe;
    private CollageChooseTitleView cJw;
    /* access modifiers changed from: private */
    public RelativeLayout cJx;
    private C1494a compositeDisposable = new C1494a();
    private Terminator czM;

    public CollageOpsView(Activity activity) {
        super(activity, C6072a.class);
    }

    /* access modifiers changed from: private */
    public void aan() {
        if (getEditor() != null && getCurrentEditEffectIndex() >= 0 && this.cyJ != null && this.cGY != null) {
            if (this.cHe != null) {
                this.cHe.mo28498mn(getCurrentEditEffectIndex());
            }
            ((C6072a) getEditor()).mo28807mr(getCurrentEditEffectIndex());
            ((C6072a) getEditor()).mo27873h(0, ((C6072a) getEditor()).adO().getDuration(), false);
            this.cyJ.mo28426ml(getCurrentEditEffectIndex());
            this.cyJ.aiL();
            this.cGY.adl();
            ((C6072a) getEditor()).mo28806mq(-1);
            m17251ms(1);
        }
    }

    private void aiV() {
        if (C5837a.agH().agN() && !C2561a.aON()) {
            C5900b bVar = new C5900b(getActivity(), this.cyJ, this.cGY, (C5896a) getEditor(), new C5909e() {
                public int ajt() {
                    return ((C6072a) CollageOpsView.this.getEditor()).getCurrentEditEffectIndex();
                }

                public void aju() {
                }

                /* renamed from: fh */
                public void mo28513fh(boolean z) {
                    CollageOpsView.this.mo27844et(z);
                }
            });
            this.cHe = bVar;
            ImageView eS = this.cHe.mo28496eS(getContext());
            ImageView eT = this.cHe.mo28497eT(getContext());
            if (eS != null && (this.cGX.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.cGX.getParent()).addView(eS);
                ((ViewGroup) this.cGX.getParent()).addView(eT);
            }
        }
    }

    private void aiW() {
        this.cyJ = (VideoEditorSeekLayout) findViewById(R.id.ve_collage_seek_layout);
        this.cyJ.setOnOperationCallback(getVideoOperator());
        this.cyJ.setmOnTimeLineSeekListener(this.cGq);
        this.cyJ.setOnVideoEditorSeekListener(new C5910b() {
            public void aav() {
                CollageOpsView.this.aiZ();
            }

            public void pauseVideo() {
                CollageOpsView.this.aiY();
            }
        });
    }

    private void aiX() {
        this.cyJ.mo28397a(getEditor(), ((C6072a) getEditor()).aiz());
        this.cyJ.mo28392J(((C6072a) getEditor()).adZ(), false);
        this.cyJ.setMaskDrawable(getResources().getDrawable(R.color.color_00BFDC_p25));
        this.cyJ.setTrimMaskDrawable(getResources().getDrawable(R.color.color_00BFDC_p50));
    }

    /* access modifiers changed from: private */
    public void aiY() {
        ((C6072a) getEditor()).adX();
        if (this.cGU != 4) {
            ajr();
        }
    }

    /* access modifiers changed from: private */
    public void aiZ() {
        if (getEditor() != null) {
            if (this.cGU == 3) {
                ((C6072a) getEditor()).mo28796a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
                ajl();
            }
            ((C6072a) getEditor()).adY();
        }
    }

    private void ajI() {
        if (this.cIc.get()) {
            this.cGY.mo28360d(ajO().aIg());
            this.cIc.set(false);
        }
        this.cGY.getScaleRotateView().mo31012hM(true);
        this.cGY.getScaleRotateView().mo31006eh(true);
        m17251ms(this.cGV);
    }

    /* access modifiers changed from: private */
    public void ajJ() {
        switch (this.cGU) {
            case 4:
                ajN();
                return;
            default:
                return;
        }
    }

    private C8441b ajK() {
        C8441b bVar;
        if (this.cIc.get()) {
            bVar = ajO();
            this.cIc.set(false);
        } else {
            bVar = null;
        }
        C8441b f = ((C6072a) getEditor()).mo28803f(bVar != null ? bVar.aIg() : this.cGY.getScaleRotateView().getScaleViewState());
        if (f == null) {
            return null;
        }
        if (this.cyJ != null) {
            this.cyJ.mo28414cx(f.aIc().getmPosition(), f.aIc().getmPosition() + f.aIc().getmTimeLength());
        }
        return f;
    }

    private boolean ajL() {
        if (this.cIc.get()) {
            ajO();
            this.cIc.set(false);
        }
        int i = this.cGV;
        if (i == 0 || i == 2) {
            finish();
            return true;
        }
        this.cGY.getScaleRotateView().mo31012hM(true);
        this.cGY.getScaleRotateView().mo31006eh(true);
        m17251ms(this.cGV);
        return true;
    }

    /* access modifiers changed from: private */
    public void ajM() {
        if (this.cyJ != null) {
            ((C6072a) getEditor()).adX();
            ((C6072a) getEditor()).mo27870ep(true);
            Range addingRange = this.cyJ.getAddingRange();
            if (addingRange != null) {
                Range range = new Range(addingRange.getmPosition(), addingRange.getmTimeLength());
                ((C6072a) getEditor()).mo28795a(((C6072a) getEditor()).aiA(), range, this.cyJ.getmEffectKeyFrameRangeList());
                ((C6072a) getEditor()).mo27873h(0, ((C6072a) getEditor()).adO().getDuration(), false);
                this.cyJ.mo28413c(range);
                this.cyJ.aiL();
                m17251ms(1);
            }
        }
    }

    private void ajN() {
        if (getEditor() != null && this.cyJ != null) {
            ((C6072a) getEditor()).adX();
            ((C6072a) getEditor()).mo27870ep(true);
            Range addingRange = this.cyJ.getAddingRange();
            ((C6072a) getEditor()).mo27868b(0, ((C6072a) getEditor()).adO().getDuration(), false, addingRange == null ? 0 : addingRange.getmPosition());
            int aiA = ((C6072a) getEditor()).aiA();
            if (this.cHe != null) {
                this.cHe.mo28498mn(aiA);
            }
            ((C6072a) getEditor()).mo28807mr(aiA);
            this.cyJ.aiL();
            m17251ms(1);
        }
    }

    /* access modifiers changed from: private */
    public C8441b ajO() {
        int aiA = ((C6072a) getEditor()).aiA();
        C8441b mg = ((C6072a) getEditor()).mo28483mg(aiA);
        if (this.cHe != null) {
            this.cHe.mo28498mn(aiA);
        }
        ((C6072a) getEditor()).mo28807mr(aiA);
        LogUtils.m14222e("CollageSetRangeee", "stopPreview()");
        ((C6072a) getEditor()).mo27868b(0, ((C6072a) getEditor()).adO().getDuration(), false, ((C6072a) getEditor()).aiR());
        return mg;
    }

    private void ajT() {
        this.cJx = (RelativeLayout) findViewById(R.id.ve_collage_op_view);
        this.cGX = (TextView) findViewById(R.id.ve_collage_op_btn);
        this.cGX.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (CollageOpsView.this.cHe != null) {
                    CollageOpsView.this.cHe.akS();
                }
                CollageOpsView.this.aji();
            }
        });
        this.cIe = (ImageView) findViewById(R.id.ve_collage_op_left_btn);
        this.cIe.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CollageOpsView.this.ajJ();
            }
        });
    }

    private void ajU() {
        this.cGY = (PlayerFakeView) findViewById(R.id.ve_collage_transparent_fake_view);
        this.cGY.mo28354a(((C6072a) getEditor()).adN(), ((C6072a) getEditor()).getSurfaceSize(), true, 20);
        this.cGY.setEnableFlip(true);
        this.cGY.setOnDelListener(new C5889a() {
            public void aan() {
                if (CollageOpsView.this.cGU == 2) {
                    CollageOpsView.this.cGY.adl();
                    ((C6072a) CollageOpsView.this.getEditor()).aiS();
                    return;
                }
                CollageOpsView.this.aan();
            }
        });
        this.cGY.setScaleRotateViewDecoder(new C7065a());
        this.cGY.setOnReplaceListener(new C5892d() {
            public void aiI() {
                CollageOpsView.this.m17251ms(5);
            }

            public void aiK() {
            }
        });
    }

    private void ajV() {
        this.cAH = (EditorGalleryBoard) findViewById(R.id.editor_effect_board);
        this.cAH.setBoardVisibility(8);
        this.cAH.mo30947a(C7045d.MODE_PIC, false);
        if (((C6072a) this.cyD).adK() != null) {
            this.cAH.setCompressedFilePath(((C6072a) this.cyD).adK().aJH());
        }
        this.cJx.post(new Runnable() {
            public void run() {
                CollageOpsView.this.cAH.setNormalHeight(CollageOpsView.this.cJx.getMeasuredHeight());
            }
        });
        this.cAH.setGalleryBoardListener(new C7059a() {
            public void afn() {
            }

            public void afo() {
                C6073b.m17304eI(CollageOpsView.this.getContext());
            }

            public void afp() {
                C6073b.m17305eJ(CollageOpsView.this.getContext());
            }

            /* renamed from: eA */
            public void mo27985eA(boolean z) {
            }

            /* renamed from: gI */
            public void mo27986gI(String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("path = ");
                sb.append(str);
                LogUtilsV2.m14227d(sb.toString());
                CollageOpsView.this.mo28783hc(str);
            }
        });
    }

    private void ajb() {
        this.czM = (Terminator) findViewById(R.id.terminator);
        this.cJw = new CollageChooseTitleView(getContext());
        this.cJw.setOnChooseModeChangeListener(new C6075a() {
            /* renamed from: js */
            public void mo28792js(int i) {
                switch (i) {
                    case 0:
                        if (CollageOpsView.this.cAH != null) {
                            CollageOpsView.this.cAH.mo30946a(C7045d.MODE_PIC);
                            return;
                        }
                        return;
                    case 1:
                        if (CollageOpsView.this.cAH != null) {
                            CollageOpsView.this.cAH.mo30946a(C7045d.MODE_VIDEO);
                            return;
                        }
                        return;
                    case 2:
                        if (CollageOpsView.this.cAH != null) {
                            CollageOpsView.this.cAH.mo30946a(C7045d.MODE_GIF);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        this.czM.setTitleContentLayout(this.cJw);
        this.czM.setTerminatorListener(new C5858a() {
            public void aeW() {
                CollageOpsView.this.ajf();
            }

            public void aeX() {
                CollageOpsView.this.ajc();
            }
        });
    }

    /* access modifiers changed from: private */
    public void ajc() {
        if (!C4580b.m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR)) {
            switch (this.cGU) {
                case 1:
                    if (!aeG()) {
                        finish();
                        break;
                    } else {
                        return;
                    }
                case 2:
                    C8441b ajK = ajK();
                    if (ajK == null) {
                        finish();
                        break;
                    } else {
                        m17251ms(4);
                        C6073b.m17303a(getContext(), ajK);
                        break;
                    }
                case 3:
                    if (!aeG()) {
                        ((C6072a) getEditor()).mo28796a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
                        finish();
                        break;
                    } else {
                        return;
                    }
                case 4:
                    ajM();
                    break;
                case 5:
                    aje();
                    break;
            }
        }
    }

    private void aje() {
        C8441b bVar;
        if (this.cIc.get()) {
            bVar = ajO();
            this.cIc.set(false);
        } else {
            bVar = null;
        }
        ((C6072a) getEditor()).mo28796a(getCurrentEditEffectIndex(), bVar != null ? bVar.aIg() : this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
        ajl();
    }

    /* access modifiers changed from: private */
    public void ajf() {
        if (!C4580b.m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR) && getEditor() != null) {
            switch (this.cGU) {
                case 1:
                    if (((C6072a) getEditor()).aiw()) {
                        ajp();
                        break;
                    } else {
                        finish();
                        break;
                    }
                case 2:
                    ajL();
                    break;
                case 3:
                    ((C6072a) getEditor()).mo28796a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
                    ajl();
                    if (!((C6072a) getEditor()).aiw()) {
                        finish();
                        break;
                    } else {
                        ajp();
                        break;
                    }
                case 4:
                    ajN();
                    break;
                case 5:
                    ajI();
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    public void aji() {
        switch (this.cGU) {
            case 1:
                ((C6072a) getEditor()).adX();
                if (((C6072a) getEditor()).adO().getDuration() - ((C6072a) getEditor()).adZ() > 500) {
                    m17251ms(2);
                    break;
                } else {
                    ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
                    return;
                }
            case 3:
                ((C6072a) getEditor()).adX();
                ajk();
                if (((C6072a) getEditor()).adO().getDuration() - ((C6072a) getEditor()).adZ() > 500) {
                    m17251ms(2);
                    break;
                } else {
                    ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
                    return;
                }
            case 4:
                ajM();
                break;
        }
    }

    private void ajl() {
        ((C6072a) getEditor()).mo28806mq(-1);
        if (this.cyJ != null) {
            this.cyJ.aiL();
        }
        this.cGY.mo28355aL(((C6072a) getEditor()).mo28478fe(true));
        this.cGY.adl();
        getEffectHListView().mo29002nk(-1);
        m17251ms(1);
    }

    private void ajp() {
        C8978m.m26348af(getContext(), getContext().getString(R.string.xiaoying_str_com_cancel), getContext().getString(R.string.xiaoying_str_com_ok)).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                CollageOpsView.this.ajq();
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    public void ajr() {
        List mf = ((C6072a) getEditor()).mo28482mf(((C6072a) getEditor()).adZ());
        StringBuilder sb = new StringBuilder();
        sb.append("list = ");
        sb.append(mf.size());
        LogUtilsV2.m14227d(sb.toString());
        if (mf.size() > 0) {
            int intValue = ((Integer) mf.get(0)).intValue();
            if (this.cGU != 3 || this.cyJ == null || this.cyJ.getEditRange() == null || !this.cyJ.getEditRange().contains2(((C6072a) getEditor()).adZ())) {
                ajk();
                m17252mt(((Integer) mf.get(0)).intValue());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("edit same effect index = ");
                sb2.append(intValue);
                LogUtilsV2.m14227d(sb2.toString());
            }
        } else if (this.cGU == 1) {
            LogUtilsV2.m14227d("current mode is normal ");
        } else {
            ScaleRotateViewState scaleRotateViewState = null;
            if (!(this.cGY == null || this.cGY.getScaleRotateView() == null)) {
                scaleRotateViewState = this.cGY.getScaleRotateView().getScaleViewState();
            }
            ((C6072a) getEditor()).mo28796a(getCurrentEditEffectIndex(), scaleRotateViewState, this.cyJ.getmEffectKeyFrameRangeList());
            ajl();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m17238d(Range range) {
        if (this.cyJ != null) {
            int i = this.cyJ.getmEditBGMRangeIndex();
            if (!(range == null || getEditor() == null || !((C6072a) getEditor()).mo28795a(i, range, this.cyJ.getmEffectKeyFrameRangeList()))) {
                this.cyJ.mo28412c(i, range);
            }
        }
    }

    private int getCurrentEditEffectIndex() {
        if (getEditor() != null) {
            return ((C6072a) getEditor()).getCurrentEditEffectIndex();
        }
        return -1;
    }

    private NavEffectTitleLayout getEffectHListView() {
        if (this.cGW == null) {
            this.cGW = new NavEffectTitleLayout(getContext());
        }
        return this.cGW;
    }

    /* renamed from: mI */
    private void m17249mI(int i) {
        QClip dataClip = ((C6072a) getEditor()).adO().getDataClip();
        boolean z = dataClip != null && dataClip.getEffectCountByGroup(2, 20) > 0 && !C5837a.agH().agK();
        if (i < 0) {
            if (z) {
                this.cGU = 1;
                m17251ms(1);
                this.compositeDisposable.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
                    public void run() {
                        CollageOpsView.this.ajr();
                    }
                }, 300, TimeUnit.MILLISECONDS));
                return;
            }
            m17251ms(2);
        }
    }

    /* renamed from: mJ */
    private boolean m17250mJ(int i) {
        return i == 1 || i == 3 || i == 4;
    }

    /* access modifiers changed from: private */
    /* renamed from: ms */
    public void m17251ms(int i) {
        if (this.cGY != null && this.cAH != null && !aeC()) {
            if (this.cyJ != null) {
                this.cyJ.setFineTuningEnable(m17250mJ(i));
            }
            this.cGV = this.cGU;
            this.cGU = i;
            switch (this.cGU) {
                case 1:
                    ajh();
                    this.cGY.adl();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    this.cIe.setVisibility(8);
                    if (this.cAH != null) {
                        this.cAH.setBoardVisibility(8);
                    }
                    this.czM.setBtnVisibility(true);
                    break;
                case 2:
                    this.czM.setTitleContentLayout(this.cJw);
                    if (this.cAH != null) {
                        this.cAH.setBoardVisibility(0);
                    }
                    this.cGY.aiG();
                    this.cGY.getScaleRotateView().mo31012hM(false);
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    this.cIe.setVisibility(8);
                    ((C6072a) getEditor()).aiS();
                    break;
                case 3:
                    ajh();
                    this.cGY.aiG();
                    this.cGY.getScaleRotateView().mo31012hM(true);
                    this.cGY.getScaleRotateView().mo31006eh(true);
                    this.cIe.setVisibility(8);
                    if (this.cAH != null) {
                        this.cAH.setBoardVisibility(8);
                    }
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    break;
                case 4:
                    this.cGY.aiG();
                    this.cGY.adl();
                    this.czM.setBtnVisibility(false);
                    this.czM.setTitle(R.string.xiaoying_str_com_home_edit_pip);
                    this.cIe.setVisibility(0);
                    if (this.cAH != null) {
                        this.cAH.setBoardVisibility(8);
                    }
                    this.cGX.setText(R.string.xiaoying_str_ve_trim_finish_btn_title);
                    break;
                case 5:
                    this.czM.setTitleContentLayout(this.cJw);
                    if (this.cAH != null) {
                        this.cAH.setBoardVisibility(0);
                    }
                    this.cGY.aiG();
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGY.getScaleRotateView().mo31012hM(false);
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    this.cIe.setVisibility(8);
                    ((C6072a) getEditor()).aiS();
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mt */
    public void m17252mt(int i) {
        ((C6072a) getEditor()).mo28806mq(i);
        C8441b mg = ((C6072a) getEditor()).mo28483mg(i);
        if (mg != null && this.cGY != null) {
            this.cGY.mo28360d(mg.aIg());
            if (this.cGY.getScaleRotateView() != null) {
                this.cGY.getScaleRotateView().mo31012hM(true);
                this.cGY.getScaleRotateView().mo31006eh(true);
            }
            if (this.cyJ != null) {
                this.cyJ.mo28429mo(i);
                if (this.cHe != null) {
                    this.cHe.mo28494cA(((C6072a) getEditor()).adZ(), ((C6072a) getEditor()).getCurrentEditEffectIndex());
                }
            }
            m17251ms(3);
            getEffectHListView().mo29002nk(i);
            C6485b bVar = new C6485b(5, i, 20);
            if (getVideoOperator() != null) {
                getVideoOperator().mo29678a(bVar);
            }
        }
    }

    public void aex() {
        super.aex();
        if (getEditor() == null) {
            finish();
            return;
        }
        C10021c.aZH().mo38494ax(this);
        ajT();
        ajU();
        ajb();
        aiW();
        aiV();
        aiX();
        ajV();
        m17249mI(getBundle().getInt("ve_extra_effect_id", -1));
    }

    public boolean aey() {
        return true;
    }

    public void aez() {
        this.cGX.post(new Runnable() {
            public void run() {
                int i = CollageOpsView.this.getBundle().getInt("ve_extra_effect_id", -1);
                if (i >= 0) {
                    CollageOpsView.this.m17252mt(i);
                }
            }
        });
    }

    public void ajh() {
        if (this.czM != null) {
            if (this.cGW == null) {
                this.cGW = new NavEffectTitleLayout(getContext());
            }
            this.cGW.setData(((C6072a) getEditor()).aiz(), hashCode());
            this.czM.setTitleContentLayout(this.cGW);
        }
    }

    public void ajk() {
        int currentEditEffectIndex = getCurrentEditEffectIndex();
        if (currentEditEffectIndex >= 0 && this.cGY.getScaleRotateView() != null) {
            ((C6072a) getEditor()).mo28796a(currentEditEffectIndex, this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
        }
        ajl();
    }

    public void ajq() {
        C4586g.m11693B(getActivity());
        ((C6072a) getEditor()).aiy().mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                C4586g.m11695Sl();
                CollageOpsView.this.finish();
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void finish() {
        super.finish();
        if (this.cyD != null) {
            ((C6072a) this.cyD).aix();
        }
        if (this.cIc.get()) {
            this.cIc.set(false);
            ajO();
        }
        if (this.cGY != null) {
            this.cGY.adl();
            this.cGY.aiG();
        }
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }

    public C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                if (CollageOpsView.this.cyJ != null) {
                    CollageOpsView.this.cyJ.mo28411b(aVar);
                }
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                if (CollageOpsView.this.getEditor() == null) {
                    return false;
                }
                int i = CollageOpsView.this.cGU;
                if (i != 2) {
                    switch (i) {
                        case 4:
                            ((C6072a) CollageOpsView.this.getEditor()).adX();
                            return false;
                        case 5:
                            break;
                        default:
                            int b = ((C6072a) CollageOpsView.this.getEditor()).mo28799b(point);
                            CollageOpsView.this.ajk();
                            if (b >= ((C6072a) CollageOpsView.this.getEditor()).aiz().size() || b < 0 || CollageOpsView.this.cGY == null) {
                                return false;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("Find Sticker when Single Tap index = ");
                            sb.append(b);
                            LogUtilsV2.m14227d(sb.toString());
                            CollageOpsView.this.m17252mt(b);
                            return true;
                    }
                }
                if (CollageOpsView.this.cIc.get()) {
                    C8441b w = CollageOpsView.this.ajO();
                    if (w != null) {
                        CollageOpsView.this.cGY.mo28360d(w.aIg());
                    }
                    CollageOpsView.this.cIc.set(false);
                }
                return false;
            }

            public boolean aet() {
                return CollageOpsView.this.cyJ != null && CollageOpsView.this.cyJ.ait();
            }

            public void aeu() {
                if (CollageOpsView.this.cyJ != null) {
                    CollageOpsView.this.cyJ.aeu();
                }
            }

            public int aev() {
                if (CollageOpsView.this.cyJ == null) {
                    return 0;
                }
                return CollageOpsView.this.cyJ.aev();
            }

            public void aew() {
                if (CollageOpsView.this.cyJ != null) {
                    CollageOpsView.this.cyJ.aew();
                    if (1 == CollageOpsView.this.cGU) {
                        CollageOpsView.this.ajr();
                    } else if (3 == CollageOpsView.this.cGU) {
                        if (CollageOpsView.this.cyJ.getFocusState() == 0) {
                            CollageOpsView.this.ajr();
                        } else {
                            int i = CollageOpsView.this.cyJ.getmEditBGMRangeIndex();
                            if (i >= 0) {
                                ((C6072a) CollageOpsView.this.getEditor()).mo28795a(i, CollageOpsView.this.cyJ.getEditRange(), CollageOpsView.this.cyJ.getmEffectKeyFrameRangeList());
                                C6073b.m17302D(CollageOpsView.this.getContext(), CollageOpsView.this.cyJ.aiP());
                            }
                        }
                    }
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                if (CollageOpsView.this.cyJ == null) {
                    return 0;
                }
                return CollageOpsView.this.cyJ.mo28423hV(i);
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                if (CollageOpsView.this.cyJ != null) {
                    CollageOpsView.this.cyJ.mo28425lb(i);
                    if (CollageOpsView.this.cHe != null) {
                        CollageOpsView.this.cHe.mo28494cA(i, ((C6072a) CollageOpsView.this.getEditor()).getCurrentEditEffectIndex());
                    }
                }
            }
        };
    }

    public int getLayoutId() {
        return R.layout.editor_effect_collage_ops;
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                if (CollageOpsView.this.cyJ != null) {
                    CollageOpsView.this.cyJ.mo28392J(i, z);
                }
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPlaying = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (CollageOpsView.this.cyJ != null) {
                    CollageOpsView.this.cyJ.mo28393K(i, z);
                }
                if (CollageOpsView.this.cGY != null) {
                    CollageOpsView.this.cGY.aiG();
                }
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPause = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (CollageOpsView.this.cyJ != null) {
                    CollageOpsView.this.cyJ.mo28394L(i, z);
                }
                if (CollageOpsView.this.cGY != null && CollageOpsView.this.cGU == 1 && CollageOpsView.this.getEditor() != null && !CollageOpsView.this.aeC()) {
                    CollageOpsView.this.cGY.mo28355aL(((C6072a) CollageOpsView.this.getEditor()).mo28478fe(true));
                }
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerStop = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (CollageOpsView.this.cyJ != null) {
                    CollageOpsView.this.cyJ.mo28395M(i, z);
                }
                if (CollageOpsView.this.cIc.get()) {
                    CollageOpsView.this.cIc.set(false);
                    CollageOpsView.this.cGY.mo28360d(CollageOpsView.this.ajO().aIg());
                    CollageOpsView.this.cGY.getScaleRotateView().mo31006eh(false);
                    CollageOpsView.this.cGY.getScaleRotateView().mo31012hM(false);
                    return;
                }
                if (CollageOpsView.this.cGU == 4) {
                    CollageOpsView.this.ajM();
                }
            }

            public void aes() {
            }
        };
    }

    /* renamed from: hc */
    public void mo28783hc(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            ToastUtils.show(getContext(), "File is not exist", 0);
        } else if (this.cGY != null) {
            ((C6072a) getEditor()).mo28462a(getCurrentEditEffectIndex(), ((C6072a) getEditor()).mo28804gZ(str));
            if (this.cGU == 5) {
                if (C8750d.m25573jM(str)) {
                    mo28785k(str, true);
                } else {
                    this.cGY.mo28360d(((C6072a) getEditor()).mo28801c(str, this.cGY.getScaleRotateView().getScaleViewState()));
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGY.getScaleRotateView().mo31012hM(false);
                }
                return;
            }
            if (C8750d.m25573jM(str)) {
                mo28785k(str, false);
            } else {
                mo28784hj(str);
            }
        }
    }

    /* renamed from: hj */
    public void mo28784hj(String str) {
        if (!TextUtils.isEmpty(str) && this.cGY != null && this.cGY.getScaleRotateView() != null) {
            if (this.cIc.get()) {
                ajO();
                this.cIc.set(false);
            }
            this.cGY.mo28360d(((C6072a) getEditor()).mo28802d(str, this.cGY.getScaleRotateView().getScaleViewState()));
            this.cGY.getScaleRotateView().mo31006eh(false);
        }
    }

    /* renamed from: k */
    public void mo28785k(String str, boolean z) {
        if (this.cGY.getScaleRotateView() != null) {
            C8441b bVar = null;
            if (this.cIc.get()) {
                bVar = ajO();
                this.cIc.set(false);
            }
            if (((C6072a) getEditor()).mo28800b(str, bVar != null ? bVar.aIg() : this.cGY.getScaleRotateView().getScaleViewState(), z) != null) {
                this.cGY.adl();
                this.cIc.set(true);
            }
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        C10021c.aZH().mo38496az(this);
        if (this.cGY != null) {
            this.cGY.destroy();
        }
        if (this.cHe != null) {
            this.cHe.akS();
            this.cHe.destroy();
            this.cHe = null;
        }
        if (this.cyJ != null) {
            this.cyJ.destroy();
        }
        if (this.cAH != null) {
            this.cAH.auF();
        }
    }

    public void onActivityResume() {
        super.onActivityResume();
        aeD();
    }

    public boolean onBackPressed() {
        switch (this.cGU) {
            case 1:
                if (!((C6072a) getEditor()).aiw()) {
                    finish();
                    return true;
                }
                ajp();
                return true;
            case 2:
                return ajL();
            case 3:
                ((C6072a) getEditor()).mo28796a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
                ajl();
                if (((C6072a) getEditor()).aiw()) {
                    ajp();
                }
                return true;
            case 4:
                ajN();
                return true;
            case 5:
                ajI();
                return true;
            default:
                finish();
                return true;
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6185b bVar) {
        int i = bVar.cNh;
        StringBuilder sb = new StringBuilder();
        sb.append("onEventMainThread event.clickPosition = ");
        sb.append(i);
        LogUtilsV2.m14227d(sb.toString());
        ajk();
        ajl();
        m17252mt(i);
        C8441b mg = ((C6072a) getEditor()).mo28483mg(i);
        if (mg != null) {
            int i2 = mg.aIc().getmPosition();
            if (this.cyJ != null) {
                this.cyJ.mo28394L(i2, false);
            }
            ((C6072a) getEditor()).mo27846H(i2, false);
        }
    }
}
