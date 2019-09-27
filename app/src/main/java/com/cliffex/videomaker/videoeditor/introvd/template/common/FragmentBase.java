package com.introvd.template.common;

import android.app.Activity;
import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.common.callback.ResultCallback;
import com.introvd.template.router.app.ANRServiceProxy;
import com.vivavideo.component.crash.C9287h;
import java.lang.reflect.Field;

public class FragmentBase extends Fragment {
    protected boolean mbFirstOnResume = true;
    protected ResultCallback resultCallback;

    public void onActivityCreated(Bundle bundle) {
        LogUtilsV2.m14227d("=======onActivityCreated");
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        LogUtilsV2.m14227d("=======onAttach");
        super.onAttach(activity);
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("=======onCreate");
        LogUtilsV2.m14227d(sb.toString());
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogUtilsV2.m14227d("=======onCreateView");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        LogUtilsV2.m14227d("=======onDestroy");
        super.onDestroy();
    }

    public void onDestroyView() {
        LogUtilsV2.m14227d("=======onDestroyView");
        super.onDestroyView();
    }

    public void onDetach() {
        LogUtilsV2.m14227d("=======onDetach");
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onFirstResume() {
    }

    public boolean onKeyUp() {
        return false;
    }

    public void onPause() {
        LogUtilsV2.m14227d("=======onPause");
        super.onPause();
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("-onPause->");
        C9287h.offerLifeCycleQueue(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("-onPause->");
        ANRServiceProxy.offerLifeCycleQueue(sb2.toString());
    }

    public void onResume() {
        LogUtilsV2.m14227d("=======onResume");
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("-onResume- first = ");
        sb.append(this.mbFirstOnResume);
        sb.append("->");
        C9287h.offerLifeCycleQueue(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("-onResume- first = ");
        sb2.append(this.mbFirstOnResume);
        sb2.append("->");
        ANRServiceProxy.offerLifeCycleQueue(sb2.toString());
        if (this.mbFirstOnResume) {
            onFirstResume();
            this.mbFirstOnResume = false;
        }
        super.onResume();
    }

    public void onStart() {
        LogUtilsV2.m14227d("=======onStart");
        super.onStart();
    }

    public void onStop() {
        LogUtilsV2.m14227d("=======onStop");
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("-onStop->");
        C9287h.offerLifeCycleQueue(sb.toString());
        super.onStop();
    }

    public void setFragmentParams(Object... objArr) {
    }

    public void setResultCallback(ResultCallback resultCallback2) {
        this.resultCallback = resultCallback2;
    }
}
