package com.introvd.template.editor.advance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.editor.R;
import com.introvd.template.editor.advance.C5605j.C5608c;
import com.introvd.template.editor.advance.ScaleRotateViewV4.C5579a;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p375r.p376a.C8360a.C8362a;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.model.editor.TextEffectParams;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8539p;
import com.introvd.template.template.model.StyleCatItemModel;
import com.introvd.template.template.model.TemplatePackageInfo;
import com.introvd.template.template.p404d.C8651b;
import com.introvd.template.template.p404d.C8653d;
import com.introvd.template.template.p404d.C8655f;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8738h;
import com.introvd.template.template.p407e.C8742k;
import com.introvd.template.template.p407e.C8743l;
import com.introvd.template.template.p407e.C8744m;
import com.introvd.template.template.p408f.C8746a;
import com.introvd.template.template.p408f.C8750d;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.xyui.StoryGridView;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import xiaoying.engine.QEngine;
import xiaoying.engine.clip.QEffect;

/* renamed from: com.introvd.template.editor.advance.k */
public class C5609k {
    OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (!C4580b.m11632Sf()) {
                if (view.equals(C5609k.this.cwP)) {
                    if (C5609k.this.cwE != null) {
                        C5609k.this.cwE.ace();
                    }
                } else if (view.equals(C5609k.this.cwQ) && C5609k.this.cwE != null) {
                    C5609k.this.cwE.acg();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public QEngine bPS = null;
    private RelativeLayout bWd;
    private RelativeLayout ctD;
    /* access modifiers changed from: private */
    public TextEffectParams cwA;
    private QEffect cwB = null;
    private boolean cwC = false;
    /* access modifiers changed from: private */
    public String cwD = "";
    /* access modifiers changed from: private */
    public C5599f cwE;
    private TemplateConditionModel cwF;
    /* access modifiers changed from: private */
    public ArrayList<StoryBoardItemInfo> cwG;
    private List<TemplateInfo> cwH = new ArrayList();
    private StoryGridView cwI;
    /* access modifiers changed from: private */
    public C5598e cwJ;
    private RecyclerView cwK;
    /* access modifiers changed from: private */
    public C5597d cwL = null;
    /* access modifiers changed from: private */
    public C5593c cwM;
    private LinearLayoutManager cwN;
    private RelativeLayout cwO;
    /* access modifiers changed from: private */
    public RelativeLayout cwP;
    /* access modifiers changed from: private */
    public ImageButton cwQ;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwR;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwS;
    /* access modifiers changed from: private */
    public List<TemplatePackageInfo> cwT;
    private Map<String, List<Long>> cwU;
    /* access modifiers changed from: private */
    public ArrayList<StyleCatItemModel> cwV;
    /* access modifiers changed from: private */
    public C5581a cwW;
    private C8738h cwX = new C8738h();
    public ScaleRotateViewV4 cwY;
    /* access modifiers changed from: private */
    public int cwZ = -1;
    /* access modifiers changed from: private */
    public ScaleRotateViewState cwh;
    /* access modifiers changed from: private */
    public C8759b cww = new C8759b(5);
    private MSize cwx;
    /* access modifiers changed from: private */
    public String cwy = "";
    private C5653p cwz = new C5653p();
    /* access modifiers changed from: private */
    public int cxa = -1;
    /* access modifiers changed from: private */
    public int cxb = -1;
    /* access modifiers changed from: private */
    public String cxc = null;
    private C5604i cxd = new C5604i() {
        /* renamed from: c */
        public void mo27540c(int i, Object obj) {
            if (!C4580b.m11632Sf() && i != C5609k.this.cxa) {
                C5609k.this.cxc = "";
                TemplateInfo templateInfo = (TemplateInfo) obj;
                if (templateInfo != null) {
                    EffectInfoModel effectInfoModel = new EffectInfoModel();
                    effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
                    effectInfoModel.setmUrl(templateInfo.strUrl);
                    effectInfoModel.mName = templateInfo.strTitle;
                    if (C5609k.this.cwE != null) {
                        if (!C5609k.this.cwE.aci()) {
                            C5609k.this.cwE.onItemClicked(i);
                        } else {
                            return;
                        }
                    }
                    C5609k.this.adp();
                    if (C5609k.this.cwM != null) {
                        C5609k.this.cwM.mo27526gf(templateInfo.ttid);
                        C5609k.this.cwM.notifyDataSetChanged();
                    }
                    if (C5609k.this.cww != null) {
                        C5609k.this.cwZ = C5609k.this.cww.mo35205bx(effectInfoModel.mTemplateId);
                    }
                    C5609k.this.m15396ak("VE_Sticker_Show", C8450a.m24469bn(effectInfoModel.mTemplateId));
                    C5609k.this.cxa = i;
                    C5609k.this.mo27603a(C5609k.this.adr(), (QEffect) null, true);
                    if (C5609k.this.cwE != null) {
                        C5609k.this.cwA = null;
                        if (C5609k.this.cwY != null) {
                            C5609k.this.cwA = C5609k.m15399b(C5609k.this.cwY.getScaleViewState());
                        }
                        C5609k.this.cwE.mo27421a(C5609k.this.cwA);
                    }
                }
            }
        }

        /* renamed from: d */
        public void mo27541d(int i, Object obj) {
        }

        /* renamed from: e */
        public boolean mo27542e(int i, Object obj) {
            if (!C4600l.m11739k(C5609k.this.mContext, true)) {
                return false;
            }
            TemplateInfo templateInfo = (TemplateInfo) obj;
            if (templateInfo != null) {
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
                effectInfoModel.setmUrl(templateInfo.strUrl);
                effectInfoModel.mName = templateInfo.strTitle;
                if (C5609k.this.cwE != null) {
                    C5609k.this.cwE.mo27428b(effectInfoModel);
                }
                C5609k.this.mo27602a(templateInfo, i);
            }
            return true;
        }
    };
    private C8362a cxe = new C8362a() {
        /* renamed from: z */
        public void mo27631z(View view, int i) {
            C5609k.this.cxb = i;
            if (C5609k.this.cwJ != null) {
                C5609k.this.cwJ.mo27533kP(C5609k.this.cxb);
                C5609k.this.cwJ.notifyDataSetChanged();
            }
            C5609k.this.m15409el(false);
            StyleCatItemModel styleCatItemModel = (StyleCatItemModel) C5609k.this.cwV.get(C5609k.this.cxb);
            if (styleCatItemModel.type == 0 || styleCatItemModel.type == 2) {
                C5609k.this.cwW.ack();
            } else if (styleCatItemModel.type == 1) {
                String d = C5609k.this.m15419kT(C5609k.this.cxb);
                C5609k.this.cwW.mo27472a(C5609k.this.mContext, false, C8762d.m25613a(d, (List<TemplateInfo>[]) new List[]{C5609k.this.cwS, C5609k.this.cwR}), d);
            }
        }
    };
    private C8362a cxf = new C8362a() {
        /* renamed from: z */
        public void mo27631z(View view, int i) {
            if (!(C4580b.m11632Sf() || C5609k.this.cwG == null || i == C5609k.this.cxa)) {
                StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) C5609k.this.cwG.get(i);
                if (storyBoardItemInfo != null) {
                    EffectInfoModel effectInfoModel = storyBoardItemInfo.mEffectInfo;
                    if (effectInfoModel != null && effectInfoModel.isbNeedDownload()) {
                        if (C5609k.this.cwE != null) {
                            C5609k.this.cwE.mo27428b(effectInfoModel);
                        }
                        return;
                    }
                }
                if (C5609k.this.cwE != null) {
                    if (!C5609k.this.cwE.aci()) {
                        C5609k.this.cwE.onItemClicked(i);
                    } else {
                        return;
                    }
                }
                C5609k.this.adp();
                if (C5609k.this.cwL != null) {
                    C5609k.this.cwL.mo27533kP(i);
                    C5609k.this.cwL.acE();
                }
                if (!(storyBoardItemInfo == null || storyBoardItemInfo.mEffectInfo == null)) {
                    C5609k.this.cxc = "";
                    if (C5609k.this.cww != null) {
                        C5609k.this.cwZ = C5609k.this.cww.mo35205bx(storyBoardItemInfo.mEffectInfo.mTemplateId);
                        if (C5609k.this.cwZ < 0) {
                            C5609k.this.cxc = storyBoardItemInfo.mEffectInfo.mPath;
                        }
                    }
                    C5609k.this.m15396ak("VE_Sticker_Show", TextUtils.isEmpty(C5609k.this.cxc) ^ true ? "giphy" : C8450a.m24469bn(storyBoardItemInfo.mEffectInfo.mTemplateId));
                }
                C5609k.this.cxa = i;
                C5609k.this.mo27603a(C5609k.this.adr(), (QEffect) null, true);
                if (C5609k.this.cwE != null) {
                    C5609k.this.cwA = null;
                    if (C5609k.this.cwY != null) {
                        C5609k.this.cwA = C5609k.m15399b(C5609k.this.cwY.getScaleViewState());
                    }
                    C5609k.this.cwE.mo27421a(C5609k.this.cwA);
                }
            }
        }
    };
    private C5608c cxg = new C5608c() {
        public void aan() {
            if (C5609k.this.cwE != null) {
                C5609k.this.cwE.ach();
            }
            C5609k.this.cwZ = -1;
            C5609k.this.cxa = -1;
            C5609k.this.cwy = "";
            C5609k.this.cxc = "";
            C5609k.this.cwD = "";
            C5609k.this.adl();
            if (C5609k.this.cwL != null) {
                C5609k.this.cwL.mo27533kP(C5609k.this.cxa);
                C5609k.this.cwL.acE();
            }
            if (C5609k.this.cwM != null) {
                C5609k.this.cwM.mo27526gf("");
                C5609k.this.cwM.notifyDataSetChanged();
            }
        }

        /* renamed from: eg */
        public void mo27599eg(boolean z) {
            C5609k.this.adg();
            ScaleRotateViewState scaleViewState = C5609k.this.cwY.getScaleViewState();
            scaleViewState.mBitmap = C5609k.this.cwh.mBitmap;
            C5609k.this.cwh = scaleViewState;
            if (C5609k.this.cwY != null) {
                if (z) {
                    C5609k.this.cwh.setVerFlip(!C5609k.this.cwh.isVerFlip);
                } else {
                    C5609k.this.cwh.setHorFlip(!C5609k.this.cwh.isHorFlip);
                }
                C5609k.this.cwY.setScaleViewState(C5609k.this.cwh);
                C5609k.this.cwY.invalidate();
                if (C5609k.this.cwE != null) {
                    C5609k.this.cwE.acf();
                }
                UserBehaviorLog.onKVEvent(C5609k.this.mContext.getApplicationContext(), "VE_Title_Flip", new HashMap());
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean cxh = false;
    private C5579a cxi = new C5579a() {
        /* renamed from: A */
        public void mo27462A(MotionEvent motionEvent) {
            if (C5609k.this.cwE != null) {
                C5609k.this.cwE.onSingleTapUp(motionEvent);
            }
        }

        /* renamed from: B */
        public void mo27463B(MotionEvent motionEvent) {
        }

        public void ada() {
            C5609k.this.cxh = false;
        }

        public void adb() {
            LogUtils.m14223i("SubtitleAddViewManager", "onCenterSingleTaped");
            if (C5609k.this.ads() && C5609k.this.cwE != null) {
                C5609k.this.cwE.mo27432v(null);
            }
        }

        /* renamed from: ei */
        public void mo27466ei(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("onUpOp bNeedUpdateThumb=");
            sb.append(z);
            LogUtils.m14223i("SubtitleAddViewManager", sb.toString());
            if (C5609k.this.cxh && C5609k.this.cwE != null) {
                C5609k.this.cwE.acf();
            }
        }

        /* renamed from: ej */
        public void mo27467ej(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("onMoveOp bNeedUpdateThumb=");
            sb.append(z);
            LogUtils.m14223i("SubtitleAddViewManager", sb.toString());
            C5609k.this.cxh = true;
        }
    };
    private OnClickListener cxj = new OnClickListener() {
        public void onClick(View view) {
            TemplateInfo a = C8762d.m25613a(C5609k.this.m15419kT(C5609k.this.cxb), (List<TemplateInfo>[]) new List[]{C5609k.this.cwS, C5609k.this.cwR});
            if (C5609k.this.cwE != null && a != null) {
                C5609k.this.cwE.mo27422a((RollInfo) a);
            }
        }
    };
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new C5622a(this);

    /* renamed from: com.introvd.template.editor.advance.k$a */
    private static class C5622a extends WeakHandler<C5609k> {
        public C5622a(C5609k kVar) {
            super(kVar);
        }

        public void handleMessage(Message message) {
            C5609k kVar = (C5609k) getOwner();
            if (kVar != null) {
                int i = message.what;
                boolean z = true;
                if (i != 10001) {
                    switch (i) {
                        case 10005:
                            if (message.arg1 != 1) {
                                z = false;
                            }
                            kVar.cwT = C8742k.aMi().mo35177cG(kVar.mContext, "cover_sticker");
                            kVar.mo27623p(false, z);
                            break;
                        case 10006:
                            if (kVar.cwL != null) {
                                kVar.cwL.mo27534kQ(message.arg1);
                                break;
                            }
                            break;
                    }
                } else {
                    kVar.mo27603a(kVar.adr(), (QEffect) null, true);
                }
            }
        }
    }

    public C5609k(RelativeLayout relativeLayout, MSize mSize, TemplateConditionModel templateConditionModel) {
        this.bWd = relativeLayout;
        this.mContext = this.bWd.getContext();
        this.cwx = mSize;
        this.cwF = templateConditionModel;
        this.cww.mo35198a(relativeLayout.getContext(), -1, templateConditionModel, AppStateModel.getInstance().isInChina());
        initUI();
        adf();
    }

    /* renamed from: G */
    private void m15386G(int i, boolean z) {
        this.cwH.clear();
        this.cwM.mo27525ay(this.cwH);
        this.cwT = C8742k.aMi().mo35177cG(this.mContext, "cover_sticker");
        if (C8655f.aKE().aKF()) {
            i--;
        }
        if (i >= 0 && i < this.cwT.size()) {
            TemplatePackageInfo templatePackageInfo = (TemplatePackageInfo) this.cwT.get(i);
            if (templatePackageInfo != null) {
                C8742k.aMi().mo35178cz(this.mContext, templatePackageInfo.strGroupCode);
                this.cwH = C8742k.aMi().mo35183qt(templatePackageInfo.strGroupCode);
                int i2 = 0;
                if (this.cwH != null && this.cwH.size() > 0 && this.cwM != null) {
                    this.cwM.mo27525ay(this.cwH);
                    for (TemplateInfo templateInfo : this.cwH) {
                        if (templateInfo != null) {
                            EffectInfoModel bw = this.cww.mo35204bw(C2575a.m7391rq(templateInfo.ttid));
                            if (bw != null && TextUtils.equals(this.cww.mo35210qG(this.cwZ), bw.mPath) && this.cwZ >= 0) {
                                this.cxa = i2;
                                if (this.cwM != null) {
                                    this.cwM.mo27526gf(templateInfo.ttid);
                                    this.cwM.notifyDataSetChanged();
                                    this.cwK.smoothScrollToPosition(this.cxa);
                                }
                            }
                            i2++;
                        }
                    }
                } else if (!z && C4600l.m11739k(this.mContext, false)) {
                    m15414gq(templatePackageInfo.strGroupCode);
                }
            }
        }
    }

    /* renamed from: a */
    private void m15395a(final List<StoryBoardItemInfo> list, final C8651b bVar) {
        if (this.executorService != null && !this.executorService.isShutdown()) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) list.get(i);
                        if (storyBoardItemInfo.bmpThumbnail == null) {
                            float f = (float) 80;
                            Bitmap a = C8539p.m24891a(storyBoardItemInfo.mEffectInfo.mPath, 0, f, f, C5609k.this.bPS);
                            if (a != null && C5609k.this.cxb >= 0 && C5609k.this.cxb < C5609k.this.cwV.size()) {
                                if ("Giphy".equals(C5609k.this.m15419kT(C5609k.this.cxb))) {
                                    storyBoardItemInfo.bmpThumbnail = a;
                                    if (bVar != null) {
                                        bVar.mo27628cm(i, 10);
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    private void adf() {
        this.cwY = new ScaleRotateViewV4(this.mContext);
        this.cwY.setEnableFlip(true);
        this.cwY.setLayoutParams(new LayoutParams(-1, -1));
        this.ctD.addView(this.cwY);
        Resources resources = this.mContext.getResources();
        Drawable drawable = resources.getDrawable(R.drawable.v4_xiaoying_com_btn_text_zoom_drawable_selector);
        Drawable drawable2 = resources.getDrawable(R.drawable.v4_xiaoying_ve_subtitle_horflip_btn_selector);
        Drawable drawable3 = resources.getDrawable(R.drawable.v4_xiaoying_ve_subtitle_verflip_btn_selector);
        Drawable drawable4 = resources.getDrawable(R.drawable.xiaoying_ve_text_del_icon);
        this.cwY.setFlipDrawable(drawable2, drawable3);
        this.cwY.setAnchorDrawable(drawable, drawable4);
        this.cwY.setmOnGestureListener(this.cxi);
        this.cwY.setDelListener(this.cxg);
    }

    /* access modifiers changed from: private */
    public void adg() {
        if (this.cwY != null && this.cwY.getVisibility() == 0) {
            ScaleRotateViewState scaleViewState = this.cwY.getScaleViewState();
            if (scaleViewState != null && this.cwz != null) {
                this.cwD = adr();
                mo27601a(scaleViewState, this.cwD);
            }
        }
    }

    private void adh() {
        if (this.cww != null) {
            this.cwZ = this.cww.mo35208qC(this.cwD);
            if (this.cwZ < 0) {
                this.cxc = this.cwD;
            }
        }
    }

    private void adi() {
        if (this.cwK != null) {
            this.cwV = new ArrayList<>();
            if (C8655f.aKE().aKF()) {
                this.cwV.add(0, new StyleCatItemModel(2, "Giphy"));
            }
            this.cwT = C8742k.aMi().mo35177cG(this.mContext, "cover_sticker");
            for (TemplatePackageInfo templatePackageInfo : this.cwT) {
                this.cwV.add(new StyleCatItemModel(0, templatePackageInfo.strGroupCode));
            }
            if (this.cwX.mo35167hh(this.mContext) > 0) {
                this.cwV.add(new StyleCatItemModel(1, "sticker_test/"));
            }
            this.cwR = C8735f.aMf().mo35151qk(C8399c.ede);
            this.cwS = C8743l.m25552cI(this.mContext, C8399c.ede);
            List b = C8746a.m25568b(this.cwS, false, true);
            StyleCatItemModel styleCatItemModel = new StyleCatItemModel(1, "20160224184733");
            if (!b.contains(styleCatItemModel)) {
                this.cwV.add(styleCatItemModel);
            }
            this.cwV.addAll(b);
            List b2 = C8746a.m25568b(this.cwR, true, true);
            b2.removeAll(b);
            this.cwV.addAll(b2);
            this.cwU = new HashMap();
            if (C2561a.aOR() == 1) {
                this.cwU.put("20160224184733", C8744m.etu);
            }
            Iterator it = this.cwV.iterator();
            while (it.hasNext()) {
                StyleCatItemModel styleCatItemModel2 = (StyleCatItemModel) it.next();
                if (styleCatItemModel2.type == 0) {
                    m15401b(this.cwU, styleCatItemModel2.ttid);
                } else if (styleCatItemModel2.type == 1) {
                    if ("sticker_test/".equals(styleCatItemModel2.ttid)) {
                        this.cwU.put("sticker_test/", this.cwX.mo35172hm(this.mContext));
                    } else {
                        C8746a.m25570c(this.cwU, styleCatItemModel2.ttid);
                    }
                }
            }
            if (this.cwU != null && this.cwU.size() > 0) {
                Iterator it2 = this.cwV.iterator();
                while (it2.hasNext()) {
                    StyleCatItemModel styleCatItemModel3 = (StyleCatItemModel) it2.next();
                    if (styleCatItemModel3.type == 0) {
                        styleCatItemModel3.strPath = C8746a.m25565a(this.cwT, styleCatItemModel3.ttid, styleCatItemModel3.strPath);
                    }
                }
                if (this.cwJ != null) {
                    this.cwJ.mItemInfoList = this.cwV;
                } else {
                    this.cwJ = new C5598e(this.mContext, this.cwV);
                }
                if (this.cwI != null) {
                    this.cwI.setAdapter(this.cwJ);
                    this.cwJ.mo33617a(this.cxe);
                }
            }
            if (this.cwK != null) {
                this.cwK.setAdapter(this.cwM);
                this.cwM.mo27524a(this.cxd);
            }
        }
    }

    private void adj() {
        if (this.cww != null && this.cwV != null) {
            EffectInfoModel vh = this.cww.mo35214vh(this.cwZ);
            if (vh == null && !TextUtils.isEmpty(this.cxc)) {
                this.cxb = 0;
            } else if (vh != null) {
                this.cxb = C8746a.m25564a(vh.mTemplateId, (List<StyleCatItemModel>) this.cwV, this.cwU);
            } else {
                this.cxb = 0;
            }
            String kT = m15419kT(this.cxb);
            if (m15413gp(kT)) {
                this.cwW.ack();
            } else {
                this.cwW.mo27472a(this.mContext, false, C8762d.m25613a(kT, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}), kT);
            }
            this.cwI.scrollToPosition(this.cxb);
            this.cwJ.mo27533kP(this.cxb);
        }
    }

    private void ado() {
        if (this.cwh != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("state:");
            sb.append(this.cwh);
            LogUtils.m14223i("SubtitleAddViewManager", sb.toString());
            this.cwY.setScaleViewState(this.cwh);
            this.cwY.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void adp() {
        this.cwh = null;
        this.cwz.cxX = new PointF();
        this.cwz.mAngle = 0.0f;
        this.cwz.cvt = 1.0f;
        this.cwz.cxZ = Integer.valueOf(0);
        this.cwz.cya = "";
        this.cwz.cxY = "";
    }

    /* access modifiers changed from: private */
    public String adr() {
        int i = this.cwZ;
        return i < 0 ? this.cxc : this.cww.mo35210qG(i);
    }

    private void adt() {
        int i = 0;
        if (C8746a.etx == null || C8746a.etx.size() < 1) {
            if (C8746a.etx == null) {
                C8746a.etx = new ArrayList<>();
            }
            String[] aKG = C8655f.aKE().aKG();
            if (aKG != null) {
                int length = aKG.length;
                int i2 = 0;
                while (i < length) {
                    StoryBoardItemInfo qy = C8750d.m25574qy(aKG[i]);
                    if (qy.mEffectInfo != null && TextUtils.equals(this.cxc, qy.mEffectInfo.mPath)) {
                        this.cxa = i2;
                    }
                    C8746a.etx.add(qy);
                    i2++;
                    i++;
                }
            }
        } else {
            Iterator it = C8746a.etx.iterator();
            while (it.hasNext()) {
                StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) it.next();
                if (storyBoardItemInfo.mEffectInfo != null && TextUtils.equals(this.cxc, storyBoardItemInfo.mEffectInfo.mPath)) {
                    this.cxa = i;
                }
                i++;
            }
        }
        m15395a((List<StoryBoardItemInfo>) C8746a.etx, (C8651b) new C8651b() {
            /* renamed from: a */
            public void mo27626a(C8653d dVar) {
            }

            /* renamed from: aG */
            public void mo27627aG(List<C8653d> list) {
            }

            /* renamed from: cm */
            public void mo27628cm(int i, int i2) {
                if (C5609k.this.mHandler != null) {
                    Message obtainMessage = C5609k.this.mHandler.obtainMessage(10006);
                    obtainMessage.arg1 = i;
                    obtainMessage.arg2 = i2;
                    C5609k.this.mHandler.sendMessage(obtainMessage);
                }
            }
        });
        this.cwG.clear();
        this.cwG.addAll(C8746a.etx);
    }

    /* access modifiers changed from: private */
    /* renamed from: ak */
    public void m15396ak(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str2);
        UserBehaviorLog.onKVEvent(this.mContext, str, hashMap);
    }

    /* renamed from: b */
    public static TextEffectParams m15399b(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState == null) {
            return null;
        }
        String str = scaleRotateViewState.mStylePath;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        float f = scaleRotateViewState.mDegree;
        TextEffectParams textEffectParams = new TextEffectParams();
        textEffectParams.setVersion(scaleRotateViewState.mVersion);
        textEffectParams.setmAngle(f);
        textEffectParams.setmStyleDuration(scaleRotateViewState.mMinDuration);
        textEffectParams.setHorFlip(scaleRotateViewState.isHorFlip);
        textEffectParams.setVerFlip(scaleRotateViewState.isVerFlip);
        textEffectParams.setmEffectStylePath(str);
        textEffectParams.setmTextRangeLen(-1);
        textEffectParams.setApplyInWholeClip(true);
        textEffectParams.bShowStaticPicture = true;
        textEffectParams.setAnimOn(false);
        textEffectParams.setmTextRect(C8530i.m24763t(scaleRotateViewState));
        textEffectParams.setmTemplateId(C8762d.aMt().getTemplateID(str));
        return textEffectParams;
    }

    /* renamed from: b */
    private void m15401b(Map<String, List<Long>> map, String str) {
        C8742k.aMi().mo35178cz(this.mContext, str);
        List<TemplateInfo> qt = C8742k.aMi().mo35183qt(str);
        if (qt != null && !qt.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (TemplateInfo templateInfo : qt) {
                arrayList.add(Long.valueOf(C2575a.m7391rq(templateInfo.ttid)));
            }
            map.put(str, arrayList);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: el */
    public void m15409el(boolean z) {
        if (this.cwG == null) {
            this.cwG = new ArrayList<>();
        } else {
            this.cwG.clear();
        }
        this.cxa = -1;
        if (this.cwM != null) {
            this.cwM.mo27526gf("");
            this.cwM.notifyDataSetChanged();
        }
        if (this.cwV != null && this.cxb >= 0 && this.cxb < this.cwV.size()) {
            StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cwV.get(this.cxb);
            if (styleCatItemModel != null) {
                String kT = m15419kT(this.cxb);
                if (styleCatItemModel.type == 2) {
                    adt();
                    this.cwL.mo33617a(this.cxf);
                    this.cwK.setAdapter(this.cwL);
                    this.cwL.mo27533kP(this.cxa);
                    this.cwL.mo27532h(this.cwG);
                    if (this.cxa >= 0) {
                        this.cwK.smoothScrollToPosition(this.cxa);
                    }
                } else if (styleCatItemModel.type == 0) {
                    this.cwK.setAdapter(this.cwM);
                    m15386G(this.cxb, z);
                } else if (styleCatItemModel.type == 1) {
                    List<Long> list = (List) this.cwU.get(kT);
                    if (this.cww == null || list == null || list.size() <= 0) {
                        C8746a.m25567a(this.cwG, this.cwR, this.cwS, kT);
                    } else {
                        int i = 0;
                        for (Long l : list) {
                            StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
                            storyBoardItemInfo.mEffectInfo = this.cww.mo35204bw(l.longValue());
                            Bitmap bz = this.cww.mo35206bz(l.longValue());
                            if (bz != null) {
                                storyBoardItemInfo.bmpThumbnail = bz;
                            } else {
                                storyBoardItemInfo.coverUrl = C8762d.aMt().getTemplateExternalFile(l.longValue(), 0, 3);
                            }
                            storyBoardItemInfo.isVideo = false;
                            storyBoardItemInfo.lDuration = 0;
                            this.cwG.add(storyBoardItemInfo);
                            if (storyBoardItemInfo.mEffectInfo != null && TextUtils.equals(this.cww.mo35210qG(this.cwZ), storyBoardItemInfo.mEffectInfo.mPath) && this.cwZ >= 0) {
                                this.cxa = i;
                            }
                            i++;
                        }
                    }
                    this.cwL.mo33617a(this.cxf);
                    this.cwK.setAdapter(this.cwL);
                    this.cwL.mo27533kP(this.cxa);
                    this.cwL.mo27532h(this.cwG);
                    if (this.cxa >= 0) {
                        this.cwK.scrollToPosition(this.cxa);
                    }
                }
            }
        }
    }

    @SuppressLint({"UseValueOf"})
    /* renamed from: gm */
    private boolean m15412gm(String str) {
        if (this.cwh == null) {
            return false;
        }
        Bitmap a = C8539p.m24891a(str, this.cwh.mExampleThumbPos, this.cwh.mFrameWidth, this.cwh.mFrameHeight, this.bPS);
        if (a != null) {
            this.cwh.mBitmap = a;
        }
        return true;
    }

    /* renamed from: gp */
    private boolean m15413gp(String str) {
        if (this.cwT == null || this.cwT.isEmpty()) {
            return false;
        }
        for (TemplatePackageInfo templatePackageInfo : this.cwT) {
            if (templatePackageInfo.strGroupCode.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0.size() > 0) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* renamed from: gq */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m15414gq(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00a2 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0019
            java.util.List<com.introvd.template.template.model.TemplatePackageInfo> r0 = r6.cwT     // Catch:{ all -> 0x00a2 }
            java.util.List r0 = com.introvd.template.template.p407e.C8742k.m25537db(r0)     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x0017
            int r0 = r0.size()     // Catch:{ all -> 0x00a2 }
            if (r0 > 0) goto L_0x002a
        L_0x0017:
            r1 = 1
            goto L_0x002a
        L_0x0019:
            com.introvd.template.template.e.k r0 = com.introvd.template.template.p407e.C8742k.aMi()     // Catch:{ all -> 0x00a2 }
            java.util.List r0 = r0.mo35183qt(r7)     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x0017
            int r0 = r0.size()     // Catch:{ all -> 0x00a2 }
            if (r0 > 0) goto L_0x002a
            goto L_0x0017
        L_0x002a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r0.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "key_pref_cover_sticker_refresh_last_time"
            r0.append(r2)     // Catch:{ all -> 0x00a2 }
            r0.append(r7)     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a2 }
            com.introvd.template.common.AppPreferencesSetting r2 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ all -> 0x00a2 }
            java.lang.String r3 = ""
            java.lang.String r2 = r2.getAppSettingStr(r0, r3)     // Catch:{ all -> 0x00a2 }
            if (r1 != 0) goto L_0x006f
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a2 }
            if (r1 != 0) goto L_0x006f
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a2 }
            long r1 = com.p131c.p132a.p135c.C2575a.parseLong(r2)     // Catch:{ all -> 0x00a2 }
            r5 = 0
            long r3 = r3 - r1
            long r1 = java.lang.Math.abs(r3)     // Catch:{ all -> 0x00a2 }
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0063
            goto L_0x006f
        L_0x0063:
            android.os.Handler r7 = r6.mHandler     // Catch:{ all -> 0x00a2 }
            if (r7 == 0) goto L_0x00a0
            android.os.Handler r7 = r6.mHandler     // Catch:{ all -> 0x00a2 }
            r0 = 10005(0x2715, float:1.402E-41)
            r7.sendEmptyMessage(r0)     // Catch:{ all -> 0x00a2 }
            goto L_0x00a0
        L_0x006f:
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x008d
            com.introvd.template.q.f r7 = com.introvd.template.p374q.C8347f.aKf()     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = "template.packages.info"
            com.introvd.template.editor.advance.k$3 r2 = new com.introvd.template.editor.advance.k$3     // Catch:{ all -> 0x00a2 }
            r2.<init>(r0)     // Catch:{ all -> 0x00a2 }
            r7.mo33601a(r1, r2)     // Catch:{ all -> 0x00a2 }
            android.content.Context r7 = r6.mContext     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = ""
            java.lang.String r1 = "cover_sticker"
            com.introvd.template.p374q.C8346e.m24071T(r7, r0, r1)     // Catch:{ all -> 0x00a2 }
            goto L_0x00a0
        L_0x008d:
            com.introvd.template.q.f r1 = com.introvd.template.p374q.C8347f.aKf()     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "template.packages.detail"
            com.introvd.template.editor.advance.k$4 r3 = new com.introvd.template.editor.advance.k$4     // Catch:{ all -> 0x00a2 }
            r3.<init>(r0)     // Catch:{ all -> 0x00a2 }
            r1.mo33601a(r2, r3)     // Catch:{ all -> 0x00a2 }
            android.content.Context r0 = r6.mContext     // Catch:{ all -> 0x00a2 }
            com.introvd.template.p374q.C8346e.m24075cq(r0, r7)     // Catch:{ all -> 0x00a2 }
        L_0x00a0:
            monitor-exit(r6)
            return
        L_0x00a2:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.C5609k.m15414gq(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: kT */
    public String m15419kT(int i) {
        if (this.cwV == null || this.cwV.isEmpty() || i < 0) {
            return "";
        }
        StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cwV.get(i);
        return styleCatItemModel != null ? styleCatItemModel.ttid : "";
    }

    /* renamed from: x */
    private float m15432x(float f, float f2) {
        float f3 = f2 / 2.0f;
        return f - f3 < 0.0f ? f3 : f + f3 > ((float) this.cwx.width) ? ((float) this.cwx.width) - f3 : f;
    }

    /* renamed from: y */
    private float m15434y(float f, float f2) {
        float f3 = f2 / 2.0f;
        return f - f3 < 0.0f ? f3 : f + f3 > ((float) this.cwx.height) ? ((float) this.cwx.height) - f3 : f;
    }

    /* renamed from: a */
    public void mo27600a(C5599f fVar) {
        this.cwE = fVar;
    }

    /* renamed from: a */
    public void mo27601a(ScaleRotateViewState scaleRotateViewState, String str) {
        float f;
        if (this.cwz != null && FileUtils.isFileExisted(str)) {
            if (this.cwz.cxX == null) {
                this.cwz.cxX = new PointF();
            }
            if (scaleRotateViewState != null) {
                this.cwz.cxX.x = scaleRotateViewState.mPosInfo.getmCenterPosX();
                this.cwz.cxX.y = scaleRotateViewState.mPosInfo.getmCenterPosY();
                this.cwz.mAngle = scaleRotateViewState.mDegree;
            }
            ScaleRotateViewState b = C8530i.m24759b(this.bPS, str, new VeMSize(this.cwx.width, this.cwx.height));
            if (b != null) {
                f = b.mPosInfo.getmHeight();
                b.mMinDuration = C8538o.m24841N(str, b.mMinDuration);
            } else {
                f = 0.0f;
            }
            if (scaleRotateViewState != null) {
                float f2 = scaleRotateViewState.mPosInfo.getmHeight();
                if (scaleRotateViewState.isDftTemplate && scaleRotateViewState.mLineNum > 0) {
                    f2 = scaleRotateViewState.mPosInfo.getmHeight() / ((float) scaleRotateViewState.mLineNum);
                }
                if (f > 0.0f && f2 > 0.0f) {
                    this.cwz.cvt = f / f2;
                }
            }
            this.cwz.cxY = str;
        }
    }

    /* renamed from: a */
    public void mo27602a(TemplateInfo templateInfo, int i) {
        if (templateInfo != null) {
            int indexOf = this.cwH.indexOf(templateInfo);
            if (indexOf >= 0) {
                TemplateInfo templateInfo2 = (TemplateInfo) this.cwH.get(indexOf);
                if (templateInfo2 != null && templateInfo2.nState == 1) {
                    templateInfo2.nState = 8;
                    this.cwM.mo27525ay(this.cwH);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo27603a(String str, QEffect qEffect, boolean z) {
        if (this.cwY != null) {
            if (qEffect == null) {
                this.cwh = C8530i.m24759b(this.bPS, str, new VeMSize(this.cwx.width, this.cwx.height));
                if (this.cwh != null) {
                    if (this.cwz != null) {
                        if (this.cwz.cxX == null || (this.cwz.cxX.x == 0.0f && this.cwz.cxX.y == 0.0f)) {
                            Random random = new Random();
                            float x = m15432x(((float) (this.cwx.width / 2)) + (((random.nextFloat() * ((float) this.cwx.width)) / 2.0f) - ((float) (this.cwx.width / 4))), this.cwh.mPosInfo.getmWidth());
                            float y = m15434y(((float) (this.cwx.height / 2)) + (((random.nextFloat() * ((float) this.cwx.height)) / 2.0f) - ((float) (this.cwx.height / 4))), this.cwh.mPosInfo.getmHeight());
                            this.cwh.mPosInfo.setmCenterPosX(x);
                            this.cwh.mPosInfo.setmCenterPosY(y);
                        } else {
                            this.cwh.mPosInfo.setmCenterPosX(this.cwz.cxX.x);
                            this.cwh.mPosInfo.setmCenterPosY(this.cwz.cxX.y);
                        }
                        this.cwh.mDegree = this.cwz.mAngle;
                        if (this.cwz.cvt > 0.0f) {
                            this.cwh.mPosInfo.setmWidth((float) ((int) (this.cwh.mPosInfo.getmWidth() / this.cwz.cvt)));
                            this.cwh.mPosInfo.setmHeight((float) ((int) (this.cwh.mPosInfo.getmHeight() / this.cwz.cvt)));
                        }
                        if (z && TextUtils.equals(str, this.cwz.cxY)) {
                            this.cwh.setTextColor(this.cwz.cxZ.intValue());
                        }
                        this.cwh.setAnimOn(this.cwz.cyc.booleanValue());
                    }
                    if (this.cwY != null) {
                        if (m15412gm(str)) {
                            ado();
                        } else {
                            ToastUtils.show(this.mContext, R.string.xiaoying_str_ve_msg_not_support_ttf, 0);
                            if (this.cwE != null) {
                                this.cwE.mo27429dU(true);
                            }
                        }
                    }
                } else {
                    if (this.cwY != null) {
                        this.cwY.setVisibility(4);
                    }
                    adp();
                }
                this.cwD = str;
            } else {
                adp();
                VeMSize veMSize = new VeMSize(this.cwx.width, this.cwx.height);
                this.cwh = C8538o.m24851a(qEffect, veMSize);
                String e = C8538o.m24872e(qEffect);
                ScaleRotateViewState b = C8530i.m24759b(this.bPS, e, veMSize);
                this.cwh.mFrameWidth = b.mFrameWidth;
                this.cwh.mFrameHeight = b.mFrameHeight;
                this.cwh.mExampleThumbPos = b.mExampleThumbPos;
                if (m15412gm(e)) {
                    ado();
                } else {
                    ToastUtils.show(this.mContext, R.string.xiaoying_str_ve_msg_not_support_ttf, 0);
                    if (this.cwE != null) {
                        this.cwE.mo27429dU(true);
                    }
                }
                this.cwD = e;
            }
        }
    }

    /* renamed from: a */
    public void mo27604a(QEngine qEngine) {
        this.bPS = qEngine;
    }

    public void adc() {
        add();
        adi();
        adj();
        m15409el(false);
        m15414gq("");
    }

    public void add() {
        if (!TextUtils.isEmpty(this.cwy)) {
            if (!C8750d.m25573jM(this.cwy) || !C8655f.aKE().aKF()) {
                this.cwZ = this.cww.mo35208qC(this.cwy);
                if (this.cwZ < 0) {
                    this.cwZ = this.cww.aMs();
                    return;
                }
                return;
            }
            this.cxc = this.cwy;
            this.cwZ = -1;
        } else if (C8655f.aKE().aKF()) {
            String[] aKG = C8655f.aKE().aKG();
            if (aKG != null) {
                this.cxc = aKG[0];
            }
        } else {
            this.cwZ = 0;
        }
    }

    public void ade() {
        if (this.cwY != null) {
            this.ctD.removeView(this.cwY);
            this.cwY = null;
        }
        if (this.cwK != null) {
            this.cwK.setAdapter(null);
            this.cwK = null;
        }
        this.cwO.setVisibility(4);
        if (this.cww != null) {
            this.cww.unInit(true);
        }
        if (this.executorService != null) {
            this.executorService.shutdown();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    public void adk() {
        C4562a.m11534b(this.cwO, true, true, 0);
    }

    public void adl() {
        if (this.cwY != null) {
            this.cwY.setVisibility(4);
        }
    }

    public boolean adm() {
        boolean z = false;
        if (this.cwY == null) {
            return false;
        }
        if (this.cwY.getVisibility() == 0) {
            z = true;
        }
        return z;
    }

    public void adn() {
        this.cwy = "";
        this.cwZ = -1;
        this.cxa = -1;
        if (this.cwL != null) {
            this.cwL.mo27533kP(this.cxa);
            this.cwL.acE();
        }
        if (this.cwM != null) {
            this.cwM.mo27526gf("");
            this.cwM.notifyDataSetChanged();
        }
    }

    public QEffect adq() {
        return this.cwB;
    }

    public boolean ads() {
        boolean z = true;
        if (this.cwO == null) {
            return true;
        }
        if (this.cwO.getVisibility() == 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: au */
    public boolean mo27614au(long j) {
        return C8762d.m25613a(String.valueOf(j), (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}) != null;
    }

    /* renamed from: b */
    public void mo27615b(QEffect qEffect) {
        this.cwB = qEffect;
    }

    /* renamed from: ek */
    public void mo27616ek(boolean z) {
        if (this.cww != null) {
            int count = this.cww.getCount();
            this.cww.mo35198a(this.mContext, -1, this.cwF, AppStateModel.getInstance().isInChina());
            if (count != this.cww.getCount() || z) {
                this.cwZ = this.cww.mo35208qC(this.cwD);
                if (this.cwZ < 0) {
                    this.cxc = this.cwD;
                }
                adi();
                adj();
                m15409el(false);
                return;
            }
            adh();
        }
    }

    /* renamed from: em */
    public void mo27617em(boolean z) {
        C4562a.m11534b(this.cwO, false, true, 0);
        if (z) {
            adl();
        }
    }

    /* renamed from: gk */
    public void mo27618gk(String str) {
        if (this.cww != null) {
            this.cww.mo35198a(this.mContext, -1, this.cwF, AppStateModel.getInstance().isInChina());
            adh();
        }
        String kT = m15419kT(this.cxb);
        if (m15413gp(kT)) {
            if (this.cwM != null) {
                this.cwM.mo27526gf(C8450a.m24469bn(C2575a.m7391rq(str)));
                this.cwM.notifyDataSetChanged();
            }
            this.cwW.ack();
            m15401b(this.cwU, str);
        } else {
            C8746a.m25570c(this.cwU, str);
            this.cwW.mo27472a(this.mContext, false, C8762d.m25613a(kT, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}), kT);
        }
        if (TextUtils.equals(str, kT)) {
            m15409el(false);
        }
    }

    /* renamed from: gl */
    public void mo27619gl(String str) {
        if (this.cww != null) {
            this.cww.mo35198a(this.mContext, -1, this.cwF, AppStateModel.getInstance().isInChina());
        }
        String kT = m15419kT(this.cxb);
        if (TextUtils.equals(str, kT)) {
            m15409el(false);
        }
        if (m15413gp(kT)) {
            this.cwW.ack();
            m15401b(this.cwU, str);
            return;
        }
        C8746a.m25570c(this.cwU, str);
        this.cwW.mo27472a(this.mContext, false, C8762d.m25613a(kT, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}), kT);
    }

    /* renamed from: gn */
    public void mo27620gn(String str) {
        this.cwy = str;
    }

    /* renamed from: go */
    public void mo27621go(String str) {
        this.cwD = str;
    }

    public final void initUI() {
        this.cwO = (RelativeLayout) this.bWd.findViewById(R.id.layout_sticker_list);
        this.ctD = (RelativeLayout) this.bWd.findViewById(R.id.preview_layout_fake);
        this.cwK = (RecyclerView) this.bWd.findViewById(R.id.recycler_view_cover_package);
        this.cwN = new LinearLayoutManager(this.mContext, 0, false);
        this.cwK.setLayoutManager(this.cwN);
        this.cwK.mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                rect.left = C4583d.m11670O(C5609k.this.mContext, 7);
                rect.right = C4583d.m11670O(C5609k.this.mContext, 7);
            }
        });
        this.cwP = (RelativeLayout) this.bWd.findViewById(R.id.layout_downloaded);
        this.cwQ = (ImageButton) this.bWd.findViewById(R.id.btn_giphy_download);
        this.cwI = (StoryGridView) this.bWd.findViewById(R.id.tab_listview);
        this.cwM = new C5593c(this.mContext);
        this.cwL = new C5597d(this.mContext);
        this.cwW = new C5581a((RelativeLayout) this.bWd.findViewById(R.id.relative_layout_roll_download), this.cxj);
        this.cwP.setOnClickListener(this.acD);
        this.cwQ.setOnClickListener(this.acD);
    }

    /* renamed from: p */
    public void mo27623p(boolean z, boolean z2) {
        this.cww.mo35198a(this.mContext, -1, this.cwF, AppStateModel.getInstance().isInChina());
        this.cwZ = this.cww.mo35208qC(this.cwD);
        if (this.cwZ < 0) {
            this.cxc = this.cwD;
        }
        adi();
        if (z) {
            adj();
        }
        m15409el(z2);
    }

    /* renamed from: v */
    public void mo27624v(String str, int i) {
        boolean z;
        if (this.cwV != null) {
            String kT = m15419kT(this.cxb);
            if (this.cwK != null && this.cxb >= 0 && this.cxb < this.cwV.size() && TextUtils.equals(kT, str)) {
                z = true;
                this.cwW.mo27474c(str, i, z);
            }
        }
        z = false;
        this.cwW.mo27474c(str, i, z);
    }
}
