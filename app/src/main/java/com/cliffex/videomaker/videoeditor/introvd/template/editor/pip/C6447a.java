package com.introvd.template.editor.pip;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.pip.TrimMaskView.C6446a;
import com.introvd.template.editor.videotrim.p292ui.C7010b;
import com.introvd.template.editor.videotrim.p292ui.C7010b.C7015c;
import com.introvd.template.editor.videotrim.p292ui.VePIPGallery;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.PIPItemInfo;
import com.introvd.template.sdk.utils.p394b.C8537n;
import java.lang.ref.WeakReference;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.clip.QSceneClip;

/* renamed from: com.introvd.template.editor.pip.a */
public class C6447a {
    /* access modifiers changed from: private */
    public View btV;
    /* access modifiers changed from: private */
    public C6452b cWL = null;
    /* access modifiers changed from: private */
    public TextView cWQ;
    /* access modifiers changed from: private */
    public TrimMaskView cWR;
    /* access modifiers changed from: private */
    public C7010b cWS;
    /* access modifiers changed from: private */
    public C7010b cWT;
    /* access modifiers changed from: private */
    public PIPItemInfo[] cWU = null;
    /* access modifiers changed from: private */
    public int cWV = 0;
    /* access modifiers changed from: private */
    public int cWW = Constants.getScreenSize().width;
    private boolean cWX = true;
    /* access modifiers changed from: private */
    public boolean cWY = false;
    private Range cWZ = new Range();
    private Range cXa = new Range();
    /* access modifiers changed from: private */
    public int cXb = 0;
    /* access modifiers changed from: private */
    public int cXc = 0;
    private C7015c cXd = new C7015c() {
        private boolean cXg = true;
        private boolean cXh = false;

        public void anY() {
            StringBuilder sb = new StringBuilder();
            sb.append("onGalleryMoveStart bScrollLeft=");
            sb.append(this.cXg);
            LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb.toString());
            if (C6447a.this.cWR != null) {
                C6447a.this.cWR.setPlaying(false);
            }
            if (C6447a.this.cWL != null) {
                C6447a.this.cWL.mo29532x(true, true);
            }
        }

        public void anZ() {
            StringBuilder sb = new StringBuilder();
            sb.append("onGalleryMoveStop bScrollLeft=");
            sb.append(this.cXg);
            LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb.toString());
            if (C6447a.this.cWL != null) {
                C6447a.this.cWL.mo29528ky(C6447a.this.cWS.mo30902F(C6447a.this.cWR.getmLeftPos(), false));
            }
            C6447a.this.m18623l(true, C6447a.this.cWS.atR());
            C6447a.this.m18623l(false, C6447a.this.cWS.act());
            C6447a.this.cXb = C6447a.this.anV();
            C6447a.this.cXc = C6447a.this.anW();
            C6447a.this.anQ();
        }

        /* renamed from: nY */
        public void mo29618nY(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onGalleryMoving moveDist=");
            sb.append(i);
            LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb.toString());
            if (i < 0 && !this.cXg) {
                this.cXg = true;
                if (C6447a.this.cXb > 1) {
                    C6447a.this.m18616gj(this.cXg);
                }
                this.cXh = false;
                if (C6447a.this.cWL != null) {
                    C6447a.this.cWL.mo29527ge(true);
                }
            } else if (i > 0 && this.cXg) {
                this.cXg = false;
                if (C6447a.this.cXb == 1 || C6447a.this.cXb == 3) {
                    C6447a.this.m18616gj(this.cXg);
                }
            }
            if (this.cXg) {
                C6447a.this.m18623l(this.cXg, C6447a.this.cWS.atR());
            } else {
                boolean a = C6447a.this.m18623l(this.cXg, C6447a.this.cWS.act());
                if (!this.cXh && a) {
                    this.cXh = true;
                    if (C6447a.this.cWL != null) {
                        C6447a.this.cWL.mo29527ge(false);
                    }
                }
            }
            if (C6447a.this.cWL == null) {
                return;
            }
            if (this.cXh) {
                C6447a.this.cWL.mo29531nV(C6447a.this.cWT.mo30902F(C6447a.this.cWR.getmLeftPos(), false));
                return;
            }
            C6447a.this.cWL.mo29531nV(C6447a.this.cWS.mo30902F(C6447a.this.cWR.getmLeftPos(), false));
        }
    };
    private C7015c cXe = new C7015c() {
        private boolean cXg = true;
        private boolean cXh = false;

        public void anY() {
            if (C6447a.this.cWR != null) {
                C6447a.this.cWR.setPlaying(false);
            }
            if (C6447a.this.cWL != null) {
                C6447a.this.cWL.mo29532x(true, false);
            }
        }

        public void anZ() {
            if (C6447a.this.cWL != null) {
                C6447a.this.cWL.mo29528ky(C6447a.this.cWT.mo30902F(C6447a.this.cWR.getmLeftPos(), false));
            }
            C6447a.this.m18623l(true, C6447a.this.cWT.atR());
            C6447a.this.m18623l(false, C6447a.this.cWT.act());
            C6447a.this.cXb = C6447a.this.anV();
            C6447a.this.cXc = C6447a.this.anW();
            C6447a.this.anQ();
        }

        /* renamed from: nY */
        public void mo29618nY(int i) {
            if (i < 0 && !this.cXg) {
                this.cXg = true;
                if (C6447a.this.cXc > 1) {
                    C6447a.this.m18617gk(this.cXg);
                }
                this.cXh = false;
                if (C6447a.this.cWL != null) {
                    C6447a.this.cWL.mo29527ge(false);
                }
            } else if (i > 0 && this.cXg) {
                this.cXg = false;
                if (C6447a.this.cXc == 1 || C6447a.this.cXc == 3) {
                    C6447a.this.m18617gk(this.cXg);
                }
            }
            if (this.cXg) {
                C6447a.this.m18623l(this.cXg, C6447a.this.cWT.atR());
            } else {
                boolean a = C6447a.this.m18623l(this.cXg, C6447a.this.cWT.act());
                if (!this.cXh && a) {
                    this.cXh = true;
                    if (C6447a.this.cWL != null) {
                        C6447a.this.cWL.mo29527ge(true);
                    }
                }
            }
            if (C6447a.this.cWL == null) {
                return;
            }
            if (this.cXh) {
                C6447a.this.cWL.mo29531nV(C6447a.this.cWS.mo30902F(C6447a.this.cWR.getmLeftPos(), false));
                return;
            }
            C6447a.this.cWL.mo29531nV(C6447a.this.cWT.mo30902F(C6447a.this.cWR.getmLeftPos(), false));
        }
    };
    private C6446a cXf = new C6446a() {
        private boolean cXj = false;

        /* renamed from: m */
        private void m18636m(boolean z, int i) {
            if (z) {
                if (C6447a.this.cWS != null) {
                    int act = C6447a.this.cWS.act();
                    if (i < act) {
                        C6447a.this.cWY = true;
                        C6447a.this.cWS.mo30922pM(i - act);
                    }
                }
                if (C6447a.this.cWT != null) {
                    int act2 = C6447a.this.cWT.act();
                    if (i < act2) {
                        C6447a.this.cWY = true;
                        C6447a.this.cWT.mo30922pM(i - act2);
                        return;
                    }
                    return;
                }
                return;
            }
            if (C6447a.this.cWS != null) {
                int atR = C6447a.this.cWS.atR();
                if (i > atR) {
                    C6447a.this.cWY = true;
                    C6447a.this.cWS.mo30922pM(i - atR);
                }
            }
            if (C6447a.this.cWT != null) {
                int atR2 = C6447a.this.cWT.atR();
                if (i > atR2) {
                    C6447a.this.cWY = true;
                    C6447a.this.cWT.mo30922pM(i - atR2);
                }
            }
        }

        public void aoa() {
            Context context = C6447a.this.btV.getContext();
            ToastUtils.show(context, context.getResources().getString(R.string.xiaoying_str_ve_pip_trim_duration_tip2, new Object[]{Integer.valueOf(1)}), 0);
        }

        /* renamed from: eH */
        public void mo29591eH(boolean z) {
            if (C6447a.this.cWR != null) {
                C6447a.this.cWR.setPlaying(false);
            }
            this.cXj = z;
            if (C6447a.this.cWL != null) {
                C6447a.this.cWL.mo29532x(false, z);
            }
            if (C6447a.this.cWR == null) {
                return;
            }
            if (z) {
                if (C6447a.this.cWR.getmLeftPos() == C6447a.this.anN()) {
                    C6447a.this.cWR.setmMinLeftPos(C6447a.this.cWV);
                    C6447a.this.cWR.setmMinLeftPos4Fake(C6447a.this.anN());
                    return;
                }
                C6447a.this.cWR.setmMinLeftPos(C6447a.this.anN());
            } else if (C6447a.this.cWR.getmRightPos() == C6447a.this.anO()) {
                C6447a.this.cWR.setmMaxRightPos(C6447a.this.cWW);
                C6447a.this.cWR.setmMaxRightPos4Fake(C6447a.this.anO());
            } else {
                C6447a.this.cWR.setmMaxRightPos(C6447a.this.anO());
            }
        }

        /* renamed from: ky */
        public void mo29592ky(int i) {
            if (C6447a.this.cWS != null) {
                m18636m(this.cXj, i);
                Message obtainMessage = C6447a.this.mHandler.obtainMessage(501);
                obtainMessage.arg1 = i;
                obtainMessage.arg2 = this.cXj ^ true ? 1 : 0;
                C6447a.this.mHandler.sendMessageDelayed(obtainMessage, 30);
            }
        }

        /* renamed from: lJ */
        public void mo29593lJ(int i) {
            if (C6447a.this.cWL != null) {
                int F = C6447a.this.cWS.mo30902F(C6447a.this.anN(), false);
                C6447a.this.cWL.mo29529lJ(C6447a.this.cWS.mo30902F(i, false) - F);
            }
        }

        /* renamed from: ls */
        public void mo29594ls(int i) {
            if (C6447a.this.cWL != null) {
                int F = C6447a.this.cWS.mo30902F(C6447a.this.anN(), false);
                C6447a.this.cWL.mo29530ls(C6447a.this.cWS.mo30902F(i, false) - F);
            }
        }

        /* renamed from: nZ */
        public void mo29595nZ(int i) {
            if (C6447a.this.cWL != null) {
                int F = C6447a.this.cWS.mo30902F(C6447a.this.anN(), false);
                C6447a.this.cWL.mo29531nV(C6447a.this.cWS.mo30902F(i, false) - F);
            }
            C6447a.this.anX();
        }
    };
    /* access modifiers changed from: private */
    public Handler mHandler = new C6451a(this);

    /* renamed from: com.introvd.template.editor.pip.a$a */
    private static class C6451a extends Handler {
        WeakReference<C6447a> cuV;

        public C6451a(C6447a aVar) {
            this.cuV = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C6447a aVar = (C6447a) this.cuV.get();
            if (aVar != null) {
                int i = 0;
                switch (message.what) {
                    case HttpStatus.SC_MOVED_PERMANENTLY /*301*/:
                        if (aVar.cWR != null) {
                            int i2 = message.arg1;
                            Range anR = aVar.anR();
                            int i3 = anR.getmPosition();
                            int limitValue = anR.getLimitValue();
                            if (i2 < i3) {
                                aVar.cWR.setmOffset(0);
                            } else if (i2 > limitValue) {
                                aVar.cWR.setmOffset(aVar.cWR.getmRightPos() - aVar.cWR.getmLeftPos());
                            } else {
                                aVar.cWR.setmOffset(aVar.cWS.mo30921pL(i2 - i3));
                            }
                            aVar.cWR.invalidate();
                            break;
                        }
                        break;
                    case 302:
                        Range anR2 = aVar.anR();
                        if (anR2 == null) {
                            if (aVar.cWU[0] != null) {
                                i = aVar.cWU[0].getmSrcDuration();
                            }
                            aVar.cWQ.setText(C4580b.m11637V((long) i));
                            break;
                        } else {
                            aVar.cWQ.setText(C4580b.m11637V((long) anR2.getmTimeLength()));
                            break;
                        }
                    case 401:
                        if (!(aVar.cWU == null || aVar.cWU[1] == null || aVar.cWT == null)) {
                            int pK = aVar.cWT.mo30920pK(aVar.cWU[1].getmRange().getmPosition());
                            int i4 = aVar.cWR.getmLeftPos();
                            int atO = aVar.cWR.getmLeftPos() - aVar.cWS.atO();
                            aVar.cWS.mo30923q(true, atO);
                            aVar.cWT.mo30923q(true, atO);
                            int atO2 = aVar.cWR.getmRightPos() - aVar.cWS.atO();
                            aVar.cWS.mo30923q(false, atO2);
                            aVar.cWT.mo30923q(false, atO2 + aVar.cWT.atN());
                            aVar.cWT.mo30922pM(i4 - pK);
                            sendEmptyMessageDelayed(HttpStatus.SC_PAYMENT_REQUIRED, 10);
                            break;
                        }
                    case HttpStatus.SC_PAYMENT_REQUIRED /*402*/:
                        aVar.cXb = aVar.anV();
                        aVar.cXc = aVar.anW();
                        if (aVar.cWL != null) {
                            aVar.cWL.anL();
                            break;
                        }
                        break;
                    case 501:
                        int i5 = message.arg1;
                        boolean z = message.arg2 <= 0;
                        if (aVar.cWL != null) {
                            aVar.cWL.mo29528ky(aVar.cWS.mo30902F(i5, false) - aVar.cWS.mo30902F(aVar.anN(), false));
                        }
                        if (z) {
                            int atO3 = i5 - aVar.cWS.atO();
                            aVar.cWS.mo30923q(true, atO3);
                            if (aVar.cWT != null) {
                                aVar.cWT.mo30923q(true, atO3);
                            }
                        } else {
                            int atO4 = i5 - aVar.cWS.atO();
                            aVar.cWS.mo30923q(false, atO4);
                            if (aVar.cWT != null) {
                                aVar.cWT.mo30923q(false, atO4 + aVar.cWT.atN());
                            }
                        }
                        aVar.cXb = aVar.anV();
                        aVar.cXc = aVar.anW();
                        Range anR3 = aVar.anR();
                        if (anR3 != null) {
                            aVar.cWQ.setText(C4580b.m11637V((long) anR3.getmTimeLength()));
                        }
                        aVar.anQ();
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.pip.a$b */
    public interface C6452b {
        void anL();

        /* renamed from: ge */
        void mo29527ge(boolean z);

        /* renamed from: ky */
        void mo29528ky(int i);

        /* renamed from: lJ */
        void mo29529lJ(int i);

        /* renamed from: ls */
        void mo29530ls(int i);

        /* renamed from: nV */
        void mo29531nV(int i);

        /* renamed from: x */
        void mo29532x(boolean z, boolean z2);
    }

    public C6447a(View view, QSceneClip qSceneClip) throws Exception {
        this.btV = view;
        VePIPGallery vePIPGallery = (VePIPGallery) this.btV.findViewById(R.id.gallery_timeline);
        VePIPGallery vePIPGallery2 = (VePIPGallery) this.btV.findViewById(R.id.xiaoying_ve_pip_gallery_timeline);
        this.cWU = C8537n.m24820c(qSceneClip);
        if (this.cWU != null && this.cWU.length == 2 && this.cWU[0] != null) {
            int i = this.cWU[0].getmSrcDuration();
            if (i > 0) {
                if (this.cWU[0] != null) {
                    this.cWS = new C7010b(this.cWU[0], vePIPGallery, i);
                    this.cWS.setmItemIndex(this.cWU[0].getmItemIndex());
                }
                if (this.cWU[1] == null || this.cWU[0] == null) {
                    throw new Exception("State is wrong");
                }
                this.cWT = new C7010b(this.cWU[1], vePIPGallery2, i);
                this.cWT.setmItemIndex(this.cWU[1].getmItemIndex());
            }
            this.cWR = (TrimMaskView) this.btV.findViewById(R.id.xiaoying_ve_trimmaskview);
            this.cWR.setmGalleryContentHeight(10.0f);
            this.cWR.setmGalleryMaskHeight(64.67f);
            this.cWR.setbMaskFullScreenMode(false);
            this.cWR.setbCenterAlign(true);
        }
    }

    /* access modifiers changed from: private */
    public int anN() {
        if (this.cWS == null || this.cWT == null) {
            return 0;
        }
        int act = this.cWS.act();
        int act2 = this.cWT.act();
        if (act < act2) {
            act = act2;
        }
        if (act < this.cWV) {
            act = this.cWV;
        }
        return act;
    }

    /* access modifiers changed from: private */
    public int anO() {
        if (this.cWS == null || this.cWT == null) {
            return 0;
        }
        int atR = this.cWS.atR();
        int atR2 = this.cWT.atR();
        if (atR > atR2) {
            atR = atR2;
        }
        if (atR > this.cWW) {
            atR = this.cWW;
        }
        return atR;
    }

    /* access modifiers changed from: private */
    public void anX() {
        Range anR = anR();
        if (anR != null) {
            this.cWQ.setText(C4580b.m11637V((long) anR.getmTimeLength()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gj */
    public void m18616gj(boolean z) {
        if (z) {
            int i = this.cWR.getmLeftPos();
            this.cWS.mo30923q(true, i - this.cWS.atO());
            this.cWS.mo30923q(false, (i + this.cWR.getmMinDistance()) - this.cWS.atO());
            return;
        }
        this.cWS.mo30923q(true, (this.cWR.getmRightPos() - this.cWR.getmMinDistance()) - this.cWS.atO());
        this.cWS.mo30923q(false, this.cWR.getmRightPos() - this.cWS.atO());
    }

    /* access modifiers changed from: private */
    /* renamed from: gk */
    public void m18617gk(boolean z) {
        if (z) {
            int i = this.cWR.getmLeftPos();
            this.cWT.mo30923q(true, i - this.cWS.atO());
            this.cWT.mo30923q(false, ((i + this.cWR.getmMinDistance()) - this.cWS.atO()) + this.cWT.atN());
            return;
        }
        this.cWT.mo30923q(true, (this.cWR.getmRightPos() - this.cWR.getmMinDistance()) - this.cWS.atO());
        this.cWT.mo30923q(false, (this.cWR.getmRightPos() - this.cWS.atO()) + this.cWT.atN());
    }

    private void initUI() {
        if (this.btV != null) {
            this.cWQ = (TextView) this.btV.findViewById(R.id.txtview_trimed_duration);
            if (!(this.cWR == null || this.cWU == null || this.cWU.length != 2 || this.cWU[0] == null)) {
                VeRange veRange = this.cWU[0].getmRange();
                this.cWR.setmOnOperationListener(this.cXf);
                int atM = this.cWS.atM();
                this.cWV = (Constants.getScreenSize().width - atM) / 2;
                this.cWW = this.cWV + atM;
                this.cWR.setmMinLeftPos(this.cWV);
                this.cWR.setmLeftPos(this.cWV + this.cWS.mo30921pL(veRange.getmPosition()));
                this.cWR.setmMaxRightPos(this.cWW);
                this.cWR.setmRightPos(this.cWV + this.cWS.mo30921pL(veRange.getLimitValue()));
                this.cWR.setmMinDistance((int) (1000.0f / this.cWS.atP()));
            }
            this.mHandler.sendEmptyMessageDelayed(302, 100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean m18623l(boolean z, int i) {
        if (z) {
            if (this.cWR.getmRightPos() > i) {
                this.cWR.setmRightPos(i);
                this.cWR.invalidate();
                anX();
                return true;
            }
        } else if (this.cWR.getmLeftPos() < i) {
            this.cWR.setmLeftPos(i);
            this.cWR.invalidate();
            anX();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo29596a(C6452b bVar) {
        this.cWL = bVar;
    }

    public void anM() {
        if (this.cWS != null && this.cWT != null) {
            int i = this.cWS.getmItemIndex();
            this.cWS.setmItemIndex(this.cWT.getmItemIndex());
            this.cWT.setmItemIndex(i);
        }
    }

    public boolean anP() {
        return this.cWX;
    }

    public void anQ() {
        if (this.cWR != null && this.cWT != null && this.cWS != null) {
            int i = this.cWR.getmLeftPos();
            int i2 = this.cWR.getmRightPos();
            int F = this.cWS.mo30902F(i, false);
            int F2 = this.cWS.mo30902F(i2, false);
            this.cWZ.setmPosition(F);
            int i3 = F2 - F;
            int F3 = this.cWT.mo30902F(i, false);
            int F4 = this.cWT.mo30902F(i2, false);
            this.cXa.setmPosition(F3);
            int i4 = F4 - F3;
            this.cXa.setmTimeLength(i4 > i3 ? i3 : i4);
            Range range = this.cWZ;
            if (i4 > i3) {
                i4 = i3;
            }
            range.setmTimeLength(i4);
        }
    }

    public Range anR() {
        Range range = new Range();
        if (this.cWS != null) {
            int F = this.cWS.mo30902F(anN(), false);
            int F2 = this.cWS.mo30902F(this.cWR.getmLeftPos(), false) - F;
            int F3 = this.cWS.mo30902F(this.cWR.getmRightPos(), false) - F;
            range.setmPosition(F2);
            range.setmTimeLength(F3 - F2);
        }
        return range;
    }

    public Range anS() {
        return this.cWZ;
    }

    public Range anT() {
        return this.cXa;
    }

    public boolean anU() {
        boolean z = this.cWY;
        this.cWY = false;
        return z;
    }

    public int anV() {
        if (this.cWS == null) {
            return 0;
        }
        int act = this.cWS.act();
        int i = this.cWR.getmLeftPos();
        int atR = this.cWS.atR();
        int i2 = this.cWR.getmRightPos();
        StringBuilder sb = new StringBuilder();
        sb.append("prepareBaseGalleryLimitOffset leftPos=");
        sb.append(act);
        sb.append(";leftTrimPos=");
        sb.append(i);
        sb.append(";rightPos=");
        sb.append(atR);
        sb.append(";rightTrimPos=");
        sb.append(i2);
        LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb.toString());
        boolean z = act == i;
        boolean z2 = atR == i2;
        int atO = this.cWS.atO();
        if (z && z2) {
            this.cWS.mo30923q(true, (i - atO) + 30);
            this.cWS.mo30923q(false, (i2 - atO) - 30);
            return 3;
        } else if (z2) {
            this.cWS.mo30923q(true, i - atO);
            this.cWS.mo30923q(false, (i + this.cWR.getmMinDistance()) - atO);
            return 2;
        } else if (z) {
            this.cWS.mo30923q(false, i2 - atO);
            this.cWS.mo30923q(true, (i2 - this.cWR.getmMinDistance()) - atO);
            return 1;
        } else {
            this.cWS.mo30923q(true, i - atO);
            this.cWS.mo30923q(false, i2 - atO);
            return 0;
        }
    }

    public int anW() {
        if (this.cWT == null) {
            return 0;
        }
        int act = this.cWT.act();
        int i = this.cWR.getmLeftPos();
        int atR = this.cWT.atR();
        int i2 = this.cWR.getmRightPos();
        StringBuilder sb = new StringBuilder();
        sb.append("prepareLongGalleryLimitOffset leftPos=");
        sb.append(act);
        sb.append(";leftTrimPos=");
        sb.append(i);
        sb.append(";rightPos=");
        sb.append(atR);
        sb.append(";rightTrimPos=");
        sb.append(i2);
        LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb.toString());
        int atN = this.cWT.atN();
        boolean z = act == i;
        boolean z2 = atR == i2;
        int atO = this.cWS.atO();
        if (z && z2) {
            this.cWT.mo30923q(true, (i - atO) + 30);
            this.cWT.mo30923q(false, ((i2 - atO) + atN) - 30);
            return 3;
        } else if (z2) {
            this.cWT.mo30923q(true, i - atO);
            this.cWT.mo30923q(false, ((i + this.cWR.getmMinDistance()) - atO) + atN);
            return 2;
        } else if (z) {
            this.cWT.mo30923q(false, (i2 - atO) + atN);
            this.cWT.mo30923q(true, (i2 - this.cWR.getmMinDistance()) - atO);
            return 1;
        } else {
            this.cWT.mo30923q(true, i - atO);
            this.cWT.mo30923q(false, (i2 - atO) + atN);
            return 0;
        }
    }

    public void destroy() {
        if (this.cWS != null) {
            this.cWS.destroy();
        }
        if (this.cWT != null) {
            this.cWT.destroy();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        this.cWR = null;
        this.btV = null;
        this.cWL = null;
        this.cWU = null;
    }

    /* renamed from: gf */
    public void mo29607gf(boolean z) {
        this.cWX = z;
    }

    /* renamed from: gg */
    public int mo29608gg(boolean z) {
        int i;
        if (z) {
            if (this.cWS != null) {
                i = this.cWS.getmItemIndex();
                StringBuilder sb = new StringBuilder();
                sb.append("getGalleryElementIndex bBase =");
                sb.append(z);
                sb.append(";index=");
                sb.append(i);
                LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb.toString());
                return i;
            }
        } else if (this.cWT != null) {
            i = this.cWT.getmItemIndex();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getGalleryElementIndex bBase =");
            sb2.append(z);
            sb2.append(";index=");
            sb2.append(i);
            LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb2.toString());
            return i;
        }
        i = -1;
        StringBuilder sb22 = new StringBuilder();
        sb22.append("getGalleryElementIndex bBase =");
        sb22.append(z);
        sb22.append(";index=");
        sb22.append(i);
        LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb22.toString());
        return i;
    }

    /* renamed from: gh */
    public Range mo29609gh(boolean z) {
        Range range = new Range();
        int i = 0;
        if (z) {
            if (this.cWS != null) {
                int F = this.cWS.mo30902F(anN(), false);
                int F2 = this.cWS.mo30902F(anO(), false);
                if (F < 0) {
                    C5839a.m16330eA(VivaBaseApplication.m8749FZ());
                } else {
                    i = F;
                }
                range.setmPosition(i);
                range.setmTimeLength(F2 - i);
            }
        } else if (this.cWT != null) {
            int F3 = this.cWT.mo30902F(anN(), false);
            int F4 = this.cWT.mo30902F(anO(), false);
            if (F3 < 0) {
                C5839a.m16330eA(VivaBaseApplication.m8749FZ());
            } else {
                i = F3;
            }
            range.setmPosition(i);
            range.setmTimeLength(F4 - i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getGalleryAvailRange bBase =");
        sb.append(z);
        sb.append(";range=");
        sb.append(range);
        LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb.toString());
        return range;
    }

    /* renamed from: gi */
    public int mo29610gi(boolean z) {
        int i = this.cWR.getmLeftPos();
        return z ? this.cWS.mo30902F(i, false) : this.cWT.mo30902F(i, false);
    }

    public boolean load() {
        if (this.cWU != null && this.cWU.length == 2) {
            initUI();
            if (this.cWS != null) {
                this.cWS.mo30904a(this.cXd);
                this.cWS.mo30918hs(true);
                this.cWS.mo30919pI(this.cWR.getmMinLeftPos());
            }
            if (this.cWT != null) {
                this.cWT.mo30904a(this.cXe);
                this.cWT.mo30918hs(true);
                this.cWT.mo30919pI(this.cWR.getmMinLeftPos());
            }
            this.mHandler.sendEmptyMessageDelayed(401, 100);
        }
        return true;
    }

    /* renamed from: nW */
    public void mo29612nW(int i) {
        this.cXb = i;
    }

    /* renamed from: nX */
    public void mo29613nX(int i) {
        this.cXc = i;
    }

    public void setPlaying(boolean z) {
        if (this.cWR != null) {
            this.cWR.setPlaying(z);
        }
    }

    public void updateProgress(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateProgress time=");
        sb.append(i);
        LogUtils.m14223i("AdvancePIPMultiTrimPanel", sb.toString());
        Message obtainMessage = this.mHandler.obtainMessage(HttpStatus.SC_MOVED_PERMANENTLY);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }
}
