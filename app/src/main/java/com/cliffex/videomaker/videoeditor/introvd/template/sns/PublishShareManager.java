package com.introvd.template.sns;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.introvd.template.p414ui.dialog.C8945c;
import com.introvd.template.p414ui.dialog.C8945c.C8948b;
import com.introvd.template.p414ui.dialog.C8957e;
import com.quvideo.sns.base.C4987e;
import java.io.File;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

public class PublishShareManager {
    private static List<ResolveInfo> VIDEOSHAREACTIVITYS;

    public interface ShareMoreListener {
        void onAppClick(ResolveInfo resolveInfo);
    }

    public static List<ResolveInfo> getFilterEmailActivity(Activity activity) {
        return activity.getPackageManager().queryIntentActivities(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:")), 65536);
    }

    private static List<String> getFilterPkgList(Activity activity) {
        List<String> b = C4987e.m12739b(activity.getApplicationContext(), new int[]{28, 26, 31, 38, 33, 32});
        List filterEmailActivity = getFilterEmailActivity(activity);
        for (int i = 0; i < filterEmailActivity.size(); i++) {
            ResolveInfo resolveInfo = (ResolveInfo) filterEmailActivity.get(i);
            if (resolveInfo != null) {
                b.add(resolveInfo.activityInfo.packageName);
            }
        }
        return b;
    }

    public static List<ResolveInfo> getVideoShareResolveInfos(Activity activity) {
        if (VIDEOSHAREACTIVITYS == null) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("video/*");
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File("")));
                VIDEOSHAREACTIVITYS = activity.getPackageManager().queryIntentActivities(intent, 65536);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return VIDEOSHAREACTIVITYS;
    }

    public static void showShareMore(Activity activity, final ShareMoreListener shareMoreListener) {
        final List d = C8957e.m26317d(getVideoShareResolveInfos(activity), getFilterPkgList(activity));
        C8945c cVar = new C8945c(activity, C8957e.m26314a(d, activity.getPackageManager()), new C8948b() {
            public void buttonClick(int i) {
            }

            public void itemClick(int i) {
                if (shareMoreListener != null) {
                    shareMoreListener.onAppClick((ResolveInfo) d.get(i));
                }
            }
        });
        cVar.setButtonText(C10122R.string.xiaoying_str_com_cancel);
        cVar.mo31986Q(Integer.valueOf(C10122R.string.xiaoying_str_com_forward_to));
        cVar.show();
    }
}
