package com.introvd.template.router.community;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.support.p021v4.app.DialogFragment;
import android.support.p021v4.app.Fragment;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.community.publish.PublishProjectInfo;
import com.introvd.template.router.todoCode.TODOParamModel;

public interface ICommunityService extends C1949c {
    public static final String URL = "/VivaCommunity/CommunityService";

    DialogFragment createCloseServiceTipDialog(OnDismissListener onDismissListener);

    Fragment createFindViewPagerFragment();

    Fragment createMessageFragment();

    Fragment createStudioFragment();

    boolean executeTodo(Activity activity, TODOParamModel tODOParamModel);

    PublishProjectInfo getPublishProjectInfoByPrjId(long j);

    void refreshFragmentData(Fragment fragment);

    void stopAllPublish(Context context);

    void updatePublishProjectInfo(PublishProjectInfo publishProjectInfo);
}
