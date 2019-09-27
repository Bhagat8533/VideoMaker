package com.introvd.template.editor.videotrim.p292ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.videotrim.p292ui.C7010b.C7015c;
import com.introvd.template.editor.videotrim.p292ui.TrimMaskView4Import.C6983a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.videoeditor.p416a.C9006a;
import java.lang.ref.WeakReference;
import java.util.Locale;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.clip.QClip;

/* renamed from: com.introvd.template.editor.videotrim.ui.a */
public class C7005a {
    public static float dmU = 30.0f;
    /* access modifiers changed from: private */
    public View btV;
    /* access modifiers changed from: private */
    public C7009b cts;
    private int dmV = 0;
    /* access modifiers changed from: private */
    public boolean dmW = false;
    /* access modifiers changed from: private */
    public int dmX = 0;
    /* access modifiers changed from: private */
    public int dmY = 0;
    /* access modifiers changed from: private */
    public boolean dmZ = false;
    /* access modifiers changed from: private */
    public TextView dna;
    /* access modifiers changed from: private */
    public TextView dnb;
    /* access modifiers changed from: private */
    public TextView dnc;
    /* access modifiers changed from: private */
    public TrimMaskView4Import dnd;
    /* access modifiers changed from: private */
    public C7010b dne;
    private C7015c dnf = new C7015c() {
        public void anY() {
            C7005a.this.dmZ = true;
            C7005a.this.mo30898hr(false);
            if (C7005a.this.cts != null) {
                C7005a.this.dmX = C7005a.this.mo30897gi(true);
                C7005a.this.dmY = C7005a.this.mo30897gi(false);
                C7005a.this.cts.mo27404i(true, C7005a.this.dmX);
                C7005a.this.atI();
            }
        }

        public void anZ() {
            if (C7005a.this.cts != null) {
                C7005a.this.dmX = C7005a.this.mo30897gi(true);
                C7005a.this.dmY = C7005a.this.mo30897gi(false);
                C7005a.this.cts.mo27407ky(C7005a.this.dmX);
                C7005a.this.atI();
            }
            C7005a.this.dmZ = false;
        }

        /* renamed from: nY */
        public void mo29618nY(int i) {
            if (C7005a.this.cts != null) {
                C7005a.this.dmX = C7005a.this.mo30897gi(true);
                C7005a.this.dmY = C7005a.this.mo30897gi(false);
                C7005a.this.cts.mo27405iD(C7005a.this.dmX);
                C7005a.this.atI();
            }
        }
    };
    private C6983a dng = new C6983a() {
        private boolean cXj = true;

        public void aoa() {
            Context context = C7005a.this.btV.getContext();
            float c = ((float) C7005a.this.mMinDuration) / 1000.0f;
            ToastUtils.show(context, context.getResources().getString(R.string.xiaoying_str_ve_pip_trim_duration_tip2, new Object[]{String.format(Locale.US, "%1$02.1f", new Object[]{Float.valueOf(c % 60.0f)})}), 0);
        }

        /* renamed from: eH */
        public void mo30707eH(boolean z) {
            C7005a.this.dmW = true;
            this.cXj = z;
            C7005a.this.mo30898hr(false);
            if (C7005a.this.cts != null) {
                C7005a.this.cts.mo27404i(z, C7005a.this.mo30897gi(this.cXj));
                C7005a.this.m20510da(this.cXj ? C7005a.this.mo30897gi(true) : C7005a.this.dmX, this.cXj ? C7005a.this.dmY : C7005a.this.mo30897gi(false));
            }
        }

        /* renamed from: ky */
        public void mo30708ky(int i) {
            if (C7005a.this.cts != null) {
                C7005a.this.cts.mo27407ky(C7005a.this.mo30897gi(this.cXj));
                int gi = this.cXj ? C7005a.this.mo30897gi(true) : C7005a.this.dmX;
                int d = this.cXj ? C7005a.this.dmY : C7005a.this.mo30897gi(false);
                if (this.cXj) {
                    C7005a.this.dmX = gi;
                } else {
                    C7005a.this.dmY = d;
                }
                C7005a.this.m20510da(gi, d);
            }
        }

        /* renamed from: lJ */
        public void mo30709lJ(int i) {
            if (C7005a.this.cts != null) {
                C7005a.this.cts.mo27408kz(C7005a.this.dne.mo30902F(i, false));
            }
        }

        /* renamed from: ls */
        public void mo30710ls(int i) {
            if (C7005a.this.cts != null) {
                C7005a.this.cts.mo27406kA(C7005a.this.dne.mo30902F(i, false));
            }
        }

        /* renamed from: nZ */
        public void mo30711nZ(int i) {
            if (C7005a.this.cts == null) {
                return;
            }
            if (C7005a.this.dnd.isPlaying()) {
                C7005a.this.cts.mo27405iD(C7005a.this.dne.mo30902F(i, false));
                return;
            }
            C7005a.this.cts.mo27405iD(C7005a.this.mo30897gi(this.cXj));
            C7005a.this.m20510da(C7005a.this.mo30897gi(true), C7005a.this.mo30897gi(false));
        }
    };
    private Handler mHandler = new C7008a(this);
    /* access modifiers changed from: private */
    public int mMinDuration = 0;

    /* renamed from: com.introvd.template.editor.videotrim.ui.a$a */
    private static class C7008a extends Handler {
        WeakReference<C7005a> cuV;

        public C7008a(C7005a aVar) {
            this.cuV = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C7005a aVar = (C7005a) this.cuV.get();
            if (aVar != null) {
                switch (message.what) {
                    case HttpStatus.SC_MOVED_PERMANENTLY /*301*/:
                        if (aVar.dnd != null) {
                            int i = message.arg1;
                            if (message.arg2 == 1) {
                                aVar.dmW = true;
                                int pK = aVar.dne.mo30920pK(i);
                                if (aVar.atH()) {
                                    if (aVar.mMinDuration + i > aVar.dmY) {
                                        i = aVar.dmY - aVar.mMinDuration;
                                        pK = aVar.dne.mo30920pK(i);
                                    }
                                    aVar.dnd.setmLeftPos(pK);
                                    aVar.dmX = i;
                                    aVar.m20510da(aVar.dmX, aVar.dmY);
                                } else {
                                    if (i - aVar.mMinDuration < aVar.dmX) {
                                        i = aVar.mMinDuration + aVar.dmX;
                                        pK = aVar.dne.mo30920pK(i);
                                    }
                                    aVar.dnd.setmRightPos(pK);
                                    aVar.dmY = i;
                                    aVar.m20510da(aVar.dmX, aVar.dmY);
                                }
                            } else if (aVar.dnd.isPlaying()) {
                                int gi = aVar.mo30897gi(true);
                                int gi2 = aVar.mo30897gi(false);
                                if (i < gi) {
                                    aVar.dnd.setmOffset(0);
                                } else if (i > gi2) {
                                    aVar.dnd.setmOffset(aVar.dnd.getmRightPos() - aVar.dnd.getmLeftPos());
                                } else {
                                    aVar.dnd.setmOffset(aVar.dne.mo30921pL(i - gi));
                                }
                            }
                            aVar.dnd.invalidate();
                            break;
                        }
                        break;
                    case 302:
                        aVar.dmX = aVar.mo30897gi(true);
                        aVar.dmY = aVar.mo30897gi(false);
                        if (aVar.dnd != null) {
                            aVar.dnd.setLeftMessage(C4580b.m11665ih(aVar.dmX));
                            aVar.dnd.setRightMessage(C4580b.m11665ih(aVar.dmY));
                        }
                        if (aVar.dna != null) {
                            aVar.dna.setText(C4580b.m11665ih(aVar.dmY - aVar.dmX));
                        }
                        if (aVar.dne != null) {
                            if (!aVar.dne.atS()) {
                                if (aVar.dnb != null) {
                                    aVar.dnb.setVisibility(0);
                                }
                                if (aVar.dnc != null) {
                                    aVar.dnc.setVisibility(0);
                                    aVar.dnc.setText(aVar.btV.getResources().getString(R.string.xiaoying_str_ve_pip_file_count_limit_tip, new Object[]{new C9006a(aVar.btV.getResources(), 0, aVar.dne.atQ()).aNq()}));
                                    break;
                                }
                            } else {
                                if (aVar.dnb != null) {
                                    aVar.dnb.setVisibility(4);
                                }
                                if (aVar.dnc != null) {
                                    aVar.dnc.setVisibility(4);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.videotrim.ui.a$b */
    public interface C7009b {
        /* renamed from: i */
        void mo27404i(boolean z, int i);

        /* renamed from: iD */
        void mo27405iD(int i);

        /* renamed from: kA */
        void mo27406kA(int i);

        /* renamed from: ky */
        void mo27407ky(int i);

        /* renamed from: kz */
        void mo27408kz(int i);
    }

    public C7005a(View view, QClip qClip, int i) {
        this.btV = view;
        VePIPGallery vePIPGallery = (VePIPGallery) this.btV.findViewById(R.id.gallery_timeline);
        this.dnd = (TrimMaskView4Import) this.btV.findViewById(R.id.xiaoying_ve_trimmaskview);
        this.dnd.setbCenterAlign(true);
        this.dne = new C7010b(qClip, vePIPGallery, i);
        this.dnd.setmGalleryItemHeight(C7010b.cuf);
        this.dnd.setmChildHeight(C7010b.cuf);
    }

    /* access modifiers changed from: private */
    public void atI() {
        this.dnd.setLeftMessage(C4580b.m11665ih(mo30897gi(true)));
        this.dnd.setRightMessage(C4580b.m11665ih(mo30897gi(false)));
    }

    /* access modifiers changed from: private */
    /* renamed from: da */
    public void m20510da(int i, int i2) {
        this.dmV = i2 - i;
        if (this.dmV > this.dne.atQ()) {
            this.dmV = this.dne.atQ();
        }
        this.dnd.setLeftMessage(C4580b.m11665ih(i));
        this.dnd.setRightMessage(C4580b.m11665ih(i2));
        this.dna.setText(C4580b.m11665ih(this.dmV));
    }

    private void initUI() {
        this.dna = (TextView) this.btV.findViewById(R.id.txtview_trimed_duration);
        this.dnb = (TextView) this.btV.findViewById(R.id.xiaoying_ve_txtview_pip_trim_tip);
        this.dnc = (TextView) this.btV.findViewById(R.id.xiaoying_ve_txtview_pip_duration_limit_tip);
        if (this.dnd != null) {
            this.dnd.setmOnOperationListener(this.dng);
            if (!this.dne.atS()) {
                int atM = this.dne.atM();
                this.dnd.setmMinLeftPos(C4583d.m11671P(dmU));
                this.dnd.setmLeftPos(C4583d.m11671P(dmU));
                this.dnd.setmMaxRightPos(C4583d.m11671P(dmU) + atM);
                this.dnd.setmRightPos(C4583d.m11671P(dmU) + atM);
            } else {
                int atM2 = this.dne.atM();
                int i = (Constants.getScreenSize().width - atM2) / 2;
                this.dnd.setmMinLeftPos(i);
                this.dnd.setmLeftPos(i);
                int i2 = i + atM2;
                this.dnd.setmMaxRightPos(i2);
                this.dnd.setmRightPos(i2);
            }
            this.dnd.setmMinDistance((int) (((float) this.mMinDuration) / this.dne.atP()));
        }
        this.mHandler.sendEmptyMessageDelayed(302, 300);
    }

    /* renamed from: E */
    public void mo30891E(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateProgress time=");
        sb.append(i);
        LogUtils.m14223i("AdvanceTrimPanel", sb.toString());
        Message obtainMessage = this.mHandler.obtainMessage(HttpStatus.SC_MOVED_PERMANENTLY);
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = z ? 1 : 0;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    public void mo30892a(C7009b bVar) {
        this.cts = bVar;
    }

    public boolean atH() {
        return this.dnd != null && this.dnd.atT();
    }

    public int atJ() {
        return this.dmX;
    }

    public int atK() {
        if (this.dmY <= 0) {
            this.dmY = mo30897gi(false);
        }
        return this.dmY;
    }

    public void destroy() {
        if (this.dne != null) {
            this.dne.destroy();
        }
    }

    /* renamed from: gi */
    public int mo30897gi(boolean z) {
        int i = z ? this.dnd.getmLeftPos() : this.dnd.getmRightPos();
        int F = (!this.dnd.atU() || z) ? this.dne.mo30902F(i, true) : this.dmX + this.mMinDuration;
        StringBuilder sb = new StringBuilder();
        sb.append("getCurTime bLeft=");
        sb.append(z);
        sb.append(";curTime=");
        sb.append(F);
        sb.append(";position=");
        sb.append(i);
        LogUtils.m14223i("AdvanceTrimPanel", sb.toString());
        return F;
    }

    /* renamed from: hr */
    public void mo30898hr(boolean z) {
        if (this.dnd != null) {
            this.dnd.setPlaying(z);
        }
    }

    public boolean load() {
        initUI();
        this.dne.mo30904a(this.dnf);
        this.dne.mo30919pI(this.dnd.getmMinLeftPos());
        this.dmV = this.dne.atQ();
        return true;
    }

    /* renamed from: pH */
    public void mo30900pH(int i) {
        this.mMinDuration = i;
    }
}
