package com.introvd.template.starvlogs.logfirebase;

import android.app.Activity;

public class ActionFirebaseStarVlogs {
    public static void actionSplashActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_splash", "action_onCreate", "onCreate Splash Activity");
    }

    public static void actionWelcomeActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_welcome", "action_onCreate", "onCreate Welcome Activity");
    }

    public static void actionCheckingActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_checking", "action_onCreate", "onCreate Checking Activity");
    }

    public static void actionErrorActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_error", "action_onCreate", "onCreate Error Activity");
    }

    public static void actionClickSelfieCamera(Activity activity) {
        LogFirebase.logEvent(activity, "activity_main", "onClick", "click_btn_sefile");
    }

    public static void actionClickThemesActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_main", "onClick", "click_btn_themes");
    }

    public static void actionClickMyStudioActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_main", "onClick", "click_btn_my_studio");
    }

    public static void actionClickRecorderActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_main", "onClick", "click_btn_recorder");
    }

    public static void actionClickCreateVideoActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_main", "onClick", "click_btn_create");
    }

    public static void actionClickEditActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_main", "onClick", "click_btn_edit");
    }

    public static void actionClickButtonAdsMain(Activity activity) {
        LogFirebase.logEvent(activity, "activity_main", "onClick", "onClick_btn_ads");
    }

    public static void actionClickSupportMe(Activity activity) {
        LogFirebase.logEvent(activity, "activity_main", "onClick", "onClick_btn_suport_me");
    }

    public static void actionTemplateCateActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_template_category", "activity_template_category", "onCreate");
    }

    public static void actionTemplateInfoActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_template_info", "activity_template_info", "onCreate");
    }

    public static void actionSefieCameraActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_camera_selfie", "activity_camera_selfie", "onCreate");
    }

    public static void actionEditorPreview(Activity activity) {
        LogFirebase.logEvent(activity, "activity_editor_preview", "activity_editor_preview", "onCreate");
    }

    public static void actionPublishActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_publish", "activity_publish", "onCreate");
    }

    public static void actionResultActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_result", "activity_result", "onCreate");
    }

    public static void actionMyStudioActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_my_studio", "activity_my_studio", "onCreate");
    }

    public static void actionVideoEditorActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_video_editor", "activity_video_editor", "onCreate");
    }

    public static void actionGalleryActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_gallery", "activity_gallery", "onCreate");
    }

    public static void actionVideoTrimActivity(Activity activity) {
        LogFirebase.logEvent(activity, "activity_video_trim", "activity_video_trim", "onCreate");
    }
}
