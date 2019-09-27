package com.introvd.template.datacenter;

import java.lang.ref.WeakReference;

public interface CursorDaemon {
    void add(WeakReference<SocialCursor> weakReference);

    void remove(WeakReference<SocialCursor> weakReference);
}
