package com.introvd.template.editor.effects.bubble.subtitle;

import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.StorageInfo;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.R;
import com.introvd.template.editor.advance.C5600g;
import com.introvd.template.editor.effects.bubble.p255a.C5924c;
import com.introvd.template.editor.effects.bubble.p255a.C5924c.C5927a;
import com.introvd.template.editor.effects.bubble.subtitle.C6005b.C6007a;
import com.introvd.template.editor.effects.bubble.subtitle.C6032h.C6034a;
import com.introvd.template.editor.effects.quickposition.PixelMoveControlView;
import com.introvd.template.editor.effects.quickposition.PixelMoveControlView.C6189a;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p414ui.view.MultiColorBar;
import com.introvd.template.p414ui.view.MultiColorBar.C8981a;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.ShadowInfo;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.model.editor.StrokeInfo;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p407e.C8720b;
import com.introvd.template.template.p407e.C8720b.C8727c;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p408f.C8751e;
import com.introvd.template.template.p409g.C8759b;
import com.p131c.p132a.C2561a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QStyle;

/* renamed from: com.introvd.template.editor.effects.bubble.subtitle.i */
public class C6035i {
    /* access modifiers changed from: private */
    public static boolean bIV;
    private static boolean cIF;
    private static ArrayList<StoryBoardItemInfo> cxu;
    /* access modifiers changed from: private */
    public RelativeLayout bWd;
    /* access modifiers changed from: private */
    public RelativeLayout cHT;
    /* access modifiers changed from: private */
    public RelativeLayout cHU;
    /* access modifiers changed from: private */
    public RelativeLayout cHV;
    private PixelMoveControlView cIA;
    private SwitchCompat cIB;
    private SwitchCompat cIC;
    /* access modifiers changed from: private */
    public C5924c cID;
    private RadioGroup cIE;
    private SeekBar cIG;
    /* access modifiers changed from: private */
    public MultiColorBar cIH;
    private MultiColorBar cII;
    /* access modifiers changed from: private */
    public C6016e cIJ;
    /* access modifiers changed from: private */
    public C6009d cIK;
    /* access modifiers changed from: private */
    public C6008c cIL;
    private OnClickListener cIM = new OnClickListener() {
        public void onClick(View view) {
            if (view == C6035i.this.cIw) {
                C6035i.this.cIw.setBackgroundColor(C6035i.this.bWd.getContext().getResources().getColor(R.color.color_1affffff));
                C6035i.this.cHT.setBackgroundColor(C6035i.this.bWd.getContext().getResources().getColor(R.color.transparent));
            } else if (view == C6035i.this.cHT) {
                C6035i.this.cHT.setBackgroundColor(C6035i.this.bWd.getContext().getResources().getColor(R.color.color_1affffff));
            } else if (view == C6035i.this.cHU) {
                C6035i.this.cHU.setBackgroundColor(C6035i.this.bWd.getContext().getResources().getColor(R.color.color_1affffff));
            } else if (view == C6035i.this.cHV) {
                C6035i.this.cHV.setBackgroundColor(C6035i.this.bWd.getContext().getResources().getColor(R.color.color_1affffff));
            }
        }
    };
    private C6000a cIN = new C6000a() {
        private boolean cIU = true;

        public int adF() {
            return C6035i.this.cwZ;
        }

        public boolean adG() {
            if (C6035i.this.cIL != null) {
                C6035i.this.cIL.ace();
            }
            return false;
        }

        public void ajB() {
            C6035i.this.add();
        }

        /* renamed from: b */
        public void mo28679b(RollInfo rollInfo) {
            if (C6035i.this.cIL != null) {
                C6035i.this.cIL.mo28657a(rollInfo);
            }
        }

        /* renamed from: c */
        public void mo28680c(EffectInfoModel effectInfoModel) {
            if (C6035i.this.cIL != null) {
                C6035i.this.cIL.mo28660b(effectInfoModel);
            }
        }

        /* renamed from: kX */
        public void mo28681kX(int i) {
            if (C6035i.this.cwZ != i) {
                C6035i.this.cwZ = i;
                if (C6035i.this.ajQ() ^ this.cIU) {
                    if (this.cIU) {
                        C6035i.this.cIK.adI();
                    } else {
                        C6035i.this.cIJ.adI();
                    }
                }
            }
            C6035i.this.ajy();
        }

        /* renamed from: mx */
        public boolean mo28682mx(int i) {
            this.cIU = C6035i.this.ajQ();
            return true;
        }
    };
    private C5927a cIO = new C5927a() {
        /* renamed from: z */
        public void mo28545z(View view, int i) {
            if (!C4580b.m11632Sf()) {
                if (i == 0) {
                    try {
                        new C5600g(C6035i.this.bWd.getContext()).show();
                    } catch (Exception e) {
                        C5523b.logException(e);
                    }
                } else {
                    if (i == 1) {
                        C6035i.this.cxw = "";
                    } else {
                        StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) C6035i.this.cID.getItem(i);
                        if (storyBoardItemInfo != null) {
                            if (TextUtils.isEmpty(storyBoardItemInfo.mFontPath)) {
                                View findViewById = view.findViewById(R.id.edit_subtitle_font_item_download_layout);
                                if (findViewById != null) {
                                    findViewById.performClick();
                                }
                                return;
                            }
                            C6035i.this.cxw = storyBoardItemInfo.mFontPath;
                        }
                    }
                    if (C6035i.this.cIL != null) {
                        C6035i.this.cIL.mo28662hf(C6035i.this.cxw);
                    }
                    int ajC = C6035i.this.cID.ajC();
                    C6035i.this.cID.mo28542kP(i);
                    C6035i.this.cID.notifyItemChanged(ajC);
                    C6035i.this.cID.notifyItemChanged(i);
                }
            }
        }
    };
    private C6007a cIP = new C6007a() {
        /* renamed from: fl */
        public void mo28694fl(boolean z) {
            if (C6035i.this.cIL != null) {
                C6035i.this.cIL.mo28661fl(z);
            }
        }

        /* renamed from: kV */
        public void mo28695kV(int i) {
            C6035i.this.m17162mC(i);
        }
    };
    private OnCheckedChangeListener cIQ = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("key_pref_anim_style_open", z);
            C6035i.this.m17173t(true, z);
        }
    };
    private OnCheckedChangeListener cIR = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (C6035i.this.cIL != null) {
                C6035i.this.cIL.mo28656O(0, z);
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener cIS = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            C6035i.this.m17163mD(C6035i.this.m17132R(((RadioButton) radioGroup.findViewById(i)).getTag()));
        }
    };
    private C6034a cIa = new C6034a() {
        /* renamed from: my */
        public void mo28745my(int i) {
        }
    };
    /* access modifiers changed from: private */
    public boolean cIr = false;
    /* access modifiers changed from: private */
    public int cIs = 0;
    /* access modifiers changed from: private */
    public C6005b cIt;
    private C6032h cIu;
    private RelativeLayout cIv;
    /* access modifiers changed from: private */
    public RelativeLayout cIw;
    private RelativeLayout cIx;
    /* access modifiers changed from: private */
    public View cIy;
    private View cIz;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    private boolean cwC = false;
    private String cwD = "";
    /* access modifiers changed from: private */
    public TemplateConditionModel cwF;
    /* access modifiers changed from: private */
    public int cwZ = -1;
    /* access modifiers changed from: private */
    public C8759b cww = new C8759b(9);
    /* access modifiers changed from: private */
    public RecyclerView cxA;
    private ImageView cxC;
    /* access modifiers changed from: private */
    public ArrayList<StoryBoardItemInfo> cxE;
    /* access modifiers changed from: private */
    public C8720b cxF;
    public String cxw = "";
    private RelativeLayout cxy;

    public C6035i(RelativeLayout relativeLayout, TemplateConditionModel templateConditionModel) {
        cIF = !C2561a.aON();
        this.bWd = relativeLayout;
        this.cwF = templateConditionModel;
        this.compositeDisposable = new C1494a();
        initUI();
        adu();
        this.cIJ = new C6016e(this.cxy);
        this.cIJ.mo28707a(this.cIN);
        this.cIK = new C6009d(this.cIv);
        this.cIK.mo28696a(this.cIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public int m17132R(Object obj) {
        String valueOf = String.valueOf(obj);
        if ("LEFT".equals(valueOf)) {
            return 0;
        }
        if ("MIDDLE".equals(valueOf)) {
            return 1;
        }
        return "RIGHT".equals(valueOf) ? 2 : 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m17136a(ArrayList<StoryBoardItemInfo> arrayList, String str) {
        if (arrayList != null) {
            int size = arrayList.size();
            StringBuilder sb = new StringBuilder();
            sb.append("subtitle style count = ");
            sb.append(size);
            LogUtilsV2.m14230i(sb.toString());
            for (int i = 0; i < size; i++) {
                StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) arrayList.get(i);
                if (!TextUtils.isEmpty(str) && TextUtils.equals(str, storyBoardItemInfo.mFontPath)) {
                    return i;
                }
            }
        }
        return 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: aH */
    public List<StoryBoardItemInfo> m17142aH(List<TemplateInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (TemplateInfo templateInfo : new ArrayList(list)) {
            StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
            storyBoardItemInfo.mFontInfo = templateInfo;
            storyBoardItemInfo.mFontPath = this.cxF.mo35113qf(templateInfo.ttid);
            arrayList.add(storyBoardItemInfo);
        }
        return arrayList;
    }

    private void adu() {
        this.cIt = new C6005b(this.bWd, cIF);
        this.cIt.mo28687a(this.cIP);
        this.cIu = new C6032h(this.bWd);
        this.cIu.mo28742a(this.cIa);
        this.cxC = (ImageView) this.bWd.findViewById(R.id.iv_color_reset);
        this.cxC.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C6035i.this.cIL != null) {
                    ScaleRotateViewState ajD = C6035i.this.cIL.ajD();
                    if (ajD != null) {
                        C6035i.this.cIH.setCurColor(ajD.getTextDftColor());
                        C6035i.this.cIL.mo28664k(0, ajD.getTextDftColor(), true);
                    }
                }
            }
        });
        this.cIH = (MultiColorBar) this.bWd.findViewById(R.id.multicolor_bar_subtitle);
        this.cIH.setOnColorChangerListener(new C8981a() {
            /* renamed from: g */
            public void mo27671g(int i, float f) {
                if (C6035i.this.cIL != null) {
                    C6035i.this.cIL.mo28664k(0, i, false);
                }
            }

            /* renamed from: kW */
            public void mo27672kW(int i) {
                if (C6035i.this.cIL != null) {
                    C6035i.this.cIL.mo28664k(0, i, true);
                }
            }
        });
        this.cII = (MultiColorBar) this.bWd.findViewById(R.id.multicolor_bar_stroke);
        this.cII.setOnColorChangerListener(new C8981a() {
            /* renamed from: g */
            public void mo27671g(int i, float f) {
                if (C6035i.this.cIL != null) {
                    C6035i.this.cIL.mo28664k(1, i, false);
                }
            }

            /* renamed from: kW */
            public void mo27672kW(int i) {
                if (C6035i.this.cIL != null) {
                    C6035i.this.cIL.mo28664k(1, i, true);
                }
            }
        });
        this.cIG = (SeekBar) this.bWd.findViewById(R.id.seekbar_stroke);
        this.cIG.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (C6035i.this.cIL != null) {
                    C6035i.this.cIL.mo28668mz(i);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void adv() {
        try {
            if (C8735f.aMf().mo35143aq(this.bWd.getContext(), C8399c.edb)) {
                ImageView imageView = (ImageView) this.bWd.findViewById(R.id.img_new_flag);
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<StoryBoardItemInfo> adx() {
        Collection collection;
        Collection collection2;
        final ArrayList<StoryBoardItemInfo> arrayList = new ArrayList<>();
        String mainStorage = StorageInfo.getMainStorage();
        ArrayList arrayList2 = null;
        if (FileUtils.isDirectoryExisted(mainStorage)) {
            StringBuilder sb = new StringBuilder();
            sb.append(mainStorage);
            sb.append("/font/");
            arrayList2 = C8751e.m25576a(C8751e.m25577qA(sb.toString()), false);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mainStorage);
            sb2.append("/ifont/custom/");
            collection = C8751e.m25576a(C8751e.m25577qA(sb2.toString()), false);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(mainStorage);
            sb3.append("/zitiguanjia/");
            collection2 = C8751e.m25576a(C8751e.m25577qA(sb3.toString()), false);
        } else {
            collection2 = null;
            collection = null;
        }
        ArrayList a = C8751e.m25576a(C8751e.m25577qA(CommonConfigure.APP_PRIVATE_FONT_PATH), false);
        arrayList.add(new StoryBoardItemInfo());
        arrayList.add(new StoryBoardItemInfo());
        if (a != null) {
            arrayList.addAll(a);
        }
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        if (collection != null) {
            arrayList.addAll(collection);
        }
        if (collection2 != null) {
            arrayList.addAll(collection2);
        }
        if (cxu != null) {
            arrayList.addAll(cxu);
        }
        final List aH = m17142aH(this.cxF.aLW());
        arrayList.addAll(aH);
        this.cxF.mo35102a((C8727c) new C8727c() {
            public boolean adC() {
                return false;
            }

            public boolean adD() {
                int i;
                arrayList.removeAll(aH);
                aH.clear();
                aH.addAll(C6035i.this.m17142aH(C6035i.this.cxF.aLW()));
                arrayList.addAll(aH);
                if (C6035i.this.cID != null) {
                    i = C6035i.this.m17136a(arrayList, C6035i.this.cxw);
                    C6035i.this.cID.mo28542kP(i);
                    C6035i.this.cID.notifyDataSetChanged();
                } else {
                    i = 0;
                }
                if (C6035i.this.cxA != null) {
                    C6035i.this.cxA.getLayoutManager().scrollToPosition(i);
                }
                return false;
            }

            public boolean adE() {
                if (C6035i.this.cID != null) {
                    C6035i.this.cID.notifyDataSetChanged();
                }
                return false;
            }
        });
        this.cxF.aLV();
        return arrayList;
    }

    /* access modifiers changed from: private */
    public boolean ajR() {
        return this.cwC;
    }

    /* renamed from: i */
    private void m17155i(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState != null) {
            this.cIB.setOnCheckedChangeListener(null);
            this.cIB.setChecked(scaleRotateViewState.isAnimOn());
            this.cIB.setOnCheckedChangeListener(this.cIQ);
            if (scaleRotateViewState.isSupportAnim() && !ajQ()) {
                this.cIx.setVisibility(0);
            } else {
                this.cIx.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m17156i(ArrayList<StoryBoardItemInfo> arrayList) {
        if (this.cxA != null) {
            int a = m17136a(arrayList, this.cxw);
            this.cID = new C5924c(this.bWd.getContext(), arrayList, this.cxF);
            this.cID.mo28542kP(a);
            this.cxA.setAdapter(this.cID);
            this.cID.mo28538a(this.cIO);
            this.cxA.getLayoutManager().scrollToPosition(a);
        }
    }

    private void initUI() {
        this.cIz = this.bWd.findViewById(R.id.rl_subtitle_root_bottom_layout);
        this.cIz.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cxy = (RelativeLayout) this.bWd.findViewById(R.id.rl_subtitle_layout);
        this.cIv = (RelativeLayout) this.bWd.findViewById(R.id.rl_anim_text_layout);
        this.cIx = (RelativeLayout) this.bWd.findViewById(R.id.anim_switch_layout);
        this.cIB = (SwitchCompat) this.bWd.findViewById(R.id.anim_switch);
        this.cIB.setOnCheckedChangeListener(this.cIQ);
        this.cIC = (SwitchCompat) this.bWd.findViewById(R.id.btn_import_finish);
        this.cIC.setOnCheckedChangeListener(this.cIR);
        adv();
        this.cIE = (RadioGroup) this.bWd.findViewById(R.id.align_radio_group);
        this.cIE.setOnCheckedChangeListener(this.cIS);
        this.cIA = (PixelMoveControlView) this.bWd.findViewById(R.id.pixel_move);
        this.cIA.setOnLongMoveListener(new C6189a() {
            /* renamed from: mH */
            public void mo28772mH(int i) {
                if (C6035i.this.cIL != null) {
                    C6035i.this.cIL.mo28666mB(i);
                }
            }
        });
        this.cIw = (RelativeLayout) this.bWd.findViewById(R.id.tab_font_style);
        this.cHT = (RelativeLayout) this.bWd.findViewById(R.id.tab_font_color);
        this.cHU = (RelativeLayout) this.bWd.findViewById(R.id.tab_font_stroke);
        this.cHV = (RelativeLayout) this.bWd.findViewById(R.id.tab_font_shadow);
        this.cIw.setOnClickListener(this.cIM);
        this.cHT.setOnClickListener(this.cIM);
        this.cHU.setOnClickListener(this.cIM);
        this.cHV.setOnClickListener(this.cIM);
        this.cxA = (RecyclerView) this.bWd.findViewById(R.id.recycler_view_font_text);
        this.cxA.setLayoutManager(new GridLayoutManager(this.bWd.getContext(), 2, 0, false));
    }

    /* renamed from: j */
    private void m17158j(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState != null) {
            StrokeInfo strokeInfo = scaleRotateViewState.getStrokeInfo();
            if (strokeInfo != null) {
                this.cII.setCurColor(strokeInfo.strokeColor);
                this.cIG.setProgress((int) (strokeInfo.strokeWPersent * 200.0f));
            }
            ShadowInfo shadowInfo = scaleRotateViewState.getShadowInfo();
            if (shadowInfo != null) {
                this.cIC.setOnCheckedChangeListener(null);
                this.cIC.setChecked(shadowInfo.isbEnableShadow());
                this.cIC.setOnCheckedChangeListener(this.cIR);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mC */
    public void m17162mC(int i) {
        ScaleRotateViewState scaleRotateViewState;
        String str = "";
        if (this.cIL != null) {
            this.cIL.mo28667my(i);
            scaleRotateViewState = this.cIL.ajD();
        } else {
            scaleRotateViewState = null;
        }
        if (scaleRotateViewState != null) {
            int ajC = this.cIt.ajC();
            if (ajC == 1) {
                str = "bubble_text";
            }
            if (ajC == 0) {
                str = "animation_Text";
            } else if (ajC == 2) {
                this.cIH.setCurColor(scaleRotateViewState.getTextColor());
                int a = m17136a(this.cxE, scaleRotateViewState.getTextFontPath());
                if (this.cID != null) {
                    this.cID.mo28542kP(a);
                    this.cID.notifyDataSetChanged();
                    this.cxA.getLayoutManager().scrollToPosition(a);
                }
                m17158j(scaleRotateViewState);
                str = "text_info";
                C6031g.m17109bf(this.bWd.getContext(), "字体");
            } else if (ajC == 3) {
                int mF = m17165mF(scaleRotateViewState.getTextAlignment());
                if (mF >= 0) {
                    Object mE = m17164mE(mF);
                    if (mE != null) {
                        RadioButton radioButton = (RadioButton) this.cIE.findViewWithTag(mE);
                        if (radioButton != null) {
                            radioButton.setChecked(true);
                        }
                    }
                }
                m17155i(scaleRotateViewState);
                str = "positioning";
            }
            C6031g.m17110bg(this.bWd.getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mD */
    public void m17163mD(int i) {
        int i2 = 2;
        if (i == 0) {
            i2 = 1;
        } else if (i == 1) {
            i2 = 96;
        } else if (i != 2) {
            i2 = 0;
        }
        if (this.cIL != null) {
            this.cIL.mo28665mA(i2);
        }
    }

    /* renamed from: mE */
    private Object m17164mE(int i) {
        return i == 0 ? "LEFT" : i == 1 ? "MIDDLE" : i == 2 ? "RIGHT" : "LEFT";
    }

    /* renamed from: mF */
    private int m17165mF(int i) {
        if (i == 96) {
            return 1;
        }
        switch (i) {
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m17173t(boolean z, boolean z2) {
        if (z) {
            if (this.cIL != null) {
                this.cIL.mo28656O(1, z2);
            }
            if (z2) {
                ToastUtils.show(this.bWd.getContext(), this.bWd.getContext().getResources().getString(R.string.xiaoying_str_ve_anim_effect_on), 0);
            } else {
                ToastUtils.show(this.bWd.getContext(), this.bWd.getContext().getResources().getString(R.string.xiaoying_str_ve_anim_effect_off), 0);
            }
        } else {
            ToastUtils.show(this.bWd.getContext(), R.string.xiaoying_str_ve_title_template_no_anim_tip, 0);
        }
    }

    /* renamed from: a */
    public void mo28746a(C6008c cVar) {
        this.cIL = cVar;
    }

    public void add() {
        if (this.cww != null) {
            this.cwZ = this.cww.mo35208qC(this.cwD);
            if (this.cIs != 4 && cIF && this.cwZ < 0) {
                this.cwZ = this.cww.mo35205bx(648518346341875717L);
            }
            if (this.cIs == 4) {
                this.cwZ = this.cww.mo35205bx(QStyle.DEFAULT_BUBBLE_TEMPLATE_ID);
            }
            if (this.cwZ < 0 && this.cww.getCount() > 0) {
                this.cwZ = 0;
            }
            if (!this.cIr) {
                this.cIt.mo28692s(ajQ(), false);
            }
        }
    }

    public void ade() {
        if (this.cIJ != null) {
            this.cIJ.ade();
        }
        if (this.cxA != null) {
            this.cxA.setAdapter(null);
            this.cxA = null;
        }
        if (this.cww != null) {
            this.cww.unInit(true);
        }
        if (this.cxF != null) {
            this.cxF.release();
        }
        if (this.cIt != null) {
            this.cIt.ade();
        }
    }

    public void adk() {
        mo28758fj(true);
    }

    public void ajA() {
        C4562a.m11534b(this.cIz, false, true, 0);
    }

    public void ajP() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean ajQ() {
        if (!cIF) {
            return false;
        }
        if (this.cww != null) {
            EffectInfoModel vh = this.cww.mo35214vh(this.cwZ);
            if (vh != null) {
                return C8450a.m24466bk(vh.mTemplateId);
            }
        }
        return true;
    }

    public RollInfo ajv() {
        if (ajQ()) {
            if (this.cIK != null) {
                return this.cIK.ajv();
            }
        } else if (this.cIJ != null) {
            return this.cIJ.ajv();
        }
        return null;
    }

    public void ajy() {
        if (this.cIt != null) {
            if (this.cIr) {
                this.cIr = false;
                this.cIt.mo28691kP(2);
            } else {
                int ajC = this.cIt.ajC();
                if (!(ajC == 1 || ajC == 0)) {
                    this.cIt.mo28692s(ajQ(), false);
                }
            }
        }
        if (this.cIL != null) {
            this.cIL.mo28663j(this.cww.mo35210qG(this.cwZ), ajQ());
        }
    }

    /* renamed from: cC */
    public void mo28755cC(View view) {
        this.cIy = view;
    }

    /* renamed from: ek */
    public void mo28756ek(boolean z) {
        if (this.cww != null) {
            int count = this.cww.getCount();
            this.cww.mo35198a(this.bWd.getContext(), -1, this.cwF, bIV);
            if (count != this.cww.getCount() || z) {
                this.cwZ = this.cww.mo35208qC(this.cwD);
                this.cIJ.mo28712fm(true);
                this.cIK.mo28700fm(true);
                return;
            }
            this.cwZ = this.cww.mo35208qC(this.cwD);
        }
    }

    /* renamed from: eo */
    public void mo28757eo(boolean z) {
        this.cww.mo35198a(this.bWd.getContext(), -1, this.cwF, bIV);
        this.cwZ = this.cww.mo35208qC(this.cwD);
        this.cIJ.mo28712fm(z);
        this.cIK.mo28700fm(z);
    }

    /* renamed from: fj */
    public void mo28758fj(boolean z) {
        C4562a.m11534b(this.cIz, true, z, 0);
        m17162mC(this.cwZ);
    }

    /* renamed from: fo */
    public void mo28759fo(boolean z) {
        this.cwC = z;
    }

    /* renamed from: fp */
    public void mo28760fp(boolean z) {
        this.cIr = z;
    }

    /* renamed from: fq */
    public void mo28761fq(boolean z) {
        if (this.cIt != null) {
            this.cIt.mo28690fk(z);
        }
    }

    /* renamed from: go */
    public void mo28762go(String str) {
        this.cwD = str;
    }

    /* renamed from: gt */
    public void mo28763gt(String str) {
        if (this.cww != null) {
            this.cww.mo35198a(this.bWd.getContext(), -1, this.cwF, bIV);
        }
        if (this.cIJ.mo28714hg(str)) {
            this.cIJ.mo28713gl(str);
        } else if (this.cIK.mo28702hg(str)) {
            this.cIK.mo28701gl(str);
        }
    }

    /* renamed from: gu */
    public void mo28764gu(String str) {
        this.cxw = str;
        int a = m17136a(this.cxE, str);
        if (this.cID != null) {
            this.cID.mo28542kP(a);
            this.cID.notifyDataSetChanged();
        }
    }

    /* renamed from: hl */
    public void mo28765hl(final String str) {
        C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                C6035i.this.cww.mo35198a(C6035i.this.bWd.getContext(), -1, C6035i.this.cwF, C6035i.bIV);
                C6035i.this.cIJ.mo28708a(C6035i.this.cww);
                C6035i.this.cIK.mo28697a(C6035i.this.cww);
                C6035i.this.cxF = new C8720b(C6035i.this.bWd.getContext());
                C6035i.this.cxE = C6035i.this.adx();
                mVar.mo9791K(Boolean.valueOf(true));
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) throws Exception {
                C6035i.this.add();
                C6035i.this.cIJ.mo28715hh(str);
                C6035i.this.cIK.mo28700fm(true);
                return Boolean.valueOf(true);
            }
        }).mo10164f(900, TimeUnit.MILLISECONDS).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                C6035i.this.compositeDisposable.mo9785e(bVar);
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                if (C6035i.this.cIy.getVisibility() == 0) {
                    if (C6035i.this.cIr || C6035i.this.cIs == 2) {
                        C6035i.this.ajy();
                    } else if (C6035i.this.cIs == 4) {
                        C6035i.this.cIt.mo28691kP(1);
                        C6035i.this.ajy();
                    } else if (!C6035i.this.ajR() && C6035i.this.cww != null && C6035i.this.cww.getCount() > 0) {
                        C6035i.this.ajy();
                    }
                    C6035i.this.cIs = 0;
                    C6035i.this.m17156i(C6035i.this.cxE);
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: mG */
    public void mo28766mG(int i) {
        this.cIs = i;
    }

    /* renamed from: v */
    public void mo28767v(String str, int i) {
        if (this.cIJ.mo28714hg(str)) {
            this.cIJ.mo28716v(str, i);
        } else if (this.cIK.mo28702hg(str)) {
            this.cIK.mo28703v(str, i);
        }
    }
}
