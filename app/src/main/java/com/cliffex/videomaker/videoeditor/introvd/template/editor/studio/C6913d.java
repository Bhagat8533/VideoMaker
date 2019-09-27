package com.introvd.template.editor.studio;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.support.p021v4.widget.NestedScrollView;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.GridLayoutManager.LayoutParams;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.google.android.exoplayer2.util.MimeTypes;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtilsV7;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.effects.customwatermark.C6092e;
import com.introvd.template.editor.p244a.C5553a;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.service.ProjectScanService;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p207c.C4612a;
import com.introvd.template.p324m.C7563a;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.router.camera.CameraIntentInfo.Builder;
import com.introvd.template.router.community.PublishParams.DomeSocialPublishParams;
import com.introvd.template.router.community.svip.ISvipAPI;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.studio.StudioActionEvent;
import com.introvd.template.router.slide.SlideshowRouter;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p380a.C8380a;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.p390f.C8445a;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.quvideo.rescue.C4905b;
import com.quvideo.rescue.model.LogModel;
import java.io.File;
import java.lang.ref.WeakReference;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.studio.d */
public class C6913d {
    /* access modifiers changed from: private */

    /* renamed from: Vu */
    public RecyclerView f3517Vu;
    /* access modifiers changed from: private */
    public WeakReference<Activity> bwg;
    /* access modifiers changed from: private */
    public int djh = 0;
    private boolean dji = false;
    /* access modifiers changed from: private */
    public int djj = 0;
    private String djk = null;
    /* access modifiers changed from: private */
    public C6899b djl;
    /* access modifiers changed from: private */
    public C6892a djm;
    /* access modifiers changed from: private */
    public C6926c djn;
    private NestedScrollView djo = null;
    /* access modifiers changed from: private */
    public int djp = -1;
    /* access modifiers changed from: private */
    public boolean djq = false;
    /* access modifiers changed from: private */
    public boolean djr = false;
    private C6912c djs = new C6912c() {
        /* renamed from: a */
        public void mo30557a(C8445a aVar) {
            C6913d.this.m20159d(aVar);
        }

        /* renamed from: a */
        public void mo30558a(C8445a aVar, int i) {
            if (!(1 != C6913d.this.djj || C6913d.this.bwg == null || C6913d.this.bwg.get() == null)) {
                UserBehaviorUtilsV7.onEventClickHomepageDraftList((Context) C6913d.this.bwg.get(), "删除");
            }
            C6913d.this.m20154b(aVar, i);
        }

        /* renamed from: b */
        public void mo30559b(C8445a aVar) {
            if (!(1 != C6913d.this.djj || C6913d.this.bwg == null || C6913d.this.bwg.get() == null)) {
                UserBehaviorUtilsV7.onEventClickHomepageDraftList((Context) C6913d.this.bwg.get(), "保存/上传");
            }
            C6913d.this.djp = 2;
            C6913d.this.djn.sendMessage(C6913d.this.djn.obtainMessage(258, C6913d.this.djp, 0, aVar));
        }

        /* renamed from: c */
        public void mo30560c(final C8445a aVar) {
            if (aVar != null) {
                final Activity activity = (Activity) C6913d.this.bwg.get();
                C8978m.m26350ht(activity).mo10296do(R.string.xiaoying_str_prj_send_tip).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        C4905b.m12541a(new LogModel().withPageName(activity.getLocalClassName()).withLogLevel(LogModel.LEVEL_WARING).withMessage("Upload_User_ProjectFile"));
                        ProjectScanService.m19493a(activity.getApplicationContext(), aVar.strPrjURL, new String[0]);
                        ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_ve_after_uplode_toast), 0);
                    }
                }).mo10313qu().show();
            }
        }
    };

    /* renamed from: com.introvd.template.editor.studio.d$a */
    public interface C6924a {
        void asr();
    }

    /* renamed from: com.introvd.template.editor.studio.d$b */
    private class C6925b extends ExAsyncTask<Object, Integer, Boolean> {
        private long djB;
        private boolean djC;
        private int position;

        private C6925b() {
            this.djB = 0;
            this.position = -1;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Boolean doInBackground(Object... objArr) {
            this.djC = objArr[0].booleanValue();
            this.djB = objArr[1].longValue();
            String str = objArr[2];
            this.position = objArr[3].intValue();
            if (C6913d.this.bwg.get() != null) {
                (this.djC ? C8468c.aIQ() : C8522g.aJA()).mo33875a((Context) C6913d.this.bwg.get(), str, 1, true);
            }
            C6092e.m17361hn(C6092e.m17362ho(str));
            return Boolean.valueOf(true);
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            Activity j = C6913d.this.getHostActivity();
            if (j != null) {
                if (bool.booleanValue()) {
                    ToastUtils.show((Context) j, R.string.xiaoying_str_delete_draft_success, 0);
                } else {
                    ToastUtils.show((Context) j, R.string.xiaoying_str_studio_del_prj_msg_fail, 0);
                }
            }
            C8446b.aIZ().remove((int) this.djB);
            C10021c.aZH().mo38492aA(new StudioActionEvent(0, C6913d.this.djj));
            if ((C6913d.this.djh == 2 ? C6913d.this.djm.getDataList().size() : C6913d.this.djl.getDataList().size()) == 1) {
                C6913d.this.m20168hl(true);
            } else {
                C6913d.this.djn.sendMessage(C6913d.this.djn.obtainMessage(8193, Integer.valueOf(this.position)));
            }
            C4586g.m11695Sl();
        }
    }

    /* renamed from: com.introvd.template.editor.studio.d$c */
    private static class C6926c extends WeakHandler<C6913d> {
        public C6926c(C6913d dVar) {
            super(dVar);
        }

        public void handleMessage(Message message) {
            C6913d dVar = (C6913d) getOwner();
            if (dVar != null) {
                Activity activity = (Activity) dVar.bwg.get();
                if (activity != null) {
                    int i = message.what;
                    if (i != 258) {
                        if (i != 262) {
                            switch (i) {
                                case 8193:
                                    int intValue = ((Integer) message.obj).intValue();
                                    if (dVar.djh != 2) {
                                        dVar.djl.removeItem(intValue);
                                        break;
                                    } else {
                                        dVar.djm.removeItem(intValue);
                                        break;
                                    }
                                case 8194:
                                    C8445a aVar = (C8445a) message.obj;
                                    if (aVar != null) {
                                        C8381b aIQ = C8451b.m24477un(aVar.prjThemeType) ? C8468c.aIQ() : C8522g.aJA();
                                        dVar.djp = 8194;
                                        aIQ.ebQ = aIQ.mo33885aV(aVar._id);
                                        C8380a aHf = aIQ.aHf();
                                        if (!(aHf == null || aHf.mProjectDataItem == null)) {
                                            if ((aHf.getCacheFlag() & 2) != 0) {
                                                dVar.m20148a(activity, aVar, dVar.djp);
                                                break;
                                            } else {
                                                dVar.m20165f(aVar);
                                                break;
                                            }
                                        }
                                    } else {
                                        return;
                                    }
                            }
                        } else if (dVar.f3517Vu != null && dVar.f3517Vu.getVisibility() == 0) {
                            dVar.djl.notifyDataSetChanged();
                        }
                    } else if (!dVar.djr) {
                        int i2 = message.arg1;
                        if (i2 != 4) {
                            if (i2 != 7) {
                                switch (i2) {
                                    case 1:
                                    case 2:
                                        break;
                                    default:
                                        switch (i2) {
                                            case 12:
                                                dVar.m20163e((C8445a) message.obj);
                                                break;
                                            case 13:
                                                C8445a aVar2 = (C8445a) message.obj;
                                                try {
                                                    Intent intent = new Intent("android.intent.action.VIEW");
                                                    C4612a.m11759a(intent, MimeTypes.VIDEO_MP4, new File(aVar2.strPrjExportURL), true);
                                                    intent.setFlags(268435456);
                                                    activity.startActivity(intent);
                                                    break;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                    break;
                                                }
                                        }
                                }
                            } else {
                                C8445a aVar3 = (C8445a) message.obj;
                                int i3 = message.arg2;
                                if (aVar3 != null) {
                                    dVar.m20142a(aVar3._id, aVar3, i3);
                                } else {
                                    return;
                                }
                            }
                        }
                        sendEmptyMessage(262);
                        C8445a aVar4 = (C8445a) message.obj;
                        if (aVar4 != null) {
                            if (message.arg1 == 2 && !TextUtils.isEmpty(aVar4.strActivityData)) {
                                aVar4.strActivityData = "";
                            }
                            dVar.m20165f(aVar4);
                        }
                    }
                }
            }
        }
    }

    public C6913d(Activity activity) {
        this.bwg = new WeakReference<>(activity);
        if (activity != null) {
            this.djk = activity.getIntent().getStringExtra("activityID");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20142a(long j, C8445a aVar, int i) {
        final Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            activity.getContentResolver();
            final String be = C8404c.m24236be(j);
            if (!TextUtils.isEmpty(be)) {
                C1895a r = C8978m.m26350ht(activity).mo10315r(activity.getResources().getString(R.string.xiaoying_str_delete_draft_dialog_title));
                final C8445a aVar2 = aVar;
                final long j2 = j;
                final int i2 = i;
                C69216 r1 = new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", C8446b.m24444g(aVar2) ? "exported" : "draft");
                        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C6913d.this.djj == 0 ? EditorRouter.ENTRANCE_STUDIO : EditorRouter.ENTRANCE_ME_STUDIO);
                        UserBehaviorLog.onKVEvent(activity, "Studio_Delete", hashMap);
                        C4586g.m11703a((Context) activity, R.string.xiaoying_str_studio_del_prj_msg_processing, (OnCancelListener) null);
                        try {
                            new C6925b().execute((Params[]) new Object[]{Boolean.valueOf(C8451b.m24477un(aVar2.prjThemeType)), Long.valueOf(j2), be, Integer.valueOf(i2)});
                        } catch (Exception e) {
                            C4586g.m11696Sm();
                            e.printStackTrace();
                        }
                    }
                };
                r.mo10281a((C1904j) r1).mo10313qu().show();
            }
        }
    }

    /* renamed from: a */
    public static boolean m20147a(Activity activity, int i, C8381b bVar, String str) {
        boolean z;
        int i2;
        if (i != 2) {
            if ((i == 6 || i == 10) && bVar != null) {
                DataItemProject aHe = bVar.aHe();
                if (aHe != null) {
                    if (bVar instanceof C8522g) {
                        if (C8451b.m24482us(aHe.prjThemeType)) {
                            EditorRouter.launchFastEditorActivity(activity, new Object[0]);
                            return true;
                        } else if (C8446b.aIZ().mo34322bi(aHe._id)) {
                            EditorRouter.launchEditorPreviewActivity(activity, C3742b.m9111II().mo23139JG(), new Object[0]);
                            return true;
                        } else {
                            EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
                            editorIntentInfo.from = str;
                            EditorRouter.launchEditorActivity(activity, editorIntentInfo);
                            return true;
                        }
                    } else if (C5837a.agH().agM()) {
                        SlideshowRouter.launchSlideEdit(activity, false);
                        return true;
                    } else {
                        SlideshowRouter.launchSlideshowPreview(activity, false);
                        return true;
                    }
                }
            }
            return false;
        }
        if (bVar != null) {
            bVar.aHg();
            DataItemProject aHe2 = bVar.aHe();
            if (aHe2 != null) {
                int i3 = aHe2.iCameraCode;
                if (i3 != 0) {
                    int cameraModeParam = CameraCodeMgr.getCameraModeParam(i3);
                    z = !CameraCodeMgr.isCameraParamPIP(cameraModeParam);
                    i2 = cameraModeParam == 12 ? 1 : 0;
                    Builder builder = new Builder();
                    builder.setNewPrj(0);
                    builder.setbNewCam(z);
                    builder.setCaptureMode(i2);
                    C7563a.m22315a(activity, builder.build(), null, false);
                    return true;
                }
            }
        }
        i2 = 0;
        z = true;
        Builder builder2 = new Builder();
        builder2.setNewPrj(0);
        builder2.setbNewCam(z);
        builder2.setCaptureMode(i2);
        C7563a.m22315a(activity, builder2.build(), null, false);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20148a(Activity activity, C8445a aVar, int i) {
        C4586g.m11695Sl();
        this.djr = false;
        if (activity == null || aVar == null) {
            return false;
        }
        String[] ok = C8558m.m25028ok(aVar.strExtra);
        C5553a.m15009b(ok[0], ok[1], false);
        final boolean un = C8451b.m24477un(aVar.prjThemeType);
        C8381b aIQ = un ? C8468c.aIQ() : C8522g.aJA();
        DataItemProject aHe = aIQ.aHe();
        if (aHe != null && (i == 4 || i == 1)) {
            aHe.strExtra = C8558m.m25029ol(aHe.strExtra);
            C1820a.aVi().mo10058o(new Runnable() {
                public void run() {
                    if (!un) {
                        C8522g.aJA().aHc();
                    } else {
                        C8468c.aIQ().aHc();
                    }
                }
            });
        }
        if (i == 4) {
            int a = C8446b.aIZ().mo34315a(activity.getApplicationContext(), aHe);
            String str = "unknown";
            if (this.djj == 0) {
                str = EditorRouter.ENTRANCE_STUDIO;
            } else if (this.djj == 1) {
                str = EditorRouter.ENTRANCE_ME_STUDIO;
            }
            if (m20147a(activity, a, aIQ, str) && this.djj == 0) {
                activity.finish();
            }
        } else if (i != 8194) {
            switch (i) {
                case 1:
                    if (!un) {
                        DataItemProject aHe2 = aIQ.aHe();
                        if (aHe2 != null) {
                            if (C8446b.aIZ().mo34322bi(aHe2._id)) {
                                EditorRouter.launchEditorPreviewActivity(activity, C3742b.m9111II().mo23139JG(), new Object[0]);
                            } else if (C8451b.m24482us(aVar.prjThemeType)) {
                                EditorRouter.launchFastEditorActivity(activity, new Object[0]);
                            } else {
                                EditorRouter.launchEditorActivity(activity, new Object[0]);
                            }
                        }
                    } else if (C5837a.agH().agM()) {
                        SlideshowRouter.launchSlideEdit(activity, false);
                    } else {
                        SlideshowRouter.launchSlideshowPreview(activity, false);
                    }
                    if (this.djj == 0) {
                        activity.finish();
                        break;
                    }
                    break;
                case 2:
                    if (!un) {
                        activity.getIntent().putExtra("new_prj", 0);
                        if (C6386d.m18370a(activity, false, aHe)) {
                            C8446b.aIZ().mo34319b(activity.getApplicationContext(), aHe._id, 5);
                        }
                        UserBehaviorLog.onKVEvent(activity, "Studio_Video_Share", new HashMap());
                    } else if (aHe == null) {
                        return true;
                    } else {
                        String bn = C8450a.m24469bn(C8558m.m25025oh(aHe.strExtra).longValue());
                        ISvipAPI iSvipAPI = (ISvipAPI) BizServiceManager.getService(ISvipAPI.class);
                        if (iSvipAPI != null && iSvipAPI.checkCommodityNeedLogin(bn)) {
                            return true;
                        }
                        VivaRouter.getRouterBuilder(DomeSocialPublishParams.URL).mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_FROM_SOCIAL, false).mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_SLIDE_SHOW_VIDEO, true).mo10394aZ(R.anim.activity_enter, R.anim.activity_exit).mo10382H(activity);
                    }
                    if (this.djj == 0) {
                        activity.finish();
                        break;
                    }
                    break;
            }
        } else if (un) {
            SlideshowRouter.launchSlideshowPublish(activity, true, C8558m.m25024og(aHe.strExtra), C8558m.m25025oh(aHe.strExtra).longValue());
        } else {
            activity.getIntent().putExtra("new_prj", 0);
            C6386d.m18371a(activity, false, aHe, this.djk);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20154b(C8445a aVar, int i) {
        this.djn.sendMessage(this.djn.obtainMessage(258, 7, i, aVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: bI */
    public void m20155bI(List<C8445a> list) {
        Activity hostActivity = getHostActivity();
        if (hostActivity != null && !hostActivity.isFinishing()) {
            m20168hl(list.isEmpty());
            if (this.f3517Vu != null) {
                if (this.djh == 0) {
                    this.f3517Vu.setLayoutManager(new LinearLayoutManager(hostActivity));
                    this.f3517Vu.setAdapter(this.djl);
                    this.djl.mo30548hg(true);
                    this.djl.setDataList(new ArrayList(list));
                    this.djl.mo30549hh(this.dji);
                } else if (this.djh == 1) {
                    this.f3517Vu.setLayoutManager(new GridLayoutManager(hostActivity, 2));
                    this.f3517Vu.setAdapter(this.djl);
                    this.djl.mo30548hg(false);
                    this.djl.setDataList(new ArrayList(list));
                    this.djl.mo30549hh(this.dji);
                } else if (this.djh == 2) {
                    this.f3517Vu.setLayoutManager(new GridLayoutManager(hostActivity, 3));
                    if (this.f3517Vu.getItemDecorationCount() > 0) {
                        this.f3517Vu.mo7774ce(0);
                    }
                    this.f3517Vu.mo7733a((C1018h) new C1018h() {
                        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                            super.getItemOffsets(rect, view, recyclerView, rVar);
                            int aN = recyclerView.mo7746aN(view);
                            int ks = ((LayoutParams) view.getLayoutParams()).mo7573ks();
                            if (aN > 0) {
                                if (ks == 2) {
                                    rect.right = 0;
                                    rect.left = C7689a.m22597aR(0.75f);
                                } else if (ks == 1) {
                                    rect.right = C7689a.m22597aR(0.75f);
                                    rect.left = C7689a.m22597aR(0.75f);
                                } else {
                                    rect.left = 0;
                                    rect.right = C7689a.m22597aR(0.75f);
                                }
                            }
                            rect.bottom = C7689a.m22597aR(1.5f);
                            rect.top = 0;
                        }
                    });
                    this.f3517Vu.setAdapter(this.djm);
                    this.djm.setDataList(new ArrayList(list));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m20159d(C8445a aVar) {
        if (this.bwg != null && this.bwg.get() != null) {
            if (!this.dji) {
                this.djn.sendMessage(this.djn.obtainMessage(258, 12, 0, aVar));
            } else if (aVar.egu >= 2) {
                ToastUtils.longShow((Context) this.bwg.get(), R.string.xiaoying_str_studio_tag_limit_notrans);
            } else {
                this.djn.sendMessage(this.djn.obtainMessage(8194, aVar));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m20163e(C8445a aVar) {
        int i = aVar == null ? 0 : aVar.iPrjClipCount != 0 ? 4 : 1;
        this.djn.sendEmptyMessage(262);
        this.djp = i;
        if (this.djp > 0) {
            this.djn.sendMessage(this.djn.obtainMessage(258, this.djp, 0, aVar));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m20165f(final C8445a aVar) {
        if (!this.djq) {
            Activity hostActivity = getHostActivity();
            if (hostActivity != null && !hostActivity.isFinishing()) {
                final boolean un = C8451b.m24477un(aVar.prjThemeType);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("prj_load_callback_action");
                LocalBroadcastManager.getInstance(hostActivity.getApplicationContext()).registerReceiver(new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        Activity j = C6913d.this.getHostActivity();
                        if (j != null && !j.isFinishing()) {
                            Context applicationContext = j.getApplicationContext();
                            LocalBroadcastManager.getInstance(applicationContext).unregisterReceiver(this);
                            if ("prj_load_callback_action".equals(intent.getAction())) {
                                if (intent.getBooleanExtra("prj_load_cb_intent_data_flag", true)) {
                                    C6913d.this.m20169hm(un);
                                    C6913d.this.m20148a(j, aVar, C6913d.this.djp);
                                } else {
                                    C6913d.this.djr = false;
                                    C4586g.m11695Sl();
                                    ToastUtils.show(applicationContext, R.string.xiaoying_str_ve_project_load_fail, 0);
                                }
                            }
                        }
                    }
                }, intentFilter);
                this.djr = true;
                ProjectScanService.m19510j(hostActivity, aVar.strPrjURL, un);
            }
        }
    }

    private String getCurrentSQLTimestamp() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    /* access modifiers changed from: private */
    public Activity getHostActivity() {
        if (this.bwg == null) {
            return null;
        }
        return (Activity) this.bwg.get();
    }

    /* access modifiers changed from: private */
    /* renamed from: hl */
    public void m20168hl(boolean z) {
        int i = 0;
        if (this.djo != null) {
            ((ImageView) this.djo.findViewById(R.id.studio_no_video_icon)).setImageResource(AppStateModel.getInstance().isMiddleEast() ? R.drawable.editor_east_draft_empty_video : R.drawable.editor_studio_draft_empty_bg);
            this.djo.setVisibility(z ? 0 : 4);
        }
        if (this.f3517Vu != null) {
            RecyclerView recyclerView = this.f3517Vu;
            if (z) {
                i = 4;
            }
            recyclerView.setVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hm */
    public void m20169hm(boolean z) {
        if (!z) {
            ProjectItem ahP = C8522g.aJA().aHf();
            if (ahP != null) {
                DataItemProject dataItemProject = ahP.mProjectDataItem;
                if (dataItemProject != null) {
                    dataItemProject.strModifyTime = getCurrentSQLTimestamp();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo30561a(RecyclerView recyclerView, NestedScrollView nestedScrollView) {
        this.f3517Vu = recyclerView;
        this.djl = new C6899b((Context) this.bwg.get());
        this.djl.mo30546a(this.djs);
        this.djm = new C6892a((Context) this.bwg.get());
        this.djm.mo30542a(this.djs);
        this.djn = new C6926c(this);
        this.djo = nestedScrollView;
        this.djl.mo30547a((C6924a) new C6924a() {
            public void asr() {
                if (C6913d.this.f3517Vu != null) {
                    C6913d.this.f3517Vu.post(new Runnable() {
                        public void run() {
                            C6913d.this.mo30563hk(false);
                        }
                    });
                }
            }
        });
    }

    /* renamed from: hj */
    public void mo30562hj(boolean z) {
        this.dji = z;
    }

    /* renamed from: hk */
    public void mo30563hk(final boolean z) {
        if (!this.djq && !this.djr) {
            final Activity hostActivity = getHostActivity();
            if (hostActivity != null && !hostActivity.isFinishing()) {
                this.djq = true;
                C1848s.m5326ai(Boolean.valueOf(true)).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
                    /* renamed from: c */
                    public Boolean apply(Boolean bool) throws Exception {
                        if (z) {
                            C8468c.aIQ().mo33874S(hostActivity.getApplicationContext(), false);
                            C8522g.aJA().mo33874S(hostActivity.getApplicationContext(), false);
                        }
                        C8446b.aIZ().mo34316am(hostActivity, 0);
                        return Boolean.valueOf(true);
                    }
                }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
                    /* renamed from: e */
                    public void onSuccess(Boolean bool) {
                        C6913d.this.m20155bI(C8446b.aIZ().getList());
                        C6913d.this.djq = false;
                    }

                    public void onError(Throwable th) {
                        C6913d.this.djq = false;
                    }
                });
            }
        }
    }

    public void onDestroy() {
        if (this.f3517Vu != null) {
            this.f3517Vu.setAdapter(null);
            this.f3517Vu = null;
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    /* renamed from: pw */
    public void mo30567pw(int i) {
        this.djj = i;
    }

    /* renamed from: px */
    public void mo30568px(int i) {
        this.djh = i;
    }
}
