package com.introvd.template.router.community.event;

public class MessageTipsEvent {
    public int messageTipsCount;
    public boolean needShowFollowVideoTips;
    public boolean needShowMessageTips;

    public MessageTipsEvent(boolean z, boolean z2, int i) {
        this.needShowFollowVideoTips = z;
        this.needShowMessageTips = z2;
        this.messageTipsCount = i;
    }
}
