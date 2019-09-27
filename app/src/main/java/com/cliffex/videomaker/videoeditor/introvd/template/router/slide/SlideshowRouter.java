package com.introvd.template.router.slide;

import android.app.Activity;
import android.os.Parcelable;
import aoptest.chandler.com.vivarouter.R;
import com.aiii.android.arouter.facade.C1941a;
import com.introvd.template.router.BaseRouter;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.parammodels.PickCoverParams;
import java.util.ArrayList;

public class SlideshowRouter extends BaseRouter {
    public static final String KEY_INTENT_APPLY_THEME_ID = "key_intent_apply_theme_id";
    public static final String KEY_INTENT_AUTO_PLAY = "key_intent_auto_play";
    public static final String KEY_INTENT_PREVIEW_AUTOPLAY = "key_intent_preview_autoplay";
    public static final String KEY_INTENT_PRJ_NEW_FLAG = "key_intent_prj_new_flag";
    public static final String KEY_INTENT_PRJ_SLIDE = "key_intent_prj_slide";
    public static final String KEY_INTENT_PUBLISH_TAG = "key_intent_publish_tag";
    public static final String KEY_INTENT_SLIDE_FILE_MODEL_LIST = "key_intent_slide_file_model_list";
    public static final String URL_COVER = "/Slide/Cover";
    public static final String URL_EDITOR = "/Story/Editor";
    public static final String URL_PREVIEW = "/Story/Preview";
    public static final String URL_PUBLISH = "/Slidee/Publish";
    public static final String URL_SLIDE_EDITOR = "/Slide/Editor";

    public static void launchSlideAfterFilePrepared(Activity activity, Parcelable parcelable, ArrayList<? extends Parcelable> arrayList) {
        getRouterBuilder(activity.getApplication(), URL_SLIDE_EDITOR).mo10387a(CommonParams.INTENT_KEY_TODOPARAM_MODEL, parcelable).mo10389a(KEY_INTENT_SLIDE_FILE_MODEL_LIST, arrayList).mo10391a(KEY_INTENT_PRJ_NEW_FLAG, true).mo10391a(KEY_INTENT_AUTO_PLAY, true).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchSlideEdit(Activity activity, Parcelable parcelable) {
        getRouterBuilder(activity.getApplication(), URL_SLIDE_EDITOR).mo10387a(CommonParams.INTENT_KEY_TODOPARAM_MODEL, parcelable).mo10391a(KEY_INTENT_PRJ_NEW_FLAG, true).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchSlideEdit(Activity activity, boolean z) {
        getRouterBuilder(activity.getApplication(), URL_SLIDE_EDITOR).mo10391a(KEY_INTENT_PREVIEW_AUTOPLAY, z).mo10391a(KEY_INTENT_PRJ_NEW_FLAG, false).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchSlideEditForTest(Activity activity, long j) {
        getRouterBuilder(activity.getApplication(), URL_SLIDE_EDITOR).mo10386a(KEY_INTENT_APPLY_THEME_ID, j).mo10391a(KEY_INTENT_PRJ_NEW_FLAG, true).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchSlideshowCover(Activity activity, boolean z, String str, long j, int i) {
        getRouterBuilder(activity.getApplication(), URL_COVER).mo10391a(KEY_INTENT_PRJ_SLIDE, z).mo10399f(PickCoverParams.ACTIVITY_COVER_PICK_RESULT_KEY, str).mo10386a(PickCoverParams.ACTIVITY_COVER_PICK_TIME_POSITION_KEY, j).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10396b(activity, i);
    }

    public static void launchSlideshowEdit(Activity activity, Parcelable parcelable) {
        getRouterBuilder(activity.getApplication(), URL_EDITOR).mo10387a(CommonParams.INTENT_KEY_TODOPARAM_MODEL, parcelable).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchSlideshowPreview(Activity activity, boolean z) {
        getRouterBuilder(activity.getApplication(), URL_PREVIEW).mo10391a(KEY_INTENT_PREVIEW_AUTOPLAY, z).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }

    public static void launchSlideshowPublish(Activity activity, boolean z, String str, long j) {
        C1941a routerBuilder = getRouterBuilder(activity.getApplication(), URL_PUBLISH);
        if (str != null) {
            routerBuilder.mo10399f(KEY_INTENT_PUBLISH_TAG, str);
        }
        routerBuilder.mo10386a(KEY_INTENT_APPLY_THEME_ID, j).mo10391a(KEY_INTENT_PRJ_SLIDE, z).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10382H(activity);
    }
}
