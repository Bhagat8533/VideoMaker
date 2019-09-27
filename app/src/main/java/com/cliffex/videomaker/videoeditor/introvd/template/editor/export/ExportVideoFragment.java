package com.introvd.template.editor.export;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.R;
import com.introvd.template.editor.advance.AdvanceEditorGif;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.export.C6235c.C6236a;
import com.introvd.template.editor.export.C6263m.C6267a;
import com.introvd.template.editor.export.p258a.C6227a;
import com.introvd.template.editor.export.p258a.C6230b;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p266h.C6397i;
import com.introvd.template.editor.p266h.C6397i.C6403a;
import com.introvd.template.editor.p266h.C6404j;
import com.introvd.template.editor.p266h.C6406l;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.AppRouter.IntentHomeParams;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.export.CoverChangedEvent;
import com.introvd.template.router.editor.export.ExportActionEvent;
import com.introvd.template.router.editor.export.ExportClickEvent;
import com.introvd.template.router.editor.export.ExportPrjInfo;
import com.introvd.template.router.editor.export.ExportPrjInfo.Builder;
import com.introvd.template.router.editor.export.ExportVideoInfo;
import com.introvd.template.router.editor.export.IExportTpyeChoose;
import com.introvd.template.router.editor.export.PublishDetailInfo;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.router.parammodels.PickCoverParams;
import com.introvd.template.router.setting.VivaSettingRouter.SettingPrams;
import com.introvd.template.router.slide.SlideshowRouter;
import com.introvd.template.router.sns.MyResolveInfo;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.editor.p389c.C8438d;
import com.introvd.template.sdk.model.GifExpModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import com.introvd.template.sdk.p380a.C8380a;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.slide.p392a.C8460a;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8559n;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.sdk.utils.p394b.C8541r;
import com.introvd.template.sdk.utils.p394b.p395a.C8510e;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.videoeditor.p416a.C9006a;
import com.p131c.p132a.C2561a;
import com.xiaoying.p448a.p449a.C9536c;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.json.JSONException;
import org.json.JSONObject;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.storyboard.QStoryboard;

@LDPProtect
@SuppressLint({"ValidFragment"})
public class ExportVideoFragment extends Fragment implements C6230b {
    /* access modifiers changed from: private */
    public boolean bChinaArea;
    private C8501a bOK;
    private QStoryboard cFJ;
    private boolean cPl = C8549f.aJf().booleanValue();
    private C8381b cPm;
    /* access modifiers changed from: private */
    public boolean cPn = false;
    /* access modifiers changed from: private */
    public boolean cPo = false;
    /* access modifiers changed from: private */
    public boolean cPp = false;
    /* access modifiers changed from: private */
    public C6207a cPq;
    /* access modifiers changed from: private */
    public VideoExportParamsModel cPr;
    /* access modifiers changed from: private */
    public C6227a cPs;
    private boolean cPt;
    private C0068f cPu = new C0068f() {
        @C0078n(mo161n = C0062a.ON_DESTROY)
        public void onActivityDestory() {
            if (ExportVideoFragment.this.ctq != null) {
                ExportVideoFragment.this.ctq.release();
            }
            if (ExportVideoFragment.this.ctc != null) {
                ExportVideoFragment.this.ctc.asW();
                ExportVideoFragment.this.ctc = null;
            }
            if (ExportVideoFragment.this.cPq != null) {
                ExportVideoFragment.this.cPq.removeCallbacksAndMessages(null);
                ExportVideoFragment.this.cPq = null;
            }
            if (ExportVideoFragment.this.cPs != null) {
                ExportVideoFragment.this.cPs.release();
            }
        }

        @C0078n(mo161n = C0062a.ON_PAUSE)
        public void onActivityPause() {
            if (ExportVideoFragment.this.ctc != null) {
                ExportVideoFragment.this.ctc.bOL = true;
                ExportVideoFragment.this.ctc.asU();
            }
        }

        @C0078n(mo161n = C0062a.ON_RESUME)
        public void onActivityResume() {
            if (ExportVideoFragment.this.ctc != null && ExportVideoFragment.this.ctc.bOL) {
                ExportVideoFragment.this.ctc.bOL = false;
                ExportVideoFragment.this.ctc.asV();
            }
        }
    };
    private C6403a cPv = new C6403a() {
        /* access modifiers changed from: private */
        public String ctr = "";

        public void abW() {
            C10021c.aZH().mo38492aA(new ExportActionEvent(ExportVideoFragment.this.uniqueId, 0));
        }

        public void abX() {
            ExportVideoFragment.this.alA();
            C4597i.m11728a(false, ExportVideoFragment.this.mActivity);
            C4596h.m11717Sq();
            C4596h.m11719Ss();
            C10021c.aZH().mo38492aA(new ExportActionEvent(ExportVideoFragment.this.uniqueId, 3));
            ExportVideoFragment.this.isExporting = false;
        }

        /* renamed from: dT */
        public void mo27398dT(boolean z) {
            ExportVideoFragment.this.isExporting = z;
            C10021c.aZH().mo38492aA(new ExportActionEvent(ExportVideoFragment.this.uniqueId, 4, z));
        }

        /* renamed from: fY */
        public void mo27399fY(String str) {
            this.ctr = str;
            ExportVideoFragment.this.alA();
            C4597i.m11728a(false, ExportVideoFragment.this.mActivity);
            C4596h.m11717Sq();
            C4596h.m11719Ss();
            if (ExportVideoFragment.this.cPp && ExportVideoFragment.this.cPo) {
                C6253g.m17916no(3);
                ExportVideoFragment.this.cPo = false;
            }
            if (ExportVideoFragment.this.ctq == null || !ExportVideoFragment.this.ctq.isShowing()) {
                C10021c aZH = C10021c.aZH();
                ExportActionEvent exportActionEvent = new ExportActionEvent(ExportVideoFragment.this.uniqueId, 1, str, true);
                aZH.mo38492aA(exportActionEvent);
            }
            ExportVideoFragment.this.isExporting = false;
        }

        /* renamed from: fZ */
        public void mo27400fZ(String str) {
            if (!ExportVideoFragment.this.mActivity.isFinishing()) {
                try {
                    if (ExportVideoFragment.this.ctq == null || ExportVideoFragment.this.ctq.isShowing()) {
                        ExportVideoFragment.this.ctq = new C6257k(ExportVideoFragment.this.mActivity, C6255i.m17928fI(ExportVideoFragment.this.bChinaArea));
                        ExportVideoFragment.this.ctq.setOnDismissListener(new OnDismissListener() {
                            public void onDismiss(DialogInterface dialogInterface) {
                                if (!ExportVideoFragment.this.isExporting) {
                                    C10021c aZH = C10021c.aZH();
                                    ExportActionEvent exportActionEvent = new ExportActionEvent(ExportVideoFragment.this.uniqueId, 1, C61982.this.ctr, true);
                                    aZH.mo38492aA(exportActionEvent);
                                }
                            }
                        });
                        ExportVideoFragment.this.ctq.show();
                    } else {
                        ExportVideoFragment.this.ctq.show();
                    }
                } catch (Exception e) {
                    C5523b.logException(e);
                }
            }
        }

        /* renamed from: kw */
        public void mo27401kw(int i) {
            ExportVideoFragment.this.alA();
            C4597i.m11728a(false, ExportVideoFragment.this.mActivity);
            C4596h.m11717Sq();
            C4596h.m11719Ss();
            C10021c.aZH().mo38492aA(new ExportActionEvent(ExportVideoFragment.this.uniqueId, 2));
            ExportVideoFragment.this.isExporting = false;
        }

        /* renamed from: kx */
        public void mo27402kx(int i) {
        }
    };
    /* access modifiers changed from: private */
    public C6397i ctc;
    /* access modifiers changed from: private */
    public C6257k ctq = null;
    /* access modifiers changed from: private */
    public volatile boolean isExporting = false;
    /* access modifiers changed from: private */
    public FragmentActivity mActivity;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public DataItemProject mProjectDataItem;
    /* access modifiers changed from: private */
    public long magicCode;
    /* access modifiers changed from: private */
    public long uniqueId;

    /* renamed from: com.introvd.template.editor.export.ExportVideoFragment$a */
    private class C6207a extends Handler {
        public C6207a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            long j;
            String str;
            super.handleMessage(message);
            if (message.what == 268443649) {
                DataItemProject e = ExportVideoFragment.this.mProjectDataItem;
                if (e != null) {
                    String str2 = e.strCoverURL;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = C6255i.m17930hF(e.strPrjURL);
                        e.strCoverURL = str2;
                    } else {
                        try {
                            str = str2;
                            j = C8558m.m25031on(e.strExtra).longValue();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        C6254h.m17922eZ(ExportVideoFragment.this.mContext.getApplicationContext());
                        ExportVideoFragment.m17752a((Activity) ExportVideoFragment.this.mActivity, 8449, str, j, false);
                    }
                    str = str2;
                    j = 0;
                    C6254h.m17922eZ(ExportVideoFragment.this.mContext.getApplicationContext());
                    ExportVideoFragment.m17752a((Activity) ExportVideoFragment.this.mActivity, 8449, str, j, false);
                }
            }
        }
    }

    /* renamed from: a */
    private C6236a m17747a(final String str, final boolean z, final IExportTpyeChoose iExportTpyeChoose) {
        return new C6236a() {
            /* renamed from: R */
            public void mo29087R(int i, boolean z) {
                ExportVideoFragment.this.m17760a(str, z, iExportTpyeChoose, i, z, false);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17751a(int i, boolean z, String str, boolean z2, IExportTpyeChoose iExportTpyeChoose, boolean z3) {
        if (i == 1) {
            m17761a(z, "720p", 1, !z3, z2, iExportTpyeChoose);
        } else if (i == 2) {
            m17761a(z, "1080P", 2, true, z2, iExportTpyeChoose);
        } else if (i == 5) {
            m17761a(z, "QHD", 4, true, z2, iExportTpyeChoose);
        } else if (i == 6) {
            m17761a(z, "UHD", 5, true, z2, iExportTpyeChoose);
        } else if (i == 3) {
            m17762a(z, z2, iExportTpyeChoose);
        } else if (i == 4) {
            C6254h.m17920bt(this.mContext, str);
            Intent intent = new Intent(this.mContext, AdvanceEditorGif.class);
            intent.putExtra("bundle_key_prjdata", this.mProjectDataItem);
            this.mActivity.startActivityForResult(intent, 8448);
        } else {
            m17761a(z, "480p", 0, false, z2, iExportTpyeChoose);
        }
    }

    /* renamed from: a */
    public static void m17752a(Activity activity, int i, String str, long j, boolean z) {
        VivaRouter.getRouterBuilder(PickCoverParams.URL).mo10400g(activity.getIntent().getExtras()).mo10399f(PickCoverParams.ACTIVITY_COVER_PICK_RESULT_KEY, str).mo10386a(PickCoverParams.ACTIVITY_COVER_PICK_TIME_POSITION_KEY, j).mo10391a(PickCoverParams.BUNDLE_KEY_GO_MINI_PUBLISH_BOOL, z).mo10396b(activity, i);
    }

    /* renamed from: a */
    private void m17753a(final Activity activity, final boolean z, final boolean z2, final IExportTpyeChoose iExportTpyeChoose) {
        if (activity != null && !activity.isFinishing()) {
            C8978m.m26349hs(activity).mo10315r(this.mContext.getString(R.string.xiaoying_str_publish_export_hw_enable_tip)).mo10303dv(R.string.xiaoying_str_publish_export_hw_enable_continue_op).mo10299dr(R.string.xiaoying_str_publish_export_hw_enable_set_op).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    iExportTpyeChoose.onExportTypeChoose(0, ExportVideoFragment.this.mo29060a(z, 0, z2));
                    C6254h.m17918br(ExportVideoFragment.this.mContext, "continue");
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    VivaRouter.getRouterBuilder(SettingPrams.URL).mo10386a(CommonParams.INTENT_MAGIC_CODE, ExportVideoFragment.this.magicCode).mo10391a(SettingPrams.BUNDLE_DATA_KEY_GO_FEEDBACK, false).mo10382H(activity);
                    C6254h.m17918br(ExportVideoFragment.this.mContext, "setting");
                }
            }).mo10313qu().show();
        }
    }

    /* renamed from: a */
    private void m17754a(Activity activity, boolean z, boolean z2, boolean z3, boolean z4, C6236a aVar) {
        boolean z5 = z3;
        C6236a aVar2 = aVar;
        if (activity != null && !activity.isFinishing()) {
            int alt = C6253g.alt();
            boolean z6 = true;
            boolean z7 = z && C3742b.m9111II().mo23181bZ(this.mContext) && z4 && (alt == 1 || alt == 2);
            boolean z8 = z && C8549f.aJc() && !C2561a.aON();
            boolean z9 = z2 && !C2561a.aON();
            if (z || z8 || z7 || z9) {
                C6235c cVar = r3;
                boolean z10 = z9;
                C6235c cVar2 = new C6235c(activity, C8549f.aJf().booleanValue(), new boolean[]{true, z, z8, z7, z9, C8549f.isHD2KSupport(), C8549f.isHD4KSupport()}, z3, z4, z4);
                if (z7) {
                    C6254h.m17921eY(this.mContext);
                }
                cVar.mo29136a(aVar2);
                try {
                    cVar.show();
                } catch (Exception e) {
                    C5523b.logException(e);
                }
                if (C8549f.aJf().booleanValue()) {
                    C5554b.m15027aH(this.mContext, "HD_Export_Dialog_Show_Beta");
                } else {
                    Context context = this.mContext;
                    if (!z && !z8) {
                        z6 = false;
                    }
                    C5554b.m15020a(context, z6, z10, z5);
                }
                return;
            }
            if (aVar2 != null) {
                aVar2.mo29087R(0, z5);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17759a(VideoExportParamsModel videoExportParamsModel) {
        this.cPp = videoExportParamsModel.bHDExport;
        if (this.ctc != null) {
            this.ctc.cPt = this.cPt;
            this.ctc.mo29447a((Activity) this.mActivity, this.cPm, this.bOK, videoExportParamsModel, this.cPv);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17760a(String str, boolean z, IExportTpyeChoose iExportTpyeChoose, int i, boolean z2, boolean z3) {
        C8380a aHf = this.cPm.aHf();
        if (aHf == null || (!aHf.isClipSourceFileLosted && !aHf.isTemplateFileLosted)) {
            m17751a(i, z2, str, z, iExportTpyeChoose, z3);
            return;
        }
        C1895a dr = C8978m.m26349hs(this.mActivity).mo10293dl(R.string.xiaoying_str_com_prompt_title).mo10315r(z2 ? this.mContext.getString(R.string.xiaoying_str_publish_export_file_lost_tip) : this.mContext.getString(R.string.xiaoying_str_publish_upload_file_lost_tip)).mo10303dv(R.string.xiaoying_str_com_no).mo10299dr(R.string.xiaoying_str_com_yes);
        final int i2 = i;
        final boolean z4 = z2;
        final String str2 = str;
        final boolean z5 = z;
        final IExportTpyeChoose iExportTpyeChoose2 = iExportTpyeChoose;
        final boolean z6 = z3;
        C62058 r0 = new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                ExportVideoFragment.this.m17751a(i2, z4, str2, z5, iExportTpyeChoose2, z6);
            }
        };
        dr.mo10281a((C1904j) r0).mo10313qu().show();
    }

    /* renamed from: a */
    private void m17761a(boolean z, String str, int i, boolean z2, boolean z3, IExportTpyeChoose iExportTpyeChoose) {
        C6254h.m17917bq(this.mContext, str);
        boolean a = mo29060a(z, i, z3);
        this.cPt = alC();
        if (!z2 || !alE() || this.cPl || this.cPt) {
            iExportTpyeChoose.onExportTypeChoose(i, a);
            return;
        }
        C6254h.m17919bs(this.mContext, C6253g.alu());
        String str2 = "HD export";
        if (i == 4) {
            str2 = "2k";
        } else if (i == 5) {
            str2 = "4k";
        }
        C8049f.aBf().mo33097b(this.mActivity, C8070o.aBw(), C7825a.HD.getId(), str2, -1);
    }

    /* renamed from: a */
    private void m17762a(boolean z, boolean z2, IExportTpyeChoose iExportTpyeChoose) {
        C6254h.m17917bq(this.mContext, "free HD");
        int alt = C6253g.alt();
        if (alt == 2) {
            UserBehaviorUtilsV5.onEventHDFreeExportDialogClick(this.mContext, "unlocked");
            this.cPo = true;
            iExportTpyeChoose.onExportTypeChoose(1, mo29060a(z, 1, z2));
        } else if (alt == 1) {
            UserBehaviorUtilsV5.onEventHDFreeExportDialogClick(this.mContext, "locked");
            C6263m.m17940a(this.mActivity, new C6267a() {
                /* renamed from: a */
                public void mo29088a(MyResolveInfo myResolveInfo) {
                    ExportVideoFragment.this.cPn = true;
                }

                public void alL() {
                }
            });
        }
    }

    private boolean alC() {
        return !m17775fM(this.bChinaArea) && m17776fN(this.bChinaArea);
    }

    private boolean alD() {
        return !this.mProjectDataItem.isProjectModified() && FileUtils.isFileExisted(this.mProjectDataItem.strPrjExportURL);
    }

    private long alF() {
        if (this.cPm instanceof C8468c) {
            QSlideShowSession aIT = ((C8468c) this.cPm).aIT();
            if (aIT != null) {
                return aIT.GetTheme();
            }
            return 0;
        } else if (this.cPm instanceof C8522g) {
            return C8540q.m24894C(this.cPm.aHd()).longValue();
        } else {
            return 0;
        }
    }

    /* renamed from: ap */
    private void m17764ap(Activity activity) {
        C8049f.aBf().mo33097b(activity, C8070o.aBw(), C7825a.DURATION_LIMIT.getId(), "export duration limit", -1);
    }

    /* renamed from: b */
    private void m17766b(final boolean z, final String str, final boolean z2) {
        C8978m.m26349hs(this.mActivity).mo10293dl(R.string.xiaoying_str_com_info_title).mo10296do(R.string.xiaoying_str_ve_export_overwrite_ask_tip).mo10303dv(R.string.xiaoying_str_com_prj_reexport).mo10299dr(R.string.xiaoying_str_com_cancel).mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                ExportVideoFragment.this.m17769c(z, str, z2);
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17769c(boolean z, String str, boolean z2) {
        UserBehaviorUtilsV5.onEventCommunityPublishKeyboardTest("export");
        C10021c.aZH().mo38492aA(new ExportClickEvent(this.uniqueId));
        mo29058a(false, z, str, z2, true);
    }

    /* renamed from: f */
    private void m17774f(FragmentActivity fragmentActivity) {
        boolean bi = C8446b.aIZ().mo34322bi(this.mProjectDataItem._id);
        if (C8451b.m24478uo(this.mProjectDataItem.prjThemeType)) {
            if (C8451b.m24479up(this.mProjectDataItem.prjThemeType)) {
                if (bi) {
                    EditorRouter.launchEditorPreviewActivity((Activity) fragmentActivity, C3742b.m9111II().mo23139JG(), new Object[0]);
                    return;
                }
                EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
                editorIntentInfo.from = "share";
                EditorRouter.launchEditorActivity((Activity) fragmentActivity, editorIntentInfo);
            } else if (C8451b.m24482us(this.mProjectDataItem.prjThemeType)) {
                EditorRouter.launchFastEditorActivity(fragmentActivity, new Object[0]);
            }
        } else if (!C8451b.m24481ur(this.mProjectDataItem.prjThemeType)) {
        } else {
            if (C5837a.agH().agM()) {
                SlideshowRouter.launchSlideEdit((Activity) fragmentActivity, false);
            } else {
                SlideshowRouter.launchSlideshowPreview(fragmentActivity, false);
            }
        }
    }

    /* renamed from: fM */
    private boolean m17775fM(boolean z) {
        return C8549f.aJe().booleanValue();
    }

    /* renamed from: fN */
    private boolean m17776fN(boolean z) {
        return C3742b.m9111II().mo23179Jz();
    }

    /* renamed from: fO */
    private boolean m17777fO(boolean z) {
        if (this.mProjectDataItem == null) {
            return false;
        }
        boolean z2 = true;
        if (z || !AppStateModel.getInstance().isInChina()) {
            return true;
        }
        boolean ku = C8072q.aBx().mo33072ku(C7825a.WATER_MARK.getId());
        boolean ahb = C5842b.ahb();
        UtilsPrefs with = UtilsPrefs.with(VivaBaseApplication.m8749FZ(), AppRouter.VIVA_APP_PREF_FILENAME, true);
        StringBuilder sb = new StringBuilder();
        sb.append(IntentHomeParams.WATER_MARK_PREF);
        sb.append(this.mProjectDataItem.strPrjURL);
        long readLong = with.readLong(sb.toString(), -1);
        boolean bp = C8559n.m25039bp(readLong);
        if ((!ku || !ahb || !bp) && ((ku || !bp) && (!ku || readLong != 0))) {
            z2 = false;
        }
        return z2;
    }

    public static String getExportFileName(int i) {
        String str = CommonConfigure.APP_DEFAULT_EXPORT_PATH;
        String str2 = ".mp4";
        if (i == 3) {
            str2 = ".gif";
        }
        if (C8510e.m24600oR(str) != 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_");
        sb.append(System.currentTimeMillis());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("XiaoYing_Video");
        sb3.append(sb2);
        String sb4 = sb3.toString();
        if (i == 1) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append("_HD");
            sb4 = sb5.toString();
        } else if (i == 2) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(sb4);
            sb6.append("_1080HD");
            sb4 = sb6.toString();
        }
        return FileUtils.getFreeFileName(str, sb4, str2, 0);
    }

    public static String lauchPickCoverActivity(Activity activity, String str, String str2, String str3) {
        long j;
        if (TextUtils.isEmpty(str2)) {
            str2 = C6255i.m17930hF(str);
        } else {
            try {
                j = C8558m.m25031on(str3).longValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
            m17752a(activity, 8449, str2, j, true);
            return str2;
        }
        j = 0;
        m17752a(activity, 8449, str2, j, true);
        return str2;
    }

    /* renamed from: nq */
    private boolean m17786nq(int i) {
        boolean z = true;
        if (this.mProjectDataItem == null || this.bOK.aJv() == null || i == 3) {
            return true;
        }
        String str = this.mProjectDataItem.strPrjExportURL;
        if (this.mProjectDataItem.isProjectModified() || !FileUtils.isFileExisted(str)) {
            return true;
        }
        VeMSize f = C8541r.m24980f(this.bOK.aJv(), str);
        VeMSize b = C8438d.m24393b(this.cPr);
        if (b != null && b.width == f.width && b.height == f.height) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public void mo29053a(ImageView imageView, String str) {
        alA();
        if (imageView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(FileUtils.fileSize(str));
            ImageLoader.loadImageWithSignature(this.mContext, str, imageView, sb.toString());
        }
    }

    /* renamed from: a */
    public void mo29054a(PublishDetailInfo publishDetailInfo) {
        if (this.mProjectDataItem != null) {
            this.mProjectDataItem.strPrjTitle = publishDetailInfo.strPrjTitle;
            this.mProjectDataItem.strVideoDesc = publishDetailInfo.strVideoDesc;
            Long on = C8558m.m25031on(this.mProjectDataItem.strExtra);
            if (on.longValue() > 0) {
                publishDetailInfo.strExtra = C8558m.m25023k(publishDetailInfo.strExtra, on.longValue());
            }
            this.mProjectDataItem.strExtra = publishDetailInfo.strExtra;
            alA();
        }
    }

    /* renamed from: a */
    public void mo29055a(boolean z, String str, boolean z2) {
        if (this.mProjectDataItem != null) {
            boolean z3 = false;
            if (this.cPm instanceof C8468c) {
                z3 = true;
            }
            if (this.cPr == null || z) {
                this.cPr = C6404j.m18433a(this.mContext, this.mProjectDataItem.strPrjURL, this.mProjectDataItem.isMVPrj(), 0, null, true);
                if (this.cPm instanceof C8522g) {
                    this.cPr.videoBitrateScales = ((C8522g) this.cPm).bmF;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.cPr.assignedPath = str;
                }
                this.cPr.isSlidePrj = z3;
            } else {
                this.cPr.assignedPath = str;
                this.cPr.isSlidePrj = z3;
                if (z2) {
                    C10021c aZH = C10021c.aZH();
                    ExportActionEvent exportActionEvent = new ExportActionEvent(this.uniqueId, 1, str, false);
                    aZH.mo38492aA(exportActionEvent);
                    return;
                }
            }
            m17759a(this.cPr);
        }
    }

    /* renamed from: a */
    public void mo29056a(boolean z, boolean z2, String str, boolean z3) {
        if (!this.isExporting) {
            boolean ahb = C5842b.ahb();
            boolean z4 = true;
            if (z) {
                long j = -1;
                if (this.mContext != null) {
                    UtilsPrefs with = UtilsPrefs.with(this.mContext, AppRouter.VIVA_APP_PREF_FILENAME, true);
                    StringBuilder sb = new StringBuilder();
                    sb.append(IntentHomeParams.WATER_MARK_PREF);
                    sb.append(this.mProjectDataItem.strPrjURL);
                    j = with.readLong(sb.toString(), -1);
                }
                z4 = C8559n.m25039bp(j);
            } else {
                ahb = true;
            }
            if (!alD()) {
                m17769c(z2, str, z3);
            } else if ((!z4 || !ahb) && (z4 || ahb)) {
                m17769c(z2, str, z3);
            } else {
                m17766b(z2, str, z3);
            }
        }
    }

    /* renamed from: a */
    public final void mo29057a(boolean z, boolean z2, final String str, final boolean z3, final IExportTpyeChoose iExportTpyeChoose) {
        if (iExportTpyeChoose == null) {
            mo29058a(z, z2, str, z3, true);
        } else if (!mo29075fL(z)) {
            if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false)) {
                m17753a((Activity) this.mActivity, !z, z3, iExportTpyeChoose);
                return;
            }
            boolean z4 = (!z || C3742b.m9111II().mo23184cc(this.mContext)) && (m17775fM(this.bChinaArea) || m17776fN(this.bChinaArea));
            this.cPt = alC();
            if (this.cPt) {
                UserBehaviorLog.onKVEvent(this.mActivity, "Event_SW_720_SHOW", new HashMap());
            }
            if (z4 || z2) {
                if (!AppStateModel.getInstance().isMiddleEast() || !z) {
                    m17754a((Activity) this.mActivity, z4, z2, !z, !this.cPt && alE(), m17747a(str, z3, iExportTpyeChoose));
                } else {
                    C6237d.m17889a((Context) this.mActivity, (C6243a) new C6243a() {
                        /* renamed from: nn */
                        public void mo29086nn(int i) {
                            ExportVideoFragment.this.m17760a(str, z3, iExportTpyeChoose, i, false, true);
                        }
                    });
                }
                return;
            }
            iExportTpyeChoose.onExportTypeChoose(0, mo29060a(!z, 0, z3));
        }
    }

    /* renamed from: a */
    public final void mo29058a(boolean z, boolean z2, String str, boolean z3, final boolean z4) {
        mo29057a(z, z2, str, z3, (IExportTpyeChoose) new IExportTpyeChoose() {
            public void onExportTypeChoose(int i, boolean z) {
                if (z4 || !z) {
                    if (ExportVideoFragment.this.cPr != null) {
                        ExportVideoFragment.this.m17759a(ExportVideoFragment.this.cPr);
                    }
                    return;
                }
                C10021c aZH = C10021c.aZH();
                ExportActionEvent exportActionEvent = new ExportActionEvent(ExportVideoFragment.this.uniqueId, 1, ExportVideoFragment.this.mProjectDataItem.strPrjExportURL, false);
                aZH.mo38492aA(exportActionEvent);
            }
        });
    }

    /* renamed from: a */
    public boolean mo29059a(FragmentActivity fragmentActivity, long j, long j2, boolean z) {
        this.mActivity = fragmentActivity;
        this.mContext = fragmentActivity.getApplicationContext();
        this.mActivity.getLifecycle().mo152a(this.cPu);
        this.bChinaArea = AppStateModel.getInstance().isInChina();
        Bundle bundle = new Bundle();
        bundle.putLong("uniqueId", j);
        bundle.putLong("magicCode", j2);
        bundle.putBoolean("bSlidePrj", z);
        setArguments(bundle);
        this.bOK = C8501a.aJs();
        this.cPm = z ? C8468c.aIQ() : C8522g.aJA();
        this.cFJ = this.cPm.aHd();
        this.mProjectDataItem = this.cPm.aHe();
        if (this.mProjectDataItem == null || this.cFJ == null || this.cFJ.getClipCount() <= 0) {
            return false;
        }
        this.cPq = new C6207a(Looper.getMainLooper());
        this.cPs = new C6227a();
        this.cPs.attachView((C6230b) this);
        this.uniqueId = j;
        this.magicCode = j2;
        if (this.mProjectDataItem == null) {
            return false;
        }
        this.ctc = new C6397i(this.mContext, C8404c.m24237bf(this.mProjectDataItem._id));
        return true;
    }

    /* renamed from: a */
    public final boolean mo29060a(boolean z, int i, boolean z2) {
        if (this.mProjectDataItem != null) {
            this.cPr = C6404j.m18433a(this.mContext, this.mProjectDataItem.strPrjURL, this.mProjectDataItem.isMVPrj(), i, null, z);
            if (this.cPm instanceof C8522g) {
                float f = ((C8522g) this.cPm).bmF;
                if (i == 1) {
                    f = ((C8522g) this.cPm).bmG;
                } else if (i == 2) {
                    f = ((C8522g) this.cPm).bmH;
                }
                this.cPr.videoBitrateScales = f;
            }
        }
        return !z2 && !m17786nq(i) && m17777fO(z);
    }

    public void alA() {
        if (this.mProjectDataItem != null && this.mContext != null) {
            this.cPm.mo33876a(this.mProjectDataItem, AppStateModel.getInstance().isCommunitySupport());
        }
    }

    public String alB() {
        return this.cFJ != null ? C8540q.m24908Q(this.cFJ) : "";
    }

    /* access modifiers changed from: protected */
    public boolean alE() {
        boolean z = !C8072q.aBx().mo33072ku(C7825a.HD.getId());
        StringBuilder sb = new StringBuilder();
        sb.append(">>>> isHDNotPurchased=");
        sb.append(z);
        LogUtilsV2.m14228e(sb.toString());
        return z;
    }

    public String alG() {
        long alF = alF();
        return alF > 0 ? C8450a.m24469bn(alF) : "";
    }

    public String alH() {
        String l = C8762d.aMt().mo35241l(alF(), 4);
        return l == null ? "" : l;
    }

    public int alI() {
        return this.mProjectDataItem.prjThemeType;
    }

    public PublishDetailInfo alJ() {
        if (this.mProjectDataItem == null) {
            return null;
        }
        PublishDetailInfo publishDetailInfo = new PublishDetailInfo(this.mProjectDataItem.strPrjTitle, this.mProjectDataItem.strVideoDesc, this.mProjectDataItem.strActivityData, this.mProjectDataItem.strExtra, C8558m.m25035or(this.mProjectDataItem.strExtra), this.mProjectDataItem.getPrjTodoContent());
        return publishDetailInfo;
    }

    public List<Integer> alK() {
        return C6406l.m18439e(this.cFJ);
    }

    public String alv() {
        return this.mProjectDataItem != null ? this.mProjectDataItem.strPrjExportURL : "";
    }

    public String alw() {
        return this.mProjectDataItem != null ? this.mProjectDataItem.strPrjThumbnail : "";
    }

    public String alx() {
        return this.mProjectDataItem != null ? this.mProjectDataItem.strCoverURL : "";
    }

    public ExportPrjInfo aly() {
        if (this.mProjectDataItem == null || this.cPm.aHd() == null || this.cPm.aHd().getClipCount() <= 0) {
            return null;
        }
        return new Builder()._id(this.mProjectDataItem._id).strPrjURL(this.mProjectDataItem.strPrjURL).isModified(this.mProjectDataItem.isProjectModified()).isMVPrj(this.mProjectDataItem.isMVPrj()).prjName(this.mProjectDataItem.getProjectName()).iPrjDuration(this.mProjectDataItem.iPrjDuration).strCreateTime(this.mProjectDataItem.strCreateTime).prjThemeType(this.mProjectDataItem.prjThemeType).build();
    }

    public ExportVideoInfo alz() {
        if (this.mProjectDataItem == null || this.cPr == null) {
            return null;
        }
        C9536c cVar = new C9536c();
        cVar.duration = this.mProjectDataItem.iPrjDuration;
        VeMSize b = C8438d.m24393b(this.cPr);
        if (b == null) {
            return null;
        }
        cVar.eTh = new MSize(b.width, b.height);
        return new ExportVideoInfo(cVar.duration, cVar.eTh.width, cVar.eTh.height);
    }

    /* renamed from: fK */
    public void mo29074fK(boolean z) {
        if (this.mProjectDataItem != null) {
            this.cPs.release();
            long j = 0;
            if (TextUtils.isEmpty(this.mProjectDataItem.strCoverURL)) {
                this.mProjectDataItem.strCoverURL = C6255i.m17930hF(this.mProjectDataItem.strPrjURL);
            } else {
                j = C8558m.m25031on(this.mProjectDataItem.strExtra).longValue();
            }
            long j2 = j;
            if (z) {
                SlideshowRouter.launchSlideshowCover(this.mActivity, this.cPm instanceof C8468c, this.mProjectDataItem.strCoverURL, j2, 8449);
            } else if (this.cPm instanceof C8522g) {
                C8522g gVar = (C8522g) this.cPm;
                if (this.cFJ == null) {
                    C8410e.m24270gK(this.mContext);
                    gVar.mo34738a(this.bOK, (Handler) this.cPq);
                } else {
                    UserBehaviorUtilsV5.onEventEditVideoCover(this.mContext);
                    C6254h.m17922eZ(this.mContext);
                    m17752a((Activity) this.mActivity, 8449, this.mProjectDataItem.strCoverURL, j2, false);
                }
            } else {
                SlideshowRouter.launchSlideshowCover(this.mActivity, true, this.mProjectDataItem.strCoverURL, j2, 8449);
            }
        }
    }

    /* renamed from: fL */
    public boolean mo29075fL(boolean z) {
        if (this.mActivity == null || this.mContext == null || C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId())) {
            return false;
        }
        C8380a aHf = this.cPm.aHf();
        if (aHf == null || aHf.getStoryboard() == null) {
            return false;
        }
        if (!new C9006a(this.mContext.getResources(), aHf.getStoryboard().getDuration(), C6255i.m17931u(this.bChinaArea, z)).aNp()) {
            return false;
        }
        m17764ap(getActivity());
        return true;
    }

    /* renamed from: hG */
    public boolean mo29076hG(String str) {
        boolean z = false;
        if (this.cFJ == null || this.cPr == null) {
            return false;
        }
        if (FileUtils.getFreeSpace(FileUtils.getFileParentPath(str)) > C8438d.m24392b(this.cFJ, this.cPr)) {
            z = true;
        }
        return z;
    }

    /* renamed from: hH */
    public String mo29077hH(String str) {
        try {
            return C8460a.m24503o(new JSONObject(str));
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: n */
    public void mo29078n(ImageView imageView) {
        if (this.mContext != null) {
            C8380a aHf = this.cPm.aHf();
            if (imageView == null || !(aHf == null || aHf.mProjectDataItem == null)) {
                String str = aHf.mProjectDataItem.strCoverURL;
                if (imageView != null && FileUtils.isFileExisted(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(FileUtils.fileSize(str));
                    ImageLoader.loadImageWithSignature(this.mContext, str, imageView, sb.toString());
                } else if (aHf.getStoryboard() != null) {
                    this.cPs.mo29128a(aHf, imageView);
                }
            } else {
                imageView.setImageResource(R.drawable.prj_no_clip_default);
            }
        }
    }

    /* renamed from: np */
    public void mo29079np(int i) {
        if (this.mActivity != null) {
            if (!C5530d.m14977kn(i)) {
                m17774f(this.mActivity);
            } else if (this.cPm != null) {
                if (C8446b.aIZ().mo34321bh(this.mProjectDataItem._id) == 5) {
                    C8446b.aIZ().mo34326k(this.mActivity.getApplicationContext(), this.mProjectDataItem._id);
                    StudioRouter.launchStudioActivity(this.mActivity);
                } else {
                    m17774f(this.mActivity);
                }
            }
        }
    }

    /* renamed from: nr */
    public boolean mo29080nr(int i) {
        return C6406l.m18435b(this.cFJ, i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mActivity != null && !this.mActivity.isFinishing()) {
            boolean z = true;
            if ((!this.cPn && i != 10632) || C6253g.alt() != 1) {
                z = false;
            }
            if (z) {
                C6253g.m17916no(2);
                this.cPn = false;
            }
            if (i == 8448 && i2 == -1) {
                if (this.cPm instanceof C8522g) {
                    GifExpModel gifExpModel = (GifExpModel) intent.getExtras().getParcelable("gif_params");
                    this.cPr = C6404j.m18433a(this.mContext, this.mProjectDataItem.strPrjURL, this.mProjectDataItem.isMVPrj(), 3, gifExpModel, false);
                    m17759a(this.cPr);
                    C6254h.m17917bq(this.mContext, "gif");
                }
            } else if (i == 8449 && i2 == -1) {
                try {
                    String str = this.mProjectDataItem.strCoverURL;
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        long j = extras.getLong(PickCoverParams.ACTIVITY_COVER_PICK_TIME_POSITION_KEY, 0);
                        this.mProjectDataItem.strExtra = C8558m.m25023k(this.mProjectDataItem.strExtra, j);
                    }
                    if (FileUtils.isFileExisted(str)) {
                        FileUtils.deleteFile(this.mProjectDataItem.strPrjThumbnail);
                        String str2 = this.mProjectDataItem.strPrjThumbnail;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = str;
                        }
                        int lastIndexOf = str2.lastIndexOf(File.separator);
                        int lastIndexOf2 = this.mProjectDataItem.strPrjThumbnail.lastIndexOf(46);
                        if (lastIndexOf > 0 && lastIndexOf2 > 0 && lastIndexOf2 > lastIndexOf) {
                            String substring = this.mProjectDataItem.strPrjThumbnail.substring(0, lastIndexOf);
                            String substring2 = this.mProjectDataItem.strPrjThumbnail.substring(lastIndexOf2);
                            DataItemProject dataItemProject = this.mProjectDataItem;
                            StringBuilder sb = new StringBuilder();
                            sb.append(substring);
                            sb.append(File.separator);
                            sb.append("thumb_");
                            sb.append(System.currentTimeMillis());
                            sb.append(substring2);
                            dataItemProject.strPrjThumbnail = sb.toString();
                        }
                        FileUtils.copyFile(str, this.mProjectDataItem.strPrjThumbnail);
                    }
                    alA();
                    C10021c.aZH().mo38492aA(new CoverChangedEvent(this.uniqueId));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mContext == null || this.mActivity == null || this.ctc == null || this.cPm == null || this.cFJ == null || this.cPs == null) {
            this.mActivity = getActivity();
            if (this.mActivity != null) {
                this.mContext = this.mActivity.getApplicationContext();
                boolean z = getArguments().getBoolean("bSlidePrj", false);
                long j = getArguments().getLong("uniqueId", 0);
                long j2 = getArguments().getLong("magicCode", 0);
                this.bChinaArea = AppStateModel.getInstance().isInChina();
                this.bOK = C8501a.aJs();
                this.cPm = z ? C8468c.aIQ() : C8522g.aJA();
                this.cFJ = this.cPm.aHd();
                this.mProjectDataItem = this.cPm.aHe();
                this.cPq = new C6207a(Looper.getMainLooper());
                this.cPs = new C6227a();
                this.cPs.attachView((C6230b) this);
                this.uniqueId = j;
                this.magicCode = j2;
                if (this.mProjectDataItem != null) {
                    this.ctc = new C6397i(this.mContext, C8404c.m24237bf(this.mProjectDataItem._id));
                }
            }
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
