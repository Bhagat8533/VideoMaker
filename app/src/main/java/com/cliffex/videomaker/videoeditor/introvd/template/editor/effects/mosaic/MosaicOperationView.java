package com.introvd.template.editor.effects.mosaic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.effects.C5910b;
import com.introvd.template.editor.effects.PlayerFakeView;
import com.introvd.template.editor.effects.PlayerFakeView.C5889a;
import com.introvd.template.editor.effects.PlayerFakeView.C5890b;
import com.introvd.template.editor.effects.PlayerFakeView.C5892d;
import com.introvd.template.editor.effects.VideoEditorSeekLayout;
import com.introvd.template.editor.effects.nav.C6185b;
import com.introvd.template.editor.effects.nav.NavEffectTitleLayout;
import com.introvd.template.editor.effects.p253a.C5900b;
import com.introvd.template.editor.effects.p253a.C5909e;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.editor.widget.timeline.C7124b;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.utils.C8562q;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2561a;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.clip.QEffect;

@LDPProtect
@SuppressLint({"ViewConstructor"})
public class MosaicOperationView extends BaseOperationView<C6167b> {
    public int cGU = 2;
    public int cGV = 0;
    private NavEffectTitleLayout cGW;
    /* access modifiers changed from: private */
    public TextView cGX;
    /* access modifiers changed from: private */
    public PlayerFakeView cGY;
    private C7124b cGq = new C7124b() {
        /* renamed from: a */
        public boolean mo28344a(int i, Range range) {
            StringBuilder sb = new StringBuilder();
            sb.append("onUpdateRange = index = ");
            sb.append(i);
            sb.append(", range = ");
            sb.append(range);
            LogUtilsV2.m14227d(sb.toString());
            MosaicOperationView.this.m17584d(range);
            return false;
        }

        public void acd() {
            LogUtilsV2.m14227d("onEndSeek = ");
            ((C6167b) MosaicOperationView.this.getEditor()).aeb();
            if ((MosaicOperationView.this.cGU == 1 || MosaicOperationView.this.cGU == 3) && !MosaicOperationView.this.cyJ.aiO()) {
                MosaicOperationView.this.ajr();
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
            ((C6167b) MosaicOperationView.this.getEditor()).mo27874kY(i);
            if (MosaicOperationView.this.cHe != null) {
                MosaicOperationView.this.cHe.mo28494cA(i, ((C6167b) MosaicOperationView.this.getEditor()).getCurrentEditEffectIndex());
            }
        }

        /* renamed from: kz */
        public void mo28352kz(int i) {
            ((C6167b) MosaicOperationView.this.getEditor()).adX();
            ((C6167b) MosaicOperationView.this.getEditor()).aea();
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
    private View cIz;
    public final int cKc = IapRTConstants.REQUEST_CODE_FOR_VIP;
    private ImageView cMA;
    private TextView cMB;
    private TextView cMC;
    /* access modifiers changed from: private */
    public String cMD;
    /* access modifiers changed from: private */
    public String cME;
    /* access modifiers changed from: private */
    public String cMF;
    /* access modifiers changed from: private */
    public HashMap<Integer, Integer> cMG = new HashMap<>();
    /* access modifiers changed from: private */
    public int cMH = 0;
    private OnSeekBarChangeListener cMI = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                MosaicOperationView.this.mo28956mX(i);
                MosaicOperationView.this.getVideoOperator().mo29678a(new C6485b(6, MosaicOperationView.this.getCurrentEditEffectIndex(), 40));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            MosaicOperationView.this.cMG.put(Integer.valueOf(MosaicOperationView.this.cMH), Integer.valueOf(seekBar.getProgress()));
            C6166a.m17635bo(MosaicOperationView.this.getContext(), MosaicOperationView.this.cMH == 0 ? "高斯模糊" : "像素化");
        }
    };
    private C5890b cMJ = new C5890b() {
        public void aiH() {
            if (MosaicOperationView.this.getEditor() != null && MosaicOperationView.this.cGY.getScaleRotateView() != null) {
                ((C6167b) MosaicOperationView.this.getEditor()).mo28967a(MosaicOperationView.this.getCurrentEditEffectIndex(), MosaicOperationView.this.cGY.getScaleRotateView().getScaleViewState(), MosaicOperationView.this.cyJ.getmEffectKeyFrameRangeList());
                MosaicOperationView.this.mo28956mX(MosaicOperationView.this.cMw.getProgress());
                MosaicOperationView.this.getVideoOperator().mo29686b(new C6485b());
            }
        }

        /* renamed from: b */
        public void mo28388b(RectF rectF, float f, int i) {
            Rect a = C8562q.m25042a(rectF, ((C6167b) MosaicOperationView.this.getEditor()).getSurfaceSize().width, ((C6167b) MosaicOperationView.this.getEditor()).getSurfaceSize().height);
            if (a != null) {
                MosaicOperationView.this.m17603na(i);
                ((C6167b) MosaicOperationView.this.getEditor()).mo28965a(MosaicOperationView.this.getCurrentEditEffectIndex(), a, ((C6167b) MosaicOperationView.this.getEditor()).adZ(), f, false);
                MosaicOperationView.this.mo28956mX(MosaicOperationView.this.cMw.getProgress());
                MosaicOperationView.this.getVideoOperator().mo29686b(new C6485b());
            }
        }
    };
    /* access modifiers changed from: private */
    public SeekBar cMw;
    /* access modifiers changed from: private */
    public View cMx;
    /* access modifiers changed from: private */
    public View cMy;
    private ImageView cMz;
    private C1494a compositeDisposable = new C1494a();
    /* access modifiers changed from: private */
    public VideoEditorSeekLayout cyJ;
    private C4576e czL;
    private Terminator czM;

    /* renamed from: po */
    private OnClickListener f3499po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(MosaicOperationView.this.cMx)) {
                if (((C6167b) MosaicOperationView.this.getEditor()).akV() != null) {
                    MosaicOperationView.this.m17598mY(0);
                } else {
                    MosaicOperationView.this.m17599mZ(0);
                }
                MosaicOperationView.this.m17589fC(true);
            } else if (view.equals(MosaicOperationView.this.cMy)) {
                if (((C6167b) MosaicOperationView.this.getEditor()).akV() != null) {
                    MosaicOperationView.this.m17598mY(1);
                } else {
                    MosaicOperationView.this.m17599mZ(1);
                }
                MosaicOperationView.this.m17589fC(false);
            } else if (view.equals(MosaicOperationView.this.cGX)) {
                if (MosaicOperationView.this.cHe != null) {
                    MosaicOperationView.this.cHe.akS();
                }
                MosaicOperationView.this.aji();
            }
        }
    };

    public MosaicOperationView(Activity activity) {
        super(activity, C6167b.class);
    }

    /* renamed from: Oj */
    private void m17574Oj() {
        this.cMx = findViewById(R.id.gaussian_blur_layout);
        this.cMz = (ImageView) findViewById(R.id.gaussian_image);
        this.cMB = (TextView) findViewById(R.id.gaussian_text);
        this.cMy = findViewById(R.id.pixel_layout);
        this.cMA = (ImageView) findViewById(R.id.pixel_image);
        this.cMC = (TextView) findViewById(R.id.pixel_text);
        this.cIz = findViewById(R.id.mosaic_first_panel);
        this.cMx.setOnClickListener(this.f3499po);
        this.cMy.setOnClickListener(this.f3499po);
        this.cMw = (SeekBar) findViewById(R.id.mosaic_degree);
        this.cMw.setOnSeekBarChangeListener(this.cMI);
        this.cGY = (PlayerFakeView) findViewById(R.id.ve_mosaic_transparent_fake_view);
        this.cGY.mo28354a(((C6167b) getEditor()).adN(), ((C6167b) getEditor()).getSurfaceSize(), true, ((C6167b) getEditor()).getGroupId());
        this.cGY.setEnableFlip(false);
        this.cGY.aiE();
        this.cGY.setOnMoveListener(this.cMJ);
        this.cGY.setOnDelListener(new C5889a() {
            public void aan() {
                if (MosaicOperationView.this.cGU == 2) {
                    MosaicOperationView.this.cGY.adl();
                } else {
                    MosaicOperationView.this.ajG();
                }
            }
        });
        this.cGY.setOnReplaceListener(new C5892d() {
            public void aiI() {
                MosaicOperationView.this.m17600ms(5);
                int currentEditEffectIndex = MosaicOperationView.this.getCurrentEditEffectIndex();
                if (MosaicOperationView.this.getEditor() != null) {
                    C8441b mg = ((C6167b) MosaicOperationView.this.getEditor()).mo28483mg(currentEditEffectIndex);
                    if (mg != null) {
                        String aIf = mg.aIf();
                        if (MosaicOperationView.this.cMD.equals(aIf)) {
                            MosaicOperationView.this.m17589fC(true);
                        } else if (MosaicOperationView.this.cME.equals(aIf)) {
                            MosaicOperationView.this.m17589fC(false);
                        }
                    }
                }
            }

            public void aiK() {
            }
        });
        this.cGX = (TextView) findViewById(R.id.tv_mosaic_op_btn);
        this.cGX.setOnClickListener(this.f3499po);
        this.cMD = C8762d.aMt().mo35225bB(360287970192785410L);
        this.cME = C8762d.aMt().mo35225bB(360287970192785409L);
        ajb();
        aiW();
    }

    private void aiW() {
        this.cyJ = (VideoEditorSeekLayout) findViewById(R.id.ve_mosaic_seek_layout);
        this.cyJ.setOnOperationCallback(getVideoOperator());
        this.cyJ.setmOnTimeLineSeekListener(this.cGq);
        this.cyJ.setOnVideoEditorSeekListener(new C5910b() {
            public void aav() {
                MosaicOperationView.this.aiZ();
            }

            public void pauseVideo() {
                MosaicOperationView.this.aiY();
            }
        });
    }

    private void aiX() {
        this.cyJ.mo28397a(getEditor(), ((C6167b) getEditor()).aiz());
        this.cyJ.mo28392J(((C6167b) getEditor()).adZ(), false);
        this.cyJ.setTrimMaskDrawable(getResources().getDrawable(R.color.color_809500ff));
        this.cyJ.setMaskDrawable(getResources().getDrawable(R.color.color_4c9500ff));
    }

    /* access modifiers changed from: private */
    public void aiY() {
        ((C6167b) getEditor()).adX();
        if (this.cGU != 4) {
            ajr();
        }
    }

    /* access modifiers changed from: private */
    public void aiZ() {
        if (getEditor() != null) {
            if (this.cGU == 3) {
                ((C6167b) getEditor()).mo28967a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
                ajl();
            }
            ((C6167b) getEditor()).adY();
        }
    }

    private void ajA() {
        C4562a.m11534b(this.cIz, false, true, 0);
    }

    /* access modifiers changed from: private */
    public void ajG() {
        if (getEditor() != null && getCurrentEditEffectIndex() >= 0 && this.cyJ != null && this.cGY != null && this.cGY.getScaleRotateView() != null && this.cGY.getScaleRotateView().getScaleViewState() != null) {
            if (this.cHe != null) {
                this.cHe.mo28498mn(getCurrentEditEffectIndex());
            }
            ((C6167b) getEditor()).mo28974mr(getCurrentEditEffectIndex());
            ((C6167b) getEditor()).mo27873h(0, ((C6167b) getEditor()).adO().getDuration(), false);
            this.cyJ.mo28426ml(getCurrentEditEffectIndex());
            this.cyJ.aiL();
            this.cGY.adl();
            ((C6167b) getEditor()).mo28973mq(-1);
            m17600ms(1);
        }
    }

    private void ajI() {
        this.cGY.getScaleRotateView().mo31012hM(true);
        this.cGY.getScaleRotateView().mo31006eh(true);
        m17600ms(this.cGV);
    }

    private C8441b ajK() {
        C8441b m = ((C6167b) getEditor()).mo28972m(this.cGY.getScaleRotateView().getScaleViewState());
        if (m == null) {
            return null;
        }
        getVideoOperator().mo29686b(new C6485b());
        return m;
    }

    private boolean ajL() {
        ajG();
        int i = this.cGV;
        if (i == 0 || i == 2) {
            finish();
            return true;
        }
        this.cGY.getScaleRotateView().mo31012hM(true);
        this.cGY.getScaleRotateView().mo31006eh(true);
        m17600ms(this.cGV);
        return true;
    }

    /* access modifiers changed from: private */
    public void ajM() {
        if (getVideoOperator() != null && this.cyJ != null && getEditor() != null) {
            ((C6167b) getEditor()).adX();
            ((C6167b) getEditor()).mo27870ep(true);
            Range addingRange = this.cyJ.getAddingRange();
            if (addingRange != null) {
                Range range = new Range(addingRange.getmPosition(), addingRange.getmTimeLength());
                ((C6167b) getEditor()).mo28966a(((C6167b) getEditor()).aiA(), range, this.cyJ.getmEffectKeyFrameRangeList());
                this.cyJ.mo28413c(range);
            }
            this.cyJ.aiL();
            m17600ms(1);
            ((C6167b) getEditor()).mo28973mq(-1);
        }
    }

    private void ajN() {
        if (getEditor() != null && this.cyJ != null) {
            ((C6167b) getEditor()).adX();
            ((C6167b) getEditor()).mo27870ep(true);
            Range addingRange = this.cyJ.getAddingRange();
            ((C6167b) getEditor()).mo27868b(0, ((C6167b) getEditor()).adO().getDuration(), false, addingRange == null ? 0 : addingRange.getmPosition());
            int aiA = ((C6167b) getEditor()).aiA();
            if (this.cHe != null) {
                this.cHe.mo28498mn(aiA);
            }
            ((C6167b) getEditor()).mo28974mr(aiA);
            this.cyJ.aiL();
            m17600ms(1);
        }
    }

    private void ajb() {
        this.czM = (Terminator) findViewById(R.id.terminator);
        this.czM.setTitle(R.string.xiaoying_str_ve_mosaic_title);
        this.czM.setTerminatorListener(new C5858a() {
            public void aeW() {
                MosaicOperationView.this.ajf();
            }

            public void aeX() {
                MosaicOperationView.this.ajc();
            }
        });
    }

    /* access modifiers changed from: private */
    public void ajc() {
        if (!C4580b.m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR)) {
            if (!C8049f.aBf().aBr() || C8072q.aBx().mo33072ku(C7825a.MOSAIC.getId())) {
                switch (this.cGU) {
                    case 1:
                        finish();
                        break;
                    case 2:
                        if (((C6167b) getEditor()).akV() != null) {
                            if (!(getVideoOperator() == null || ((C6167b) getEditor()).akV() == null || ((C6167b) getEditor()).akV().aIc() == null)) {
                                ((C6167b) getEditor()).mo27870ep(false);
                                ((C6167b) getEditor()).mo27868b(((C6167b) getEditor()).akV().aIc().getmPosition(), ((C6167b) getEditor()).akV().aIc().getmTimeLength(), true, ((C6167b) getEditor()).akV().aIc().getmPosition());
                                this.cyJ.mo28414cx(((C6167b) getEditor()).akV().aIc().getmPosition(), ((C6167b) getEditor()).akV().aIc().getmPosition() + ((C6167b) getEditor()).akV().aIc().getmTimeLength());
                            }
                            m17600ms(4);
                            break;
                        } else {
                            finish();
                            return;
                        }
                    case 3:
                        finish();
                        break;
                    case 4:
                        ajM();
                        break;
                    case 5:
                        ajl();
                        break;
                }
                return;
            }
            C8049f.aBf().mo33097b(getContext(), C8070o.aBw(), C7825a.MOSAIC.getId(), "Mosaic", IapRTConstants.REQUEST_CODE_FOR_VIP);
        }
    }

    /* access modifiers changed from: private */
    public void ajf() {
        if (!C4580b.m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR) && getEditor() != null) {
            switch (this.cGU) {
                case 1:
                    if (((C6167b) getEditor()).aiw()) {
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
                    ((C6167b) getEditor()).mo28967a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
                    ajl();
                    if (!((C6167b) getEditor()).aiw()) {
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

    private void ajh() {
        if (this.czM != null) {
            if (this.cGW == null) {
                this.cGW = new NavEffectTitleLayout(getContext());
            }
            this.cGW.setData(((C6167b) getEditor()).aiz(), hashCode());
            this.czM.setTitleContentLayout(this.cGW);
        }
    }

    /* access modifiers changed from: private */
    public void aji() {
        switch (this.cGU) {
            case 1:
                ((C6167b) getEditor()).adX();
                if (((C6167b) getEditor()).adO().getDuration() - ((C6167b) getEditor()).adZ() > 500) {
                    m17600ms(2);
                    ((C6167b) getEditor()).mo28973mq(-1);
                    this.cMx.performClick();
                    break;
                } else {
                    ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
                    return;
                }
            case 3:
                ((C6167b) getEditor()).adX();
                ajk();
                m17600ms(2);
                ((C6167b) getEditor()).mo28973mq(-1);
                this.cMx.performClick();
                break;
            case 4:
                ajM();
                break;
        }
    }

    /* access modifiers changed from: private */
    public void ajk() {
        int currentEditEffectIndex = getCurrentEditEffectIndex();
        if (!(getEditor() == null || currentEditEffectIndex < 0 || this.cGY == null || this.cGY.getScaleRotateView() == null)) {
            ((C6167b) getEditor()).mo28967a(currentEditEffectIndex, this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
        }
        ajl();
    }

    private void ajl() {
        if (getEditor() != null) {
            ((C6167b) getEditor()).mo28973mq(-1);
            this.cyJ.aiL();
            this.cGY.mo28355aL(((C6167b) getEditor()).mo28478fe(true));
            this.cGY.adl();
            getEffectHListView().mo29002nk(-1);
            m17600ms(1);
        }
    }

    private void ajp() {
        String string = getContext().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getContext(), getContext().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                MosaicOperationView.this.ajq();
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    public void ajr() {
        List mf = ((C6167b) getEditor()).mo28482mf(((C6167b) getEditor()).adZ());
        StringBuilder sb = new StringBuilder();
        sb.append("list = ");
        sb.append(mf.size());
        LogUtilsV2.m14227d(sb.toString());
        if (mf.size() > 0) {
            int intValue = ((Integer) mf.get(0)).intValue();
            if (this.cGU != 3 || this.cyJ.getEditRange() == null || !this.cyJ.getEditRange().contains2(((C6167b) getEditor()).adZ())) {
                m17601mt(((Integer) mf.get(0)).intValue());
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
            ((C6167b) getEditor()).mo28967a(getCurrentEditEffectIndex(), scaleRotateViewState, this.cyJ.getmEffectKeyFrameRangeList());
            ajl();
        }
    }

    private void akW() {
        if (C5837a.agH().agN() && !C2561a.aON()) {
            C5900b bVar = new C5900b(getActivity(), this.cyJ, this.cGY, (C5896a) getEditor(), new C5909e() {
                public int ajt() {
                    return ((C6167b) MosaicOperationView.this.getEditor()).getCurrentEditEffectIndex();
                }

                public void aju() {
                    MosaicOperationView.this.getVideoOperator().mo29686b(new C6485b());
                }

                /* renamed from: fh */
                public void mo28513fh(boolean z) {
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

    /* access modifiers changed from: private */
    public void akX() {
        QEffect b = C8537n.m24816b(((C6167b) getEditor()).adO().getDataClip(), ((C6167b) getEditor()).getGroupId(), ((C6167b) getEditor()).getCurrentEditEffectIndex());
        if (b != null) {
            if (this.cMH == 0) {
                this.cMw.setProgress((int) ((((float) b.getEffectPropData(1).mValue) / 120.0f) * ((float) this.cMw.getMax())));
            } else if (((C6167b) getEditor()).getStreamSize() != null) {
                if (((C6167b) getEditor()).getStreamSize().width > ((C6167b) getEditor()).getStreamSize().height) {
                    this.cMw.setProgress((int) (((float) this.cMw.getMax()) - (((float) (((double) (b.getEffectPropData(1).mValue - 10)) / ((((double) ((float) ((C6167b) getEditor()).getStreamSize().width)) * 0.25d) - 10.0d))) * ((float) this.cMw.getMax()))));
                } else {
                    this.cMw.setProgress((int) (((float) this.cMw.getMax()) - (((float) (((double) (b.getEffectPropData(2).mValue - 10)) / ((((double) ((float) ((C6167b) getEditor()).getStreamSize().height)) * 0.25d) - 10.0d))) * ((float) this.cMw.getMax()))));
                }
            } else {
                return;
            }
            this.cMG.put(Integer.valueOf(this.cMH), Integer.valueOf(this.cMw.getProgress()));
        }
    }

    private void akd() {
        if (!C8072q.aBx().mo33072ku(C7825a.MOSAIC.getId()) && !C4577f.m11630i(this.czL)) {
            this.czL = C4577f.m11623a(getContext(), (View) this, "Mosaic", (int) IapRTConstants.REQUEST_CODE_FOR_VIP);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m17584d(Range range) {
        int i = this.cyJ.getmEditBGMRangeIndex();
        if (!(range == null || getEditor() == null || !((C6167b) getEditor()).mo28966a(i, range, this.cyJ.getmEffectKeyFrameRangeList()))) {
            this.cyJ.mo28412c(i, range);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fC */
    public void m17589fC(boolean z) {
        this.cMx.setSelected(z);
        this.cMz.setImageResource(z ? R.drawable.editor_btn_effect_mosaic_gaussian : R.drawable.editor_btn_effect_mosaic_gaussian_unfocus);
        this.cMB.setTextColor(z ? getResources().getColor(R.color.white) : getResources().getColor(R.color.color_8E8E93));
        this.cMy.setSelected(!z);
        this.cMA.setImageResource(!z ? R.drawable.editor_btn_effect_mosaic_pixel : R.drawable.editor_btn_effect_mosaic_pixel_unfocus);
        this.cMC.setTextColor(!z ? getResources().getColor(R.color.white) : getResources().getColor(R.color.color_8E8E93));
    }

    /* renamed from: fj */
    private void m17590fj(boolean z) {
        C4562a.m11534b(this.cIz, true, z, 0);
    }

    private NavEffectTitleLayout getEffectHListView() {
        if (this.cGW == null) {
            this.cGW = new NavEffectTitleLayout(getContext());
        }
        return this.cGW;
    }

    /* access modifiers changed from: private */
    /* renamed from: mY */
    public void m17598mY(int i) {
        if (this.cMH != i) {
            this.cMH = i;
            C6166a.m17634bn(getContext(), i == 0 ? "高斯模糊" : "像素化");
            ScaleRotateViewState c = ((C6167b) getEditor()).mo28970c(i == 0 ? this.cMD : this.cME, this.cGY.getScaleRotateView().getScaleViewState(), true);
            this.cGY.mo28360d(c);
            this.cGY.getScaleRotateView().mo31006eh(false);
            this.cGY.getScaleRotateView().mo31012hM(false);
            ((C6167b) getEditor()).mo28967a(((C6167b) getEditor()).getCurrentEditEffectIndex(), c, this.cyJ.getmEffectKeyFrameRangeList());
            if (this.cMG.get(Integer.valueOf(this.cMH)) != null) {
                mo28956mX(((Integer) this.cMG.get(Integer.valueOf(this.cMH))).intValue());
            } else {
                mo28956mX(50);
            }
            getVideoOperator().mo29678a(new C6485b(6, getCurrentEditEffectIndex(), 40));
            akX();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mZ */
    public void m17599mZ(int i) {
        this.cMH = i;
        C6166a.m17634bn(getContext(), i == 0 ? "高斯模糊" : "像素化");
        this.cGY.mo28360d(((C6167b) getEditor()).mo28970c(i == 0 ? this.cMD : this.cME, this.cGY.getScaleRotateView().getScaleViewState(), false));
        this.cGY.getScaleRotateView().mo31006eh(false);
        this.cGY.getScaleRotateView().mo31012hM(false);
        ajK();
        mo28956mX(50);
        getVideoOperator().mo29678a(new C6485b(6, getCurrentEditEffectIndex(), 40));
        akX();
    }

    /* access modifiers changed from: private */
    /* renamed from: ms */
    public void m17600ms(int i) {
        if (this.cGY != null && this.czM != null && this.cGX != null) {
            boolean z = this.cGV == 0;
            this.cGV = this.cGU;
            this.cGU = i;
            switch (this.cGU) {
                case 1:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(true);
                    }
                    ajh();
                    this.cGY.adl();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    this.czM.setBtnVisibility(true);
                    ajA();
                    break;
                case 2:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(false);
                    }
                    if (z) {
                        m17590fj(false);
                    } else {
                        m17590fj(true);
                    }
                    this.czM.setTitle(R.string.xiaoying_str_ve_mosaic_title);
                    this.cGY.getScaleRotateView().mo31012hM(false);
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGY.aiG();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    break;
                case 3:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(true);
                    }
                    ajh();
                    this.cGY.getScaleRotateView().mo31012hM(true);
                    this.cGY.getScaleRotateView().mo31006eh(true);
                    this.cGY.aiG();
                    ajA();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    break;
                case 4:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(true);
                    }
                    ajh();
                    this.cGY.aiG();
                    this.cGY.adl();
                    this.czM.setBtnVisibility(false);
                    this.czM.setTitle(R.string.xiaoying_str_ve_mosaic_title);
                    ajA();
                    this.cGX.setText(R.string.xiaoying_str_ve_trim_finish_btn_title);
                    break;
                case 5:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(false);
                    }
                    m17590fj(true);
                    this.czM.setTitle(R.string.xiaoying_str_ve_mosaic_title);
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGY.getScaleRotateView().mo31012hM(false);
                    this.cGY.aiG();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mt */
    public void m17601mt(int i) {
        if (getVideoOperator() != null && getEditor() != null) {
            ((C6167b) getEditor()).mo28973mq(i);
            C8441b mg = ((C6167b) getEditor()).mo28483mg(i);
            if (mg == null || mg.aIg() == null || mg.aIc() == null) {
                ajG();
            } else if (!aeC() && this.cGY != null) {
                if (this.cMD.equals(mg.aIf())) {
                    this.cMH = 0;
                } else if (this.cME.equals(mg.aIf())) {
                    this.cMH = 1;
                }
                this.cGY.mo28360d(mg.aIg());
                if (this.cGY.getScaleRotateView() != null) {
                    this.cGY.getScaleRotateView().mo31012hM(true);
                    this.cGY.getScaleRotateView().mo31006eh(true);
                }
                this.cyJ.mo28429mo(i);
                if (this.cHe != null) {
                    this.cHe.mo28494cA(((C6167b) getEditor()).adZ(), ((C6167b) getEditor()).getCurrentEditEffectIndex());
                }
                m17600ms(3);
                getEffectHListView().mo29002nk(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: na */
    public void m17603na(int i) {
        if (i == 32) {
            C6166a.m17637eU(getContext());
            return;
        }
        if (i == 16) {
            C6166a.m17636bp(getContext(), "bottom");
        } else if (i == 128) {
            C6166a.m17636bp(getContext(), TtmlNode.LEFT);
        } else if (i == 512) {
            C6166a.m17636bp(getContext(), TtmlNode.RIGHT);
        } else if (i == 1024) {
            C6166a.m17636bp(getContext(), "top");
        }
    }

    public void aex() {
        super.aex();
        if (getEditor() == null) {
            finish();
            return;
        }
        C10021c.aZH().mo38494ax(this);
        m17574Oj();
        akW();
        aiX();
        int i = getBundle().getInt("ve_extra_effect_id", -1);
        EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class);
        if (editorIntentInfo != null) {
            this.cMF = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAM_MOSAIC_TYPE);
        }
        if (i < 0) {
            m17600ms(2);
        }
    }

    public boolean aey() {
        return true;
    }

    public void aez() {
        this.cGX.post(new Runnable() {
            public void run() {
                int i = MosaicOperationView.this.getBundle().getInt("ve_extra_effect_id", -1);
                if (i >= 0) {
                    MosaicOperationView.this.m17601mt(i);
                    MosaicOperationView.this.akX();
                } else if (TextUtils.isEmpty(MosaicOperationView.this.cMF) || "0".equals(MosaicOperationView.this.cMF)) {
                    MosaicOperationView.this.cMx.performClick();
                } else {
                    MosaicOperationView.this.cMy.performClick();
                }
            }
        });
    }

    public void ajq() {
        C4586g.m11693B(getActivity());
        ((C6167b) getEditor()).aiy().mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                C4586g.m11695Sl();
                MosaicOperationView.this.finish();
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void finish() {
        if (this.cyD != null) {
            ((C6167b) this.cyD).aix();
        }
        if (this.cGY != null) {
            this.cGY.adl();
            this.cGY.aiG();
        }
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        super.finish();
    }

    public int getCurrentEditEffectIndex() {
        if (getEditor() != null) {
            return ((C6167b) getEditor()).getCurrentEditEffectIndex();
        }
        return -1;
    }

    public C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                if (MosaicOperationView.this.cyJ != null) {
                    MosaicOperationView.this.cyJ.mo28411b(aVar);
                }
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                if (MosaicOperationView.this.getEditor() == null) {
                    return false;
                }
                int i = MosaicOperationView.this.cGU;
                if (i == 2 || i == 5) {
                    return false;
                }
                int b = ((C6167b) MosaicOperationView.this.getEditor()).mo28969b(point);
                MosaicOperationView.this.ajk();
                if (b >= ((C6167b) MosaicOperationView.this.getEditor()).aiz().size() || b < 0 || MosaicOperationView.this.cGY == null) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Find Mosaic when Single Tap index = ");
                sb.append(b);
                LogUtilsV2.m14227d(sb.toString());
                MosaicOperationView.this.m17601mt(b);
                return true;
            }

            public boolean aet() {
                return MosaicOperationView.this.cyJ != null && MosaicOperationView.this.cyJ.ait() && MosaicOperationView.this.cyJ.aiN();
            }

            public void aeu() {
                MosaicOperationView.this.cyJ.aeu();
            }

            public int aev() {
                return MosaicOperationView.this.cyJ.aev();
            }

            public void aew() {
                MosaicOperationView.this.cyJ.aew();
                if (1 == MosaicOperationView.this.cGU) {
                    MosaicOperationView.this.ajr();
                } else if (3 == MosaicOperationView.this.cGU) {
                    if (MosaicOperationView.this.cyJ.getFocusState() == 0) {
                        MosaicOperationView.this.ajr();
                    } else {
                        int i = MosaicOperationView.this.cyJ.getmEditBGMRangeIndex();
                        if (i >= 0) {
                            ((C6167b) MosaicOperationView.this.getEditor()).mo28966a(i, MosaicOperationView.this.cyJ.getEditRange(), MosaicOperationView.this.cyJ.getmEffectKeyFrameRangeList());
                        }
                    }
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                return MosaicOperationView.this.cyJ.mo28423hV(i);
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                MosaicOperationView.this.cyJ.mo28425lb(i);
                if (MosaicOperationView.this.cHe != null) {
                    MosaicOperationView.this.cHe.mo28494cA(i, ((C6167b) MosaicOperationView.this.getEditor()).getCurrentEditEffectIndex());
                }
            }
        };
    }

    public int getLayoutId() {
        return R.layout.editor_effect_mosaic_layout;
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerReady = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (MosaicOperationView.this.cyJ != null) {
                    MosaicOperationView.this.cyJ.mo28392J(i, z);
                }
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPlaying = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (MosaicOperationView.this.cyJ != null) {
                    MosaicOperationView.this.cyJ.mo28393K(i, z);
                }
                if (MosaicOperationView.this.cGY != null) {
                    MosaicOperationView.this.cGY.aiG();
                }
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPause = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (MosaicOperationView.this.cyJ != null) {
                    MosaicOperationView.this.cyJ.mo28394L(i, z);
                }
                if (MosaicOperationView.this.cGY != null && MosaicOperationView.this.cGU == 1 && !MosaicOperationView.this.aeC()) {
                    MosaicOperationView.this.cGY.mo28355aL(((C6167b) MosaicOperationView.this.getEditor()).mo28478fe(true));
                }
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerStop = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (MosaicOperationView.this.cyJ != null) {
                    MosaicOperationView.this.cyJ.mo28395M(i, z);
                }
                if (MosaicOperationView.this.cIc.get()) {
                    MosaicOperationView.this.cGY.getScaleRotateView().mo31006eh(false);
                    MosaicOperationView.this.cGY.getScaleRotateView().mo31012hM(false);
                    MosaicOperationView.this.cIc.set(false);
                }
                if (MosaicOperationView.this.cGU == 4) {
                    MosaicOperationView.this.ajM();
                }
            }

            public void aes() {
            }
        };
    }

    /* renamed from: mX */
    public void mo28956mX(int i) {
        int i2;
        int i3;
        if (this.cGY.getScaleRotateView() != null && this.cGY.getScaleRotateView().getScaleViewState() != null && this.cGY.getScaleRotateView().getScaleViewState().getRectArea() != null && getEditor() != null) {
            float max = ((float) i) / ((float) this.cMw.getMax());
            QEffect b = C8540q.m24940b(((C6167b) getEditor()).adO(), ((C6167b) getEditor()).getGroupId(), ((C6167b) getEditor()).getCurrentEditEffectIndex());
            if (b != null) {
                if (this.cMH == 0) {
                    i2 = ((int) (((float) 120) * max)) + 0;
                    i3 = i2;
                } else {
                    float f = 1.0f - max;
                    if (((C6167b) getEditor()).getStreamSize() != null) {
                        float f2 = ((float) ((C6167b) getEditor()).getStreamSize().width) / ((float) ((C6167b) getEditor()).getStreamSize().height);
                        int i4 = ((C6167b) getEditor()).getStreamSize().width > ((C6167b) getEditor()).getStreamSize().height ? (int) (((double) ((C6167b) getEditor()).getStreamSize().width) * 0.25d) : (int) (((double) ((C6167b) getEditor()).getStreamSize().height) * 0.25d);
                        if (f2 > 1.0f) {
                            i2 = ((int) (((float) (i4 - 10)) * f)) + 10;
                            i3 = (int) (((float) i2) / f2);
                        } else {
                            int i5 = (int) ((((float) (i4 - 10)) * f) + ((float) 10));
                            i3 = i5;
                            i2 = (int) (((float) i5) * f2);
                        }
                        if (i2 < 1) {
                            i2 = 1;
                        }
                        if (i3 < 1) {
                            i3 = 1;
                        }
                    } else {
                        return;
                    }
                }
                QEffectPropertyData qEffectPropertyData = new QEffectPropertyData();
                qEffectPropertyData.mID = 1;
                qEffectPropertyData.mValue = i2;
                b.setProperty(QEffect.PROP_EFFECT_PROPDATA, qEffectPropertyData);
                qEffectPropertyData.mID = 2;
                qEffectPropertyData.mValue = i3;
                b.setProperty(QEffect.PROP_EFFECT_PROPDATA, qEffectPropertyData);
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
        C4577f.m11629e(this.czL);
    }

    public void onActivityResume() {
        super.onActivityResume();
        akd();
    }

    public boolean onBackPressed() {
        switch (this.cGU) {
            case 1:
                if (!((C6167b) getEditor()).aiw()) {
                    finish();
                    return true;
                }
                ajp();
                return true;
            case 2:
                return ajL();
            case 3:
                if (getEditor() == null || !((C6167b) getEditor()).mo28967a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList())) {
                    ajG();
                } else {
                    ajl();
                    if (((C6167b) getEditor()).aiw()) {
                        ajp();
                    }
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
        m17601mt(i);
        if (getEditor() != null && ((C6167b) getEditor()).mo28483mg(i) != null) {
            this.cyJ.mo28394L(0, false);
            ((C6167b) getEditor()).mo27846H(0, false);
            int i2 = ((C6167b) getEditor()).mo28483mg(i).aIc().getmPosition();
            this.cyJ.mo28394L(i2, false);
            ((C6167b) getEditor()).mo27846H(i2, false);
        }
    }
}
