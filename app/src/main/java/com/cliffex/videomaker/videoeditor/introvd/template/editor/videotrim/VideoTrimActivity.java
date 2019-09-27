package com.introvd.template.editor.videotrim;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.facebook.ads.AdError;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.ActivityStateCheckListener;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.ViewClickEffectMgr;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.model.Range;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.trim.C5822a;
import com.introvd.template.editor.clipedit.trim.C5822a.C5828b;
import com.introvd.template.editor.clipedit.trim.C5822a.C5829c;
import com.introvd.template.editor.clipedit.trim.C5822a.C5830d;
import com.introvd.template.editor.clipedit.trim.C5832c;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p244a.C5555c;
import com.introvd.template.editor.videotrim.crop.CropImageView;
import com.introvd.template.editor.videotrim.crop.CropImageView.C6968a;
import com.introvd.template.editor.videotrim.p287a.C6955a;
import com.introvd.template.editor.videotrim.p287a.C6958b;
import com.introvd.template.editor.videotrim.p288b.C6960a;
import com.introvd.template.editor.videotrim.p288b.C6961b;
import com.introvd.template.editor.videotrim.p288b.C6965e;
import com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p242d.C5529c;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.p320j.C7547a.C7548a;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.editor.cache.C8442c;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.editor.p388b.C8425b;
import com.introvd.template.sdk.editor.p388b.C8425b.C8426a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8563r;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8541r;
import com.introvd.template.sdk.utils.p397d.C8546a;
import com.introvd.template.sdk.utils.p397d.C8547b;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import com.introvd.template.xyui.C9136a;
import com.p131c.p132a.p133a.C2564c;
import com.quvideo.rescue.C4905b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QUtils.QVideoImportFormat;

@SuppressLint({"UseValueOf"})
@C1942a(mo10417rZ = "/XYVideoEditor/VideoTrim")
public class VideoTrimActivity extends FilePickerBaseActivity implements Callback, ActivityStateCheckListener {
    /* access modifiers changed from: private */
    public static int bMB;
    /* access modifiers changed from: private */
    public static final Boolean dlz = Boolean.valueOf(false);
    private static int limitRangeCount = Integer.MAX_VALUE;
    private OnClickListener acD;
    /* access modifiers changed from: private */
    public MSize bLU;
    /* access modifiers changed from: private */
    public C9136a bML;
    private RelativeLayout bMj;
    /* access modifiers changed from: private */
    public C5822a cCF;
    /* access modifiers changed from: private */
    public C5830d cDB;
    private C5829c cDM;
    /* access modifiers changed from: private */
    public long cQX = 0;
    /* access modifiers changed from: private */
    public boolean cSX;
    private TODOParamModel cSm;
    /* access modifiers changed from: private */
    public C8546a cTA;
    /* access modifiers changed from: private */
    public boolean cTB = true;
    /* access modifiers changed from: private */
    public C8442c cTG = new C8442c();
    /* access modifiers changed from: private */
    public boolean cTK = false;
    private C8434c cTW;
    /* access modifiers changed from: private */
    public C6965e cTd;
    private RelativeLayout cUb;
    /* access modifiers changed from: private */
    public ImageView cUg;
    /* access modifiers changed from: private */
    public LinearLayout cZu;
    /* access modifiers changed from: private */
    public ImageView cau;
    private volatile boolean csC;
    protected int csL;
    protected SurfaceView csN;
    protected SurfaceHolder csO;
    /* access modifiers changed from: private */
    public MSize csP;
    /* access modifiers changed from: private */
    public RelativeLayout csR;
    C8426a csU;
    /* access modifiers changed from: private */
    public C8431d cso;
    protected C8425b cst = null;
    /* access modifiers changed from: private */
    public ImageButton cti;
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
    public CropImageView dlA;
    /* access modifiers changed from: private */
    public ImageView dlB;
    /* access modifiers changed from: private */
    public Button dlC;
    /* access modifiers changed from: private */
    public Button dlD;
    /* access modifiers changed from: private */
    public ImageButton dlE;
    /* access modifiers changed from: private */
    public ImageButton dlF;
    /* access modifiers changed from: private */
    public ImageButton dlG;
    /* access modifiers changed from: private */
    public RelativeLayout dlH;
    /* access modifiers changed from: private */
    public RelativeLayout dlI;
    /* access modifiers changed from: private */
    public RelativeLayout dlJ;
    private RelativeLayout dlK;
    /* access modifiers changed from: private */
    public volatile boolean dlL = false;
    /* access modifiers changed from: private */
    public boolean dlM = false;
    /* access modifiers changed from: private */
    public volatile boolean dlN = false;
    /* access modifiers changed from: private */
    public boolean dlO;
    /* access modifiers changed from: private */
    public boolean dlP = false;
    protected boolean dlQ;
    /* access modifiers changed from: private */
    public int dlR;
    /* access modifiers changed from: private */
    public Handler dlS;
    private C6955a dlT;
    private boolean dlU;
    /* access modifiers changed from: private */
    public boolean dlV;
    private C6958b dlW;
    private C5828b dlX;

    /* renamed from: com.introvd.template.editor.videotrim.VideoTrimActivity$a */
    private class C6952a implements C8434c {
        public C6952a() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            switch (i) {
                case 2:
                    int aIx = VideoTrimActivity.this.cso.aIx();
                    VideoTrimActivity.this.cso.mo34191jn(true);
                    VideoTrimActivity.this.cso.aIB();
                    VideoTrimActivity.this.m20284nF(aIx);
                    return;
                case 3:
                    C4597i.m11728a(true, VideoTrimActivity.this);
                    VideoTrimActivity.this.m20283nE(i2);
                    return;
                case 4:
                    C4597i.m11728a(false, VideoTrimActivity.this);
                    VideoTrimActivity.this.m20282nD(i2);
                    return;
                case 5:
                    C4597i.m11728a(false, VideoTrimActivity.this);
                    if (VideoTrimActivity.this.abF()) {
                        VideoTrimActivity.this.cso.aID();
                    }
                    VideoTrimActivity.this.m20258dR(false);
                    if (VideoTrimActivity.this.cCF != null) {
                        VideoTrimActivity.this.cCF.setPlaying(false);
                    }
                    VideoTrimActivity.this.m20281nC(i2);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.VideoTrimActivity$b */
    private static class C6953b extends WeakHandler<VideoTrimActivity> {
        public C6953b(VideoTrimActivity videoTrimActivity) {
            super(videoTrimActivity);
        }

        public void handleMessage(Message message) {
            Message message2 = message;
            VideoTrimActivity videoTrimActivity = (VideoTrimActivity) getOwner();
            if (videoTrimActivity != null) {
                boolean z = true;
                switch (message2.what) {
                    case 101:
                        C4582c.m11669dF(videoTrimActivity);
                        if (videoTrimActivity.cso != null) {
                            videoTrimActivity.cso.play();
                            break;
                        }
                        break;
                    case 102:
                        if (!videoTrimActivity.ctu) {
                            sendEmptyMessageDelayed(102, 100);
                            break;
                        } else {
                            videoTrimActivity.cCF.setPlaying(true);
                            videoTrimActivity.m20258dR(true);
                            sendEmptyMessageDelayed(101, 40);
                            break;
                        }
                    case HttpStatus.SC_MOVED_PERMANENTLY /*301*/:
                        if (videoTrimActivity.cCF != null && videoTrimActivity.cCF.agp() != null) {
                            int agB = videoTrimActivity.cCF.agp().agB();
                            TrimedClipItemDataModel a = videoTrimActivity.m20263f(new Range(agB, videoTrimActivity.cCF.agp().agC() - agB));
                            if (!videoTrimActivity.cTA.bNeedTranscode) {
                                videoTrimActivity.dlt.clear();
                                videoTrimActivity.dlt.add(a);
                                videoTrimActivity.m20247bK(videoTrimActivity.dlt);
                                videoTrimActivity.dlP = false;
                                break;
                            } else {
                                videoTrimActivity.att();
                                videoTrimActivity.dlt.clear();
                                videoTrimActivity.dlt.add(a);
                                videoTrimActivity.mo30589au(videoTrimActivity);
                                ArrayList arrayList = new ArrayList(videoTrimActivity.dlt);
                                videoTrimActivity.cQX = System.currentTimeMillis();
                                if (videoTrimActivity.mo30585a(videoTrimActivity, videoTrimActivity.cTd, arrayList, videoTrimActivity.bOK)) {
                                    videoTrimActivity.dlN = true;
                                    if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false)) {
                                        C4596h.m11716Sp();
                                    }
                                    C4597i.m11729b(true, videoTrimActivity);
                                    break;
                                } else {
                                    videoTrimActivity.dlP = false;
                                    videoTrimActivity.atn();
                                    if (!videoTrimActivity.cTK) {
                                        if (!videoTrimActivity.dlQ) {
                                            videoTrimActivity.ats();
                                            break;
                                        }
                                    } else {
                                        videoTrimActivity.setResult(0, videoTrimActivity.getIntent());
                                        videoTrimActivity.finish();
                                        break;
                                    }
                                }
                            }
                        } else {
                            videoTrimActivity.dlP = false;
                            break;
                        }
                        break;
                    case AdError.MEDIAVIEW_MISSING_ERROR_CODE /*6001*/:
                        if (videoTrimActivity.bML != null) {
                            videoTrimActivity.bML.mo36079a(true, 4, videoTrimActivity.getResources().getString(R.string.xiaoying_str_ve_import_scroll_for_choose_hep_tip), videoTrimActivity.cZu, C4580b.m11666qi(), 0, C4583d.m11673ii(10), 200, 0);
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("prefer_key_import_video_show_move_help", false);
                            break;
                        }
                        break;
                    case AdError.ICONVIEW_MISSING_ERROR_CODE /*6002*/:
                        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("prefer_key_import_video_fine_tunning_help", true) && videoTrimActivity.csR != null) {
                            videoTrimActivity.csR.setVisibility(0);
                            break;
                        }
                    case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /*6003*/:
                        C4596h.m11717Sq();
                        break;
                    case 6005:
                        if (videoTrimActivity.bML != null) {
                            String string = videoTrimActivity.getResources().getString(R.string.xiaoying_str_ve_import_suc_help_tip, new Object[]{Integer.valueOf(videoTrimActivity.cuo != null ? videoTrimActivity.cuo.size() : 0)});
                            videoTrimActivity.bML.mo36098vP(QDisplayContext.DISPLAY_ROTATION_180);
                            videoTrimActivity.bML.mo36087f(videoTrimActivity.dlC, 5, C4580b.m11666qi());
                            videoTrimActivity.bML.mo36086dt(string);
                            videoTrimActivity.bML.mo36092jQ(true);
                            videoTrimActivity.bML.mo36097vO(100);
                            videoTrimActivity.bML.mo36085dT(0, -C4583d.m11673ii(15));
                            break;
                        }
                        break;
                    case TodoConstants.TODO_TYPE_QA_TEST /*10001*/:
                        if (videoTrimActivity.cso == null) {
                            videoTrimActivity.cso = new C8431d();
                            videoTrimActivity.cso.mo34191jn(false);
                            QSessionStream a2 = videoTrimActivity.m20238a(videoTrimActivity.bLU, videoTrimActivity.csO);
                            VeMSize veMSize = new VeMSize(videoTrimActivity.csP.width, videoTrimActivity.csP.height);
                            VeMSize veMSize2 = new VeMSize(videoTrimActivity.bLU.width, videoTrimActivity.bLU.height);
                            if (videoTrimActivity.cso.mo34170a(a2, videoTrimActivity.getPlayCallback(), veMSize2, 0, videoTrimActivity.bOK.aJv(), videoTrimActivity.csO, C8571x.m25059a(veMSize, veMSize2, 1, (Object) videoTrimActivity.csO, videoTrimActivity.cTG))) {
                                videoTrimActivity.cso.aIB();
                                break;
                            }
                        }
                        break;
                    case 10102:
                        C4586g.m11704a((Context) videoTrimActivity, R.string.xiaoying_str_com_wait_tip, (OnCancelListener) null, false);
                        videoTrimActivity.resetPlayer();
                        break;
                    case 10103:
                        if (videoTrimActivity.cso != null) {
                            videoTrimActivity.dlR = 0;
                            videoTrimActivity.cso.setDisplayContext(C8571x.m25059a(new VeMSize(videoTrimActivity.csP.width, videoTrimActivity.csP.height), new VeMSize(videoTrimActivity.bLU.width, videoTrimActivity.bLU.height), 1, (Object) videoTrimActivity.csO, videoTrimActivity.cTG));
                            videoTrimActivity.cso.aIB();
                            break;
                        }
                        break;
                    case 10104:
                        if (videoTrimActivity.dlM) {
                            if (!videoTrimActivity.cTK) {
                                if (!videoTrimActivity.dlr || videoTrimActivity.dlO) {
                                    if (videoTrimActivity.cPm instanceof C8522g) {
                                        videoTrimActivity.amV();
                                        C4586g.m11703a((Context) videoTrimActivity, R.string.xiaoying_str_com_loading, (OnCancelListener) null);
                                        C6961b bVar = new C6961b((C8522g) videoTrimActivity.cPm, videoTrimActivity.bOK, videoTrimActivity.dlS, videoTrimActivity.cuo, VideoTrimActivity.dlz.booleanValue());
                                        bVar.execute((Params[]) new Void[0]);
                                        break;
                                    }
                                } else {
                                    videoTrimActivity.amV();
                                    Intent intent = videoTrimActivity.getIntent();
                                    intent.putExtra("isImage", false);
                                    intent.putExtra("needInsert", true);
                                    intent.putExtra(MediaGalleryRouter.INTENT_TRIM_RANGE_LIST_KEY, videoTrimActivity.cuo);
                                    videoTrimActivity.setResult(-1, intent);
                                    videoTrimActivity.finish();
                                    break;
                                }
                            } else {
                                if (videoTrimActivity.cuo == null || videoTrimActivity.cuo.size() <= 0) {
                                    videoTrimActivity.setResult(0);
                                } else {
                                    TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) videoTrimActivity.cuo.get(0);
                                    if (FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                                        trimedClipItemDataModel.mRawFilePath = trimedClipItemDataModel.mExportPath;
                                        trimedClipItemDataModel.mVeRangeInRawVideo.setmPosition(0);
                                    }
                                    Intent intent2 = new Intent();
                                    intent2.putExtra(GalleryRouter.INTENT_DATA_BACK_KEY, trimedClipItemDataModel);
                                    videoTrimActivity.setResult(-1, intent2);
                                }
                                videoTrimActivity.finish();
                                break;
                            }
                        } else {
                            sendEmptyMessageDelayed(10104, 200);
                            break;
                        }
                        break;
                    case 10114:
                        videoTrimActivity.ctu = true;
                        break;
                    case 1048577:
                        videoTrimActivity.dlM = true;
                        break;
                    case 2097168:
                        if (videoTrimActivity.cPm instanceof C8522g) {
                            if (message2.arg1 <= 0) {
                                z = false;
                            }
                            C8522g gVar = (C8522g) videoTrimActivity.cPm;
                            if (z) {
                                videoTrimActivity.amV();
                                if (videoTrimActivity.bOK.isProjectModified()) {
                                    int a3 = gVar.mo34730a(true, videoTrimActivity.bOK, (Handler) new C6954c(videoTrimActivity), AppStateModel.getInstance().isCommunitySupport(), gVar.mo34778uz(gVar.ebQ));
                                    if (a3 == 0 || a3 == 6) {
                                        videoTrimActivity.bOK.mo34669jt(false);
                                        break;
                                    } else {
                                        C4586g.m11696Sm();
                                        videoTrimActivity.finish();
                                        return;
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.VideoTrimActivity$c */
    private static class C6954c extends WeakHandler<VideoTrimActivity> {
        C6954c(VideoTrimActivity videoTrimActivity) {
            super(videoTrimActivity);
        }

        public void handleMessage(Message message) {
            VideoTrimActivity videoTrimActivity = (VideoTrimActivity) getOwner();
            if (videoTrimActivity != null) {
                if (videoTrimActivity.cPm.aHe() != null) {
                    EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
                    switch (VideoTrimActivity.bMB) {
                        case 2001:
                            editorIntentInfo.baseMode = 0;
                            editorIntentInfo.tabType = 1;
                            editorIntentInfo.secondaryMode = 1005;
                            EditorRouter.launchEditorActivity((Activity) videoTrimActivity, PassThoughUrlGenerator.generateUrl(EditorRouter.EDITOR_URL, editorIntentInfo));
                            break;
                        case 2002:
                            editorIntentInfo.baseMode = 0;
                            editorIntentInfo.tabType = 2;
                            editorIntentInfo.secondaryMode = 2002;
                            EditorRouter.launchEditorActivity((Activity) videoTrimActivity, PassThoughUrlGenerator.generateUrl(EditorRouter.EDITOR_URL, editorIntentInfo));
                            break;
                        case 2004:
                            videoTrimActivity.atr();
                            break;
                        default:
                            EditorRouter.launchEditorActivity((Activity) videoTrimActivity, new Object[0]);
                            break;
                    }
                }
                C4586g.m11696Sm();
                videoTrimActivity.finish();
            }
        }
    }

    public VideoTrimActivity() {
        this.csC = C8549f.aJd() && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
        this.dlQ = false;
        this.cso = null;
        this.dlR = -1;
        this.bLU = null;
        this.csP = null;
        this.dlS = new C6953b(this);
        this.csL = 1;
        this.dlU = false;
        this.cSX = false;
        this.cTd = new C6965e() {
            /* renamed from: aU */
            public void mo29355aU(List<TrimedClipItemDataModel> list) {
                C4596h.m11717Sq();
                C4597i.m11728a(false, VideoTrimActivity.this);
                VideoTrimActivity.this.cSX = true;
                VideoTrimActivity.this.amI();
                long currentTimeMillis = System.currentTimeMillis() - VideoTrimActivity.this.cQX;
                for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                    C5555c.m15038a(VideoTrimActivity.this.getApplicationContext(), VideoTrimActivity.this.bOK.aJv(), trimedClipItemDataModel.mExportPath, currentTimeMillis);
                }
                VideoTrimActivity.this.m20247bK(list);
                VideoTrimActivity.this.dlN = false;
                VideoTrimActivity.this.dlP = false;
            }

            /* renamed from: aV */
            public void mo29356aV(List<TrimedClipItemDataModel> list) {
                C4596h.m11717Sq();
                C4597i.m11728a(false, VideoTrimActivity.this);
                String[] strArr = new String[list.size()];
                int i = 0;
                for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                    if (FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                        int i2 = i + 1;
                        strArr[i] = trimedClipItemDataModel.mExportPath;
                        trimedClipItemDataModel.mExportPath = "";
                        i = i2;
                    }
                }
                FileUtils.deleteFiles(strArr);
                if (VideoTrimActivity.this.cso != null && !VideoTrimActivity.this.isFinishing()) {
                    VideoTrimActivity.this.dlS.sendMessage(VideoTrimActivity.this.dlS.obtainMessage(10102));
                }
                VideoTrimActivity.this.cSX = false;
                VideoTrimActivity.this.amI();
                VideoTrimActivity.this.dlN = false;
                VideoTrimActivity.this.dlP = false;
            }

            public void amb() {
                VideoTrimActivity.this.atn();
                StringBuilder sb = new StringBuilder();
                sb.append("onProducerReleased bExportSuc=");
                sb.append(VideoTrimActivity.this.cSX);
                LogUtilsV2.m14230i(sb.toString());
                if (VideoTrimActivity.this.cSX && !VideoTrimActivity.this.cTK && VideoTrimActivity.this.dlr && VideoTrimActivity.this.dlQ) {
                    VideoTrimActivity.this.dlS.removeMessages(10102);
                    VideoTrimActivity.this.dlS.sendMessage(VideoTrimActivity.this.dlS.obtainMessage(10102));
                }
            }

            /* renamed from: d */
            public void mo29361d(List<TrimedClipItemDataModel> list, String str) {
                C4596h.m11717Sq();
                VideoTrimActivity.this.cSX = false;
                VideoTrimActivity.this.dlP = false;
                C4597i.m11728a(false, VideoTrimActivity.this);
                String[] strArr = new String[list.size()];
                int i = 0;
                for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                    if (FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                        int i2 = i + 1;
                        strArr[i] = trimedClipItemDataModel.mExportPath;
                        trimedClipItemDataModel.mExportPath = "";
                        i = i2;
                    }
                }
                if (!C5530d.m14977kn(VideoTrimActivity.this.csj)) {
                    ToastUtils.show((Context) VideoTrimActivity.this, R.string.xiaoying_str_ve_msg_video_or_prj_export_failed, 0);
                }
                FileUtils.deleteFiles(strArr);
                if (VideoTrimActivity.this.dlu != null) {
                    VideoTrimActivity.this.dlu.cancel();
                }
                VideoTrimActivity.this.amI();
                VideoTrimActivity.this.setResult(0, VideoTrimActivity.this.getIntent());
                VideoTrimActivity.this.finish();
            }

            public void onProgress(int i) {
                if (VideoTrimActivity.this.dlu != null) {
                    VideoTrimActivity.this.dlu.setProgress(i);
                }
            }
        };
        this.csU = new C8426a() {
            public void abL() {
                LogUtilsV2.m14230i("onSeekFinish run");
                if (VideoTrimActivity.this.ctt) {
                    VideoTrimActivity.this.ctt = false;
                    if (VideoTrimActivity.this.ctv) {
                        VideoTrimActivity.this.ctv = false;
                    }
                } else if (VideoTrimActivity.this.ctw) {
                    if (VideoTrimActivity.this.dlS != null) {
                        VideoTrimActivity.this.dlS.removeMessages(101);
                        VideoTrimActivity.this.dlS.sendEmptyMessage(101);
                    }
                    VideoTrimActivity.this.ctw = false;
                }
                VideoTrimActivity.this.ctu = true;
            }
        };
        this.acD = new OnClickListener() {
            public void onClick(View view) {
                if (!C4580b.m11632Sf() && !VideoTrimActivity.this.dlP) {
                    int i = 0;
                    VideoTrimActivity.this.ctt = false;
                    VideoTrimActivity.this.dlS.removeMessages(102);
                    if (view.equals(VideoTrimActivity.this.cti)) {
                        C2564c.m7331dz(VideoTrimActivity.this.cti);
                        if (VideoTrimActivity.this.isVideoPlaying()) {
                            if (VideoTrimActivity.this.cso != null) {
                                VideoTrimActivity.this.adX();
                                VideoTrimActivity.this.dlR = VideoTrimActivity.this.cso.aIx();
                                VideoTrimActivity.this.m20258dR(false);
                            }
                            VideoTrimActivity.this.cCF.setPlaying(false);
                        } else {
                            VideoTrimActivity.this.cCF.setPlaying(true);
                            VideoTrimActivity.this.m20258dR(true);
                            VideoTrimActivity.this.dlS.sendEmptyMessageDelayed(101, 40);
                        }
                    } else if (view.equals(VideoTrimActivity.this.cau)) {
                        C2564c.m7331dz(VideoTrimActivity.this.cau);
                        if (VideoTrimActivity.this.cso != null) {
                            if (VideoTrimActivity.this.isVideoPlaying()) {
                                VideoTrimActivity.this.adX();
                            }
                            VideoTrimActivity.this.dlR = VideoTrimActivity.this.cso.aIx();
                        }
                        VideoTrimActivity.this.ats();
                    } else if (view.equals(VideoTrimActivity.this.dlB) || view.equals(VideoTrimActivity.this.dlC)) {
                        C2564c.m7331dz(view);
                        if (VideoTrimActivity.this.bML != null) {
                            VideoTrimActivity.this.bML.aNX();
                        }
                        if (VideoTrimActivity.this.cso != null) {
                            if (VideoTrimActivity.this.isVideoPlaying()) {
                                VideoTrimActivity.this.adX();
                            }
                            VideoTrimActivity.this.dlR = VideoTrimActivity.this.cso.aIx();
                            VideoTrimActivity.this.m20258dR(false);
                            VideoTrimActivity.this.cCF.setPlaying(false);
                        }
                        VideoTrimActivity.this.dlQ = false;
                        if (VideoTrimActivity.this.cuo == null || VideoTrimActivity.this.cuo.size() <= 0) {
                            VideoTrimActivity.this.dlS.sendEmptyMessage(HttpStatus.SC_MOVED_PERMANENTLY);
                            VideoTrimActivity.this.dlP = true;
                        } else {
                            VideoTrimActivity.this.dlS.sendEmptyMessageDelayed(10104, 200);
                        }
                    } else if (view.equals(VideoTrimActivity.this.dlJ)) {
                        C2564c.m7331dz(VideoTrimActivity.this.dlG);
                        UserBehaviorLog.onKVEvent(VideoTrimActivity.this, "Gallery_Video_trim_Add", new HashMap());
                        if (!VideoTrimActivity.this.ctu || VideoTrimActivity.this.dlN) {
                            VideoTrimActivity.this.dlS.removeMessages(10114);
                            VideoTrimActivity.this.dlS.sendEmptyMessageDelayed(10114, 1500);
                            ToastUtils.show(VideoTrimActivity.this.getApplicationContext(), R.string.xiaoying_str_com_wait_tip, 0);
                        } else if (AppPreferencesSetting.getInstance().getAppSettingBoolean("prefer_key_import_video_no_trim_help", false)) {
                            if (VideoTrimActivity.this.bML != null) {
                                VideoTrimActivity.this.bML.aNX();
                            }
                            if (VideoTrimActivity.this.cso != null) {
                                if (VideoTrimActivity.this.isVideoPlaying()) {
                                    VideoTrimActivity.this.adX();
                                }
                                VideoTrimActivity.this.dlR = VideoTrimActivity.this.cso.aIx();
                                VideoTrimActivity.this.m20258dR(false);
                                VideoTrimActivity.this.cCF.setPlaying(false);
                            }
                            VideoTrimActivity.this.dlQ = true;
                            VideoTrimActivity.this.dlS.sendEmptyMessage(HttpStatus.SC_MOVED_PERMANENTLY);
                        } else {
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("prefer_key_import_video_no_trim_help", true);
                        }
                    } else if (view.equals(VideoTrimActivity.this.dlH)) {
                        C2564c.m7331dz(VideoTrimActivity.this.dlE);
                        VideoTrimActivity.this.dlV = !VideoTrimActivity.this.dlV;
                        VideoTrimActivity.this.atu();
                        VideoTrimActivity.this.cTG.mo34290jk(VideoTrimActivity.this.dlV);
                        VideoTrimActivity.this.dlE.setSelected(VideoTrimActivity.this.dlV);
                        CropImageView Q = VideoTrimActivity.this.dlA;
                        if (!VideoTrimActivity.this.dlV) {
                            i = 8;
                        }
                        Q.setVisibility(i);
                        C5554b.m15030eq(VideoTrimActivity.this.getApplicationContext());
                    } else if (view.equals(VideoTrimActivity.this.dlI)) {
                        C2564c.m7331dz(VideoTrimActivity.this.dlF);
                        VideoTrimActivity.this.cTG.aIh();
                        VideoTrimActivity.this.atu();
                        VideoTrimActivity.this.dlS.sendEmptyMessage(10103);
                    } else if (view.equals(VideoTrimActivity.this.dlD) && VideoTrimActivity.this.csR != null) {
                        VideoTrimActivity.this.csR.setVisibility(4);
                    }
                }
            }
        };
        this.dlW = new C6958b() {
            private boolean cDE = false;

            public int atA() {
                this.cDE = true;
                VideoTrimActivity.this.m20257dO(false);
                VideoTrimActivity.this.dlL = true;
                boolean agr = VideoTrimActivity.this.cCF.agr();
                int agB = agr ? VideoTrimActivity.this.cCF.agp().agB() : VideoTrimActivity.this.cCF.agp().agC();
                if (VideoTrimActivity.this.csR != null) {
                    VideoTrimActivity.this.csR.setVisibility(4);
                }
                VideoTrimActivity.this.ctx = agr;
                AppPreferencesSetting.getInstance().setAppSettingBoolean("prefer_key_import_video_fine_tunning_help", false);
                return agB;
            }

            public void atB() {
                VideoTrimActivity.this.adX();
                VideoTrimActivity.this.m20258dR(false);
                VideoTrimActivity.this.cCF.setPlaying(false);
            }

            public boolean atC() {
                return !VideoTrimActivity.this.ctt && VideoTrimActivity.this.cso != null && !VideoTrimActivity.this.cso.isPlaying() && !VideoTrimActivity.this.dlV;
            }

            public void atz() {
                this.cDE = false;
                VideoTrimActivity.this.abR();
            }

            /* renamed from: hV */
            public int mo30605hV(int i) {
                if (VideoTrimActivity.this.cCF == null || i < 0) {
                    return 0;
                }
                int aHR = VideoTrimActivity.this.cTA.cCG.aHR() - 1;
                if (i > aHR) {
                    i = aHR;
                }
                C5832c agp = VideoTrimActivity.this.cCF.agp();
                VeAdvanceTrimGallery agm = VideoTrimActivity.this.cCF.agm();
                if (!(agp == null || agm == null)) {
                    if (VideoTrimActivity.this.cCF.agr()) {
                        if (i > agp.agC() - VeAdvanceTrimGallery.dxa) {
                            i = agp.agC() - VeAdvanceTrimGallery.dxa;
                        }
                        if (VideoTrimActivity.this.cCF.agu()) {
                            int dd = agm.mo31269dd(agm.dxb, agm.getCount());
                            if (i < dd) {
                                i = dd + 1;
                            }
                        }
                    } else {
                        if (i < agp.agB() + VeAdvanceTrimGallery.dxa) {
                            i = agp.agB() + VeAdvanceTrimGallery.dxa;
                        }
                        if (VideoTrimActivity.this.cCF.agu()) {
                            int dd2 = agm.mo31269dd(agm.dxc, agm.getCount());
                            if (i > dd2) {
                                i = dd2 - 1;
                            }
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onValidateTime curTime = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                return i;
            }

            /* renamed from: pE */
            public void mo30606pE(int i) {
                if (VideoTrimActivity.this.cCF != null) {
                    if (VideoTrimActivity.this.cst != null && VideoTrimActivity.this.cst.isAlive()) {
                        VideoTrimActivity.this.cst.seekTo(i);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("onScroll curTime =");
                    sb.append(i);
                    LogUtilsV2.m14230i(sb.toString());
                    VideoTrimActivity.this.m20207D(i, true);
                }
                if (VideoTrimActivity.this.cCF != null && this.cDE) {
                    VideoTrimActivity.this.cCF.mo28144lE(i);
                }
            }
        };
        this.cDB = new C5830d() {
            /* renamed from: eH */
            public void mo28118eH(boolean z) {
                VideoTrimActivity.this.ctu = false;
                VideoTrimActivity.this.dlS.removeMessages(102);
                if (VideoTrimActivity.this.bML != null) {
                    VideoTrimActivity.this.bML.aNX();
                }
                VideoTrimActivity.this.ctv = !z;
                VideoTrimActivity.this.ctx = z;
                if (VideoTrimActivity.this.isVideoPlaying()) {
                    VideoTrimActivity.this.adX();
                }
                if (VideoTrimActivity.this.cso != null) {
                    VideoTrimActivity.this.cso.mo34188dF(0, VideoTrimActivity.this.cso.agX());
                }
                VideoTrimActivity.this.cCF.setPlaying(false);
                VideoTrimActivity.this.ctt = true;
                VideoTrimActivity.this.dlS.removeMessages(101);
                VideoTrimActivity.this.dlL = false;
                VideoTrimActivity.this.m20257dO(VideoTrimActivity.this.cTB);
            }

            /* renamed from: ly */
            public void mo28119ly(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("onProgressChanged progress=");
                sb.append(i);
                LogUtilsV2.m14230i(sb.toString());
                if (VideoTrimActivity.this.cst != null && VideoTrimActivity.this.cst.isAlive()) {
                    VideoTrimActivity.this.cst.seekTo(i);
                }
                VideoTrimActivity.this.m20207D(i, false);
            }

            /* renamed from: lz */
            public int mo28120lz(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("onTrimEnd updateTrimTimeView onEndSeek progress=");
                sb.append(i);
                LogUtilsV2.m14230i(sb.toString());
                if (VideoTrimActivity.this.cst != null && VideoTrimActivity.this.cst.isAlive()) {
                    int i2 = i - 10;
                    if (i2 <= 0) {
                        i2 = 0;
                    }
                    VideoTrimActivity.this.cst.seekTo(i2);
                }
                VideoTrimActivity.this.m20207D(i, false);
                VideoTrimActivity.this.abK();
                VideoTrimActivity.this.abR();
                if (!(VideoTrimActivity.this.dlS == null || VideoTrimActivity.this.cCF == null)) {
                    if (VideoTrimActivity.this.cCF.agr()) {
                        VideoTrimActivity.this.dlS.sendEmptyMessageDelayed(AdError.ICONVIEW_MISSING_ERROR_CODE, 100);
                    } else if (AppPreferencesSetting.getInstance().getAppSettingBoolean("prefer_key_import_video_show_move_help", true)) {
                        VideoTrimActivity.this.dlS.sendEmptyMessageDelayed(AdError.MEDIAVIEW_MISSING_ERROR_CODE, 100);
                    }
                }
                AppPreferencesSetting.getInstance().setAppSettingBoolean("prefer_key_import_video_no_trim_help", true);
                return i;
            }
        };
        this.cDM = new C5829c() {
            public void afS() {
                VideoTrimActivity.this.dlS.removeMessages(102);
                VideoTrimActivity.this.ctw = true;
                VideoTrimActivity.this.ctu = true;
                VideoTrimActivity.this.adX();
                VideoTrimActivity.this.dlL = false;
                VideoTrimActivity.this.m20257dO(VideoTrimActivity.this.cTB);
            }

            /* renamed from: lr */
            public void mo28063lr(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("onProgressChanged progress=");
                sb.append(i);
                LogUtilsV2.m14230i(sb.toString());
                if (VideoTrimActivity.this.cst != null && VideoTrimActivity.this.cst.isAlive()) {
                    VideoTrimActivity.this.cst.seekTo(i);
                }
                VideoTrimActivity.this.m20207D(i, false);
            }

            /* renamed from: ls */
            public void mo28064ls(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("onStartSeek progress=");
                sb.append(i);
                LogUtilsV2.m14230i(sb.toString());
                if (VideoTrimActivity.this.cst != null && VideoTrimActivity.this.cst.isAlive()) {
                    int i2 = i - 10;
                    if (i2 <= 0) {
                        i2 = 0;
                    }
                    VideoTrimActivity.this.cst.seekTo(i2);
                }
                VideoTrimActivity.this.m20207D(i, false);
                VideoTrimActivity.this.abK();
            }
        };
        this.dlX = new C5828b() {
            /* renamed from: eM */
            public void mo28172eM(boolean z) {
                if (VideoTrimActivity.this.cDB != null) {
                    VideoTrimActivity.this.cDB.mo28118eH(z);
                }
            }

            /* renamed from: lK */
            public void mo28173lK(int i) {
                if (VideoTrimActivity.this.cDB != null) {
                    VideoTrimActivity.this.cDB.mo28119ly(i);
                }
            }

            /* renamed from: lL */
            public void mo28174lL(int i) {
                if (VideoTrimActivity.this.cDB != null) {
                    VideoTrimActivity.this.cDB.mo28120lz(i);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public void m20207D(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateProgress before time =");
        sb.append(i);
        sb.append(";isGallerySeek=");
        sb.append(this.ctt);
        LogUtilsV2.m14230i(sb.toString());
        if (this.cCF != null) {
            this.cCF.mo28146lG(i);
        }
    }

    /* renamed from: a */
    private RectF m20233a(RectF rectF, int i) {
        int i2 = i % 360;
        RectF rectF2 = new RectF(rectF);
        if (i2 == 90) {
            rectF2.left = rectF.top;
            rectF2.top = 10000.0f - rectF.right;
            rectF2.right = rectF.bottom;
            rectF2.bottom = 10000.0f - rectF.left;
        } else if (i2 == 180) {
            rectF2.left = 10000.0f - rectF.right;
            rectF2.top = 10000.0f - rectF.bottom;
            rectF2.right = 10000.0f - rectF.left;
            rectF2.bottom = 10000.0f - rectF.top;
        } else if (i2 == 270) {
            rectF2.left = 10000.0f - rectF.bottom;
            rectF2.top = rectF.left;
            rectF2.right = 10000.0f - rectF.top;
            rectF2.bottom = rectF.right;
        }
        return rectF2;
    }

    /* renamed from: a */
    private MSize m20234a(C8442c cVar, RectF rectF, QVideoImportFormat qVideoImportFormat) {
        VeMSize veMSize = new VeMSize(cVar.getWidth(), cVar.getHeight());
        boolean aIi = cVar.aIi();
        if (!cVar.aIj() || rectF == null) {
            VeMSize js = C8572y.m25096js(AppStateModel.getInstance().isCommunitySupport());
            if (qVideoImportFormat != null) {
                js = new VeMSize(qVideoImportFormat.mWidth, qVideoImportFormat.mHeight);
            }
            VeMSize a = C8572y.m25065a(js, veMSize, aIi);
            return new MSize(a.width, a.height);
        }
        VeMSize aJp = C8572y.aJp();
        if (this.csC) {
            aJp = new VeMSize((int) QUtils.VIDEO_RES_720P_HEIGHT, (int) QUtils.VIDEO_RES_720P_HEIGHT);
        }
        VeMSize c = C8572y.m25083c(veMSize, aJp);
        MSize mSize = new MSize();
        if (aIi) {
            mSize.width = (int) ((((float) c.width) * (rectF.bottom - rectF.top)) / 10000.0f);
            mSize.height = (int) ((((float) c.height) * (rectF.right - rectF.left)) / 10000.0f);
        } else {
            mSize.width = (int) ((((float) c.width) * (rectF.right - rectF.left)) / 10000.0f);
            mSize.height = (int) ((((float) c.height) * (rectF.bottom - rectF.top)) / 10000.0f);
        }
        return mSize;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public QSessionStream m20238a(MSize mSize, SurfaceHolder surfaceHolder) {
        if (this.cTA.mClip != null) {
            QDisplayContext c = C8571x.m25060c(mSize.width, mSize.height, 1, surfaceHolder);
            if (c != null) {
                int aJl = C8572y.aJl();
                C8563r.m25047e(this.cTA.mClip);
                return C8563r.m25046a(this.cTA.mClip, c.getScreenRect(), c.getResampleMode(), c.getRotation(), aJl);
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m20242a(TrimedClipItemDataModel trimedClipItemDataModel, C7548a aVar) {
        if (!(trimedClipItemDataModel == null || aVar == null)) {
            trimedClipItemDataModel.digitalWaterMarkCode = aVar.aaW();
        }
        if (this.cuo != null) {
            this.cuo.add(trimedClipItemDataModel);
        }
    }

    /* access modifiers changed from: private */
    public boolean abF() {
        return this.cCF != null && this.cCF.agr();
    }

    private MSize abH() {
        int P = Constants.getScreenSize().height - C4583d.m11671P(280.0f);
        return P < Constants.getScreenSize().width ? new MSize(Constants.getScreenSize().width, P) : new MSize(Constants.getScreenSize().width, Constants.getScreenSize().width);
    }

    /* access modifiers changed from: private */
    public void abK() {
        if (this.cst != null) {
            this.cst.aIq();
        }
    }

    /* access modifiers changed from: private */
    public void abR() {
        if (isVideoPlaying()) {
            this.cti.setImageResource(R.drawable.v5_xiaoying_ve_preview_pause_btn);
        } else {
            this.cti.setImageResource(R.drawable.v5_xiaoying_ve_preview_play_btn);
        }
    }

    private void abS() {
        if (this.cso != null) {
            this.cso.aIv();
            this.cso = null;
        }
    }

    private void abs() {
        atu();
        LayoutParams layoutParams = (LayoutParams) this.dlK.getLayoutParams();
        layoutParams.width = this.csP.width;
        layoutParams.height = this.csP.height;
        this.dlK.setLayoutParams(layoutParams);
        this.dlK.invalidate();
    }

    private void abt() {
        this.csN = (SurfaceView) findViewById(R.id.previewview);
        if (this.csN != null) {
            this.csN.setVisibility(0);
            this.csO = this.csN.getHolder();
            if (this.csO != null) {
                this.csO.addCallback(this);
                this.csO.setFormat(this.csL);
            }
        }
    }

    private void aca() {
        this.dlA = (CropImageView) findViewById(R.id.crop_view);
        this.cUg = (ImageView) findViewById(R.id.img_avatar);
        this.cau = (ImageView) findViewById(R.id.xiaoying_com_btn_left);
        this.dlB = (ImageView) findViewById(R.id.xiaoying_com_btn_right);
        this.dlB.setVisibility(4);
        this.dlC = (Button) findViewById(R.id.imgbtn_import);
        this.dlC.setOnClickListener(this.acD);
        ((TextView) findViewById(R.id.xiaoying_com_textview_title)).setText(R.string.xiaoying_str_import_external_video_title);
        this.cti = (ImageButton) findViewById(R.id.play_btn);
        this.bMj = (RelativeLayout) findViewById(R.id.layout_preview);
        this.dlK = (RelativeLayout) findViewById(R.id.layout_preview_bg);
        this.dlF = (ImageButton) findViewById(R.id.imgbtn_rotate);
        this.dlE = (ImageButton) findViewById(R.id.imgbtn_crop);
        this.dlG = (ImageButton) findViewById(R.id.btn_start_trim);
        this.dlH = (RelativeLayout) findViewById(R.id.layout_crop);
        this.dlI = (RelativeLayout) findViewById(R.id.layout_rotate);
        this.dlJ = (RelativeLayout) findViewById(R.id.layout_trim);
        this.cUb = (RelativeLayout) findViewById(R.id.xiaoying_relativelayout_fine_tunning_tip);
        this.csR = (RelativeLayout) findViewById(R.id.xiaoying_relativelayout_finetunning_help);
        this.dlD = (Button) findViewById(R.id.xiaoying_btn_hide);
        this.cZu = (LinearLayout) findViewById(R.id.trim_gallery_content_layout);
        this.dlD.setOnClickListener(this.acD);
        this.cau.setOnClickListener(this.acD);
        this.cti.setOnClickListener(this.acD);
        this.dlH.setOnClickListener(this.acD);
        this.dlI.setOnClickListener(this.acD);
        this.dlJ.setOnClickListener(this.acD);
        this.dlA.setCropActionCallback(new C6968a() {
            public void aty() {
                C5554b.m15031er(VideoTrimActivity.this.getApplicationContext());
            }
        });
        if (this.dlU) {
            this.dlJ.setVisibility(8);
        }
        if (this.dlw) {
            this.dlH.setVisibility(8);
            this.dlJ.setVisibility(8);
            this.dlI.setVisibility(8);
        }
        if (limitRangeCount <= 1) {
            this.dlJ.setVisibility(8);
        }
        this.dlT = new C6955a(this.bMj, this.cUb);
        this.dlT.mo30616a(this.dlW);
        this.dlT.adc();
    }

    /* access modifiers changed from: private */
    public void adX() {
        if (this.cso != null) {
            this.cso.pause();
        }
    }

    /* access modifiers changed from: private */
    public void amI() {
        if (this.cSU != null) {
            this.cSU.release();
            this.cSU = null;
        }
    }

    /* access modifiers changed from: private */
    public void amV() {
        if (this.cPm instanceof C8522g) {
            ((C8522g) this.cPm).mo34723F(false, AppStateModel.getInstance().isCommunitySupport());
        }
    }

    /* access modifiers changed from: private */
    public void anb() {
        if (this.cCF != null) {
            Bitmap ags = this.cCF.ags();
            if (ags != null) {
                this.cUg.setImageBitmap(ags);
                Point agt = this.cCF.agt();
                RectF cH = m20251cH(this.dlC);
                final float width = (float) (agt.x - (ags.getWidth() / 2));
                final float height = (float) ((agt.y + (this.cCF.agm().getHeight() / 2)) - (ags.getHeight() / 2));
                final float centerX = cH.centerX() - ((float) (this.cUg.getWidth() / 2));
                final float centerY = cH.centerY() - ((float) (this.cUg.getHeight() / 2));
                StringBuilder sb = new StringBuilder();
                sb.append("startX : ");
                sb.append(width);
                LogUtilsV2.m14230i(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("startY : ");
                sb2.append(height);
                LogUtilsV2.m14230i(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("endX : ");
                sb3.append(centerX);
                LogUtilsV2.m14230i(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("endY : ");
                sb4.append(centerY);
                LogUtilsV2.m14230i(sb4.toString());
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cUg, "scaleX", new float[]{1.0f, 0.2f});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cUg, "scaleY", new float[]{1.0f, 0.2f});
                ofFloat.setDuration(500);
                ofFloat2.setDuration(500);
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setDuration(500);
                valueAnimator.setObjectValues(new Object[]{new PointF(0.0f, 0.0f)});
                valueAnimator.setInterpolator(new LinearInterpolator());
                C69475 r6 = new TypeEvaluator<PointF>() {
                    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
                        PointF pointF3 = new PointF();
                        pointF3.x = width + ((centerX - width) * f);
                        pointF3.y = height + ((centerY - height) * f * f);
                        return pointF3;
                    }
                };
                valueAnimator.setEvaluator(r6);
                valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                        VideoTrimActivity.this.cUg.setX(pointF.x);
                        VideoTrimActivity.this.cUg.setY(pointF.y);
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(ofFloat).with(ofFloat2);
                animatorSet.play(ofFloat2).with(valueAnimator);
                animatorSet.play(valueAnimator);
                animatorSet.addListener(new AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        VideoTrimActivity.this.cUg.setVisibility(4);
                        VideoTrimActivity.this.atv();
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        VideoTrimActivity.this.cUg.setVisibility(0);
                    }
                });
                animatorSet.start();
            }
        }
    }

    private void atp() {
        this.dlB.setVisibility(4);
        this.cau.setVisibility(0);
        if (this.cTK || this.dlO) {
            this.dlJ.setVisibility(4);
        }
        this.bML = new C9136a(this);
    }

    private void atq() {
        this.cCF = new C5822a((ViewGroup) this.cZu.getParent(), this.cTA.mClip, this.cTA.cCG, 0);
        this.cCF.mo28125a(this.cDB);
        this.cCF.mo28124a(this.cDM);
        this.cCF.mo28123a(this.dlX);
        this.cCF.mo28142lB(this.ctm);
        if (this.cTK) {
            this.cCF.mo28147lI(2000);
        } else if (this.dlw) {
            this.cCF.mo28147lI(this.ctm);
        } else {
            this.cCF.mo28147lI(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        this.cCF.mo28141lA(C4583d.m11673ii(5));
        this.cCF.mo28136eI(false);
        this.cCF.setMinMaxEqualLimitEnable();
    }

    /* access modifiers changed from: private */
    public void ats() {
        if (!this.dlP) {
            if (!C5530d.m14977kn(this.csj) && !C5529c.m14975km(this.csp.cnV)) {
                C8978m.m26350ht(this).mo10296do(R.string.xiaoying_str_com_msg_intent_send_cancel_tip).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        VideoTrimActivity.this.finish();
                        VideoTrimActivity.this.overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
                    }
                }).mo10313qu().show();
            } else if (!this.dlr || this.cuo == null || this.cuo.size() <= 0) {
                finish();
                overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
            } else if (!isFinishing()) {
                C8978m.m26350ht(this).mo10297dp(getResources().getColor(R.color.color_8E8E93)).mo10300ds(getResources().getColor(R.color.color_ff5e13)).mo10277a(Typeface.defaultFromStyle(1), (Typeface) null).mo10296do(R.string.xiaoying_str_com_dialog_cancel_ask).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        VideoTrimActivity.this.finish();
                        VideoTrimActivity.this.overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
                    }
                }).mo10313qu().show();
            }
        }
    }

    /* access modifiers changed from: private */
    public void att() {
        if (this.cso != null) {
            this.cso.aIt();
            this.cso.aIu();
        }
    }

    /* access modifiers changed from: private */
    public void atu() {
        MSize mSize = new MSize(this.bLU.width, this.bLU.height);
        if (this.cTG.aIi()) {
            mSize.width ^= mSize.height;
            mSize.height ^= mSize.width;
            mSize.width ^= mSize.height;
        }
        this.dlA.mo30644cZ(mSize.width / 10, mSize.height / 10);
        LayoutParams layoutParams = (LayoutParams) this.dlA.getLayoutParams();
        layoutParams.width = mSize.width;
        layoutParams.height = mSize.height;
        this.dlA.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void atv() {
        if (this.dlC != null && this.cuo != null) {
            String string = getString(R.string.xiaoying_str_com_add);
            int size = this.cuo != null ? this.cuo.size() : 0;
            if (size > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(" ");
                sb.append(size);
                string = sb.toString();
            }
            this.dlC.setText(string);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bK */
    public void m20247bK(List<TrimedClipItemDataModel> list) {
        if (this.cTK) {
            this.dlM = false;
            if (list != null) {
                for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                    if (FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath)) {
                        m20271iP(trimedClipItemDataModel.mExportPath);
                    }
                    m20242a(trimedClipItemDataModel, this.cTA.eiW);
                    new C6960a(trimedClipItemDataModel, getResources().getDimensionPixelSize(R.dimen.time_line_item_width_height), this.bOK.aJv(), this.dlS).execute((Params[]) new Void[0]);
                }
            }
            this.dlS.sendEmptyMessageDelayed(10104, 200);
        } else if (this.dlr) {
            this.dlM = false;
            if (list != null) {
                for (TrimedClipItemDataModel trimedClipItemDataModel2 : list) {
                    if (FileUtils.isFileExisted(trimedClipItemDataModel2.mExportPath)) {
                        m20271iP(trimedClipItemDataModel2.mExportPath);
                    }
                    m20242a(trimedClipItemDataModel2, this.cTA.eiW);
                    new C6960a(trimedClipItemDataModel2, getResources().getDimensionPixelSize(R.dimen.time_line_item_width_height), this.bOK.aJv(), this.dlS).execute((Params[]) new Void[0]);
                }
            }
            if (!this.dlQ) {
                atv();
                this.dlS.sendEmptyMessageDelayed(10104, 200);
                return;
            }
            this.cUg.postDelayed(new Runnable() {
                public void run() {
                    VideoTrimActivity.this.anb();
                    if (VideoTrimActivity.this.cuo != null && VideoTrimActivity.this.cuo.size() > 0 && !AppPreferencesSetting.getInstance().getAppSettingBoolean("prefer_key_import_video_suc_tip_help", false)) {
                        VideoTrimActivity.this.dlS.sendEmptyMessageDelayed(6005, 200);
                        AppPreferencesSetting.getInstance().setAppSettingBoolean("prefer_key_import_video_suc_tip_help", true);
                    }
                }
            }, 200);
        } else {
            this.dlM = true;
            if (list != null) {
                for (TrimedClipItemDataModel trimedClipItemDataModel3 : list) {
                    if (FileUtils.isFileExisted(trimedClipItemDataModel3.mExportPath)) {
                        m20271iP(trimedClipItemDataModel3.mExportPath);
                    }
                    m20242a(trimedClipItemDataModel3, this.cTA.eiW);
                }
            }
            if (!this.dlQ) {
                this.dlS.sendEmptyMessageDelayed(10104, 200);
            } else {
                this.cUg.postDelayed(new Runnable() {
                    public void run() {
                        VideoTrimActivity.this.anb();
                    }
                }, 200);
            }
        }
    }

    /* renamed from: cH */
    public static RectF m20251cH(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        int left = view.getLeft();
        int top = view.getTop();
        while (true) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return new RectF((float) left, (float) top, (float) (left + width), (float) (top + height));
            }
            view = (View) parent;
            left += view.getLeft();
            top += view.getTop();
        }
    }

    /* renamed from: cX */
    private void m20252cX(int i, int i2) {
        String str = "other";
        if (i == i2) {
            str = "1:1";
        } else if (i * 9 == i2 * 16) {
            str = "16:9";
        } else if (i2 * 9 == i * 16) {
            str = "9:16";
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(":");
        sb.append(i2);
        hashMap.put("resolution", sb.toString());
        hashMap.put("resolution_ratio", str);
        UserBehaviorLog.onKVEvent(this, "Gallery_Import_Resolution", hashMap);
    }

    /* renamed from: cY */
    private void m20253cY(int i, int i2) {
        abt();
        VeMSize veMSize = new VeMSize(abH().width, abH().height);
        VeMSize d = C8572y.m25086d(new VeMSize(i, i2), veMSize);
        this.bLU = new MSize(d.width, d.height);
        this.csP = new MSize(veMSize.width, veMSize.height);
        abs();
    }

    /* access modifiers changed from: private */
    /* renamed from: dO */
    public void m20257dO(boolean z) {
        if (this.cst != null && !this.dlL) {
            try {
                this.cst.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cst = null;
        }
        if (this.cst == null) {
            this.cst = new C8425b(this.cso, z, this.csU);
            this.cst.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dR */
    public void m20258dR(boolean z) {
        if (this.cso != null && this.cCF != null && this.cCF.agp() != null) {
            boolean agr = this.cCF.agr();
            if (z) {
                int agB = this.cCF.agp().agB();
                int agC = this.cCF.agp().agC();
                this.cso.mo34186d(new VeRange(agB, agC - agB));
                if (agr || this.ctx) {
                    this.cso.mo34196uf(agB);
                    return;
                }
                this.ctx = true;
                int i = agC - 1000;
                if (i >= agB) {
                    agB = i;
                }
                this.cso.mo34196uf(agB);
                return;
            }
            this.cso.mo34188dF(0, this.cso.agX());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public TrimedClipItemDataModel m20263f(Range range) {
        TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
        trimedClipItemDataModel.isImage = Boolean.valueOf(false);
        trimedClipItemDataModel.mVeRangeInRawVideo = new VeRange(range.getmPosition(), range.getmTimeLength());
        trimedClipItemDataModel.mRawFilePath = this.csh;
        trimedClipItemDataModel.mRotate = Integer.valueOf(this.cTG.aHX());
        trimedClipItemDataModel.bCrop = Boolean.valueOf(this.cTG.aIj());
        if (trimedClipItemDataModel.bCrop.booleanValue()) {
            trimedClipItemDataModel.cropRect = m20233a(this.dlA.getCroppedRect(), this.cTG.aHX());
        }
        MSize a = m20234a(this.cTG, trimedClipItemDataModel.cropRect, this.cTA.eiV);
        trimedClipItemDataModel.mStreamSizeVe = new VeMSize(a.width, a.height);
        trimedClipItemDataModel.mEncType = C8541r.m24978a(this.cTA.eiV);
        trimedClipItemDataModel.bCropFeatureEnable = Boolean.valueOf(this.cTA.bNeedTranscode);
        return trimedClipItemDataModel;
    }

    /* access modifiers changed from: private */
    public C8434c getPlayCallback() {
        if (this.cTW == null) {
            this.cTW = new C6952a();
        }
        return this.cTW;
    }

    /* renamed from: iP */
    private void m20271iP(String str) {
        C8522g.m24676iP(str);
    }

    /* access modifiers changed from: private */
    public boolean isVideoPlaying() {
        return this.cso != null && this.cso.isPlaying();
    }

    /* access modifiers changed from: private */
    /* renamed from: nC */
    public void m20281nC(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerStop progress=");
        sb.append(i);
        LogUtilsV2.m14230i(sb.toString());
        m20207D(i, false);
        abR();
    }

    /* access modifiers changed from: private */
    /* renamed from: nD */
    public void m20282nD(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerPause progress=");
        sb.append(i);
        LogUtilsV2.m14230i(sb.toString());
        if (!this.ctt) {
            m20207D(i, false);
        }
        abR();
    }

    /* access modifiers changed from: private */
    /* renamed from: nE */
    public void m20283nE(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerPlaying progress=");
        sb.append(i);
        LogUtilsV2.m14230i(sb.toString());
        m20207D(i, false);
        abR();
    }

    /* access modifiers changed from: private */
    /* renamed from: nF */
    public void m20284nF(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlayerReady progress=");
        sb.append(i);
        LogUtilsV2.m14230i(sb.toString());
        C4586g.m11696Sm();
        this.dlN = false;
        m20207D(i, false);
        abR();
    }

    /* access modifiers changed from: private */
    public void resetPlayer() {
        LogUtilsV2.m14230i("resetPlayer");
        if (this.cso != null) {
            this.dlN = true;
            boolean b = this.cso.mo34184b(m20238a(this.bLU, this.csO), this.dlR);
            if (!b) {
                C4586g.m11696Sm();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("resetPlayer result=");
            sb.append(b);
            LogUtilsV2.m14230i(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public boolean atm() {
        if (TextUtils.isEmpty(this.csh) || this.bOK == null) {
            return false;
        }
        QEngine aJv = this.bOK.aJv();
        if (aJv == null || (!MediaFileUtils.IsVideoFileType(MediaFileUtils.GetFileMediaType(this.csh)))) {
            return false;
        }
        this.cTA = C8547b.m24991b(aJv, this.csh, this.cTK, AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false));
        if (this.cTA.mClip == null) {
            return false;
        }
        if (this.cTA.eej != null) {
            int i = this.cTA.eej.width;
            int i2 = this.cTA.eej.height;
            this.cTG.mo34283a(new VeMSize(i, i2));
            m20252cX(i, i2);
        }
        this.cTB = C8547b.m24993m(this.cTG.getWidth(), this.cTG.getHeight(), AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false));
        return true;
    }

    public void atr() {
        try {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.introvd.template.finishactivity"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
        editorIntentInfo.baseMode = 1;
        editorIntentInfo.secondaryMode = -1;
        EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.generateUrl(EditorRouter.EDITOR_URL, editorIntentInfo, this.cSm));
    }

    public boolean isResponseTodoProcess() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.cTK = getIntent().getIntExtra(MediaGalleryRouter.INTENT_PIP_PICK_FILE, 0) != 0;
        this.dlO = getIntent().getBooleanExtra(MediaGalleryRouter.INTENT_PICK_VIDEO_FOR_GIFMAKER, false);
        this.dlw = getIntent().getBooleanExtra(MediaGalleryRouter.INTENT_KEY_IS_SLIDESHOW_PICK, false);
        limitRangeCount = getIntent().getIntExtra(MediaGalleryRouter.INTENT_KEY_VIDEO_COUNT_LIMIT, Integer.MAX_VALUE);
        super.onCreate(bundle);
        if (this.cTG.getWidth() == 0 || this.cTG.getHeight() == 0) {
            if (!isFinishing()) {
                ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file, 0);
                setResult(0);
                finish();
                overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
            }
            return;
        }
        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false)) {
            C4596h.m11716Sp();
            this.dlS.sendEmptyMessageDelayed(AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE, 500);
        } else {
            C4596h.m11717Sq();
        }
        this.cSm = (TODOParamModel) getIntent().getParcelableExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
        if (this.cSm != null && this.cSm.getActivityFlag() == 1) {
            this.dlU = true;
        }
        synchronized (this) {
            setContentView(R.layout.editor_act_video_trim_layout);
            ActionFirebaseStarVlogs.actionVideoTrimActivity(this);
        }
        int intExtra = getIntent().getIntExtra(MediaGalleryRouter.INTENT_VIDEO_DURATION_LIMIT, 0);
        if (intExtra > 0) {
            this.ctm = intExtra;
        }
        bMB = getIntent().getIntExtra(GalleryRouter.EXTRA_INTENT_MODE_KEY, -1);
        aca();
        atq();
        m20253cY(this.cTG.getWidth(), this.cTG.getHeight());
        atp();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        abS();
        this.dlT = null;
        if (this.cCF != null) {
            this.cCF.destroy();
        }
        if (this.bML != null) {
            this.bML.unInit();
            this.bML = null;
        }
        ViewClickEffectMgr.destroyEffectByToken(VideoTrimActivity.class.getSimpleName());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 || super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        ats();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        UserBehaviorLog.onPause(this);
        if (this.cso != null) {
            if (isVideoPlaying()) {
                adX();
            }
            this.dlR = this.cso.aIx();
        }
        att();
        if (isFinishing()) {
            abK();
            abS();
            if (this.cTA.mClip != null) {
                this.cTA.mClip.unInit();
                this.cTA.mClip = null;
            }
            if (this.bML != null) {
                this.bML.aNX();
            }
        }
        C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(false));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UserBehaviorLog.onResume(this);
        if (this.dlR >= 0 && (this.cSU == null || !ato())) {
            this.dlS.sendEmptyMessageDelayed(10102, 100);
        }
        C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(true));
        C4905b.m12547g(19, null, VideoTrimActivity.class.getSimpleName());
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LogUtilsV2.m14230i("surfaceChanged");
        this.csO = surfaceHolder;
        if (this.dlS != null) {
            this.dlS.removeMessages(TodoConstants.TODO_TYPE_QA_TEST);
            this.dlS.sendMessageDelayed(this.dlS.obtainMessage(TodoConstants.TODO_TYPE_QA_TEST), 30);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        LogUtilsV2.m14230i("surfaceCreated");
        this.csO = surfaceHolder;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtilsV2.m14230i("surfaceDestroyed");
    }
}
