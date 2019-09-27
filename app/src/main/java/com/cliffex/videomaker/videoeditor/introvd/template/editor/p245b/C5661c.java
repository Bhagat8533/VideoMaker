package com.introvd.template.editor.p245b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.common.title.C5866b;
import com.introvd.template.editor.common.title.EditorTitle;
import com.introvd.template.editor.common.view.EditLessonFragment;
import com.introvd.template.editor.common.view.EditLessonFragment.C5871a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6293a.C6297b;
import com.introvd.template.editor.preview.fragment.p275b.C6651b;
import com.introvd.template.editor.preview.p271b.C6551b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1513a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p037b.p050b.p077k.C1830a;
import p037b.p050b.p077k.C1833c;

/* renamed from: com.introvd.template.editor.b.c */
public class C5661c extends BaseController<C5674e> {
    private C1494a cBh;
    /* access modifiers changed from: private */
    public EditorTitle cFS;
    private EditLessonFragment cFT;
    private C4576e cFU;
    private C4576e cFV;
    /* access modifiers changed from: private */
    public C6651b cFW;
    private C1890f cFX;
    private C6297b cFY;
    private C1833c<Integer> cFZ = C1830a.aVl().aVm();
    private C1495b cGa = aih();
    /* access modifiers changed from: private */
    public long cGb = -1;
    private C5871a cGc = new C5871a() {
        public void ahM() {
            if (C5661c.this.getMvpView() != null) {
                ((C5674e) C5661c.this.getMvpView()).abl();
            }
        }

        /* renamed from: d */
        public void mo27752d(TODOParamModel tODOParamModel) {
            Context b = C5661c.this.context;
            StringBuilder sb = new StringBuilder();
            sb.append(tODOParamModel.mTODOCode);
            sb.append("");
            C5554b.m15026aG(b, sb.toString());
            if (C5661c.this.getMvpView() != null) {
                ((C5674e) C5661c.this.getMvpView()).mo27337d(tODOParamModel);
            }
        }
    };
    /* access modifiers changed from: private */
    public Context context;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15618a(C5654a aVar) {
        if (aVar == null) {
            aig();
        } else if (this.cFS == null || !this.cFS.ahA()) {
            aig();
        } else if (getMvpView() == null) {
            aig();
        } else if (aii()) {
            aig();
        } else {
            if (!aVar.ahN()) {
                C4577f.m11629e(this.cFU);
            } else if (!C4577f.m11630i(this.cFU)) {
                this.cFU = C4577f.m11625a((Context) ((C5674e) getMvpView()).getActivity(), (View) this.cFS, aij(), "preview tip duration limit", -1);
            }
            if (aVar.ahN() || !aVar.ahO()) {
                C4577f.m11629e(this.cFV);
            } else if (!C4577f.m11630i(this.cFV)) {
                this.cFV = C4577f.m11624a((Context) ((C5674e) getMvpView()).getActivity(), (View) this.cFS, "effects", 44, -1);
            }
        }
    }

    private C1495b aih() {
        return this.cFZ.mo10157d(C1820a.aVi()).mo10172i(1500, TimeUnit.MILLISECONDS).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Integer, C5654a>() {
            /* renamed from: h */
            public C5654a apply(Integer num) throws Exception {
                return new C5654a(C5661c.this.cGb, (long) num.intValue());
            }
        }).mo10152c(C1487a.aUa()).mo10160e((C1513a) new C1513a() {
            public void run() throws Exception {
                C5661c.this.aig();
            }
        }).mo10128a((C1517e<? super T>) new C1517e<C5654a>() {
            /* renamed from: b */
            public void accept(C5654a aVar) throws Exception {
                C5661c.this.m15618a(aVar);
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C5661c.this.aig();
            }
        });
    }

    private boolean aii() {
        FragmentActivity activity = ((C5674e) getMvpView()).getActivity();
        if (activity == null) {
            return false;
        }
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        if (supportFragmentManager == null) {
            return false;
        }
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag("fragment_tag_bgm");
        if (findFragmentByTag != null && !findFragmentByTag.isRemoving()) {
            return findFragmentByTag.isVisible();
        }
        return false;
    }

    private String aij() {
        return String.valueOf(5);
    }

    /* renamed from: fb */
    private void m15623fb(boolean z) {
        if (this.cFS != null) {
            this.cFS.mo28287eZ(z);
        }
    }

    /* renamed from: fc */
    private void m15624fc(boolean z) {
        if (this.cFS != null) {
            this.cFS.mo28286eY(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: md */
    public String m15625md(int i) {
        switch (i) {
            case -1:
                return "unknown";
            case 0:
                return "theme";
            case 1:
                return EditorRouter.ENTRANCE_EDIT;
            case 2:
                return "effects";
            case 3:
                return "music";
            default:
                return "unknown";
        }
    }

    /* renamed from: a */
    public void attachView(C5674e eVar) {
        super.attachView(eVar);
        if (this.cGa != null && !this.cGa.aAy()) {
            this.cGa.dispose();
        }
        this.cGa = aih();
    }

    public void aic() {
        this.cFW.hide();
        if (this.cFS != null) {
            this.cFS.hide();
        }
    }

    public void aid() {
        if (this.cFS != null) {
            this.cFS.show();
        }
    }

    public void aie() {
        if (!((C5674e) getMvpView()).getActivity().isFinishing()) {
            try {
                if (this.cFX == null) {
                    boolean agL = C5837a.agH().agL();
                    this.cFX = new C1895a(((C5674e) getMvpView()).getActivity()).mo10315r(this.context.getString(agL ? R.string.xiaoying_str_editor_exit_editor_msg : R.string.xiaoying_str_query_exit_edit)).mo10316s(this.context.getString(agL ? R.string.xiaoying_str_com_save_title : R.string.xiaoying_str_save_and_exit)).mo10300ds(this.context.getResources().getColor(R.color.color_ff5e13)).mo10288aA(true).mo10277a(Typeface.defaultFromStyle(1), (Typeface) null).mo10281a((C1904j) new C1904j() {
                        public void onClick(C1890f fVar, C1885b bVar) {
                            fVar.dismiss();
                            ((C5674e) C5661c.this.getMvpView()).mo27758er(true);
                        }
                    }).mo10317t(this.context.getString(agL ? R.string.xiaoying_str_editor_without_draft_title : R.string.xiaoying_str_com_cancel)).mo10302du(this.context.getResources().getColor(R.color.black)).mo10291b(new C1904j() {
                        public void onClick(C1890f fVar, C1885b bVar) {
                            fVar.dismiss();
                        }
                    }).mo10275a((OnCancelListener) new OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                            if (C5661c.this.getMvpView() != null) {
                                ((C5674e) C5661c.this.getMvpView()).mo27758er(false);
                            }
                        }
                    }).mo10313qu();
                }
                if (!this.cFX.isShowing()) {
                    this.cFX.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void aif() {
        this.cFW.hide();
    }

    public void aig() {
        C4577f.m11629e(this.cFU);
        C4577f.m11629e(this.cFV);
    }

    public void aik() {
        if (this.cFT != null) {
            this.cFT.mo28304a((C5871a) null);
            this.cFT = null;
        }
    }

    public void detachView() {
        super.detachView();
        if (this.cGa != null && !this.cGa.aAy()) {
            this.cGa.dispose();
        }
        C10021c.aZH().mo38496az(this);
        if (this.cBh != null) {
            this.cBh.clear();
        }
        if (this.cFY != null) {
            C6293a.anj().mo29245b(this.cFY);
        }
        if (this.cFU != null) {
            C4577f.m11629e(this.cFU);
            this.cFU = null;
        }
        if (this.cFX != null && this.cFX.isShowing()) {
            this.cFX.dismiss();
        }
    }

    /* renamed from: es */
    public void mo27732es(boolean z) {
        m15623fb(!z);
        m15624fc(!z);
    }

    /* renamed from: gW */
    public void mo27733gW(String str) {
        if (getMvpView() != null) {
            this.cFW.hide();
            ((C5674e) getMvpView()).abj();
            boolean z = true;
            UtilsPrefs with = UtilsPrefs.with(this.context, EditorRouter.VIVA_EDITOR_PREF_FILENAME, true);
            if (!with.readBoolean(EditorRouter.KEY_HAS_SHOWED_EDIT_LESSON_ANIMATION, false)) {
                with.writeBoolean(EditorRouter.KEY_HAS_SHOWED_EDIT_LESSON_ANIMATION, true);
            }
            if (!(this.cFT == null || str == null || !str.equals(this.cFT.getUrl()))) {
                z = false;
            }
            if (z) {
                this.cFT = (EditLessonFragment) C1919a.m5529sc().mo10355al(EditorRouter.EDITOR_EDIT_LESSON_URL).mo10399f(EditorRouter.KEY_EDIT_LESSON_URL, str).mo10412rX();
                this.cFT.mo28304a(this.cGc);
                ((C5674e) getMvpView()).getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).add(R.id.fragment_container, (Fragment) this.cFT).commitAllowingStateLoss();
            } else {
                ((C5674e) getMvpView()).getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).show(this.cFT).commitAllowingStateLoss();
            }
        }
    }

    public void init(Context context2) {
        this.context = context2;
        C10021c.aZH().mo38494ax(this);
        this.cBh = new C1494a();
        this.cFW = new C6651b(((C5674e) getMvpView()).getActivity());
        if (((C5674e) getMvpView()).abi()) {
            C6293a anj = C6293a.anj();
            C56621 r0 = new C6297b() {
                /* renamed from: r */
                public void mo27739r(boolean z, boolean z2) {
                    if (C5661c.this.cFS != null) {
                        C5661c.this.cFS.mo28284eW(z);
                        C5661c.this.cFS.mo28285eX(z2);
                        if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_key_editor_undo_help_show_flag", false) && C5661c.this.cFS.ahA()) {
                            C5661c.this.cFW.mo30034b(C5661c.this.cFS.getUndoView(), 8, C5661c.this.context.getString(R.string.xiaoying_str_editor_undo_tip_title), C4580b.m11666qi(), C4583d.m11673ii(10), -C4583d.m11673ii(10));
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_key_editor_undo_help_show_flag", true);
                        }
                    }
                }
            };
            this.cFY = r0;
            anj.mo29235a((C6297b) r0);
        }
    }

    /* renamed from: mb */
    public void mo27735mb(int i) {
        if (this.cFS == null) {
            this.cFS = new EditorTitle(((C5674e) getMvpView()).getActivity());
            if (i == 0 && C3742b.m9111II().mo23171Jr()) {
                if (!UtilsPrefs.with(this.context, EditorRouter.VIVA_EDITOR_PREF_FILENAME, true).readBoolean(EditorRouter.KEY_HAS_SHOWED_EDIT_LESSON_ANIMATION, false)) {
                    this.cFS.ahC();
                }
                this.cFS.ahB();
            }
            if (!AppStateModel.getInstance().isCommunitySupport() && C3742b.m9111II().mo23168Jo()) {
                this.cFS.mo28292lZ(R.string.xiaoying_str_studio_export_and_upload);
            }
            this.cFS.setTitleListener(new C5866b() {
                public void ahD() {
                    if (C5661c.this.getMvpView() != null) {
                        ((C5674e) C5661c.this.getMvpView()).mo27338kq(1);
                    }
                }

                public void ahE() {
                    if (C5661c.this.getMvpView() != null) {
                        ((C5674e) C5661c.this.getMvpView()).mo27338kq(2);
                    }
                }

                public void ahF() {
                    C5554b.m15025aF(C5661c.this.context, C5661c.this.m15625md(C5843c.agO().getTabMode()));
                    C5661c.this.mo27733gW("");
                }

                public void ahG() {
                    if (C5661c.this.getMvpView() != null && ((C5674e) C5661c.this.getMvpView()).aef()) {
                        C5661c.this.cFW.hide();
                        C6293a.anj().mo29247fZ(true);
                        if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_key_editor_redo_help_show_flag", false) && C5661c.this.cFS.ahA()) {
                            C5661c.this.cFW.mo30034b(C5661c.this.cFS.getRedoView(), 8, C5661c.this.context.getString(R.string.xiaoying_str_editor_redo_tip_title), C4580b.m11666qi(), C4583d.m11673ii(10), -C4583d.m11673ii(10));
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_key_editor_redo_help_show_flag", true);
                        }
                    }
                }

                public void ahH() {
                    if (C5661c.this.getMvpView() != null && ((C5674e) C5661c.this.getMvpView()).aef()) {
                        C5661c.this.cFW.hide();
                        C6293a.anj().mo29248ga(true);
                    }
                }

                public void onBack() {
                    if (C5661c.this.getMvpView() != null) {
                        ((C5674e) C5661c.this.getMvpView()).mo27338kq(0);
                    }
                }
            });
        }
        if (i == 1 || i == 2) {
            this.cFS.mo28287eZ(false);
        }
        this.cFS.mo28283eV(((C5674e) getMvpView()).abi());
        this.cFS.mo28284eW(C6293a.anj().ano());
        this.cFS.mo28285eX(C6293a.anj().anp());
        this.cBh.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                ((C5674e) C5661c.this.getMvpView()).getRootView().addView(C5661c.this.cFS, new LayoutParams(-1, -2));
                if (!((C5674e) C5661c.this.getMvpView()).aeg()) {
                    C5661c.this.aid();
                }
            }
        }, 300, TimeUnit.MILLISECONDS));
    }

    /* renamed from: mc */
    public void mo27736mc(int i) {
        this.cFZ.mo9886K(Integer.valueOf(i));
    }

    public boolean onBackPressed() {
        if (this.cFT == null || this.cFT.isHidden()) {
            return false;
        }
        ((C5674e) getMvpView()).getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).hide(this.cFT).commitAllowingStateLoss();
        ((C5674e) getMvpView()).abl();
        return true;
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6551b bVar) {
        if (bVar != null) {
            this.cGb = bVar.apj();
        }
    }
}
