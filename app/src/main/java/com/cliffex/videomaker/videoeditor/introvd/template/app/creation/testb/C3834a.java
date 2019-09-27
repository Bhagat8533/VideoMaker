package com.introvd.template.app.creation.testb;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import com.introvd.template.R;
import com.introvd.template.app.community.freeze.C3763b;
import com.introvd.template.app.creation.C3818b;
import com.introvd.template.app.creation.C3821d;
import com.introvd.template.app.creation.testb.C3848e.C3852a;
import com.introvd.template.app.creation.testb.C3848e.C3853b;
import com.introvd.template.app.homepage.AppModelConfigInfo;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.homepage.C3935b.C3941a;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.filecache.FileCache;
import com.introvd.template.common.filecache.FileCache.Builder;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.editor.studio.StudioActionEvent;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.user.UserServiceProxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.creation.testb.a */
public class C3834a extends BaseController<C3854f> {
    private C3846c bpb;
    /* access modifiers changed from: private */
    public BroadcastReceiver bpc;
    /* access modifiers changed from: private */
    public C3848e bpd;
    /* access modifiers changed from: private */
    public List<String> bpe;
    private C3853b bpf = new C3853b() {
        /* renamed from: c */
        public void mo23357c(C3843b bVar) {
            C3834a.this.m9426b(bVar);
            if (C3834a.this.bpd != null && C3834a.this.bpd.isShowing()) {
                C3834a.this.bpd.dismiss();
            }
        }
    };
    private C3847d bpg = new C3847d() {
        /* renamed from: c */
        public void mo23358c(C3843b bVar) {
            C3834a.this.m9426b(bVar);
        }
    };
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    /* access modifiers changed from: private */
    public Context context;

    /* renamed from: E */
    private void m9412E(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            List KF = m9415KF();
            if (KF != null && KF.size() != 0) {
                if (this.bpd == null) {
                    this.bpd = new C3852a(this.context).mo23384b((OnDismissListener) new OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            C3818b.m9356N(C3834a.this.context, "Exit");
                        }
                    }).mo23386p(null).mo23385b(this.bpf).mo23383U(KF).mo23382KS();
                } else {
                    this.bpd.show();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: KD */
    public void m9413KD() {
        m9418Ke().mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<AppModelConfigInfo>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: a */
            public void mo9886K(AppModelConfigInfo appModelConfigInfo) {
                ((C3854f) C3834a.this.getMvpView()).mo23324c(appModelConfigInfo);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                ((C3854f) C3834a.this.getMvpView()).mo23324c(C3834a.this.m9419Kf());
            }
        });
    }

    /* renamed from: KE */
    private List<C3843b> m9414KE() {
        if (this.bpb == null) {
            return null;
        }
        return this.bpb.mo23376KE();
    }

    /* renamed from: KF */
    private List<C3843b> m9415KF() {
        if (this.bpb == null) {
            return null;
        }
        return this.bpb.mo23377KF();
    }

    /* access modifiers changed from: private */
    /* renamed from: KH */
    public void m9416KH() {
        if (this.bpc == null) {
            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
            if (iEditorService != null) {
                iEditorService.startPrjScanService(this.context);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH);
                this.bpc = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        if (StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH.equals(intent.getAction())) {
                            C1487a.aUa().mo9777a(new Runnable() {
                                public void run() {
                                    C3834a.this.mo23350bw(false);
                                }
                            }, 1000, TimeUnit.MILLISECONDS);
                        }
                        if (C3834a.this.bpc != null) {
                            LocalBroadcastManager.getInstance(context).unregisterReceiver(C3834a.this.bpc);
                            C3834a.this.bpc = null;
                        }
                    }
                };
                LocalBroadcastManager.getInstance(this.context).registerReceiver(this.bpc, intentFilter);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Kd */
    public ModeItemInfo m9417Kd() {
        ModeItemInfo modeItemInfo;
        AppModelConfigInfo Lj = C3935b.m9679Lb().mo23480Lj();
        if (AppStateModel.getInstance().isInChina() && Lj == null) {
            return null;
        }
        if (Lj == null) {
            modeItemInfo = new ModeItemInfo();
            modeItemInfo.itemName = "shuffle";
            modeItemInfo.rawId = 0;
            modeItemInfo.todoCode = TodoConstants.TODO_TYPE_SHOW_SHUFFLE_ADS;
            modeItemInfo.itemImgBackupRes = Integer.valueOf(R.drawable.vivavideo_tool_shuffle_new);
            modeItemInfo.itemNameBackupRes = R.string.xiaoying_str_com_ads_shuffle;
        } else {
            modeItemInfo = C3821d.m9371b(Lj);
        }
        return modeItemInfo;
    }

    /* renamed from: Ke */
    private C1834l<AppModelConfigInfo> m9418Ke() {
        AppModelConfigInfo Lg = C3935b.m9679Lb().mo23477Lg();
        Builder builder = new Builder(this.context, AppModelConfigInfo.class);
        StringBuilder sb = new StringBuilder();
        sb.append(TodoConstants.TODO_TYPE_VIP_UPGRADE);
        sb.append(AppModelConfigInfo.class.getName());
        FileCache build = builder.setCacheKey(sb.toString()).build();
        if (Lg != null) {
            build.saveCache(Lg);
        }
        return build.getCache();
    }

    /* access modifiers changed from: private */
    /* renamed from: Kf */
    public AppModelConfigInfo m9419Kf() {
        AppModelConfigInfo appModelConfigInfo = new AppModelConfigInfo();
        appModelConfigInfo.eventType = TodoConstants.TODO_TYPE_VIP_UPGRADE;
        return appModelConfigInfo;
    }

    /* renamed from: a */
    private void m9422a(Activity activity, C3843b bVar) {
        if (activity != null && !activity.isFinishing() && bVar != null) {
            int freezeCode = C3763b.getFreezeCode();
            if (freezeCode == 203) {
                C3763b.m9231Is().mo23238f(((C3854f) getMvpView()).getHostActivity(), UserServiceProxy.getUserId(), freezeCode);
                return;
            }
            if (activity.getIntent() != null) {
                activity.getIntent().removeExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
            }
            TODOParamModel tODOParamModel = new TODOParamModel();
            tODOParamModel.mTODOCode = bVar.mo23366KM();
            tODOParamModel.mJsonParam = bVar.mo23367KN();
            Bundle bundle = new Bundle();
            bundle.putString(EditorRouter.COMMON_PARAM_POSITION, EditorRouter.COMMON_BEHAVIOR_POSITION_CREATION);
            BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel, bundle);
            ((C3854f) getMvpView()).mo23322a(bVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9426b(C3843b bVar) {
        switch (bVar.getType()) {
            case 1:
                m9422a(((C3854f) getMvpView()).getHostActivity(), bVar);
                String str = "";
                if (bVar.mo23366KM() == 408) {
                    str = "Slideshow";
                } else if (bVar.mo23366KM() == 401) {
                    str = "Edit";
                }
                if (mo23346KG()) {
                    C3818b.m9355M(this.context, str);
                    return;
                } else {
                    C3818b.m9354L(this.context, str);
                    return;
                }
            case 2:
                m9422a(((C3854f) getMvpView()).getHostActivity(), bVar);
                String str2 = "";
                if (bVar.mo23366KM() == 934) {
                    str2 = "video_Save";
                } else if (bVar.mo23366KM() == 426) {
                    str2 = "Wow";
                } else if (bVar.mo23366KM() == 217) {
                    str2 = "MusicLens";
                } else if (bVar.mo23366KM() == 215) {
                    str2 = "Selfie";
                } else if (bVar.mo23366KM() == 210) {
                    str2 = "Mix_video";
                } else if (bVar.mo23366KM() == 409) {
                    str2 = "Collage";
                }
                C3818b.m9356N(this.context, str2);
                return;
            case 3:
                m9422a(((C3854f) getMvpView()).getHostActivity(), bVar);
                if (mo23346KG()) {
                    C3818b.m9355M(this.context, "Effects");
                    return;
                } else {
                    C3818b.m9354L(this.context, "Effects");
                    return;
                }
            case 4:
                m9412E(((C3854f) getMvpView()).getHostActivity());
                if (mo23346KG()) {
                    C3818b.m9355M(this.context, "More");
                    return;
                } else {
                    C3818b.m9354L(this.context, "More");
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: F */
    public void mo23342F(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            if (mo23346KG()) {
                C3818b.m9355M(this.context, "Camera");
            } else {
                C3818b.m9354L(this.context, "Camera");
            }
            if (activity.getIntent() != null) {
                activity.getIntent().removeExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
            }
            TODOParamModel tODOParamModel = new TODOParamModel();
            tODOParamModel.mTODOCode = TodoConstants.TODO_TYPE_CAMERA_MODE_HD6;
            Bundle bundle = new Bundle();
            bundle.putString(EditorRouter.COMMON_PARAM_POSITION, EditorRouter.COMMON_BEHAVIOR_POSITION_CREATION);
            BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel, bundle);
        }
    }

    /* renamed from: G */
    public void mo23343G(Activity activity) {
        int freezeCode = C3763b.getFreezeCode();
        if (freezeCode == 203) {
            C3763b.m9231Is().mo23238f(((C3854f) getMvpView()).getHostActivity(), UserServiceProxy.getUserId(), freezeCode);
            return;
        }
        if (mo23346KG()) {
            C3818b.m9355M(this.context, "Draft");
        }
        TODOParamModel tODOParamModel = new TODOParamModel();
        tODOParamModel.mTODOCode = TodoConstants.TODO_TYPE_STUDIO;
        BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel);
    }

    /* renamed from: H */
    public void mo23344H(Activity activity) {
        AppRouter.startWebPage(activity, "http://hybrid.xiaoying.tv/vivavideo/help/en/Popular_Tips/Tutorial.html", null);
    }

    /* renamed from: KC */
    public void mo23345KC() {
        C3935b.m9679Lb().mo23482a(this.context, (C3941a) new C3941a() {
            /* renamed from: bu */
            public void mo23296bu(boolean z) {
                C3834a.this.m9413KD();
                ((C3854f) C3834a.this.getMvpView()).mo23323a(C3834a.this.m9417Kd());
            }
        });
    }

    /* renamed from: KG */
    public boolean mo23346KG() {
        return this.bpe != null && this.bpe.size() > 0;
    }

    /* renamed from: Q */
    public void mo23347Q(List<AbstractCreationToolView> list) {
        List KE = m9414KE();
        if (KE != null && KE.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i < KE.size()) {
                    ((AbstractCreationToolView) list.get(i)).mo23319a((C3843b) KE.get(i), this.bpg);
                }
            }
        }
    }

    /* renamed from: a */
    public void attachView(C3854f fVar) {
        super.attachView(fVar);
    }

    /* renamed from: bw */
    public void mo23350bw(final boolean z) {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            C1834l draftThumbnailList = iEditorService.getDraftThumbnailList(this.context);
            if (draftThumbnailList != null) {
                draftThumbnailList.mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<String>>() {
                    /* renamed from: R */
                    public void mo9886K(List<String> list) {
                        if (list != null && !list.isEmpty()) {
                            C3834a.this.bpe = list;
                            ((C3854f) C3834a.this.getMvpView()).mo23321P(list);
                        } else if (z) {
                            C3834a.this.m9416KH();
                        } else if (list != null) {
                            C3834a.this.bpe = list;
                            ((C3854f) C3834a.this.getMvpView()).mo23321P(list);
                        }
                    }

                    /* renamed from: a */
                    public void mo9877a(C1495b bVar) {
                        C3834a.this.compositeDisposable.mo9785e(bVar);
                    }

                    public void onComplete() {
                    }

                    public void onError(Throwable th) {
                    }
                });
            }
        }
    }

    public void detachView() {
        super.detachView();
    }

    public void init(Context context2) {
        this.context = context2;
        this.compositeDisposable = new C1494a();
        this.bpb = new C3846c(context2);
        C10021c.aZH().mo38494ax(this);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(StudioActionEvent studioActionEvent) {
        mo23350bw(true);
    }

    public void release() {
        C10021c.aZH().mo38496az(this);
        if (this.bpd != null && this.bpd.isShowing()) {
            this.bpd.dismiss();
        }
        if (this.bpc != null) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.bpc);
        }
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }
}
