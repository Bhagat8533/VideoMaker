package com.introvd.template.sdk.editor.p389c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.editor.c.b */
public class C8436b extends Handler {
    private final Handler mHandler;
    private final QStoryboard mStoryBoard;

    public C8436b(QStoryboard qStoryboard, Handler handler) {
        super(handler.getLooper());
        this.mHandler = handler;
        this.mStoryBoard = qStoryboard;
    }

    public void handleMessage(Message message) {
        if (message.what == 268443649) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(268443649, 0, 0, this.mStoryBoard));
            }
        } else if ((message.what == 268443650 || message.what == 268443651 || message.what == 268443652) && this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(message.what, message.arg1, message.arg2, message.obj);
            Bundle data = message.getData();
            if (data != null) {
                obtainMessage.setData(data);
            }
            this.mHandler.sendMessage(obtainMessage);
        }
    }
}
