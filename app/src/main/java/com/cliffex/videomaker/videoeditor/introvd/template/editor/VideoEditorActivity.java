package com.introvd.template.editor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.bumptech.glide.C2176e;
import com.introvd.base.utlisads.BannerAdmob;
import com.introvd.base.utlisads.CrashAll;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.advance.AdvanceEditorGif;
import com.introvd.template.editor.base.BaseEditorActivity;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.common.p249c.C5844a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p245b.C5655b;
import com.introvd.template.editor.p266h.C6375c;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.preview.C6521a;
import com.introvd.template.editor.preview.C6549b;
import com.introvd.template.editor.preview.PreviewOpsView;
import com.introvd.template.editor.preview.p271b.C6552c;
import com.introvd.template.editor.preview.p271b.C6553d;
import com.introvd.template.editor.todo.EditorTodoInterceptorImpl;
import com.introvd.template.editor.widget.scalerotate.p295a.C7066b;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.p173a.p174a.C3574d;
import com.introvd.template.router.FuncExportRouter;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;

@C1942a(mo10417rZ = "/XYVideoEditor/VideoEditor")
public class VideoEditorActivity extends BaseEditorActivity {
    private volatile boolean crZ = false;
    private TODOParamModel todoParamModel;

    private void abm() {
        C5839a.m16334q(getApplicationContext(), "share_btn", this.cyn.from);
        if (this.cyl.aia().getDuration() >= 300000 && !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId())) {
            C8049f.aBf().mo33097b(this, C8070o.aBw(), C7825a.DURATION_LIMIT.getId(), "export duration limit", -1);
        } else if (!abk() || this.todoParamModel == null || this.todoParamModel.isNormalShare()) {
            boolean z = true;
            if (this.cyt == 1) {
                Intent intent = new Intent(this, AdvanceEditorGif.class);
                intent.putExtra("bundle_key_prjdata", C8522g.aJA().aHe());
                if (this.todoParamModel != null) {
                    intent.putExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL, this.todoParamModel);
                }
                startActivity(intent);
            } else {
                z = C6386d.m18370a((Activity) this, false, this.cyl.adK().aHe());
            }
            if (z) {
                this.cyl.ahU();
                C2176e.m6133ai(getApplicationContext()).clearMemory();
                C7066b.auS().clearMemory();
                finish();
            }
        } else {
            FuncExportRouter.launchFuncExportActivity(this, this.todoParamModel);
            finish();
        }
    }

    private void abn() {
        C5839a.m16334q(getApplicationContext(), "save_draft", this.cyn.from);
        C5554b.recordPrjSave(getApplicationContext(), "advanced_preview");
        C5554b.recordPrjSave(getApplicationContext(), "advanced_preview");
        C7680l.aAf().mo32494it(true);
        C7680l.aAf().mo32496kc(EditorRouter.ENTRANCE_EDIT);
        StudioRouter.launchStudioActivity(this);
        finish();
    }

    private void abo() {
        if (this.cyi != null && !this.cyi.onBackPressed() && (this.cyi instanceof PreviewOpsView)) {
            this.cym.aie();
        }
    }

    /* renamed from: dN */
    private void m14985dN(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("bundle_is_only_edit_theme_title", z);
        this.cyx.mo27786f(3001, bundle);
    }

    /* access modifiers changed from: private */
    public void setFocusTab(int i) {
        if (this.cyi != null) {
            this.cyi.setFocusTab(i);
        }
    }

    public boolean abi() {
        return C5837a.agH().abi();
    }

    public void abj() {
        super.abj();
        if (this.cyi instanceof PreviewOpsView) {
            ((PreviewOpsView) this.cyi).aoO();
            C10021c.aZH().mo38492aA(new C6553d());
        }
    }

    public boolean abk() {
        return this.todoParamModel != null && this.todoParamModel.getActivityFlag() > 0;
    }

    public void abl() {
        this.cym.mo27736mc(this.cyl.aia().getDuration());
        if (C5843c.agO().getTabMode() == 0) {
            C10021c.aZH().mo38492aA(new C6552c());
        }
    }

    /* renamed from: d */
    public void mo27337d(TODOParamModel tODOParamModel) {
        String str = EditorTodoInterceptorImpl.todoCode2URL(this, tODOParamModel);
        final EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromIntent(str, EditorIntentInfo.class);
        if (editorIntentInfo != null) {
            this.cyn = editorIntentInfo;
            final Bundle bundle = new Bundle();
            bundle.putString(PassThoughUrlGenerator.EXTRA_PASS_THROUGH_URL, str);
            runOnUiThread(new Runnable() {
                public void run() {
                    int clipCount = VideoEditorActivity.this.cyl.aia().getClipCount();
                    if (clipCount > 0) {
                        VideoEditorActivity.this.setFocusTab(editorIntentInfo.tabType);
                        int i = editorIntentInfo.secondaryMode;
                        if (clipCount == 1 && i == 1012) {
                            C6549b.m18997Z(VideoEditorActivity.this.getApplicationContext(), i);
                            return;
                        }
                        int agQ = C5843c.agO().agQ();
                        C5655b c = VideoEditorActivity.this.cyl;
                        if (VideoEditorActivity.this.cyl.adU()) {
                            agQ++;
                        }
                        if (c.mo27721ma(agQ)) {
                            if (i == 1004 || i == 1005 || i == 1010 || i == 1007) {
                                C6549b.m18997Z(VideoEditorActivity.this.getApplicationContext(), i);
                                return;
                            }
                        } else if (i == 1017) {
                            C6549b.m18997Z(VideoEditorActivity.this.getApplicationContext(), i);
                            return;
                        }
                        if (editorIntentInfo.secondaryMode == 1010) {
                            VideoEditorActivity.this.cyi.mo29752oq(1010);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        int agQ2 = C5843c.agO().agQ();
                        if (VideoEditorActivity.this.cyl.adU()) {
                            agQ2++;
                        }
                        arrayList.add(Integer.valueOf(agQ2));
                        if (i == 1011 && clipCount - 1 == agQ2) {
                            C6549b.m18997Z(VideoEditorActivity.this.getApplicationContext(), i);
                        } else if (!EditorModes.isEffectMode(i) || VideoEditorActivity.this.cyk == null || VideoEditorActivity.this.cyl.aia().getDuration() - C5852d.agW().agY() > 500) {
                            bundle.putIntegerArrayList("ve_extra_clip_index_list", arrayList);
                            bundle.putBoolean("ve_extra_clip_applyall_enable", VideoEditorActivity.this.cyi.mo29753or(editorIntentInfo.secondaryMode));
                            VideoEditorActivity.this.mo27775e(editorIntentInfo.secondaryMode, bundle);
                        } else {
                            ToastUtils.show((Context) VideoEditorActivity.this.getActivity(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: kq */
    public void mo27338kq(int i) {
        super.mo27338kq(i);
        switch (i) {
            case 0:
                abo();
                return;
            case 1:
                abn();
                return;
            case 2:
                abm();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: kr */
    public void mo27339kr(int i) {
        super.mo27339kr(i);
        boolean z = true;
        if (i == 1 && this.todoParamModel != null && !this.crZ) {
            this.crZ = true;
            if (abk() && this.todoParamModel.getTitleEditFlag() > 0) {
                if (this.todoParamModel.getTitleEditFlag() != 2) {
                    z = false;
                }
                m14985dN(z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionFirebaseStarVlogs.actionVideoEditorActivity(this);
        CrashAll.loadAndshow(this, "las_activity_editor");
        C6375c.asF().mo29428fL(this);
        this.todoParamModel = (TODOParamModel) PassThoughUrlGenerator.getInfoFromIntent(getIntent(), TODOParamModel.class);
        setContentView(R.layout.editor_act_main);
        this.cyh = (RelativeLayout) findViewById(R.id.editor_content_layout);
        int i = this.cyn.tabType;
        C5843c.agO().setTabMode(i);
        C6521a.m18903bB(getApplicationContext(), EditorModes.getEditorTabName(i));
        C7593c.m22383b(EditorRouter.ENTRANCE_EDIT, C7594d.dMA, new String[0]);
        if (!C8048e.aBe().isInChina() && C7680l.aAf().azZ()) {
            C7680l.aAe().mo32526aj(this, 17);
        }
        List gR = C5843c.agO().mo28232gR(C8399c.ecX);
        if (gR != null) {
            C5844a.m16354W(getApplicationContext(), gR.size());
        }
        C8049f.aBf().mo33095aG(this);
        BannerAdmob.setupDataBannerAdmob(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C3574d.m8800ey("Editor");
        C8035c.release();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            C7680l.aAe().mo32531h(19, null);
            if (this.cym != null) {
                this.cym.aik();
            }
            if (C8530i.eic != 0) {
                C8530i.aJM();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C3574d.m8799e("Editor", this.bfB);
        this.bfB = 0;
    }
}
