package com.introvd.template.editor.preview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.common.title.C5866b;
import com.introvd.template.editor.common.title.EditorTitle;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8058h;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.p324m.C7563a;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.router.camera.CameraIntentInfo.Builder;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.editor.p388b.C8421a;
import com.introvd.template.sdk.editor.p388b.C8421a.C8424a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.utils.C8563r;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import java.lang.ref.WeakReference;
import org.p489b.C9963d;
import p037b.p050b.C1807g;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.storyboard.QStoryboard;

@C1942a(mo10417rZ = "/XYVideoEditor/EditorPreview")
public class EditorPreviewActivity extends EventActivity implements OnClickListener {
    /* access modifiers changed from: private */
    public C8522g bMM;
    private RelativeLayout bMj;
    /* access modifiers changed from: private */
    public C8501a bOK;
    private boolean bTs = false;
    /* access modifiers changed from: private */
    public C8421a cTL;
    /* access modifiers changed from: private */
    public boolean cTN;
    private C8434c cTW;
    /* access modifiers changed from: private */
    public C9963d cTZ;
    private TextView cWl;
    private TextView cWm;
    private OnSeekBarChangeListener cYN = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                if (EditorPreviewActivity.this.cTL != null) {
                    EditorPreviewActivity.this.cTL.mo34149b(new C8424a(i, false));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(">>>EditorPlayerView:OnSeekBarChangeListener onProgressChanged:");
                sb.append(i);
                LogUtilsV2.m14230i(sb.toString());
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (EditorPreviewActivity.this.cso != null && EditorPreviewActivity.this.cZC) {
                EditorPreviewActivity.this.cso.pause();
            }
            EditorPreviewActivity.this.cTN = true;
            if (EditorPreviewActivity.this.cTL != null) {
                EditorPreviewActivity.this.cTL.setMode(2);
                EditorPreviewActivity.this.cTL.mo34146a(EditorPreviewActivity.this.cso);
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            EditorPreviewActivity.this.cTN = false;
            if (EditorPreviewActivity.this.cTL != null) {
                EditorPreviewActivity.this.cTL.aIp();
            }
            if (EditorPreviewActivity.this.cso != null) {
                EditorPreviewActivity.this.cZx.setSelected(true);
                EditorPreviewActivity.this.cso.play();
            }
            EditorPreviewActivity.this.m18849gs(seekBar.isSelected());
        }
    };
    /* access modifiers changed from: private */
    public SurfaceHolder cYh;
    /* access modifiers changed from: private */
    public int cYl = 0;
    /* access modifiers changed from: private */
    public EditorTitle cZA;
    private View cZB;
    /* access modifiers changed from: private */
    public boolean cZC;
    /* access modifiers changed from: private */
    public C6517b cZD = new C6517b(this);
    /* access modifiers changed from: private */
    public ImageButton cZx;
    private ImageButton cZy;
    private View cZz;
    private SeekBar clA;
    /* access modifiers changed from: private */
    public int csK = 0;
    /* access modifiers changed from: private */
    public MSize csP;
    /* access modifiers changed from: private */
    public C8431d cso;
    private MSize css;
    /* access modifiers changed from: private */
    public boolean csx;
    /* access modifiers changed from: private */
    public C4576e czk;
    /* access modifiers changed from: private */
    public QStoryboard mStoryBoard;

    /* renamed from: com.introvd.template.editor.preview.EditorPreviewActivity$a */
    private class C6516a implements C8434c {
        public C6516a() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            switch (i) {
                case 2:
                    if (EditorPreviewActivity.this.cso != null) {
                        int aIx = EditorPreviewActivity.this.cso.aIx();
                        EditorPreviewActivity.this.cso.mo34191jn(true);
                        EditorPreviewActivity.this.cso.aIB();
                        EditorPreviewActivity.this.m18846eE(false);
                        EditorPreviewActivity.this.updateProgress(aIx);
                        return;
                    }
                    return;
                case 3:
                    EditorPreviewActivity.this.m18846eE(true);
                    EditorPreviewActivity.this.updateProgress(i2);
                    C4597i.m11729b(true, EditorPreviewActivity.this);
                    return;
                case 4:
                    EditorPreviewActivity.this.m18846eE(false);
                    EditorPreviewActivity.this.updateProgress(i2);
                    C4597i.m11729b(false, EditorPreviewActivity.this);
                    return;
                case 5:
                    C4597i.m11729b(false, EditorPreviewActivity.this);
                    EditorPreviewActivity.this.m18846eE(false);
                    EditorPreviewActivity.this.updateProgress(i2);
                    if (EditorPreviewActivity.this.cso != null) {
                        EditorPreviewActivity.this.cso.mo34197ug(0);
                        return;
                    }
                    return;
                case 6:
                    if (i2 == 268455950) {
                        C5842b.ahd();
                        C5842b.ahf();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.introvd.template.editor.preview.EditorPreviewActivity$b */
    public static class C6517b extends Handler {
        private WeakReference<EditorPreviewActivity> activityRef;

        C6517b(EditorPreviewActivity editorPreviewActivity) {
            this.activityRef = new WeakReference<>(editorPreviewActivity);
        }

        public void handleMessage(Message message) {
            EditorPreviewActivity editorPreviewActivity = (EditorPreviewActivity) this.activityRef.get();
            if (editorPreviewActivity != null && message.what == 12289) {
                if (!editorPreviewActivity.csx || editorPreviewActivity.csP == null) {
                    if (editorPreviewActivity.cso != null) {
                        editorPreviewActivity.cso.mo34191jn(false);
                    }
                    editorPreviewActivity.cZD.removeMessages(12289);
                    editorPreviewActivity.cZD.sendMessageDelayed(obtainMessage(12289), 50);
                } else if (editorPreviewActivity.cso == null) {
                    editorPreviewActivity.aas();
                } else if (editorPreviewActivity.cYh.getSurface().isValid() && editorPreviewActivity.csP != null) {
                    QDisplayContext c = C8571x.m25060c(editorPreviewActivity.csP.width, editorPreviewActivity.csP.height, 1, editorPreviewActivity.cYh);
                    editorPreviewActivity.cso.setDisplayContext(c);
                    editorPreviewActivity.cso.mo34166a(c, editorPreviewActivity.csK);
                    editorPreviewActivity.cso.aIB();
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.preview.EditorPreviewActivity$c */
    private class C6518c implements Callback {
        private C6518c() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            LogUtilsV2.m14230i("EditorPreviewActivity:surfaceChanged");
            EditorPreviewActivity.this.cYh = surfaceHolder;
            if (EditorPreviewActivity.this.cZD != null) {
                EditorPreviewActivity.this.cZD.removeMessages(12289);
                EditorPreviewActivity.this.cZD.sendMessageDelayed(EditorPreviewActivity.this.cZD.obtainMessage(12289), 50);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            LogUtilsV2.m14230i("EditorPreviewActivity:surfaceCreated");
            EditorPreviewActivity.this.cYh = surfaceHolder;
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LogUtilsV2.m14230i("EditorPreviewActivity:surfaceDestroyed");
        }
    }

    /* renamed from: Kl */
    private void m18830Kl() {
        this.bMj = (RelativeLayout) findViewById(R.id.preview_layout);
        this.bMj.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (EditorPreviewActivity.this.cZx.isSelected() && EditorPreviewActivity.this.cso != null) {
                    EditorPreviewActivity.this.cZx.setSelected(false);
                    EditorPreviewActivity.this.cso.pause();
                    EditorPreviewActivity.this.m18849gs(EditorPreviewActivity.this.cZx.isSelected());
                }
            }
        });
        abu();
        abt();
    }

    /* renamed from: Yt */
    private void m18831Yt() {
        int duration = this.mStoryBoard != null ? this.mStoryBoard.getDuration() : 0;
        this.clA.setMax(duration);
        this.clA.setProgress(0);
        if (this.cWl != null) {
            this.cWl.setText(C4580b.m11637V(0));
        }
        if (this.cWm != null) {
            this.cWm.setText(C4580b.m11637V((long) duration));
        }
        this.clA.setOnSeekBarChangeListener(this.cYN);
    }

    /* access modifiers changed from: private */
    public void aas() {
        C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) {
                int i = 0;
                EditorPreviewActivity.this.cZC = false;
                VeMSize veMSize = null;
                if (EditorPreviewActivity.this.cso != null) {
                    EditorPreviewActivity.this.cso.aIv();
                    EditorPreviewActivity.this.cso = null;
                }
                EditorPreviewActivity.this.cso = new C8431d();
                EditorPreviewActivity.this.cso.mo34191jn(false);
                QSessionStream o = EditorPreviewActivity.this.abB();
                if (o == null) {
                    mVar.mo9791K(Boolean.valueOf(false));
                    return;
                }
                while (true) {
                    if (EditorPreviewActivity.this.cYh != null && EditorPreviewActivity.this.cYh.getSurface() != null && EditorPreviewActivity.this.cYh.getSurface().isValid() && i >= 1) {
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
                if (EditorPreviewActivity.this.csP != null) {
                    veMSize = new VeMSize(EditorPreviewActivity.this.csP.width, EditorPreviewActivity.this.csP.height);
                }
                boolean a = EditorPreviewActivity.this.cso.mo34169a(o, EditorPreviewActivity.this.getPlayCallback(), veMSize, EditorPreviewActivity.this.cYl, EditorPreviewActivity.this.bOK.aJv(), EditorPreviewActivity.this.cYh);
                StringBuilder sb = new StringBuilder();
                sb.append(">>>EditorPreviewActivity:InitXYMediaPlayer PlayerInitTask initResult=");
                sb.append(a);
                LogUtilsV2.m14230i(sb.toString());
                mVar.mo9791K(Boolean.valueOf(true));
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                EditorPreviewActivity.this.cZC = true;
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* access modifiers changed from: private */
    public QSessionStream abB() {
        QDisplayContext c = C8571x.m25060c(C8572y.m25087dI(this.css.width, 2), C8572y.m25087dI(this.css.height, 2), 1, this.cYh);
        if (c == null) {
            return null;
        }
        return C8563r.m25045a(1, this.mStoryBoard, 0, 0, c.getScreenRect(), c.getResampleMode(), c.getRotation(), AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false) ? 4 : 2);
    }

    private void abt() {
        this.cYh = ((SurfaceView) findViewById(R.id.video_editor_preview)).getHolder();
        if (this.cYh != null) {
            this.cYh.addCallback(new C6518c());
            this.cYh.setType(2);
            this.cYh.setFormat(1);
        }
        this.cZx = (ImageButton) findViewById(R.id.seekbar_play);
        this.cZy = (ImageButton) findViewById(R.id.imgbtn_play);
        this.cWl = (TextView) findViewById(R.id.txtview_cur_time);
        this.cWm = (TextView) findViewById(R.id.txtview_duration);
        this.clA = (SeekBar) findViewById(R.id.seekbar_simple_edit);
        this.cZz = findViewById(R.id.edit_video_layout);
        this.cZA = (EditorTitle) findViewById(R.id.editor_title);
        this.cZx.setOnClickListener(this);
        this.cZz.setOnClickListener(this);
        this.cZA.setTitleListener(new C5866b() {
            public void ahD() {
                if (EditorPreviewActivity.this.cso != null) {
                    EditorPreviewActivity.this.cso.pause();
                }
                C5554b.recordPrjSave(EditorPreviewActivity.this.getApplicationContext(), "simple_preview");
                C7680l.aAf().mo32494it(true);
                C7680l.aAf().mo32496kc(EditorRouter.ENTRANCE_EDIT);
                StudioRouter.launchStudioActivity(EditorPreviewActivity.this);
                EditorPreviewActivity.this.finish();
            }

            public void ahE() {
                if (EditorPreviewActivity.this.cso != null) {
                    EditorPreviewActivity.this.cso.pause();
                }
                if (EditorPreviewActivity.this.mStoryBoard.getDuration() < 300000 || C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId())) {
                    if (C6386d.m18370a((Activity) EditorPreviewActivity.this, false, EditorPreviewActivity.this.bMM.aHe())) {
                        EditorPreviewActivity.this.finish();
                    }
                    return;
                }
                C8049f.aBf().mo33097b(EditorPreviewActivity.this, C8070o.aBw(), C7825a.DURATION_LIMIT.getId(), "export duration limit", -1);
            }

            public void onBack() {
                if (EditorPreviewActivity.this.cso != null) {
                    EditorPreviewActivity.this.cso.pause();
                }
                EditorPreviewActivity.this.aoG();
                EditorPreviewActivity.this.finish();
            }
        });
        this.cZA.mo28291lY(R.drawable.editor_icon_back);
    }

    private void abu() {
        VeMSize veMSize = new VeMSize(Constants.getScreenSize().width, Constants.getScreenSize().height);
        if (((double) Math.abs((((float) this.css.width) / ((float) this.css.height)) - 0.5625f)) < 0.02d) {
            this.css.height = (int) (((float) this.css.width) / 0.5625f);
        }
        VeMSize e = C8572y.m25090e(new VeMSize(this.css.width, this.css.height), veMSize);
        this.csP = new MSize(e.width, e.height);
        if (this.csP != null) {
            LayoutParams layoutParams = new LayoutParams(this.csP.width, this.csP.height);
            layoutParams.addRule(13);
            this.bMj.setLayoutParams(layoutParams);
            this.bMj.invalidate();
        }
        this.csx = true;
    }

    private int abw() {
        if (this.bMM == null) {
            return 1;
        }
        ProjectItem ahP = this.bMM.aHf();
        if (ahP == null) {
            return 1;
        }
        this.mStoryBoard = ahP.mStoryBoard;
        if (this.mStoryBoard == null || ahP.mClipModelCacheList == null) {
            return 1;
        }
        if (ahP.mProjectDataItem != null) {
            this.css = new MSize(ahP.mProjectDataItem.streamWidth, ahP.mProjectDataItem.streamHeight);
        }
        C8540q.m24907P(this.mStoryBoard);
        return 0;
    }

    /* access modifiers changed from: private */
    public String aij() {
        return String.valueOf(5);
    }

    private boolean aim() {
        if (this.mStoryBoard != null) {
            QEngine engine = this.mStoryBoard.getEngine();
            if (engine != null) {
                return C8572y.m25092e(engine);
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean aoG() {
        DataItemProject aHe = this.bMM.aHe();
        int i = aHe != null ? aHe.iCameraCode : 0;
        if (i == 0) {
            return false;
        }
        Builder builder = new Builder();
        builder.setNewPrj(0);
        builder.setCameraIntent(4101);
        int cameraModeParam = CameraCodeMgr.getCameraModeParam(i);
        builder.setbNewCam(!CameraCodeMgr.isCameraParamPIP(cameraModeParam));
        builder.setCaptureMode(cameraModeParam == 12 ? 1 : 0);
        C7563a.m22315a(this, builder.build(), null, false);
        return true;
    }

    private void aoH() {
        this.cZB = findViewById(R.id.btn_purchase_remove_watermark);
        final C8058h aBf = C8049f.aBf();
        if (aBf != null) {
            this.cZB.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    aBf.mo33097b(EditorPreviewActivity.this, C8070o.aBw(), C7825a.WATER_MARK.getId(), "watermark", -1);
                }
            });
        }
    }

    private void aoI() {
        aoJ();
        aoK();
    }

    private void aoJ() {
        if (C8072q.aBx().mo33072ku(C7825a.WATER_MARK.getId())) {
            this.cZB.setVisibility(8);
        } else {
            this.cZB.setVisibility(0);
        }
    }

    private void aoK() {
        if (this.mStoryBoard == null) {
            C4577f.m11629e(this.czk);
        } else if (300000 > this.mStoryBoard.getDuration()) {
            C4577f.m11629e(this.czk);
        } else {
            if (C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId())) {
                C4577f.m11629e(this.czk);
                this.cWm.setTextColor(getResources().getColor(R.color.white));
            } else if (!C4577f.m11630i(this.czk)) {
                this.cWm.setTextColor(getResources().getColor(R.color.color_FF2E0E));
                this.cZA.post(new Runnable() {
                    public void run() {
                        EditorPreviewActivity.this.czk = C4577f.m11625a((Context) EditorPreviewActivity.this, (View) EditorPreviewActivity.this.cZA, EditorPreviewActivity.this.aij(), "preview tip duration limit", -1);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: eE */
    public void m18846eE(boolean z) {
        if (this.cZx.isShown()) {
            this.cZx.setSelected(z);
        }
        if (this.cZy.isShown()) {
            this.cZy.setSelected(z);
        }
        m18849gs(this.cZx.isSelected());
    }

    /* access modifiers changed from: private */
    public C8434c getPlayCallback() {
        if (this.cTW == null) {
            this.cTW = new C6516a();
        }
        return this.cTW;
    }

    /* access modifiers changed from: private */
    /* renamed from: gs */
    public void m18849gs(boolean z) {
        if (z) {
            this.cZA.setVisibility(8);
            this.cZz.setVisibility(8);
            return;
        }
        this.cZA.setVisibility(0);
        this.cZz.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void updateProgress(int i) {
        if (!this.cTN) {
            this.clA.setProgress(i);
        }
        this.cWl.setText(C4580b.m11637V((long) i));
    }

    public void onClick(View view) {
        if (view == this.cZx || view == this.cZy) {
            if (this.cso != null) {
                if (view.isSelected()) {
                    this.cso.pause();
                } else {
                    this.cso.play();
                }
                m18849gs(view.isSelected());
            }
        } else if (view == this.cZz) {
            C5554b.m15033et(getApplicationContext());
            DataItemProject aHe = this.bMM.aHe();
            if (aHe != null) {
                C8446b.aIZ().mo34325j(getApplicationContext(), aHe._id);
            }
            String passThroughUrlFromIntent = PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent());
            EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
            editorIntentInfo.from = EditorRouter.ENTRANCE_QUICK_PREVIEW;
            EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.replaceParams(passThroughUrlFromIntent, editorIntentInfo));
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionFirebaseStarVlogs.actionEditorPreview(this);
        mo22815FX();
        setContentView(R.layout.editor_act_preview);
        this.bMM = C8522g.aJA();
        if (this.bMM == null) {
            finish();
            return;
        }
        this.bOK = C8501a.aJs();
        if (this.bOK == null) {
            finish();
        } else if (abw() != 0) {
            finish();
        } else {
            m18830Kl();
            m18831Yt();
            aoH();
            this.cTL = new C8421a();
            this.cTL.aIo().mo9817a((C1807g<? super T>) new C1807g<C8424a>() {
                /* renamed from: a */
                public void mo9888K(C8424a aVar) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onNext = ");
                    sb.append(aVar.position);
                    sb.append(",finish = ");
                    sb.append(aVar.eev);
                    LogUtilsV2.m14227d(sb.toString());
                    if (EditorPreviewActivity.this.cTZ != null) {
                        EditorPreviewActivity.this.cTZ.mo9893bV(1);
                    }
                    EditorPreviewActivity.this.cTN = !aVar.eev;
                }

                /* renamed from: a */
                public void mo9889a(C9963d dVar) {
                    EditorPreviewActivity.this.cTZ = dVar;
                    EditorPreviewActivity.this.cTZ.mo9893bV(1);
                }

                public void onComplete() {
                    LogUtilsV2.m14227d("onComplete = ");
                }

                public void onError(Throwable th) {
                    LogUtilsV2.m14227d("onError = ");
                    th.printStackTrace();
                }
            });
            C5554b.m15032es(getApplicationContext());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.cTZ != null) {
            this.cTZ.cancel();
            this.cTZ = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.cso != null) {
            this.cso.pause();
        }
        aoG();
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        C4577f.m11629e(this.czk);
        if (this.cso != null) {
            this.cso.pause();
            this.csK = this.cso.aIx();
            this.cso.aIt();
            if (aim() || isFinishing()) {
                this.cso.aIv();
                this.cso = null;
            }
        }
        this.bTs = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        aoI();
        if (this.bTs && this.cZD != null) {
            this.cZD.removeMessages(12289);
            this.cZD.sendMessageDelayed(this.cZD.obtainMessage(12289), 50);
        }
        this.bTs = false;
    }
}
