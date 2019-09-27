package com.introvd.template.editor.advance;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.p024v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.facebook.places.model.PlaceFields;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.common.utils.UtilsBitmap;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.editor.R;
import com.introvd.template.editor.advance.C5583b.C5590c;
import com.introvd.template.editor.advance.C5583b.C5591d;
import com.introvd.template.editor.p245b.C5676g;
import com.introvd.template.editor.p266h.C6408m;
import com.introvd.template.editor.videotrim.p292ui.VeGallery2;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.PublishParams.DomeSocialPublishParams;
import com.introvd.template.router.parammodels.PickCoverParams;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextEffectParams;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.info.TemplateInfoActivity;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p408f.C8746a;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p055c.C1505b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QBitmapFactory;
import xiaoying.utils.QColorSpace;
import xiaoying.utils.QComUtils;

@C1942a(mo10417rZ = "/VideoEditor/pickcover")
public class AdvanceEditorPickCoverActivity extends AdvanceBaseEditActivity {
    private RelativeLayout bWd;
    /* access modifiers changed from: private */
    public ImageView bZM;
    private C5576a ctA = new C5576a(this);
    /* access modifiers changed from: private */
    public volatile boolean ctB = false;
    /* access modifiers changed from: private */
    public String ctC = "";
    private RelativeLayout ctD;
    /* access modifiers changed from: private */
    public C5583b ctE = null;
    /* access modifiers changed from: private */
    public int ctF = -1;
    private LinearLayout ctG;
    /* access modifiers changed from: private */
    public ImageView ctH;
    /* access modifiers changed from: private */
    public ImageView ctI;
    /* access modifiers changed from: private */
    public ImageView ctJ;
    /* access modifiers changed from: private */
    public ImageView ctK;
    /* access modifiers changed from: private */
    public RelativeLayout ctL;
    /* access modifiers changed from: private */
    public RelativeLayout ctM;
    /* access modifiers changed from: private */
    public ImageView ctN;
    /* access modifiers changed from: private */
    public C5609k ctO;
    /* access modifiers changed from: private */
    public C5626m ctP;
    /* access modifiers changed from: private */
    public boolean ctQ = false;
    /* access modifiers changed from: private */
    public boolean ctR = true;
    private boolean ctS = false;
    private C5590c ctT = new C5591d() {
        public void acd() {
            AdvanceEditorPickCoverActivity.this.abJ();
            AdvanceEditorPickCoverActivity.this.csy = false;
        }

        /* renamed from: iD */
        public void mo27415iD(int i) {
            if (AdvanceEditorPickCoverActivity.this.cst != null && AdvanceEditorPickCoverActivity.this.cst.isAlive()) {
                AdvanceEditorPickCoverActivity.this.cst.seekTo(i);
            }
        }

        /* renamed from: kz */
        public void mo27416kz(int i) {
            AdvanceEditorPickCoverActivity.this.isModified = true;
            if (AdvanceEditorPickCoverActivity.this.cso != null && AdvanceEditorPickCoverActivity.this.cso.isPlaying()) {
                AdvanceEditorPickCoverActivity.this.cso.pause();
            }
            AdvanceEditorPickCoverActivity.this.csy = true;
            AdvanceEditorPickCoverActivity.this.mo27373dO(false);
            if (AdvanceEditorPickCoverActivity.this.ctE != null && AdvanceEditorPickCoverActivity.this.ctE.acv()) {
                UserBehaviorLog.onKVEvent(AdvanceEditorPickCoverActivity.this, "VE_Dubbing_Finetune", new HashMap());
            } else if (AdvanceEditorPickCoverActivity.this.ctE != null) {
                AdvanceEditorPickCoverActivity.this.ctE.mo27496kK(-1);
            }
        }
    };
    private C5599f ctU = new C5599f() {
        /* renamed from: a */
        public void mo27421a(TextEffectParams textEffectParams) {
            if (textEffectParams != null && AdvanceEditorPickCoverActivity.this.cso != null && AdvanceEditorPickCoverActivity.this.csP != null) {
                AdvanceEditorPickCoverActivity.this.m15140a(textEffectParams, C6408m.m18453a(textEffectParams.getmTextRect(), AdvanceEditorPickCoverActivity.this.csP.width, AdvanceEditorPickCoverActivity.this.csP.height), 30);
            }
        }

        /* renamed from: a */
        public boolean mo27422a(RollInfo rollInfo) {
            AdvanceEditorPickCoverActivity.this.m15141a(rollInfo, "type_roll");
            return false;
        }

        public void ace() {
            AdvanceEditorPickCoverActivity.this.m15160gd(C8399c.ede);
        }

        public void acf() {
            TextEffectParams b = AdvanceEditorPickCoverActivity.this.ctO.cwY != null ? C5609k.m15399b(AdvanceEditorPickCoverActivity.this.ctO.cwY.getScaleViewState()) : null;
            if (b != null) {
                Rect a = C6408m.m18453a(b.getmTextRect(), AdvanceEditorPickCoverActivity.this.csP.width, AdvanceEditorPickCoverActivity.this.csP.height);
                if (AdvanceEditorPickCoverActivity.this.ctO.adq() != null) {
                    AdvanceEditorPickCoverActivity.this.m15128a(AdvanceEditorPickCoverActivity.this.mStoryBoard, b, a, 30);
                }
            }
        }

        public void acg() {
            AdvanceEditorPickCoverActivity.this.m15160gd("Giphy");
        }

        public void ach() {
            AdvanceEditorPickCoverActivity.this.mo27410kC(30);
        }

        public boolean aci() {
            return AdvanceEditorPickCoverActivity.this.acc();
        }

        /* renamed from: b */
        public void mo27428b(EffectInfoModel effectInfoModel) {
            if (effectInfoModel != null) {
                AdvanceEditorPickCoverActivity.this.bNB = effectInfoModel.mTemplateId;
                AdvanceEditorPickCoverActivity.this.mo27351a(effectInfoModel, "stickerItem");
            }
        }

        /* renamed from: dU */
        public void mo27429dU(boolean z) {
            AdvanceEditorPickCoverActivity.this.mo27411kD(30);
            if (z) {
                UserBehaviorLog.reportError(AdvanceEditorPickCoverActivity.this, "sticker bitmap is too big to create.");
            }
            AdvanceEditorPickCoverActivity.this.bNB = -1;
        }

        public void onItemClicked(int i) {
            AdvanceEditorPickCoverActivity.this.ctF = C8540q.m24958j(AdvanceEditorPickCoverActivity.this.mStoryBoard, 30);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (AdvanceEditorPickCoverActivity.this.ctF < 0) {
                return true;
            }
            return AdvanceEditorPickCoverActivity.this.m15175u(motionEvent);
        }

        /* renamed from: v */
        public boolean mo27432v(MotionEvent motionEvent) {
            return true;
        }
    };
    private C5599f ctV = new C5599f() {
        /* renamed from: a */
        public void mo27421a(TextEffectParams textEffectParams) {
            if (textEffectParams != null && AdvanceEditorPickCoverActivity.this.ctP != null && AdvanceEditorPickCoverActivity.this.csP != null) {
                AdvanceEditorPickCoverActivity.this.m15140a(textEffectParams, C6408m.m18453a(textEffectParams.getmTextRect(), AdvanceEditorPickCoverActivity.this.csP.width, AdvanceEditorPickCoverActivity.this.csP.height), 35);
            }
        }

        /* renamed from: a */
        public boolean mo27422a(RollInfo rollInfo) {
            if (rollInfo != null) {
                AdvanceEditorPickCoverActivity.this.m15141a(rollInfo, "type_roll");
            }
            return false;
        }

        public void ace() {
            AdvanceEditorPickCoverActivity.this.m15160gd(C8399c.edb);
        }

        public void acf() {
            if (AdvanceEditorPickCoverActivity.this.ctP.cwY != null) {
                TextEffectParams adz = AdvanceEditorPickCoverActivity.this.ctP.adz();
                if (adz != null) {
                    Rect a = C6408m.m18453a(adz.getmTextRect(), AdvanceEditorPickCoverActivity.this.csP.width, AdvanceEditorPickCoverActivity.this.csP.height);
                    QEffect adq = AdvanceEditorPickCoverActivity.this.ctP.adq();
                    if (adq != null) {
                        adz.setmTextAlignment(C8538o.m24882l(adq));
                        AdvanceEditorPickCoverActivity.this.m15128a(AdvanceEditorPickCoverActivity.this.mStoryBoard, adz, a, 35);
                    }
                }
            }
        }

        public void ach() {
            AdvanceEditorPickCoverActivity.this.mo27410kC(35);
        }

        public boolean aci() {
            return AdvanceEditorPickCoverActivity.this.acc();
        }

        public void acj() {
            if (AdvanceEditorPickCoverActivity.this.cso != null && AdvanceEditorPickCoverActivity.this.cso.isPlaying()) {
                AdvanceEditorPickCoverActivity.this.cso.pause();
            }
        }

        /* renamed from: b */
        public void mo27428b(EffectInfoModel effectInfoModel) {
            if (effectInfoModel != null) {
                AdvanceEditorPickCoverActivity.this.bNB = effectInfoModel.mTemplateId;
                AdvanceEditorPickCoverActivity.this.mo27351a(effectInfoModel, "subtitleItem");
            }
        }

        /* renamed from: dU */
        public void mo27429dU(boolean z) {
            AdvanceEditorPickCoverActivity.this.mo27411kD(35);
        }

        public void onItemClicked(int i) {
            AdvanceEditorPickCoverActivity.this.ctF = C8540q.m24958j(AdvanceEditorPickCoverActivity.this.mStoryBoard, 35);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return AdvanceEditorPickCoverActivity.this.ctF < 0 || AdvanceEditorPickCoverActivity.this.m15175u(motionEvent);
        }
    };
    private RollInfo ctW = null;
    /* access modifiers changed from: private */
    public boolean isModified = false;

    /* renamed from: po */
    private OnClickListener f3476po = new OnClickListener() {
        public void onClick(View view) {
            if (AdvanceEditorPickCoverActivity.this.ctE != null) {
                AdvanceEditorPickCoverActivity.this.ctE.mo27496kK(-1);
            }
            AdvanceEditorPickCoverActivity.this.csy = false;
            if (!C4580b.m11632Sf()) {
                if (view.equals(AdvanceEditorPickCoverActivity.this.bZM)) {
                    if (AdvanceEditorPickCoverActivity.this.ctO != null && !AdvanceEditorPickCoverActivity.this.ctO.ads()) {
                        AdvanceEditorPickCoverActivity.this.m15167kB(30);
                    } else if (AdvanceEditorPickCoverActivity.this.ctP == null || AdvanceEditorPickCoverActivity.this.ctP.ads()) {
                        if (AdvanceEditorPickCoverActivity.this.cso != null) {
                            AdvanceEditorPickCoverActivity.this.cso.pause();
                        }
                        AdvanceEditorPickCoverActivity.this.finish();
                    } else {
                        AdvanceEditorPickCoverActivity.this.m15167kB(35);
                    }
                } else if (view.equals(AdvanceEditorPickCoverActivity.this.ctN)) {
                    if (AdvanceEditorPickCoverActivity.this.ctO != null && !AdvanceEditorPickCoverActivity.this.ctO.ads()) {
                        AdvanceEditorPickCoverActivity.this.m15167kB(30);
                    } else if (AdvanceEditorPickCoverActivity.this.ctP == null || AdvanceEditorPickCoverActivity.this.ctP.ads()) {
                        if (AdvanceEditorPickCoverActivity.this.cso != null) {
                            AdvanceEditorPickCoverActivity.this.cso.pause();
                        }
                        if (!AdvanceEditorPickCoverActivity.this.isModified) {
                            AdvanceEditorPickCoverActivity.this.setResult(0);
                            AdvanceEditorPickCoverActivity.this.finish();
                            return;
                        }
                        int aIx = AdvanceEditorPickCoverActivity.this.cso != null ? AdvanceEditorPickCoverActivity.this.cso.aIx() : 0;
                        if (AdvanceEditorPickCoverActivity.this.mStoryBoard != null) {
                            C4586g.m11703a((Context) AdvanceEditorPickCoverActivity.this, R.string.xiaoying_str_com_wait_tip, (OnCancelListener) null);
                            C5577b bVar = new C5577b(AdvanceEditorPickCoverActivity.this.mStoryBoard.getDataClip(), AdvanceEditorPickCoverActivity.this.css, AdvanceEditorPickCoverActivity.this.ctC, aIx);
                            bVar.execute((Params[]) new Void[0]);
                        }
                    } else {
                        AdvanceEditorPickCoverActivity.this.m15167kB(35);
                    }
                } else if (view.equals(AdvanceEditorPickCoverActivity.this.ctL)) {
                    AdvanceEditorPickCoverActivity.this.m15165j(true, 30);
                    AdvanceEditorPickCoverActivity.this.ctO.adk();
                    AdvanceEditorPickCoverActivity.this.ctP.mo27659em(true);
                } else if (view.equals(AdvanceEditorPickCoverActivity.this.ctM)) {
                    AdvanceEditorPickCoverActivity.this.m15165j(true, 35);
                    AdvanceEditorPickCoverActivity.this.ctO.mo27617em(true);
                    AdvanceEditorPickCoverActivity.this.ctP.adk();
                } else if (view.equals(AdvanceEditorPickCoverActivity.this.ctH) || view.equals(AdvanceEditorPickCoverActivity.this.ctJ)) {
                    AdvanceEditorPickCoverActivity.this.m15167kB(30);
                } else if (view.equals(AdvanceEditorPickCoverActivity.this.ctI) || view.equals(AdvanceEditorPickCoverActivity.this.ctK)) {
                    AdvanceEditorPickCoverActivity.this.m15167kB(35);
                }
            }
        }
    };

    /* renamed from: com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity$a */
    private static class C5576a extends WeakHandler<AdvanceEditorPickCoverActivity> {
        public C5576a(AdvanceEditorPickCoverActivity advanceEditorPickCoverActivity) {
            super(advanceEditorPickCoverActivity);
        }

        /* JADX WARNING: type inference failed for: r9v0 */
        /* JADX WARNING: type inference failed for: r9v1, types: [com.introvd.template.sdk.utils.VeMSize] */
        /* JADX WARNING: type inference failed for: r9v2, types: [com.introvd.template.sdk.utils.VeMSize] */
        /* JADX WARNING: type inference failed for: r9v3, types: [com.introvd.template.sdk.model.editor.TextEffectParams] */
        /* JADX WARNING: type inference failed for: r9v4, types: [com.introvd.template.sdk.model.editor.TextEffectParams] */
        /* JADX WARNING: type inference failed for: r9v5 */
        /* JADX WARNING: type inference failed for: r9v6 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.introvd.template.sdk.model.editor.TextEffectParams, com.introvd.template.sdk.utils.VeMSize]
          uses: [com.introvd.template.sdk.utils.VeMSize, ?[int, boolean, OBJECT, ARRAY, byte, short, char], com.introvd.template.sdk.model.editor.TextEffectParams]
          mth insns count: 191
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r12) {
            /*
                r11 = this;
                java.lang.Object r0 = r11.getOwner()
                com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity r0 = (com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity) r0
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                int r1 = r12.what
                r2 = 10101(0x2775, float:1.4155E-41)
                r3 = 0
                if (r1 == r2) goto L_0x021e
                r2 = 10301(0x283d, float:1.4435E-41)
                r4 = 1
                if (r1 == r2) goto L_0x01eb
                r2 = 35
                r5 = 30
                r6 = 0
                r8 = 10802(0x2a32, float:1.5137E-41)
                r9 = 0
                if (r1 == r8) goto L_0x012a
                r10 = 10904(0x2a98, float:1.528E-41)
                if (r1 == r10) goto L_0x0118
                switch(r1) {
                    case 10111: goto L_0x003c;
                    case 10112: goto L_0x0029;
                    default: goto L_0x0027;
                }
            L_0x0027:
                goto L_0x0230
            L_0x0029:
                java.lang.Object r12 = r12.obj
                java.lang.String r12 = (java.lang.String) r12
                com.introvd.template.editor.advance.m r1 = r0.ctP
                if (r1 == 0) goto L_0x0230
                com.introvd.template.editor.advance.m r0 = r0.ctP
                r0.mo27663gr(r12)
                goto L_0x0230
            L_0x003c:
                boolean r1 = r0.acc()
                if (r1 == 0) goto L_0x0043
                return
            L_0x0043:
                java.lang.Object r1 = r12.obj
                java.lang.String r1 = (java.lang.String) r1
                com.introvd.template.template.g.d r6 = com.introvd.template.template.p409g.C8762d.aMt()
                long r6 = r6.getTemplateID(r1)
                int r12 = r12.arg1
                if (r12 == r4) goto L_0x0055
                r12 = 1
                goto L_0x0056
            L_0x0055:
                r12 = 0
            L_0x0056:
                int r6 = xiaoying.engine.base.QStyle.QTemplateIDUtils.getTemplateType(r6)
                java.lang.String r6 = java.lang.String.valueOf(r6)
                boolean r6 = com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity.m15159gc(r6)
                if (r6 != 0) goto L_0x00ba
                boolean r6 = com.introvd.template.template.p408f.C8750d.m25573jM(r1)
                if (r6 == 0) goto L_0x006b
                goto L_0x00ba
            L_0x006b:
                com.introvd.template.editor.advance.m r3 = r0.ctP
                if (r3 == 0) goto L_0x0230
                com.introvd.template.editor.advance.m r3 = r0.ctP
                r3.mo27661gn(r1)
                com.introvd.template.editor.advance.m r3 = r0.ctP
                r3.mo27662go(r1)
                com.introvd.template.editor.advance.m r3 = r0.ctP
                r3.mo27641a(r1, r9, r4)
                if (r12 == 0) goto L_0x0090
                com.introvd.template.editor.advance.m r1 = r0.ctP
                r1.mo27658ek(r12)
                goto L_0x009b
            L_0x0090:
                com.introvd.template.editor.advance.m r12 = r0.ctP
                boolean r1 = r0.ctR
                r12.mo27660eo(r1)
            L_0x009b:
                com.introvd.template.editor.advance.m r12 = r0.ctP
                com.introvd.template.sdk.model.editor.TextEffectParams r12 = r12.adz()
                if (r12 == 0) goto L_0x0230
                android.graphics.RectF r1 = r12.getmTextRect()
                com.introvd.template.common.MSize r3 = r0.csP
                int r3 = r3.width
                com.introvd.template.common.MSize r4 = r0.csP
                int r4 = r4.height
                android.graphics.Rect r1 = com.introvd.template.editor.p266h.C6408m.m18453a(r1, r3, r4)
                r0.m15140a(r12, r1, r2)
                goto L_0x0230
            L_0x00ba:
                com.introvd.template.editor.advance.k r2 = r0.ctO
                if (r2 == 0) goto L_0x0230
                com.introvd.template.editor.advance.k r2 = r0.ctO
                r2.mo27620gn(r1)
                com.introvd.template.editor.advance.k r2 = r0.ctO
                r2.mo27621go(r1)
                com.introvd.template.editor.advance.k r2 = r0.ctO
                r2.mo27603a(r1, r9, r4)
                if (r12 == 0) goto L_0x00df
                com.introvd.template.editor.advance.k r1 = r0.ctO
                r1.mo27616ek(r12)
                goto L_0x00eb
            L_0x00df:
                com.introvd.template.editor.advance.k r12 = r0.ctO
                boolean r1 = r0.ctQ
                r1 = r1 ^ r4
                r12.mo27623p(r1, r3)
            L_0x00eb:
                com.introvd.template.editor.advance.k r12 = r0.ctO
                com.introvd.template.editor.advance.ScaleRotateViewV4 r12 = r12.cwY
                if (r12 == 0) goto L_0x0101
                com.introvd.template.editor.advance.k r12 = r0.ctO
                com.introvd.template.editor.advance.ScaleRotateViewV4 r12 = r12.cwY
                com.introvd.template.sdk.model.editor.ScaleRotateViewState r12 = r12.getScaleViewState()
                com.introvd.template.sdk.model.editor.TextEffectParams r9 = com.introvd.template.editor.advance.C5609k.m15399b(r12)
            L_0x0101:
                if (r9 == 0) goto L_0x0230
                android.graphics.RectF r12 = r9.getmTextRect()
                com.introvd.template.common.MSize r1 = r0.csP
                int r1 = r1.width
                com.introvd.template.common.MSize r2 = r0.csP
                int r2 = r2.height
                android.graphics.Rect r12 = com.introvd.template.editor.p266h.C6408m.m18453a(r12, r1, r2)
                r0.m15140a(r9, r12, r5)
                goto L_0x0230
            L_0x0118:
                com.introvd.template.template.e.f r12 = com.introvd.template.template.p407e.C8735f.aMf()
                android.content.Context r0 = r0.getApplicationContext()
                java.lang.String r1 = com.introvd.template.sdk.p383c.C8399c.ede
                r12.mo35147cz(r0, r1)
                r11.sendEmptyMessageDelayed(r8, r6)
                goto L_0x0230
            L_0x012a:
                r12 = -1
                java.util.ArrayList r1 = r0.csv
                if (r1 == 0) goto L_0x013e
                java.util.ArrayList r1 = r0.csv
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x013e
                java.util.ArrayList r12 = r0.csv
                int r12 = r12.size()
                int r12 = r12 - r4
            L_0x013e:
                java.util.ArrayList r1 = r0.csv
                java.lang.String r1 = r0.mo27374f(r1)
                long r3 = r0.mTemplateId
                int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r3 <= 0) goto L_0x015a
                boolean r3 = android.text.TextUtils.isEmpty(r1)
                if (r3 == 0) goto L_0x015a
                com.introvd.template.template.g.d r1 = com.introvd.template.template.p409g.C8762d.aMt()
                long r3 = r0.mTemplateId
                java.lang.String r1 = r1.mo35225bB(r3)
            L_0x015a:
                xiaoying.engine.storyboard.QStoryboard r3 = r0.mStoryBoard
                xiaoying.engine.clip.QEffect r3 = com.introvd.template.sdk.utils.p394b.C8540q.m24940b(r3, r5, r12)
                if (r3 == 0) goto L_0x0180
                com.introvd.template.common.MSize r4 = r0.csP
                if (r4 == 0) goto L_0x0174
                com.introvd.template.sdk.utils.VeMSize r4 = new com.introvd.template.sdk.utils.VeMSize
                com.introvd.template.common.MSize r5 = r0.csP
                int r5 = r5.width
                com.introvd.template.common.MSize r6 = r0.csP
                int r6 = r6.height
                r4.<init>(r5, r6)
                goto L_0x0175
            L_0x0174:
                r4 = r9
            L_0x0175:
                com.introvd.template.sdk.model.editor.ScaleRotateViewState r3 = com.introvd.template.sdk.utils.p394b.C8538o.m24851a(r3, r4)
                com.introvd.template.editor.advance.k r4 = r0.ctO
                r4.mo27601a(r3, r1)
            L_0x0180:
                com.introvd.template.editor.advance.k r3 = r0.ctO
                r3.adc()
                xiaoying.engine.storyboard.QStoryboard r3 = r0.mStoryBoard
                xiaoying.engine.clip.QEffect r12 = com.introvd.template.sdk.utils.p394b.C8540q.m24940b(r3, r2, r12)
                com.introvd.template.editor.advance.m r2 = r0.ctP
                if (r2 != 0) goto L_0x0194
                return
            L_0x0194:
                com.introvd.template.editor.advance.m r2 = r0.ctP
                r2.mo27661gn(r1)
                com.introvd.template.editor.advance.m r2 = r0.ctP
                r2.mo27657b(r9)
                if (r12 == 0) goto L_0x01e3
                com.introvd.template.common.MSize r2 = r0.csP
                if (r2 == 0) goto L_0x01b1
                com.introvd.template.sdk.utils.VeMSize r9 = new com.introvd.template.sdk.utils.VeMSize
                int r3 = r2.width
                int r2 = r2.height
                r9.<init>(r3, r2)
            L_0x01b1:
                com.introvd.template.sdk.utils.b.a r2 = com.introvd.template.sdk.utils.p394b.C8501a.aJs()
                xiaoying.engine.QEngine r2 = r2.aJv()
                com.introvd.template.sdk.model.editor.ScaleRotateViewState r12 = com.introvd.template.sdk.utils.p394b.C8538o.m24850a(r2, r12, r9)
                if (r12 == 0) goto L_0x01c8
                com.introvd.template.sdk.model.editor.TextBubbleInfo r2 = r12.mTextBubbleInfo
                if (r2 == 0) goto L_0x01c8
                com.introvd.template.sdk.model.editor.TextBubbleInfo r2 = r12.mTextBubbleInfo
                r2.reset()
            L_0x01c8:
                com.introvd.template.editor.advance.m r2 = r0.ctP
                r2.mo27640a(r12, r1)
                if (r12 == 0) goto L_0x01dc
                com.introvd.template.editor.advance.m r1 = r0.ctP
                java.lang.String r12 = r12.getTextFontPath()
                r1.mo27665gu(r12)
            L_0x01dc:
                com.introvd.template.editor.advance.m r12 = r0.ctP
                r12.adA()
            L_0x01e3:
                com.introvd.template.editor.advance.m r12 = r0.ctP
                r12.adc()
                goto L_0x0230
            L_0x01eb:
                com.introvd.template.sdk.editor.b.d r12 = r0.cso
                if (r12 == 0) goto L_0x0210
                com.introvd.template.editor.b.f r12 = r0.csu
                if (r12 == 0) goto L_0x0210
                boolean r12 = r0.csH
                if (r12 == 0) goto L_0x020b
                r0.csH = r3
                com.introvd.template.editor.b.f r12 = r0.csu
                com.introvd.template.common.MSize r1 = r0.css
                int r2 = r0.csD
                xiaoying.engine.base.QSessionStream r12 = r12.mo27761a(r1, r4, r2)
                com.introvd.template.sdk.editor.b.d r1 = r0.cso
                int r2 = r0.csK
                r1.mo34168a(r12, r2)
                goto L_0x0210
            L_0x020b:
                com.introvd.template.sdk.editor.b.d r12 = r0.cso
                r12.aIB()
            L_0x0210:
                com.introvd.template.editor.advance.m r12 = r0.ctP
                if (r12 == 0) goto L_0x0230
                com.introvd.template.editor.advance.m r12 = r0.ctP
                r12.onResume()
                goto L_0x0230
            L_0x021e:
                boolean r12 = r0.ctB
                if (r12 == 0) goto L_0x0230
                com.introvd.template.sdk.editor.b.d r12 = r0.cso
                if (r12 == 0) goto L_0x022d
                com.introvd.template.sdk.editor.b.d r12 = r0.cso
                r12.play()
            L_0x022d:
                r0.ctB = r3
            L_0x0230:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity.C5576a.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity$b */
    private class C5577b extends ExAsyncTask<Void, Void, Boolean> {
        private MSize css = null;
        private String ctC = "";
        private long ctZ = 0;
        private QClip mClip = new QClip();

        public C5577b(QClip qClip, MSize mSize, String str, int i) {
            if (!(qClip == null || qClip.duplicate(this.mClip) == 0)) {
                this.mClip.unInit();
                this.mClip = null;
            }
            if (mSize != null) {
                this.css = new MSize(mSize.width, mSize.height);
            }
            this.ctC = str;
            this.ctZ = (long) i;
            StringBuilder sb = new StringBuilder();
            sb.append("ThumbDecodeTask mDestPath=");
            sb.append(this.ctC);
            sb.append(";mTimePos=");
            sb.append(this.ctZ);
            LogUtilsV2.m14230i(sb.toString());
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            AdvanceEditorPickCoverActivity.this.m15150b(AdvanceEditorPickCoverActivity.this.m15133a(AdvanceEditorPickCoverActivity.this.mStoryBoard), this.ctC);
            if (this.mClip == null || this.css == null || TextUtils.isEmpty(this.ctC)) {
                return Boolean.valueOf(false);
            }
            int dI = C8572y.m25087dI(this.css.width, 4);
            int dI2 = C8572y.m25087dI(this.css.height, 4);
            if (AdvanceEditorPickCoverActivity.this.cso != null) {
                Bitmap dG = AdvanceEditorPickCoverActivity.this.cso.mo34189dG(dI, dI2);
                if (dG == null) {
                    return Boolean.valueOf(false);
                }
                UtilsBitmap.saveBitmap(this.ctC, dG, 85);
                return Boolean.valueOf(true);
            } else if (this.mClip.createThumbnailManager(dI, dI2, 65538, false, false) != 0) {
                return Boolean.valueOf(false);
            } else {
                QBitmap createQBitmapBlank = QBitmapFactory.createQBitmapBlank(dI, dI2, QColorSpace.QPAF_RGB32_A8R8G8B8);
                if (C8572y.m25063a(this.mClip, createQBitmapBlank, (int) this.ctZ, true) != 0) {
                    return Boolean.valueOf(false);
                }
                Bitmap createBitmap = Bitmap.createBitmap(dI, dI2, Config.ARGB_8888);
                if (QAndroidBitmapFactory.transformQBitmapIntoBitmap(createQBitmapBlank, createBitmap) != 0) {
                    return Boolean.valueOf(false);
                }
                UtilsBitmap.saveBitmap(this.ctC, createBitmap, 85);
                if (createQBitmapBlank != null && !createQBitmapBlank.isRecycled()) {
                    createQBitmapBlank.recycle();
                }
                if (this.mClip != null) {
                    this.mClip.destroyThumbnailManager();
                    this.mClip.unInit();
                    this.mClip = null;
                }
                return Boolean.valueOf(true);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            C4586g.m11695Sl();
            if (bool.booleanValue()) {
                Intent intent = new Intent();
                intent.putExtra(PickCoverParams.ACTIVITY_COVER_PICK_TIME_POSITION_KEY, this.ctZ);
                AdvanceEditorPickCoverActivity.this.setResult(-1, intent);
            } else {
                AdvanceEditorPickCoverActivity.this.setResult(0);
            }
            AdvanceEditorPickCoverActivity.this.finish();
        }
    }

    /* renamed from: a */
    private float m15126a(int i, QClip qClip) {
        return C8537n.m24784a(qClip, i, (float) (i == 35 ? IronSourceConstants.IS_INSTANCE_LOAD_FAILED : 2100));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m15128a(QStoryboard qStoryboard, TextEffectParams textEffectParams, Rect rect, int i) {
        int i2;
        this.isModified = true;
        if (qStoryboard == null || textEffectParams == null || ((!TextUtils.isEmpty(textEffectParams.getmEffectStylePath()) && rect == null) || qStoryboard.getDataClip() == null)) {
            return 2;
        }
        VeMSize veMSize = null;
        QEffect qEffect = 30 == i ? this.ctO.adq() : 35 == i ? this.ctP.adq() : null;
        if (qEffect != null) {
            if (this.css != null) {
                veMSize = new VeMSize(this.css.width, this.css.height);
            }
            i2 = i == 30 ? C8538o.m24866c(qEffect, textEffectParams, rect, veMSize) : i == 35 ? C8538o.m24862b(qEffect, textEffectParams, rect, veMSize) : 0;
            if (this.cso != null) {
                this.cso.mo34167a(qStoryboard.getDataClip(), 2, qEffect);
            }
        } else {
            i2 = 0;
        }
        return i2 != 0 ? 1 : 0;
    }

    /* renamed from: a */
    private int m15129a(QStoryboard qStoryboard, TextEffectParams textEffectParams, Rect rect, int i, int i2) {
        int i3;
        this.isModified = true;
        if (qStoryboard == null || textEffectParams == null || i < 0 || (!TextUtils.isEmpty(textEffectParams.getmEffectStylePath()) && rect == null)) {
            return 2;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return 2;
        }
        if (TextUtils.isEmpty(textEffectParams.getmEffectStylePath())) {
            QEffect b = C8537n.m24816b(dataClip, i2, i);
            if (!(this.cso == null || b == null)) {
                this.cso.mo34167a(qStoryboard.getDataClip(), 3, b);
                this.cso.aIB();
            }
            i3 = C8540q.m24943c(qStoryboard, i2, i);
        } else {
            i3 = 0;
        }
        if (30 == i2) {
            this.ctO.mo27615b((QEffect) null);
        } else if (35 == i2) {
            this.ctP.mo27657b((QEffect) null);
        }
        String str = "Cover_Template_Delete_Sticker";
        if (35 == i2) {
            str = "Cover_Template_Delete_Title";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", C8450a.m24469bn(textEffectParams.getmTemplateId()));
        UserBehaviorLog.onKVEvent(this, str, hashMap);
        return i3 != 0 ? 1 : 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<ScaleRotateViewState> m15133a(QStoryboard qStoryboard) {
        ArrayList arrayList = new ArrayList();
        int j = C8540q.m24958j(qStoryboard, 30);
        int i = 0;
        while (true) {
            VeMSize veMSize = null;
            if (i >= j) {
                break;
            }
            QEffect b = C8540q.m24940b(qStoryboard, 30, i);
            if (b != null) {
                if (this.csP != null) {
                    veMSize = new VeMSize(this.csP.width, this.csP.height);
                }
                ScaleRotateViewState a = C8538o.m24851a(b, veMSize);
                a.groupID = 30;
                arrayList.add(a);
            }
            i++;
        }
        int j2 = C8540q.m24958j(qStoryboard, 35);
        for (int i2 = 0; i2 < j2; i2++) {
            QEffect b2 = C8540q.m24940b(qStoryboard, 35, i2);
            if (b2 != null) {
                ScaleRotateViewState a2 = C8538o.m24850a(C8501a.aJs().aJv(), b2, this.csP != null ? new VeMSize(this.csP.width, this.csP.height) : null);
                if (a2 != null) {
                    a2.groupID = 35;
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15140a(TextEffectParams textEffectParams, Rect rect, int i) {
        this.isModified = true;
        VeMSize veMSize = null;
        QEffect qEffect = 30 == i ? this.ctO.adq() : 35 == i ? this.ctP.adq() : null;
        if (qEffect != null) {
            mo27353a(Boolean.valueOf(true).booleanValue(), qEffect);
            if (this.cso != null) {
                this.cso.aIB();
            }
        }
        QEngine aJv = this.bOK.aJv();
        QClip dataClip = this.mStoryBoard.getDataClip();
        textEffectParams.mLayerID = m15126a(i, dataClip) + 5.0E-4f;
        if (this.css != null) {
            veMSize = new VeMSize(this.css.width, this.css.height);
        }
        if (C8537n.m24789a(dataClip, aJv, textEffectParams, i, rect, veMSize) == 0) {
            QEffect b = C8540q.m24940b(this.mStoryBoard, i, C8540q.m24958j(this.mStoryBoard, i) - 1);
            this.cso.mo34167a(dataClip, 1, b);
            C8538o.m24870c(b, false);
            if (30 == i) {
                this.ctO.mo27615b(b);
            } else if (35 == i) {
                this.ctP.mo27657b(b);
            }
        }
        String str = "Cover_Template_Add_Sticker";
        if (35 == i) {
            str = "Cover_Template_Add_Title";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", C8450a.m24469bn(textEffectParams.getmTemplateId()));
        UserBehaviorLog.onKVEvent(this, str, hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15141a(RollInfo rollInfo, String str) {
        if (rollInfo != null) {
            String str2 = rollInfo.ttid;
            if (!C8745n.m25561qv(str2) && !"20160224184733".equals(str2) && !"20160224184948".equals(str2) && C4600l.m11739k(this, true)) {
                mo27352a((TemplateInfo) rollInfo, str);
            }
        }
    }

    /* renamed from: a */
    private void m15142a(QEffect qEffect) {
        if (qEffect != null) {
            mo27353a(Boolean.valueOf(false).booleanValue(), qEffect);
        }
    }

    /* renamed from: a */
    private void m15143a(QEffect qEffect, int i) {
        if (i != 30 || this.ctO == null) {
            if (i == 35 && this.ctP != null) {
                ScaleRotateViewState a = C8538o.m24850a(this.bOK.aJv(), qEffect, this.css != null ? new VeMSize(this.css.width, this.css.height) : null);
                if (a != null) {
                    this.ctP.mo27657b(qEffect);
                    this.ctP.mo27661gn(a.mStylePath);
                    this.ctP.mo27662go(a.mStylePath);
                    this.ctP.mo27665gu(a.getTextFontPath());
                    this.ctP.mo27641a((String) null, qEffect, false);
                    this.ctP.add();
                    this.ctP.mo27658ek(true);
                    this.ctP.adw();
                }
            }
        } else if (qEffect != null) {
            ScaleRotateViewState a2 = C8538o.m24851a(qEffect, this.csP != null ? new VeMSize(this.csP.width, this.csP.height) : null);
            if (a2 != null) {
                this.ctO.mo27615b(qEffect);
                this.ctO.mo27620gn(a2.mStylePath);
                this.ctO.mo27621go(a2.mStylePath);
                this.ctO.mo27603a((String) null, qEffect, false);
                this.ctO.add();
                this.ctO.mo27623p(true, false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15144a(QStoryboard qStoryboard, List<ScaleRotateViewState> list) throws Exception {
        if (!(qStoryboard == null || list == null || list.isEmpty())) {
            QEngine aJv = this.bOK.aJv();
            QClip dataClip = this.mStoryBoard.getDataClip();
            for (int i = 0; i < list.size(); i++) {
                ScaleRotateViewState scaleRotateViewState = (ScaleRotateViewState) list.get(i);
                int i2 = scaleRotateViewState.groupID;
                TextEffectParams b = C5609k.m15399b(scaleRotateViewState);
                if (i2 == 35) {
                    b = C5626m.m15482a("", scaleRotateViewState, "");
                }
                if (b != null) {
                    Rect a = C6408m.m18453a(b.getmTextRect(), this.csP.width, this.csP.height);
                    b.mLayerID = m15126a(i2, dataClip) + 5.0E-4f;
                    C8537n.m24789a(dataClip, aJv, b, i2, a, this.css != null ? new VeMSize(this.css.width, this.css.height) : null);
                }
            }
            if (this.cso != null) {
                this.cso.mo34167a(dataClip, 6, null);
                this.cso.aIB();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(list.toString());
            sb.append(";size=");
            sb.append(list.size());
            LogUtilsV2.m14228e(sb.toString());
        }
        throw new Exception("no data serilized");
    }

    private void abS() {
        if (this.cso != null) {
            this.cso.aIv();
            this.cso = null;
        }
    }

    private void abY() {
        if (this.mStoryBoard != null && this.bMM != null) {
            TemplateConditionModel aJK = this.bMM.aJK();
            this.ctO = new C5609k(this.bWd, this.csP, aJK);
            this.ctO.mo27600a(this.ctU);
            this.ctO.mo27604a(this.mStoryBoard.getEngine());
            this.ctP = new C5626m(this.bWd, this.csP, aJK);
            this.ctP.mo27656b(this.ctV);
            this.ctP.mo27642a(this.mStoryBoard.getEngine());
        }
    }

    private void abZ() {
        if (this.mStoryBoard != null) {
            C5583b bVar = new C5583b((VeGallery2) findViewById(R.id.gallery_timeline), this.mStoryBoard.getDataClip(), this.mStoryBoard.getDuration(), new ArrayList(), this.css);
            this.ctE = bVar;
            this.ctE.mo27479a(this.ctT);
            this.ctE.mo27488b(C8540q.m24952f(this.mStoryBoard, this.ctE.acy(), 3000));
            this.ctE.mo27490dV(false);
            this.ctE.setmState(1);
        }
    }

    private void aca() {
        this.bWd = (RelativeLayout) findViewById(R.id.relativelayout_music_panel);
        this.bMj = (RelativeLayout) findViewById(R.id.preview_layout);
        this.ctD = (RelativeLayout) findViewById(R.id.preview_layout_fake);
        this.csQ = (RelativeLayout) findViewById(R.id.layout_pick_cover_preview_layout);
        new LinearLayoutManager(getApplicationContext()).setOrientation(0);
        this.ctG = (LinearLayout) findViewById(R.id.tab_layout);
        this.ctH = (ImageView) findViewById(R.id.btn_sticker_ok);
        this.ctI = (ImageView) findViewById(R.id.btn_subtitle_ok);
        this.ctJ = (ImageView) findViewById(R.id.btn_sticker_cancel);
        this.ctK = (ImageView) findViewById(R.id.btn_subtitle_cancel);
        this.ctL = (RelativeLayout) findViewById(R.id.tab_sticker);
        this.ctM = (RelativeLayout) findViewById(R.id.tab_font);
        this.ctN = (ImageView) findViewById(R.id.xiaoying_btn_finish);
        this.bZM = (ImageView) findViewById(R.id.img_back);
        this.ctH.setOnClickListener(this.f3476po);
        this.ctI.setOnClickListener(this.f3476po);
        this.ctJ.setOnClickListener(this.f3476po);
        this.ctK.setOnClickListener(this.f3476po);
        this.ctL.setOnClickListener(this.f3476po);
        this.ctM.setOnClickListener(this.f3476po);
        this.bZM.setOnClickListener(this.f3476po);
        this.ctN.setOnClickListener(this.f3476po);
        this.ctD.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    return AdvanceEditorPickCoverActivity.this.m15175u(motionEvent);
                }
                return true;
            }
        });
    }

    private void acb() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(500, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1840o<List>>() {
            /* renamed from: h */
            public C1840o<List> apply(Boolean bool) {
                return C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, List>() {
                    /* renamed from: i */
                    public List apply(Boolean bool) {
                        List a = AdvanceEditorPickCoverActivity.this.m15157ga(AdvanceEditorPickCoverActivity.this.ctC);
                        if (a != null) {
                            return a;
                        }
                        throw C1505b.m4703z(new Throwable("No Cache"));
                    }
                });
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List>() {
            /* renamed from: R */
            public void mo9886K(List list) {
                try {
                    AdvanceEditorPickCoverActivity.this.m15144a(AdvanceEditorPickCoverActivity.this.mStoryBoard, list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                StringBuilder sb = new StringBuilder();
                sb.append(">>>>>>onSubscribe run");
                sb.append(bVar);
                LogUtilsV2.m14228e(sb.toString());
            }

            public void onComplete() {
                LogUtilsV2.m14228e(">>>>>>onComplete run");
            }

            public void onError(Throwable th) {
                LogUtilsV2.m14228e(">>>>>>onError run");
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean acc() {
        if (C8540q.m24958j(this.mStoryBoard, 30) + C8540q.m24958j(this.mStoryBoard, 35) < 4) {
            return false;
        }
        ToastUtils.show((Context) this, R.string.xiaoying_str_edit_max_item_count_tip, 0);
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[SYNTHETIC, Splitter:B:26:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0068 A[SYNTHETIC, Splitter:B:31:0x0068] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15150b(java.util.List<com.introvd.template.sdk.model.editor.ScaleRotateViewState> r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r6 = r4.m15158gb(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            boolean r0 = com.introvd.template.common.FileUtils.isFileExisted(r6)
            if (r0 == 0) goto L_0x0014
            com.introvd.template.common.FileUtils.deleteFile(r6)
        L_0x0014:
            if (r5 == 0) goto L_0x006c
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x001d
            goto L_0x006c
        L_0x001d:
            r0 = 0
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x005a }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x005a }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x005a }
            r3.<init>(r6)     // Catch:{ IOException -> 0x005a }
            r2.<init>(r3)     // Catch:{ IOException -> 0x005a }
            r1.<init>(r2)     // Catch:{ IOException -> 0x005a }
            int r6 = r5.size()     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            com.introvd.template.sdk.model.editor.ScaleRotateViewState[] r6 = new com.introvd.template.sdk.model.editor.ScaleRotateViewState[r6]     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            java.lang.Object[] r6 = r5.toArray(r6)     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            r1.writeObject(r6)     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            r6.<init>()     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            java.lang.String r0 = "serializeTextState state="
            r6.append(r0)     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            r6.append(r5)     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            java.lang.String r5 = r6.toString()     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            com.introvd.template.common.LogUtilsV2.m14227d(r5)     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            r1.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0065
        L_0x0052:
            r5 = move-exception
            goto L_0x0066
        L_0x0054:
            r5 = move-exception
            r0 = r1
            goto L_0x005b
        L_0x0057:
            r5 = move-exception
            r1 = r0
            goto L_0x0066
        L_0x005a:
            r5 = move-exception
        L_0x005b:
            java.lang.String r6 = ">>>"
            com.introvd.template.common.LogUtilsV2.m14229e(r6, r5)     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x0065
            r0.close()     // Catch:{ IOException -> 0x0065 }
        L_0x0065:
            return
        L_0x0066:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            throw r5
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity.m15150b(java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        if (r1 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 != null) goto L_0x002d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0040 A[SYNTHETIC, Splitter:B:28:0x0040] */
    /* renamed from: ga */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.introvd.template.sdk.model.editor.ScaleRotateViewState> m15157ga(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002a, all -> 0x0028 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002a, all -> 0x0028 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002a, all -> 0x0028 }
            java.lang.String r5 = r4.m15158gb(r5)     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002a, all -> 0x0028 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002a, all -> 0x0028 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002a, all -> 0x0028 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0031, ClassNotFoundException -> 0x002a, all -> 0x0028 }
            java.lang.Object r5 = r1.readObject()     // Catch:{ IOException -> 0x0026, ClassNotFoundException -> 0x0024 }
            com.introvd.template.sdk.model.editor.ScaleRotateViewState[] r5 = (com.introvd.template.sdk.model.editor.ScaleRotateViewState[]) r5     // Catch:{ IOException -> 0x0026, ClassNotFoundException -> 0x0024 }
            com.introvd.template.sdk.model.editor.ScaleRotateViewState[] r5 = (com.introvd.template.sdk.model.editor.ScaleRotateViewState[]) r5     // Catch:{ IOException -> 0x0026, ClassNotFoundException -> 0x0024 }
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ IOException -> 0x0026, ClassNotFoundException -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x0023 }
        L_0x0023:
            return r5
        L_0x0024:
            goto L_0x002b
        L_0x0026:
            r5 = move-exception
            goto L_0x0033
        L_0x0028:
            r5 = move-exception
            goto L_0x003e
        L_0x002a:
            r1 = r0
        L_0x002b:
            if (r1 == 0) goto L_0x003b
        L_0x002d:
            r1.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003b
        L_0x0031:
            r5 = move-exception
            r1 = r0
        L_0x0033:
            java.lang.String r2 = ""
            com.introvd.template.common.LogUtilsV2.m14229e(r2, r5)     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003b
            goto L_0x002d
        L_0x003b:
            return r0
        L_0x003c:
            r5 = move-exception
            r0 = r1
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity.m15157ga(java.lang.String):java.util.List");
    }

    /* renamed from: gb */
    private String m15158gb(String str) {
        try {
            String path = new File(str).getParentFile().getPath();
            String fileName = FileUtils.getFileName(str);
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            sb.append(File.separator);
            sb.append(fileName);
            sb.append("BubbleInfoList.txt");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gc */
    public static boolean m15159gc(String str) {
        return C8399c.ede.equals(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: gd */
    public void m15160gd(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "edit_title");
        UserBehaviorLog.onKVEvent(this, "Template_Enter_New_Version", hashMap);
        Intent intent = new Intent(this, TemplateInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID, str);
        bundle.putBoolean(TemplateRouter.EXTRA_KEY_NEED_ACTIVITY_RESULT, true);
        intent.putExtras(bundle);
        startActivityForResult(intent, 10102);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m15165j(boolean z, int i) {
        if (z) {
            this.ctG.setVisibility(4);
            this.ctE.mo27491dW(false);
            this.ctE.mo27492dX(true);
            HashMap hashMap = new HashMap();
            String str = "Sticker";
            if (i == 35) {
                str = "Title";
            }
            hashMap.put(PlaceFields.PAGE, str);
            UserBehaviorLog.onKVEvent(this, "Cover_Subpage_Enter", hashMap);
            return;
        }
        this.ctG.setVisibility(0);
        this.ctE.mo27491dW(true);
        this.ctE.mo27492dX(false);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
    /* renamed from: kB */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15167kB(int r8) {
        /*
            r7 = this;
            r0 = 0
            r7.m15165j(r0, r8)
            com.introvd.template.editor.advance.k r1 = r7.ctO
            r1.mo27617em(r0)
            com.introvd.template.editor.advance.m r1 = r7.ctP
            r1.mo27659em(r0)
            r0 = 0
            r1 = 35
            r2 = 30
            if (r2 != r8) goto L_0x0035
            com.introvd.template.editor.advance.k r3 = r7.ctO
            boolean r3 = r3.adm()
            if (r3 == 0) goto L_0x0035
            com.introvd.template.editor.advance.k r3 = r7.ctO
            r3.adl()
            com.introvd.template.editor.advance.k r3 = r7.ctO
            com.introvd.template.editor.advance.ScaleRotateViewV4 r3 = r3.cwY
            if (r3 == 0) goto L_0x0051
            com.introvd.template.editor.advance.k r3 = r7.ctO
            com.introvd.template.editor.advance.ScaleRotateViewV4 r3 = r3.cwY
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r3 = r3.getScaleViewState()
            com.introvd.template.sdk.model.editor.TextEffectParams r3 = com.introvd.template.editor.advance.C5609k.m15399b(r3)
            goto L_0x0052
        L_0x0035:
            if (r1 != r8) goto L_0x00a1
            com.introvd.template.editor.advance.m r3 = r7.ctP
            boolean r3 = r3.adm()
            if (r3 == 0) goto L_0x00a1
            com.introvd.template.editor.advance.m r3 = r7.ctP
            r3.adl()
            com.introvd.template.editor.advance.m r3 = r7.ctP
            com.introvd.template.editor.advance.ScaleRotateViewV4 r3 = r3.cwY
            if (r3 == 0) goto L_0x0051
            com.introvd.template.editor.advance.m r3 = r7.ctP
            com.introvd.template.sdk.model.editor.TextEffectParams r3 = r3.adz()
            goto L_0x0052
        L_0x0051:
            r3 = r0
        L_0x0052:
            if (r3 == 0) goto L_0x0091
            android.graphics.RectF r4 = r3.getmTextRect()
            com.introvd.template.common.MSize r5 = r7.csP
            int r5 = r5.width
            com.introvd.template.common.MSize r6 = r7.csP
            int r6 = r6.height
            android.graphics.Rect r4 = com.introvd.template.editor.p266h.C6408m.m18453a(r4, r5, r6)
            xiaoying.engine.storyboard.QStoryboard r5 = r7.mStoryBoard
            r7.m15128a(r5, r3, r4, r8)
            if (r2 != r8) goto L_0x0072
            com.introvd.template.editor.advance.k r0 = r7.ctO
            xiaoying.engine.clip.QEffect r0 = r0.adq()
            goto L_0x007a
        L_0x0072:
            if (r1 != r8) goto L_0x007a
            com.introvd.template.editor.advance.m r0 = r7.ctP
            xiaoying.engine.clip.QEffect r0 = r0.adq()
        L_0x007a:
            if (r0 == 0) goto L_0x0091
            r3 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r3 = r3.booleanValue()
            r7.mo27353a(r3, r0)
            com.introvd.template.sdk.editor.b.d r0 = r7.cso
            if (r0 == 0) goto L_0x0091
            com.introvd.template.sdk.editor.b.d r0 = r7.cso
            r0.aIB()
        L_0x0091:
            if (r2 != r8) goto L_0x0099
            com.introvd.template.editor.advance.k r8 = r7.ctO
            r8.adn()
            goto L_0x00a0
        L_0x0099:
            if (r1 != r8) goto L_0x00a0
            com.introvd.template.editor.advance.m r8 = r7.ctP
            r8.adn()
        L_0x00a0:
            return
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.AdvanceEditorPickCoverActivity.m15167kB(int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public boolean m15175u(MotionEvent motionEvent) {
        Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        int j = C8540q.m24958j(this.mStoryBoard, 35);
        int i = 0;
        while (true) {
            VeMSize veMSize = null;
            if (i < j) {
                QEffect b = C8540q.m24940b(this.mStoryBoard, 35, i);
                if (b != null) {
                    if (this.csP != null) {
                        veMSize = new VeMSize(this.csP.width, this.csP.height);
                    }
                    ScaleRotateViewState a = C8538o.m24851a(b, veMSize);
                    if (a != null) {
                        RectF rectArea = a.getRectArea();
                        if (rectArea != null && C8530i.m24753a(point, 0.0f, new Rect((int) rectArea.left, (int) rectArea.top, (int) rectArea.right, (int) rectArea.bottom))) {
                            if (this.ctP.ads()) {
                                m15165j(true, 35);
                                this.ctP.adk();
                                this.ctO.mo27617em(true);
                            }
                            QEffect adq = this.ctO.adq();
                            if (adq != null) {
                                mo27353a(Boolean.valueOf(true).booleanValue(), adq);
                                if (this.cso != null) {
                                    this.cso.aIB();
                                }
                            }
                            QEffect adq2 = this.ctP.adq();
                            if (adq2 != null) {
                                mo27353a(Boolean.valueOf(true).booleanValue(), adq2);
                                if (this.cso != null) {
                                    this.cso.aIB();
                                }
                            }
                            this.ctF = i;
                            m15143a(b, 35);
                            m15142a(b);
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
                i++;
            } else {
                int j2 = C8540q.m24958j(this.mStoryBoard, 30);
                for (int i2 = 0; i2 < j2; i2++) {
                    QEffect b2 = C8540q.m24940b(this.mStoryBoard, 30, i2);
                    if (b2 != null) {
                        ScaleRotateViewState a2 = C8538o.m24851a(b2, this.csP != null ? new VeMSize(this.csP.width, this.csP.height) : null);
                        if (a2 != null) {
                            RectF rectArea2 = a2.getRectArea();
                            if (rectArea2 != null && C8530i.m24753a(point, 0.0f, new Rect((int) rectArea2.left, (int) rectArea2.top, (int) rectArea2.right, (int) rectArea2.bottom))) {
                                if (this.ctO.ads()) {
                                    m15165j(true, 30);
                                    this.ctO.adk();
                                    this.ctP.mo27659em(true);
                                }
                                QEffect adq3 = this.ctO.adq();
                                if (adq3 != null) {
                                    mo27353a(Boolean.valueOf(true).booleanValue(), adq3);
                                    if (this.cso != null) {
                                        this.cso.aIB();
                                    }
                                }
                                QEffect adq4 = this.ctP.adq();
                                if (adq4 != null) {
                                    mo27353a(Boolean.valueOf(true).booleanValue(), adq4);
                                    if (this.cso != null) {
                                        this.cso.aIB();
                                    }
                                }
                                this.ctF = i2;
                                m15143a(b2, 30);
                                m15142a(b2);
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                m15167kB(30);
                m15167kB(35);
                return false;
            }
        }
    }

    private void updateProgress(int i) {
        if (!this.csy && this.ctE != null) {
            this.ctE.updateProgress(i);
        }
    }

    /* access modifiers changed from: protected */
    public void abA() {
    }

    /* access modifiers changed from: protected */
    public QSessionStream abB() {
        return this.csu.mo27761a(this.css, 1, this.csD);
    }

    /* access modifiers changed from: protected */
    public boolean abF() {
        return this.cso != null;
    }

    /* access modifiers changed from: protected */
    public void abI() {
        if (this.ctA != null) {
            this.ctA.sendEmptyMessage(10101);
        }
    }

    /* access modifiers changed from: protected */
    public void aby() {
        if (this.mStoryBoard != null) {
            QStoryboard qStoryboard = new QStoryboard();
            qStoryboard.init(C8501a.aJs().aJv(), null);
            if (this.mStoryBoard.duplicate(qStoryboard) != 0) {
                qStoryboard.unInit();
                return;
            }
            this.mStoryBoard = qStoryboard;
            this.csu = new C5676g(qStoryboard);
            this.csu.mo27765c(this.css);
        }
    }

    /* access modifiers changed from: protected */
    public boolean abz() {
        return false;
    }

    /* renamed from: d */
    public void mo27372d(long j, int i) {
        if (this.ctO != null && this.ctP != null) {
            if (this.ctO.mo27614au(j)) {
                C5609k kVar = this.ctO;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(j);
                kVar.mo27624v(sb.toString(), i);
                return;
            }
            C5626m mVar = this.ctP;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(j);
            mVar.mo27667v(sb2.toString(), i);
        }
    }

    /* access modifiers changed from: protected */
    public int getPlayerInitTime() {
        return this.csK;
    }

    /* access modifiers changed from: protected */
    /* renamed from: kC */
    public void mo27410kC(int i) {
        if (this.ctF >= 0) {
            m15129a(this.mStoryBoard, new TextEffectParams(), (Rect) null, this.ctF, i);
            UserBehaviorLog.onKVEvent(this, "VE_Sticker_Delete", new HashMap());
        }
        mo27411kD(i);
    }

    /* renamed from: kD */
    public void mo27411kD(int i) {
        this.ctF = -1;
        C8537n.m24801a(this.mStoryBoard.getDataClip(), i, true);
        if (i == 30) {
            if (this.ctO != null) {
                this.ctO.adl();
            }
        } else if (this.ctP != null) {
            this.ctP.adl();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ks */
    public int mo27378ks(int i) {
        updateProgress(i);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: kt */
    public int mo27379kt(int i) {
        updateProgress(i);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ku */
    public int mo27380ku(int i) {
        updateProgress(i);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: kv */
    public int mo27381kv(int i) {
        updateProgress(i);
        return 0;
    }

    /* renamed from: m */
    public void mo27383m(Long l) {
        String l2 = C8762d.aMt().mo35241l(l.longValue(), 4);
        C8735f aMf = C8735f.aMf();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(l);
        aMf.mo35153qn(sb.toString());
        C8745n.updateRollTemplateMapInfo(getApplicationContext());
        if (this.ctO != null && this.ctP != null) {
            if (this.ctO.mo27614au(l.longValue())) {
                UserEventDurationRelaUtils.finishDuraEventSuc(getApplicationContext(), C8450a.m24469bn(l.longValue()), "Cover_Template_Download_Sticker", "list", l2, "sticker");
                C5609k kVar = this.ctO;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(l);
                kVar.mo27618gk(sb2.toString());
                return;
            }
            UserEventDurationRelaUtils.finishDuraEventSuc(getApplicationContext(), C8450a.m24469bn(l.longValue()), "Cover_Template_Download_Title", "list", l2, "subtitle");
            C5626m mVar = this.ctP;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(l);
            mVar.mo27664gt(sb3.toString());
        }
    }

    /* renamed from: n */
    public void mo27384n(Long l) {
        String by = C8759b.m25586by(l.longValue());
        if (this.ctA != null) {
            Message obtainMessage = this.ctA.obtainMessage(10111);
            obtainMessage.obj = by;
            obtainMessage.arg1 = 1;
            this.ctA.sendMessageDelayed(obtainMessage, 50);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        long j;
        String str = "";
        if (intent != null) {
            str = intent.getStringExtra("template_path");
            j = C8762d.aMt().getTemplateID(str);
        } else {
            j = 0;
        }
        if (i != 4369) {
            switch (i) {
                case 10102:
                    if (i2 == -1) {
                        Message obtainMessage = this.ctA.obtainMessage(10111);
                        obtainMessage.obj = str;
                        this.ctA.sendMessage(obtainMessage);
                        return;
                    } else if (C8759b.m25585b(5, this.mStoryBoard) > 0) {
                        return;
                    } else {
                        if (m15159gc(String.valueOf(QTemplateIDUtils.getTemplateType(j)))) {
                            if (this.ctO != null) {
                                this.ctO.mo27623p(true ^ this.ctQ, false);
                                return;
                            }
                            return;
                        } else if (this.ctP != null) {
                            this.ctP.mo27660eo(this.ctR);
                            this.ctR = true;
                            return;
                        } else {
                            return;
                        }
                    }
                case 10103:
                    if (i2 == -1) {
                        Message obtainMessage2 = this.ctA.obtainMessage(10112);
                        obtainMessage2.obj = str;
                        this.ctA.sendMessage(obtainMessage2);
                        return;
                    }
                    Message obtainMessage3 = this.ctA.obtainMessage(10112);
                    obtainMessage3.obj = "";
                    this.ctA.sendMessage(obtainMessage3);
                    return;
                default:
                    return;
            }
        } else if (this.ctW != null) {
            C8739i.m25523cC(this, this.ctW.ttid);
            if (m15159gc(String.valueOf(QTemplateIDUtils.getTemplateType(j)))) {
                mo27352a((TemplateInfo) this.ctW, "type_roll");
                this.ctO.mo27619gl(this.ctW.ttid);
                return;
            }
            mo27352a((TemplateInfo) this.ctW, "type_roll");
            this.ctP.mo27664gt(this.ctW.ttid);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if ("M040".equals(Build.MODEL) || NotchUtil.isNotchDevice()) {
            setTheme(R.style.Theme_XiaoYingNoSplash);
        }
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.ctC = extras.getString(PickCoverParams.ACTIVITY_COVER_PICK_RESULT_KEY);
            this.csK = (int) extras.getLong(PickCoverParams.ACTIVITY_COVER_PICK_TIME_POSITION_KEY);
            this.ctS = extras.getBoolean(PickCoverParams.BUNDLE_KEY_GO_MINI_PUBLISH_BOOL);
        }
        if (TextUtils.isEmpty(this.ctC) || !FileUtils.isValidFileName(this.ctC)) {
            finish();
            ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_ve_pick_cover_need_path_msg, 0);
            return;
        }
        setContentView(R.layout.editor_act_advance_pick_cover);
        if (this.csK <= 0) {
            this.csK = C8572y.m25104x(this.mStoryBoard);
        }
        aca();
        abs();
        abu();
        abt();
        abY();
        abZ();
        acb();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.ctE != null) {
            this.ctE.destroy();
        }
        if (this.ctA != null) {
            this.ctA.removeCallbacksAndMessages(null);
            this.ctA = null;
        }
        if (this.ctO != null) {
            this.ctO.ade();
            this.ctO = null;
        }
        if (this.ctP != null) {
            this.ctP.ade();
            this.ctP = null;
        }
        QComUtils.resetInstanceMembers(this);
        abS();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (C4580b.m11632Sf()) {
            return true;
        }
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.ctO != null && !this.ctO.ads()) {
            m15167kB(30);
            return true;
        } else if (this.ctP == null || this.ctP.ads()) {
            finish();
            return true;
        } else {
            m15167kB(35);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        abv();
        if (this.cso != null) {
            if (this.cso.isPlaying()) {
                this.cso.pause();
            }
            this.csK = this.cso.aIx();
            this.cso.aIt();
        }
        this.csE = true;
        if (isFinishing()) {
            if (C8746a.etx != null) {
                C8746a.etx.clear();
                C8746a.etx = null;
            }
            if (this.ctS) {
                VivaRouter.getRouterBuilder(DomeSocialPublishParams.URL).mo10400g(getIntent().getExtras()).mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_FROM_SOCIAL, true).mo10394aZ(R.anim.activity_enter, R.anim.activity_exit).mo10382H(this);
            }
            abS();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.csE && this.csT != null) {
            this.csT.sendEmptyMessageDelayed(TodoConstants.TODO_TYPE_QA_TEST, 50);
        }
        if (this.csE) {
            this.ctA.sendEmptyMessageDelayed(10301, 50);
        } else {
            this.ctA.sendEmptyMessageDelayed(10904, 100);
        }
        this.csE = false;
        if (this.ctO != null) {
            this.ctO.mo27623p(!this.ctQ, false);
            this.ctQ = false;
        }
    }
}
