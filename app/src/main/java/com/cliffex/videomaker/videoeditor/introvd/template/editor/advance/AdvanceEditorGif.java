package com.introvd.template.editor.advance;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.AppMiscListener;
import com.introvd.template.C4681i;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.common.p236ui.popup.MenuItem;
import com.introvd.template.common.p236ui.popup.PopupMenu;
import com.introvd.template.common.p236ui.popup.PopupMenu.OnItemSelectedListener;
import com.introvd.template.editor.R;
import com.introvd.template.editor.export.C6255i;
import com.introvd.template.editor.export.C6257k;
import com.introvd.template.editor.p266h.C6397i;
import com.introvd.template.editor.p266h.C6397i.C6403a;
import com.introvd.template.editor.p266h.C6404j;
import com.introvd.template.editor.videotrim.p292ui.C7005a;
import com.introvd.template.editor.videotrim.p292ui.C7005a.C7009b;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.model.GifExpModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.storyboard.QStoryboard;

public class AdvanceEditorGif extends AdvanceBaseEditActivity {
    /* access modifiers changed from: private */
    public ImageView bZM;
    private DataItemProject ctb;
    private C6397i ctc = null;
    private GifExpModel ctd = new GifExpModel();
    /* access modifiers changed from: private */
    public C5567a cte = new C5567a(this);
    /* access modifiers changed from: private */
    public Button ctf;
    private RelativeLayout ctg;
    /* access modifiers changed from: private */
    public C7005a cth;
    /* access modifiers changed from: private */
    public ImageButton cti;
    /* access modifiers changed from: private */
    public RelativeLayout ctj;
    /* access modifiers changed from: private */
    public RelativeLayout ctk;
    /* access modifiers changed from: private */
    public Button ctl;
    private int ctm;
    private int ctn = 0;
    private int cto = 0;
    private boolean ctp = false;
    /* access modifiers changed from: private */
    public C6257k ctq = null;
    /* access modifiers changed from: private */
    public String ctr;
    private C7009b cts = new C7009b() {
        /* renamed from: i */
        public void mo27404i(boolean z, int i) {
            AdvanceEditorGif.this.ctu = false;
            AdvanceEditorGif.this.cte.removeMessages(102);
            AdvanceEditorGif.this.ctv = !z;
            AdvanceEditorGif.this.ctx = z;
            AdvanceEditorGif.this.abN();
            if (!(AdvanceEditorGif.this.cso == null || AdvanceEditorGif.this.mStoryBoard == null)) {
                AdvanceEditorGif.this.cso.mo34188dF(0, AdvanceEditorGif.this.mStoryBoard.getDuration());
            }
            AdvanceEditorGif.this.cth.mo30898hr(false);
            AdvanceEditorGif.this.ctt = true;
            AdvanceEditorGif.this.cte.removeMessages(101);
            AdvanceEditorGif.this.mo27373dO(false);
            AdvanceEditorGif.this.m15072D(i, false);
        }

        /* renamed from: iD */
        public void mo27405iD(int i) {
            String abU = AdvanceEditorGif.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onProgressChanged progress=");
            sb.append(i);
            LogUtils.m14223i(abU, sb.toString());
            if (AdvanceEditorGif.this.cst != null && AdvanceEditorGif.this.cst.isAlive()) {
                AdvanceEditorGif.this.cst.seekTo(i);
            }
            AdvanceEditorGif.this.m15072D(i, false);
        }

        /* renamed from: kA */
        public void mo27406kA(int i) {
            if (AdvanceEditorGif.this.cst != null && AdvanceEditorGif.this.cst.isAlive()) {
                int i2 = i - 10;
                if (i2 <= 0) {
                    i2 = 0;
                }
                AdvanceEditorGif.this.cst.seekTo(i2);
            }
            AdvanceEditorGif.this.m15072D(i, false);
            AdvanceEditorGif.this.abK();
        }

        /* renamed from: ky */
        public void mo27407ky(int i) {
            String abV = AdvanceEditorGif.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onTrimEnd updateTrimTimeView onEndSeek progress=");
            sb.append(i);
            LogUtils.m14223i(abV, sb.toString());
            if (AdvanceEditorGif.this.cst != null && AdvanceEditorGif.this.cst.isAlive()) {
                int i2 = i - 10;
                if (i2 <= 0) {
                    i2 = 0;
                }
                AdvanceEditorGif.this.cst.seekTo(i2);
            }
            AdvanceEditorGif.this.m15072D(i, false);
            AdvanceEditorGif.this.abK();
            AdvanceEditorGif.this.abR();
        }

        /* renamed from: kz */
        public void mo27408kz(int i) {
            AdvanceEditorGif.this.cte.removeMessages(102);
            AdvanceEditorGif.this.ctw = true;
            AdvanceEditorGif.this.ctu = true;
            AdvanceEditorGif.this.abN();
            AdvanceEditorGif.this.mo27373dO(false);
            AdvanceEditorGif.this.m15072D(i, false);
        }
    };
    /* access modifiers changed from: private */
    public volatile boolean ctt = false;
    /* access modifiers changed from: private */
    public volatile boolean ctu = true;
    /* access modifiers changed from: private */
    public volatile boolean ctv = false;
    /* access modifiers changed from: private */
    public volatile boolean ctw = false;
    /* access modifiers changed from: private */
    public volatile boolean ctx = false;
    /* access modifiers changed from: private */
    public boolean isExporting = false;

    /* renamed from: po */
    private OnClickListener f3475po = new OnClickListener() {
        public void onClick(View view) {
            if (AdvanceEditorGif.this.bZM.equals(view)) {
                AdvanceEditorGif.this.abA();
                AdvanceEditorGif.this.finish();
            } else if (AdvanceEditorGif.this.ctf.equals(view)) {
                AdvanceEditorGif.this.abM();
            } else if (AdvanceEditorGif.this.cti.equals(view)) {
                if (AdvanceEditorGif.this.cth != null) {
                    AdvanceEditorGif.this.cth.mo30898hr(true);
                }
                AdvanceEditorGif.this.m15091dR(true);
                AdvanceEditorGif.this.abO();
            } else if (AdvanceEditorGif.this.csQ.equals(view)) {
                AdvanceEditorGif.this.abN();
                if (AdvanceEditorGif.this.cth != null) {
                    AdvanceEditorGif.this.cth.mo30898hr(false);
                }
            } else if (AdvanceEditorGif.this.ctk.equals(view)) {
                AdvanceEditorGif.this.abQ();
            } else if (AdvanceEditorGif.this.ctj.equals(view)) {
                AdvanceEditorGif.this.abP();
            } else if (AdvanceEditorGif.this.ctl.equals(view)) {
                AdvanceEditorGif.this.abN();
                if (AdvanceEditorGif.this.cth != null) {
                    AdvanceEditorGif.this.cth.mo30898hr(false);
                }
                C8049f.aBf().mo33097b(AdvanceEditorGif.this, C8070o.aBw(), C7825a.DURATION_LIMIT.getId(), "gif", 1000);
            }
        }
    };

    /* renamed from: com.introvd.template.editor.advance.AdvanceEditorGif$a */
    private static class C5567a extends WeakHandler<AdvanceEditorGif> {
        public C5567a(AdvanceEditorGif advanceEditorGif) {
            super(advanceEditorGif);
        }

        public void handleMessage(Message message) {
            AdvanceEditorGif advanceEditorGif = (AdvanceEditorGif) getOwner();
            if (advanceEditorGif != null) {
                int i = message.what;
                if (i == 101) {
                    C4582c.m11669dF(advanceEditorGif);
                    advanceEditorGif.abO();
                } else if (!(i != 10301 || advanceEditorGif.cso == null || advanceEditorGif.csu == null)) {
                    if (advanceEditorGif.csH) {
                        advanceEditorGif.csH = false;
                        advanceEditorGif.cso.mo34168a(advanceEditorGif.csu.mo27761a(advanceEditorGif.css, 1, advanceEditorGif.csD), advanceEditorGif.csK);
                    } else {
                        advanceEditorGif.cso.aIB();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m15072D(int i, boolean z) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("updateProgress before time =");
        sb.append(i);
        sb.append(";isGallerySeek=");
        sb.append(this.ctt);
        LogUtils.m14223i(str, sb.toString());
        if (!this.ctt && this.cth != null) {
            this.cth.mo30891E(i, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15076a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            this.ctd.expSize = new VeMSize(480, 480);
        } else if (itemId == 1) {
            this.ctd.expSize = new VeMSize(320, 320);
        } else if (itemId == 2) {
            this.ctd.expSize = new VeMSize(240, 240);
        }
        this.ctn = itemId;
        ((TextView) this.ctj.getChildAt(0)).setText(menuItem.getTitle());
    }

    /* access modifiers changed from: private */
    public void abM() {
        if (this.ctd != null) {
            if (this.ctd.expFps <= 0) {
                this.ctd.expFps = 15;
            }
            if (this.ctd.expSize == null) {
                this.ctd.expSize = new VeMSize(480, 480);
            }
            if (this.cth != null) {
                int atJ = this.cth.atJ();
                this.ctd.mExpVeRange = new VeRange(atJ, this.cth.atK() - atJ);
            } else {
                this.ctd.mExpVeRange = new VeRange(0, 5000);
            }
        }
        if (this.csJ != null) {
            DataItemProject dataItemProject = this.bMM.aHf().mProjectDataItem;
            this.ctc.mo29447a((Activity) this, (C8381b) this.bMM, this.bOK, C6404j.m18433a(getApplicationContext(), dataItemProject.strPrjURL, dataItemProject.isMVPrj(), 3, this.ctd, false), (C6403a) new C6403a() {
                public void abW() {
                }

                public void abX() {
                    AdvanceEditorGif.this.bMM.mo33876a(AdvanceEditorGif.this.bMM.aHe(), AppStateModel.getInstance().isCommunitySupport());
                    C4597i.m11728a(false, AdvanceEditorGif.this);
                    C4596h.m11717Sq();
                    C4596h.m11719Ss();
                    AdvanceEditorGif.this.m15090dQ(false);
                    AdvanceEditorGif.this.isExporting = false;
                }

                /* renamed from: dT */
                public void mo27398dT(boolean z) {
                    AdvanceEditorGif.this.isExporting = z;
                }

                /* renamed from: fY */
                public void mo27399fY(String str) {
                    AdvanceEditorGif.this.ctr = str;
                    AdvanceEditorGif.this.bMM.mo33876a(AdvanceEditorGif.this.bMM.aHe(), AppStateModel.getInstance().isCommunitySupport());
                    C4597i.m11728a(false, AdvanceEditorGif.this);
                    C4596h.m11717Sq();
                    C4596h.m11719Ss();
                    if (AdvanceEditorGif.this.ctq == null || !AdvanceEditorGif.this.ctq.isShowing()) {
                        AdvanceEditorGif.this.m15098fX(str);
                    }
                    AdvanceEditorGif.this.isExporting = false;
                }

                /* renamed from: fZ */
                public void mo27400fZ(String str) {
                    if (!AdvanceEditorGif.this.isFinishing()) {
                        if (AdvanceEditorGif.this.ctq == null || AdvanceEditorGif.this.ctq.isShowing()) {
                            AdvanceEditorGif.this.ctq = new C6257k(AdvanceEditorGif.this, C6255i.m17928fI(AppStateModel.getInstance().isInChina()));
                            AdvanceEditorGif.this.ctq.setOnDismissListener(new OnDismissListener() {
                                public void onDismiss(DialogInterface dialogInterface) {
                                    if (!AdvanceEditorGif.this.isExporting) {
                                        AdvanceEditorGif.this.m15098fX(AdvanceEditorGif.this.ctr);
                                    }
                                }
                            });
                            AdvanceEditorGif.this.ctq.show();
                        } else {
                            AdvanceEditorGif.this.ctq.show();
                        }
                    }
                }

                /* renamed from: kw */
                public void mo27401kw(int i) {
                    AdvanceEditorGif.this.bMM.mo33876a(AdvanceEditorGif.this.bMM.aHe(), AppStateModel.getInstance().isCommunitySupport());
                    C4597i.m11728a(false, AdvanceEditorGif.this);
                    C4596h.m11717Sq();
                    C4596h.m11719Ss();
                    AdvanceEditorGif.this.m15090dQ(false);
                    AdvanceEditorGif.this.isExporting = false;
                }

                /* renamed from: kx */
                public void mo27402kx(int i) {
                }
            });
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("gif_params", this.ctd);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void abN() {
        if (this.cso != null) {
            this.cso.pause();
        }
    }

    /* access modifiers changed from: private */
    public void abO() {
        if (this.cso != null) {
            this.cso.play();
        }
    }

    /* access modifiers changed from: private */
    public void abP() {
        String[] strArr = {"480P", "320P", "240P"};
        PopupMenu popupMenu = new PopupMenu(this, true, this.ctn);
        popupMenu.setWindowBg(R.drawable.viva_popmenu_bg_noarrow);
        popupMenu.setWidth(120);
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            popupMenu.add(i2, strArr[i]);
            i++;
            i2 = i3;
        }
        popupMenu.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(MenuItem menuItem) {
                AdvanceEditorGif.this.m15076a(menuItem);
            }
        });
        popupMenu.bForceUnder = true;
        popupMenu.show(this.ctj);
    }

    /* access modifiers changed from: private */
    public void abQ() {
        String[] strArr = {"15F/s", "10F/s", "5F/s"};
        PopupMenu popupMenu = new PopupMenu(this, true, this.cto);
        popupMenu.setWidth(120);
        popupMenu.setWindowBg(R.drawable.viva_popmenu_bg_noarrow);
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            popupMenu.add(i2, strArr[i]);
            i++;
            i2 = i3;
        }
        popupMenu.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(MenuItem menuItem) {
                AdvanceEditorGif.this.m15081b(menuItem);
            }
        });
        popupMenu.bForceUnder = true;
        popupMenu.show(this.ctk);
    }

    /* access modifiers changed from: private */
    public void abR() {
        if (this.cso == null || !this.cso.isPlaying()) {
            this.cti.setVisibility(0);
        } else {
            this.cti.setVisibility(4);
        }
    }

    private void abS() {
        if (this.cso != null) {
            this.cso.aIv();
            this.cso = null;
        }
    }

    private void abT() {
        boolean z = !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId());
        if (this.ctp != z) {
            m15089dP(z);
            if (this.cth != null) {
                this.cth.destroy();
                this.cth = null;
            }
            m15092dS(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15081b(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            this.ctd.expFps = 15;
        } else if (itemId == 1) {
            this.ctd.expFps = 10;
        } else if (itemId == 2) {
            this.ctd.expFps = 5;
        }
        this.cto = itemId;
        ((TextView) this.ctk.getChildAt(0)).setText(menuItem.getTitle());
    }

    /* renamed from: dP */
    private void m15089dP(boolean z) {
        QStoryboard aHd = this.bMM.aHd();
        if (aHd != null) {
            int duration = aHd.getDuration();
            if (!z || duration <= 5000) {
                this.ctl.setVisibility(8);
                this.ctf.setText(R.string.xiaoying_str_studio_export_and_upload);
            } else {
                String str = "5";
                this.ctl.setText(getString(R.string.xiaoying_str_gif_export_limit, new Object[]{str}));
                this.ctl.setVisibility(0);
                this.ctf.setText(getString(R.string.xiaoying_str_gif_export_five_second_title, new Object[]{str}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dQ */
    public void m15090dQ(boolean z) {
        if (this.csJ != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", z ? "succeed" : ParametersKeys.FAILED);
            UserBehaviorLog.onKVEvent(this, "VE_Gif_Function_Export_done", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dR */
    public void m15091dR(boolean z) {
        if (this.cso != null && this.cth != null) {
            this.cth.atH();
            if (z) {
                int atJ = this.cth.atJ();
                this.cso.mo34186d(new VeRange(atJ, this.cth.atK() - atJ));
                this.cso.mo34196uf(atJ);
            } else if (this.mStoryBoard != null) {
                this.cso.mo34188dF(0, this.mStoryBoard.getDuration());
            }
        }
    }

    /* renamed from: dS */
    private void m15092dS(boolean z) {
        if (this.mStoryBoard != null) {
            this.ctm = z ? 5000 : Integer.MAX_VALUE;
            this.cth = new C7005a((View) this.ctg.getParent(), this.mStoryBoard.getDataClip(), this.ctm);
            this.cth.mo30892a(this.cts);
            this.cth.mo30900pH(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            this.cth.load();
        }
    }

    /* renamed from: e */
    private void m15094e(TODOParamModel tODOParamModel) {
        if (tODOParamModel != null) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(tODOParamModel.mJsonParam);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString("resolution");
                String optString2 = jSONObject.optString("FPS");
                MenuItem menuItem = new MenuItem();
                if ("320P".equals(optString)) {
                    menuItem.setItemId(1);
                    menuItem.setTitle("320P");
                } else if ("240P".equals(optString)) {
                    menuItem.setItemId(2);
                    menuItem.setTitle("240P");
                } else {
                    menuItem.setItemId(0);
                    menuItem.setTitle("480P");
                }
                m15076a(menuItem);
                MenuItem menuItem2 = new MenuItem();
                if ("10".equals(optString2)) {
                    menuItem2.setItemId(1);
                    menuItem2.setTitle("10F/s");
                } else if ("5".equals(optString2)) {
                    menuItem2.setItemId(2);
                    menuItem2.setTitle("5F/s");
                } else {
                    menuItem2.setItemId(0);
                    menuItem2.setTitle("15F/s");
                }
                m15081b(menuItem2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fX */
    public void m15098fX(String str) {
        boolean isCommunitySupport = AppStateModel.getInstance().isCommunitySupport();
        boolean isInChina = AppStateModel.getInstance().isInChina();
        String str2 = null;
        if (!isCommunitySupport) {
            AppMiscListener Gr = C4681i.m12184Gp().mo25016Gr();
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                str2 = aHe.strPrjThumbnail;
            }
            Gr.launchExportResult(this, str2, str, true, -1);
            finish();
        } else if (isInChina) {
            DataItemProject aHe2 = this.bMM.aHe();
            if (aHe2 != null && C8446b.aIZ().mo34321bh(aHe2._id) == 5) {
                C8446b.aIZ().mo34326k(getApplicationContext(), aHe2._id);
            }
            StudioRouter.launchStudioActivity(this);
            finish();
        } else {
            AppMiscListener Gr2 = C4681i.m12184Gp().mo25016Gr();
            DataItemProject aHe3 = this.bMM.aHe();
            if (aHe3 != null) {
                str2 = aHe3.strPrjThumbnail;
            }
            Gr2.launchExportResult(this, str2, str, true, 1001);
        }
        m15090dQ(true);
    }

    private void updateProgress(int i) {
        abR();
    }

    /* access modifiers changed from: protected */
    public void abA() {
        if (this.csJ != null) {
            EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
            editorIntentInfo.baseMode = 1;
            editorIntentInfo.secondaryMode = -1;
            EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.generateUrl(EditorRouter.EDITOR_URL, editorIntentInfo, this.csJ));
        }
    }

    /* access modifiers changed from: protected */
    public void abI() {
        if (this.ctt) {
            this.ctt = false;
            if (this.ctv) {
                this.ctv = false;
            }
        } else if (this.ctw) {
            if (this.cte != null) {
                this.cte.removeMessages(101);
                this.cte.sendEmptyMessage(101);
            }
            this.ctw = false;
        }
        this.ctu = true;
    }

    /* access modifiers changed from: protected */
    public void aby() {
    }

    /* access modifiers changed from: protected */
    public boolean abz() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getPlayerInitTime() {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ks */
    public int mo27378ks(int i) {
        m15072D(i, false);
        updateProgress(i);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: kt */
    public int mo27379kt(int i) {
        updateProgress(i);
        m15072D(i, false);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ku */
    public int mo27380ku(int i) {
        updateProgress(i);
        if (!this.ctt) {
            m15072D(i, false);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: kv */
    public int mo27381kv(int i) {
        if (this.cth != null) {
            this.cth.mo30898hr(false);
        }
        updateProgress(i);
        m15072D(i, false);
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1000 && i == 1001 && i2 == -1) {
            finish();
        }
    }

    public void onBackPressed() {
        abA();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.editor_act_advance_gif);
        this.bMM = C8522g.aJA();
        this.ctb = (DataItemProject) getIntent().getExtras().getParcelable("bundle_key_prjdata");
        if (this.bMM.mo34762d(this.ctb) == null) {
            LogUtilsV2.m14228e("The project is not passed.");
            finish();
            return;
        }
        this.ctc = new C6397i(getApplicationContext(), "gifexp");
        this.bMj = (RelativeLayout) findViewById(R.id.preview_layout);
        this.csQ = (RelativeLayout) findViewById(R.id.layout_pick_cover_preview_layout);
        this.bZM = (ImageView) findViewById(R.id.img_back);
        this.bZM.setOnClickListener(this.f3475po);
        ((TextView) findViewById(R.id.text_title)).setText(R.string.xiaoying_str_gif_exp_title);
        ((ImageView) findViewById(R.id.xiaoying_btn_finish)).setVisibility(4);
        this.ctf = (Button) findViewById(R.id.share_btn_share);
        this.ctf.setOnClickListener(this.f3475po);
        this.ctj = (RelativeLayout) findViewById(R.id.txtview_gif_size);
        this.ctk = (RelativeLayout) findViewById(R.id.txtview_gif_fps);
        this.ctk.setOnClickListener(this.f3475po);
        this.ctj.setOnClickListener(this.f3475po);
        this.ctg = (RelativeLayout) findViewById(R.id.relativelayout_trimgallery_content_area);
        this.cti = (ImageButton) findViewById(R.id.imgbtn_play);
        this.cti.setOnClickListener(this.f3475po);
        this.csQ.setOnClickListener(this.f3475po);
        this.ctl = (Button) findViewById(R.id.btn_vip);
        this.ctl.setOnClickListener(this.f3475po);
        abs();
        abu();
        abt();
        m15094e(this.csJ);
        this.ctp = !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId());
        m15089dP(this.ctp);
        m15092dS(this.ctp);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.cte != null) {
            this.cte.removeCallbacksAndMessages(null);
            this.cte = null;
        }
        abS();
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
            this.cte.sendEmptyMessageDelayed(10301, 50);
        }
        abT();
        this.csE = false;
    }
}
