package com.introvd.template.router.community;

import android.app.Activity;
import com.aiii.android.arouter.facade.C1941a;
import com.introvd.template.router.BaseRouter;

public class VivaCommunityRouter extends BaseRouter {
    public static final String COMMUNITY_TODO_INTERCEPTOR = "/VivaCommunity/todoInterceptor";
    public static final String PROXY_APPLICATION = "/VivaCommunity/application";
    public static final String PROXY_MAIN_ACTIVITY = "/VivaCommunity/main_activity";
    public static final String PROXY_USER_LIFECYCLE = "/VivaCommunity/user_lifecycle";
    public static final String ROUTER_GROUP = "/VivaCommunity/";

    public class ActivityVideoCardListPagePrams {
        public static final String INTENT_KEY_ACTIVITY_ID = "intent_extra_key_activity_id";
        public static final String INTENT_KEY_ACTIVITY_TITLE = "intent_extra_key_title";
        public static final String INTENT_KEY_FROM_TODO_CODE = "intent_key_from_todo_code";
        public static final String URL = "/VivaCommunity/activityvideocardlist";

        public ActivityVideoCardListPagePrams() {
        }
    }

    public class ActivityVideoDetailActivityParams {
        public static final String EXTRA_ACTIVITY_ID = "extra_activity_id";
        public static final String URL = "/VivaCommunity/XYActivityVideoListActivityNew/entry";

        public ActivityVideoDetailActivityParams() {
        }
    }

    public class BlackListActivityParams {
        public static final String URL = "/VivaCommunity/XYBlackListActivity/entry";

        public BlackListActivityParams() {
        }
    }

    public class FeedVideoActivityParams {
        public static final String EXTRA_RESULT_FOCUS_POS = "extra_result_focus_pos";
        public static final String EXTRA_SHOW_COMMENT = "extra_show_comment";
        public static final String EXTRA_SHOW_COMMENT_DATA = "extra_show_comment_data";
        public static final String EXTRA_VIDEO_DATA_REFRESH = "extra_video_data_refresh";
        public static final String EXTRA_VIDEO_FROM_1205 = "extra_video_from_1205";
        public static final String EXTRA_VIDEO_HASHTAG_SEARCH_TYPE = "extra_video_hashtag_search_type";
        public static final String EXTRA_VIDEO_IS_CONTAIN_UPLOAD = "extra_video_is_contain_upload";
        public static final String EXTRA_VIDEO_PAGE_FROM = "extra_video_page_from";
        public static final String EXTRA_VIDEO_PAGE_FROM_EXTRA_STR = "extra_video_page_from_extra_str";
        public static final String EXTRA_VIDEO_PAGE_FROM_SECONDARYTAB = "extra_video_page_from_secondarytab";
        public static final String EXTRA_VIDEO_POSITION = "extra_video_position";
        public static final String EXTRA_VIDEO_SCROLL_ID = "extra_video_scroll_id";
        public static final String EXTRA_VIDEO_TYPE_ACTIVITYID = "extra_video_type_activityid";
        public static final String EXTRA_VIDEO_TYPE_HASHTAG = "extra_video_type_hashtag";
        public static final String EXTRA_VIDEO_TYPE_HOT = "extra_video_type_hot";
        public static final String EXTRA_VIDEO_TYPE_LBS_JSON = "extra_video_type_lbs_json";
        public static final String EXTRA_VIDEO_TYPE_LIKEDVIDEO = "extra_video_type_likedvideo";
        public static final String EXTRA_VIDEO_TYPE_MULTI_JSON = "extra_video_type_multi_json";
        public static final String EXTRA_VIDEO_TYPE_SINGLE_JSON = "extra_video_type_single_json";
        public static final String EXTRA_VIDEO_TYPE_SLIDE_JSON = "extra_video_type_slide_json";
        public static final String EXTRA_VIDEO_TYPE_TOPIC_JSON = "extra_video_type_topic_json";
        public static final String EXTRA_VIDEO_TYPE_USERID = "extra_video_type_userid";
        public static final String URL = "/VivaCommunity/FeedVideoActivity/entry";

        public FeedVideoActivityParams() {
        }
    }

    public class GdprPrivacyPageParams {
        public static final String INTENT_KEY_SETTING_MODE = "intent_key_setting_mode";
        public static final String URL = "/VivaCommunity/GdprPrivacyActivity/entry";

        public GdprPrivacyPageParams() {
        }
    }

    public class HashtagVideoCardListPagePrams {
        public static final String INTENT_KEY_FROM_TODO_CODE = "intent_key_from_todo_code";
        public static final String INTENT_KEY_HASHTAG = "intent_extra_key_search_words";
        public static final String URL = "/VivaCommunity/hashtagvideocardlist";

        public HashtagVideoCardListPagePrams() {
        }
    }

    public class MixGoThingActivityParams {
        public static final String URL = "/VivaCommunity/MixGoThingActivity/entry";

        public MixGoThingActivityParams() {
        }
    }

    public class NearByGridVideoActivityParams {
        public static final String URL = "/VivaCommunity/NearByGridActivity/entry";

        public NearByGridVideoActivityParams() {
        }
    }

    public class RcVideoListActivityParams {
        public static final String EXTRA_VIDEO_PLAY_INTENT_INFO = "extra_video_play_intent_info";
        public static final int REQUEST_CODE_VIDEO_PLAY = 6145;
        public static final String RESULT_EXTRA_PLAY_POSITION = "result_extra_play_position";
        public static final String URL = "/VivaCommunity/RcVideoListActivity/entry";

        public RcVideoListActivityParams() {
        }
    }

    public class RecommendTagUserPageParams {
        public static final String URL = "/VivaCommunity/RecommendTagUserPage/entry";

        public RecommendTagUserPageParams() {
        }
    }

    public class RegisterFollowsPageParams {
        public static final String URL = "/VivaCommunity/RegisterFollowsPage/entry";

        public RegisterFollowsPageParams() {
        }
    }

    public class SearchVideoListActivityParams {
        public static final String EXTRA_VIDEO_ACTIVITY_ID = "extra_video_activity_id";
        public static final String EXTRA_VIDEO_TAG = "extra_video_tag";
        public static final String URL = "/VivaCommunity/SearchVideoListActivity/entry";

        public SearchVideoListActivityParams() {
        }
    }

    public class TopUserActivityPrams {
        public static final String EXTRA_MODULE_ID = "extra_module_id";
        public static final String EXTRA_TITLE = "extra_title";
        public static final String URL = "/VivaCommunity/TopUserActivity/entry";

        public TopUserActivityPrams() {
        }
    }

    public class UserAvatarLargePagePrams {
        public static final String INTENT_KEY_AVATAR_URL = "intent_key_avatar_url";
        public static final String URL = "/VivaCommunity/UserAvatarLargeActivity/entry";

        public UserAvatarLargePagePrams() {
        }
    }

    public class UserFollowListPrams {
        public static final int CONTACTS_MODE_FANS = 1;
        public static final int CONTACTS_MODE_FOLLOWS = 2;
        public static final String EXTRA_MODE = "extra_mode";
        public static final String EXTRA_USERID = "extra_userid";
        public static final String URL = "/VivaCommunity/UserFollowListActivity/entry";

        public UserFollowListPrams() {
        }
    }

    public class UserHomePageParams {
        public static final String EXTRA_TYPE_FROM = "extra_type_from";
        public static final String EXTRA_USER_AUID = "extra_user_auid";
        public static final String EXTRA_USER_NAME = "extra_user_name";
        public static final String URL = "/VivaCommunity/UserHomePage/entry";

        public UserHomePageParams() {
        }
    }

    public class UserOwnHomeParams {
        public static final String EXTRA_TYPE_FROM = "extra_type_from";
        public static final String URL = "/VivaCommunity/UserOwnPage/entry";

        public UserOwnHomeParams() {
        }
    }

    public class VideoDetailActivityParam {
        public static final String EXTRA_AUTO_JUMPTO_COMMENT = "extra_auto_jumpto_comment";
        public static final String EXTRA_AUTO_SHOW_COMMENT_VIEW = "extra_auto_show_comment_view";
        public static final String EXTRA_KEY_INFO_SOURCE = "extra_key_info_source";
        public static final String EXTRA_KEY_INFO_SOURCE_EXTRA = "extra_key_info_source_extra";
        public static final String EXTRA_RECOMMEND_TRACEID = "extra_key_recommend_traceid";
        public static final String EXTRA_VIDEO_PLAY_POSITION = "extra_key_video_play_position";
        public static final String EXTRA_VIDEO_PUID = "extra_video_puid";
        public static final String EXTRA_VIDEO_PVER = "extra_video_pver";
        public static final String URL = "/VivaCommunity/VideoDetailActivity/entry";

        public VideoDetailActivityParam() {
        }
    }

    public class VideoPlayerActivityParams {
        public static final String EXTRA_IGNORE_LOGIN = "extra_ignore_login";
        public static final String EXTRA_INTENT_TYPE = "extra_intent_type";
        public static final String EXTRA_VIDEO_PLAY_INTENT_INFO = "extra_video_play_intent_info";
        public static final int REQUEST_CODE_VIDEO_PLAY = 4097;
        public static final String URL = "/VivaCommunity/VideoPlayerActivity/entry";

        public VideoPlayerActivityParams() {
        }
    }

    public class WhatsAppParams {
        public static final String GALLERY_URL = "/VivaCommunity/gallery";
        public static final String INTENT_EXTRA_KEY_WHATSAPP_POSITION = "intent_extra_key_position";
        public static final String INTENT_EXTRA_KEY_WHATSAPP_SINGLE_FLAG = "intent_extra_key_single_flag";
        public static final String VIDEOPLAY_URL = "/VivaCommunity/whatsapp/videoplay";

        public WhatsAppParams() {
        }
    }

    public class XYMessagePrams {
        public static final String MESSAGE_AT_URL = "/VivaCommunity/MessageAtActivity/entry";
        public static final String MESSAGE_COMMENT_URL = "/VivaCommunity/MessageCommentActivity/entry";
        public static final String MESSAGE_DETAIL_URL = "/VivaCommunity/XiaoYingMessageDetailActivity/entry";
        public static final String MESSAGE_FANS_URL = "/VivaCommunity/MessageFansActivity/entry";
        public static final String MESSAGE_FOLLOW_URL = "/VivaCommunity/XYMessageFollowActivity/entry";
        public static final String MESSAGE_LIKED_URL = "/VivaCommunity/MessageLikedActivity/entry";
        public static final String MESSAGE_URL = "/VivaCommunity/XYMessageActivity/entry";

        public XYMessagePrams() {
        }
    }

    public static void launchRecommendTagUserPage(Activity activity, int i, int i2, int i3) {
        C1941a routerBuilder = getRouterBuilder(activity.getApplication(), RecommendTagUserPageParams.URL);
        if (!(i2 == 0 || i3 == 0)) {
            routerBuilder.mo10394aZ(i2, i3);
        }
        if (i != 0) {
            routerBuilder.mo10396b(activity, i);
        } else {
            routerBuilder.mo10382H(activity);
        }
    }

    public static void launchRegisterFollowsPage(Activity activity, int i) {
        C1941a routerBuilder = getRouterBuilder(activity.getApplication(), RegisterFollowsPageParams.URL);
        if (i != 0) {
            routerBuilder.mo10396b(activity, i);
        } else {
            routerBuilder.mo10382H(activity);
        }
    }
}
