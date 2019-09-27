package com.introvd.template.editor.gallery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.C0069g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.gson.Gson;
import com.introvd.template.EventActivity;
import com.introvd.template.common.ApiHelper;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.editor.R;
import com.introvd.template.editor.gallery.C6327a.C6331a;
import com.introvd.template.editor.gallery.p264a.C6332a;
import com.introvd.template.editor.gallery.p264a.C6343b;
import com.introvd.template.editor.gallery.preview.C6363a;
import com.introvd.template.editor.gallery.preview.C6364b;
import com.introvd.template.editor.gallery.preview.MediaTrimView;
import com.introvd.template.editor.gallery.preview.MediaTrimView.C6361a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.preview.fragment.p275b.C6651b;
import com.introvd.template.editor.widget.C7019a;
import com.introvd.template.editor.widget.C7019a.C7023a;
import com.introvd.template.explorer.p299d.C7187d;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.picker.C8171a;
import com.introvd.template.picker.C8186b;
import com.introvd.template.picker.MediaPickerView;
import com.introvd.template.picker.p366b.C8189b;
import com.introvd.template.picker.p367c.C8215c;
import com.introvd.template.picker.p369d.C8218b;
import com.introvd.template.router.FuncExportRouter;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EngineSubtitleInfoModel;
import com.introvd.template.sdk.utils.C8555k;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p133a.C2564c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@C1942a(mo10417rZ = "/gallery/entry")
public class GalleryActivity extends EventActivity implements C0069g, OnClickListener, C6343b {
    private boolean bMn = true;
    private String bMy = null;
    /* access modifiers changed from: private */
    public MediaPickerView cRU;
    /* access modifiers changed from: private */
    public MediaTrimView cRV;
    private LinearLayout cRW;
    private ImageView cRX;
    private ImageView cRY;
    private TextView cRZ;
    private GalleryIntentInfo cSA;
    /* access modifiers changed from: private */
    public C6651b cSB;
    /* access modifiers changed from: private */
    public long cSC;
    private GalleryPicPreDecodeRx cSD;
    C7023a cSE = new C7023a() {
        public void onCancel() {
            GalleryActivity.this.cSz = false;
            GalleryActivity.this.amC();
            if (GalleryActivity.this.cSu != null) {
                GalleryActivity.this.cSu.amH();
            }
            long currentTimeMillis = System.currentTimeMillis() - GalleryActivity.this.cSC;
            C6344b.m18171a(GalleryActivity.this.getApplicationContext(), "Gallery_Import_Transcode_Cancel", C6348d.amK().amS(), currentTimeMillis, C6348d.amK().mo29375fX(false), C6348d.amK().mo29375fX(true));
        }
    };
    /* access modifiers changed from: private */
    public TextView cSa;
    private TextView cSb;
    /* access modifiers changed from: private */
    public View cSc;
    private RelativeLayout cSd;
    /* access modifiers changed from: private */
    public LinearLayout cSe;
    /* access modifiers changed from: private */
    public TextView cSf;
    /* access modifiers changed from: private */
    public RelativeLayout cSg;
    private C6327a cSh;
    private int cSi = 0;
    private int cSj = 0;
    private int cSk;
    /* access modifiers changed from: private */
    public int cSl = 0;
    private TODOParamModel cSm;
    private String cSn = "";
    private C6332a cSo;
    private int cSp = -1;
    private ArrayList<String> cSq;
    private boolean cSr;
    private BroadcastReceiver cSs;
    /* access modifiers changed from: private */
    public C7019a cSt;
    /* access modifiers changed from: private */
    public C6345c cSu;
    /* access modifiers changed from: private */
    public int cSv = 0;
    /* access modifiers changed from: private */
    public View cSw;
    /* access modifiers changed from: private */
    public boolean cSx;
    /* access modifiers changed from: private */
    public C1890f cSy;
    /* access modifiers changed from: private */
    public boolean cSz;
    private long lTemplateId;

    /* renamed from: Kl */
    private void m18067Kl() {
        this.cRV = (MediaTrimView) findViewById(R.id.preview_view);
        this.cRU = (MediaPickerView) findViewById(R.id.picker_view);
        getLifecycle().mo152a(this.cRU);
        amr();
        amq();
        ams();
        this.cRV.amX();
    }

    private boolean amm() {
        return this.cSj == 1 || this.cSr;
    }

    private void amn() {
        C8171a.init(getApplicationContext());
        int i = 0;
        C8171a.m23620ta(NotchUtil.isNotchDevice() ? C6386d.getStatusBarHeight(getApplicationContext()) : 0);
        C8171a.m23616iQ(AppStateModel.getInstance().isInChina());
        boolean z = true;
        if (this.cSj == 1 || this.cSr) {
            z = false;
        }
        C8171a.m23617iR(z);
        if (this.cSq != null && this.cSq.size() > 0) {
            if (this.cSp == 2001 || this.cSp == 2003) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator it = this.cSq.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (MediaFileUtils.IsVideoFileType(MediaFileUtils.GetFileMediaType(str))) {
                        arrayList.add(str);
                    }
                }
                this.cSq = arrayList;
            }
            C8171a.m23618q(this.cSq);
            Iterator it2 = this.cSq.iterator();
            while (it2.hasNext()) {
                if (MediaFileUtils.IsVideoFileType(MediaFileUtils.GetFileMediaType((String) it2.next()))) {
                    i++;
                }
            }
            Context applicationContext = getApplicationContext();
            String str2 = i == 0 ? "all pics" : i == this.cSq.size() ? "all videos" : "mixed";
            C6344b.m18179bz(applicationContext, str2);
        }
    }

    /* access modifiers changed from: private */
    public void amp() {
        this.cRU.postDelayed(new Runnable() {
            public void run() {
                if (GalleryActivity.this.cSv == 0 && !GalleryActivity.this.cSx && !GalleryActivity.this.isFinishing() && GalleryActivity.this.cSg != null && GalleryActivity.this.cRU != null) {
                    GalleryActivity.this.cSx = true;
                    GalleryActivity.this.cSg.setVisibility(0);
                    LayoutParams layoutParams = new LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    try {
                        GalleryActivity.this.cSg.addView(GalleryActivity.this.cSw, layoutParams);
                    } catch (Exception unused) {
                    }
                    C8171a.m23619sZ(C4583d.m11670O(GalleryActivity.this.getApplication(), 50));
                    GalleryActivity.this.cRU.mo33252sT(C4583d.m11670O(GalleryActivity.this.getApplication(), 50));
                    GalleryActivity.this.amq();
                }
            }
        }, 200);
    }

    /* access modifiers changed from: private */
    public void amq() {
        int i = C8218b.m23733gH(getApplicationContext()).widthPixels;
        int i2 = C8218b.m23733gH(getApplicationContext()).heightPixels;
        if (NotchUtil.isNotchDevice()) {
            i2 -= C6386d.getStatusBarHeight(this);
        }
        this.cRV.getLayoutParams().height = i;
        int O = this.cSx ? ((i2 + i) - C8171a.dXK) - C4583d.m11670O(getBaseContext(), 50) : (i2 + i) - C8171a.dXK;
        ViewGroup.LayoutParams layoutParams = this.cRU.getLayoutParams();
        layoutParams.height = O;
        this.cRU.setLayoutParams(layoutParams);
    }

    private void amr() {
        this.cSd = (RelativeLayout) findViewById(R.id.gallery_title_layout);
        this.cSc = findViewById(R.id.picker_blur_view);
        this.cRW = (LinearLayout) findViewById(R.id.gallery_chooser_layout);
        this.cRX = (ImageView) findViewById(R.id.iv_gallery_back);
        this.cSa = (TextView) findViewById(R.id.gallery_type);
        this.cRY = (ImageView) findViewById(R.id.gallery_change_icon);
        this.cSb = (TextView) findViewById(R.id.chooser_hint);
        this.cRZ = (TextView) findViewById(R.id.tv_next);
        this.cSe = (LinearLayout) findViewById(R.id.layout_ops_title);
        this.cSf = (TextView) findViewById(R.id.tv_ops_title);
        this.cSg = (RelativeLayout) findViewById(R.id.ad_container);
        this.cSc.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (GalleryActivity.this.cSc != null) {
                    GalleryActivity.this.cRU.mo33253sW(0);
                }
                return true;
            }
        });
        this.cSh = new C6327a(getApplicationContext(), new C6331a() {
            /* renamed from: nx */
            public void mo29305nx(int i) {
                if (i == 0) {
                    GalleryActivity.this.cSa.setText(R.string.xiaoying_str_ve_gallery_filter_menu_item_photo_only);
                } else if (i == 1) {
                    GalleryActivity.this.cSa.setText(R.string.xiaoying_str_ve_gallery_filter_menu_item_video_only);
                }
                if (GalleryActivity.this.cSB != null) {
                    GalleryActivity.this.cSB.hide();
                }
                GalleryActivity.this.cRU.mo33255sY(i);
            }

            public void onDismiss() {
                GalleryActivity.this.mo29294fU(false);
            }
        });
        if (this.cSi == 0) {
            this.cRY.setVisibility(0);
            this.cSb.setVisibility(0);
        } else {
            if (this.cSi == 2) {
                this.cSa.setText(R.string.xiaoying_str_ve_gallery_filter_menu_item_photo_only);
                this.cRU.mo33255sY(0);
            } else if (this.cSi == 1) {
                this.cSa.setText(R.string.xiaoying_str_ve_gallery_filter_menu_item_video_only);
            }
            this.cRY.setVisibility(8);
            this.cSb.setVisibility(8);
        }
        this.cSh.mo29329nz(this.cSi);
        DataItemProject aHe = this.cSo.adK().aHe();
        if (this.cSj == 2 && aHe != null && aHe.isMVPrj()) {
            this.cSh.mo29328nA(0);
        }
        if (amm()) {
            this.cSe.setVisibility(0);
            this.cSf.setText(R.string.xiaoying_str_ve_choose_videos_title);
        }
        if (this.cSp > 0 && this.cSq != null) {
            this.cRW.setVisibility(8);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void ams() {
        this.cRW.setOnClickListener(this);
        this.cRX.setOnClickListener(this);
        this.cRZ.setOnClickListener(this);
        this.cSc.setOnClickListener(this);
        this.cSe.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.cRU.setExternalCallback(new C8189b() {
            /* renamed from: aS */
            public void mo29308aS(final List<C8215c> list) {
                GalleryActivity.this.amt();
                if (list != null && list.size() > 0) {
                    GalleryActivity.this.cRV.postDelayed(new Runnable() {
                        public void run() {
                            ArrayList arrayList = new ArrayList();
                            for (C8215c cVar : list) {
                                arrayList.add(new C6363a(cVar.aFK(), cVar.getSourceType()));
                            }
                            GalleryActivity.this.cRV.mo29385aZ(arrayList);
                        }
                    }, 100);
                }
            }

            public void amD() {
                if (GalleryActivity.this.cRV != null) {
                    GalleryActivity.this.cRV.mo29390nH(0);
                }
            }

            public void amE() {
                if (GalleryActivity.this.cSB != null) {
                    GalleryActivity.this.cSB.hide();
                }
            }

            /* renamed from: c */
            public boolean mo29311c(int i, int i2, String str) {
                C6363a aVar = new C6363a(str, i);
                aVar.action = i2;
                boolean a = GalleryActivity.this.cRV.mo29384a(aVar);
                if (a && i2 > 0) {
                    GalleryActivity.this.amt();
                }
                boolean z = false;
                GalleryActivity.this.cRU.mo33253sW(0);
                boolean z2 = true;
                if (i2 == 1) {
                    if (i == 0) {
                        GalleryActivity.this.m18083hO(str);
                    }
                    if (GalleryActivity.this.cSB != null) {
                        GalleryActivity.this.cSB.hide();
                    }
                    GalleryActivity.this.cRV.mo29390nH(0);
                    GalleryActivity.this.m18090nv(i2);
                    try {
                        C6364b previewItem = GalleryActivity.this.cRV.getPreviewItem();
                        if (str != null && str.equals(previewItem.cTz.cTw)) {
                            z = true;
                        }
                        if (i == 0) {
                            C6344b.m18182f(GalleryActivity.this.getApplicationContext(), true, z);
                        } else {
                            C6344b.m18186g(GalleryActivity.this.getApplicationContext(), true, z);
                        }
                        C6344b.m18181e(GalleryActivity.this.getApplicationContext(), true, z);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (i2 == 2) {
                    try {
                        C6364b previewItem2 = GalleryActivity.this.cRV.getPreviewItem();
                        if (str == null || !str.equals(previewItem2.cTz.cTw)) {
                            z2 = false;
                        }
                        C6344b.m18181e(GalleryActivity.this.getApplicationContext(), false, z2);
                        if (i == 0) {
                            C6344b.m18182f(GalleryActivity.this.getApplicationContext(), false, z2);
                        } else {
                            C6344b.m18186g(GalleryActivity.this.getApplicationContext(), false, z2);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (i2 == 0) {
                    GalleryActivity.this.cSl = GalleryActivity.this.cSl + 1;
                    GalleryActivity.this.m18091nw(i2);
                }
                return a;
            }

            /* renamed from: i */
            public void mo29312i(boolean z, String str) {
                if (z && !TextUtils.isEmpty(str)) {
                    GalleryActivity.this.cSf.setText(str);
                }
                GalleryActivity.this.cSe.setVisibility(z ? 0 : 8);
            }

            /* renamed from: ny */
            public void mo29313ny(int i) {
                if (GalleryActivity.this.cRV != null) {
                    GalleryActivity.this.cRV.mo29390nH(-1);
                }
                GalleryActivity.this.cSv = i;
                GalleryActivity.this.cSc.setVisibility(i == 1 ? 0 : 8);
                if (i == 0 && GalleryActivity.this.cSw != null && !GalleryActivity.this.cSx) {
                    GalleryActivity.this.amp();
                }
            }
        });
        this.cRV.setAdContainerStateCallBack(new C6361a() {
            public boolean amF() {
                return GalleryActivity.this.cSg != null && GalleryActivity.this.cSg.getVisibility() == 0;
            }
        });
    }

    /* access modifiers changed from: private */
    public void amt() {
        int aFu = C8186b.aFr().aFu();
        if (aFu > 0) {
            StringBuilder sb = new StringBuilder(getString(R.string.xiaoying_str_com_next_step_title));
            sb.append("(");
            sb.append(aFu);
            sb.append(")");
            this.cRZ.setTextColor(getResources().getColor(R.color.color_ff5e13));
            this.cRZ.setText(sb);
            return;
        }
        this.cRZ.setTextColor(getResources().getColor(R.color.color_ff5e13_p50));
        this.cRZ.setText(getString(R.string.xiaoying_str_com_next_step_title));
    }

    /* access modifiers changed from: private */
    public void amu() {
        if (!(C6348d.amK().amN() > 0)) {
            int i = this.cSi != 0 ? this.cSi == 2 ? R.string.xiaoying_str_ve_msg_add_photos_tip : R.string.xiaoying_str_ve_msg_add_videos_or_photo_tip : R.string.xiaoying_str_ve_msg_add_videos_or_photo_tip;
            C4577f.m11626a((Context) this, 0, (View) this.cSd, i);
            if (this.cRU != null) {
                View firstCompletelyVisibleItemSelectBtn = this.cRU.getFirstCompletelyVisibleItemSelectBtn();
                if (firstCompletelyVisibleItemSelectBtn != null) {
                    if (this.cRV != null) {
                        this.cRV.mo29390nH(-1);
                    }
                    if (C4580b.m11666qi()) {
                        this.cSB.mo30034b(firstCompletelyVisibleItemSelectBtn, 3, getResources().getString(R.string.xiaoying_str_gallery_check_help_tip), C4580b.m11666qi(), -C4583d.dpFloatToPixel(getApplicationContext(), 115.0f), 0);
                    } else {
                        this.cSB.mo30034b(firstCompletelyVisibleItemSelectBtn, 3, getResources().getString(R.string.xiaoying_str_gallery_check_help_tip), C4580b.m11666qi(), 0, 0);
                    }
                }
            }
            return;
        }
        if (this.cSm != null && this.cSm.getActivityFlag() > 0) {
            if (this.cSm.getActivityFlag() == 2) {
                boolean z = !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId());
                boolean z2 = C6348d.amK().amR() > 300000;
                if (z && z2) {
                    ToastUtils.show(getApplicationContext(), getString(R.string.xiaoying_str_com_user_other_channel_export_tip, new Object[]{"5"}), 1);
                    return;
                }
            }
        }
        this.cRV.mo29387fY(false);
        amv();
        if (C6348d.amK().amP()) {
            this.cSC = System.currentTimeMillis();
            C6344b.m18172b(getApplicationContext(), C6348d.amK().amS(), C6348d.amK().mo29375fX(false), C6348d.amK().mo29375fX(true));
            int amN = C6348d.amK().amN();
            int amQ = C6348d.amK().amQ();
            if (this.cSt != null) {
                this.cSt.cancel();
                this.cSt = null;
            }
            this.cSt = new C7019a(this, amN);
            this.cSt.mo30938a(this.cSE);
            this.cSt.show();
            this.cSt.mo30941qb(amQ);
            C4597i.m11729b(true, this);
            amx();
            DataItemProject aHe = C8522g.aJA().aHe();
            if (aHe == null) {
                this.cSo.mo29340f(null);
                aHe = C8522g.aJA().aHe();
                if (aHe == null) {
                    return;
                }
            }
            String str = aHe.strPrjURL;
            if (this.cSu != null) {
                this.cSu.release();
                this.cSu = null;
            }
            this.cSu = new C6345c(getApplicationContext());
            if (!this.cSu.mo29352hU(str)) {
                if (this.cSt != null) {
                    this.cSt.cancel();
                    this.cSt = null;
                }
                this.cRV.onResume();
                C4597i.m11729b(false, this);
            }
        } else {
            amw();
        }
    }

    private void amv() {
        if (this.cSD != null) {
            this.cSD.stop();
            List<TrimedClipItemDataModel> amO = C6348d.amK().amO();
            if (amO != null && amO.size() != 0) {
                for (TrimedClipItemDataModel trimedClipItemDataModel : amO) {
                    if (trimedClipItemDataModel.isImage.booleanValue() && !FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                        String hT = this.cSD.mo29321hT(trimedClipItemDataModel.mRawFilePath);
                        if (FileUtils.isFileExisted(hT)) {
                            trimedClipItemDataModel.mExportPath = hT;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Jamin PreDecoder mExportPath = ");
                            sb.append(hT);
                            LogUtilsV2.m14227d(sb.toString());
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void amw() {
        StringBuilder sb = new StringBuilder();
        sb.append("____GalleryAction==");
        sb.append(this.cSj);
        sb.append(",CreateANewProject==");
        sb.append(this.bMn);
        LogUtilsV2.m14230i(sb.toString());
        C6344b.m18185g(getApplicationContext(), "Next", true);
        List<TrimedClipItemDataModel> amO = C6348d.amK().amO();
        StringBuilder sb2 = new StringBuilder();
        for (TrimedClipItemDataModel trimedClipItemDataModel : amO) {
            if (trimedClipItemDataModel.isImage.booleanValue()) {
                if (sb2.length() > 0) {
                    sb2.append("_");
                }
                sb2.append(trimedClipItemDataModel.repeatCount);
            }
        }
        C6344b.m18173bA(getApplicationContext(), sb2.toString());
        if (this.cSj == 2) {
            ArrayList arrayList = new ArrayList(amO);
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra(MediaGalleryRouter.INTENT_BACK_RANGE_LIST_KEY, arrayList);
            setResult(-1, intent);
            finish();
        } else if (this.cSj == 1 || this.cSj == 4) {
            TrimedClipItemDataModel trimedClipItemDataModel2 = (TrimedClipItemDataModel) amO.get(0);
            Intent intent2 = new Intent();
            intent2.putExtra(GalleryRouter.INTENT_DATA_BACK_KEY, trimedClipItemDataModel2);
            setResult(-1, intent2);
            finish();
        } else if (this.cSr) {
            this.cSo.mo29338b((TrimedClipItemDataModel) amO.get(0), getResources().getDimensionPixelSize(R.dimen.time_line_item_width_height));
        } else if (this.bMn) {
            C4586g.m11704a((Context) this, R.string.xiaoying_str_com_loading, (OnCancelListener) null, false);
            if (this.cSp > 0) {
                this.cSo.mo29339c(amO, false);
            } else {
                this.cSo.mo29335aW(amO);
            }
        }
    }

    private void amx() {
        if (this.cSs == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.quvideo.vivavideo.xyeditor.transcode.done");
            intentFilter.addAction("com.quvideo.vivavideo.xyeditor.transcode.update");
            intentFilter.addAction("com.quvideo.vivavideo.xyeditor.transcode.secondaryupdate");
            this.cSs = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    String stringExtra = intent.getStringExtra("result");
                    StringBuilder sb = new StringBuilder();
                    sb.append("transService onReceive action=");
                    sb.append(action);
                    sb.append(",result=");
                    sb.append(stringExtra);
                    LogUtilsV2.m14230i(sb.toString());
                    if ("com.quvideo.vivavideo.xyeditor.transcode.update".equals(action)) {
                        if (GalleryActivity.this.cSt != null) {
                            GalleryActivity.this.cSt.mo30941qb(intent.getIntExtra(SocialConstDef.SEARCH_HISTORY_COUNT, 0));
                        }
                    } else if ("com.quvideo.vivavideo.xyeditor.transcode.secondaryupdate".equals(action)) {
                        GalleryActivity.this.cSt.mo30942qc(intent.getIntExtra("progress", 0));
                    } else if ("com.quvideo.vivavideo.xyeditor.transcode.done".equals(action)) {
                        C4597i.m11729b(false, GalleryActivity.this);
                        GalleryActivity.this.cSt.mo30942qc(100);
                        if (GalleryActivity.this.cRV != null) {
                            GalleryActivity.this.cRV.postDelayed(new Runnable() {
                                public void run() {
                                    if (GalleryActivity.this.cSt != null && !GalleryActivity.this.isFinishing()) {
                                        GalleryActivity.this.amw();
                                        GalleryActivity.this.cSt.cancel();
                                        GalleryActivity.this.cSt = null;
                                    }
                                }
                            }, 500);
                        }
                        long currentTimeMillis = System.currentTimeMillis() - GalleryActivity.this.cSC;
                        C6344b.m18171a(GalleryActivity.this.getApplicationContext(), "Gallery_Import_Trancode_Done", C6348d.amK().amS(), currentTimeMillis, C6348d.amK().mo29375fX(false), C6348d.amK().mo29375fX(true));
                        GalleryActivity.this.amC();
                    }
                }
            };
            LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.cSs, intentFilter);
        }
    }

    private void amy() {
        if (this.cSm == null || this.cSm.mTODOCode <= 0) {
            EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent()));
        } else if (this.cSm.getActivityFlag() > 0) {
            if (this.cSm.getActivityFlag() == 2) {
                Long k = C8555k.m25011k(this.cSm.getJsonObj());
                if (k.longValue() > 0) {
                    String bB = C8762d.aMt().mo35225bB(k.longValue());
                    if (!TextUtils.isEmpty(bB)) {
                        this.cSo.mo29344x(getApplicationContext(), C8522g.aJA().aHe().strPrjURL, bB);
                        return;
                    }
                }
            }
            if (!(this.cSo.adK() == null || this.cSo.adK().aHe() == null)) {
                FuncExportRouter.launchFuncExportActivity(this, this.cSm);
            }
        } else {
            EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent()));
        }
        try {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.introvd.template.finishactivity"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4586g.m11696Sm();
        finish();
    }

    private void amz() {
        switch (this.cSp) {
            case 2004:
                try {
                    LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.introvd.template.finishactivity"));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
        }
        EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent()));
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: hO */
    public void m18083hO(String str) {
        DataItemProject aHe = C8522g.aJA().aHe();
        if (this.cSD != null && aHe != null) {
            String str2 = aHe.strPrjURL;
            if (!TextUtils.isEmpty(str2)) {
                this.cSD.mo29319hQ(str2);
                this.cSD.mo29320hR(str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nv */
    public void m18090nv(int i) {
        if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("gallery_trim_help_show", false) && C8186b.aFr().aFu() > 3 && this.cRV != null && !this.cRV.cTC) {
            this.cRV.mo29389nG(i);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("gallery_trim_help_show", true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nw */
    public void m18091nw(int i) {
        if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("gallery_check_clip_help_show", false) && C8186b.aFr().aFu() == 0 && this.cSl > 3 && this.cRV != null) {
            this.cRV.mo29389nG(i);
            AppPreferencesSetting.getInstance().setAppSettingBoolean("gallery_check_clip_help_show", true);
        }
    }

    /* renamed from: a */
    public void mo29288a(TrimedClipItemDataModel trimedClipItemDataModel) {
        if (trimedClipItemDataModel != null) {
            this.cSo.amV();
            C4586g.m11703a(getBaseContext(), R.string.xiaoying_str_com_loading, (OnCancelListener) null);
            ArrayList arrayList = new ArrayList();
            arrayList.add(trimedClipItemDataModel);
            this.cSo.mo29339c(arrayList, false);
        }
    }

    /* renamed from: aR */
    public void mo29289aR(List<EngineSubtitleInfoModel> list) {
        if (list != null && list.size() > 0) {
            EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent()));
        } else if (!(this.cSo.adK() == null || this.cSo.adK().aHe() == null)) {
            FuncExportRouter.launchFuncExportActivity(this, this.cSm);
        }
        C4586g.m11696Sm();
        finish();
    }

    public int amA() {
        return this.cSk;
    }

    public void amB() {
        if (C6348d.amK().amN() <= 0 || this.cSj == 2 || this.cSr || this.cSj == 1) {
            finish();
            return;
        }
        if (this.cSy == null) {
            this.cSy = C8978m.m26348af(this, getString(R.string.xiaoying_str_com_discard_title), getString(R.string.xiaoying_str_com_save_title)).mo10296do(R.string.xiaoying_str_com_msg_save_draft_ask).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    C6344b.m18185g(GalleryActivity.this.getApplicationContext(), "Save", true);
                    C5554b.recordPrjSave(GalleryActivity.this.getApplicationContext(), "gallery");
                    GalleryActivity.this.cSy.dismiss();
                    GalleryActivity.this.cSz = true;
                    GalleryActivity.this.amu();
                }
            }).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    C6344b.m18185g(GalleryActivity.this.getApplicationContext(), "Discard", true);
                    GalleryActivity.this.finish();
                }
            }).mo10313qu();
        }
        if (!this.cSy.isShowing()) {
            this.cSy.show();
        }
    }

    public void amC() {
        if (this.cSs != null) {
            LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.cSs);
            this.cSs = null;
        }
    }

    public TODOParamModel amo() {
        return this.cSm;
    }

    /* renamed from: fU */
    public void mo29294fU(boolean z) {
        this.cRY.clearAnimation();
        RotateAnimation rotateAnimation = z ? new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f) : new RotateAnimation(180.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(10);
        this.cRY.setAnimation(rotateAnimation);
    }

    /* renamed from: fV */
    public void mo29295fV(boolean z) {
        C4586g.m11696Sm();
        if (z) {
            this.cSo.amV();
            this.cSo.saveCurrProject();
            amz();
        }
    }

    /* renamed from: fW */
    public void mo29296fW(boolean z) {
        C4586g.m11696Sm();
        if (this.cSz) {
            finish();
        } else {
            amy();
        }
    }

    public void finishActivity() {
        finish();
    }

    public String getEntrance() {
        return this.cSn;
    }

    public long getTemplateID() {
        return this.lTemplateId;
    }

    /* renamed from: hP */
    public void mo29300hP(String str) {
        this.cSn = str;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.cRU != null) {
            this.cRU.mo33248b(i, i2, intent);
        }
    }

    public void onAdLoaded(View view) {
        if (!isFinishing() && view != null) {
            this.cSw = view;
            amp();
        }
    }

    public void onBackPressed() {
        if (!this.cRU.onBackPressed()) {
            amB();
        }
    }

    public void onClick(View view) {
        if (!C4580b.m11632Sf()) {
            if (view == this.cRX) {
                amB();
            } else if (view == this.cRZ) {
                C2564c.m7327dA(this.cRZ);
                int amN = C6348d.amK().amN();
                int amM = C6348d.amK().amM();
                C6344b.m18170a(getApplicationContext(), amN, amN - amM, amM, C6348d.amK().amR(), true);
                amu();
            } else if (view == this.cRW && this.cSh != null && this.cSh.amG() > 1 && !isFinishing()) {
                C6344b.m18183fa(getApplicationContext());
                mo29294fU(true);
                this.cSh.mo29326B(this.cRW, (this.cSx ? C8171a.dXK + C4583d.m11670O(getApplication(), 50) : C8171a.dXK) + C8171a.aFo());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if ("M040".equals(Build.MODEL) || NotchUtil.isNotchDevice()) {
            setTheme(R.style.Theme_XiaoYingNoSplash);
        }
        super.onCreate(bundle);
        String passThroughUrlFromIntent = PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent());
        StringBuilder sb = new StringBuilder();
        sb.append("passThroughUrl = ");
        sb.append(new Gson().toJson((Object) passThroughUrlFromIntent));
        LogUtilsV2.m14227d(sb.toString());
        this.cSA = (GalleryIntentInfo) PassThoughUrlGenerator.getInfoFromIntent(getIntent(), GalleryIntentInfo.class);
        this.cSm = (TODOParamModel) PassThoughUrlGenerator.getInfoFromIntent(getIntent(), TODOParamModel.class);
        this.cSD = GalleryPicPreDecodeRx.m18113h(this);
        boolean z = false;
        if (this.cSA != null) {
            this.cSk = this.cSA.getImageDuration();
            this.bMn = this.cSA.isNewPrj();
            this.cSi = this.cSA.getSourceMode();
            this.cSp = this.cSA.getExtraIntentMode();
            if (this.cSp == 2004) {
                z = true;
            }
            this.cSr = z;
            this.bMy = this.cSA.getActivityId();
            this.cSq = this.cSA.getInputPathList();
            this.cSj = this.cSA.getAction();
            this.lTemplateId = this.cSA.getTemplateID();
        } else {
            this.cSA = new Builder().setSourceMode(0).build();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onCreate-------MagicCode==");
        sb2.append(this.cSA.getMagicCode());
        sb2.append(",mGalleryAction == ");
        sb2.append(this.cSj);
        sb2.append(",CreateANewProject == ");
        sb2.append(this.bMn);
        sb2.append(",mGallerySource==");
        sb2.append(this.cSi);
        LogUtils.m14223i("GalleryActivity", sb2.toString());
        this.cSB = new C6651b(this);
        amn();
        this.cSo = new C6332a();
        this.cSo.attachView((C6343b) this);
        this.cSo.mo29333a(getApplicationContext(), this.cSi, this.cSA.getMagicCode(), this.bMn);
        if (this.cSr) {
            mo22812FU();
        }
        if (ApiHelper.HONEYCOMB_HIGHER) {
            getWindow().setFlags(16777216, 16777216);
        }
        C6348d.amK().mo29381nB(this.cSj);
        setVolumeControlStream(3);
        setContentView(R.layout.gallery_main_acitvity);
        m18067Kl();
        this.cSo.mo29341id(this.bMy);
        if (this.cSi == 2) {
            this.cSo.mo29342n(this.bMy, this.bMn);
        }
        C6344b.m18187h(getApplicationContext(), this.cSj == 2 ? "add more clips" : "create project", true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.cRV != null) {
            this.cRV.onDestroy();
        }
        if (this.cSo != null) {
            this.cSo.detachView();
        }
        if (this.cSy != null && this.cSy.isShowing()) {
            this.cSy.dismiss();
            this.cSy = null;
        }
        if (this.cSt != null && this.cSt.isShowing()) {
            this.cSt.dismiss();
            this.cSt = null;
        }
        if (this.cSg != null) {
            this.cSg.removeAllViews();
            this.cSg = null;
        }
        amC();
        C6348d.amK().reset();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        C7680l.aAf().mo32495iu(false);
        this.cRV.mo29387fY(isFinishing());
        if (isFinishing()) {
            C7187d axT = C7187d.axT();
            axT.mo31669qY(28);
            axT.mo31669qY(31);
        }
        this.cSl = 0;
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        C7680l.aAf().mo32495iu(true);
        super.onResume();
        this.cRV.onResume();
        this.bfB = 0;
    }
}
