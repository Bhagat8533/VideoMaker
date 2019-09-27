package com.introvd.template.router.lifecycle;

import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Context;
import android.support.p021v4.app.FragmentActivity;
import android.util.Log;
import com.aiii.android.arouter.facade.template.C1949c;

public abstract class BaseMainActivityLifeCycle implements C0068f, C1949c {
    protected FragmentActivity mActivity;

    public FragmentActivity getActivity() {
        return this.mActivity;
    }

    public final void init(Context context) {
    }

    public void init(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
    }

    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onCreate() {
        String str = BizAppLifeCycleManager.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onCreate");
        Log.d(str, sb.toString());
    }

    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onDestroy() {
        String str = BizAppLifeCycleManager.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onDestroy");
        Log.d(str, sb.toString());
    }

    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onPause() {
        String str = BizAppLifeCycleManager.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onPause");
        Log.d(str, sb.toString());
    }

    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onResume() {
        String str = BizAppLifeCycleManager.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onResume");
        Log.d(str, sb.toString());
    }

    @C0078n(mo161n = C0062a.ON_STOP)
    public void onStop() {
        String str = BizAppLifeCycleManager.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" onStop");
        Log.d(str, sb.toString());
    }
}
