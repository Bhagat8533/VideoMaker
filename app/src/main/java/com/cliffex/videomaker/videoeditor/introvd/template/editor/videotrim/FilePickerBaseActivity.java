package com.introvd.template.editor.videotrim;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.introvd.template.EventActivity;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p244a.C5553a;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.videotrim.p288b.C6962c;
import com.introvd.template.editor.videotrim.p288b.C6963d;
import com.introvd.template.editor.videotrim.p292ui.C7017c;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8567u;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import java.util.ArrayList;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

public class FilePickerBaseActivity extends EventActivity {
    protected boolean bMn = false;
    protected long bMw;
    protected C8501a bOK = null;
    protected C8381b cPm;
    protected C6963d cSU = null;
    protected String csh = "";
    protected int csj;
    protected C5530d csp;
    protected int ctm = 0;
    protected ArrayList<TrimedClipItemDataModel> cuo = null;
    protected boolean dlr = false;
    protected volatile boolean dls = false;
    protected ArrayList<TrimedClipItemDataModel> dlt = new ArrayList<>();
    protected C7017c dlu = null;
    /* access modifiers changed from: private */
    public C1495b dlv;
    protected boolean dlw;
    OnDismissListener dlx = new OnDismissListener() {
        public void onDismiss(DialogInterface dialogInterface) {
            if (FilePickerBaseActivity.this.cSU != null) {
                FilePickerBaseActivity.this.cSU.alW();
            }
        }
    };

    /* renamed from: e */
    private void m20196e(final C8522g gVar) {
        C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                boolean z = false;
                if (gVar != null) {
                    FilePickerBaseActivity.this.dls = true;
                    gVar.mo34756b(FilePickerBaseActivity.this.getApplicationContext(), null, FilePickerBaseActivity.this.csp.cnX == 2, C5553a.bix, C5553a.cyL);
                    z = true;
                }
                mVar.mo9791K(Boolean.valueOf(z));
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                FilePickerBaseActivity.this.dlv = bVar;
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                FilePickerBaseActivity.this.dls = false;
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: t */
    private String m20197t(Intent intent) {
        String stringExtra = intent.getStringExtra(GalleryRouter.INTENT_PATH_KEY);
        StringBuilder sb = new StringBuilder();
        sb.append("path:");
        sb.append(stringExtra);
        LogUtils.m14223i("FilePickerBaseActivity", sb.toString());
        return stringExtra;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30585a(Activity activity, C6962c cVar, ArrayList<TrimedClipItemDataModel> arrayList, C8501a aVar) {
        if (!C6386d.asR()) {
            ToastUtils.show((Context) activity, activity.getResources().getString(R.string.xiaoying_str_com_msg_low_diskspace_warning), 0);
            return false;
        } else if (this.cPm == null || this.cPm.aHe() == null) {
            return true;
        } else {
            this.cSU = new C6963d(activity, arrayList, aVar.aJv(), this.cPm.aHe().strPrjURL);
            this.cSU.mo30626a(cVar);
            return this.cSU.auu();
        }
    }

    /* access modifiers changed from: protected */
    public boolean atm() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void atn() {
        if (this.dlu != null) {
            this.dlu.dismiss();
        }
    }

    public boolean ato() {
        return this.dlu != null && this.dlu.isShowing();
    }

    /* access modifiers changed from: protected */
    /* renamed from: au */
    public void mo30589au(Activity activity) {
        if (!activity.isFinishing()) {
            this.dlu = new C7017c(activity);
            this.dlu.mo30933pN(R.string.xiaoying_str_ve_video_import_progressing);
            this.dlu.setOnDismissListener(this.dlx);
            this.dlu.show();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        String stringExtra = getIntent().getStringExtra(MediaGalleryRouter.INTENT_IN_VEPICKMODE);
        C8567u.setContext(getApplicationContext());
        C8553i.setContext(getApplicationContext());
        this.dlr = "com.introvd.template.intent.action.EDITORFILEPICKER".equals(stringExtra);
        this.bMw = getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
        this.cPm = this.dlw ? C8468c.aIQ() : C8522g.aJA();
        boolean z = true;
        if (getIntent().getIntExtra("new_prj", 1) != 1) {
            z = false;
        }
        this.bMn = z;
        this.bOK = C8501a.aJs();
        this.csh = m20197t(getIntent());
        if (!atm()) {
            ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file, 0);
            setResult(0);
            finish();
            return;
        }
        this.cuo = getIntent().getParcelableArrayListExtra(MediaGalleryRouter.INTENT_TRIM_RANGE_LIST_KEY);
        if (this.cuo == null) {
            this.cuo = new ArrayList<>();
        }
        C5530d dVar = (C5530d) MagicCode.getMagicParam(this.bMw, "AppRunningMode", new C5530d());
        this.csj = dVar.cnU;
        this.csp = dVar;
        if (!C5530d.m14977kn(this.csj) && (this.cPm instanceof C8522g) && this.cPm.aHd() == null && this.cPm.ebQ <= 0) {
            m20196e((C8522g) this.cPm);
        }
        this.ctm = Integer.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.dlv != null) {
            this.dlv.dispose();
            this.dlv = null;
        }
    }
}
