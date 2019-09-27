package com.introvd.template.camera.base;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.introvd.template.camera.p229b.C4999g;
import com.introvd.template.camera.p232e.C5041h;
import com.introvd.template.common.MSize;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.template.p409g.C8759b;

public abstract class AbstractCameraView extends RelativeLayout {
    /* access modifiers changed from: protected */
    public Handler bLS;
    /* access modifiers changed from: protected */
    public C5041h bMf;
    /* access modifiers changed from: protected */
    public C4999g bOs;
    /* access modifiers changed from: protected */
    public C8759b bOt;
    /* access modifiers changed from: protected */
    public C5021a bOu = null;

    /* renamed from: com.introvd.template.camera.base.AbstractCameraView$a */
    public interface C5021a {
        /* renamed from: iG */
        void mo25709iG(int i);
    }

    public AbstractCameraView(Context context) {
        super(context);
    }

    /* renamed from: SY */
    public abstract void mo25791SY();

    /* renamed from: Ts */
    public abstract void mo25792Ts();

    /* renamed from: Uj */
    public abstract void mo25793Uj();

    /* renamed from: Uk */
    public abstract void mo25794Uk();

    /* renamed from: Ul */
    public abstract boolean mo25795Ul();

    /* renamed from: Um */
    public abstract void mo25796Um();

    /* renamed from: Un */
    public abstract void mo25797Un();

    /* renamed from: Uo */
    public abstract void mo25798Uo();

    /* renamed from: Up */
    public abstract void mo25799Up();

    /* renamed from: Uq */
    public abstract boolean mo25800Uq();

    /* renamed from: a */
    public abstract void mo25801a(Long l, int i);

    /* renamed from: b */
    public abstract void mo25802b(RelativeLayout relativeLayout);

    /* renamed from: b */
    public abstract void mo25803b(MusicDataItem musicDataItem);

    /* renamed from: ck */
    public void mo25804ck(View view) {
        if (view != null && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    /* renamed from: cm */
    public abstract void mo25805cm(boolean z);

    public C4999g getCameraMusicMgr() {
        return this.bOs;
    }

    public abstract View getTopIndicatorView();

    /* renamed from: iF */
    public abstract void mo25808iF(int i);

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    /* renamed from: p */
    public abstract boolean mo25812p(MotionEvent motionEvent);

    public void setCallbackHandler(Handler handler) {
        this.bLS = handler;
    }

    public void setCameraMusicMgr(C4999g gVar) {
        this.bOs = gVar;
    }

    public abstract void setClipCount(int i, boolean z);

    public abstract void setCurrentTimeValue(long j);

    public abstract void setEffect(int i, boolean z, boolean z2, boolean z3);

    public abstract void setEffectMgr(C8759b bVar);

    public void setSoundPlayer(C5041h hVar) {
        this.bMf = hVar;
    }

    public abstract void setState(int i, MSize mSize);

    public abstract void setTimeExceed(boolean z);

    public abstract void setZoomValue(double d);

    public void setmModeChooseListener(C5021a aVar) {
        this.bOu = aVar;
    }
}
