package com.introvd.template.editor.base;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.common.utils.UtilsDevice;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6279a;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p259f.C6282d;
import com.introvd.template.editor.p266h.C6396h;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.editor.provider.C6708c;
import com.vivavideo.component.crash.C9287h;
import java.lang.ref.WeakReference;

public abstract class BaseOperationView<T extends C5686a> extends RelativeLayout implements C0068f {
    private Bundle bundle;
    /* access modifiers changed from: protected */
    public WeakReference<Activity> bwg;
    protected C6499a cyB;
    /* access modifiers changed from: protected */
    public C6279a cyC;
    protected T cyD;
    protected boolean cyE = false;
    protected boolean cyF;
    private boolean cyG = false;

    public BaseOperationView(Activity activity, Class<T> cls) {
        super(activity);
        if (activity != null) {
            this.bwg = new WeakReference<>(activity);
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
            try {
                this.cyD = (C5686a) cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("OperationView :");
            sb.append(this);
            sb.append(" ,just not attached to Host Activity");
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public void mo27806C(MotionEvent motionEvent) {
    }

    /* access modifiers changed from: protected */
    public boolean aeA() {
        if (this.cyD instanceof C5896a) {
            return ((C5896a) this.cyD).aiw();
        }
        return false;
    }

    public void aeB() {
        String ac = C6396h.m18391ac(getContext(), C6708c.m19490oV(C5843c.agO().agS()));
        if (ac != null) {
            C5554b.m15029e(getContext(), ac, aeA());
        }
    }

    /* access modifiers changed from: protected */
    public boolean aeC() {
        return this.cyG;
    }

    public void aex() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onViewCreated");
        LogUtilsV2.m14227d(sb.toString());
    }

    public boolean aey() {
        return false;
    }

    public void aez() {
    }

    /* access modifiers changed from: protected */
    public void exit() {
        aeB();
        if (this.cyC != null) {
            this.cyC.mo27783I(-1, false);
        }
        this.cyG = true;
    }

    /* access modifiers changed from: protected */
    public void exit(boolean z) {
        aeB();
        if (this.cyC != null) {
            this.cyC.mo27783I(-1, z);
        }
        this.cyG = true;
    }

    /* access modifiers changed from: protected */
    public void finish() {
        aeB();
        if (this.cyC != null) {
            this.cyC.mo27783I(-1, false);
        }
        this.cyG = true;
        this.cyD.mo27869ep(getContext().getApplicationContext());
    }

    public final Activity getActivity() {
        if (this.bwg == null) {
            return null;
        }
        return (Activity) this.bwg.get();
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public T getEditor() {
        return this.cyD;
    }

    public C5688b getFineTuningListener() {
        return null;
    }

    public abstract int getLayoutId();

    public int getPlayerInitTime() {
        return 0;
    }

    public C6280b getPlayerStatusListener() {
        return null;
    }

    public int getStreamType() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public float getTouchViewHeight() {
        return (float) C5840b.cEx;
    }

    public C6282d getVideoControlListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public C6499a getVideoOperator() {
        return this.cyB;
    }

    public int getViewHeight() {
        return aey() ? C5840b.cEy : C5840b.cEx;
    }

    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onActivityCreate() {
    }

    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onActivityDestroy() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onActivityDestroy");
        LogUtilsV2.m14227d(sb.toString());
        setVideoOperateHandler(null);
        setActivityListener(null);
    }

    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onActivityPause() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onActivityPause");
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("-onActivityPause->");
        C9287h.offerLifeCycleQueue(sb2.toString());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" requestCode=");
        sb.append(i);
        sb.append(",resultCode=");
        sb.append(i2);
        LogUtilsV2.m14227d(sb.toString());
    }

    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onActivityResume() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onActivityResume");
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("-onActivityResume");
        C9287h.offerLifeCycleQueue(sb2.toString());
    }

    @C0078n(mo161n = C0062a.ON_STOP)
    public void onActivityStop() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onActivityStop");
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("-onActivityStop->");
        C9287h.offerLifeCycleQueue(sb2.toString());
    }

    public boolean onBackPressed() {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getActivity() == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.cyF) {
            return !this.cyE;
        }
        float rawY = motionEvent.getRawY();
        if (NotchUtil.isNotchDevice()) {
            rawY -= (float) UtilsDevice.getStatusBarHeight(getContext());
        }
        if (rawY - ((float) (getActivity().findViewById(16908290).getMeasuredHeight() - Constants.getScreenSize().height)) > ((float) Constants.getScreenSize().height) - getTouchViewHeight()) {
            return true;
        }
        if (aey()) {
            mo27806C(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setActivityListener(C6279a aVar) {
        this.cyC = aVar;
    }

    public void setBundle(Bundle bundle2) {
        this.bundle = bundle2;
    }

    public void setLock(boolean z) {
        this.cyE = z;
        if (z) {
            setEnabled(false);
        } else {
            setEnabled(true);
        }
    }

    public void setVideoOperateHandler(C6499a aVar) {
        this.cyB = aVar;
        if (this.cyD != null) {
            this.cyD.mo27849a(aVar);
        }
    }
}
