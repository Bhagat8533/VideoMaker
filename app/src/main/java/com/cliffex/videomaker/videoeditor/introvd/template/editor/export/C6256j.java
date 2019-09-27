package com.introvd.template.editor.export;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.app.FragmentManager;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.editor.export.j */
public class C6256j implements Callback {
    private static final C6256j cPG = new C6256j();
    final Map<FragmentManager, ExportVideoFragment> cPH = new HashMap();
    private final Handler handler = new Handler(Looper.getMainLooper(), this);

    C6256j() {
    }

    public static C6256j alM() {
        return cPG;
    }

    @TargetApi(17)
    /* renamed from: aq */
    private static boolean m17932aq(Activity activity) {
        return VERSION.SDK_INT < 17 || !activity.isDestroyed();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo29181a(FragmentActivity fragmentActivity, FragmentManager fragmentManager, long j, long j2, boolean z) {
        if (((ExportVideoFragment) fragmentManager.findFragmentByTag("com.xiaoying.export.video")) == null && ((ExportVideoFragment) this.cPH.get(fragmentManager)) == null) {
            ExportVideoFragment exportVideoFragment = new ExportVideoFragment();
            if (exportVideoFragment.mo29059a(fragmentActivity, j2, j, z)) {
                this.cPH.put(fragmentManager, exportVideoFragment);
                fragmentManager.beginTransaction().add((Fragment) exportVideoFragment, "com.xiaoying.export.video").commitAllowingStateLoss();
                this.handler.obtainMessage(2, fragmentManager).sendToTarget();
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo29182b(FragmentActivity fragmentActivity, long j, long j2, boolean z) {
        if (!m17932aq(fragmentActivity)) {
            return false;
        }
        return mo29181a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), j, j2, z);
    }

    /* renamed from: g */
    public ExportVideoFragment mo29183g(FragmentActivity fragmentActivity) {
        if (!m17932aq(fragmentActivity)) {
            return null;
        }
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        ExportVideoFragment exportVideoFragment = (ExportVideoFragment) supportFragmentManager.findFragmentByTag("com.xiaoying.export.video");
        if (exportVideoFragment == null) {
            exportVideoFragment = (ExportVideoFragment) this.cPH.get(supportFragmentManager);
        }
        return exportVideoFragment;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 2) {
            return false;
        }
        this.cPH.remove((FragmentManager) message.obj);
        return true;
    }
}
