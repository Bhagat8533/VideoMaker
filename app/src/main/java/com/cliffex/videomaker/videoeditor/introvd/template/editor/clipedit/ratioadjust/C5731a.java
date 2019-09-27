package com.introvd.template.editor.clipedit.ratioadjust;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.MSize;
import com.introvd.template.common.utils.UtilsMSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.ratioadjust.C5747d.C5751b;
import com.introvd.template.editor.clipedit.ratioadjust.C5747d.C5752c;
import com.introvd.template.editor.clipedit.ratioadjust.RatioAdjustView.C5730a;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.widget.picker.EditorGalleryBoard;
import com.introvd.template.editor.widget.picker.EditorGalleryBoard.C7045d;
import com.introvd.template.editor.widget.picker.p294b.C7059a;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.p414ui.view.MultiColorBar;
import com.introvd.template.p414ui.view.MultiColorBar.C8981a;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.sdk.utils.C8500b;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.template.p409g.C8762d;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.clip.QClip;

/* renamed from: com.introvd.template.editor.clipedit.ratioadjust.a */
public class C5731a {
    private static String[] cAQ;
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(C5731a.this.cAn)) {
                C5731a.this.m15934ll(8);
                C5731a.this.mo27969N(8, true);
                C5731a.this.cAM = C5731a.this.cAF.getProgress();
                C5731a.this.afm();
            } else if (view.equals(C5731a.this.cAo)) {
                C5731a.this.m15934ll(9);
                C5731a.this.mo27969N(9, true);
                C5731a.this.afm();
            } else if (view.equals(C5731a.this.cAp)) {
                C5731a.this.m15934ll(6);
                C5731a.this.mo27969N(6, true);
                C5731a.this.cAM = C5731a.this.cAG.getProgress();
                C5731a.this.afm();
            } else if (view.equals(C5731a.this.cAu)) {
                boolean isSelected = C5731a.this.cAu.isSelected();
                C5731a.this.m15926ez(isSelected);
                C5731a.this.cAu.setSelected(!isSelected);
                C5740b.m15958aO(C5731a.this.mContext, isSelected ? "fint out" : "fit in");
            }
        }
    };
    private OnSeekBarChangeListener bGR = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            C5731a.this.cAM = i;
            if (C5731a.this.mTransformType == 7 && i >= 10) {
                C5731a.this.mo27969N(6, true);
            } else if (C5731a.this.mTransformType == 6 && i < 10) {
                C5731a.this.mo27969N(7, true);
            }
            C5731a.this.afm();
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
    private QEngine bPS;
    /* access modifiers changed from: private */
    public float bSb = 0.0f;
    /* access modifiers changed from: private */
    public boolean blp = false;
    private RatioAdjustView cAA;
    private RatioAdjustView cAB;
    private RatioAdjustView cAC;
    private RatioAdjustView cAD;
    /* access modifiers changed from: private */
    public RatioAdjustView cAE;
    /* access modifiers changed from: private */
    public SeekBar cAF;
    /* access modifiers changed from: private */
    public SeekBar cAG;
    private EditorGalleryBoard cAH;
    private TextView cAI;
    private C5747d cAJ;
    /* access modifiers changed from: private */
    public C5739a cAK;
    private long cAL;
    /* access modifiers changed from: private */
    public int cAM = 0;
    private float cAN = 0.5f;
    private MSize cAO;
    /* access modifiers changed from: private */
    public boolean cAP;
    private boolean cAR = false;
    private C5730a cAS = new C5730a() {
        /* renamed from: b */
        public void mo27968b(final RatioAdjustView ratioAdjustView, final float f) {
            if (!C4580b.m11632Sf()) {
                if (C5731a.this.cAE != null && C5731a.this.cAE.equals(ratioAdjustView)) {
                    return;
                }
                if (f >= 1.0f || !C5731a.this.cAP || ratioAdjustView.equals(C5731a.this.cAw)) {
                    C5731a.this.m15904a(ratioAdjustView, f);
                } else {
                    C8978m.m26350ht(C5731a.this.mContext).mo10293dl(R.string.xiaoying_str_ve_edit_use_ratio_affect_theme_title).mo10296do(R.string.xiaoying_str_ve_edit_use_ratio_affect_theme_des).mo10281a((C1904j) new C1904j() {
                        public void onClick(C1890f fVar, C1885b bVar) {
                            C5731a.this.m15904a(ratioAdjustView, f);
                        }
                    }).mo10313qu().show();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean cAT;
    /* access modifiers changed from: private */
    public boolean cAU;
    private C5752c cAV = new C5751b() {
        /* renamed from: A */
        public void mo27988A(float f, float f2) {
            if (C5731a.this.csP != null) {
                C5731a.this.mShiftX = f / ((float) C5731a.this.csP.width);
                C5731a.this.mShiftY = f2 / ((float) C5731a.this.csP.height);
                C5731a.this.afm();
            }
        }

        public void afq() {
            if (C5731a.this.cAK != null) {
                C5731a.this.cAK.afq();
            }
        }

        public boolean afr() {
            if (C5731a.this.cAT) {
                C5740b.m15958aO(C5731a.this.mContext, "zoom");
                C5731a.this.cAT = false;
            }
            if (C5731a.this.cAU) {
                C5740b.m15958aO(C5731a.this.mContext, "move");
                C5731a.this.cAU = false;
            }
            return super.afr();
        }

        /* renamed from: z */
        public void mo27991z(float f, float f2) {
            C5731a.this.bSb = f;
            C5731a.this.afm();
        }
    };
    private RelativeLayout cAi;
    private RelativeLayout cAj;
    private ImageView cAk;
    private ImageView cAl;
    private ImageView cAm;
    /* access modifiers changed from: private */
    public RelativeLayout cAn;
    /* access modifiers changed from: private */
    public RelativeLayout cAo;
    /* access modifiers changed from: private */
    public RelativeLayout cAp;
    private View cAq;
    private View cAr;
    private View cAs;
    private RelativeLayout cAt;
    /* access modifiers changed from: private */
    public ImageView cAu;
    private HorizontalScrollView cAv;
    /* access modifiers changed from: private */
    public RatioAdjustView cAw;
    private RatioAdjustView cAx;
    private RatioAdjustView cAy;
    private RatioAdjustView cAz;
    /* access modifiers changed from: private */
    public MSize csP;
    /* access modifiers changed from: private */
    public String csh;
    private float cvt = 1.0f;
    private MultiColorBar cxB;
    private C8981a cxL = new C8981a() {
        /* renamed from: g */
        public void mo27671g(int i, float f) {
            C5731a.this.mClearR = (16711680 & i) >> 16;
            C5731a.this.mClearG = (65280 & i) >> 8;
            C5731a.this.mClearB = i & 255;
            C5731a.this.afm();
        }

        /* renamed from: kW */
        public void mo27672kW(int i) {
        }
    };
    /* access modifiers changed from: private */
    public C4576e czk;
    /* access modifiers changed from: private */
    public int mClearB = 0;
    /* access modifiers changed from: private */
    public int mClearG = 0;
    /* access modifiers changed from: private */
    public int mClearR = 0;
    public QEffectPropertyData[] mClipParamDatas = null;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public float mShiftX = 0.0f;
    /* access modifiers changed from: private */
    public float mShiftY = 0.0f;
    public int mTransformType;

    /* renamed from: com.introvd.template.editor.clipedit.ratioadjust.a$a */
    public interface C5739a {
        void afq();

        boolean afs();

        boolean aft();

        /* renamed from: al */
        void mo27957al(float f);

        /* renamed from: c */
        void mo27958c(long j, boolean z);

        /* renamed from: eB */
        void mo27959eB(boolean z);

        /* renamed from: eC */
        void mo27960eC(boolean z);

        /* renamed from: gJ */
        void mo27961gJ(String str);
    }

    public C5731a(boolean z, QEngine qEngine, QClip qClip, View view, View view2) {
        this.cAP = z;
        this.bPS = qEngine;
        this.mContext = view.getContext();
        cAQ = new String[]{this.mContext.getResources().getString(R.string.xiaoying_str_edit_vscale_original), "1:1", "4:5", "16:9", "9:16", "4:3", "3:4", "2.39:1"};
        this.cAv = (HorizontalScrollView) view.findViewById(R.id.hs_clip_ratios);
        this.cAi = (RelativeLayout) view.findViewById(R.id.rl_layout_color_bar);
        this.cAj = (RelativeLayout) view.findViewById(R.id.rl_layout_adjust_blur);
        this.cAk = (ImageView) view2.findViewById(R.id.iv_tab_blur);
        this.cAl = (ImageView) view2.findViewById(R.id.iv_tab_color);
        this.cAm = (ImageView) view2.findViewById(R.id.iv_tab_background);
        this.cAn = (RelativeLayout) view2.findViewById(R.id.rl_tab_blur);
        this.cAo = (RelativeLayout) view2.findViewById(R.id.rl_tab_color);
        this.cAp = (RelativeLayout) view2.findViewById(R.id.rl_tab_background);
        this.cAq = view2.findViewById(R.id.view_tab_blur);
        this.cAr = view2.findViewById(R.id.view_tab_color);
        this.cAs = view2.findViewById(R.id.view_tab_background);
        this.cAF = (SeekBar) view.findViewById(R.id.seekbar_blur);
        this.cxB = (MultiColorBar) view.findViewById(R.id.multicolor_bar);
        this.cxB.setOnColorChangerListener(this.cxL);
        this.cAu = (ImageView) view.findViewById(R.id.iv_btn_fit);
        this.cAt = (RelativeLayout) view.findViewById(R.id.layout_pic_seekbar);
        this.cAG = (SeekBar) view.findViewById(R.id.pic_seekbar_blur);
        this.cAu.setOnClickListener(this.acD);
        this.cAn.setOnClickListener(this.acD);
        this.cAo.setOnClickListener(this.acD);
        this.cAp.setOnClickListener(this.acD);
        this.cAw = (RatioAdjustView) view.findViewById(R.id.ratio_view_original);
        this.cAx = (RatioAdjustView) view.findViewById(R.id.ratio_view_1_1);
        this.cAy = (RatioAdjustView) view.findViewById(R.id.ratio_view_4_5);
        this.cAz = (RatioAdjustView) view.findViewById(R.id.ratio_view_16_9);
        this.cAA = (RatioAdjustView) view.findViewById(R.id.ratio_view_9_16);
        this.cAB = (RatioAdjustView) view.findViewById(R.id.ratio_view_4_3);
        this.cAC = (RatioAdjustView) view.findViewById(R.id.ratio_view_3_4);
        this.cAD = (RatioAdjustView) view.findViewById(R.id.ratio_view_12_5);
        this.cAw.mo27963a(R.drawable.editor_clip_proportion_original, cAQ[0], -1.0f);
        this.cAx.mo27963a(R.drawable.editor_clip_proportion_1_1, cAQ[1], 1.0f);
        this.cAy.mo27963a(R.drawable.editor_clip_proportion_4_5, cAQ[2], 0.8f);
        this.cAz.mo27963a(R.drawable.editor_clip_proportion_16_9, cAQ[3], 1.7777778f);
        this.cAA.mo27963a(R.drawable.editor_clip_proportion_9_16, cAQ[4], 0.5625f);
        this.cAB.mo27963a(R.drawable.editor_clip_proportion_3_4, cAQ[5], 1.3333334f);
        this.cAC.mo27963a(R.drawable.editor_clip_proportion_4_3, cAQ[6], 0.75f);
        this.cAD.mo27963a(R.drawable.editor_clip_proportion_12_5, cAQ[7], 2.4f);
        this.cAw.setOnClipRatioViewClickListener(this.cAS);
        this.cAx.setOnClipRatioViewClickListener(this.cAS);
        this.cAy.setOnClipRatioViewClickListener(this.cAS);
        this.cAz.setOnClipRatioViewClickListener(this.cAS);
        this.cAA.setOnClipRatioViewClickListener(this.cAS);
        this.cAB.setOnClipRatioViewClickListener(this.cAS);
        this.cAC.setOnClipRatioViewClickListener(this.cAS);
        this.cAD.setOnClipRatioViewClickListener(this.cAS);
        this.cAI = (TextView) view.findViewById(R.id.tv_ratio_custom_bg);
        m15919cy(view);
        afl();
        if (this.cAJ == null) {
            this.cAJ = new C5747d(view.findViewById(R.id.rl_preview_layout_fake));
        }
        this.cAJ.mo28012a(this.cAV);
        this.cAJ.adc();
        this.mTransformType = m15911b(qClip);
        this.cAL = C6386d.m18379pz(this.mTransformType);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15904a(RatioAdjustView ratioAdjustView, float f) {
        if (this.cAK == null || this.cAK.afs()) {
            if (this.cAE != null && !this.cAE.equals(ratioAdjustView)) {
                this.cAE.clearFocus();
            }
            ratioAdjustView.setFocus();
            this.cAE = ratioAdjustView;
            if (this.cAK != null) {
                this.cvt = f;
                this.cAK.mo27957al(f);
            }
            if (ratioAdjustView.equals(this.cAw) && this.cAO != null) {
                afj();
                if (C8572y.m25102s((((float) this.cAO.width) * 1.0f) / ((float) this.cAO.height), (((float) this.csP.width) * 1.0f) / ((float) this.csP.height), 0.04f)) {
                    mo27978ey(false);
                    mo27969N(8, true);
                    return;
                }
            }
            if (this.cAK != null) {
                this.cAK.mo27960eC(false);
            }
            if (!(this.cAj.getVisibility() == 0 || this.cAi.getVisibility() == 0 || this.cAH.getVisibility() == 0)) {
                m15934ll(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void afg() {
        if (C8072q.aBx().mo33072ku(C7825a.CUSTOMIZED_BACKGROUND.getId()) || this.blp) {
            C4577f.m11629e(this.czk);
        } else if (!C4577f.m11630i(this.czk)) {
            this.czk = C4577f.m11623a(this.mContext, (View) this.cAm, "custom_bg", (int) IapRTConstants.REQUEST_CODE_FOR_VIP);
        }
    }

    private void afi() {
        MSize fitInSize = UtilsMSize.getFitInSize(this.cAO, this.csP);
        if (this.cAO != null) {
            if ((((float) this.cAO.width) * 1.0f) / ((float) this.cAO.height) >= (((float) this.csP.width) * 1.0f) / ((float) this.csP.height)) {
                this.cAN = (((float) this.csP.height) * 1.0f) / ((float) fitInSize.height);
            } else {
                this.cAN = (((float) this.csP.width) * 1.0f) / ((float) fitInSize.width);
            }
        }
    }

    private void afj() {
        if (C8572y.m25102s(1.0f, this.cAN, 0.05f)) {
            this.bSb = this.cAN;
        } else {
            this.bSb = 1.0f;
        }
        this.cAu.setSelected(false);
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
        if (this.cAJ != null) {
            this.cAJ.mo28014m(this.bSb, this.mShiftX, this.mShiftY);
        }
        afm();
    }

    private void afk() {
        if (this.cAK != null ? this.cAK.aft() : true) {
            this.cAE = m15908ak((((float) this.csP.width) * 1.0f) / ((float) this.csP.height));
        } else {
            this.cAE = this.cAw;
        }
        this.cAE.setFocus();
        if (!this.cAE.equals(this.cAw) || !C8572y.m25102s((((float) this.cAO.width) * 1.0f) / ((float) this.cAO.height), (((float) this.csP.width) * 1.0f) / ((float) this.csP.height), 0.04f)) {
            if (this.cAK != null) {
                this.cAK.mo27960eC(false);
            }
            m15934ll(this.mTransformType);
            return;
        }
        mo27978ey(false);
    }

    /* renamed from: ak */
    private RatioAdjustView m15908ak(float f) {
        if (C8572y.m25102s(f, 1.0f, 0.04f)) {
            this.cvt = 1.0f;
            return this.cAx;
        } else if (C8572y.m25102s(f, 0.75f, 0.04f)) {
            this.cvt = 0.75f;
            return this.cAC;
        } else if (C8572y.m25102s(f, 1.3333334f, 0.04f)) {
            this.cvt = 1.3333334f;
            return this.cAB;
        } else if (C8572y.m25102s(f, 0.8f, 0.04f)) {
            this.cvt = 0.8f;
            return this.cAy;
        } else if (C8572y.m25102s(f, 2.4f, 0.04f)) {
            this.cvt = 2.4f;
            return this.cAD;
        } else if (C8572y.m25102s(f, 0.5625f, 0.04f)) {
            this.cvt = 0.5625f;
            return this.cAA;
        } else if (!C8572y.m25102s(f, 1.7777778f, 0.04f)) {
            return this.cAw;
        } else {
            this.cvt = 1.7777778f;
            return this.cAz;
        }
    }

    /* renamed from: b */
    private static int m15911b(QClip qClip) {
        if (C8537n.m24835n(qClip).booleanValue()) {
            return 8;
        }
        long templateID = C8762d.aMt().getTemplateID(C8538o.m24873f(C8537n.m24816b(qClip, -10, 0)));
        if (5404319552844595213L == templateID) {
            return 8;
        }
        if (5404319552844595212L == templateID) {
            return 9;
        }
        if (5404319552844595214L == templateID) {
            return 6;
        }
        return 5404319552844595215L == templateID ? 7 : 8;
    }

    /* renamed from: c */
    private void m15917c(QClip qClip) {
        if (qClip != null && this.mClipParamDatas != null) {
            this.bSb = (((float) this.mClipParamDatas[0].mValue) / 5000.0f) - 10.0f;
            this.mShiftX = (((float) this.mClipParamDatas[3].mValue) / 5000.0f) - 10.0f;
            this.mShiftY = (((float) this.mClipParamDatas[4].mValue) / 5000.0f) - 10.0f;
            if (this.cAu != null) {
                this.cAu.setSelected(this.bSb > 1.0f);
            }
            if (this.mTransformType == 8) {
                this.cAM = this.mClipParamDatas[5].mValue;
                this.cAF.setProgress(this.cAM);
            } else if (this.mTransformType == 9) {
                if (this.mClipParamDatas.length >= 13) {
                    this.mClearR = this.mClipParamDatas[5].mValue;
                    this.mClearG = this.mClipParamDatas[6].mValue;
                    this.mClearB = this.mClipParamDatas[7].mValue;
                    this.mClearR = this.mClipParamDatas[8].mValue;
                    this.mClearG = this.mClipParamDatas[9].mValue;
                    this.mClearB = this.mClipParamDatas[10].mValue;
                    this.cxB.setCurColor(Color.rgb(this.mClearR, this.mClearG, this.mClearB));
                } else {
                    return;
                }
            } else if (this.mTransformType == 6 || this.mTransformType == 7) {
                this.cAM = this.mClipParamDatas[5].mValue;
                this.cAG.setProgress(this.cAM);
                this.cAH.setFocusItem(C8538o.m24886p(C8537n.m24816b(qClip, -10, 0)));
            }
            this.cAF.setOnSeekBarChangeListener(this.bGR);
            this.cAG.setOnSeekBarChangeListener(this.bGR);
            afk();
        }
    }

    /* renamed from: cy */
    private void m15919cy(View view) {
        this.cAH = (EditorGalleryBoard) view.findViewById(R.id.clip_ratio_effect_board);
        this.cAH.mo30947a(C7045d.MODE_PIC, !C8072q.aBx().mo33072ku(C7825a.CUSTOMIZED_BACKGROUND.getId()));
        this.cAH.setNormalHeight(C8500b.m24591P(158.0f));
        C8522g aJA = C8522g.aJA();
        if (aJA != null) {
            this.cAH.setCompressedFilePath(aJA.aJH());
        }
        this.cAH.setGalleryBoardListener(new C7059a() {
            public void afn() {
                C5731a.this.csh = null;
                C5731a.this.afm();
            }

            public void afo() {
            }

            public void afp() {
            }

            /* renamed from: eA */
            public void mo27985eA(boolean z) {
                if (z) {
                    C5731a.this.blp = true;
                    C4577f.m11629e(C5731a.this.czk);
                    return;
                }
                C5731a.this.blp = false;
                C5731a.this.afg();
            }

            /* renamed from: gI */
            public void mo27986gI(String str) {
                C5731a.this.csh = str;
                C5731a.this.afm();
            }
        });
    }

    /* renamed from: ex */
    private void m15925ex(boolean z) {
        if (this.cAv != null) {
            ((LayoutParams) this.cAv.getLayoutParams()).topMargin = C8500b.m24591P(z ? 13.0f : 28.0f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ez */
    public void m15926ez(boolean z) {
        if (!z) {
            float f = (((float) this.csP.width) * 1.0f) / ((float) this.csP.height);
            if (this.cvt < 0.0f) {
                this.cvt = -this.cvt;
            }
            if (this.cvt > 1.0f) {
                this.bSb = ((this.cAN * this.cvt) / f) + 0.01f;
            } else {
                this.bSb = ((this.cAN * f) / this.cvt) + 0.01f;
            }
        } else if (C8572y.m25102s(1.0f, this.cAN, 0.05f)) {
            this.bSb = this.cAN;
        } else {
            this.bSb = 1.0f;
        }
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
        if (this.cAJ != null) {
            this.cAJ.mo28014m(this.bSb, this.mShiftX, this.mShiftY);
        }
        afm();
    }

    /* access modifiers changed from: private */
    /* renamed from: ll */
    public void m15934ll(int i) {
        this.cAu.setVisibility(0);
        if (i == 8) {
            C4577f.m11629e(this.czk);
            this.cAk.setSelected(true);
            this.cAl.setSelected(false);
            this.cAm.setSelected(false);
            this.cAq.setVisibility(0);
            this.cAr.setVisibility(8);
            this.cAs.setVisibility(8);
            m15925ex(true);
            this.cAj.setVisibility(0);
            this.cAi.setVisibility(8);
            this.cAH.setVisibility(8);
            this.cAt.setVisibility(8);
            this.cAI.setVisibility(8);
        } else if (i == 9) {
            C4577f.m11629e(this.czk);
            this.cAk.setSelected(false);
            this.cAl.setSelected(true);
            this.cAm.setSelected(false);
            this.cAq.setVisibility(8);
            this.cAr.setVisibility(0);
            this.cAs.setVisibility(8);
            m15925ex(true);
            this.cAj.setVisibility(8);
            this.cAi.setVisibility(0);
            this.cAH.setVisibility(8);
            this.cAt.setVisibility(8);
            this.cAI.setVisibility(8);
        } else if (i == 6 || i == 7) {
            afg();
            this.cAk.setSelected(false);
            this.cAl.setSelected(false);
            this.cAm.setSelected(true);
            this.cAq.setVisibility(8);
            this.cAr.setVisibility(8);
            this.cAs.setVisibility(0);
            m15925ex(false);
            this.cAj.setVisibility(8);
            this.cAi.setVisibility(8);
            this.cAH.setVisibility(0);
            this.cAt.setVisibility(0);
            this.cAI.setVisibility(0);
        }
    }

    /* renamed from: N */
    public void mo27969N(int i, boolean z) {
        this.mTransformType = i;
        this.cAL = C6386d.m18379pz(this.mTransformType);
        if (this.cAK != null) {
            this.cAK.mo27958c(this.cAL, z);
        }
    }

    /* renamed from: a */
    public void mo27970a(C5739a aVar) {
        this.cAK = aVar;
    }

    /* renamed from: a */
    public void mo27971a(QClip qClip, MSize mSize) {
        if (qClip != null) {
            VeMSize f = C8537n.m24823f(qClip);
            if (f != null) {
                this.cAO = new MSize(f.width, f.height);
            }
        }
        this.csP = mSize;
        afi();
    }

    /* renamed from: a */
    public void mo27972a(QClip qClip, boolean z) {
        if (qClip != null) {
            this.mTransformType = m15911b(qClip);
            this.cAL = C6386d.m18379pz(this.mTransformType);
            this.mClipParamDatas = C8537n.m24811a(this.bPS, qClip, -10, this.cAL);
            if (z) {
                m15917c(qClip);
            }
        }
    }

    public boolean afh() {
        return this.cAE != null && !this.cAE.equals(this.cAw);
    }

    public void afl() {
        if (this.cAH != null) {
            this.cAH.mo30949hD(!C8072q.aBx().mo33072ku(C7825a.CUSTOMIZED_BACKGROUND.getId()));
        }
    }

    public void afm() {
        if (this.mClipParamDatas != null && this.mClipParamDatas.length >= 5) {
            this.mClipParamDatas[0].mValue = (int) ((this.bSb + 10.0f) * 5000.0f);
            this.mClipParamDatas[1].mValue = (int) ((this.bSb + 10.0f) * 5000.0f);
            this.mClipParamDatas[3].mValue = (int) ((this.mShiftX + 10.0f) * 5000.0f);
            this.mClipParamDatas[4].mValue = (int) ((this.mShiftY + 10.0f) * 5000.0f);
            int i = 100;
            if (this.mTransformType != 9) {
                if (this.mClipParamDatas.length >= 8 || this.cAK == null) {
                    this.mClipParamDatas[5].mValue = this.cAM;
                    this.mClipParamDatas[6].mValue = this.cAM;
                    QEffectPropertyData qEffectPropertyData = this.mClipParamDatas[7];
                    if (!this.cAR) {
                        i = 0;
                    }
                    qEffectPropertyData.mValue = i;
                    if ((this.mTransformType == 6 || this.mTransformType == 7) && this.cAK != null) {
                        this.cAK.mo27961gJ(this.csh);
                        this.cAK.mo27959eB(true);
                        return;
                    }
                } else {
                    this.cAK.mo27959eB(false);
                    return;
                }
            } else if (this.mClipParamDatas.length >= 13 || this.cAK == null) {
                this.mClipParamDatas[5].mValue = this.mClearR;
                this.mClipParamDatas[6].mValue = this.mClearG;
                this.mClipParamDatas[7].mValue = this.mClearB;
                this.mClipParamDatas[8].mValue = this.mClearR;
                this.mClipParamDatas[9].mValue = this.mClearG;
                this.mClipParamDatas[10].mValue = this.mClearB;
                QEffectPropertyData qEffectPropertyData2 = this.mClipParamDatas[12];
                if (!this.cAR) {
                    i = 0;
                }
                qEffectPropertyData2.mValue = i;
            } else {
                this.cAK.mo27959eB(false);
                return;
            }
            if (this.cAK != null) {
                this.cAK.mo27959eB(false);
            }
        }
    }

    /* renamed from: aj */
    public void mo27976aj(float f) {
        RatioAdjustView ak = m15908ak(f);
        if (ak != null && (this.cAE == null || !this.cAE.equals(ak))) {
            m15904a(ak, f);
        }
    }

    /* renamed from: ew */
    public void mo27977ew(boolean z) {
        this.cAR = z;
    }

    /* renamed from: ey */
    public void mo27978ey(boolean z) {
        if (this.cAK != null) {
            this.cAK.mo27960eC(true);
        }
        m15925ex(false);
        this.cAj.setVisibility(8);
        this.cAi.setVisibility(8);
        this.cAH.setVisibility(8);
        this.cAI.setVisibility(8);
        this.cAt.setVisibility(8);
        this.cAu.setVisibility(8);
        if (z && this.cAE != null) {
            this.cAE.clearFocus();
        }
    }

    public long getEffectID() {
        return this.cAL;
    }

    /* access modifiers changed from: 0000 */
    public void onDestroy() {
        C4577f.m11629e(this.czk);
        if (this.cAH != null) {
            this.cAH.auF();
        }
    }

    /* access modifiers changed from: 0000 */
    public void onResume() {
        if (C8072q.aBx().mo33072ku(C7825a.CUSTOMIZED_BACKGROUND.getId())) {
            C4577f.m11629e(this.czk);
        }
    }
}
