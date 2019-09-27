package com.introvd.template.editor.advance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.StorageInfo;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.editor.advance.C5605j.C5608c;
import com.introvd.template.editor.advance.C5623l.C5625a;
import com.introvd.template.editor.advance.ScaleRotateViewV4.C5579a;
import com.introvd.template.editor.effects.bubble.subtitle.C6031g;
import com.introvd.template.editor.p266h.C6408m;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p375r.p376a.C8360a.C8362a;
import com.introvd.template.p414ui.dialog.C8950d;
import com.introvd.template.p414ui.dialog.C8950d.C8955b;
import com.introvd.template.p414ui.dialog.C8950d.C8956c;
import com.introvd.template.p414ui.view.MultiColorBar;
import com.introvd.template.p414ui.view.MultiColorBar.C8981a;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;
import com.introvd.template.sdk.model.editor.TextEffectParams;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8533l;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.template.p407e.C8720b;
import com.introvd.template.template.p407e.C8720b.C8727c;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p408f.C8751e;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.clip.QEffect;

/* renamed from: com.introvd.template.editor.advance.m */
public class C5626m {
    /* access modifiers changed from: private */
    public static final String LOG_TAG = "m";
    private static ArrayList<StoryBoardItemInfo> cxu;
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (!C4580b.m11632Sf() && view.equals(C5626m.this.cxC) && C5626m.this.mHandler != null && C5626m.this.cwh != null) {
                C5626m.this.cxB.setCurColor(C5626m.this.cwh.getTextDftColor());
                Message obtainMessage = C5626m.this.mHandler.obtainMessage(TodoConstants.TODO_TYPE_H5_FOLLOW);
                obtainMessage.arg1 = C5626m.this.cwh.getTextDftColor();
                C5626m.this.mHandler.sendMessage(obtainMessage);
            }
        }
    };
    /* access modifiers changed from: private */
    public QEngine bPS = null;
    /* access modifiers changed from: private */
    public RelativeLayout bWd;
    /* access modifiers changed from: private */
    public Context context;
    private RelativeLayout ctD;
    private TextEffectParams cwA;
    private QEffect cwB = null;
    /* access modifiers changed from: private */
    public String cwD = "";
    /* access modifiers changed from: private */
    public C5599f cwE;
    private TemplateConditionModel cwF;
    public ScaleRotateViewV4 cwY;
    /* access modifiers changed from: private */
    public int cwZ = -1;
    /* access modifiers changed from: private */
    public ScaleRotateViewState cwh;
    /* access modifiers changed from: private */
    public C8759b cww = new C8759b(9);
    /* access modifiers changed from: private */
    public MSize cwx;
    /* access modifiers changed from: private */
    public String cwy = "";
    private C5653p cwz = new C5653p();
    private RecyclerView cxA;
    /* access modifiers changed from: private */
    public MultiColorBar cxB;
    /* access modifiers changed from: private */
    public ImageView cxC;
    /* access modifiers changed from: private */
    public C5601h cxD;
    /* access modifiers changed from: private */
    public ArrayList<StoryBoardItemInfo> cxE;
    /* access modifiers changed from: private */
    public C8720b cxF = null;
    /* access modifiers changed from: private */
    public C5640n cxG;
    private C5652o cxH = new C5652o() {
        public int adF() {
            return C5626m.this.cwZ;
        }

        public boolean adG() {
            if (C5626m.this.cwE != null) {
                C5626m.this.cwE.ace();
            }
            return false;
        }

        public boolean adH() {
            if (C5626m.this.cwE != null) {
                C5626m.this.cwE.aci();
            }
            return false;
        }

        /* renamed from: b */
        public void mo27680b(RollInfo rollInfo) {
            if (C5626m.this.cwE != null) {
                C5626m.this.cwE.mo27422a(rollInfo);
            }
        }

        /* renamed from: c */
        public void mo27681c(EffectInfoModel effectInfoModel) {
            if (C5626m.this.cwE != null) {
                C5626m.this.cwE.mo27428b(effectInfoModel);
            }
        }

        /* renamed from: kX */
        public void mo27682kX(int i) {
            if (C5626m.this.cwE != null) {
                if (!C5626m.this.cwE.aci()) {
                    C5626m.this.cwE.onItemClicked(i);
                } else {
                    return;
                }
            }
            C5626m.this.adg();
            if (C5626m.this.cwZ != i) {
                C5626m.this.cwZ = i;
                C5626m.this.cxG.adI();
                EffectInfoModel vh = C5626m.this.cww.mo35214vh(C5626m.this.cwZ);
                if (vh != null) {
                    C6031g.m17115e(C5626m.this.context, vh.mName, C8450a.m24469bn(vh.mTemplateId), C8450a.m24466bk(vh.mTemplateId));
                }
            }
            C5626m.this.adp();
            C5626m.this.adw();
            C5626m.this.mo27641a(C5626m.this.adr(), (QEffect) null, true);
            C5626m.this.ady();
        }
    };
    private C8362a cxI = new C8362a() {
        /* renamed from: z */
        public void mo27631z(View view, int i) {
            if (!C4580b.m11632Sf()) {
                if (i == 0) {
                    new C5600g(C5626m.this.bWd.getContext()).show();
                    return;
                }
                if (i == 1) {
                    C5626m.this.cxw = "";
                } else {
                    StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) C5626m.this.cxD.getItem(i);
                    if (storyBoardItemInfo != null) {
                        if (TextUtils.isEmpty(storyBoardItemInfo.mFontPath)) {
                            View findViewById = view.findViewById(R.id.edit_subtitle_font_item_download_layout);
                            if (findViewById != null) {
                                findViewById.performClick();
                            }
                            return;
                        }
                        C5626m.this.cxw = storyBoardItemInfo.mFontPath;
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("name", FileUtils.getFileName(C5626m.this.cxw));
                UserBehaviorLog.onKVEvent(C5626m.this.bWd.getContext(), "VE_Font_Show", hashMap);
                if (C5626m.this.cwZ >= 0) {
                    Message obtainMessage = C5626m.this.mHandler.obtainMessage(10005);
                    obtainMessage.obj = C5626m.this.cxw;
                    C5626m.this.mHandler.sendMessage(obtainMessage);
                    int ajC = C5626m.this.cxD.ajC();
                    C5626m.this.cxD.mo27533kP(i);
                    C5626m.this.cxD.notifyItemChanged(ajC);
                    C5626m.this.cxD.notifyItemChanged(i);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public C8956c cxJ = new C8956c() {
        /* renamed from: a */
        public void mo27683a(int i, CharSequence charSequence) {
            switch (i) {
                case 1:
                    if (C5626m.this.cwY != null) {
                        String charSequence2 = charSequence.toString();
                        if (!TextUtils.equals(charSequence2, C5626m.this.cwh.getTextBubbleText())) {
                            C5626m.this.cwh.setTextBubbleText(charSequence2);
                            C5626m.this.m15501gm(C5626m.this.adr());
                            C5626m.this.cwY.setScaleViewState(C5626m.this.cwh);
                            C5626m.this.cwY.mo27439eh(true);
                            C5626m.this.cwY.invalidate();
                            if (C5626m.this.cwE != null) {
                                C5626m.this.cwE.acf();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    /* access modifiers changed from: private */
    public C8955b cxK = new C8955b() {
        /* renamed from: gv */
        public boolean mo27669gv(String str) {
            if (C6408m.m18454iO(str)) {
                return true;
            }
            ToastUtils.show(C5626m.this.bWd.getContext(), R.string.xiaoying_str_ve_msg_no_valid_char, 0);
            return false;
        }
    };
    private C8981a cxL = new C8981a() {
        /* renamed from: g */
        public void mo27671g(int i, float f) {
            if (C5626m.this.mHandler != null) {
                Message obtainMessage = C5626m.this.mHandler.obtainMessage(TodoConstants.TODO_TYPE_H5_FOLLOW);
                obtainMessage.arg1 = i;
                C5626m.this.mHandler.sendMessage(obtainMessage);
            }
        }

        /* renamed from: kW */
        public void mo27672kW(int i) {
        }
    };
    private C5608c cxg = new C5608c() {
        public void aan() {
            if (C5626m.this.cwE != null) {
                C5626m.this.cwE.ach();
            }
            C5626m.this.cwZ = -1;
            C5626m.this.cwy = "";
            C5626m.this.cwD = "";
            C5626m.this.adl();
            C5626m.this.cxG.adI();
        }

        /* renamed from: eg */
        public void mo27599eg(boolean z) {
            C5626m.this.adg();
            ScaleRotateViewState scaleViewState = C5626m.this.cwY.getScaleViewState();
            scaleViewState.mBitmap = C5626m.this.cwh.mBitmap;
            C5626m.this.cwh = scaleViewState;
            if (C5626m.this.cwY != null) {
                if (z) {
                    C5626m.this.cwh.setVerFlip(!C5626m.this.cwh.isVerFlip);
                } else {
                    C5626m.this.cwh.setHorFlip(!C5626m.this.cwh.isHorFlip);
                }
                C5626m.this.m15501gm(C5626m.this.adr());
                C5626m.this.cwY.setScaleViewState(C5626m.this.cwh);
                C5626m.this.cwY.mo27439eh(true);
                C5626m.this.cwY.invalidate();
                if (C5626m.this.cwE != null) {
                    C5626m.this.cwE.acf();
                }
                UserBehaviorLog.onKVEvent(C5626m.this.bWd.getContext().getApplicationContext(), "VE_Title_Flip", new HashMap());
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean cxh = false;
    private C5579a cxi = new C5579a() {
        /* renamed from: A */
        public void mo27462A(MotionEvent motionEvent) {
            if (C5626m.this.cwE != null) {
                C5626m.this.cwE.onSingleTapUp(motionEvent);
            }
        }

        /* renamed from: B */
        public void mo27463B(MotionEvent motionEvent) {
        }

        public void ada() {
            LogUtils.m14223i(C5626m.LOG_TAG, "onDownOp ");
            C5626m.this.cxh = false;
        }

        public void adb() {
            if (C5626m.this.cwY != null) {
                C8950d dVar = new C8950d(C5626m.this.bWd.getContext(), C5626m.this.cwY.getScaleViewState().getTextBubbleText(), C5626m.this.cxJ, false);
                try {
                    dVar.mo35604a(C5626m.this.cxK);
                    dVar.mo35594dR(R.string.xiaoying_str_com_cancel, R.string.xiaoying_str_com_ok);
                    dVar.show();
                    C5626m.this.adg();
                } catch (Exception e) {
                    String adB = C5626m.LOG_TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ex:");
                    sb.append(e.getMessage());
                    LogUtils.m14222e(adB, sb.toString());
                }
            }
        }

        /* renamed from: ei */
        public void mo27466ei(boolean z) {
            String adB = C5626m.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onUpOp bNeedUpdateThumb=");
            sb.append(z);
            LogUtils.m14223i(adB, sb.toString());
            if (!(C5626m.this.cwh == null || C5626m.this.cwY == null)) {
                C5626m.this.m15487a(C5626m.this.cwY.getScaleViewState(), false);
                String l = C5626m.this.adr();
                VeMSize veMSize = null;
                if (C5626m.this.cwx != null) {
                    veMSize = new VeMSize(C5626m.this.cwx.width, C5626m.this.cwx.height);
                }
                Bitmap b = C8530i.m24757b(C5626m.this.bPS, C5626m.this.cwh, l, veMSize);
                if (b != null) {
                    C5626m.this.cwh.mBitmap = b;
                    if (C5626m.this.cwY != null) {
                        C5626m.this.cwY.setScaleViewState(C5626m.this.cwh);
                        C5626m.this.cwY.mo27439eh(true);
                        C5626m.this.cwY.invalidate();
                    }
                } else {
                    return;
                }
            }
            if (C5626m.this.cxh && C5626m.this.cwE != null) {
                C5626m.this.cwE.acf();
            }
        }

        /* renamed from: ej */
        public void mo27467ej(boolean z) {
            String adB = C5626m.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onMoveOp bNeedUpdateThumb=");
            sb.append(z);
            LogUtils.m14223i(adB, sb.toString());
            C5626m.this.cxh = true;
        }
    };
    private C5625a cxs = new C5625a() {
        /* renamed from: kV */
        public void mo27638kV(int i) {
            if (C5626m.this.cwE != null) {
                C5626m.this.cwE.acj();
            }
            if (i == 1 && C5626m.this.cxB != null && C5626m.this.cwh != null) {
                C5626m.this.cxB.setCurColor(C5626m.this.cwh.getTextColor());
            }
        }
    };
    private C8533l cxv = new C8533l();
    public String cxw = "";
    private C5623l cxx;
    private RelativeLayout cxy;
    private RelativeLayout cxz;
    /* access modifiers changed from: private */
    public Handler mHandler = new C5639a(this);

    /* renamed from: com.introvd.template.editor.advance.m$a */
    private static class C5639a extends Handler {
        private WeakReference<C5626m> csX = null;

        public C5639a(C5626m mVar) {
            this.csX = new WeakReference<>(mVar);
        }

        public void handleMessage(Message message) {
            C5626m mVar = (C5626m) this.csX.get();
            if (mVar != null) {
                int i = message.what;
                if (i == 10003) {
                    int i2 = message.arg1;
                    if (!(mVar.cwY == null || mVar.cwh == null || mVar.cwZ <= -1)) {
                        mVar.cwh.setTextColor(i2);
                        mVar.m15501gm(mVar.adr());
                        mVar.cwY.setScaleViewState(mVar.cwh);
                        mVar.cwY.mo27439eh(true);
                        if (mVar.cwE != null) {
                            mVar.cwE.acf();
                        }
                    }
                } else if (i == 10005) {
                    String str = (String) message.obj;
                    if (mVar.cwY != null && mVar.cwZ > -1) {
                        mVar.cwh.setFontPath(str);
                        mVar.m15501gm(mVar.adr());
                        mVar.cwY.setScaleViewState(mVar.cwh);
                        mVar.cwY.mo27439eh(true);
                        if (mVar.cwE != null) {
                            mVar.cwE.acf();
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("name", str);
                        UserBehaviorLog.onKVEvent(mVar.bWd.getContext().getApplicationContext(), "Cover_Template_Use_Font", hashMap);
                    }
                }
            }
        }
    }

    public C5626m(RelativeLayout relativeLayout, MSize mSize, TemplateConditionModel templateConditionModel) {
        this.context = relativeLayout.getContext();
        this.bWd = relativeLayout;
        this.cwx = mSize;
        this.cwF = templateConditionModel;
        this.cxF = new C8720b(this.context);
        this.cww.mo35198a(this.context, -1, templateConditionModel, AppStateModel.getInstance().isInChina());
        initUI();
        this.cxG = new C5640n(this.cxy, this.cww);
        this.cxG.mo27685a(this.cxH);
        this.cwY = m15480a(this.bWd.getContext(), this.ctD, this.cxi, this.cxg);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m15479a(ArrayList<StoryBoardItemInfo> arrayList, String str) {
        if (arrayList != null) {
            int size = arrayList.size();
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("subtitle style count = ");
            sb.append(size);
            LogUtils.m14223i(str2, sb.toString());
            for (int i = 0; i < size; i++) {
                StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) arrayList.get(i);
                if (!TextUtils.isEmpty(str) && TextUtils.equals(str, storyBoardItemInfo.mFontPath)) {
                    return i;
                }
            }
        }
        return 1;
    }

    /* renamed from: a */
    public static ScaleRotateViewV4 m15480a(Context context2, RelativeLayout relativeLayout, C5579a aVar, C5608c cVar) {
        ScaleRotateViewV4 scaleRotateViewV4 = new ScaleRotateViewV4(context2);
        scaleRotateViewV4.setLayoutParams(new LayoutParams(-1, -1));
        relativeLayout.addView(scaleRotateViewV4);
        Resources resources = context2.getResources();
        Drawable drawable = resources.getDrawable(R.drawable.v4_xiaoying_ve_subtitle_horflip_btn_selector);
        Drawable drawable2 = resources.getDrawable(R.drawable.v4_xiaoying_ve_subtitle_verflip_btn_selector);
        scaleRotateViewV4.setAnchorDrawable(resources.getDrawable(R.drawable.v4_xiaoying_com_btn_text_zoom_drawable_selector), resources.getDrawable(R.drawable.xiaoying_ve_text_del_icon));
        scaleRotateViewV4.setFlipDrawable(drawable, drawable2);
        scaleRotateViewV4.setmOnGestureListener(aVar);
        scaleRotateViewV4.setDelListener(cVar);
        return scaleRotateViewV4;
    }

    /* renamed from: a */
    public static TextEffectParams m15482a(String str, ScaleRotateViewState scaleRotateViewState, String str2) {
        String textBubbleText = scaleRotateViewState.getTextBubbleText();
        if (TextUtils.isEmpty(str)) {
            str = scaleRotateViewState.mStylePath;
        }
        RectF t = C8530i.m24763t(scaleRotateViewState);
        TextEffectParams c = m15494c(scaleRotateViewState);
        c.setmTextRect(t);
        c.setmEffectStylePath(str);
        c.setmTextRangeLen(-1);
        c.setApplyInWholeClip(true);
        c.setAnimOn(false);
        c.bShowStaticPicture = true;
        c.setmTxtContent(textBubbleText);
        c.setmFontPath(str2);
        c.setmTemplateId(C8762d.aMt().getTemplateID(str));
        return c;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15487a(ScaleRotateViewState scaleRotateViewState, boolean z) {
        this.cwh = scaleRotateViewState;
    }

    /* access modifiers changed from: private */
    /* renamed from: aH */
    public List<StoryBoardItemInfo> m15490aH(List<TemplateInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (TemplateInfo templateInfo : new ArrayList(list)) {
            StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
            storyBoardItemInfo.mFontInfo = templateInfo;
            storyBoardItemInfo.mFontPath = this.cxF.mo35113qf(templateInfo.ttid);
            arrayList.add(storyBoardItemInfo);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void adg() {
        if (this.cwY != null && this.cwY.getVisibility() == 0) {
            ScaleRotateViewState scaleViewState = this.cwY.getScaleViewState();
            if (scaleViewState != null && this.cwz != null) {
                this.cwD = adr();
                mo27640a(scaleViewState, this.cwD);
            }
        }
    }

    private void adh() {
        if (this.cww != null) {
            this.cwZ = this.cww.mo35208qC(this.cwD);
        }
    }

    private void ado() {
        if (this.cwh != null) {
            this.cwY.setScaleViewState(this.cwh);
            this.cwY.mo27439eh(true);
            this.cwY.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void adp() {
        this.cxw = "";
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
        return this.cww.mo35210qG(this.cwZ);
    }

    private void adu() {
        this.cxx = new C5623l(this.cxz);
        this.cxx.adc();
        this.cxx.mo27633a(this.cxs);
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
        final List aH = m15490aH(this.cxF.aLW());
        arrayList.addAll(aH);
        this.cxF.mo35102a((C8727c) new C8727c() {
            public boolean adC() {
                return false;
            }

            public boolean adD() {
                arrayList.removeAll(aH);
                aH.clear();
                aH.addAll(C5626m.this.m15490aH(C5626m.this.cxF.aLW()));
                arrayList.addAll(aH);
                if (C5626m.this.cxD != null) {
                    C5626m.this.cxD.mo27533kP(C5626m.this.m15479a(arrayList, C5626m.this.cxw));
                    C5626m.this.cxD.notifyDataSetChanged();
                }
                return false;
            }

            public boolean adE() {
                if (C5626m.this.cxD != null) {
                    C5626m.this.cxD.notifyDataSetChanged();
                }
                return false;
            }
        });
        this.cxF.aLV();
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void ady() {
        if (this.cwE != null && this.cwY != null) {
            String qG = this.cww.mo35210qG(this.cwZ);
            if (!TextUtils.isEmpty(qG)) {
                this.cwA = m15482a(qG, this.cwY.getScaleViewState(), this.cxw);
                m15502gs("VE_Title_Animate_Add");
                this.cwE.mo27421a(this.cwA);
            }
        }
    }

    /* renamed from: c */
    private static TextEffectParams m15494c(ScaleRotateViewState scaleRotateViewState) {
        TextEffectParams textEffectParams = new TextEffectParams();
        TextBubble textBubble = scaleRotateViewState.getTextBubble();
        if (textBubble != null) {
            textEffectParams.setmTxtColor(textBubble.mTextColor);
            textEffectParams.setmTextAlignment(textBubble.mTextAlignment);
            textEffectParams.setmShadowInfo(textBubble.mShadowInfo);
            textEffectParams.setmStrokeInfo(textBubble.mStrokeInfo);
            textEffectParams.setmTxtContent(textBubble.mText);
        }
        textEffectParams.setAnimOn(scaleRotateViewState.isAnimOn());
        textEffectParams.setmAngle(scaleRotateViewState.mDegree);
        textEffectParams.setHorFlip(scaleRotateViewState.isHorFlip);
        textEffectParams.setVerFlip(scaleRotateViewState.isVerFlip);
        textEffectParams.setVersion(scaleRotateViewState.mVersion);
        textEffectParams.setmEffectStylePath(scaleRotateViewState.mStylePath);
        textEffectParams.setApplyInWholeClip(false);
        return textEffectParams;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"UseValueOf"})
    /* renamed from: gm */
    public boolean m15501gm(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap b = C8530i.m24757b(this.bPS, this.cwh, str, this.cwx != null ? new VeMSize(this.cwx.width, this.cwx.height) : null);
        if (b == null) {
            return false;
        }
        String str2 = LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("prepareBitmap time consume:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtils.m14223i(str2, sb.toString());
        this.cwh.mBitmap = b;
        return true;
    }

    /* renamed from: gs */
    private void m15502gs(String str) {
        EffectInfoModel vh = this.cww.mo35214vh(this.cwZ);
        if (vh != null && C8450a.m24466bk(vh.mTemplateId)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", vh.mName);
            hashMap.put("ttid", C8450a.m24469bn(vh.mTemplateId));
            UserBehaviorLog.onKVEvent(this.bWd.getContext(), str, hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m15505i(ArrayList<StoryBoardItemInfo> arrayList) {
        if (this.cxA != null) {
            int a = m15479a(arrayList, this.cxw);
            this.cxD = new C5601h(this.bWd.getContext(), arrayList, this.cxF);
            this.cxD.mo27533kP(a);
            this.cxA.setAdapter(this.cxD);
            this.cxD.mo33617a(this.cxI);
        }
    }

    private void initUI() {
        this.cxz = (RelativeLayout) this.bWd.findViewById(R.id.relative_layout);
        this.ctD = (RelativeLayout) this.bWd.findViewById(R.id.preview_layout_fake);
        this.cxy = (RelativeLayout) this.bWd.findViewById(R.id.relativelayout_theme_content);
        adv();
        this.cxA = (RecyclerView) this.bWd.findViewById(R.id.xiaoying_layout_storyboard_view_fonts);
        this.cxA.setLayoutManager(new GridLayoutManager(this.bWd.getContext(), 2, 0, false));
        this.cxB = (MultiColorBar) this.bWd.findViewById(R.id.multicolor_bar);
        this.cxB.setOnColorChangerListener(this.cxL);
        this.cxC = (ImageView) this.bWd.findViewById(R.id.btn_color_reset);
        this.cxC.setOnClickListener(this.acD);
    }

    /* renamed from: x */
    private float m15520x(float f, float f2) {
        float f3 = f2 / 2.0f;
        return f - f3 < 0.0f ? f3 : f + f3 > ((float) this.cwx.width) ? ((float) this.cwx.width) - f3 : f;
    }

    /* renamed from: y */
    private float m15521y(float f, float f2) {
        float f3 = f2 / 2.0f;
        return f - f3 < 0.0f ? f3 : f + f3 > ((float) this.cwx.height) ? ((float) this.cwx.height) - f3 : f;
    }

    /* renamed from: a */
    public void mo27639a(C5653p pVar, ScaleRotateViewState scaleRotateViewState, String str, boolean z) {
        if (pVar != null) {
            if (!(pVar.cxX == null || (pVar.cxX.x == 0.0f && pVar.cxX.y == 0.0f))) {
                scaleRotateViewState.mPosInfo.setmCenterPosX(pVar.cxX.x);
                scaleRotateViewState.mPosInfo.setmCenterPosY(pVar.cxX.y);
            }
            scaleRotateViewState.mDegree = pVar.mAngle;
            if (pVar.cvt > 0.0f) {
                scaleRotateViewState.mPosInfo.setmWidth((float) ((int) (scaleRotateViewState.mPosInfo.getmWidth() / pVar.cvt)));
                scaleRotateViewState.mPosInfo.setmHeight((float) ((int) (scaleRotateViewState.mPosInfo.getmHeight() / pVar.cvt)));
            }
            TextBubble textBubble = scaleRotateViewState.getTextBubble();
            if (textBubble != null) {
                textBubble.mTextAlignment = pVar.cye;
            }
            if (z && TextUtils.equals(str, pVar.cxY)) {
                scaleRotateViewState.setTextColor(pVar.cxZ.intValue());
            }
            scaleRotateViewState.setAnimOn(pVar.cyc.booleanValue());
        }
    }

    /* renamed from: a */
    public void mo27640a(ScaleRotateViewState scaleRotateViewState, String str) {
        if (this.cwz != null && scaleRotateViewState != null && FileUtils.isFileExisted(str)) {
            if (this.cwz.cxX == null) {
                this.cwz.cxX = new PointF();
            }
            this.cwz.cxX.x = scaleRotateViewState.mPosInfo.getmCenterPosX();
            this.cwz.cxX.y = scaleRotateViewState.mPosInfo.getmCenterPosY();
            this.cwz.mAngle = scaleRotateViewState.mDegree;
            VeMSize veMSize = null;
            TextBubble dftTextBubble = scaleRotateViewState.mTextBubbleInfo != null ? scaleRotateViewState.mTextBubbleInfo.getDftTextBubble() : null;
            if (dftTextBubble != null) {
                this.cwz.cye = dftTextBubble.mTextAlignment;
                this.cwz.mFontPath = dftTextBubble.mFontPath;
            }
            this.cwz.cyd = false;
            if (this.cwx != null) {
                veMSize = new VeMSize(this.cwx.width, this.cwx.height);
            }
            ScaleRotateViewState c = C8538o.m24868c(this.bPS, str, veMSize);
            float f = c != null ? c.mPosInfo.getmHeight() : 0.0f;
            float f2 = scaleRotateViewState.mPosInfo.getmHeight();
            if (scaleRotateViewState.isDftTemplate && scaleRotateViewState.mLineNum > 0) {
                f2 = scaleRotateViewState.mPosInfo.getmHeight() / ((float) scaleRotateViewState.mLineNum);
            }
            if (f > 0.0f && f2 > 0.0f) {
                this.cwz.cvt = f / f2;
            }
            if (dftTextBubble != null && !scaleRotateViewState.bNeedTranslate) {
                String str2 = dftTextBubble.mText;
                String str3 = dftTextBubble.mDftText;
                if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str3, str2) && (TextUtils.isEmpty(this.cwz.cya) || !TextUtils.equals(str2, this.cwz.cyb))) {
                    this.cwz.cya = str2;
                }
            }
            if (scaleRotateViewState.mTextBubbleInfo != null) {
                this.cwz.cyc = Boolean.valueOf(scaleRotateViewState.mTextBubbleInfo.isAnimOn);
                if (dftTextBubble != null) {
                    this.cwz.cxZ = Integer.valueOf(dftTextBubble.mTextColor);
                }
            }
            this.cwz.cyb = "";
            this.cwz.cxY = str;
        }
    }

    /* renamed from: a */
    public void mo27641a(String str, QEffect qEffect, boolean z) {
        if (this.cwY != null) {
            VeMSize veMSize = null;
            if (qEffect == null) {
                if (this.cwx != null) {
                    veMSize = new VeMSize(this.cwx.width, this.cwx.height);
                }
                ScaleRotateViewState c = C8538o.m24868c(this.bPS, str, veMSize);
                if (c != null) {
                    c.setTextBubbleText(this.context.getResources().getString(R.string.viva_subtitle_default_title));
                    Random random = new Random();
                    float x = m15520x(((float) (this.cwx.width / 2)) + (((random.nextFloat() * ((float) this.cwx.width)) / 2.0f) - ((float) (this.cwx.width / 4))), c.mPosInfo.getmWidth());
                    float y = m15521y(((float) (this.cwx.height / 2)) + (((random.nextFloat() * ((float) this.cwx.height)) / 2.0f) - ((float) (this.cwx.height / 4))), c.mPosInfo.getmHeight());
                    c.mPosInfo.setmCenterPosX(x);
                    c.mPosInfo.setmCenterPosY(y);
                    m15487a(c, true);
                }
                if (this.cwh != null) {
                    this.cwh.setFontPath(this.cxw);
                    mo27639a(this.cwz, this.cwh, str, z);
                    String textBubbleText = this.cwh.getTextBubbleText();
                    String str2 = this.cwz.cya;
                    if (mo27643a(this.cwh, textBubbleText, str2)) {
                        this.cwz.cyb = str2;
                    }
                    if (this.cwY != null) {
                        if (m15501gm(str)) {
                            ado();
                        } else {
                            ToastUtils.show(this.bWd.getContext(), R.string.xiaoying_str_ve_msg_not_support_ttf, 0);
                            if (this.cwE != null) {
                                this.cwE.mo27429dU(true);
                            }
                        }
                    }
                } else {
                    adl();
                    adp();
                }
                this.cwD = str;
            } else {
                adp();
                if (this.cwx != null) {
                    veMSize = new VeMSize(this.cwx.width, this.cwx.height);
                }
                m15487a(C8538o.m24850a(this.bPS, qEffect, veMSize), true);
                if (!TextUtils.isEmpty(this.cxw)) {
                    this.cwh.setFontPath(this.cxw);
                } else {
                    this.cxw = this.cwh.getTextFontPath();
                }
                String e = C8538o.m24872e(qEffect);
                if (m15501gm(e)) {
                    ado();
                } else {
                    ToastUtils.show(this.bWd.getContext(), R.string.xiaoying_str_ve_msg_not_support_ttf, 0);
                    if (this.cwE != null) {
                        this.cwE.mo27429dU(true);
                    }
                }
                this.cwD = e;
            }
        }
    }

    /* renamed from: a */
    public void mo27642a(QEngine qEngine) {
        this.bPS = qEngine;
    }

    /* renamed from: a */
    public boolean mo27643a(ScaleRotateViewState scaleRotateViewState, String str, String str2) {
        String str3 = "";
        boolean z = false;
        if (this.cxv == null) {
            str2 = str3;
        } else if (TextUtils.isEmpty(str2) || scaleRotateViewState.bNeedTranslate) {
            str2 = this.cxv.mo34790oN(str);
        } else {
            z = true;
        }
        scaleRotateViewState.setTextBubbleText(str2);
        return z;
    }

    public void adA() {
        if (this.cwz != null) {
            this.cwz.cya = "";
        }
    }

    public void adc() {
        adu();
        add();
        this.cxx.mo27635en(false);
        this.cxG.mo27690q(true, false);
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) throws Exception {
                C5626m.this.cxE = C5626m.this.adx();
                return Boolean.valueOf(true);
            }
        }).mo10200k(900, TimeUnit.MILLISECONDS).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C5626m.this.m15505i(C5626m.this.cxE);
            }

            public void onError(Throwable th) {
            }
        });
    }

    public void add() {
        this.cwZ = this.cww.mo35208qC(this.cwy);
    }

    public void ade() {
        if (this.cwY != null) {
            this.ctD.removeView(this.cwY);
            this.cwY = null;
        }
        if (this.cxG != null) {
            this.cxG.ade();
        }
        if (this.cww != null) {
            this.cww.unInit(true);
        }
        if (this.cxF != null) {
            this.cxF.release();
        }
    }

    public void adk() {
        if (this.cxx != null) {
            this.cxx.mo27636kP(0);
        }
        C4562a.m11534b(this.cxz, true, true, 0);
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
        if (this.cxG != null) {
            this.cxG.adI();
        }
    }

    public QEffect adq() {
        return this.cwB;
    }

    public boolean ads() {
        boolean z = true;
        if (this.cxz == null) {
            return true;
        }
        if (this.cxz.getVisibility() == 0) {
            z = false;
        }
        return z;
    }

    public void adw() {
        if (this.cxE != null && this.cxD != null && this.cxA != null) {
            this.cxD.mo27533kP(m15479a(this.cxE, this.cxw));
            this.cxD.notifyDataSetChanged();
        }
    }

    public TextEffectParams adz() {
        if (this.cwY == null) {
            return null;
        }
        ScaleRotateViewState scaleViewState = this.cwY.getScaleViewState();
        String qG = this.cww.mo35210qG(this.cwZ);
        if (TextUtils.isEmpty(qG)) {
            return null;
        }
        return m15482a(qG, scaleViewState, this.cxw);
    }

    /* renamed from: b */
    public void mo27656b(C5599f fVar) {
        this.cwE = fVar;
    }

    /* renamed from: b */
    public void mo27657b(QEffect qEffect) {
        this.cwB = qEffect;
    }

    /* renamed from: ek */
    public void mo27658ek(boolean z) {
        if (this.cww != null) {
            int count = this.cww.getCount();
            this.cww.mo35198a(this.bWd.getContext(), -1, this.cwF, AppStateModel.getInstance().isInChina());
            if (count != this.cww.getCount() || z) {
                this.cwZ = this.cww.mo35208qC(this.cwD);
                this.cxG.mo27690q(true, false);
                return;
            }
            adh();
        }
    }

    /* renamed from: em */
    public void mo27659em(boolean z) {
        C4562a.m11534b(this.cxz, false, true, 0);
        if (z) {
            adl();
        }
    }

    /* renamed from: eo */
    public void mo27660eo(boolean z) {
        this.cww.mo35198a(this.bWd.getContext(), -1, this.cwF, AppStateModel.getInstance().isInChina());
        this.cwZ = this.cww.mo35208qC(this.cwD);
        this.cxG.mo27690q(z, false);
    }

    /* renamed from: gn */
    public void mo27661gn(String str) {
        this.cwy = str;
    }

    /* renamed from: go */
    public void mo27662go(String str) {
        this.cwD = str;
    }

    /* renamed from: gr */
    public void mo27663gr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cxw = str;
        }
        this.cxE = adx();
        m15505i(this.cxE);
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(10005);
            obtainMessage.obj = this.cxw;
            this.mHandler.sendMessageDelayed(obtainMessage, 100);
        }
    }

    /* renamed from: gt */
    public void mo27664gt(String str) {
        boolean isInChina = AppStateModel.getInstance().isInChina();
        if (this.cww != null) {
            this.cww.mo35198a(this.bWd.getContext(), -1, this.cwF, isInChina);
        }
        if (this.cxG != null) {
            this.cxG.mo27689gl(str);
        }
    }

    /* renamed from: gu */
    public void mo27665gu(String str) {
        this.cxw = str;
    }

    public void onResume() {
        boolean aq = C8735f.aMf().mo35143aq(this.bWd.getContext(), C8399c.edb);
        ImageView imageView = (ImageView) this.bWd.findViewById(R.id.img_new_flag);
        if (imageView == null) {
            return;
        }
        if (aq) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
    }

    /* renamed from: v */
    public void mo27667v(String str, int i) {
        this.cxG.mo27691v(str, i);
    }
}
