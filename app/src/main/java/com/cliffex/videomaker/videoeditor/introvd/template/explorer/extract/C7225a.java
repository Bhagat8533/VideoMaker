package com.introvd.template.explorer.extract;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.explorer.p308ui.WaveSeekBar;
import com.introvd.template.explorer.p308ui.WaveSeekBar.C7340a;
import com.introvd.template.explorer.p308ui.WaveSeekBar.C7342c;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.sdk.editor.cache.C8442c;
import com.introvd.template.sdk.editor.p388b.C8421a;
import com.introvd.template.sdk.editor.p388b.C8421a.C8424a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.C8563r;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p397d.C8546a;
import com.introvd.template.sdk.utils.p397d.C8547b;
import com.introvd.template.vivaexplorermodule.R;
import java.lang.ref.WeakReference;
import org.p489b.C9963d;
import p037b.p050b.C1807g;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QSessionStream;

/* renamed from: com.introvd.template.explorer.extract.a */
public class C7225a extends BaseController<C7236c> {
    private C8546a cTA;
    private C8442c cTG = new C8442c();
    private C8434c cTW;
    /* access modifiers changed from: private */
    public C9963d cTZ;
    /* access modifiers changed from: private */
    public VeMSize cWh;
    /* access modifiers changed from: private */
    public C8421a cYE;
    /* access modifiers changed from: private */
    public SurfaceHolder cYh;
    /* access modifiers changed from: private */
    public volatile int cYk = 0;
    /* access modifiers changed from: private */
    public volatile boolean cYm;
    private Context context;
    /* access modifiers changed from: private */
    public int csK = -1;
    /* access modifiers changed from: private */
    public C8431d cso = null;
    /* access modifiers changed from: private */
    public C1495b dgd;
    /* access modifiers changed from: private */
    public C7233c dys = new C7233c(this);

    /* renamed from: com.introvd.template.explorer.extract.a$5 */
    static /* synthetic */ class C72305 {
        static final /* synthetic */ int[] dyu = new int[C7340a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.introvd.template.explorer.ui.WaveSeekBar$a[] r0 = com.introvd.template.explorer.p308ui.WaveSeekBar.C7340a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                dyu = r0
                int[] r0 = dyu     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.introvd.template.explorer.ui.WaveSeekBar$a r1 = com.introvd.template.explorer.p308ui.WaveSeekBar.C7340a.START     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = dyu     // Catch:{ NoSuchFieldError -> 0x001f }
                com.introvd.template.explorer.ui.WaveSeekBar$a r1 = com.introvd.template.explorer.p308ui.WaveSeekBar.C7340a.MOVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = dyu     // Catch:{ NoSuchFieldError -> 0x002a }
                com.introvd.template.explorer.ui.WaveSeekBar$a r1 = com.introvd.template.explorer.p308ui.WaveSeekBar.C7340a.END     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.extract.C7225a.C72305.<clinit>():void");
        }
    }

    /* renamed from: com.introvd.template.explorer.extract.a$a */
    private class C7231a implements C8434c {
        public C7231a() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            switch (i) {
                case 2:
                    C7225a.this.cYm = true;
                    if (C7225a.this.cso != null) {
                        C7225a.this.cso.mo34191jn(true);
                        C7225a.this.cso.aIB();
                    }
                    ((C7236c) C7225a.this.getMvpView()).mo31702nF(C7225a.this.cso.agX());
                    ((C7236c) C7225a.this.getMvpView()).mo31700hd(false);
                    return;
                case 3:
                    ((C7236c) C7225a.this.getMvpView()).mo31700hd(true);
                    C4597i.m11729b(true, ((C7236c) C7225a.this.getMvpView()).getHostActivity());
                    return;
                case 4:
                    ((C7236c) C7225a.this.getMvpView()).mo31700hd(false);
                    C4597i.m11729b(false, ((C7236c) C7225a.this.getMvpView()).getHostActivity());
                    return;
                case 5:
                    ((C7236c) C7225a.this.getMvpView()).mo31700hd(false);
                    C4597i.m11729b(false, ((C7236c) C7225a.this.getMvpView()).getHostActivity());
                    if (C7225a.this.cso != null) {
                        C7225a.this.cso.mo34197ug(0);
                        return;
                    }
                    return;
                case 6:
                    ((C7236c) C7225a.this.getMvpView()).mo31700hd(false);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.introvd.template.explorer.extract.a$b */
    private class C7232b implements Callback {
        private C7232b() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            C7225a.this.cYh = surfaceHolder;
            if (C7225a.this.dys != null) {
                C7225a.this.dys.removeMessages(24578);
                C7225a.this.dys.sendMessageDelayed(C7225a.this.dys.obtainMessage(24578), 40);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            C7225a.this.cYh = surfaceHolder;
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }

    /* renamed from: com.introvd.template.explorer.extract.a$c */
    public static class C7233c extends Handler {
        private WeakReference<C7225a> cYS;

        C7233c(C7225a aVar) {
            this.cYS = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C7225a aVar = (C7225a) this.cYS.get();
            if (aVar != null) {
                switch (message.what) {
                    case 24576:
                        removeMessages(24576);
                        if (aVar.cso != null && aVar.aog()) {
                            aVar.cso.play();
                            break;
                        }
                    case 24578:
                        if (aVar.cWh != null) {
                            if (aVar.cso != null) {
                                if (aVar.cYh.getSurface().isValid() && aVar.cYk != 1) {
                                    aVar.cYk = 1;
                                    QDisplayContext c = C8571x.m25060c(aVar.cWh.width, aVar.cWh.height, 1, aVar.cYh);
                                    aVar.cso.setDisplayContext(c);
                                    aVar.cso.mo34166a(c, aVar.csK);
                                    aVar.cso.aIB();
                                }
                                aVar.cYk = 2;
                                break;
                            } else {
                                aVar.arO();
                                break;
                            }
                        } else {
                            if (aVar.cso != null) {
                                aVar.cso.mo34191jn(false);
                            }
                            aVar.dys.removeMessages(24578);
                            aVar.dys.sendMessageDelayed(obtainMessage(24578), 40);
                            return;
                        }
                    case 24580:
                        if (aVar.cso != null && aVar.aog()) {
                            int i = message.arg1;
                            if (aVar.cso.aIx() != i || aVar.cso.aIx() == 0) {
                                aVar.cso.mo34196uf(i);
                                break;
                            }
                        } else {
                            sendMessageDelayed(obtainMessage(24580, message.arg1, 0), 40);
                            break;
                        }
                        break;
                    case 24581:
                        removeMessages(24580);
                        if (aVar.cso != null && aVar.aog()) {
                            int i2 = message.arg1;
                            int i3 = message.arg2;
                            VeRange veRange = new VeRange(i2, i3);
                            if (!veRange.equals(aVar.cso.aIC())) {
                                aVar.cso.mo34186d(veRange);
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
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public QSessionStream m21333a(MSize mSize, SurfaceHolder surfaceHolder) {
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

    private void aop() {
        this.cYE = new C8421a();
        this.cYE.aIo().mo9817a((C1807g<? super T>) new C1807g<C8424a>() {
            /* renamed from: a */
            public void mo9888K(C8424a aVar) {
                if (C7225a.this.cTZ != null) {
                    C7225a.this.cTZ.mo9893bV(1);
                }
            }

            /* renamed from: a */
            public void mo9889a(C9963d dVar) {
                C7225a.this.cTZ = dVar;
                C7225a.this.cTZ.mo9893bV(1);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    public void arO() {
        if (this.cYk != 1) {
            this.cYk = 1;
            this.cYm = false;
            if (this.cso != null) {
                this.cso.mo34185c(null);
            }
            C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
                /* renamed from: c */
                public Boolean apply(Boolean bool) {
                    if (C7225a.this.cso != null) {
                        C7225a.this.cso.aIv();
                        C7225a.this.cso = null;
                    }
                    C7225a.this.cso = new C8431d();
                    int i = 0;
                    C7225a.this.cso.mo34191jn(false);
                    QSessionStream a = C7225a.this.m21333a(((C7236c) C7225a.this.getMvpView()).adN(), C7225a.this.cYh);
                    if (a == null) {
                        return Boolean.valueOf(false);
                    }
                    int i2 = 0;
                    while (true) {
                        if (C7225a.this.cYh != null && C7225a.this.cYh.getSurface() != null && C7225a.this.cYh.getSurface().isValid() && i2 >= 1) {
                            break;
                        }
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i2++;
                    }
                    boolean a2 = C7225a.this.cso.mo34169a(a, C7225a.this.getPlayCallback(), C7225a.this.cWh, C7225a.this.csK, C8501a.aJs().aJv(), C7225a.this.cYh);
                    if (a2) {
                        while (!C7225a.this.cYm && i < 3) {
                            try {
                                Thread.sleep(80);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            i++;
                        }
                    }
                    return Boolean.valueOf(a2);
                }
            }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                    C7225a.this.dgd = bVar;
                }

                /* renamed from: b */
                public void mo9886K(Boolean bool) {
                    C7225a.this.cYk = 2;
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    C7225a.this.cYk = 2;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public C8434c getPlayCallback() {
        if (this.cTW == null) {
            this.cTW = new C7231a();
        }
        return this.cTW;
    }

    /* renamed from: iZ */
    private boolean m21344iZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QEngine aJv = C8501a.aJs().aJv();
        if (aJv == null || !MediaFileUtils.IsVideoFileType(MediaFileUtils.GetFileMediaType(str))) {
            return false;
        }
        this.cTA = C8547b.m24991b(aJv, str, false, AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false));
        if (this.cTA.mClip == null) {
            return false;
        }
        if (this.cTA.eej != null) {
            this.cTG.mo34283a(new VeMSize(this.cTA.eej.width, this.cTA.eej.height));
        }
        return true;
    }

    /* renamed from: a */
    public void attachView(C7236c cVar) {
        super.attachView(cVar);
    }

    public void aoe() {
        if (this.cso != null) {
            this.cso.stop();
            this.cso.aIv();
            this.cso = null;
        }
    }

    public boolean aog() {
        return this.cYk == 2;
    }

    public VeMSize awh() {
        return this.cWh;
    }

    public C7342c awi() {
        return new C7342c() {
            /* renamed from: a */
            public void mo31735a(WaveSeekBar waveSeekBar, C7340a aVar, boolean z) {
                int selectedMinValue = waveSeekBar.getSelectedMinValue();
                int selectedMaxValue = waveSeekBar.getSelectedMaxValue();
                StringBuilder sb = new StringBuilder();
                sb.append("onWaveValueChanged---isLeft：");
                sb.append(z);
                sb.append(",leftValue:");
                sb.append(selectedMinValue);
                sb.append(",rightValue:");
                sb.append(selectedMaxValue);
                LogUtils.m14222e("WaveSeek", sb.toString());
                switch (C72305.dyu[aVar.ordinal()]) {
                    case 1:
                        C7225a.this.pause();
                        if (C7225a.this.cYE != null) {
                            C7225a.this.cYE.setMode(1);
                            C7225a.this.cYE.mo34146a(C7225a.this.cso);
                            return;
                        }
                        return;
                    case 2:
                        if (C7225a.this.cYE != null) {
                            C8421a i = C7225a.this.cYE;
                            if (z) {
                                selectedMaxValue = selectedMinValue;
                            }
                            i.mo34149b(new C8424a(selectedMaxValue, false));
                            return;
                        }
                        return;
                    case 3:
                        C7225a aVar2 = C7225a.this;
                        int i2 = selectedMaxValue - selectedMinValue;
                        if (z) {
                            selectedMaxValue = selectedMinValue;
                        }
                        aVar2.mo31733t(selectedMinValue, i2, selectedMaxValue, 0);
                        if (C7225a.this.cYE != null) {
                            C7225a.this.cYE.aIp();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* renamed from: bR */
    public void mo31726bR(Context context2, String str) {
        this.context = context2;
        if (!m21344iZ(str)) {
            ToastUtils.shortShow(context2, R.string.xiaoying_str_ve_clip_add_msg_invalid_file);
            ((C7236c) getMvpView()).abA();
            return;
        }
        this.cWh = C8572y.m25090e(new VeMSize(this.cTG.getWidth(), this.cTG.getHeight()), new VeMSize(((C7236c) getMvpView()).adN().width, ((C7236c) getMvpView()).adN().height));
        aop();
    }

    /* renamed from: c */
    public void mo31727c(SurfaceHolder surfaceHolder) {
        this.cYh = surfaceHolder;
        if (this.cYh != null) {
            this.cYh.addCallback(new C7232b());
            this.cYh.setType(2);
            this.cYh.setFormat(1);
        }
    }

    public void detachView() {
        super.detachView();
    }

    public void onActivityPause() {
        if (this.cso != null) {
            pause();
            this.csK = this.cso.aIx();
            this.cso.aIt();
            this.cYk = 0;
        }
    }

    public void onActivityResume() {
        if (this.dys != null) {
            this.dys.removeMessages(24578);
            this.dys.sendMessageDelayed(this.dys.obtainMessage(24578), 80);
        }
    }

    public void pause() {
        if (this.cso != null && aog()) {
            this.cso.pause();
        }
    }

    public void play() {
        if (this.dys != null) {
            this.dys.sendEmptyMessageDelayed(24576, 40);
        }
    }

    public void release() {
        aoe();
        if (this.dys != null) {
            this.dys.removeCallbacksAndMessages(null);
            this.dys = null;
        }
        if (this.dgd != null) {
            this.dgd.dispose();
            this.dgd = null;
        }
        if (this.cTZ != null) {
            this.cTZ.cancel();
            this.cTZ = null;
        }
    }

    /* renamed from: t */
    public void mo31733t(int i, int i2, int i3, int i4) {
        if (this.cso != null) {
            pause();
            if (this.dys != null) {
                this.dys.removeMessages(24581);
                this.dys.sendMessageDelayed(this.dys.obtainMessage(24581, i, i2, Integer.valueOf(i3)), (long) i4);
            }
        }
    }
}
