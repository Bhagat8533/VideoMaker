package com.introvd.template.router.community;

public class PublishParams {

    public class DomeSocialPublishParams {
        public static final String PARAMS_KEY_IS_FROM_SOCIAL = "params_key_is_from_social";
        public static final String PARAMS_KEY_IS_SLIDE_SHOW_VIDEO = "params_key_is_slide_show_video";
        public static final String URL = "/publish/domesocial";

        public DomeSocialPublishParams() {
        }
    }

    public class TanabataPublishParams {
        public static final String KEY_INTENT_ACTIVITY_TAG = "key_intent_activity_tag";
        public static final String URL = "/publish/tanabata";

        public TanabataPublishParams() {
        }
    }

    public class WhatsAppsPublishActivityParam {
        public static final String INTENT_DURATION = "intent_duration";
        public static final String INTENT_POSITION = "intent_position";
        public static final String INTENT_THUMBNAIL_PATH = "intent_thumbnail_path";
        public static final String INTENT_VIDEO_HEIGHT = "intent_height";
        public static final String INTENT_VIDEO_PATH = "intent_video_path";
        public static final String INTENT_VIDEO_WIDTH = "intent_width";
        public static final String URL = "/publish/WhatsAppsPublishActivity";

        public WhatsAppsPublishActivityParam() {
        }
    }

    public class XYActivityPublishActivityParam {
        public static final String ACTIVITY_TYPE = "ActivityType";
        public static final String ACTIVITY_VIDEO_PATH = "activity_video_path";
        public static final String URL = "/publish/XYActivityPublishActivity";
        public static final String VIDEOTHUMB = "videothumb";

        public XYActivityPublishActivityParam() {
        }
    }
}
