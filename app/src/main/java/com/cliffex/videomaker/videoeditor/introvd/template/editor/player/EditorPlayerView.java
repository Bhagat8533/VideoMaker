package com.introvd.template.editor.player;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.effects.WatermarkFakerView;
import com.introvd.template.editor.effects.customwatermark.C6090c;
import com.introvd.template.editor.effects.customwatermark.C6091d;
import com.introvd.template.editor.effects.customwatermark.C6092e;
import com.introvd.template.editor.effects.customwatermark.C6094f;
import com.introvd.template.editor.effects.customwatermark.C6096h;
import com.introvd.template.editor.effects.customwatermark.CustomWaterMarkView.C6087a;
import com.introvd.template.editor.p245b.C5655b;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p246c.C5689c;
import com.introvd.template.editor.player.p267a.p268a.C6484a;
import com.introvd.template.editor.player.p269b.C6501c;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.sdk.editor.p388b.C8421a;
import com.introvd.template.sdk.editor.p388b.C8421a.C8424a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8563r;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import org.p489b.C9963d;
import p037b.p050b.C1807g;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;

public class EditorPlayerView extends BaseEditorPlayerView implements OnClickListener, C6482a {
    private static final MSize cYO = new MSize((int) QUtils.VIDEO_RES_1080P_HEIGHT, (int) QUtils.VIDEO_RES_1080P_HEIGHT);
    /* access modifiers changed from: private */
    public static int retryCount;
    private boolean bTs = false;
    private SeekBar cAF;
    public C1494a cBh;
    /* access modifiers changed from: private */
    public boolean cTN = false;
    private C8434c cTW;
    /* access modifiers changed from: private */
    public C9963d cTZ;
    private RelativeLayout cWk;
    private TextView cWl;
    private TextView cWm;
    private ImageButton cYA;
    private View cYB;
    private WatermarkFakerView cYC;
    /* access modifiers changed from: private */
    public C6481c cYD = new C6481c(this);
    /* access modifiers changed from: private */
    public C8421a cYE;
    /* access modifiers changed from: private */
    public long cYF = -1;
    private QClip cYG;
    private QStoryboard cYH;
    private QStoryboard cYI;
    /* access modifiers changed from: private */
    public C6498b cYJ;
    private boolean cYK;
    private C1495b cYL;
    /* access modifiers changed from: private */
    public C1838m<Integer> cYM;
    private OnSeekBarChangeListener cYN = new OnSeekBarChangeListener() {
        private VeRange cYR = null;

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(">>>OnSeekBarChangeListener onProgressChanged:");
            sb.append(i);
            LogUtils.m14222e("EditorPlayerView", sb.toString());
            if (z && EditorPlayerView.this.cYE != null) {
                if (this.cYR != null) {
                    i += this.cYR.getmPosition();
                }
                EditorPlayerView.this.cYE.mo34149b(new C8424a(i, false));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            LogUtils.m14222e("EditorPlayerView", ">>>OnSeekBarChangeListener onStartTrackingTouch");
            if (EditorPlayerView.this.cso != null && EditorPlayerView.this.cso.isPlaying()) {
                EditorPlayerView.this.cYp = true;
            }
            EditorPlayerView.this.pause();
            EditorPlayerView.this.cTN = true;
            if (EditorPlayerView.this.cso != null) {
                this.cYR = EditorPlayerView.this.cso.aIC();
                if (EditorPlayerView.this.cYE != null) {
                    EditorPlayerView.this.cYE.setMode(2);
                    EditorPlayerView.this.cYE.mo34146a(EditorPlayerView.this.cso);
                }
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            LogUtils.m14222e("EditorPlayerView", ">>>OnSeekBarChangeListener onStopTrackingTouch");
            if (EditorPlayerView.this.cYE != null) {
                EditorPlayerView.this.cYE.aIp();
            }
        }
    };
    private int csD = 2;
    private boolean csx;
    private RelativeLayout ctD;
    private ImageButton cti;

    /* renamed from: com.introvd.template.editor.player.EditorPlayerView$a */
    private class C6479a implements C8434c {
        public C6479a() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            Activity activity = (Activity) EditorPlayerView.this.cYe.get();
            if (activity != null && !activity.isFinishing()) {
                switch (i) {
                    case 2:
                        EditorPlayerView.this.cYF = -1;
                        EditorPlayerView.this.cYm = true;
                        StringBuilder sb = new StringBuilder();
                        sb.append(">>>MSG_PLAYER_READY ");
                        sb.append(EditorPlayerView.this.cYk);
                        LogUtils.m14223i("EditorPlayerView", sb.toString());
                        if (EditorPlayerView.this.cso != null) {
                            int aIx = EditorPlayerView.this.cso.aIx();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(">>>MSG_PLAYER_READY progress=");
                            sb2.append(aIx);
                            LogUtils.m14223i("EditorPlayerView", sb2.toString());
                            EditorPlayerView.this.cso.mo34191jn(true);
                            EditorPlayerView.this.cso.aIB();
                            if (EditorPlayerView.this.cYv != null) {
                                EditorPlayerView.this.cYv.mo27793J(aIx, EditorPlayerView.this.cTN);
                            }
                            EditorPlayerView.this.m18726gn(false);
                            EditorPlayerView.this.mo29698og(aIx);
                            EditorPlayerView.this.m18704E(aIx, true);
                            if (EditorPlayerView.this.cYn) {
                                EditorPlayerView.this.cYn = false;
                                EditorPlayerView.this.aoh();
                                break;
                            }
                        }
                        break;
                    case 3:
                        EditorPlayerView.this.cYF = -1;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(">>>MSG_PLAYER_RUNNING progress=");
                        sb3.append(i2);
                        LogUtils.m14223i("EditorPlayerView", sb3.toString());
                        C4597i.m11729b(true, activity);
                        if (EditorPlayerView.this.cYv != null) {
                            EditorPlayerView.this.cYv.mo27794K(i2, EditorPlayerView.this.cTN);
                        }
                        EditorPlayerView.this.m18726gn(true);
                        EditorPlayerView.this.m18704E(i2, false);
                        break;
                    case 4:
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(">>>MSG_PLAYER_PAUSED progress=");
                        sb4.append(i2);
                        LogUtils.m14223i("EditorPlayerView", sb4.toString());
                        C4597i.m11729b(false, activity);
                        boolean z = EditorPlayerView.this.cYF == ((long) i2);
                        if (z) {
                            EditorPlayerView.this.cYF = -1;
                        }
                        boolean z2 = EditorPlayerView.this.cTN || z;
                        if (EditorPlayerView.this.cYv != null) {
                            EditorPlayerView.this.cYv.mo27795L(i2, z2);
                        }
                        EditorPlayerView.this.m18726gn(false);
                        EditorPlayerView.this.m18704E(i2, true);
                        break;
                    case 5:
                        LogUtils.m14223i("EditorPlayerView", ">>>MSG_PLAYER_STOPPED ");
                        C4597i.m11729b(false, activity);
                        EditorPlayerView.this.m18726gn(false);
                        EditorPlayerView.this.m18704E(i2, true);
                        if (EditorPlayerView.this.cYt) {
                            EditorPlayerView.this.m18731oi(0);
                        }
                        if (EditorPlayerView.this.cYv != null) {
                            EditorPlayerView.this.cYv.mo27796M(i2, EditorPlayerView.this.cTN);
                            break;
                        }
                        break;
                    case 6:
                        if (i2 == 268455950) {
                            C5842b.ahd();
                            C5842b.ahf();
                            break;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.player.EditorPlayerView$b */
    private class C6480b implements Callback {
        private C6480b() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Surface --> surfaceChanged,isDisplayAnimating:");
            sb.append(EditorPlayerView.this.cYy);
            LogUtils.m14222e("EditorPlayerView", sb.toString());
            EditorPlayerView.this.cYh = surfaceHolder;
            if (!EditorPlayerView.this.cYy && EditorPlayerView.this.cYD != null) {
                EditorPlayerView.this.cYD.removeMessages(24578);
                EditorPlayerView.this.cYD.sendMessageDelayed(EditorPlayerView.this.cYD.obtainMessage(24578), 40);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            LogUtils.m14222e("EditorPlayerView", "Surface --> surfaceCreated");
            EditorPlayerView.this.cYh = surfaceHolder;
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LogUtils.m14222e("EditorPlayerView", "Surface --> surfaceDestroyed");
        }
    }

    /* renamed from: com.introvd.template.editor.player.EditorPlayerView$c */
    public static class C6481c extends Handler {
        private WeakReference<EditorPlayerView> cYS;

        C6481c(EditorPlayerView editorPlayerView) {
            this.cYS = new WeakReference<>(editorPlayerView);
        }

        public void handleMessage(Message message) {
            EditorPlayerView editorPlayerView = (EditorPlayerView) this.cYS.get();
            if (editorPlayerView != null) {
                switch (message.what) {
                    case 24576:
                        removeMessages(24576);
                        if (editorPlayerView.cso == null || !editorPlayerView.aog()) {
                            if (EditorPlayerView.retryCount < 10) {
                                EditorPlayerView.aou();
                                sendEmptyMessageDelayed(24576, 40);
                                break;
                            }
                        } else {
                            EditorPlayerView.retryCount = 0;
                            editorPlayerView.cso.play();
                            break;
                        }
                        break;
                    case 24578:
                        editorPlayerView.aoo();
                        break;
                    case 24580:
                        if (editorPlayerView.cso != null && editorPlayerView.aog()) {
                            int i = message.arg1;
                            if (editorPlayerView.cso.aIx() != i || editorPlayerView.cso.aIx() == 0) {
                                editorPlayerView.cso.mo34196uf(i);
                                StringBuilder sb = new StringBuilder();
                                sb.append("Player Seek position:");
                                sb.append(i);
                                LogUtils.m14223i("EditorPlayerView", sb.toString());
                                break;
                            }
                        } else {
                            sendMessageDelayed(obtainMessage(24580, message.arg1, 0), 40);
                            break;
                        }
                        break;
                    case 24581:
                        removeMessages(24580);
                        if (editorPlayerView.cso != null && editorPlayerView.aog()) {
                            int i2 = message.arg1;
                            int i3 = message.arg2;
                            VeRange veRange = new VeRange(i2, i3);
                            if (!veRange.equals(editorPlayerView.cso.aIC())) {
                                editorPlayerView.cso.mo34186d(veRange);
                            }
                            int intValue = message.obj != null ? ((Integer) message.obj).intValue() : -1;
                            if (intValue < i2 || intValue > i3 + i2) {
                                intValue = i2;
                            }
                            sendMessage(obtainMessage(24580, intValue, 0));
                            break;
                        } else {
                            sendMessageDelayed(obtainMessage(24581, message.arg1, message.arg2, message.obj), 40);
                            break;
                        }
                        break;
                    case 24582:
                        if (message.obj instanceof C6484a) {
                            removeMessages(24582);
                            if (!editorPlayerView.aog()) {
                                sendMessageDelayed(obtainMessage(24582, message.obj), 40);
                                break;
                            } else {
                                C6484a aVar = (C6484a) message.obj;
                                if (editorPlayerView.cYJ != null) {
                                    editorPlayerView.cYJ.mo29748c(aVar);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    public EditorPlayerView(Context context) {
        super(context);
    }

    public EditorPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EditorPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m18704E(final int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("||||||Update Progress:");
        sb.append(i);
        LogUtils.m14223i("EditorPlayerView", sb.toString());
        C5852d.agW().mo28249lW(i);
        if (this.cYi) {
            if (!z) {
                if (this.cYL == null) {
                    this.cYL = C1834l.m5254a((C1839n<T>) new C1839n<Integer>() {
                        /* renamed from: a */
                        public void mo10177a(C1838m<Integer> mVar) throws Exception {
                            EditorPlayerView.this.cYM = mVar;
                            mVar.mo9791K(Integer.valueOf(i));
                        }
                    }).mo10157d(C1487a.aUa()).mo10171h(100, TimeUnit.MILLISECONDS).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Integer>() {
                        /* renamed from: j */
                        public void accept(Integer num) throws Exception {
                            EditorPlayerView.this.m18730oh(num.intValue());
                        }
                    });
                    this.cBh.mo9785e(this.cYL);
                }
                if (this.cYM != null) {
                    this.cYM.mo9791K(Integer.valueOf(i));
                }
            } else {
                m18730oh(i);
            }
        }
    }

    private void aar() {
        this.bMj = (RelativeLayout) findViewById(R.id.preview_layout);
        this.ctD = (RelativeLayout) findViewById(R.id.preview_layout_fake);
        this.cYg = (RelativeLayout) findViewById(R.id.layout_preview_background);
        if (this.cYj == 0) {
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.bottomMargin = C5840b.cEz;
            this.cYg.setLayoutParams(layoutParams);
        } else if (this.cYj == 1) {
            LayoutParams layoutParams2 = new LayoutParams(-1, -1);
            layoutParams2.bottomMargin = C5840b.cEA;
            layoutParams2.topMargin = C5840b.cEB;
            this.cYg.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    public QSessionStream abB() {
        MSize b = m18714b(this.csP, this.css);
        QRect qRect = new QRect(0, 0, C8572y.m25087dI(b.width, 2), C8572y.m25087dI(b.height, 2));
        VeMSize veMSize = null;
        switch (this.cYr) {
            case 0:
                aor();
                if (this.cFI == 1011) {
                    this.cYI = new QStoryboard();
                    this.cYq.aib().duplicate(this.cYI);
                } else {
                    aoq();
                }
                QStoryboard workStoryboard = getWorkStoryboard();
                C8540q.m24935a(workStoryboard, new VeMSize(b.width, b.height));
                return C8563r.m25045a(1, workStoryboard, 0, 0, qRect, 65537, 0, this.csD);
            case 1:
                aor();
                aoq();
                this.cYI = new QStoryboard();
                this.cYq.aib().duplicate(this.cYI);
                if (getFocusClip() == null) {
                    return null;
                }
                if (this.cFI == 1003 || this.cFI == 1014) {
                    C8563r.m25047e(getFocusClip());
                }
                return C8563r.m25046a(getFocusClip(), qRect, 65537, 0, this.csD);
            case 2:
                boolean z = !((Boolean) getFocusClip().getProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE)).booleanValue();
                if (this.cYH == null) {
                    this.cYG = new QClip();
                    getFocusClip().duplicate(this.cYG);
                    this.cYH = new QStoryboard();
                    this.cYH.init(this.cYq.adL().aJv(), null);
                    C8540q.m24923a(this.cYH, this.cYG, 0);
                    if (this.cFI == 1003 || this.cFI == 1014) {
                        C8563r.m25047e(this.cYG);
                    }
                }
                QClip i = C8540q.m24956i(this.cYH, 0);
                if (z || this.cFI == 1003) {
                    i.setProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE, Boolean.valueOf(false));
                } else {
                    i.setProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE, Boolean.valueOf(true));
                }
                if (this.css != null) {
                    veMSize = new VeMSize(this.css.width, this.css.height);
                }
                C8540q.m24935a(this.cYH, veMSize);
                return C8563r.m25045a(1, this.cYH, 0, 0, qRect, 65537, 0, this.csD);
            default:
                return null;
        }
    }

    private void amW() {
        this.cUa = new C5689c(this.ctD, (RelativeLayout) findViewById(R.id.xiaoying_relativelayout_fine_tunning_tip));
        this.cUa.mo27876a((C5688b) new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                if (EditorPlayerView.this.getFineTuningProxyListener() != null) {
                    EditorPlayerView.this.getFineTuningProxyListener().mo27798a(aVar);
                }
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                return EditorPlayerView.this.getFineTuningProxyListener() != null && EditorPlayerView.this.getFineTuningProxyListener().mo27799a(EditorPlayerView.this.m18724g(point));
            }

            public boolean aet() {
                return EditorPlayerView.this.getFineTuningProxyListener() != null && EditorPlayerView.this.cso != null && !EditorPlayerView.this.cso.isPlaying() && EditorPlayerView.this.getFineTuningProxyListener().aet();
            }

            public void aeu() {
                if (EditorPlayerView.this.cYs) {
                    EditorPlayerView.this.pause();
                }
                if (EditorPlayerView.this.getFineTuningProxyListener() != null) {
                    EditorPlayerView.this.getFineTuningProxyListener().aeu();
                }
            }

            public int aev() {
                if (EditorPlayerView.this.cYE != null) {
                    EditorPlayerView.this.cYE.setMode(1);
                    EditorPlayerView.this.cYE.mo34146a(EditorPlayerView.this.cso);
                }
                if (EditorPlayerView.this.getFineTuningProxyListener() != null) {
                    return EditorPlayerView.this.getFineTuningProxyListener().aev();
                }
                return 0;
            }

            public void aew() {
                if (EditorPlayerView.this.getFineTuningProxyListener() != null) {
                    EditorPlayerView.this.getFineTuningProxyListener().aew();
                }
                if (EditorPlayerView.this.cYE != null) {
                    EditorPlayerView.this.cYE.aIp();
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                if (i < 0) {
                    i = 0;
                }
                return EditorPlayerView.this.getFineTuningProxyListener() != null ? EditorPlayerView.this.getFineTuningProxyListener().mo27804hV(i) : i;
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                EditorPlayerView.this.cTN = true;
                if (EditorPlayerView.this.cYE != null) {
                    EditorPlayerView.this.cYE.mo34149b(new C8424a(i, false));
                }
                if (EditorPlayerView.this.getFineTuningProxyListener() != null) {
                    EditorPlayerView.this.getFineTuningProxyListener().mo27805lb(i);
                }
            }
        });
        this.cUa.adc();
    }

    private void aoj() {
        this.cYC.mo28447d(getSurfaceSize());
        this.cYC.setCustomWaterMarkViewListener(new C6087a() {
            public void ake() {
                if (EditorPlayerView.this.cYu != null) {
                    EditorPlayerView.this.cYu.aer();
                }
            }
        });
    }

    private void aok() {
        this.cti = (ImageButton) findViewById(R.id.imgbtn_play);
        this.cYB = findViewById(R.id.btn_purchase_remove_watermark);
        this.cYC = (WatermarkFakerView) findViewById(R.id.simple_watermark_player_faker_view);
        this.cti.setOnClickListener(this);
        this.cYB.setOnClickListener(this);
    }

    private void aol() {
        this.cBh.mo9785e(C1834l.m5254a((C1839n<T>) new C1839n<C6096h>() {
            /* renamed from: a */
            public void mo10177a(C1838m<C6096h> mVar) {
                String str = "";
                if (!(EditorPlayerView.this.cYq.ahP() == null || EditorPlayerView.this.cYq.ahP().mProjectDataItem == null)) {
                    str = EditorPlayerView.this.cYq.ahP().mProjectDataItem.strPrjURL;
                }
                C6096h a = C6094f.m17364a(C6092e.m17360hm(C6092e.m17362ho(str)), EditorPlayerView.this.getSurfaceSize(), EditorPlayerView.this.getStreamSize());
                if (a != null) {
                    mVar.mo9791K(a);
                } else {
                    C6091d.ajW().mo28829a(null);
                }
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<C6096h>() {
            /* renamed from: d */
            public void accept(C6096h hVar) {
                if (hVar != null) {
                    C6091d.ajW().mo28829a(hVar);
                    EditorPlayerView.this.m18719c(hVar);
                }
            }
        }));
    }

    /* access modifiers changed from: private */
    public void aom() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.player_seek_view_stub);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            this.cWk = (RelativeLayout) inflate.findViewById(R.id.relativelayout_seekbar);
            this.cAF = (SeekBar) inflate.findViewById(R.id.seekbar_simple_edit);
            this.cWl = (TextView) inflate.findViewById(R.id.txtview_cur_time);
            this.cWm = (TextView) inflate.findViewById(R.id.txtview_duration);
            this.cYA = (ImageButton) inflate.findViewById(R.id.seekbar_play);
            if (!this.cYi) {
                this.cAF.setVisibility(4);
                this.cYA.setVisibility(4);
                this.cWl.setVisibility(4);
                this.cWm.setVisibility(4);
            }
            this.cYA.setOnClickListener(this);
        }
    }

    private void aon() {
        int i = 0;
        int i2 = 8;
        if (C8049f.aBf().aBr()) {
            WatermarkFakerView watermarkFakerView = this.cYC;
            if (this.cYo && C6091d.ajW().ajX() != null) {
                i2 = 0;
            }
            watermarkFakerView.setVisibility(i2);
            return;
        }
        WatermarkFakerView watermarkFakerView2 = this.cYC;
        if (C6091d.ajW().ajX() == null) {
            i = 8;
        }
        watermarkFakerView2.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public void aoo() {
        StringBuilder sb = new StringBuilder();
        sb.append("$$$rebuildPlayerInter, tate==");
        sb.append(this.cYk);
        LogUtils.m14223i("EditorPlayerView", sb.toString());
        if (!this.csx || this.csP == null) {
            if (this.cso != null) {
                this.cso.mo34191jn(false);
            }
            if (this.cYD != null) {
                this.cYD.removeMessages(24578);
                this.cYD.sendMessageDelayed(this.cYD.obtainMessage(24578), 40);
            }
            return;
        }
        if (this.cso == null) {
            int agZ = C5852d.agW().agZ();
            if (this.cYr != agZ) {
                this.cYr = agZ;
            }
            mo29655gl(false);
        } else {
            if (this.cYh.getSurface().isValid() && this.cYk != 1) {
                this.cYk = 1;
                QDisplayContext c = C8571x.m25060c(this.csP.width, this.csP.height, 1, this.cYh);
                this.cso.setDisplayContext(c);
                this.cso.mo34166a(c, this.csK);
                this.cso.aIB();
                LogUtils.m14223i("EditorPlayerView", "$$$Player activeStream done...");
            }
            this.cYk = 2;
        }
    }

    private void aop() {
        this.cYE = new C8421a();
        this.cYE.aIo().mo9817a((C1807g<? super T>) new C1807g<C8424a>() {
            /* renamed from: a */
            public void mo9888K(C8424a aVar) {
                long j = (long) aVar.position;
                StringBuilder sb = new StringBuilder();
                sb.append("PlayerSeekRx-->position = ");
                sb.append(j);
                sb.append(",finish = ");
                sb.append(aVar.eev);
                LogUtils.m14223i("EditorPlayerView", sb.toString());
                if (EditorPlayerView.this.cTZ != null) {
                    EditorPlayerView.this.cTZ.mo9893bV(1);
                }
                int i = (int) j;
                C5852d.agW().mo28249lW(i);
                if (aVar.eev) {
                    EditorPlayerView.this.cYF = j;
                    EditorPlayerView.this.cTN = false;
                    EditorPlayerView.this.m18704E(i, true);
                    if (EditorPlayerView.this.cYp) {
                        EditorPlayerView.this.aoh();
                        EditorPlayerView.this.cYp = false;
                    }
                }
            }

            /* renamed from: a */
            public void mo9889a(C9963d dVar) {
                EditorPlayerView.this.cTZ = dVar;
                EditorPlayerView.this.cTZ.mo9893bV(1);
            }

            public void onComplete() {
                LogUtils.m14221d("EditorPlayerView", "PlayerSeekRx-->onComplete");
            }

            public void onError(Throwable th) {
                LogUtils.m14221d("EditorPlayerView", "PlayerSeekRx-->onError");
                th.printStackTrace();
            }
        });
    }

    static /* synthetic */ int aou() {
        int i = retryCount;
        retryCount = i + 1;
        return i;
    }

    /* renamed from: b */
    private MSize m18714b(MSize mSize, MSize mSize2) {
        if (!C8549f.aJc() || !C5837a.agH().agI()) {
            return mSize2;
        }
        LogUtilsV2.m14228e("Use HD Preview!");
        C8501a.aJs().aJv().setProperty(39, Boolean.FALSE);
        VeMSize veMSize = null;
        if (mSize2 != null) {
            veMSize = new VeMSize(mSize2.width, mSize2.height);
        }
        VeMSize d = C8572y.m25086d(veMSize, new VeMSize(cYO.width, cYO.height));
        if (d != null && d.height * d.width < mSize.width * mSize.height) {
            mSize = new MSize(d.width, d.height);
        }
        return mSize;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18719c(C6096h hVar) {
        if (this.cYC != null && hVar != null) {
            this.cYC.setVisibility(0);
            this.cYC.mo28449e(hVar.cKy);
        } else if (this.cYC != null) {
            this.cYC.setVisibility(8);
        }
    }

    /* renamed from: cG */
    private void m18720cG(int i, int i2) {
        if (this.cAF != null) {
            this.cAF.setMax(i);
            this.cAF.setProgress(i2);
            this.cAF.setOnSeekBarChangeListener(this.cYN);
        }
        if (this.cWm != null && this.cWl != null) {
            if (mo29658of(i)) {
                this.cWm.setTextColor(getResources().getColor(R.color.color_FF2E0E));
            } else {
                this.cWm.setTextColor(getResources().getColor(R.color.f6180default));
            }
            this.cWm.setText(C4580b.m11637V((long) i));
            this.cWl.setText(C4580b.m11637V((long) i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public Point m18724g(Point point) {
        if (point == null || this.ctD == null || this.bMj == null) {
            return null;
        }
        point.x -= this.bMj.getLeft();
        point.y -= this.bMj.getTop();
        StringBuilder sb = new StringBuilder();
        sb.append("onSingleTap fixClickPoint = ");
        sb.append(point);
        LogUtilsV2.m14227d(sb.toString());
        return point;
    }

    private QClip getFocusClip() {
        return C8540q.m24956i(getWorkStoryboard(), getFocusIndex());
    }

    /* access modifiers changed from: private */
    public C8434c getPlayCallback() {
        if (this.cTW == null) {
            this.cTW = new C6479a();
        }
        return this.cTW;
    }

    private QStoryboard getWorkStoryboard() {
        return (this.cYr != 2 || this.cYH == null) ? this.cYI != null ? this.cYI : this.cYq.aib() : this.cYH;
    }

    /* access modifiers changed from: private */
    /* renamed from: gn */
    public void m18726gn(boolean z) {
        if (this.cti.isShown()) {
            this.cti.setSelected(z);
        }
        if (this.cYA.isShown()) {
            this.cYA.setSelected(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: oh */
    public void m18730oh(int i) {
        if (this.cYi) {
            int nO = mo29656nO(i);
            if (!this.cTN) {
                this.cAF.setProgress(nO);
            }
            this.cWl.setText(C4580b.m11637V((long) nO));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: oi */
    public void m18731oi(int i) {
        if (this.cso != null) {
            this.cso.mo34197ug(i);
        }
    }

    /* renamed from: t */
    private void m18733t(int i, int i2, int i3, int i4) {
        if (this.cso != null) {
            pause();
            if (this.cYD != null) {
                this.cYD.removeMessages(24581);
                this.cYD.sendMessageDelayed(this.cYD.obtainMessage(24581, i, i2, Integer.valueOf(i3)), (long) i4);
            }
        }
    }

    /* renamed from: H */
    public void mo29675H(int i, boolean z) {
        pause();
        if (z) {
            aoh();
        }
        if (this.cYD != null) {
            this.cYD.removeMessages(24580);
            this.cYD.sendMessage(this.cYD.obtainMessage(24580, i, 0));
        }
    }

    /* renamed from: a */
    public void mo29676a(int i, C6501c cVar, boolean z) {
        if (this.cso != null) {
            int a = this.cso.mo34167a(getWorkStoryboard().getDataClip(), 11, null);
            if (cVar != null) {
                cVar.mo29749op(a);
            }
            boolean z2 = a == 0;
            if (i < 0) {
                i = 0;
            }
            if (z2) {
                mo29675H(i, z);
            }
        }
    }

    /* renamed from: a */
    public void mo29677a(int i, QEffect qEffect) {
        if (this.cso != null && getWorkStoryboard() != null) {
            this.cso.mo34167a(getWorkStoryboard().getDataClip(), i, qEffect);
        }
    }

    /* renamed from: a */
    public void mo29642a(Activity activity, C5655b bVar, int i) {
        super.mo29642a(activity, bVar, i);
        this.cBh = new C1494a();
        mo29688f(bVar.getStreamSize());
        aoj();
        aol();
        C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                EditorPlayerView.this.aom();
                EditorPlayerView.this.mo29698og(0);
                EditorPlayerView.this.aof();
            }
        }, 120, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public <E extends C6484a> boolean mo29678a(E e) {
        return this.cYJ != null && this.cYJ.mo29748c(e);
    }

    /* access modifiers changed from: protected */
    public void abt() {
        this.cYf = (SurfaceView) findViewById(R.id.video_editor_preview);
        this.cYh = this.cYf.getHolder();
        if (this.cYh != null) {
            this.cYh.addCallback(new C6480b());
            this.cYh.setType(2);
            this.cYh.setFormat(1);
        }
    }

    public void aea() {
        pause();
        this.cTN = true;
        if (this.cYE != null) {
            this.cYE.setMode(1);
            this.cYE.mo34146a(this.cso);
        }
    }

    public void aeb() {
        if (this.cYE != null) {
            this.cYE.aIp();
        }
    }

    public void aex() {
        super.aex();
        this.cYJ = new C6498b();
        this.cYJ.attachView((C6482a) this);
        this.csD = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false) ? 4 : 2;
        LayoutInflater.from(getContext()).inflate(R.layout.editor_player_layout, this, true);
        aar();
        aok();
        abt();
        amW();
        aop();
        C10021c.aZH().mo38494ax(this);
    }

    public void aof() {
        int agR = C5843c.agO().agR();
        int agS = C5843c.agO().agS();
        int tabMode = C5843c.agO().getTabMode();
        boolean agT = C5843c.agO().agT();
        if (agR == -1 || (agS != -1 && !EditorModes.isThemeMode(agS))) {
            if (!EditorModes.isClipEditMode(agS) || agS == 1006) {
                this.cti.setVisibility(8);
            } else {
                this.cti.setSelected(false);
                this.cti.setVisibility(0);
            }
            this.cWk.setVisibility(8);
            this.cYB.setVisibility(8);
            if (agS != 2008) {
                this.cYC.setVisibility(8);
                return;
            }
            return;
        }
        this.cti.setVisibility(8);
        if (this.cso == null || !this.cso.isPlaying()) {
            this.cYA.setSelected(false);
        }
        this.cWk.setVisibility(0);
        if (!this.cYo) {
            this.cYB.setVisibility(0);
        }
        aon();
        if (EditorModes.isThemeMode(agS) || agT) {
            this.cYB.setVisibility(8);
            this.cYC.setVisibility(8);
        }
        if (tabMode == 1 && agT) {
            this.cti.setSelected(false);
            this.cti.setVisibility(0);
            this.cWk.setVisibility(8);
        } else if (tabMode == 2) {
            this.cWk.setVisibility(8);
        }
    }

    public void aoh() {
        super.aoh();
        retryCount = 0;
        if (this.cYD != null) {
            this.cYD.sendEmptyMessageDelayed(24576, 40);
        }
    }

    public void aoi() {
        super.aoi();
        if (this.cYD != null) {
            this.cYD.removeMessages(24576);
        }
        pause();
    }

    public void aoq() {
        if (this.cYI != null) {
            this.cYI.unInit();
            this.cYI = null;
        }
    }

    public void aor() {
        if (this.cYH != null) {
            this.cYH.unInit();
            this.cYH = null;
        }
        if (this.cYG != null) {
            this.cYG = null;
        }
    }

    public void aos() {
        if (this.cso != null) {
            this.cso.aIB();
        }
    }

    /* renamed from: b */
    public void mo29685b(int i, QEffect qEffect) {
        if (this.cso != null) {
            this.cso.mo34167a(getFocusClip(), i, qEffect);
        }
    }

    /* renamed from: b */
    public <E extends C6484a> void mo29686b(E e) {
        if (this.cYD != null) {
            this.cYD.removeMessages(24582);
            this.cYD.sendMessage(this.cYD.obtainMessage(24582, e));
        }
    }

    /* renamed from: c */
    public boolean mo29649c(MSize mSize, boolean z) {
        if (mSize != null && mSize.equals(this.css) && !z) {
            return false;
        }
        this.css = mSize;
        this.csP = mo29641a(mSize, this.cYq.adN());
        LayoutParams layoutParams = new LayoutParams(this.csP.width, this.csP.height);
        layoutParams.addRule(13);
        this.bMj.setLayoutParams(layoutParams);
        this.bMj.requestLayout();
        this.bMj.invalidate();
        this.csx = true;
        this.cYC.mo28448e(this.csP);
        C6096h a = C6094f.m17364a(C6091d.ajW().ajX(), this.csP, this.css);
        C6091d.ajW().mo28829a(a);
        m18719c(a);
        return true;
    }

    /* renamed from: cH */
    public void mo29687cH(int i, int i2) {
        this.cYr = i;
        this.cYl = i2;
        mo29655gl(true);
    }

    /* renamed from: f */
    public boolean mo29688f(MSize mSize) {
        return mo29649c(mSize, false);
    }

    public QClip getClip(int i) {
        return C8540q.m24956i(getWorkStoryboard(), i);
    }

    public int getFocusIndex() {
        if ((this.cYr != 2 || this.cYH == null) && this.cYu != null) {
            return this.cYu.aep();
        }
        return 0;
    }

    public QStoryboard getStoryboard() {
        return getWorkStoryboard();
    }

    public MSize getStreamSize() {
        return this.css;
    }

    public MSize getSurfaceSize() {
        return this.csP;
    }

    public QEngine getVEEngine() {
        if (this.cYq != null) {
            return this.cYq.getEngine();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: gl */
    public void mo29655gl(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("&&&initXYMediaPlayer playerInitState==:");
        sb.append(this.cYk);
        LogUtils.m14223i("EditorPlayerView", sb.toString());
        if (this.cYk == 1) {
            LogUtils.m14222e("EditorPlayerView", "Player init intercept，Player is building...");
            return;
        }
        this.cYk = 1;
        this.cYm = false;
        if (this.cso != null) {
            this.cso.mo34185c(null);
        }
        C1834l.m5257ah(Boolean.valueOf(z)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                LogUtils.m14223i("EditorPlayerView", "&&&InitXYMediaPlayer ---------------------->");
                EditorPlayerView.this.aoe();
                long currentTimeMillis = System.currentTimeMillis();
                EditorPlayerView.this.cso = new C8431d();
                int i = 0;
                EditorPlayerView.this.cso.mo34191jn(false);
                QSessionStream b = EditorPlayerView.this.abB();
                if (b == null) {
                    return Boolean.valueOf(false);
                }
                int i2 = 0;
                while (true) {
                    if (EditorPlayerView.this.cYh != null && EditorPlayerView.this.cYh.getSurface() != null && EditorPlayerView.this.cYh.getSurface().isValid() && i2 >= 1) {
                        break;
                    }
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i2++;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                LogUtils.m14223i("EditorPlayerView", "&&&InitXYMediaPlayer init start >>>>");
                VeMSize veMSize = null;
                if (EditorPlayerView.this.csP != null) {
                    veMSize = new VeMSize(EditorPlayerView.this.csP.width, EditorPlayerView.this.csP.height);
                }
                boolean a = EditorPlayerView.this.cso.mo34169a(b, EditorPlayerView.this.getPlayCallback(), veMSize, EditorPlayerView.this.cYl, EditorPlayerView.this.cYq.getEngine(), EditorPlayerView.this.cYh);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(currentTimeMillis3);
                hashMap.put("timeCost", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(currentTimeMillis3 / 100);
                sb2.append("_");
                sb2.append(currentTimeMillis4 / 100);
                hashMap.put("timeCost100_realTimeCost100", sb2.toString());
                UserBehaviorLog.onKVEvent(EditorPlayerView.this.getContext(), "Dev_Event_RebuildPlayer_TimeCost", hashMap);
                if (a) {
                    while (!EditorPlayerView.this.cYm && i < 3) {
                        try {
                            Thread.sleep(80);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        i++;
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("&&&InitXYMediaPlayer PlayerInitTask initResult=");
                sb3.append(a);
                LogUtils.m14223i("EditorPlayerView", sb3.toString());
                return Boolean.valueOf(a);
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                LogUtils.m14223i("EditorPlayerView", "&&&InitXYMediaPlayer onSubscribe");
                EditorPlayerView.this.cBh.mo9785e(bVar);
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                StringBuilder sb = new StringBuilder();
                sb.append("&&&InitXYMediaPlayer onNext<-----------aBoolean：");
                sb.append(bool);
                LogUtils.m14223i("EditorPlayerView", sb.toString());
                EditorPlayerView.this.cYk = 2;
                if (EditorPlayerView.this.cYv != null) {
                    EditorPlayerView.this.cYv.aes();
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                LogUtils.m14223i("EditorPlayerView", "&&&InitXYMediaPlayer  Error<----------------------");
                EditorPlayerView.this.cYk = 2;
            }
        });
    }

    /* renamed from: gm */
    public void mo29695gm(boolean z) {
        if (EditorModes.isBaseEditMode(this.cFI)) {
            this.cYo = !z;
            int agS = C5843c.agO().agS();
            boolean agT = C5843c.agO().agT();
            if (agS == -1 && !agT) {
                this.cYB.setVisibility(z ? 0 : 8);
                aon();
            }
        }
    }

    /* renamed from: kY */
    public void mo29696kY(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onSeekProgressChanged ,progress:");
        sb.append(i);
        LogUtils.m14222e("EditorPlayerView", sb.toString());
        if (this.cYE != null) {
            this.cYE.mo34149b(new C8424a(i, false));
        }
    }

    /* renamed from: n */
    public void mo29697n(boolean z, int i) {
        if (this.cso != null && this.cFI == 0) {
            pause();
            this.cYK = !z;
            if (z) {
                m18733t(0, getWorkStoryboard().getDuration(), i, 40);
            } else {
                VeRange S = C8540q.m24910S(getWorkStoryboard());
                this.cso.mo34186d(S);
                if (!S.contains(i)) {
                    i = S.getmPosition();
                }
                this.cso.mo34196uf(i);
            }
            mo29698og(i);
        }
    }

    /* renamed from: og */
    public void mo29698og(int i) {
        int i2 = 0;
        if (this.cFI != 0 || !this.cYK) {
            QStoryboard workStoryboard = getWorkStoryboard();
            if (workStoryboard != null && workStoryboard.getClipCount() > 0) {
                i2 = workStoryboard.getDuration();
                if (this.cYi) {
                    m18720cG(i2, i);
                }
            } else if (this.cYi) {
                m18720cG(100, 0);
            }
        } else {
            if (this.cso != null) {
                i2 = this.cso.aIy();
            }
            if (this.cYi) {
                m18720cG(i2, mo29656nO(i));
            }
        }
        C5852d.agW().mo28248lV(i2);
        if (this.cYu != null) {
            this.cYu.mo27792la(i2);
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        aoe();
        C10021c.aZH().mo38496az(this);
        if (this.cBh != null) {
            this.cBh.clear();
        }
        if (this.cYD != null) {
            this.cYD.removeCallbacksAndMessages(null);
            this.cYD = null;
        }
        if (this.cYI != null) {
            this.cYI.unInit();
            this.cYI = null;
        }
        if (this.cTZ != null) {
            this.cTZ.cancel();
            this.cTZ = null;
        }
    }

    public void onActivityPause() {
        super.onActivityPause();
        if (this.cso != null) {
            pause();
            if (this.cso != null) {
                this.csK = this.cso.aIx();
            }
            if (this.cso != null) {
                this.cso.aIt();
            }
            this.cYk = 0;
            if (this.cYq.ahZ().aim()) {
                aoe();
            }
        }
        Activity activity = (Activity) this.cYe.get();
        if (activity != null && activity.isFinishing()) {
            aoe();
            C5852d.agW().reset();
        }
        this.bTs = true;
    }

    public void onActivityResume() {
        super.onActivityResume();
        if (this.bTs && this.cYD != null) {
            this.cYD.removeMessages(24578);
            this.cYD.sendMessageDelayed(this.cYD.obtainMessage(24578), 40);
        }
        this.bTs = false;
    }

    public void onClick(View view) {
        if (view == this.cti || view == this.cYA) {
            if (view.isSelected()) {
                if (getVideoControlListener() != null) {
                    getVideoControlListener().agl();
                    return;
                }
                aoi();
            } else if (getVideoControlListener() != null) {
                getVideoControlListener().agk();
            } else {
                aoh();
            }
        } else if (view == this.cYB && this.cYu != null) {
            this.cYu.aeq();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6090c cVar) {
        if (cVar.cJH) {
            this.cYC.setVisibility(8);
        } else {
            m18719c(cVar.cJG);
        }
    }

    public void setPlayRange(int i, int i2, boolean z) {
        if (this.cso != null) {
            setPlayRange(i, i2, z, this.cso.aIx());
        }
    }

    public void setPlayRange(int i, int i2, boolean z, int i3) {
        if (i3 < i || i3 > i + i2) {
            i3 = i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Player setPlayRange, start:");
        sb.append(i);
        sb.append(",length:");
        sb.append(i2);
        sb.append(",autoPlay:");
        sb.append(z);
        sb.append(",startPos:");
        sb.append(i3);
        LogUtils.m14222e("EditorPlayerView", sb.toString());
        m18733t(i, i2, i3, 0);
        if (z) {
            aoh();
        }
    }
}
