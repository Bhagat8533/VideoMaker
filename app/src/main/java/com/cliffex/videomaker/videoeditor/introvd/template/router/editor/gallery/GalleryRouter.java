package com.introvd.template.router.editor.gallery;

import android.app.Activity;
import android.os.Parcelable;
import aoptest.chandler.com.vivarouter.R;
import com.introvd.template.router.BaseRouter;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import java.util.ArrayList;

public class GalleryRouter extends BaseRouter {
    public static final int ACTIVITY_REQUEST_CODE_PREVIEW = 4097;
    public static final String EXTRA_INTENT_MODE_KEY = "extra_intent_mode_key";
    public static final String GALLERY_EXTRA_INTENT_ACTION = "gallery_extra_intent_action";
    public static final String GALLERY_GROUP = "/gallery/";
    public static final String GALLERY_SELF_GROUP = "/gallerySelf/";
    public static final String GALLERY_TODO_INTERCEPTOR = "/gallerySelf/todoInterceptor";
    public static final String INTENT_DATA_BACK_KEY = "intent_data_return_key";
    public static final int INTENT_EDIT_MODE_GIFMAKER = 2004;
    public static final int INTENT_EDIT_MODE_MEME = 2002;
    public static final int INTENT_EDIT_MODE_TRANSFORM = 2001;
    public static final int INTENT_EDIT_MODE_TRIM = 2003;
    public static final String INTENT_KEY_TEMPLATE_ID = "key_template_id";
    public static final String INTENT_OUTPUT_PATH = "output";
    public static final String INTENT_PATH_KEY = "file_path";
    public static final String INTENT_POSITION_KEY = "item_position";
    public static final String PROXY_MAIN_APP = "/gallerySelf/GalleryAppLifeCycle";
    public static final int REQUEST_IMPORT_EXT_FILE = 8193;
    public static final int REQUEST_IMPORT_SINGLE_FILE = 8194;
    public static final String URL = "/gallery/entry";
    private static GalleryRouter instance;
    private static boolean isNewVersion;

    private GalleryRouter() {
    }

    public static GalleryRouter getInstance() {
        if (instance == null) {
            instance = new GalleryRouter();
        }
        return instance;
    }

    public void init(boolean z) {
        isNewVersion = z;
    }

    public void launchActivity(Activity activity, String str, int i) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), isNewVersion ? URL : MediaGalleryRouter.URL).mo10399f(PassThoughUrlGenerator.EXTRA_PASS_THROUGH_URL, str).mo10394aZ(R.anim.activity_enter_hold, R.anim.activity_enter_hold).mo10396b(activity, i);
        }
    }

    public void launchExtraIntentGallery(Activity activity, int i, int i2, long j, ArrayList<String> arrayList, Parcelable parcelable) {
        int i3;
        int i4;
        if (activity != null) {
            GalleryIntentInfo build = new Builder().setSourceMode(1).setMagicCode(j).setExtraIntentMode(i2).setInputPathList(arrayList).build();
            EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
            editorIntentInfo.baseMode = 0;
            switch (i2) {
                case 2001:
                    i3 = 1;
                    i4 = 1005;
                    break;
                case 2002:
                    i3 = 2;
                    i4 = 2002;
                    break;
                default:
                    i3 = 1;
                    i4 = -1;
                    break;
            }
            editorIntentInfo.tabType = i3;
            editorIntentInfo.secondaryMode = i4;
            launchActivity(activity, PassThoughUrlGenerator.generateUrl(isNewVersion ? URL : MediaGalleryRouter.URL, build, editorIntentInfo), -1);
        }
    }

    public void launchGalleryActivity(Activity activity, int i, Object... objArr) {
        if (activity != null) {
            launchActivity(activity, PassThoughUrlGenerator.generateUrl(isNewVersion ? URL : MediaGalleryRouter.URL, objArr), i);
        }
    }

    public void launchPIPVideoPicker(Activity activity, boolean z, int i) {
        if (activity != null) {
            long longExtra = activity.getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
            String str = isNewVersion ? URL : MediaGalleryRouter.URL;
            int i2 = 1;
            Object[] objArr = new Object[1];
            Builder magicCode = new Builder().setSourceMode(0).setMagicCode(longExtra);
            if (z) {
                i2 = 4;
            }
            objArr[0] = magicCode.setAction(i2).setNewPrj(false).build();
            launchActivity(activity, PassThoughUrlGenerator.generateUrl(str, objArr), i);
        }
    }

    public void launchPhotoEdit(Activity activity, Parcelable parcelable, String str) {
        if (activity != null) {
            launchActivity(activity, PassThoughUrlGenerator.generateUrl(isNewVersion ? URL : MediaGalleryRouter.URL, new Builder().setSourceMode(2).setNewPrj(true).setActivityId(str).setMagicCode(activity.getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0)).build(), parcelable), -1);
        }
    }

    public void launchSlideSpecificPicker(Activity activity, Parcelable parcelable, int i, int i2, int i3) {
        if (activity != null) {
            getRouterBuilder(activity.getApplication(), isNewVersion ? URL : MediaGalleryRouter.URL).mo10399f(PassThoughUrlGenerator.EXTRA_PASS_THROUGH_URL, PassThoughUrlGenerator.generateUrl(isNewVersion ? URL : MediaGalleryRouter.URL, new Builder().setSourceMode(2).setAction(10).setMinRangeCount(i).setLimitRangeCount(i2).setNewPrj(false).build())).mo10387a(CommonParams.INTENT_KEY_TODOPARAM_MODEL, parcelable).mo10406h(MediaGalleryRouter.INTENT_KEY_VIDEO_DURATION_LIMIT, i3).mo10394aZ(R.anim.activity_enter_hold, R.anim.activity_enter_hold).mo10382H(activity);
        }
    }

    public void launchSlideshowPicker(Activity activity, ArrayList<? extends Parcelable> arrayList, boolean z, int i, int i2) {
        if (activity != null) {
            String str = isNewVersion ? URL : MediaGalleryRouter.URL;
            Object[] objArr = new Object[1];
            objArr[0] = new Builder().setSourceMode(z ? 2 : 0).setAction(5).setLimitRangeCount(i).setMinRangeCount(i).setNewPrj(false).build();
            getRouterBuilder(activity.getApplication(), isNewVersion ? URL : MediaGalleryRouter.URL).mo10399f(PassThoughUrlGenerator.EXTRA_PASS_THROUGH_URL, PassThoughUrlGenerator.generateUrl(str, objArr)).mo10389a(MediaGalleryRouter.INTENT_TRIM_RANGE_LIST_KEY, arrayList).mo10406h(MediaGalleryRouter.INTENT_KEY_VIDEO_DURATION_LIMIT, i2).mo10394aZ(R.anim.activity_enter_hold, R.anim.activity_enter_hold).mo10396b(activity, 36865);
        }
    }

    public void launchVideoEdit(Activity activity, Parcelable parcelable, String str) {
        if (activity != null) {
            launchActivity(activity, PassThoughUrlGenerator.generateUrl(isNewVersion ? URL : MediaGalleryRouter.URL, new Builder().setSourceMode(0).setNewPrj(true).setActivityId(str).setMagicCode(activity.getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0)).build(), parcelable), -1);
        }
    }
}
