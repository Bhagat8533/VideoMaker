package com.introvd.template.router.community;

import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.community.publish.PublishProjectInfo;

public class CommunityServiceProxy {
    public static PublishProjectInfo getPublishProjectInfoByPrjId(long j) {
        ICommunityService iCommunityService = (ICommunityService) BizServiceManager.getService(ICommunityService.class);
        if (iCommunityService != null) {
            return iCommunityService.getPublishProjectInfoByPrjId(j);
        }
        return null;
    }

    public static void updatePublishProjectInfo(PublishProjectInfo publishProjectInfo) {
        ICommunityService iCommunityService = (ICommunityService) BizServiceManager.getService(ICommunityService.class);
        if (iCommunityService != null) {
            iCommunityService.updatePublishProjectInfo(publishProjectInfo);
        }
    }
}
